package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.EmergencyContact;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamFormNumber;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamReschedulingFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTNotificationUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.SAVE_REGISTRATION, }, service = MVCResourceCommand.class)

public class SaveOCTRegistrationDataMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		logger.info(" SaveRegistrationDataMVCResourceCommand serveResource () started::");
		try {
			float examFee = 0;
			boolean eligibilityCheck = false;
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
			long oCExamScheduleId = ParamUtil.getLong(resourceRequest, "oCExamScheduleId");
			String feeType = ParamUtil.getString(resourceRequest, "feeType");

			long id = ParamUtil.getLong(resourceRequest, "id");
			boolean isSuccess = false;
			if (lrUserId <= 0) {
				lrUserId = themeDisplay.getUserId();
			}
			// oCExamScheduleId=61238;
			logger.info("exam schedule id::" + ParamUtil.getLong(resourceRequest, "oCExamScheduleId"));

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

			File internshipFile = uploadPortletRequest.getFile("internshipFileEntry");
			String fileName = uploadPortletRequest.getFileName("internshipFileEntry");

			Map<String, Serializable> registrationMap = new HashMap<>();
			Map<String, Serializable> tempRegistrationMap = new HashMap<>();
			registrationMap.put("lrUserId", lrUserId);

			registrationMap.put("oCExamScheduleId", oCExamScheduleId);
			registrationMap.put("internshipStatus", ParamUtil.getString(resourceRequest, "internshipStatus"));
			String internshipFromDate = ParamUtil.getString(resourceRequest, "internshipFromDate");
			String internshipToDate = ParamUtil.getString(resourceRequest, "internshipToDate");

			// String filename=internshipFile.getName();
			logger.info("IntersihpTo Date" + omsbCommonApi.convertDDMMYYYYDateToObjectDate(internshipToDate));
			registrationMap.put("internshipFromDate",
					omsbCommonApi.convertDDMMYYYYDateToObjectDate(internshipFromDate));
			registrationMap.put("internshipToDate", omsbCommonApi.convertDDMMYYYYDateToObjectDate(internshipToDate));

			if (Validator.isNotNull(fileName)) {
				FileEntry fileEntry = FileUploadUtil.addDocument(fileName, internshipFile,
						FileUtil.getExtension(fileName), themeDisplay.getScopeGroupId(), 0);
				logger.info("fileEntry" + fileEntry);

				if (Validator.isNotNull(fileEntry)) {
					registrationMap.put("internshipFileEntryId", fileEntry.getFileEntryId());
				}

			}

			if (ParamUtil.getString(resourceRequest, "langUsedCollege").equalsIgnoreCase("other")) {
				registrationMap.put("langUsedCollege", ParamUtil.getString(resourceRequest, "langUsedOther"));
				registrationMap.put("langUsedOther", true);

			} else {
				registrationMap.put("langUsedCollege", ParamUtil.getString(resourceRequest, "langUsedCollege"));
				registrationMap.put("langUsedOther", false);
			}

			OCTExamSchedule octExamSchedule = oCTExamUtil.getOCTExamScheduleById(oCExamScheduleId,
					themeDisplay.getPortalURL());
			if (Validator.isNotNull(octExamSchedule)) {
				OCTExamDefinition octExamDefinition = oCTExamUtil.getOCTExamDefinitionByDefinitionId(
						octExamSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL());
				examFee = oCTExamUtil.calculateExamFee(themeDisplay, octExamSchedule);
				if (Validator.isNotNull(octExamDefinition)) {

					registrationMap.put("oCExamTitleId", octExamDefinition.getoCExamTitleId());

					List<OCTExamFormNumber> octExamFormnumbers = oCTExamUtil
							.getOCTExamFormnumberByDefinitionId(themeDisplay, octExamSchedule.getOctExamDefinitionId());
					if (!octExamFormnumbers.isEmpty()) {
						registrationMap.put("oCExamFormNumberId", octExamFormnumbers.get(0).getId());

					}

					if (octExamDefinition.isEligibilityCheck() || octExamDefinition.isApplyEligibility()) {
						eligibilityCheck = true;
						// saveExamRegistrationTempObject
					}
				}

			}

			registrationMap.put("regStatus", OCTExamConstants.PENDING_STATUS_KEY);
			logger.info("internshipStatus" + ParamUtil.getString(resourceRequest, "internshipStatus"));
			logger.info("internshipStatus" + ParamUtil.getString(resourceRequest, "internshipFromDate"));
			logger.info("langUsedCollege" + ParamUtil.getString(resourceRequest, "langUsedCollege"));

			if (id > 0 || OmsbOctExamWebPortletKeys.FEES_TYPE_OCT_EXAM_RESCHEDULE.equalsIgnoreCase(feeType)) {
				OCTRegistration octRestration = oCTExamUtil.getOCTRestrationById(themeDisplay.getPortalURL(), id);
				if ("Rescheduled".equalsIgnoreCase(octExamSchedule.getExamStatusName())) {
					examFee = 0;
				} else {
					OCTExamReschedulingFees octExamREscheduleFee = oCTExamUtil.getOCTExamRescheduleFee(octExamSchedule, themeDisplay);
					double reschedulingFeesPercentage=0;
					float feesPaid=0;
					if(Validator.isNotNull(octExamREscheduleFee) && Validator.isNotNull(octRestration) ) {
						
						reschedulingFeesPercentage=octExamREscheduleFee.getReschedulingFeesPercentage();
						feesPaid = octRestration.getFeesPaid();
					}
					double reschedulingFees = (reschedulingFeesPercentage / 100.0) * feesPaid;
					examFee = (float) reschedulingFees;
				}

				
				isSuccess = true;

			}
			registrationMap.put("feesPaid", examFee);

			ObjectEntry addObjectEntryByERC = omsbCommonApi.addObjectEntryByERC(
					OmsbOctExamWebPortletKeys.OB_OC_EXAM_REGISTRATION_ERC, registrationMap, resourceRequest,
					themeDisplay);

			logger.info("addObjectEntryByERC .... " + addObjectEntryByERC);

			if (eligibilityCheck && Validator.isNotNull(addObjectEntryByERC)) {
				tempRegistrationMap.put("oCExamRegistrationId", addObjectEntryByERC.getPrimaryKey());
				omsbCommonApi.addObjectEntryByERC(OmsbOctExamWebPortletKeys.OB_OC_EXAM_REGISTRATION_TEMP_ERC,
						tempRegistrationMap, resourceRequest, themeDisplay);
				isSuccess = true;
			}
			StringBuilder userRegNumber = new StringBuilder().append("OCT_").append(themeDisplay.getUserId() + "_")
					.append(addObjectEntryByERC.getPrimaryKey());
			registrationMap.put("userRegNumber", userRegNumber);

			boolean isOCTAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
					RoleNameConstants.OCT_ADMIN, Boolean.FALSE);
			if (isOCTAdmin) {
				registrationMap.put("regStatus", OCTExamConstants.REGISTERED_STATUS_KEY);
			}

			updateObjectEntryByERC(OmsbOctExamWebPortletKeys.OB_OC_EXAM_REGISTRATION_ERC, registrationMap,
					resourceRequest, lrUserId, addObjectEntryByERC.getPrimaryKey());

			long ocExamRegistrationId = ((Validator.isNotNull(addObjectEntryByERC.getPrimaryKey()))
					? addObjectEntryByERC.getPrimaryKey()
					: 0);
			logger.info("ocExamRegistrationId" + ocExamRegistrationId);
			saveEmergencyContact(themeDisplay, id, ocExamRegistrationId, resourceRequest, themeDisplay.getUserId());
			isSuccess = true;
					
			if (isSuccess) {
				SessionMessages.add(resourceRequest, OmsbOctExamWebPortletKeys.SET_EXAM_REGISTRATION_SUCCESS);
			}
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			responseJson.put("feeType", feeType);
			responseJson.put("examfees", examFee);
			
			PrintWriter out = resourceResponse.getWriter();
			out.println(responseJson);
			logger.info("doProcessAction () ended::");
		} catch (Exception e) {
			SessionErrors.add(resourceRequest, OmsbOctExamWebPortletKeys.SET_EXAM_REGISTRATION_ERROR);
			logger.info(e.getMessage(), e);
		}
		
		return true;
	}

	public void saveEmergencyContact(ThemeDisplay themeDisplay, long oldOCExamRegistrationId, long ocExamRegistrationId,
			ResourceRequest resourceRequest, long lrUserId) {
		logger.info("saveEmergencyContact () started::");

		Map<String, Serializable> emergancyContanctMap = new HashMap<>();
		emergancyContanctMap.put("name", ParamUtil.getString(resourceRequest, "name"));
		emergancyContanctMap.put("telephone", ParamUtil.getString(resourceRequest, "telephone"));
		emergancyContanctMap.put("consentAuthorize", ParamUtil.getString(resourceRequest, "consentAuthorize"));
		emergancyContanctMap.put("emailAddress", ParamUtil.getString(resourceRequest, "emailAddress"));
		emergancyContanctMap.put("mobileNumber", ParamUtil.getString(resourceRequest, "mobile"));
		emergancyContanctMap.put("relationshipToApplicant",
				ParamUtil.getString(resourceRequest, "relationshipToApplicant"));
		emergancyContanctMap.put("declaration", ParamUtil.getString(resourceRequest, "declaration"));
		emergancyContanctMap.put("oCExamRegistrationId", ocExamRegistrationId);
		emergancyContanctMap.put("lrUserID", lrUserId);
		logger.info("name ::"+ ParamUtil.getString(resourceRequest, "name"));
		EmergencyContact emergancyContact = oCTExamUtil.getEmergancyContactDetailByLrUserId(themeDisplay, lrUserId);
		if (Validator.isNotNull(emergancyContact)) {
			omsbCommonApi.updateObjectEntryByERC(OmsbOctExamWebPortletKeys.OB_EXAM_EMERGENCY_CONTACT_ERC,
					emergancyContanctMap, resourceRequest, themeDisplay,
					emergancyContact.getId());
			logger.info("UpdatedEmergencyContact () ended::");
		} else {

			ObjectEntry addObjectEntryByERC = omsbCommonApi.addObjectEntryByERC(
					OmsbOctExamWebPortletKeys.OB_EXAM_EMERGENCY_CONTACT_ERC, emergancyContanctMap, resourceRequest,
					themeDisplay);
			logger.info("object primarykey" + addObjectEntryByERC.getPrimaryKey());
		}
		
		logger.info("saveEmergencyContact () ended::");
	}

	private ObjectEntry updateObjectEntryByERC(String erc, Map<String, Serializable> values, PortletRequest request,
			long lrUserId, long entryId) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			return ObjectEntryLocalServiceUtil.updateObjectEntry(lrUserId, entryId, values, serviceContext);

		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")

	private OCTExamUtil oCTExamUtil;
	
	@Reference(unbind = "-")
	private OCTNotificationUtil octNotificationUtil;

	private Log logger = LogFactoryUtil.getLog(SaveOCTRegistrationDataMVCResourceCommand.class);
}

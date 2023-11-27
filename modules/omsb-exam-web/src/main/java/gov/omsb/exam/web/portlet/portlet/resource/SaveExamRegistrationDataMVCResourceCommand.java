package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.object.model.ObjectEntry;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
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
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;

import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.SAVE_EXAM_REGISTRATION }, service = MVCResourceCommand.class)

public class SaveExamRegistrationDataMVCResourceCommand  implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
	
	try {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		float examFee = 0;

		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		long examTypeId = ParamUtil.getLong(resourceRequest, "examTypeId");
		long programId = ParamUtil.getLong(resourceRequest, "programId");
		long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
		String role = ParamUtil.getString(resourceRequest, "role");
		String feeType = ParamUtil.getString(resourceRequest, "feeType");
		

		if (logger.isDebugEnabled()) {
			logger.debug("exam schedule id::" + ParamUtil.getLong(resourceRequest, "examScheduleId"));
		}
		
		Map<String, Serializable> registrationMap = new HashMap<>();
		registrationMap.put("lrUserId", lrUserId);
		registrationMap.put("examTypeId", examTypeId);
		registrationMap.put("programId", programId);
		registrationMap.put("examScheduleId", examScheduleId);
		registrationMap.put("registrationStatus", OMSBExamWebPortletKeys.EXAM_REGISTRATION_PENDING);
		registrationMap.put("declaration", ParamUtil.getString(resourceRequest, "declaration"));
		registrationMap.put("consentAuthorize", ParamUtil.getString(resourceRequest, "consentAuthorize"));
		
		if (ParamUtil.getString(resourceRequest, "langUsedCollege").equalsIgnoreCase("other")) {
			registrationMap.put("langUsedCollege", ParamUtil.getString(resourceRequest, "langUsedOther"));
			registrationMap.put("langUsedOther", true);

		} else {
			registrationMap.put("langUsedCollege", ParamUtil.getString(resourceRequest, "langUsedCollege"));
			registrationMap.put("langUsedOther", false);
		}
		ExamSchedule examSchedule = examUtil.getExamScheduleById(examScheduleId, themeDisplay.getPortalURL());
		if(role.equalsIgnoreCase(OMSBExamWebPortletKeys.TRAINEE)) {
			examFee=examUtil.calculateExamFee(themeDisplay,examSchedule);
		}
		
		registrationMap.put("feesPaid", examFee);
		ObjectEntry addObjectEntryByERC = omsbCommonApi.addObjectEntryByERC(
				OMSBExamWebPortletKeys.OB_EXAM_REGISTRATION_ERC, registrationMap, resourceRequest, themeDisplay);
		logger.info("addObjectEntryByERC.getPrimaryKey()::"+addObjectEntryByERC.getPrimaryKey());
		StringBuilder userRegNumber = new StringBuilder().append("EXAM_").append(themeDisplay.getUserId() + "_")
				.append(addObjectEntryByERC.getPrimaryKey());
		registrationMap.put("userRegNumber", userRegNumber);

		omsbCommonApi.updateObjectEntryByERC(OMSBExamWebPortletKeys.OB_EXAM_REGISTRATION_ERC, registrationMap,
				resourceRequest, themeDisplay, addObjectEntryByERC.getPrimaryKey());

		long examRegistrationId = ((Validator.isNotNull(addObjectEntryByERC.getPrimaryKey()))
				? addObjectEntryByERC.getPrimaryKey()
				: 0);
		logger.info("examRegistrationId::?"+examRegistrationId);
		saveEmergencyContact(themeDisplay, examRegistrationId, resourceRequest, themeDisplay.getUserId());
			logger.debug("doProcessAction () ended::");
			
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			responseJson.put("feeType", feeType);
			responseJson.put("examfees", examFee);
			
			PrintWriter out = resourceResponse.getWriter();
			out.println(responseJson);		
	
	}catch(Exception e) {
		
		logger.info(e.getMessage());
	}
	return true;
}

public void saveEmergencyContact(ThemeDisplay themeDisplay, long examRegistrationId, ResourceRequest resourceRequest,
		long lrUserId) {

	if (logger.isDebugEnabled()) {
		logger.debug("saveEmergencyContact () started::");
	}
	Map<String, Serializable> emergancyContanctMap = new HashMap<>();
	emergancyContanctMap.put("name", ParamUtil.getString(resourceRequest, "name"));
	emergancyContanctMap.put("telephone", ParamUtil.getString(resourceRequest, "telephone"));
	emergancyContanctMap.put("consentAuthorize", ParamUtil.getString(resourceRequest, "consentAuthorize"));
	emergancyContanctMap.put("emailAddress", ParamUtil.getString(resourceRequest, "emailAddress"));
	emergancyContanctMap.put("mobileNumber", ParamUtil.getString(resourceRequest, "mobile"));
	emergancyContanctMap.put("relationshipToApplicant",
			ParamUtil.getString(resourceRequest, "relationshipToApplicant"));
	emergancyContanctMap.put("declaration", ParamUtil.getString(resourceRequest, "declaration"));
	emergancyContanctMap.put("examRegistrationId", examRegistrationId);
	emergancyContanctMap.put("lrUserID", lrUserId);

	omsbCommonApi.addObjectEntryByERC(
			OMSBExamWebPortletKeys.OB_EXAM_EMERGENCY_CONTACT_ERC, emergancyContanctMap, resourceRequest,
			themeDisplay);

	if (logger.isDebugEnabled()) {
		logger.debug("saveEmergencyContact () ended::");
	}

}





@Reference(unbind = "-")
private OMSBHttpConnector omsbHttpConnector;

@Reference(unbind = "-")
private OMSBCommonApi omsbCommonApi;

@Reference(unbind = "-")
private ExamUtil examUtil;

private Log logger = LogFactoryUtil.getLog(SaveExamRegistrationDataMVCResourceCommand.class);
}

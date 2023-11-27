package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTNotificationUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.UPDATE_OCT_EXAMS_SCHEDULE_ACTION, }, service = MVCActionCommand.class)
public class UpdateOCTExamScheduleMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		try {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = themeDisplay.getPortalURL();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		Locale locale = themeDisplay.getLocale();
		long companyId = themeDisplay.getCompanyId();
		long octExamScheduleId = ParamUtil.getLong(actionRequest, "siOCTExamScheduleId");
		String registrationStartDate = ParamUtil.getString(actionRequest, "siRegistrationStartDate");
		String registrationEndDate = ParamUtil.getString(actionRequest, "siRegistrationEndDate");
		String examDate = ParamUtil.getString(actionRequest, "siExamDate");
		String examStartTime = ParamUtil.getString(actionRequest, "siExamStartTime");
		String examEndTime = ParamUtil.getString(actionRequest, "siExamEndTime");
		int noOfSeats = ParamUtil.getInteger(actionRequest, "siNoOfSeats");
		String examStatus = ParamUtil.getString(actionRequest, "siCMD");
		String locateOnGoogleMap = ParamUtil.getString(actionRequest, "siLocationOnGoogleMap");
		String venue = ParamUtil.getString(actionRequest, "siVenue");
		String octExamDepartmentId = ParamUtil.getString(actionRequest, "siDepartmentId");
		String octExamSectionId = ParamUtil.getString(actionRequest, "siSectionId");
		long examDefinitionId = ParamUtil.getLong(actionRequest, "siOCTExamDefinitionId");
		boolean isSuccess=false;
		
		ListTypeEntry listEntry = omsbCommonApi
				.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DEPARTMENT, octExamDepartmentId, companyId);

		ListTypeEntry listTypeEntry = omsbCommonApi
				.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SECTION, octExamSectionId, companyId);
		
		long departmentListTypeEntryId = 0;
		long sectionListTypeEntryId = 0;
		if (Validator.isNotNull(listEntry)) {
			departmentListTypeEntryId = listEntry.getListTypeEntryId();
		}
		if (Validator.isNotNull(listTypeEntry)) {
			sectionListTypeEntryId = listTypeEntry.getListTypeEntryId();
		}

		OCTExamSchedule octExamSchedule = octExamUtil.getOCTExamScheduleById(octExamScheduleId, portalURL);
		String response = StringPool.BLANK;
		if (Validator.isNotNull(octExamSchedule)) {
			octExamSchedule = prepareOCTExamSchedule(octExamSchedule, registrationStartDate, registrationEndDate,
					examDate, examStartTime, examEndTime, noOfSeats, examStatus, examDefinitionId, locateOnGoogleMap,
					venue, departmentListTypeEntryId, sectionListTypeEntryId, locale);
			response = octExamUtil.updateOCTExamSchedule(octExamSchedule, portalURL, scopeGroupId);
			isSuccess=true;
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
			logger.info(response);
		}
		
		if (examStatus.equalsIgnoreCase("Announced")) {

			logger.info("SEND NOTIFICATION ....");
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, RoleNameConstants.EXAM_APPLICANT);
				if (Validator.isNotNull(role)) {
					octNotificationUtil.sendNotificationToUsers(portalURL, examStatus, scopeGroupId, companyId, locale,
							role.getRoleId(), octExamSchedule);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
					octScheduleUtil.addCalenderEvent(serviceContext, octExamSchedule);
				}
			} catch (PortalException e) {
				logger.error(e.getMessage(), e);
			}
		}
		if(isSuccess) 
			SessionMessages.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_SCHEDULE_SUCCESS);
		return true;
	}catch (Exception e) {
		SessionErrors.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_SCHEDULE_ERROR);
		logger.error(e.getMessage(), e);
	}
		return false;
	}

	private OCTExamSchedule prepareOCTExamSchedule(OCTExamSchedule octExamSchedule, String registrationStartDate,
			String registrationEndDate, String examDate, String examStartTime, String examEndTime, int noOfSeats,
			String examStatus, long examDefinitionId, String locateOnGoogleMap, String venue, long octExamDepartmentId,
			long octExamSectionId, Locale locale) {
		if (Validator.isNotNull(registrationStartDate)) {
			octExamSchedule
					.setRegistrationStartDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(registrationStartDate));
		}

		if (Validator.isNotNull(registrationEndDate)) {
			octExamSchedule.setRegistrationEndDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(registrationEndDate));
		}

		if (Validator.isNotNull(examDate)) {
			octExamSchedule.setExamDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(examDate));
		}

//		if (Validator.isNotNull(examStartTime)) {
//			octExamSchedule.setExamTime(examStartTime);
//		}
//
//		if (Validator.isNotNull(examEndTime)) {
//			octExamSchedule.setExamEndTime(examEndTime);
//		}

		if (Validator.isNotNull(noOfSeats)) {
			octExamSchedule.setNoOfSeats(noOfSeats);
		}

		if (Validator.isNotNull(locateOnGoogleMap)) {
			octExamSchedule.setLocationOnGoogleMap(locateOnGoogleMap);
		}

		if (Validator.isNotNull(venue)) {
			octExamSchedule.setVenue(venue);
		}

		if (Validator.isNotNull(octExamDepartmentId)) {
			octExamSchedule.setDepartmentId(octExamDepartmentId);
		}

		if (Validator.isNotNull(octExamSectionId)) {
			octExamSchedule.setSectionId(octExamSectionId);
		}

		if (Validator.isNotNull(examStatus)) {
			List<ListTypeEntry> listTypeEntry = omsbCommonApi
					.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_STATUS, PortalUtil.getDefaultCompanyId());
			if (Validator.isNotNull(listTypeEntry)) {
				for (ListTypeEntry entry : listTypeEntry) {
					if (entry.getName(locale).equalsIgnoreCase(examStatus)) {
						octExamSchedule.setExamStatusId(entry.getListTypeEntryId());
					}

				}
			}
		}
		if (Validator.isNotNull(examDefinitionId)) {
			octExamSchedule.setOctExamDefinitionId(examDefinitionId);
		}

		return octExamSchedule;
	}

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;
	
	@Reference(unbind = "-")
	private OCTScheduleUtil octScheduleUtil;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private OCTNotificationUtil octNotificationUtil;

	private Log logger = LogFactoryUtil.getLog(UpdateOCTExamScheduleMVCActionCommand.class);
}

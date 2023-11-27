package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="+MVCCommandNames.ADD_OCT_EXAM_SCHEDULE_ACTION, }, service = MVCActionCommand.class)
public class SaveOCTExamScheduleMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("doProcessAction() started ");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long octExamId = ParamUtil.getLong(actionRequest, "octExamId");
			boolean isSuccess = false;
			
			String riExamStartDate = ParamUtil.getString(actionRequest, "riExamStartDate");
			String riExamEndDate = ParamUtil.getString(actionRequest, "riExamEndDate");
			String riDepartmentId = ParamUtil.getString(actionRequest, "riDepartmentId");
			String riSectionId = ParamUtil.getString(actionRequest, "riSectionId");
			String riLocationOnGoogleMap = ParamUtil.getString(actionRequest, "riLocationOnGoogleMap1");
			String riVenue = ParamUtil.getString(actionRequest, "riVenue");
			
			long riDaysOfWeek1 = ParamUtil.getLong(actionRequest, "riDaysOfWeek");
			long examCenter = ParamUtil.getLong(actionRequest, "riTrainingSite");
			long riNoOfSeats = ParamUtil.getLong(actionRequest, "riNoOfSeats");
			long riExamSlotsId = ParamUtil.getLong(actionRequest, "riExamSlotList");
			String riRegistrationStartDate = ParamUtil.getString(actionRequest, "riRegistrationStartDate");
			String riRegistrationEndDate = ParamUtil.getString(actionRequest, "riRegistrationEndDate");
			
			long octExamScheduleAdminId=  ParamUtil.getLong(actionRequest, "riExamScheduleAdmnId");
			long ocScheduleId=ParamUtil.getLong(actionRequest, "ocScheduleId"); 
			String status=ParamUtil.getString(actionRequest, "riCMD");
			
			
			String repeatedInstanceDuplicateRowValues = ParamUtil.getString(actionRequest,"repeatedValuesArray");
			LOGGER.info("repeatedInstanceDuplicateRowValues:"+repeatedInstanceDuplicateRowValues);
			Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.EXAM_APPLICANT);
			long roleId = 0;
			if (Validator.isNotNull(role)) {

				roleId = role.getRoleId();
			}

			long examDefinitionId = octScheduleUtil.createOCTExamDefinition(octExamId, themeDisplay);
			if (examDefinitionId <= 0) {
				OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefintionByOCTExamId(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(), octExamId);
				if (Validator.isNotNull(octExamDefinition)) {
					examDefinitionId = octExamDefinition.getId();
				}
			}

			if (!repeatedInstanceDuplicateRowValues.isEmpty()) {
				
				
				octScheduleUtil.saveOCTExamScheduleRepeatedInstance(examDefinitionId, octExamId, octExamScheduleAdminId, 
						themeDisplay, roleId, repeatedInstanceDuplicateRowValues, riDepartmentId, riSectionId, riLocationOnGoogleMap,
						riExamStartDate, riExamEndDate, riVenue, 
						riDaysOfWeek1, examCenter, riNoOfSeats, riExamSlotsId, status,riRegistrationStartDate,riRegistrationEndDate);

				isSuccess = true;
				actionResponse.setRenderParameter("mvcRenderCommandName",MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
			} else {
				octExamScheduleAdminId=  ParamUtil.getLong(actionRequest, "octScheduleAdminId");
				ocScheduleId= ParamUtil.getLong(actionRequest, "octScheduleId");
				octScheduleUtil.saveOCTExamScheduleSingleInstance(examDefinitionId, octExamId, actionRequest, actionResponse,
						themeDisplay, repeatedInstanceDuplicateRowValues, roleId,octExamScheduleAdminId,ocScheduleId);
				isSuccess = true;
			}
			if (isSuccess)
				SessionMessages.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_SCHEDULE_SUCCESS);

		
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
	}
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTScheduleUtil octScheduleUtil;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference
	private CalendarBookingLocalService _calendarBookingLocalService;

	private Log LOGGER = LogFactoryUtil.getLog(SaveOCTExamScheduleMVCActionCommand.class);

}

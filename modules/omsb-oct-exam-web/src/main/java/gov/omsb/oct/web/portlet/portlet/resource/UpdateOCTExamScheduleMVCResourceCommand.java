package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTMultiDateItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.SAVE_UPDATE_OCT_REPEATED_INSTANCE }, service = MVCResourceCommand.class)
public class UpdateOCTExamScheduleMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String command = ParamUtil.getString(resourceRequest, "command");
			
			long octExamId = ParamUtil.getLong(resourceRequest, "octExamId");
			String riExamStartDate = ParamUtil.getString(resourceRequest, "riExamStartDate");
			String riExamEndDate = ParamUtil.getString(resourceRequest, "riExamEndDate");
			String riDepartmentId = ParamUtil.getString(resourceRequest, "riDepartmentId");
			String riSectionId = ParamUtil.getString(resourceRequest, "riSectionId");
			String riLocationOnGoogleMap = ParamUtil.getString(resourceRequest, "riLocationOnGoogleMap1");
			String riVenue = ParamUtil.getString(resourceRequest, "riVenue");
			
			long riDaysOfWeek1 = ParamUtil.getLong(resourceRequest, "riDaysOfWeek1");
			long examCenter = ParamUtil.getLong(resourceRequest, "riTrainingSiteId");
			long riNoOfSeats = ParamUtil.getLong(resourceRequest, "riNoOfSeats");
			long riExamSlotsId = ParamUtil.getLong(resourceRequest, "riExamSlotsId");
			String riRegistrationStartDate = ParamUtil.getString(resourceRequest, "riRegistrationStartDate");
			String riRegistrationEndDate = ParamUtil.getString(resourceRequest, "riRegistrationEndDate");
			
			long octExamScheduleAdminId=  ParamUtil.getLong(resourceRequest, "riExamScheduleAdmnId");
			long examMultiDateId=  ParamUtil.getLong(resourceRequest, "examMultiDateId");
			Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.EXAM_APPLICANT);
			
			long roleId = 0;
			if (Validator.isNotNull(role)) {
				

				roleId = role.getRoleId();
			}
			OCTMultiDateItems oCTMultiDateItems= new OCTMultiDateItems();
			logger.info("octexam id:" + octExamId);
			String repeatedInstanceArrayString = ParamUtil.getString(resourceRequest,
					"repeatedInstanceDuplicateRowValues");
			logger.info("repeatedInstanceArrayString:"+repeatedInstanceArrayString);
			String jsp="/jsps/schedule/oct-repeated-instance-schedule-list.jsp";
			
			long examDefinitionId = octScheduleUtil.createOCTExamDefinition(octExamId, themeDisplay);

			if (examDefinitionId <= 0) {
				OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefintionByOCTExamId(
						themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), octExamId);
				if (Validator.isNotNull(octExamDefinition)) {
					examDefinitionId = octExamDefinition.getId();
				}
			}
			
			if (command.equalsIgnoreCase("saveDetails")) {
				OCTExamSchedule oCTExamSchedule=octScheduleUtil.saveOCTExamScheduleRepeatedInstance(examDefinitionId, octExamId,
						octExamScheduleAdminId, themeDisplay, roleId, repeatedInstanceArrayString, riDepartmentId,
						riSectionId, riLocationOnGoogleMap, riExamStartDate, riExamEndDate, riVenue, riDaysOfWeek1,
						examCenter, riNoOfSeats, riExamSlotsId, OCTExamConstants.PENDING_STATUS_KEY, riRegistrationStartDate, riRegistrationEndDate);
				if(Validator.isNotNull(oCTExamSchedule)) {
					 oCTMultiDateItems =  octScheduleUtil.getOCExamMultiDatesItemBasedOnScheduleAdminId
							(themeDisplay, oCTExamSchedule.getoCExamScheduleAdminId());
					resourceRequest.setAttribute("ocExamMultiDates", oCTMultiDateItems.getItems());
				}

				octScheduleUtil.loadScheduleExmListJSP(resourceRequest, resourceResponse, jsp);
				
			} else if (command.equalsIgnoreCase("deleteDetails")) {
				
				Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
				omsbHttpConnector.executeDelete(
						themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_MULTI_DATES + examMultiDateId, headers);
				oCTMultiDateItems = octScheduleUtil.getOCExamMultiDatesItemBasedOnScheduleAdminId(themeDisplay,
						octExamScheduleAdminId);
				resourceRequest.setAttribute("ocExamMultiDates", oCTMultiDateItems.getItems());
				octScheduleUtil.loadScheduleExmListJSP(resourceRequest, resourceResponse, jsp);
				
			} else if (command.equalsIgnoreCase("editDetails")) {
				logger.info("examMultiDateId::"+examMultiDateId);
				JSONObject responseObj = octScheduleUtil.getEditedMultObjDetails(themeDisplay, examMultiDateId);
				resourceResponse.getWriter().write(responseObj.toString());
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	private Log logger = LogFactoryUtil.getLog(UploadOCTExamResultMVCResourceCommand.class);

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OCTScheduleUtil octScheduleUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
}

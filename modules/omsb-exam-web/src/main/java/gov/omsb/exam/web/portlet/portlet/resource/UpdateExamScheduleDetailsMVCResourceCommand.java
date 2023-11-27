package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamMultiDatesItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.SAVE_EXAM_MD_SCHEDULE }, service = MVCResourceCommand.class)
public class UpdateExamScheduleDetailsMVCResourceCommand implements MVCResourceCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(UpdateExamScheduleDetailsMVCResourceCommand.class);

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ScheduleUtil scheduleUtil;

	@Reference(unbind = "-")
	private ExamUtil examUtil;

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String command = ParamUtil.getString(resourceRequest, "command");
			long examId = ParamUtil.getLong(resourceRequest, "examId");
			long examTypeId = ParamUtil.getLong(resourceRequest, "examTypeId");
			String mdApplicationStartDate = ParamUtil.getString(resourceRequest, "mdApplicationStartDate");
			String mdApplicationEndDate = ParamUtil.getString(resourceRequest, "mdApplicationEndDate");
			int mdNoOfSeats = ParamUtil.getInteger(resourceRequest, "mdNoOfSeats");
			long examScheduleAdminId = ParamUtil.getLong(resourceRequest, "examScheduleAdminId");
			String valuesArray = ParamUtil.getString(resourceRequest, "values");
			String status = ParamUtil.getString(resourceRequest, "status");
			long examMultiDateId = ParamUtil.getLong(resourceRequest, "examMultiDateId");
			String flowType = ParamUtil.getString(resourceRequest, "flowType");

			String selectedValues = ParamUtil.getString(resourceRequest, "selectedValues");

			long riApplicationStartDaysBefore = ParamUtil.getLong(resourceRequest, "riApplicationStartDaysBefore");
			long riApplicationEndsDaysBefore = ParamUtil.getLong(resourceRequest, "riApplicationEndsDaysBefore");
			String riExamStartsFrom = ParamUtil.getString(resourceRequest, "riExamStartsFrom");
			String riExamEndsOn = ParamUtil.getString(resourceRequest, "riExamEndsOn");
			long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
			
			ExamMultiDatesItem multiDatesItem = new ExamMultiDatesItem();

			String jsp = StringPool.BLANK;
			if (flowType.equalsIgnoreCase("multipleInstance")) {
				jsp = "/jsps/schedule/multiple-date-exam-list.jsp";
				if (command.equalsIgnoreCase("saveDetails")) {
					ExamSchedule schedule = scheduleUtil.updateExamScheduleAndExamMultiDatesObject(
							 examId, examScheduleId,
							valuesArray, mdApplicationStartDate, mdApplicationEndDate, mdNoOfSeats, status,
							themeDisplay, selectedValues, examScheduleAdminId);

					if (Validator.isNotNull(schedule)) {
						multiDatesItem = scheduleUtil.getExamMultiDatesItemBasedOnScheduleAdminId(themeDisplay,
								schedule.getExamScheduleAdminId());
						resourceRequest.setAttribute("examMultiDates", multiDatesItem.getItems());
					}
					scheduleUtil.loadScheduleExmListJSP(resourceRequest, resourceResponse, jsp);

				} else if (command.equalsIgnoreCase("deleteDetails")) {
					Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
					omsbHttpConnector.executeDelete(
							themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL + examMultiDateId, headers);
					multiDatesItem = scheduleUtil.getExamMultiDatesItemBasedOnScheduleAdminId(themeDisplay,
							examScheduleAdminId);
					resourceRequest.setAttribute("examMultiDates", multiDatesItem.getItems());
					scheduleUtil.loadScheduleExmListJSP(resourceRequest, resourceResponse, jsp);

				} else if (command.equalsIgnoreCase("editDetails")) {

					JSONObject responseObj = scheduleUtil.getEditedMultObjDetails(themeDisplay, examMultiDateId);
					resourceRequest.setAttribute("examMultiDates", multiDatesItem.getItems());
					resourceResponse.getWriter().write(responseObj.toString());

				}

			} else {
				// Repeated Instance
				jsp = "/jsps/schedule/repeated-instance-exam-list.jsp";
				
				if (command.equalsIgnoreCase("saveDetails")) {
					ExamSchedule examSchedule = scheduleUtil.saveAndUpdateRepeatedInstanceObject(status,
							riExamStartsFrom, riExamEndsOn, riApplicationStartDaysBefore, riApplicationEndsDaysBefore,
							examTypeId, examId, valuesArray, themeDisplay, examScheduleAdminId, selectedValues,
							mdNoOfSeats);

					if (Validator.isNotNull(examSchedule) && examSchedule.getExamScheduleAdminId() !=0) {
						multiDatesItem = scheduleUtil.getExamMultiDatesItemBasedOnScheduleAdminId(themeDisplay,
								examSchedule.getExamScheduleAdminId());
						resourceRequest.setAttribute("examMultiDates", multiDatesItem.getItems());
					}
					

					scheduleUtil.loadScheduleExmListJSP(resourceRequest, resourceResponse, jsp);

					
				} else if (command.equalsIgnoreCase("deleteDetails")) {

					Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
					omsbHttpConnector.executeDelete(
							themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL + examMultiDateId, headers);
					multiDatesItem = scheduleUtil.getExamMultiDatesItemBasedOnScheduleAdminId(themeDisplay,
							examScheduleAdminId);
					resourceRequest.setAttribute("examMultiDates", multiDatesItem.getItems());
					scheduleUtil.loadScheduleExmListJSP(resourceRequest, resourceResponse, jsp);

				} else if (command.equalsIgnoreCase("editDetails")) {
					JSONObject responseObj = scheduleUtil.getEditedMultObjDetails(themeDisplay, examMultiDateId);
					resourceRequest.setAttribute("examMultiDates", multiDatesItem.getItems());
					resourceResponse.getWriter().write(responseObj.toString());

				}
					 
				}
			

			return Boolean.FALSE;
		} catch (Exception e) {
			LOGGER.error("Error, " + e.getMessage());
			return Boolean.TRUE;
		}
	}

}

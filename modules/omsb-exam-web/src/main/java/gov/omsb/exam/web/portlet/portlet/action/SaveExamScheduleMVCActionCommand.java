package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.util.ExamNotificationUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.SAVE_EXAM_SCHEDULE, }, service = MVCActionCommand.class)

public class SaveExamScheduleMVCActionCommand extends BaseMVCActionCommand {


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		logger.debug("process action method started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long examTypeId = ParamUtil.getLong(actionRequest, "examTypeId");
		long examId = ParamUtil.getLong(actionRequest, "examId");

		//Multiple Instance Data
		
		String mdApplicationStartDate = ParamUtil.getString(actionRequest, "mdApplicationStartDate");
		String mdApplicationEndDate = ParamUtil.getString(actionRequest, "mdApplicationEndDate");
		int mdNoOfSeats = ParamUtil.getInteger(actionRequest, "mdNoOfSeats");
		long mdExamScheduleAdmnId = ParamUtil.getLong(actionRequest, "examScheduleAdmnId");
		String mdSelectedValues = ParamUtil.getString(actionRequest, "selectedValues");
		String multiDatesDuplicateRowValues = ParamUtil.getString(actionRequest, "multiDatesValuesArray");
		
		//Repeated Instance Data
		
		long riExamScheduleAdminId=ParamUtil.getLong(actionRequest, "riExamScheduleAdmnId");
		String riSelectedValues = ParamUtil.getString(actionRequest, "riSelectedValues");
		long riApplicationStartDaysBefore = ParamUtil.getLong(actionRequest, "riApplicationStartDaysBefore");
		long riApplicationEndsDaysBefore = ParamUtil.getLong(actionRequest, "riApplicationEndsDaysBefore");
		String riExamStartsFrom = ParamUtil.getString(actionRequest, "riExamStartFrom");
		String riExamEndsOn = ParamUtil.getString(actionRequest, "riExamEndOn");
		String repeatedInstanceDuplicateRowValues = ParamUtil.getString(actionRequest,
				"riMultiDatesValuesArray");
		String status=StringPool.BLANK;
		 status = ParamUtil.getString(actionRequest, "mdCMDValue");
		logger.debug("mdSelectedValues values---"+mdSelectedValues);
		if (!multiDatesDuplicateRowValues.isEmpty()) {
			
			scheduleUtil.updateExamScheduleAndExamMultiDatesObject(examId, mdExamScheduleAdmnId, multiDatesDuplicateRowValues,
					mdApplicationStartDate,mdApplicationEndDate,mdNoOfSeats,status,themeDisplay, mdSelectedValues,mdExamScheduleAdmnId);
			
		} else if (!repeatedInstanceDuplicateRowValues.isEmpty()) {
			 status = ParamUtil.getString(actionRequest, "riCMDStatus");
			scheduleUtil.saveAndUpdateRepeatedInstanceObject(status, riExamStartsFrom, riExamEndsOn, riApplicationStartDaysBefore,
					riApplicationEndsDaysBefore, examTypeId, examId, repeatedInstanceDuplicateRowValues, themeDisplay, riExamScheduleAdminId, riSelectedValues, mdNoOfSeats);
			
		} else {
			 status =  ParamUtil.getString(actionRequest, "siCMD");
			 scheduleUtil.saveSingleInstanceObj(actionRequest, themeDisplay, examTypeId, examId,status);
		}
		actionResponse.setRenderParameter("mvcRenderCommandName",MVCCommands.EXAMS_SCHEDULE_LIST);
	}
	
	
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ScheduleUtil scheduleUtil;

	@Reference(unbind = "-")
	private ExamUtil examUtil;

	@Reference(unbind = "-")
	private ExamNotificationUtil examNotificationUtil;

	private Log logger = LogFactoryUtil.getLog(SaveExamScheduleMVCActionCommand.class);

}
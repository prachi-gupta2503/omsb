package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamMultiDates;
import gov.omsb.exam.web.portlet.dto.ExamMultiDatesItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.EXAM_SCHEDULE_ACTIONS, }, service = MVCRenderCommand.class)

public class ExamScheduleActionsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(renderRequest, "cmd");
		String result = ParamUtil.getString(renderRequest, "result");
		String programName = ParamUtil.getString(renderRequest, "programName");
		String examType = ParamUtil.getString(renderRequest, "examType");
		long programId = ParamUtil.getLong(renderRequest, "programId");
		long examTypeId = ParamUtil.getLong(renderRequest, "examTypeId");
		long examScheduleId = ParamUtil.getLong(renderRequest, "examScheduleId");
		long examId = ParamUtil.getLong(renderRequest, "examId");
		String editExamSchedule = ParamUtil.getString(renderRequest, "editExamSchedule");
		long examScheduleAdminId = ParamUtil.getLong(renderRequest, "examScheduleAdminId");
		
		String actionJSP = null;
		List<ExamMultiDates> multiDates = new ArrayList<>();
		if (cmd.equalsIgnoreCase(DataflowConstants.ACTION_EDIT)
				|| cmd.equalsIgnoreCase(DataflowConstants.ACTION_VIEW)) {

			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + examScheduleId;
			String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			if (Validator.isNotNull(response)) {
				ExamSchedule examSchedule = CustomObjectMapperUtil.readValue(response, ExamSchedule.class);
				if (Validator.isNotNull(examSchedule)) {
					examSchedule.setApplicationStartDate(
							commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getApplicationStartDate()));
					examSchedule.setApplicationEndDate(
							commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getApplicationEndDate()));

					if (!examSchedule.isMultiDates()) {
						examSchedule.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getExamDate()));
					}
						try {
							scheduleUtil.setExamStartAndEndTime(examSchedule);
						}catch (Exception e) {
							logger.error("Exception in setting value of start and end time"+e);
						}
					
					
					if (examSchedule.isMultiDates()) {
						try {
							String multiDatesUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL
									+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
									+ StringPool.QUESTION + "filter=examScheduleAdminId"
									+ URLEncoder.encode(" eq " + examSchedule.getExamScheduleAdminId(), DataflowConstants.UTF_8);

							String multiDatesResponse = commonApi.getData(multiDatesUrl);
							if (Validator.isNotNull(multiDatesResponse)) {
								ExamMultiDatesItem examMultiDatesItem = CustomObjectMapperUtil
										.readValue(multiDatesResponse, ExamMultiDatesItem.class);

								for (int i = 0; i < examMultiDatesItem.getItems().size(); i++) {
									ExamMultiDates dates = new ExamMultiDates();
									dates.setId(examMultiDatesItem.getItems().get(i).getId());
									dates.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(
											examMultiDatesItem.getItems().get(i).getExamDate()));
									dates.setStartTime(examMultiDatesItem.getItems().get(i).getStartTime());
									dates.setEndTime(examMultiDatesItem.getItems().get(i).getEndTime());
									dates.setVenue(examMultiDatesItem.getItems().get(i).getVenue());
									dates.setLocationOnGoogleMap(
											examMultiDatesItem.getItems().get(i).getLocationOnGoogleMap());
									dates.setExamScheduleId(examMultiDatesItem.getItems().get(i).getExamScheduleId());

									multiDates.add(dates);
									
								}

								renderRequest.setAttribute("examMultiDates", multiDates);
							}
						} catch (UnsupportedEncodingException e) {
							logger.error(e.getMessage());
						}
					}
					examScheduleAdminId=examSchedule.getExamScheduleAdminId();
					if (cmd.equalsIgnoreCase(DataflowConstants.ACTION_VIEW)) {

						actionJSP = OMSBExamWebPortletKeys.VIEW_EXAM_SCHEDULE_JSP;
					} else if (cmd.equalsIgnoreCase(DataflowConstants.ACTION_EDIT)) {
						actionJSP = OMSBExamWebPortletKeys.EXAM_SCHEDULE_JSP;
					}
					programId=examSchedule.getProgramId();
					logger.info("program id::"+programId);
					renderRequest.setAttribute("editExamSchedule", editExamSchedule);
					renderRequest.setAttribute("programName", programName);
					renderRequest.setAttribute("examType", examType);
					renderRequest.setAttribute("examSchedule", examSchedule);
					renderRequest.setAttribute("examTypeId", examTypeId);
					renderRequest.setAttribute("examId", examId);
					renderRequest.setAttribute("examScheduleAdminId", examScheduleAdminId);
					
					Exam exam = examUtil.getExamById(examId, themeDisplay.getPortalURL());

					if (Validator.isNotNull(exam)) {

						String examJson = exam.getExamJson();

						exam = CustomObjectMapperUtil.readValue(examJson, Exam.class);
						logger.info("program from exam: "+exam.getProgram().get(0).getProgramId());
						renderRequest.setAttribute("exam", exam);

					}
				}
			}
		} else if (cmd.equalsIgnoreCase(DataflowConstants.ACTION_ADD)) {
			
			Exam exam = examUtil.getExamById(examId, themeDisplay.getPortalURL());

			if (Validator.isNotNull(exam)) {

				String examJson = exam.getExamJson();

				exam = CustomObjectMapperUtil.readValue(examJson, Exam.class);
				
				renderRequest.setAttribute("exam", exam);

			}
			
			
			actionJSP = OMSBExamWebPortletKeys.EXAM_SCHEDULE_JSP;
		}
		renderRequest.setAttribute("result", result);
		renderRequest.setAttribute("action", cmd);
		renderRequest.setAttribute("programName", programName);
		renderRequest.setAttribute("examType", examType);
		renderRequest.setAttribute("programId", programId);
		renderRequest.setAttribute("examTypeId", examTypeId);
		renderRequest.setAttribute("examId", examId);
		ExamMultiDatesItem multiDatesItem	=scheduleUtil.getExamMultiDatesItemBasedOnScheduleAdminId(themeDisplay, examScheduleAdminId);
		if(examScheduleAdminId>0) {
			renderRequest.setAttribute("examMultiDates", multiDatesItem.getItems());
		}
		return actionJSP;
	}

	@Reference(unbind = "_")
	private ScheduleUtil scheduleUtil;

	@Reference
	private OMSBCommonApi commonApi;
	
	@Reference
	private ExamUtil examUtil;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(ExamScheduleActionsMVCRenderCommand.class);
}
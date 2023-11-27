package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamAppeal;
import gov.omsb.exam.web.portlet.dto.ExamAppealItem;
import gov.omsb.exam.web.portlet.dto.ExamAppealStatus;
import gov.omsb.exam.web.portlet.dto.ExamDefinition;
import gov.omsb.exam.web.portlet.dto.ExamDocuments;
import gov.omsb.exam.web.portlet.dto.ExamResult;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_RESULTS_LIST, }, service = MVCRenderCommand.class)

public class ViewResultsListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int apealWindow = 0;
		String examAnnouncedDate;
		int noOfDaysInExamAnnouncedDate = 0;
		List<ExamAppealStatus> appealStatusList = new ArrayList<>();

		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		List<ExamResultItem> examResults = new ArrayList<>();
		String examResultsUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + themeDisplay.getUserId(), StandardCharsets.UTF_8);
		String examResultsResponse = commonApi.getData(examResultsUrl);
		if (Validator.isNotNull(examResultsResponse)) {
			ExamResult examResultItem = CustomObjectMapperUtil.readValue(examResultsResponse, ExamResult.class);
			if (Validator.isNotNull(examResultItem)) {

				for (int i = 0; i < examResultItem.getItems().size(); i++) {

					ExamResultItem examResult = new ExamResultItem();

					String examDefinitionURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_DEFINITION_URL
							+ examResultItem.getItems().get(i).getExamDefinitionId();
					String examDefinitionResponse = omsbHttpConnector.executeGet(examDefinitionURL, "", headers);
					if (Validator.isNotNull(examDefinitionResponse)) {
						ExamDefinition examDefinitionItem = CustomObjectMapperUtil.readValue(examDefinitionResponse,
								ExamDefinition.class);
						Exam exam = examUtil.getExamById(examDefinitionItem.getExamId(), themeDisplay.getPortalURL());
						ExamAppeal appeal = examUtil.getExamAppealByExamResultId(themeDisplay,
								examResultItem.getItems().get(i).getId());
						apealWindow = examDefinitionItem.getAppealWindow();
						examAnnouncedDate = examResultItem.getItems().get(i).getExamAnnouncedDate();

						noOfDaysInExamAnnouncedDate = examUtil.getDateDifferenceWithCurrentDate(examAnnouncedDate);

						if (Validator.isNotNull(appeal)) {
							examResult.setAppealCount(appeal.getAppealCount());
							examResult.setAppealStatus(examAppealUtil.getStatusKey(appeal.getAppealStatus()));
						} else if (noOfDaysInExamAnnouncedDate < apealWindow) {
							examResult.setAppealCount(0);
							examResult.setAppealStatus(StringPool.BLANK);
						}
						if (Validator.isNotNull(exam)) {

							examResult.setId(examResultItem.getItems().get(i).getId());
							examResult.setExamScheduleId(examResultItem.getItems().get(i).getExamScheduleId());
							examResult.setLrUserId(examResultItem.getItems().get(i).getLrUserId());
							examResult.setPercentage(examResultItem.getItems().get(i).getPercentage());
							examResult.setResult(examResultItem.getItems().get(i).getResult());
							examResult.setAppealFees(examDefinitionItem.getAppealFees());
							examResult.setReAppealFees(examDefinitionItem.getReappealFees());
							try {
								if (Validator.isNotNull(examResultItem)
										&& Validator.isNotNull(examResultItem.getItems())
										&& examResultItem.getItems().size() > 0) {
									ExamAppealItem appealItem = examAppealUtil.getAppealByResultlId(themeDisplay,
											examResultItem.getItems().get(i).getId());
									if (appealItem.getItems().get(0).getAppealCount() > 0) {
										List<ExamAppealStatus> appealStatus = examAppealUtil
												.getExamAppealStatusByAppealId(themeDisplay,
														appealItem.getItems().get(0).getId());
										logger.info("appeal id: "+appealItem.getItems().get(0).getId());
										logger.info("size :" + appealStatus.size());
										logger.info("reason :" + appealStatus.get(1).getReason());
										
										if (Validator.isNotNull(appealStatus) && !appealStatus.isEmpty()) {
											for (ExamAppealStatus examAppealStatus : appealStatus) {
												logger.info("isAdmin :" + examAppealStatus.isAdmin());
												if (examAppealStatus.isAdmin()) {
													logger.info("reason :" + examAppealStatus.getReason());
													examResult.setAdminComments(examAppealStatus.getReason());
													String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_DOCUMENTS_URL +
															  CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() +
															  StringPool.QUESTION + "filter=examAppealStatusId" + URLEncoder.encode(" eq "
															  + examAppealStatus.getId(), StandardCharsets.UTF_8);
													List<ExamDocuments> documentList = examAppealUtil.getExamDocsByStatusId(url);
													examAppealStatus.setExamDocuments(documentList);
													examAppealStatus.setName(examAppealUtil.getName(examAppealStatus.getLrUserId()));
													appealStatusList.add(examAppealStatus);
													
												}
											}
											
											renderRequest.setAttribute("documentList", appealStatusList);
										}
									}
									
									/*
									 * ExamAppealItem appealItem = examAppealUtil.getAppealByResultlId(themeDisplay,
									 * examResultItem.getItems().get(i).getId());
									 * if(Validator.isNotNull(appealItem)) {
									 * if(appealItem.getItems().get(0).getAppealCount()>0) { List<ExamAppealStatus>
									 * appealsStatus =
									 * examAppealUtil.getExamAppealStatusByAppealId(themeDisplay,appealItem.getItems
									 * ().get(0).getId());
									 * appealsStatus=appealsStatus.stream().filter(n->n.isAdmin()).collect(
									 * Collectors.toList()); if(Validator.isNotNull(appealsStatus)) { String
									 * url=appealsStatus.get(0).getExamDocuments().get(0).getFileURL();
									 * System.out.println(url); } } }
									 * 
									 * 
									 * 
									 * 
									 * List<ExamAppeal> exmApl =appealItem.getItems().stream().filter(n ->
									 * n.getAppealCount()>0).collect(Collectors.toList());
									 * 
									 * List<ExamAppealStatus> appealsStatus =
									 * examAppealUtil.getExamAppealStatusByAppealId(themeDisplay,exmApl.get(0).getId
									 * ()); examResult.setAdminComments(Validator.isNotNull(appealsStatus) &&
									 * appealsStatus.size()>0 ? appealsStatus.get(0).getReason() :
									 * StringPool.BLANK); for (ExamAppealStatus status: appealsStatus) 
									 * { 
									  String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_DOCUMENTS_URL +
									 * CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() +
									 * StringPool.QUESTION + "filter=examAppealStatusId" + URLEncoder.encode(" eq "
									 * + status.getId(), StandardCharsets.UTF_8); List<ExamDocuments> documentList =
									 * examAppealUtil.getExamDocsByStatusId(url);
									 * status.setExamDocuments(documentList);
									 * status.setName(examAppealUtil.getName(status.getLrUserId()));
									 * appealStatusList.add(status); }
									 * examResult.setAppealStatusList(appealStatusList);
									 * 
									 */}

							} catch (Exception e) {
								// TODO: handle exception
							}

							examResult.setExamType(examUtil.getExamType(exam.getExamTypeId(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
							String scheduleUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL
									+ examResultItem.getItems().get(i).getExamScheduleId();
							String examScheduleResponse = omsbHttpConnector.executeGet(scheduleUrl, "", headers);
							if (Validator.isNotNull(examScheduleResponse)) {
								ExamSchedule examSchedule = CustomObjectMapperUtil.readValue(examScheduleResponse,
										ExamSchedule.class);
								if (Validator.isNotNull(examSchedule)) {
									String programName = examUtil.getProgramByProgramId(examSchedule.getProgramId(),
											themeDisplay);

									examResult.setProgramName(programName);
								}
							}
							try {
								examResult.setTraineeLevelId(examUtil.getTraineeLevelId(themeDisplay.getUserId()));
							} catch (Exception e) {
								logger.error("Error in getting trainee Level Id ---" + e);
								examResult.setTraineeLevelId(0);
							}

							examResults.add(examResult);
						}
					}
				}
			}
		}
		renderRequest.setAttribute("examResult", examResults);
		renderRequest.setAttribute("appealStatusList", appealStatusList);
		return OMSBExamWebPortletKeys.EXAM_RESULTS_LIST_JSP;
	}

	@Reference(unbind = "_")
	private ScheduleUtil scheduleUtil;

	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private ExamUtil examUtil;

	@Reference(unbind = "_")
	private UserLocalService userLocalService;

	@Reference(unbind = "_")
	private ExamAppealUtil examAppealUtil;

	private static final Log logger = LogFactoryUtil.getLog(ViewResultsListMVCRenderCommand.class);

}

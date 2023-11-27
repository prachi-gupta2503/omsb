package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExam;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppeal;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResult;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="+MVCCommandNames.VIEW_OCT_RESULTS_LIST, }, service = MVCRenderCommand.class)

public class OCTViewResultsListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		logger.info("inside the render of VIEW_OCT_RESULTS_LIST");
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		List<OCTExamResultItem> examResults = new ArrayList<>();
		String examResultsUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULT_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + themeDisplay.getUserId(), StandardCharsets.UTF_8);
		String examResultsResponse = commonApi.getData(examResultsUrl);
		if (Validator.isNotNull(examResultsResponse)) {
			OCTExamResult examResultItem = CustomObjectMapperUtil.readValue(examResultsResponse, OCTExamResult.class);
			if (Validator.isNotNull(examResultItem)) {

				for (int i = 0; i < examResultItem.getItems().size(); i++) {

					OCTExamResultItem examResult = new OCTExamResultItem();

					String examDefinitionURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_DEFINITION_URL
							+ examResultItem.getItems().get(i).getoCExamDefinitionId();
					String examDefinitionResponse = omsbHttpConnector.executeGet(examDefinitionURL, "", headers);
					if (Validator.isNotNull(examDefinitionResponse)) {
						OCTExamDefinitionItem examDefinitionItem = CustomObjectMapperUtil
								.readValue(examDefinitionResponse, OCTExamDefinitionItem.class);

						OCTExam exam = octExamUtil.getExamById(examDefinitionItem.getExamId(),
								themeDisplay.getPortalURL());
						// String programName =
						// octExamUtil.getProgramByProgramId(examDefinitionItem.getProgramId(),
						// themeDisplay);
						OCTExamAppeal appeal = octExamUtil.getExamAppealByExamResultId(themeDisplay,
								examResultItem.getItems().get(i).getId());
						logger.info("appeal  " + appeal);
						if (Validator.isNotNull(appeal)) {
							examResult.setAppealCount(appeal.getAppealCount());
							examResult.setAppealStatus(octExamAppealUtil.getStatusKey(appeal.getAppealStatus()));
							
							if(appeal.getAppealCount() > 0) {
								if(appeal.getAppealCount() == 1) {
									examResult.setStatusColor(octExamUtil.getAppealStatusColor(true,appeal.getAppealStatus()));
								} else {
									examResult.setStatusColor(octExamUtil.getAppealStatusColor(false,appeal.getAppealStatus()));
								}
							}
							
						} else {
							examResult.setAppealCount(0);
							examResult.setAppealStatus("");
						}
						if (Validator.isNotNull(exam)) {

							logger.info("got the exam object " + exam);


							int appealWindow = examDefinitionItem.getAppealWindow();
							int reAppealWindow = examDefinitionItem.getReAppealWindow();
							String announcedDate = examResultItem.getItems().get(i).getAnnouncedDate();

							boolean isAppealAllowed = false, isReAppealAllowed = false;
							// Parsing the given String to Date object
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							LocalDate today = null;
							try {
								logger.info("announcedDate  " + announcedDate);
								logger.info("appeal  " + appeal);
								if (Validator.isNotNull(announcedDate)) {

									Date currentDate = new Date();

									ObjectDefinition appealObjectDefinition;
									try {
										appealObjectDefinition = ObjectDefinitionLocalServiceUtil
												.getObjectDefinitionByExternalReferenceCode("OB_OC_EXAM_APPEAL_ERC",
														themeDisplay.getCompanyId());
														logger.info("checking appeal count");
										if (examResult.getAppealCount() == 0) {
											logger.info("under appeal section");

											Date date = formatter.parse(announcedDate);
											LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault())
													.toLocalDate();
											LocalDate afterAppealDays = localDate.plusDays(appealWindow);

											today = currentDate.toInstant().atZone(ZoneId.systemDefault())
													.toLocalDate();
											isAppealAllowed = afterAppealDays.isAfter(today);
										}
										if (examResult.getAppealCount() == 1) {
											logger.info("under reappeal section");
											WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil
													.fetchWorkflowInstanceLink(themeDisplay.getCompanyId(),
															themeDisplay.getScopeGroupId(),
															appealObjectDefinition.getClassName(), appeal.getId());

											long instanceId = workflowInstanceLink.getWorkflowInstanceId();

											WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
													.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
											Date appealCompletedDate = workflowInstance.getEndDate();
											if(Validator.isNotNull(appealCompletedDate)) {
												LocalDate localReAppealDate = appealCompletedDate.toInstant()
														.atZone(ZoneId.systemDefault()).toLocalDate();
												LocalDate afterReAppealDays = localReAppealDate.plusDays(reAppealWindow);
												today = currentDate.toInstant().atZone(ZoneId.systemDefault())
														.toLocalDate();
												isReAppealAllowed = afterReAppealDays.isAfter(today);

											}
											
										}

									} catch (PortalException e) {
										logger.error(e);
									}

								}
							} catch (ParseException e) {
								logger.error(e);
							}
							examResult.setIsAppealAllowed(String.valueOf(isAppealAllowed).toLowerCase());
							examResult.setIsReAppealAllowed(String.valueOf(isReAppealAllowed).toLowerCase());
							examResult.setId(examResultItem.getItems().get(i).getId());
							// examResult.setExamScheduleId(examResultItem.getItems().get(i).getExamScheduleId());
							examResult.setLrUserId(examResultItem.getItems().get(i).getLrUserId());
							// examResult.setExamType(octExamUtil.getExamType(exam.getExamTypeId(),
							// themeDisplay.getPortalURL()));
							// examResult.setProgramName(programName);
							examResult.setPercentage(examResultItem.getItems().get(i).getPercentage());
							examResult.setResult(examResultItem.getItems().get(i).getResult());
							examResult.setAppealFees(examDefinitionItem.getAppealFees());
							examResult.setReAppealFees(examDefinitionItem.getReAppealFees());
							examResult.setAdminComments("Appeal Rejected");
							examResults.add(examResult);
						}
					}
				}
			}
		}
		renderRequest.setAttribute("examResult", examResults);
		return OmsbOctExamWebPortletKeys.OCT_EXAM_RESULTS_LIST_JSP;

	}

	private static final Log logger = LogFactoryUtil.getLog(OCTViewResultsListMVCRenderCommand.class);

	@Reference
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "_")
	private OCTExamAppealUtil octExamAppealUtil;

}

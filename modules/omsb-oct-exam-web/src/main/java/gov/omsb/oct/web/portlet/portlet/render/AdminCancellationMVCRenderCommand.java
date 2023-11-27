/*
 * package gov.omsb.oct.web.portlet.portlet.render;
 * 
 * import com.liferay.object.model.ObjectEntry; import
 * com.liferay.object.service.ObjectDefinitionLocalService; import
 * com.liferay.object.service.ObjectEntryLocalService; import
 * com.liferay.petra.string.StringPool; import
 * com.liferay.portal.kernel.exception.PortalException; import
 * com.liferay.portal.kernel.log.Log; import
 * com.liferay.portal.kernel.log.LogFactoryUtil; import
 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand; import
 * com.liferay.portal.kernel.theme.ThemeDisplay; import
 * com.liferay.portal.kernel.util.ParamUtil; import
 * com.liferay.portal.kernel.util.Validator; import
 * com.liferay.portal.kernel.util.WebKeys;
 * 
 * import java.net.URLEncoder; import java.nio.charset.StandardCharsets; import
 * java.util.ArrayList; import java.util.List;
 * 
 * import javax.portlet.PortletException; import javax.portlet.RenderRequest;
 * import javax.portlet.RenderResponse;
 * 
 * import org.osgi.service.component.annotations.Component; import
 * org.osgi.service.component.annotations.Reference;
 * 
 * import gov.omsb.common.api.OMSBCommonApi; import
 * gov.omsb.common.constants.CommonConstants; import
 * gov.omsb.common.object.url.LRObjectURL; import
 * gov.omsb.common.util.CustomObjectMapperUtil; import
 * gov.omsb.common.util.CustomWorkflowTaskUtil; import
 * gov.omsb.oct.exam.web.constants.MVCCommandNames; import
 * gov.omsb.oct.exam.web.constants.OCTExamConstants; import
 * gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys; import
 * gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealStatus; import
 * gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealStatusItem; import
 * gov.omsb.oct.exam.web.portlet.dto.OCTExamDocuments; import
 * gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil; import
 * gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
 * 
 * @Component(immediate = true, property = { "javax.portlet.name=" +
 * OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
 * "mvc.command.name="+MVCCommandNames.ADMIN_CANCELLATION_RENDER, }, service =
 * MVCRenderCommand.class) public class AdminCancellationMVCRenderCommand
 * implements MVCRenderCommand {
 * 
 * @Override public String render(RenderRequest renderRequest, RenderResponse
 * renderResponse) throws PortletException {
 * 
 * ThemeDisplay themeDisplay = (ThemeDisplay)
 * renderRequest.getAttribute(WebKeys.THEME_DISPLAY); long id =
 * ParamUtil.getLong(renderRequest, "cancellationId"); long workflowTaskId =
 * ParamUtil.getLong(renderRequest, "workflowTaskId"); long instanceId =
 * ParamUtil.getLong(renderRequest, "workflowInstanceId"); boolean assignedToMe
 * = ParamUtil.getBoolean(renderRequest, "assignedToMe"); String examTitle = "";
 * try { ObjectEntry objectEntry = objectEntryLocalService.getObjectEntry(id);
 * if (Validator.isNotNull(objectEntry)) { long titleId =
 * (long)objectEntry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_TITLE_ID);
 * examTitle = octExamUtil.getExamTitleById(titleId, themeDisplay); } } catch
 * (PortalException e) {
 * logger.error("Exception while getting the cancellation entry", e); }
 * List<OCTExamAppealStatus> cancellationStatusList = new ArrayList<>();
 * List<OCTExamAppealStatus> statusList =
 * getExamCancellationStatusByCancellationId(themeDisplay, id); for
 * (OCTExamAppealStatus status: statusList) { String url =
 * themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_CANCELLATION_DOCUMENT_URL +
 * CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() +
 * StringPool.QUESTION + "filter="+
 * OCTExamConstants.FIELD_OC_EXAM_CANCELLATION_STATUS_ID +
 * URLEncoder.encode(" eq " + status.getId(), StandardCharsets.UTF_8);
 * List<OCTExamDocuments> documentList =
 * octExamAppealUtil.getExamDocsByStatusId(url); logger.info("documentList ?? "
 * + documentList.size()); status.setExamDocuments(documentList);
 * status.setName(octExamAppealUtil.getName(status.getLrUserId()));
 * cancellationStatusList.add(status); }
 * 
 * List<String> trNames =
 * CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
 * renderRequest.setAttribute("statusList", cancellationStatusList);
 * renderRequest.setAttribute("id", id);
 * renderRequest.setAttribute("assignedToMe", assignedToMe);
 * renderRequest.setAttribute("instanceId", instanceId);
 * renderRequest.setAttribute("workflowTaskId", workflowTaskId);
 * renderRequest.setAttribute("trNames", trNames);
 * renderRequest.setAttribute("examTitle", examTitle);
 * 
 * return OmsbOctExamWebPortletKeys.ADMIN_CANCELLATION_JSP; }
 * 
 * public List<OCTExamAppealStatus>
 * getExamCancellationStatusByCancellationId(ThemeDisplay themeDisplay, long
 * cancellationId) {
 * 
 * logger.info("------getExamAppealStatusByAppealId----"); String url =
 * themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_CANCELLATION_STATUS_URL +
 * CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() +
 * StringPool.QUESTION + "filter="+OCTExamConstants.FIELD_OC_EXAM_CANCEL_ID +
 * URLEncoder.encode(" eq " + cancellationId, StandardCharsets.UTF_8);
 * logger.info("url == " + url); String response = omsbCommonApi.getData(url);
 * logger.info("------getExamCancellationStatusByCancellationId----"+response);
 * 
 * OCTExamAppealStatusItem statusItems =
 * CustomObjectMapperUtil.readValue(response, OCTExamAppealStatusItem.class); if
 * (Validator.isNotNull(statusItems) &&
 * Validator.isNotNull(statusItems.getItems()) &&
 * !statusItems.getItems().isEmpty()) { return statusItems.getItems(); } return
 * new ArrayList<>(); }
 * 
 * @Reference private ObjectEntryLocalService objectEntryLocalService;
 * 
 * @Reference private ObjectDefinitionLocalService objectDefinitionLocalService;
 * 
 * @Reference(unbind = "-") private OCTExamUtil octExamUtil;
 * 
 * @Reference(unbind = "-") private OCTExamAppealUtil octExamAppealUtil;
 * 
 * @Reference(unbind = "-") private OMSBCommonApi omsbCommonApi;
 * 
 * private static final Log logger =
 * LogFactoryUtil.getLog(AdminCancellationMVCRenderCommand.class); }
 */
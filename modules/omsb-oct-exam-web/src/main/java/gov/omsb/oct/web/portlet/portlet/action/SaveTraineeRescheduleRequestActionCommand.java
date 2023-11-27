/*
 * package gov.omsb.oct.web.portlet.portlet.action;
 * 
 * import com.liferay.object.model.ObjectDefinition; import
 * com.liferay.object.model.ObjectEntry; import
 * com.liferay.object.service.ObjectEntryLocalService; import
 * com.liferay.object.service.ObjectEntryLocalServiceUtil; import
 * com.liferay.portal.kernel.exception.PortalException; import
 * com.liferay.portal.kernel.json.JSONArray; import
 * com.liferay.portal.kernel.json.JSONFactoryUtil; import
 * com.liferay.portal.kernel.json.JSONObject; import
 * com.liferay.portal.kernel.log.Log; import
 * com.liferay.portal.kernel.log.LogFactoryUtil; import
 * com.liferay.portal.kernel.model.Role; import
 * com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand; import
 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand; import
 * com.liferay.portal.kernel.repository.model.FileEntry; import
 * com.liferay.portal.kernel.service.ServiceContext; import
 * com.liferay.portal.kernel.service.ServiceContextFactory; import
 * com.liferay.portal.kernel.theme.ThemeDisplay; import
 * com.liferay.portal.kernel.upload.UploadPortletRequest; import
 * com.liferay.portal.kernel.util.FileUtil; import
 * com.liferay.portal.kernel.util.ParamUtil; import
 * com.liferay.portal.kernel.util.PortalUtil; import
 * com.liferay.portal.kernel.util.Validator; import
 * com.liferay.portal.kernel.util.WebKeys; import
 * com.liferay.portal.kernel.workflow.WorkflowInstance; import
 * com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
 * 
 * import java.io.File; import java.io.Serializable; import java.util.HashMap;
 * import java.util.List; import java.util.Map; import
 * java.util.stream.Collectors;
 * 
 * import javax.mail.internet.NewsAddress; import javax.portlet.ActionRequest;
 * import javax.portlet.ActionResponse; import javax.portlet.PortletRequest;
 * 
 * import org.osgi.service.component.annotations.Component; import
 * org.osgi.service.component.annotations.Reference;
 * 
 * import gov.omsb.common.api.OMSBCommonApi; import
 * gov.omsb.common.constants.RoleNameConstants; import
 * gov.omsb.common.util.FileUploadUtil; import
 * gov.omsb.oct.exam.web.constants.MVCCommandNames; import
 * gov.omsb.oct.exam.web.constants.OCTExamConstants; import
 * gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys; import
 * gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil; import
 * gov.omsb.oct.exam.web.portlet.util.OCTExamCancellationUtil; import
 * gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
 * 
 * @Component(immediate = true, property = { "javax.portlet.name=" +
 * OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, "mvc.command.name=" +
 * MVCCommandNames.SAVE_RESCHEDULE_REQUEST_ACTION, }, service =
 * MVCActionCommand.class) public class
 * SaveTraineeRescheduleRequestActionCommand extends BaseMVCActionCommand {
 * 
 * private static final Log logger =
 * LogFactoryUtil.getLog(SaveTraineeRescheduleRequestActionCommand.class);
 * 
 * @Override protected void doProcessAction(ActionRequest actionRequest,
 * ActionResponse actionResponse) throws Exception {
 * logger.info("Invoking do process action method ::::::::::"); ThemeDisplay
 * themeDisplay = (ThemeDisplay)
 * actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 * 
 * String reason = ParamUtil.getString(actionRequest, "comments"); String
 * supportingDocJson = ParamUtil.getString(actionRequest, "supportingDocJson");
 * long examDefinitionId = ParamUtil.getLong(actionRequest, "examDefinitionId",
 * 54969); long examScheduleId = ParamUtil.getLong(actionRequest,
 * "examScheduleId", 55361); long newExamScheduleId =
 * ParamUtil.getLong(actionRequest, "newExamScheduleId", 55362); long
 * examTitleId = ParamUtil.getLong(actionRequest, "examTitleId", 54955); long
 * rescheduleId = ParamUtil.getLong(actionRequest, "rescheduleId"); long
 * workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId"); long
 * instanceId = ParamUtil.getLong(actionRequest, "instanceId"); boolean
 * assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe"); String
 * transitionName = ParamUtil.getString(actionRequest, "trName");
 * 
 * logger.info("reason ::::::::::" + reason);
 * logger.info("scheduleId ::::::::::" + examDefinitionId);
 * logger.info("supportingDocJson ::::::::::" + supportingDocJson);
 * logger.info("newExamScheduleId ::::::::::" + newExamScheduleId);
 * logger.info("examTitleId ::::::::::" + examTitleId); List<String > roleNames
 * = themeDisplay.getUser().getRoles().stream().map(Role::getName).collect(
 * Collectors.toList()); boolean isAdmin = Boolean.FALSE; if
 * (roleNames.contains(RoleNameConstants.OCT_ADMIN)) { isAdmin = Boolean.TRUE; }
 * long statusId = octExamCancellationUtil.getStatusId(roleNames,
 * transitionName, themeDisplay); logger.info("statusId ::::::::::" + statusId);
 * ObjectEntry scheduleEntry = null; if (rescheduleId > 0 && isAdmin) { //update
 * the cancellation with status. logger.info("inside update ::::::::::" );
 * scheduleEntry = updateRescheduleById(actionRequest, themeDisplay,
 * rescheduleId, statusId); } else { scheduleEntry = addReschedule(themeDisplay,
 * examTitleId, examScheduleId, newExamScheduleId, actionRequest, statusId,
 * examDefinitionId); }
 * 
 * logger.info("cancelEntry ::::::::::" + scheduleEntry); ObjectEntry
 * rescheduleStatusEntry = null; if (Validator.isNotNull(scheduleEntry)) {
 * rescheduleId = scheduleEntry.getObjectEntryId();
 * logger.info("RescheduleId ::::::::::" + rescheduleId); rescheduleStatusEntry
 * = addRescheduleStatus(themeDisplay, reason, rescheduleId, actionRequest,
 * statusId, isAdmin); logger.info("cancelStatusEntry ::::::::::" +
 * rescheduleStatusEntry); } JSONObject jsonData =
 * JSONFactoryUtil.createJSONObject(supportingDocJson); JSONArray array =
 * jsonData.getJSONArray("items"); if
 * (Validator.isNotNull(rescheduleStatusEntry)) { for (int i = 0; i <
 * array.length(); i++) { JSONObject supportingValues = array.getJSONObject(i);
 * String fileName = supportingValues.getString("fileName"); String docTitle =
 * supportingValues.getString("docTitle"); String rowNumber =
 * supportingValues.getString("rowNumber"); UploadPortletRequest uploadRequest =
 * PortalUtil.getUploadPortletRequest(actionRequest); File file =
 * uploadRequest.getFile("docInput_" + rowNumber); FileEntry entry =
 * FileUploadUtil.addDocument(fileName, file, FileUtil.getExtension(fileName),
 * themeDisplay.getScopeGroupId(), 0); if (Validator.isNotNull(entry) &&
 * rescheduleStatusEntry != null) { logger.info("fileName ?? " +
 * entry.getFileEntryId()); addRescheduleDocs(themeDisplay, docTitle,
 * entry.getFileEntryId(), rescheduleStatusEntry.getObjectEntryId(),
 * actionRequest); } } }
 * 
 * if (!assignedToMe && isAdmin && Validator.isNotNull(rescheduleStatusEntry)) {
 * WorkflowInstance workflowInstance =
 * WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(),
 * instanceId); octExamAppealUtil.assignOrCompleteWorkflow(transitionName, "",
 * themeDisplay, workflowInstance, workflowTaskId); }
 * 
 * logger.info("Invoking do process action method successful::::::::::"); }
 * 
 * private ObjectEntry addReschedule(ThemeDisplay themeDisplay, long
 * examTitleId, long scheduleId, long newScheduleId, PortletRequest request,
 * long statusId, long definitionId) { Map<String, Serializable> values = new
 * HashMap<>(); values.put(OCTExamConstants.FIELD_OC_EXAM_DEFINITION_ID,
 * definitionId); values.put(OCTExamConstants.FIELD_OC_EXAM_SCHEDULE_ID,
 * scheduleId); values.put(OCTExamConstants.FIELD_OC_NEW_EXAM_SCHEDULE_ID,
 * newScheduleId); values.put(OCTExamConstants.FIELD_OC_EXAM_LR_USER_ID,
 * themeDisplay.getUserId());
 * values.put(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_WF_STATUS_ID, statusId);
 * values.put(OCTExamConstants.FIELD_OC_EXAM_TITLE_ID, examTitleId); return
 * omsbCommonApi.addObjectEntryByERC(OmsbOctExamWebPortletKeys.
 * RESCHEDULE_OBJECT_ERC, values, request, themeDisplay); }
 * 
 * private ObjectEntry addRescheduleStatus(ThemeDisplay themeDisplay, String
 * reason, long rescheduleId, PortletRequest request, long statusId, boolean
 * isAdmin) { Map<String, Serializable> values = new HashMap<>();
 * values.put(OCTExamConstants.FIELD_OC_EXAM_LR_USER_ID,
 * themeDisplay.getUserId());
 * values.put(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_WF_STATUS_ID, statusId);
 * values.put(OCTExamConstants.FIELD_OC_EXAM_REASON, reason);
 * values.put(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_ADMIN, isAdmin);
 * values.put(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_ID, rescheduleId);
 * return omsbCommonApi.addObjectEntryByERC(OmsbOctExamWebPortletKeys.
 * RESCHEDULE_STATUS_OBJECT_ERC, values, request, themeDisplay); }
 * 
 * private ObjectEntry addRescheduleDocs(ThemeDisplay themeDisplay, String
 * docTitle, long fileEntryId, long rescheduleStatusId, PortletRequest request)
 * { Map<String, Serializable> values = new HashMap<>();
 * values.put(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_DOCUMENT_FILE_ENTRY_ID,
 * fileEntryId);
 * values.put(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_DOCUMENT_TITLE,
 * docTitle); values.put(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_STATUS_ID,
 * rescheduleStatusId); return
 * omsbCommonApi.addObjectEntryByERC(OmsbOctExamWebPortletKeys.
 * RESCHEDULE_DOCS_OBJECT_ERC, values, request, themeDisplay); }
 * 
 * private ObjectEntry updateRescheduleById(PortletRequest request, ThemeDisplay
 * themeDisplay, long pk, long statusId) { try { ObjectDefinition
 * objectDefinition = octExamUtil.getObjectDefinition(themeDisplay,
 * OmsbOctExamWebPortletKeys.RESCHEDULE_OBJECT_ERC); ObjectEntry entry = null;
 * if (Validator.isNotNull(objectDefinition)) { entry =
 * objectEntryLocalService.getObjectEntry(pk); ServiceContext serviceContext =
 * ServiceContextFactory.getInstance(request); Map<String, Serializable> values
 * = new HashMap<>();
 * values.put(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_WF_STATUS_ID,statusId);
 * if (Validator.isNotNull(entry)) { entry =
 * ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry
 * (entry.getExternalReferenceCode(), themeDisplay.getUserId(),
 * themeDisplay.getScopeGroupId(), objectDefinition.getObjectDefinitionId(),
 * values, serviceContext); } } return entry; } catch (PortalException e) {
 * logger.error("exception while calling the updateRescheduleById ::::: " + e);
 * } return null;
 * 
 * }
 * 
 * @Reference private OMSBCommonApi omsbCommonApi;
 * 
 * @Reference private OCTExamUtil octExamUtil;
 * 
 * @Reference private ObjectEntryLocalService objectEntryLocalService;
 * 
 * @Reference(unbind = "-") private OCTExamAppealUtil octExamAppealUtil;
 * 
 * @Reference(unbind = "-") private OCTExamCancellationUtil
 * octExamCancellationUtil; }
 */
/*
 * package gov.omsb.oct.exam.web.portlet.util;
 * 
 * import com.liferay.object.model.ObjectEntry; import
 * com.liferay.portal.kernel.exception.PortalException; import
 * com.liferay.portal.kernel.log.Log; import
 * com.liferay.portal.kernel.log.LogFactoryUtil; import
 * com.liferay.portal.kernel.model.User; import
 * com.liferay.portal.kernel.service.UserLocalService; import
 * com.liferay.portal.kernel.theme.ThemeDisplay; import
 * com.liferay.portal.kernel.util.Validator; import
 * com.liferay.portal.kernel.workflow.WorkflowInstance; import
 * com.liferay.portal.kernel.workflow.WorkflowLog;
 * 
 * import java.util.ArrayList; import java.util.Comparator; import
 * java.util.List;
 * 
 * import org.osgi.service.component.annotations.Component; import
 * org.osgi.service.component.annotations.Reference;
 * 
 * import gov.omsb.common.api.OMSBCommonApi; import
 * gov.omsb.common.constants.RoleNameConstants; import
 * gov.omsb.common.util.CustomWorkflowTaskUtil; import
 * gov.omsb.oct.exam.web.constants.OCTExamConstants; import
 * gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys; import
 * gov.omsb.oct.exam.web.portlet.dto.CancellationDetail; import
 * gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
 * 
 * @Component(immediate = true, property = {}, service =
 * OCTExamCancellationUtil.class) public class OCTExamCancellationUtil {
 * 
 * public CancellationDetail getWorkflowData(ThemeDisplay themeDisplay,
 * CancellationDetail detail, long primaryKey, String erc) { String className =
 * octExamUtil.getObjectClassName(erc,themeDisplay.getCompanyId()); boolean
 * assignedToRole = false; long workflowTaskId = 0; long workflowInstanceId = 0;
 * try { WorkflowInstance instance =
 * CustomWorkflowTaskUtil.getWorkflowInstace(className, themeDisplay,
 * primaryKey); if (Validator.isNotNull(instance)) { workflowInstanceId =
 * instance.getWorkflowInstanceId(); } List<WorkflowLog> logs =
 * CustomWorkflowTaskUtil.getWorkflowLogs(themeDisplay.getCompanyId(),
 * instance); if (!logs.isEmpty()) { long assigneeRoleId =
 * CustomWorkflowTaskUtil.getWorkflowAssigneeRoleIdByLogs(logs); assignedToRole
 * = CustomWorkflowTaskUtil.isWorkFlowTaskAssignedToRole(themeDisplay,
 * assigneeRoleId); workflowTaskId =
 * CustomWorkflowTaskUtil.getWorkflowTaskIdByLogs(logs); } List<String>
 * transitionNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay,
 * workflowTaskId); detail.setAssignedToMe(assignedToRole);
 * detail.setWorkflowInstanceId(workflowInstanceId);
 * detail.setWorkflowTaskId(workflowTaskId);
 * detail.setTransitionNames(transitionNames); }catch (Exception e) {
 * logger.error(e.getMessage(), e); } return detail; }
 * 
 * public String getDateValues(OCTExamSchedule schedule, String value) { if
 * (Validator.isNotNull(schedule) && Validator.isNotNull(value)) { String date =
 * omsbCommonApi.convertDateFormatToDDMMYYYY(value);
 * logger.info("examDate ::::::: "+ date); return date; } return ""; }
 * 
 * public List<CancellationDetail> getAllCancellationList(ThemeDisplay
 * themeDisplay) { logger.info("getAllCancellationList ::::::: ");
 * List<ObjectEntry> objectEntries = new ArrayList<>(); List<CancellationDetail>
 * detailList = new ArrayList<>(); try { objectEntries =
 * octExamUtil.getAllObjectEntryByDefinitionERC(themeDisplay,
 * OmsbOctExamWebPortletKeys.CANCELLATION_OBJECT_ERC); for (ObjectEntry entry:
 * objectEntries) { CancellationDetail detail = new CancellationDetail();
 * detail.setValues(entry.getValues()); long examScheduleId =(long)
 * entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_SCHEDULE_ID); long
 * cancellationStatusId = (long)
 * entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_CANCEL_WF_STATUS_ID);
 * long examTitleId = (long)
 * entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_TITLE_ID); long lrUserId
 * = (long) entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_LR_USER_ID);
 * OCTExamSchedule schedule =
 * octExamUtil.getOCTExamScheduleById(examScheduleId,themeDisplay.getPortalURL()
 * );
 * 
 * logger.info("schedule ::::::: "+ schedule); String examDate =
 * getDateValues(schedule, schedule.getExamDate()); String regStartDate =
 * getDateValues(schedule, schedule.getRegistrationStartDate()); String
 * regEndDate = getDateValues(schedule, schedule.getRegistrationEndDate());
 * 
 * detail.setId(entry.getObjectEntryId());
 * detail.setExamDate(Validator.isNotNull(schedule)?examDate:"");
 * detail.setRegistrationStartDate(Validator.isNotNull(schedule)?regStartDate:""
 * );
 * detail.setRegistrationEndDate(Validator.isNotNull(schedule)?regEndDate:"");
 * detail.setExamTitle(octExamUtil.getExamTitleById(examTitleId, themeDisplay));
 * User user = userLocalService.fetchUser(lrUserId); if
 * (Validator.isNotNull(user)) { detail.setUserName(user.getFullName()); } else
 * { detail.setUserName("No Data"); }
 * detail.setCancellationStatusValue(omsbCommonApi.
 * getListTypeEntryNameBylistTypeEntryId(cancellationStatusId,
 * themeDisplay.getLocale()));
 * detail.setStatusColor(octExamUtil.getCancellatoinColor(cancellationStatusId))
 * ; detail = getWorkflowData(themeDisplay, detail,
 * entry.getObjectEntryId(),OmsbOctExamWebPortletKeys.CANCELLATION_OBJECT_ERC);
 * detailList.add(detail); }
 * detailList.sort(Comparator.comparingLong(CancellationDetail::getId).reversed(
 * )); logger.info("cancell size()::::::: "+ detailList.size()); } catch
 * (Exception e) {
 * logger.error("Exception while getting the cancellation list ::::::: ", e); }
 * return detailList; }
 * 
 * public List<CancellationDetail> getAllRescheduleList(ThemeDisplay
 * themeDisplay) { List<ObjectEntry> objectEntries = new ArrayList<>();
 * List<CancellationDetail> detailList = new ArrayList<>(); try { objectEntries
 * = octExamUtil.getAllObjectEntryByDefinitionERC(themeDisplay,
 * OmsbOctExamWebPortletKeys.RESCHEDULE_OBJECT_ERC); for (ObjectEntry entry:
 * objectEntries) { CancellationDetail detail = new CancellationDetail();
 * detail.setValues(entry.getValues()); long examScheduleId =(long)
 * entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_SCHEDULE_ID); long
 * cancellationStatusId = (long)
 * entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_RESCHEDULE_WF_STATUS_ID)
 * ; long examTitleId = (long)
 * entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_TITLE_ID); long lrUserId
 * = (long) entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_LR_USER_ID);
 * OCTExamSchedule schedule =
 * octExamUtil.getOCTExamScheduleById(examScheduleId,themeDisplay.getPortalURL()
 * ); logger.info("schedule ::::::: "+ schedule); String examDate =
 * getDateValues(schedule, schedule.getExamDate()); String regStartDate =
 * getDateValues(schedule, schedule.getRegistrationStartDate()); String
 * regEndDate = getDateValues(schedule, schedule.getRegistrationEndDate());
 * 
 * detail.setId(entry.getObjectEntryId());
 * detail.setExamDate(Validator.isNotNull(schedule)?examDate:"");
 * detail.setRegistrationStartDate(Validator.isNotNull(schedule)?regStartDate:""
 * );
 * detail.setRegistrationEndDate(Validator.isNotNull(schedule)?regEndDate:"");
 * detail.setExamTitle(octExamUtil.getExamTitleById(examTitleId, themeDisplay));
 * User user = userLocalService.fetchUser(lrUserId); if
 * (Validator.isNotNull(user)) { detail.setUserName(user.getFullName()); } else
 * { detail.setUserName("No Data"); }
 * detail.setCancellationStatusValue(omsbCommonApi.
 * getListTypeEntryNameBylistTypeEntryId(cancellationStatusId,
 * themeDisplay.getLocale()));
 * detail.setStatusColor(octExamUtil.getCancellatoinColor(cancellationStatusId))
 * ; // detail = getWorkflowData(themeDisplay, detail, entry.getObjectEntryId(),
 * OmsbOctExamWebPortletKeys.RESCHEDULE_OBJECT_ERC); detailList.add(detail); }
 * detailList.sort(Comparator.comparingLong(CancellationDetail::getId).reversed(
 * )); } catch (Exception e) {
 * logger.error("exception while calling getAllRescheduleList ::::: ", e); }
 * return detailList;
 * 
 * }
 * 
 * public long getStatusId(List<String> roleNames, String transitionName,
 * ThemeDisplay themeDisplay) { long statusId = 0; if
 * (roleNames.contains(RoleNameConstants.OCT_ADMIN)) { //isAdmin = Boolean.TRUE;
 * if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.
 * TRANSITION_NAME_ACCEPT)) { logger.info("in accept condition ::::::::::" +
 * transitionName); statusId =
 * octExamUtil.getExamStatusIdByListTypeKey(OmsbOctExamWebPortletKeys.
 * PL_EXAM_STATUS_KEY_ACCEPTED, themeDisplay.getCompanyId()); } else if
 * (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.
 * TRANSITION_NAME_REJECT)) { logger.info("in reject condition ::::::::::" +
 * transitionName); statusId =
 * octExamUtil.getExamStatusIdByListTypeKey(OmsbOctExamWebPortletKeys.
 * PL_EXAM_STATUS_KEY_REJECTED, themeDisplay.getCompanyId()); } } else {
 * statusId =
 * octExamUtil.getExamStatusIdByListTypeKey(OmsbOctExamWebPortletKeys.
 * PL_EXAM_STATUS_KEY_PENDING, themeDisplay.getCompanyId()); } return statusId;
 * }
 * 
 * @Reference private OCTExamUtil octExamUtil;
 * 
 * @Reference private OMSBCommonApi omsbCommonApi;
 * 
 * @Reference private UserLocalService userLocalService;
 * 
 * private static final Log logger =
 * LogFactoryUtil.getLog(OCTExamCancellationUtil.class);
 * 
 * }
 */
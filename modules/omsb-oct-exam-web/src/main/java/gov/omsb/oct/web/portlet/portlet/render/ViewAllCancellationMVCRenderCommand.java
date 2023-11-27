package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.CancellationDetail;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="+MVCCommandNames.VIEW_ALL_CANCELLATION_RENDER, }, service = MVCRenderCommand.class)
public class ViewAllCancellationMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long scheduleId = ParamUtil.getLong(renderRequest, "scheduleId");
		List<ObjectEntry> objectEntries = new ArrayList<>();
		try {
			ObjectDefinition objectDefinition = objectDefinitionLocalService.getObjectDefinitionByExternalReferenceCode(OmsbOctExamWebPortletKeys.CANCELLATION_OBJECT_ERC, themeDisplay.getCompanyId());
			if (Validator.isNotNull(objectDefinition)) {
				objectEntries = objectEntryLocalService.getObjectEntries(themeDisplay.getScopeGroupId(), objectDefinition.getObjectDefinitionId(), -1, -1);
			}
			List<CancellationDetail> detailList = new ArrayList<>();
			for (ObjectEntry entry: objectEntries) {
				CancellationDetail detail = new CancellationDetail();
				detail.setValues(entry.getValues());
				long examScheduleId =(long) entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_SCHEDULE_ID);
				long cancellationStatusId = (long) entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_CANCEL_WF_STATUS_ID);
				long examTitleId = (long) entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_TITLE_ID);
				OCTExamSchedule schedule = octExamUtil.getOCTExamScheduleById(examScheduleId,themeDisplay.getPortalURL());
				
				logger.info("schedule ::::::: "+ schedule);
				String examDate = "";
				String regStartDate = "";
				String regEndDate="";
				if (Validator.isNotNull(schedule) && Validator.isNotNull(schedule.getExamDate())) {
					examDate = omsbCommonApi.convertDateFormatToDDMMYYYY(schedule.getExamDate());
					logger.info("examDate ::::::: "+ examDate);
				}
				if (Validator.isNotNull(schedule) && Validator.isNotNull(schedule.getRegistrationStartDate())) {
					regStartDate = omsbCommonApi.convertDateFormatToDDMMYYYY(schedule.getRegistrationStartDate());
					logger.info("regStartDate ::::::: "+ regStartDate);
				}
				if (Validator.isNotNull(schedule) && Validator.isNotNull(schedule.getRegistrationEndDate())) {
					regEndDate = omsbCommonApi.convertDateFormatToDDMMYYYY(schedule.getRegistrationEndDate());
					logger.info("regEndDate ::::::: "+ regEndDate);
				}
				detail.setId(entry.getObjectEntryId());
				detail.setExamDate(Validator.isNotNull(schedule)?examDate:"");
				detail.setRegistrationStartDate(Validator.isNotNull(schedule)?regStartDate:"");
				detail.setRegistrationEndDate(Validator.isNotNull(schedule)?regEndDate:"");
				detail.setExamTitle(octExamUtil.getExamTitleById(examTitleId, themeDisplay));
				detail.setUserName(themeDisplay.getUser().getFullName());
				detail.setCancellationStatusValue(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(cancellationStatusId, themeDisplay.getLocale()));
				detail.setStatusColor(octExamUtil.getCancellatoinColor(cancellationStatusId));
				detail = getWorkflowData(themeDisplay, detail, entry.getObjectEntryId());
				detailList.add(detail);
			}
			detailList.sort(Comparator.comparingLong(CancellationDetail::getId).reversed());
			renderRequest.setAttribute("cancellationList", detailList);
		} catch (Exception e) {
			logger.error("Exception while getting the cancellation list ::::::: ", e);
		}
		return OmsbOctExamWebPortletKeys.VIEW_ALL_CANCELLATION_JSP;
	}

	
	public CancellationDetail getWorkflowData(ThemeDisplay themeDisplay, CancellationDetail detail, long primaryKey) {
		String className = octExamUtil.getObjectClassName(OmsbOctExamWebPortletKeys.CANCELLATION_OBJECT_ERC,themeDisplay.getCompanyId());
		boolean assignedToRole = false;
		long workflowTaskId = 0;
		long workflowInstanceId = 0;
		try {
			WorkflowInstance instance = CustomWorkflowTaskUtil.getWorkflowInstace(className, themeDisplay, primaryKey);
			if (Validator.isNotNull(instance)) {
				workflowInstanceId = instance.getWorkflowInstanceId();
			}
			List<WorkflowLog> logs = CustomWorkflowTaskUtil.getWorkflowLogs(themeDisplay.getCompanyId(), instance);
			if (!logs.isEmpty()) {
				long assigneeRoleId = CustomWorkflowTaskUtil.getWorkflowAssigneeRoleIdByLogs(logs);
				assignedToRole = CustomWorkflowTaskUtil.isWorkFlowTaskAssignedToRole(themeDisplay, assigneeRoleId);
				workflowTaskId = CustomWorkflowTaskUtil.getWorkflowTaskIdByLogs(logs);
			}
			List<String> transitionNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
			detail.setAssignedToMe(assignedToRole);
			detail.setWorkflowInstanceId(workflowInstanceId);
			detail.setWorkflowTaskId(workflowTaskId);
			detail.setTransitionNames(transitionNames);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return detail;
	}
	
	private static  final Log logger = LogFactoryUtil.getLog(ViewAllCancellationMVCRenderCommand.class);
	@Reference
	private OCTExamUtil octExamUtil;
	@Reference
	private ObjectEntryLocalService objectEntryLocalService;
	@Reference
	private ObjectDefinitionLocalService objectDefinitionLocalService;

	@Reference
	private OMSBCommonApi omsbCommonApi;
}

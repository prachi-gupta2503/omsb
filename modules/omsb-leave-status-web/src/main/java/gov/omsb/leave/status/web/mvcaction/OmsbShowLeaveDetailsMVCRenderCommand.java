package gov.omsb.leave.status.web.mvcaction;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusWebPortletKeys;
import gov.omsb.leave.status.web.util.OmsbAddLeaveUtil;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB,
		"mvc.command.name="
				+ OmsbLeaveStatusConstants.VIEW_LEAVE_DETAILS_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbShowLeaveDetailsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveStatusConstants.VIEW_DATE_FORMAT);

		SimpleDateFormat statusViewDateFormat = new SimpleDateFormat(OmsbLeaveStatusConstants.STATUS_VIEW_DATE_FORMAT);

		SimpleDateFormat statusViewTimeFormat = new SimpleDateFormat(OmsbLeaveStatusConstants.STATUS_VIEW_TIME_FORMAT);

		long leaveMasterId = ParamUtil.getLong(renderRequest, "leaveMasterId");

		try {
			LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveMasterId);

			long leaveTypeId = leaveMaster.getLeaveTypeId();

			LeaveTypes leaveTypes = leaveTypesLocalService.getLeaveTypes(leaveTypeId);

			DynamicQuery dynamicQuery = kaleoTaskInstanceTokenLocalService.dynamicQuery();

			dynamicQuery.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.CLASS_PK, leaveMasterId));
			dynamicQuery
					.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.CLASS_NAME, LeaveMaster.class.getName()));
			dynamicQuery.addOrder(OrderFactoryUtil.asc("createDate"));

			List<KaleoTaskInstanceToken> kaleoTaskInstanceTokens = kaleoTaskInstanceTokenLocalService
					.dynamicQuery(dynamicQuery);

			List<Map<String, String>> lstkKaleoAssigneeDetails = new ArrayList<>();

			String approvalStatus = StringPool.BLANK;
			if (leaveMaster.getStatus() == 0) {
				approvalStatus = OmsbLeaveStatusConstants.STATUS_APPROVED;
			} else if (leaveMaster.getStatus() == 1) {
				approvalStatus = OmsbLeaveStatusConstants.STATUS_PENDING;
			} else if (leaveMaster.getStatus() == 4) {
				approvalStatus = OmsbLeaveStatusConstants.STATUS_REJECTED;
			} else if (leaveMaster.getStatus() == 8) {
				approvalStatus = OmsbLeaveStatusConstants.STATUS_CANCELED;
			}

			if (kaleoTaskInstanceTokens.size() > 1 || OmsbLeaveStatusConstants.STATUS_REJECTED.equals(approvalStatus)) {

				int kaleoTaskInstanceTokenSize = kaleoTaskInstanceTokens.size();

				List<Integer> logTypes = new ArrayList<>();
				logTypes.add(WorkflowLog.TASK_COMPLETION);

				List<WorkflowLog> kaleoLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(
						themeDisplay.getCompanyId(), kaleoTaskInstanceTokens.get(0).getKaleoInstanceId(), logTypes,
						QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

				Map<String, String> nodeWiseKaleoLogs = OmsbAddLeaveUtil.getNodeWiseKaleoComments(kaleoLogs);

				lstkKaleoAssigneeDetails = getKaleoAssigneeDetails(themeDisplay, kaleoTaskInstanceTokens, logTypes,
						nodeWiseKaleoLogs, kaleoTaskInstanceTokenSize, approvalStatus);

			}

			renderRequest.setAttribute("leaveMaster", leaveMaster);
			renderRequest.setAttribute("kaleoTaskInstanceTokens", kaleoTaskInstanceTokens);
			renderRequest.setAttribute(OmsbLeaveStatusConstants.APPROVAL_STATUS_LIST, lstkKaleoAssigneeDetails);
			renderRequest.setAttribute(OmsbLeaveStatusConstants.LEAVE_TYPE,
					leaveTypes.getLeaveTypes(themeDisplay.getLocale()));
			renderRequest.setAttribute(OmsbLeaveStatusConstants.SDF, sdf);
			renderRequest.setAttribute(OmsbLeaveStatusConstants.VIEW_STATUS_SDF, statusViewDateFormat);
			renderRequest.setAttribute(OmsbLeaveStatusConstants.VIEW_STATUS_TIME_SDF, statusViewTimeFormat);

		} catch (PortalException e) {
			log.error("PortalException While Fetching Leave Details");
		}

		return OmsbLeaveStatusConstants.VIEW_LEAVE_DETAILS_JSP;
	}

	private List<Map<String, String>> getKaleoAssigneeDetails(ThemeDisplay themeDisplay,
			List<KaleoTaskInstanceToken> kaleoTaskInstanceTokens, List<Integer> logTypes,
			Map<String, String> nodeWiseKaleoLogs, int kaleoTaskInstanceTokenSize, String approvalStatus)
			throws PortalException {

		SimpleDateFormat statusViewDateFormat = new SimpleDateFormat(OmsbLeaveStatusConstants.STATUS_VIEW_DATE_FORMAT);

		SimpleDateFormat statusViewTimeFormat = new SimpleDateFormat(OmsbLeaveStatusConstants.STATUS_VIEW_TIME_FORMAT);

		List<Map<String, String>> lstkKaleoAssigneeDetails = new ArrayList<>();

		int iteration = 1;

		for (KaleoTaskInstanceToken kaleoTaskInstanceToken : kaleoTaskInstanceTokens) {

			if (!kaleoTaskInstanceToken.getCompleted()) {
				continue;
			}

			Map<String, String> kaleoAssigneeDetails = new HashMap<>();

			if (iteration == kaleoTaskInstanceTokenSize) {
				kaleoAssigneeDetails.put(OmsbLeaveStatusConstants.STATUS, approvalStatus);
			} else {
				kaleoAssigneeDetails.put(OmsbLeaveStatusConstants.STATUS, OmsbLeaveStatusConstants.STATUS_APPROVED);
			}

			long taskAssigneeClassPk = kaleoTaskInstanceToken.getKaleoTask().getKaleoTaskAssignments().get(0)
					.getAssigneeClassPK();

			kaleoAssigneeDetails.put(OmsbLeaveStatusConstants.USER_NAME,
					userLocalService.getUser(kaleoTaskInstanceToken.getCompletionUserId()).getFullName());
			kaleoAssigneeDetails.put(OmsbLeaveStatusConstants.COMPLETION_DATE,
					statusViewDateFormat.format(kaleoTaskInstanceToken.getCompletionDate()));
			kaleoAssigneeDetails.put(OmsbLeaveStatusConstants.COMPLETION_TIME,
					statusViewTimeFormat.format(kaleoTaskInstanceToken.getCompletionDate()));
			kaleoAssigneeDetails.put(OmsbLeaveStatusConstants.ROLE_NAME,
					roleLocalService.getRole(taskAssigneeClassPk).getName());

			if (kaleoTaskInstanceToken.getKaleoInstanceId() == kaleoTaskInstanceTokens.get(0).getKaleoInstanceId()) {
				kaleoAssigneeDetails.put(OmsbLeaveStatusConstants.COMMENTS,
						nodeWiseKaleoLogs.get(kaleoTaskInstanceToken.getKaleoTask().getKaleoNode().getName()));
			} else {
				List<WorkflowLog> anotherKaleoLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(
						themeDisplay.getCompanyId(), kaleoTaskInstanceToken.getKaleoInstanceId(), logTypes,
						QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

				Map<String, String> anotherNodeWiseKaleoLogs = OmsbAddLeaveUtil
						.getNodeWiseKaleoComments(anotherKaleoLogs);

				kaleoAssigneeDetails.put(OmsbLeaveStatusConstants.COMMENTS,
						anotherNodeWiseKaleoLogs.get(kaleoTaskInstanceToken.getKaleoTask().getKaleoNode().getName()));
			}

			lstkKaleoAssigneeDetails.add(kaleoAssigneeDetails);

			iteration++;

		}

		return lstkKaleoAssigneeDetails;

	}

	@Reference
	LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	KaleoTaskInstanceTokenLocalService kaleoTaskInstanceTokenLocalService;

	@Reference
	UserLocalService userLocalService;

	@Reference
	RoleLocalService roleLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbAddLeaveMVCRenderCommand.class.getName());

}
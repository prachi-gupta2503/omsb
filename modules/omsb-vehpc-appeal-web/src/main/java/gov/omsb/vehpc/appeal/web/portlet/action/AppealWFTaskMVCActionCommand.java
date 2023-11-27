package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.util.AppealWrokflowUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
		"mvc.command.name=/appeal/workflow_action", }, service = MVCActionCommand.class)
public class AppealWFTaskMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("inside the AssignWorkflowTaskMVCActionCommand :::::::::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		logger.info("workflowTaskId    "+workflowTaskId);
		long instanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId");
		String comments = ParamUtil.getString(actionRequest, "comments");
		long eqAppealId = ParamUtil.getLong(actionRequest, "eqAppealId");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
		String tName = ParamUtil.getString(actionRequest, "transitionName");
		String roleName = appealUtil.getAppealRoleName(themeDisplay.getUser().getRoles());
		logger.info("eqAppeal Id ?? " + eqAppealId);
		logger.info("comments ?? " + comments);
		logger.info("cmd  ?? " + cmd);
		logger.info("roleName  ?? " + roleName);
		logger.info("transition Name  ?? " + tName);
		WorkflowInstance workflowInstance = null;
		try {
			workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			if (Validator.isNotNull(workflowInstance)) {
				logger.info("taskId :::::::::: " + workflowTaskId + "   ::: instance :: " + instanceId
						+ " :: assignedToMe :: " + assignedToMe);
				if (!assignedToMe) {
					logger.info("tName  is ?? "+tName);
					String statusKey = getStatusItemKey(tName);
					logger.info("statusKey  statusKey"+statusKey);
					long statusId = getStatusId(statusKey, themeDisplay.getCompanyId());
					logger.info("statusId                   statusId      1111111111111111111statusId"+statusId);
					appealUtil.saveAppealStatus(themeDisplay, roleName, comments, eqAppealId, statusId, 0);
					appealUtil.updateEquivalencyAppeal(themeDisplay, eqAppealId, statusId);
				}
				appealUtil.assignOrCompleteWorkflow(tName, cmd, themeDisplay, workflowInstance, workflowTaskId);
				
			}

		} catch (PortalException e) {
			logger.error("Exception in the AssignWorkflowTaskMVCRenderCommand "+e.getMessage(), e);
		}
	}

	private String getStatusItemKey(String tName) {
		logger.info("tName"+ tName);
		String key = "";
		if (AppealConstants.TRANSITION_NAME_RAISE.equalsIgnoreCase(tName)) {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_RAISED;
		} else if (AppealConstants.TRANSITION_NAME_INSUFFICIENT.equalsIgnoreCase(tName)) {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_REJECTED; // Changed the status to rejected on request of business.
		} 
		  else if (AppealConstants.TRANSITION_NAME_INITIATE.equalsIgnoreCase(tName)) {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_INITIATED;
		} else if (AppealConstants.TRANSITION_NAME_REJECT.equalsIgnoreCase(tName)) {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_REJECTED;
		} 
		else if (AppealConstants.TRANSITION_NAME_COMMITTEE_REJECT.equalsIgnoreCase(tName)) {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_REJECTED;
		}
		else {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_COMPLETED;
		}
		logger.info("Key  "+key);
		return key;
	}

	private long getStatusId(String statusKey, long companyId) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQ_APPEAL_STATUS,
				statusKey, companyId);
		if (Validator.isNotNull(entry)) {
			return entry.getListTypeEntryId();
		}
		return 0;
	}

	@Reference(unbind = "-")
	private AppealWrokflowUtil appealWrokflowUtil;

	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	private static final Log logger = LogFactoryUtil.getLog(AppealWFTaskMVCActionCommand.class);

}

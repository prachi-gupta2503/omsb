package omsb.vehpc.appeal.mvc.commands.action;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatus;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.AppealWrokflowUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=/appeal/workflow_action", }, service = MVCActionCommand.class)
public class AppealWFTaskMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("inside the AssignWorkflowTaskMVCActionCommand :::::::::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		logger.info("workflowTaskId    " + workflowTaskId);
		long instanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId");
		String comments = ParamUtil.getString(actionRequest, "comments");
		long eqAppealId = ParamUtil.getLong(actionRequest, "eqAppealId");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
		String tName = ParamUtil.getString(actionRequest, "transitionName");
		String tName1 = ParamUtil.getString(actionRequest, "transitionName1");
		long personId = ParamUtil.getLong(actionRequest, "personId");
		long equivalencyRequestId = ParamUtil.getLong(actionRequest, "equivalencyRequestId");
		String roleName = appealUtil.getAppealRoleName(themeDisplay.getUser().getRoles());
		String transition = StringPool.BLANK;
		if (Validator.isNotNull(tName1)) {
			transition = tName1;
		} else {
			transition = tName;
		}
		logger.info("eqAppeal Id ?? " + eqAppealId);
		logger.info("comments ?? " + comments);
		logger.info("cmd  ?? " + cmd);
		logger.info("roleName  ?? " + roleName);
		logger.info("transition Name  ?? " + transition);

		logger.info("transition Name1::::::::  ?? " + tName1);
		WorkflowInstance workflowInstance = null;
		try {
			workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			if (Validator.isNotNull(workflowInstance)) {
				logger.info("taskId :::::::::: " + workflowTaskId + "   ::: instance :: " + instanceId
						+ " :: assignedToMe :: " + assignedToMe);
				logger.info("tName  is ?? " + transition);
				String statusKey = getStatusItemKey(transition);
				logger.info("statusKey  statusKey" + statusKey);
				long statusId = getStatusId(statusKey, themeDisplay.getCompanyId());
				logger.info("statusId                   statusId      1111111111111111111statusId" + statusId);
				EquivalencyAppealStatus appealStatus = appealUtil.saveAppealStatus(themeDisplay, roleName, comments,
						eqAppealId, statusId, "", "", "", themeDisplay.getUserId());
				appealUtil.updateEquivalencyAppeal(themeDisplay, eqAppealId, statusId);
				appealUtil.assignOrCompleteWorkflow(transition, cmd, themeDisplay, workflowInstance, workflowTaskId);

				appealUtil.uploadDocuments(equivalencyRequestId, themeDisplay, actionRequest, personId, eqAppealId,
						appealStatus.getId(), "adminAdditionalAttachment",
						OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE);

			}

		} catch (PortalException e) {
			logger.error("Exception in the AssignWorkflowTaskMVCRenderCommand " + e.getMessage(), e);
		}
	}

	private String getStatusItemKey(String tName) {
		logger.info("tName" + tName);
		String key = "";
		if (AppealConstants.CREATED_KEY.equalsIgnoreCase(tName)) {
			key = AppealConstants.CREATED_KEY;
		} else if (AppealConstants.INSUFFICIENT_KEY.equalsIgnoreCase(tName)) {
			key = AppealConstants.INSUFFICIENT_KEY; // Changed the status to rejected on request of business.
		} else if (AppealConstants.INITIATED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.INITIATED_KEY;
		} else if (AppealConstants.EQUATED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.EQUATED_KEY;
		} else if (AppealConstants.COMPLETED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.COMPLETED_KEY;
		} else {
			key = AppealConstants.COMPLETED_KEY;
		}
		logger.info("Key  " + key);
		return key;
	}

	private long getStatusId(String statusKey, long companyId) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(AppealConstants.PL_Equivalency_Status,
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

package gov.omsb.registration.web.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;

@Component(immediate = true, 
			property = { 
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+MVCCommands.SAVE_ADMIN_ASSIGN_DECISION
			}, service = MVCActionCommand.class)
public class SaveAdminAssignDecisionMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		logger.info("SaveAdminAssignDecisionMVCActionCommand Invoke");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), ParamUtil.getLong(actionRequest, "workflowInstanceId"));
			if (Validator.isNotNull(workflowInstance)) {
				CustomWorkflowTaskUtil.assignWorkflowToUser(themeDisplay, workflowInstance, ParamUtil.getLong(actionRequest, "workflowTaskId"));
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
	}

	private static final Log logger = LogFactoryUtil.getLog(SaveAdminAssignDecisionMVCActionCommand.class);	
}

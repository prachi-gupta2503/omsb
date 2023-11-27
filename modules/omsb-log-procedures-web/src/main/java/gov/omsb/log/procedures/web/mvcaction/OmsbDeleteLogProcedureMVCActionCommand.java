package gov.omsb.log.procedures.web.mvcaction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresWebPortletKeys;
import gov.omsb.tms.service.TraineeLoggedProcedureDetailsLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
		"mvc.command.name="
				+ OmsbLogProceduresConstants.DELETE_LOG_PROCEDURE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteLogProcedureMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String tabName = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.TAB_NAME); 
		
		long traineeLoggedProcedureId = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.TRAINEE_LOGGED_PROCEDURE_DETAILS_ID);

		traineeLoggedProcedureDetailsLocalService.deleteTraineeLoggedProcedureDetails(traineeLoggedProcedureId);

		log.debug("-------Log Deleted Successfully--------");

		actionResponse.getRenderParameters().setValue("mvcPath", OmsbLogProceduresConstants.VIEW_PROCEDURES_JSP);

		actionRequest.setAttribute(OmsbLogProceduresConstants.TAB_NAME, tabName);
				
		setSucessesMessage(actionRequest, "log-procedure-deleted");

	}
	
	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}

	@Reference
	TraineeLoggedProcedureDetailsLocalService traineeLoggedProcedureDetailsLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbDeleteLogProcedureMVCActionCommand.class.getName());

}
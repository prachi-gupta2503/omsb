package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.service.PatientTypeProgDurationRelLocalService;
import gov.omsb.tms.service.RoleTypeProgDurationRelLocalService;
import gov.omsb.tms.service.VisitTypeProgDurationRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.DELETE_PROCEDURE_LOGGING_PARAMETERS_MVC_COMMAND_NAME }, service = MVCActionCommand.class)

public class OmsbDeleteProcedureLoggingParametersMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String masterName = ParamUtil.getString(actionRequest, OmsbSetupProceduresWebPortletKeys.MASTER_VALUE);
		if (OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME.equalsIgnoreCase(masterName)) {
			long roleTypeProgDurationRelId = ParamUtil.getLong(actionRequest,
					OmsbSetupProceduresWebPortletKeys.PROCEDURE_LOGGING_PARAMETER_ID, GetterUtil.DEFAULT_LONG);
			try {
				roleTypeProgDurationRelLocalService.deleteRoleTypeProgDurationRel(roleTypeProgDurationRelId);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_DELETE_SUCCESS);
			} catch (Exception e) {
				_logger.error(e);
				setErrorMessage(actionRequest, e.getLocalizedMessage());
			}
		} else if (OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME.equalsIgnoreCase(masterName)) {
			long patientTypeProgDurationRelId = ParamUtil.getLong(actionRequest,
					OmsbSetupProceduresWebPortletKeys.PROCEDURE_LOGGING_PARAMETER_ID, GetterUtil.DEFAULT_LONG);
			try {
				patientTypeProgDurationRelLocalService.deletePatientTypeProgDurationRel(patientTypeProgDurationRelId);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_DELETE_SUCCESS);
			} catch (Exception e) {
				_logger.error(e);
				setErrorMessage(actionRequest, e.getLocalizedMessage());
			}
		} else {
			long visitTypeProgDurationRelId = ParamUtil.getLong(actionRequest,
					OmsbSetupProceduresWebPortletKeys.PROCEDURE_LOGGING_PARAMETER_ID, GetterUtil.DEFAULT_LONG);
			try {
				visitTypeProgDurationRelLocalService.deleteVisitTypeProgDurationRel(visitTypeProgDurationRelId);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_DELETE_SUCCESS);
			} catch (Exception e) {
				_logger.error(e);
				setErrorMessage(actionRequest, e.getLocalizedMessage());
			}
		}

		actionRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.MASTER_VALUE, masterName);
		_logger.info("ProcessAction Exit ::: ");
	}

	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}

	@Reference
	private RoleTypeProgDurationRelLocalService roleTypeProgDurationRelLocalService;

	@Reference
	private VisitTypeProgDurationRelLocalService visitTypeProgDurationRelLocalService;

	@Reference
	private PatientTypeProgDurationRelLocalService patientTypeProgDurationRelLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbDeleteProcedureLoggingParametersMVCActionCommand.class.getName());

}

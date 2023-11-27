package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.service.ProgramMasterLocalService;

/**
 * @author Aditya Meghnathi
 */

@Component(property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=" + OmsbProgramConstants.DELETE_PROGRAM_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbDeleteProgramMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long programMasterId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.PROGRAM_MASTER_ID, 0l);

		if (programMasterId != 0) {
			try {
				programMasterLocalService.deleteProgramMaster(programMasterId);
				setSucessesMessage(actionRequest, OmsbProgramConstants.PROGRAM_DELETED_SUCCESS_MESSAGE);
			} catch (PortalException e) {
				_logger.error(e);
				setErrorMessage(actionRequest, e.getLocalizedMessage());
			}
		}
		return true;
	}
	
	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteProgramMVCActionCommand.class.getName());

}

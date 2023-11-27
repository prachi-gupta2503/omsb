package gov.omsb.procedure.groups.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.procedure.groups.web.constants.OmsbProcedureGroupsConstants;
import gov.omsb.procedure.groups.web.constants.OmsbProcedureGroupsWebPortletKeys;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;

/**
 * @author Aditya Meghnathi
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbProcedureGroupsWebPortletKeys.OMSBPROCEDUREGROUPSWEB, "mvc.command.name="
				+ OmsbProcedureGroupsConstants.SAVE_PROCEDURE_GROUPS_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbSaveProcedureGroupMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		long procedureGroupMasterId = ParamUtil.getLong(actionRequest,
				OmsbProcedureGroupsConstants.PROCEDURE_GROUP_MASTER_ID, 0);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if (procedureGroupMasterId != 0) {
				// Update Procedure group master
				isSuccess = procedureGroupMasterLocalService.updateProcedureGroupMaster(actionRequest, procedureGroupMasterId, themeDisplay);
			} else {
				// Create Procedure group master
				isSuccess = procedureGroupMasterLocalService.createProcedureGroupMaster(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	@Reference
	private ProcedureGroupMasterLocalService procedureGroupMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveProcedureGroupMVCActionCommand.class.getName());
}

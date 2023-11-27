package gov.omsb.procedure.groups.web.portlet.mvccommands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.procedure.groups.web.constants.OmsbProcedureGroupsConstants;
import gov.omsb.procedure.groups.web.constants.OmsbProcedureGroupsWebPortletKeys;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;

/**
 * @author Aditya Meghnathi
 */

@Component(property = { "javax.portlet.name=" + OmsbProcedureGroupsWebPortletKeys.OMSBPROCEDUREGROUPSWEB,
		"mvc.command.name="
				+ OmsbProcedureGroupsConstants.DELETE_PROCEDURE_GROUPS_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbDeleteProcedureGroupMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.info("doProcessAction Invoked ::: ");
		long procedureGroupMasterId = ParamUtil.getLong(actionRequest,
				OmsbProcedureGroupsConstants.PROCEDURE_GROUP_MASTER_ID, GetterUtil.DEFAULT_LONG);
		procedureGroupMasterLocalService.deleteProcedureGroupMaster(procedureGroupMasterId);
		_logger.debug("doProcessAction ::: Procedure Group Master Record Deleted");
		_logger.info("doProcessAction Exit ::: ");
	}

	@Reference
	private ProcedureGroupMasterLocalService procedureGroupMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteProcedureGroupMVCActionCommand.class.getName());
}

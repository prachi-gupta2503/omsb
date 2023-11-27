package gov.omsb.assign.procedure.web.mvcaction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.assign.procedure.web.constants.OmsbAssignProcedureConstants;
import gov.omsb.assign.procedure.web.constants.OmsbAssignProcedureWebPortletKeys;
import gov.omsb.tms.service.ProcedureGroupProceduresCPTCodeRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbAssignProcedureWebPortletKeys.OMSBASSIGNPROCEDUREWEB, "mvc.command.name="
				+ OmsbAssignProcedureConstants.DELETE_ASSIGN_PROCEDURE_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbDeleteAssignProceduresMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long pgProcedureCptCodeRelId = ParamUtil.getLong(actionRequest,
				OmsbAssignProcedureConstants.PG_PROCEDURES_CPT_REL_ID);

		procedureGroupProceduresCPTCodeRelLocalService
				.deleteProcedureGroupProceduresCPTCodeRel(pgProcedureCptCodeRelId);

		log.debug("------RECORD DELETED SUCCESSFULLY------");

	}

	@Reference
	private ProcedureGroupProceduresCPTCodeRelLocalService procedureGroupProceduresCPTCodeRelLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbDeleteAssignProceduresMVCActionCommand.class.getName());

}
package gov.omsb.assign.procedure.web.mvcaction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.assign.procedure.web.constants.OmsbAssignProcedureConstants;
import gov.omsb.assign.procedure.web.constants.OmsbAssignProcedureWebPortletKeys;
import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel;
import gov.omsb.tms.service.ProcedureGroupProceduresCPTCodeRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbAssignProcedureWebPortletKeys.OMSBASSIGNPROCEDUREWEB, "mvc.command.name="
				+ OmsbAssignProcedureConstants.EDIT_ASSIGN_PROCEDURE_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbUpdateAssignProcedureMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long pgProcedureCPTCodeRelId = ParamUtil.getLong(actionRequest,
				OmsbAssignProcedureConstants.PG_PROCEDURES_CPT_REL_ID);
		long procedureGroupId = ParamUtil.getLong(actionRequest, OmsbAssignProcedureConstants.PROCEDURE_GROUP_NAMES);
		long procedureId = ParamUtil.getLong(actionRequest, OmsbAssignProcedureConstants.PROCEDURE_NAMES);
		long cptCodeId = ParamUtil.getLong(actionRequest, OmsbAssignProcedureConstants.CPT_CODE_NAMES);

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel = procedureGroupProceduresCPTCodeRelLocalService
				.getProcedureGroupProceduresCPTCodeRel(pgProcedureCPTCodeRelId);

		procedureGroupProceduresCPTCodeRel.setModifiedBy(themeDisplay.getUserId());
		procedureGroupProceduresCPTCodeRel.setModifiedDate(new Date());
		procedureGroupProceduresCPTCodeRel.setProcedureGroupId(procedureGroupId);
		procedureGroupProceduresCPTCodeRel.setProcedureId(procedureId);
		procedureGroupProceduresCPTCodeRel.setCptCodeId(cptCodeId);

		procedureGroupProceduresCPTCodeRelLocalService
				.updateProcedureGroupProceduresCPTCodeRel(procedureGroupProceduresCPTCodeRel);

		log.debug("------RECORD UPDATED SUCCESSFULLY------");

	}

	@Reference
	private ProcedureGroupProceduresCPTCodeRelLocalService procedureGroupProceduresCPTCodeRelLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbAddAssignProceduresMVCActionCommand.class.getName());

}
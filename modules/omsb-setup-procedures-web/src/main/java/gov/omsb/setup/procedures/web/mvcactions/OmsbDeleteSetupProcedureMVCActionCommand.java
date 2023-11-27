package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.ProcedurePgProgdurationRel;
import gov.omsb.tms.model.ProceduregroupProgdurationRel;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.service.ProcedurePgProgdurationRelLocalService;
import gov.omsb.tms.service.ProceduregroupProgdurationRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.DELETE_SETUP_PROCEDURE_MVC_COMMAND_NAME }, service = MVCActionCommand.class)

public class OmsbDeleteSetupProcedureMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.info("ProcessAction Invoked ::: ");

		String masterName = ParamUtil.getString(actionRequest, OmsbSetupProceduresWebPortletKeys.MASTER_VALUE);
		long progdurationRotationTlPgProcedurePtRelId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PROGDURATION_TS_ROTATION_TL_PG_PROCEDURE_PT_REL_ID,
				GetterUtil.DEFAULT_LONG);
		try {
			ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel = progdurationRotationTlPgProcedurePtRelLocalService
					.getProgdurationRotationTlPgProcedurePtRel(progdurationRotationTlPgProcedurePtRelId);

			if (progdurationRotationTlPgProcedurePtRelLocalService
					.findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
							progdurationRotationTlPgProcedurePtRel.getProgramDurationId(),
							progdurationRotationTlPgProcedurePtRel.getProcedureGroupId(),
							progdurationRotationTlPgProcedurePtRel.getProcedureId()).size() == 1) {
				deleteProcedureAndProcedureGroupRelation(progdurationRotationTlPgProcedurePtRel.getProgramDurationId(),
						progdurationRotationTlPgProcedurePtRel.getProcedureGroupId(),
						progdurationRotationTlPgProcedurePtRel.getProcedureId());
			}

			progdurationRotationTlPgProcedurePtRelLocalService
					.deleteProgdurationRotationTlPgProcedurePtRel(progdurationRotationTlPgProcedurePtRelId);

			setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.CONFIGURE_PROCEDURE_DELETE_SUCCESS);
			_logger.debug("ProcessAction ::: Setup Procedure Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}

		actionRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.MASTER_VALUE, masterName);

		_logger.info("ProcessAction Exit ::: ");
	}

	private void deleteProcedureAndProcedureGroupRelation(long programDurationId, long procedureGroupId,
			long procedureId) {
		ProceduregroupProgdurationRel proceduregroupProgdurationRel = proceduregroupProgdurationRelLocalService
				.findByProgramDurationIdAndProcedureGroupMasterId(programDurationId, procedureGroupId);
		ProcedurePgProgdurationRel procedurePgProgdurationRel = procedurePgProgdurationRelLocalService
				.findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(programDurationId,
						procedureGroupId, procedureId);

		if (Validator.isNotNull(proceduregroupProgdurationRel)) {
			proceduregroupProgdurationRelLocalService
					.deleteProceduregroupProgdurationRel(proceduregroupProgdurationRel);
			_logger.info("proceduregroupProgdurationRel deleted ::: ");
		}

		if (Validator.isNotNull(procedurePgProgdurationRel)) {
			procedurePgProgdurationRelLocalService.deleteProcedurePgProgdurationRel(procedurePgProgdurationRel);
			_logger.info("procedurePgProgdurationRel deleted ::: ");
		}

	}

	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}

	@Reference
	private ProgdurationRotationTlPgProcedurePtRelLocalService progdurationRotationTlPgProcedurePtRelLocalService;

	@Reference
	private ProceduregroupProgdurationRelLocalService proceduregroupProgdurationRelLocalService;

	@Reference
	private ProcedurePgProgdurationRelLocalService procedurePgProgdurationRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteSetupProcedureMVCActionCommand.class.getName());
}

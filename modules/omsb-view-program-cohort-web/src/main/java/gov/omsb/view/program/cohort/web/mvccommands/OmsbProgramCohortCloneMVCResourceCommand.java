package gov.omsb.view.program.cohort.web.mvccommands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.PatientTypeProgDurationRel;
import gov.omsb.tms.model.ProcedurePgProgdurationRel;
import gov.omsb.tms.model.ProceduregroupProgdurationRel;
import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;
import gov.omsb.tms.model.ProgdurationObjectivesRel;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.RoleTypeProgDurationRel;
import gov.omsb.tms.model.VisitTypeProgDurationRel;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.view.program.cohort.web.constants.OmsbViewProgramCohortWebPortletKeys;
import gov.omsb.view.program.cohort.web.util.OmsbViewProgramCloneCohortUtil;
import gov.omsb.view.program.cohort.web.util.OmsbViewProgramRollbackCloneCohortUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbViewProgramCohortWebPortletKeys.OMSBVIEWPROGRAMCOHORTWEB,
"mvc.command.name=/clone/programcohort"}, service = MVCResourceCommand.class)
public class OmsbProgramCohortCloneMVCResourceCommand extends BaseMVCResourceCommand  {
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
	_logger.info("resourceRequest Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isSuccess = true;
		
		long newProgramMasterId = ParamUtil.getLong(resourceRequest, "newProgramMasterId", 0);
		long oldProgramDurationId = ParamUtil.getLong(resourceRequest, "oldProgramDurationId", 0);
		String cohort = ParamUtil.getString(resourceRequest, OmsbTmsCommonConstants.COHORT, StringPool.BLANK);
		
		boolean isExistCohort = viewProgramCloneCohortUtil.checkDuplicateCohort(newProgramMasterId, cohort);
		_logger.debug("resourceRequest ::: isExistCohort ::: " + isExistCohort);
		String error = StringPool.BLANK;
		if(isExistCohort) {
			error = OmsbViewProgramCohortWebPortletKeys.COHORT_ALREADY_EXIST_ERROR;
			isSuccess = false;
		} else {
			ProgramDurationDetails lastProgramDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(oldProgramDurationId);
			
			if(Validator.isNotNull(lastProgramDurationDetails)) {
				isSuccess = cloneCohort(newProgramMasterId, cohort, lastProgramDurationDetails, themeDisplay);
			} else {
				error = OmsbViewProgramCohortWebPortletKeys.NO_COHORT_EXIST_ERROR;
				isSuccess = false;
			}
		}
		
		_logger.debug("resourceRequest ::: programMasterId ::: " + newProgramMasterId);
		_logger.debug("resourceRequest ::: cohort ::: " + cohort);
		
		JSONObject resultJson = prepareJsonResponse(isSuccess, error);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		
		_logger.info("resourceRequest Exit ::: ");
	}
	
	public JSONObject prepareJsonResponse(boolean isSuccess, String error) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put(CommonConstants.SUCCESS, isSuccess);
		
		if(!isSuccess) {
			resultJson.put(CommonConstants.ERROR, error);
		}
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	private boolean cloneCohort(long programMasterId, String cohort, ProgramDurationDetails lastProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("cloneCohort  Invoked");
		boolean isSuccessfull = true;
		
		ProgramDurationDetails newProgramDurationDetails = null;
		List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels = null;
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = null;
		List<ProgdurationRotationTraineelevelBlocksRel> progdurationRotationTraineelevelBlocksRels = null;
		List<ProgdurationObjectivesRel> progdurationObjectivesRels = null;
		List<ProgdurationCompetenciesRequirementsRel> progdurationCompetenciesRequirementsRels = null;
		List<RoleTypeProgDurationRel> roleTypeProgDurationRels = null;
		List<PatientTypeProgDurationRel> patientTypeProgDurationRels = null;
		List<VisitTypeProgDurationRel> visitTypeProgDurationRels = null;
		List<ProcedurePgProgdurationRel> procedurePgProgdurationRels = null;
		List<ProceduregroupProgdurationRel> proceduregroupProgdurationRels = null;
		List<ProgdurationRotationTlPgProcedurePtRel> progdurationRotationTlPgProcedurePtRels = null;
		
		try {
			
			// Clone Cohort in Program Duration
			newProgramDurationDetails = viewProgramCloneCohortUtil.cloneProgramDuration(programMasterId, cohort, lastProgramDurationDetails);
			
			// Clone ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRels = viewProgramCloneCohortUtil.cloneProgDurationTraineeLevelBlocksLevelTypes(lastProgramDurationDetails, newProgramDurationDetails);
			_logger.debug("cloneCohort ::: total progdurationTraineelevelBlocksLevelTypeRels : " + progdurationTraineelevelBlocksLevelTypeRels.size());
			
			// Clone progduration_rotation_traineelevel_blocks_rel
			progdurationRotationTrainingsitesRels =  viewProgramCloneCohortUtil.cloneProgdurationRotationTrainingsitesRels(lastProgramDurationDetails, newProgramDurationDetails, themeDisplay);
			_logger.debug("cloneCohort ::: total progdurationRotationTrainingsitesRels : " + progdurationRotationTrainingsitesRels.size());
			
			// Clone progduration_rotation_trainingsites_rel
			progdurationRotationTraineelevelBlocksRels = viewProgramCloneCohortUtil.cloneProgdurationRotationTraineelevelBlocksRels(lastProgramDurationDetails, newProgramDurationDetails, themeDisplay);
			_logger.debug("cloneCohort ::: total progdurationRotationTraineelevelBlocksRels : " + progdurationRotationTraineelevelBlocksRels.size());
			
			// Clone progduration_objectives_rel
			progdurationObjectivesRels = viewProgramCloneCohortUtil.cloneProgdurationObjectivesRels(lastProgramDurationDetails, newProgramDurationDetails);
			_logger.debug("cloneCohort ::: total progdurationObjectivesRels : " + progdurationObjectivesRels.size());
			
			// Clone progduration_competencies_requirements_rel
			progdurationCompetenciesRequirementsRels = viewProgramCloneCohortUtil.cloneProgdurationCompetenciesRequirementsRels(lastProgramDurationDetails, newProgramDurationDetails);
			_logger.debug("cloneCohort ::: total progdurationCompetenciesRequirementsRels : " + progdurationCompetenciesRequirementsRels.size());
			
			// Clone setup Log Procedures
			// Clone role_type_prog_duration_rel
			roleTypeProgDurationRels  = viewProgramCloneCohortUtil.cloneRoleTypeProgDurationRels(lastProgramDurationDetails, newProgramDurationDetails, themeDisplay);
			_logger.debug("cloneCohort ::: total roleTypeProgDurationRels : " + roleTypeProgDurationRels.size());
			
			// Clone patient_type_prog_duration_rel
			patientTypeProgDurationRels  = viewProgramCloneCohortUtil.clonePatientTypeProgDurationRels(lastProgramDurationDetails, newProgramDurationDetails, themeDisplay);
			_logger.debug("cloneCohort ::: total patientTypeProgDurationRels : " + patientTypeProgDurationRels.size());
			
			// Clone visit_type_prog_duration_rel
			visitTypeProgDurationRels  = viewProgramCloneCohortUtil.cloneVisitTypeProgDurationRels(lastProgramDurationDetails, newProgramDurationDetails, themeDisplay);
			_logger.debug("cloneCohort ::: total visitTypeProgDurationRels : " + visitTypeProgDurationRels.size());
			
			// Clone procedure_pg_progduration_rel
			procedurePgProgdurationRels  = viewProgramCloneCohortUtil.cloneProcedurePgProgdurationRels(lastProgramDurationDetails, newProgramDurationDetails, themeDisplay);
			_logger.debug("cloneCohort ::: total procedurePgProgdurationRels : " + procedurePgProgdurationRels.size());
			
			// Clone proceduregroup_progduration_rel
			proceduregroupProgdurationRels  = viewProgramCloneCohortUtil.cloneProceduregroupProgdurationRels(lastProgramDurationDetails, newProgramDurationDetails, themeDisplay);
			_logger.debug("cloneCohort ::: total proceduregroupProgdurationRels : " + proceduregroupProgdurationRels.size());
			
			// Clone progduration_rotation_tl_pg_procedure_pt_rel
			progdurationRotationTlPgProcedurePtRels = viewProgramCloneCohortUtil.cloneProgdurationRotationTlPgProcedurePtRels(lastProgramDurationDetails, newProgramDurationDetails, themeDisplay);
			_logger.debug("cloneCohort ::: total progdurationRotationTlPgProcedurePtRels : " + progdurationRotationTlPgProcedurePtRels.size());
			
			// Create Blocks in blocks_metadata_details_rel
			boolean isBlocksCreated = viewProgramCloneCohortUtil.createBlocks(newProgramDurationDetails.getProgDurationId(), themeDisplay);
			
			if(isBlocksCreated && Validator.isNotNull(newProgramDurationDetails) && Validator.isNotNull(progdurationTraineelevelBlocksLevelTypeRels)) {
				isSuccessfull = true;
			} else {
				isSuccessfull = false;
			}
			
		} catch (Exception e) {
			isSuccessfull = false;
			_logger.error("Error while cloning cohort, Rolling back all changes");

			viewProgramRollbackCloneCohortUtil.rollbackPatientTypeProgDurationRelsClone(patientTypeProgDurationRels);
			viewProgramRollbackCloneCohortUtil.rollbackProceduregroupProgdurationRelClone(proceduregroupProgdurationRels);
			viewProgramRollbackCloneCohortUtil.rollbackProcedurePgProgdurationRelClone(procedurePgProgdurationRels);
			viewProgramRollbackCloneCohortUtil.rollbackProgdurationCompetenciesRequirementsRelsClone(progdurationCompetenciesRequirementsRels);
			viewProgramRollbackCloneCohortUtil.rollbackProgdurationObjectivesRelsClone(progdurationObjectivesRels);
			viewProgramRollbackCloneCohortUtil.rollbackProgdurationRotationTlPgProcedurePtRelsClone(progdurationRotationTlPgProcedurePtRels);
			viewProgramRollbackCloneCohortUtil.rollbackProgdurationRotationTraineelevelBlocksRelsClone(progdurationRotationTraineelevelBlocksRels);
			viewProgramRollbackCloneCohortUtil.rollbackProgdurationRotationTrainingsitesRelsClone(progdurationRotationTrainingsitesRels);
			viewProgramRollbackCloneCohortUtil.rollbackProgdurationTraineelevelBlocksLevelTypeRelsClone(progdurationTraineelevelBlocksLevelTypeRels);
			viewProgramRollbackCloneCohortUtil.rollbackProgramDurationDetailsClone(newProgramDurationDetails);
			viewProgramRollbackCloneCohortUtil.rollbackRoleTypeProgDurationRelsClone(roleTypeProgDurationRels);
			viewProgramRollbackCloneCohortUtil.rollbackVisitTypeProgDurationRelsClone(visitTypeProgDurationRels);
			viewProgramRollbackCloneCohortUtil.rollbackCreatedBlocks(newProgramDurationDetails);
		}
		_logger.info("cloneCohort  Exit");
		
		
		return isSuccessfull;
	}
	
	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	OmsbViewProgramCloneCohortUtil viewProgramCloneCohortUtil;
	
	@Reference
	OmsbViewProgramRollbackCloneCohortUtil viewProgramRollbackCloneCohortUtil;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramCohortCloneMVCResourceCommand.class.getName());

}

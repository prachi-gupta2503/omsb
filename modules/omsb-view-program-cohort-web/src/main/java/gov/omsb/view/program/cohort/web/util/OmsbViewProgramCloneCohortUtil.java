package gov.omsb.view.program.cohort.web.util;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
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
import gov.omsb.tms.service.BlockWeekMetadataDetailsRelLocalService;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.PatientTypeProgDurationRelLocalService;
import gov.omsb.tms.service.ProcedurePgProgdurationRelLocalService;
import gov.omsb.tms.service.ProceduregroupProgdurationRelLocalService;
import gov.omsb.tms.service.ProgdurationCompetenciesRequirementsRelLocalService;
import gov.omsb.tms.service.ProgdurationObjectivesRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.RoleTypeProgDurationRelLocalService;
import gov.omsb.tms.service.VisitTypeProgDurationRelLocalService;

/**
 * @author Jayesh Goswami
 */

@Component(immediate = true, service = OmsbViewProgramCloneCohortUtil.class)
public class OmsbViewProgramCloneCohortUtil {


	public ProgramDurationDetails cloneProgramDuration(long programMasterId, String cohort, ProgramDurationDetails lastProgramDurationDetails) {
		_logger.info("cloneProgramDuration Invoked");
		long programDurationId = counterLocalService.increment(ProgramDurationDetails.class.getName());
		ProgramDurationDetails details = programDurationDetailsLocalService.createProgramDurationDetails(programDurationId);
		details.setAyApplicableForm(cohort);
		details.setProgramId(programMasterId);
		details.setGroupId(lastProgramDurationDetails.getGroupId());
		details.setCompanyId(lastProgramDurationDetails.getCompanyId());
		details.setNoOfBlocks(lastProgramDurationDetails.getNoOfBlocks());
		programDurationDetailsLocalService.addProgramDurationDetails(details);
		_logger.info("cloneProgramDuration Exit");
		return details;
	}
	
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> cloneProgDurationTraineeLevelBlocksLevelTypes(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails) {
		_logger.info("cloneProgDurationTraineeLevelBlocksLevelTypes Invoked");
		List<ProgdurationTraineelevelBlocksLevelTypeRel> newBlocksLevelTypeRels = new ArrayList<>();
		List<ProgdurationTraineelevelBlocksLevelTypeRel> blocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(lastProgramDurationDetails.getProgDurationId());
		for(ProgdurationTraineelevelBlocksLevelTypeRel blocksLevelTypeRel : blocksLevelTypeRels) {
			long progdurationTraineelevelBlocksLevelTypeRelId = counterLocalService.increment(ProgdurationTraineelevelBlocksLevelTypeRel.class.getName());
			ProgdurationTraineelevelBlocksLevelTypeRel levelTypeRel  = progdurationTraineelevelBlocksLevelTypeRelLocalService.createProgdurationTraineelevelBlocksLevelTypeRel(progdurationTraineelevelBlocksLevelTypeRelId);
			levelTypeRel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			levelTypeRel.setLevelTypeId(blocksLevelTypeRel.getLevelTypeId());
			levelTypeRel.setTraineeLevelId(blocksLevelTypeRel.getTraineeLevelId());
			levelTypeRel.setGroupId(blocksLevelTypeRel.getGroupId());
			levelTypeRel.setCompanyId(blocksLevelTypeRel.getCompanyId());
			levelTypeRel.setNoOfBlocks(blocksLevelTypeRel.getNoOfBlocks());
			newBlocksLevelTypeRels.add(progdurationTraineelevelBlocksLevelTypeRelLocalService.addProgdurationTraineelevelBlocksLevelTypeRel(levelTypeRel));
		}
		_logger.info("cloneProgDurationTraineeLevelBlocksLevelTypes Exit");
		return newBlocksLevelTypeRels;
	}
	
	public List<ProgdurationRotationTrainingsitesRel> cloneProgdurationRotationTrainingsitesRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("cloneProgdurationRotationTrainingsitesRels Invoked");
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = new ArrayList<>();
		List<ProgdurationRotationTrainingsitesRel>  existingProgdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRelLocalService.findByProgramDurationId(lastProgramDurationDetails.getProgDurationId());
	
		for(ProgdurationRotationTrainingsitesRel rel : existingProgdurationRotationTrainingsitesRels) {
			long progdurationRotationTrainingsitesRelId = counterLocalService.increment(ProgdurationRotationTrainingsitesRel.class.getName());
			ProgdurationRotationTrainingsitesRel rotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService.createProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRelId);
			rotationTrainingsitesRel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			rotationTrainingsitesRel.setRotationId(rel.getRotationId());
			rotationTrainingsitesRel.setTrainingSitesId(rel.getTrainingSitesId());
			rotationTrainingsitesRel.setGroupId(rel.getGroupId());
			rotationTrainingsitesRel.setCompanyId(rel.getCompanyId());
			rotationTrainingsitesRel.setCreatedBy(themeDisplay.getUserId());
			rotationTrainingsitesRel.setModifiedBy(themeDisplay.getUserId()); 
			rotationTrainingsitesRel.setIsSharedRotation(rel.getIsSharedRotation());
			rotationTrainingsitesRel.setRotationOwningProgramId(rel.getRotationOwningProgramId());
			rotationTrainingsitesRel.setProgCodeRsnSiteCode(rel.getProgCodeRsnSiteCode());
			rotationTrainingsitesRel.setNoOfSlots(rel.getNoOfSlots());
			progdurationRotationTrainingsitesRels.add(progdurationRotationTrainingsitesRelLocalService.addProgdurationRotationTrainingsitesRel(rotationTrainingsitesRel));
		}
		_logger.info("cloneProgdurationRotationTrainingsitesRels Exit");
		return progdurationRotationTrainingsitesRels;
	}
	
	public List<ProgdurationRotationTraineelevelBlocksRel> cloneProgdurationRotationTraineelevelBlocksRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("cloneProgdurationRotationTraineelevelBlocksRels Invoked");
		List<ProgdurationRotationTraineelevelBlocksRel> progdurationRotationTraineelevelBlocksRels = new ArrayList<>();
		List<ProgdurationRotationTraineelevelBlocksRel>  blocksRels = progdurationRotationTraineelevelBlocksRelLocalService.findTraineeLevelByDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(ProgdurationRotationTraineelevelBlocksRel blocksRel : blocksRels) {
			long progdurationRotationTlBlocksRelId = counterLocalService.increment(ProgdurationRotationTraineelevelBlocksRel.class.getName());
			ProgdurationRotationTraineelevelBlocksRel rel = progdurationRotationTraineelevelBlocksRelLocalService.createProgdurationRotationTraineelevelBlocksRel(progdurationRotationTlBlocksRelId);
			rel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			rel.setRotationId(blocksRel.getRotationId());
			rel.setRotationType(blocksRel.getRotationType());
			rel.setTraineeLevelId(blocksRel.getTraineeLevelId());
			rel.setGroupId(blocksRel.getGroupId());
			rel.setCompanyId(blocksRel.getCompanyId());
			rel.setCreatedBy(themeDisplay.getUserId());
			rel.setModifiedBy(themeDisplay.getUserId());
			rel.setNoOfBlocks(blocksRel.getNoOfBlocks());
			progdurationRotationTraineelevelBlocksRels.add(progdurationRotationTraineelevelBlocksRelLocalService.addProgdurationRotationTraineelevelBlocksRel(rel));
		}
		_logger.info("cloneProgdurationRotationTraineelevelBlocksRels Exit");
		return progdurationRotationTraineelevelBlocksRels;
	}
	
	public List<ProgdurationObjectivesRel> cloneProgdurationObjectivesRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails) {
		_logger.info("cloneProgdurationObjectivesRels  Invoked");		
		List<ProgdurationObjectivesRel> progdurationObjectivesRels = new ArrayList<>();
		List<ProgdurationObjectivesRel> objectivesRels = progdurationObjectivesRelLocalService.findByProgDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(ProgdurationObjectivesRel objectivesRel : objectivesRels) {
			ProgdurationObjectivesRel rel = progdurationObjectivesRelLocalService.addProgdurationObjectivesRel(objectivesRel.getGroupId(), objectivesRel.getCompanyId(), newProgramDurationDetails.getProgDurationId(), objectivesRel.getObjectives());
			progdurationObjectivesRels.add(rel);
		}
		_logger.info("cloneProgdurationObjectivesRels  Exit");		
		return progdurationObjectivesRels;
	}
	
	public List<ProgdurationCompetenciesRequirementsRel> cloneProgdurationCompetenciesRequirementsRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails) {
		_logger.info("cloneProgdurationCompetenciesRequirementsRels Invoked");		
		List<ProgdurationCompetenciesRequirementsRel> progdurationCompetenciesRequirementsRels = new ArrayList<>();
		List<ProgdurationCompetenciesRequirementsRel> competenciesRequirementsRels = progdurationCompetenciesRequirementsRelLocalService.getByProgDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(ProgdurationCompetenciesRequirementsRel competenciesRequirementsRel : competenciesRequirementsRels) {
			ProgdurationCompetenciesRequirementsRel rel = progdurationCompetenciesRequirementsRelLocalService.addProgdurationCompetenciesRequirementsRel(competenciesRequirementsRel.getGroupId(), competenciesRequirementsRel.getCompanyId(), newProgramDurationDetails.getProgDurationId(), competenciesRequirementsRel.getCompetenciesMasterId(), competenciesRequirementsRel.getRequirements());
			progdurationCompetenciesRequirementsRels.add(rel);
		}
		_logger.info("cloneProgdurationCompetenciesRequirementsRels Exit");		
		return progdurationCompetenciesRequirementsRels;
	}
	
	public List<RoleTypeProgDurationRel> cloneRoleTypeProgDurationRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("cloneRoleTypeProgDurationRels Invoked");		
		List<RoleTypeProgDurationRel> roleTypeProgDurationRels = new ArrayList<>();
		List<RoleTypeProgDurationRel> existingRoleTypeProgDurationRels = roleTypeProgDurationRelLocalService.findByProgramDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(RoleTypeProgDurationRel roleTypeProgDurationRel : existingRoleTypeProgDurationRels) {
			long roleTypeProgDurationRelId = counterLocalService.increment(RoleTypeProgDurationRel.class.getName());
			RoleTypeProgDurationRel rel = roleTypeProgDurationRelLocalService.createRoleTypeProgDurationRel(roleTypeProgDurationRelId);
			rel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			rel.setRoleTypeMasterId(roleTypeProgDurationRel.getRoleTypeMasterId());
			rel.setGroupId(roleTypeProgDurationRel.getGroupId());
			rel.setCompanyId(roleTypeProgDurationRel.getCompanyId());
			rel.setCreatedBy(themeDisplay.getUserId());
			rel.setModifiedBy(themeDisplay.getUserId());
			rel = roleTypeProgDurationRelLocalService.addRoleTypeProgDurationRel(rel);
			roleTypeProgDurationRels.add(rel);
		}
		
		_logger.info("cloneRoleTypeProgDurationRels Exit");		
		return roleTypeProgDurationRels;
	}
	
	public List<PatientTypeProgDurationRel> clonePatientTypeProgDurationRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("clonePatientTypeProgDurationRels Invoked");		
		List<PatientTypeProgDurationRel> patientTypeProgDurationRels = new ArrayList<>();
		List<PatientTypeProgDurationRel> existingPatientTypeProgDurationRels = patientTypeProgDurationRelLocalService.findByProgramDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(PatientTypeProgDurationRel patientTypeProgDurationRel : existingPatientTypeProgDurationRels) {
			long patientTypeProgDurationRelId = counterLocalService.increment(PatientTypeProgDurationRel.class.getName());
			PatientTypeProgDurationRel rel = patientTypeProgDurationRelLocalService.createPatientTypeProgDurationRel(patientTypeProgDurationRelId);
			rel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			rel.setPatientTypeMasterId(patientTypeProgDurationRel.getPatientTypeMasterId());
			rel.setGroupId(patientTypeProgDurationRel.getGroupId());
			rel.setCompanyId(patientTypeProgDurationRel.getCompanyId());
			rel.setCreatedBy(themeDisplay.getUserId());
			rel.setModifiedBy(themeDisplay.getUserId());
			rel = patientTypeProgDurationRelLocalService.addPatientTypeProgDurationRel(rel);
			patientTypeProgDurationRels.add(rel);
		}
		
		_logger.info("clonePatientTypeProgDurationRels Exit");		
		return patientTypeProgDurationRels;
	}
	
	public List<VisitTypeProgDurationRel> cloneVisitTypeProgDurationRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("cloneVisitTypeProgDurationRels Invoked");		
		List<VisitTypeProgDurationRel> visitTypeProgDurationRels = new ArrayList<>();
		List<VisitTypeProgDurationRel> existingVisitTypeProgDurationRels = visitTypeProgDurationRelLocalService.findByProgramDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(VisitTypeProgDurationRel visitTypeProgDurationRel : existingVisitTypeProgDurationRels) {
			long visitTypeProgDurationRelId = counterLocalService.increment(PatientTypeProgDurationRel.class.getName());
			VisitTypeProgDurationRel rel = visitTypeProgDurationRelLocalService.createVisitTypeProgDurationRel(visitTypeProgDurationRelId);
			rel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			rel.setVisitTypeMasterId(visitTypeProgDurationRel.getVisitTypeMasterId());
			rel.setGroupId(visitTypeProgDurationRel.getGroupId());
			rel.setCompanyId(visitTypeProgDurationRel.getCompanyId());
			rel.setCreatedBy(themeDisplay.getUserId());
			rel.setModifiedBy(themeDisplay.getUserId());
			rel = visitTypeProgDurationRelLocalService.addVisitTypeProgDurationRel(rel);
			visitTypeProgDurationRels.add(rel);
		}
		
		_logger.info("cloneVisitTypeProgDurationRels Exit");		
		return visitTypeProgDurationRels;
	}
	
	public List<ProcedurePgProgdurationRel> cloneProcedurePgProgdurationRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("cloneProcedurePgProgdurationRels Invoked");		
		List<ProcedurePgProgdurationRel> procedurePgProgdurationRels = new ArrayList<>();
		List<ProcedurePgProgdurationRel> existingProcedurePgProgdurationRels = procedurePgProgdurationRelLocalService.findByProgramDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(ProcedurePgProgdurationRel procedurePgProgdurationRel : existingProcedurePgProgdurationRels) {
			long procedurePgProgdurationRelId = counterLocalService.increment(ProcedurePgProgdurationRel.class.getName());
			ProcedurePgProgdurationRel rel = procedurePgProgdurationRelLocalService.createProcedurePgProgdurationRel(procedurePgProgdurationRelId);
			rel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			rel.setProcedureGroupMasterId(procedurePgProgdurationRel.getProcedureGroupMasterId());
			rel.setProcedureMasterId(procedurePgProgdurationRel.getProcedureMasterId());
			rel.setGroupId(procedurePgProgdurationRel.getGroupId());
			rel.setCompanyId(procedurePgProgdurationRel.getCompanyId());
			rel.setCreatedBy(themeDisplay.getUserId());
			rel.setModifiedBy(themeDisplay.getUserId());
			rel = procedurePgProgdurationRelLocalService.addProcedurePgProgdurationRel(rel);
			procedurePgProgdurationRels.add(rel);
		}
		
		_logger.info("cloneProcedurePgProgdurationRels Exit");		
		return procedurePgProgdurationRels;
	}

	public List<ProceduregroupProgdurationRel> cloneProceduregroupProgdurationRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("cloneProceduregroupProgdurationRels Invoked");		
		List<ProceduregroupProgdurationRel> proceduregroupProgdurationRels = new ArrayList<>();
		List<ProceduregroupProgdurationRel> existingProcedurePgProgdurationRels = proceduregroupProgdurationRelLocalService.findByProgramDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(ProceduregroupProgdurationRel proceduregroupProgdurationRel : existingProcedurePgProgdurationRels) {
			long proceduregroupProgdurationRelId = counterLocalService.increment(ProcedurePgProgdurationRel.class.getName());
			ProceduregroupProgdurationRel rel = proceduregroupProgdurationRelLocalService.createProceduregroupProgdurationRel(proceduregroupProgdurationRelId);
			rel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			rel.setProcedureGroupMasterId(proceduregroupProgdurationRel.getProcedureGroupMasterId());
			rel.setGroupId(proceduregroupProgdurationRel.getGroupId());
			rel.setCompanyId(proceduregroupProgdurationRel.getCompanyId());
			rel.setCreatedBy(themeDisplay.getUserId());
			rel.setModifiedBy(themeDisplay.getUserId());
			rel = proceduregroupProgdurationRelLocalService.addProceduregroupProgdurationRel(rel);
			proceduregroupProgdurationRels.add(rel);
		}
		
		_logger.info("cloneProceduregroupProgdurationRels Exit");		
		return proceduregroupProgdurationRels;
	} 
	
	public List<ProgdurationRotationTlPgProcedurePtRel> cloneProgdurationRotationTlPgProcedurePtRels(ProgramDurationDetails lastProgramDurationDetails, ProgramDurationDetails newProgramDurationDetails, ThemeDisplay themeDisplay) {
		_logger.info("cloneProgdurationRotationTlPgProcedurePtRels Invoked");		
		List<ProgdurationRotationTlPgProcedurePtRel> progdurationRotationTlPgProcedurePtRels = new ArrayList<>();
		List<ProgdurationRotationTlPgProcedurePtRel> existingProgdurationRotationTlPgProcedurePtRels = progdurationRotationTlPgProcedurePtRelLocalService.findByProgramDurationId(lastProgramDurationDetails.getProgDurationId());
		
		for(ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel : existingProgdurationRotationTlPgProcedurePtRels) {
			long progdurationRotationTlPgProcedurePtRelId = counterLocalService.increment(ProcedurePgProgdurationRel.class.getName());
			ProgdurationRotationTlPgProcedurePtRel rel = progdurationRotationTlPgProcedurePtRelLocalService.createProgdurationRotationTlPgProcedurePtRel(progdurationRotationTlPgProcedurePtRelId);
			rel.setProgramDurationId(newProgramDurationDetails.getProgDurationId());
			rel.setRotationId(progdurationRotationTlPgProcedurePtRel.getRotationId());
			rel.setTraineeLevelId(progdurationRotationTlPgProcedurePtRel.getTraineeLevelId());
			rel.setProcedureGroupId(progdurationRotationTlPgProcedurePtRel.getProcedureGroupId());
			rel.setProcedureId(progdurationRotationTlPgProcedurePtRel.getProcedureId());
			rel.setMinimumProcedures(progdurationRotationTlPgProcedurePtRel.getMinimumProcedures());
			rel.setTraineelevelMinimumProcedures(progdurationRotationTlPgProcedurePtRel.getTraineelevelMinimumProcedures());
			rel.setGroupId(progdurationRotationTlPgProcedurePtRel.getGroupId());
			rel.setCompanyId(progdurationRotationTlPgProcedurePtRel.getCompanyId());
			rel.setCreatedBy(themeDisplay.getUserId());
			rel.setModifiedBy(themeDisplay.getUserId());
			rel = progdurationRotationTlPgProcedurePtRelLocalService.addProgdurationRotationTlPgProcedurePtRel(rel);
			progdurationRotationTlPgProcedurePtRels.add(rel);
		}
		
		_logger.info("cloneProgdurationRotationTlPgProcedurePtRels Exit");		
		return progdurationRotationTlPgProcedurePtRels;
	}
	
	
	public boolean checkDuplicateCohort(long programMasterId, String cohort) {
		_logger.info("checkDuplicateCohort  Invoked");
		ProgramDurationDetails programDurationDetails = null;
		try {
			programDurationDetails = programDurationDetailsLocalService.findByProgramIdAndAYApplicableFrom(programMasterId, cohort);
		} catch (Exception e) {
			_logger.error("Program Duration Not Exist");
		}
		
		_logger.info("checkDuplicateCohort  Exit");
		return Validator.isNotNull(programDurationDetails);
	}

	/**
	 * Block Creations
	 */
	
	public boolean createBlocks(long programDurationId, ThemeDisplay themeDisplay) {
		_logger.debug("createBlocks Invoked ::: ");
		boolean isSuccess = false;
		try {
			ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(programDurationId);
			List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programDurationId);
			
			// Sort TraineeLevels
			progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRels.stream().sorted((o1, o2)-> Long.compare(o1.getTraineeLevelId(), o2.getTraineeLevelId())).collect(Collectors.toList());
			
			SimpleDateFormat formatter = new SimpleDateFormat(OmsbTmsCommonConstants.DATE_FORMAT_DD_MM_YYYY);
			long currentYear = Long.parseLong(programDurationDetails.getAyApplicableForm().split(StringPool.DASH)[0]);
			for(ProgdurationTraineelevelBlocksLevelTypeRel traineeLevelBlockLevelTypeRel : progdurationTraineelevelBlocksLevelTypeRels) {
				Date startDate = formatter.parse(OmsbTmsCommonConstants.YEAR_START_DATE_FOR_BLOCK + currentYear);
				currentYear++;
				createBlocksForTraineeLevel(startDate,traineeLevelBlockLevelTypeRel.getProgdurationTlBlocksLtId(), traineeLevelBlockLevelTypeRel.getNoOfBlocks(), themeDisplay);
				_logger.debug("createBlocks ::: Blocks Created for ProgdurationTraineelevelBlocksLevelTypeRel : " + traineeLevelBlockLevelTypeRel.getProgdurationTlBlocksLtId());
			}
			isSuccess = true;
			
		} catch (ParseException | PortalException e) {
			_logger.error("createBlocks " + e);
		}  
		
		_logger.debug("createBlocks Exit ::: ");
		return isSuccess;
	}

	@SuppressWarnings("deprecation")
	public Date createBlocksForTraineeLevel(Date startDate, long progDurationTlBlocksLtId, long noOfBlocks, ThemeDisplay themeDisplay) {
		_logger.info("createBlocksForTraineeLevel Invoked :::");
		Calendar startDateCal = Calendar.getInstance();
		startDateCal.setTime(startDate);
		BlocksMetadataDetailsRel blocksMetadataDetailsRel = null;
		for(long block = 1; block <= noOfBlocks; block++) {
			Calendar endDate = CommonUtil.nextSaturdayDateAfterAddingNoOfDays((Calendar)startDateCal.clone(), 28);
			BlocksMetadataDetailsRel detailsRel = null;
			detailsRel =  blocksMetadataDetailsRelLocalService.findByProgDurationTlBlocksLtIdAndBlockStartDate(progDurationTlBlocksLtId, startDateCal.getTime());
			
			if(Validator.isNotNull(detailsRel)) {
				try {
					blocksMetadataDetailsRel = blocksMetadataDetailsRelLocalService.updateBlockMetadataDetailsRel(detailsRel.getBlocksMetadataDetailsRelId(), OmsbTmsCommonConstants.BLOCK + StringPool.DASH + block, startDateCal.getTime(), endDate.getTime(), progDurationTlBlocksLtId,themeDisplay);
					if(Validator.isNotNull(blocksMetadataDetailsRel)) {
						_logger.debug("updateBlocksForTraineeLevel  ::: ProgDurationTlBlocksLtId : " + blocksMetadataDetailsRel.getProgDurationTlBlocksLtId());
					}
				} catch (Exception e) {
					_logger.error("updateBlocksForTraineeLevel ::: " + e);
				}
				_logger.debug("updateBlocksForTraineeLevel ::: Block Created for BlockMetadataDetailsRel : " + (OmsbTmsCommonConstants.BLOCK + StringPool.DASH + block) + startDate.getYear());
			} else {
				blocksMetadataDetailsRel = blocksMetadataDetailsRelLocalService.createBlockMetadataDetailsRel(OmsbTmsCommonConstants.BLOCK + StringPool.DASH + block, startDateCal.getTime(), endDate.getTime(), progDurationTlBlocksLtId,themeDisplay);
				
				if (Validator.isNotNull(blocksMetadataDetailsRel)) {
					createBlocksForWeeks(startDateCal, blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId(), endDate, themeDisplay);
				}

				_logger.debug("createBlocksForTraineeLevel ::: Block Created for BlockMetadataDetailsRel : " + (OmsbTmsCommonConstants.BLOCK + StringPool.DASH + block) + startDate.getYear());
			}

			endDate.add(Calendar.DAY_OF_MONTH,1);
	        startDateCal = endDate;
		}
		_logger.info("createBlocksForTraineeLevel Exit :::");
		return startDateCal.getTime();
	}
	
	private void createBlocksForWeeks(Calendar startDateCal, long blocksMetadataDetailsRelId, Calendar endDate, ThemeDisplay themeDisplay) {
		Calendar weekStartDateCal = startDateCal;
		for (int weekNo = 1; weekStartDateCal.before(endDate) || weekStartDateCal.equals(endDate); weekNo++) {
		    Calendar weekEndDateCal = CommonUtil.nextSaturdayDateAfterAddingNoOfDays((Calendar)weekStartDateCal.clone(), 7);

			blockWeekMetadataDetailsRelLocalService.createBlockWeekMetadataDetailsRel(blocksMetadataDetailsRelId, weekStartDateCal.getTime(), weekEndDateCal.getTime(), OmsbTmsCommonConstants.WEEK + StringPool.DASH + weekNo, themeDisplay.getUserId(), themeDisplay.getScopeGroupId());

		    weekEndDateCal.add(Calendar.DAY_OF_MONTH, 1);
		    weekStartDateCal = weekEndDateCal;
		}
	}

	@Reference
	public CounterLocalService counterLocalService;
	
	@Reference
	RoleTypeProgDurationRelLocalService roleTypeProgDurationRelLocalService;
	
	@Reference
	PatientTypeProgDurationRelLocalService patientTypeProgDurationRelLocalService;
	
	@Reference
	ProcedurePgProgdurationRelLocalService procedurePgProgdurationRelLocalService;
	
	@Reference
	VisitTypeProgDurationRelLocalService visitTypeProgDurationRelLocalService;
	
	@Reference
	ProceduregroupProgdurationRelLocalService proceduregroupProgdurationRelLocalService;
	
	@Reference
	ProgdurationRotationTlPgProcedurePtRelLocalService progdurationRotationTlPgProcedurePtRelLocalService;
	
	@Reference
	BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;
	
	@Reference
	ProgdurationCompetenciesRequirementsRelLocalService progdurationCompetenciesRequirementsRelLocalService;
	
	@Reference
	ProgdurationObjectivesRelLocalService progdurationObjectivesRelLocalService;
	
	@Reference
	ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	@Reference
	ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;
	
	@Reference
	ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	BlockWeekMetadataDetailsRelLocalService blockWeekMetadataDetailsRelLocalService;

	public static final Log _logger = LogFactoryUtil.getLog(OmsbViewProgramCloneCohortUtil.class.getName());
}

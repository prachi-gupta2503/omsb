package gov.omsb.view.program.cohort.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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

@Component(immediate = true, service = OmsbViewProgramRollbackCloneCohortUtil.class)
public class OmsbViewProgramRollbackCloneCohortUtil {

	public boolean rollbackProgdurationRotationTlPgProcedurePtRelsClone(List<ProgdurationRotationTlPgProcedurePtRel> progdurationRotationTlPgProcedurePtRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProgdurationRotationTlPgProcedurePtRelsClone Invoked :::");
		
		if(Validator.isNotNull(progdurationRotationTlPgProcedurePtRels) && !progdurationRotationTlPgProcedurePtRels.isEmpty()) {
			_logger.info("rollbackProgdurationRotationTlPgProcedurePtRelsClone Started :::");
			for(ProgdurationRotationTlPgProcedurePtRel rel : progdurationRotationTlPgProcedurePtRels) {
				try {
					progdurationRotationTlPgProcedurePtRelLocalService.deleteProgdurationRotationTlPgProcedurePtRel(rel.getProgdurationRotationTlPgProcedurePtRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting ProgdurationRotationTlPgProcedurePtRel " + e.getMessage());
				}
			}
			_logger.info("rollbackProgdurationRotationTlPgProcedurePtRelsClone Completed :::");
		}
		
		_logger.info("rollbackProgdurationRotationTlPgProcedurePtRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackProceduregroupProgdurationRelClone(List<ProceduregroupProgdurationRel> proceduregroupProgdurationRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProceduregroupProgdurationRelClone Invoked :::");
		
		if(Validator.isNotNull(proceduregroupProgdurationRels) && !proceduregroupProgdurationRels.isEmpty()) {
			_logger.info("rollbackProceduregroupProgdurationRelClone Started :::");
			for(ProceduregroupProgdurationRel rel : proceduregroupProgdurationRels) {
				try {
					proceduregroupProgdurationRelLocalService.deleteProceduregroupProgdurationRel(rel.getPgPdRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting ProceduregroupProgdurationRel " + e.getMessage());
				}
			}
			_logger.info("rollbackProceduregroupProgdurationRelClone Completed :::");
		}
		
		_logger.info("rollbackProceduregroupProgdurationRelClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackProcedurePgProgdurationRelClone(List<ProcedurePgProgdurationRel> procedurePgProgdurationRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProcedurePgProgdurationRelClone Invoked :::");
		
		if(Validator.isNotNull(procedurePgProgdurationRels) && !procedurePgProgdurationRels.isEmpty()) {
			_logger.info("rollbackProcedurePgProgdurationRelClone Started :::");
			for(ProcedurePgProgdurationRel rel : procedurePgProgdurationRels) {
				try {
					proceduregroupProgdurationRelLocalService.deleteProceduregroupProgdurationRel(rel.getProcedurePgPdRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting procedurePgProgdurationRels" + e.getMessage());
				}
			}
			_logger.info("rollbackProcedurePgProgdurationRelClone Completed :::");
		}
		
		_logger.info("rollbackProcedurePgProgdurationRelClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackVisitTypeProgDurationRelsClone(List<VisitTypeProgDurationRel> visitTypeProgDurationRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackVisitTypeProgDurationRelsClone Invoked :::");
		
		if(Validator.isNotNull(visitTypeProgDurationRels) && !visitTypeProgDurationRels.isEmpty()) {
			_logger.info("rollbackVisitTypeProgDurationRelsClone Started :::");
			for(VisitTypeProgDurationRel rel : visitTypeProgDurationRels) {
				try {
					visitTypeProgDurationRelLocalService.deleteVisitTypeProgDurationRel(rel.getVisitTypeProgDurationRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting VisitTypeProgDurationRel" + e.getMessage());
				}
			}
			_logger.info("rollbackVisitTypeProgDurationRelsClone Completed :::");
		}
		
		_logger.info("rollbackVisitTypeProgDurationRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackPatientTypeProgDurationRelsClone(List<PatientTypeProgDurationRel> patientTypeProgDurationRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackPatientTypeProgDurationRelsClone Invoked :::");
		
		if(Validator.isNotNull(patientTypeProgDurationRels) && !patientTypeProgDurationRels.isEmpty()) {
			_logger.info("rollbackPatientTypeProgDurationRelsClone Started :::");
			for(PatientTypeProgDurationRel rel : patientTypeProgDurationRels) {
				try {
					patientTypeProgDurationRelLocalService.deletePatientTypeProgDurationRel(rel.getPatientTypeProgDurationRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting PatientTypeProgDurationRel " + e.getMessage());
				}
			}
			_logger.info("rollbackPatientTypeProgDurationRelsClone Completed :::");
		}
		
		_logger.info("rollbackPatientTypeProgDurationRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackRoleTypeProgDurationRelsClone(List<RoleTypeProgDurationRel> roleTypeProgDurationRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackPatientTypeProgDurationRelsClone Invoked :::");
		
		if(Validator.isNotNull(roleTypeProgDurationRels) && !roleTypeProgDurationRels.isEmpty()) {
			_logger.info("rollbackPatientTypeProgDurationRelsClone Started :::");
			for(RoleTypeProgDurationRel rel : roleTypeProgDurationRels) {
				try {
					roleTypeProgDurationRelLocalService.deleteRoleTypeProgDurationRel(rel.getRoleTypeProgDurationRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting RoleTypeProgDurationRel " + e.getMessage());
				}
			}
			_logger.info("rollbackPatientTypeProgDurationRelsClone Completed :::");
		}
		
		_logger.info("rollbackPatientTypeProgDurationRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackProgdurationCompetenciesRequirementsRelsClone(List<ProgdurationCompetenciesRequirementsRel> progdurationCompetenciesRequirementsRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProgdurationCompetenciesRequirementsRelsClone Invoked :::");
		
		if(Validator.isNotNull(progdurationCompetenciesRequirementsRels) && !progdurationCompetenciesRequirementsRels.isEmpty()) {
			_logger.info("rollbackProgdurationCompetenciesRequirementsRelsClone Started :::");
			for(ProgdurationCompetenciesRequirementsRel rel : progdurationCompetenciesRequirementsRels) {
				try {
					progdurationCompetenciesRequirementsRelLocalService.deleteProgdurationCompetenciesRequirementsRel(rel.getProgdurationCompetenciesRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting ProgdurationCompetenciesRequirementsRel " + e.getMessage());
				}
			}
			_logger.info("rollbackProgdurationCompetenciesRequirementsRelsClone Completed :::");
		}
		
		_logger.info("rollbackProgdurationCompetenciesRequirementsRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackProgdurationObjectivesRelsClone(List<ProgdurationObjectivesRel> progdurationObjectivesRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProgdurationObjectivesRelsClone Invoked :::");
		
		if(Validator.isNotNull(progdurationObjectivesRels) && !progdurationObjectivesRels.isEmpty()) {
			_logger.info("rollbackProgdurationObjectivesRelsClone Started :::");
			for(ProgdurationObjectivesRel rel : progdurationObjectivesRels) {
				try {
					progdurationCompetenciesRequirementsRelLocalService.deleteProgdurationCompetenciesRequirementsRel(rel.getPDObjectivesId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting ProgdurationObjectivesRel " + e.getMessage());
				}
			}
			_logger.info("rollbackProgdurationObjectivesRelsClone Completed :::");
		}
		
		_logger.info("rollbackProgdurationObjectivesRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackProgdurationRotationTraineelevelBlocksRelsClone(List<ProgdurationRotationTraineelevelBlocksRel> progdurationRotationTraineelevelBlocksRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProgdurationRotationTraineelevelBlocksRelsClone Invoked :::");
		
		if(Validator.isNotNull(progdurationRotationTraineelevelBlocksRels) && !progdurationRotationTraineelevelBlocksRels.isEmpty()) {
			_logger.info("rollbackProgdurationRotationTraineelevelBlocksRelsClone Started :::");
			for(ProgdurationRotationTraineelevelBlocksRel rel : progdurationRotationTraineelevelBlocksRels) {
				try {
					progdurationRotationTraineelevelBlocksRelLocalService.deleteProgdurationRotationTraineelevelBlocksRel(rel.getProgdurationRotationTlBlocksRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting ProgdurationRotationTraineelevelBlocksRel " + e.getMessage());
				}
			}
			_logger.info("rollbackProgdurationRotationTraineelevelBlocksRelsClone Completed :::");
		}
		
		_logger.info("rollbackProgdurationRotationTraineelevelBlocksRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackProgdurationRotationTrainingsitesRelsClone(List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProgdurationRotationTrainingsitesRelsClone Invoked :::");
		
		if(Validator.isNotNull(progdurationRotationTrainingsitesRels) && !progdurationRotationTrainingsitesRels.isEmpty()) {
			_logger.info("rollbackProgdurationRotationTrainingsitesRelsClone Started :::");
			for(ProgdurationRotationTrainingsitesRel rel : progdurationRotationTrainingsitesRels) {
				try {
					progdurationRotationTrainingsitesRelLocalService.deleteProgdurationRotationTrainingsitesRel(rel.getProgdurationRotationTsRelId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting ProgdurationRotationTrainingsitesRel " + e.getMessage());
				}
			}
			_logger.info("rollbackProgdurationRotationTrainingsitesRelsClone Completed :::");
		}
		
		_logger.info("rollbackProgdurationRotationTrainingsitesRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackProgdurationTraineelevelBlocksLevelTypeRelsClone(List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProgdurationTraineelevelBlocksLevelTypeRelsClone Invoked :::");
		
		if(Validator.isNotNull(progdurationTraineelevelBlocksLevelTypeRels) && !progdurationTraineelevelBlocksLevelTypeRels.isEmpty()) {
			_logger.info("rollbackProgdurationTraineelevelBlocksLevelTypeRelsClone for proceduregroupProgdurationRels Started :::");
			for(ProgdurationTraineelevelBlocksLevelTypeRel rel : progdurationTraineelevelBlocksLevelTypeRels) {
				try {
					progdurationTraineelevelBlocksLevelTypeRelLocalService.deleteProgdurationTraineelevelBlocksLevelTypeRel(rel.getProgdurationTlBlocksLtId());
				} catch (PortalException e) {
					isRollbackSuccessfully = false;
					_logger.error("Error while deleting ProgdurationTraineelevelBlocksLevelTypeRel " + e.getMessage());
				}
			}
			_logger.info("rollbackProgdurationTraineelevelBlocksLevelTypeRelsClone for proceduregroupProgdurationRels Completed :::");
		}
		
		_logger.info("rollbackProgdurationTraineelevelBlocksLevelTypeRelsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackProgramDurationDetailsClone(ProgramDurationDetails newProgramDurationDetails) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackProgramDurationDetailsClone Invoked :::");
		
		if(Validator.isNotNull(newProgramDurationDetails)) {
			_logger.info("rollbackProgramDurationDetailsClone Started :::");
			try {
				programDurationDetailsLocalService.deleteProgramDurationDetails(newProgramDurationDetails.getProgDurationId());
			} catch (PortalException e) {
				isRollbackSuccessfully = false;
				_logger.error("Error while deleting ProgramDurationDetails " + e.getMessage());
			}
			_logger.info("rollbackProgramDurationDetailsClone Completed :::");
		}
		
		_logger.info("rollbackProgramDurationDetailsClone Exit :::");
		return isRollbackSuccessfully;
	}
	
	public boolean rollbackCreatedBlocks(ProgramDurationDetails programDurationDetails) {
		boolean isRollbackSuccessfully = true;
		_logger.info("rollbackCreatedBlocks Invoked :::");
		
		List<ProgdurationTraineelevelBlocksLevelTypeRel> traineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programDurationDetails.getProgDurationId());
		
		for(ProgdurationTraineelevelBlocksLevelTypeRel traineelevelBlocksLevelTypeRel : traineelevelBlocksLevelTypeRels) {
			List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = blocksMetadataDetailsRelLocalService.findByProgDurationTlBlocksLtId(traineelevelBlocksLevelTypeRel.getProgdurationTlBlocksLtId());
			for(BlocksMetadataDetailsRel blocksMetadataDetailsRel : blocksMetadataDetailsRels) {
				try {
					blocksMetadataDetailsRelLocalService.deleteBlocksMetadataDetailsRel(blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());
				} catch (PortalException e) {
					_logger.error("Error while deleting blocks " + e.getMessage());
				}
			}
		}
		
		_logger.info("rollbackCreatedBlocks Exit :::");
		return isRollbackSuccessfully;
	}
	
		
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
	
	public static final Log _logger = LogFactoryUtil.getLog(OmsbViewProgramRollbackCloneCohortUtil.class.getName());
}

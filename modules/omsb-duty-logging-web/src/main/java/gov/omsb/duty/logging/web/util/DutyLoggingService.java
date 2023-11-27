package gov.omsb.duty.logging.web.util;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.model.DutyRule;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.ProgramDutyRule;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.DutyAssignmentLocalService;
import gov.omsb.tms.service.DutyRuleLocalService;
import gov.omsb.tms.service.DutyTypesLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramDutyAssignmentLocalService;
import gov.omsb.tms.service.ProgramDutyRuleLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, service = DutyLoggingService.class)
public class DutyLoggingService {

	private static final Log LOGGER = LogFactoryUtil.getLog(DutyLoggingService.class);

	// Add the duty types
	public DutyTypes addDutyTypes(String dutyType, long groupId, long userId) throws PortalException {
		LOGGER.info("service - add duty type");
		
		return dutyTypesLocalService.addDutyTypes(dutyType,groupId,userId);
	}

	// Get the Duty Type List
	public List<DutyTypes> getDutyTypesList() {
		LOGGER.info("service - duty type list");
		return dutyTypesLocalService.getDutyTypesList();
	}

	// update the dutyTypes
	public DutyTypes updateDutyTypes(long dutyTypeId, long userId, String dutyType) throws PortalException {
		return dutyTypesLocalService.editDutyTypes(dutyTypeId, userId, dutyType);
	}

	// get DutyTypes by id
	public DutyTypes getDutyTypes(long dutyTypeId) throws PortalException {
		return dutyTypesLocalService.getDutyTypes(dutyTypeId);
	}

	// Add the ProgramDutyAssignment
	public ProgramDutyAssignment addProgramDutyAssignment(long programId, long dutyAssignmentId, long cohortId,
			ServiceContext serviceContext) throws PortalException {
		LOGGER.info("service - add program duty type assignment");
		return programDutyAssignmentLocalService.addProgramDutyAssignment(programId, dutyAssignmentId, cohortId,
				serviceContext);
	}

	public ProgramDutyAssignment editProgramDutyAssignment(long programDutyAssignmentId, String status)
			throws PortalException {
		LOGGER.info("service - edit program duty type assignment");
		return programDutyAssignmentLocalService.editProgramDutyAssignment(programDutyAssignmentId, status);
	}

	// Get the Program Duty Assignment List
	public List<ProgramDutyAssignment> getProgramDutyAssignmentList() {
		LOGGER.info("service - duty type list");
		return programDutyAssignmentLocalService.getProgramDutyAssignmentList();

	}

	public List<DutyAssignment> getDutyAssignmentList() {
		return dutyAssignmentLocalService.getDutyAssignments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<ProgramMaster> getProgramMasterList() {
		return programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public ProgramMaster getProgramByProgramId(long programId) throws PortalException {
		return programMasterLocalService.getProgramMaster(programId);
	}

	public List<ProgramDurationDetails> getCohortListByProgramId(long programId) {
		return programDurationDetailsLocalService.findProgramDurationByProgramId(programId);
	}

	public ProgramDurationDetails getCohortListByCohortId(long cohortId) throws PortalException {
		return programDurationDetailsLocalService.getProgramDurationDetails(cohortId);
	}

	public List<DutyAssignment> getAssignmentListByDutyTypeId(long dutyTypeId) {
		return dutyAssignmentLocalService.findAssignmentByDutyTypeId(dutyTypeId);
	}

	public DutyAssignment getAssignmentListByAssignmentId(long dutyAssignmentId) throws PortalException {
		return dutyAssignmentLocalService.getDutyAssignment(dutyAssignmentId);
	}

	public List<DutyRule> getDutyRuleList() {
		return dutyRuleLocalService.getDutyRules(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<ProgramDutyRule> getProgramDutyRuleList() {
		return programDutyRuleLocalService.getProgramDutyRules(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public DutyRule getDutyRule(long dutyRuleId) throws PortalException {
		return dutyRuleLocalService.getDutyRule(dutyRuleId);
	}

	public List<DutyRule> getDutyRulesByProgramAndCohort(long programId,long cohortId) { 
		return programDutyRuleLocalService.getDutyRulesListByProgramAndCohort(programId, cohortId);
	  
	  }

	@Reference
	private DutyTypesLocalService dutyTypesLocalService;

	@Reference
	private DutyAssignmentLocalService dutyAssignmentLocalService;

	@Reference
	private ProgramDutyAssignmentLocalService programDutyAssignmentLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private DutyRuleLocalService dutyRuleLocalService;

	@Reference
	private ProgramDutyRuleLocalService programDutyRuleLocalService;

}

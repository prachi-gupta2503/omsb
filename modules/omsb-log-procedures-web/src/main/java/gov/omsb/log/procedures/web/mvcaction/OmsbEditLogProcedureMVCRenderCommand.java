package gov.omsb.log.procedures.web.mvcaction;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.model.PatientTypeProgDurationRel;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.ProcedurePgProgdurationRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.model.RoleTypeProgDurationRel;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.model.VisitTypeProgDurationRel;
import gov.omsb.tms.service.CptCodeMasterLocalService;
import gov.omsb.tms.service.GenderMasterLocalService;
import gov.omsb.tms.service.PatientTypeMasterLocalService;
import gov.omsb.tms.service.PatientTypeProgDurationRelLocalService;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;
import gov.omsb.tms.service.ProcedureGroupProceduresCPTCodeRelLocalService;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.ProcedurePgProgdurationRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RoleTypeMasterLocalService;
import gov.omsb.tms.service.RoleTypeProgDurationRelLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;
import gov.omsb.tms.service.TraineeLoggedProcedureDetailsLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.tms.service.VisitTypeProgDurationRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
		"mvc.command.name=" + OmsbLogProceduresConstants.EDIT_LOG_PROCEDURES_JSP }, service = MVCRenderCommand.class)
public class OmsbEditLogProcedureMVCRenderCommand implements MVCRenderCommand {

	long programDurationId = GetterUtil.DEFAULT_LONG;
	long programId = GetterUtil.DEFAULT_LONG;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String tabName = ParamUtil.getString(renderRequest, OmsbLogProceduresConstants.TAB_NAME);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLogProceduresConstants.STORE_DATE_FORMAT);

		long loggedProcedureId = ParamUtil.getLong(renderRequest, OmsbLogProceduresConstants.LOGGED_PROCEDURE_ID);
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetail = traineeLoggedProcedureDetailsLocalService.fetchTraineeLoggedProcedureDetails(loggedProcedureId);

		setProgramIdAndProgramDurationId(themeDisplay);
		setProgramMaster(traineeLoggedProcedureDetail, renderRequest);
		setTrainingSiteMaster(traineeLoggedProcedureDetail, renderRequest);
		setGenderMasters(renderRequest, themeDisplay);
		setPatientTypeMasters(programDurationId, renderRequest, themeDisplay);
		setVisitTypeMasters(programDurationId, renderRequest, themeDisplay);
		setProcedureGroupAndProcedureAndCPTCode(programDurationId, renderRequest, themeDisplay);
		setRoleTypeMaster(programDurationId, renderRequest, themeDisplay);
		setFacultyList(programId, themeDisplay, renderRequest);
				
		renderRequest.setAttribute(OmsbLogProceduresConstants.LOGGED_PROCEDURES, traineeLoggedProcedureDetail);
		
		try {
			renderRequest.setAttribute(OmsbLogProceduresConstants.PATIENT_DOB, sdf.format(traineeLoggedProcedureDetail.getPatientDOB()));
			renderRequest.setAttribute(OmsbLogProceduresConstants.PROCEDURE_PERFORMED_DATE, sdf.format(traineeLoggedProcedureDetail.getProcedurePerformedDate()));		
		} catch (Exception e) {
			log.error(e);
		}

		renderRequest.setAttribute(OmsbLogProceduresConstants.TAB_NAME, tabName);
		log.debug("-------Redirecting To Edit Page--------");

		return OmsbLogProceduresConstants.EDIT_LOG_PROCEDURES_JSP;
	}

	private void setProgramIdAndProgramDurationId(ThemeDisplay themeDisplay){
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = traineeAdmissionDetailsRelLocalService.findByTraineeId(themeDisplay.getUserId());
		if(Validator.isNotNull(traineeAdmissionDetailsRel)) {
			programDurationId = traineeAdmissionDetailsRel.getProgramDurationId();
			ProgramDurationDetails durationDetails = programDurationDetailsLocalService.fetchProgramDurationDetails(programDurationId);
			if (Validator.isNotNull(durationDetails)) {
				programId = durationDetails.getProgramId();
			}
		}
	}

	private void setProgramMaster(TraineeLoggedProcedureDetails traineeLoggedProcedureDetail, RenderRequest renderRequest) {
		try {
			if(Validator.isNotNull(traineeLoggedProcedureDetail)) {
				ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programId);
				if(Validator.isNotNull(programMaster)) {
					renderRequest.setAttribute(CommonConstants.PROGRAM, programMaster);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}

	}

	private void setTrainingSiteMaster(TraineeLoggedProcedureDetails traineeLoggedProcedureDetail, RenderRequest renderRequest) {
		List<TrainingSitesMaster> trainingSitesMasters = new ArrayList<>();
		if(Validator.isNotNull(traineeLoggedProcedureDetail)) {
			TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.fetchTrainingSitesMaster(traineeLoggedProcedureDetail.getTrainingSitesId());
			if (Validator.isNotNull(trainingSitesMaster)) {
				trainingSitesMasters.add(trainingSitesMaster);
			}
		}
		renderRequest.setAttribute(OmsbLogProceduresConstants.TRAINING_SITE_MASTER_LIST, trainingSitesMasters);
	}

	private void setGenderMasters(RenderRequest renderRequest, ThemeDisplay themeDisplay) {
		List<GenderMaster> genderMasters = genderMasterLocalService.getGenderMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		genderMasters = genderMasters.stream().sorted((first,second)->{
	        String genderFirst = first.getGenderName(themeDisplay.getLocale()).toLowerCase();
	        String genderSecond = second.getGenderName(themeDisplay.getLocale()).toLowerCase();
	        return genderFirst.compareTo(genderSecond);
		}).collect(Collectors.toList());
		
		renderRequest.setAttribute(OmsbLogProceduresConstants.GENDER_MASTER_LIST, genderMasters);
	}

	private void setVisitTypeMasters(long programDurationId, RenderRequest renderRequest, ThemeDisplay themeDisplay) {
		List<VisitTypeMaster> visitTypeMasters = new ArrayList<>();

		List<VisitTypeProgDurationRel> visitTypeProgDurationRels = visitTypeProgDurationRelLocalService.findByProgramDurationId(programDurationId);
		
		for (VisitTypeProgDurationRel visitTypeProgDurationRel : visitTypeProgDurationRels) {
			try {
				visitTypeMasters.add(visitTypeMasterLocalService.getVisitTypeMaster(visitTypeProgDurationRel.getVisitTypeMasterId()));
			} catch (PortalException e) {
				log.error(e);
			}
		}
		visitTypeMasters = visitTypeMasters.stream().sorted((first,second)->{
	        String visitTypeNameFirst = first.getVisitTypeName(themeDisplay.getLocale()).toLowerCase();
	        String visitTypeNameSecond = second.getVisitTypeName(themeDisplay.getLocale()).toLowerCase();
	        return visitTypeNameFirst.compareTo(visitTypeNameSecond);
		}).collect(Collectors.toList());
		
		renderRequest.setAttribute(OmsbLogProceduresConstants.VISIT_TYPE_MASTER_LIST, visitTypeMasters);
	}
	
	private void setProcedureGroupAndProcedureAndCPTCode(long programDurationId, RenderRequest renderRequest, ThemeDisplay themeDisplay) {
		Map<Long, String> cptCodeMasters = new LinkedHashMap<>();

		List<ProcedureGroupMaster> procedureGroupMasters = new ArrayList<>();
		
		List<ProcedureMaster> procedureMasters = new ArrayList<>();

		List<ProcedurePgProgdurationRel> procedurePgProgdurationRels = procedurePgProgdurationRelLocalService.findByProgramDurationId(programDurationId);
		
		ProcedureMaster procedureMaster;
		for (ProcedurePgProgdurationRel procedurePgProgdurationRel : procedurePgProgdurationRels) {
			try {
				procedureMaster = procedureMasterLocalService.getProcedureMaster(procedurePgProgdurationRel.getProcedureMasterId());
				procedureMasters.add(procedureMaster);
				procedureGroupMasters.add(procedureGroupMasterLocalService.getProcedureGroupMaster(procedurePgProgdurationRel.getProcedureGroupMasterId()));
				if(Validator.isNotNull(procedureMaster.getCptCode())) {
					cptCodeMasters.put(procedureMaster.getProcedureMasterId(), procedureMaster.getCptCode(themeDisplay.getLocale()));
				}
			} catch (PortalException e) {
				log.error(e);
			}
		}		
		procedureGroupMasters = procedureGroupMasters.stream().sorted((first,second)->{
	        String procedureGroupNameFirst = first.getProcedureGroupName(themeDisplay.getLocale()).toLowerCase();
	        String procedureGroupNameSecond = second.getProcedureGroupName(themeDisplay.getLocale()).toLowerCase();
	        return procedureGroupNameFirst.compareTo(procedureGroupNameSecond);
		}).collect(Collectors.toList());
		
		procedureMasters = procedureMasters.stream().sorted((first,second)->{
	        String procedureNameFirst = first.getProcedureName(themeDisplay.getLocale()).toLowerCase();
	        String procedureNameSecond = second.getProcedureName(themeDisplay.getLocale()).toLowerCase();
	        return procedureNameFirst.compareTo(procedureNameSecond);
		}).collect(Collectors.toList());	

		renderRequest.setAttribute(OmsbLogProceduresConstants.CPT_CODE_MASTER_LIST, cptCodeMasters);
		renderRequest.setAttribute(OmsbLogProceduresConstants.PROCEDURE_GROUP_MASTER_LIST, procedureGroupMasters);
		renderRequest.setAttribute(OmsbLogProceduresConstants.PROCEDURE_MASTER_LIST, procedureMasters);
	}
	
	private void setPatientTypeMasters(long programDurationId, RenderRequest renderRequest, ThemeDisplay themeDisplay) {
		List<PatientTypeMaster> patientTypeMasters = new ArrayList<>();

		List<PatientTypeProgDurationRel> patientTypeProgDurationRels = patientTypeProgDurationRelLocalService.findByProgramDurationId(programDurationId);
 		
		for (PatientTypeProgDurationRel patientTypeProgDurationRel : patientTypeProgDurationRels) {
			try {
				patientTypeMasters.add(patientTypeMasterLocalService.getPatientTypeMaster(patientTypeProgDurationRel.getPatientTypeMasterId()));
			} catch (PortalException e) {
				log.error(e);
			}
		}
		patientTypeMasters = patientTypeMasters.stream().sorted((first,second)->{
	        String patientTypeFirst = first.getPatientTypeName(themeDisplay.getLocale()).toLowerCase();
	        String patientTypeSecond = second.getPatientTypeName(themeDisplay.getLocale()).toLowerCase();
	        return patientTypeFirst.compareTo(patientTypeSecond);
		}).collect(Collectors.toList());

		renderRequest.setAttribute(OmsbLogProceduresConstants.PATIENT_TYPE_MASTER_LIST, patientTypeMasters);
	}
	
	private void setRoleTypeMaster(long programDurationId, RenderRequest renderRequest, ThemeDisplay themeDisplay) {
		List<RoleTypeMaster> roleTypeMasters = new ArrayList<>();
		
		List<RoleTypeProgDurationRel> roleTypeProgDurationRels = roleTypeProgDurationRelLocalService.findByProgramDurationId(programDurationId);
		
		for (RoleTypeProgDurationRel roleTypeProgDurationRel : roleTypeProgDurationRels) {
			try {
				roleTypeMasters.add(roleTypeMasterLocalService.getRoleTypeMaster(roleTypeProgDurationRel.getRoleTypeMasterId()));
			} catch (PortalException e) {
				log.error(e.getMessage());
			}
		}
		roleTypeMasters = roleTypeMasters.stream().sorted((first,second)->{
	        String roleTypeNameFirst = first.getRoleTypeName(themeDisplay.getLocale()).toLowerCase();
	        String roleTypeNameSecond = second.getRoleTypeName(themeDisplay.getLocale()).toLowerCase();
	        return roleTypeNameFirst.compareTo(roleTypeNameSecond);
		}).collect(Collectors.toList());

		renderRequest.setAttribute(OmsbLogProceduresConstants.ROLE_TYPE_MASTER_LIST, roleTypeMasters);
	}

	private void setFacultyList(long programId, ThemeDisplay themeDisplay, RenderRequest renderRequest) {
		List<User> users = new ArrayList<>();
		try {
			Role facultyRole = roleLocalService.fetchRole(themeDisplay.getCompanyId(), OmsbTmsCommonConstants.FACULTY_ROLE);
			if (Validator.isNotNull(facultyRole)) {
				UserMetadataItem facultyMetadataItem = userMetadataUtil.getUserMetadataItemsByProgramIdAndRoleId(themeDisplay.getPortalURL(), themeDisplay.getSiteGroupId(), programId, facultyRole.getRoleId());				
				List<UserMetadata> facultyMetadatas = facultyMetadataItem.getItems();
				for (UserMetadata userMetadata : facultyMetadatas) {
					User user = userLocalService.fetchUser(userMetadata.getLrUserId());
					if (Validator.isNotNull(user)) {
						users.add(user);						
					}
				}
			}
			
			users = users.stream().sorted((first,second)->{
		        String userNameFirst = first.getFullName().toLowerCase();
		        String userNameSecond = second.getFullName().toLowerCase();
		        return userNameFirst.compareTo(userNameSecond);
			}).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Exception -> " + e.getMessage());
		}
		renderRequest.setAttribute(OmsbLogProceduresConstants.SUPERVISORS_LIST, users);
	}

	@Reference
	ProgramMasterLocalService programMasterLocalService;

	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	GenderMasterLocalService genderMasterLocalService;

	@Reference
	PatientTypeMasterLocalService patientTypeMasterLocalService;

	@Reference
	VisitTypeMasterLocalService visitTypeMasterLocalService;

	@Reference
	CptCodeMasterLocalService cptCodeMasterLocalService;

	@Reference
	ProcedureGroupMasterLocalService procedureGroupMasterLocalService;

	@Reference
	ProcedureMasterLocalService procedureMasterLocalService;

	@Reference
	ProcedureGroupProceduresCPTCodeRelLocalService procedureGroupProceduresCPTCodeRelLocalService;
	
	@Reference
	TrainingSitesMasterLocalService trainingSitesMasterLocalService; 

	@Reference
	RoleTypeMasterLocalService roleTypeMasterLocalService;

	@Reference
	TraineeLoggedProcedureDetailsLocalService traineeLoggedProcedureDetailsLocalService;

	@Reference
	PatientTypeProgDurationRelLocalService patientTypeProgDurationRelLocalService;
	
	@Reference
	VisitTypeProgDurationRelLocalService visitTypeProgDurationRelLocalService;
	
	@Reference
	RoleTypeProgDurationRelLocalService roleTypeProgDurationRelLocalService;

	@Reference
	ProcedurePgProgdurationRelLocalService procedurePgProgdurationRelLocalService;
	
	@Reference
	TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService;

	@Reference
	RoleLocalService roleLocalService;

	@Reference
	UserLocalService userLocalService;

	@Reference
	UserMetadataUtil userMetadataUtil;

	private Log log = LogFactoryUtil.getLog(OmsbEditLogProcedureMVCRenderCommand.class.getName());

}
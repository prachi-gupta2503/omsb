package gov.omsb.view.procedures.supervisor.web.mvccommands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.service.CptCodeMasterLocalService;
import gov.omsb.tms.service.GenderMasterLocalService;
import gov.omsb.tms.service.PatientTypeMasterLocalService;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;
import gov.omsb.tms.service.ProcedureGroupProceduresCPTCodeRelLocalService;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.RoleTypeMasterLocalService;
import gov.omsb.tms.service.TraineeLoggedProcedureDetailsLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbViewProceduresSupervisorWebPortletKeys.OMSBVIEWPROCEDURESSUPERVISORWEB,
		"mvc.command.name="
				+ OmsbViewProceduresSupervisorWebPortletKeys.VIEW_PROCEDURE_DETAIL }, service = MVCRenderCommand.class)

public class OmsbViewSupervisorProcedureDetailMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.debug("OmsbViewSupervisorProcedureDetailMVCRenderCommand render invokes ::: " );
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long loggedProcedureId = ParamUtil.getLong(renderRequest, OmsbViewProceduresSupervisorWebPortletKeys.TRAINEE_LOGGED_PROCEDURE_DETAILS_ID);
		
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails = traineeLoggedProcedureDetailsLocalService.fetchTraineeLoggedProcedureDetails(loggedProcedureId);
		

		if(Validator.isNotNull(traineeLoggedProcedureDetails) ) {
			setProcedureDetails(traineeLoggedProcedureDetails, themeDisplay, renderRequest);
		}

		_logger.info("-------Redirecting To View Page--------");
		return OmsbViewProceduresSupervisorWebPortletKeys.VIEW_PROCEDURE_DETAIL_JSP;
	}

	private void setProcedureDetails(TraineeLoggedProcedureDetails traineeLoggedProcedureDetails ,ThemeDisplay themeDisplay, RenderRequest renderRequest) {
		
		String genderMasterName = StringPool.DASH;
		String patientTypeName = StringPool.DASH;
		String visitTypeName = StringPool.DASH;
		String roleTypeName = StringPool.DASH;
		String cptCodeName = StringPool.DASH;
		String procedureGroupName = StringPool.DASH;
		String procedureName = StringPool.DASH;
		String trainingSiteName = StringPool.DASH;
		String supervisorName = StringPool.DASH;
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbViewProceduresSupervisorWebPortletKeys.STORE_DATE_FORMAT);

		
		GenderMaster genderMaster = genderMasterLocalService.fetchGenderMaster(traineeLoggedProcedureDetails.getGenderId());
		if (Validator.isNotNull(genderMaster))
			genderMasterName = genderMaster.getGenderName(themeDisplay.getLocale());
		
		PatientTypeMaster patientTypeMaster = patientTypeMasterLocalService.fetchPatientTypeMaster(traineeLoggedProcedureDetails.getPatientTypeId());
		if(Validator.isNotNull(patientTypeMaster))
			patientTypeName = patientTypeMaster.getPatientTypeName(themeDisplay.getLocale());
		
		VisitTypeMaster visitTypeMaster = visitTypeMasterLocalService.fetchVisitTypeMaster(traineeLoggedProcedureDetails.getVisitTypeId());
		if(Validator.isNotNull(visitTypeMaster))
			visitTypeName = visitTypeMaster.getVisitTypeName(themeDisplay.getLocale());
		
		RoleTypeMaster roleTypeMaster = roleTypeMasterLocalService.fetchRoleTypeMaster(traineeLoggedProcedureDetails.getRoleTypeId());
		if(Validator.isNotNull(roleTypeMaster))
			roleTypeName = roleTypeMaster.getRoleTypeName(themeDisplay.getLocale());
		
		ProcedureMaster procedureMaster = procedureMasterLocalService.fetchProcedureMaster(traineeLoggedProcedureDetails.getProcedureId());
		if(Validator.isNotNull(procedureMaster)) {
			procedureName = procedureMaster.getProcedureName(themeDisplay.getLocale());
			if(Validator.isNotNull(procedureMaster)) {
				cptCodeName = procedureMaster.getCptCode(themeDisplay.getLocale());
			}
			if(Validator.isNotNull(procedureMaster.getProcedureGroupMasterId())) {
				 ProcedureGroupMaster procedureGroupMaster = procedureGroupMasterLocalService.fetchProcedureGroupMaster(procedureMaster.getProcedureGroupMasterId());
				 if(Validator.isNotNull(procedureGroupMaster))
					 procedureGroupName = procedureGroupMaster.getProcedureGroupName(themeDisplay.getLocale());
			}
		}
		
		TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.fetchTrainingSitesMaster(traineeLoggedProcedureDetails.getTrainingSitesId());
		if(Validator.isNotNull(trainingSitesMaster))
			trainingSiteName = trainingSitesMaster.getTrainingSiteName(themeDisplay.getLocale());
					
		User user = userLocalService.fetchUser(traineeLoggedProcedureDetails.getFacultyId());
		if(Validator.isNotNull(user))
			supervisorName = user.getFullName();
	
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.GENDER_MASTER_NAME, genderMasterName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.PATIENT_TYPE_NAME, patientTypeName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.VISIT_TYPE_NAME, visitTypeName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.ROLE_TYPE_NAME, roleTypeName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.CPT_CODE_NAME, cptCodeName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.PROCEDURE_GROUP_NAME, procedureGroupName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.PROCEDURE_NAME, procedureName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.TRAINING_SITE_NAME, trainingSiteName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.SUPERVISOR_NAME, supervisorName);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.SDF, sdf);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.TRAINEE_LOGGED_PROCEDURE_DETAIL, traineeLoggedProcedureDetails);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.TAB_NAME, ParamUtil.getString(renderRequest, OmsbViewProceduresSupervisorWebPortletKeys.TAB_NAME));

	}
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
	UserLocalService userLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbViewSupervisorProcedureDetailMVCRenderCommand.class);
}

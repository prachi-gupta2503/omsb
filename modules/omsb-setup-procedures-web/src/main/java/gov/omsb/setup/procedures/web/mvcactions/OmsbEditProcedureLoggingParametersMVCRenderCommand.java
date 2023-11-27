package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.model.PatientTypeProgDurationRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.model.RoleTypeProgDurationRel;
import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.model.VisitTypeProgDurationRel;
import gov.omsb.tms.service.PatientTypeMasterLocalService;
import gov.omsb.tms.service.PatientTypeProgDurationRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.RoleTypeMasterLocalService;
import gov.omsb.tms.service.RoleTypeProgDurationRelLocalService;
import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.tms.service.VisitTypeProgDurationRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"mvc.command.name=/edit-procedure-logging-parameters-form" }, service = MVCRenderCommand.class)

public class OmsbEditProcedureLoggingParametersMVCRenderCommand implements MVCRenderCommand {

	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditProcedureLoggingParametersMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("Edit Procedure RenderRequest :: Invoked");

		 String editProcedureName = ParamUtil.getString(renderRequest, OmsbSetupProceduresWebPortletKeys.EDIT_PROCEDURE_NAME);
	     String procedureTypeProgDurationRelId = ParamUtil.getString(renderRequest, OmsbSetupProceduresWebPortletKeys.PROCEDURE_TYPE_PROG_DURATION_REL_ID);
	     String procedueTypeProgDurationRelName = ParamUtil.getString(renderRequest,OmsbSetupProceduresWebPortletKeys.PROCEDURE_TYPE_PROG_DURATION_REL_NAME);
		
		
		try {
			if(OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_ROLE.equalsIgnoreCase(editProcedureName))
			{	
			RoleTypeProgDurationRel roleTypeProgDurationRel = roleTypeProgDurationRelLocalService.getRoleTypeProgDurationRel(Long.parseLong(procedureTypeProgDurationRelId));
			RoleTypeMaster roleTypeMaster = roleTypeMasterLocalService.getRoleTypeMaster(roleTypeProgDurationRel.getRoleTypeMasterId());
			ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(roleTypeProgDurationRel.getProgramDurationId());
			List<ProgramDurationDetails> programDurationDetailsList = new ArrayList<>(programDurationDetailsLocalService
					.findProgramDurationByProgramId(programDurationDetails.getProgramId()));
	        Collections.sort(programDurationDetailsList, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROCEDURE_NAME, editProcedureName);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_ID,programDurationDetails.getProgramId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_ID ,programDurationDetails.getProgDurationId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_DETAILS_LIST,programDurationDetailsList);
			
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_PROG_DURATION_REL_ID ,procedureTypeProgDurationRelId);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_MASTER_ID, roleTypeMaster.getRoleTypeMasterId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_PROG_DURATION_REL_NAME,procedueTypeProgDurationRelName);
			}
			
			if(OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_PATIENT.equalsIgnoreCase(editProcedureName))
			{	
			PatientTypeProgDurationRel patientTypeProgDurationRel = patientTypeProgDurationRelLocalService.getPatientTypeProgDurationRel(Long.parseLong(procedureTypeProgDurationRelId));
			PatientTypeMaster patientTypeMaster = patientTypeMasterLocalService.getPatientTypeMaster(patientTypeProgDurationRel.getPatientTypeMasterId());
			ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(patientTypeProgDurationRel.getProgramDurationId());
			List<ProgramDurationDetails> programDurationDetailsList = new ArrayList<>(programDurationDetailsLocalService
					.findProgramDurationByProgramId(programDurationDetails.getProgramId()));
	        Collections.sort(programDurationDetailsList, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));

			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROCEDURE_NAME, editProcedureName);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_ID,programDurationDetails.getProgramId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_ID,programDurationDetails.getProgDurationId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_DETAILS_LIST,programDurationDetailsList);
			
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_PROG_DURATION_REL_ID ,procedureTypeProgDurationRelId);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_MASTER_ID, patientTypeMaster.getPatientTypeMasterId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_PROG_DURATION_REL_NAME,procedueTypeProgDurationRelName);
			}
			
			if(OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_VISIT.equalsIgnoreCase(editProcedureName))
			{	
			VisitTypeProgDurationRel visitTypeProgDurationRel = visitTypeProgDurationRelLocalService.getVisitTypeProgDurationRel(Long.parseLong(procedureTypeProgDurationRelId));
			VisitTypeMaster visitTypeMaster = visitTypeMasterLocalService.getVisitTypeMaster(visitTypeProgDurationRel.getVisitTypeMasterId());
			ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(visitTypeProgDurationRel.getProgramDurationId());
			List<ProgramDurationDetails> programDurationDetailsList = new ArrayList<>(programDurationDetailsLocalService
					.findProgramDurationByProgramId(programDurationDetails.getProgramId()));
	        Collections.sort(programDurationDetailsList, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));

			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROCEDURE_NAME, editProcedureName);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_ID,programDurationDetails.getProgramId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_ID ,programDurationDetails.getProgDurationId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_DETAILS_LIST,programDurationDetailsList);
			
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_PROG_DURATION_REL_ID ,procedureTypeProgDurationRelId);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_MASTER_ID, visitTypeMaster.getVisitTypeMasterId());
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_PROG_DURATION_REL_NAME,procedueTypeProgDurationRelName);
			}
		}catch (Exception e) {
			_logger.error(e);
		}

		return OmsbSetupProceduresWebPortletKeys.EDIT_PROCEDURE_JSP;
	}

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private PatientTypeProgDurationRelLocalService patientTypeProgDurationRelLocalService;

	@Reference
	private PatientTypeMasterLocalService patientTypeMasterLocalService;

	@Reference
	private RoleTypeProgDurationRelLocalService roleTypeProgDurationRelLocalService;

	@Reference
	private RoleTypeMasterLocalService roleTypeMasterLocalService;

	@Reference
	private VisitTypeProgDurationRelLocalService visitTypeProgDurationRelLocalService;

	@Reference
	private VisitTypeMasterLocalService visitTypeMasterLocalService;
}

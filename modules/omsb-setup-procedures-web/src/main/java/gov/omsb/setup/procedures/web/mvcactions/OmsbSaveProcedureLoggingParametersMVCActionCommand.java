package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.model.PatientTypeProgDurationRel;
import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.model.RoleTypeProgDurationRel;
import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.model.VisitTypeProgDurationRel;
import gov.omsb.tms.service.PatientTypeMasterLocalService;
import gov.omsb.tms.service.PatientTypeProgDurationRelLocalService;
import gov.omsb.tms.service.RoleTypeMasterLocalService;
import gov.omsb.tms.service.RoleTypeProgDurationRelLocalService;
import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.tms.service.VisitTypeProgDurationRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.SAVE_PROCEDURE_LOGGING_PARAMETER_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveProcedureLoggingParametersMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String masterName = ParamUtil.getString(actionRequest, OmsbSetupProceduresWebPortletKeys.MASTER_VALUE);
		boolean isCreate = ParamUtil.getBoolean(actionRequest, OmsbSetupProceduresWebPortletKeys.IS_CREATE);
		boolean isEdit = ParamUtil.getBoolean(actionRequest, OmsbSetupProceduresWebPortletKeys.IS_EDIT);
		if (OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME.equalsIgnoreCase(masterName)) {
			handleRoleType(actionRequest, themeDisplay, isCreate, isEdit);
		} else if (OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME.equalsIgnoreCase(masterName)) {
			handlePatientType(actionRequest, themeDisplay, isCreate, isEdit);
		} else {
			handleVisitType(actionRequest, themeDisplay, isCreate, isEdit);
		}
		actionResponse.getRenderParameters().setValue(OmsbSetupProceduresWebPortletKeys.MVC_COMMAND_NAME,
				StringPool.FORWARD_SLASH);
		actionRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.MASTER_VALUE, masterName);
	}

	// Handeling Role Type Logging Procedure Parameter
	private void handleRoleType(ActionRequest actionRequest, ThemeDisplay themeDisplay, boolean isCreate,
			boolean isEdit) {
		long progDurationId;
		try {
			if (isEdit) {
				progDurationId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION);
				handleEditRoleType(actionRequest, progDurationId, themeDisplay);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME_EDIT_SUCCESS);
			} else {
				progDurationId = ParamUtil.getLong(actionRequest,
						OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_ROLE);
				if (isCreate) {
					handleCreateRoleType(actionRequest, progDurationId, themeDisplay);
				} else {
					handleOtherRoleTypes(actionRequest, progDurationId, themeDisplay);
				}
			}
		} catch (PortalException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}
	}

	private void handleEditRoleType(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay)
			throws PortalException {
		long roleTypeProgDurationId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_PROG_DURATION_REL_ID);
		String[] selectedRole = ParamUtil.getParameterValues(actionRequest,
				OmsbSetupProceduresWebPortletKeys.ROLE_TYPE);

		roleTypeProgDurationRelLocalService.deleteRoleTypeProgDurationRel(roleTypeProgDurationId);

		for (String roleTypeMasterId : selectedRole) {
			if (Validator.isNull(roleTypeProgDurationRelLocalService
					.findByProgramDurationIdAndRoleTypeMasterId(progDurationId, Long.parseLong(roleTypeMasterId)))) {
				createRoleTypeProgDurationRel(progDurationId, Long.parseLong(roleTypeMasterId), themeDisplay);
			}
		}
	}

	private void handleCreateRoleType(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay) {
		RoleTypeMaster roleTypeMaster = roleTypeMasterLocalService
				.createRoleTypeMaster(counterLocalService.increment(RoleTypeMaster.class.getName(), 1));
		Map<Locale, String> roleTypeName = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME);
		roleTypeMaster.setRoleTypeNameMap(roleTypeName);
		roleTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
		roleTypeMaster.setCreatedBy(themeDisplay.getUserId());
		roleTypeMaster.setModifiedBy(themeDisplay.getUserId());

		roleTypeMaster = roleTypeMasterLocalService.addUpdateRoleTypeMaster(roleTypeMaster,
				new ArrayList<>(roleTypeName.values()), true);

		if (Validator.isNotNull(roleTypeMaster)) {
			if (Validator.isNotNull(roleTypeMaster.getRoleTypeMasterId())
					&& Validator.isNull(roleTypeProgDurationRelLocalService.findByProgramDurationIdAndRoleTypeMasterId(
							progDurationId, roleTypeMaster.getRoleTypeMasterId()))) {
				createRoleTypeProgDurationRel(progDurationId, roleTypeMaster.getRoleTypeMasterId(), themeDisplay);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME_SUCCESS);
			}
		} else {
			setErrorMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME_ERROR);
		}
	}

	private void handleOtherRoleTypes(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay) {
		long[] roleTypesIds = ParamUtil.getLongValues(actionRequest, OmsbSetupProceduresWebPortletKeys.ROLE_TYPE);
		for (long roleTypeId : roleTypesIds) {
			if (Validator.isNull(roleTypeProgDurationRelLocalService
					.findByProgramDurationIdAndRoleTypeMasterId(progDurationId, roleTypeId))) {
				createRoleTypeProgDurationRel(progDurationId, roleTypeId, themeDisplay);
			}
		}
		setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME_SUCCESS);
	}

	private void createRoleTypeProgDurationRel(long progDurationId, long roleTypeMasterId, ThemeDisplay themeDisplay) {
		RoleTypeProgDurationRel roleTypeProgDurationRel = roleTypeProgDurationRelLocalService
				.createRoleTypeProgDurationRel(
						counterLocalService.increment(RoleTypeProgDurationRel.class.getName(), 1));
		roleTypeProgDurationRel.setRoleTypeMasterId(roleTypeMasterId);
		roleTypeProgDurationRel.setProgramDurationId(progDurationId);
		roleTypeProgDurationRel.setGroupId(themeDisplay.getScopeGroupId());
		roleTypeProgDurationRel.setCreatedBy(themeDisplay.getUserId());
		roleTypeProgDurationRel.setModifiedBy(themeDisplay.getUserId());
		roleTypeProgDurationRelLocalService.addRoleTypeProgDurationRel(roleTypeProgDurationRel);
	}

	// Handeling Patient Type Logging Procedure Parameter
	private void handlePatientType(ActionRequest actionRequest, ThemeDisplay themeDisplay, boolean isCreate,
			boolean isEdit) {
		long progDurationId;
		try {
			if (isEdit) {
				progDurationId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION);
				handleEditPatientType(actionRequest, progDurationId, themeDisplay);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME_EDIT_SUCCESS);
			} else {
				progDurationId = ParamUtil.getLong(actionRequest,
						OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_PATIENT);
				if (isCreate) {
					handleCreatePatientType(actionRequest, progDurationId, themeDisplay);
				} else {
					handleOtherPatientTypes(actionRequest, progDurationId, themeDisplay);
				}
			}
		} catch (PortalException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}
	}

	private void handleEditPatientType(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay)
			throws PortalException {
		long patientTypeProgDurationId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_PROG_DURATION_REL_ID);
		String[] selectedPatient = ParamUtil.getParameterValues(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE);

		patientTypeProgDurationRelLocalService.deletePatientTypeProgDurationRel(patientTypeProgDurationId);

		for (String patientTypeMasterId : selectedPatient) {
			if (Validator.isNull(patientTypeProgDurationRelLocalService.findByProgramDurationIdAndPatientTypeMasterId(
					progDurationId, Long.parseLong(patientTypeMasterId)))) {
				createPatientTypeProgDurationRel(progDurationId, Long.parseLong(patientTypeMasterId), themeDisplay);
			}
		}
	}

	private void handleCreatePatientType(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay) {
		PatientTypeMaster patientTypeMaster = patientTypeMasterLocalService
				.createPatientTypeMaster(counterLocalService.increment(PatientTypeMaster.class.getName(), 1));
		Map<Locale, String> patientTypeName = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME);
		patientTypeMaster.setPatientTypeNameMap(patientTypeName);
		patientTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
		patientTypeMaster.setCreatedBy(themeDisplay.getUserId());
		patientTypeMaster.setModifiedBy(themeDisplay.getUserId());

		patientTypeMaster = patientTypeMasterLocalService.addUpdatePatientTypeMaster(patientTypeMaster,
				new ArrayList<>(patientTypeName.values()), true);

		if (Validator.isNotNull(patientTypeMaster)) {
			if (Validator.isNull(patientTypeProgDurationRelLocalService.findByProgramDurationIdAndPatientTypeMasterId(
					progDurationId, patientTypeMaster.getPatientTypeMasterId()))) {
				createPatientTypeProgDurationRel(progDurationId, patientTypeMaster.getPatientTypeMasterId(),
						themeDisplay);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME_SUCCESS);
			}
		} else {
			setErrorMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME_ERROR);
		}
	}

	private void handleOtherPatientTypes(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay) {
		long[] patientTypeIds = ParamUtil.getLongValues(actionRequest, OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE);
		for (long patientTypeId : patientTypeIds) {
			if (Validator.isNull(patientTypeProgDurationRelLocalService
					.findByProgramDurationIdAndPatientTypeMasterId(progDurationId, patientTypeId))) {
				createPatientTypeProgDurationRel(progDurationId, patientTypeId, themeDisplay);
			}
		}
		setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME_SUCCESS);
	}

	private void createPatientTypeProgDurationRel(long progDurationId, long patientTypeMasterId,
			ThemeDisplay themeDisplay) {
		PatientTypeProgDurationRel patientTypeProgDurationRel = patientTypeProgDurationRelLocalService
				.createPatientTypeProgDurationRel(
						counterLocalService.increment(PatientTypeProgDurationRel.class.getName(), 1));
		patientTypeProgDurationRel.setPatientTypeMasterId(patientTypeMasterId);
		patientTypeProgDurationRel.setProgramDurationId(progDurationId);
		patientTypeProgDurationRel.setGroupId(themeDisplay.getScopeGroupId());
		patientTypeProgDurationRel.setCreatedBy(themeDisplay.getUserId());
		patientTypeProgDurationRel.setModifiedBy(themeDisplay.getUserId());
		patientTypeProgDurationRelLocalService.addPatientTypeProgDurationRel(patientTypeProgDurationRel);
	}

	// Handeling Visit Type Logging Procedure Parameter
	private void handleVisitType(ActionRequest actionRequest, ThemeDisplay themeDisplay, boolean isCreate,
			boolean isEdit) {
		long progDurationId;
		try {
			if (isEdit) {
				progDurationId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION);
				handleEditVisitType(actionRequest, progDurationId, themeDisplay);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME_EDIT_SUCCESS);
			} else {
				progDurationId = ParamUtil.getLong(actionRequest,
						OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_VISIT);
				if (isCreate) {
					handleCreateVisitType(actionRequest, progDurationId, themeDisplay);
				} else {
					handleOtherVisitTypes(actionRequest, progDurationId, themeDisplay);
				}
			}
		} catch (PortalException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}
	}

	private void handleEditVisitType(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay)
			throws PortalException {
		long visitTypeProgDurationId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_PROG_DURATION_REL_ID);
		String[] selectedVisit = ParamUtil.getParameterValues(actionRequest,
				OmsbSetupProceduresWebPortletKeys.VISIT_TYPE);

		visitTypeProgDurationRelLocalService.deleteVisitTypeProgDurationRel(visitTypeProgDurationId);

		for (String visitTypeMasterId : selectedVisit) {
			if (Validator.isNull(visitTypeProgDurationRelLocalService
					.findByProgramDurationIdAndVisitTypeMasterId(progDurationId, Long.parseLong(visitTypeMasterId)))) {
				createVisitTypeProgDurationRel(progDurationId, Long.parseLong(visitTypeMasterId), themeDisplay);
			}
		}
	}

	private void handleCreateVisitType(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay) {
		VisitTypeMaster visitTypeMaster = visitTypeMasterLocalService
				.createVisitTypeMaster(counterLocalService.increment(VisitTypeMaster.class.getName(), 1));
		Map<Locale, String> visitTypeName = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME);
		visitTypeMaster.setVisitTypeNameMap(visitTypeName);
		visitTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
		visitTypeMaster.setCreatedBy(themeDisplay.getUserId());
		visitTypeMaster.setModifiedBy(themeDisplay.getUserId());

		visitTypeMaster = visitTypeMasterLocalService.addUpdateVisitTypeMaster(visitTypeMaster,
				new ArrayList<>(visitTypeName.values()), true);

		if (Validator.isNotNull(visitTypeMaster)) {
			if (Validator.isNull(visitTypeProgDurationRelLocalService.findByProgramDurationIdAndVisitTypeMasterId(
					progDurationId, visitTypeMaster.getVisitTypeMasterId()))) {
				createVisitTypeProgDurationRel(progDurationId, visitTypeMaster.getVisitTypeMasterId(), themeDisplay);
				setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME_SUCCESS);
			}
		} else {
			setErrorMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME_ERROR);
		}
	}

	private void handleOtherVisitTypes(ActionRequest actionRequest, long progDurationId, ThemeDisplay themeDisplay) {
		long[] visitTypeIds = ParamUtil.getLongValues(actionRequest, OmsbSetupProceduresWebPortletKeys.VISIT_TYPE);

		for (long visitTypeId : visitTypeIds) {
			if (Validator.isNull(visitTypeProgDurationRelLocalService
					.findByProgramDurationIdAndVisitTypeMasterId(progDurationId, visitTypeId))) {
				createVisitTypeProgDurationRel(progDurationId, visitTypeId, themeDisplay);
			}
		}
		setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME_SUCCESS);
	}

	private void createVisitTypeProgDurationRel(long progDurationId, long visitTypeMasterId,
			ThemeDisplay themeDisplay) {
		VisitTypeProgDurationRel visitTypeProgDurationRel = visitTypeProgDurationRelLocalService
				.createVisitTypeProgDurationRel(
						counterLocalService.increment(VisitTypeProgDurationRel.class.getName(), 1));
		visitTypeProgDurationRel.setVisitTypeMasterId(visitTypeMasterId);
		visitTypeProgDurationRel.setProgramDurationId(progDurationId);
		visitTypeProgDurationRel.setGroupId(themeDisplay.getScopeGroupId());
		visitTypeProgDurationRel.setCreatedBy(themeDisplay.getUserId());
		visitTypeProgDurationRel.setModifiedBy(themeDisplay.getUserId());
		visitTypeProgDurationRelLocalService.addVisitTypeProgDurationRel(visitTypeProgDurationRel);
	}

	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveProcedureLoggingParametersMVCActionCommand.class);

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private RoleTypeMasterLocalService roleTypeMasterLocalService;

	@Reference
	private RoleTypeProgDurationRelLocalService roleTypeProgDurationRelLocalService;

	@Reference
	private VisitTypeMasterLocalService visitTypeMasterLocalService;

	@Reference
	private VisitTypeProgDurationRelLocalService visitTypeProgDurationRelLocalService;

	@Reference
	private PatientTypeMasterLocalService patientTypeMasterLocalService;

	@Reference
	private PatientTypeProgDurationRelLocalService patientTypeProgDurationRelLocalService;

}

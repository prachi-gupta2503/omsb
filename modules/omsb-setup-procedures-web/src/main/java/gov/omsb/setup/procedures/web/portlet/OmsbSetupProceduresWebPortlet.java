package gov.omsb.setup.procedures.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.setup.procedures.web.portlet.util.OmsbSetupProcedureUtil;
import gov.omsb.tms.custom.dto.SetupProcedureDTO;
import gov.omsb.tms.model.CptCodeMaster;
import gov.omsb.tms.model.ParticipationTypeMaster;
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.model.PatientTypeProgDurationRel;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.model.RoleTypeProgDurationRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.model.VisitTypeProgDurationRel;
import gov.omsb.tms.service.CptCodeMasterLocalService;
import gov.omsb.tms.service.ParticipationTypeMasterLocalService;
import gov.omsb.tms.service.PatientTypeMasterLocalService;
import gov.omsb.tms.service.PatientTypeProgDurationRelLocalService;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RoleTypeMasterLocalService;
import gov.omsb.tms.service.RoleTypeProgDurationRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.tms.service.VisitTypeProgDurationRelLocalService;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbSetupProceduresWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbSetupProceduresWebPortletKeys.VIEW_JSP,
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbSetupProceduresWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbSetupProceduresWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);

		String masterValue = ParamUtil.get(renderRequest, OmsbSetupProceduresWebPortletKeys.MASTER_VALUE,
				OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME);

		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		List<ProgramMaster> programMasterList;
		if (isSuperAdmin || isChairman) {
			programMasterList = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} else {
			programMasterList = getProgramList(themeDisplay);
		}

		programMasterList = programMasterList.stream().sorted((first,second)->{
	        String siteFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        String siteSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        return siteFirst.compareTo(siteSecond);
		}).collect(Collectors.toList());
		List<ProcedureGroupMaster> procedureGroupMasters = procedureGroupMasterLocalService
				.getProcedureGroupMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		procedureGroupMasters = procedureGroupMasters.stream().sorted((first,second)->{
	        String groupFirst = first.getProcedureGroupName(themeDisplay.getLocale()).toLowerCase();
	        String groupSecond = second.getProcedureGroupName(themeDisplay.getLocale()).toLowerCase();
	        return groupFirst.compareTo(groupSecond);
		}).collect(Collectors.toList());
		List<ParticipationTypeMaster> participationTypeMasters = participationTypeMasterLocalService
				.getParticipationTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<TraineeLevelMaster> traineeLevelMasters = traineeLevelMasterLocalService
				.getTraineeLevelMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<CptCodeMaster> cptCodeMasters = cptCodeMasterLocalService.getCptCodeMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		List<RotationMaster> rotationMasters = rotationMasterLocalService.getRotationMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		rotationMasters = rotationMasters.stream()
				.filter(rotation -> !OmsbSetupProceduresWebPortletKeys.LEAVE
						.equalsIgnoreCase(rotation.getRotationName(CommonConstants.LANGUAGE_CODE_ENGLISH)))
				.collect(Collectors.toList());
		rotationMasters = rotationMasters.stream().sorted((first,second)->{
	        String groupFirst = first.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        String groupSecond = second.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        return groupFirst.compareTo(groupSecond);
		}).collect(Collectors.toList());
		
		List<ProgramDurationDetails> programDurationDetails = programDurationDetailsLocalService
				.getProgramDurationDetailses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<ProcedureMaster> procedureMasters = procedureMasterLocalService
				.findByProcedureGroupMasterId(GetterUtil.DEFAULT_LONG);
		procedureMasters = procedureMasters.stream().sorted((first,second)->{
	        String groupFirst = first.getProcedureName(themeDisplay.getLocale()).toLowerCase();
	        String groupSecond = second.getProcedureName(themeDisplay.getLocale()).toLowerCase();
	        return groupFirst.compareTo(groupSecond);
		}).collect(Collectors.toList()); 
		List<SetupProcedureDTO> configureProcedureList = progdurationRotationTlPgProcedurePtRelLocalService
				.getSetUpProcedureDetails(themeDisplay.getLocale().toString());

		List<PatientTypeProgDurationRel> patientTypeProgDurationRelList = new ArrayList<>();
		List<RoleTypeProgDurationRel> roleTypeProgDurationRelList = new ArrayList<>();
		List<VisitTypeProgDurationRel> visitTypeProgDurationRelList = new ArrayList<>();
		List<SetupProcedureDTO> setUpProceduresList = new ArrayList<>();
		if (isSuperAdmin) {
			patientTypeProgDurationRelList = patientTypeProgDurationRelLocalService
					.getPatientTypeProgDurationRels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			roleTypeProgDurationRelList = roleTypeProgDurationRelLocalService
					.getRoleTypeProgDurationRels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			visitTypeProgDurationRelList = visitTypeProgDurationRelLocalService
					.getVisitTypeProgDurationRels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			setUpProceduresList = configureProcedureList;
		} else {
			for (ProgramMaster programMaster : programMasterList) {
				List<ProgramDurationDetails> programDurationDetailsByProgram = programDurationDetailsLocalService
						.findProgramDurationByProgramId(programMaster.getProgramMasterId());
				for (ProgramDurationDetails programDurationDetail : programDurationDetailsByProgram) {
					patientTypeProgDurationRelList.addAll(patientTypeProgDurationRelLocalService
							.findByProgramDurationId(programDurationDetail.getProgDurationId()));
					roleTypeProgDurationRelList.addAll(roleTypeProgDurationRelLocalService
							.findByProgramDurationId(programDurationDetail.getProgDurationId()));
					visitTypeProgDurationRelList.addAll(visitTypeProgDurationRelLocalService
							.findByProgramDurationId(programDurationDetail.getProgDurationId()));
					setUpProceduresList.addAll(configureProcedureList.stream()
							.filter(setupProcedureDTO -> setupProcedureDTO
									.getProgramDurationId() == programDurationDetail.getProgDurationId())
							.collect(Collectors.toList()));
				}
			}
		}
		roleTypeProgDurationRelList = roleTypeProgDurationRelList.stream()
				.sorted(Comparator.comparing(RoleTypeProgDurationRel::getModifiedDate).reversed())
				.collect(Collectors.toList());
		patientTypeProgDurationRelList = patientTypeProgDurationRelList.stream()
				.sorted(Comparator.comparing(PatientTypeProgDurationRel::getModifiedDate).reversed())
				.collect(Collectors.toList());
		visitTypeProgDurationRelList = visitTypeProgDurationRelList.stream()
				.sorted(Comparator.comparing(VisitTypeProgDurationRel::getModifiedDate).reversed())
				.collect(Collectors.toList());

		Map<Long, String> visitTypeMapping = getVisitTypeMapping(visitTypeProgDurationRelList, themeDisplay);
		Map<Long, String> patientTypeMapping = getPatientTypeMapping(patientTypeProgDurationRelList, themeDisplay);
		Map<Long, String> roleTypeMapping = getRoleTypeMapping(roleTypeProgDurationRelList, themeDisplay);

		visitTypeMapping = OmsbSetupProcedureUtil.sortMapByValues(visitTypeMapping);
		patientTypeMapping = OmsbSetupProcedureUtil.sortMapByValues(patientTypeMapping);
		roleTypeMapping = OmsbSetupProcedureUtil.sortMapByValues(roleTypeMapping);

		_logger.debug("Setup Procedure List ::: " + setUpProceduresList);

		Map<Long, String> programNameCohotMapping = new HashMap<>();
		for (ProgramDurationDetails programDuration : programDurationDetails) {
			try {
				ProgramMaster programMaster = programMasterLocalService
						.getProgramMaster(programDuration.getProgramId());
				programNameCohotMapping.put(programDuration.getProgDurationId(),
						programMaster.getProgramName(themeDisplay.getLocale()) + StringPool.SPACE
								+ StringPool.OPEN_PARENTHESIS + programDuration.getAyApplicableForm()
								+ StringPool.CLOSE_PARENTHESIS);
			} catch (PortalException e) {
				_logger.error(e);
			}
		}

		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.SDF, sdf);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_MAPPING, visitTypeMapping);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_MAPPING, roleTypeMapping);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_MAPPING, patientTypeMapping);

		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_PROG_DURATION_REL_LIST,
				visitTypeProgDurationRelList);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_PROG_DURATION_REL_LIST,
				roleTypeProgDurationRelList);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_PROG_DURATION_REL_LIST,
				patientTypeProgDurationRelList);

		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.PROGRAM_NAME_COHORT_MAP, programNameCohotMapping);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_PROGRAM_LIST, programMasterList);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_PROCEDURE_GROUPS,
				procedureGroupMasters);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_CPT_CODES, cptCodeMasters);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_PROCEDURES, procedureMasters);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_PROGRAM_DURATIONS,
				programDurationDetails);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_ROTATIONS, rotationMasters);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_TRAINEE_LEVEL_LIST,
				traineeLevelMasters);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_PARTICIPATION_TYPE,
				participationTypeMasters);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_SETUP_PROCEDURE_LIST, setUpProceduresList);

		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.MASTER_NAME, masterValue);

		super.render(renderRequest, renderResponse);
	}

	private List<ProgramMaster> getProgramList(ThemeDisplay themeDisplay) {
		List<ProgramMaster> programList = new ArrayList<>();
		try {
			UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(),
					themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
			List<Long> ids = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
					.collect(Collectors.toList());

			programList = programMasterLocalService.getProgramListByIds(ids);
		} catch (Exception e) {
			_logger.error(e);
		}
		return programList;
	}

	private Map<Long, String> getVisitTypeMapping(List<VisitTypeProgDurationRel> visitTypeProgDurationRelList,
			ThemeDisplay themeDisplay) {
		Map<Long, String> visitTypeMapping = new HashMap<>();

		for (VisitTypeProgDurationRel visitTypeProgDurationRel : visitTypeProgDurationRelList) {
			VisitTypeMaster visitTypeMaster;
			try {
				visitTypeMaster = visitTypeMasterLocalService
						.getVisitTypeMaster(visitTypeProgDurationRel.getVisitTypeMasterId());
				visitTypeMapping.put(visitTypeMaster.getVisitTypeMasterId(),
						visitTypeMaster.getVisitTypeName(themeDisplay.getLocale()));
			} catch (PortalException e) {
				_logger.error(e);
			}
		}

		return visitTypeMapping;
	}

	private Map<Long, String> getRoleTypeMapping(List<RoleTypeProgDurationRel> roleTypeProgDurationRelList,
			ThemeDisplay themeDisplay) {
		Map<Long, String> roleTypeMapping = new HashMap<>();

		for (RoleTypeProgDurationRel roleTypeProgDurationRel : roleTypeProgDurationRelList) {
			RoleTypeMaster roleTypeMaster;
			try {
				roleTypeMaster = roleTypeMasterLocalService
						.getRoleTypeMaster(roleTypeProgDurationRel.getRoleTypeMasterId());
				roleTypeMapping.put(roleTypeMaster.getRoleTypeMasterId(),
						roleTypeMaster.getRoleTypeName(themeDisplay.getLocale()));
			} catch (PortalException e) {
				_logger.error(e);
			}
		}

		return roleTypeMapping;
	}

	private Map<Long, String> getPatientTypeMapping(List<PatientTypeProgDurationRel> patientTypeProgDurationRelList,
			ThemeDisplay themeDisplay) {
		Map<Long, String> patientTypeMapping = new HashMap<>();

		for (PatientTypeProgDurationRel patientTypeProgDurationRel : patientTypeProgDurationRelList) {
			PatientTypeMaster patientTypeMaster;
			try {
				patientTypeMaster = patientTypeMasterLocalService
						.getPatientTypeMaster(patientTypeProgDurationRel.getPatientTypeMasterId());
				patientTypeMapping.put(patientTypeMaster.getPatientTypeMasterId(),
						patientTypeMaster.getPatientTypeName(themeDisplay.getLocale()));
			} catch (PortalException e) {
				_logger.error(e);
			}
		}

		return patientTypeMapping;
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSetupProceduresWebPortlet.class);

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProcedureMasterLocalService procedureMasterLocalService;

	@Reference
	private PatientTypeMasterLocalService patientTypeMasterLocalService;

	@Reference
	private RoleTypeMasterLocalService roleTypeMasterLocalService;

	@Reference
	private VisitTypeMasterLocalService visitTypeMasterLocalService;

	@Reference
	private PatientTypeProgDurationRelLocalService patientTypeProgDurationRelLocalService;

	@Reference
	private RoleTypeProgDurationRelLocalService roleTypeProgDurationRelLocalService;

	@Reference
	private VisitTypeProgDurationRelLocalService visitTypeProgDurationRelLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private CptCodeMasterLocalService cptCodeMasterLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	private ProgdurationRotationTlPgProcedurePtRelLocalService progdurationRotationTlPgProcedurePtRelLocalService;

	@Reference
	private ParticipationTypeMasterLocalService participationTypeMasterLocalService;

	@Reference
	private ProcedureGroupMasterLocalService procedureGroupMasterLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;
}
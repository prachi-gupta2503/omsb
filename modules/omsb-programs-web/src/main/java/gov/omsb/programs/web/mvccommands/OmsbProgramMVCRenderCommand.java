package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
import gov.omsb.common.util.CommonUtil;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.programs.web.dto.TraineeElectiveRotationDTO;
import gov.omsb.programs.web.portlet.util.OmsbProgramGenerateUrlsUtil;
import gov.omsb.programs.web.portlet.util.OmsbProgramUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO;
import gov.omsb.tms.model.CompetenciesMaster;
import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;
import gov.omsb.tms.model.ProgdurationObjectivesRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.service.CompetenciesMasterLocalService;
import gov.omsb.tms.service.ProgdurationCompetenciesRequirementsRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramTypeMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.RotationTypeMasterLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name="
				+ OmsbProgramConstants.PROGRAM_DETAILS_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbProgramMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("Render Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isTrainee = CommonUtil.isTraineeUser(themeDisplay.getUser());
		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());
		boolean isFaculty = CommonUtil.isFacultyUser(themeDisplay.getUser());

		long programMasterId = ParamUtil.getLong(renderRequest, OmsbProgramConstants.PROGRAM_MASTER_ID);
		try {
			ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programMasterId);
			List<ProgramMaster> otherProgramList;
			if (isSuperAdmin || isChairman) {
				otherProgramList = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			} else {
				otherProgramList = getOtherProgramList(themeDisplay, programMaster);
			}

			List<ProgramTypeMaster> programTypeMasters = programTypeMasterLocalService
					.getProgramTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			SimpleDateFormat sdf = new SimpleDateFormat(OmsbProgramConstants.DATE_FORMAT);
			Date estDate = programMaster.getEstablishmentDate();
			renderRequest.setAttribute("formatedEstablishmentDate", sdf.format(estDate));
			renderRequest.setAttribute(OmsbProgramConstants.RENDER_ESTABLISHMENT_DATE, estDate);

			// SET Program Duration (Cohort)
			List<ProgramDurationDetails>  programDurationDetails = new ArrayList<>(programDurationDetailsLocalService.findProgramDurationByProgramId(programMasterId));

			// Sortin list based on Year
	        Collections.sort(programDurationDetails, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));

			
			long progDurationId = GetterUtil.DEFAULT_LONG;
			if(!programDurationDetails.isEmpty()) {
				progDurationId = programDurationDetails.get(GetterUtil.DEFAULT_INTEGER).getProgDurationId();
			}			
						
			programTypeMasters = programTypeMasters.stream().sorted((first,second)->{
		        String programTypeFirst = first.getProgramTypeName(themeDisplay.getLocale()).toLowerCase();
		        String programTypeSecond = second.getProgramTypeName(themeDisplay.getLocale()).toLowerCase();
		        return programTypeFirst.compareTo(programTypeSecond);
			}).collect(Collectors.toList());
			
			renderRequest.setAttribute(CommonConstants.PROGRAM, programMaster);
			renderRequest.setAttribute(OmsbProgramConstants.RENDER_PROGRAM_TYPE_LIST, programTypeMasters);
			renderRequest.setAttribute(CommonConstants.OTHER_PROGRAM_LIST, otherProgramList);

			List<TraineeLevelMaster> traineeLevelMasters = traineeLevelMasterLocalService
					.getTraineeLevelMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<ProgramStructureDTO> programStructureDTOList = programMasterLocalService
					.getProgramStructure(programMasterId, themeDisplay.getLocale().toString());

			List<TrainingSiteByProgramDTO> trainingSiteByProgramDTOs = rotationTrainingsitesRelLocalService
					.getTrainingSiteDetailsByProgram(programMasterId, themeDisplay.getLocale().toString());
			
			List<RotationMaster> rotationMasterList = rotationMasterLocalService.getRotationMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			rotationMasterList = rotationMasterList.stream().filter(obj -> !OmsbTmsCommonConstants.LEAVE.equalsIgnoreCase(obj.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH))).collect(Collectors.toList());
	
			List<RotationTypeMaster> rotationTypeMasters = rotationTypeMasterLocalService.getRotationTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			if(isTrainee) {
				setDataForTrainee(programMasterId, programMaster, renderRequest, themeDisplay);
			} else if (isFaculty) {
			    renderRequest.setAttribute(OmsbProgramConstants.PROG_DURATION_OBJECTIVES_REL, OmsbObjectivesMVCResourceCommand.getProgramObjectivesByProgramDurationId(progDurationId, null, themeDisplay.getLocale()));
				renderRequest.setAttribute(OmsbProgramConstants.COMPETENCIES_REQUIRMENTS_REL, OmsbObjectivesMVCResourceCommand.getSpecificObjectivesByProgramDurationId(progDurationId, null, themeDisplay.getLocale()));
			} else {
				List<ProgdurationCompetenciesRequirementsRel> competenciesRequirementsRels = OmsbProgramUtil.getCompetenciesRequirementsListByProgDurationIdAndCompetencyType(progDurationId);
				List<ProgdurationObjectivesRel> progdurationObjectivesRels = OmsbProgramUtil.getProgdurationObjectivesListByProgDurationIdAndObjetiveType(progDurationId);

				renderRequest.setAttribute(OmsbProgramConstants.PROG_DURATION_OBJECTIVES_REL, progdurationObjectivesRels);
				renderRequest.setAttribute(OmsbProgramConstants.COMPETENCIES_REQUIRMENTS_REL, competenciesRequirementsRels);
			}

			renderRequest.setAttribute(OmsbProgramConstants.TRAINING_SITE_LIST,
					OmsbProgramUtil.getTrainingSiteList(trainingSiteByProgramDTOs));
			renderRequest.setAttribute(OmsbProgramConstants.PROGRAM_STRUCTURE_LIST,
					OmsbProgramUtil.getProgramStructure(programStructureDTOList, traineeLevelMasters, themeDisplay));
			renderRequest.setAttribute(OmsbProgramConstants.IS_TRAINEE, isTrainee);
			renderRequest.setAttribute(OmsbProgramConstants.IS_FACULTY, isFaculty);
			renderRequest.setAttribute("isChairman", isChairman);
			renderRequest.setAttribute(OmsbProgramConstants.TRAINEE_LEVEL_MASTERS, traineeLevelMasters);
			
			renderRequest.setAttribute(OmsbProgramConstants.ROTATION_MASTER_LIST,rotationMasterList);
			renderRequest.setAttribute("rotationTypeMasterList", rotationTypeMasters);

			List<CompetenciesMaster> competenciesMasters = competenciesMasterLocalService.getCompetenciesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	    	
			renderRequest.setAttribute("programDurationDetailList", programDurationDetails);
			renderRequest.setAttribute(OmsbProgramConstants.COMPETENCIES, competenciesMasters);
			renderRequest.setAttribute(OmsbTmsCommonConstants.VIEW_PROGRAM_COHORT_RENDER_URL_LABEL, OmsbProgramGenerateUrlsUtil.createViewProgramCohortRenderUrl(themeDisplay, renderRequest,programMasterId));
			renderRequest.setAttribute(OmsbTmsCommonConstants.ADD_PROGRAM_COHORT_RENDER_URL_LABEL, OmsbProgramGenerateUrlsUtil.createAddProgramCohortRenderUrl(themeDisplay, renderRequest, programMasterId, themeDisplay.getURLCurrent()));
		} catch (PortalException e) {
			_logger.error(e);
		}
		_logger.info("Render Exit ::: ");
		return CommonConstants.PROGRAM_DETAILS_PAGE_URL;
	}

	private List<ProgramMaster> getOtherProgramList(ThemeDisplay themeDisplay, ProgramMaster programMaster) {
		List<ProgramMaster> otherProgramList = new ArrayList<>();
		try {
			UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(),
					themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
			List<Long> ids = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
					.collect(Collectors.toList());

			otherProgramList = programMasterLocalService.getProgramListByIdsAndStatus(ids,
					programMaster.getProgramStatus());
		} catch (Exception e) {
			_logger.error(e);
		}
		return otherProgramList;
	}
	
	private Map<Long, String> getTraineeLevelsMap(long programId, Locale currentLocale) {
	    Map<Long, String> traineeLevelsMap = new HashMap<>();

	    List<Long> programDurationIds = programDurationDetailsLocalService.findProgramDurationByProgramId(programId)
	            .stream().map(ProgramDurationDetails::getProgDurationId).collect(Collectors.toList());
	    List<Long> traineeLevelIds = new ArrayList<>();

	    for (Long programDurationId : programDurationIds) {
	        traineeLevelIds.addAll(progdurationTraineelevelBlocksLevelTypeRelLocalService
	                .findByProgramDurationId(programDurationId).stream()
	                .map(ProgdurationTraineelevelBlocksLevelTypeRel::getTraineeLevelId)
	                .collect(Collectors.toList()));
	    }

	    TraineeLevelMaster traineeLevelMaster;
	    for (Long traineeLevelId : traineeLevelIds) {
	        traineeLevelMaster = traineeLevelMasterLocalService.fetchTraineeLevelMaster(traineeLevelId);
	        if (Validator.isNotNull(traineeLevelMaster)) {
	            traineeLevelsMap.put(traineeLevelId,
	                    traineeLevelMaster.getTraineeLevelName(currentLocale));
	        }
	    }

	    _logger.debug("Trainee Level List - " + traineeLevelsMap.toString());
	    return traineeLevelsMap;
	}

	private void setDataForTrainee(long programMasterId, ProgramMaster programMaster, RenderRequest renderRequest, ThemeDisplay themeDisplay) {

		long programDurationId;

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = traineeAdmissionDetailsRelLocalService.findByTraineeId(themeDisplay.getUserId());
		programDurationId = Validator.isNotNull(traineeAdmissionDetailsRel) ? traineeAdmissionDetailsRel.getProgramDurationId() : GetterUtil.DEFAULT_LONG;

	    List<TraineeElectiveRotationDTO> traineeElectiveRotationsList = fetchTraineeElectiveRotations(themeDisplay, programDurationId);
	    
	    renderRequest.setAttribute(OmsbProgramConstants.PROG_DURATION_OBJECTIVES_REL, OmsbObjectivesMVCResourceCommand.getProgramObjectivesByProgramDurationId(programDurationId, null, themeDisplay.getLocale()));
		renderRequest.setAttribute(OmsbProgramConstants.COMPETENCIES_REQUIRMENTS_REL, OmsbObjectivesMVCResourceCommand.getSpecificObjectivesByProgramDurationId(programDurationId, null, themeDisplay.getLocale()));
	    renderRequest.setAttribute(OmsbProgramConstants.TRAINEE_ELECTIVE_ROTATIONS_LIST, traineeElectiveRotationsList);
	    renderRequest.setAttribute(OmsbProgramConstants.TRAINEE_LEVEL_MAP, getTraineeLevelsMap(programMasterId, themeDisplay.getLocale()));
	    renderRequest.setAttribute(OmsbProgramConstants.PROGRAM_NAME, programMaster.getProgramName(themeDisplay.getLocale()));
	}

	private List<TraineeElectiveRotationDTO> fetchTraineeElectiveRotations(ThemeDisplay themeDisplay, long programDurationId) {
	    List<TraineeElectiveRotationDTO> traineeElectiveRotationsList = new ArrayList<>();

	    if (Validator.isNotNull(programDurationId)) {
	        List<TraineeProgdurationTraineelevelDetails> traineeProgdurationTraineelevelDetails = traineeProgdurationTraineelevelDetailsLocalService.findByTraineeIdAndProgramDurationId(themeDisplay.getUserId(), programDurationId);

	        for (TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetail : traineeProgdurationTraineelevelDetails) {
	            List<TraineeElectiverotationPriorityDetails> traineeElectiverotationPriorityDetails = traineeElectiverotationPriorityDetailsLocalService.findByTraineePdTlErDetailsId(traineeProgdurationTraineelevelDetail.getTraineePdTlErDetailsId());

	            TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService.fetchTraineeLevelMaster(traineeProgdurationTraineelevelDetail.getTraineeLevelId());

	            if (Validator.isNotNull(traineeLevelMaster)) {
	                for (TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetail : traineeElectiverotationPriorityDetails) {
	                    TraineeElectiveRotationDTO traineeElectiveRotationDTO = createTraineeElectiveRotationDTO(traineeProgdurationTraineelevelDetail, themeDisplay, traineeElectiverotationPriorityDetail, traineeLevelMaster);
	                    traineeElectiveRotationsList.add(traineeElectiveRotationDTO);
	                }
	            }
	        }
	    }

	    return traineeElectiveRotationsList;
	}

	private TraineeElectiveRotationDTO createTraineeElectiveRotationDTO(TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetail, ThemeDisplay themeDisplay, TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetail, TraineeLevelMaster traineeLevelMaster) {
	    TraineeElectiveRotationDTO traineeElectiveRotationDTO = new TraineeElectiveRotationDTO();
	    traineeElectiveRotationDTO.setTraineePdTlErDetailsId(traineeProgdurationTraineelevelDetail.getTraineePdTlErDetailsId());

	    RotationMaster rotationMaster = rotationMasterLocalService.fetchRotationMaster(traineeElectiverotationPriorityDetail.getRotationId());
	    if (Validator.isNotNull(rotationMaster)) {
	        traineeElectiveRotationDTO.setElectiveRotation(rotationMaster.getRotationName(themeDisplay.getLocale()));
	    }

	    traineeElectiveRotationDTO.setElectiverotationPriorityDetailsId(traineeElectiverotationPriorityDetail.getTraineeElectiverotationPriorityDetailsId());
	    traineeElectiveRotationDTO.setTraineeLevelId(traineeProgdurationTraineelevelDetail.getTraineeLevelId());
	    traineeElectiveRotationDTO.setTraineeLevel(traineeLevelMaster.getTraineeLevelName(themeDisplay.getLocale()));

	    return traineeElectiveRotationDTO;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private ProgramTypeMasterLocalService programTypeMasterLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService rotationTrainingsitesRelLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;

	@Reference
	private CompetenciesMasterLocalService competenciesMasterLocalService;
	
	@Reference
	private ProgdurationCompetenciesRequirementsRelLocalService competenciesRequirementsRelService;

	@Reference
	private TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService;

	@Reference
	private TraineeProgdurationTraineelevelDetailsLocalService traineeProgdurationTraineelevelDetailsLocalService;

	@Reference
	private TraineeElectiverotationPriorityDetailsLocalService traineeElectiverotationPriorityDetailsLocalService;

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramMVCRenderCommand.class.getName());
}

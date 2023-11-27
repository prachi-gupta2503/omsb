package gov.omsb.programs.web.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO;
import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;
import gov.omsb.tms.model.ProgdurationObjectivesRel;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgdurationCompetenciesRequirementsRelLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationObjectivesRelLocalServiceUtil;

/**
 * 
 * @author Jayesh Goswami
 *
 */
public class OmsbProgramUtil {

	private OmsbProgramUtil() {
	}

	public static Map<Long, String> getTrainingSiteList(List<TrainingSiteByProgramDTO> programStructureDTOList) {
		_logger.info("getTrainingSiteList Invoked ::: ");
		HashMap<Long, String> trainingSiteList = new HashMap<>();
		for (TrainingSiteByProgramDTO structureDTO : programStructureDTOList) {
			trainingSiteList.put(structureDTO.getTrainingSiteId(), structureDTO.getTrainingSiteName());
		}
		_logger.info("getTrainingSiteList Exit ::: ");
		return trainingSiteList;
	}

	public static Map<String, HashMap<String, Long>> getProgramStructure(
			List<ProgramStructureDTO> programStructureDTOList, List<TraineeLevelMaster> traineeLevelMasters,
			ThemeDisplay themeDisplay) {
		_logger.info("getProgramStructure Invoked ::: ");
		HashMap<String, HashMap<String, Long>> rotation = new LinkedHashMap<>();
		for (ProgramStructureDTO structureDTO : programStructureDTOList) {
			if (rotation.containsKey(structureDTO.getRotationName() + StringPool.DASH + structureDTO.getRotationId())) {
				rotation.get(structureDTO.getRotationName() + StringPool.DASH + structureDTO.getRotationId())
						.put(structureDTO.getTraineeLevelName(), structureDTO.getNoOfBlocks());
			} else {
				HashMap<String, Long> traineeLevelData = new LinkedHashMap<>();
				for (TraineeLevelMaster levelMaster : traineeLevelMasters) {
					traineeLevelData.put(levelMaster.getTraineeLevelName(themeDisplay.getLocale()), 0l);
				}
				traineeLevelData.put(structureDTO.getTraineeLevelName(), structureDTO.getNoOfBlocks());
				rotation.put(structureDTO.getRotationName() + StringPool.DASH + structureDTO.getRotationId(),
						traineeLevelData);
			}
		}
		_logger.info("getProgramStructure Exit ::: ");
		return rotation;
	}

	public static ProgramMaster createProgramMasterObject(ActionRequest actionRequest, ProgramMaster programMaster,
			boolean isCreate) {
		_logger.info("createProgramMasterObject Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Map<Locale, String> programName = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbProgramConstants.PROGRAM_NAME);
		Map<Locale, String> programCode = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbProgramConstants.PROGRAM_CODE);
		Map<Locale, String> programVision = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbProgramConstants.PROGRAM_VISION);
		Map<Locale, String> programMission = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbProgramConstants.PROGRAM_MISSION);
		Map<Locale, String> programObjectives = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbProgramConstants.PROGRAM_OBJECTIVES);
		Map<Locale, String> programDescription = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbProgramConstants.PROGRAM_DESCRIPTION);
		Map<Locale, String> programAdmissionRequirements = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbProgramConstants.PROGRAM_ADMISSION_REQUIREMENTS);
		Date establishmentDate = ParamUtil.getDate(actionRequest, OmsbProgramConstants.PROGRAM_ESTABLISHMENT_DATE,
				new SimpleDateFormat(OmsbProgramConstants.DATE_FORMAT));
		Boolean programStatus = ParamUtil.getBoolean(actionRequest, OmsbProgramConstants.PROGRAM_STATUS, Boolean.TRUE);
		long programTypeId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.PROGRAM_TYPE_MASTER_ID);

		if (isCreate) {
			programMaster.setCreateDate(new Date());
		}

		if (Validator.isNotNull(programMaster)) {
			programMaster.setGroupId(themeDisplay.getScopeGroupId());
			programMaster.setProgramNameMap(programName);
			programMaster.setProgramCodeMap(programCode);
			programMaster.setEstablishmentDate(establishmentDate);
			programMaster.setProgramObjectivesMap(programObjectives);
			programMaster.setProgramDescriptionMap(programDescription);
			programMaster.setProgramAdmissionRequirementsMap(programAdmissionRequirements);
			programMaster.setProgramVisionMap(programVision);
			programMaster.setProgramMissionMap(programMission);
			programMaster.setProgramStatus(programStatus);
			programMaster.setModifiedDate(new Date());
			programMaster.setProgramTypeId(programTypeId);
		}

		_logger.info("createProgramMasterObject Exit ::: ");
		return programMaster;
	}
	
	public static ProgdurationCompetenciesRequirementsRel createCompetenciesRequirementsRelObject(ActionRequest actionRequest, ProgdurationCompetenciesRequirementsRel competenciesRequirementsRel,
			long competencyMasterId, Map<Locale, String> requirements, boolean isCreate) {
		_logger.info("createCompetenciesRequirementsRelObject Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.PROG_DURARION_ID);
		
		if (Validator.isNotNull(competenciesRequirementsRel)) {
			competenciesRequirementsRel.setProgDurationId(progDurationId);
			competenciesRequirementsRel.setCompetenciesMasterId(competencyMasterId);
			competenciesRequirementsRel.setRequirementsMap(requirements);
			
			if (isCreate) {
				competenciesRequirementsRel.setCreateDate(new Date());
			}
			
			competenciesRequirementsRel.setModifiedDate(new Date());
			competenciesRequirementsRel.setGroupId(themeDisplay.getScopeGroupId());
			competenciesRequirementsRel.setCompanyId(themeDisplay.getCompanyId());
		}
		
		return competenciesRequirementsRel;
	}
	
	public static ProgdurationObjectivesRel createProgDurationObjectiveObject(ActionRequest actionRequest, ProgdurationObjectivesRel progdurationObjectivesRel, 
			Map<Locale, String> programObjectives, boolean isCreate) {
		_logger.info("createCompetenciesRequirementsRelObject Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.PROG_DURARION_ID);
		
		if (Validator.isNotNull(progdurationObjectivesRel)) {
			progdurationObjectivesRel.setProgDurationId(progDurationId);
			progdurationObjectivesRel.setObjectivesMap(programObjectives);
			
			if (isCreate) {
				progdurationObjectivesRel.setCreateDate(new Date());
			}
			
			progdurationObjectivesRel.setModifiedDate(new Date());
			progdurationObjectivesRel.setGroupId(themeDisplay.getScopeGroupId());
			progdurationObjectivesRel.setCompanyId(themeDisplay.getCompanyId());
		}
		
		return progdurationObjectivesRel;
	}
	
	public static List<ProgdurationCompetenciesRequirementsRel> getCompetenciesRequirementsListByProgDurationIdAndCompetencyType(long progDurationId){
		DynamicQuery dynamicQuery = ProgdurationCompetenciesRequirementsRelLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("progDurationId").eq(progDurationId));
	    return ProgdurationCompetenciesRequirementsRelLocalServiceUtil.dynamicQuery(dynamicQuery);
	}
	
	public static List<ProgdurationObjectivesRel> getProgdurationObjectivesListByProgDurationIdAndObjetiveType(long progDurationId){
		DynamicQuery dynamicQuery = ProgdurationObjectivesRelLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("progDurationId").eq(progDurationId));
	    return ProgdurationObjectivesRelLocalServiceUtil.dynamicQuery(dynamicQuery);
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramUtil.class.getName());

}

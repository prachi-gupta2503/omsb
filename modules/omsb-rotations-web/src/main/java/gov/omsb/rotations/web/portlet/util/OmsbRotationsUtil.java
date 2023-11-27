package gov.omsb.rotations.web.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import gov.omsb.rotations.web.constants.OmsbRotationsWebPortletKeys;
import gov.omsb.rotations.web.dto.ProgramRotationDTO;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.RotationStructureDTO;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.RotationCompetenciesRequirementsRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationObjectivesRel;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgdurationCompetenciesRequirementsRelLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationObjectivesRelLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil;
import gov.omsb.tms.service.ProgramDurationDetailsLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.RotationCompetenciesRequirementsRelLocalServiceUtil;
import gov.omsb.tms.service.RotationObjectivesRelLocalServiceUtil;
import gov.omsb.tms.service.RotationTypeMasterLocalServiceUtil;

/**
 * 
 * @author Jayesh Goswami
 *
 */
public class OmsbRotationsUtil {
	
	private OmsbRotationsUtil() {}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param request
	 * @param progDurationId
	 * @return
	 */
	public static String createProgramDetailsPageRenderUrl(ThemeDisplay themeDisplay, PortletRequest request, long progDurationId) {
		_logger.info("createProgramDetailsPageRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
			long programMasterId = ProgramDurationDetailsLocalServiceUtil.getProgramDurationDetails(progDurationId).getProgramId();
			String portletId = OmsbRotationsWebPortletKeys.OMSBPROGRAMSWEB;
			long plId = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
			PortletURL programListRenderUrl = PortletURLFactoryUtil.getPortletURLFactory().create(request, portletId, plId,
					PortletRequest.RENDER_PHASE);
			programListRenderUrl.getRenderParameters().setValue("p_p_state", "normal");
			programListRenderUrl.getRenderParameters().setValue("p_p_mode", "view");
			programListRenderUrl.getRenderParameters().setValue(OmsbRotationsWebPortletKeys.MVC_RENDER_COMMAND_NAME, "/program-details");
			programListRenderUrl.getRenderParameters().setValue("programMasterId", String.valueOf(programMasterId));
			renderUrlStr = programListRenderUrl.toString();
		} catch (PortalException e) {
			_logger.error("createProgramDetailsPageRenderUrl Error ::: " + e);
		}
		_logger.info("createProgramDetailsPageRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param request
	 * @param rotationMasterId
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String createAddRotationRenderUrl(ThemeDisplay themeDisplay, PortletRequest request, long progDurationId) {
		_logger.info("createAddRotationRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request,
					themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(OmsbRotationsWebPortletKeys.PROGRAM_DURATION_ID, String.valueOf(progDurationId));
			renderUrl.setParameter(OmsbRotationsWebPortletKeys.MVC_RENDER_COMMAND_NAME,
					OmsbRotationsWebPortletKeys.ROTATION_ADD_MVC_RENDER_COMMAND);
		   renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createAddRotationRenderUrl Error ::: " + e);
		}
		_logger.info("createAddRotationRenderUrl Exit ::: ");
		return renderUrlStr;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param request
	 * @param rotationMasterId
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String createRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, long rotationMasterId) {
		_logger.info("createRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
		PortletURL renderUrl =  PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		   renderUrl.setWindowState(WindowState.NORMAL);
		   renderUrl.setPortletMode(PortletMode.VIEW);
		   renderUrl.setParameter(OmsbRotationsWebPortletKeys.MVC_RENDER_COMMAND_NAME, OmsbTmsCommonConstants.ROTATION_DETAILS_MVC_RENDER_COMMAND);
		   renderUrl.setParameter(OmsbRotationsWebPortletKeys.ROTATION_MASTER_ID, String.valueOf(rotationMasterId));
		   renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createRenderUrl Error ::: " + e);
		}
		_logger.info("createRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param rotationsMaster
	 * @return
	 */
	public static RotationMaster createRotationMasterObject(ActionRequest actionRequest, RotationMaster rotationsMaster) {
		_logger.info("createRotationMasterObject Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Map<Locale, String> rotationCode = LocalizationUtil.getLocalizationMap(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_CODE );
		Map<Locale, String> rotationName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_NAME);
		Map<Locale, String> rotationShortName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_SHORT_NAME);
		Map<Locale, String> rotationObjectives = LocalizationUtil.getLocalizationMap(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_OBJECTIVES);
		Boolean rotationStatus = ParamUtil.getBoolean(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_STATUS, Boolean.TRUE);

		rotationsMaster.setRotationCodeMap(rotationCode);
		rotationsMaster.setRotationNameMap(rotationName);
		rotationsMaster.setRotationShortNameMap(rotationShortName);
		rotationsMaster.setRotationObjectivesMap(rotationObjectives);
		rotationsMaster.setRotationStatus(rotationStatus);
		rotationsMaster.setGroupId(themeDisplay.getScopeGroupId());
		
		_logger.info("createRotationMasterObject Exit ::: ");
		return rotationsMaster;
	}
	
	/**
	 * 
	 * @param resourceRequest
	 * @param themeDisplay
	 * @param rotationMasterList
	 * @return
	 */
	public static JSONObject preapareRotationResponseJson(ResourceRequest resourceRequest, ThemeDisplay themeDisplay,
			List<RotationMaster> rotationMasterList) {
		_logger.info("preapareRotationResponseJson Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray rotationMasterListJSONArray = JSONFactoryUtil.createJSONArray();
		for (RotationMaster rotationMaster : rotationMasterList) {
			if(!OmsbTmsCommonConstants.LEAVE.equalsIgnoreCase(rotationMaster.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH))) {
				JSONObject rotationJson = JSONFactoryUtil.createJSONObject();
				rotationJson.put(OmsbRotationsWebPortletKeys.ROTATION_NAME, rotationMaster.getRotationName(themeDisplay.getLocale()));
				rotationJson.put(OmsbRotationsWebPortletKeys.RENDER_URL, OmsbRotationsUtil.createRenderUrl(themeDisplay, resourceRequest, rotationMaster.getRotationMasterId()));
				rotationMasterListJSONArray.put(rotationJson);	
			}
		}
		
		resultJson.put(OmsbRotationsWebPortletKeys.SUCCESS, true);
		resultJson.put(OmsbRotationsWebPortletKeys.RESULT, rotationMasterListJSONArray);
		_logger.info("preapareRotationResponseJson Exit ::: ");
		return resultJson;
	}
	
	/**
	 * 
	 * @param rotationMasterId
	 * @param themeDisplay
	 * @param traineeLevelMasters
	 * @return Map<String, ProgramRotationDTO>
	 */
	public static Map<String, ProgramRotationDTO> getRotationStructure(ThemeDisplay themeDisplay, List<TraineeLevelMaster> traineeLevelMasters, List<RotationStructureDTO> rotationStructureDTOList) {
		HashMap<String, ProgramRotationDTO> programDTOList = new HashMap<>();
		_logger.info("getRotationStructure Invoked ::: ");
		for(RotationStructureDTO structureDTO : rotationStructureDTOList) {
			if(programDTOList.containsKey(structureDTO.getProgramName())) {
				// Set Number of Blocks for the Residential level for exising program
				ProgramRotationDTO rotationDTO = programDTOList.get(structureDTO.getProgramName());
				rotationDTO.getRotationTrainingLevel().put(structureDTO.getTraineeLevelName(), structureDTO.getNoOfBlocks());
			
			} else {
				// Set Default Residential level to 0
				HashMap<String, Long> trainingLevelData = new LinkedHashMap<>();
				for(TraineeLevelMaster levelMaster : traineeLevelMasters) {
					trainingLevelData.put(levelMaster.getTraineeLevelName(themeDisplay.getLocale()), 0l);
				}
				
				// Set Number of Blocks for the Residential level
				if(trainingLevelData.containsKey(structureDTO.getTraineeLevelName())) {
					trainingLevelData.put(structureDTO.getTraineeLevelName(), structureDTO.getNoOfBlocks());
				}
				
				// Set ProgramRotationDTO
				ProgramRotationDTO programRotationDTO = new ProgramRotationDTO(structureDTO.getProgramName(), structureDTO.getProgramId(), trainingLevelData);
				programDTOList.put(structureDTO.getProgramName(), programRotationDTO);
			}
		}
		_logger.debug("getRotationStructure ::: Total Program : " + programDTOList.size());
		_logger.info("getRotationStructure Exit ::: ");
		return programDTOList;
	}
	
	public static RotationCompetenciesRequirementsRel createCompetenciesRequirementsRelObject(ActionRequest actionRequest, RotationCompetenciesRequirementsRel competenciesRequirementsRel,
			long competencyMasterId, Map<Locale, String> requirements, long rotationId, boolean isCreate) {
		_logger.info("createCompetenciesRequirementsRelObject Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.PROG_DURARION_ID);
		
		if (Validator.isNotNull(competenciesRequirementsRel)) {
			competenciesRequirementsRel.setProgDurationId(progDurationId);
			competenciesRequirementsRel.setRotationId(rotationId);
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
	
	public static RotationObjectivesRel createRotationObjectiveObject(ActionRequest actionRequest, RotationObjectivesRel rotationObjectivesRel, 
			Map<Locale, String> programObjectives, long rotationId, boolean isCreate) {
		_logger.info("createCompetenciesRequirementsRelObject Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.PROG_DURARION_ID);
		
		if (Validator.isNotNull(rotationObjectivesRel)) {
			rotationObjectivesRel.setProgDurationId(progDurationId);
			rotationObjectivesRel.setRotationId(rotationId);
			rotationObjectivesRel.setObjectivesMap(programObjectives);

			if (isCreate) {
				rotationObjectivesRel.setCreateDate(new Date());
			}
			
			rotationObjectivesRel.setModifiedDate(new Date());
			rotationObjectivesRel.setGroupId(themeDisplay.getScopeGroupId());
			rotationObjectivesRel.setCompanyId(themeDisplay.getCompanyId());
		}
		
		return rotationObjectivesRel;
	}
	
	public static ProgdurationRotationTraineelevelBlocksRel createProgdurationRotationTraineelevelBlocksRelObject(ActionRequest actionRequest, ProgdurationRotationTraineelevelBlocksRel traineelevelBlocksLevelTypeRel, 
			long traineeLevelId, long rotationId, boolean isCreate) {
		_logger.info("createProgdurationRotationTraineelevelBlocksRelObject Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.PROG_DURARION_ID);
		
		if (Validator.isNotNull(traineelevelBlocksLevelTypeRel)) {
			traineelevelBlocksLevelTypeRel.setProgramDurationId(progDurationId);
			traineelevelBlocksLevelTypeRel.setRotationId(rotationId);
			
			if(isCreate) {
				long rotationTypeId = getRotationTypeId();
		
				traineelevelBlocksLevelTypeRel.setRotationType(rotationTypeId);
				traineelevelBlocksLevelTypeRel.setTraineeLevelId(traineeLevelId);
				traineelevelBlocksLevelTypeRel.setCreateDate(new Date());
				traineelevelBlocksLevelTypeRel.setCreatedBy(themeDisplay.getUserId());
			}else {
				traineelevelBlocksLevelTypeRel.setModifiedDate(new Date());
			}
			
			traineelevelBlocksLevelTypeRel.setGroupId(themeDisplay.getScopeGroupId());
			traineelevelBlocksLevelTypeRel.setCompanyId(themeDisplay.getCompanyId());
			traineelevelBlocksLevelTypeRel.setModifiedBy(themeDisplay.getUserId());
		}
		
		_logger.info("traineelevelBlocksLevelTypeRel :: " + traineelevelBlocksLevelTypeRel);
		
		return traineelevelBlocksLevelTypeRel;
	}
	
	public static List<RotationCompetenciesRequirementsRel> getCompetenciesRequirementsListByProgDurationIdAndRotationId(long progDurationId, long rotationId){
		DynamicQuery dynamicQuery = RotationCompetenciesRequirementsRelLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("progDurationId").eq(progDurationId));
		dynamicQuery.add(PropertyFactoryUtil.forName("rotationId").eq(rotationId));
	    return ProgdurationCompetenciesRequirementsRelLocalServiceUtil.dynamicQuery(dynamicQuery);
	}
	
	public static List<RotationObjectivesRel> getRotationObjectivesListByProgDurationIdAndRotationId(long progDurationId, long rotationId){
		DynamicQuery dynamicQuery = RotationObjectivesRelLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("progDurationId").eq(progDurationId));
		dynamicQuery.add(PropertyFactoryUtil.forName("rotationId").eq(rotationId));
	    return ProgdurationObjectivesRelLocalServiceUtil.dynamicQuery(dynamicQuery);
	}
	
	public static long getRotationTypeId() {
		long id = 0;
		List<RotationTypeMaster> rotationTypeMasters = RotationTypeMasterLocalServiceUtil.getRotationTypeMasters(-1, -1);
		_logger.debug("rotationTypeMasters" + rotationTypeMasters);
		for(RotationTypeMaster rotationTypeMaster : rotationTypeMasters) {
			if(rotationTypeMaster.getRotationTypeName(Locale.US).equals("Core")) {
				id = rotationTypeMaster.getRotationTypeMasterId();
				break;
			}
		}
		return id;
	}
	
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> getProgdurationTraineelevelBlocksLevelTypeRel(long progDurationId){
		DynamicQuery dynamicQuery = ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("programDurationId").eq(progDurationId));
	    return ProgdurationObjectivesRelLocalServiceUtil.dynamicQuery(dynamicQuery);
	}
	
	public static String getProgramNameWithCohort(long programDurationId, ThemeDisplay themeDisplay) {
		ProgramDurationDetails programDurationDetails;
		String programNameWithCohort = StringPool.BLANK;
		try {
			programDurationDetails = ProgramDurationDetailsLocalServiceUtil
					.getProgramDurationDetails(programDurationId);
			programNameWithCohort = ProgramMasterLocalServiceUtil.getProgramMaster(programDurationDetails.getProgramId()).getProgramName(themeDisplay.getLocale())
					+ StringPool.SPACE + StringPool.OPEN_PARENTHESIS + programDurationDetails.getAyApplicableForm()
					+ StringPool.CLOSE_PARENTHESIS; 
		} catch (PortalException e) {
			_logger.error(e);
		}
		return programNameWithCohort;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbRotationsUtil.class.getName());

}

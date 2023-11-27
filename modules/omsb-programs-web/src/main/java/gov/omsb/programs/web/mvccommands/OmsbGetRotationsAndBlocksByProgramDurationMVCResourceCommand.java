package gov.omsb.programs.web.mvccommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.programs.web.dto.RotationDTO;
import gov.omsb.programs.web.dto.TraineeLevelDTO;
import gov.omsb.programs.web.portlet.util.OmsbProgramGenerateUrlsUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.RotationTypeMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/get/rotations-and-blocks-by-program-duration" }, service = MVCResourceCommand.class)
public class OmsbGetRotationsAndBlocksByProgramDurationMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long programDurationId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM_DURATION_ID, 0l);

		List<ProgramStructureDTO> prgstrDTOs =  programMasterLocalService.getProgramStructure(programDurationId, themeDisplay.getLocale().toString());
		List<ProgramStructureDTO> programStructureDTOs = new ArrayList<>();
		for(ProgramStructureDTO dto : prgstrDTOs) {
			RotationMaster rotationMaster = rotationMasterLocalService.getRotationMaster(dto.getRotationId());
			if(!OmsbTmsCommonConstants.LEAVE.equalsIgnoreCase(rotationMaster.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH))) {
				programStructureDTOs.add(dto);
			}
		}
		
		List<TraineeLevelMaster> traineeLevelMasters = getTraineeLevelNamesByProgramDuration(programDurationId);
		
		JSONObject resultJson = prepareJsonResponse(programStructureDTOs, traineeLevelMasters, themeDisplay, resourceRequest, programDurationId);
		_logger.debug("doServeResource ::: Response ::: " + resultJson.toString());
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
 
		_logger.info("doServeResource Exit ::: ");
	}

	private List<TraineeLevelMaster> getTraineeLevelNamesByProgramDuration(long programDurationId) {
		List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels  = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programDurationId);
		List<Long> traineeLevelIds = progdurationTraineelevelBlocksLevelTypeRels.stream().map(ProgdurationTraineelevelBlocksLevelTypeRel::getTraineeLevelId).collect(Collectors.toList());
		return traineeLevelMasterLocalService.findByTraineeLevelIds(traineeLevelIds);
	}
	
	private JSONObject prepareJsonResponse(List<ProgramStructureDTO> programStructureDTOs, List<TraineeLevelMaster> traineeLevelMasters, ThemeDisplay themeDisplay, ResourceRequest resourceRequest, long programCohortId) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray traineeLevels = JSONFactoryUtil.createJSONArray();
		if(Validator.isNotNull(traineeLevelMasters) && !traineeLevelMasters.isEmpty()) {
			_logger.debug("prepareJsonResponse ::: traineeLevelMasters size :: " + traineeLevelMasters.size());
			
			for(TraineeLevelMaster traineeLevelMaster : traineeLevelMasters) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("traineeLevelName", traineeLevelMaster.getTraineeLevelName(themeDisplay.getLocale().toString()));
				jsonObject.put("traineeLevelMasterId", traineeLevelMaster.getTraineeLevelMasterId());
				traineeLevels.put(jsonObject);
			}
		} else {
			_logger.debug("prepareJsonResponse ::: No TraineeLevelMaster Found !");
		}
		resultJson.put("traineeLevels", traineeLevels);

		List<Long> rotationIds =  programStructureDTOs.stream().map(ProgramStructureDTO::getRotationId).collect(Collectors.toList());
		CommonUtil.removeDuplicateIds(rotationIds);
		programStructureDTOs =  programStructureDTOs.stream().sorted(Comparator.comparingLong(ProgramStructureDTO::getTraineeLevelMasterId)).collect(Collectors.toList());
		HashMap<Long,RotationDTO> rotationMap = new HashMap<>();
		for(Long rotationId : rotationIds) {
			RotationDTO rotationDTO = new RotationDTO();
			rotationMap.put(rotationId, rotationDTO);
			prepareRotationDTO(programStructureDTOs, traineeLevelMasters, rotationDTO, rotationId, programCohortId, themeDisplay, resourceRequest);
		}
		
	   List<RotationDTO> rotationList = new ArrayList<>(rotationMap.values());

	   try {
			String jsonString = (new ObjectMapper()).writeValueAsString((rotationList));
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
			resultJson.put(CommonConstants.RESULT, jsonArray);
		} catch (Exception e) {
			_logger.error(e);
		}
		
	   resultJson.put("addRotation", OmsbProgramGenerateUrlsUtil.getRotationRenderUrl(themeDisplay, resourceRequest, programCohortId));
	   
		resultJson.put(CommonConstants.SUCCESS, true);
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	private void prepareRotationDTO(List<ProgramStructureDTO> programStructureDTOs, List<TraineeLevelMaster> traineeLevelMasters, RotationDTO rotationDTO, long rotationId, long programCohortId, ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {
		for(ProgramStructureDTO programStructureDTO : programStructureDTOs) {
			if(rotationId == programStructureDTO.getRotationId()) {
				rotationDTO.setRotationId(rotationId);
				rotationDTO.setRotationName(programStructureDTO.getRotationName());
				rotationDTO.setSharedRotation(isSharedRotation(programStructureDTO, programCohortId));
				rotationDTO.setRotationRenderUrl(OmsbProgramGenerateUrlsUtil.getRotationEditOrViewRenderUrl(themeDisplay, resourceRequest, programCohortId, rotationId));
				TraineeLevelDTO traineeLevelDTO = new TraineeLevelDTO();
				prepareTraineeLevelDTO(traineeLevelDTO, programStructureDTO, traineeLevelMasters, themeDisplay);
				rotationDTO.getTraineeLevelDTOs().add(traineeLevelDTO);
			}
		}
	}

	private void prepareTraineeLevelDTO(TraineeLevelDTO traineeLevelDTO, ProgramStructureDTO programStructureDTO, List<TraineeLevelMaster> traineeLevelMasters, ThemeDisplay themeDisplay) {
		traineeLevelDTO.setNoOfBlocks(programStructureDTO.getNoOfBlocks());
		traineeLevelDTO.setProgDurationRotationTlBlocksRelId(programStructureDTO.getProgDurationRotationTlBlocksRelId());
		traineeLevelDTO.setTraineeLevelMasterId(programStructureDTO.getTraineeLevelMasterId());
		
		for(TraineeLevelMaster traineeLevelMaster : traineeLevelMasters) {
			if(programStructureDTO.getTraineeLevelMasterId() == traineeLevelMaster.getTraineeLevelMasterId()) {
				traineeLevelDTO.setTraineeLevelName(traineeLevelMaster.getTraineeLevelName(themeDisplay.getLocale().toString()));
			}
		}
		
		traineeLevelDTO.setElective(Boolean.FALSE);
		try {
			RotationTypeMaster rtm = rotationTypeMasterLocalService.getRotationTypeMaster(programStructureDTO.getRotationType());
			if("Elective".equalsIgnoreCase(rtm.getRotationTypeName("en_US"))) {
				traineeLevelDTO.setElective(Boolean.TRUE);		
			}
		} catch (PortalException e) {
			_logger.error(e);
		}
	}

	private boolean isSharedRotation(ProgramStructureDTO programStructureDTO, long programDurationId) {
		boolean isSharedRotation = false;
		try {
			List<ProgdurationRotationTrainingsitesRel>  progdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRelLocalService.findByProgramDurationIdAndRotationIdAndIsSharedRotation(programDurationId, programStructureDTO.getRotationId(), Boolean.TRUE);
			isSharedRotation = Validator.isNotNull(progdurationRotationTrainingsitesRels) && !progdurationRotationTrainingsitesRels.isEmpty();	
		} catch (Exception e) {
			_logger.error("Shared Rotation Not Found");
		}
		
		return isSharedRotation;
	}
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetRotationsAndBlocksByProgramDurationMVCResourceCommand.class.getName());
}


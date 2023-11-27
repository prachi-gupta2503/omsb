package gov.omsb.programs.web.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
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

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.exception.NoSuchProgdurationRotationTraineelevelBlocksRelException;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/save/assigned-rotation-and-traineeblocks-to-program-cohort" }, service = MVCResourceCommand.class)
public class OmsbAssignedRotationAndTraineeBlocksToProgramCohortMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long programCohortId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.PROG_DURARION_ID, 0l);
		String assignedRotationJson = ParamUtil.getString(resourceRequest,OmsbTmsCommonConstants.ASSIGNED_ROTATION, StringPool.BLANK);
		boolean isSuccess = false;
		
		_logger.debug("doServeResource ::: programCohortId ::: " + programCohortId);
		_logger.debug("doServeResource ::: traineeLevelAndBlocksJson ::: " + assignedRotationJson);
		
		isSuccess = saveTraineeLevelAndRotationBlocksToProgramCohort(assignedRotationJson, programCohortId, themeDisplay);

		JSONObject resultJson = prepareJsonResponse(isSuccess);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	private boolean saveTraineeLevelAndRotationBlocksToProgramCohort(String assignedRotationJson, long programCohortId, ThemeDisplay themeDisplay) {
		_logger.info("saveTraineeLevelAndRotationBlocksToProgramCohort Invoked ::: ");

		boolean isSuccess = false;
		
		// Convert String to Json
		try {
			JSONObject payload = JSONFactoryUtil.createJSONObject(assignedRotationJson);
			boolean isSharedRotation = payload.getBoolean(OmsbTmsCommonConstants.IS_SHARED_ROTATION);
			long rotationMasterId = payload.getLong(OmsbTmsCommonConstants.ROTATION_MASTER_ID);
			long sharedProgramMasterId = payload.getLong(OmsbTmsCommonConstants.SHARED_PROGRAM_MASTER_ID);
			long sharedProgramDurationId = payload.getLong(OmsbTmsCommonConstants.SHARED_PROGRAM_DURATION_ID);
			
			JSONArray traineeLevels = payload.getJSONArray(OmsbTmsCommonConstants.TRAINEE_LEVEL_AND_BLOCKS);
			
			for (int i = 0; i < traineeLevels.length(); i++) {
				JSONObject traineeLevel = traineeLevels.getJSONObject(i);
				long traineeLevelMasterId = traineeLevel.getLong(OmsbTmsCommonConstants.TRAINEE_LEVEL_MASTER_ID);
				
				ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel = getProgDurationRotationTraineeLevelBlocksRel(programCohortId, rotationMasterId, traineeLevelMasterId);
				
				if(progdurationRotationTraineelevelBlocksRel != null) {
					// Update Record
					progdurationRotationTraineelevelBlocksRel.setRotationType(traineeLevel.getLong(OmsbTmsCommonConstants.ROTATION_TYPE));
					progdurationRotationTraineelevelBlocksRel.setNoOfBlocks(traineeLevel.getInt(OmsbTmsCommonConstants.NO_OF_BLOCKS));
					progdurationRotationTraineelevelBlocksRel.setModifiedBy(themeDisplay.getUserId());
					progdurationRotationTraineelevelBlocksRelLocalService.updateProgdurationRotationTraineelevelBlocksRel(progdurationRotationTraineelevelBlocksRel);
					isSuccess = true;
					_logger.debug("progdurationRotationTraineelevelBlocksRel Updated ::: " +  progdurationRotationTraineelevelBlocksRel.getProgdurationRotationTlBlocksRelId());
				} else {
					// Create Record
					long progdurationRotationTlBlocksRelId = counterLocalService.increment(ProgdurationRotationTraineelevelBlocksRel.class.getName());
					progdurationRotationTraineelevelBlocksRel = progdurationRotationTraineelevelBlocksRelLocalService.createProgdurationRotationTraineelevelBlocksRel(progdurationRotationTlBlocksRelId);
					progdurationRotationTraineelevelBlocksRel.setProgramDurationId(programCohortId);
					progdurationRotationTraineelevelBlocksRel.setRotationId(rotationMasterId);
					progdurationRotationTraineelevelBlocksRel.setRotationType(traineeLevel.getLong(OmsbTmsCommonConstants.ROTATION_TYPE));
					progdurationRotationTraineelevelBlocksRel.setTraineeLevelId(traineeLevel.getLong(OmsbTmsCommonConstants.TRAINEE_LEVEL_MASTER_ID));
					progdurationRotationTraineelevelBlocksRel.setGroupId(themeDisplay.getScopeGroupId());
					progdurationRotationTraineelevelBlocksRel.setCreatedBy(themeDisplay.getUserId());
					progdurationRotationTraineelevelBlocksRel.setModifiedBy(themeDisplay.getUserId());
					progdurationRotationTraineelevelBlocksRel.setNoOfBlocks(traineeLevel.getInt(OmsbTmsCommonConstants.NO_OF_BLOCKS));
					progdurationRotationTraineelevelBlocksRelLocalService.addProgdurationRotationTraineelevelBlocksRel(progdurationRotationTraineelevelBlocksRel);
					isSuccess = true;
					_logger.debug("progdurationRotationTraineelevelBlocksRel Created ::: " +  progdurationRotationTlBlocksRelId);
				}
		    }
			if(isSharedRotation) {
				addRotationInProgdurationRotationTrainingsitesRel(isSharedRotation, rotationMasterId, sharedProgramMasterId,sharedProgramDurationId, programCohortId, themeDisplay);
			}
			
		} catch (JSONException e) {
			_logger.error(e);
		}
		
		_logger.info("saveTraineeLevelAndRotationBlocksToProgramCohort Exit ::: ");
		return isSuccess;
	}
	
	private boolean addRotationInProgdurationRotationTrainingsitesRel(boolean isSharedRotation, long rotationMasterId, long sharedProgramMasterId,long sharedProgramDurationId, long programCohortId, ThemeDisplay themeDisplay) {
		_logger.info("addRotationInProgdurationRotationTrainingsitesRel Invoked ::: ");	
		long progdurationRotationTsRelId = counterLocalService.increment(ProgdurationRotationTrainingsitesRel.class.getName());
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService.createProgdurationRotationTrainingsitesRel(progdurationRotationTsRelId);
		progdurationRotationTrainingsitesRel.setProgramDurationId(programCohortId);
		progdurationRotationTrainingsitesRel.setRotationId(rotationMasterId);
		progdurationRotationTrainingsitesRel.setTrainingSitesId(0l);
		progdurationRotationTrainingsitesRel.setGroupId(themeDisplay.getScopeGroupId());
		progdurationRotationTrainingsitesRel.setCreatedBy(themeDisplay.getUserId());
		progdurationRotationTrainingsitesRel.setModifiedBy(themeDisplay.getUserId());
		progdurationRotationTrainingsitesRel.setIsSharedRotation(isSharedRotation);
		progdurationRotationTrainingsitesRel.setRotationOwningProgramId(sharedProgramMasterId);
		progdurationRotationTrainingsitesRel.setOwningProgramDurationId(sharedProgramDurationId);
		progdurationRotationTrainingsitesRel.setNoOfSlots(0);
		ProgdurationRotationTrainingsitesRel rotationTrainingsitesRel  = progdurationRotationTrainingsitesRelLocalService.addProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRel);
		_logger.info("addRotationInProgdurationRotationTrainingsitesRel Exit ::: ");
		return Validator.isNotNull(rotationTrainingsitesRel);
	}

	private ProgdurationRotationTraineelevelBlocksRel getProgDurationRotationTraineeLevelBlocksRel(long programCohortId, long rotationMasterId, long traineeLevelMasterId) {
		ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel = null;  
		try {
			progdurationRotationTraineelevelBlocksRel = progdurationRotationTraineelevelBlocksRelLocalService.findByProgramDurationIdAndTraineeLevelIdAndRotationId( traineeLevelMasterId, programCohortId, rotationMasterId);
		} catch (NoSuchProgdurationRotationTraineelevelBlocksRelException e) {
			_logger.error(e.getMessage());
		}
		return progdurationRotationTraineelevelBlocksRel;
	}
	
	private JSONObject prepareJsonResponse(boolean isSuccess) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put(CommonConstants.SUCCESS, isSuccess);
		
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbAssignedRotationAndTraineeBlocksToProgramCohortMVCResourceCommand.class.getName());
}
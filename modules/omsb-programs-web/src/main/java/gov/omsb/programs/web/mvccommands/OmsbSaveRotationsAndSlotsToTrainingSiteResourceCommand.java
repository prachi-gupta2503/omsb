package gov.omsb.programs.web.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
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

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
"mvc.command.name=/save/rotations-and-slots-to-training-site" }, service = MVCResourceCommand.class)
public class OmsbSaveRotationsAndSlotsToTrainingSiteResourceCommand extends BaseMVCResourceCommand {
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long programCohortId = ParamUtil.getLong(resourceRequest, "programCohortId", 0l);
		long trainingSiteId = ParamUtil.getLong(resourceRequest, "trainingSiteId", 0l);
		String rotationJson = ParamUtil.getString(resourceRequest, "rotationJsons","" );
		long rotationMasterId = 0;
		TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(trainingSiteId);
		String trainingSiteName = trainingSitesMaster.getTrainingSiteName(themeDisplay.getLocale());
		
		_logger.debug("doServeResource ::: programCohortId ::: " + programCohortId);
		_logger.debug("doServeResource ::: selectedRotations ::: " + rotationJson);
		_logger.debug("doServeResource ::: selectedTrainingSite ::: " + trainingSiteId);
	
		 boolean isSuccess = true;
		
		if(Validator.isNotNull(rotationJson)) {
			JSONArray rotationJsonArray = JSONFactoryUtil.createJSONArray(rotationJson);
			_logger.debug("doServeResource ::: length ::: " + rotationJsonArray.length());
			
			 List<ProgdurationRotationTraineelevelBlocksRel> progdurationRotationTraineelevelBlocksRelList;
			 for (int i = 0; i < rotationJsonArray.length(); i++) {  	 
			     JSONObject rotationJsonObject = rotationJsonArray.getJSONObject(i); 
				 progdurationRotationTraineelevelBlocksRelList = progdurationRotationTraineelevelBlocksRelLocalService.findByProgramDurationIdAndRotationId(programCohortId, rotationJsonObject.getLong("rotation"));
				 rotationMasterId = rotationJsonObject.getLong("rotation");
				 if(Validator.isNull(progdurationRotationTraineelevelBlocksRelList) || progdurationRotationTraineelevelBlocksRelList.isEmpty() ) {
					 List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programCohortId);
					 progdurationRotationTraineelevelBlocksRelLocalService.addProgdurationRotationTraineelevelBlocksRel(progdurationTraineelevelBlocksLevelTypeRels, rotationMasterId, themeDisplay.getScopeGroupId(),themeDisplay.getUserId());
				 }
			 }
			 
			 
			 List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRelLocalService.addRotationsAndSlotsToTrainingSite(rotationJsonArray, programCohortId, trainingSiteId, themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			 
			 if(Validator.isNull(progdurationRotationTrainingsitesRels) || progdurationRotationTrainingsitesRels.isEmpty()) {
				 isSuccess = false;
			 }
		}
		
		
		JSONObject resultJson = prepareJsonResponse(isSuccess,trainingSiteId, trainingSiteName);
		JSONPortletResponseUtil.writeJSON(resourceRequest,resourceResponse, resultJson);
		
		_logger.info("doServeResource Exit ::: "); 
	}
	
	private JSONObject prepareJsonResponse(boolean isSuccess,long trainingSitesMasterId, String trainingSiteName) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		
		_logger.debug("trainingSitesMasterList : "+trainingSitesMasterId);
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONObject trainingSiteJson = JSONFactoryUtil.createJSONObject();
		trainingSiteJson.put( OmsbProgramConstants.TRAINING_SITE_NAME,trainingSiteName);
		trainingSiteJson.put(OmsbTmsCommonConstants.TRAINING_SITE_MASTER_ID,trainingSitesMasterId);
		
		resultJson.put(CommonConstants.SUCCESS, isSuccess);
		resultJson.put(CommonConstants.RESULT, trainingSiteJson);

		_logger.debug("resultJson : "+resultJson);
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveRotationsAndSlotsToTrainingSiteResourceCommand.class);
}

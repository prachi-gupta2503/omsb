package gov.omsb.programs.web.mvccommands;

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
import gov.omsb.tms.custom.dto.RotationDTO;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/get/all-assigned-rotations-by-training-site" }, service = MVCResourceCommand.class)
public class OmsbGetRotationsByTrainingSiteMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long trainingSiteMasterId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.TRAINING_SITE_MASTER_ID, 0l);
		long programDurationId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM_DURATION_ID, 0l);

		List<RotationDTO> rotationList = rotationMasterLocalService.getRotationsByTrainingSiteAndCohort(trainingSiteMasterId, programDurationId, themeDisplay.getLocale().toString());
		
		TrainingSitesMaster trainingSiteMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(trainingSiteMasterId);
		String trainingSiteName = trainingSiteMaster.getTrainingSiteName(themeDisplay.getLocale().toString());
		
		JSONObject resultJson = prepareJsonResponse(rotationList, trainingSiteName);
		_logger.debug("doServeResource ::: Response ::: " + resultJson.toString());
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	private JSONObject prepareJsonResponse(List<RotationDTO> rotationList, String trainingSiteName) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray trainingSiteJSONArray = JSONFactoryUtil.createJSONArray();
		if (Validator.isNotNull(rotationList) && !rotationList.isEmpty()) {
			_logger.debug("prepareJsonResponse ::: rotationList size :: " + rotationList.size());
			for (RotationDTO rotationDTO : rotationList) {
				RotationMaster rotationMaster = null;
				try {
					rotationMaster = rotationMasterLocalService.getRotationMaster(rotationDTO.getRotationMasterId());
					if ((!OmsbTmsCommonConstants.LEAVE.equalsIgnoreCase(
							rotationMaster.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH)))) {
						JSONObject trainingSiteJson = JSONFactoryUtil.createJSONObject();
						trainingSiteJson.put(OmsbProgramConstants.ROTATION_NAME, rotationDTO.getRotationName());
						trainingSiteJson.put(OmsbProgramConstants.NO_OF_SLOTS, rotationDTO.getNoOfslots());
						trainingSiteJson.put(OmsbProgramConstants.PROGDURATION_ROTATION_TS_REL_ID,
								rotationDTO.getProgDurationRotationTsRelId());
						trainingSiteJSONArray.put(trainingSiteJson);
					}
				} catch (Exception e) {
					_logger.error(e);
				} 
			}
		} else {
			_logger.debug("prepareJsonResponse ::: No Rotations Found !");
		}

		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(OmsbProgramConstants.TRAINING_SITE_NAME, trainingSiteName);
		resultJson.put(CommonConstants.RESULT, trainingSiteJSONArray);
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetRotationsByTrainingSiteMVCResourceCommand.class.getName());
}


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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/get/trainee-level-names-by-program-duration" }, service = MVCResourceCommand.class)
public class OmsbGetTraineeLevelNamesByProgramDurationMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long programDurationId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM_DURATION_ID, 0l);

		List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels  = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programDurationId);
		List<Long> traineeLevelIds = progdurationTraineelevelBlocksLevelTypeRels.stream().map(ProgdurationTraineelevelBlocksLevelTypeRel::getTraineeLevelId).collect(Collectors.toList());
		List<TraineeLevelMaster> traineeLevelMasters = traineeLevelMasterLocalService.findByTraineeLevelIds(traineeLevelIds);
		traineeLevelMasters =  traineeLevelMasters.stream().sorted(Comparator.comparingLong(TraineeLevelMaster::getTraineeLevelMasterId)).collect(Collectors.toList());
		
		JSONObject resultJson = prepareJsonResponse(traineeLevelMasters, themeDisplay);
		_logger.debug("doServeResource ::: Response ::: " + resultJson.toString());
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	private JSONObject prepareJsonResponse(List<TraineeLevelMaster> traineeLevelMasters, ThemeDisplay themeDisplay) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray progdurationTraineelevelBlocksLevelTypeRelsJSONArray = JSONFactoryUtil.createJSONArray();
		if(Validator.isNotNull(traineeLevelMasters) && !traineeLevelMasters.isEmpty()) {
			_logger.debug("prepareJsonResponse ::: traineeLevelMasters size :: " + traineeLevelMasters.size());
			for(TraineeLevelMaster traineeLevelMaster : traineeLevelMasters) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("traineeLevelName", traineeLevelMaster.getTraineeLevelName(themeDisplay.getLocale().toString()));
				jsonObject.put("traineeLevelMasterId", traineeLevelMaster.getTraineeLevelMasterId());
				progdurationTraineelevelBlocksLevelTypeRelsJSONArray.put(jsonObject);
			}
		} else {
			_logger.debug("prepareJsonResponse ::: No TraineeLevelMaster Found !");
		}
	
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, progdurationTraineelevelBlocksLevelTypeRelsJSONArray);
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetTraineeLevelNamesByProgramDurationMVCResourceCommand.class.getName());
}


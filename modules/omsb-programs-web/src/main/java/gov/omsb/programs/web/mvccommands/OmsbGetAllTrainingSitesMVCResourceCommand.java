package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/get/all-training-sites" }, service = MVCResourceCommand.class)
public class OmsbGetAllTrainingSitesMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programCohortId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.PROGRAM_COHORT_ID, 0l);

		List<TrainingSitesMaster> trainingSitesMasterList = trainingSitesMasterLocalService.getTrainingSitesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRelList = progdurationRotationTrainingsitesRelLocalService.findByProgramDurationId(programCohortId);
		List<Long> assignedTrainingSiteIds = progdurationRotationTrainingsitesRelList.stream().map(ProgdurationRotationTrainingsitesRel::getTrainingSitesId).collect(Collectors.toList());
		
		JSONObject resultJson = prepareJsonResponse(trainingSitesMasterList, themeDisplay, assignedTrainingSiteIds);
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	private JSONObject prepareJsonResponse(List<TrainingSitesMaster> trainingSitesMasterList, ThemeDisplay themeDisplay, List<Long> assignedTrainingSiteIds) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray trainingSiteJSONArray = JSONFactoryUtil.createJSONArray();
		
		for (TrainingSitesMaster trainingSite: trainingSitesMasterList) {
			JSONObject trainingSiteJson = JSONFactoryUtil.createJSONObject();
			trainingSiteJson.put( OmsbProgramConstants.TRAINING_SITE_NAME, trainingSite.getTrainingSiteName(themeDisplay.getLocale()));
			trainingSiteJson.put(OmsbTmsCommonConstants.TRAINING_SITE_MASTER_ID, trainingSite.getTrainingSiteMasterId());
			trainingSiteJson.put(OmsbProgramConstants.IS_SELECTED, assignedTrainingSiteIds.contains(trainingSite.getTrainingSiteMasterId()));
			trainingSiteJSONArray.put(trainingSiteJson);
		}
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, trainingSiteJSONArray);
		
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetAllTrainingSitesMVCResourceCommand.class.getName());
}


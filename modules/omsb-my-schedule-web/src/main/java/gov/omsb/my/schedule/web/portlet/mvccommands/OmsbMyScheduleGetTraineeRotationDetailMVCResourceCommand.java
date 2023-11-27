package gov.omsb.my.schedule.web.portlet.mvccommands;

import com.liferay.petra.string.StringPool;
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
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.my.schedule.web.constants.OmsbMyScheduleWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TraineeRotationTsBlockDetailsRelLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMyScheduleWebPortletKeys.OMSBMYSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMyScheduleWebPortletKeys.GET_TRAINEE_ROTATION_DETAIL_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbMyScheduleGetTraineeRotationDetailMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_logger.info("OmsbMyScheduleGetTraineeRotationDetailMVCResourceCommand Invoked ::: ");

		long progdurationRotationTrainingsitesRelId = ParamUtil.getLong(resourceRequest,
				OmsbMyScheduleWebPortletKeys.PROG_DRATION_ROTATION_TRAINING_SITES_REL_ID);

		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService
				.getProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRelId);

		JSONObject resultObject = getTrainingAndRotationCodeResultJson(resourceRequest,
				progdurationRotationTrainingsitesRel);

		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultObject);

	}

	private JSONObject getTrainingAndRotationCodeResultJson(ResourceRequest resourceRequest,
			ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel) throws PortalException {

		_logger.info("getTrainingAndRotationCodeResultJson Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRelList = progdurationRotationTrainingsitesRelLocalService
				.findByRotationId(progdurationRotationTrainingsitesRel.getRotationId());

		Map<Long, String> trainingSiteCodeMapping = new HashMap<>();
		Map<Long, String> trainingCodeMapping = new HashMap<>();
		Map<Long, Boolean> isSharedRoationMapping = new HashMap<>();
		Map<Long, Integer> trainingSiteblockNoMapping = new HashMap<>();
		progdurationRotationTrainingsitesRelList.forEach(progdurationRTRel -> {
			try {

				long progdurationRTRelId = progdurationRTRel.getProgdurationRotationTsRelId();
				String trainingCode = trainingSitesMasterLocalService
						.getTrainingSitesMaster(progdurationRTRel.getTrainingSitesId())
						.getTrainingSiteCode(themeDisplay.getLocale());

				trainingSiteCodeMapping.put(progdurationRTRel.getTrainingSitesId(),
						rotationMasterLocalService.getRotationMaster(progdurationRTRel.getRotationId())
								.getRotationCode(themeDisplay.getLocale()) + StringPool.COLON + trainingCode);
				trainingCodeMapping.put(progdurationRTRel.getTrainingSitesId(), trainingCode);
				isSharedRoationMapping.put(progdurationRTRel.getTrainingSitesId(),
						progdurationRotationTrainingsitesRel.isIsSharedRotation());
				List<Long> blockIdList = traineeRotationTsBlockDetailsRelLocalService
						.findByProgDurationRotationTsRelId(progdurationRTRelId).stream()
						.map(TraineeRotationTsBlockDetailsRel::getBlocksMetadataDetailsRelId)
						.collect(Collectors.toList());
				int count = blockIdList.size();

				trainingSiteblockNoMapping.put(progdurationRTRel.getTrainingSitesId(), count);
			} catch (PortalException e) {
				_logger.error(e);
			}
		});

		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (Map.Entry<Long, String> entry : trainingSiteCodeMapping.entrySet()) {
			JSONObject codesJson = JSONFactoryUtil.createJSONObject();
			codesJson.put(OmsbMyScheduleWebPortletKeys.ROTATION_TRAINING_CODE, entry.getValue());
			codesJson.put(OmsbMyScheduleWebPortletKeys.IS_SHARED_ROTATION, isSharedRoationMapping.get(entry.getKey()));
			codesJson.put(OmsbMyScheduleWebPortletKeys.TRAINING_SITE_CODE, trainingCodeMapping.get(entry.getKey()));
			codesJson.put(OmsbMyScheduleWebPortletKeys.COUNT, trainingSiteblockNoMapping.get(entry.getKey()));
			jsonArray.put(codesJson);
		}
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, jsonArray);

		return resultJson;
	}

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbMyScheduleGetFacultyRotationDetailMVCResourceCommand.class);

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private TraineeRotationTsBlockDetailsRelLocalService traineeRotationTsBlockDetailsRelLocalService;

	@Reference
	private BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;
}

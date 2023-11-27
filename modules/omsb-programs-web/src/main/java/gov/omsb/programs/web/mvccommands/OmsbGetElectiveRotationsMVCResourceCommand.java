package gov.omsb.programs.web.mvccommands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.RotationTypeMasterLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name="
				+ OmsbProgramConstants.GET_ELECTIVE_ROTATIONS_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetElectiveRotationsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.debug("ServeResource Invoked ::: ");

		JSONObject resultJson = JSONFactoryUtil.createJSONObject();

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long traineeId = themeDisplay.getUserId();

		Map<Long, String> availableTraineeRotationMap = new HashMap<>();
		List<TraineeElectiverotationPriorityDetails> traineeElectiveDeatils = new ArrayList<>();

		long traineeLevelId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.SELECTED_TRAINEE_LEVEL_ID, 0);
		long traineePdTlErDetailsId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.TRAINEE_PD_TL_ER_ID, 0);

		final long programDurationId;
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = traineeAdmissionDetailsRelLocalService.findByTraineeId(themeDisplay.getUserId());
		if(Validator.isNotNull(traineeAdmissionDetailsRel)) {
			programDurationId = traineeAdmissionDetailsRel.getProgramDurationId();
		} else {
			programDurationId = GetterUtil.DEFAULT_LONG;
		}

		if (Validator.isNull(traineePdTlErDetailsId)) {
			TraineeProgdurationTraineelevelDetails progdurationTraineelevelDetails = traineeProgdurationTraineelevelDetailsLocalService
					.findByTraineeIdAndTraineeLevelId(traineeId, traineeLevelId);
			if (Validator.isNotNull(progdurationTraineelevelDetails) && programDurationId == progdurationTraineelevelDetails.getProgramDurationId()) {
				traineePdTlErDetailsId = progdurationTraineelevelDetails.getTraineePdTlErDetailsId();
			}
		}

		long rotationTypeId = GetterUtil.DEFAULT_LONG;

		try {
			RotationTypeMaster rotationTypeMaster = rotationTypeMasterLocalService
					.findByRotationNameByLike(StringPool.PERCENT + StringPool.GREATER_THAN
							+ OmsbProgramConstants.ROTATION_TYPE_ELECTIVE + StringPool.LESS_THAN + StringPool.PERCENT)
					.get(GetterUtil.DEFAULT_INTEGER);
			rotationTypeId = rotationTypeMaster.getRotationTypeMasterId();
		} catch (Exception e) {
			_logger.error(e.getMessage());
		}

		List<Long> rotationIds = progdurationRotationTraineelevelBlocksRelLocalService
				.findByTraineeLevelIdAndRotationType(traineeLevelId, rotationTypeId).stream()
				.filter(r ->  r.getProgramDurationId() == programDurationId)
				.map(ProgdurationRotationTraineelevelBlocksRel::getRotationId).collect(Collectors.toList());

		RotationMaster rotationMaster;
		for (Long rotationId : rotationIds) {
			rotationMaster = rotationMasterLocalService.fetchRotationMaster(rotationId);
			if (Validator.isNotNull(rotationMaster)) {
				availableTraineeRotationMap.put(rotationId, rotationMaster.getRotationName(themeDisplay.getLocale()));
			}
		}

		List<TraineeElectiverotationPriorityDetails> traineeElectiverotationPriorityDetails = traineeElectiverotationPriorityDetailsLocalService
				.findByTraineePdTlErDetailsId(traineePdTlErDetailsId);

		for (TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetail : traineeElectiverotationPriorityDetails) {
			rotationMaster = rotationMasterLocalService
					.fetchRotationMaster(traineeElectiverotationPriorityDetail.getRotationId());
			if (Validator.isNotNull(rotationMaster)) {
				traineeElectiveDeatils.add(traineeElectiverotationPriorityDetail);
			}
		}

		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(OmsbProgramConstants.AVAILABLE_TRAINEE_ROTATION_MAP, availableTraineeRotationMap);
		resultJson.put(OmsbProgramConstants.SELECTED_TRAINEE_ROTATION_LIST, traineeElectiveDeatils);
		resultJson.put(OmsbProgramConstants.TRAINEE_PD_TL_ER_ID, traineePdTlErDetailsId);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.debug("ServeResource Exit ::: ");
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	private TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private TraineeProgdurationTraineelevelDetailsLocalService traineeProgdurationTraineelevelDetailsLocalService;

	@Reference
	private TraineeElectiverotationPriorityDetailsLocalService traineeElectiverotationPriorityDetailsLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetElectiveRotationsMVCResourceCommand.class);
}

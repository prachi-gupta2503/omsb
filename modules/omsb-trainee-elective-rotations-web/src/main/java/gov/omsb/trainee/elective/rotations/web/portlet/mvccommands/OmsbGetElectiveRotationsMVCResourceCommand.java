package gov.omsb.trainee.elective.rotations.web.portlet.mvccommands;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.trainee.elective.rotations.web.constants.OmsbTraineeElectiveRotationsWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTraineeElectiveRotationsWebPortletKeys.OMSBTRAINEEELECTIVEROTATIONSWEB,
"mvc.command.name=" + OmsbTraineeElectiveRotationsWebPortletKeys.GET_ELECTIVE_ROTATIONS_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetElectiveRotationsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.debug("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long traineeLevelId = ParamUtil.getLong(resourceRequest, OmsbTraineeElectiveRotationsWebPortletKeys.SELECTED_TRAINEE_LEVEL_ID, 0);
		_logger.debug("traineeLevelId ::: " + traineeLevelId);

		
		Map<Long, String> traineeRotationMap = new HashMap<>();
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		if (traineeLevelId != 0) {
			List<Long> rotationIds = progdurationRotationTraineelevelBlocksRelLocalService
					.findByTraineeLevelIdAndRotationType(traineeLevelId, OmsbTmsCommonConstants.ROTATION_TYPE_ELECTIVE).stream()
					.map(ProgdurationRotationTraineelevelBlocksRel::getRotationId).collect(Collectors.toList());
			
			_logger.debug("rotationIds ::: "  + rotationIds);
			
			
			RotationMaster rotationMaster;
			for (Long rotationId : rotationIds) {
				rotationMaster = rotationMasterLocalService.fetchRotationMaster(rotationId);
				_logger.debug("rotationMaster ::: "  + rotationMaster);
				if (Validator.isNotNull(rotationMaster)) {
					traineeRotationMap.put(rotationId, rotationMaster.getRotationName(themeDisplay.getLocale()));
				}
			}
		}
		_logger.debug("traineeRotationMap ::: "  + traineeRotationMap.toString());
		
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, traineeRotationMap);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.debug("ServeResource Exit ::: ");
	}

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetElectiveRotationsMVCResourceCommand.class);
}

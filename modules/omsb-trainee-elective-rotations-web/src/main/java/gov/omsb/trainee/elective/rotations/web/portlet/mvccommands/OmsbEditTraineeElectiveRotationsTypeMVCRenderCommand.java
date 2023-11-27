package gov.omsb.trainee.elective.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;
import gov.omsb.trainee.elective.rotations.web.constants.OmsbTraineeElectiveRotationsWebPortletKeys;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbTraineeElectiveRotationsWebPortletKeys.OMSBTRAINEEELECTIVEROTATIONSWEB,
		"mvc.command.name="
				+ OmsbTraineeElectiveRotationsWebPortletKeys.EDIT_TRAINEE_ELECTIVE_ROTATIONS_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditTraineeElectiveRotationsTypeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.debug("render Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {

			List<UserMetadata> userMetadataList = userMetadataUtil.getUserMetadataItemsByLrUserId(
					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId()).getItems();

			UserMetadata userMetadata = userMetadataList.get(0);
			long programId = userMetadata.getProgramId();

			long traineePdTlErDetailsId = ParamUtil.getLong(renderRequest,
					OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_PD_TL_ER_ID, 0);

			ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programId);
			String programName = programMaster.getProgramName(themeDisplay.getLocale());

			TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails = traineeProgdurationTraineelevelDetailsLocalService
					.fetchTraineeProgdurationTraineelevelDetails(traineePdTlErDetailsId);
			long traineeLevelId = traineeProgdurationTraineelevelDetails.getTraineeLevelId();
			TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService
					.getTraineeLevelMaster(traineeLevelId);
			String traineeLevelName = traineeLevelMaster.getTraineeLevelName(themeDisplay.getLocale());

			Map<Long, String> availableTraineeRotationMap = new HashMap<>();
			List<TraineeElectiverotationPriorityDetails> traineeElectiveDeatils = new ArrayList<>();


			List<Long> rotationIds = progdurationRotationTraineelevelBlocksRelLocalService
					.findRotationByTraineeLevelId(traineeLevelId).stream()
					.map(ProgdurationRotationTraineelevelBlocksRel::getRotationId).collect(Collectors.toList());
			RotationMaster rotationMaster;
			for (Long rotationId : rotationIds) {
				rotationMaster = rotationMasterLocalService.fetchRotationMaster(rotationId);
				if (Validator.isNotNull(rotationMaster)) {
					availableTraineeRotationMap.put(rotationId,
							rotationMaster.getRotationName(themeDisplay.getLocale()));
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

			renderRequest.setAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_PD_TL_ER_ID,
					traineePdTlErDetailsId);
			renderRequest.setAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.AVAILABLE_TRAINEE_ROTATION_MAP,
					availableTraineeRotationMap);
			renderRequest.setAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.SELECTED_TRAINEE_ROTATION_LIST,
					traineeElectiveDeatils);
			renderRequest.setAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.PROGRAM_NAME, programName);
			renderRequest.setAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_LEVEL_NAME, traineeLevelName);
		} catch (PortalException e) {
			_logger.error(e);
		}

		_logger.debug("render Exit::: ");
		return OmsbTraineeElectiveRotationsWebPortletKeys.EDIT_TRAINEE_ELECTIVE_ROTATIONS_JSP;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private TraineeProgdurationTraineelevelDetailsLocalService traineeProgdurationTraineelevelDetailsLocalService;

	@Reference
	private TraineeElectiverotationPriorityDetailsLocalService traineeElectiverotationPriorityDetailsLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbEditTraineeElectiveRotationsTypeMVCRenderCommand.class);
}

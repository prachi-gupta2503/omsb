package gov.omsb.trainee.elective.rotations.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;
import gov.omsb.trainee.elective.rotations.web.constants.OmsbTraineeElectiveRotationsWebPortletKeys;
import gov.omsb.trainee.elective.rotations.web.portlet.util.OmsbTraineeElectiveRotationsUtil;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbTraineeElectiveRotationsWebPortletKeys.OMSBTRAINEEELECTIVEROTATIONSWEB,
		"mvc.command.name="
				+ OmsbTraineeElectiveRotationsWebPortletKeys.SAVE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveTraineeElectiveRotationsMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.debug("ProcessAction Invoked");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long traineePdTlErDetailsId = ParamUtil.getLong(actionRequest, OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_PD_TL_ER_ID, 0);
		if (traineePdTlErDetailsId != 0) {
			isSuccess = updateTraineeElectiveRotations(actionRequest, traineePdTlErDetailsId, themeDisplay);
		} else {
			isSuccess = createTraineeElectiveRotations(actionRequest, themeDisplay);
		}
		_logger.debug("ProcessAction Exit");
		return isSuccess;
	}

	/**
	 * 
	 * @param actionRequest
	 * @param traineePdTlErDetailsId
	 * @param themeDisplay
	 * @return
	 */
	private boolean updateTraineeElectiveRotations(ActionRequest actionRequest, long traineePdTlErDetailsId, ThemeDisplay themeDisplay) {
		if (!validateSelectedElectiveRotationsCount(actionRequest)) {
			return false;
		}
		TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails = traineeProgdurationTraineelevelDetailsLocalService.fetchTraineeProgdurationTraineelevelDetails(traineePdTlErDetailsId);
		if (Validator.isNull(traineeProgdurationTraineelevelDetails)) {
			return false;
		}

		deleteExistingElectiveRotations(traineePdTlErDetailsId);
		
		traineeProgdurationTraineelevelDetails = OmsbTraineeElectiveRotationsUtil.createTraineeProgdurationTraineelevelDetails(actionRequest, traineeProgdurationTraineelevelDetails, Boolean.FALSE, themeDisplay);
		traineeProgdurationTraineelevelDetailsLocalService.updateTraineeProgdurationTraineelevelDetails(traineeProgdurationTraineelevelDetails);
		_logger.debug("TraineeProgdurationTraineelevelDetails Record Updated");

		long[] selectedElectiveRotations = ParamUtil.getLongValues(actionRequest, OmsbTraineeElectiveRotationsWebPortletKeys.ELECTIVE_ROTATIONS);
		createNewElectiveRotations(selectedElectiveRotations, traineePdTlErDetailsId, themeDisplay);

		return true;
	}

	/**
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	private boolean createTraineeElectiveRotations(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		if (!validateSelectedElectiveRotationsCount(actionRequest)) {
			return false;
		}
		
		if (!validateTraineeElectiveRotations(actionRequest, themeDisplay)) {
			return false;
		}

		long traineePdTlErDetailsId = counterLocalService.increment(TraineeProgdurationTraineelevelDetails.class.getName(), 1);
		long[] selectedElectiveRotations = ParamUtil.getLongValues(actionRequest, OmsbTraineeElectiveRotationsWebPortletKeys.ELECTIVE_ROTATIONS);

		TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails = traineeProgdurationTraineelevelDetailsLocalService.createTraineeProgdurationTraineelevelDetails(traineePdTlErDetailsId);
		traineeProgdurationTraineelevelDetails = OmsbTraineeElectiveRotationsUtil.createTraineeProgdurationTraineelevelDetails(actionRequest, traineeProgdurationTraineelevelDetails, Boolean.TRUE, themeDisplay);
		traineeProgdurationTraineelevelDetailsLocalService.addTraineeProgdurationTraineelevelDetails(traineeProgdurationTraineelevelDetails);
		_logger.debug("TraineeProgdurationTraineelevelDetails Record Created");

		createNewElectiveRotations(selectedElectiveRotations, traineePdTlErDetailsId, themeDisplay);
		return true;
	}

	/**
	 * 
	 * @param traineePdTlErDetailsId
	 */
	private void deleteExistingElectiveRotations(long traineePdTlErDetailsId) {
		List<TraineeElectiverotationPriorityDetails> traineeElectiverotationPriorityDetailsList = traineeElectiverotationPriorityDetailsLocalService.findByTraineePdTlErDetailsId(traineePdTlErDetailsId);
		for (TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetail : traineeElectiverotationPriorityDetailsList) {
			traineeElectiverotationPriorityDetailsLocalService.deleteTraineeElectiverotationPriorityDetails(traineeElectiverotationPriorityDetail);
		}
		_logger.debug("Existing TraineeElectiverotationPriorityDetails Records Deleted");
	}

	/**
	 * 
	 * @param actionRequest
	 * @param selectedElectiveRotations
	 * @param traineePdTlErDetailsId
	 * @param themeDisplay
	 */
	private void createNewElectiveRotations(long[] selectedElectiveRotations, long traineePdTlErDetailsId, ThemeDisplay themeDisplay) {
		for (int sequence = 0; sequence < selectedElectiveRotations.length; sequence++) {
			long traineeElectiverotationPriorityDetailsId = counterLocalService.increment(TraineeElectiverotationPriorityDetails.class.getName(), 1);
			TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetails = traineeElectiverotationPriorityDetailsLocalService.createTraineeElectiverotationPriorityDetails(traineeElectiverotationPriorityDetailsId);
			traineeElectiverotationPriorityDetails = OmsbTraineeElectiveRotationsUtil.createTraineeElectiverotationPriorityDetails(traineeElectiverotationPriorityDetails, Boolean.TRUE, themeDisplay, selectedElectiveRotations, sequence, traineePdTlErDetailsId);
			traineeElectiverotationPriorityDetailsLocalService.addTraineeElectiverotationPriorityDetails(traineeElectiverotationPriorityDetails);
			_logger.debug("New TraineeElectiverotationPriorityDetails Record Created");
		}
	}

	/**
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	private boolean validateTraineeElectiveRotations(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		long traineeLevelId = ParamUtil.getLong(actionRequest, OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_LEVEL_ID);
		if (Validator.isNotNull(traineeProgdurationTraineelevelDetailsLocalService.findByTraineeIdAndTraineeLevelId(themeDisplay.getUserId(), traineeLevelId))) {
			SessionErrors.add(actionRequest, OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_LEVEL_ERROR);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	/**
	 * @param actionRequest
	 * @return
	 */
	private boolean validateSelectedElectiveRotationsCount(ActionRequest actionRequest) {
		long[] selectedElectiveRotations = ParamUtil.getLongValues(actionRequest, OmsbTraineeElectiveRotationsWebPortletKeys.ELECTIVE_ROTATIONS);
		if(selectedElectiveRotations.length == 0 || selectedElectiveRotations.length > 3) {
			SessionErrors.add(actionRequest, OmsbTraineeElectiveRotationsWebPortletKeys.ELECTIVE_ROTATION_COUNT_ERROR);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	@Reference
	private TraineeProgdurationTraineelevelDetailsLocalService traineeProgdurationTraineelevelDetailsLocalService;

	@Reference
	private TraineeElectiverotationPriorityDetailsLocalService traineeElectiverotationPriorityDetailsLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveTraineeElectiveRotationsMVCActionCommand.class);

}

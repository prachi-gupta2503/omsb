package gov.omsb.programs.web.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.programs.web.portlet.util.OmsbTraineeElectiveRotationsUtil;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name="
				+ OmsbProgramConstants.SAVE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveTraineeElectiveRotationsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.debug("ProcessAction Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long traineePdTlErDetailsId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.TRAINEE_PD_TL_ER_ID, 0);
		if (traineePdTlErDetailsId != 0) {
			updateTraineeElectiveRotations(actionRequest, traineePdTlErDetailsId, themeDisplay);
		} else {
			createTraineeElectiveRotations(actionRequest, themeDisplay);
		}
		try {
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, OmsbProgramConstants.REDIRECT));
		} catch (IOException e) {
			_logger.error(e.getMessage());
		}
		_logger.debug("ProcessAction Exit");
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

		long[] selectedElectiveRotations = ParamUtil.getLongValues(actionRequest, OmsbProgramConstants.ELECTIVE_ROTATIONS);
		createNewElectiveRotations(selectedElectiveRotations, traineePdTlErDetailsId, themeDisplay);
		setSucessesMessage(actionRequest, OmsbProgramConstants.ELECTIVE_ROTATION_SAVED);
		actionRequest.setAttribute(OmsbProgramConstants.SUCCESS_MESSAGE, OmsbProgramConstants.ELECTIVE_ROTATION_SAVED);
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

		long traineePdTlErDetailsId = counterLocalService.increment(TraineeProgdurationTraineelevelDetails.class.getName());
		long[] selectedElectiveRotations = ParamUtil.getLongValues(actionRequest, OmsbProgramConstants.ELECTIVE_ROTATIONS);

		TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails = traineeProgdurationTraineelevelDetailsLocalService.createTraineeProgdurationTraineelevelDetails(traineePdTlErDetailsId);
		traineeProgdurationTraineelevelDetails = OmsbTraineeElectiveRotationsUtil.createTraineeProgdurationTraineelevelDetails(actionRequest, traineeProgdurationTraineelevelDetails, Boolean.TRUE, themeDisplay);
		traineeProgdurationTraineelevelDetailsLocalService.addTraineeProgdurationTraineelevelDetails(traineeProgdurationTraineelevelDetails);
		_logger.debug("TraineeProgdurationTraineelevelDetails Record Created");

		createNewElectiveRotations(selectedElectiveRotations, traineePdTlErDetailsId, themeDisplay);
		setSucessesMessage(actionRequest, OmsbProgramConstants.ELECTIVE_ROTATION_SAVED);
		actionRequest.setAttribute(OmsbProgramConstants.SUCCESS_MESSAGE, OmsbProgramConstants.ELECTIVE_ROTATION_SAVED);
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
		long traineeLevelId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.TRAINEE_LEVEL_ID);
		if (Validator.isNotNull(traineeProgdurationTraineelevelDetailsLocalService.findByTraineeIdAndTraineeLevelId(themeDisplay.getUserId(), traineeLevelId))) {
			setErrorMessage(actionRequest, OmsbProgramConstants.TRAINEE_LEVEL_ERROR);
			return false;
		}
		return true;
	}
	
	/**
	 * @param actionRequest
	 * @return
	 */
	private boolean validateSelectedElectiveRotationsCount(ActionRequest actionRequest) {
		long[] selectedElectiveRotations = ParamUtil.getLongValues(actionRequest, OmsbProgramConstants.ELECTIVE_ROTATIONS);
		if(selectedElectiveRotations.length == 0 || selectedElectiveRotations.length > 3) {
			setErrorMessage(actionRequest, OmsbProgramConstants.ELECTIVE_ROTATION_COUNT_ERROR);
			return false;
		}
		return true;
	}
	
	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}

	@Reference
	private TraineeProgdurationTraineelevelDetailsLocalService traineeProgdurationTraineelevelDetailsLocalService;

	@Reference
	private TraineeElectiverotationPriorityDetailsLocalService traineeElectiverotationPriorityDetailsLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveTraineeElectiveRotationsMVCActionCommand.class);

}

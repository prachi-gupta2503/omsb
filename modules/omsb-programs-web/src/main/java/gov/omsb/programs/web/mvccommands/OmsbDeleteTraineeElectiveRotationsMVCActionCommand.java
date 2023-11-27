package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
"mvc.command.name=" + OmsbProgramConstants.DELETE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteTraineeElectiveRotationsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.info("ProcessAction Invoked ::: ");
		long electiverotationPriorityDetailsId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.ELECTIVE_ROTATION_PRIORITY_DETAILS_ID, 0);
		try {
			TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetail = traineeElectiverotationPriorityDetailsLocalService.getTraineeElectiverotationPriorityDetails(electiverotationPriorityDetailsId);
			if(traineeElectiverotationPriorityDetailsLocalService.findByTraineePdTlErDetailsId(traineeElectiverotationPriorityDetail.getTraineePdTlErDetailsId()).size() == 1) {
				traineeProgdurationTraineelevelDetailsLocalService.deleteTraineeProgdurationTraineelevelDetails(traineeElectiverotationPriorityDetail.getTraineePdTlErDetailsId());
			}
			traineeElectiverotationPriorityDetailsLocalService.deleteTraineeElectiverotationPriorityDetails(traineeElectiverotationPriorityDetail);
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, OmsbProgramConstants.REDIRECT));
			setSucessesMessage(actionRequest, OmsbProgramConstants.ELECTIVE_ROTATION_DELETD);
			actionRequest.setAttribute(OmsbProgramConstants.SUCCESS_MESSAGE, OmsbProgramConstants.ELECTIVE_ROTATION_DELETD);
		} catch (PortalException | IOException e) {
			_logger.error(e.getMessage());
			setErrorMessage(actionRequest, OmsbProgramConstants.SOMETHING_WENT_WRONG);
		}
		_logger.info("ProcessAction Exit ::: ");
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

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteTraineeElectiveRotationsMVCActionCommand.class);

}

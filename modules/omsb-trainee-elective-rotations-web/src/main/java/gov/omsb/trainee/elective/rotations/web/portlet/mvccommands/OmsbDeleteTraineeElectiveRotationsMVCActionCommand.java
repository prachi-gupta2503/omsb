package gov.omsb.trainee.elective.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;
import gov.omsb.trainee.elective.rotations.web.constants.OmsbTraineeElectiveRotationsWebPortletKeys;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTraineeElectiveRotationsWebPortletKeys.OMSBTRAINEEELECTIVEROTATIONSWEB,
"mvc.command.name=" + OmsbTraineeElectiveRotationsWebPortletKeys.DELETE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteTraineeElectiveRotationsMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.debug("ProcessAction Invoked ::: ");
		long traineePdTlErDetailsId = ParamUtil.getLong(actionRequest, OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_PD_TL_ER_ID, 0);
		try {
			if(traineePdTlErDetailsId != 0) {
				List<TraineeElectiverotationPriorityDetails> traineeElectiverotationPriorityDetails = traineeElectiverotationPriorityDetailsLocalService.findByTraineePdTlErDetailsId(traineePdTlErDetailsId);
				for (TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetail : traineeElectiverotationPriorityDetails) {
                    traineeElectiverotationPriorityDetailsLocalService.deleteTraineeElectiverotationPriorityDetails(traineeElectiverotationPriorityDetail);
                    _logger.debug("ProcessAction ::: TraineeElectiverotationPriorityDetails Record Deleted");
				}
				traineeProgdurationTraineelevelDetailsLocalService.deleteTraineeProgdurationTraineelevelDetails(traineePdTlErDetailsId);
                _logger.debug("ProcessAction ::: TraineeProgdurationTraineelevelDetails Record Deleted");
			}
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.debug("ProcessAction Exit ::: ");
		return true;	
	}

	@Reference
	private TraineeProgdurationTraineelevelDetailsLocalService traineeProgdurationTraineelevelDetailsLocalService;
	
	@Reference
	private TraineeElectiverotationPriorityDetailsLocalService traineeElectiverotationPriorityDetailsLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteTraineeElectiveRotationsMVCActionCommand.class);
}

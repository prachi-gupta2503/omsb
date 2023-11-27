package gov.omsb.programs.web.portlet.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Calendar;

import javax.portlet.ActionRequest;

import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalServiceUtil;

/**
 * @author Dhairya
 */
public class OmsbTraineeElectiveRotationsUtil {
	private OmsbTraineeElectiveRotationsUtil() {
		
	}

	public static TraineeProgdurationTraineelevelDetails createTraineeProgdurationTraineelevelDetails(ActionRequest actionRequest, TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.debug("createTraineeProgdurationTraineelevelDetails Invoked ::: ");
		
		Calendar calendar = Calendar.getInstance();
		
		traineeProgdurationTraineelevelDetails.setModifiedDate(calendar.getTime());
		traineeProgdurationTraineelevelDetails.setModifiedBy(themeDisplay.getUserId());
		if(isCreate) {
			long traineeLevelId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.TRAINEE_LEVEL_ID);

			long programDurationId = GetterUtil.DEFAULT_LONG;
			
			TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = TraineeAdmissionDetailsRelLocalServiceUtil.findByTraineeId(themeDisplay.getUserId());
			if(Validator.isNotNull(traineeAdmissionDetailsRel)) {
				programDurationId = traineeAdmissionDetailsRel.getProgramDurationId();
			}

			traineeProgdurationTraineelevelDetails.setProgramDurationId(programDurationId);
			traineeProgdurationTraineelevelDetails.setTraineeId(themeDisplay.getUserId());
			traineeProgdurationTraineelevelDetails.setTraineeLevelId(traineeLevelId);
			traineeProgdurationTraineelevelDetails.setGroupId(themeDisplay.getScopeGroupId());
			traineeProgdurationTraineelevelDetails.setCompanyId(themeDisplay.getCompanyId());
			traineeProgdurationTraineelevelDetails.setCreateDate(calendar.getTime());
			traineeProgdurationTraineelevelDetails.setCreatedBy(themeDisplay.getUserId());
		}
		
		_logger.debug("createTraineeProgdurationTraineelevelDetails Exit ::: ");
		return traineeProgdurationTraineelevelDetails;
	}

	public static TraineeElectiverotationPriorityDetails createTraineeElectiverotationPriorityDetails(TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetails, boolean isCreate, ThemeDisplay themeDisplay, long[] selectedElectiveRotations, int sequence, long traineePdTlErDetailsId) {
		_logger.debug("createTraineeElectiverotationPriorityDetails Invoked ::: ");
		
		Calendar calendar = Calendar.getInstance();
		
		traineeElectiverotationPriorityDetails.setModifiedDate(calendar.getTime());
		traineeElectiverotationPriorityDetails.setModifiedBy(themeDisplay.getUserId());
		traineeElectiverotationPriorityDetails.setSequence(sequence+1);
		traineeElectiverotationPriorityDetails.setRotationId(selectedElectiveRotations[sequence]);
		if(isCreate) {
			traineeElectiverotationPriorityDetails.setTraineePdTlErDetailsId(traineePdTlErDetailsId);
			traineeElectiverotationPriorityDetails.setGroupId(themeDisplay.getScopeGroupId());
			traineeElectiverotationPriorityDetails.setCompanyId(themeDisplay.getCompanyId());
			traineeElectiverotationPriorityDetails.setCreateDate(calendar.getTime());
			traineeElectiverotationPriorityDetails.setCreatedBy(themeDisplay.getUserId());
		}
		_logger.debug("createTraineeElectiverotationPriorityDetails Exit ::: ");
		return traineeElectiverotationPriorityDetails;
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTraineeElectiveRotationsUtil.class);
}

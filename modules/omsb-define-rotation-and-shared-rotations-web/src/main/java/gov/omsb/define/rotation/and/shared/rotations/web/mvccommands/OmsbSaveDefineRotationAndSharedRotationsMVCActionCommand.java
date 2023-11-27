package gov.omsb.define.rotation.and.shared.rotations.web.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbDefineRotationAndSharedRotationsWebPortletKeys.OMSBDEFINEROTATIONANDSHAREDROTATIONSWEB,
		"mvc.command.name="	+ OmsbDefineRotationAndSharedRotationsWebPortletKeys.SAVE_DRASR_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveDefineRotationAndSharedRotationsMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("processAction Invoked ::: ");
		boolean isSuccess = false;
		isSuccess = createOrUpdateProgdurationRotationTrainingsitesRel(actionRequest);
		
		_logger.info("processAction Exit ::: ");
		return isSuccess;
	}
	
	private boolean createOrUpdateProgdurationRotationTrainingsitesRel(ActionRequest actionRequest) {
		_logger.info("createProgdurationRotationTrainingsitesRel Invoked ::: ");
		long programMasterId = ParamUtil.getLong(actionRequest, OmsbTmsCommonConstants.PROGRAM, 0);
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbTmsCommonConstants.PROG_DURATION_ID, 0);
		long rotationMasterId = ParamUtil.getLong(actionRequest, OmsbTmsCommonConstants.ROTATION_MASTER_ID, 0);
		boolean isSharedRotation = ParamUtil.getBoolean(actionRequest, OmsbTmsCommonConstants.IS_SHARED_ROTATION, Boolean.FALSE);
		long sharedProgramId = ParamUtil.getLong(actionRequest, OmsbTmsCommonConstants.SHARED_PROGRAM_ID, 0);
		long trainingSiteMasterId = ParamUtil.getLong(actionRequest, OmsbTmsCommonConstants.TRAINING_SITE_MASTER_ID, 0);
		int noOfSlots = ParamUtil.getInteger(actionRequest, OmsbTmsCommonConstants.No_OF_SLOTS, 0);
		long progdurationRotationTrainingsitesRelId = ParamUtil.getLong(actionRequest, OmsbDefineRotationAndSharedRotationsWebPortletKeys.PROG_DURATION_ROTATION_TRAINING_SITE_REL_ID, 0);
		boolean isCreate = true;
		
		try {
			ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = null;
			if(progdurationRotationTrainingsitesRelId != 0) {
				isCreate = false;
				progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService.getProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRelId);
			} else {
			
				if(isSharedRotation && isDuplicateRecordForSharedProgram(progDurationId, sharedProgramId, rotationMasterId)) {
					SessionErrors.add(actionRequest, "duplicate-entry-found-define-rotation-for-shared-rotation");
					return false;					
				} else if (isDuplicateRecordForNotSharedProgram(progDurationId, trainingSiteMasterId, rotationMasterId)) {
					SessionErrors.add(actionRequest, "duplicate-entry-found-define-rotation-for-not-shared-rotation");
					return false;
				} else {
					SessionErrors.clear(actionRequest);
				}
				
				SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				progdurationRotationTrainingsitesRelId = counterLocalService.increment(getClass().getName(), 1);
				progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService.createProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRelId);
			}
				
			
			progdurationRotationTrainingsitesRel.setProgramDurationId(progDurationId);
			progdurationRotationTrainingsitesRel.setIsSharedRotation(isSharedRotation);
			progdurationRotationTrainingsitesRel.setRotationId(rotationMasterId);
			String progcodeRsnSitecode = StringPool.BLANK;
			
			_logger.debug("createProgdurationRotationTrainingsitesRel ::: isSharedRotation " + isSharedRotation);
			
			if(!isSharedRotation) {
				progdurationRotationTrainingsitesRel.setTrainingSitesId(trainingSiteMasterId);
				progdurationRotationTrainingsitesRel.setNoOfSlots(noOfSlots);
				progdurationRotationTrainingsitesRel.setRotationOwningProgramId(0);
				
				ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programMasterId);
				RotationMaster rotationMaster = rotationMasterLocalService.getRotationMaster(rotationMasterId);
				TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(trainingSiteMasterId);
				progcodeRsnSitecode = programMaster.getProgramCode(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH) + StringPool.DASH + rotationMaster.getRotationShortName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH) + StringPool.DASH + trainingSitesMaster.getTrainingSiteCode(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH);
				
			} else {
				progdurationRotationTrainingsitesRel.setRotationOwningProgramId(sharedProgramId);
				progdurationRotationTrainingsitesRel.setTrainingSitesId(0);
				progdurationRotationTrainingsitesRel.setNoOfSlots(0);
			}
			progdurationRotationTrainingsitesRel.setProgCodeRsnSiteCode(progcodeRsnSitecode);
			
			if(isCreate) {
				progdurationRotationTrainingsitesRelLocalService.addProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRel);
			} else {
				progdurationRotationTrainingsitesRelLocalService.updateProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRel);
			}
			
			_logger.debug("createProgdurationRotationTrainingsitesRel ::: Record Created ");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("createProgdurationRotationTrainingsitesRel Exit ::: ");
		return true;
	}
	
	private boolean isDuplicateRecordForNotSharedProgram(long progDurationId, long trainingSiteId, long rotationId) {
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService.findByProgDurationTrainingSitesAndRotationId(progDurationId, trainingSiteId, rotationId);
		return Validator.isNotNull(progdurationRotationTrainingsitesRel);
	}
	
	private boolean isDuplicateRecordForSharedProgram(long progDurationId, long sharedProgramId, long rotationId) {
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService.findByProgDurationRotationOwningProgramAndRotationId(progDurationId, sharedProgramId, rotationId);
		return Validator.isNotNull(progdurationRotationTrainingsitesRel);
	}
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService; 
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService; 
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService; 

	@Reference
	ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveDefineRotationAndSharedRotationsMVCActionCommand.class.getName());

}

package gov.omsb.program.cohort.web.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.util.CommonUtil;
import gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys;
import gov.omsb.program.cohort.web.dto.ProgramCohortRelationalDTO;
import gov.omsb.program.cohort.web.portlet.util.ProgramCohortUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.BlockWeekMetadataDetailsRelLocalService;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbProgramCohortWebPortletKeys.OMSBPROGRAMCOHORTWEB,
"mvc.command.name=" + OmsbProgramCohortWebPortletKeys.SAVE_PROGRAM_COHORT_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbProgramCohortSaveMVCActionCommand implements MVCActionCommand  {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		//programId - programId from programDetails page
		long programId = ParamUtil.getLong(actionRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_ID, 0);
		long programDurationId = ParamUtil.getLong(actionRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_DURATION_ID, 0);
		long programMasterId = ParamUtil.getLong(actionRequest, OmsbProgramCohortWebPortletKeys.PROGRAM, 0);
		String cohort = ParamUtil.getString(actionRequest, OmsbProgramCohortWebPortletKeys.COHORT, StringPool.BLANK);
		boolean isCreate = ParamUtil.getBoolean(actionRequest, "isCreate", false);
		
		List<ProgramCohortRelationalDTO> programCohortRelationalDTOs = ProgramCohortUtil.prepareProgramCohortRelationalDTOs(actionRequest);
		
		// sort programCohortRelationalDTOs List
		programCohortRelationalDTOs = programCohortRelationalDTOs.stream().sorted((o1, o2)-> Long.compare(o1.getTraineeLevelId(), o2.getTraineeLevelId())).collect(Collectors.toList());
		
		ProgramDurationDetails programDurationDetails = null;
		if(Validator.isNull(programDurationId)) {
			
			programDurationDetails = programDurationDetailsLocalService.findByProgramIdAndAYApplicableFrom(programMasterId, cohort);
			_logger.debug("ProcessAction ::: Program Duration Record Find By Program Id and Cohort");	
			if(Validator.isNull(programDurationDetails)) {
				programDurationDetails = createProgramDurartion(actionRequest, themeDisplay, programMasterId, cohort);
				programDurationDetails = programDurationDetailsLocalService.addProgramDurationDetails(programDurationDetails);
				_logger.debug("ProcessAction ::: Program Duration Record Created");
			}
				
		} else {
			try {
				programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(programDurationId);
			} catch (PortalException e) {
				_logger.error("Error While Getting Program Duration ::: " + e);
			}
		}
		
		if(programDurationDetails != null) {
			if(isCreate && checkDuplicateTraineeAndCohort(programDurationDetails.getProgDurationId(), programCohortRelationalDTOs)) {
				 setErrorMessage(actionRequest,OmsbProgramCohortWebPortletKeys.PROGRAM_COHORT_CREATED_ERROR_MESSAGE);
				return false;
			} else if(!checkInvalidBlocksNumbers(programCohortRelationalDTOs, isCreate, programDurationId)) {
				 setErrorMessage(actionRequest,OmsbProgramCohortWebPortletKeys.PROGRAM_COHORT_BLOCK_ERROR_MESSAGE);
				return false;
			} else {
				createOrUpdateProgdurationTraineelevelBlocksLevelTypeRel(programCohortRelationalDTOs, programDurationDetails.getProgDurationId(), themeDisplay, actionRequest);
				try {
					actionResponse.sendRedirect(ProgramCohortUtil.createAddProgramCohortRenderUrl(themeDisplay, actionRequest, programId));
				} catch (IOException e) {
					_logger.error(e);
				}
			}
		}
		
		_logger.debug("ProcessAction ::: Program Duration Trainee Level Blocks Level Type Rel Record Created");
		_logger.info("ProcessAction Exit ::: ");
		
		return true;
	}
	
	private boolean checkDuplicateTraineeAndCohort(long programDurationId, List<ProgramCohortRelationalDTO> programCohortRelationalDTOs) {
		_logger.info("checkDuplicateTraineeAndCohort ::: Invoked");
		boolean isDuplicateFound = false;
		
		for(ProgramCohortRelationalDTO cohortRelationalDTO : programCohortRelationalDTOs) {
			try {
				if(Validator.isNotNull(progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationIdAndTraineeLevelId(programDurationId, cohortRelationalDTO.getTraineeLevelId()))) {
					isDuplicateFound = true;
					break;
				}
			} catch (Exception e) {
				_logger.error("checkDuplicateTraineeAndCohort ::: " + e);
			}
		}
		
		_logger.info("checkDuplicateTraineeAndCohort ::: Exit");
		return isDuplicateFound;
	}
	
	private boolean checkInvalidBlocksNumbers(List<ProgramCohortRelationalDTO> programCohortRelationalDTOs, boolean isCreate, long programDurationId) {
		_logger.info("validateBlocksNumbers ::: Invoked");
		boolean isValidBlockNumbers = true;
		if(isCreate) {
			// Validate Block Number for the Add Trainee Level
			isValidBlockNumbers = validateBlockNumbersForAddCohort(programCohortRelationalDTOs, isValidBlockNumbers);
		} else {
			// Validate Block Number for the Edit Trainee Level
			isValidBlockNumbers = validateBlocksForEditCohort(programCohortRelationalDTOs, programDurationId, isValidBlockNumbers);
		}
		
		_logger.info("validateBlocksNumbers ::: Exit");
		return isValidBlockNumbers;
	}

	private boolean validateBlockNumbersForAddCohort(List<ProgramCohortRelationalDTO> programCohortRelationalDTOs, boolean isValidBlockNumbers) {
		_logger.info("validateBlocksNumbers ::: Validate Block Number for the Add Trainee Level");
		if(Validator.isNotNull(programCohortRelationalDTOs) && !programCohortRelationalDTOs.isEmpty()) {
			long lastTraineeLevelId = programCohortRelationalDTOs.get(programCohortRelationalDTOs.size()-1).getTraineeLevelId();
			for(ProgramCohortRelationalDTO cohortRelationalDTO : programCohortRelationalDTOs) {
				if(cohortRelationalDTO.getTraineeLevelId() != lastTraineeLevelId && cohortRelationalDTO.getNoOfBlocks() != 13) {
					isValidBlockNumbers = false;
				}
			}
		}
		return isValidBlockNumbers;
	}
	
	private boolean validateBlocksForEditCohort(List<ProgramCohortRelationalDTO> programCohortRelationalDTOs, long programDurationId, boolean isValidBlockNumbers) {
		_logger.info("validateBlocksNumbers ::: Validate Block Number for the Edit Trainee Level");
		List<ProgdurationTraineelevelBlocksLevelTypeRel>  progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programDurationId);
		// sort list
		progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRels.stream().sorted((o1, o2)-> Long.compare(o1.getTraineeLevelId(), o2.getTraineeLevelId())).collect(Collectors.toList());
		long lastTraineeLevelId = progdurationTraineelevelBlocksLevelTypeRels.get(progdurationTraineelevelBlocksLevelTypeRels.size()-1).getTraineeLevelId();
		for(ProgramCohortRelationalDTO cohortRelationalDTO : programCohortRelationalDTOs) {
			if(cohortRelationalDTO.getTraineeLevelId() != lastTraineeLevelId && cohortRelationalDTO.getNoOfBlocks() != 13) {
				isValidBlockNumbers = false;
			}
		}
		
		// Delete blocks if its last trainee level update
		if(isValidBlockNumbers && programCohortRelationalDTOs.size() == 1 && programCohortRelationalDTOs.get(0).getTraineeLevelId() == lastTraineeLevelId) {
			ProgdurationTraineelevelBlocksLevelTypeRel  progdurationTraineelevelBlocksLevelTypeRel = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationIdAndTraineeLevelId(programDurationId, lastTraineeLevelId);
			ProgramCohortUtil.deleteBlocks(progdurationTraineelevelBlocksLevelTypeRel.getProgdurationTlBlocksLtId());
		}
		return isValidBlockNumbers;
	}
	
	private boolean createOrUpdateProgdurationTraineelevelBlocksLevelTypeRel(List<ProgramCohortRelationalDTO> programCohortRelationalDTOs, long programDurationId, ThemeDisplay themeDisplay, ActionRequest actionRequest) {
		_logger.info("createOrUpdateProgdurationTraineelevelBlocksLevelTypeRel Invoked ::: ");
		boolean isSuccess = false;
		for(ProgramCohortRelationalDTO dto : programCohortRelationalDTOs) {
			boolean isCreate = false;
			try {
				ProgdurationTraineelevelBlocksLevelTypeRel traineelevelBlocksLevelTypeRel = null;
				if(Validator.isNull(dto.getProgdurationTlBlocksLtId())) {
					traineelevelBlocksLevelTypeRel = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationIdAndTraineeLevelId(programDurationId, dto.getTraineeLevelId());
					if(Validator.isNull(traineelevelBlocksLevelTypeRel)) {
						isCreate = true;
						long progdurationTraineelevelBlocksLevelTypeRelId = counterLocalService.increment(getClass().getName(), 1);
						traineelevelBlocksLevelTypeRel = progdurationTraineelevelBlocksLevelTypeRelLocalService.createProgdurationTraineelevelBlocksLevelTypeRel(progdurationTraineelevelBlocksLevelTypeRelId);	
					}
				} else {
					isCreate = false;
					traineelevelBlocksLevelTypeRel = progdurationTraineelevelBlocksLevelTypeRelLocalService.getProgdurationTraineelevelBlocksLevelTypeRel(dto.getProgdurationTlBlocksLtId());
				}
				
				traineelevelBlocksLevelTypeRel.setGroupId(themeDisplay.getScopeGroupId());
				traineelevelBlocksLevelTypeRel.setCompanyId(themeDisplay.getCompanyId());
				traineelevelBlocksLevelTypeRel.setLevelTypeId(dto.getLevelTypeId());
				traineelevelBlocksLevelTypeRel.setNoOfBlocks(dto.getNoOfBlocks());
				traineelevelBlocksLevelTypeRel.setTraineeLevelId(dto.getTraineeLevelId());
				traineelevelBlocksLevelTypeRel.setProgramDurationId(programDurationId);
				
				if(isCreate) {
					progdurationTraineelevelBlocksLevelTypeRelLocalService.addProgdurationTraineelevelBlocksLevelTypeRel(traineelevelBlocksLevelTypeRel);	
				} else {
					progdurationTraineelevelBlocksLevelTypeRelLocalService.updateProgdurationTraineelevelBlocksLevelTypeRel(traineelevelBlocksLevelTypeRel);
				}
				isSuccess = true;
				setSucessesMessage(actionRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_COHORT_CREATED_SUCCESS_MESSAGE);
			} catch (Exception e) {
				_logger.error("Error while creating record programDurationID : " + programDurationId + " levelTypeId : " + dto.getLevelTypeId() + " noOfBlocks : " + dto.getNoOfBlocks() + " traineeLevelId : " + dto.getTraineeLevelId() + StringPool.BLANK  + e);
			}
		}
		
		if(isSuccess)
			isSuccess = updateNoOfBlocksInProgramDetails(programDurationId);
		
		if(isSuccess)
			isSuccess = createBlocks(programDurationId, themeDisplay);
		
		_logger.info("createOrUpdateProgdurationTraineelevelBlocksLevelTypeRel Exit ::: ");
		return isSuccess;
	}
	
	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}
	
	private boolean createBlocks(long programDurationId, ThemeDisplay themeDisplay) {
		_logger.debug("createBlocks Invoked ::: ");
		boolean isSuccess = false;
		try {
			ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(programDurationId);
			List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programDurationId);
			
			// Sort TraineeLevels
			progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRels.stream().sorted((o1, o2)-> Long.compare(o1.getTraineeLevelId(), o2.getTraineeLevelId())).collect(Collectors.toList());
			
			SimpleDateFormat formatter = new SimpleDateFormat(OmsbTmsCommonConstants.DATE_FORMAT_DD_MM_YYYY);
			long currentYear = Long.parseLong(programDurationDetails.getAyApplicableForm().split(StringPool.DASH)[0]);
			for(ProgdurationTraineelevelBlocksLevelTypeRel traineeLevelBlockLevelTypeRel : progdurationTraineelevelBlocksLevelTypeRels) {
				Date startDate = formatter.parse(OmsbTmsCommonConstants.YEAR_START_DATE_FOR_BLOCK + currentYear);
				currentYear++;
				createBlocksForTraineeLevel(startDate,traineeLevelBlockLevelTypeRel.getProgdurationTlBlocksLtId(), traineeLevelBlockLevelTypeRel.getNoOfBlocks(), themeDisplay);
				_logger.debug("createBlocks ::: Blocks Created for ProgdurationTraineelevelBlocksLevelTypeRel : " + traineeLevelBlockLevelTypeRel.getProgdurationTlBlocksLtId());
			}
			isSuccess = true;
			
		} catch (ParseException | PortalException e) {
			_logger.error("createBlocks " + e);
		}  
		
		_logger.debug("createBlocks Exit ::: ");
		return isSuccess;
	}
	
	@SuppressWarnings("deprecation")
	private Date createBlocksForTraineeLevel(Date startDate, long progDurationTlBlocksLtId, long noOfBlocks, ThemeDisplay themeDisplay) {
		_logger.info("createBlocksForTraineeLevel Invoked :::");
		Calendar startDateCal = Calendar.getInstance();
		startDateCal.setTime(startDate);
		BlocksMetadataDetailsRel blocksMetadataDetailsRel = null;
		for(long block = 1; block <= noOfBlocks; block++) {
			Calendar endDate = CommonUtil.nextSaturdayDateAfterAddingNoOfDays((Calendar)startDateCal.clone(), 28);
			BlocksMetadataDetailsRel detailsRel = null;
			detailsRel =  blocksMetadataDetailsRelLocalService.findByProgDurationTlBlocksLtIdAndBlockStartDate(progDurationTlBlocksLtId, startDateCal.getTime());
			
			if(Validator.isNotNull(detailsRel)) {
				try {
					blocksMetadataDetailsRel = blocksMetadataDetailsRelLocalService.updateBlockMetadataDetailsRel(detailsRel.getBlocksMetadataDetailsRelId(), OmsbTmsCommonConstants.BLOCK + StringPool.DASH + block, startDateCal.getTime(), endDate.getTime(), progDurationTlBlocksLtId,themeDisplay);
					if(Validator.isNotNull(blocksMetadataDetailsRel)) {
						_logger.debug("updateBlocksForTraineeLevel ::: ProgDurationTlBlocksLtId : " + blocksMetadataDetailsRel.getProgDurationTlBlocksLtId());
					}
				} catch (Exception e) {
					_logger.error("updateBlocksForTraineeLevel ::: " + e);
				}
				_logger.debug("updateBlocksForTraineeLevel ::: Block Created for BlockMetadataDetailsRel : " + (OmsbTmsCommonConstants.BLOCK + StringPool.DASH + block) + startDate.getYear());
			} else {
				blocksMetadataDetailsRel = blocksMetadataDetailsRelLocalService.createBlockMetadataDetailsRel(OmsbTmsCommonConstants.BLOCK + StringPool.DASH + block, startDateCal.getTime(), endDate.getTime(), progDurationTlBlocksLtId,themeDisplay);
				
				if (Validator.isNotNull(blocksMetadataDetailsRel)) {
					createBlocksForWeeks(startDateCal, blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId(), endDate, themeDisplay);
				}

				_logger.debug("createBlocksForTraineeLevel ::: Block Created for BlockMetadataDetailsRel : " + (OmsbTmsCommonConstants.BLOCK + StringPool.DASH + block) + startDate.getYear());
			}

			endDate.add(Calendar.DAY_OF_MONTH,1);
	        startDateCal = endDate;
		}
		_logger.info("createBlocksForTraineeLevel Exit :::");
		return startDateCal.getTime();
	}

	private void createBlocksForWeeks(Calendar startDateCal, long blocksMetadataDetailsRelId, Calendar endDate, ThemeDisplay themeDisplay) {
		Calendar weekStartDateCal = startDateCal;
		for (int weekNo = 1; weekStartDateCal.before(endDate) || weekStartDateCal.equals(endDate); weekNo++) {
		    Calendar weekEndDateCal = CommonUtil.nextSaturdayDateAfterAddingNoOfDays((Calendar)weekStartDateCal.clone(), 7);

			blockWeekMetadataDetailsRelLocalService.createBlockWeekMetadataDetailsRel(blocksMetadataDetailsRelId, weekStartDateCal.getTime(), weekEndDateCal.getTime(), OmsbTmsCommonConstants.WEEK + StringPool.DASH + weekNo, themeDisplay.getUserId(), themeDisplay.getScopeGroupId());

		    weekEndDateCal.add(Calendar.DAY_OF_MONTH, 1);
		    weekStartDateCal = weekEndDateCal;
		}
	}

	private boolean updateNoOfBlocksInProgramDetails(long programDurationId) {
		_logger.info("updateNoOfBlocksInProgramDetails Invoked ::: ");
		try {
			ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(programDurationId);
			List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programDurationId);
			programDurationDetails.setNoOfBlocks(progdurationTraineelevelBlocksLevelTypeRels.stream().mapToInt(ProgdurationTraineelevelBlocksLevelTypeRel::getNoOfBlocks).sum());
			programDurationDetailsLocalService.updateProgramDurationDetails(programDurationDetails);
			_logger.debug("updateNoOfBlocksInProgramDetails ::: NoOfBlocks Updated For ProgramDurationId ::: " + programDurationDetails.getProgDurationId());
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("updateNoOfBlocksInProgramDetails Exit ::: ");
		return true;
	}
	
	private ProgramDurationDetails createProgramDurartion(ActionRequest actionRequest, ThemeDisplay themeDisplay, long programMasterId, String cohort) {
		_logger.info("createProgramDurartion Invoked ::: ");
		ProgramDurationDetails programDurationDetails = null;
		_logger.debug(programMasterId + cohort);
		if(Validator.isNotNull(programMasterId) && Validator.isNotNull(cohort)) {
			long programDurationId = counterLocalService.increment(getClass().getName(), 1);
			programDurationDetails = programDurationDetailsLocalService.createProgramDurationDetails(programDurationId);
			programDurationDetails.setGroupId(themeDisplay.getScopeGroupId());
			programDurationDetails.setCompanyId(themeDisplay.getCompanyId());
			programDurationDetails.setAyApplicableForm(ParamUtil.getString(actionRequest, OmsbTmsCommonConstants.COHORT, StringPool.BLANK));
			programDurationDetails.setNoOfBlocks(0); 
			programDurationDetails.setProgramId(programMasterId);
		}
		_logger.info("createProgramDurartion Exit ::: ");
		return programDurationDetails;
	}
	
	@Reference
	ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;
	
	@Reference
	BlockWeekMetadataDetailsRelLocalService blockWeekMetadataDetailsRelLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramCohortSaveMVCActionCommand.class.getName());
}

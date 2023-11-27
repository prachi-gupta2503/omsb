package gov.omsb.program.cohort.web.mvccommands;

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
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys;
import gov.omsb.program.cohort.web.portlet.util.ProgramCohortUtil;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbProgramCohortWebPortletKeys.OMSBPROGRAMCOHORTWEB,
"mvc.command.name=" + OmsbProgramCohortWebPortletKeys.DELETE_PROGRAM_COHORT_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbProgramCohortDeleteMVCActionCommand implements MVCActionCommand  {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = false;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//programId - programId from programDetails page
		long programId = ParamUtil.getLong(actionRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_ID, 0);
		
		long progdurationTlBlocksLtId = ParamUtil.getLong(actionRequest, OmsbProgramCohortWebPortletKeys.PROGDURATION_TL_BLOCKS_TS_REL_ID, 0);
		try {
			ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel = progdurationTraineelevelBlocksLevelTypeRelLocalService.deleteProgdurationTraineelevelBlocksLevelTypeRel(progdurationTlBlocksLtId);
			_logger.debug("ProcessAction ::: Program Duration Trainee Level Blocks Level Type Rel Record Deleted");
			if(Validator.isNotNull(progdurationTraineelevelBlocksLevelTypeRel)) {
				ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(progdurationTraineelevelBlocksLevelTypeRel.getProgramDurationId());
				List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(progdurationTraineelevelBlocksLevelTypeRel.getProgramDurationId());
				programDurationDetails.setNoOfBlocks(progdurationTraineelevelBlocksLevelTypeRels.stream().mapToInt(ProgdurationTraineelevelBlocksLevelTypeRel::getNoOfBlocks).sum());
				programDurationDetailsLocalService.updateProgramDurationDetails(programDurationDetails);
				_logger.debug("ProcessAction ::: NoOfBlocks Updated For ProgramDurationId ::: " + programDurationDetails.getProgDurationId());
				
				isSuccess = ProgramCohortUtil.deleteBlocks(progdurationTraineelevelBlocksLevelTypeRel.getProgdurationTlBlocksLtId());
			}
			actionResponse.sendRedirect(ProgramCohortUtil.createAddProgramCohortRenderUrl(themeDisplay, actionRequest, programId));
		} catch (PortalException | IOException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_COHORT_DELETED_ERROR_MESSAGE);
		}
		setSucessesMessage(actionRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_COHORT_DELETED_SUCCESS_MESSAGE);
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}

	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;
	
	@Reference
	ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramCohortDeleteMVCActionCommand.class.getName());
}

package gov.omsb.view.program.cohort.web.mvccommands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Comparator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.view.program.cohort.web.constants.OmsbViewProgramCohortWebPortletKeys;
import gov.omsb.view.program.cohort.web.util.OmsbViewProgramCohortUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbViewProgramCohortWebPortletKeys.OMSBVIEWPROGRAMCOHORTWEB,
"mvc.command.name=" + OmsbViewProgramCohortWebPortletKeys.PROGRAM_COHORT_TRAINEE_LEVEL_LIST_MVC_RESOURCE_COMMAND}, service = MVCResourceCommand.class)
public class OmsbProgramCohortTraineeLevelListMVCResouceCommand  implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		_logger.info("serveResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programDurationId = ParamUtil.getLong(resourceRequest, OmsbViewProgramCohortWebPortletKeys.PROGRAM_DURATION_ID, 0);
		List<ProgramCohortDTO> programCohortDTOs = progdurationTraineelevelBlocksLevelTypeRelLocalService.getProgramCohortsRelationalDataByProgramDurationId(programDurationId, themeDisplay.getLocale().toString());
		programCohortDTOs.sort(Comparator.comparing(ProgramCohortDTO::getTraineeLevelName));
		omsbViewProgramCohortUtil.prepareActionData(programCohortDTOs, themeDisplay, resourceRequest);
		omsbViewProgramCohortUtil.prepareResponseJsonForProgramCohortDTOs(resourceRequest, resourceResponse, programCohortDTOs);
		
		return true;
	}
	@Reference(unbind = "_")
	private OmsbViewProgramCohortUtil omsbViewProgramCohortUtil;
	
	@Reference(unbind = "_")
	private UserMetadataUtil userMetadataUtil;
	
	@Reference
	LeaveMasterLocalService leaveMasterLocalService;
	
	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramCohortTraineeLevelListMVCResouceCommand.class.getName());

}

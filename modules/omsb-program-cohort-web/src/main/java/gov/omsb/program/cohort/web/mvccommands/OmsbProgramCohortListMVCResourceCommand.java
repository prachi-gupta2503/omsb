package gov.omsb.program.cohort.web.mvccommands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys;
import gov.omsb.program.cohort.web.portlet.util.ProgramCohortUtil;
import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbProgramCohortWebPortletKeys.OMSBPROGRAMCOHORTWEB,
"mvc.command.name=" + OmsbProgramCohortWebPortletKeys.PROGRAM_COHORT_LIST_MVC_RESOURCE_COMMAND}, service = MVCResourceCommand.class)
public class OmsbProgramCohortListMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		_logger.info("doServeResource Invoked :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		List<Long> programMasterIds = new ArrayList<>();
		List<ProgramMaster> programMasterList = new ArrayList<>();
		if (isSuperAdmin || isChairman) {
			programMasterList = programMasterLocalService.getProgramMasters(-1, -1);
			programMasterIds = programMasterList.stream().map(ProgramMaster::getProgramMasterId).collect(Collectors.toList());
		} else {
			try {
				UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
				if(Validator.isNotNull(userMetadataItem) && userMetadataItem.getItems() != null ) {
					programMasterIds = (userMetadataItem.getItems()).stream().map(UserMetadata::getProgramId).collect(Collectors.toList());
				}
				_logger.debug("Program Id :: " + programMasterIds.toString());
				_logger.debug("programMasterList size :: " + programMasterList.size());
			} catch (Exception e) {
				_logger.error(e);
			}
		}
		
		List<String> yearRange = ProgramCohortUtil.getYearRangeForSearch(programDurationDetailsLocalService.getProgramDurationDetailsesCount(), resourceRequest);
		List<ProgramCohortDTO> programCohortDTOs =  progdurationTraineelevelBlocksLevelTypeRelLocalService.getProgramCohorts(programMasterIds, yearRange, themeDisplay.getLocale().toString());
		programCohortDTOs = programCohortDTOs.stream().sorted(Comparator.comparing(ProgramCohortDTO::getModifiedDate).reversed()).collect(Collectors.toList());
		ProgramCohortUtil.prepareActionData(programCohortDTOs, themeDisplay, resourceRequest);
		ProgramCohortUtil.prepareResponseJsonForProgramCohortDTOs(resourceRequest, resourceResponse, programCohortDTOs);
		_logger.info("doServeResource Exit :::");
	}
	
	@Reference(unbind = "_")
	private UserMetadataUtil userMetadataUtil;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramCohortListMVCResourceCommand.class.getName());

}

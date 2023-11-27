package gov.omsb.view.program.cohort.web.mvccommands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.view.program.cohort.web.constants.OmsbViewProgramCohortWebPortletKeys;
import gov.omsb.view.program.cohort.web.util.OmsbViewProgramCohortUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbViewProgramCohortWebPortletKeys.OMSBVIEWPROGRAMCOHORTWEB,
"mvc.command.name=" + OmsbViewProgramCohortWebPortletKeys.PROGRAM_COHORT_LIST_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbProgramCohortListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		_logger.info("serveResource Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long programMasterId = ParamUtil.getLong(resourceRequest, OmsbViewProgramCohortWebPortletKeys.PROGRAM_ID, 0);
		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		List<Long> programMasterIds = new ArrayList<>();
		
		if(Validator.isNull(programMasterId)) {
			List<ProgramMaster> programMasterList;
			if (isSuperAdmin || isChairman) {
				_logger.debug("serveResource ::: isSuperAdmin " + isSuperAdmin);
				_logger.debug("serveResource ::: isChairman " + isChairman);
				programMasterList = programMasterLocalService.findByProgramStatus(Boolean.TRUE);
				programMasterIds =  programMasterList.stream().map(ProgramMaster::getProgramMasterId).collect(Collectors.toList());
			} else {
				try {
					UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
					programMasterIds = CommonUtil.getProgramIdsFromUsermetadataItems(userMetadataItem);
				} catch (Exception e) {
					_logger.error(e);
				}
			}
		} else {
			programMasterIds.add(programMasterId);
		}
		_logger.debug("serveResource ::: programMasterIds " + programMasterIds.toString());
		
		List<String> yearRange = OmsbViewProgramCohortUtil.getYearRangeForSearch(programDurationDetailsLocalService.getProgramDurationDetailsesCount(), resourceRequest);
		List<ProgramCohortDTO> programCohortDTOs =  programDurationDetailsLocalService.getProgramAndCohortsFromProgramDuration(programMasterIds, yearRange, themeDisplay.getLocale().toString());
		omsbViewProgramCohortUtil.prepareResponseJsonForProgramCohortDTOs(resourceRequest, resourceResponse, programCohortDTOs);
		_logger.info("serveResource Exit ::: ");
		return true;
	}

	@Reference(unbind = "_")
	private OmsbViewProgramCohortUtil omsbViewProgramCohortUtil;
	
	@Reference(unbind = "_")
	private UserMetadataUtil userMetadataUtil;
	
	@Reference
	ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramCohortListMVCResourceCommand.class.getName());

}

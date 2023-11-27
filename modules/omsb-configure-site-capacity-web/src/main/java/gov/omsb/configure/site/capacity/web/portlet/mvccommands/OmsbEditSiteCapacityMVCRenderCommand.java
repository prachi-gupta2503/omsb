package gov.omsb.configure.site.capacity.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.configure.site.capacity.web.constants.OmsbConfigureSiteCapacityWebPortletKeys;
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbConfigureSiteCapacityWebPortletKeys.OMSBCONFIGURESITECAPACITYWEB,
		"mvc.command.name="
				+ OmsbConfigureSiteCapacityWebPortletKeys.RENDER_EDIT_SITE_CAPACITY_MVC_COMMAND_NAME }, service = MVCRenderCommand.class)

public class OmsbEditSiteCapacityMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("OmsbEditSiteCapacityMVCRenderCommand render Invoked ::: ");
		long progdurationRotationTsRelId = ParamUtil.getLong(renderRequest,
				OmsbConfigureSiteCapacityWebPortletKeys.PROGDURATION_ROTATION_TS_REL_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ProgdurationRotationTrainingsitesRel pdRotationTrainingsitesRel;
		try {
			pdRotationTrainingsitesRel = pdRotationTrainingsitesRelLocalService
					.getProgdurationRotationTrainingsitesRel(progdurationRotationTsRelId);
			ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService
					.getProgramDurationDetails(pdRotationTrainingsitesRel.getProgramDurationId());
			ProgramMaster programMaster = programMasterLocalService
					.getProgramMaster(programDurationDetails.getProgramId());

			List<ProgramDurationDetails> programDurationDetailList = programDurationDetailsLocalService
					.findProgramDurationByProgramId(programDurationDetails.getProgramId());

			UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(
					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			List<Long> programMasterIds = new ArrayList<>();
			if (Validator.isNotNull(userMetadataItem) && Validator.isNotNull(userMetadataItem.getItems())) {
				programMasterIds = (userMetadataItem.getItems()).stream().map(UserMetadata::getProgramId)
						.collect(Collectors.toList());
			}

			List<ProgramMaster> programMasterList = programMasterLocalService.findByProgramMasterId(programMasterIds);

			List<TrainingSiteByPdDTO> trainingSiteByPdDTOs = pdRotationTrainingsitesRelLocalService
					.getTrainingSitesByCohort(pdRotationTrainingsitesRel.getProgramDurationId(),
							themeDisplay.getLocale().toString());

			List<RotationListDTO> rotationListDTOs = pdRotationTrainingsitesRelLocalService
					.getNotSharedRotationsByTrainingSitesId(pdRotationTrainingsitesRel.getTrainingSitesId(),
							themeDisplay.getLocale().toString());
			renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.RENDER_EDIT_PROGRAMS, programMaster);
			renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.RENDER_EDIT_COHORT_DETAILS,
					programDurationDetails);
			renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.ALL_PROGRAM_LIST, programMasterList);
			renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.ALL_TRAINING_SITE_LIST,
					trainingSiteByPdDTOs);
			renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.ALL_ROTATION_LIST, rotationListDTOs);
			renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.RENDER_EDIT_SITE_CAPACITY_DETAILS,
					pdRotationTrainingsitesRel);
			renderRequest.setAttribute("programDurationDetailList", programDurationDetailList);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return OmsbConfigureSiteCapacityWebPortletKeys.EDIT_SITE_CAPACITY_JSP;
	}

	@Reference(unbind = "_")
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService pdRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditSiteCapacityMVCRenderCommand.class.getName());
}

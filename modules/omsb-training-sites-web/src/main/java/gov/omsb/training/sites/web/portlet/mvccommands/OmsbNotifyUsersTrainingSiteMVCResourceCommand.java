package gov.omsb.training.sites.web.portlet.mvccommands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.custom.dto.ConfigureRotationBlockDetailsDTO;
import gov.omsb.tms.custom.dto.ProgdurationRotationTrainingSiteDTO;
import gov.omsb.tms.model.ProgramMasterModel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;
import gov.omsb.training.sites.web.dto.OmsbTrainingSiteDetailsDTO;
import gov.omsb.training.sites.web.portlet.util.OmsbTrainingSitesUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTrainingSitesWebPortletKeys.OMSBTRAININGSITESWEB,
		"mvc.command.name="
				+ OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_NOTIFY_SITES_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbNotifyUsersTrainingSiteMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long rotationId = ParamUtil.get(resourceRequest, OmsbTrainingSitesWebPortletKeys.ROTATION_ID, 0);
		String userIds = ParamUtil.get(resourceRequest, OmsbTrainingSitesWebPortletKeys.USER_ID, "");

		String currentYear = OmsbTrainingSitesUtil.getCurrentYear();

		OmsbTrainingSiteDetailsDTO omsbTrainingSiteDetailsDTO = new OmsbTrainingSiteDetailsDTO();

		long trainingSiteDemand = 0;
		long trainingSiteSupply = 0;

		List<ProgdurationRotationTrainingSiteDTO> progdurationRotationTrainingSiteDTOs = trainingSitesMasterLocalService
				.getProgdurationRotationByRotationAndDuration(rotationId, currentYear, themeDisplay.getLanguageId());

		for (ProgdurationRotationTrainingSiteDTO progdurationRotationTrainingSiteDTO : progdurationRotationTrainingSiteDTOs) {
			trainingSiteSupply = trainingSiteSupply + progdurationRotationTrainingSiteDTO.getNoOfSlots() * 13;
		}

		ConfigureRotationBlockDetailsDTO configureRotationBlockDetailsDTO = progdurationRotationTraineelevelBlocksRelLocalService
				.getConfigureRotationDetailsByRotationAndDuration(rotationId, currentYear);

		trainingSiteDemand = trainingSiteDemand + configureRotationBlockDetailsDTO.getNoOfBlocks() * 100;

		omsbTrainingSiteDetailsDTO.setCurrentSlots(trainingSiteSupply);
		omsbTrainingSiteDetailsDTO.setDemandSlots(trainingSiteDemand);

		ProgramMasterModel programMaster = programMasterLocalService.getProgramMaster(programDurationDetailsLocalService
				.getProgramDurationDetails(progdurationRotationTrainingSiteDTOs.get(0).getProgDurationId())
				.getProgramId());
		RotationMaster rotationMaster = rotationMasterLocalService.getRotationMaster(rotationId);
		TrainingSitesMaster trainingSiteMaster = trainingSitesMasterLocalService
				.getTrainingSitesMaster(progdurationRotationTrainingSiteDTOs.get(0).getTrainingSiteId());

		omsbTrainingSiteDetailsDTO.setTrainingSiteName(trainingSiteMaster.getTrainingSiteName());
		omsbTrainingSiteDetailsDTO.setRotationName(rotationMaster.getRotationName());
		omsbTrainingSiteDetailsDTO.setProgramName(programMaster.getProgramName());
		omsbTrainingSiteDetailsDTO.setUserIds(userIds);

		OmsbTrainingSitesUtil.prepareMailMessage(omsbTrainingSiteDetailsDTO, themeDisplay.getUser(), "");
		OmsbTrainingSitesUtil.prepareNotificationMessage(omsbTrainingSiteDetailsDTO, themeDisplay.getUser(), "");
	}

	@Reference
	private UserLocalService userLocalservice;

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbNotifyUsersTrainingSiteMVCResourceCommand.class);

}

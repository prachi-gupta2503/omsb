package gov.omsb.training.sites.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.TrainingSiteStructureDTO;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;
import gov.omsb.training.sites.web.portlet.util.OmsbTrainingSitesTaskExecutor;
import gov.omsb.training.sites.web.portlet.util.OmsbTrainingSitesUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, configurationPid = "gov.omsb.training.sites.web.configurable.OmsbTrainingSitesConfiguration", property = {
		"javax.portlet.name=" + OmsbTrainingSitesWebPortletKeys.OMSBTRAININGSITESWEB, "mvc.command.name="
				+ OmsbTmsCommonConstants.TRAINING_SITE_DETAILS_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbViewTrainingSiteDetailsRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("Render Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progDurationId = ParamUtil.getLong(renderRequest, OmsbTrainingSitesWebPortletKeys.PROG_DURARION_ID, 0l);
		long trainingSiteMasterId = ParamUtil.getLong(renderRequest,
				OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_MASTER_ID);

		try {

			List<Long> programIds = userMetadataUtil
					.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
							themeDisplay.getUserId())
					.getItems().stream().map(UserMetadata::getProgramId).collect(Collectors.toList());

			TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService
					.getTrainingSitesMaster(trainingSiteMasterId);
			
			List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService
					.findByProgramDurationId(progDurationId);
			
			Set<TrainingSitesMaster> otherTrainingSitesList = new HashSet<>();
			for(ProgdurationRotationTrainingsitesRel pdRotationTsRel : progdurationRotationTrainingsitesRel) {
				if(Validator.isNotNull(pdRotationTsRel.getTrainingSitesId()) && pdRotationTsRel.getTrainingSitesId() != 0) {
					TrainingSitesMaster tsMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(pdRotationTsRel.getTrainingSitesId());
					otherTrainingSitesList.add(tsMaster);
				}
			}
			
			List<TrainingSiteStructureDTO> trainingSiteStructureDTOList = trainingSitesMasterLocalService
					.getTrainingSiteStructure(programIds, OmsbTrainingSitesUtil.getCurrentYear(), trainingSiteMasterId,
							themeDisplay.getLocale().toString());

			Map<Long, Boolean> rotationShortageMap = OmsbTrainingSitesTaskExecutor.getShortageMap();

			HashMap<String, HashMap<String, Long>> programDTOList = new LinkedHashMap<>();
			HashMap<String, Long> rotationNameAndKeyMap = new LinkedHashMap<>();

			_logger.debug("rotationShortageMap ::: " + ((rotationShortageMap != null) ? rotationShortageMap.toString() : rotationShortageMap) );
			rotationShortageMap = null;
			renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.ROTATION_SHORTAGE_MAP, rotationShortageMap);

			renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.TRAINING_SITE, trainingSitesMaster);
			renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_OTHER, otherTrainingSitesList);
			renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_STRUCTURE_LIST,
					OmsbTrainingSitesUtil.getTrainingSiteStructure(trainingSiteStructureDTOList, programDTOList,
							rotationNameAndKeyMap));
			renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.ROTAITON_NAME_AND_KEY_MAP,
					rotationNameAndKeyMap);
			renderRequest.setAttribute(CommonConstants.IS_TRAINEE_USER_OR_IS_FACULTY_USER,
					(CommonUtil.isTraineeUser(themeDisplay.getUser()) || CommonUtil.isFacultyUser(themeDisplay.getUser())));
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.PROG_DURARION_ID, progDurationId);
		renderRequest.setAttribute("programListRenderUrl", OmsbTrainingSitesUtil.createProgramDetailsPageRenderUrl(themeDisplay,
				renderRequest, progDurationId));
		renderRequest.setAttribute("programNameWithCohort", OmsbTrainingSitesUtil.getProgramNameWithCohort(progDurationId,themeDisplay));
		
		_logger.debug("Render Exit ::: ");
		return OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_DETAILS_PAGE_URL;
	}
	
	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbViewTrainingSiteDetailsRenderCommand.class.getName());
}

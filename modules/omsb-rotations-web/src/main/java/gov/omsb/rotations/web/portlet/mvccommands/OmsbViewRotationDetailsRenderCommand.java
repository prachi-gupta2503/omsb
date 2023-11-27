package gov.omsb.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.rotations.web.constants.OmsbRotationsWebPortletKeys;
import gov.omsb.rotations.web.portlet.util.OmsbRotationsUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.RotationStructureDTO;
import gov.omsb.tms.model.CompetenciesMaster;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.RotationCompetenciesRequirementsRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationObjectivesRel;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.CompetenciesMasterLocalService;
import gov.omsb.tms.service.ProgdurationCompetenciesRequirementsRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationsWebPortletKeys.OMSBROTATIONSWEB,
		"mvc.command.name="
				+ OmsbTmsCommonConstants.ROTATION_DETAILS_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbViewRotationDetailsRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("Render Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long rotationMasterId = ParamUtil.getLong(renderRequest, OmsbRotationsWebPortletKeys.ROTATION_MASTER_ID);
		long progDurationId = ParamUtil.getLong(renderRequest, OmsbTmsCommonConstants.PROGRAM_DURATION_ID, 0l);

		boolean isTraineeOrFaculty = Boolean.FALSE;
		if(CommonUtil.isTraineeUser(themeDisplay.getUser()) || CommonUtil.isFacultyUser(themeDisplay.getUser())) {
			isTraineeOrFaculty = Boolean.TRUE;
		}
		
		try {
			
			RotationMaster rotationMaster = rotationMasterLocalService.getRotationMaster(rotationMasterId);
			setOtherRotationList(progDurationId, renderRequest, rotationMaster.getRotationStatus());
			
			List<TraineeLevelMaster> traineeLevelMasters = traineeLevelMasterLocalService
					.getTraineeLevelMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			List<RotationStructureDTO> rotationStructureDTOList = rotationMasterLocalService
					.getRotationStructure(rotationMasterId, themeDisplay.getLocale().toString());

			List<CompetenciesMaster> competenciesMasters = competenciesMasterLocalService
					.getCompetenciesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			

			List<RotationCompetenciesRequirementsRel> competenciesRequirementsRels = OmsbRotationsUtil
					.getCompetenciesRequirementsListByProgDurationIdAndRotationId(progDurationId, rotationMasterId);
			List<RotationObjectivesRel> rotationObjectivesRels = OmsbRotationsUtil
					.getRotationObjectivesListByProgDurationIdAndRotationId(progDurationId, rotationMasterId);
			
			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.COMPETENCIES, competenciesMasters);
			renderRequest.setAttribute("competenciesRequirementsRels", competenciesRequirementsRels);
			renderRequest.setAttribute("rotationObjectivesRels", rotationObjectivesRels);

			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.ROTATION_IS_SHARED,
					isSharedRotaiton(rotationMasterId));
			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.ROTATION, rotationMaster);
			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.TRAINEE_LEVEL_LIST, traineeLevelMasters);
			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.ROTATION_STRUCTURE_LIST, OmsbRotationsUtil
					.getRotationStructure(themeDisplay, traineeLevelMasters, rotationStructureDTOList));
			renderRequest.setAttribute("programNameWithCohort", OmsbRotationsUtil.getProgramNameWithCohort(progDurationId,themeDisplay));

		} catch (PortalException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		renderRequest.setAttribute(CommonConstants.IS_TRAINEE_USER,
				isTraineeOrFaculty);
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROG_DURATION_ID, progDurationId);
		renderRequest.setAttribute("programListRenderUrl", OmsbRotationsUtil.createProgramDetailsPageRenderUrl(themeDisplay,
				renderRequest, progDurationId));
		
		_logger.info("Render Exit ::: ");
		return OmsbRotationsWebPortletKeys.ROTATION_DETAILS_PAGE_URL;
	}

	private void setOtherRotationList(long progDurationId, RenderRequest renderRequest, boolean rotationStatus) {
	    List<RotationMaster> otherRotationList;
	    
	    if (progDurationId != 0) {
	        otherRotationList = buildRotationListFromDurationId(progDurationId);
	    } else {
	        otherRotationList = rotationMasterLocalService.findByRotationStatus(rotationStatus);
	    }
	    
		otherRotationList = otherRotationList.stream().filter(rotation -> !OmsbTmsCommonConstants.LEAVE.equalsIgnoreCase(rotation.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH))).collect(Collectors.toList());
	    renderRequest.setAttribute(OmsbRotationsWebPortletKeys.ROTATION_LIST_OTHER, otherRotationList);
	}

	private List<RotationMaster> buildRotationListFromDurationId(long progDurationId) {
	    List<RotationMaster> result = new ArrayList<>();
	    List<ProgdurationRotationTraineelevelBlocksRel> traineelevelBlocksRels =  
	            progdurationRotationTraineelevelBlocksRelLocalService.findTraineeLevelByDurationId(progDurationId);
	    
	    Set<Long> seenRotationIds = new HashSet<>();

	    for (ProgdurationRotationTraineelevelBlocksRel blocksRel : traineelevelBlocksRels) {
	        long rotationId = blocksRel.getRotationId();
	        if (!seenRotationIds.contains(rotationId)) {
	            try {
	                RotationMaster rotationMaster = rotationMasterLocalService.getRotationMaster(rotationId);
	                result.add(rotationMaster);
	                seenRotationIds.add(rotationId);
	            } catch (PortalException e) {
	                _logger.error(e.getMessage(), e);
	            }
	        }
	    }
	    return result;
	}

	private boolean isSharedRotaiton(long rotationId) {
		boolean isSharedRotation = false;
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRelLocalService
				.findByRotationId(rotationId, Boolean.TRUE);

		if (Validator.isNotNull(progdurationRotationTrainingsitesRels)
				&& !progdurationRotationTrainingsitesRels.isEmpty())
			isSharedRotation = true;

		return isSharedRotation;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	private CompetenciesMasterLocalService competenciesMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private ProgdurationCompetenciesRequirementsRelLocalService competenciesRequirementsRelService;
	
	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbViewRotationDetailsRenderCommand.class.getName());
}

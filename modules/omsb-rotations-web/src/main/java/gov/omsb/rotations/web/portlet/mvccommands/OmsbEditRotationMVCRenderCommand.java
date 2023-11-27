package gov.omsb.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

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
import gov.omsb.tms.model.CompetenciesMaster;
import gov.omsb.tms.model.RotationCompetenciesRequirementsRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationObjectivesRel;
import gov.omsb.tms.service.CompetenciesMasterLocalService;
import gov.omsb.tms.service.ProgdurationCompetenciesRequirementsRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationsWebPortletKeys.OMSBROTATIONSWEB,
		"mvc.command.name="
				+ OmsbRotationsWebPortletKeys.ROTATION_EDIT_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditRotationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long rotationMasterId = ParamUtil.getLong(renderRequest, OmsbRotationsWebPortletKeys.ROTATION_MASTER_ID);
		
		boolean isTraineeOrFaculty = Boolean.FALSE;
		if(CommonUtil.isTraineeUser(themeDisplay.getUser()) || CommonUtil.isFacultyUser(themeDisplay.getUser())) {
			isTraineeOrFaculty = Boolean.TRUE;
		}

		try {
			RotationMaster rotationMaster = rotationMasterLocalService.getRotationMaster(rotationMasterId);

			List<CompetenciesMaster> competenciesMasters = competenciesMasterLocalService
					.getCompetenciesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			long progDurationId = ParamUtil.getLong(renderRequest, OmsbRotationsWebPortletKeys.PROG_DURARION_ID, 0l);
			
			List<RotationCompetenciesRequirementsRel> competenciesRequirementsRels = OmsbRotationsUtil
					.getCompetenciesRequirementsListByProgDurationIdAndRotationId(progDurationId, rotationMasterId);
			List<RotationObjectivesRel> rotationObjectivesRels = OmsbRotationsUtil
					.getRotationObjectivesListByProgDurationIdAndRotationId(progDurationId, rotationMasterId);
			
			List<RotationMaster> otherRotationList = rotationMasterLocalService.getRotationMasters(QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
			
			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.ROTATION_LIST_OTHER, otherRotationList);

			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.COMPETENCIES, competenciesMasters);
			renderRequest.setAttribute("competenciesRequirementsRels", competenciesRequirementsRels);
			renderRequest.setAttribute("rotationObjectivesRels", rotationObjectivesRels);
			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.PROG_DURARION_ID, progDurationId);
			renderRequest.setAttribute(OmsbRotationsWebPortletKeys.ROTATION, rotationMaster);
			renderRequest.setAttribute(CommonConstants.IS_TRAINEE_USER,
					isTraineeOrFaculty);
			renderRequest.setAttribute("programListRenderUrl", OmsbRotationsUtil.createProgramDetailsPageRenderUrl(themeDisplay,
					renderRequest, progDurationId));
			renderRequest.setAttribute("programNameWithCohort", OmsbRotationsUtil.getProgramNameWithCohort(progDurationId,themeDisplay));
		} catch (PortalException e) {
			_logger.error(e);
		}

		_logger.info("render Exit ::: ");
		return OmsbRotationsWebPortletKeys.ROTATION_EDIT_PAGE_URL;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private CompetenciesMasterLocalService competenciesMasterLocalService;

	@Reference
	private ProgdurationCompetenciesRequirementsRelLocalService competenciesRequirementsRelService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditRotationMVCRenderCommand.class.getName());

}

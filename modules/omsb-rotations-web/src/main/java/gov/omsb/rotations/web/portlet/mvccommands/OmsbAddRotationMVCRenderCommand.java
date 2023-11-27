package gov.omsb.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.rotations.web.constants.OmsbRotationsWebPortletKeys;
import gov.omsb.rotations.web.portlet.util.OmsbRotationsUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.CompetenciesMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.service.CompetenciesMasterLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationsWebPortletKeys.OMSBROTATIONSWEB,
		"mvc.command.name="
				+ OmsbRotationsWebPortletKeys.ROTATION_ADD_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbAddRotationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<RotationMaster> otherRotationList = rotationMasterLocalService.getRotationMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		renderRequest.setAttribute(OmsbRotationsWebPortletKeys.ROTATION_LIST_OTHER, otherRotationList);

		List<CompetenciesMaster> competenciesMasters = competenciesMasterLocalService
				.getCompetenciesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute(OmsbRotationsWebPortletKeys.COMPETENCIES, competenciesMasters);

		long progDurationId = ParamUtil.getLong(renderRequest, OmsbTmsCommonConstants.PROGRAM_DURATION_ID, 0l);

		renderRequest.setAttribute(OmsbRotationsWebPortletKeys.PROG_DURARION_ID, progDurationId);
		renderRequest.setAttribute("competenciesRequirementsRels", new ArrayList<>());
		renderRequest.setAttribute("rotationObjectivesRels", new ArrayList<>());
		renderRequest.setAttribute("programListRenderUrl", OmsbRotationsUtil.createProgramDetailsPageRenderUrl(themeDisplay,
				renderRequest, progDurationId));
		renderRequest.setAttribute("programNameWithCohort", OmsbRotationsUtil.getProgramNameWithCohort(progDurationId,themeDisplay));

		_logger.info("render Exit ::: ");
		return OmsbRotationsWebPortletKeys.ROTATION_ADD_PAGE_URL;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private CompetenciesMasterLocalService competenciesMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbAddRotationMVCRenderCommand.class.getName());
}

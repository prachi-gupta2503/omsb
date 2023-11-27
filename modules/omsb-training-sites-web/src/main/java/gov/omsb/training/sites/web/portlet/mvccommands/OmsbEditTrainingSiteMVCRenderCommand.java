package gov.omsb.training.sites.web.portlet.mvccommands;

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

import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;
import gov.omsb.training.sites.web.portlet.util.OmsbTrainingSitesUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTrainingSitesWebPortletKeys.OMSBTRAININGSITESWEB,
"mvc.command.name=" + OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_EDIT_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditTrainingSiteMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progDurationId = ParamUtil.getLong(renderRequest, OmsbTrainingSitesWebPortletKeys.PROG_DURARION_ID, 0l);
		
		long trainingSiteMasterId = ParamUtil.getLong(renderRequest,OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_MASTER_ID);
		
		try {
			TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(trainingSiteMasterId);
			renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.TRAINING_SITE, trainingSitesMaster);
			
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		
		List<TrainingSitesMaster> otherTrainingSitesList = trainingSitesMasterLocalService.getTrainingSitesMasters(-1,-1);
		renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_OTHER, otherTrainingSitesList);
		renderRequest.setAttribute(OmsbTrainingSitesWebPortletKeys.PROG_DURARION_ID, progDurationId);
		renderRequest.setAttribute("programListRenderUrl", OmsbTrainingSitesUtil.createProgramDetailsPageRenderUrl(themeDisplay,
				renderRequest, progDurationId));
		renderRequest.setAttribute("programNameWithCohort", OmsbTrainingSitesUtil.getProgramNameWithCohort(progDurationId,themeDisplay));
		_logger.info("render Exit ::: ");
		return OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_EDIT_PAGE_URL;
	}
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditTrainingSiteMVCRenderCommand.class.getName());

}

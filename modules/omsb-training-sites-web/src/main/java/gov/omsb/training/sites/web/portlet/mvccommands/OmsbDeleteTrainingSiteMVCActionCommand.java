package gov.omsb.training.sites.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;
import gov.omsb.training.sites.web.portlet.util.OmsbTrainingSitesUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTrainingSitesWebPortletKeys.OMSBTRAININGSITESWEB,
"mvc.command.name=" + OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_DELETE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteTrainingSiteMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbTrainingSitesWebPortletKeys.PROG_DURARION_ID);
		
		long trainingSiteMasterId = ParamUtil.getLong(actionRequest, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_MASTER_ID, 0);
		try {
			trainingSitesMasterLocalService.deleteTrainingSitesMaster(trainingSiteMasterId);
			actionResponse.sendRedirect(OmsbTrainingSitesUtil.createAddTrainingSiteRenderUrl(themeDisplay,
					actionRequest, progDurationId));
			_logger.debug("ProcessAction ::: Training Site Master Record Deleted");
		} catch (PortalException | IOException e) {
			_logger.error(e.getMessage());
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteTrainingSiteMVCActionCommand.class.getName());

}

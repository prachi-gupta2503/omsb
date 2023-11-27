package gov.omsb.trainee.level.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.trainee.level.web.constants.OmsbTraineeLevelConstants;
import gov.omsb.trainee.level.web.constants.OmsbTraineeLevelWebPortletKeys;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTraineeLevelWebPortletKeys.OMSBTRAINEELEVELWEB,
		"mvc.command.name="
				+ OmsbTraineeLevelConstants.SAVE_TRAINEE_LEVEL_COMMAND_NAME }, service = MVCActionCommand.class)

public class OmsbSaveTraineeLevelMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		long traineeLevelMasterId = ParamUtil.getLong(actionRequest, OmsbTraineeLevelConstants.TRAINEE_LEVEL_MASTER_ID,
				0);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if (traineeLevelMasterId != 0) {
				// Update Trainee Level
				isSuccess = traineeLevelMasterLocalService.updateTraineeLevelMaster(actionRequest, traineeLevelMasterId, themeDisplay);
			} else {
				// Create Trainee Level
				isSuccess = traineeLevelMasterLocalService.createTraineeLevelMaster(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveTraineeLevelMVCActionCommand.class.getName());

}
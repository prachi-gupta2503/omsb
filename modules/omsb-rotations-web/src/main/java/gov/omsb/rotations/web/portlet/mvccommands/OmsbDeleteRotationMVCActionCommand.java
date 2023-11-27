package gov.omsb.rotations.web.portlet.mvccommands;

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

import gov.omsb.rotations.web.constants.OmsbRotationsWebPortletKeys;
import gov.omsb.rotations.web.portlet.util.OmsbRotationsUtil;
import gov.omsb.tms.service.RotationMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationsWebPortletKeys.OMSBROTATIONSWEB,
"mvc.command.name=" + OmsbRotationsWebPortletKeys.ROTATION_DELETE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteRotationMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programCohortId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.PROG_DURARION_ID, 0);
		
		long rotationMasterId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_MASTER_ID, 0);
		try {
			rotationMasterLocalService.deleteRotationMaster(rotationMasterId);
			actionResponse.sendRedirect(OmsbRotationsUtil.createAddRotationRenderUrl(themeDisplay, actionRequest, programCohortId));
			_logger.debug("ProcessAction ::: Rotation Master Record Deleted");
		} catch (PortalException | IOException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteRotationMVCActionCommand.class.getName());

}

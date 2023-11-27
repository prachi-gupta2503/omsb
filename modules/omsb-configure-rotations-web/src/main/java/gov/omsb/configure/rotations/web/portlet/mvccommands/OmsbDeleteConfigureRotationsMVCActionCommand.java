package gov.omsb.configure.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.configure.rotations.web.constants.OmsbConfigureRotationsWebPortletKeys;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;

/**
 * 
 * @author Komal Gajera
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbConfigureRotationsWebPortletKeys.OMSBCONFIGUREROTATIONSWEB,
"mvc.command.name=" + OmsbConfigureRotationsWebPortletKeys.DELETE_CONFIGURE_ROTATIONS_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteConfigureRotationsMVCActionCommand implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		long configureRotationMasterId = ParamUtil.getLong(actionRequest, OmsbConfigureRotationsWebPortletKeys.CONFIGURE_ROTATIONS_MASTER_ID, 0);
		try {
			progdurationRotationTraineelevelBlocksRelLocalService.deleteProgdurationRotationTraineelevelBlocksRel(configureRotationMasterId);
			_logger.debug("ProcessAction ::: Eligibility Degree Master Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteConfigureRotationsMVCActionCommand.class.getName());

	
}

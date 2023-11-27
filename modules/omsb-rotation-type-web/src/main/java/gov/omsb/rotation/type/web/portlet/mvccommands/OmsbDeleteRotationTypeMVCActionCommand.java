package gov.omsb.rotation.type.web.portlet.mvccommands;

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

import gov.omsb.rotation.type.web.constants.OmsbRotationTypeWebPortletKeys;
import gov.omsb.tms.service.RotationTypeMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationTypeWebPortletKeys.OMSBROTATIONTYPEWEB,
		"mvc.command.name="
				+ OmsbRotationTypeWebPortletKeys.DELETE_ROTATION_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteRotationTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		long rotationTypeMasterId = ParamUtil.getLong(actionRequest,
				OmsbRotationTypeWebPortletKeys.ROTATION_TYPE_MASTER_ID, 0);
		try {
			//delete rotationtype
			rotationTypeMasterLocalService.deleteRotationTypeMaster(rotationTypeMasterId);
			_logger.debug("ProcessAction ::: Rotation Type Master Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}

	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteRotationTypeMVCActionCommand.class.getName());

}

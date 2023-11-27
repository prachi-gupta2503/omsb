package gov.omsb.role.types.web.portlet.mvccommands;

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

import gov.omsb.role.types.web.constants.OmsbRoleTypesWebPortletKeys;
import gov.omsb.tms.service.RoleTypeMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRoleTypesWebPortletKeys.OMSBROLETYPESWEB,
"mvc.command.name=" + OmsbRoleTypesWebPortletKeys.DELETE_ROLE_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteRoleTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		long roleTypeMasterId = ParamUtil.getLong(actionRequest, OmsbRoleTypesWebPortletKeys.ROLE_TYPE_MASTER_ID, 0);
		try {
			roleTypeMasterLocalService.deleteRoleTypeMaster(roleTypeMasterId);
			_logger.debug("ProcessAction ::: Role Type Master Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}
	
	@Reference
	private RoleTypeMasterLocalService roleTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteRoleTypeMVCActionCommand.class.getName());


}

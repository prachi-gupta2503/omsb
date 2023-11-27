package gov.omsb.role.types.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.role.types.web.constants.OmsbRoleTypesWebPortletKeys;
import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.service.RoleTypeMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRoleTypesWebPortletKeys.OMSBROLETYPESWEB,
"mvc.command.name=" + OmsbRoleTypesWebPortletKeys.EDIT_ROLE_TYPE_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditRoleTypeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long roleTypeMasterId = ParamUtil.getLong(renderRequest, OmsbRoleTypesWebPortletKeys.ROLE_TYPE_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbRoleTypesWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		
		try {
			RoleTypeMaster roleTypeMaster = roleTypeMasterLocalService.getRoleTypeMaster(roleTypeMasterId);
			renderRequest.setAttribute(OmsbRoleTypesWebPortletKeys.ROLE_TYPE, roleTypeMaster);

			List<RoleTypeMaster> roleTypeMasterList = roleTypeMasterLocalService.getRoleTypeMasters(-1, -1);
			renderRequest.setAttribute(OmsbRoleTypesWebPortletKeys.ROLE_TYPE_MASTER_LIST, roleTypeMasterList);
			renderRequest.setAttribute(OmsbRoleTypesWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbRoleTypesWebPortletKeys.EDIT_ROLE_TYPE_JSP;
	}
	
	@Reference
	private RoleTypeMasterLocalService roleTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditRoleTypeMVCRenderCommand.class.getName());
}

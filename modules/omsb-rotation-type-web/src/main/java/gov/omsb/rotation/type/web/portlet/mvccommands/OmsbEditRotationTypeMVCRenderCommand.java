package gov.omsb.rotation.type.web.portlet.mvccommands;

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

import gov.omsb.rotation.type.web.constants.OmsbRotationTypeWebPortletKeys;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.service.RotationTypeMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationTypeWebPortletKeys.OMSBROTATIONTYPEWEB,
"mvc.command.name=" + OmsbRotationTypeWebPortletKeys.EDIT_ROTATION_TYPE_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditRotationTypeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long rotationTypeMasterId = ParamUtil.getLong(renderRequest, OmsbRotationTypeWebPortletKeys.ROTATION_TYPE_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbRotationTypeWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		
		try {
			//Getting rotationtype by id
			RotationTypeMaster rotationTypeMaster = rotationTypeMasterLocalService.getRotationTypeMaster(rotationTypeMasterId);
			renderRequest.setAttribute(OmsbRotationTypeWebPortletKeys.ROTATION_TYPE, rotationTypeMaster);

			//List of rotationtype
			List<RotationTypeMaster> rotationTypeMasterList = rotationTypeMasterLocalService.getRotationTypeMasters(-1, -1);
			renderRequest.setAttribute(OmsbRotationTypeWebPortletKeys.ROTATION_TYPE_MASTER_LIST, rotationTypeMasterList);
			renderRequest.setAttribute(OmsbRotationTypeWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbRotationTypeWebPortletKeys.EDIT_ROTATION_TYPE_JSP;
	}
	
	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditRotationTypeMVCRenderCommand.class.getName());
}

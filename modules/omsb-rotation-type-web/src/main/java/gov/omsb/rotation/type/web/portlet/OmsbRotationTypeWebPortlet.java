package gov.omsb.rotation.type.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.rotation.type.web.constants.OmsbRotationTypeWebPortletKeys;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.service.RotationTypeMasterLocalService;

/**
 * @author HP
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbRotationTypeWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbRotationTypeWebPortletKeys.ADD_ROTATION_TYPE_JSP,
		"javax.portlet.name=" + OmsbRotationTypeWebPortletKeys.OMSBROTATIONTYPEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbRotationTypeWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		_logger.debug("render Invoked ::: ");
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbRotationTypeWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		//List of rotationtype
		List<RotationTypeMaster> rotationTypeMasterList = rotationTypeMasterLocalService.getRotationTypeMasters(-1, -1);
		renderRequest.setAttribute(OmsbRotationTypeWebPortletKeys.ROTATION_TYPE_MASTER_LIST, rotationTypeMasterList);
		renderRequest.setAttribute(OmsbRotationTypeWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		_logger.debug("render Exit ::: ");
		
		super.render(renderRequest, renderResponse);
	}
	
	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbRotationTypeWebPortlet.class.getName());
}
package gov.omsb.rotations.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.rotations.web.constants.OmsbRotationsWebPortletKeys;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = {"javax.portlet.version=3.0", "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.header-portlet-js=/js/custom.js",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=OmsbRotationsWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbRotationsWebPortletKeys.ROTATION_LIST_PAGE_URL,
		"javax.portlet.name=" + OmsbRotationsWebPortletKeys.OMSBROTATIONSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbRotationsWebPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		renderRequest.setAttribute(CommonConstants.IS_TRAINEE_USER, CommonUtil.isTraineeUser(themeDisplay.getUser()));
		super.render(renderRequest, renderResponse);
	}
}
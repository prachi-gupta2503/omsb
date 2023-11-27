package omsb.vehpc.equivalency.web.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import omsb.vehpc.appeal.preferences.AppealConfiguration;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author HabeebT
 */
@Component(immediate = true, configurationPid = OmsbVehpcEquivalencyWebPortletKeys.APPEAL_CONFIGURATION_ID, property = {
		"com.liferay.portlet.display-category=OMSB", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=OmsbVehpcEquivalencyWeb",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.config-template=/jsps/configuration.jsp",
		"javax.portlet.init-param.view-template=/jsps/equivalency.jsp",
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbVehpcEquivalencyWebPortlet extends MVCPortlet {

	private volatile AppealConfiguration appealConfiguration;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute(AppealConfiguration.class.getName(), appealConfiguration);
		super.render(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		appealConfiguration = ConfigurableUtil.createConfigurable(AppealConfiguration.class, properties);
	}
}
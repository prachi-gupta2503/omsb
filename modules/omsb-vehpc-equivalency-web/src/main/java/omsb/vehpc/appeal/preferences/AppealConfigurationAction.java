package omsb.vehpc.appeal.preferences;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(configurationPid = OmsbVehpcEquivalencyWebPortletKeys.APPEAL_CONFIGURATION_ID, configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true, property = "javax.portlet.name="
		+ OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB, service = ConfigurationAction.class)
public class AppealConfigurationAction extends DefaultConfigurationAction {
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info("Blade Message Portlet configuration include");
		}

		httpServletRequest.setAttribute(AppealConfiguration.class.getName(), _appealConf);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info("Blade Message Portlet configuration action");
		}

		String appealValidity = ParamUtil.getString(actionRequest, "appealValidity");
		String showEquivalencyCertificate = ParamUtil.getString(actionRequest, "showEquivalencyCertificate");
		String showEquivalencyLevel = ParamUtil.getString(actionRequest, "showEquivalencyLevel");

		if (_log.isInfoEnabled()) {

			_log.info("appealValidity : " + appealValidity);
			_log.info("showEquivalencyCertificate : " + showEquivalencyCertificate);
			_log.info("showEquivalencyLevel : " + showEquivalencyLevel);
		}

		PortletPreferences portletPreferences = actionRequest.getPreferences();
		portletPreferences.setValue("appealValidity", appealValidity);
		portletPreferences.setValue("showEquivalencyCertificate", showEquivalencyCertificate);
		portletPreferences.setValue("showEquivalencyLevel", showEquivalencyLevel);
		portletPreferences.store();

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_appealConf = ConfigurableUtil.createConfigurable(AppealConfiguration.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(AppealConfiguration.class);

	private volatile AppealConfiguration _appealConf;
}

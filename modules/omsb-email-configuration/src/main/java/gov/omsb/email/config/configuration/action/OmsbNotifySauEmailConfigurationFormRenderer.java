package gov.omsb.email.config.configuration.action;

import com.liferay.configuration.admin.display.ConfigurationFormRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import gov.omsb.email.config.configuration.OmsbNotifySauEmailConfiguration;
import gov.omsb.email.config.constants.EmailConfigurationConstants;

@Component(immediate = true, service = ConfigurationFormRenderer.class)
public class OmsbNotifySauEmailConfigurationFormRenderer implements ConfigurationFormRenderer {

	public static final String CLASS_NAME = OmsbNotifySauEmailConfiguration.class.getName();

	
	
	@Override
	public String getPid() {
		return CLASS_NAME;
	}

	@Override
	public Map<String, Object> getRequestParameters(HttpServletRequest httpServletRequest) {
		
		Map<String, Object> params = new HashMap<>();
		Map<Locale, String> subjectMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG_FIELD_SUBJECT);
	    Map<Locale, String> bodyMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG_FIELD_BODY);
	    
	    LocalizedValuesMap subjectLocalizedValuesMap = new LocalizedValuesMap();
	    LocalizedValuesMap bodyLocalizedValuesMap = new LocalizedValuesMap();

	    for (Map.Entry<Locale, String> subjectEntry : subjectMap.entrySet()) {
	    	subjectLocalizedValuesMap.put(subjectEntry.getKey(), subjectEntry.getValue());
	    }

	    for (Map.Entry<Locale, String> bodyEntry : bodyMap.entrySet()) {
	    	bodyLocalizedValuesMap.put(bodyEntry.getKey(), bodyEntry.getValue());
	    }
	    
	    String subjectXML = LocalizationUtil.getXml(subjectLocalizedValuesMap, EmailConfigurationConstants.CONFIG_FIELD_SUBJECT);
	    String bodyXML = LocalizationUtil.getXml(bodyLocalizedValuesMap, EmailConfigurationConstants.CONFIG_FIELD_BODY);
	    
	    params.put(EmailConfigurationConstants.CONFIG_FIELD_SUBJECT, subjectXML);
		params.put(EmailConfigurationConstants.CONFIG_FIELD_BODY, bodyXML);
		
		_logger.debug("************** setting subject = " + subjectXML);
		_logger.debug("************** setting body = " + bodyXML);		
		
		return params;
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		
		String subjectXML = OmsbNotifySauEmailConfigurationAction.subjectXML();
	    String bodyXML = OmsbNotifySauEmailConfigurationAction.bodyXML();
	    		
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG_FIELD_SUBJECT, subjectXML);
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG_FIELD_BODY, bodyXML);
		
		_logger.debug("************** getting subject = "+subjectXML);
		_logger.debug("************** getting body = "+bodyXML);

		jspRenderer.renderJSP(servletContext, httpServletRequest, httpServletResponse, EmailConfigurationConstants.CONFIG_CUSTOM_JSP);
		
	}

	@Reference(target = "(osgi.web.symbolicname=omsb.email.configuration)", unbind = "-")
	private ServletContext servletContext;

	@Reference
	private JSPRenderer jspRenderer;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbNotifySauEmailConfigurationFormRenderer.class);
}

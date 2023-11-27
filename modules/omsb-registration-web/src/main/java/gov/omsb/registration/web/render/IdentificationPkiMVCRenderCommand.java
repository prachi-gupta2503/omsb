package gov.omsb.registration.web.render;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.endpoint.configuration.api.PkiConfiguration;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(immediate = true, 
configurationPid = "gov.omsb.endpoint.configuration.api.PkiConfiguration",
property = { 
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name="+ MVCCommands.VIEW_IDENTIFICATION_PKI},
service = MVCRenderCommand.class)
public class IdentificationPkiMVCRenderCommand implements MVCRenderCommand{
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		boolean isPkiAvailable=_pkiConfiguration.isPkiAvailable();
		boolean isPkiMandatory=_pkiConfiguration.isPkiMandatory();
		logger.info("isPkiAvailable :: "+isPkiAvailable+ "  isPkiMandatory :: "+isPkiMandatory);
		renderRequest.setAttribute("pkiAvaibility", isPkiAvailable);
		renderRequest.setAttribute("cardReaderIDPURL", CommonConstants.CARD_READER_IDP_URL);
		return OmsbRegistrationWebPortletKeys.IDENTIFICATION_PKI_JSP;
	}	
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_pkiConfiguration = ConfigurableUtil.createConfigurable(
	    		PkiConfiguration.class, properties);
	}
	
	private volatile PkiConfiguration _pkiConfiguration;
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
    private final Log logger=LogFactoryUtil.getLog(IdentificationPkiMVCRenderCommand.class);
}

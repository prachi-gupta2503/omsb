package gov.omsb.registration.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;

/**
 * @author RahulkumarP
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"javax.portlet.display-name=OmsbRegistrationWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.action-url-redirect=false",
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbRegistrationWebPortlet extends MVCPortlet {}


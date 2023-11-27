package gov.omsb.tms.ecm.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;

/**
 * @author Jitendra
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ECMembershipRequest",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.action-url-redirect=false",
		"javax.portlet.init-param.view-template=/jsp/view.jsp",
		"javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class ECMembershipRequestPortlet extends MVCPortlet {
}
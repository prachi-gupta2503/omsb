package gov.omsb.dashboard.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import gov.omsb.dashboard.web.constants.OmsbDashboardWebPortletKeys;

/**
 * @author himansh.nimavat
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.45942329.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.d90dbcf1.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbDashboardWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmsbDashboardWebPortletKeys.OMSBDASHBOARDWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbDashboardWebPortlet extends MVCPortlet {
	
}
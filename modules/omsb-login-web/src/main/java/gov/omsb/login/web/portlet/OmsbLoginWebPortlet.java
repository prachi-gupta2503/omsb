package gov.omsb.login.web.portlet;

import gov.omsb.login.web.constants.OmsbLoginWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author himanshu.nimavat
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbLoginWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmsbLoginWebPortletKeys.OMSBLOGINWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user", 
		"com.liferay.portlet.action-url-redirect=true"
	},
	service = Portlet.class
)
public class OmsbLoginWebPortlet extends MVCPortlet {
}
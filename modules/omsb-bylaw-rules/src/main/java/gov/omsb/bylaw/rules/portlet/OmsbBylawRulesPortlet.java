package gov.omsb.bylaw.rules.portlet;

import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author SachinG
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbBylawRules",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/by-law-home.jsp",
		"javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbBylawRulesPortlet extends MVCPortlet {
}
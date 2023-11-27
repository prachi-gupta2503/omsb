package gov.omsb.master.web.portlet;

import gov.omsb.master.web.constants.OmsbMasterPortletKeys;

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
		"javax.portlet.display-name=OmsbMaster",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/",
		"javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbMasterPortlet extends MVCPortlet {
}
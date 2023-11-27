package gov.omsb.vehpc.appeal.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

/**
 * @author HabeebT
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbVehpcAppealWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/appeal-home.jsp",
		"javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbVehpcAppealWebPortlet extends MVCPortlet {
	
}
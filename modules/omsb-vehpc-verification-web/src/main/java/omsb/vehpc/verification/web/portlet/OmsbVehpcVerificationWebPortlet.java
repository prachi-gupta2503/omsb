package omsb.vehpc.verification.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;

/**
 * @author HabeebT
 */
@Component(
		
		immediate = true,
		property = { 
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css", 
//				"com.liferay.portlet.footer-portal-javascript=/js/main.js?t=57687898",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=OmsbVehpcVerificationWeb", 
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/jsps/verification/verification.jsp",
				"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user" 
				
				}, 
		service = Portlet.class)
public class OmsbVehpcVerificationWebPortlet extends MVCPortlet {

}
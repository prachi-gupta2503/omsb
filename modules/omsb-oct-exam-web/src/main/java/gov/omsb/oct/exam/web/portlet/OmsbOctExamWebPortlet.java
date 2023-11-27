package gov.omsb.oct.exam.web.portlet;

import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author AftabA
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbOctExamWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/",
		"javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"com.liferay.portlet.header-portlet-javascript=/js/moment.min.js?t=52368123",
		"com.liferay.portlet.header-portlet-javascript=/js/fullcalendar.min.js?t=5236453",
		"com.liferay.portlet.header-portlet-css=/css/scheduler-min.css?t=879688222245",
		"com.liferay.portlet.header-portlet-css=/css/fullcalendar.min.css?t=879688222222",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbOctExamWebPortlet extends MVCPortlet {
}	
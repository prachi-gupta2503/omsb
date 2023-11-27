package gov.omsb.exam.web.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;

/**
 * @author anitas
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"javax.portlet.display-name=OMSBExamWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/", "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.header-portlet-css=/css/exam_main.css",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OMSBExamWebPortlet extends MVCPortlet {
}
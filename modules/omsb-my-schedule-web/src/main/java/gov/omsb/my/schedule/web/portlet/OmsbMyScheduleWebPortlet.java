package gov.omsb.my.schedule.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import gov.omsb.my.schedule.web.constants.OmsbMyScheduleWebPortletKeys;

/**
 * @author HP
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbMyScheduleWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + OmsbMyScheduleWebPortletKeys.OMSBMYSCHEDULEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbMyScheduleWebPortlet extends MVCPortlet {
}
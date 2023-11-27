package gov.omsb.email.template.master.portlet;

import gov.omsb.email.template.master.constants.EmailTemplateMasterPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Niddhi Thacker
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.omsb",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/lib/fontawesome.css",
		"com.liferay.portlet.header-portlet-css=/css/lib/jquery.dataTables.min.css",
		"com.liferay.portlet.header-portlet-css=/css/lib/select2.min.css",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/jquery.validate.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/bootstrap-tagsinput.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/jquery.dataTables.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/select2.full.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/additional-methods.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/email_template/main.js?t=23432",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.display-name=Email Template Master",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/email_template/view.jsp",
		"javax.portlet.name=" + EmailTemplateMasterPortletKeys.OMSB_EMAIL_TEMPLATE_MASTER_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class EmailTemplateMasterPortlet extends MVCPortlet {
}
package gov.omsb.form.builder.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author Niddhi Thacker
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.omsb",
		"com.liferay.portlet.header-portlet-css=/css/main.css?t=333333345",
		"com.liferay.portlet.header-portlet-css=/css/lib/summernote-lite.min.css?t=3553443245",
		"com.liferay.portlet.header-portlet-css=/css/lib/fontawesome.css",
		"com.liferay.portlet.header-portlet-css=/css/lib/tagify.css",
		"com.liferay.portlet.header-portlet-css=/css/lib/select2.min.css",
		"com.liferay.portlet.header-portlet-css=/css/lib/jquery.dataTables.min.css?t=6878899",
		"com.liferay.portlet.header-portlet-css=/css/lib/rowReorder.dataTables.min.css?t=6878899",
		"com.liferay.portlet.header-portlet-css=/css/lib/daterangepicker.css?t=879688222222",
		"com.liferay.portlet.header-portlet-css=/css/lib/dropzone.min.css",
		"com.liferay.portlet.header-portlet-css=/css/lib/jsgrid.min.css",
		"com.liferay.portlet.header-portlet-css=/css/lib/jsgrid-theme.min.css",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/jquery.dataTables.min.js?t=5236839",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/dataTables.rowReorder.min.js?t=5236839",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/summernote-lite.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/dropzone.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/jQuery.tagify.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/jquery.validate.min.js?t=5263878989",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/select2.full.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/lib/moment.min.js?t=43655427789",
		"com.liferay.portlet.footer-portlet-javascript=/js/lib/daterangepicker.min.js?t=4556677789",
		"com.liferay.portlet.footer-portlet-javascript=/js/lib/crypto-js.js?t=45567888",
		"com.liferay.portlet.footer-portlet-javascript=/js/lib/jsgrid.min.js?t=45567888",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/additional-methods.min.js?t=323",
		"com.liferay.portlet.footer-portlet-javascript=/js/common/main.js?t=44557332232332333354833388",
		"com.liferay.portlet.footer-portlet-javascript=/js/configuration/main.js?t=564546456",
		"com.liferay.portlet.footer-portlet-javascript=/js/display/main.js?t=6867486876",
		"com.liferay.portlet.css-class-wrapper=form-builder-web",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.action-url-redirect=false",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.display-name=",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/display/modeSelection.jsp",
		"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.version=3.0",
		"javax.portlet.supported-public-render-parameter=formDefinitionId"
	},
	service = Portlet.class
)
public class FormBuilderWebPortlet extends MVCPortlet {


}
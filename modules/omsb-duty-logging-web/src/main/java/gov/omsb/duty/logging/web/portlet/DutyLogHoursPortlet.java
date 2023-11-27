package gov.omsb.duty.logging.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.DutyLoggingConstants;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DutyLogHours", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + DutyLoggingConstants.LOG_DUTY_HOURS_PAGE,
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGHOURS,
		"com.liferay.portlet.header-portlet-css=/css/fullcalendar.min.css?t=879688222222",
		"com.liferay.portlet.header-portlet-css=/css/scheduler-min.css?t=879688222245",
		"com.liferay.portlet.header-portlet-css=/css/main.css?t=879688222222121",
		"com.liferay.portlet.header-portlet-javascript=/js/moment.min.js?t=52368123",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.min.js?t=52368324",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery-ui.min.js?t=5236234",
		"com.liferay.portlet.header-portlet-javascript=/js/fullcalendar.min.js?t=5236453",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DutyLogHoursPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.render(renderRequest, renderResponse);
	}

}
package gov.omsb.faculty.membership.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=OMSB",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=FacultyMembershipRequest",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/faculty-request/my-faculty-requests.jsp",
			"javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIPREQUEST,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class FacultyMembershipRequestPortlet extends MVCPortlet{

}

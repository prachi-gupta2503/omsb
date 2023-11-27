package gov.omsb.faculty.membership.web.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;


@Component(immediate = true, property = {
		"javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"mvc.command.name=/search/dutyLogViolationData" }, service = MVCResourceCommand.class)
public class SearchFacultyRequestMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		Long programMasterId = ParamUtil.getLong(resourceRequest, "programMasterId");
		Long traineeId = ParamUtil.getLong(resourceRequest, "traineeId");
		long traineeLevelId = ParamUtil.getLong(resourceRequest, "traineeLevelId");

		return false;
	}

}

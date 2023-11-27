package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.service.DutyAssignmentLocalService;
import gov.omsb.tms.service.DutyAssignmentLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name="+MVCCommandNames.DELETE_DUTY_ASSIGNMENT 

}, service = MVCResourceCommand.class)
public class DeleteDutyAssignmentMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("DeleteDutyAssignmentMVCResourceCommand Called");
		DutyAssignment dutyAssignment = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		long dutyAssignmentId = Long.parseLong(httpRequest.getParameter("id"));
		LOGGER.info("dutyAssignmentId ======> " + dutyAssignmentId);
		try {
			dutyAssignment = dutyAssignmentLocalService.deleteDutyAssignment(dutyAssignmentId);
			LOGGER.info("DutyAssignment Delete Successfully");
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return true;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(DeleteDutyAssignmentMVCResourceCommand.class);
	@Reference
	private DutyAssignmentLocalService dutyAssignmentLocalService;
}

package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.tms.service.DutyTypesLocalService;
import gov.omsb.tms.service.DutyTypesLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name="+MVCCommandNames.DELETE_DUTY_TYPES

}, service = MVCResourceCommand.class)

public class DeleteDutyTypesMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("DeleteDutyTypeMVCResourceCommand Called");
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		long dutyTypeId =Long.parseLong(httpRequest.getParameter("id"));
		LOGGER.info("dutyTypeId ---> "+dutyTypeId);
		
		dutyTypesLocalService.deleteDutyType(dutyTypeId);
		LOGGER.info("DutyType Delete Successfully");
		
		return true;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(DeleteDutyAssignmentMVCResourceCommand.class);
	@Reference
	private DutyTypesLocalService dutyTypesLocalService;
	
}

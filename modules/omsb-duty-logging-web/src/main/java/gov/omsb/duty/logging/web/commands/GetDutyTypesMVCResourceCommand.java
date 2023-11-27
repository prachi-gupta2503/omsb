package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.duty.logging.web.util.DutyLoggingService;
import gov.omsb.tms.model.DutyTypes;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name=" + MVCCommandNames.GET_DUTY_TYPES_DATA }, service = MVCResourceCommand.class)

public class GetDutyTypesMVCResourceCommand implements MVCResourceCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(GetDutyTypesMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("For edit do serve---------");
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		String id = httpRequest.getParameter("id");
		long dutyTypeId = Long.parseLong(id);
		LOGGER.info("dutyType Id :---->" + dutyTypeId);
		DutyTypes dutyTypes = null;
		JSONObject responseObj = null;
		try {
			dutyTypes = dutyLoggingService.getDutyTypes(dutyTypeId);
			responseObj = JSONFactoryUtil.createJSONObject();
			responseObj.put("dutyType", dutyTypes.getDutyType());
			responseObj.put("dutyTypeId", dutyTypeId);
			JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, responseObj);
		} catch (PortalException e) {
			LOGGER.info("Error while getting duty types "+e.getMessage());
		}catch(IOException e) {
			LOGGER.info("Error"+e.getMessage());
			
		}
		return false;
	}

	@Reference
	private DutyLoggingService dutyLoggingService;
}

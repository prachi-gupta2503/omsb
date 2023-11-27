package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.service.DutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.DutyTypesLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name="+MVCCommandNames.EDIT_DUTY_ASSIGNMENT

}, service = MVCResourceCommand.class)
public class EditDutyAssignmentMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("------------------serveResource called--------------------");
		DutyAssignment dutyAssignment = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		long dutyAssignmentId = Long.parseLong(httpRequest.getParameter("id"));
		LOGGER.info("dutyAssignmentId ======> " + dutyAssignmentId);
		try {
			dutyAssignment = DutyAssignmentLocalServiceUtil.getDutyAssignment(dutyAssignmentId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		DutyTypes dutyTypes = null;
		try {
			dutyTypes = DutyTypesLocalServiceUtil.getDutyTypes(dutyAssignment.getDutyTypeId());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("dutyTypes =====> " + dutyTypes);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		responseObj.put("dutyAssignmentId", dutyAssignment.getDutyAssignmentId());
		responseObj.put("assignment", dutyAssignment.getAssignment());
		responseObj.put("dutyTypeId", dutyTypes.getDutyTypeId());
		responseObj.put("colorCode", dutyAssignment.getColorCode());
		LOGGER.info("jsonArray =====> " + jsonArray);

		try {
			JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, responseObj);
		} catch (IOException e) {
			e.getMessage();
		}
		return true;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(EditDutyAssignmentMVCResourceCommand.class);

}

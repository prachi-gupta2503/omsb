package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.service.DutyTypesLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name=" + MVCCommandNames.VIEW_DUTY_TYPES }, service = MVCResourceCommand.class)
public class ViewDutyTypesListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		LOGGER.info("serveResource called---");
		List<DutyTypes> dutyTypesList = dutyTypesLocalService.getDutyTypesList();
		LOGGER.info("dutyTypeList---->" + dutyTypesList);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (DutyTypes dutyTypes : dutyTypesList) {
			if(dutyTypes.getStatus().equalsIgnoreCase("Active")) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put("dutyType", dutyTypes.getDutyType());
			jsonObj.put("dutyTypeId", dutyTypes.getDutyTypeId());
			User user = null;
			try {
				user = userLocalService.getUser(dutyTypes.getCreatedBy());
				String userName = user.getScreenName();
				jsonObj.put("addedBy", userName);
				jsonArray.put(jsonObj);
				JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonArray);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			catch (IOException e) { 
				e.printStackTrace();
			}
		}
		
		}
		return false;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(ViewDutyTypesListMVCResourceCommand.class);

	@Reference
	private DutyTypesLocalService dutyTypesLocalService;

	@Reference
	private UserLocalService userLocalService;

}

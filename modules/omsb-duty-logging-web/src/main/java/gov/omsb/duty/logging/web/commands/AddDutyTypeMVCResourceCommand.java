package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.duty.logging.web.util.DutyLoggingService;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.service.DutyTypesLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name=" + MVCCommandNames.ADD_DUTY_TYPES }, service = MVCResourceCommand.class)
public class AddDutyTypeMVCResourceCommand implements MVCResourceCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(AddDutyTypeMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("add duty type");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		String dutyType = ParamUtil.getString(resourceRequest, "dutyType");
		long dutyTypeId = ParamUtil.getLong(resourceRequest, "dutyTypeId");
		LOGGER.info("dutyTypeid-->" + dutyTypeId);
		try {
			if (dutyTypeId > 0) {
				dutyLoggingService.updateDutyTypes(dutyTypeId,userId,dutyType); // used for update
			} else {
				dutyLoggingService.addDutyTypes(dutyType,groupId,userId); // used for add new dutyType
			}
		} catch (PortalException e) {
			LOGGER.info("Error in Add/update Duty Type"+e.getMessage());
		}
		return true;
	}

	@Reference
	private DutyLoggingService dutyLoggingService;
	@Reference
	private DutyTypesLocalService dutyTypesLocalService;

}
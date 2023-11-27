package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTNotificationUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.CANCEL_REGISTRATION, }, service = MVCResourceCommand.class)

public class OCTRegistrationCancellationMCVResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		logger.info("OCTRegistrationCancellationMCVResourceCommand" );
		long oCExamScheduleId = ParamUtil.getLong(resourceRequest, "oCExamScheduleId");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long userId = themeDisplay.getUserId();
		OCTRegistrationItem octRegistrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
				userId, oCExamScheduleId);
		if(Validator.isNotNull(octRegistrationItem) && Validator.isNotNull(octRegistrationItem.getItems()) && !octRegistrationItem.getItems().isEmpty()) {
			OCTRegistration octRegistration = octRegistrationItem.getItems().get(0);
			omsbCommonApi.deleteObjectEntryEntryId(octRegistration.getId());
			return true;
		}
		return false;
	}

	
	@Reference
	private OCTExamUtil octExamUtil;

	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTNotificationUtil octNotificationUtil;
	
	private Log logger = LogFactoryUtil.getLog(OCTRegistrationCancellationMCVResourceCommand.class);


}

package gov.omsb.exam.web.portlet.portlet.resource;

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
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.CANCEL_EXAM_REGISTRATION }, service = MVCResourceCommand.class)

public class CancelRegistrationMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		logger.info("OCTRegistrationCancellationMCVResourceCommand" );
		long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long userId = themeDisplay.getUserId();
		RegistrationItem registrationItem = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(),
				userId, examScheduleId);
		
		boolean hasUserRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), userId, RoleNameConstants.TRAINEE);
		if(hasUserRole) {
			
			if(Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems()) && !registrationItem.getItems().isEmpty()) {
				Registration octRegistration = registrationItem.getItems().get(0);
				omsbCommonApi.deleteObjectEntryEntryId(octRegistration.getId());
				return true;
			}
		}
		return false;
	}

	
	@Reference
	private ExamUtil examUtil;

	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

		
	private Log logger = LogFactoryUtil.getLog(CancelRegistrationMVCResourceCommand.class);


}

package gov.omsb.registration.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.Person;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.util.RegistrationUtil;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name=" + MVCCommands.SAVE_REGISTRATION_PERSONAL_DETAILS }, service = MVCActionCommand.class)
public class SavePersonalDetailsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("SaveRegistrationPersonalDetailsMVCActionCommand Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Registration registration = registrationUtil.getRegistrationDTO(actionRequest, themeDisplay);	
		
		if(Validator.isNull(registration.getPersonId())){
			 LOGGER.info("new Person flag if condtion :: "+registration.getDateOfBirth());
		    // registration.setDateOfBirth(ParamUtil.getString(actionRequest, "dateOfBirth").trim());
			 Person newPerson = registrationUtil.setPersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), registration.getCivilId(), registration.getPassportNo(), ParamUtil.getString(actionRequest, "dateOfBirth").trim());
		   LOGGER.info("new Person Id :: "+newPerson.getId());
		   registration.setPersonId(newPerson.getId());
		}
		
		if(registration.getPersonId() > 0) {
			registration=registrationUtil.saveRegistration(actionRequest, registration);
			//actionResponse.getRenderParameters().setValue("personId", String.valueOf(registration.getPersonId()));
		}
		actionRequest.setAttribute("personId",registration.getPersonId());
		//actionResponse.getRenderParameters().setValue("personId", MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS);
	//	actionResponse.getRenderParameters().setValue("personId", String.valueOf(registration.getPersonId()));	
		actionResponse.getRenderParameters().setValue("lrUserId", String.valueOf(registration.getLrUserId()));
		actionResponse.getRenderParameters().setValue("civilId", String.valueOf(registration.getCivilId()));
		actionResponse.getRenderParameters().setValue("passportNumber", String.valueOf(registration.getPassportNo()));
		actionResponse.getRenderParameters().setValue("dateOfBirth", String.valueOf(registration.getDateOfBirth()));
	//	actionResponse.getRenderParameters().setValue("isMyProfile", ParamUtil.getString(actionRequest, "isMyProfile"));
		
		boolean isNext = ParamUtil.getBoolean(actionRequest, "isNext");
		
		if(isNext) {
		  	actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_EDUCATION_DETAILS);
		} else {
		  	actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS);
		}
		 SessionMessages.add(actionRequest,"success-personal-detail");
		//SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		//SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(SavePersonalDetailsMVCActionCommand.class);
}
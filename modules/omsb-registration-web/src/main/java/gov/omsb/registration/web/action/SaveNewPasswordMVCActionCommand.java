package gov.omsb.registration.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.util.RegistrationUtil;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name=" + MVCCommands.SAVE_REGISTRATION_NEW_PASSWORD }, service = MVCActionCommand.class)
public class SaveNewPasswordMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("SaveNewPasswordMVCActionCommand Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = ParamUtil.getLong(actionRequest, "userId");	
		if(Validator.isNotNull(userId)) {
			String password = ParamUtil.getString(actionRequest, "password");
			try{
				UserLocalServiceUtil.updatePassword(userId, password, password, Boolean.FALSE);
				PersonItem personItem = registrationUtil.fetchPersonByLrUserId(themeDisplay, userId);
				if(Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems()) && personItem.getItems().size()>0) {
					UserMetatdataItems userMetaDataItems = registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), userId);
					if(Validator.isNotNull(userMetaDataItems) && Validator.isNotNull(userMetaDataItems.getItems()) && userMetaDataItems.getItems().size()>0) {
						long userMetaDataId = userMetaDataItems.getItems().get(0).getId();
						
						LOGGER.info("userMetaDataItems.getItems().get(0).getLrUserId :::" +userMetaDataItems.getItems().get(0).getLrUserId());
						LOGGER.info("userMetaDataItems.getItems().get(0).getRoleId :::" +userMetaDataItems.getItems().get(0).getRoleId());
						
						boolean requserforService=isRequestforService(userMetaDataItems.getItems().get(0));
						LOGGER.info("requserforService  ::" +requserforService);
						updateRegistrationStatus(themeDisplay,userId,personItem.getItems().get(0).getId(),userMetaDataId,requserforService);
					}
				}
				//actionResponse.setRenderParameter("mvcPath", OmsbRegistrationWebPortletKeys.IDENTIFICATION_CONFIRMATION_JSP);
				//actionResponse.setRenderParameter("mvcPath", "/");
				actionResponse.sendRedirect("/login");
				
			} catch(Exception e) {
				actionRequest.setAttribute("userId", userId);
				SessionErrors.add(actionRequest, "new-password-can-not-be-same-as-current-password");
				actionResponse.setRenderParameter("mvcPath", OmsbRegistrationWebPortletKeys.REGISTRATION_NEW_PASSWORD_JSP);
			}
		}
		
		SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	private void updateRegistrationStatus(ThemeDisplay themeDisplay,long lrUserId,long personId,long userMetaDataId,boolean requserforService) {
		UserRegistrationStatus userRegistrationStatus=new UserRegistrationStatus();
		userRegistrationStatus.setLrUserId(Validator.isNotNull(lrUserId)?lrUserId:0);
		userRegistrationStatus.setUserStatus(CommonConstants.PENDING);
		userRegistrationStatus.setPersonId(personId);
		userRegistrationStatus.setUserMetaDataId(userMetaDataId);
		registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_PROFILE_STATUS, userRegistrationStatus);
		if(!requserforService) {
			LOGGER.info("inside adding user role status::::");
			registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_ROLE_STATUS, userRegistrationStatus);	
		}
		
		
	}
	
	public boolean isRequestforService(UserMetadata userMetadata) {
		boolean isRequestforService=true;
		if(Validator.isNotNull(userMetadata.getRoleId()) && userMetadata.getRoleId()>0) {
			isRequestforService=false;
		}
		return isRequestforService;
	}
	
	

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(SaveNewPasswordMVCActionCommand.class);
}
package gov.omsb.registration.web.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.dto.UserRegistrationStatusItems;
import gov.omsb.registration.web.util.RegistrationUtil;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name=" + MVCCommands.SAVE_REGISTRATION_DETAILS }, service = MVCActionCommand.class)
public class SaveRegistrationDetailsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("SaveRegistrationDetailsMVCActionCommand Invoked");
		EmploymentDetail employmentDetail=null;
		long personId = ParamUtil.getLong(actionRequest, "personId");
		long lrUserId = ParamUtil.getLong(actionRequest, "lrUserId");
	//	long employed = ParamUtil.getLong(actionRequest, "employed");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		long groupId = group.getGroupId();
		Registration registration = registrationUtil.getRegistrationDTO(actionRequest, themeDisplay);
		if(registration.getPersonId() > 0) {
			registrationUtil.saveRegistration(actionRequest, registration);
		}
		EducationDetailItem educationDetailItems = registrationUtil.fetchEducationDetailByLrUserId(themeDisplay, registration.getLrUserId());
		for(EducationDetail educationDetail : educationDetailItems.getItems()) {
			educationDetail.setPersonId(registration.getPersonId());
			updateEduDetail(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.PUT_EDUCATION_DETAIL_URL, educationDetail);
		}
		EmploymentDetailItem employmentDetailItem = registrationUtil.getWorkDetailsByLrUserIdAndWorkDetailType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), registration.getLrUserId(),"0");
		for(EmploymentDetail ed : employmentDetailItem.getItems()) {
			ed.setPersonId(registration.getPersonId());
			updateEmploymentDetail(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_EMPLOYMENT_DETAIL_URL, ed);
		}
//		UserMetadataItem userMetaItems = registrationUtil.fetchUserMetaDataByLrUserId(themeDisplay, registration.getLrUserId());
//		for(UserMetadata userMetaData : userMetaItems.getItems()) {
//			updateUserMeta(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), "o/c/usermetadatas/", userMetaData);
//			

		
		registrationUtil.saveEmploymentDetail(actionRequest, employmentDetail, uploadPortletRequest, groupId,
				themeDisplay, registration.getPersonId(), lrUserId, 1);
		
		try {
			UserRegistrationStatus userRegistrationProfileStatus=new UserRegistrationStatus();
			userRegistrationProfileStatus.setLrUserId(Validator.isNotNull(lrUserId)?lrUserId:0);
			userRegistrationProfileStatus.setUserStatus(CommonConstants.PENDING);
			userRegistrationProfileStatus.setPersonId(Validator.isNotNull(registration.getPersonId())?registration.getPersonId():0);	
			UserMetatdataItems userMetadataItems = registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(), groupId, lrUserId);
			
			for(gov.omsb.registration.web.dto.UserMetadata userMetadata : userMetadataItems.getItems()) {
				UserRegistrationStatusItems userRegistrationStatusItems=null;
				try {
					userRegistrationStatusItems=registrationUtil.getRoleStatusByUserMetadataId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userMetadata.getId());
				} catch (Exception e) {
					LOGGER.error("Error ::"+e.getMessage());
				}
				if(Validator.isNotNull(userRegistrationStatusItems) && Validator.isNotNull(userRegistrationStatusItems.getItems()) && userRegistrationStatusItems.getItems().size()>0) {
						LOGGER.info("inside if not null :::userRegistrationStatusItems ::");
				}else {
					LOGGER.info("inside else null :::userRegistrationStatusItems ::");
					if(Validator.isNotNull(userMetadata) && userMetadata.getRoleId()>0) {
						UserRegistrationStatus userRegistrationRoleStatus=new UserRegistrationStatus();
						userRegistrationRoleStatus.setLrUserId(Validator.isNotNull(lrUserId)?lrUserId:0);
						userRegistrationRoleStatus.setUserStatus(CommonConstants.PENDING);
						userRegistrationRoleStatus.setPersonId(Validator.isNotNull(registration.getPersonId())?registration.getPersonId():0);
						userRegistrationRoleStatus.setUserMetaDataId(Validator.isNotNull(userMetadata)?userMetadata.getId():0);
						registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_ROLE_STATUS, userRegistrationRoleStatus);	
					}
				}
			}
			registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_PROFILE_STATUS, userRegistrationProfileStatus);
			sendNotificationToApprover(themeDisplay);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}		
				
		if(themeDisplay.getLayout().getName(themeDisplay.getLocale()).equalsIgnoreCase(OmsbRegistrationWebPortletKeys.MY_PROFILE_PAGE_NAME)) {
			actionResponse.sendRedirect("/group/guest/my-profile");
		}
		
		
		
	}

	private void sendNotificationToApprover(ThemeDisplay themeDisplay) throws PortalException {
		Role profileRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN);
		long[] profileRoleUserIds = UserLocalServiceUtil.getRoleUserIds(profileRole.getRoleId());
		for (int i=0; i<=profileRoleUserIds.length;i++) {
			commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), profileRoleUserIds[0], OmsbRegistrationWebPortletKeys.REGISTRATION_PROFILE_APPROVER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
		}
		
		Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN);
		long[] roleUserIds = UserLocalServiceUtil.getRoleUserIds(role.getRoleId());
		for (int i=0; i<=roleUserIds.length;i++) {
			commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), roleUserIds[0], OmsbRegistrationWebPortletKeys.OMSB_REGISTRATION_EMAIL_NOTIFICATION, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
		}
	}

	private void updateUserProfileStatus(long personId, ThemeDisplay themeDisplay) {
		UserRegistrationStatusItems userRegistrationStatusItems=registrationUtil.getRegistrationStatusByPersonId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personId);
		if(Validator.isNotNull(userRegistrationStatusItems) && Validator.isNotNull(userRegistrationStatusItems.getItems()) && userRegistrationStatusItems.getItems().size()>0) {
			UserRegistrationStatus userRegistrationProfileStatus=userRegistrationStatusItems.getItems().get(0);
			if(Validator.isNotNull(userRegistrationProfileStatus)) {
				if(userRegistrationProfileStatus.getUserStatus().equalsIgnoreCase(OmsbRegistrationWebPortletKeys.REJECTED_WF_STATUS)) {
					userRegistrationProfileStatus.setUserStatus(CommonConstants.PENDING);
					try {
						registrationUtil.updateRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_PROFILE_STATUS, userRegistrationProfileStatus);
						sendNotificationToApprover(themeDisplay);
					} catch (PortalException e) {
						LOGGER.error(e.getMessage());
					}
				}
			}
		}
	}
	public EducationDetail updateEduDetail(String portalURL, long groupId, String objectURL, EducationDetail educationDetail) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		if (Validator.isNotNull(educationDetail) && educationDetail.getId() > 0) {
			String educationDetailDataMapper = CustomObjectMapperUtil.writeValueAsString(educationDetail, null);
			String response = httpConnector.executePut(portalURL + objectURL + educationDetail.getId(), educationDetailDataMapper, headers);
			return CustomObjectMapperUtil.readValue(response, EducationDetail.class);
		}
		return null;
	}
	public EmploymentDetail updateEmploymentDetail(String portalURL, long groupId, String objectURL, EmploymentDetail employmentDetail) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		if (Validator.isNotNull(employmentDetail) && employmentDetail.getId() > 0) {
			String employmentDetailDataMapper = CustomObjectMapperUtil.writeValueAsString(employmentDetail, null);
			String response = httpConnector.executePut(portalURL + objectURL + employmentDetail.getId(), employmentDetailDataMapper, headers);
			return CustomObjectMapperUtil.readValue(response, EmploymentDetail.class);
		}
		return null;
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector httpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(SaveRegistrationDetailsMVCActionCommand.class);
}
package gov.omsb.registration.web.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.dto.UserRegistrationStatusItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SAVE_REGISTRATION_ROLE_SERVICE_SR
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class SaveRoleServiceMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(SaveRoleServiceMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			_log.info("Entry into SaveRoleServiceMVCResourceCommand ::");
			
			boolean associated=ParamUtil.getBoolean(resourceRequest, "associated");
			boolean registringForRole=ParamUtil.getBoolean(resourceRequest, "registering");
			boolean requestForService = ParamUtil.getBoolean(resourceRequest, "requestForService");
			String index=ParamUtil.getString(resourceRequest, "index");
			
			String roleId=	ParamUtil.getString(resourceRequest, "role_"+index);
			String departmentId=ParamUtil.getString(resourceRequest, "department_"+index);
			String sectionId=ParamUtil.getString(resourceRequest, "section_"+index);
			String commiteeId=ParamUtil.getString(resourceRequest, "committe_"+index);
			String functionId=ParamUtil.getString(resourceRequest, "function_"+index);
			String programtypeId=ParamUtil.getString(resourceRequest, "programtype_"+index);
			long programId=ParamUtil.getLong(resourceRequest, "program_"+index);
			String programPositionId = ParamUtil.getString(resourceRequest, "programPosition_"+index);
			String purposeId = ParamUtil.getString(resourceRequest, "purpose_"+index);
			
			String omsbServiceId=ParamUtil.getString(resourceRequest, "service");
			long lrUserId=ParamUtil.getLong(resourceRequest, "lrUserId");
			boolean roleVerifiedStatisId=false;
			boolean profileVerifiedStatisId=false;
			long id = ParamUtil.getLong(resourceRequest, "id");
			
			String roleOther = ParamUtil.getString(resourceRequest, "roleOther_"+index);
			String departmentOther=ParamUtil.getString(resourceRequest, "departmentOther_"+index);
			String sectionOther=ParamUtil.getString(resourceRequest, "sectionOther_"+index);
			String functionOther=ParamUtil.getString(resourceRequest, "functionOther_"+index);
			//String programtypeOther=ParamUtil.getString(resourceRequest, "programtypeOther_"+index);
			String programOther=ParamUtil.getString(resourceRequest, "programOther_"+index);
			String programPositionOther = ParamUtil.getString(resourceRequest, "programPositionOther_"+index);
			String purposeOther = ParamUtil.getString(resourceRequest, "purposeOther_"+index);
			
			String commiteeOther=ParamUtil.getString(resourceRequest, "commiteeOther_1");
			String omsbServiceOther=ParamUtil.getString(resourceRequest, "serviceOther");
			boolean isProfileApprover=false;
			boolean isRoleApprover=false;
			boolean isServiceApprover=false;
			try {
				 isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
			} catch (PortalException e1) {
				_log.error("Exception ::" +e1.getMessage());
			}
			try {
				 isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
			} catch (PortalException e2) {
				_log.error("Exception ::" +e2.getMessage());
			}
			try {
				 isServiceApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN, Boolean.FALSE);
			} catch (PortalException e1) {
				_log.error("Exception ::" +e1.getMessage());
			}
			
			boolean isAdmin = registrationUtil.getAdmin(themeDisplay.getCompanyId()).getUserId()==themeDisplay.getUserId()?true :false;
			boolean isRequestedByAdmin=false;
			
			if(themeDisplay.isSignedIn() && (isAdmin || isServiceApprover ||isRoleApprover || isProfileApprover)) {
				isRequestedByAdmin=true;
			}
			
			_log.info("isRequestedByAdmin:::::::"+isRequestedByAdmin);
		
			
			Person person=null;
			PersonItem personItem=null;
			if (Validator.isNotNull(id) && id > 0) {
				UserMetadata userMetadata = registrationUtil.getUserMetadataById(themeDisplay.getPortalURL(),id); 
				// null check

				if (Validator.isNotNull(userMetadata)) {
					registrationUtil.deleteUserMetaData(themeDisplay, userMetadata.getId());
				}
				
				//Delete Role Status
				UserRegistrationStatusItems userRegistrationStatusItems=registrationUtil.getRoleStatusByUserMetaDataId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userMetadata.getId());
				
				_log.info("userRegistrationStatus :::::>>>>>>>>>>>>>>>>>.."+userRegistrationStatusItems.getItems().size());
				_log.info("userRegistrationStatus :::::>>>>>>>>>>>>>>>>>.."+userRegistrationStatusItems.getItems().get(0));
				
				try {
					if(Validator.isNotNull(userRegistrationStatusItems) && Validator.isNotNull(userRegistrationStatusItems.getItems()) && userRegistrationStatusItems.getItems().size()>0) {
						UserRegistrationStatus userRegistrationStatus=	userRegistrationStatusItems.getItems().get(0);
						if(Validator.isNotNull(userRegistrationStatus)) {
							_log.info("inside delete role statuss :::");
							registrationUtil.deleteRoleStatus(themeDisplay, userRegistrationStatus.getId());
						}
					}
				} catch (Exception e) {
					_log.error("Exception in code :::" +e.getMessage());
				}
				
			}
			
			try {
				 personItem=registrationUtil.fetchPersonByLrUserId(themeDisplay, lrUserId);
			} catch (UnsupportedEncodingException e) {
				_log.error(e.getMessage());
			}
			
			if(Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems())  && personItem.getItems().size()>0) {
				person=personItem.getItems().get(0);
			}
			
			//For Role
			_log.info("inside Role  add :::");
			_log.info("requestForService ::::"+requestForService);
				
			UserMetadata userMetadata=null;
			if (requestForService) {
				_log.info("inside requestForService:::");
					userMetadata=registrationUtil.saveUserMetadata(themeDisplay, null, null, null, null, null, 0, null, null, null, null, roleVerifiedStatisId,
							profileVerifiedStatisId, omsbServiceId, registringForRole, associated, lrUserId,
							isRequestedByAdmin,roleOther,departmentOther,sectionOther,functionOther,programOther,commiteeOther,omsbServiceOther);
			} else {
					userMetadata=registrationUtil.saveUserMetadata(themeDisplay, roleId, departmentId, sectionId, commiteeId, functionId,
						programId, programPositionId, programPositionOther, purposeId, purposeOther, roleVerifiedStatisId, profileVerifiedStatisId, omsbServiceId, registringForRole,
						associated, lrUserId,isRequestedByAdmin,roleOther,departmentOther,sectionOther,functionOther,programOther,commiteeOther,omsbServiceOther);
			}
				
				//Save User Profile and Role Status
//				UserRegistrationStatus userRegistrationRoleStatus=new UserRegistrationStatus();
//				userRegistrationRoleStatus.setLrUserId(Validator.isNotNull(lrUserId)?lrUserId:0);
//				userRegistrationRoleStatus.setUserStatus(CommonConstants.PENDING);
//				userRegistrationRoleStatus.setPersonId(Validator.isNotNull(person)?person.getId():0);
//				userRegistrationRoleStatus.setUserMetaDataId(Validator.isNotNull(userMetadata)?userMetadata.getId():0);
//				_log.info("userRegistrationRoleStatus getUserMetaDataId :::::"+userRegistrationRoleStatus.getUserMetaDataId());
//				
//				try {
//					//registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_PROFILE_STATUS, userRegistrationProfileStatus);
//					registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_ROLE_STATUS, userRegistrationRoleStatus);
//					
//					Role profileRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN);
//					long[] profileRoleUserIds = UserLocalServiceUtil.getRoleUserIds(profileRole.getRoleId());
//					for (int i=0; i<=profileRoleUserIds.length;i++) {
//						commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), profileRoleUserIds[0], OmsbRegistrationWebPortletKeys.REGISTRATION_PROFILE_APPROVER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
//					}
//					
//					Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN);
//					long[] roleUserIds = UserLocalServiceUtil.getRoleUserIds(role.getRoleId());
//					for (int i=0; i<=roleUserIds.length;i++) {
//						commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), roleUserIds[0], OmsbRegistrationWebPortletKeys.REGISTRATION_SERVICE_APPROVER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
//					}
//				} catch (Exception e) {
//					_log.error(e.getMessage());
//				}
				
				JSONObject obj = JSONFactoryUtil.createJSONObject();
			
			if (Validator.isNotNull(userMetadata) && userMetadata.getId() > 0) {
				obj.put("isValid", true);
			} else {
				obj.put("isValid", false);
			}
			 		
			registrationUtil.setRoleService(resourceRequest, resourceResponse);
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error, "+e.getMessage());
			return Boolean.TRUE;
		}
	}
	
	
	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
}

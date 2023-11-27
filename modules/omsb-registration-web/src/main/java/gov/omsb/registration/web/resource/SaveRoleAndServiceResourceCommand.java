package gov.omsb.registration.web.resource;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.internet.InternetAddress;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.registration.web.action.SaveRoleServiceMVCActionCommand;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.RoleMappingItems;
import gov.omsb.registration.web.dto.Services;
import gov.omsb.registration.web.dto.ServicesItem;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.dto.UserRegistrationStatusItems;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;


@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SAVE_REGISTRATION_ROLE_AND_SERVICE
	    }, 
	    service = MVCResourceCommand.class	    
)
public class SaveRoleAndServiceResourceCommand implements MVCResourceCommand {

	public static final Log _log=LogFactoryUtil.getLog(SaveRoleServiceMVCActionCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		_log.info("Entry into SaveRoleAndServiceResourceCommand ::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean associated = ParamUtil.getBoolean(resourceRequest, "associated");
		boolean registringForRole = ParamUtil.getBoolean(resourceRequest, "registering");
		boolean requestForService = ParamUtil.getBoolean(resourceRequest, "requestForService");
		String index = ParamUtil.getString(resourceRequest, "index");
		
		String roleId =	ParamUtil.getString(resourceRequest, "role_"+index);
		String departmentId = ParamUtil.getString(resourceRequest, "department_"+index);
		String sectionId = ParamUtil.getString(resourceRequest, "section_"+index);
		String functionId = ParamUtil.getString(resourceRequest, "function_"+index);
		String programtypeId = ParamUtil.getString(resourceRequest, "programtype_"+index);
		long programId = ParamUtil.getLong(resourceRequest, "program_"+index);
		String programPositionId = ParamUtil.getString(resourceRequest, "programPosition_"+index);
		String purposeId = ParamUtil.getString(resourceRequest, "purpose_"+index);
		
		String roleOther = ParamUtil.getString(resourceRequest, "roleOther_"+index);
		String departmentOther = ParamUtil.getString(resourceRequest, "departmentOther_"+index);
		String sectionOther = ParamUtil.getString(resourceRequest, "sectionOther_"+index);
		String functionOther = ParamUtil.getString(resourceRequest, "functionOther_"+index);
		//String programtypeOther = ParamUtil.getString(resourceRequest, "programtypeOther_"+index);
		String programOther = ParamUtil.getString(resourceRequest, "programOther_"+index);
		String programPositionOther = ParamUtil.getString(resourceRequest, "programPositionOther_"+index);
		String purposeOther = ParamUtil.getString(resourceRequest, "purposeOther_"+index);
		
		String commiteeId = ParamUtil.getString(resourceRequest, "committe_"+index);
		String omsbServiceId = ParamUtil.getString(resourceRequest, "service");
		String commiteeOther = ParamUtil.getString(resourceRequest, "commiteeOther");
		String omsbServiceOther = ParamUtil.getString(resourceRequest, "serviceOther");
		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		boolean roleVerifiedStatisId=false;
		boolean profileVerifiedStatisId=false;
		//boolean registringForRole=true;
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
		
		_log.info("lrUserId ::"+lrUserId);
		Person person=null;
		PersonItem personItem=null;
		
		if (Validator.isNotNull(lrUserId) && lrUserId > 0) {
			UserMetatdataItems userMetadataItem = registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(),
					themeDisplay.getScopeGroupId(), lrUserId); // null check
			if (Validator.isNotNull(userMetadataItem.getItems()) && userMetadataItem.getItems().size() > 0) {
				UserMetadata userMetadata = userMetadataItem.getItems().get(0);				
				long userMetadataId=userMetadata.getId();
				registrationUtil.deleteUserMetaData(themeDisplay, userMetadata.getId());
				//Delete Role Status
				UserRegistrationStatusItems userRegistrationStatusItems = registrationUtil.getRoleStatusByUserMetaDataId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userMetadataId);
				_log.info("userRegistrationStatus :::::>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.."+userRegistrationStatusItems.getItems().size());
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
			_log.info("Deleted::::User info");
			try {
				 personItem=registrationUtil.fetchPersonByLrUserId(themeDisplay, lrUserId);
			} catch (UnsupportedEncodingException e) {
				_log.error(e.getMessage());
			}
		}
		
		if(Validator.isNotNull(personItem) &&  Validator.isNotNull(personItem.getItems())  && personItem.getItems().size()>0) {
			person=personItem.getItems().get(0);
		}
		
		//Changes
		UserMetadata userMetadata=null;
		if (requestForService) {
			userMetadata=registrationUtil.saveUserMetadata(themeDisplay, null, null, null, null, null, 0, null, null, null, null, roleVerifiedStatisId,
					profileVerifiedStatisId, omsbServiceId, registringForRole, associated, lrUserId,
					isRequestedByAdmin,roleOther,departmentOther,sectionOther,functionOther,programOther,commiteeOther,omsbServiceOther);
		} else {
			_log.info("inside save role service for role::::");
			try {
				userMetadata = registrationUtil.saveUserMetadata(themeDisplay, roleId, departmentId, sectionId, commiteeId, functionId,
						programId, programPositionId, programPositionOther, purposeId, purposeOther, roleVerifiedStatisId, profileVerifiedStatisId, omsbServiceId, registringForRole,
						associated, lrUserId,isRequestedByAdmin,roleOther,departmentOther,sectionOther,functionOther,programOther,commiteeOther,omsbServiceOther);
				
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			_log.info("userMetadata :::" +Validator.isNotNull(userMetadata));
		}
		resourceRequest.setAttribute("userMetadata", userMetadata);
		
		if (!requestForService) {
			//Update User status
			PersonalDetailItem personDetailItem=registrationUtil.fetchPersonalDetailsByPersonId(person.getId(), themeDisplay);
			if(Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size()>0) {
				try {
					PersonalDetail personalDetail=personDetailItem.getItems().get(0);
					
					if(registringForRole) {
						personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.ROLE_TYPE_2);
						registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);	
					}else {
						personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.ROLE_TYPE_1);
						registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);
					}
				} catch (Exception e) {
					_log.error(e.getMessage());
				}
			}
		}
		
		RoleMappingItems roleMappingItems=registrationUtil.fetchRoleMapping(themeDisplay, RoleNameConstants.ROLE_TYPE_REGISTRATION);
		List<ListTypeEntry> departmentList = registrationUtil.getPickListEntries(LRPicklistConstants.DEPARTMENT, themeDisplay.getCompanyId());
		List<ListTypeEntry> sectionList = registrationUtil.getPickListEntries(LRPicklistConstants.SECTION, themeDisplay.getCompanyId());
		List<ListTypeEntry> functionList = registrationUtil.getPickListEntries(LRPicklistConstants.FUNCTION, themeDisplay.getCompanyId());
		List<ListTypeEntry> committeList = registrationUtil.getPickListEntries(LRPicklistConstants.COMMITTEE, themeDisplay.getCompanyId());
	//	List<ListTypeEntry> serviceList = registrationUtil.getPickListEntries(LRPicklistConstants.SERVICE, themeDisplay.getCompanyId());
		ServicesItem services = registrationUtil.getServices(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId());
		_log.info("services :: "+services);
		List<Services> serviceList=new ArrayList<Services>();
		if(Validator.isNotNull(services) && Validator.isNotNull(services.getItems())) {
		
			for(Services service:services.getItems()) {
				try {
					service.setServiceId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SERVICE, service.getServiceId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					serviceList.add(service);
					_log.info(service);
				} catch(Exception e) {
					_log.error("unable to get the list type with key : "+service.getServiceId()+"  ::: "+e.getMessage());
				}
			}
		}
		
		//_log.info("services :: "+services.getItems().get(0).getServiceId());
		List<ListTypeEntry> programPositionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROGRAM_POSITION, themeDisplay.getCompanyId());
		List<ListTypeEntry> purposeList = registrationUtil.getPickListEntries(LRPicklistConstants.PURPOSE, themeDisplay.getCompanyId());
		
		_log.info("functionList :::::"+functionList.size());
		List<ProgramTypeMaster> programTypeMasterList=registrationUtil.getProgramType(themeDisplay);
		
		_log.info("programTypeMasterList :::::"+programTypeMasterList);
		List<ProgramMaster> programList=registrationUtil.getProgram(themeDisplay);
		
		_log.info("programList :::::"+programList);
		_log.info("roleMappingItems :::::"+roleMappingItems);
		if(Validator.isNotNull(roleMappingItems)) {
			List<Role> omsbRoleList= registrationUtil.getOMSBRoles(roleMappingItems);
			resourceRequest.setAttribute("omsbRoleList", omsbRoleList);
		}
		
		resourceRequest.setAttribute("sectionList", sectionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("departmentList", departmentList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("functionList", functionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("programTypeMasterList", programTypeMasterList.stream().sorted((o1, o2)->o1.getProgramTypeName(themeDisplay.getLocale()).
                compareTo(o2.getProgramTypeName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("programList", programList.stream().sorted((o1, o2)->o1.getProgramName(themeDisplay.getLocale()).
                compareTo(o2.getProgramName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("programPositionList", programPositionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("purposeList", purposeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("committeList", committeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		//resourceRequest.setAttribute("serviceList", serviceList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("serviceList",serviceList);
		resourceRequest.setAttribute("lrUserId", lrUserId);
		resourceRequest.setAttribute("personId", person.getId());
		
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_ROLE_SERVICE_JSP);
		_log.info(dispatcher);
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			_log.error(e.getMessage());
		}
		SessionMessages.add(resourceRequest,"success-role-service");
		return false;
	}
	
	public void sendEmailNotification(String senderEmail, String recieverEmail, String subject, String body) {
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(new InternetAddress(senderEmail));
			mailMessage.setTo(new InternetAddress(recieverEmail));
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	

	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	
	@Reference
	private UserLocalService userLocalService;


}

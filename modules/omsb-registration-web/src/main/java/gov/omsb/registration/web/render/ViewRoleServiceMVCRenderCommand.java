package gov.omsb.registration.web.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.RoleMappingItems;
import gov.omsb.registration.web.dto.Services;
import gov.omsb.registration.web.dto.ServicesItem;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

@Component(immediate = true, 
			property = { 
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+ MVCCommands.VIEW_REGISTRATION_ROLE_SERVICE},
			service = MVCRenderCommand.class)
public class ViewRoleServiceMVCRenderCommand implements MVCRenderCommand {
	
	public static final Log _log=LogFactoryUtil.getLog(ViewRoleServiceMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long lrUserId=ParamUtil.getLong(renderRequest, "lrUserId");
		long personId=ParamUtil.getLong(renderRequest, "personId");
		if(Validator.isNotNull(lrUserId) && lrUserId > 0) {
			UserMetatdataItems  userMetadataItem =registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), lrUserId);
			if(Validator.isNotNull(userMetadataItem) && userMetadataItem.getItems().size()>0) {
				UserMetadata userMetadata=userMetadataItem.getItems().get(0);
				try {
					userMetadata.setRoleName(RoleLocalServiceUtil.getRole(userMetadata.getRoleId()).getName());
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
			
				long programTypeId=0;	
				_log.info("userMetadata.getProgramId() :::::"+userMetadata.getProgramId());
				if(Validator.isNotNull(userMetadata.getProgramId())) {
				try {
					 ProgramMaster programMaster=ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId());
					 programTypeId= ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId()).getProgramTypeId();
					 userMetadata.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),"ProgramName",
								themeDisplay.getLocale().toString())      );
				} catch (Exception e) {
					_log.error(e.getMessage());
				}
				userMetadata.setProgramTypeId(programTypeId);
				if(programTypeId>0) {
					try {
						_log.info("ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName() :::"+ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName());
						userMetadata.setProgramTypeName(CommonUtil.getValueByLanguage(ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName(), OmsbRegistrationWebPortletKeys.PROGRAM_TYPE_NAME,
								themeDisplay.getLocale().toString()));
					} catch (PortalException e) {
						_log.error(e.getMessage());
					}
				}
				}
				renderRequest.setAttribute("userMetadata", userMetadata);
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
			renderRequest.setAttribute("omsbRoleList", omsbRoleList);
		}
		_log.info("Role Mapping size :::" +roleMappingItems.getItems().size());
		_log.info("Role Mapping  :::" +roleMappingItems.getItems().get(0).getRoleType());
		renderRequest.setAttribute("sectionList", sectionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("departmentList", departmentList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("functionList", functionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("programTypeMasterList", programTypeMasterList.stream().sorted((o1, o2)->o1.getProgramTypeName(themeDisplay.getLocale()).
                compareTo(o2.getProgramTypeName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("programList", programList.stream().sorted((o1, o2)->o1.getProgramName(themeDisplay.getLocale()).
                compareTo(o2.getProgramName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("programPositionList", programPositionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("purposeList", purposeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("committeList", committeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		//renderRequest.setAttribute("serviceList", serviceList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("serviceList",serviceList);
		renderRequest.setAttribute("lrUserId", lrUserId);
		renderRequest.setAttribute("personId", personId);
		return OmsbRegistrationWebPortletKeys.REGISTRATION_ROLE_SERVICE_JSP;
	}	

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
}
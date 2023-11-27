package gov.omsb.registration.web.resource;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.FunctionSectionCommittee;
import gov.omsb.registration.web.dto.FunctionSectionCommitteeItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.FUNCTION_SECTION_COMMITTEE_MVC_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class FunctionSectionCommitteeMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(FunctionSectionCommitteeMVCResourceCommand.class);
	
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("FunctionSectionCommitteeMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String sectionId=ParamUtil.getString(resourceRequest, "sectionId");
			FunctionSectionCommitteeItems functionSectionCommitteeItems=registrationUtil.getFunctionAndCommiteeBySectionKey(themeDisplay, sectionId);
			
			List<FunctionSectionCommittee> functionSectionCommitteeList=new ArrayList<>();
			JSONArray jsonArray= JSONFactoryUtil.createJSONArray();
			JSONArray functionArray= JSONFactoryUtil.createJSONArray();
			JSONArray committeArray= JSONFactoryUtil.createJSONArray();
			JSONObject finalObject =JSONFactoryUtil.createJSONObject();
			JSONObject committeObject =JSONFactoryUtil.createJSONObject();
			if(Validator.isNotNull(functionSectionCommitteeItems)) {
				 functionSectionCommitteeList=functionSectionCommitteeItems.getItems();
				 if(Validator.isNotNull(functionSectionCommitteeList) && functionSectionCommitteeList.size()>0){

					 for(FunctionSectionCommittee functionSectionCommittee :functionSectionCommitteeList) {
						 JSONObject object =JSONFactoryUtil.createJSONObject();
							//ListTypeEntry listTypeEntry	=registrationUtil.getPickListEntriesByMappingId(LRPicklistConstants.SECTION, themeDisplay.getCompanyId(), "coordinationAndFollowUpSection");
							ListTypeEntry functionlistTypeEntry	 =registrationUtil.getPickListEntriesByMappingId(LRPicklistConstants.FUNCTION, themeDisplay.getCompanyId(),functionSectionCommittee.getFunctionId());
							object.put("key", functionlistTypeEntry.getKey());
							object.put("name", functionlistTypeEntry.getName(themeDisplay.getLocale()));
							functionArray.put(object);
					 }
					 finalObject.put("functionObj", functionArray);
					 for(FunctionSectionCommittee functionSectionCommittee :functionSectionCommitteeList) {
						 JSONObject object =JSONFactoryUtil.createJSONObject();
							//ListTypeEntry listTypeEntry	=registrationUtil.getPickListEntriesByMappingId(LRPicklistConstants.SECTION, themeDisplay.getCompanyId(), "coordinationAndFollowUpSection");
							ListTypeEntry commiteelistTypeEntry	 =registrationUtil.getPickListEntriesByMappingId(LRPicklistConstants.COMMITTEE, themeDisplay.getCompanyId(),functionSectionCommittee.getCommitteeId());
							object.put("key", commiteelistTypeEntry.getKey());
							object.put("name", commiteelistTypeEntry.getName(themeDisplay.getLocale()));
							committeArray.put(object);
					 }
					 finalObject.put("committeObj", committeArray);
				 
			}
		}			
			_log.info("finalObject :::::::::::"+finalObject);
			
			resourceResponse.getWriter().print(finalObject.toJSONString());
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error ::, "+e.getMessage());
			return Boolean.TRUE;
		}
	
}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	
}

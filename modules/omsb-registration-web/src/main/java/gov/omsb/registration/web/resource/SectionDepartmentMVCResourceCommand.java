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
import gov.omsb.registration.web.dto.SectionDepartment;
import gov.omsb.registration.web.dto.SectionDepartmentItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SECTION_DEPARTMENT_MVC_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class SectionDepartmentMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(SectionDepartmentMVCResourceCommand.class);
	
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("SectionDepartmentMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String departmentId=ParamUtil.getString(resourceRequest, "departmentId");
			
			SectionDepartmentItems sectionDepartmentItems=registrationUtil.getSectionByDepartmentKey(themeDisplay, departmentId);
			List<SectionDepartment>  sectionDepartmentList =new ArrayList<>();
			JSONArray jsonArray= JSONFactoryUtil.createJSONArray();
			if(Validator.isNotNull(sectionDepartmentItems)) {
				sectionDepartmentList=sectionDepartmentItems.getItems();
				if(Validator.isNotNull(sectionDepartmentList) && sectionDepartmentList.size()>0) {
						for(SectionDepartment sectionDepartment:sectionDepartmentList) {
							JSONObject object =JSONFactoryUtil.createJSONObject();
							//ListTypeEntry listTypeEntry	=registrationUtil.getPickListEntriesByMappingId(LRPicklistConstants.SECTION, themeDisplay.getCompanyId(), "coordinationAndFollowUpSection");
							ListTypeEntry listTypeEntry	 =registrationUtil.getPickListEntriesByMappingId(LRPicklistConstants.SECTION, themeDisplay.getCompanyId(),sectionDepartment.getSectionId());
							_log.info("listTypeEntry :::::::::::"+listTypeEntry);
							object.put("key", listTypeEntry.getKey());
							object.put("name", listTypeEntry.getName(themeDisplay.getLocale()));
							jsonArray.put(object);
						}
				}
			}
			_log.info("departmentId :::::::::::"+departmentId);
			_log.info("jsonArray :::::::::::"+jsonArray);
			//JSONObject obj =JSONFactoryUtil.createJSONObject();
			//obj.put("departmentId", departmentId);
			resourceResponse.getWriter().print(jsonArray.toJSONString());
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error ::"+e.getMessage());
			return Boolean.TRUE;
		}
	}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	
}

package gov.omsb.registration.web.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.util.CommonUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.PROGRAM_TYPE_MVC_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class ProgramTypeMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(ProgramTypeMVCResourceCommand.class);
	
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("ProgramTypeMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long programTypeId=ParamUtil.getLong(resourceRequest, "programTypeId");
			_log.info("programTypeId ::::"+programTypeId);
			JSONArray jsonArray= JSONFactoryUtil.createJSONArray();
			
			
			List<ProgramMaster>ProgramMasterList=ProgramMasterLocalServiceUtil.findProgramByPorgramType(programTypeId);
			for(ProgramMaster programMaster :ProgramMasterList) {
				JSONObject object =JSONFactoryUtil.createJSONObject();
				programMaster.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(), "ProgramName", themeDisplay.getLocale().toString()));
				object.put("name",programMaster.getProgramName());
				object.put("id",programMaster.getProgramMasterId());
				jsonArray.put(object);
			}
			

			
			
			/*
			 * SectionDepartmentItems
			 * sectionDepartmentItems=registrationUtil.getSectionByDepartmentKey(
			 * themeDisplay, departmentId); List<SectionDepartment> sectionDepartmentList
			 * =new ArrayList<>();
			 * 
			 * if(Validator.isNotNull(sectionDepartmentItems)) {
			 * sectionDepartmentList=sectionDepartmentItems.getItems();
			 * if(Validator.isNotNull(sectionDepartmentList) &&
			 * sectionDepartmentList.size()>0) { for(SectionDepartment
			 * sectionDepartment:sectionDepartmentList) { JSONObject object
			 * =JSONFactoryUtil.createJSONObject(); //ListTypeEntry listTypeEntry
			 * =registrationUtil.getPickListEntriesByMappingId(LRPicklistConstants.SECTION,
			 * themeDisplay.getCompanyId(), "coordinationAndFollowUpSection"); ListTypeEntry
			 * listTypeEntry
			 * =registrationUtil.getPickListEntriesByMappingId(LRPicklistConstants.SECTION,
			 * themeDisplay.getCompanyId(),sectionDepartment.getSectionId());
			 * _log.info("listTypeEntry :::::::::::"+listTypeEntry); object.put("key",
			 * listTypeEntry.getKey()); object.put("name",
			 * listTypeEntry.getName(themeDisplay.getLocale())); jsonArray.put(object); } }
			 * }
			 */
			//_log.info("jsonArray :::::::::::"+jsonArray);
			//JSONObject obj =JSONFactoryUtil.createJSONObject();
			//obj.put("programTypeId", programTypeId);
			resourceResponse.getWriter().print(jsonArray.toJSONString());
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error, "+e.getMessage());
			return Boolean.TRUE;
		}
	}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	
}

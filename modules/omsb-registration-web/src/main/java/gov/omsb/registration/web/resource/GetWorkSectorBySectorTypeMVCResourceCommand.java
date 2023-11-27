package gov.omsb.registration.web.resource;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
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

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.WorkSector;
import gov.omsb.registration.web.dto.WorkSectorItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.GET_WORKSECTOR_BY_WORKSECTOR_TYPE
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class GetWorkSectorBySectorTypeMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
     try {
      _log.info("insie serave resource command:");
      ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
      _log.info(ParamUtil.getString(resourceRequest, "workSectorType"));
      String workSectorType= ParamUtil.getString(resourceRequest, "workSectorType");
      JSONArray jsonArray= JSONFactoryUtil.createJSONArray();
      
      //Get the work sector type  first 
      
      ListTypeEntry listTypeEntry =null;
      if(Validator.isNotNull(workSectorType)) {
    	  long workSectorTypeID=Long.parseLong(workSectorType);
    	   listTypeEntry	 =ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
    	  _log.info("listTypeEntry ::: " +listTypeEntry);
    	  _log.info("listTypeEntry key ::: " +listTypeEntry.getKey());
    	  _log.info("listTypeEntry  Name ::: " +listTypeEntry.getName(themeDisplay.getLocale()));
    	  
      }
      
      if(Validator.isNotNull(listTypeEntry)) {
    	  if(listTypeEntry.getKey().equalsIgnoreCase("others")) {
    		  JSONObject object =JSONFactoryUtil.createJSONObject();
				object.put("id", "other");
				object.put("value", "Other");
				jsonArray.put(object);
    	  }else {
    		  WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workSectorType);
    	  		_log.info("workSectorItems :: "+workSectorItems.getItems().size());
    	  		
    	  		if(Validator.isNotNull(workSectorItems.getItems()) && workSectorItems.getItems().size()>0) {
    	  			for(WorkSector workSector : workSectorItems.getItems()) {
    	  				JSONObject object =JSONFactoryUtil.createJSONObject();
    	  				object.put("id", workSector.getId());
    	  				object.put("value", workSector.getWorkSector());
    	  				jsonArray.put(object);
    	  			}
    	  		}
    	  		JSONObject otherObj =JSONFactoryUtil.createJSONObject();
  				otherObj.put("id", "other");
  				otherObj.put("value", "Other");
				jsonArray.put(otherObj);
    	  }
      }
      resourceResponse.getWriter().print(jsonArray.toJSONString());
      return false;
	} catch (Exception e) {	
		_log.error("Error, "+e.getMessage());
		return Boolean.TRUE;
	}
	}
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	private static final Log _log = LogFactoryUtil.getLog(GetWorkSectorBySectorTypeMVCResourceCommand.class);
}

package gov.omsb.registration.web.resource;

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
	        "mvc.command.name="+MVCCommands.GET_WORKSECTOR_BY_PARENT_WORK_SECTOR
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class GetWorkSectorByParentIdMVCResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try { 
		long workSectorParentId= ParamUtil.getLong(resourceRequest, "parentWorkSectorId");
	     ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
	     WorkSectorItems workSectorItems = registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),workSectorParentId );
	     _log.info("workSectorItems :: "+workSectorItems.getItems().size());
			JSONArray jsonArray= JSONFactoryUtil.createJSONArray();
			if(Validator.isNotNull(workSectorItems.getItems()) && workSectorItems.getItems().size()>0) {
				for(WorkSector workSector : workSectorItems.getItems()) {
					JSONObject object =JSONFactoryUtil.createJSONObject();
					object.put("id", workSector.getId());
					object.put("value", workSector.getWorkSector());
					jsonArray.put(object);
				}
				JSONObject object =JSONFactoryUtil.createJSONObject();
				object.put("id", "other");
				object.put("value", "Other");
				jsonArray.put(object);
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
	
	private static final Log _log = LogFactoryUtil.getLog(GetWorkSectorByParentIdMVCResourceCommand.class);
}

package gov.omsb.registration.web.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SAVE_REGISTRATION_EDUCATION_DETAILS_SR
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class SaveEducationDetailsMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(SaveEducationDetailsMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("Entry into SaveEducationDetailsMVCResourceCommand ::");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			/** ===== Add New Record === **/
			String qualification = ParamUtil.getString(resourceRequest, "qualification");
			String qualificationOther = ParamUtil.getString(resourceRequest, "qualificationOther");
			String institution = ParamUtil.getString(resourceRequest, "institution");
			long countryId = ParamUtil.getLong(resourceRequest, "country");
			/* String gpa = ParamUtil.getString(resourceRequest, "gpa"); */
			int yearOfGraduation = ParamUtil.getInteger(resourceRequest, "year");
			long id = ParamUtil.getLong(resourceRequest, "id");
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
			uploadPortletRequest.getContentType("qualificationDoc");
			EducationDetail educationDetail = registrationUtil.setEducationDetailsData(resourceRequest, themeDisplay,
					themeDisplay.getScopeGroupId(), qualification, institution, countryId, "", yearOfGraduation, id,qualificationOther);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			if (educationDetail.getId() > 0) {
				obj.put("isValid", true);
			} else {
				obj.put("isValid", false);
			}
			registrationUtil.setEducationDetails(resourceRequest, resourceResponse);
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

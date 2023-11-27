package gov.omsb.registration.web.resource;

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

import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.portlet.OmsbRegistrationWebPortlet;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.DELETE_REGISTRATION_EDUCATION_DETAILS_SR
	    }, 
	    service = MVCResourceCommand.class
)
public class DeleteEducationDetailMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("DeleteEducationDetailMVCResourceCommand Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id = ParamUtil.getLong(resourceRequest, "id");
		
		EducationDetail educationDetail = registrationUtil.getItems(themeDisplay.getPortalURL() + LRObjectURL.REG_EDUCATION_DETAIL_URL + id, EducationDetail.class);
		if(Validator.isNotNull(educationDetail) && educationDetail.getId()>0) {			
			registrationUtil.deleteEducationalDetail(themeDisplay, id);
			if(Validator.isNotNull(educationDetail.getDocumentInfo()) && educationDetail.getDocumentInfo().getId()>0) {
				registrationUtil.deleteDocumentInfo(themeDisplay, educationDetail.getDocumentInfo());
			}
		}
		
		registrationUtil.setEducationDetails(resourceRequest, resourceResponse);
		return Boolean.FALSE;
	}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(OmsbRegistrationWebPortlet.class);
}

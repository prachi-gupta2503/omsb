package gov.omsb.registration.web.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.VERIFY_REGISTRATION_WORK_DETAILS
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class VerifyWorkDetailMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			LOGGER.info("VerifyWorkDetailMVCResourceCommand Invoked");
			JSONObject json = JSONFactoryUtil.createJSONObject();		
			boolean isChecked = ParamUtil.getBoolean(resourceRequest, "isChecked");
			long id=ParamUtil.getLong(resourceRequest,"id");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			LOGGER.info("isChecked ::::"+isChecked);
			LOGGER.info("id ::::"+id);
			EmploymentDetail employmentDetail=registrationUtil.getEmploymentDetailById(themeDisplay.getPortalURL(), id);
			LOGGER.info("educationDetail getId::::"+employmentDetail.getId());
			//LOGGER.info("educationDetail getIssuingAuthorityCountry::::"+educationDetail.getIssuingAuthorityName());
			if(Validator.isNotNull(employmentDetail)) {
				Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
				employmentDetail.setEmploymentDetailVerified(isChecked);
				String employmentDetailMapper = CustomObjectMapperUtil.writeValueAsString(employmentDetail, null);
				String response= httpConnector.executePut(themeDisplay.getPortalURL() + LRObjectURL.REG_EMPLOYMENT_DETAIL_URL + id, employmentDetailMapper, headers);
				
				employmentDetail=CustomObjectMapperUtil.readValue(response, EmploymentDetail.class);
			}
			
			
			registrationUtil.setVerificationSWorkDetails(resourceRequest, resourceResponse);
			return Boolean.FALSE;
		} catch (Exception e) {	
			LOGGER.error("Error while checking username, "+e.getMessage());
			return Boolean.TRUE;
		}
	}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	
	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(VerifyWorkDetailMVCResourceCommand.class);
}

package gov.omsb.registration.web.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.swing.text.StyleConstants.CharacterConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.login.web.constants.OmsbLoginConstant;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.GET_CIVILID_BY_MOBILENUMBER
	    }, 
	    service = MVCResourceCommand.class 
)
public class GetCivilIdByMobileNumberMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(GetCivilIdByMobileNumberMVCResourceCommand.class);
	
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("GetCivilIdByMobileNumberMVCResourceCommand Invoked");
			String mobileNumber = ParamUtil.getString(resourceRequest, OmsbLoginConstant.MOBILE_NUMBER);
			_log.debug("Logged in mobileNumber :" + mobileNumber);
			
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			if(Validator.isNull(mobileNumber) || Validator.isBlank(mobileNumber)) {
				jsonObject.put("errorMessage", OmsbLoginConstant.MOBILE_REQUIRED_MESSAGE_KEY);
				jsonObject.put("isValid", Boolean.FALSE);
			}else if(!mobileNumber.matches("^[0-9]+$")) {
				jsonObject.put("errorMessage", OmsbLoginConstant.ENTER_VALID_MOBILE_MESSAGE_KEY);
				jsonObject.put("isValid", Boolean.FALSE);
			} else {
				
				String url = OmsbLoginConstant.LOGIN_TYPE_MOBILE_SERVICE_URL + mobileNumber;
				_log.info("PKI API URL : "+url);
				String response = httpConnector.executeGetWithTimeout(url, StringPool.BLANK, 120000, new HashMap<String, String>());
				_log.info("PKI Response : "+response);

				try{
					JSONObject jsonResponse = new JSONFactoryUtil().createJSONObject(response);
					_log.info("PKI Response JSON : "+jsonResponse);
					int statusCode = jsonResponse.getInt("status");
					if(statusCode == 502) {
						jsonObject.put("civilId", jsonResponse.getLong(OmsbLoginConstant.CIVIL_ID));
						jsonObject.put("fullName", jsonResponse.getString(OmsbLoginConstant.FULLNAME));
						jsonObject.put("fullNameAr", GetterUtil.getString( URLDecoder.decode(jsonResponse.getString(OmsbLoginConstant.FULLNAME_AR)), DataflowConstants.UTF_8));
						jsonObject.put("isValid", Boolean.TRUE);
					} else if(statusCode == 501) {
						jsonObject.put("error", statusCode);
						jsonObject.put("isValid", Boolean.FALSE);
					} else {
						jsonObject.put("error", statusCode);
						jsonObject.put("isValid", Boolean.FALSE);
					}
				} catch (JSONException e) {
					_log.info(e.getMessage(), e);	
				}
			}
			_log.info("Serversource Response JSON : "+jsonObject);
			
			resourceResponse.getWriter().print(jsonObject.toJSONString());
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error ::, "+e.getMessage());
			return Boolean.TRUE;
		}
}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;	
}

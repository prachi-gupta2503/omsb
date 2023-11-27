package gov.omsb.registration.web.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.ScreenNameValidatorFactory;

import java.io.IOException;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.portlet.OmsbRegistrationWebPortlet;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.VERIFY_REGISTRATION_PERSONAL_DETAILS
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class VerifyRegistrationPersonalDetailMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			LOGGER.info("VerifyRegistrationPersonalDetailMVCResourceCommand Invoked");
			JSONObject json = JSONFactoryUtil.createJSONObject();		
			boolean isChecked = ParamUtil.getBoolean(resourceRequest, "isChecked");
			long lrUserId=ParamUtil.getLong(resourceRequest,"lrUserId");
			long personId=ParamUtil.getLong(resourceRequest,"personId");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			
			
			
			LOGGER.info("isChecked ::::"+isChecked);
			LOGGER.info("lrUserId ::::"+lrUserId);
			LOGGER.info("personId ::::"+personId);
			
			PersonalDetailItem personalDetailItem=registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
				
			LOGGER.info("personalDetailItem ::::"+personalDetailItem.getItems().size());
			LOGGER.info("personalDetailItem ::::"+personalDetailItem.getItems().get(0).getLrUserId());
				
			if(Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size()>0) {
			
				Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
				PersonalDetail personalDetail=personalDetailItem.getItems().get(0);
				personalDetail.setPersonalDetailVerified(isChecked);
				
				String personalDetailMapper = CustomObjectMapperUtil.writeValueAsString(personalDetail, null);
				
				String response=StringPool.BLANK;
				
					response = httpConnector.executePut(
							themeDisplay.getPortalURL() + LRObjectURL.REG_PERSONAL_DETAILS_URL + personalDetail.getId(), personalDetailMapper, headers);
				
					personalDetail=CustomObjectMapperUtil.readValue(response, PersonalDetail.class);
					resourceResponse.getWriter().print(personalDetail.isPersonalDetailVerified());
				
			}
			
			/*
			 * User user = null; try { user =
			 * UserLocalServiceUtil.getUserByScreenName(PortalUtil.getDefaultCompanyId(),
			 * userName); } catch (PortalException e) {
			 * LOGGER.debug("Error while getting user details by username, "+e.getMessage())
			 * ; } if(Validator.isNotNull(user) && user.getUserId()>0) { json.put("isValid",
			 * Boolean.FALSE); json.put("message", "username-already-taken"); } else
			 * if(ScreenNameValidatorFactory.getInstance().validate(PortalUtil.
			 * getDefaultCompanyId(), userName)) { json.put("isValid", Boolean.TRUE); } else
			 * { json.put("isValid", Boolean.FALSE); json.put("message",
			 * "invalid-username");
			 * 
			 * }
			 */
			
			
			
			
			
			
			//resourceResponse.getWriter().print(json);
			return Boolean.FALSE;
		} catch (IOException e) {	
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
	
	private static final Log LOGGER = LogFactoryUtil.getLog(VerifyRegistrationPersonalDetailMVCResourceCommand.class);
}

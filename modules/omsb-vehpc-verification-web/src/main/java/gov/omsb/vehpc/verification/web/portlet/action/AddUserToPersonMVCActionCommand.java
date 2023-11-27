package gov.omsb.vehpc.verification.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.verification.dto.PersonItem;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;


@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
			"mvc.command.name=addUserToPersonURL" 
		},
		service = MVCActionCommand.class
)
public class AddUserToPersonMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(AddUserToPersonMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		log.info("doProcessAction >>>>> method started>>>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String personId = ParamUtil.getString(request, "personId");
		String personUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_BY_PK_URL+StringPool.FORWARD_SLASH+personId;
		
		String personResponse = omsbCommonApi.getData(personUrl);
		log.info("AddUserToPersonMVCActionCommand : personUrl::::"+personUrl+" , personResponse : "+personResponse);
		PersonItem person = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
		if((person.getLrUserId()==0)) {
			Map<String, String> headers = new HashMap<>();
			String authorizationToken = omsbCommonApi.getLiferayAuthorizationToken();
			headers.put("Authorization", "Bearer " + authorizationToken);
			headers.put("content-type", "application/json");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			
			jsonObject.put(CommonConstants.LR_USERID, themeDisplay.getUserId());
			String postResponse = omsbHttpConnector.executePut(themeDisplay.getPortalURL()+LRObjectURL.PERSON_BY_PK_URL+StringPool.FORWARD_SLASH+personId, jsonObject.toString(), headers);
			person = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
		}
		log.info("doProcessAction >>>>> method ended>>>>>");
		//Redirect for autologin with userId
		String redirect = themeDisplay.getCDNBaseURL() +"/group/guest/verification";
		response.sendRedirect(redirect);
	}
	@Reference(unbind = "_")
	private OMSBHttpConnector omsbHttpConnector;
	@Reference(unbind="-")
	private OMSBCommonApi omsbCommonApi;
	private static final Log _log = LogFactoryUtil.getLog(AddUserToPersonMVCActionCommand.class);
}

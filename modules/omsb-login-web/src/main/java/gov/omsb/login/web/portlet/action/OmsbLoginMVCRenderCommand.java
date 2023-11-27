package gov.omsb.login.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.login.web.constants.OmsbLoginConstant;
import gov.omsb.login.web.constants.OmsbLoginWebPortletKeys;

/**
 * @author himanshu.nimavat
 * 
 * The Class OmsbLoginMVCRenderCommand.
 * 
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbLoginWebPortletKeys.OMSBLOGINWEB,
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class OmsbLoginMVCRenderCommand implements MVCRenderCommand {
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		boolean isError = false;
		
		log.info("navTab in render ParamUtil:: " + ParamUtil.getString(renderRequest, OmsbLoginConstant.LOGIN_TYPE));
		
		log.info("Argument :: " + ParamUtil.getString(renderRequest, OmsbLoginConstant.USER_SCREEN_NAME));

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			
		String omanIDCivilNumber = httpReq.getParameter("omanIDCivilNumber");
		if(Validator.isNotNull(omanIDCivilNumber)) {
			long civilId = Long.valueOf(omanIDCivilNumber);
			String personWithScopeURL = generateScopeListURL(LRObjectURL.PERSON_URL,themeDisplay.getScopeGroupId());
			String personUrl = null;
			try {
				personUrl = personWithScopeURL + StringPool.QUESTION + "filter=" + "civilId" + URLEncoder.encode(" eq " + StringPool.APOSTROPHE + civilId + StringPool.APOSTROPHE, StringPool.UTF8);
			} catch (UnsupportedEncodingException e) {
				log.error("Error while validating the user ::: " + e);
			}
			
			String personResponse = omsbCommonApi.getData(personUrl);
			PersonItem personItems = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
			
			String loginUrl = null;
			if(Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems()) && personItems.getItems().size() > 0) {
				
				long userId = personItems.getItems().get(0).getLrUserId();
				if(Validator.isNotNull(userId)) {
					
				User user = userLocalService.fetchUserById(userId);
				
				if (Validator.isNull(user)) {
					renderRequest.setAttribute("errorMessage", "user-not-exist");
					isError = true;
				} else if (!user.isActive()) {
					renderRequest.setAttribute("errorMessage", "user-in-active");
					isError = true;
				}
				
			//Redirect for autologin with userId
			loginUrl = themeDisplay.getCDNBaseURL() + "/login?" + "pkiUserId" + StringPool.EQUAL + user.getUserId();
			} else {
				loginUrl = themeDisplay.getCDNBaseURL() + "/login";
				renderRequest.setAttribute("errorMessage", "user-not-exist");
			}
			renderRequest.setAttribute("loginUrl", loginUrl);
				
			}else {
				renderRequest.setAttribute("errorMessage", "user-not-exist");
				isError = true;
			}					
		}
		
		renderRequest.setAttribute("isError", isError);
	
		renderRequest.setAttribute(OmsbLoginConstant.LOGIN_TYPE, ParamUtil.getString(renderRequest, OmsbLoginConstant.LOGIN_TYPE));
		renderRequest.setAttribute(OmsbLoginConstant.USER_SCREEN_NAME, ParamUtil.getString(renderRequest, OmsbLoginConstant.USER_SCREEN_NAME));
		
		renderRequest.setAttribute("isSignedIn", themeDisplay.isSignedIn());
		renderRequest.setAttribute("registrationUrl", OmsbLoginConstant.REGISTRATION_JSP);
		
		return OmsbLoginConstant.VIEW_LOGIN_JSP;
	}
	
	private String generateScopeListURL(String personRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + personRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private UserLocalService userLocalService;
	
	private static final Log log = LogFactoryUtil.getLog(OmsbLoginMVCRenderCommand.class);
}

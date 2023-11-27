package omsb.forget.password.web.resources;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import omsb.forget.password.web.constants.OmsbForgetPasswordWebPortletKeys;
import omsb.forget.password.web.constants.OmsbMVCCommandsKeys;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbForgetPasswordWebPortletKeys.OMSBFORGETPASSWORDWEB,
	        "mvc.command.name="+OmsbMVCCommandsKeys.UPDATE_PASSWORD
	    }, 
	    service = MVCResourceCommand.class
)
public class UpdateUserPasswordMVCResource implements MVCResourceCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(UpdateUserPasswordMVCResource.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("Entry into UpdateUserPasswordMVCResource :: serveResource:");
		
		String newpassword = ParamUtil.getString(resourceRequest, "newPassword");
		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		LOGGER.info("newpassword ::"+newpassword);
		LOGGER.info("lrUserId ::"+lrUserId);
		
		long companyId = themeDisplay.getCompanyId();
		JSONObject json= JSONFactoryUtil.createJSONObject();
		try {
		//	User liferayUser = UserLocalServiceUtil.fetchUserById(lrUserId);
			if (Validator.isNotNull(lrUserId)) {
				try {
					User user=	UserLocalServiceUtil.updatePassword(lrUserId, newpassword, newpassword, false);
					json.put("isPasswordUpdated", true);
					json.put("isValid", true);
				} catch (Exception e) {
					json.put("isPasswordUpdated", false);
					json.put("isValid", false);
					json.put("errormessage",e.getMessage());
					LOGGER.error("Exception :::" +e.getMessage());
				}
			} else {
				json.put("isPasswordUpdated", false);
				json.put("isValid", false);
			}
			resourceResponse.getWriter().print(json);
		
		} catch (Exception e) {
			// TODO: handle exception
			json.put("isPasswordUpdated", false);
		}
		return Boolean.TRUE;
	}

}

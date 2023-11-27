package gov.omsb.login.web.auth;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

/**
 * @author himanshu.nimavat
 * 
 * The Class OmsbCustomAutoLogin.
 * 
 */
@Component(service = AutoLogin.class)
public class OmsbCustomAutoLogin extends BaseAutoLogin {

	@Override
	protected String[] doLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		User user = getUser(httpServletRequest);
		
		if(user == null) {
			return null;
		}
		
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute("j_username", user.getScreenName());
		
		String[] credentials = new String[3];

		credentials[0] = String.valueOf(user.getUserId());
		credentials[1] = user.getPassword();
		credentials[2] = Boolean.FALSE.toString();

		return credentials;
	}

	private User getUser(HttpServletRequest httpServletRequest) {
		long userId = ParamUtil.getLong(httpServletRequest, "pkiUserId");
		User user = UserLocalServiceUtil.fetchUser(userId);
			
		return Validator.isNotNull(user) ? user : null; 
	}

}

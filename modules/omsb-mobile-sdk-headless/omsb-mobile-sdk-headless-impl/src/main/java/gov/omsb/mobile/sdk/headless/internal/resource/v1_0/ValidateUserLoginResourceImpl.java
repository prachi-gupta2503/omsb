package gov.omsb.mobile.sdk.headless.internal.resource.v1_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.PasswordTrackerLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import gov.omsb.mobile.sdk.headless.dto.v1_0.Response;
import gov.omsb.mobile.sdk.headless.dto.v1_0.ValidateUserLoginRequest;
import gov.omsb.mobile.sdk.headless.resource.v1_0.ValidateUserLoginResource;

/**
 * @author Niddhi Thacker
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/validate-user-login.properties",
	scope = ServiceScope.PROTOTYPE, service = ValidateUserLoginResource.class
)
public class ValidateUserLoginResourceImpl
	extends BaseValidateUserLoginResourceImpl {
	private static final Log log = LogFactoryUtil.getLog(ValidateUserLoginResourceImpl.class);
	public static final String USERNAME_PASSWORD_REQUIRED = "Username/Password is required";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String INVALID_USER = "A user with username [$USER_NAME$] doesn't exist.";
	public static final String INVALID_PASSWORD = "Please enter correct password";
	public static final String USER_NAME = "[$USER_NAME$]";
	
	@Override
	public Response validateUserLogin(ValidateUserLoginRequest validateUserLoginRequest) throws Exception {
		log.info("::: ValidateUserLoginResourceImpl >>> validateUserLogin >>> validating user:::");
		Response response = new Response();
		String username = validateUserLoginRequest.getUserName();
		log.info("::: ValidateUserLoginResourceImpl >>> validateUserLogin >>> user name :::" + username);
		String password = validateUserLoginRequest.getPassword();
		log.info("::: ValidateUserLoginResourceImpl >>> validateUserLogin >>> password :::" + password);
		if (Validator.isNull(username) || Validator.isNull(password)) {
			response.setMessage(USERNAME_PASSWORD_REQUIRED);
			response.setStatus(ERROR);
		} else {
			User user = userLocalService.fetchUserByScreenName(PortalUtil.getDefaultCompanyId(), username);
			if (Validator.isNull(user)) {
				response.setMessage(INVALID_USER.replace(USER_NAME, username));
				response.setStatus(ERROR);
			} else {
				boolean passwordMatched = passwordTrackerLocalService.isSameAsCurrentPassword(user.getUserId(), password);
				if (!passwordMatched) {
					response.setMessage(INVALID_PASSWORD);
					response.setStatus(ERROR);
				} else {
					response.setStatus(SUCCESS);
				}
			}
		}
		return response;
	}
	
	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private PasswordTrackerLocalService passwordTrackerLocalService;
}
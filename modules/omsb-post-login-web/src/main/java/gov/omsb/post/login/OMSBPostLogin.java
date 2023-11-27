package gov.omsb.post.login;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.post.login.constants.OmsbPostLoginWebPortletKeys;

@Component(immediate = true, property = { "key=login.events.post" }, service = LifecycleAction.class)
public class OMSBPostLogin implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

		User user = null;

		HttpServletRequest request = lifecycleEvent.getRequest();

		HttpServletResponse response = lifecycleEvent.getResponse();
		try {
			user = _portal.getUser(request);
			log.info("user email::" + user.getEmailAddress());
			userRedirection(user,response);
		} catch (Exception e) {
			log.error(e.getMessage());
			;
		}
		log.info("processLifecycleEvent end");
	}

	private void userRedirection(User user, HttpServletResponse response)  {
		try {
			List<Role> userRoles = user.getRoles();
			log.info("userRoles Size :"+userRoles.size());
			if(Validator.isNotNull(userRoles) && !userRoles.isEmpty()) {
				boolean isHCP = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.HEALTH_CARE_PROFESSIONAL, Boolean.FALSE);
				boolean isUser = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.USER, Boolean.FALSE);
				boolean isProfileApprover = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
				boolean isRoleApprover = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
				boolean isTrainee = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.TRAINEE, Boolean.FALSE);
				boolean isFaculty = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.FACULTY , Boolean.FALSE);
				boolean isExamDepartmentAdmin = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.EXAM_DEPARTNEMT_ADMIN , Boolean.FALSE);
				boolean isProgramAdministrator = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.PROGRAM_ADMINISTRATOR , Boolean.FALSE);
				boolean isEmployer = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.EMPLOYER , Boolean.FALSE);
				boolean isVehpcAdmin = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.VEHPC_ADMIN , Boolean.FALSE);
				boolean isVehpcRapporteur = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.VEHPC_RAPPORTEUR , Boolean.FALSE);
				boolean isVehpcCommittee = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.VEHPC_COMMITTEE , Boolean.FALSE);
				boolean isOCTAdmin = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.OCT_ADMIN , Boolean.FALSE);
				
				if (isHCP && isUser) {
					log.info("isHCP && isUser landing ");
					response.sendRedirect(OmsbPostLoginWebPortletKeys.MY_PROFILE_PAGE_URL);
				}else if(isProfileApprover || isRoleApprover || isTrainee || isFaculty || isExamDepartmentAdmin || isProgramAdministrator || isEmployer || isVehpcAdmin || isVehpcCommittee || isVehpcRapporteur || isOCTAdmin) {
					log.info("isProfileApprover || isRoleApprover || isTrainee || isFaculty || isExamDepartmentAdmin || isProgramAdministrator || isEmployer || isVehpcAdmin || isVehpcCommittee || isVehpcRapporteur || isOCTAdmin landing ");
					response.sendRedirect(OmsbPostLoginWebPortletKeys.MY_DASHBOARD_PAGE_URL);
				}else {
					response.sendRedirect(OmsbPostLoginWebPortletKeys.DASHBOARD_PAGE_URL);
				}
			}
		} catch (Exception e) {

			log.error( e.getMessage());
		}
	}

	@Reference
	private Portal _portal;

	@Reference
	private GroupService _groupService;

	@Reference
	private RoleService _roleService;

	private static final Log log = LogFactoryUtil.getLog(OMSBPostLogin.class);

}
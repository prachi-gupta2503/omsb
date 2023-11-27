package gov.omsb.tms.ecm.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gov.omsb.tms.ecm.web.constants.ECMemberRoles;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.EcMemberRequestLocalServiceUtil;

public class ECMemberUserUtil {
	private static final Log LOGGER = LogFactoryUtil.getLog(ECMemberUserUtil.class);
	
	public static Role getRole(long companyId, String roleName) {
		LOGGER.info("getRole > companyId-"+companyId +"  - roleName -"+roleName);
		Role role = null;
		try {
			
			List<Role> allRoles = RoleLocalServiceUtil.getRoles(-1, -1);

			Optional<Role> fRole = allRoles.stream()
					 .filter(r -> r.getName().equals(roleName))
			          .findFirst();
			if(fRole.isPresent()) {
				role = fRole.get();
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		return role;
		
	}
	
	public static List<User> getQararRequesters(long requestId) {
		List<User> users = new ArrayList<User>();
		Role role = null;
		try {
			EcMemberRequest ecMemberRequest = EcMemberRequestLocalServiceUtil.getEcMemberRequest(requestId);
			String [] roleList = { ECMemberRoles.EC_SECTION_STAFF,  ECMemberRoles.EC_SECTION_HEAD,  
									ECMemberRoles.GME_DIRECTOR, ECMemberRoles.VPAA, ECMemberRoles.EXECUTIVE_PRESIDENT }; 
			for(String roleName : roleList) {
				role = RoleLocalServiceUtil.getRole(ecMemberRequest.getCompanyId(), roleName);
				if(role != null) {
					List<User> usersInRole = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
					users.addAll(usersInRole);
				}
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		
		return users;
	}
	
}

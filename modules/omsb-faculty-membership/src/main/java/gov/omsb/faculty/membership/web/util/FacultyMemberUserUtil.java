package gov.omsb.faculty.membership.web.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;


public class FacultyMemberUserUtil {

	
private static final Log LOGGER = LogFactoryUtil.getLog(FacultyMemberUserUtil.class);
	
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
}

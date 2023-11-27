package gov.omsb.role.types.web.portlet.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.role.types.web.constants.OmsbRoleTypesWebPortletKeys;
import gov.omsb.tms.model.RoleTypeMaster;

/**
 * 
 * @author Jayesh Goswami
 *
 */
public class OmsbRoleTypeUtil {
	
	private OmsbRoleTypeUtil() {}

	/**
	 * 
	 * @param actionRequest
	 * @param roleTypesMaster
	 * @param isCreate
	 * @param themeDisplay
	 * @return
	 */
	public static RoleTypeMaster createRoleTypeMasterObject(ActionRequest actionRequest, RoleTypeMaster roleTypesMaster, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.info("createRoleTypeMasterObject Invoked ::: ");
		Map<Locale, String> roleTypeName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbRoleTypesWebPortletKeys.ROLE_TYPE_NAME);
		
		roleTypesMaster.setRoleTypeNameMap(roleTypeName);
		roleTypesMaster.setModifiedBy(themeDisplay.getUserId());
		if(isCreate) {
			roleTypesMaster.setGroupId(themeDisplay.getScopeGroupId());
			roleTypesMaster.setCreatedBy(themeDisplay.getUserId());
		}
		_logger.info("createRoleTypeMasterObject Exit ::: ");
		return roleTypesMaster;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbRoleTypeUtil.class.getName());
}

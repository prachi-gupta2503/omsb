package gov.omsb.role.types.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.role.types.web.constants.OmsbRoleTypesWebPortletKeys;
import gov.omsb.role.types.web.portlet.util.OmsbRoleTypeUtil;
import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.service.RoleTypeMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRoleTypesWebPortletKeys.OMSBROLETYPESWEB,
		"mvc.command.name="
				+ OmsbRoleTypesWebPortletKeys.SAVE_ROLE_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveRoleTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long roleTypeMasterId = ParamUtil.getLong(actionRequest, OmsbRoleTypesWebPortletKeys.ROLE_TYPE_MASTER_ID, 0);

		try {
			if (roleTypeMasterId != 0) {
				// Update Role Type Master
				isSuccess = updateRoleTypeMaster(actionRequest, roleTypeMasterId, themeDisplay);
			} else {
				// Create Role Type Master
				isSuccess = createRoleTypeMaster(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	/**
	 * 
	 * @param actionRequest
	 * @param roleTypeMasterId
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	private boolean updateRoleTypeMaster(ActionRequest actionRequest, long roleTypeMasterId, ThemeDisplay themeDisplay)
			throws PortalException {
		RoleTypeMaster roleTypesMaster = roleTypeMasterLocalService.getRoleTypeMaster(roleTypeMasterId);
		if (Validator.isNotNull(roleTypesMaster)) {
			if (!validateRoleType(actionRequest, roleTypesMaster)) {
				return false;
			}
			roleTypeMasterLocalService.updateRoleTypeMaster(OmsbRoleTypeUtil.createRoleTypeMasterObject(actionRequest,
					roleTypesMaster, Boolean.FALSE, themeDisplay));
			_logger.debug("updateRoleTypeMaster ::: Role Type Master Record Updated");
		} else {
			_logger.debug("updateRoleTypeMaster ::: Role Type Master Record Not Found " + roleTypeMasterId);
			return false;
		}
		return true;

	}

	/**
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	private boolean createRoleTypeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		long roleTypeMasterId = counterLocalService.increment(getClass().getName(), 1);
		try {
			if (!validateRoleType(actionRequest, null)) {
				return false;
			}
			RoleTypeMaster roleTypeMaster = roleTypeMasterLocalService.createRoleTypeMaster(roleTypeMasterId);
			roleTypeMasterLocalService.addRoleTypeMaster(OmsbRoleTypeUtil.createRoleTypeMasterObject(actionRequest,
					roleTypeMaster, Boolean.TRUE, themeDisplay));
			_logger.debug("createRoleTypeMaster ::: Role Type Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}

	private boolean validateRoleType(ActionRequest actionRequest, RoleTypeMaster roleTypeMaster) {
		List<String> roleTypeNames = new ArrayList<>();

		Map<Locale, String> roleTypeNameMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbRoleTypesWebPortletKeys.ROLE_TYPE_NAME);

		addLocalizedValue(roleTypeNameMap, roleTypeNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(roleTypeNameMap, roleTypeNames, CommonConstants.LANGUAGE_CODE_ARABIC);

		if (checkRoleTypeNames(roleTypeNames, actionRequest, roleTypeMaster)) {
			return false;
		}

		return true;
	}

	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}

	private boolean checkRoleTypeNames(List<String> roleTypeNames, ActionRequest actionRequest,
			RoleTypeMaster roleTypeMaster) {
		List<RoleTypeMaster> roleTypeMasters;
		for (String roleTypeName : roleTypeNames) {
			String likeRoleTypeName = StringPool.PERCENT + StringPool.GREATER_THAN + roleTypeName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			roleTypeMasters = new ArrayList<>(roleTypeMasterLocalService.findByRoleTypeNameByLike(likeRoleTypeName));
			if (Validator.isNotNull(roleTypeMaster) && roleTypeMasters.contains(roleTypeMaster)) {
				roleTypeMasters.remove(roleTypeMaster);
			}
			if (!roleTypeMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbRoleTypesWebPortletKeys.ROLE_TYPE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	@Reference
	private RoleTypeMasterLocalService roleTypeMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveRoleTypeMVCActionCommand.class.getName());

}

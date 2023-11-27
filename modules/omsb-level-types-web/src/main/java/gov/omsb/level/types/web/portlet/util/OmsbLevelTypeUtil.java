package gov.omsb.level.types.web.portlet.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.level.types.web.constants.OmsbLevelTypesWebPortletKeys;
import gov.omsb.tms.model.LevelTypeMaster;

/**
 * @author Dhairya
 */
public class OmsbLevelTypeUtil {
	private OmsbLevelTypeUtil() {

	}

	/**
	 * 
	 * @param actionRequest
	 * @param levelTypeMaster
	 * @param isCreate
	 * @param themeDisplay
	 * @return
	 */
	public static LevelTypeMaster createLevelTypeMasterObject(ActionRequest actionRequest, LevelTypeMaster levelTypeMaster, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.info("createLevelTypeMasterObject Invoked ::: ");
		Calendar calendar = Calendar.getInstance();
		Map<Locale, String> levelTypeName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbLevelTypesWebPortletKeys.LEVEL_TYPE_NAME);
		levelTypeMaster.setLevelTypeNameMap(levelTypeName);
		levelTypeMaster.setModifiedDate(calendar.getTime());
		levelTypeMaster.setModifiedBy(themeDisplay.getUserId());
		if(isCreate) {
			levelTypeMaster.setCreateDate(calendar.getTime());
			levelTypeMaster.setModifiedDate(calendar.getTime());
			levelTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
			levelTypeMaster.setCompanyId(themeDisplay.getCompanyId());
			levelTypeMaster.setCreatedBy(themeDisplay.getUserId());
			levelTypeMaster.setModifiedBy(themeDisplay.getUserId());
		}
		_logger.info("createLevelTypeMasterObject Exit ::: ");
		return levelTypeMaster;
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbLevelTypeUtil.class);
}

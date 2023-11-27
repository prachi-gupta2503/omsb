package gov.omsb.rotation.type.web.portlet.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.rotation.type.web.constants.OmsbRotationTypeWebPortletKeys;
import gov.omsb.tms.model.RotationTypeMaster;

/**
 * 
 * @author Jayesh Goswami
 *
 */
public class OmsbRotationTypeUtil {
	
	private OmsbRotationTypeUtil() {}

	/**
	 * 
	 * @param actionRequest
	 * @param rotationTypeMaster
	 * @param isCreate
	 * @param themeDisplay
	 * @return
	 */
	public static RotationTypeMaster createRotationTypeMasterObject(ActionRequest actionRequest, RotationTypeMaster rotationTypeMaster, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.info("createRotationTypeMasterObject Invoked ::: ");
		Map<Locale, String> rotationTypeName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbRotationTypeWebPortletKeys.ROTATION_TYPE_NAME);
		
		rotationTypeMaster.setRotationTypeNameMap(rotationTypeName);
		rotationTypeMaster.setModifiedBy(themeDisplay.getUserId());
		if(isCreate) {
			rotationTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
			rotationTypeMaster.setCreatedBy(themeDisplay.getUserId());
		}
		_logger.info("createRotationTypeMasterObject Exit ::: ");
		return rotationTypeMaster;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbRotationTypeUtil.class.getName());
}

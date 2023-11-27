package gov.omsb.eligibility.degree.web.portlet.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.eligibility.degree.web.constants.OmsbEligibilityDegreeWebPortletKeys;
import gov.omsb.tms.model.EligibilityDegreeMaster;

/**
 * @author Komal Gajera
 */
public class OmsbEligibilityDegreeUtil {
	
	private OmsbEligibilityDegreeUtil() {}
	
	/**
	 * @param actionRequest
	 * @param eligibilityDegreeMaster
	 * @param isCreate
	 * @param themeDisplay
	 * @return
	 */
	public static EligibilityDegreeMaster createEligibilityDegreeMasterObject(ActionRequest actionRequest, EligibilityDegreeMaster eligibilityDegreeMaster, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.info("createEligibilityDegreeMasterObject Invoked ::: ");
		Map<Locale, String> eligibilityDegreeName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbEligibilityDegreeWebPortletKeys.ELIGIBILITY_DEGREE_NAME);
		
		eligibilityDegreeMaster.setEligibilityDegreeMap(eligibilityDegreeName);
		eligibilityDegreeMaster.setModifiedBy(themeDisplay.getUserId());

		if(isCreate) {
			eligibilityDegreeMaster.setGroupId(themeDisplay.getScopeGroupId());
			eligibilityDegreeMaster.setCreatedBy(themeDisplay.getUserId());
		}
		_logger.info("createEligibilityDegreeMasterObject Exit ::: ");
		return eligibilityDegreeMaster;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEligibilityDegreeUtil.class.getName());
}

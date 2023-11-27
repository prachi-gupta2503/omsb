package gov.omsb.visit.types.web.portlet.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.visit.types.web.constants.OmsbVisitTypesWebPortletKeys;

/**
 * @author Jayesh Goswami
 */
public class OmsbVisitTypeUtil {
	
	private OmsbVisitTypeUtil() {}
	
	/**
	 * 
	 * @param actionRequest
	 * @param visitTypesMaster
	 * @param isCreate
	 * @param themeDisplay
	 * @return
	 */
	public static VisitTypeMaster createVisitTypeMasterObject(ActionRequest actionRequest, VisitTypeMaster visitTypesMaster, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.info("createVisitTypeMasterObject Invoked ::: ");
		Map<Locale, String> visitTypeName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbVisitTypesWebPortletKeys.VISIT_TYPE_NAME);
		
		visitTypesMaster.setVisitTypeNameMap(visitTypeName);
		visitTypesMaster.setModifiedBy(themeDisplay.getUserId());
		if(isCreate) {
			visitTypesMaster.setGroupId(themeDisplay.getScopeGroupId());
			visitTypesMaster.setCreatedBy(themeDisplay.getUserId());
		}
		_logger.info("createVisitTypeMasterObject Exit ::: ");
		return visitTypesMaster;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbVisitTypeUtil.class.getName());
}

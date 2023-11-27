package gov.omsb.participation.type.web.portlet.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.participation.type.web.constants.OmsbParticipationTypeWebPortletKeys;
import gov.omsb.tms.model.ParticipationTypeMaster;

/**
 * 
 * @author HP
 *
 */
public class OmsbParticipationTypeUtil {
	
	private OmsbParticipationTypeUtil() {}

	/**
	 * 
	 * @param actionRequest
	 * @param participationTypesMaster
	 * @param isCreate
	 * @param themeDisplay
	 * @return
	 */
	public static ParticipationTypeMaster createParticipationTypeMasterObject(ActionRequest actionRequest, ParticipationTypeMaster participationTypeMaster, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.info("createParticipationTypeMasterObject Invoked ::: ");
		Map<Locale, String> participationTypeName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_NAME);
		
		long programDurationId = ParamUtil.getLong(actionRequest, OmsbParticipationTypeWebPortletKeys.PROGRAM_DURATION_ID, 0);
		
		//Common variable addition
		participationTypeMaster.setProgramDurationId(programDurationId);
		participationTypeMaster.setParticipationTypeNameMap(participationTypeName);
		participationTypeMaster.setModifiedBy(themeDisplay.getUserId());
		if(isCreate) {
			participationTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
			participationTypeMaster.setCreatedBy(themeDisplay.getUserId());
		}
		_logger.info("createParticipationTypeMasterObject Exit ::: ");
		return participationTypeMaster;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbParticipationTypeUtil.class.getName());
}

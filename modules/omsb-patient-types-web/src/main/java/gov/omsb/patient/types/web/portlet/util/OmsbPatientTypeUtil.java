package gov.omsb.patient.types.web.portlet.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.patient.types.web.constants.OmsbPatientTypesWebPortletKeys;
import gov.omsb.tms.model.PatientTypeMaster;

/**
 * @author Jayesh Goswami
 */
public class OmsbPatientTypeUtil {
	
	private OmsbPatientTypeUtil() {}
	
	/**
	 * @param actionRequest
	 * @param patientTypesMaster
	 * @param isCreate
	 * @param themeDisplay
	 * @return
	 */
	public static PatientTypeMaster createPatientTypeMasterObject(ActionRequest actionRequest, PatientTypeMaster patientTypesMaster, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.info("createPatientTypeMasterObject Invoked ::: ");
		Map<Locale, String> patientTypeName = LocalizationUtil.getLocalizationMap(actionRequest, OmsbPatientTypesWebPortletKeys.PATIENT_TYPE_NAME);
		
		patientTypesMaster.setPatientTypeNameMap(patientTypeName);
		patientTypesMaster.setModifiedBy(themeDisplay.getUserId());
		if(isCreate) {
			patientTypesMaster.setGroupId(themeDisplay.getScopeGroupId());
			patientTypesMaster.setCreatedBy(themeDisplay.getUserId());
		}
		_logger.info("createPatientTypeMasterObject Exit ::: ");
		return patientTypesMaster;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbPatientTypeUtil.class.getName());
}

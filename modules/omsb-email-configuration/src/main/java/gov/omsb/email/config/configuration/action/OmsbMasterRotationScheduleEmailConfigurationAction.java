package gov.omsb.email.config.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.email.config.configuration.OmsbMasterRotationScheduleEmailConfiguration;

@Component(configurationPid = "gov.omsb.email.config.configuration.OmsbMasterRotationScheduleEmailConfiguration",enabled = true, immediate = true)
public class OmsbMasterRotationScheduleEmailConfigurationAction {
	
	public static String subjectForTraineeMasterRotationSchedule() {
		Map<Locale, String> subjectForTraineeMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(subjectForTraineeMasterRotationSchedule);
		return subjectForTraineeMasterRotationScheduleMap.get(Locale.US);
	}
	public static String bodyForTraineeMasterRotationSchedule() {
		Map<Locale, String> bodyForTraineeMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(bodyForTraineeMasterRotationSchedule);
		return bodyForTraineeMasterRotationScheduleMap.get(Locale.US);
	}
	
	public static String subjectForFacultyMasterRotationSchedule() {
		Map<Locale, String> subjectForFacultyMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(subjectForFacultyMasterRotationSchedule);
		return subjectForFacultyMasterRotationScheduleMap.get(Locale.US);
	}
	public static String bodyForFacultyMasterRotationSchedule() {
		Map<Locale, String> bodyForFacultyMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(bodyForFacultyMasterRotationSchedule);
		return bodyForFacultyMasterRotationScheduleMap.get(Locale.US);
	}
	
	public static String subjectForPAUserMasterRotationSchedule() {
		Map<Locale, String> subjectForPAUserMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(subjectForPAUserMasterRotationSchedule);
		return subjectForPAUserMasterRotationScheduleMap.get(Locale.US);
	}
	public static String bodyForPAUserMasterRotationSchedule() {
		Map<Locale, String> bodyForPAUserMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(bodyForPAUserMasterRotationSchedule);
		return bodyForPAUserMasterRotationScheduleMap.get(Locale.US);
	}
	
	public static String subjectForECMemberMasterRotationSchedule() {
		Map<Locale, String> subjectForECMemberMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(subjectForECMemberMasterRotationSchedule);
		return subjectForECMemberMasterRotationScheduleMap.get(Locale.US);
	}
	public static String bodyForECMemberMasterRotationSchedule() {
		Map<Locale, String> bodyForECMemberMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(bodyForECMemberMasterRotationSchedule);
		return bodyForECMemberMasterRotationScheduleMap.get(Locale.US);
	}
	
	
	public static String subjectForTraineeMasterRotationScheduleXML() {
		return subjectForTraineeMasterRotationSchedule;
	}
	public static String bodyForTraineeMasterRotationScheduleXML() {
		return bodyForTraineeMasterRotationSchedule;
	}
	
	public static String subjectForFacultyMasterRotationScheduleXML() {
		return subjectForFacultyMasterRotationSchedule;
	}

	public static String bodyForFacultyMasterRotationScheduleXML() {
		return bodyForFacultyMasterRotationSchedule;
	}

	public static String subjectForPAUserMasterRotationScheduleXML() {
		return subjectForPAUserMasterRotationSchedule;
	}
	public static String bodyForPAUserMasterRotationScheduleXML() {
		return bodyForPAUserMasterRotationSchedule;
	}
	public static String subjectForECMemberMasterRotationScheduleXML() {
		return subjectForECMemberMasterRotationSchedule;
	}
	public static String bodyForECMemberMasterRotationScheduleXML() {
		return bodyForECMemberMasterRotationSchedule;
	}
	
	protected void activate(Map<String,Object> properties) {
		
		configuration = ConfigurableUtil.createConfigurable(OmsbMasterRotationScheduleEmailConfiguration.class, properties);
		
		subjectForTraineeMasterRotationSchedule = configuration.subjectForTraineeMasterRotationSchedule();
		bodyForTraineeMasterRotationSchedule  = configuration.bodyForTraineeMasterRotationSchedule();

		subjectForFacultyMasterRotationSchedule = configuration.subjectForFacultyMasterRotationSchedule();
		bodyForFacultyMasterRotationSchedule = configuration.bodyForFacultyMasterRotationSchedule();
		
		subjectForPAUserMasterRotationSchedule = configuration.subjectForPAUserMasterRotationSchedule();
		bodyForPAUserMasterRotationSchedule = configuration.bodyForPAUserMasterRotationSchedule();
		
		subjectForECMemberMasterRotationSchedule = configuration.subjectForECMemberMasterRotationSchedule();
		bodyForECMemberMasterRotationSchedule = configuration.bodyForECMemberMasterRotationSchedule();
	}
	
	private volatile OmsbMasterRotationScheduleEmailConfiguration configuration;

	private static String bodyForTraineeMasterRotationSchedule;
	
	private static String subjectForTraineeMasterRotationSchedule;
	
	private static String subjectForFacultyMasterRotationSchedule;
	
	private static String bodyForFacultyMasterRotationSchedule;
	
	private static String subjectForPAUserMasterRotationSchedule;
	
	private static String bodyForPAUserMasterRotationSchedule;
	
	private static String subjectForECMemberMasterRotationSchedule;
	
	private static String bodyForECMemberMasterRotationSchedule;
	
	
}

package gov.omsb.email.config.configuration.action;

import com.liferay.configuration.admin.display.ConfigurationFormRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.config.configuration.OmsbMasterRotationScheduleEmailConfiguration;
import gov.omsb.email.config.constants.EmailConfigurationConstants;

@Component(immediate = true, service = ConfigurationFormRenderer.class)
public class OmsbMasterRotationScheduleEmailConfigurationFormRenderer implements ConfigurationFormRenderer {

	public static final String CLASS_NAME = OmsbMasterRotationScheduleEmailConfiguration.class.getName();
	
	@Override
	public String getPid() {
		return CLASS_NAME;
	}

	@Override
	public Map<String, Object> getRequestParameters(HttpServletRequest httpServletRequest) {
		
		Map<String, Object> params = new HashMap<>();
		
		
		Map<Locale, String> subjectForTraineeMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_TRAINEE_MASTER_ROTATION_SCHEDULE);
	    Map<Locale, String> bodyForTraineeMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_TRAINEE_MASTER_ROTATION_SCHEDULE);
	    
	    Map<Locale, String> subjectForPAUserMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_PA_USER_MASTER_ROTATION_SCHEDULE);
	    Map<Locale, String> bodyForPAUserMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_PA_USER_MASTER_ROTATION_SCHEDULE);
	    
	    Map<Locale, String> subjectForECMemberMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_EC_MEMBER_MASTER_ROTATION_SCHEDULE);
	    Map<Locale, String> bodyForECMemberMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_EC_MEMBER_MASTER_ROTATION_SCHEDULE);
	    
	    Map<Locale, String> subjectForFacultyMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_FACULTY_MASTER_ROTATION_SCHEDULE);
	    Map<Locale, String> bodyForFacultyMasterRotationScheduleMap = LocalizationUtil.getLocalizationMap(httpServletRequest, EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_FACULTY_MASTER_ROTATION_SCHEDULE);
	    
	    
	    
	    LocalizedValuesMap traineeMasterRotationSchedulSubjectLocalizedValuesMap = new LocalizedValuesMap();
	    LocalizedValuesMap traineeMasterRotationSchedulBodyLocalizedValuesMap = new LocalizedValuesMap();
	    
	    LocalizedValuesMap paUserMasterRotationScheduleSubjectLocalizedValuesMap = new LocalizedValuesMap();
	    LocalizedValuesMap paUserMasterRotationScheduleBodyLocalizedValuesMap = new LocalizedValuesMap();
	    
	    LocalizedValuesMap ecMemberMasterRotationScheduleSubjectLocalizedValuesMap = new LocalizedValuesMap();
	    LocalizedValuesMap ecMemberMasterRotationScheduleBodyLocalizedValuesMap = new LocalizedValuesMap();
	    
	    LocalizedValuesMap facultyMasterRotationScheduleSubjectLocalizedValuesMap = new LocalizedValuesMap();
	    LocalizedValuesMap facultyMasterRotationScheduleBodyLocalizedValuesMap = new LocalizedValuesMap();

	    
	    for (Map.Entry<Locale, String> traineeMastersubjectEntry : subjectForTraineeMasterRotationScheduleMap.entrySet()) {
	    	traineeMasterRotationSchedulSubjectLocalizedValuesMap.put(traineeMastersubjectEntry.getKey(), traineeMastersubjectEntry.getValue());
	    }
	    for (Map.Entry<Locale, String> traineeMasterbodyEntry : bodyForTraineeMasterRotationScheduleMap.entrySet()) {
	    	traineeMasterRotationSchedulBodyLocalizedValuesMap.put(traineeMasterbodyEntry.getKey(), traineeMasterbodyEntry.getValue());
	    }
	    
	    for (Map.Entry<Locale, String> paUserMastersubjectEntry : subjectForPAUserMasterRotationScheduleMap.entrySet()) {
	    	paUserMasterRotationScheduleSubjectLocalizedValuesMap.put(paUserMastersubjectEntry.getKey(), paUserMastersubjectEntry.getValue());
	    }
	    for (Map.Entry<Locale, String> paUserMasterbodyEntry : bodyForPAUserMasterRotationScheduleMap.entrySet()) {
	    	paUserMasterRotationScheduleBodyLocalizedValuesMap.put(paUserMasterbodyEntry.getKey(), paUserMasterbodyEntry.getValue());
	    }
	    
	    for (Map.Entry<Locale, String> ecMemberMastersubjectEntry : subjectForECMemberMasterRotationScheduleMap.entrySet()) {
	    	ecMemberMasterRotationScheduleSubjectLocalizedValuesMap.put(ecMemberMastersubjectEntry.getKey(), ecMemberMastersubjectEntry.getValue());
	    }
	    for (Map.Entry<Locale, String> ecMemberMasterbodyEntry : bodyForECMemberMasterRotationScheduleMap.entrySet()) {
	    	ecMemberMasterRotationScheduleBodyLocalizedValuesMap.put(ecMemberMasterbodyEntry.getKey(), ecMemberMasterbodyEntry.getValue());
	    }
	    
	    for (Map.Entry<Locale, String> facultyMastersubjectEntry : subjectForFacultyMasterRotationScheduleMap.entrySet()) {
	    	facultyMasterRotationScheduleSubjectLocalizedValuesMap.put(facultyMastersubjectEntry.getKey(), facultyMastersubjectEntry.getValue());
	    }
	    for (Map.Entry<Locale, String> facultyrotationMasterbodyEntry : bodyForFacultyMasterRotationScheduleMap.entrySet()) {
	    	facultyMasterRotationScheduleBodyLocalizedValuesMap.put(facultyrotationMasterbodyEntry.getKey(), facultyrotationMasterbodyEntry.getValue());
	    }
	    
	    
	    
	    
	    String subjectForTraineeMasterRotationScheduleXML = LocalizationUtil.getXml(traineeMasterRotationSchedulSubjectLocalizedValuesMap, EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_TRAINEE_MASTER_ROTATION_SCHEDULE);
	    String bodyForTraineeMasterRotationScheduleXML = LocalizationUtil.getXml(traineeMasterRotationSchedulBodyLocalizedValuesMap, EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_TRAINEE_MASTER_ROTATION_SCHEDULE);
	    
	    String subjectForPaUserMasterRotationScheduleXML = LocalizationUtil.getXml(paUserMasterRotationScheduleSubjectLocalizedValuesMap, EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_PA_USER_MASTER_ROTATION_SCHEDULE);
	    String bodyForPaUserMasterRotationScheduleXML = LocalizationUtil.getXml(paUserMasterRotationScheduleBodyLocalizedValuesMap, EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_PA_USER_MASTER_ROTATION_SCHEDULE);
	    
	    String subjectForEcMemberMasterRotationScheduleXML = LocalizationUtil.getXml(ecMemberMasterRotationScheduleSubjectLocalizedValuesMap, EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_EC_MEMBER_MASTER_ROTATION_SCHEDULE);
	    String bodyForEcMemberMasterRotationScheduleXML = LocalizationUtil.getXml(ecMemberMasterRotationScheduleBodyLocalizedValuesMap, EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_EC_MEMBER_MASTER_ROTATION_SCHEDULE);
	    
	    String subjectForFacultyMasterRotationScheduleXML = LocalizationUtil.getXml(facultyMasterRotationScheduleSubjectLocalizedValuesMap, EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_FACULTY_MASTER_ROTATION_SCHEDULE);
	    String bodyForFacultyMasterRotationScheduleXML = LocalizationUtil.getXml(facultyMasterRotationScheduleBodyLocalizedValuesMap, EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_FACULTY_MASTER_ROTATION_SCHEDULE);
	    
	    
	    params.put(EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_TRAINEE_MASTER_ROTATION_SCHEDULE, subjectForTraineeMasterRotationScheduleXML);
		params.put(EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_TRAINEE_MASTER_ROTATION_SCHEDULE, bodyForTraineeMasterRotationScheduleXML);
		
		params.put(EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_PA_USER_MASTER_ROTATION_SCHEDULE, subjectForPaUserMasterRotationScheduleXML);
		params.put(EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_PA_USER_MASTER_ROTATION_SCHEDULE, bodyForPaUserMasterRotationScheduleXML);
		
		params.put(EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_EC_MEMBER_MASTER_ROTATION_SCHEDULE, subjectForEcMemberMasterRotationScheduleXML);
		params.put(EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_EC_MEMBER_MASTER_ROTATION_SCHEDULE, bodyForEcMemberMasterRotationScheduleXML);
		
		params.put(EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_FACULTY_MASTER_ROTATION_SCHEDULE, subjectForFacultyMasterRotationScheduleXML);
		params.put(EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_FACULTY_MASTER_ROTATION_SCHEDULE, bodyForFacultyMasterRotationScheduleXML);
		
		_logger.debug("************** setting subject = " + subjectForTraineeMasterRotationScheduleXML);
		_logger.debug("************** setting body = " + bodyForTraineeMasterRotationScheduleXML);		
		
		return params;
		
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		
		String subjectForTraineeMasterRotationScheduleXML = OmsbMasterRotationScheduleEmailConfigurationAction.subjectForTraineeMasterRotationScheduleXML();
	    String bodyForTraineeMasterRotationScheduleXML = OmsbMasterRotationScheduleEmailConfigurationAction.bodyForTraineeMasterRotationScheduleXML();
	    	
	    String subjectForPaUserMasterRotationScheduleXML = OmsbMasterRotationScheduleEmailConfigurationAction.subjectForPAUserMasterRotationScheduleXML();
	    String bodyForPaUserMasterRotationScheduleXML = OmsbMasterRotationScheduleEmailConfigurationAction.bodyForPAUserMasterRotationScheduleXML();
	    
	    String subjectForEcMemberMasterRotationScheduleXML = OmsbMasterRotationScheduleEmailConfigurationAction.subjectForECMemberMasterRotationScheduleXML();
	    String bodyForEcMemberMasterRotationScheduleXML = OmsbMasterRotationScheduleEmailConfigurationAction.bodyForECMemberMasterRotationScheduleXML();
	    
	    String subjectForFacultyMasterRotationScheduleXML = OmsbMasterRotationScheduleEmailConfigurationAction.subjectForFacultyMasterRotationScheduleXML();
	    String bodyForFacultyMasterRotationScheduleXML = OmsbMasterRotationScheduleEmailConfigurationAction.bodyForFacultyMasterRotationScheduleXML();
	    
	    
	    
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_TRAINEE_MASTER_ROTATION_SCHEDULE, subjectForTraineeMasterRotationScheduleXML);
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_TRAINEE_MASTER_ROTATION_SCHEDULE, bodyForTraineeMasterRotationScheduleXML);
		
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_PA_USER_MASTER_ROTATION_SCHEDULE, subjectForPaUserMasterRotationScheduleXML);
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_PA_USER_MASTER_ROTATION_SCHEDULE, bodyForPaUserMasterRotationScheduleXML);
		
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_EC_MEMBER_MASTER_ROTATION_SCHEDULE, subjectForEcMemberMasterRotationScheduleXML);
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_EC_MEMBER_MASTER_ROTATION_SCHEDULE, bodyForEcMemberMasterRotationScheduleXML);
		
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG__FIELD_SUBJECT_FOR_FACULTY_MASTER_ROTATION_SCHEDULE, subjectForFacultyMasterRotationScheduleXML);
		httpServletRequest.setAttribute(EmailConfigurationConstants.CONFIG__FIELD_BODY_FOR_FACULTY_MASTER_ROTATION_SCHEDULE, bodyForFacultyMasterRotationScheduleXML);
		
		
		
		
		
		
		_logger.debug("************** getting subject = "+subjectForTraineeMasterRotationScheduleXML);
		_logger.debug("************** getting body = "+bodyForTraineeMasterRotationScheduleXML);

		jspRenderer.renderJSP(servletContext, httpServletRequest, httpServletResponse, EmailConfigurationConstants.CONFIG_MASTER_ROTATION_EMAIL_JSP);
	}
	
	@Reference(target = "(osgi.web.symbolicname=omsb.email.configuration)", unbind = "-")
	private ServletContext servletContext;

	@Reference
	private JSPRenderer jspRenderer;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbApproveSharedRotationEmailConfigurationFormRenderer.class);

}

package gov.omsb.email.config.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-email-configuration", 
scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.email.config.configuration.OmsbMasterRotationScheduleEmailConfiguration", 
localization = "content/Language",name="master-rotation-schedule-email-configuration")
public interface OmsbMasterRotationScheduleEmailConfiguration {

	
	@AD(required = false, deflt="")
	public String subjectForTraineeMasterRotationSchedule();

	@AD(required = false, deflt="" )
	public String bodyForTraineeMasterRotationSchedule();
	
	@AD(required = false, deflt="")
	public String subjectForFacultyMasterRotationSchedule();
	
	@AD(required = false, deflt="")
	public String bodyForFacultyMasterRotationSchedule(); 
	
	@AD(required = false, deflt="")
	public String subjectForPAUserMasterRotationSchedule();
	
	@AD(required = false, deflt="")
	public String bodyForPAUserMasterRotationSchedule();
	
	@AD(required = false, deflt="")
	public String subjectForECMemberMasterRotationSchedule();
	
	@AD(required = false, deflt="")
	public String bodyForECMemberMasterRotationSchedule();
	
}

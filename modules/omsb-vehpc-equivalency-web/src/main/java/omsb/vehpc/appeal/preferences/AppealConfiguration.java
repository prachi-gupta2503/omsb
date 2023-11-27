package omsb.vehpc.appeal.preferences;

import aQute.bnd.annotation.metatype.Meta;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Meta.OCD(id = OmsbVehpcEquivalencyWebPortletKeys.APPEAL_CONFIGURATION_ID,
name= "Appeal Configurations")
public interface AppealConfiguration {

	@Meta.AD(
	        deflt = "60",
	        required = false
	    )
	    public int appealValidity();
	
	
	@Meta.AD(
	        required = false
	    )
	    public int showEquivalencyCertificate();
	
	@Meta.AD(
	        required = false
	    )
	    public int showEquivalencyLevel();
	
}

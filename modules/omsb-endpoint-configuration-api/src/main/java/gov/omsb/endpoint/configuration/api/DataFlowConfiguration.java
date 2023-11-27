package gov.omsb.endpoint.configuration.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

/**
 * @author TusharT
 */
@ExtendedObjectClassDefinition(
		category = "omsb-configuration",
		scope = Scope.COMPANY
		)

@OCD(
		id = "gov.omsb.endpoint.configuration.api.DataFlowConfiguration",
		localization = "content/language",
		name = "DataFlow"
		)
public interface DataFlowConfiguration {
	
	/**
	 * @author TusharT
	 * @return This method returns the auth token URL.
	 */
	@AD(deflt = "https://tokenservice-uat.dfgateway.com/token", name = "Auth Token URL", description = "This is for authentication token", required = false)
	public String authTokenURL();
	
	
	/**
	 * @author TusharT
	 * @return This method returns the auth token username.
	 */
	@AD(deflt = "adapter-api", name = "Auth Token Username", description = "This is for authentication token username", required = false)
	public String authTokenUserName();
	
	
	/**
	 * @author TusharT
	 * @return This method returns the auth token password.
	 */
	@AD(deflt = "", name = "Auth Token Password", description = "This is for authentication token password", required = false)
	public String authTokenPassword();
	
	
	/**
	 * @author TusharT
	 * @return This method returns the case details URL.
	 */
	@AD(deflt = "uat-dfomsb.dfgateway.com/cases/{case-number}", name = "Case Detail URL", description = "This is to get the case details", required = false)
	public String caseDetailURL();
	
	
	/**
	 * @author TusharT
	 * @return This method returns the doc response URL.
	 */
	@AD(deflt = "uat-dfomsb.dfgateway.com/documents/{case-number}/{doc-id}", name = "Doc Response URL", description = "This is to get the doc response", required = false)
	public String docResponeURL();
	
	
	/**
	 * @author TusharT
	 * @return This method returns the case report URL.
	 */
	@AD(deflt = "uat-dfomsb.dfgateway.com/reports/{case-number}", name = "Case Report URL", description = "This is to get the case report", required = false)
	public String caseReportURL();

}


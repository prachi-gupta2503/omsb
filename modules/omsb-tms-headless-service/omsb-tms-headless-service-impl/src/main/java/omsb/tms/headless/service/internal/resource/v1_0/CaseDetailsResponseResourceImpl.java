package omsb.tms.headless.service.internal.resource.v1_0;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import gov.omsb.common.api.OMSBCommonApi;
import omsb.tms.headless.service.dto.v1_0.CaseDetails;
import omsb.tms.headless.service.dto.v1_0.CaseDetailsResponse;
import omsb.tms.headless.service.resource.v1_0.CaseDetailsResponseResource;

/**
 * @author AftabA
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/case-details-response.properties",
	scope = ServiceScope.PROTOTYPE, service = CaseDetailsResponseResource.class
)
public class CaseDetailsResponseResourceImpl
	extends BaseCaseDetailsResponseResourceImpl {
	
	@Override
	public CaseDetailsResponse addData(CaseDetails caseDetails) throws Exception {
		logger.info("caseDetails ?? " + caseDetails);
		if (Validator.isNotNull(caseDetails.getCaseNumber()) && !caseDetails.getCaseNumber().isEmpty()) {
			omsbCommonApi.addCaseDetail(caseDetails.getCaseNumber());
		}
		
		CaseDetailsResponse response = new CaseDetailsResponse();
		response.setMessage(" ");
		response.setStatus("SUCCESS");
		return response;
	}
	
	@Reference
	private OMSBCommonApi omsbCommonApi; 
	private static final Log logger = LogFactoryUtil.getLog(CaseDetailsResponseResourceImpl.class);
}
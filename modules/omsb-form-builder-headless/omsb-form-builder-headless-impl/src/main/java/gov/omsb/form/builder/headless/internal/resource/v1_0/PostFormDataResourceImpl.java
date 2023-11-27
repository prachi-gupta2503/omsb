package gov.omsb.form.builder.headless.internal.resource.v1_0;

import gov.omsb.form.builder.headless.dto.v1_0.FormDataResponse;
import gov.omsb.form.builder.headless.dto.v1_0.PostFormDataRequest;
import gov.omsb.form.builder.headless.resource.v1_0.PostFormDataResource;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Niddhi Thacker
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/post-form-data.properties",
	scope = ServiceScope.PROTOTYPE, service = PostFormDataResource.class
)
public class PostFormDataResourceImpl
	extends BasePostFormDataResourceImpl {
	
	private static final Log log = LogFactoryUtil.getLog(PostFormDataResourceImpl.class);
	@Override
	public FormDataResponse postFormData(PostFormDataRequest postFormDataRequest) throws Exception {
		log.info("### Post Form Data ###");
		FormDataResponse dynamicFormDataResponse = new FormDataResponse();
		String firstName = postFormDataRequest.getFirstName();
		log.info("First Name: "+firstName);
		String lastName = postFormDataRequest.getLastName();
		log.info("Last Name: "+lastName);
		
		if(Validator.isNotNull(firstName) || Validator.isNotNull(lastName)) {
			dynamicFormDataResponse.setMessage(SUCCESS);
			dynamicFormDataResponse.setStatus(SUCCESS);
		} else {
			dynamicFormDataResponse.setMessage(NO_RESULTS_FOUND_MESSAGE);
			dynamicFormDataResponse.setStatus(FAILURE_STATUS);
		}
		return dynamicFormDataResponse;
	}
	public static final String SUCCESS = "success";
	public static final String FAILURE_STATUS = "Failure";
	public static final String NO_RESULTS_FOUND_MESSAGE = "No results found";
}
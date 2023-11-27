package gov.omsb.form.builder.headless.internal.resource.v1_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import gov.omsb.form.builder.headless.dto.v1_0.DeleteFormRecordsRequest;
import gov.omsb.form.builder.headless.dto.v1_0.FormDataResponse;
import gov.omsb.form.builder.headless.resource.v1_0.DeleteFormRecordsResource;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.service.FormDefinitionLocalService;

/**
 * @author Jinal Patel
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/delete-form-records.properties",
	scope = ServiceScope.PROTOTYPE, service = DeleteFormRecordsResource.class
)
public class DeleteFormRecordsResourceImpl
	extends BaseDeleteFormRecordsResourceImpl {
	
	private static final Log log = LogFactoryUtil.getLog(DeleteFormRecordsResourceImpl.class);
	
	public FormDataResponse deleteFormRecords(DeleteFormRecordsRequest deleteFormRecordsRequest) throws Exception {
		log.info("### Deleting Form Records ###");
		boolean isRecordsDeleted = false;
		FormDataResponse deleteFormDataResponse = new FormDataResponse();
		long formDefinitionId = deleteFormRecordsRequest.getFormDefinitionId();
		log.info("Form Definition Id: " + formDefinitionId);
		Long[] recordIds = deleteFormRecordsRequest.getRecordIds();
		log.info("Record Ids: " + recordIds);
		FormDefinition formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
		if (Validator.isNotNull(formDefinition)) {
			String tableName = FormDataUtil.formatFormName(formDefinition.getFormName());
			if (Validator.isNotNull(tableName) && Validator.isNotNull(recordIds)) {
				List<Long> test = Arrays.asList(recordIds);
				String recordIdStr = test.stream().map(String::valueOf)
						  .collect(Collectors.joining(","));
				isRecordsDeleted = formDefinitionLocalService.deleteFormRecords(tableName, recordIdStr);
			}
		}
		if(isRecordsDeleted) {
			deleteFormDataResponse.setMessage(SUCCESS);
			deleteFormDataResponse.setStatus(SUCCESS);
		} else {
			deleteFormDataResponse.setMessage(NO_RESULTS_FOUND_MESSAGE);
			deleteFormDataResponse.setStatus(FAILURE_STATUS);
		}
		return deleteFormDataResponse;
	}
	
	public static final String SUCCESS = "success";
	public static final String FAILURE_STATUS = "Failure";
	public static final String NO_RESULTS_FOUND_MESSAGE = "No results found";

	@Reference
	private FormDefinitionLocalService formDefinitionLocalService;
}
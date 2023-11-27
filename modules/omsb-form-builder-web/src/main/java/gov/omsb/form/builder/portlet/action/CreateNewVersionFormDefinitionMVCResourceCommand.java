package gov.omsb.form.builder.portlet.action;

import static gov.omsb.form.builder.constants.FormBuilderConstants.ERROR;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FORM_DEFINITION_ID;
import static gov.omsb.form.builder.constants.FormBuilderConstants.STATUS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.SUCCESS;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.portlet.util.FormConfigurationUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
	        "mvc.command.name=" + MVCCommandNames.NEW_VERSION_FORM_DEFINITION
	    }, 
	    service = MVCResourceCommand.class
)

public class CreateNewVersionFormDefinitionMVCResourceCommand extends BaseMVCResourceCommand {
	private static final Log log = LogFactoryUtil.getLog(CreateNewVersionFormDefinitionMVCResourceCommand.class);

	@Reference
	private FormDefinitionLocalService formDefinitionLocalService;
	
	@Reference
	private FormConfigurationUtil formConfigurationUtil;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		long formDefinitionId = ParamUtil.getLong(resourceRequest, FORM_DEFINITION_ID);
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;
		try {
			writer = resourceResponse.getWriter();
			if(formDefinitionId > 0) {
				FormDefinition formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
				if(Validator.isNotNull(formDefinition)) {
					if(Validator.isNotNull(formDefinition.getFormVersion())) {
						formDefinition = formConfigurationUtil.createNewFormVersion(formDefinition);
					}
					responseObj.put(FORM_DEFINITION_ID, formDefinition.getFormDefinitionId());
					responseObj.put(STATUS, SUCCESS);
				}
			}else {
				responseObj.put(STATUS, ERROR);
			}
		} catch (Exception e) {
			responseObj.put(STATUS, ERROR);
		}finally {
			if(Validator.isNotNull(writer)) {
				writer.write(responseObj.toString());
				writer.close();
			}
			log.info("CreateNewVersionFormDefinitionMVCResourceCommand >>> doServeResource >>>  Data retrieved successfully");
		}
		
	}
}

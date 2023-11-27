package gov.omsb.form.builder.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.portlet.util.FormConfigurationUtil;
import gov.omsb.form.builder.portlet.util.FormUtil;
import gov.omsb.form.builder.portlet.util.RangeOptionMasterUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalServiceUtil;
import gov.omsb.form.builder.service.RangeOptionMasterLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
	        "mvc.command.name=" + MVCCommandNames.FORM_CONFIGURATION_ADD
	    }, 
	    service = MVCRenderCommand.class
)
public class AddEditConfigurationMVCRenderCommand implements MVCRenderCommand{
	
	private static final Log log = LogFactoryUtil.getLog(AddEditConfigurationMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		new RangeOptionMasterUtil(rangeOptionMasterLocalService);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject rolesJson = _formConfigurationUtil.getFormBuilderRoles(themeDisplay);
		request.setAttribute("rolesJson", rolesJson);
		request.setAttribute("secretPassphrase", FormBuilderConstants.SECRET_PASS_PHRASE);
		long formDefinitionId = ParamUtil.getLong(request, "selectedFormDefinitionId",0);
		if(Validator.isNotNull(formDefinitionId)) {
			request.setAttribute("formDefinitionId", formDefinitionId);
		}
		JSONArray workflowDefinitionArr = FormUtil.getWorkflowDefinitions(request, themeDisplay);
		request.setAttribute(FormBuilderConstants.WORKFLOW_DEFINITIONS, workflowDefinitionArr);
		FormDefinition formDefinition;
		if(Validator.isNotNull(formDefinitionId)) {
			try {
				formDefinition = FormDefinitionLocalServiceUtil.getFormDefinition(Long.valueOf(formDefinitionId));
				if(Validator.isNotNull(formDefinition)) {
					request.setAttribute(FormBuilderConstants.WORKFLOW_STATUS, formDefinition.getStatus());
				}
			} catch (PortalException e) {
				log.error("Error while fetching form definition " + e.getMessage(), e);
			}
		}

		JSONArray rangeOptionNameArr = RangeOptionMasterUtil.getRangeOptionMasterArr();
		if(Validator.isNotNull(rangeOptionNameArr) && rangeOptionNameArr.length() > 0) {
			try {
				String encodedRangeOptionNameArr = new String(java.util.Base64.getEncoder().encode(rangeOptionNameArr.toString().getBytes()), "UTF-8");
				request.setAttribute(FormBuilderConstants.RANGE_OPTION_DATA_ARR, encodedRangeOptionNameArr);
			} catch (IOException e) {
				log.error("error occured while encoding :"  + e.getMessage(), e);
			}
		}
		
		return FormBuilderConstants.ADD_FORM_CONFIGURATION_JSP;
	}

	@Reference
	private FormConfigurationUtil _formConfigurationUtil;
	
	@Reference
	private RangeOptionMasterLocalService rangeOptionMasterLocalService;
	
}

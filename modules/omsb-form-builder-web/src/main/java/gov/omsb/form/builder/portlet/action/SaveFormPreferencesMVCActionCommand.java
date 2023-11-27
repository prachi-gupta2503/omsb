package gov.omsb.form.builder.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.portlet.util.FormRendererUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalService;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
				"mvc.command.name=" + MVCCommandNames.SAVE_SELECTED_FORM_ACTION 
				},
		service = MVCActionCommand.class
	)
public class SaveFormPreferencesMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String formName = ParamUtil.getString(actionRequest, FormBuilderConstants.FORM_NAME);
		String formVersion = ParamUtil.getString(actionRequest, FormBuilderConstants.FORM_VERSION);
		String kaleoDefinition = ParamUtil.getString(actionRequest, FormBuilderConstants.KALEO_DEFINITION);
		String selectedEmailTemplateId = ParamUtil.getString(actionRequest, FormBuilderConstants.EMAIL_TEMPLATE);
		log.info("selectedEmailTemplateId :: "+selectedEmailTemplateId);

		FormDefinition formDefinition = FormRendererUtil.getFormDefinitionByFormNameAndFormVersion(formName,
				formVersion);

		String ddmFormDfinitionString = StringPool.BLANK;
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		JSONArray jsonFieldsArray = JSONFactoryUtil.createJSONArray();

		PortletPreferences preferences = actionRequest.getPreferences();

		if (Validator.isNotNull(formDefinition)) {
			preferences.setValue(FormBuilderConstants.FORM_DEFINITION_ID,
					String.valueOf(formDefinition.getFormDefinitionId()));

			ddmFormDfinitionString = formDefinition.getFormConfig();

			jsonObject = FormRendererUtil.getFormConfigJSONObject(ddmFormDfinitionString);

			jsonFieldsArray = FormRendererUtil.getFormFieldsJSONArray(jsonObject);

		}
		if(Validator.isNotNull(selectedEmailTemplateId)) {
			preferences.setValue(FormBuilderConstants.SELECTED_EMAIL_TEMPLATE_ID, selectedEmailTemplateId);
		}

		preferences.setValue(FormBuilderConstants.FORM_NAME, formName);
		preferences.setValue(FormBuilderConstants.FORM_VERSION, formVersion);
		preferences.setValue(FormBuilderConstants.WORKFLOW_DEFINITION, kaleoDefinition);

		preferences.store();

		actionRequest.setAttribute(FormBuilderConstants.DDM_FORM_DEFINITION, jsonObject);
		actionRequest.setAttribute(FormBuilderConstants.JSON_FIELDS_ARRAY, jsonFieldsArray);
		actionResponse.getRenderParameters().setValue(FormBuilderConstants.JSP_PAGE,
				FormBuilderConstants.VIEW_DISPLAY_JSP);

	}

	Log log = LogFactoryUtil.getLog(SaveFormPreferencesMVCActionCommand.class.getName());

	@Reference
	FormDefinitionLocalService formDefinitionLocalService;

}
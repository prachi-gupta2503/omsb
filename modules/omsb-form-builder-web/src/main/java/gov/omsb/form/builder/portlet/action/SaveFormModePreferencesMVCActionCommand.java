package gov.omsb.form.builder.portlet.action;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
		"mvc.command.name=" + MVCCommandNames.SAVE_SELECTED_MODE_ACTION
}, service = MVCActionCommand.class)
public class SaveFormModePreferencesMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String formMode = ParamUtil.getString(actionRequest, FormBuilderConstants.FORM_MODE);
		PortletPreferences preferences = actionRequest.getPreferences();
		
		log.info("Form Mode : " + formMode);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		JSONArray jsonFieldsArray = JSONFactoryUtil.createJSONArray();

		actionRequest.setAttribute(FormBuilderConstants.DDM_FORM_DEFINITION, jsonObject);
		actionRequest.setAttribute(FormBuilderConstants.JSON_FIELDS_ARRAY, jsonFieldsArray);
		actionRequest.setAttribute(FormBuilderConstants.IS_REQUIRED_PAGE_RELOAD, true);

		preferences.setValue(FormBuilderConstants.FORM_MODE, formMode);
		preferences.store();
		
		if (formMode.equalsIgnoreCase(FormBuilderConstants.CONFIG)) {
			actionResponse.getRenderParameters().setValue(FormBuilderConstants.JSP_PAGE,
					FormBuilderConstants.FORM_ACTIONS_JSP);
		} else if (formMode.equalsIgnoreCase(FormBuilderConstants.VIEW) || formMode.equalsIgnoreCase(FormBuilderConstants.PREVIEW)) {
			actionResponse.getRenderParameters().setValue(FormBuilderConstants.JSP_PAGE,
					FormBuilderConstants.VIEW_DISPLAY_JSP);
		}

	}

	Log log = LogFactoryUtil.getLog(SaveFormModePreferencesMVCActionCommand.class.getName());

}
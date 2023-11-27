package gov.omsb.form.builder.portlet.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.service.FormDefinitionLocalServiceUtil;

public class FormRendererUtil {

	public static FormDefinition getFormDefinitionByFormNameAndFormVersion(String formName, String formVersion) {

		FormDefinition formDefinition = null;

		DynamicQuery dynamicQuery = FormDefinitionLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName(FormBuilderConstants.FORM_NAME).eq(formName));
		dynamicQuery.add(PropertyFactoryUtil.forName(FormBuilderConstants.FORM_VERSION).eq(formVersion));
		List<FormDefinition> formDefinitions = FormDefinitionLocalServiceUtil.dynamicQuery(dynamicQuery);

		if (formDefinitions.size() > 0) {
			formDefinition = formDefinitions.get(0);
		}

		return formDefinition;

	}

	public static JSONObject getFormConfigJSONObject(String formConfig) {

		JSONObject jsonConfigObj = null;
		try {
			jsonConfigObj = JSONFactoryUtil.createJSONObject(formConfig);
		} catch (JSONException e) {
			_log.error(e.getMessage());
		}
		return jsonConfigObj;

	}

	public static JSONArray getFormFieldsJSONArray(JSONObject jsonObj) {

		JSONArray jsonFieldsArray = null;
		try {
			jsonFieldsArray = JSONFactoryUtil.createJSONArray(jsonObj.getString(FormBuilderConstants.FIELDS).replace("'", "`"));
		} catch (JSONException e) {
			_log.info(e.getMessage());
		}

		return jsonFieldsArray;

	}

	static Log _log = LogFactoryUtil.getLog(FormRendererUtil.class.getName());

}

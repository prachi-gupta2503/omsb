package gov.omsb.form.builder.portlet.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.service.FormDefinitionLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
		"mvc.command.name=" + MVCCommandNames.GET_FORM_VERSIONS }, service = MVCResourceCommand.class)
public class FetchFormVersionsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("### Fetching Form Version ###");
		String formName = ParamUtil.getString(resourceRequest, FormBuilderConstants.FORM_NAME);
		DynamicQuery dynamicQuery = formDefinitionLocalService.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName(FormBuilderConstants.FORM_NAME).eq(formName));
		List<FormDefinition> formDefinitions = formDefinitionLocalService.dynamicQuery(dynamicQuery);
		List<FormDefinition> modifiableList = new ArrayList<>(formDefinitions);
		Collections.sort(modifiableList, Comparator.comparing(FormDefinition::getFormVersion));
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObject = null;
		for (FormDefinition formDefinition : modifiableList) {
			int workflowStatus = formDefinition.getStatus();
			if(workflowStatus == WorkflowConstants.STATUS_APPROVED) {
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put(FormBuilderConstants.FORM_DEFINITION_ID, formDefinition.getFormDefinitionId());
				jsonObject.put(FormBuilderConstants.FORM_VERSION, formDefinition.getFormVersion());
				jsonArray.put(jsonObject);
			}
		}
		resourceResponse.getWriter().print(jsonArray);
	}
	Log log = LogFactoryUtil.getLog(FetchFormVersionsMVCResourceCommand.class.getName());

	@Reference
	FormDefinitionLocalService formDefinitionLocalService;

}
package gov.omsb.form.builder.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;
import com.liferay.portal.workflow.definition.link.update.handler.WorkflowDefinitionLinkUpdateHandler;
import com.liferay.portal.workflow.definition.link.update.handler.WorkflowDefinitionLinkUpdateHandlerRegistryUtil;

import java.util.List;

import javax.portlet.RenderRequest;

import gov.omsb.form.builder.constants.FormBuilderConstants;

public class FormUtil {
	
	private static final Log log = LogFactoryUtil.getLog(FormUtil.class);
	
	private static WorkflowDefinitionLinkLocalService _workflowDefinitionLinkLocalService;
	
	public FormUtil(WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService){
		_workflowDefinitionLinkLocalService = workflowDefinitionLinkLocalService;
	}
	
	public static JSONArray getWorkflowDefinitions(RenderRequest request, ThemeDisplay themeDisplay){
		JSONArray workflowDefinitionArr = JSONFactoryUtil.createJSONArray();
		JSONObject workflowDefinitionObj = null;
		List<WorkflowDefinition> workflowDefinitions = null;
		try {
			workflowDefinitions = WorkflowDefinitionManagerUtil.getActiveWorkflowDefinitions(themeDisplay.getCompanyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					WorkflowComparatorFactoryUtil.getDefinitionNameComparator(true));
			for(WorkflowDefinition workflowDefinition: workflowDefinitions) {
				workflowDefinitionObj = JSONFactoryUtil.createJSONObject();
				workflowDefinitionObj.put(FormBuilderConstants.VALUE, workflowDefinition.getName()+StringPool.AT+workflowDefinition.getVersion());
				workflowDefinitionObj.put(FormBuilderConstants.LABEL, workflowDefinition.getTitle(themeDisplay.getLanguageId()));
				
				workflowDefinitionArr.put(workflowDefinitionObj);
				log.info("Workflow Definition: "+workflowDefinition.getName());
			}
		} catch (WorkflowException e) {
			log.error("Error Occured while getting workflow definitions: "+e.getMessage());
		}
		return workflowDefinitionArr;
	}
	
	public static void addUpdatedWorkflowDefinitionLink(ThemeDisplay themeDisplay, long groupId, String className, String workflowDefinition) {
		WorkflowDefinitionLinkUpdateHandler workflowDefinitionLinkUpdateHandler = WorkflowDefinitionLinkUpdateHandlerRegistryUtil.getWorkflowDefinitionLinkUpdateHandler(className);

		if (workflowDefinitionLinkUpdateHandler != null) {
			workflowDefinitionLinkUpdateHandler.updatedWorkflowDefinitionLink(workflowDefinition);
		}

		if (Validator.isNotNull(className)) {
			try {
				_workflowDefinitionLinkLocalService.updateWorkflowDefinitionLink(
					themeDisplay.getUserId(), themeDisplay.getCompanyId(), groupId,
					className, 0, 0, workflowDefinition);
			} catch (PortalException e) {
				log.error("error occured while updating workflow definition link: "+e.getMessage());
			}
		}
	}
	
}

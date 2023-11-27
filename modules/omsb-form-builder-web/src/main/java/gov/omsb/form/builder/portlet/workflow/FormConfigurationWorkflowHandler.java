package gov.omsb.form.builder.portlet.workflow;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.portlet.util.FormConfigurationUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalService;

@Component(
	 property = {"model.class.name=gov.omsb.form.builder.model.FormDefinition"},
	 service = WorkflowHandler.class
	)

public class FormConfigurationWorkflowHandler extends BaseWorkflowHandler<FormDefinition>{

	private static final Log log = LogFactoryUtil.getLog(FormConfigurationWorkflowHandler.class);
	@Reference
	private FormConfigurationUtil formConfigurationUtil;
	
	private FormDefinitionLocalService formDefinitionLocalService;
	
	@Reference(unbind = "-")
	protected void setFormDefinitionService(FormDefinitionLocalService formDefinitionLocalService) {
		this.formDefinitionLocalService = formDefinitionLocalService;
	}

	@Override
	public String getClassName() {
		return FormDefinition.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return "FormDefinition";
	}
	
	@Override
	public String getTitle(long classPK, Locale locale) {
		try {
			FormDefinition formDefinition = formDefinitionLocalService.getFormDefinition(classPK);
			if (Validator.isNotNull(formDefinition)) {
				return formDefinition.getFormName();
			}
		}
		catch (Exception exception) {
			if (log.isWarnEnabled()) {
				log.warn(exception);
			}
		}

		return StringPool.BLANK;
	}
	
	 @Override 
	 public FormDefinition updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException { 
		 log.info("Updating Status of Workflow");
		 long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID)); 
		 long formDefinitionId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)); 
		 ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");
		 FormDefinition formDefinition = formConfigurationUtil.updateStatus(userId, formDefinitionId, status, serviceContext); 
		 return formDefinition;
	 }
	 
	 
}

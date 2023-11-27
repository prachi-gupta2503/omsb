package gov.omsb.form.builder.portlet.workflow;

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
import gov.omsb.form.builder.model.FormRecordEntry;
import gov.omsb.form.builder.portlet.util.FormDataUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalService;
import gov.omsb.form.builder.service.FormRecordEntryLocalService;

@Component(
		 property = {"model.class.name=gov.omsb.form.builder.model.FormRecordEntry"},
		 service = WorkflowHandler.class
		)

public class FormRecordEntryWorkflowHandler extends BaseWorkflowHandler<FormRecordEntry>{

	private static final Log log = LogFactoryUtil.getLog(FormRecordEntryWorkflowHandler.class);

	@Reference
	private FormRecordEntryLocalService formRecordEntryLocalService;
	
	@Reference
	private FormDefinitionLocalService FormDefinitionLocalService;
	
	@Override
	public String getClassName() {
		return FormRecordEntry.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return "FormRecordEntry";
	}

	@Override
	public String getTitle(long classPK, Locale locale) {
		try {
			FormRecordEntry formRecordEntry = formRecordEntryLocalService.getFormRecordEntry(classPK);
			if (Validator.isNotNull(formRecordEntry)) {
				FormDefinition formDefinition = FormDefinitionLocalService.getFormDefinition(formRecordEntry.getFormDefinitionId());
				if(Validator.isNotNull(formDefinition)) {
					return formDefinition.getFormName();
				}
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
	public FormRecordEntry updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		log.info("Updating Status of Form Record Entry Workflow");
		 long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID)); 
		 long formRecordEntryId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)); 
		 ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");
		 FormRecordEntry formRecordEntry = FormDataUtil.updateStatus(userId, formRecordEntryId, status, serviceContext); 
		 return formRecordEntry;
	}
	
	
	 
	 
}

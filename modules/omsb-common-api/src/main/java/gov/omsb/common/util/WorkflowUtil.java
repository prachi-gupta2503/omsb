package gov.omsb.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

public class WorkflowUtil {
	
	private WorkflowUtil() {
		
	}

	public static WorkflowInstance getWorkflowInstace(String className, long classPK, long companyId, long groupId) {
		WorkflowInstance workflowInstance = null;
		WorkflowInstanceLink instanceLink;
		try {
			instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId,
					groupId, className, classPK);
			if (Validator.isNotNull(instanceLink)) {
				workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
						instanceLink.getWorkflowInstanceId());
			}
		} catch (PortalException e) {
			log.debug(e.getMessage());
		}

		return workflowInstance;
	}
	
	private static final Log log = LogFactoryUtil.getLog(WorkflowUtil.class.getName());
}

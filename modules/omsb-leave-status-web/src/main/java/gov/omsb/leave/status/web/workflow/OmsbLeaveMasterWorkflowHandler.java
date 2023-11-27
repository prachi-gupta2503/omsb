package gov.omsb.leave.status.web.workflow;

import com.liferay.counter.kernel.service.CounterLocalService;
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
import com.liferay.portal.kernel.workflow.WorkflowInstance;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.util.WorkflowUtil;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.LeaveTraineeMasterLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(property = { "model.class.name=gov.omsb.tms.model.LeaveMaster" }, service = WorkflowHandler.class)
public class OmsbLeaveMasterWorkflowHandler extends BaseWorkflowHandler<LeaveMaster> {

	private LeaveMasterLocalService leaveMasterLocalService;

	@Reference(unbind = "-")
	protected void setLeaveMasterService(LeaveMasterLocalService leaveMasterLocalService) {
		this.leaveMasterLocalService = leaveMasterLocalService;
	}

	@Override
	public String getClassName() {
		return LeaveMaster.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return "leaveMaster";
	}

	@Override
	public LeaveMaster updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {

		long leaveMasterId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
		leaveMasterLocalService.updateStatus(userId, leaveMasterId, status, serviceContext);

		return null;
	}
	
	@Override
	public String getNotificationLink(long workflowTaskId, ServiceContext serviceContext) throws PortalException {
		log.info("getNotificationLink method called..................");
		String redirectionURL = StringPool.BLANK;
		long entryClassPK = GetterUtil.getLong(serviceContext.getAttribute("entryClassPK"));
		try {
			WorkflowInstance workflowInstance = null;
			LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(entryClassPK);
			
			workflowInstance = WorkflowUtil.getWorkflowInstace(getClassName(), entryClassPK, leaveMaster.getCompanyId(), leaveMaster.getGroupId());
			if(Validator.isNotNull(workflowInstance)) {
				Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
				redirectionURL = GetterUtil.getString(workflowContext.get("viewDetailsUrl"));
				
				log.debug("redirection URL:::"+ redirectionURL);
			}
		}
		catch (Exception e) {
			log.info(e.getMessage());
		}
		
		return redirectionURL;
	}

	@Reference
	private LeaveTraineeMasterLocalService leaveTraineeMasterLocalService;

	@Reference
	private LeaveProgramMasterLocalService leaveProgramMasterLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbLeaveMasterWorkflowHandler.class.getName());

	@Reference
	private CounterLocalService counterLocalService;

}
package gov.omsb.tms.ecm.web.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowInstance;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.ecm.web.util.WorkflowUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.EcMemberRequestState;
import gov.omsb.tms.model.EcMemberRequestStatus;
import gov.omsb.tms.service.EcMemberRequestLocalServiceUtil;
import gov.omsb.tms.service.EcMemberRequestStateLocalServiceUtil;
import gov.omsb.tms.service.EcMemberRequestStatusLocalServiceUtil;

@Component(
	property = {
		"model.class.name=gov.omsb.tms.model.EcMemberRequest"
	},
	service = WorkflowHandler.class
)
public class EcMemberWorkflowHandler extends BaseWorkflowHandler<EcMemberRequest> {


	private static final Log LOGGER = LogFactoryUtil.getLog(EcMemberWorkflowHandler.class);
	
	
	@Override
	public String getClassName() {
		return EcMemberRequest.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return "ecMemberRequest";
	}
	
	@Override
	public String getNotificationLink(
			long workflowTaskId, ServiceContext serviceContext)
		throws PortalException {
		
		String viewUrl  =null;
		long entryClassPK = GetterUtil.getLong(serviceContext.getAttribute("entryClassPK"));
		EcMemberRequest req = EcMemberRequestLocalServiceUtil.getEcMemberRequest(entryClassPK);
		try {
			WorkflowInstance workflowInstance =WorkflowUtil.getWorkflowInstace(getClassName(), entryClassPK, req.getCompanyId(), req.getGroupId());
			
			Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
			viewUrl = GetterUtil.getString(workflowContext.get("viewDetailsUrl"));
			
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		
		if(Validator.isNull(viewUrl)) {
			try {
				PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
					serviceContext.getRequest(), serviceContext.getScopeGroup(),
					PortletKeys.MY_WORKFLOW_TASK, 0, 0,
					PortletRequest.RENDER_PHASE);
	
				portletURL.setParameter("mvcPath", "/edit_workflow_task.jsp");
				portletURL.setParameter(
					"workflowTaskId", String.valueOf(workflowTaskId));
				portletURL.setWindowState(WindowState.MAXIMIZED);
	
				viewUrl = portletURL.toString();
			}
			catch (WindowStateException windowStateException) {
				throw new PortalException(windowStateException);
			}
		}
		
		return viewUrl;
	}
	
	
	
	@Override
	public EcMemberRequest updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		LOGGER.info("****************EcMemberWorkflowHandler*****************************"+status);
		long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	
		long classPk = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		
		ServiceContext serviceContext=(ServiceContext)workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
		
		long qararDocId = GetterUtil.getLong(workflowContext.get("QARAR_DOC_ID"));
		
		String statusCode = GetterUtil.getString(workflowContext.get(RequestStatus.STATUS_CODE));
		EcMemberRequest ecMemberRequest = null;
		
		if(statusCode != null && !statusCode.isBlank()) {
			
			ecMemberRequest =addRequestStatus(statusCode, workflowContext);
			if(statusCode.equals(RequestStatus.MEMBER_DETAILS_ENTRY)) {
				 membershipUtil.assignPotentialECMemberRole(ecMemberRequest,serviceContext); 
				// EcMemberRequestLocalServiceUtil.updateStatus(userId, classPk , WorkflowConstants.STATUS_APPROVED,  serviceContext);
			}
			
			if(statusCode.equals(RequestStatus.COMPLETE)) {
				 membershipUtil.assignECMemberRole(ecMemberRequest,serviceContext.getCompanyId(),serviceContext.getScopeGroupId());
				 EcMemberRequestLocalServiceUtil.updateStatus(userId, classPk , WorkflowConstants.STATUS_APPROVED,  serviceContext);
				 
				 UserMetadata userMetadata = membershipUtil.addUserMetaData(ecMemberRequest);
				 membershipUtil.saveUserMetadata(userMetadata, serviceContext.getScopeGroupId());
			}
									
		}if(qararDocId > 0){
			LOGGER.info("qararDocId >>>> "+qararDocId);
		
			updateRequestQararStatus(classPk,qararDocId, workflowContext);
		}else {
			ecMemberRequest = EcMemberRequestLocalServiceUtil.updateStatus(userId, classPk , status,  serviceContext);
		}
		workflowContext.remove("QARAR_DOC_ID");
		
		workflowContext.remove(RequestStatus.STATUS_CODE);
		
		return ecMemberRequest;
		
	}
	
	
	private void updateRequestQararStatus(long classPk, long qararDocId, Map<String, Serializable> workflowContext) {
		try {
			EcMemberRequest ecMemberRequest = EcMemberRequestLocalServiceUtil.getEcMemberRequest(classPk);
			
			if(ecMemberRequest.getQararDocId() <= 0) {
				ecMemberRequest =addRequestStatus(RequestStatus.QARAR_GENERATED, workflowContext);
				ecMemberRequest.setQararDocId(qararDocId);
				EcMemberRequestLocalServiceUtil.updateEcMemberRequest(ecMemberRequest);
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public EcMemberRequest addRequestStatus(String statusCode, Map<String, Serializable> workflowContext) throws PortalException {
		LOGGER.info("****************EcMemberWorkflowHandler*****************************"+statusCode);
		long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	
		
		long requestId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext=(ServiceContext)workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
		
		long groupId =serviceContext.getScopeGroupId();
		
		
		String comments = (String) workflowContext.get(WorkflowConstants.CONTEXT_TASK_COMMENTS);
		
		workflowContext.remove(RequestStatus.STATUS_CODE);
		
		Role userRole = MembershipUtil.getUserRole(groupId, userId);
		long roleId = 0;
		if(userRole != null) {
			roleId = userRole.getRoleId();
		}	
		LOGGER.info("roleId------------"+roleId);
		EcMemberRequest ecMemberRequest = null;
		try {
			
			User user= UserLocalServiceUtil.getUser(userId);
			LOGGER.info("************* statusCode > "+statusCode);
			
			ecMemberRequest = EcMemberRequestLocalServiceUtil.getEcMemberRequest(requestId);
		
			EcMemberRequestStatus ecMemberRequestStatus = EcMemberRequestStatusLocalServiceUtil.findByCode(statusCode);
			
			EcMemberRequestState ecMemberRequestState = null;
			
			if(ecMemberRequestStatus != null) {
				long statusId = ecMemberRequestStatus.getEcMemberRequestStatusId();
				boolean isPublic = false;
				if(RequestStatus.MEMBER_DETAILS_ENTRY.equals(statusCode)) {
					isPublic = true;
				}
				ecMemberRequestState = EcMemberRequestStateLocalServiceUtil.addRequestState(comments, requestId, statusId, userId, roleId, isPublic);
				
				ecMemberRequest.setLatestEcMemberRequestStateId(ecMemberRequestState.getEcMemberRequestStateId());
			}
			LOGGER.info("ecMemberRequestState-----------"+ecMemberRequestState.getCreatedByRoleId());
			
			
			ecMemberRequest =  EcMemberRequestLocalServiceUtil.updateRequest(ecMemberRequest);
			
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return ecMemberRequest;
		
	}
	
	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;
	
	@Reference
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private OMSBHttpConnector httpConnector;
}

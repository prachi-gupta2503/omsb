package gov.omsb.faculty.membership.web.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.model.FacultyRequestStatus;
import gov.omsb.tms.service.FacultyRequestLocalServiceUtil;
import gov.omsb.tms.service.FacultyRequestStateLocalServiceUtil;
import gov.omsb.tms.service.FacultyRequestStatusLocalServiceUtil;

@Component(property = { "model.class.name=gov.omsb.tms.model.FacultyRequest" }, service = WorkflowHandler.class)
public class FacultyRequestWorkflowHandler extends BaseWorkflowHandler<FacultyRequest> {

	@Override
	public String getClassName() {
		return FacultyRequest.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return "FacultyRequest";
	}

	@Override
	public FacultyRequest updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		LOGGER.info("****************FacultyRequestWorkflowHandler*****************************" + status);
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

		long classPk = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

		String statusCode = GetterUtil.getString(workflowContext.get(RequestStatus.STATUS_CODE));
		FacultyRequest facultyRequest = null;
		LOGGER.info("### statusCode" + statusCode);
		
		if (statusCode != null && !statusCode.isBlank()) {
			facultyRequest = addRequestStatus(statusCode, workflowContext);
			if (statusCode.equals(RequestStatus.MEMBER_DETAILS_ENTRY)) {
				// membershipUtil.assignPotentialECMemberRole(ecMemberRequest,serviceContext);
				FacultyRequestLocalServiceUtil.updateStatus(userId, classPk, WorkflowConstants.STATUS_APPROVED,
						serviceContext);
			}

			if (statusCode.equals(RequestStatus.COMPLETE)) {
				// membershipUtil.assignECMemberRole(ecMemberRequest,serviceContext.getCompanyId(),serviceContext.getScopeGroupId());
				FacultyRequestLocalServiceUtil.updateStatus(userId, classPk, WorkflowConstants.STATUS_APPROVED,
						serviceContext);

				UserMetadata userMetadata = membershipUtil.addUserMetaData(facultyRequest);
				membershipUtil.saveUserMetadata(userMetadata, serviceContext.getScopeGroupId());
			}
			if(statusCode.equals(RequestStatus.PROGRAM) &&  facultyRequest.getCoveringLetterId()>0) {
				// membershipUtil.assignECMemberRole(ecMemberRequest,serviceContext.getCompanyId(),serviceContext.getScopeGroupId());
				FacultyRequestLocalServiceUtil.updateStatus(userId, classPk, WorkflowConstants.STATUS_APPROVED,
						serviceContext);

				UserMetadata userMetadata = membershipUtil.addUserMetaData(facultyRequest);
				membershipUtil.saveUserMetadata(userMetadata, serviceContext.getScopeGroupId());
			}


		}
		facultyRequest = FacultyRequestLocalServiceUtil.updateStatus(userId, classPk, status, serviceContext);
		workflowContext.remove(RequestStatus.STATUS_CODE);
		return facultyRequest;

	}

	public FacultyRequest addRequestStatus(String statusCode, Map<String, Serializable> workflowContext)
			throws PortalException {
		LOGGER.info("****************EcMemberWorkflowHandler*****************************" + statusCode);
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

		long requestId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

		long groupId = serviceContext.getScopeGroupId();

		String comments = (String) workflowContext.get(WorkflowConstants.CONTEXT_TASK_COMMENTS);

		workflowContext.remove(RequestStatus.STATUS_CODE);

		Role userRole = MembershipUtil.getUserRole(groupId, userId);
		long roleId = 0;
		if (userRole != null) {
			roleId = userRole.getRoleId();
		}
		LOGGER.info("roleId------------" + roleId);
		FacultyRequest facultyRequest = null;
		try {

			// User user= UserLocalServiceUtil.getUser(userId);
			LOGGER.info("************* statusCode > " + statusCode);

			facultyRequest = FacultyRequestLocalServiceUtil.getFacultyRequest(requestId);

			FacultyRequestStatus facultyRequestStatus = FacultyRequestStatusLocalServiceUtil.findByCode(statusCode);

			FacultyRequestState facultyRequestState = null;

			if (facultyRequestStatus != null) {
				long statusId = facultyRequestStatus.getFacultyRequestStatusId();
				boolean isPublic = false;
				if (RequestStatus.MEMBER_DETAILS_ENTRY.equals(statusCode)) {
					isPublic = true;
				}
				facultyRequestState = FacultyRequestStateLocalServiceUtil.addFacultyRequestState(comments, requestId,
						statusId, userId, roleId, isPublic);
				LOGGER.info("#### facultyRequestState " + facultyRequestState);
				facultyRequest.setLastestFacultyRequestStateId(facultyRequestState.getFacultyRequestStateId());
				LOGGER.info("#### facultyRequest " + facultyRequest);

			}
			LOGGER.info("facultyRequestState-----------" + facultyRequestState.getCreatedByRoleId());

			facultyRequest = FacultyRequestLocalServiceUtil.updateRequest(facultyRequest);

		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return facultyRequest;

	}

	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

	private static final Log LOGGER = LogFactoryUtil.getLog(FacultyRequestWorkflowHandler.class);

}

package gov.omsb.tms.ecm.web.workflow;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import gov.omsb.common.util.CommonUtil;
import gov.omsb.common.util.PortalNotification;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.WorkflowNotificationKeys;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.EcMemberRequestLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;

public class NotificationUtil {
	private static final String NEW_REQUEST_MESSAGE = "You have received a new EC Member request for Program - {program_name}";
	private static final String REJECT_MESSAGE = "Your request has been rejected by the {user_role} {user_name}, please check the comments for details";

	public static void sendNewTaskNotification(String roles, Map<String, Serializable> workflowContext) {
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPk = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		long companyId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));
		String pageURL = GetterUtil.getString(workflowContext.get(WorkflowNotificationKeys.VIEW_DETAIL_URL));
		String entryType = GetterUtil.getString(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_TYPE));
		ServiceContext serviceContext = (ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
		
		
		String[] roleList = null;
		if(Validator.isNotNull(roles)) {
			roleList = roles.split(",");
		}
		try {
			User sender = UserLocalServiceUtil.getUser(userId);
			EcMemberRequest ecMemberRequest = EcMemberRequestLocalServiceUtil.getEcMemberRequest(classPk);
			
			List<User> userList = new ArrayList<User>();
			for(String roleName : roleList) {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
				
				userList.addAll(users);
			}
			
			ProgramMaster programMaster = ProgramMasterLocalServiceUtil.getProgramMaster(ecMemberRequest.getProgramId());
			
			String programName = programMaster.getProgramName(Locale.ENGLISH);
			
			Template notificationTemplate = CommonUtil.getTemplate(NEW_REQUEST_MESSAGE);
			notificationTemplate.put("program_name",programName);

			StringWriter out = new StringWriter();
			notificationTemplate.processTemplate(out);

			String notification = out.toString();
			LOGGER.info("notification > "+notification );
			LOGGER.info("companyId > "+companyId);
			
			JSONObject payLoadJSON = JSONFactoryUtil.createJSONObject();
			
		//	payLoadJSON.put(WorkflowNotificationKeys.ENTRY_TYPE,	entryType);
		//	payLoadJSON.put(WorkflowNotificationKeys.COMPANY_ID, companyId);
		//	payLoadJSON.put(WorkflowNotificationKeys.ENTRY_CLASSPK, classPk);
		//	payLoadJSON.put(WorkflowNotificationKeys.ENTRY_CLASS_NAME, EcMemberRequest.class.getName());

		//	payLoadJSON.put(WorkflowNotificationKeys.GROUP_ID,	serviceContext.getScopeGroupId());
			payLoadJSON.put(WorkflowNotificationKeys.NOTIFICATION_MESSAGE,	"test message 1");
			payLoadJSON.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, "test message 2");
			payLoadJSON.put(WorkflowNotificationKeys.USER_ID, userId);
			payLoadJSON.put(OmsbTmsCommonConstants.SENDER_NAME, sender.getFullName());
			payLoadJSON.put(WorkflowNotificationKeys.VIEW_DETAIL_URL, "http://localhost:8080/");
			
			
			for(User user :userList) {
				PortalNotification.sendPortalNotification(user.getUserId(),	ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST, payLoadJSON);
				
			/*	Date date = new Date();
				long userNotificationId = CounterLocalServiceUtil.increment(UserNotificationEvent.class.getName());
				UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil
						.createUserNotificationEvent(userNotificationId);
				userNotificationEvent.setCompanyId(companyId);
				userNotificationEvent.setUserId(user.getUserId());
				userNotificationEvent.setType(ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST);
				userNotificationEvent.setDeliveryType(UserNotificationDeliveryConstants.TYPE_WEBSITE);
				userNotificationEvent.setDeliverBy(userId);
				userNotificationEvent.setPayload(payLoadJSON.toString());
			//	userNotificationEvent.setDelivered(Boolean.TRUE);
			//	userNotificationEvent.setActionRequired(Boolean.FALSE);
			//	userNotificationEvent.setArchived(false);
				//userNotificationEvent.setTimestamp(date.getTime());

				userNotificationEvent = UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userNotificationEvent);
				*/
				LOGGER.info("Notification sent to - "+user.getFullName());
			}
			
		}catch(Exception ex) {
			LOGGER.error(ex);
		}
		
	}
	

	private static final Log LOGGER = LogFactoryUtil.getLog(NotificationUtil.class);

}

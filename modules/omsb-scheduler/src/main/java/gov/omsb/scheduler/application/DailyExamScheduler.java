package gov.omsb.scheduler.application;

import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.dto.ExamMultiDatesItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.util.ExamNotificationUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "dispatch.task.executor.name=" + DailyExamScheduler.KEY,
		"dispatch.task.executor.type=" + DailyExamScheduler.KEY }, service = DispatchTaskExecutor.class

)
public class DailyExamScheduler extends BaseDispatchTaskExecutor {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return KEY;
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {
		logger.info("Inside doExecute method");

		String baseURL = omsbCommonApi.getBaseURL();
		logger.info("baseURL : " + baseURL);
		long groupId = 0;
		long companyId = 0;
		 Locale locale=null;
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			logger.info("Guest Group Id is ?? " + group.getGroupId());
			groupId = group.getGroupId();
			companyId = group.getCompanyId();
		}
		try {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
         locale = serviceContext.getLocale();
         logger.info("locale"+ locale);
		}catch(Exception e) {
			logger.error(e);
		}
		updateExamSchedule(baseURL, groupId, companyId);
		//updateOCTExamSchedule(baseURL, groupId, companyId);
		sendReminderNotification(baseURL, groupId, companyId,locale);

	}
	private void updateExamSchedule(String baseURL, long groupId, long companyId) {
		try {
			List<ExamSchedule> examScheduleList = examUtil.getExamScheduleDataList(baseURL, groupId);
			logger.info("examScheduleList size"+examScheduleList.size());
			for (ExamSchedule examSchedule : examScheduleList) {
				logger.info(examSchedule.getExamDate());
				if (Validator.isNotNull(examSchedule.getExamDate())) {
					Date dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
							.parse(examSchedule.getExamDate());
					if (new Date().after(dateFormat)) {
						examUtil.updateExamScheduleStatus(baseURL, companyId, examSchedule);
						logger.info("inside the condition");
					}
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateOCTExamSchedule(String baseURL, long groupId, long companyId) {
		List<OCTExamSchedule> examScheduleList = octExamUtil.getOCTExamScheduleDataList(baseURL, groupId);

		for (OCTExamSchedule oCTExamSchedule : examScheduleList) {
			logger.info(oCTExamSchedule.getExamDate());
			Date dateFormat;
			try {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(oCTExamSchedule.getExamDate());
				logger.info(dateFormat);
				logger.info(new Date().after(dateFormat));
				logger.info(new Date().before(dateFormat));

				if (new Date().before(dateFormat)) {
					octExamUtil.updateOCTExamScheduleStatus(baseURL, companyId, oCTExamSchedule);
					logger.info("inside the condition");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void sendReminderNotification(String baseURL, long groupId, long companyId, Locale locale) {
	try {
		logger.info("send Reminder notification");
		List<ExamSchedule> examScheduleList = examUtil.getExamScheduleDataList(baseURL, groupId);
		for(ExamSchedule examSchedule:examScheduleList ) {
			
			if (Validator.isNotNull(examSchedule.getExamDate())) {
			Date dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(examSchedule.getExamDate());
			LocalDate examDate = dateFormat.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate tomorrowDate = LocalDate.now().plusDays(1);
			logger.info("equals "+examDate.equals(tomorrowDate));
			examSchedule.setExamTypeName(examUtil.getExamType(examSchedule.getExamType(), companyId, baseURL, locale));
			if(examSchedule.isMultiDates()) {
				examSchedule=scheduleUtil.setSchedularWithMutiDates(examSchedule, groupId,baseURL);
			}else {
				if(Validator.isNotNull(examSchedule.getExamDate())) {
					examSchedule.setExamDate(omsbCommonApi.convertDateFormatToDDMMYYYY(examSchedule.getExamDate())+"[ "+ examSchedule.getStartTime() +"]" );
				}
			}
			if (examDate.equals(tomorrowDate)) {
				List<Registration> registrations = examUtil.getExamRegistrationByScheduleIdAndStatus( baseURL,  groupId,examSchedule.getId(),"Registered");
				for(Registration registration : registrations) {
					logger.info("send notification");
					examNotificationUtil.sendLRUserNotification(groupId, registration.getLrUserId(), MVCCommands.EXAM_REMINDER_TEMPLATE, true, examSchedule);
				}
			}
		}
			
		}
		
		}catch(Exception e) {
			logger.error(e);
		}

		
	}
	public static final String KEY = "Exam Notification Scheduler";
	@Reference
	private OCTExamUtil octExamUtil;
	@Reference
	private ExamUtil examUtil;

	@Reference
	private ScheduleUtil scheduleUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private ExamNotificationUtil examNotificationUtil;

	
	private static final Log logger = LogFactoryUtil.getLog(DailyExamScheduler.class);
}

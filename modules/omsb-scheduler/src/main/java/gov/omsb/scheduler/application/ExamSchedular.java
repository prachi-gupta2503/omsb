package gov.omsb.scheduler.application;

import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "dispatch.task.executor.name=" + ExamSchedular.KEY,
		"dispatch.task.executor.type=" + ExamSchedular.KEY }, service = DispatchTaskExecutor.class

)

public class ExamSchedular extends BaseDispatchTaskExecutor {

	@Override
	public String getName() {

		logger.info("GET NAME FUNCTION .....");
		return KEY;
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {

		logger.info("DO EXECUTE FUNCTION ::::::::");
		
		String baseURL = omsbCommonApi.getBaseURL();
		logger.info("baseURL : " + baseURL);
		long groupId = 0;
		long companyId = 0;
		
		Locale locale = new Locale("en", "US");

		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			logger.info("Guest Group Id is ?? " + group.getGroupId());
			groupId = group.getGroupId();
			companyId = group.getCompanyId();
		}

		logger.info("groupId : " + groupId);
	
		
      octExamUtil.examScheduleSchedular(baseURL, groupId, companyId, locale);
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;
	
	public static final String KEY = "Daily Exam Notification";

	private static final Log logger = LogFactoryUtil.getLog(ExamSchedular.class);
}
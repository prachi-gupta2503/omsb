package gov.omsb.scheduler.application;

import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

import gov.omsb.duty.logging.web.util.LogViolationManager;

@Component(immediate = true, property = { "dispatch.task.executor.name=" + DutyLogViolationScheduler.KEY,
		"dispatch.task.executor.type=" + DutyLogViolationScheduler.KEY }, service = DispatchTaskExecutor.class

)

public class DutyLogViolationScheduler extends BaseDispatchTaskExecutor {

	@Override
	public String getName() {
		LOGGER.info("GET NAME FUNCTION .....");
		return KEY;
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {
		LOGGER.info("=========== DutyLogViolationScheduler Called ===========");
		LogViolationManager.updateBlockViolation();
	}

	public static final String KEY = "Violation Scheduler Notification";

	private static final Log LOGGER = LogFactoryUtil.getLog(DutyLogViolationScheduler.class);
}

package override.liferay.calender;

import com.liferay.calendar.constants.CalendarPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;



@Component(immediate = true, 
			property = { 
					"javax.portlet.name=" + CalendarPortletKeys.CALENDAR,
					"mvc.command.name=oct/schedule/calendar",
					"service.ranking:Integer=100000" 
			}, service = MVCResourceCommand.class)

public class OCTExamScheduleEventMVCResourceCommand implements MVCResourceCommand {


	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		logger.info("==========================");
		logger.info("======hellooo=============");
		logger.info("==========================");

		return true;
	}
	
	protected MVCResourceCommand mvcResourceCommand;
	
	@Reference(target = "(&(osgi.web.symbolicname=com.liferay.calendar.web) (javax.portlet.name="+CalendarPortletKeys.CALENDAR+"))")
	public void setMvcResourceCommand(MVCResourceCommand mvcResourceCommand) {
		this.mvcResourceCommand = mvcResourceCommand;
	}

	public MVCResourceCommand getMvcResourceCommand() {
		return this.mvcResourceCommand;
	}
	
	@Reference(target = "(osgi.web.symbolicname=com.liferay.calendar.web)")
    protected ServletContext servletContext;
	
	private static final Log logger = LogFactoryUtil.getLog(OCTExamScheduleEventMVCResourceCommand.class);
	
}

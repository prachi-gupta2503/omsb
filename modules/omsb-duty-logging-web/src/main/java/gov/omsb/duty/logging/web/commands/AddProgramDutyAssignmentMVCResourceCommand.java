package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.duty.logging.web.util.DutyLoggingService;
import gov.omsb.tms.model.DutyTypes;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
"mvc.command.name="+MVCCommandNames.ADD_PROGRAM_DUTY_TYPE_ASSIGNMENT }, service = MVCResourceCommand.class)
public class AddProgramDutyAssignmentMVCResourceCommand  implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("add duty type");
		ServiceContext serviceContext;
		long programId = ParamUtil.getLong(resourceRequest, "programMasterId");
		long dutyAssignmentId = ParamUtil.getLong(resourceRequest, "assignmentId");
		long cohortId = ParamUtil.getLong(resourceRequest, "cohortId");
		String status =ParamUtil.getString(resourceRequest, "status");
		long programDutyAssignmentId =ParamUtil.getLong(resourceRequest, "programDutyAssignmentId");
		try {
			if(programDutyAssignmentId>0) {
				dutyLoggingService.editProgramDutyAssignment(programDutyAssignmentId, status);
			}else {
				serviceContext = ServiceContextFactory.getInstance(DutyTypes.class.getName(), resourceRequest);
				dutyLoggingService.addProgramDutyAssignment(programId, dutyAssignmentId, cohortId, serviceContext);
			}
		} catch (PortalException e) {
			LOGGER.info("Error in add/edit program duty types assignments");
		}
		return false;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(AddProgramDutyAssignmentMVCResourceCommand.class);
	
	@Reference
	private DutyLoggingService dutyLoggingService;
}

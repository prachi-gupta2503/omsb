package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.duty.logging.web.util.DutyLoggingService;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name="+MVCCommandNames.GET_MASTER_DATA }, service = MVCResourceCommand.class)
public class GetMasterDataMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		String masterData = ParamUtil.getString(resourceRequest, "cmd");
		long programMasterId = ParamUtil.getLong(resourceRequest, "programMasterId");
		long dutyTypeId = ParamUtil.getLong(resourceRequest, "dutyTypeId");
		long cohortId =  ParamUtil.getLong(resourceRequest, "cohortId");
		Writer wtr = null;
		List<?> list = null;
		try {
			if (masterData.equals("Cohort")) {
				list = dutyLoggingService.getCohortListByProgramId(programMasterId);
			} else if (masterData.equals("Assignment")) {
				list = dutyLoggingService.getAssignmentListByDutyTypeId(dutyTypeId);
			} else if (masterData.equals("DutyType")) {
				list = dutyLoggingService.getDutyTypesList();
			} else if(masterData.equals("DutyRules")) {
				list = dutyLoggingService.getDutyRulesByProgramAndCohort(programMasterId, cohortId);
			}
			else {
				LOGGER.info("No List Found");
			}
			wtr = resourceResponse.getWriter();
			String request = JSONFactoryUtil.looseSerializeDeep(list);
			wtr.write(request);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Reference
	private DutyLoggingService dutyLoggingService;
	private static final Log LOGGER = LogFactoryUtil.getLog(GetMasterDataMVCResourceCommand.class);
}

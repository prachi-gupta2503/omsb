package gov.omsb.duty.logging.web.commands;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.service.DutyAssignmentLocalService;
import gov.omsb.tms.service.DutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.persistence.DutyAssignmentPersistence;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name=" + MVCCommandNames.ADD_DUTY_ASSIGNMENT

}, service = MVCResourceCommand.class)
public class AddDutyAssignmentMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("serveResource CALLED SUCCESSFULLY");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		String assignment = ParamUtil.getString(resourceRequest, "assignment");
		long dutyTypeId = ParamUtil.getLong(resourceRequest, "dutyTypeId");
		long dutyAssignmentId = ParamUtil.getLong(resourceRequest, "dutyAssignmentId");
		String colorCode = ParamUtil.getString(resourceRequest, "colorCode");

		DutyAssignment dutyAssignment=null;
		if (dutyAssignmentId == 0) {
			LOGGER.info("INSIDE iF CONDITION");
			List<DutyAssignment> assignmentList = dutyAssignmentLocalService.findByDutyTypeIdAndAssignment(dutyTypeId,assignment);
			LOGGER.info("assignmentList::::"+assignmentList);
			for (DutyAssignment assignments : assignmentList) {
				if (assignments.getStatus().equalsIgnoreCase("Inactive")) {
					assignments.setStatus("Active");
					assignments.setModifiedBy(userId);
					assignments.setModifiedDate(new Date());
					LOGGER.info("update inactive to active");
					DutyAssignmentLocalServiceUtil.updateDutyAssignment(assignments);
					return true;
				}
			}
			dutyAssignmentId = CounterLocalServiceUtil.increment(DutyAssignment.class.getName());
			dutyAssignment = dutyAssignmentLocalService.createDutyAssignment(dutyAssignmentId);
			dutyAssignment.setAssignment(assignment);
			dutyAssignment.setDutyTypeId(dutyTypeId);
			dutyAssignment.setCreatedBy(userId);
			dutyAssignment.setCreateDate(new Date());
			dutyAssignment.setGroupId(groupId);
			dutyAssignment.setStatus("Active");
			dutyAssignment.setColorCode(colorCode);
			DutyAssignmentLocalServiceUtil.addDutyAssignment(dutyAssignment);
			LOGGER.info("DutyAssignment Add Successfully");
		} else {
				try {
					LOGGER.info("dutyAssignment:--->:::"+dutyAssignment);
						dutyAssignment = DutyAssignmentLocalServiceUtil.getDutyAssignment(dutyAssignmentId);
						dutyAssignment.setAssignment(assignment);
						dutyAssignment.setDutyTypeId(dutyTypeId);
						dutyAssignment.setModifiedBy(userId);
						dutyAssignment.setColorCode(colorCode);
						dutyAssignment.setModifiedDate(new Date());
						DutyAssignmentLocalServiceUtil.updateDutyAssignment(dutyAssignment);
				} catch (PortalException e) {
					LOGGER.error("No duty assignment found on provided dutyAssignmentId");
				}
		}
		return true;
	}

	@Reference
	private DutyAssignmentLocalService dutyAssignmentLocalService;
	@Reference
	private DutyAssignmentPersistence dutyAssignmentPersistence;

	private static final Log LOGGER = LogFactoryUtil.getLog(AddDutyAssignmentMVCResourceCommand.class);

}

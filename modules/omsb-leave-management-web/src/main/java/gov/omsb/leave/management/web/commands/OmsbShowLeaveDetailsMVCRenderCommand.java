package gov.omsb.leave.management.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBVIEWTRAINEELEAVEWEB,
		"mvc.command.name="
				+ OmsbLeaveManagementWebConstants.VIEW_LEAVE_DETAILS_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbShowLeaveDetailsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveManagementWebConstants.VIEW_DATE_FORMAT);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long leaveMasterId = ParamUtil.getLong(renderRequest, OmsbLeaveManagementWebConstants.LEAVE_MASTER_ID);

		try {
			LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveMasterId);

			long leaveTypeId = leaveMaster.getLeaveTypeId();

			LeaveTypes leaveTypes = leaveTypesLocalService.getLeaveTypes(leaveTypeId);

			renderRequest.setAttribute(OmsbLeaveManagementWebConstants.LEAVE_MASTER, leaveMaster);
			renderRequest.setAttribute(OmsbLeaveManagementWebConstants.LEAVE_TYPE, leaveTypes.getLeaveTypes(themeDisplay.getLocale()));
			renderRequest.setAttribute(OmsbLeaveManagementWebConstants.SDF, sdf);

		} catch (PortalException e) {
			log.error("PortalException While Fetching Leave Details");
		}
		return OmsbLeaveManagementWebConstants.VIEW_LEAVE_DETAILS_JSP;
	}

	@Reference
	LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	LeaveTypesLocalService leaveTypesLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbShowLeaveDetailsMVCRenderCommand.class.getName());

}
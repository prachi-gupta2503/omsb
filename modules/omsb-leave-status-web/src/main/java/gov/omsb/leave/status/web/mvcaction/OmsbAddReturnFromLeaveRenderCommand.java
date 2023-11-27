package gov.omsb.leave.status.web.mvcaction;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusWebPortletKeys;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.service.LeaveMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB,
		"mvc.command.name="
				+ OmsbLeaveStatusConstants.RETURN_FROM_LEAVE_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbAddReturnFromLeaveRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long leaveMasterId = ParamUtil.getLong(renderRequest, "leaveMasterId");

		try {
			LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveMasterId);

			SimpleDateFormat formatter = new SimpleDateFormat(OmsbLeaveStatusConstants.DD_MM_YYYY);

			String dateOFExpectedReturn = StringPool.BLANK;
			String dateOfReturn = StringPool.BLANK;

			if (Validator.isNotNull(leaveMaster.getLeaveTo())) {
				dateOFExpectedReturn = formatter.format(leaveMaster.getLeaveTo());
			}

			if (Validator.isNotNull(leaveMaster.getReturnFromLeave())) {
				dateOfReturn = formatter.format(leaveMaster.getReturnFromLeave());
			}

			renderRequest.setAttribute("dateOFExpectedReturn", dateOFExpectedReturn);
			renderRequest.setAttribute("dateOfReturn", dateOfReturn);
			renderRequest.setAttribute("reasonForDelay", leaveMaster.getReasonForDelay());
			renderRequest.setAttribute("leaveMasterId", leaveMaster.getLeaveMasterId());

		} catch (PortalException e) {
			log.debug(e.getMessage());
		}

		log.info("Data fetched for the particular leave....");

		return OmsbLeaveStatusConstants.RETURN_FROM_LEAVE;
	}

	@Reference
	LeaveMasterLocalService leaveMasterLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbAddReturnFromLeaveRenderCommand.class.getName());

}

package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="+MVCCommandNames.APPLICANT_CANCELLATION_RENDER, }, service = MVCRenderCommand.class)
public class ApplicantCancellationMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("Invoking render method ::::::::::");
		logger.info("Invoking render method successful::::::::::");
		long scheduleId = ParamUtil.getLong(renderRequest, "examScheduleId", 55361);
		long examTitleId = ParamUtil.getLong(renderRequest, "examTitleId", 54951);
		
		// Write logic to update the cancel status in the oct.
		renderRequest.setAttribute("examScheduleId", scheduleId);
		renderRequest.setAttribute("examTitleId", examTitleId);
		return OmsbOctExamWebPortletKeys.APPLICANT_CANCELLATION_JSP;
	}
	private static final Log logger = LogFactoryUtil.getLog(ApplicantCancellationMVCRenderCommand.class);
}

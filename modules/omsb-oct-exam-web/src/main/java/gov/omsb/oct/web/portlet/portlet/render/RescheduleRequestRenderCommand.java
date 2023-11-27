package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamReschedule;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_EXAM_RESCHEDULE_REQUEST, }, service = MVCRenderCommand.class)

public class RescheduleRequestRenderCommand implements MVCRenderCommand{
	private static final Log logger = LogFactoryUtil.getLog(RescheduleRequestRenderCommand.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("Start Invoking of the render method :::::::");
		long examDefinitionId=ParamUtil.getLong(renderRequest, "examDefinitionId", 54969);
		long examScheduleId=ParamUtil.getLong(renderRequest, "examScheduleId", 55361);
		long newExamScheduleId=ParamUtil.getLong(renderRequest, "newExamScheduleId", 55362);
		long examTitleId = ParamUtil.getLong(renderRequest, "examTitleId", 54955);
		
		renderRequest.setAttribute("examDefinitionId", examDefinitionId);
		renderRequest.setAttribute("examScheduleId", examScheduleId);
		renderRequest.setAttribute("newExamScheduleId", newExamScheduleId);
		renderRequest.setAttribute("examTitleId", examTitleId);
		
		logger.info("Invoking of the render method succesful:::::::");
		
		return OmsbOctExamWebPortletKeys.OCT_RESCHEDULE_REQUEST_JSP;
	}
	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;
	
}

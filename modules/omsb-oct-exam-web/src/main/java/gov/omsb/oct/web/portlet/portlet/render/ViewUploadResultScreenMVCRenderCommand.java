package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_UPLOAD_RESULT_SCREEN_RENDER, }, service = MVCRenderCommand.class)
public class ViewUploadResultScreenMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		System.out.println("ViewUploadResultScreenMVCRenderCommand");
		return OmsbOctExamWebPortletKeys.VIEW_UPLOAD_RESULT_SCREEN_JSP;
	}

}

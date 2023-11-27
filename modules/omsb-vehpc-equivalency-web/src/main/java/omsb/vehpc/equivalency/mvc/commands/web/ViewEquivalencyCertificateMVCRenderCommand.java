package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_CERTIFICATE_RENDER }, service = MVCRenderCommand.class)
public class ViewEquivalencyCertificateMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("invoking ViewEquivalencyCertificateMVCRenderCommand command");
		long equivalencyRequestId = ParamUtil.getLong(renderRequest, "equivalencyRequestId");
		
		renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);
		logger.info("invoking ViewEquivalencyCertificateMVCRenderCommand command Ends ");
		return EquivalencyJSPPathConstants.VIEW_EQUIVALENCY_CERTIFICATE_JSP;
	}
	 private static final Log logger = LogFactoryUtil.getLog(ViewEquivalencyCertificateMVCRenderCommand.class);
}

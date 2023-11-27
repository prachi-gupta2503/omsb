package gov.omsb.log.procedures.web.mvcaction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
		"mvc.command.name=" + OmsbLogProceduresConstants.ADD_LOG_PROCEDURES_JSP }, service = MVCRenderCommand.class)
public class OmsbAddLogProcedureMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		log.debug("Render JSP Page Name :: " + OmsbLogProceduresConstants.ADD_LOG_PROCEDURES_JSP);

		return OmsbLogProceduresConstants.ADD_LOG_PROCEDURES_JSP;
	}

	private Log log = LogFactoryUtil.getLog(OmsbAddLogProcedureMVCRenderCommand.class.getName());

}
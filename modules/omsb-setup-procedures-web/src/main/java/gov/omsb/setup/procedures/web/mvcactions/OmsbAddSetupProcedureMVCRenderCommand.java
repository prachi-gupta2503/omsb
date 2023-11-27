package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;

/**
 * @author Aditya Meghnathi
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"mvc.command.name=/add-setup-procedure-form" }, service = MVCRenderCommand.class)

public class OmsbAddSetupProcedureMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		List<ProgramMaster> programMaster = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_PROGRAM_LIST, programMaster);
		return OmsbSetupProceduresWebPortletKeys.ADD_SETUP_PROCEDURE_JSP;
	}

	@Reference
	private ProgramMasterLocalService programMasterLocalService;
}

package gov.omsb.procedure.groups.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.procedure.groups.web.constants.OmsbProcedureGroupsConstants;
import gov.omsb.procedure.groups.web.constants.OmsbProcedureGroupsWebPortletKeys;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProcedureGroupsWebPortletKeys.OMSBPROCEDUREGROUPSWEB,
"mvc.command.name=" + OmsbProcedureGroupsConstants.EDIT_PROCEDURE_GROUPS_MVC_COMMAND_NAME}, service = MVCRenderCommand.class)
public class OmsbEditProcedureGroupMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long procedureGroupMasterId = ParamUtil.getLong(renderRequest, OmsbProcedureGroupsConstants.PROCEDURE_GROUP_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbProcedureGroupsConstants.DATE_FORMAT);
		
		try {
			ProcedureGroupMaster procedureGroupMaster = procedureGroupMasterLocalService.getProcedureGroupMaster(procedureGroupMasterId);
			renderRequest.setAttribute(OmsbProcedureGroupsConstants.PROCEDURE_GROUP, procedureGroupMaster);

			List<ProcedureGroupMaster> procedureGroupMasterList = procedureGroupMasterLocalService.getProcedureGroupMasters(-1, -1);
			renderRequest.setAttribute(OmsbProcedureGroupsConstants.PROCEDURE_GROUP_LIST, procedureGroupMasterList);
			renderRequest.setAttribute(OmsbProcedureGroupsConstants.DATE_FORMAT_VARIABLE, sdf);
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbProcedureGroupsConstants.EDIT_JSP_PAGE;
	}
	
	@Reference
	private ProcedureGroupMasterLocalService procedureGroupMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditProcedureGroupMVCRenderCommand.class.getName());
}

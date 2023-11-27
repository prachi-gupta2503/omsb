package gov.omsb.visit.types.web.portlet.mvccommands;

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

import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.visit.types.web.constants.OmsbVisitTypesWebPortletKeys;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVisitTypesWebPortletKeys.OMSBVISITTYPESWEB,
"mvc.command.name=" + OmsbVisitTypesWebPortletKeys.EDIT_VISIT_TYPE_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditVisitTypeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long visitTypeMasterId = ParamUtil.getLong(renderRequest, OmsbVisitTypesWebPortletKeys.VISIT_TYPE_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbVisitTypesWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		
		try {
			VisitTypeMaster visitTypeMaster = visitTypeMasterLocalService.getVisitTypeMaster(visitTypeMasterId);
			renderRequest.setAttribute(OmsbVisitTypesWebPortletKeys.VISIT_TYPE, visitTypeMaster);

			List<VisitTypeMaster> visitTypeMasterList = visitTypeMasterLocalService.getVisitTypeMasters(-1, -1);
			renderRequest.setAttribute(OmsbVisitTypesWebPortletKeys.VISIT_TYPE_MASTER_LIST, visitTypeMasterList);
			renderRequest.setAttribute(OmsbVisitTypesWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbVisitTypesWebPortletKeys.EDIT_VISIT_TYPE_JSP;
	}
	
	@Reference
	private VisitTypeMasterLocalService visitTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditVisitTypeMVCRenderCommand.class.getName());
}

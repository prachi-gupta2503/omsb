package gov.omsb.participation.type.web.portlet.mvccommands;

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

import gov.omsb.participation.type.web.constants.OmsbParticipationTypeWebPortletKeys;
import gov.omsb.tms.model.ParticipationTypeMaster;
import gov.omsb.tms.service.ParticipationTypeMasterLocalService;

/**
 * 
 * @author HP
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbParticipationTypeWebPortletKeys.OMSBPARTICIPATIONTYPEWEB,
"mvc.command.name=" + OmsbParticipationTypeWebPortletKeys.EDIT_PARTICIPATION_TYPE_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditParticipationTypeMVCRenderCommand implements MVCRenderCommand{
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long participationTypeMasterId = ParamUtil.getLong(renderRequest, OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbParticipationTypeWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		
		try {
			//Getting participation through id
			ParticipationTypeMaster participationTypeMaster = participationTypeMasterLocalService.getParticipationTypeMaster(participationTypeMasterId);
			renderRequest.setAttribute(OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE, participationTypeMaster);

			//List of all participation type
			List<ParticipationTypeMaster> participationTypeMasterList = participationTypeMasterLocalService.getParticipationTypeMasters(-1,-1);
			renderRequest.setAttribute(OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_MASTER_ID, participationTypeMasterList);
			renderRequest.setAttribute(OmsbParticipationTypeWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbParticipationTypeWebPortletKeys.EDIT_PARTICIPATION_TYPE_JSP;
	}
	
	@Reference
	private ParticipationTypeMasterLocalService participationTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditParticipationTypeMVCRenderCommand.class.getName());
}

package gov.omsb.trainee.level.web.portlet.mvccommands;

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

import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.trainee.level.web.constants.OmsbTraineeLevelConstants;
import gov.omsb.trainee.level.web.constants.OmsbTraineeLevelWebPortletKeys;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTraineeLevelWebPortletKeys.OMSBTRAINEELEVELWEB,
"mvc.command.name=" + OmsbTraineeLevelConstants.EDIT_TRAINEE_LEVEL_MVC_COMMAND_NAME}, service = MVCRenderCommand.class)
public class OmsbEditTraineeLevelMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long traineeLevelMasterId = ParamUtil.getLong(renderRequest, OmsbTraineeLevelConstants.TRAINEE_LEVEL_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbTraineeLevelConstants.DATE_FORMAT);
		
		try {
			TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService.getTraineeLevelMaster(traineeLevelMasterId);
			renderRequest.setAttribute(OmsbTraineeLevelConstants.TRAINEE_LEVEL, traineeLevelMaster);

			List<TraineeLevelMaster> traineeLevelMasterList = traineeLevelMasterLocalService.getTraineeLevelMasters(-1, -1);
			renderRequest.setAttribute(OmsbTraineeLevelConstants.TRAINEE_LEVEL_LIST, traineeLevelMasterList);
			renderRequest.setAttribute(OmsbTraineeLevelConstants.DATE_FORMAT_VARIABLE, sdf);
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbTraineeLevelConstants.EDIT_JSP_PAGE;
	}
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditTraineeLevelMVCRenderCommand.class.getName());
}

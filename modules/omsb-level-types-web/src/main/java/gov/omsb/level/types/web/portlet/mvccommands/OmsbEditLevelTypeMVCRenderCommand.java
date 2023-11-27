package gov.omsb.level.types.web.portlet.mvccommands;

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

import gov.omsb.level.types.web.constants.OmsbLevelTypesWebPortletKeys;
import gov.omsb.tms.model.LevelTypeMaster;
import gov.omsb.tms.service.LevelTypeMasterLocalService;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLevelTypesWebPortletKeys.OMSBLEVELTYPESWEB,
"mvc.command.name=" + OmsbLevelTypesWebPortletKeys.EDIT_LEVEL_TYPE_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditLevelTypeMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long levelTypeMasterId = ParamUtil.getLong(renderRequest, OmsbLevelTypesWebPortletKeys.LEVEL_TYPE_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLevelTypesWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		
		try {
			LevelTypeMaster levelTypeMaster = levelTypeMasterLocalService.getLevelTypeMaster(levelTypeMasterId);
			renderRequest.setAttribute(OmsbLevelTypesWebPortletKeys.LEVEL_TYPE, levelTypeMaster);
			
			List<LevelTypeMaster> levelTypeMasters = levelTypeMasterLocalService.getLevelTypeMasters(-1, -1);
			renderRequest.setAttribute(OmsbLevelTypesWebPortletKeys.LEVEL_TYPE_MASTER_LIST, levelTypeMasters);		
			renderRequest.setAttribute(OmsbLevelTypesWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);

		} catch (PortalException e) {
			_logger.error(e);
		}
		_logger.info("render Exit ::: ");
		return OmsbLevelTypesWebPortletKeys.EDIT_LEVEL_TYPE_JSP;
	}

	@Reference
	private LevelTypeMasterLocalService levelTypeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditLevelTypeMVCRenderCommand.class);
}

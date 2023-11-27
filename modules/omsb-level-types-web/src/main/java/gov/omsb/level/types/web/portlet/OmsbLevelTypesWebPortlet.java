package gov.omsb.level.types.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
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
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbLevelTypesWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbLevelTypesWebPortletKeys.ADD_LEVEL_TYPE_JSP,
		"javax.portlet.name=" + OmsbLevelTypesWebPortletKeys.OMSBLEVELTYPESWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbLevelTypesWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		_logger.info("render Invoked ::: ");
		
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLevelTypesWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		List<LevelTypeMaster> levelTypeMasters = levelTypeMasterLocalService.getLevelTypeMasters(-1, -1);
		
		renderRequest.setAttribute(OmsbLevelTypesWebPortletKeys.LEVEL_TYPE_MASTER_LIST, levelTypeMasters);
		renderRequest.setAttribute(OmsbLevelTypesWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);

		super.render(renderRequest, renderResponse);
		_logger.info("render Exit ::: ");

	}

	@Reference
	private LevelTypeMasterLocalService levelTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbLevelTypesWebPortlet.class);
}
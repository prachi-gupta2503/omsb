package gov.omsb.trainee.level.web.portlet;

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

import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.trainee.level.web.constants.OmsbTraineeLevelConstants;
import gov.omsb.trainee.level.web.constants.OmsbTraineeLevelWebPortletKeys;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbTraineeLevelWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbTraineeLevelConstants.ADD_JSP_PAGE,
		"javax.portlet.name=" + OmsbTraineeLevelWebPortletKeys.OMSBTRAINEELEVELWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbTraineeLevelWebPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_logger.info("OmsbTraineeLevelWebPortlet render Invoked ::: ");
		List<TraineeLevelMaster> traineeLevelMaster = traineeLevelMasterLocalService.getTraineeLevelMasters(-1, -1);
		renderRequest.setAttribute(OmsbTraineeLevelConstants.TRAINEE_LEVEL_LIST, traineeLevelMaster);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbTraineeLevelConstants.DATE_FORMAT);
		renderRequest.setAttribute(OmsbTraineeLevelConstants.DATE_FORMAT_VARIABLE, sdf);
		super.render(renderRequest, renderResponse);
		_logger.info("OmsbTraineeLevelWebPortlet render Exit ::: ");
	}

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTraineeLevelWebPortlet.class.getName());
}
package gov.omsb.participation.type.web.portlet;

import gov.omsb.participation.type.web.constants.OmsbParticipationTypeWebPortletKeys;
import gov.omsb.tms.model.ParticipationTypeMaster;
import gov.omsb.tms.service.ParticipationTypeMasterLocalService;

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

/**
 * @author HP
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbParticipationTypeWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbParticipationTypeWebPortletKeys.ADD_PARTICIPATION_TYPE_JSP,
		"javax.portlet.name=" + OmsbParticipationTypeWebPortletKeys.OMSBPARTICIPATIONTYPEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbParticipationTypeWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		_logger.info("render Invoked ::: ");
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbParticipationTypeWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		
		//List of prticipation types
		List<ParticipationTypeMaster> participationTypeMasterList = participationTypeMasterLocalService.getParticipationTypeMasters(-1,-1);
		
		renderRequest.setAttribute(OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_MASTER_LIST, participationTypeMasterList);
		renderRequest.setAttribute(OmsbParticipationTypeWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		
		super.render(renderRequest, renderResponse);		
		_logger.info("render Exit ::: ");
	}
	@Reference
	private ParticipationTypeMasterLocalService participationTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbParticipationTypeWebPortlet.class.getName());
}
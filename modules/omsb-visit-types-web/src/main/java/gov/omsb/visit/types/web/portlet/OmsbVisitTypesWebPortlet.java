package gov.omsb.visit.types.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
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
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbVisitTypesWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbVisitTypesWebPortletKeys.ADD_VISIT_TYPE_JSP,
		"javax.portlet.name=" + OmsbVisitTypesWebPortletKeys.OMSBVISITTYPESWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbVisitTypesWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_logger.info("render Invoked ::: ");
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbVisitTypesWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		List<VisitTypeMaster> visitTypeMasterList = visitTypeMasterLocalService.getVisitTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		_logger.debug("visitTypeMasterList Object :  " + visitTypeMasterList);
		
		renderRequest.setAttribute(OmsbVisitTypesWebPortletKeys.VISIT_TYPE_MASTER_LIST, visitTypeMasterList);
		renderRequest.setAttribute(OmsbVisitTypesWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		
		super.render(renderRequest, renderResponse);
		_logger.info("render Exit ::: ");
	}
	
	@Reference
	private VisitTypeMasterLocalService visitTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbVisitTypesWebPortlet.class.getName());
}
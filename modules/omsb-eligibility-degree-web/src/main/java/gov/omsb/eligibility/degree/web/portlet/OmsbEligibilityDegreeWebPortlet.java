package gov.omsb.eligibility.degree.web.portlet;

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

import gov.omsb.eligibility.degree.web.constants.OmsbEligibilityDegreeWebPortletKeys;
import gov.omsb.tms.model.EligibilityDegreeMaster;
import gov.omsb.tms.service.EligibilityDegreeMasterLocalService;

/**
 * @author HP
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbEligibilityDegreeWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+OmsbEligibilityDegreeWebPortletKeys.ADD_ELIGIBILITY_DEGREE_JSP,
		"javax.portlet.name=" + OmsbEligibilityDegreeWebPortletKeys.OMSBELIGIBILITYDEGREEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbEligibilityDegreeWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_logger.info("render Invoked ::: ");
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbEligibilityDegreeWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		List<EligibilityDegreeMaster> eligibilityDegreeMasterList = eligibilityDegreeMasterLocalService.getEligibilityDegreeMasters(-1, -1);
		
		renderRequest.setAttribute(OmsbEligibilityDegreeWebPortletKeys.ELIGIBILITY_DEGREE_MASTER_LIST, eligibilityDegreeMasterList);
		renderRequest.setAttribute(OmsbEligibilityDegreeWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		
		super.render(renderRequest, renderResponse);
		_logger.info("render Exit ::: ");
	}
	
	@Reference
	private EligibilityDegreeMasterLocalService eligibilityDegreeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEligibilityDegreeWebPortlet.class.getName());
}
package gov.omsb.eligibility.degree.web.portlet.mvccommands;

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

import gov.omsb.eligibility.degree.web.constants.OmsbEligibilityDegreeWebPortletKeys;
import gov.omsb.tms.model.EligibilityDegreeMaster;
import gov.omsb.tms.service.EligibilityDegreeMasterLocalService;

/**
 * @author Komal Gajera
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbEligibilityDegreeWebPortletKeys.OMSBELIGIBILITYDEGREEWEB,
"mvc.command.name=" + OmsbEligibilityDegreeWebPortletKeys.EDIT_ELIGIBILITY_DEGREE_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditEligibilityDegreeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long eligibilityDegreeMasterId = ParamUtil.getLong(renderRequest, OmsbEligibilityDegreeWebPortletKeys.ELIGIBILITY_DEGREE_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbEligibilityDegreeWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		
		try {
			EligibilityDegreeMaster eligibilityDegreeMaster = eligibilityDegreeMasterLocalService.getEligibilityDegreeMaster(eligibilityDegreeMasterId);
			renderRequest.setAttribute(OmsbEligibilityDegreeWebPortletKeys.ELIGIBILITY_DEGREE, eligibilityDegreeMaster);

			List<EligibilityDegreeMaster> eligibilityDegreeMasterList = eligibilityDegreeMasterLocalService.getEligibilityDegreeMasters(-1, -1);
			renderRequest.setAttribute(OmsbEligibilityDegreeWebPortletKeys.ELIGIBILITY_DEGREE_MASTER_LIST, eligibilityDegreeMasterList);
			renderRequest.setAttribute(OmsbEligibilityDegreeWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbEligibilityDegreeWebPortletKeys.EDIT_ELIGIBILITY_DEGREE_JSP;
	}
	
	@Reference
	private EligibilityDegreeMasterLocalService eligibilityDegreeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditEligibilityDegreeMVCRenderCommand.class.getName());
}

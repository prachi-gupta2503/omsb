package gov.omsb.cpt.codes.web.portlet;

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

import gov.omsb.cpt.codes.web.constants.OmsbCptCodesConstants;
import gov.omsb.cpt.codes.web.constants.OmsbCptCodesWebPortletKeys;
import gov.omsb.tms.model.CptCodeMaster;
import gov.omsb.tms.service.CptCodeMasterLocalService;

/**
 * @author aditya meghnathi
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbCptCodesWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbCptCodesConstants.ADD_JSP_PAGE,
		"javax.portlet.name=" + OmsbCptCodesWebPortletKeys.OMSBCPTCODESWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbCptCodesWebPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_logger.info("OmsbCptCodesWebPortlet render Invoked ::: ");
		List<CptCodeMaster> cptCodeMaster = cptCodeMasterLocalService.getCptCodeMasters(-1, -1);
		renderRequest.setAttribute(OmsbCptCodesConstants.CPT_CODE_LIST, cptCodeMaster);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbCptCodesConstants.DATE_FORMAT);
		renderRequest.setAttribute(OmsbCptCodesConstants.DATE_FORMAT_VARIABLE, sdf);
		super.render(renderRequest, renderResponse);
		_logger.info("OmsbCptCodesWebPortlet render Exit ::: ");
	}

	@Reference
	private CptCodeMasterLocalService cptCodeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbCptCodesWebPortlet.class.getName());
}
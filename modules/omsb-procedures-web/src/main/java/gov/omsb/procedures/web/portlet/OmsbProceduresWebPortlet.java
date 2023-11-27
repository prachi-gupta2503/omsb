package gov.omsb.procedures.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

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

import gov.omsb.procedures.web.constants.OmsbProceduresConstants;
import gov.omsb.procedures.web.constants.OmsbProceduresWebPortletKeys;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.service.ProcedureMasterLocalService;

/**
 * @author taher.mohammed
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbProceduresWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbProceduresConstants.ADD_PROCEDURE_MASTER_JSP_NAME,
		"javax.portlet.name=" + OmsbProceduresWebPortletKeys.OMSBPROCEDURESWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbProceduresWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbProceduresConstants.DATE_FORMAT);
		
		List<ProcedureMaster> procedureMasters = procedureMasterLocalService.getProcedureMasters(QueryUtil.ALL_POS,QueryUtil.ALL_POS).stream()
				.sorted(Comparator.comparing(ProcedureMaster::getModifiedDate).reversed()).collect(Collectors.toList());
		
		renderRequest.setAttribute(OmsbProceduresConstants.PROCEDURES, procedureMasters);
		renderRequest.setAttribute(OmsbProceduresConstants.LANGUAGE_ID, themeDisplay.getLanguageId());
		renderRequest.setAttribute(OmsbProceduresConstants.DATE_FORMAT_VARIABLE, sdf);

		log.debug("Procedures List Size : " + procedureMasters.size());

		super.render(renderRequest, renderResponse);
	}

	@Reference
	private ProcedureMasterLocalService procedureMasterLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbProceduresWebPortlet.class.getName());

}
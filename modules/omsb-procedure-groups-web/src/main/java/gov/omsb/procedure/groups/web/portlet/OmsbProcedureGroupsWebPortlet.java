package gov.omsb.procedure.groups.web.portlet;

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

import gov.omsb.procedure.groups.web.constants.OmsbProcedureGroupsConstants;
import gov.omsb.procedure.groups.web.constants.OmsbProcedureGroupsWebPortletKeys;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbProcedureGroupsWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbProcedureGroupsConstants.ADD_JSP_PAGE,
		"javax.portlet.name=" + OmsbProcedureGroupsWebPortletKeys.OMSBPROCEDUREGROUPSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbProcedureGroupsWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_logger.info("render Invoked ::: ");
		List<ProcedureGroupMaster> procedureGroupMaster = procedureGroupMasterLocalService.getProcedureGroupMasters(-1,-1).stream()
				.sorted(Comparator.comparing(ProcedureGroupMaster::getModifiedDate).reversed()).collect(Collectors.toList());
		renderRequest.setAttribute(OmsbProcedureGroupsConstants.PROCEDURE_GROUP_LIST, procedureGroupMaster);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbProcedureGroupsConstants.DATE_FORMAT);
		renderRequest.setAttribute(OmsbProcedureGroupsConstants.DATE_FORMAT_VARIABLE, sdf);
		super.render(renderRequest, renderResponse);
		_logger.info("render Exit ::: ");
	}

	@Reference
	private ProcedureGroupMasterLocalService procedureGroupMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbProcedureGroupsWebPortlet.class.getName());
}
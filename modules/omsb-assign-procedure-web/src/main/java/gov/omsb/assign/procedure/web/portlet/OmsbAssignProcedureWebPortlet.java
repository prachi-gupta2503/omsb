package gov.omsb.assign.procedure.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.assign.procedure.web.constants.OmsbAssignProcedureConstants;
import gov.omsb.assign.procedure.web.constants.OmsbAssignProcedureWebPortletKeys;
import gov.omsb.tms.model.CptCodeMaster;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.service.CptCodeMasterLocalService;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;
import gov.omsb.tms.service.ProcedureGroupProceduresCPTCodeRelLocalService;
import gov.omsb.tms.service.ProcedureMasterLocalService;

/**
 * @author taher.mohammed
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbAssignProcedureWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/add-pg-procedures-rel.jsp",
		"javax.portlet.name=" + OmsbAssignProcedureWebPortletKeys.OMSBASSIGNPROCEDUREWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbAssignProcedureWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		logger.info("AssignProcedureRender invoked");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbAssignProcedureConstants.DATE_FORMAT);

		List<ProcedureGroupProceduresCPTCodeRel> procedureGroupProceduresCPTCodeRels = procedureGroupProceduresCPTCodeRelLocalService
				.getProcedureGroupProceduresCPTCodeRels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		List<ProcedureGroupMaster> procedureGroupMasters = procedureGroupMasterLocalService
				.getProcedureGroupMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		List<ProcedureMaster> procedureMasters = procedureMasterLocalService.getProcedureMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		List<CptCodeMaster> cptCodeMasters = cptCodeMasterLocalService.getCptCodeMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		renderRequest.setAttribute(OmsbAssignProcedureConstants.PG_PROCEDURES_CPT_RELS,
				procedureGroupProceduresCPTCodeRels);
		renderRequest.setAttribute(OmsbAssignProcedureConstants.PROCEDURE_GROUP_MASTERS, procedureGroupMasters);
		renderRequest.setAttribute(OmsbAssignProcedureConstants.PROCEDURE_MASTERS, procedureMasters);
		renderRequest.setAttribute(OmsbAssignProcedureConstants.CPT_CODE_MASTERS, cptCodeMasters);
		renderRequest.setAttribute(OmsbAssignProcedureConstants.LANGUAGE_ID, themeDisplay.getLanguageId());
		renderRequest.setAttribute(OmsbAssignProcedureConstants.DATE_FORMAT_VARIABLE, sdf);

		super.render(renderRequest, renderResponse);
		logger.info("AssignProcedureRender ended");
	}

	@Reference
	private ProcedureGroupProceduresCPTCodeRelLocalService procedureGroupProceduresCPTCodeRelLocalService;

	@Reference
	private ProcedureGroupMasterLocalService procedureGroupMasterLocalService;

	@Reference
	private ProcedureMasterLocalService procedureMasterLocalService;

	@Reference
	private CptCodeMasterLocalService cptCodeMasterLocalService;

	private Log logger = LogFactoryUtil.getLog(OmsbAssignProcedureWebPortlet.class.getName());

}
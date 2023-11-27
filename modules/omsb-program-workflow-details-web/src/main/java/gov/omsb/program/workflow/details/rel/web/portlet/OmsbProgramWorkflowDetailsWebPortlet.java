package gov.omsb.program.workflow.details.rel.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.program.workflow.details.rel.web.constants.OmsbProgramWorkflowDetailsConstant;
import gov.omsb.program.workflow.details.rel.web.constants.OmsbProgramWorkflowDetailsWebPortletKeys;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramWorkflowDetailsRel;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramWorkflowDetailsRelLocalService;

/**
 * @author taher.mohammed
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbProgramWorkflowDetailsWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="
				+ OmsbProgramWorkflowDetailsConstant.ADD_PROGRAM_WORKFLOW_DETAILS_JSP_PAGE,
		"javax.portlet.name=" + OmsbProgramWorkflowDetailsWebPortletKeys.OMSBPROGRAMWORKFLOWDETAILSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbProgramWorkflowDetailsWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<ProgramMaster> programMasters = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		List<ProgramWorkflowDetailsRel> programWorkflowDetailsRels = programWorkflowDetailsRelLocalService
				.getProgramWorkflowDetailsRels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		List<ProgramMaster> availablePrograms = new ArrayList();
		boolean isAvailable = true;
		for (ProgramMaster programMaster : programMasters) {
			for (ProgramWorkflowDetailsRel programWorkflowDetailsRel : programWorkflowDetailsRels) {
				if (programMaster.getProgramMasterId() == programWorkflowDetailsRel.getProgramId()) {
					isAvailable = false;
					break;
				}
			}
			if (isAvailable) {
				availablePrograms.add(programMaster);
			}
			isAvailable = true;
		}

		renderRequest.setAttribute(OmsbProgramWorkflowDetailsConstant.PROGRAM_MASTER_LIST, availablePrograms);
		renderRequest.setAttribute(OmsbProgramWorkflowDetailsConstant.PROGRAM_WORKFLOW_DETAILS_LIST,
				programWorkflowDetailsRels);

		log.info("Program List Size :: " + availablePrograms.size());

		super.render(renderRequest, renderResponse);
	}

	@Reference
	ProgramMasterLocalService programMasterLocalService;

	@Reference
	ProgramWorkflowDetailsRelLocalService programWorkflowDetailsRelLocalService;

	private static final Log log = LogFactoryUtil.getLog(OmsbProgramWorkflowDetailsWebPortlet.class.getName());

}
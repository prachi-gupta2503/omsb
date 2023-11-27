package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDetails;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamFormNumber;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamJsonFields;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.ADMIN_VIEW_EXAM_SETUP, }, service = MVCRenderCommand.class)
public class ViewExamSetupMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long octExamId = ParamUtil.getLong(renderRequest, "octExamId");
			String viewDefinitionCMD = ParamUtil.getString(renderRequest, "viewDefinition");
			long examDefinitionId = ParamUtil.getLong(renderRequest, "definitionId");
			String role = ParamUtil.getString(renderRequest, "role");
			if(viewDefinitionCMD.equalsIgnoreCase("viewDefinition")) {
				
			OCTExamDefinition definition = octExamUtil.getOCtExamDefinitionById(examDefinitionId, themeDisplay);
				
			octExamId = definition.getoCExamId();
			}
			
			
			logger.info("exam id:" + octExamId);
			OCTExamDetails octExamDetails = octExamUtil.getOCTExamDetailsListByExamId(octExamId,
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getPortalURL(),
					themeDisplay.getLocale());
			if (Validator.isNotNull(octExamDetails)) {
				OCTExamJsonFields examJsonFields = octExamDetails.getExamJson();
				examJsonFields.setId(octExamDetails.getId());
				if (Validator.isNotNull(examJsonFields)) {
						examJsonFields.setExamTitleName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
								examJsonFields.getExamTitleId(), themeDisplay.getLocale()));
						examJsonFields.setResultSourceName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
								examJsonFields.getResultSource(), themeDisplay.getLocale()));
					if (Validator.isNotNull(examJsonFields)
							&& Validator.isNotNull(examJsonFields.getOctExamFormNumbers())
							&& !examJsonFields.getOctExamFormNumbers().isEmpty()) {
						List<OCTExamFormNumber> examFormNumbers = examJsonFields.getOctExamFormNumbers();
						for (OCTExamFormNumber examFormNumber : examFormNumbers) {
							examFormNumber.setExamFormStatusName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
									examFormNumber.getExamFormStatus(), themeDisplay.getLocale()));
						}
					}
					if (Validator.isNotNull(examJsonFields)
							&& Validator.isNotNull(examJsonFields.getOctExamFormNumbers())
							&& !examJsonFields.getOctExamFormNumbers().isEmpty()) {
						List<OCTExamFormNumber> examFormNumbers = examJsonFields.getOctExamFormNumbers();
						for (OCTExamFormNumber examFormNumber : examFormNumbers) {
							examFormNumber.setExamFormStatusName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
									examFormNumber.getExamFormStatus(), themeDisplay.getLocale()));
						}
					}
					octExamUtil.getBlueprintFileURL(examJsonFields);
					renderRequest.setAttribute("examJson", examJsonFields);
					renderRequest.setAttribute("viewDefinitionCMD", viewDefinitionCMD);
					renderRequest.setAttribute("role", role);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return OmsbOctExamWebPortletKeys.VIEW_EXAM_SETUP_JSP;
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference
	private OCTExamUtil octExamUtil;

	private static final Log logger = LogFactoryUtil.getLog(ViewExamSetupMVCRenderCommand.class);
}
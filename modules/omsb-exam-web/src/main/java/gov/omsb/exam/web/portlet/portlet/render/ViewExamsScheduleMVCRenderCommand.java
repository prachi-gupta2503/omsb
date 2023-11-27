package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_EXAMS_SCHEDULE, }, service = MVCRenderCommand.class)
/**
 * 
 * @author RahulkumarP
 *
 */
public class ViewExamsScheduleMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(LRPicklistConstants.EXAM_STATUS,
							themeDisplay.getCompanyId());
			renderRequest.setAttribute("examStatusList",
					ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
			renderRequest.setAttribute("programs", examUtil.getProgram(themeDisplay));
			renderRequest.setAttribute("examTypes", examUtil.getExamTypes(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay));
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return OMSBExamWebPortletKeys.VIEW_EXAMS_SCHEDULE_JSP;
	}

	@Reference
	private ExamUtil examUtil;

	private static final Log LOGGER = LogFactoryUtil.getLog(ViewExamsScheduleMVCRenderCommand.class);
}

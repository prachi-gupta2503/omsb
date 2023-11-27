package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.EDIT_OCT_EXAM_SCHEDULE_RENDER, }, service = MVCRenderCommand.class)
public class EditOCTExamScheduleMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long octExamScheduleId = ParamUtil.getLong(renderRequest, "octExamScheduleId");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		OCTExamSchedule octExamSchedule = getOctExamScheduleById(octExamScheduleId, themeDisplay.getPortalURL(),
				themeDisplay.getLocale());
		/* Department pickList dropdown */
		List<ListTypeEntry> octExamDepartmentList = omsbCommonApi
				.getListTypeEntriesByERC(LRPicklistConstants.DEPARTMENT, PortalUtil.getDefaultCompanyId());
		renderRequest.setAttribute("octExamDepartmentList", octExamDepartmentList);
		/* Section pickList dropdown */
		List<ListTypeEntry> octExamSectionList = omsbCommonApi.getListTypeEntriesByERC(LRPicklistConstants.SECTION,
				PortalUtil.getDefaultCompanyId());
		renderRequest.setAttribute("octExamSectionList", octExamSectionList);

		renderRequest.setAttribute("octExamSchedule", octExamSchedule);
		return OmsbOctExamWebPortletKeys.EDIT_OCT_EXAM_SCHEDULE_JSP;
	}

	private OCTExamSchedule getOctExamScheduleById(long octExamScheduleId, String portalURL, Locale locale) {

		OCTExamSchedule octExamSchedule = octExamUtil.getOCTExamScheduleById(octExamScheduleId, portalURL);

		ListTypeEntry departmentEntry = omsbCommonApi
				.getListTypeEntryBylistTypeEntryId(octExamSchedule.getDepartmentId());
		String departmentName = StringPool.BLANK;
		String departmentKey = StringPool.BLANK;
		if (Validator.isNotNull(departmentEntry)) {
			departmentName = departmentEntry.getName(locale);
			departmentKey = departmentEntry.getKey();
		}

		ListTypeEntry sectionEntry = omsbCommonApi.getListTypeEntryBylistTypeEntryId(octExamSchedule.getSectionId());
		String sectionName = StringPool.BLANK;
		String sectionKey = StringPool.BLANK;
		if (Validator.isNotNull(sectionEntry)) {
			sectionName = sectionEntry.getName(locale);
			sectionKey = sectionEntry.getKey();
		}

		octExamSchedule.setDepartmentKey(departmentKey);
		octExamSchedule.setDepartmentName(departmentName);
		octExamSchedule.setSectionKey(sectionKey);
		octExamSchedule.setSectionName(sectionName);
		octExamSchedule.setRegistrationStartDate(
				omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getRegistrationStartDate()));
		octExamSchedule.setRegistrationEndDate(
				omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getRegistrationEndDate()));
		octExamSchedule.setExamDate(omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getExamDate()));

		return octExamSchedule;
	}

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(OCTExamsMVCRenderCommand.class);
}

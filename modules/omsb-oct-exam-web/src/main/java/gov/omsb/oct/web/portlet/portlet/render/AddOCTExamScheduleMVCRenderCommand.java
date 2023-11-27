package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
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
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDetails;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamJsonFields;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleAdmin;
import gov.omsb.oct.exam.web.portlet.dto.OCTMultiDateItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.ADD_OCT_EXAM_SCHEDULE_RENDER, }, service = MVCRenderCommand.class)
public class AddOCTExamScheduleMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long octExamId = ParamUtil.getLong(renderRequest, "octExamId");
		long octExamScheduleId = ParamUtil.getLong(renderRequest, "octExamScheduleId");
		String action=ParamUtil.getString(renderRequest, "action");
		long companyId = themeDisplay.getCompanyId();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		String portalUrl = themeDisplay.getPortalURL();
		Locale locale = themeDisplay.getLocale();
		
		if (Validator.isNotNull(octExamId)) {
			OCTExamDetails octExamDetails = octExamUtil.getOCTExamDetailsListByExamId(octExamId, companyId,
					scopeGroupId, portalUrl, locale);
			renderRequest.setAttribute("octExamTitle", octExamDetails.getOCTExamTitle());
			OCTExamJsonFields oCTExamJsonFields = octExamDetails.getExamJson();
			renderRequest.setAttribute("examJsonFields", oCTExamJsonFields);
			/* Department pickList dropdown */
			List<ListTypeEntry> octExamDepartmentList = omsbCommonApi
					.getListTypeEntriesByERC(LRPicklistConstants.DEPARTMENT, companyId);
			renderRequest.setAttribute("octExamDepartmentList", octExamDepartmentList);
			/* Section pickList dropdown */
			List<ListTypeEntry> octExamSectionList = omsbCommonApi.getListTypeEntriesByERC(LRPicklistConstants.SECTION,
					companyId);
			renderRequest.setAttribute("octExamSectionList", octExamSectionList);
			/* Training Site DropDown */
			List<ListTypeEntry> octTrainingSiteList = omsbCommonApi.getListTypeEntriesByERC("PL_OC_TRAINING_SITE_ERC", companyId);
			
			//octExamUtil.getOCTTrainingSite(portalUrl,scopeGroupId);
			renderRequest.setAttribute("octTrainingSiteList", octTrainingSiteList);
			/*Map Training Site DropDown */
			// List<OCTMapTrainingSite> octMapTrainingSiteList = octExamUtil.getOCTMapTrainingSite(portalUrl,scopeGroupId);
			// renderRequest.setAttribute("octMapTrainingSiteList", octMapTrainingSiteList);

		}
		if(Validator.isNotNull(octExamScheduleId) && octExamScheduleId !=0) {
			OCTExamSchedule examSchedule=octScheduleUtil.getOCExamScheduleByScheduleId(themeDisplay, octExamScheduleId);
			
			
			if(Validator.isNotNull(examSchedule)) {
				
				ListTypeEntry departmentEntry = omsbCommonApi
						.getListTypeEntryBylistTypeEntryId(examSchedule.getDepartmentId());
				String departmentName = StringPool.BLANK;
				String departmentKey = StringPool.BLANK;
				if (Validator.isNotNull(departmentEntry)) {
					departmentName = departmentEntry.getName(locale);
					departmentKey = departmentEntry.getKey();
				}

				ListTypeEntry sectionEntry = omsbCommonApi.getListTypeEntryBylistTypeEntryId(examSchedule.getSectionId());
				String sectionName = StringPool.BLANK;
				String sectionKey = StringPool.BLANK;
				if (Validator.isNotNull(sectionEntry)) {
					sectionName = sectionEntry.getName(locale);
					sectionKey = sectionEntry.getKey();
				}
				
				
				examSchedule.setDepartmentKey(departmentKey);
				examSchedule.setDepartmentName(departmentName);
				examSchedule.setSectionKey(sectionKey);
				examSchedule.setSectionName(sectionName);
				
				setExamScheduleDate( examSchedule,themeDisplay);
				renderRequest.setAttribute("examSchedule", examSchedule);
				if(examSchedule.isRepeatedInstance()) {
					OCTMultiDateItems multiDateItems= octScheduleUtil.getOCExamMultiDatesItemBasedOnScheduleAdminId(themeDisplay, examSchedule.getoCExamScheduleAdminId());
					renderRequest.setAttribute("ocExamMultiDates", multiDateItems.getItems());
				}
				
			}
			
		}
		renderRequest.setAttribute("octExamId", octExamId);
		renderRequest.setAttribute("action", action.isEmpty()? "add" :action);

		return OmsbOctExamWebPortletKeys.ADD_OCT_EXAM_SCHEDULE_JSP;
	}

	public void setExamScheduleDate(OCTExamSchedule octExamSchedule,ThemeDisplay themeDisplay) {
		try {
		OCTExamScheduleAdmin examScheduleAdmin=octScheduleUtil.getOCExamScheduleAdminByScheduleAdminId(themeDisplay, octExamSchedule.getoCExamScheduleAdminId());
		if(Validator.isNotNull(examScheduleAdmin)) {	
		octExamSchedule.setRegistrationStartDate(Validator.isNotNull(octExamSchedule.getRegistrationStartDate()) ?omsbCommonApi
					.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getRegistrationStartDate()).replaceAll("-","/") : StringPool.BLANK);
			octExamSchedule.setRegistrationEndDate(Validator.isNotNull(octExamSchedule.getRegistrationEndDate()) ?omsbCommonApi
					.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getRegistrationEndDate()).replaceAll("-","/") : StringPool.BLANK);
			octExamSchedule.setExamDate(Validator.isNotNull(octExamSchedule.getExamDate()) ?omsbCommonApi
					.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getExamDate()).replaceAll("-","/") : StringPool.BLANK);
			

			if(octExamSchedule.isRepeatedInstance()) {
						octExamSchedule.setExamStartDate(Validator.isNotNull(examScheduleAdmin.getExamStartDate()) ?omsbCommonApi
								.convertObjectDateToNewDDMMYYYYDate(examScheduleAdmin.getExamStartDate()).replaceAll("-","/") : StringPool.BLANK);
						octExamSchedule.setExamEndDate(Validator.isNotNull(examScheduleAdmin.getExamEndDate()) ?omsbCommonApi
								.convertObjectDateToNewDDMMYYYYDate(examScheduleAdmin.getExamEndDate()).replaceAll("-","/") : StringPool.BLANK);
						octExamSchedule.setApplicationStartFromNoOfDays(examScheduleAdmin.getApplicationStartFromNoOfDays());
						octExamSchedule.setApplicationEndAtNoOfDays(examScheduleAdmin.getApplicationEndAtNoOfDays());
			}else {
				
				octExamSchedule.setExamCenter(examScheduleAdmin.getExamCenter());
				
			}
		}
			
		
	}catch (Exception e) {
		logger.error(e.getMessage(), e);
	}
		
	}
	
	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OCTScheduleUtil octScheduleUtil;
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	private static final Log logger = LogFactoryUtil.getLog(AddOCTExamScheduleMVCRenderCommand.class);
}

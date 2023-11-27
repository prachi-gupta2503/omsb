package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleAdmin;
import gov.omsb.oct.exam.web.portlet.dto.OCTMultiDateItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_RENDER, }, service = MVCRenderCommand.class)
public class ViewOCTExamScheduleMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long octExamScheduleId = ParamUtil.getLong(renderRequest, "octExamScheduleId");
		String role = ParamUtil.getString(renderRequest, "role");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		OCTMultiDateItems oCTMultiDateItems= new OCTMultiDateItems();
		
		OCTExamSchedule octExamSchedule = getOctExamScheduleById(octExamScheduleId, themeDisplay.getPortalURL(),
				themeDisplay.getLocale(),themeDisplay);
		OCTExamScheduleAdmin examScheduleAdmin=octScheduleUtill.getOCExamScheduleAdminByScheduleAdminId(themeDisplay, octExamSchedule.getoCExamScheduleAdminId());
//		if(Validator.isNotNull(examScheduleAdmin)) {
//			String examCenter = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examScheduleAdmin.getExamCenter(),
//					themeDisplay.getLocale());
//			if(Validator.isNotNull(examScheduleAdmin.getExamCenter())) {
//				octExamSchedule.setExamCenterName(examCenter);
//			}
//		}
		
		if(Validator.isNotNull(octExamSchedule)) {
			 oCTMultiDateItems =  octScheduleUtill.getOCExamMultiDatesItemBasedOnScheduleAdminId
					(themeDisplay, octExamSchedule.getoCExamScheduleAdminId());
			 
			renderRequest.setAttribute("ocExamMultiDates", oCTMultiDateItems.getItems());
		}
		renderRequest.setAttribute("role", role);
		renderRequest.setAttribute("octExamSchedule", octExamSchedule);
		return OmsbOctExamWebPortletKeys.VIEW_OCT_EXAM_SCHEDULE_JSP;
	}

	private OCTExamSchedule getOctExamScheduleById(long octExamScheduleId, String portalURL, Locale locale,ThemeDisplay themeDisplay) {

		OCTExamSchedule octExamSchedule = octExamUtil.getOCTExamScheduleById(octExamScheduleId, portalURL);

		String departmentName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(octExamSchedule.getDepartmentId(),
				locale);
		String sectionName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(octExamSchedule.getSectionId(),
				locale);
		
		octExamSchedule.setDepartmentName(departmentName);
		octExamSchedule.setSectionName(sectionName);
		octExamSchedule.setRegistrationStartDate(
				omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getRegistrationStartDate()));
		octExamSchedule.setRegistrationEndDate(
				omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getRegistrationEndDate()));
		octExamSchedule.setExamDate(omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getExamDate()));
		
		try {
			OCTExamScheduleAdmin examScheduleAdmin=octScheduleUtill.getOCExamScheduleAdminByScheduleAdminId
					(themeDisplay, octExamSchedule.getoCExamScheduleAdminId());
			if(Validator.isNotNull(examScheduleAdmin)) {
				if(Validator.isNotNull(examScheduleAdmin.getExamStartDate())) {
					octExamSchedule.setExamStartDate(omsbCommonApi.convertObjectDateToDDMMYYYYDate
							(examScheduleAdmin.getExamStartDate()));
					
				}if(Validator.isNotNull(examScheduleAdmin.getExamEndDate()) && !examScheduleAdmin.getExamEndDate().isEmpty()) {
					octExamSchedule.setExamEndDate(omsbCommonApi.convertObjectDateToDDMMYYYYDate
							(examScheduleAdmin.getExamEndDate()));
					
				}
			}
			
		}catch (Exception e) {
			octExamSchedule.setRepeatedInstance(false);
			octExamSchedule.setExamStartDate(StringPool.BLANK);
			octExamSchedule.setExamEndDate(StringPool.BLANK);
		}
		
	
		
		return octExamSchedule;
	}

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;
	

	@Reference(unbind = "-")
	private OCTScheduleUtil octScheduleUtill;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

}

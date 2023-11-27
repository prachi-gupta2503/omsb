package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.OCTExamScheduleStatusEnum;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTNotificationUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.EXAM_RESCHEDULE, }, service = MVCRenderCommand.class)

public class OCTExamRescheduleConfirmationRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = themeDisplay.getPortalURL();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		Locale locale = themeDisplay.getLocale();
		
		long oCExamScheduleId = ParamUtil.getLong(renderRequest, "octExamScheduleId");
		long octExamDefinitionId = ParamUtil.getLong(renderRequest, "octExamDefinitionId");
		long lrUserId=themeDisplay.getUserId();
		long octExamTitleKey = ParamUtil.getLong(renderRequest, "octExamTitleKey");
		long departmentId = 0L;
		long sectionId = 0L;
		long examTitleId = 0L;
		long examStatusId = 0L;
		String examStatusName = StringPool.BLANK;
		String examTitleName = StringPool.BLANK;
		
		OCTExamSchedule currentOCTExamSchedule = octExamUtil
				.getOCTExamScheduleById(oCExamScheduleId, portalURL);
		OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(octExamDefinitionId,
				portalURL);
		String examDate = currentOCTExamSchedule.getExamDate();
		String convertedExamDate = omsbCommonApi.convertObjectDateToDDMMYYYYDate(currentOCTExamSchedule.getExamDate());
		String examStartTime = currentOCTExamSchedule.getExamSlot();
		
		/*
		 * Get Oct Exam Schedule List which needs to be displayed in calendar view
		 * @input themeDisplay
		 * @input oCExamScheduleAdminId 
		*/		
		OCTExamScheduleItems octExamScheduleItems = octExamUtil.getOCTExamScheduleListByOCExamScheduleAdminId(
				currentOCTExamSchedule.getoCExamScheduleAdminId(), portalURL, scopeGroupId);
		
		/* creating json array to show 	Oct Exam Schedule List on calendar*/
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		if(Validator.isNotNull(octExamScheduleItems) && octExamScheduleItems.getItems().size() > 0) {
			
			for (OCTExamSchedule octExamSchedule : octExamScheduleItems.getItems()) {
				if (Validator.isNotNull(octExamSchedule.getExamDate())) {
					String newExamDate = omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getExamDate());
					if(!compareExamDates(convertedExamDate,newExamDate)) {
						continue;
					}
				}
				
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put(OCTExamConstants.OVERLAP_KEY, false);
				departmentId = octExamSchedule.getDepartmentId();
				sectionId = octExamSchedule.getSectionId();
				
				if (Validator.isNotNull(octExamDefinition)) {
					examTitleId = octExamDefinition.getoCExamTitleId();
					examTitleName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examTitleId,locale);
				}
				if(Validator.isNotNull(octExamSchedule.getExamStatusId())) {
					examStatusName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examStatusId, locale);
					octExamSchedule.setExamStatusName(examStatusName);
					if (Validator.isNotNull(examStatusName) && !examStatusName.isEmpty()) {
						
						if(examStatusName.equalsIgnoreCase("reschedule")) {
							
							octExamSchedule
							.setExamStatusColor(OCTExamScheduleStatusEnum.getStatusByLabel("Announced".toLowerCase()).getColor());
							jsonObject.put(OCTExamConstants.COLOR_KEY, octExamSchedule.getExamStatusColor());
						} else if(!examStatusName.equalsIgnoreCase("reschedule")) {
							
							octExamSchedule
							.setExamStatusColor(OCTExamScheduleStatusEnum.getStatusByLabel(examStatusName.toLowerCase()).getColor());
							jsonObject.put(OCTExamConstants.COLOR_KEY, octExamSchedule.getExamStatusColor());
						}
						
					}
					octExamSchedule.setOctExamDefinitionId(octExamDefinitionId);
					octExamSchedule.setOctExamTitleId(examTitleId);
					octExamSchedule.setOctExamTitleName(examTitleName);
					jsonObject.put(OCTExamConstants.ID_KEY, octExamSchedule.getId());
					jsonObject.put(OCTExamConstants.TITLE_KEY, examTitleName);
					octExamSchedule.setDepartmentId(departmentId);
					octExamSchedule.setSectionId(sectionId);

					if (Validator.isNotNull(octExamSchedule.getRegistrationStartDate())) {
						octExamSchedule.setRegistrationStartDate(omsbCommonApi
								.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getRegistrationStartDate()));
						
						
					}
					if (Validator.isNotNull(octExamSchedule.getRegistrationEndDate())) {
						octExamSchedule.setRegistrationEndDate(
								omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getRegistrationEndDate()));
						
					}
					if (Validator.isNotNull(octExamSchedule.getExamDate())) {
						SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT);
						try {
							octExamSchedule.setExamDate( sdf.format(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(octExamSchedule.getExamDate())));
							jsonObject.put(OCTExamConstants.START_KEY, octExamSchedule.getExamDate());
							jsonObject.put(OCTExamConstants.END_KEY, octExamSchedule.getExamDate());
						} catch (ParseException e) {
							logger.error(e.getMessage());
						}
					}

					jsonArray.put(jsonObject);
				}
			}
		}
		
		renderRequest.setAttribute(OCTExamConstants.SCHEDULE_EVENTS, jsonArray);
		
		//octNotificationUtil.send
		
		
		/*
		 * String homePageUrl = themeDisplay.getPortalURL() +
		 * OmsbOctExamWebPortletKeys.EXAM_RESCHEDULE_PAGE_URL + "&examDate=" + examDate
		 * + "&examStartTime=" + examStartTime + "&examEndTime=" + examEndTime +
		 * "&examTitleId=" + octExamTitleKey + "&octExamScheduleId=" + oCExamScheduleId;
		 */
		
		
		/* update the registration to reshedule if we have exam schedule to display on calendar*/
		if(jsonArray.length() >0) {
			Map<String, Serializable> registrationMap = new HashMap<>();
			OCTRegistrationItem octRestrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, oCExamScheduleId);
			registrationMap.put("regStatus", OmsbOctExamWebPortletKeys.RESCHEDULE);
			long registrationId=0;
			if(Validator.isNotNull(octRestrationItem)&& Validator.isNotNull(octRestrationItem.getItems()) && !octRestrationItem.getItems().isEmpty()){
				omsbCommonApi.updateObjectEntryByERC(OmsbOctExamWebPortletKeys.OB_OC_EXAM_REGISTRATION_ERC,
						registrationMap, renderRequest, themeDisplay, octRestrationItem.getItems().get(0).getId());	
				
				registrationId=octRestrationItem.getItems().get(0).getId();
			}
			renderRequest.setAttribute("registrationId", registrationId);
		}
		
		
		renderRequest.setAttribute("oldOcExamScheduleId", oCExamScheduleId);
		renderRequest.setAttribute("examDate", examDate);
		renderRequest.setAttribute("examStartTime", examStartTime);
//		renderRequest.setAttribute("examEndTime", examEndTime);
		renderRequest.setAttribute("examTitleName", octExamTitleKey);
		
		return OmsbOctExamWebPortletKeys.VIEW_OCT_EXAMS_APPLICANT_CALENDAR_JSP;
	}
	
	private boolean compareExamDates(String examDate, String newExamDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate examLocalDate = LocalDate.parse(examDate, formatter);	
		LocalDate newExamLocalDate = LocalDate.parse(newExamDate, formatter);
		return newExamLocalDate.isAfter(examLocalDate);
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OCTNotificationUtil octNotificationUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(OCTExamRescheduleConfirmationRenderCommand.class);

}

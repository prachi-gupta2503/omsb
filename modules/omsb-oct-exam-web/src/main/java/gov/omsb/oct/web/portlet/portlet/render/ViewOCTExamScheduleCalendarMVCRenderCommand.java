package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.OCTExamScheduleStatusEnum;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="
				+ MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_CALENDAR_RENDER, }, service = MVCRenderCommand.class)
public class ViewOCTExamScheduleCalendarMVCRenderCommand implements MVCRenderCommand {
	private Log logger = LogFactoryUtil.getLog(ViewOCTExamScheduleCalendarMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("Inside the render command");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = themeDisplay.getPortalURL();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		Locale locale = themeDisplay.getLocale();
		long examTitleId = ParamUtil.getLong(renderRequest, "examTitleId");
		long examDefinitionId = 0L;
		long examStatusId = 0L;

		long departmentId = 0L;
		long sectionId = 0L;
		String examStatusName = StringPool.BLANK;
		String examTitleName = StringPool.BLANK;

		/**
		 * Get Schedule List By Exam Title Id
		 */
		List<OCTExamSchedule> octExamScheduleList = octExamUtil.getOCTExamScheduleListByExamTitleId(portalURL,
				scopeGroupId, examTitleId);
		renderRequest.setAttribute("octExamScheduleList", octExamScheduleList);

		/**
		 * Get Exam Definition List By Exam Title Id
		 */
		List<OCTExamDefinition> octExamSDefinitionList = octExamUtil.getOCTExamDefinitionsByExamTitleId(examTitleId,
				portalURL, scopeGroupId);
		List<OCTExamSchedule> octExamSchedules = new ArrayList<OCTExamSchedule>();

		if (Validator.isNotNull(octExamSDefinitionList) && !octExamSDefinitionList.isEmpty()) {

			OCTExamScheduleItems examSchedulesItems = null;
			for (OCTExamDefinition octExamDefinition : octExamSDefinitionList) {
				examDefinitionId = octExamDefinition.getId();
				ListTypeEntry listTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.PL_EXAM_STATUS, "announced", themeDisplay.getCompanyId());

				String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
						+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION + "filter=examStatusId"
						+ URLEncoder.encode(" eq " + listTypeEntry.getListTypeEntryId() + " and oCExamDefinitionId eq "
								+ examDefinitionId, StandardCharsets.UTF_8);

				logger.info("examScheduleURL :" + examScheduleURL);
				String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
				logger.info("Announced Exam Schedule Response (String): " + examScheduleResponse);
				examSchedulesItems = CustomObjectMapperUtil.readValue(examScheduleResponse, OCTExamScheduleItems.class);
				octExamSchedules.addAll(examSchedulesItems.getItems());
			}

			logger.info("Announced Exam Schedule List :" + octExamSchedules);
		}

		/**
		 * Preparing JSON Array of Exam Schedule List
		 */
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {

			String inputDateString = new Date().toString();

			SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
			inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

			Date date = inputFormat.parse(inputDateString);

			String outputDateString = outputFormat.format(date);
			Date examDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(outputDateString);
			if (Validator.isNotNull(octExamSchedules) && octExamSchedules.size() > 0) {

				for (OCTExamSchedule octExamSchedule : octExamSchedules) {
					Date dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
							.parse(octExamSchedule.getExamDate());
					logger.info(dateFormat);
					if (examDate.before(dateFormat)) {

						JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put(OCTExamConstants.OVERLAP_KEY, false);
						examDefinitionId = octExamSchedule.getOctExamDefinitionId();
						departmentId = octExamSchedule.getDepartmentId();
						sectionId = octExamSchedule.getSectionId();

						OCTExamDefinition octExamDefinition = octExamUtil
								.getOCTExamDefinitionByDefinitionId(examDefinitionId, portalURL);
						if (Validator.isNotNull(octExamDefinition)) {
							examTitleId = octExamDefinition.getoCExamTitleId();
							examTitleName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examTitleId, locale);

						}

						examStatusId = octExamSchedule.getExamStatusId();
						examStatusName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examStatusId, locale);
						octExamSchedule.setExamStatusName(examStatusName);

						if (Validator.isNotNull(examStatusName) && !examStatusName.isEmpty()) {

							if (examStatusName.equalsIgnoreCase("reschedule")) {

								octExamSchedule.setExamStatusColor(OCTExamScheduleStatusEnum
										.getStatusByLabel("Announced".toLowerCase()).getColor());
								jsonObject.put(OCTExamConstants.COLOR_KEY, octExamSchedule.getExamStatusColor());
							} else if (!examStatusName.equalsIgnoreCase("reschedule")) {

								octExamSchedule.setExamStatusColor(OCTExamScheduleStatusEnum
										.getStatusByLabel(examStatusName.toLowerCase()).getColor());
								jsonObject.put(OCTExamConstants.COLOR_KEY, octExamSchedule.getExamStatusColor());
							}

						}

						octExamSchedule.setOctExamDefinitionId(examDefinitionId);
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
							octExamSchedule.setRegistrationEndDate(omsbCommonApi
									.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getRegistrationEndDate()));

						}
						if (Validator.isNotNull(octExamSchedule.getExamDate())) {
							SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT);
							try {
								octExamSchedule.setExamDate(
										sdf.format(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
												.parse(octExamSchedule.getExamDate())));
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

			logger.info("JSON Array :: " + jsonArray);
			renderRequest.setAttribute(OCTExamConstants.SCHEDULE_EVENTS, jsonArray);

			/**
			 * Fetching List of Exam Titles
			 */
			List<ListTypeEntry> examTitleListTypeEntryList = omsbCommonApi.getListTypeEntriesByERC(
					LRPicklistConstants.PL_OC_EXAM_TITLE_ERC, PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("examTitleList", examTitleListTypeEntryList);

			/**
			 * Fetching List Of Exam Status
			 */
			List<ListTypeEntry> statusListTypeEntryList = omsbCommonApi
					.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_STATUS, PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("statusListTypeEntryList", statusListTypeEntryList);

			return OmsbOctExamWebPortletKeys.VIEW_OCT_EXAMS_APPLICANT_CALENDAR_JSP;
		} catch (Exception e) {
			logger.info("Exception in getting list object :: ViewOCTExamScheduleListMVCRenderCommand Class :: " + e);
			return OmsbOctExamWebPortletKeys.VIEW_OCT_EXAMS_APPLICANT_CALENDAR_JSP;
		}

	}

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

}

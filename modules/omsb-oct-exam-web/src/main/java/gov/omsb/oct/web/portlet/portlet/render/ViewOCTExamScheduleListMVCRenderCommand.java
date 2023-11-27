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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

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
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.OCTExamScheduleStatusEnum;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER, }, service = MVCRenderCommand.class)
public class ViewOCTExamScheduleListMVCRenderCommand implements MVCRenderCommand {
	private Log logger = LogFactoryUtil.getLog(ViewOCTExamScheduleListMVCRenderCommand.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = themeDisplay.getPortalURL();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		Locale locale = themeDisplay.getLocale();
		long examDefinitionId = 0L;
		long examTitleId = 0L;
		long examStatusId = 0L;

		long departmentId = 0L;
		long sectionId = 0L;
		String examStatusName = StringPool.BLANK;
		String examTitleName = StringPool.BLANK;
		List<OCTExamSchedule> octExamScheduleList = octExamUtil.getOCTExamScheduleList(portalURL, scopeGroupId);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		List<OCTExamSchedule> newOCTExamScheduleList=new ArrayList<>();
		try {

			String inputDateString = new Date().toString();

			SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
			inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

			Date date = inputFormat.parse(inputDateString);

			String outputDateString = outputFormat.format(date);
			Date examDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(outputDateString);

			if (Validator.isNotNull(octExamScheduleList) && octExamScheduleList.size()>0) {

				for (OCTExamSchedule octExamSchedule : octExamScheduleList) {

					Date dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
							.parse(octExamSchedule.getExamDate());
					logger.info(dateFormat);
					if (examDate.before(dateFormat)) {

						JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

						jsonObject.put(OCTExamConstants.OVERLAP_KEY, false);

						examDefinitionId = octExamSchedule.getOctExamDefinitionId();
						departmentId = octExamSchedule.getDepartmentId();
						sectionId = octExamSchedule.getSectionId();

						OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(examDefinitionId,
								portalURL);
						if (Validator.isNotNull(octExamDefinition)) {
							examTitleId = octExamDefinition.getoCExamTitleId();
							examTitleName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examTitleId, locale);

						}
						octExamSchedule.setExamId(octExamDefinition.getoCExamId());

						examStatusId = octExamSchedule.getExamStatusId();
						examStatusName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examStatusId, locale);
						octExamSchedule.setExamStatusName(examStatusName);
						jsonObject.put(OCTExamConstants.STATUS, octExamSchedule.getExamStatusName());
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

						octExamSchedule.setOctExamDefinitionId(examDefinitionId);
						octExamSchedule.setOctExamTitleId(examTitleId);
						octExamSchedule.setOctExamTitleName(examTitleName);
						jsonObject.put(OCTExamConstants.ID_KEY,octExamSchedule.getId() );
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
							jsonObject.put(OCTExamConstants.START_KEY, octExamSchedule.getExamDate());
							jsonObject.put(OCTExamConstants.END_KEY, octExamSchedule.getExamDate());

						}
						if (Validator.isNotNull(octExamSchedule.getExamDate())) {
							//					octExamSchedule.setExamDate(
							//							omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getExamDate()));
							//					
							SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT);
							try {
								jsonObject.put(OCTExamConstants.START_KEY, sdf.format(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(octExamSchedule.getExamDate())));
								jsonObject.put(OCTExamConstants.END_KEY, sdf.format(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(octExamSchedule.getExamDate())));

								octExamSchedule.setExamDate( omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getExamDate()));
							} catch (Exception e) {
								logger.error(e.getMessage());
							}
							//					


						}
						newOCTExamScheduleList.add(octExamSchedule);
						jsonArray.put(jsonObject);
					}
				}
			}
			renderRequest.setAttribute(OCTExamConstants.SCHEDULE_EVENTS, jsonArray);

			List<ListTypeEntry> examTitleListTypeEntryList = omsbCommonApi
					.getListTypeEntriesByERC(LRPicklistConstants.PL_OC_EXAM_TITLE_ERC, PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("examTitleList", examTitleListTypeEntryList);

			List<ListTypeEntry> statusListTypeEntryList = omsbCommonApi
					.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_STATUS, PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("statusListTypeEntryList", statusListTypeEntryList);
			renderRequest.setAttribute("octExamScheduleList", newOCTExamScheduleList);

			return OmsbOctExamWebPortletKeys.VIEW_OCT_EXAMS_FLOW_JSP;
		}catch (Exception e) {
			logger.info("Exception in getting list object :: ViewOCTExamScheduleListMVCRenderCommand Class :: "+e);
			return OmsbOctExamWebPortletKeys.VIEW_OCT_EXAMS_FLOW_JSP;
		}

	}

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

}

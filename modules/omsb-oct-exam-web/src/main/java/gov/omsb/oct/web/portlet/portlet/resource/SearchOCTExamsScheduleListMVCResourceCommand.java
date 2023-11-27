package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.OCTExamScheduleStatusEnum;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="
				+ MVCCommandNames.SEARCH_OCT_EXAMS_SCHEDULE_DETAILS_RENDER }, service = MVCResourceCommand.class)
public class SearchOCTExamsScheduleListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		String portalURL = themeDisplay.getPortalURL();
		List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
				.collect(Collectors.toList());

		if (roleNames.contains(RoleNameConstants.OCT_ADMIN)) {

			String examTitleIdString = ParamUtil.getString(resourceRequest, "examTitleId");
			String examStatusIdString = ParamUtil.getString(resourceRequest, "examStatusId");
			String examStartDate = ParamUtil.getString(resourceRequest, "examStartDate");

			long examTitleId = 0L;
			long examStatusId = 0L;
			if (Validator.isNotNull(examTitleIdString)) {
				examTitleId = Long.parseLong(examTitleIdString);
			}
			if (Validator.isNotNull(examStatusIdString)) {
				examStatusId = Long.parseLong(examStatusIdString);
			}

			List<OCTExamSchedule> octExamScheduleList = searchOCTExamScheduleListByFilters(examTitleId, examStartDate,
					examStatusId, themeDisplay);
			OCTExamDefinition octExamDefinition =new OCTExamDefinition();
			if (Validator.isNotNull(octExamScheduleList)) {
				for (OCTExamSchedule octExamSchedule : octExamScheduleList) {
					
					long examDefinitionId = octExamSchedule.getOctExamDefinitionId();
					 octExamDefinition = octExamUtil
								.getOCTExamDefinitionByDefinitionId(examDefinitionId, portalURL);
					if (Validator.isNotNull(octExamDefinition)) {
						examTitleId = octExamDefinition.getoCExamTitleId();
					}
					String examTitleName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examTitleId, locale);
					examStatusId = octExamSchedule.getExamStatusId();
					String examStatusName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examStatusId, locale);
					octExamSchedule.setExamStatusName(examStatusName);
					
					if (Validator.isNotNull(examStatusName) && !examStatusName.isEmpty()) {
						octExamSchedule
								.setExamStatusColor(OCTExamScheduleStatusEnum.getStatusByLabel(examStatusName.toLowerCase()).getColor());
					}
					octExamSchedule.setOctExamTitleId(examTitleId);
					octExamSchedule.setOctExamTitleName(examTitleName);
					if (Validator.isNotNull(octExamSchedule.getRegistrationStartDate())) {
						octExamSchedule.setRegistrationStartDate(omsbCommonApi
								.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getRegistrationStartDate()));
					}
					if (Validator.isNotNull(octExamSchedule.getRegistrationEndDate())) {
						octExamSchedule.setRegistrationEndDate(omsbCommonApi
								.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getRegistrationEndDate()));
					}
					if (Validator.isNotNull(octExamSchedule.getExamDate())) {
						octExamSchedule.setExamDate(
								omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(octExamSchedule.getExamDate()));
					}

				}

			}

			resourceRequest.setAttribute("octExamScheduleList", octExamScheduleList);

			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher(OmsbOctExamWebPortletKeys.SEARCHED_OCT_EXAM_SCHEDULE_LIST_JSP);
			try {
				dispatcher.include(resourceRequest, resourceResponse);
			} catch (PortletException | IOException e) {
				logger.info(e.getMessage());
			}
		}

		return true;
	}

	private List<OCTExamSchedule> searchOCTExamScheduleListByFilters(long examTitleId, String examStartDate,
			long examStatusId, ThemeDisplay themeDisplay) {

		long scopeGroupId = themeDisplay.getScopeGroupId();
		String portalUrl = themeDisplay.getPortalURL();

		String octExamScheduleURL = portalUrl + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId + StringPool.QUESTION + OCTExamConstants.SORT_BY_EXAM_DATE_DESC + "&filter=";

		List<OCTExamDefinition> octExamSDefinitionList = octExamUtil.getOCTExamDefinitionsByExamTitleId(examTitleId,
				portalUrl, scopeGroupId);

		if (Validator.isNotNull(octExamSDefinitionList) && octExamSDefinitionList.size() > 0) {
			octExamScheduleURL = updateOCTExamScheduleURLWithDefinitionIds(octExamSDefinitionList, octExamScheduleURL);
		}
		if (Validator.isNotNull(examStartDate)) {
			examStartDate = omsbCommonApi.convertDateFormat(examStartDate);
			octExamScheduleURL = updateOCTExamScheduleURLWithExamStartDateFilter(examStartDate, octExamScheduleURL);
		}
		if (Validator.isNotNull(examStatusId)) {
			octExamScheduleURL = updateOCTExamScheduleURLWithExamStatusIdFilter(examStatusId, octExamScheduleURL);
		}
		if (octExamScheduleURL.lastIndexOf("+and+") > 0) {
			octExamScheduleURL = octExamScheduleURL.substring(0, octExamScheduleURL.lastIndexOf("+and+"));
		}

		String octExamScheduleResponse = omsbCommonApi.getData(octExamScheduleURL);

		if (Validator.isNotNull(octExamScheduleResponse)) {
			OCTExamScheduleItems octExamScheduleItems = CustomObjectMapperUtil.readValue(octExamScheduleResponse,
					OCTExamScheduleItems.class);
			return octExamScheduleItems.getItems();
		}

		return null;

	}

	private String updateOCTExamScheduleURLWithExamStatusIdFilter(long examStatusId, String octExamScheduleURL) {
		octExamScheduleURL = octExamScheduleURL + "examStatusId+eq+" + examStatusId + "+and+";
		return octExamScheduleURL;
	}

	private String updateOCTExamScheduleURLWithExamStartDateFilter(String examStartDate, String octExamScheduleURL) {
		octExamScheduleURL = octExamScheduleURL + "examDate+eq+" + examStartDate + "+and+";
		return octExamScheduleURL;
	}

	private String updateOCTExamScheduleURLWithDefinitionIds(List<OCTExamDefinition> octExamSDefinitionList,
			String oCTExamScheduleURL) {

		boolean isFirstDefinition = true;
		for (OCTExamDefinition octExamDefinition : octExamSDefinitionList) {
			if (isFirstDefinition) {
				oCTExamScheduleURL = oCTExamScheduleURL + StringPool.OPEN_PARENTHESIS;
				isFirstDefinition = false;
			}
			oCTExamScheduleURL = oCTExamScheduleURL + "oCExamDefinitionId+eq+" + octExamDefinition.getId() + "+or+";
		}
		if (oCTExamScheduleURL.lastIndexOf("+or+") > 0) {
			oCTExamScheduleURL = oCTExamScheduleURL.substring(0, oCTExamScheduleURL.lastIndexOf("+or+"));
		}

		oCTExamScheduleURL = oCTExamScheduleURL + StringPool.CLOSE_PARENTHESIS + "+and+";

		return oCTExamScheduleURL;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	private Log logger = LogFactoryUtil.getLog(SearchOCTExamsScheduleListMVCResourceCommand.class);

}

package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppeal;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_APPLICANT_REQUESTS, }, service = MVCRenderCommand.class)
public class ApplicantRequestsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<OCTExamAppeal> appealList = getAllAppealList(themeDisplay);
		appealList.sort(Comparator.comparingLong(OCTExamAppeal::getId).reversed());
		renderRequest.setAttribute("appealList", appealList);

		List<OCTRegistration> registrationList = getAllRegistrationList(themeDisplay);
		renderRequest.setAttribute("registrationList", registrationList);
		
		
		
		List<ListTypeEntry> examTitleList = omsbCommonApi
				.getListTypeEntriesByERC(LRPicklistConstants.PL_OC_EXAM_TITLE_ERC, themeDisplay.getCompanyId());
		renderRequest.setAttribute("examTitleList", examTitleList);
		
		
		/*
		 * List<CancellationDetail> cancellationList =
		 * octExamCancellationUtil.getAllCancellationList(themeDisplay);
		 * renderRequest.setAttribute("cancellationList", cancellationList);
		 * 
		 * List<CancellationDetail> rescheduleDetailList =
		 * octExamCancellationUtil.getAllRescheduleList(themeDisplay);
		 * renderRequest.setAttribute("rescheduleDetailList", rescheduleDetailList);
		 */
		logger.info("ApplicantRequests:::");
		return OmsbOctExamWebPortletKeys.APPLICANT_REQUESTS_JSP;
	}

	private List<OCTRegistration> getAllRegistrationList(ThemeDisplay themeDisplay) {
		List<OCTRegistration> examRegistrations = new ArrayList<>();
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		logger.info("response of List OF exam registration url ?? " + url);

		String response = omsbCommonApi.getData(url);
		logger.info("response of List OF exam registration ?? " + response);

		OCTRegistrationItem registrations = CustomObjectMapperUtil.readValue(response, OCTRegistrationItem.class);
		if (Validator.isNotNull(registrations) && Validator.isNotNull(registrations.getItems())
				&& !registrations.getItems().isEmpty()) {
			for (OCTRegistration registration : registrations.getItems()) {
				logger.info("========registration data========" + registration);
				registration.setFirstName(octExamUtil.getName(registration.getLrUserId()));

				if (registration.getRegStatus().equalsIgnoreCase(OCTExamConstants.PENDING)) {
					registration = octExamUtil.getExamRegistrationWorkflowData(themeDisplay, registration);
				}

				registration.setRegistrationStatus(octExamUtil.getregistrationStatus(registration.getoCExamScheduleId(),
						themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getLocale(),
						themeDisplay.getCompanyId()));
				registration.setStatusColor(octExamUtil.getColorMap(registration.getRegStatus()));

				OCTExamSchedule examSchedule = octExamUtil.getOCTExamScheduleById(registration.getoCExamScheduleId(),
						themeDisplay.getPortalURL());

				if (Validator.isNotNull(examSchedule)) {
					
					OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(
							examSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL());
					if (Validator.isNotNull(octExamDefinition)) {
						logger.info("octExamDefinition ... "+octExamDefinition.getId());
						
						logger.info("octExamDefinition ... "+octExamDefinition.getoCExamTitleId());

						ListTypeEntry examTitle = omsbCommonApi.getListTypeEntryBylistTypeEntryId(octExamDefinition.getoCExamTitleId());
						
						if(Validator.isNotNull(examTitle)) {
							
							registration.setExamTitle(examTitle.getName(themeDisplay.getLocale()));
						}
						
					}


					registration.setExamStartDate(omsbCommonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getExamDate()));
					registration.setExamTime(examSchedule.getExamSlot());
					registration.setExamEndDate(examSchedule.getRegistrationEndDate());
				}

				logger.info(registration.toString());
				examRegistrations.add(registration);

			}
		}

		return examRegistrations;
	}

	private List<OCTExamAppeal> getAllAppealList(ThemeDisplay themeDisplay) {
		List<OCTExamAppeal> examAppeals = new ArrayList<>();
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		String response = omsbCommonApi.getData(url);

		logger.info("response of List ?? " + response);
		OCTExamAppealItem appeals = CustomObjectMapperUtil.readValue(response, OCTExamAppealItem.class);
		if (Validator.isNotNull(appeals) && Validator.isNotNull(appeals.getItems()) && !appeals.getItems().isEmpty()) {
			for (OCTExamAppeal appeal : appeals.getItems()) {
				appeal.setTraineeName(octExamAppealUtil.getName(appeal.getLrUserId()));
				appeal = octExamAppealUtil.getWorkflowData(themeDisplay, appeal);
				long appealStatus = appeal.getAppealStatus();

				appeal.setAppealStatusValue(octExamAppealUtil.getStatusName(appealStatus, themeDisplay));
				appeal = setAdditionalAppeal(appeal, themeDisplay);
				if (appeal.getAppealCount() > 0) {
					if (appeal.getAppealCount() == 1) {
						appeal.setStatusColor(octExamUtil.getAppealStatusColor(true, appealStatus));
					} else {
						appeal.setStatusColor(octExamUtil.getAppealStatusColor(false, appealStatus));
					}
				}

				logger.info("appeal  " + appeal.toString());
				examAppeals.add(appeal);
			}
		}
		return examAppeals;
	}

	private OCTExamAppeal setAdditionalAppeal(OCTExamAppeal appeal, ThemeDisplay themeDisplay) {
		OCTExamResultItem examResult = null;
		OCTExamDefinitionItem exam = null;
		if (Validator.isNotNull(appeal)) {
			examResult = octExamUtil.getExamResultById(appeal.getExamResultId(), themeDisplay);
		}
		if (Validator.isNotNull(examResult)) {
			appeal.setResult(examResult.getResult());
			appeal.setPercentage(examResult.getPercentage());
			exam = octScheduleUtil.getExamDefinitionById(themeDisplay, examResult.getoCExamDefinitionId());
		}
		if (Validator.isNotNull(exam)) {
			logger.info("exam.getProgram() ?? " + exam.getProgramId());
			appeal.setExamType(octExamUtil.getExamType(exam.getExamTypeId(), themeDisplay.getPortalURL()));
		}
		return appeal;
	}

	@Reference
	private OCTExamAppealUtil octExamAppealUtil;

	@Reference
	private OCTExamUtil octExamUtil;

	@Reference
	private OCTScheduleUtil octScheduleUtil;

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private ObjectEntryLocalService objectEntryLocalService;
	@Reference
	private ObjectDefinitionLocalService objectDefinitionLocalService;

	private static final Log logger = LogFactoryUtil.getLog(ApplicantRequestsMVCRenderCommand.class);

}

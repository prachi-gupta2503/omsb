package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
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
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamAppeal;
import gov.omsb.exam.web.portlet.dto.ExamAppealItem;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + OMSBExamWebPortletKeys.EXAM_APPEAL_LIST, }, service = MVCRenderCommand.class)
public class ViewAllAppealMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("ViewAllAppealMVCRenderCommand Started");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ExamAppeal> appealList = getAllAppealList(themeDisplay);
		appealList.sort(Comparator.comparingLong(ExamAppeal::getId).reversed());
		List<ListTypeEntry> examTypes = omsbCommonApi.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_TYPE,
				themeDisplay.getCompanyId());
		List<ListTypeEntry> resultStatusList = omsbCommonApi.getListTypeEntriesByERC(LRPicklistConstants.RESULT_STATUS,
				themeDisplay.getCompanyId());

		renderRequest.setAttribute("appealList", appealList);
		renderRequest.setAttribute("examTypes", examTypes);
		renderRequest.setAttribute("resultStatusList", resultStatusList);

		return OMSBExamWebPortletKeys.LIST_OF_APPEAL_JSP;
	}

	private List<ExamAppeal> getAllAppealList(ThemeDisplay themeDisplay) {
		List<ExamAppeal> examAppeals = new ArrayList<>();
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		String response = omsbCommonApi.getData(url);
		logger.info("response of List ?? " + response);
		ExamAppealItem appeals = CustomObjectMapperUtil.readValue(response, ExamAppealItem.class);
		if (Validator.isNotNull(appeals) && Validator.isNotNull(appeals.getItems()) && !appeals.getItems().isEmpty()) {
			for (ExamAppeal appeal : appeals.getItems()) {
				appeal.setTraineeName(examAppealUtil.getName(appeal.getLrUserId()));
				appeal = examAppealUtil.getWorkflowData(themeDisplay, appeal);
				long appealStatus = appeal.getAppealStatus();
				appeal.setAppealStatusValue(examAppealUtil.getStatusName(appealStatus, themeDisplay));
				appeal = setAdditionalAppeal(appeal, themeDisplay);
				examAppeals.add(appeal);
			}
		}
		return examAppeals;
	}

	private ExamAppeal setAdditionalAppeal(ExamAppeal appeal, ThemeDisplay themeDisplay) {
		ExamResultItem examResult = null;
		if (Validator.isNotNull(appeal)) {
			examResult = examUtil.getExamResultById(appeal.getExamResultId(), themeDisplay);
		}
		if (Validator.isNotNull(examResult)) {
			appeal.setResult(examResult.getResult());
			appeal.setPercentage(examResult.getPercentage());
			ExamSchedule examSchedule = examUtil.getExamScheduleById(examResult.getExamScheduleId(),
					themeDisplay.getPortalURL());
			if (Validator.isNotNull(examSchedule)) {
				logger.info("exam.getProgram() ?? " + examSchedule.getProgramId());
				appeal.setProgramName(examUtil.getProgramByProgramId(examSchedule.getProgramId(), themeDisplay));
				appeal.setExamType(examUtil.getExamType(examSchedule.getExamType(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
			}
		}

		return appeal;
	}

	@Reference
	private ExamAppealUtil examAppealUtil;

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference
	private ExamUtil examUtil;

	@Reference
	private ScheduleUtil scheduleUtil;

	private static final Log logger = LogFactoryUtil.getLog(ViewAllAppealMVCRenderCommand.class);
}

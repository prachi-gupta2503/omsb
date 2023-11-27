package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_FUTURE_SCHEDULE_EXAM, }, service = MVCRenderCommand.class)
public class OCTViewFutureScheduleExam implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		String portalUrl = themeDisplay.getPortalURL();
		Locale locale = themeDisplay.getLocale();
		logger.info("Inside the render");
		long oCTExamDefinitionId = ParamUtil.getLong(renderRequest, "octExamDefinitionId");
		long oCTExamScheduleId = ParamUtil.getLong(renderRequest, "octExamScheduleId");
		float reschedulingFeesPercentage = ParamUtil.getLong(renderRequest, "reschedulingFeesPercentage");
		logger.info(oCTExamDefinitionId);
		List<OCTExamSchedule> ocExamSchedules = octExamUtil.getOCTFutureExamScheduleList(scopeGroupId, portalUrl,oCTExamDefinitionId,oCTExamScheduleId,
				locale, companyId);

		ocExamSchedules = ocExamSchedules.stream().map(schedule -> {
			schedule.setoCExamScheduleId(oCTExamScheduleId);
			return schedule;
		}).collect(Collectors.toList());

		logger.info("OCTExamSchedule size : " + ocExamSchedules.size());
		
		
		
		logger.info("OCTExamSchedule size : "+ocExamSchedules.size());
		
		renderRequest.setAttribute("examSchedules", ocExamSchedules);
		renderRequest.setAttribute("reschedulingFeesPercentage", reschedulingFeesPercentage);
		return OmsbOctExamWebPortletKeys.APPLICANT_RESCHEDULE_EXAM_LIST_JSP;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(OCTViewFutureScheduleExam.class);
}

package gov.omsb.exam.web.portlet.portlet.render;


import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamDefinition;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.ExamScheduleItem;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawal;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalItem;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_WITHDRAW_LIST, }, service = MVCRenderCommand.class)

public class ViewWithdrawListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			List<ExamWithdrawal> examWithdrawalList=new ArrayList<>();
			ExamWithdrawalItem examWithdrawalItem = examUtil.getExamWithdrawalList(themeDisplay.getPortalURL(),
					themeDisplay.getScopeGroupId());
			
			if (Validator.isNotNull(examWithdrawalItem) && Validator.isNotNull(examWithdrawalItem.getItems())) {
				examWithdrawalList = examWithdrawalItem.getItems();
				logger.info("examWithdrawalList size"+ examWithdrawalList.size());
				for (ExamWithdrawal examWithdrawal : examWithdrawalList) {
					
						ExamSchedule examSchedule = examUtil.getExamScheduleById(examWithdrawal.getExamScheduleId(), themeDisplay.getPortalURL());
						if (Validator.isNotNull(examSchedule)){
								String programName = examUtil.getProgramByProgramId(examSchedule.getProgramId(),
										themeDisplay);
								examWithdrawal.setProgramName(programName);
									if (examSchedule.getExamType() != 0) {
										String examType = examUtil.getExamType(examSchedule.getExamType(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale());
										examWithdrawal.setExamType(examType);
									}
						}
					String name = examAppealUtil.getName(examWithdrawal.getLrUserId());
					examWithdrawal.setTraineeName(name);
					long statusId = examWithdrawal.getWithdrawalStatus();
					examWithdrawal.setWithdrawalStatusValue(examAppealUtil.getStatusName(statusId, themeDisplay));
					examWithdrawal = examSetupUtil.getWorkflowData(themeDisplay, examWithdrawal);

				}
			}

			 renderRequest.setAttribute("examWithdrawal", examWithdrawalList);
			 List<ListTypeEntry> examTypes = commonApi.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_TYPE,themeDisplay.getCompanyId());
			 renderRequest.setAttribute("examWithdrawal", examWithdrawalList);
			 renderRequest.setAttribute("examTypes", examTypes);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return OMSBExamWebPortletKeys.WITHDRAW_LIST_JSP;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private ExamUtil examUtil;

	@Reference(unbind = "_")
	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	private ExamAppealUtil examAppealUtil;

	@Reference(unbind = "-")
	private ExamSetupUtil examSetupUtil;

	private Log logger = LogFactoryUtil.getLog(EditExamScheduleMVCRenderCommand.class);

}

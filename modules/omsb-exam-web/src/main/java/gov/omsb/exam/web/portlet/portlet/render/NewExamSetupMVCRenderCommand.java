package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
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
import gov.omsb.exam.web.portlet.dto.ExamType;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramTypeMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.NEW_EXAM_SETUP, }, service = MVCRenderCommand.class)
public class NewExamSetupMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("exam setup render() started");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String cmd = ParamUtil.getString(renderRequest, "cmd");
			logger.info("cmd::?" + cmd);
			List<ListTypeEntry> resultSources = omsbCommonApi
					.getListTypeEntriesByERC(LRPicklistConstants.PL_RESULT_SOURCE, PortalUtil.getDefaultCompanyId());
			ListTypeEntry selectionExamType = omsbCommonApi.getListTypeEntryByListTypeItemKey(
					LRPicklistConstants.PL_EXAM_TYPE, LRPicklistConstants.SELECTION_EXAM_KEY,
					themeDisplay.getCompanyId());
		

				List<ListTypeEntry> examEligiblities = omsbCommonApi.getListTypeEntriesByERC(
						LRPicklistConstants.PL_EXAM_ELIGIBILITY_ERC, PortalUtil.getDefaultCompanyId());

				logger.info("Program id " + ParamUtil.getLong(renderRequest, "searchProgramId"));
				logger.info("Exam Type  id " + ParamUtil.getLong(renderRequest, "searchExamTypeId"));
				List<ProgramTypeMaster> programTypeMasters = examUtil.getProgramType(themeDisplay);
//		CopyOnWriteArrayList getByRuleCondition = byLawUtil.GetByRuleCondition(themeDisplay);
				renderRequest.setAttribute("resultSources", resultSources);
				renderRequest.setAttribute("programTypeMasters", programTypeMasters);
				renderRequest.setAttribute("searchProgramId", ParamUtil.getLong(renderRequest, "searchProgramId"));
			 	renderRequest.setAttribute("searchExamTypeId", ParamUtil.getLong(renderRequest, "searchExamTypeId"));
				renderRequest.setAttribute("examEligiblities", examEligiblities);
				renderRequest.setAttribute("rules", examUtil.getByLawRules(themeDisplay));
//		renderRequest.setAttribute("getByRuleCondition", getByRuleCondition);
				ExamType examType = null;
				if (Validator.isNotNull(selectionExamType)) {
					logger.info("selectionExamType::" + selectionExamType.getKey());
					 examType = examUtil.getExamTypeByExamTypeName(themeDisplay, selectionExamType.getKey());
				}
				if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.ADD_EXAM)) {
					renderRequest.setAttribute("cmd", cmd);
					setExamTypeJson(examType, themeDisplay, renderRequest);
				} else if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.EDIT_EXAM)) {
					examSetupUtil.getExamById(renderRequest, themeDisplay, cmd);
				}
			

//		edit
			
			logger.info("exam setup render() ended");
			return OMSBExamWebPortletKeys.NEW_EXAM_SETUP_JSP;
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
		return OMSBExamWebPortletKeys.NEW_EXAM_SETUP_JSP;
	}

	public void setExamTypeJson(ExamType examType, ThemeDisplay themeDisplay, RenderRequest renderRequest) {
		try {
			if (Validator.isNotNull(examType) && Validator.isNotNull(examType.getExamType())) {
				logger.info(" examType.getExamType():" + examType.getExamType());
				ListTypeEntry listTypeEntryByListTypeItemKey = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.PL_EXAM_TYPE, examType.getExamType(), themeDisplay.getCompanyId());
				if (Validator.isNotNull(listTypeEntryByListTypeItemKey)) {
					renderRequest.setAttribute("examTypeName", listTypeEntryByListTypeItemKey.getName(themeDisplay.getLocale()));
					renderRequest.setAttribute("examTypeId", examType.getId());
				}

			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
	}

	@Reference
	private ExamSetupUtil examSetupUtil;
	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;
	@Reference(unbind = "-")
	private ProgramTypeMasterLocalService programTypeMasterLocalService;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private ExamUtil examUtil;
	private static final Log logger = LogFactoryUtil.getLog(NewExamSetupMVCRenderCommand.class);
}

package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDetails;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamFormNumber;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamJsonFields;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_NEW_EXAM_SETUP, }, service = MVCRenderCommand.class)
public class OCTNewExamSetupMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("OCT new exam setup render() started");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(renderRequest, "cmd");
		logger.info("cmd::?" + cmd);
		long octExamId = ParamUtil.getLong(renderRequest, "octExamId");
		logger.info("oct exam id::" + octExamId);
		List<ListTypeEntry> examTitles = omsbCommonApi.getListTypeEntriesByERC(LRPicklistConstants.PL_OC_EXAM_TITLE_ERC,
				PortalUtil.getDefaultCompanyId());
		if (Validator.isNotNull(examTitles) && examTitles.size() > 0) {
			logger.info("Exam Titles Size ... " + examTitles.size());
		}

		for (ListTypeEntry ListType : examTitles) {
			logger.info("ids:" + ListType.getListTypeEntryId());
			logger.info("get name :" + omsbCommonApi.getValueByLanguage(ListType.getName(),
					OmsbOctExamWebPortletKeys.EXAM_TITLE_NAME, themeDisplay.getLocale().toString()));

			ListType.setName(omsbCommonApi.getValueByLanguage(ListType.getName(),
					OmsbOctExamWebPortletKeys.EXAM_TITLE_NAME, themeDisplay.getLocale().toString()));
		}
		List<ListTypeEntry> examStatus = omsbCommonApi
				.getListTypeEntriesByERC(LRPicklistConstants.PL_OC_EXAM_FORM_STATUS, PortalUtil.getDefaultCompanyId());
		List<ListTypeEntry> resultSource = omsbCommonApi.getListTypeEntriesByERC(LRPicklistConstants.PL_RESULT_SOURCE,
				PortalUtil.getDefaultCompanyId());
		renderRequest.setAttribute("examTitles", examTitles);
		renderRequest.setAttribute("examStatus", examStatus);
		renderRequest.setAttribute("resultSource", resultSource);
		renderRequest.setAttribute("cmd", cmd);
//		edit
		if (cmd.equalsIgnoreCase(OCTExamConstants.EDIT_EXAM)) {
			logger.info("edit::::");
			OCTExamDetails octExamDetails = octExamUtil.getOCTExamDetailsListByExamId(octExamId,
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getPortalURL(),
					themeDisplay.getLocale());
			OCTExamJsonFields examJsonFields = octExamDetails.getExamJson();
			logger.info("location ::" + examJsonFields.getLocationOnGoogleMap());
			examJsonFields.setId(octExamId);
			List<OCTExamFormNumber> examFormNumbers = examJsonFields.getOctExamFormNumbers();
			for (OCTExamFormNumber examFormNumber : examFormNumbers) {
				examFormNumber.setExamFormStatusName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
						examFormNumber.getExamFormStatus(), themeDisplay.getLocale()));
			}
			renderRequest.setAttribute("examJsonFields", examJsonFields);
		}
		logger.info("OCT new exam setup render() ended");
		return OmsbOctExamWebPortletKeys.OCT_EXAM_SETUP_JSP;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	private static final Log logger = LogFactoryUtil.getLog(OCTNewExamSetupMVCRenderCommand.class);
}

package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamJsonFields;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=exam/save_exam_setup", }, service = MVCActionCommand.class)
public class SaveOCTNewExamSetupMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("OCT new exam setup doProcessAction() started");
		}
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			long octExamId = ParamUtil.getLong(actionRequest, OCTExamConstants.OCT_EXAM_ID);
			long examTitleId = ParamUtil.getLong(actionRequest, OCTExamConstants.EXAM_TITLE_CAMELCASE);
			boolean isSuccess=false;
			
			OCTExamJsonFields octExamJsonFields = octExamUtil.getExamJsonFields(actionRequest, themeDisplay,
					uploadPortletRequest);
			
			long existExam = ParamUtil.getLong(actionRequest, OCTExamConstants.EXIST_EXAM);
			if (logger.isDebugEnabled()) {
				logger.debug("exist exam in doProcessAction ::  SaveOCTNewExamSetupMVCActionCommand :: " + existExam);}
			
			String examJsonResponse = CustomObjectMapperUtil.writeValueAsString(octExamJsonFields, null);
			
			if (logger.isDebugEnabled()) {
				logger.debug("Exam json reponse in doProcessAction ::  SaveOCTNewExamSetupMVCActionCommand :: "
						+ examJsonResponse);}
			
			
			Map<String, Serializable> values = new HashMap<>();
			values.put(OCTExamConstants.EXAM_JSON, examJsonResponse);
			values.put(OCTExamConstants.MODIFIED, true);
			values.put(OCTExamConstants.OC_EXAM_TITLE_ID, examTitleId);

			long examId = (octExamId > 0) ? octExamId : existExam;

			if (examId > 0) {
				
				if (logger.isDebugEnabled()) {
					logger.debug("Here Exam id is > 0 in in doProcessAction ::  SaveOCTNewExamSetupMVCActionCommand :: ");}
				
				omsbCommonApi.updateObjectEntryById(OCTExamConstants.OB_OC_EXAM_ERC, themeDisplay, examId, values,
						actionRequest);
				isSuccess=true;

			} else {
				
				if (logger.isDebugEnabled()) {
					logger.debug("when Exam Id <=0 in doProcessAction ::  SaveOCTNewExamSetupMVCActionCommand :: ");}
				
				omsbCommonApi.addObjectEntryByERC(OCTExamConstants.OB_OC_EXAM_ERC, values, actionRequest, themeDisplay);
				isSuccess=true;
			}

			if(isSuccess) SessionMessages.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_FORM_SUCCESS);
					
			actionResponse.sendRedirect(OmsbOctExamWebPortletKeys.REDIRECT_URL);
			if (logger.isDebugEnabled()) {
				logger.debug("OCT new exam setup doProcessAction() ended");
			}
		} catch (Exception e) {
			SessionErrors.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_FORM_ERROR);
			if (logger.isErrorEnabled()) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(SaveOCTNewExamSetupMVCActionCommand.class);
}

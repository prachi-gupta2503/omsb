package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.GET_OCT_EXAM_FORM }, service = MVCResourceCommand.class)
public class GetOCTExamFormMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		logger.info("doServeResource resource() started");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int examFormNo = ParamUtil.getInteger(resourceRequest, "examFormNo");
		long examTitleId = ParamUtil.getLong(resourceRequest, "examTitleId");
		String cmd = ParamUtil.getString(resourceRequest, "cmd");

		logger.info("cmd:" + cmd);
		logger.info("examFormNo::" + examFormNo + "examTitleId::" + examTitleId);

		if (cmd.equalsIgnoreCase(OmsbOctExamWebPortletKeys.GET_EXAM_FORM)) {
			octExamUtil.getOCTExamTitle(examFormNo, resourceResponse, examTitleId, themeDisplay);
		}
		if (cmd.equalsIgnoreCase(OmsbOctExamWebPortletKeys.GET_EXIST_EXAM)) {
			octExamUtil.getExistOCTExam(examTitleId, resourceResponse, themeDisplay);
		}

		logger.info("doServeResource resource() ended");
	}

	@Reference
	private OCTExamUtil octExamUtil;
	private static final Log logger = LogFactoryUtil.getLog(GetOCTExamFormMVCResourceCommand.class);
}

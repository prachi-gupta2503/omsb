package gov.omsb.master.web.action;

import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.master.web.constants.MVCCommandNames;
import gov.omsb.master.web.constants.OmsbExamMasterConstants;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name="
				+ MVCCommandNames.SAVE_CERTIFICATION_MASTER_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class SaveOMSBCertificationMasterMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long category = ParamUtil.getLong(actionRequest, OmsbExamMasterConstants.OMSB_CERTIFICATION_MASTER_CATEGORY);
			String title = ParamUtil.getString(actionRequest,
					OmsbExamMasterConstants.OMSB_CERTIFICATION_MASTER_TITLE);
			String description = ParamUtil.getString(actionRequest,
					OmsbExamMasterConstants.OMSB_CERTIFICATION_MASTER_DESCRIPTION);

			Map<String, Serializable> values = new HashMap<>();
			values.put(OmsbExamMasterConstants.OMSB_CERTIFICATION_MASTER_CATEGORY, category);
			values.put(OmsbExamMasterConstants.OMSB_CERTIFICATION_MASTER_TITLE, title);
			values.put(OmsbExamMasterConstants.OMSB_CERTIFICATION_MASTER_DESCRIPTION, description);

			ObjectEntry objectEntry = omsbCommonApi.addObjectEntryByERC(
					OmsbExamMasterConstants.OMSB_Exam_CERTIFICATION_MASTER_ERC, values, actionRequest, themeDisplay);
			if (Validator.isNull(objectEntry)) {
				SessionErrors.add(actionRequest, OmsbMasterPortletKeys.SET_INSTITUTION_MASTER_FORM_ERROR);
			}

		} catch (Exception e) {
			SessionErrors.add(actionRequest, OmsbMasterPortletKeys.SET_INSTITUTION_MASTER_FORM_ERROR);
			if (logger.isErrorEnabled()) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log logger = LogFactoryUtil.getLog(SaveOMSBCertificationMasterMVCActionCommand.class);
}

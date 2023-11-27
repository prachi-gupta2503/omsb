package gov.omsb.form.builder.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.RangeOptionMaster;
import gov.omsb.form.builder.portlet.util.FormDataUtil;
import gov.omsb.form.builder.portlet.util.RangeOptionMasterUtil;
import gov.omsb.form.builder.service.RangeOptionMasterLocalService;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
				"mvc.command.name=" + MVCCommandNames.SAVE_RANGE_OPTION 
				},
		service = MVCActionCommand.class
	)

public class SaveRangeOptionMVCActionCommand extends BaseMVCActionCommand{

	private static final Log log = LogFactoryUtil.getLog(SaveRangeOptionMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new RangeOptionMasterUtil(rangeOptionMasterLocalService);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		RangeOptionMaster rangeOptionMaster = null;
		log.info("Saving Range Option...");
		String redirectUrl = ParamUtil.getString(actionRequest, FormBuilderConstants.REDIRECT_URL, StringPool.BLANK);
		long rangeOptionId = ParamUtil.getLong(actionRequest, FormBuilderConstants.RANGE_OPTION_ID, 0);
		String rangeOptionName = ParamUtil.getString(actionRequest, FormBuilderConstants.RANGE_OPTION_NAME, StringPool.BLANK);
		log.info("Range Option Name: " + rangeOptionName);
		String encryptedRangeOptions = ParamUtil.getString(actionRequest, FormBuilderConstants.ENCRYPTED_RANGE_OPTIONS_DATA, StringPool.BLANK);
		String rangeOptions = FormDataUtil.decryptEncryptedData(encryptedRangeOptions);
		log.info("Range Options Data: " + rangeOptions);
		if(Validator.isNotNull(rangeOptionName)) {
			rangeOptionMaster = RangeOptionMasterUtil.saveRangeOption(themeDisplay, rangeOptionId, rangeOptionName, rangeOptions);
			log.info("Range Option Master: " + rangeOptionMaster);
		}
		actionResponse.sendRedirect(redirectUrl);
	}

	@Reference
	private RangeOptionMasterLocalService rangeOptionMasterLocalService;

}

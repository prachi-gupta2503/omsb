package gov.omsb.form.builder.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
		"mvc.command.name=" + MVCCommandNames.SWITCH_FORM_ACTION }, service = MVCActionCommand.class)
public class ResetFormPreferencesMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		portletPreferences.setValue(FormBuilderConstants.FORM_NAME, StringPool.BLANK);
		portletPreferences.setValue(FormBuilderConstants.FORM_MODE, FormBuilderConstants.VIEW);
		portletPreferences.setValue(FormBuilderConstants.FORM_VERSION, StringPool.BLANK);
		portletPreferences.setValue(FormBuilderConstants.WORKFLOW_DEFINITION, StringPool.BLANK);
		portletPreferences.store();

		actionRequest.setAttribute(FormBuilderConstants.IS_REQUIRED_PAGE_RELOAD, true);
	}

	Log log = LogFactoryUtil.getLog(ResetFormPreferencesMVCActionCommand.class.getName());

}
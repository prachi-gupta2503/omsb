package gov.omsb.leave.status.web.mvcaction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusWebPortletKeys;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.service.LeaveMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB,
		"mvc.command.name="
				+ OmsbLeaveStatusConstants.ADD_EDIT_RETURN_FROM_LEAVE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbAddReturnFromLeaveMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Date dateOfReturn = ParamUtil.getDate(actionRequest, OmsbLeaveStatusConstants.DATE_OF_RETURN,
				new SimpleDateFormat(OmsbLeaveStatusConstants.DD_MM_YYYY));
		Map<Locale, String> reasonForDelay = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbLeaveStatusConstants.REASON_FOR_DELAY);

		long leaveMasterId = ParamUtil.getLong(actionRequest, OmsbLeaveStatusConstants.LEAVE_MASTER_ID);

		LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveMasterId);

		leaveMaster.setReturnFromLeave(dateOfReturn);
		leaveMaster.setReasonForDelayMap(reasonForDelay);

		leaveMasterLocalService.updateLeaveMaster(leaveMaster);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(LeaveMaster.class.getName(), actionRequest);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(leaveMaster.getCompanyId(), leaveMaster.getGroupId(),
				leaveMaster.getCreatedBy(), LeaveMaster.class.getName(), leaveMaster.getLeaveMasterId(), leaveMaster,
				serviceContext);

	}

	@Reference
	private LeaveMasterLocalService leaveMasterLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbAddReturnFromLeaveMVCActionCommand.class.getName());

}

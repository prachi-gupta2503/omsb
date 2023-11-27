package gov.omsb.view.procedures.supervisor.web.mvccommands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.TraineeLoggedProcedureDetailsLocalService;
import gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys;
import gov.omsb.view.procedures.supervisor.web.util.OmsbViewProcedureSuperVisorGenerateUrlsUtil;
import gov.omsb.view.procedures.supervisor.web.util.OmsbViewProceduresSupervisorUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbViewProceduresSupervisorWebPortletKeys.OMSBVIEWPROCEDURESSUPERVISORWEB,
		"mvc.command.name="
				+ OmsbViewProceduresSupervisorWebPortletKeys.NOT_PASS_PRODCEDURE }, service = MVCActionCommand.class)
public class OmsbViewProceduresSupervisorNotPassMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("processAction Invoked ::: ");
		String tabName = ParamUtil.getString(actionRequest, OmsbViewProceduresSupervisorWebPortletKeys.TAB_NAME);

		String traineeLoggedProcedureDetailsIds = ParamUtil.getString(actionRequest,
				OmsbViewProceduresSupervisorWebPortletKeys.TRAINEE_LOGGED_PROCEDURE_DETAILS_IDS_FOR_NOT_PASS, "");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Map<Locale, String> supervisorCommentsMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbViewProceduresSupervisorWebPortletKeys.NOT_PASS_COMMENT);

		updateDetails(traineeLoggedProcedureDetailsIds, supervisorCommentsMap,
				OmsbViewProceduresSupervisorWebPortletKeys.STATUS_NOT_PASS, themeDisplay, actionRequest);

		actionRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.TAB_NAME, tabName);
		_logger.info("processAction Exit ::: ");
		return true;
	}

	private boolean updateDetails(String traineeLoggedProcedureDetailsIds, Map<Locale, String> supervisorCommentsMap,
			String procedureStatus, ThemeDisplay themeDisplay, ActionRequest actionRequest) {
		String[] ids = traineeLoggedProcedureDetailsIds.split(StringPool.COMMA);

		for (String id : ids) {
			if (Validator.isNotNull(id)) {
				try {
					TraineeLoggedProcedureDetails details = traineeLoggedProcedureDetailsLocalService
							.getTraineeLoggedProcedureDetails(Long.valueOf(id));
					details.setProcedureStatus(procedureStatus);
					details.setSupervisorCommentsMap(supervisorCommentsMap);
					traineeLoggedProcedureDetailsLocalService.updateTraineeLoggedProcedureDetails(details);
					ProcedureMaster procedureMaster = procedureMasterLocalService
							.getProcedureMaster(details.getProcedureId());

					String renderURL = OmsbViewProcedureSuperVisorGenerateUrlsUtil.createViewLogProcedureRenderUrl(
							themeDisplay, actionRequest, details.getProcedureId(), Boolean.TRUE);

					omsbViewProceduresSupervisorUtil.sendStatusChangedEmailNotification(details, procedureMaster,
							themeDisplay, renderURL);
					JSONObject payload = omsbViewProceduresSupervisorUtil.prepareStatusChangedWebNotificationPayload(
							details, procedureMaster, themeDisplay, renderURL);
					userNotificationEventLocalService.sendUserNotificationEvents(details.getTraineeId(),
							OmsbViewProceduresSupervisorWebPortletKeys.OMSBVIEWPROCEDURESSUPERVISORWEB,
							UserNotificationDeliveryConstants.TYPE_WEBSITE, payload);
				} catch (Exception e) {
					_logger.error(e);
				}
			}
		}
		return true;
	}
	
	@Reference
	private OmsbViewProceduresSupervisorUtil omsbViewProceduresSupervisorUtil;

	@Reference
	private TraineeLoggedProcedureDetailsLocalService traineeLoggedProcedureDetailsLocalService;

	@Reference
	private ProcedureMasterLocalService procedureMasterLocalService;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbViewProceduresSupervisorNotPassMVCActionCommand.class.getName());

}

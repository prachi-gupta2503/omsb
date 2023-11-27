package gov.omsb.trainee.level.web.portlet.mvccommands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.trainee.level.web.constants.OmsbTraineeLevelConstants;
import gov.omsb.trainee.level.web.constants.OmsbTraineeLevelWebPortletKeys;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTraineeLevelWebPortletKeys.OMSBTRAINEELEVELWEB,
		"mvc.command.name="
				+ OmsbTraineeLevelConstants.DELETE_TRAINEE_LEVEL_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbDeleteTraineeLevelMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.info("doProcessAction Invoked ::: ");
		long traineeLeMasterId = ParamUtil.getLong(actionRequest, OmsbTraineeLevelConstants.TRAINEE_LEVEL_MASTER_ID,
				GetterUtil.DEFAULT_LONG);
		traineeLevelMasterLocalService.deleteTraineeLevelMaster(traineeLeMasterId);
		_logger.debug("doProcessAction ::: Trainee Level Master Record Deleted");
		_logger.info("doProcessAction Exit ::: ");
	}

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteTraineeLevelMVCActionCommand.class.getName());
}
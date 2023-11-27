package gov.omsb.level.types.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.level.types.web.constants.OmsbLevelTypesWebPortletKeys;
import gov.omsb.tms.service.LevelTypeMasterLocalService;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLevelTypesWebPortletKeys.OMSBLEVELTYPESWEB,
"mvc.command.name=" + OmsbLevelTypesWebPortletKeys.DELETE_LEVEL_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteLevelTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		long LevelTypeMasterId = ParamUtil.getLong(actionRequest, OmsbLevelTypesWebPortletKeys.LEVEL_TYPE_MASTER_ID, 0);
		try {
			levelTypeMasterLocalService.deleteLevelTypeMaster(LevelTypeMasterId);
			_logger.info("ProcessAction ::: Level Type Master Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}

	@Reference
	private LevelTypeMasterLocalService levelTypeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteLevelTypeMVCActionCommand.class);

}

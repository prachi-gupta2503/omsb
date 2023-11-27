package gov.omsb.participation.type.web.portlet.mvccommands;

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

import gov.omsb.participation.type.web.constants.OmsbParticipationTypeWebPortletKeys;
import gov.omsb.tms.service.ParticipationTypeMasterLocalService;

/**
 * 
 * @author HP
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbParticipationTypeWebPortletKeys.OMSBPARTICIPATIONTYPEWEB,
"mvc.command.name=" + OmsbParticipationTypeWebPortletKeys.DELETE_PARTICIPATION_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteParticipationTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		//getting participation type id
		long participationTypeMasterId = ParamUtil.getLong(actionRequest, OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_MASTER_ID, 0);
		try {
			//delete participation type
			participationTypeMasterLocalService.deleteParticipationTypeMaster(participationTypeMasterId);
			_logger.debug("ProcessAction ::: Participation Type Master Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}
	
	@Reference
	private ParticipationTypeMasterLocalService participationTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteParticipationTypeMVCActionCommand.class.getName());


}

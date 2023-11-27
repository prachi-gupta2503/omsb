package gov.omsb.define.rotation.and.shared.rotations.web.mvccommands;

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

import gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbDefineRotationAndSharedRotationsWebPortletKeys.OMSBDEFINEROTATIONANDSHAREDROTATIONSWEB,
		"mvc.command.name="	+ OmsbDefineRotationAndSharedRotationsWebPortletKeys.DELETE_DRASR_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteDefineRotationAndSharedRotationsMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("processAction Invoked ::: ");
		
		long progdurationRotationTrainingsitesRelId = ParamUtil.getLong(actionRequest, OmsbDefineRotationAndSharedRotationsWebPortletKeys.PROG_DURATION_ROTATION_TRAINING_SITE_REL_ID , 0);
		if(progdurationRotationTrainingsitesRelId !=0) {
			try {
				progdurationRotationTrainingsitesRelLocalService.deleteProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRelId);
			} catch (PortalException e) {
				_logger.error(e);
				return false;
			}
		}
		
		_logger.info("processAction Exit ::: ");
		return true;
	}
	
	@Reference
	ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteDefineRotationAndSharedRotationsMVCActionCommand.class.getName());

}

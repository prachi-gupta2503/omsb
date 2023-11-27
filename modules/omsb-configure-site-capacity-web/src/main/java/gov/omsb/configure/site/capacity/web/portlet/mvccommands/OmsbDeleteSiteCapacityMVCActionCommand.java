package gov.omsb.configure.site.capacity.web.portlet.mvccommands;

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

import gov.omsb.configure.site.capacity.web.constants.OmsbConfigureSiteCapacityWebPortletKeys;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbConfigureSiteCapacityWebPortletKeys.OMSBCONFIGURESITECAPACITYWEB,
		"mvc.command.name="
				+ OmsbConfigureSiteCapacityWebPortletKeys.DELETE_SITE_CAPACITY_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbDeleteSiteCapacityMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");

		long siteCapacityId = ParamUtil.getLong(actionRequest,
				OmsbConfigureSiteCapacityWebPortletKeys.PROGDURATION_ROTATION_TS_REL_ID, 0);
		try {
			pdRotationTrainingsitesRelLocalService.deleteProgdurationRotationTrainingsitesRel(siteCapacityId);
			_logger.debug("ProcessAction ::: Site Capacity Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService pdRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteSiteCapacityMVCActionCommand.class.getName());

}

package gov.omsb.configure.site.capacity.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.configure.site.capacity.web.constants.OmsbConfigureSiteCapacityWebPortletKeys;
import gov.omsb.configure.site.capacity.web.util.OmsbSiteCapacityUtil;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbConfigureSiteCapacityWebPortletKeys.OMSBCONFIGURESITECAPACITYWEB,
		"mvc.command.name="
				+ OmsbConfigureSiteCapacityWebPortletKeys.SAVE_SITE_CAPACITY_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbSaveSiteCapacityMVCActionCommand implements MVCActionCommand {
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long siteCapacityId = ParamUtil.getLong(actionRequest,
				OmsbConfigureSiteCapacityWebPortletKeys.PROGDURATION_ROTATION_TS_REL_ID, 0);

		try {
			if (siteCapacityId != 0) {
				// Update Site Capacity
				isSuccess = updateSiteCapacity(actionRequest, siteCapacityId, themeDisplay);
			} else {
				// Create Site Capacity
				isSuccess = createSiteCapacity(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	private boolean updateSiteCapacity(ActionRequest actionRequest, long siteCapacityId, ThemeDisplay themeDisplay)
			throws PortalException {
		ProgdurationRotationTrainingsitesRel pdRotationTrainingsitesRel = pdRotationTrainingsitesRelLocalService
				.getProgdurationRotationTrainingsitesRel(siteCapacityId);
		if (Validator.isNotNull(pdRotationTrainingsitesRel)) {
			pdRotationTrainingsitesRelLocalService.updateProgdurationRotationTrainingsitesRel(OmsbSiteCapacityUtil
					.createSiteCapacityObject(actionRequest, pdRotationTrainingsitesRel, Boolean.FALSE, themeDisplay));
			_logger.debug("updateSiteCapacity ::: Site Capacity Record Updated");
		} else {
			_logger.debug("updateSiteCapacity ::: Site Capacity Record Not Found " + siteCapacityId);
			return false;
		}
		return true;

	}

	private boolean createSiteCapacity(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		try {
			long rotationId = ParamUtil.getLong(actionRequest, OmsbConfigureSiteCapacityWebPortletKeys.ROTATION,
					GetterUtil.DEFAULT_LONG);
			long programDurationId = ParamUtil.getLong(actionRequest, OmsbConfigureSiteCapacityWebPortletKeys.COHORT,
					GetterUtil.DEFAULT_LONG);
			long trainingSiteId = ParamUtil.getLong(actionRequest,
					OmsbConfigureSiteCapacityWebPortletKeys.TRAINING_SITE, GetterUtil.DEFAULT_LONG);
			ProgdurationRotationTrainingsitesRel pdRotationTrainingsitesRel = pdRotationTrainingsitesRelLocalService
					.findByProgDurationTrainingSitesAndRotationId(programDurationId, trainingSiteId, rotationId);
			if (Validator.isNotNull(pdRotationTrainingsitesRel)) {
				pdRotationTrainingsitesRelLocalService.updateProgdurationRotationTrainingsitesRel(
						OmsbSiteCapacityUtil.createSiteCapacityObject(actionRequest, pdRotationTrainingsitesRel,
								Boolean.FALSE, themeDisplay));
				_logger.debug("updateSiteCapacity ::: Site Capacity Record Updated");
			} else {
				_logger.debug("updateSiteCapacity ::: Site Capacity Record Not Found ");
				return false;
			}
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService pdRotationTrainingsitesRelLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveSiteCapacityMVCActionCommand.class.getName());

}

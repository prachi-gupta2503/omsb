package gov.omsb.configure.site.capacity.web.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;

import gov.omsb.configure.site.capacity.web.constants.OmsbConfigureSiteCapacityWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;

public class OmsbSiteCapacityUtil {

	private OmsbSiteCapacityUtil() {

	}

	public static ProgdurationRotationTrainingsitesRel createSiteCapacityObject(ActionRequest actionRequest,
			ProgdurationRotationTrainingsitesRel pdRotationTrainingsitesRel, boolean isCreate,
			ThemeDisplay themeDisplay) {
		_logger.info("createSiteCapacityObject Invoked ::: ");
		long rotationId = ParamUtil.getLong(actionRequest, OmsbConfigureSiteCapacityWebPortletKeys.ROTATION,
				GetterUtil.DEFAULT_LONG);
		long programDurationId = ParamUtil.getLong(actionRequest, OmsbConfigureSiteCapacityWebPortletKeys.COHORT,
				GetterUtil.DEFAULT_LONG);
		long trainingSiteId = ParamUtil.getLong(actionRequest, OmsbConfigureSiteCapacityWebPortletKeys.TRAINING_SITE,
				GetterUtil.DEFAULT_LONG);
		int noOfSlots = ParamUtil.getInteger(actionRequest, OmsbConfigureSiteCapacityWebPortletKeys.NO_OF_SLOTS);
		pdRotationTrainingsitesRel.setProgramDurationId(programDurationId);
		pdRotationTrainingsitesRel.setRotationId(rotationId);
		pdRotationTrainingsitesRel.setTrainingSitesId(trainingSiteId);
		pdRotationTrainingsitesRel.setNoOfSlots(noOfSlots);
		pdRotationTrainingsitesRel.setModifiedBy(themeDisplay.getUserId());
		pdRotationTrainingsitesRel.setGroupId(themeDisplay.getScopeGroupId());
		if (isCreate) {
			pdRotationTrainingsitesRel.setCreatedBy(themeDisplay.getUserId());
		}
		_logger.info("createSiteCapacityObject Exit ::: ");
		return pdRotationTrainingsitesRel;
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSiteCapacityUtil.class.getName());
}

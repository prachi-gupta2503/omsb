package gov.omsb.training.sites.web.portlet.mvccommands;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;
import gov.omsb.training.sites.web.portlet.util.OmsbTrainingSitesUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTrainingSitesWebPortletKeys.OMSBTRAININGSITESWEB,
		"mvc.command.name="
				+ OmsbTrainingSitesWebPortletKeys.TRAINING_SITES_LIST_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbTrainingSiteListMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Boolean trainingSiteStatus = ParamUtil.getBoolean(resourceRequest,
				OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_STATUS, Boolean.TRUE);

		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		List<TrainingSitesMaster> trainingSiteMasterList = new ArrayList<>();
		
		if (isSuperAdmin || isChairman) {
			trainingSiteMasterList = trainingSitesMasterLocalService.findByProgramStatus(trainingSiteStatus);
		} else {
			
			UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(
					themeDisplay.getPortalURL(), themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
			List<Long> ids = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
					.collect(Collectors.toList());

			_logger.debug("Program Id :: " + ids.toString()); 

			if(Validator.isNotNull(ids)) {
				trainingSiteMasterList = trainingSitesMasterLocalService.getTrainigSitesListByIdsAndStatus(ids, trainingSiteStatus);
			}
		}

		JSONObject resultJson = OmsbTrainingSitesUtil.prepareTrainingSiteResponseJson(resourceRequest, themeDisplay,
				trainingSiteMasterList);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("ServeResource Exit ::: ");
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTrainingSiteListMVCResourceCommand.class.getName());

}

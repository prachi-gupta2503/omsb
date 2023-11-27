package gov.omsb.rotations.web.portlet.mvccommands;

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
import gov.omsb.rotations.web.constants.OmsbRotationsWebPortletKeys;
import gov.omsb.rotations.web.portlet.util.OmsbRotationsUtil;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.service.RotationMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationsWebPortletKeys.OMSBROTATIONSWEB,
"mvc.command.name=" + OmsbRotationsWebPortletKeys.ROTATION_LIST_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbRotationListMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Boolean rotationStatus = ParamUtil.getBoolean(resourceRequest, OmsbRotationsWebPortletKeys.ROTATION_STATUS, Boolean.TRUE);
		
		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());
		
		List<RotationMaster> rotationMasterList = new ArrayList<>();
		
		if (isSuperAdmin || isChairman) {
			_logger.info("isSuperAdmin :: " + isSuperAdmin);
			_logger.info("isChairman :: " + isChairman);
			rotationMasterList = rotationMasterLocalService.findByRotationStatus(rotationStatus);
		} else {
			
			UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(
					themeDisplay.getPortalURL(), themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
			_logger.info("metadataItem  :: " + metadataItem);
			
			if(Validator.isNotNull(metadataItem)) {
				List<Long> ids = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
						.collect(Collectors.toList());
				_logger.info("ids  :: " + ids);
				for(long id : ids) {
					_logger.info("Program Id :: " + id); 
				}
				
				rotationMasterList = rotationMasterLocalService.getRotationListByIdsAndStatus(ids, rotationStatus);
				_logger.info("rotationMasterList  :: " + rotationMasterList);
			}
		
		}
		
		JSONObject resultJson = OmsbRotationsUtil.preapareRotationResponseJson(resourceRequest, themeDisplay, rotationMasterList);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		
		_logger.info("ServeResource Exit ::: ");
	}
	
	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbRotationListMVCResourceCommand.class.getName());

}

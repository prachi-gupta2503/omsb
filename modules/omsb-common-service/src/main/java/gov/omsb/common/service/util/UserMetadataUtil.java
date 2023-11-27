package gov.omsb.common.service.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.SauTrainingSitesItem;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, service = UserMetadataUtil.class)
public class UserMetadataUtil {

	public UserMetadataItem getUserMetadataItemsByLrUserId(String portalURL, long groupId, long userId) {
		_logger.info("getUserMetadataItemsByLrUserId Invoked :::");
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (userId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=lrUserId"
						+ URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				_logger.error(e);
			}
		}
		_logger.info("getUserMetadataItemsByLrUserId Exit ::: " + sbURL.toString());
		return getItems(sbURL.toString(), UserMetadataItem.class);
	}

	public UserMetadataItem getUserMetadataItemsByProgramId(String portalURL, long groupId, long programId) {
		_logger.info("getUserMetadataItemsByProgramId Invoked :::");
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (programId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=programId"
						+ URLEncoder.encode(" eq " + programId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				_logger.error(e);
			}
		}
		_logger.info("getUserMetadataItemsByProgramId Exit :::");
		return getItems(sbURL.toString(), UserMetadataItem.class);
	}

	public UserMetadataItem getUserMetadataItemsByProgramIdAndRoleId(String portalURL, long groupId, long programId, long roleId) {
		_logger.info("getUserMetadataItemsByProgramIdAndRoleId Invoked :::");
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (programId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=programId"
						+ URLEncoder.encode(" eq " + programId + " and ", DataflowConstants.UTF_8));
				sbURL.append("roleId"
						+ URLEncoder.encode(" eq " + StringPool.APOSTROPHE + roleId + StringPool.APOSTROPHE, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				_logger.error(e);
			}
		}
		_logger.info("getUserMetadataItemsByProgramIdAndRoleId Exit :::");
		return getItems(sbURL.toString(), UserMetadataItem.class);
	}
	
	public SauTrainingSitesItem getSauUserListByTrainingSite(String portalURL, long groupId, long trainingSiteId) {
		_logger.info("getSauUserListByTrainingSite Invoked :::" + trainingSiteId);
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_SAU_TRAINING_SITES_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (trainingSiteId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=trainingSitesId"
						+ URLEncoder.encode(" eq " + trainingSiteId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				_logger.error(e);
			}
		}
		_logger.info("getSauUserListByTrainingSite Exit :::");
		return getItems(sbURL.toString(), SauTrainingSitesItem.class);
	}

	private <T> T getItems(String url, Class<T> clazz) {
		String response = commonApi.getData(url);
		return CustomObjectMapperUtil.readValue(response, clazz);
	}

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	private static final Log _logger = LogFactoryUtil.getLog(UserMetadataUtil.class);
}

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
import gov.omsb.common.dto.RoleMappingItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;

@Component(immediate = true, service = RoleMappingUtil.class)
public class RoleMappingUtil {

	public RoleMappingItem getRoleIdsByRoleType(String portalURL, long groupId, String roleTypeName) {
		_logger.info("getRoleIdsByRoleType Invoked :::" + roleTypeName);
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.ROLE_MAPPING_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		_logger.info("sbUrl::::::" + sbURL);
		if (!roleTypeName.isEmpty()) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=roleType"
						+ URLEncoder.encode(" eq '" + roleTypeName + "'", DataflowConstants.UTF_8));
				_logger.info("sbUrl::::::after :::::::" + sbURL);
			} catch (UnsupportedEncodingException e) {
				_logger.error(e);
			}
		}
		_logger.info("getRoleIdsByRoleType Exit :::");
		return getItems(sbURL.toString(), RoleMappingItem.class);
	}

	private <T> T getItems(String url, Class<T> clazz) {
		String response = commonApi.getData(url);
		return CustomObjectMapperUtil.readValue(response, clazz);
	}

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	private static final Log _logger = LogFactoryUtil.getLog(RoleMappingUtil.class);
}

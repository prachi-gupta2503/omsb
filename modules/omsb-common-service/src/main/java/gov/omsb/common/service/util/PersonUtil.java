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
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, service = PersonUtil.class)
public class PersonUtil {

	public PersonItem getPersonItemsByLrUserId(String portalURL, long groupId, long userId) {
		_logger.info("getPersonItemsByLrUserId Invoked :::");
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_PERSON_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (userId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=lrUserId"
						+ URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				_logger.error(e);
			}
		}
		_logger.info("getPersonItemsByLrUserId Exit ::: " + sbURL.toString());
		return getItems(sbURL.toString(), PersonItem.class);
	}

	private <T> T getItems(String url, Class<T> clazz) {
		String response = commonApi.getData(url);
		_logger.info("Person object response ::: " + response);
		return CustomObjectMapperUtil.readValue(response, clazz);
	}

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	private static final Log _logger = LogFactoryUtil.getLog(PersonUtil.class);

}
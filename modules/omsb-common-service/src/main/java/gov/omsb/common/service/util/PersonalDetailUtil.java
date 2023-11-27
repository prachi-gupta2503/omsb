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
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, service = PersonalDetailUtil.class)
public class PersonalDetailUtil {

	public PersonalDetailItem getPersonalDetailItemsByPersonId(String portalURL, long groupId, long personId) {
		_logger.info("getPersonalDetailItemsByPersonId Invoked :::");
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_PERSONAL_DETAILS_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (personId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				_logger.error(e);
			}
		}
		_logger.info("getPersonalDetailItemsByPersonId Exit ::: " + sbURL.toString());
		return getItems(sbURL.toString(), PersonalDetailItem.class);
	}

	private <T> T getItems(String url, Class<T> clazz) {
		String response = commonApi.getData(url);
		_logger.info("Personal Detail object response ::: " + response);
		return CustomObjectMapperUtil.readValue(response, clazz);
	}

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	private static final Log _logger = LogFactoryUtil.getLog(EducationDetailsUtil.class);

}

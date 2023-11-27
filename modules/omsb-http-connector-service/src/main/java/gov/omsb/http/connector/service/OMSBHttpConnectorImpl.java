package gov.omsb.http.connector.service;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Http;

import java.io.IOException;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.http.connector.api.OMSBHttpConnector;

/**
 * @author AftabA
 */
@Component(immediate = true, service = OMSBHttpConnector.class)
public class OMSBHttpConnectorImpl implements OMSBHttpConnector {

	@Override
	public String getDataFlowAuthToken(String url, String payload) {
		logger.info("getDataFlowAuthToken invoking ::: ");
		try {
			Http.Options options = new Http.Options();
			options.setLocation(url);
			options.setBody(payload, StringPool.BLANK, StringPool.BLANK);
			options.setPost(true);
			//Http.Response response = options.getResponse();
			logger.info("getDataFlowAuthToken invocation successful ::: ");
			return http.URLtoString(options);
		} catch (IOException e) {
			logger.error("An Error occurred executing the get DataFlow Auth Token ::: " + e);
		}
		logger.info("getDataFlowAuthToken invocation Failed ::: ");
		return null;
	}

	@Override
	public String executeGet(String url, String payload, Map<String, String> headers) {
		logger.info("executeGet invoking ::: ");
		try {
			logger.info("inside try block >>>=========");
			Http.Options options = new Http.Options();
			options.setLocation(url);
			options.setHeaders(headers);
			options.setBody(payload, StringPool.BLANK, StringPool.BLANK);
			options.setPost(false);
			//Http.Response response = options.getResponse();
			return http.URLtoString(options);
		} catch (Exception e) {
			logger.error("An Error occurred in the executeGet()  ::: " + e);
		}
		logger.info("executeGet invocation successful ::: ");
		return null;
	}
	
	@Override
	public String executeGetWithTimeout(String url, String payload, int milliSeconds, Map<String, String> headers) {
		logger.info("executeGet invoking ::: ");
		try {
			logger.info("inside try block >>>=========");
			Http.Options options = new Http.Options();
			options.setLocation(url);
			options.setHeaders(headers);
			options.setBody(payload, StringPool.BLANK, StringPool.BLANK);
			options.setPost(false);
			options.setTimeout(milliSeconds);
			//Http.Response response = options.getResponse();
			
			String response = http.URLtoString(options);
			int statusCode = options.getResponse().getResponseCode();
			
			JSONObject jsonObject;
			if(statusCode == 200) {
				jsonObject = new JSONFactoryUtil().createJSONObject(response);
				jsonObject.put("statusCode", statusCode);
			}else {
				jsonObject = new JSONFactoryUtil().createJSONObject();
				jsonObject.put("statusCode", statusCode);
			}
			
			return jsonObject.toJSONString();
		} catch (Exception e) {
			logger.error("An Error occurred in the executeGet()  ::: " + e);
		}
		logger.info("executeGet invocation successful ::: ");
		return null;
	}

	@Override
	public String tokenExecutePost(String url, String payload, Map<String, String> headers) {

		logger.debug("Invoking the executPost method");
		try {
			StringBuilder urlBuilder = new StringBuilder(url);
			urlBuilder.append("?");
			urlBuilder.append(payload);
			String completeUrl = urlBuilder.toString();
			logger.debug("completeUrl is  >>>=========" + completeUrl);
			Http.Options options = new Http.Options();
			options.setLocation(completeUrl);
			if (!headers.isEmpty()) {
				options.setHeaders(headers);
			}
			//options.setBody("", "", ContentTypes.TEXT_XML_UTF8);
			options.setPost(true);
			Http.Response response = options.getResponse();
			logger.debug("response ??  ::: " + response.getResponseCode());
			logger.debug("executePost invocation successful");
			logger.debug("response>>>>>>>>>> " + http.URLtoString(options));
			return http.URLtoString(options);
		} catch (IOException e) {
			logger.error("An IO error occurred: " + e.getMessage());
			logger.debug("An IO error occurred: " + e);
		}
		return null;
	}

	@Override
	public String executePost(String url, String payload, Map<String, String> headers) {

		logger.info("Invoking the executPost method");
		try {
			Http.Options options = new Http.Options();
			options.setLocation(url);
			if (!headers.isEmpty()) {
				options.setHeaders(headers);
			}
			options.setBody(payload, "", "UTF-8");
			options.setPost(true);
			logger.info("executePost invocation successful");
			return http.URLtoString(options);
		} catch (IOException e) {
			logger.error("An IO error occurred: " + e.getMessage(), e);
		}
		return "saved";
	}
	
	@Override
	public String executePostWithTimeout(String url, String payload, int milliSeconds, Map<String, String> headers) {
		logger.info("executePostWithTimeout invoking ::: ");
		try {
			logger.info("inside try block >>>=========");
			Http.Options options = new Http.Options();
			
			options.setLocation(url);
			options.setHeaders(headers);
			options.setBody(payload, StringPool.BLANK, StringPool.BLANK);
			options.setPost(true);
			options.setTimeout(milliSeconds);
			return http.URLtoString(options);
		} catch (Exception e) {
			logger.error("An Error occurred in the executePostWithTimeout()  ::: " + e);
		}
		logger.info("executePostWithTimeout invocation successful ::: ");
		return null;
	}

	@Override
	public String executePut(String url, String payload, Map<String, String> headers) {
		logger.info("Invoking the executePut method ");

		try {
			Http.Options options = new Http.Options();
			options.setLocation(url);
			
			if (!headers.isEmpty()) {
				options.setHeaders(headers);
			}
			
			options.setBody(payload, "", "UTF-8");
			options.setPut(true);

			logger.info("executePut invocation successful11");
			return http.URLtoString(options);
		} catch (IOException e) {
			logger.debug("An IO error occurred: " + e.getMessage(), e);
		}
		return "updated successfully";
	}

	@Override
	public String executeDelete(String url, Map<String, String> headers) {
		logger.info("Invoking the executeDelete method ");
		try {
			Http.Options options = new Http.Options();
			options.setLocation(url);
			options.setHeaders(headers);
			options.setDelete(true);
			logger.info("executeDelete invocation successful");
			return http.URLtoString(options);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "deleted successfully";
	}

	@Reference
	private Http http;

	private static final Log logger = LogFactoryUtil.getLog(OMSBHttpConnectorImpl.class);
}

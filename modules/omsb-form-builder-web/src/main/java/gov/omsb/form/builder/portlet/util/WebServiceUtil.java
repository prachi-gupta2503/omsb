package gov.omsb.form.builder.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;

import java.util.Map;
import java.util.Map.Entry;

public class WebServiceUtil {
	private static Log log = LogFactoryUtil.getLog(WebServiceUtil.class);

	public static String post(String url, String body, Map<String, Object> headers, Map<String, Object> params) {
		String response = StringPool.BLANK;
		StringBuilder urlBuilder = new StringBuilder(url);
		
		Http.Options options = new Http.Options();
		options.setPost(Boolean.TRUE);
		
		// Set Additional Headers
		for (Entry<String, Object> entry : headers.entrySet()) {
			options.addHeader(entry.getKey(), String.valueOf(entry.getValue()));
		}
		
		// Set Body and Part based on content type
		if(ContentTypes.APPLICATION_JSON.equals(headers.get(HttpHeaders.CONTENT_TYPE))) {
			log.info("Body: "+body);
			if(!params.isEmpty()) {
				urlBuilder.append(StringPool.QUESTION);
				// Set Request params
				for (Entry<String, Object> entry : params.entrySet()) {
					urlBuilder.append(StringPool.AMPERSAND).append(entry.getKey().trim() + "=" +  String.valueOf(entry.getValue()).trim());
				}
			}
			options.setBody(body, ContentTypes.APPLICATION_JSON, StringPool.UTF8);
		}else if(ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED.equals(headers.get(HttpHeaders.CONTENT_TYPE))) {
			for (Entry<String, Object> entry : params.entrySet()) {
				options.addPart(entry.getKey().trim(), String.valueOf(entry.getValue()).trim());
			}
		}
		
		log.info("::: Post/Prepopulate Data API URL ::: >>> " + urlBuilder.toString());
		options.setLocation(urlBuilder.toString());
		log.info("options: "+options);
		try {
			response = HttpUtil.URLtoString(options);
		} catch (Exception e) {
			log.error("Error while invoking PostData/Prepopulate API." + e.getMessage(), e);
		}
		log.info("::: POST/Prepopulate DATA API invoke successfully ::: "+response);
		return response;
	}
}

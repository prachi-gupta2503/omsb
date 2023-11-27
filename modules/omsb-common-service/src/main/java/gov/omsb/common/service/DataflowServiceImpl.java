package gov.omsb.common.service;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.DataflowService;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.DataflowTokenDTO;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.endpoint.configuration.api.DataFlowConfiguration;
import gov.omsb.http.connector.api.OMSBHttpConnector;

/**
 * @author TusharT
 */

@Component(immediate = true, service = DataflowService.class)
public class DataflowServiceImpl implements DataflowService {

	@Override
	public String getAuthToken() {
		logger.info("Auth Token URL Function Started !");
		try {

			DataFlowConfiguration dataFlowConfiguration = provider.getSystemConfiguration(DataFlowConfiguration.class);
			String authTokenURL = dataFlowConfiguration.authTokenURL();
			logger.info("authTokenURL ?? " + authTokenURL);
			String authTokenUserName = dataFlowConfiguration.authTokenUserName();
			String authTokenPassword = dataFlowConfiguration.authTokenPassword();
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put("userName", authTokenUserName);
			object.put("password", authTokenPassword);
			String response = omsbHttpConnector.getDataFlowAuthToken(authTokenURL, object.toString());
			logger.info("response ??  !" + response);
			if (Validator.isNotNull(response)) {
				return getAccessTokenByResponse(response);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String getCaseDetail(String caseNumber) {
		DataFlowConfiguration dataFlowConfiguration;
		try {
			dataFlowConfiguration = provider.getSystemConfiguration(DataFlowConfiguration.class);
			String caseURL = dataFlowConfiguration.caseDetailURL().replace(CommonConstants.CASE_NUMBER, caseNumber);
			logger.info("caseURL :::: " + caseURL);
			String token = getAuthToken();
			if (Validator.isNotNull(token)) {
				Map<String, String> headers = new HashMap<>();
				headers.put(HttpHeaders.AUTHORIZATION, CommonConstants.BEARER + StringPool.SPACE + token);
				headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
				return omsbHttpConnector.executeGet(caseURL, StringPool.BLANK, headers);
			}
		} catch (ConfigurationException e) {
			logger.error("exception while getting the case details  "+e);
		}
		return null;
	}

	@Override
	public String getDocRespone(String caseNumber, String docId) {
		DataFlowConfiguration dataFlowConfiguration;
		try {
			dataFlowConfiguration = provider.getSystemConfiguration(DataFlowConfiguration.class);
			String docURL = dataFlowConfiguration.docResponeURL().replace(CommonConstants.CASE_NUMBER, caseNumber).replace(CommonConstants.DOCUMENT_ID_VAR, docId);
			logger.info(" Document docURL :::: " + docURL);
			String token = getAuthToken();
			logger.info("token token  ::::: "+token);
			Map<String, String> headers = new HashMap<>();
			headers.put(HttpHeaders.AUTHORIZATION, CommonConstants.BEARER+ StringPool.SPACE+token);
			headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
			return omsbHttpConnector.executeGet(docURL, StringPool.BLANK, headers);
		} catch (ConfigurationException e) {
			logger.error("exception while getting the doc response  "+e);
		}
		return null;
		
	}

	@Override
	public String getCaseReport(String caseNumber) {
		DataFlowConfiguration dataFlowConfiguration;
		try {
			dataFlowConfiguration = provider.getSystemConfiguration(DataFlowConfiguration.class);
			String caseURL = dataFlowConfiguration.caseReportURL().replace(CommonConstants.CASE_NUMBER, caseNumber);
			logger.info(" Case Report caseURL :::: " + caseURL);
			String token = getAuthToken();
			logger.info("token token  ::::: "+token);
			Map<String, String> headers = new HashMap<>();
			headers.put(HttpHeaders.AUTHORIZATION, CommonConstants.BEARER + StringPool.SPACE + token);
			headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
			return omsbHttpConnector.executeGet(caseURL, StringPool.BLANK, headers);
		} catch (ConfigurationException e) {
			logger.error("exception while getting the case report  "+e);
		}
		return null;
		
	}

	private String getAccessTokenByResponse(String response) {
		DataflowTokenDTO tokenDTO = CustomObjectMapperUtil.readValue(response, DataflowTokenDTO.class);
		logger.info("Access Token using custom object??? :::::: " +  tokenDTO.getMessage().getAccessToken());
		if (Validator.isNotNull(tokenDTO)) {
			return tokenDTO.getMessage().getAccessToken();
		}
		return null;
	}
	
	@Reference
	private ConfigurationProvider provider;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(DataflowServiceImpl.class);

}

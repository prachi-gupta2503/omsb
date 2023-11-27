package gov.omsb.qarar.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.endpoint.configuration.api.QararAPIConfiguration;
import gov.omsb.qarar.service.QararService;
import gov.omsb.qarar.service.QararUpdateServiceExecutor;
import gov.omsb.qarar.service.constants.APIFields;
import gov.omsb.qarar.service.constants.QararConstants;
import gov.omsb.qarar.service.dto.QararServiceResponse;
import gov.omsb.tms.model.QararRequest;
import gov.omsb.tms.service.QararRequestLocalServiceUtil;

/**
 * @author Jitendra
 */
@Component(immediate = true, property = {}, service = QararService.class)
public class QararServiceImpl implements QararService {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(QararServiceImpl.class);

	@Override
	public long createECMembershipQarar(String programName, String doctorName, long referenceId, String referenceClass, long userId, long companyId, long groupId) throws PortalException {

		Map<String, String> params = new HashMap<String, String>();
		params.put(APIFields.PROGRAM_NAME, programName);
		params.put(APIFields.DOCTOR_NAME, doctorName);
		params.put(APIFields.QARAR_TYPE, "7");
		params.put(APIFields.REFERENCE,"");
		
		String response = null;
		if("true".equalsIgnoreCase(PropsUtil.get("ec.member.qarar.api.disabled"))){
			LOGGER.info("---------------------------------generateQararResponse----------------------------------------------");
			response = generateQararResponse(referenceId);
		}else {
			LOGGER.info("---------------------------------callQararApi-------------------------------------------------------");
			response = callQararApi(params);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(	DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		QararServiceResponse qararServiceResponse = null;
		
		try {
			qararServiceResponse = objectMapper.readValue(response, QararServiceResponse.class);
			if(qararServiceResponse != null && qararServiceResponse.getStatusCode()==200) {
				long requestId = CounterLocalServiceUtil.increment(QararRequest.class.getName());
				QararRequest qararRequest = QararRequestLocalServiceUtil.createQararRequest(requestId);
				qararRequest.setCreatedBy(userId);
				qararRequest.setCompanyId(companyId);
				qararRequest.setCreateDate(new Date());
				qararRequest.setGroupId(groupId);
				qararRequest.setModifiedDate(new Date());
				qararRequest.setModifiedBy(userId);
				qararRequest.setDocTreeId(qararServiceResponse.getDocTreeId());
				qararRequest.setQararType(QararConstants.QARAR_TYPE_MEMBERSHIP);
				qararRequest.setReferenceId(referenceId);
				//qararRequest.setDocURL(qararServiceResponse.getPreviewLink());
				qararRequest.setReferenceClass(referenceClass);
				QararRequestLocalServiceUtil.updateQararRequest(qararRequest);
				
				String previewLink = qararServiceResponse.getPreviewLink();
				LOGGER.info("previewLink > "+previewLink);
				if(Validator.isNotNull(previewLink)) {
					try {
						ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
						Map<String, Serializable> taskContextMap = new HashMap<>();
						taskContextMap.put("docTreeId", qararServiceResponse.getDocTreeId());
						taskContextMap.put("serviceContext", serviceContext);
						taskContextMap.put("previewLink", previewLink);
						LOGGER.info("Test 1");
						// Adding the job to liferay background manager
						BackgroundTask backgroundTask = BackgroundTaskManagerUtil.addBackgroundTask(
								userId, groupId, QararUpdateServiceExecutor.class.getName(),
								QararUpdateServiceExecutor.class.getName(), taskContextMap, serviceContext);
						LOGGER.info("Test 11");

					} catch (Exception e) {
						LOGGER.error(e);
					}
				}
				
				return qararRequest.getQararRequestId();
			}else {
				throw new PortalException(qararServiceResponse.getStatusMsg());
			}
		} catch (JsonProcessingException e) {
			throw new PortalException(e.getMessage());
		}

	}

	private String generateQararResponse(long referenceId) {
		int rand = new Random().nextInt(99) + 100;
		long docTreeId = Long.parseLong(String.valueOf(referenceId)+String.valueOf(rand));
		String res = "{\"statusCode\":200,\"docTreeId\":\""+docTreeId+"\",\"statusMsg\":\"DocTreeId generated\",\"previewLink\":\"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf\"}";
		return res;
	}

	private String callQararApi(Map<String, String> params) throws PortalException {
		String responseStr = null;
		try {
			QararAPIConfiguration configuration = configurationProvider.getSystemConfiguration(QararAPIConfiguration.class);
			String qararApiURL = configuration.qararApiURL();

			Http.Options options = new Http.Options();
			options.setPost(true);

			options.addHeader(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED);
			options.setLocation(qararApiURL);

			for (Entry<String, String> entry : params.entrySet()) {
				options.addPart(entry.getKey().trim(), entry.getValue().trim());
			}

			Http.Response response = options.getResponse();
			responseStr = http.URLtoString(options);
			
			LOGGER.debug("response code > " + response.getResponseCode());
			
			LOGGER.debug("response > " + responseStr);

		} catch (IOException  | ConfigurationException ex) {
			LOGGER.equals(ex);
			throw new PortalException(ex.getMessage());
		}
		return responseStr;
	}

	@Reference(unbind = "-")
	private ConfigurationProvider configurationProvider;
	
	@Reference
	private Http http;

}
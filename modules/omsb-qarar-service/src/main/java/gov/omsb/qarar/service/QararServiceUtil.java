package gov.omsb.qarar.service;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;

import java.io.InputStream;
import java.io.Serializable;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.common.util.WorkflowUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.qarar.rs.QararRestService;
import gov.omsb.tms.model.QararRequest;

@Component(immediate = true, service = QararServiceUtil.class)
public class QararServiceUtil {

	private static final Log LOGGER = LogFactoryUtil.getLog(QararRestService.class);

	public void updateEntityStatus(QararRequest qararRequest) {
		if (qararRequest.getReferenceClass() == null || qararRequest.getReferenceClass().isBlank()) {
			return;
		}

		try {
			LOGGER.info("updateEntityStatus 1");
			WorkflowHandler workflowHandler = WorkflowHandlerRegistryUtil
					.getWorkflowHandler(qararRequest.getReferenceClass());
			WorkflowInstance workflowInstance = WorkflowUtil.getWorkflowInstace(qararRequest.getReferenceClass(),
					qararRequest.getReferenceId(), qararRequest.getCompanyId(), qararRequest.getGroupId());

			Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
			workflowContext.put("QARAR_DOC_ID", qararRequest.getQararDocId());
			workflowHandler.updateStatus(-1, workflowContext);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public long saveQararDoc(QararRequest qararRequest, String previewLink, long docTreeId) {
		long qararDocId = 0;
		LOGGER.info("QararRestService getQararDocIdByPreviewLink Method Called");
		InputStream inputStream = null;
		CloseableHttpClient httpClient = null;
		try
		{
			previewLink = previewLink.trim();
			// Create an instance of HttpClient
			if(previewLink.toUpperCase().startsWith("HTTPS")) {
				httpClient = getCloseableHttpClient();
			}else {
				httpClient = HttpClients.createDefault();
			}
			// Create an HTTP GET request
			HttpGet httpGet = new HttpGet(previewLink);
			// Execute the request and get the response
			HttpResponse response = httpClient.execute(httpGet);
			// Check the status code of the response
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				// Get the response entity (the content of the remote file)
				HttpEntity entity = response.getEntity();
				// Check if the entity is not null
				if (entity != null) {
					// Get the input stream from the entity
					inputStream = entity.getContent();
					//HttpServletRequest httpServletRequest = null;
					//ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),httpServletRequest);
					
					Role adminRole = RoleLocalServiceUtil.getRole(qararRequest.getCompanyId(),"Administrator");
					List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
					User user = null;
					if(adminUsers == null || adminUsers.size()<1) {
						user = UserLocalServiceUtil.getUser(qararRequest.getCreatedBy());
					}else {
						user = adminUsers.get(0);
					}
					PrincipalThreadLocal.setName(user.getUserId());
					PermissionChecker checker =PermissionCheckerFactoryUtil.create(user);
					PermissionThreadLocal.setPermissionChecker(checker);
					
					ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
					if(serviceContext == null) {
						 serviceContext = new ServiceContext();
						serviceContext.setUserId(user.getUserId());
						serviceContext.setScopeGroupId(qararRequest.getGroupId());
					}
					LOGGER.info("*********************** Test");
					//LOGGER.info(serviceContext.getUserId());
					serviceContext.setAddGuestPermissions(true);
					String fileName = "qarar_" + docTreeId + "_" + System.currentTimeMillis() + ".pdf";
					String mimeType = "application/pdf";
					DLFolder dLFolder = FileUploadUtil.getDLFolder(qararRequest.getGroupId(),
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "QARAR_Document");

					if (dLFolder == null) {
						dLFolder = FileUploadUtil.createDLFolder(qararRequest.getGroupId(), "QARAR_Document",
								DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, qararRequest.getCreatedBy(), StringPool.BLANK);
					}

					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(fileName, qararRequest.getGroupId(),
							dLFolder.getFolderId(), fileName, mimeType, fileName, StringPool.BLANK, StringPool.BLANK,
							fileName, inputStream, entity.getContentLength(), null, null, serviceContext);

					DocumentInfo documentInfo = saveDocumentInfo(qararRequest.getGroupId(), fileEntry.getFileEntryId(), fileName);
					qararDocId = documentInfo.getId();
					LOGGER.info("fileEntry.getFileEntryId()>" +fileEntry.getFileEntryId());
					LOGGER.info("qararDocId>" +qararDocId);
					
				}
			} else {
				// Handle the case where the remote file couldn't be fetched (e.g., log an// error)
				LOGGER.info("Failed to fetch remote file. Status code: " + statusCode);
			}
		}catch(Exception e){
			LOGGER.error(e);
		}finally {
			try {
				inputStream.close();
			} catch (Exception e) {
				// No need to handle
			}
			try {
				httpClient.close();
			} catch (Exception e) {
				// No need to handle
			}
		}
		return qararDocId;

	}
	
	public static CloseableHttpClient getCloseableHttpClient(){
	    CloseableHttpClient httpClient = null;
	    try {
	        httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
	                .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
	                {
	                    public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
	                    {
	                        return true;
	                    }

						@Override
						public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType)
								throws java.security.cert.CertificateException {
							// TODO Auto-generated method stub
							return true;
						}
	                }).build()).build();

	    } catch (KeyManagementException e) {
	        LOGGER.error("KeyManagementException in creating http client instance", e);
	    } catch (NoSuchAlgorithmException e) {
	        LOGGER.error("NoSuchAlgorithmException in creating http client instance", e);
	    } catch (KeyStoreException e) {
	        LOGGER.error("KeyStoreException in creating http client instance", e);
	    }
	    return httpClient;
	}
		
	private DocumentInfo saveDocumentInfo(long groupId, long fileEntryId, String fileName) {
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String payload = "{\"fileEntryID\": \"" + fileEntryId + "\", \"dFFileName\": \"" + fileName + "\"}";
		String url = getScopeURL(LRObjectURL.DOCUMENT_INFO_URL, groupId);
		String response = httpConnector.executePost(url, payload, headers);
		return CustomObjectMapperUtil.readValue(response, DocumentInfo.class);
	}

	private String getScopeURL(String url, long scopeId) {
		return omsbCommonApi.getBaseURL() + url.replace("{scope-id}", String.valueOf(scopeId));
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector httpConnector;
	

}

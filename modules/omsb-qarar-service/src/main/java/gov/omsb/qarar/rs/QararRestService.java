package gov.omsb.qarar.rs;

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
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

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
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.common.util.WorkflowUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.qarar.service.QararServiceUtil;
import gov.omsb.tms.model.QararRequest;
import gov.omsb.tms.service.QararRequestLocalServiceUtil;

/**
 * @author Jitendra
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/qarar",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=OMSB.Rest", "liferay.auth.verifier=false",
		"liferay.oauth2=false" }, service = Application.class)
public class QararRestService extends Application {

	private static final Log LOGGER = LogFactoryUtil.getLog(QararRestService.class);

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/test")
	@Produces("text/plain")
	public String working() {
		return "Test Qarar 1 -It works!";
	}

	@POST
	@Path("/update-status/{docTreeId}")
	@Produces("text/plain")
	public String updateStatus(@PathParam("docTreeId") long docTreeId, @QueryParam("previewLink") String previewLink,
			@Context HttpServletResponse response) {
		try {
			LOGGER.info("updateStatus docTreeId > "+docTreeId);
			LOGGER.info("updateStatus previewLink > "+previewLink);
			QararRequest qararRequest = QararRequestLocalServiceUtil.findByDocTreeId(docTreeId);
			
			long qararDocId = qararServiceUtil.saveQararDoc(qararRequest, previewLink,docTreeId);
			if(qararDocId <= 0 || previewLink == null || previewLink.isBlank()) {
				response.setStatus(404);
				return "Failure";
			}else {
				qararRequest.setDocURL(previewLink);
				qararRequest.setQararDocId(qararDocId);
				qararRequest.setModifiedDate(new Date());
				QararRequestLocalServiceUtil.updateQararRequest(qararRequest);
	
				qararServiceUtil.updateEntityStatus(qararRequest);
			}
		} catch (Exception ex ) {
			response.setStatus(404);
			return "Failure";
		}

		return "Success";
	}

	
	@Reference(unbind = "-")
	private QararServiceUtil qararServiceUtil;
	
}
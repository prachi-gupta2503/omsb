package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentTypesItem;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Tayyaba MM
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.DELETE_EVALUATED_CERTIFICATES
	    }, 
	    service = MVCResourceCommand.class
)

public class DeleteEvaluatedCertificatesMVCResourceCommand implements MVCResourceCommand{
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info(" deleteEvaluatedCertificates doServeResource::: Invoked >> ");

		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		long certificateDocInfoId = ParamUtil.getLong(resourceRequest, "certificateDocInfoId");
		long certFileEntryId = ParamUtil.getLong(resourceRequest, "fileEntryId");
		LOGGER.info(" certificateDocInfoId :: " + certificateDocInfoId + " certFileEntryId :: " + certFileEntryId);

		try {
			DLAppLocalServiceUtil.deleteFileEntry(certFileEntryId);
		} catch (PortalException e) {
			LOGGER.info(e.getMessage());
		}
		
		String deleteCertDocInfoURL = omsbCommonApi.getBaseURL() + LRObjectURL.DELETE_DOCINFO+ certificateDocInfoId;
		String documentInfoGetResponse = oMSBHttpConnector.executeGet(deleteCertDocInfoURL,StringPool.BLANK, headersInfo);
		oMSBHttpConnector.executeDelete(deleteCertDocInfoURL, headersInfo);
		if(Validator.isNotNull(documentInfoGetResponse)) {
			DocumentInfo docInfo = CustomObjectMapperUtil.readValue(documentInfoGetResponse, DocumentInfo.class);
			if(Validator.isNotNull(docInfo)) {
				String deleteCertEquivalencyDocTypeURL = omsbCommonApi.getBaseURL() + LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK + docInfo.getEquivalencyDocTypeId();
				String deleteCertEquivalencyDocType = oMSBHttpConnector.executeDelete(deleteCertEquivalencyDocTypeURL, headersInfo);
				LOGGER.info("deleteCertEquivalencyDocType  >>>>>>" +deleteCertEquivalencyDocType);
			
			}
			
		}
		
		return true;
	}
	
	
	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyPersonSearchMVCResourceCommand.class);
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
}

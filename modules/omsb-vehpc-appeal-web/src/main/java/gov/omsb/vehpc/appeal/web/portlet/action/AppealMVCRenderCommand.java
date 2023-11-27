package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.DocumentInfo;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyDecisionLevel;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyLevel;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.util.HeaderUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
		"mvc.command.name=" + AppealConstants.NEW_APPEAL_SAVE }, service = MVCRenderCommand.class)
public class AppealMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("calling here AppealMVCRenderCommand?? ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long decisionLevelId = ParamUtil.getLong(renderRequest, "equivalencyDecisionLevelId");
		
		
//		long decisionId = ParamUtil.getLong(renderRequest, "equivalencyDecisionId");
//		String decisionUrl = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL + "scopes/"
//				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
//		decisionUrl = decisionUrl + "filter=eQDecisionId"
//				+ URLEncoder.encode(" eq " + decisionId, StandardCharsets.UTF_8);
//		logger.info("decisionUrl ?? " + decisionUrl);
//		String response = omsbHttpConnector.executeGet(decisionUrl, "", headerUtil.getHeaders());
//		logger.info("response for appeal using EQ Decision Id?? " + response);
//		EquivalencyAppealItems equivalencyAppeal = CustomObjectMapperUtil.readValue(response,
//				EquivalencyAppealItems.class);
//		String docAppealId = "";
//		User appeallantUser = null;
//		String appealComments = "";
//		String createdDate = "";
//	
//		if (Validator.isNotNull(equivalencyAppeal.getItems()) && !equivalencyAppeal.getItems().isEmpty()) {
//			logger.info(" this is comments" + equivalencyAppeal.getItems().get(0).getComments());
//			logger.info(" this is comments" + equivalencyAppeal.getItems().get(0).getAppellantUserId());
//			appeallantUser = userLocalService.fetchUser(equivalencyAppeal.getItems().get(0).getAppellantUserId());
//			docAppealId = String.valueOf(equivalencyAppeal.getItems().get(0).getId());
//			appealComments = equivalencyAppeal.getItems().get(0).getComments();
//			createdDate = equivalencyAppeal.getItems().get(0).getDateCreated();
//		}

		String decisionsLevelurl = themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL
				+ decisionLevelId;
		String equivalencydecisionsurlresponse = omsbHttpConnector.executeGet(decisionsLevelurl, "", headerUtil.getHeaders());
		EquivalencyDecisionLevel decisionLevel = CustomObjectMapperUtil.readValue(equivalencydecisionsurlresponse, EquivalencyDecisionLevel.class);
		String comments = "";
		long decisiondocinfo = 0;
		String equivalencylevelkey = "";
		if (Validator.isNotNull(decisionLevel)) {
			EquivalencyLevel equivalencyLevelId = decisionLevel.getEquivalencyLevelId();
			if (Validator.isNotNull(equivalencyLevelId)) {
				equivalencylevelkey = equivalencyLevelId.getKey();
			}
			logger.info(equivalencylevelkey + "keeeeeeeeeeyyyyyyyyyyyyyyyyyyyyyyyyyyy this line ");
			comments = decisionLevel.getComments();
			decisiondocinfo = decisionLevel.getDocumentInfoId();
		}
		
		
		
		
		//// documentInfoId
		String decisonCertificateUrl = themeDisplay.getPortalURL() + AppealConstants.DECISION_CERTIFICATE_URL
				+ decisiondocinfo;
		logger.info("decisonCertificateUrl              " + decisonCertificateUrl);
		String decisionInfoUrlResponse = omsbHttpConnector.executeGet(decisonCertificateUrl, "",
				headerUtil.getHeaders());
		logger.info("decisionInfoUrlResponse ?? " + decisionInfoUrlResponse);
		DocumentInfo decisiondocumentInfo = CustomObjectMapperUtil.readValue(decisionInfoUrlResponse,
				DocumentInfo.class);
		long decisonFileEntryId = decisiondocumentInfo.getFileEntryID();
		String certificateFileName = "";
		String certificatefileUrl = getFileURL(decisonFileEntryId);
		
		FileEntry entry = appealUtil.getFileEntryById(decisonFileEntryId);
		if (Validator.isNotNull(entry)) {
			 String inputString = entry.getFileName();
			certificateFileName = inputString.replaceAll("^[0-9]+", "");
		}
		
		////
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(AppealConstants.PL_EQUIVALENCY_DOCUMENTS_TYPE_ERC, themeDisplay.getCompanyId());
			List<ListTypeEntry> documentTypelist = new ArrayList<>();
			documentTypelist = ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId());
			renderRequest.setAttribute("documentTypelist", documentTypelist);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		renderRequest.setAttribute("decisionLevelId", decisionLevelId);
		renderRequest.setAttribute("certificateName", certificateFileName);
		renderRequest.setAttribute("equivalencylevelkey", equivalencylevelkey);
		renderRequest.setAttribute("comments", comments);
		renderRequest.setAttribute("certificatefileurl", certificatefileUrl);
		return AppealConstants.NEW_APPEAL_SAVE_JSP;
	}

	private String getFileURL(long fileEntryId) {
		try {
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			String fileUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
			logger.info("url ?? " + fileUrl);
			return fileUrl;
		} catch (PortalException e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private UserLocalService userLocalService;
	
	@Reference
	private HeaderUtil headerUtil;
	
	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	private static final Log logger = LogFactoryUtil.getLog(AppealMVCRenderCommand.class);
}

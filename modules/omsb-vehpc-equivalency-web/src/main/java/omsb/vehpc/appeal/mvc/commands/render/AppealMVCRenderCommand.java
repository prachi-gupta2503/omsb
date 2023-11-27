package omsb.vehpc.appeal.mvc.commands.render;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.WorkSector;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EducationalDetailItem;
import omsb.vehpc.equivalency.dto.web.EmploymentDetail;
import omsb.vehpc.equivalency.dto.web.EmploymentDetailItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecision;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevel;
import omsb.vehpc.equivalency.dto.web.FocalPoint;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + AppealConstants.NEW_APPEAL_SAVE }, service = MVCRenderCommand.class)
public class AppealMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("calling here AppealMVCRenderCommand?? ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long equivalencyRequestId = ParamUtil.getLong(renderRequest, "equivalencyRequestId");
		long equivalencyAppealId = ParamUtil.getLong(renderRequest, "equivalencyAppealId");
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		boolean isAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN,
				themeDisplay.getUserId());
		boolean isEmployer = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.EMPLOYER,
				themeDisplay.getUserId());
		boolean isCommittee = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_COMMITTEE,
				themeDisplay.getUserId());
		boolean isRapporteur = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_RAPPORTEUR,
				themeDisplay.getUserId());
		
		EquivalencyDecisionItems equivalencyDecisionItems = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			// Get EQ Appeal Documents
			String eqAppealDocumentUrl = themeDisplay.getPortalURL() + AppealConstants.EQUIVALENCY_APPEAL_DOCUMENTS_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();

			eqAppealDocumentUrl = eqAppealDocumentUrl + StringPool.QUESTION + "filter=eQAppealId" + URLEncoder.encode(
					" eq " + equivalencyAppealId, OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);

			String decisionDocumentResponse = omsbHttpConnector.executeGet(eqAppealDocumentUrl, "",
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

			equivalencyDecisionItems = objectMapper.readValue(decisionDocumentResponse.toString(),
					new TypeReference<EquivalencyDecisionItems>() {
					});

		} catch (UnsupportedEncodingException | JsonProcessingException e1) {
			logger.error(e1.getMessage());
		}

		List<EquivalencyDecisionLevel> levelList = appealUtil.getDecisionLevelsByEqRequestId(themeDisplay,
				equivalencyRequestId);
		List<EquivalencyDecisionLevel> newLevelList = new ArrayList<>();
		if (Validator.isNotNull(levelList) && !levelList.isEmpty()) {
			for (EquivalencyDecisionLevel decisionLevel : levelList) {

				String decisonCertificateUrl = themeDisplay.getPortalURL() + AppealConstants.DECISION_CERTIFICATE_URL
						+ decisionLevel.getDocumentInfoId();
				String decisionInfoUrlResponse = omsbHttpConnector.executeGet(decisonCertificateUrl, "",
						headerUtil.getHeaders());
				DocumentInfo decisiondocumentInfo = CustomObjectMapperUtil.readValue(decisionInfoUrlResponse,
						DocumentInfo.class);
				FileEntry entry = null;
				if (Validator.isNotNull(decisiondocumentInfo)) {
					decisionLevel.setFileUrl(getFileURL(decisiondocumentInfo.getFileEntryID()));
					entry = appealUtil.getFileEntryById(decisiondocumentInfo.getFileEntryID());
				}

				if (Validator.isNotNull(entry)) {
					EducationalDetailItem eDetail = equivalencyUtil
							.getEducationDetailById(decisiondocumentInfo.getComponentClassRefId(), themeDisplay);
					decisionLevel.setFileName(eDetail.getQualificationAttained());
				}

				if (Validator.isNotNull(equivalencyDecisionItems) && equivalencyDecisionItems.getItems().size() > 0) {
					List<EquivalencyDecision> equivalencyDecisionList = equivalencyDecisionItems.getItems();
					equivalencyDecisionList.stream().anyMatch(eqDecision -> {
						if (eqDecision.getEqDecisionLevelId() == decisionLevel.getId()) {
							decisionLevel.setEquatedDoc(true);
							return true;
						}
						return false;
					});
				}

				newLevelList.add(decisionLevel);
			}
		}
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(AppealConstants.PL_EQUIVALENCY_DOCUMENTS_TYPE_ERC,
							themeDisplay.getCompanyId());
			List<ListTypeEntry> documentTypelist = ListTypeEntryLocalServiceUtil
					.getListTypeEntries(definition.getListTypeDefinitionId());
			renderRequest.setAttribute("documentTypelist", documentTypelist);
			renderRequest.setAttribute("decisionLevelList", newLevelList);
			renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);

			if (equivalencyAppealId > 0) {
				renderRequest.setAttribute("equivalencyAppealId", equivalencyAppealId);
				// Get Supporting Documents List
				String documentInfoUrl = themeDisplay.getPortalURL() + AppealConstants.DOCUMENT_INFO_CERTIFICATE_URL
						+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
				String encodedDocAppealId = URLEncoder.encode(String.valueOf(equivalencyAppealId),
						StandardCharsets.UTF_8);
				documentInfoUrl = documentInfoUrl + "filter=equivalencyAppealId"
						+ URLEncoder.encode(" eq " + encodedDocAppealId, StandardCharsets.UTF_8);
				String documentInfoUrlResponse = omsbHttpConnector.executeGet(documentInfoUrl, "",
						headerUtil.getHeaders());
				DocumentInfoItems documentInfoItems = CustomObjectMapperUtil.readValue(documentInfoUrlResponse,
						DocumentInfoItems.class);
				List<DocumentInfo> documentInfos = new ArrayList<>();
				if (Validator.isNotNull(documentInfoItems.getItems()) && !documentInfoItems.getItems().isEmpty()) {
					for (DocumentInfo info : documentInfoItems.getItems()) {
						String docsfileurl = appealUtil.getFileURL(info.getFileEntryID());
						info.setDocsfileurl(docsfileurl);

						ListTypeEntry documentTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
								"PL_EQUIVALENCY_DOCUMENTS_TYPE_ERC", info.getDocumentType(),
								themeDisplay.getCompanyId());
						if (Validator.isNotNull(documentTypeEntry)) {
							info.setEvaluateDocTypeName(documentTypeEntry.getName(themeDisplay.getLocale()));
						}

						documentInfos.add(info);
					}
				}
				renderRequest.setAttribute("supportingDocumentList", documentInfos);

				// Get Appeal Details
				String appealUrl = themeDisplay.getPortalURL() + AppealConstants.OB_EQUIVALENCY_APPEAL_URL
						+ equivalencyAppealId;
				String appealResponse = omsbHttpConnector.executeGet(appealUrl, "", headerUtil.getHeaders());
				EquivalencyAppeal equivalencyAppeal = CustomObjectMapperUtil.readValue(appealResponse,
						EquivalencyAppeal.class);

				String appealComment = equivalencyAppeal.getComments();
				renderRequest.setAttribute("appealComment", appealComment);
			}

		} catch (PortalException e) {
			e.printStackTrace();
		}
		String eqRequestResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + equivalencyRequestId,
				StringPool.BLANK, headersInfo);
		EquivalencyRequest equivalencyRequest = CustomObjectMapperUtil.readValue(eqRequestResponse, EquivalencyRequest.class);
		if(Validator.isNotNull(equivalencyRequest)) {
			if (!isEmployer) {
				FocalPoint focalPoint = new FocalPoint();
				User user;
				try {
					user = UserLocalServiceUtil
							.getUser(Long.valueOf(equivalencyRequest.getEmployerUserID()));
				focalPoint.setEmail(user.getEmailAddress());
				focalPoint.setName(user.getFullName());

				String personDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_PERSONAL_DETAILS_URL
						+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
						+ StringPool.QUESTION + "filter=lrUserId" + URLEncoder.encode(
								" eq " + equivalencyRequest.getEmployerUserID(), DataflowConstants.UTF_8);
				PersonalDetailItem personalDetailItem = CustomObjectMapperUtil
						.readValue(omsbCommonApi.getData(personDetailsUrl), PersonalDetailItem.class);
				if (Validator.isNotNull(personalDetailItem)
						&& Validator.isNotNull(personalDetailItem.getItems())
						&& personalDetailItem.getItems().size() > 0) {
					focalPoint.setMobileNumber(personalDetailItem.getItems().get(0).getMobileNumber());
					}
					renderRequest.setAttribute("focalPoint", focalPoint);
				} catch (PortalException | UnsupportedEncodingException e) {
					logger.error("Error in getting focal point Details" + e.getMessage());
				}
			}
		}
		String personURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSON_BY_ID_URL2 + equivalencyRequest.getPersonId();
		String personResponse = omsbHttpConnector.executeGet(personURL, StringPool.BLANK, headersInfo);
		Person person = CustomObjectMapperUtil.readValue(personResponse, Person.class);
		if(Validator.isNotNull(person)) {
			String passportNumber = person.getPassportNumber();
			String dateOfBirth = omsbCommonApi.convertDateFormatToDDMMYYYY(person.getDateOfBirth());
			renderRequest.setAttribute("passportNumber", passportNumber);
			renderRequest.setAttribute("dateOfBirth", dateOfBirth);
		}
		
		String getPersonalDetailsURL = themeDisplay.getPortalURL()+
				LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL2 +themeDisplay.getScopeGroupId() + "?filter=personId%20eq%20" + equivalencyRequest.getPersonId();
		String personalDetailRes = omsbHttpConnector.executeGet(getPersonalDetailsURL, StringPool.BLANK, headersInfo);

		PersonalDetailItems personalDetailsItems = CustomObjectMapperUtil.readValue(personalDetailRes,
				PersonalDetailItems.class);

		if (Validator.isNotNull(personalDetailsItems) && personalDetailsItems.getItems().size() > 0) {
			if (Validator.isNotNull(personalDetailsItems.getItems().get(0).getProfession())) {
				ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						OmsbVehpcEquivalencyWebPortletKeys.PROFESSION_ERC,
						personalDetailsItems.getItems().get(0).getProfession(), themeDisplay.getCompanyId());
				if (Validator.isNotNull(entry)) {
					String proffesion = entry.getName(themeDisplay.getLocale());
					personalDetailsItems.getItems().get(0).setProfession(proffesion);
				}
			}

			long natinalityCountryId = personalDetailsItems.getItems().get(0).getNationalityCountryId();
			/* Custom country */
			Country country = null;
			String countryName = "";
			if (natinalityCountryId > 0) {
				try {
					country = countryLocalService.getCountry(natinalityCountryId);
				} catch (PortalException e) {
					logger.error("Exception while getting the country ", e);
				}
			}
			if (Validator.isNotNull(country)) {
				countryName =country.getName(themeDisplay.getLocale());
			}
			
			/*Primary Specialty*/
			long primarySpecialtyId = personalDetailsItems.getItems().get(0).getPrimarySpeciality();
			if(Validator.isNotNull(primarySpecialtyId)) {
				ListTypeEntry primarySpecialtyListTypeEntry =omsbCommonApi.getListTypeEntryBylistTypeEntryId(primarySpecialtyId);
				if(Validator.isNotNull(primarySpecialtyListTypeEntry)) {
					renderRequest.setAttribute("primarySpecialty", primarySpecialtyListTypeEntry.getName(themeDisplay.getLocale()));
				}
			}
			
			renderRequest.setAttribute("personNatinality", countryName);
			renderRequest.setAttribute("personalDetail", personalDetailsItems.getItems().get(0));
		}
		renderRequest.setAttribute("isVEHPCEmployer", isEmployer);
		renderRequest.setAttribute("isVEHPCAdmin", isAdmin);
		renderRequest.setAttribute("isVEHPCCommittee", isCommittee);
		renderRequest.setAttribute("isVEHPCRapporteur", isRapporteur);
		renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);
		
			
		return AppealConstants.NEW_APPEAL_SAVE_JSP;
	}

	private String getFileURL(long fileEntryId) {
		try {
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			String fileUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
			logger.info("url ?? " + fileUrl);
			return fileUrl;
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
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

	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;
	
	@Reference
	private CountryLocalService countryLocalService;

	private static final Log logger = LogFactoryUtil.getLog(AppealMVCRenderCommand.class);
}

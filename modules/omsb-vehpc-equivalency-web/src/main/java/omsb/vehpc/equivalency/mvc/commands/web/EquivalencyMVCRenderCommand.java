package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.EquivalencyRequestStatusEnum;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyCertificate;
import omsb.vehpc.appeal.preferences.AppealConfiguration;
import omsb.vehpc.equivalency.dto.web.EquivalencyAllRequests;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecision;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;
import omsb.vehpc.equivalency.workflow.web.JspTransitionWorkflowHandler;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class EquivalencyMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		boolean isAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN,
				themeDisplay.getUserId());
		boolean isEmployer = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.EMPLOYER,
				themeDisplay.getUserId());
		boolean isCommittee = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_COMMITTEE,
				themeDisplay.getUserId());
		boolean isRapporteur = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_RAPPORTEUR,
				themeDisplay.getUserId());

		long completedStatusId = 0;
		ListTypeEntry completedStatusListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
				LRPicklistConstants.PL_EQUIVALENCY_STATUS, EquivalencyRequestStatusEnum.COMPLETED.getText(),
				themeDisplay.getCompanyId());
		if (Validator.isNotNull(completedStatusListTypeEntry)) {
			completedStatusId = completedStatusListTypeEntry.getListTypeEntryId();
		}

		long initiatedStatusId = 0;
		ListTypeEntry initiateStatusListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
				LRPicklistConstants.PL_EQUIVALENCY_STATUS, EquivalencyRequestStatusEnum.INITIATED.getText(),
				themeDisplay.getCompanyId());

		if (Validator.isNotNull(initiateStatusListTypeEntry)) {
			initiatedStatusId = initiateStatusListTypeEntry.getListTypeEntryId();
		}

		long employerDraftStatusId = 0;
		ListTypeEntry employerDraftListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
				LRPicklistConstants.PL_EQUIVALENCY_STATUS, EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText(),
				themeDisplay.getCompanyId());

		if (Validator.isNotNull(employerDraftListTypeEntry)) {
			employerDraftStatusId = employerDraftListTypeEntry.getListTypeEntryId();
		}

		// Get Equivalencies
		String equivalencyRquestsURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_REQUESTS_URL,
				themeDisplay.getScopeGroupId()) + "?sort=id:desc&pageSize=0";

		if (isEmployer) {
			equivalencyRquestsURL = equivalencyRquestsURL + "&filter=employerUserID"
					+ URLEncoder.encode(" eq " + themeDisplay.getUserId(), StandardCharsets.UTF_8);
		} else {
			if (isCommittee || isRapporteur) {
				// Get Equivalencies with "Received" status
				if (initiatedStatusId > 0 && completedStatusId > 0) {
					equivalencyRquestsURL = equivalencyRquestsURL + "&filter=equivalencyStatusId"
							+ URLEncoder.encode(
									" eq " + initiatedStatusId + " or equivalencyStatusId eq " + completedStatusId,
									StandardCharsets.UTF_8);
				}
			} else if (isAdmin && employerDraftStatusId > 0) {
				// Get Equivalency with non "employer draft" status
				equivalencyRquestsURL = equivalencyRquestsURL + "&filter=equivalencyStatusId"
						+ URLEncoder.encode(" ne " + employerDraftStatusId, StandardCharsets.UTF_8);

			}
		}

		try {

			List<EquivalencyRequest> equivalencyRequestList = equivalencyUtil
					.getEquivalencyRequestList(equivalencyRquestsURL);

			if (Validator.isNotNull(equivalencyRequestList)) {
				List<EquivalencyAllRequests> equivalencyRequests = new ArrayList<>();

				for (EquivalencyRequest equivalencyRequest : equivalencyRequestList) {
					long equivalencyRequestId = equivalencyRequest.getId();
					long eqAppealId =0;
					EquivalencyAllRequests equivalencyAllRequests = new EquivalencyAllRequests();

					if (completedStatusId > 0 && equivalencyRequest.getEquivalencyStatusId() == completedStatusId) {

						// Get Equivalency appeal
						String getAppealUrl = themeDisplay.getPortalURL() + AppealConstants.OB_EQUIVALENCY_APPEAL_URL
								+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
								+ StringPool.QUESTION;
						if (isEmployer) {
							getAppealUrl = getAppealUrl + "filter=eQRequestedId"
									+ URLEncoder.encode(" eq " + equivalencyRequestId, StandardCharsets.UTF_8);
						} else {
							if ((isCommittee || isRapporteur) && initiatedStatusId > 0) {
								// Get Appeals with Received status
								getAppealUrl = getAppealUrl + "filter=eQRequestedId" + URLEncoder.encode(
										" eq " + equivalencyRequestId + " and statusID eq '" + initiatedStatusId + "'",
										StandardCharsets.UTF_8);
							} else if (isAdmin && employerDraftStatusId > 0) {
								// Get Appeals with non "employer draft" status
								getAppealUrl = getAppealUrl + "filter=eQRequestedId"
										+ URLEncoder.encode(" eq " + equivalencyRequestId + " and statusID ne '"
												+ employerDraftStatusId + "'", StandardCharsets.UTF_8);
							}

						}

						List<EquivalencyAppeal> equivalencyAppealList = equivalencyUtil.getAppealList(getAppealUrl);
						EquivalencyAppeal equivalencyAppeal = null;
						if (Validator.isNotNull(equivalencyAppealList) && equivalencyAppealList.size() > 0) {
							equivalencyAppeal = equivalencyAppealList.get(0);
						}
						if (Validator.isNotNull(equivalencyAppeal)) {
							long equivalencyAppealStatusId = equivalencyAppeal.getStatusID();

							// Skip the request for Committee and Rapporteur users if Appeal status is not
							// Initiated
							if ((isCommittee || isRapporteur) && equivalencyAppealStatusId != initiatedStatusId) {
								continue;
							}

							eqAppealId = Long.valueOf(equivalencyAppeal.getId());
							equivalencyAllRequests.setAppealId(eqAppealId);

							ListTypeEntry listTypeEntry = null;
							if (isCommittee || isRapporteur) {
								listTypeEntry = initiateStatusListTypeEntry;
							} else {
								listTypeEntry = ListTypeEntryLocalServiceUtil
										.fetchListTypeEntry(equivalencyAppealStatusId);
							}

							if (Validator.isNotNull(listTypeEntry)) {
								String equivalencyAppealStatusKey = listTypeEntry.getKey();
								equivalencyAllRequests.setAppealStatusKey(equivalencyAppealStatusKey);
								String appealStatusToDisplay = equivalencyUtil.getFinalStatus(isEmployer, isCommittee,
										isAdmin, isRapporteur, equivalencyAppealStatusKey);
								String valueOfAppealStatusToDisplay = equivalencyUtil.getFinalStatusValue(isAdmin,
										isEmployer, appealStatusToDisplay, themeDisplay, equivalencyAppealStatusKey);

								equivalencyAllRequests.setAppealStatus(valueOfAppealStatusToDisplay);
								appealStatusToDisplay = appealStatusToDisplay.toLowerCase();
								LOGGER.info("appealStatusToDisplay >>>>>>>>>>>>>>> " + appealStatusToDisplay);
								if (Validator.isNotNull(appealStatusToDisplay) && Validator.isNotNull(
										EquivalencyRequestStatusEnum.getStatusByLabel(appealStatusToDisplay))) {
									equivalencyAllRequests.setAppealStatusColorClass(EquivalencyRequestStatusEnum
											.getStatusByLabel(appealStatusToDisplay).getColor());
								}

								if (listTypeEntry.getKey().equalsIgnoreCase("Insufficient")) {
									equivalencyAllRequests.setResubmit(true);
								}

							}

						} else {
							if (isCommittee || isRapporteur) {
								continue;
							}
							equivalencyAllRequests = fillEquivalencyRequestWhenAppealIsNotCreated(
									equivalencyAllRequests, equivalencyRequestId, renderRequest, themeDisplay,
									headersInfo);
						}
					} else {
						equivalencyAllRequests = fillEquivalencyRequestWhenAppealIsNotCreated(equivalencyAllRequests,
								equivalencyRequestId, renderRequest, themeDisplay, headersInfo);
					}

					// setting eq. request status
					if (equivalencyRequest.getEquivalencyStatusId() > 0) {
						ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil
								.fetchListTypeEntry(equivalencyRequest.getEquivalencyStatusId());
						if (Validator.isNotNull(listTypeEntry)) {
							equivalencyAllRequests.setStatusKey(listTypeEntry.getKey());
							String equivalencyStatusToDisplay = equivalencyUtil.getFinalStatus(isEmployer, isCommittee,
									isAdmin, isRapporteur, listTypeEntry.getKey());

							equivalencyAllRequests.setStatus(equivalencyUtil.getFinalStatusValue(isAdmin, isEmployer,
									equivalencyStatusToDisplay, themeDisplay, listTypeEntry.getKey()));
							equivalencyStatusToDisplay = equivalencyStatusToDisplay.toLowerCase();
							if (Validator.isNotNull(equivalencyStatusToDisplay) && Validator.isNotNull(
									EquivalencyRequestStatusEnum.getStatusByLabel(equivalencyStatusToDisplay))) {
								equivalencyAllRequests.setStatusColorClass(EquivalencyRequestStatusEnum
										.getStatusByLabel(equivalencyStatusToDisplay).getColor());
							}
						}
					}

					try {
						equivalencyAllRequests.setCreatedBy(
								userLocalService.getUser(equivalencyRequest.getEmployerUserID()).getFullName());
					} catch (PortalException e) {
						LOGGER.error(e.getMessage());
					}
					equivalencyAllRequests.setEquivalencyRequestId(equivalencyRequestId);
					equivalencyAllRequests.setDateCreated(
							omsbCommonApi.convertObjectDateToDDMMYYYYDate(equivalencyRequest.getDateCreated()));

					equivalencyAllRequests.setPersonId(equivalencyRequest.getPersonId());
					equivalencyAllRequests.setTransitions(
							JspTransitionWorkflowHandler.equivalencyRequestJspTransitionHandler(themeDisplay,
									getObjectClassName(themeDisplay.getCompanyId()), equivalencyRequestId));

					try {
//						String getPersonByIdURL = generateScopeListURL(LRObjectURL.GET_PERSON_BY_ID_URL,
//								themeDisplay.getScopeGroupId());
//						String finderQueryPerson = StringPool.QUESTION + "filter=id" + URLEncoder
//								.encode(" eq '" + equivalencyRequest.getPersonId() + "'", DataflowConstants.UTF_8);
//						LOGGER.info("getPersonByIdURL : " + getPersonByIdURL + finderQueryPerson);
//						String personRes = oMSBHttpConnector.executeGet(getPersonByIdURL + finderQueryPerson, "",
//								headersInfo);
//
//						equivalencyAllRequests
//								.setDateOfbirth(JSONFactoryUtil.createJSONObject(personRes).getString("dateofBirth"));

						String getPersonDetailsURL = generateScopeListURL(
								LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL, themeDisplay.getScopeGroupId());
						String finderQueryPersonDetails = StringPool.QUESTION + "filter=personId"
								+ URLEncoder.encode(" eq " + equivalencyRequest.getPersonId(), DataflowConstants.UTF_8);
						LOGGER.info("getPersonDetailsURL : " + getPersonDetailsURL + finderQueryPersonDetails);
						String personDetailRes = oMSBHttpConnector
								.executeGet(getPersonDetailsURL + finderQueryPersonDetails, "", headersInfo);

						PersonalDetailItems personalDetailItems = CustomObjectMapperUtil.readValue(personDetailRes,
								PersonalDetailItems.class);
						if (Validator.isNotNull(personalDetailItems) && personalDetailItems.getItems().size() > 0) {
							LOGGER.info("getPersonDetailsURL : " + getPersonDetailsURL + finderQueryPersonDetails);
							equivalencyAllRequests
									.setEmployeeName(personalDetailItems.getItems().get(0).getGivenNameAsPassport());
						}
						//Get Equivalency Certificate
						if(Validator.isNotNull(equivalencyAllRequests.getAppealStatusKey()) && equivalencyAllRequests.getAppealStatusKey().equals("completed")) {
							String equivalencyCertificateFileUrl = equivalencyUtil.getEquivalencyCertificateByEquivalencyAppealId(eqAppealId,themeDisplay.getScopeGroupId());
							if(Validator.isNotNull(equivalencyCertificateFileUrl)) {
								equivalencyAllRequests.setCertificateFileUrl(equivalencyCertificateFileUrl);
							}
						}else if(equivalencyAllRequests.getStatusKey().equals("completed")) {
							String equivalencyCertificateFileUrl = equivalencyUtil.getEquivalencyCertificateByEquivalencyRequestId(equivalencyRequestId,themeDisplay.getScopeGroupId());
							if(Validator.isNotNull(equivalencyCertificateFileUrl)) {
								equivalencyAllRequests.setCertificateFileUrl(equivalencyCertificateFileUrl);
							}
							
						}

//						String getCaseRequestURL = generateScopeListURL(LRObjectURL.CASE_REQUEST_URL,
//								themeDisplay.getScopeGroupId());
//						LOGGER.info("getCaseRequestURL : " + getCaseRequestURL + finderQueryPersonDetails);
//						String caseRequestRes = oMSBHttpConnector
//								.executeGet(getCaseRequestURL + finderQueryPersonDetails, "", headersInfo);
//						LOGGER.info("getCaseRequestURL caseRequestRes::::" + caseRequestRes);
//						CaseRequest caseRequest = CustomObjectMapperUtil.readValue(caseRequestRes, CaseRequest.class);
//						if (Validator.isNotNull(caseRequest) && caseRequest.getItems().size() > 0) {
//							LOGGER.info("getCaseRequestURL : " + getCaseRequestURL + finderQueryPersonDetails);
//							equivalencyAllRequests.setCaseNumber(caseRequest.getItems().get(0).getCaseNumber());
//							equivalencyAllRequests.setVerificationDate(omsbCommonApi.convertObjectDateToDDMMYYYYDate(
//									caseRequest.getItems().get(0).getVerificationDate()));
//						}
						equivalencyRequests.add(equivalencyAllRequests);

					} catch (NullPointerException | UnsupportedEncodingException e) {
						LOGGER.error(e.getMessage());
					}
				}
				renderRequest.setAttribute("equivalencyRequests", equivalencyRequests);
			}
		} catch (NullPointerException e) {
			LOGGER.error(e.getMessage(), e);
		}

		/* Equivalency Status pickList dropdown */
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_Equivalency_Status",
							PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("equivalencyStatusList",
					ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		renderRequest.setAttribute("isAdmin", isAdmin);
		renderRequest.setAttribute("isEmployer", isEmployer);
		renderRequest.setAttribute("isCommittee", isCommittee);
		renderRequest.setAttribute("isRapporteur", isRapporteur);
		return EquivalencyJSPPathConstants.EQUIVALENCY_JSP;
	}

	private EquivalencyAllRequests fillEquivalencyRequestWhenAppealIsNotCreated(
			EquivalencyAllRequests equivalencyAllRequests, long equivalencyRequestId, RenderRequest renderRequest,
			ThemeDisplay themeDisplay, Map<String, String> headersInfo) {
		equivalencyAllRequests.setAppealStatus("Not Initiated");
		equivalencyAllRequests.setAppealStatusColorClass(EquivalencyRequestStatusEnum
				.getStatusByLabel(EquivalencyRequestStatusEnum.NOT_INITIATED.getText().toLowerCase()).getColor());

		try {

			// To Check appeal validity starts
			String eqDecisionsUrl = themeDisplay.getPortalURL() + AppealConstants.EQUIVALENCY_DECISION_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
			eqDecisionsUrl = eqDecisionsUrl + "filter=equivalencyRequestId"
					+ URLEncoder.encode(" eq " + equivalencyRequestId, StandardCharsets.UTF_8);

			String eqDecisionsResponse = oMSBHttpConnector.executeGet(eqDecisionsUrl, "", headersInfo);

			EquivalencyDecisionItems equivalencyDecisionItems = CustomObjectMapperUtil.readValue(eqDecisionsResponse,
					EquivalencyDecisionItems.class);

			for (EquivalencyDecision equivalencyDecision : equivalencyDecisionItems.getItems()) {

				if (Validator.isNotNull(equivalencyDecision.getDateModified())) {
					if (Validator.isNotNull(equivalencyDecision.getEquivalencyStatus())
							&& equivalencyDecision.getEquivalencyStatus().getName().equalsIgnoreCase("Completed")) {
						String modifiedDateString = equivalencyDecision.getDateModified();

						AppealConfiguration messageDisplayConfiguration = (AppealConfiguration) renderRequest
								.getAttribute(AppealConfiguration.class.getName());
						PortletPreferences portletPreserence = renderRequest.getPreferences();
						String tagName = StringPool.BLANK;

						if (messageDisplayConfiguration != null) {
							tagName = portletPreserence.getValue("appealValidity",
									String.valueOf(messageDisplayConfiguration.appealValidity()));
						}

						int appealValidityValue = Integer.parseInt(tagName);

						LocalDate today = null;
						boolean isAppealAllowed = false;
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						if (Validator.isNotNull(modifiedDateString)) {
							Date date;

							date = formatter.parse(modifiedDateString);

							Date currentDate = new Date();
							LocalDate modifiedLocalDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

							LocalDate afterAppealDays = modifiedLocalDate.plusDays(appealValidityValue);

							today = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

							isAppealAllowed = afterAppealDays.isAfter(today);

						}
						equivalencyAllRequests.setAppealValidity(isAppealAllowed);

					}
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return equivalencyAllRequests;

	}

	private String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL()
				+ equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}

	private String getObjectClassName(long companyId) {
		try {
			ObjectDefinition definition = objectDefinitionService
					.getObjectDefinitionByExternalReferenceCode("OB_EUIVALENCY_REQUEST_ERC", companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Reference(unbind = "-")
	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;

	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyMVCRenderCommand.class);
}

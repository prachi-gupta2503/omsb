package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.DD_MM_YYYY;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EQ;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.FILTER;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PROGRAM_LIST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ROLE_LIST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.SINGLE_QUOTE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.UNICODE_TRANSFORMATION_FORMAT;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.dto.CustomCountry;
import gov.omsb.tms.ecm.web.dto.PotentialMemberAffiliationDTO;
import gov.omsb.tms.ecm.web.dto.ViewEcMemberRequestDTO;
import gov.omsb.tms.ecm.web.dto.WorkflowTaskDetail;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.BankDetailsLocalService;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestStateLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

/**
 * @author Jinal Patel
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name=/edit/ec-member-details" }, service = MVCRenderCommand.class)
public class EditECMembershipRequestMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("edit ec membership request render");
		renderRequest.setAttribute("redirectURL", PortalUtil.getCurrentURL(renderRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String ecMembershipRequestIdStr = ParamUtil.getString(renderRequest, "ecMembershipRequestId");
		if (Validator.isNotNull(ecMembershipRequestIdStr) && !ecMembershipRequestIdStr.isBlank()) {
			long ecMembershipRequestId = Long.valueOf(ecMembershipRequestIdStr);
			try {
				EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMembershipRequestId);
				ViewEcMemberRequestDTO viewEcMemberRequestDTO = new ViewEcMemberRequestDTO();
				setPersonRelatedData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				setRoleAndProgramData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				setCoveringLetterData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				setCvData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				viewEcMemberRequestDTO.setComment(ecMemberRequest.getComments(themeDisplay.getLocale()));
				renderRequest.setAttribute(PROGRAM_LIST, membershipUtil.getUserPrograms(themeDisplay));
				renderRequest.setAttribute(ROLE_LIST, membershipUtil.getECMemberRoles(themeDisplay.getScopeGroupId()));
				renderRequest.setAttribute("editData", viewEcMemberRequestDTO);
				renderRequest.setAttribute("ecMemberRequestId", ecMemberRequest.getEcMemberRequestId());
				renderRequest.setAttribute("isEditMode", true);
				 HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
					
				WorkflowTaskDetail workflowTaskDetail = MembershipUtil.getMemberRequestWorkflowDetail(httpRequest,themeDisplay, ecMemberRequest); 
				
				renderRequest.setAttribute("workflowTaskDetail", workflowTaskDetail);
				
			} catch (PortalException e) {
				log.error("unable to fetch ec member request details");
			}
		}
		return "/jsp/editEcMembershipRequest.jsp";
	}


	@SuppressWarnings("deprecation")
	private void setCoveringLetterData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		log.info("setCoveringLetterData started");
		FileEntry coveringLetterFileEntry;
		try {
			coveringLetterFileEntry = DLAppServiceUtil
					.getFileEntry(Long.valueOf(ecMemberRequest.getCoveringLetterId()));
			String coveringLetterURL = DLUtil.getPreviewURL(coveringLetterFileEntry,
					coveringLetterFileEntry.getFileVersion(), themeDisplay, null, true, true);
			String coveringLetterName = coveringLetterFileEntry.getDescription();
			viewEcMemberRequestDTO.setCoveringLetterName(coveringLetterName);
			viewEcMemberRequestDTO.setCoveringLetterUrl(coveringLetterURL);
		} catch (PortalException e) {
			log.error("error while fetching covering letter");
		}
		log.info("setCoveringLetterData ended");
	}

	@SuppressWarnings("deprecation")
	private void setCvData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		log.info("setCvData started");
		FileEntry cvFileEntry;
		try {
			cvFileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(ecMemberRequest.getCvId()));
			String cvURL = DLUtil.getPreviewURL(cvFileEntry, cvFileEntry.getFileVersion(), themeDisplay, null, true,
					true);
			String cvName = cvFileEntry.getDescription();
			viewEcMemberRequestDTO.setCvName(cvName);
			viewEcMemberRequestDTO.setCvUrl(cvURL);
		} catch (PortalException e) {
			log.error("unable to fetch cv data");
		}
		log.info("setCvData ended");
	}

	private Role setRoleAndProgramData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		log.info("setRoleAndProgramData started");
		Role role = null;
		try {
			role = roleLocalService.getRole(ecMemberRequest.getPotentialEcMemberRoleId());
			viewEcMemberRequestDTO.setMembershipRoleId(role.getRoleId());
			viewEcMemberRequestDTO.setMembershipRoleName(role.getName());
		} catch (PortalException | NullPointerException e) {
			log.error("unable to fetch role");
		}
		ProgramMaster program = null;
		try {
			program = programMasterLocalService.getProgramMaster(ecMemberRequest.getProgramId());
			viewEcMemberRequestDTO.setProgramId(program.getProgramMasterId());
			viewEcMemberRequestDTO.setProgramName(program.getProgramName(themeDisplay.getLocale()));
		} catch (PortalException e) {
			log.error("unable to fetch program");
		}
		log.info("setRoleAndProgramData ended");
		return role;
	}

	private void setPersonRelatedData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		log.info("setPersonRelatedData started");
		String personWithScopeURL = generateScopeListURL(LRObjectURL.PERSON_URL,
				themeDisplay.getScopeGroupId());
		String personUrl = StringPool.BLANK;
		PersonItem personItems = null;
		try {
			personUrl = personWithScopeURL + StringPool.QUESTION + FILTER + "id"
					+ URLEncoder.encode(EQ + SINGLE_QUOTE + ecMemberRequest.getPotentialEcMemberId() + SINGLE_QUOTE,
							UNICODE_TRANSFORMATION_FORMAT);
			String personResponse = omsbCommonApi.getData(personUrl);
			personItems = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
		} catch (UnsupportedEncodingException e) {
			log.error("unable to generate personURL");
		}
		
		if (Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems())
				&& personItems.getItems().size() > 0) {
			Person person = personItems.getItems().get(0);
			viewEcMemberRequestDTO.setCivilId(person.getCivilId());
			viewEcMemberRequestDTO.setPersonId(person.getId());
			viewEcMemberRequestDTO.setPassportNumber(person.getPassportNumber());

			PersonalDetail personalDetail = null;
			try {
				personalDetail = fetchPersonDetailsByPersonId(person.getId(), themeDisplay);
			} catch (UnsupportedEncodingException e) {
				log.error("unable to fetch personal details");
			}

			if (Validator.isNotNull(personalDetail)) {
				viewEcMemberRequestDTO.setGivenNameAsPassport(personalDetail.getGivenNameAsPassport());
				viewEcMemberRequestDTO.setNationalId(String.valueOf(personalDetail.getNationalityCountryId()));
			}

			setDobData(viewEcMemberRequestDTO, person);
			
			setPotentialMemberAffiliationData(viewEcMemberRequestDTO, themeDisplay, person);
		}
		log.info("setPersonRelatedData ended");
	}

	private void setDobData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, Person person) {
		String dateOfBirth = StringPool.BLANK;
		try {
			Date dob = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
					.parse(person.getDateOfBirth());
			SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);
			dateOfBirth = sdf.format(dob);
			viewEcMemberRequestDTO.setDateOfBirth(dateOfBirth);
		} catch (ParseException e) {
			log.info("Error while parsing dob string to date, " + e.getMessage());
		}
	}

	private void setPotentialMemberAffiliationData(ViewEcMemberRequestDTO viewEcMemberRequestDTO,
			ThemeDisplay themeDisplay, Person person) {
		log.info("setPotentialMemberAffiliationData started");
		String userMetadataWithScopeURL = omsbCommonApi.getBaseURL() + LRObjectURL.REG_USER_METADATA_URL+String.valueOf(themeDisplay.getScopeGroupId());
		String userMetadataUrl = StringPool.BLANK;
		UserMetadataItem userMetadataItems = null;
			try {
				userMetadataUrl = userMetadataWithScopeURL + StringPool.QUESTION + FILTER+"lrUserId" + URLEncoder.encode(EQ + person.getLrUserId(), UNICODE_TRANSFORMATION_FORMAT);
				String userMetadataResponse = omsbCommonApi.getData(userMetadataUrl);
				userMetadataItems = CustomObjectMapperUtil.readValue(userMetadataResponse, UserMetadataItem.class);
			} catch (UnsupportedEncodingException e) {
				log.error("unable to generate userMetadataurl");
			}
			
			List<PotentialMemberAffiliationDTO> potentialMemberAffiliationDTOList = new ArrayList<PotentialMemberAffiliationDTO>();
			if(Validator.isNotNull(userMetadataItems) && Validator.isNotNull(userMetadataItems.getItems()) && userMetadataItems.getItems().size() > 0) {
				for(UserMetadata userMetadata : userMetadataItems.getItems()) {
					ProgramMaster programMaster;
					PotentialMemberAffiliationDTO potentialMemberAffiliationDTO = new PotentialMemberAffiliationDTO();
					try {
						programMaster = programMasterLocalService.getProgramMaster(userMetadata.getProgramId());
						potentialMemberAffiliationDTO.setProgram(programMaster.getProgramName(themeDisplay.getLocale()));
					} catch (PortalException e) {
						log.error("unable to fetch program master");
					}
					try {
						potentialMemberAffiliationDTO.setRole(roleLocalService.getRole(userMetadata.getRoleId()).getName());
					} catch (PortalException e) {
						log.error("unable to fetch role");
					}
					potentialMemberAffiliationDTOList.add(potentialMemberAffiliationDTO);
				}
			}
			viewEcMemberRequestDTO.setPotentialMemberAffiliationDTOs(potentialMemberAffiliationDTOList);
			log.info("setPotentialMemberAffiliationData ended");
	}


	


	private String generateScopeListURL(String personRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + personRequestsUrl.replace("{scope-id}", String.valueOf(siteId));
	}
	
	private PersonalDetail fetchPersonDetailsByPersonId(long personId, ThemeDisplay themeDisplay)
			throws UnsupportedEncodingException {
		String personDetailsUrl = generateScopeListURL(
				LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL + "?filter=personId%20eq%20" + personId,
				themeDisplay.getScopeGroupId());
		String personDetailsResponse = omsbCommonApi.getData(personDetailsUrl);
		PersonalDetailItem personalDetailItems = CustomObjectMapperUtil.readValue(personDetailsResponse,
				PersonalDetailItem.class);
		PersonalDetail personalDetails = null;
		if (Validator.isNotNull(personalDetailItems) && Validator.isNotNull(personalDetailItems.getItems())
				&& personalDetailItems.getItems().size() > 0) {
			personalDetails = personalDetailItems.getItems().get(0);
		}
		return personalDetails;
	}

	public String getCountryName(ThemeDisplay themeDisplay, long countryId) {
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.GET_CUSTOM_COUNTRY_BY_NATIONALITYCOUNTRYID_URL
					+ themeDisplay.getScopeGroupId() + "?filter=countryID"
					+ URLEncoder.encode(" eq " + countryId, DataflowConstants.UTF_8);
			String customCuntryResponse = omsbCommonApi.getData(url);
			CustomCountry countryItemResponse = CustomObjectMapperUtil.readValue(customCuntryResponse,
					CustomCountry.class);
			return countryItemResponse.getItems().get(0).getNationality();
		} catch (NullPointerException | UnsupportedEncodingException e) {
			log.info(e.getMessage());
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
	private ProgramMasterLocalService programMasterLocalService;

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;

	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;

	@Reference(unbind = "-")
	private BankDetailsLocalService bankDetailsLocalService;

	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;
	
	@Reference(unbind = "-")
	private EcMemberRequestLocalService ecMemberRequestLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference(unbind = "-")
	private EcMemberRequestStateLocalService ecMemberRequestStateLocalService;

	private static final Log log = LogFactoryUtil.getLog(EditECMembershipRequestMVCRenderCommand.class);
}

package gov.omsb.tms.ecm.web.util;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.DD_MM_YYYY;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EQ;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EQ_EC_MEMBER_ROLE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.FILTER;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.LR_USER_ID;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ROLE_TYPE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.SINGLE_QUOTE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.UNICODE_TRANSFORMATION_FORMAT;

import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.custom.dto.ECMembershipRequestListDTO;
import gov.omsb.tms.custom.dto.ProgramDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.ecm.web.constants.ECMemberRoles;
import gov.omsb.tms.ecm.web.dto.ActionDetail;
import gov.omsb.tms.ecm.web.dto.CommentsSection;
import gov.omsb.tms.ecm.web.dto.CustomCountryItems;
import gov.omsb.tms.ecm.web.dto.DocumentInfo;
import gov.omsb.tms.ecm.web.dto.DocumentInfoItem;
import gov.omsb.tms.ecm.web.dto.EducationalDetail;
import gov.omsb.tms.ecm.web.dto.EducationalDetailItem;
import gov.omsb.tms.ecm.web.dto.EducationalDetailsItem;
import gov.omsb.tms.ecm.web.dto.EducationalDetailsView;
import gov.omsb.tms.ecm.web.dto.MemberRequestDetail;
import gov.omsb.tms.ecm.web.dto.PotentialMemberAffiliationDTO;
import gov.omsb.tms.ecm.web.dto.RoleMapping;
import gov.omsb.tms.ecm.web.dto.RoleMappingItem;
import gov.omsb.tms.ecm.web.dto.ViewEcMemberRequestDTO;
import gov.omsb.tms.ecm.web.dto.WorkflowTaskDetail;
import gov.omsb.tms.model.BankDetails;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.EcMemberRequestRotations;
import gov.omsb.tms.model.EcMemberRequestState;
import gov.omsb.tms.model.EcMemberRequestStatus;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.BankDetailsLocalService;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestLocalServiceUtil;
import gov.omsb.tms.service.EcMemberRequestRotationsLocalService;
import gov.omsb.tms.service.EcMemberRequestStateLocalService;
import gov.omsb.tms.service.EcMemberRequestStateLocalServiceUtil;
import gov.omsb.tms.service.EcMemberRequestStatusLocalService;
import gov.omsb.tms.service.EcMemberRequestStatusLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, service = MembershipUtil.class)
public class MembershipUtil {
	public static final String ID = "id";

	public static final String SCOPE_ID = "{scope-id}";

	public String generateFileName(String fileName) {
		if (Validator.isNotNull(fileName)) {
			Date d = new Date();

			String baseFileName = fileName.substring(0, fileName.lastIndexOf('.'));
			String extension = fileName.substring(fileName.lastIndexOf('.'));
			fileName = baseFileName + d.getTime() + extension;
		}
		return fileName;
	}

	public List<ProgramDTO> getUserPrograms(ThemeDisplay themeDisplay) {

		List<ProgramDTO> programDTOList = new ArrayList<ProgramDTO>();

		String userMetadataWithScopeURL = generateScopeListURL(LRObjectURL.REG_USER_METADATA_URL,
				themeDisplay.getScopeGroupId());
		String userMetadataUrl = StringPool.BLANK;
		try {
			userMetadataUrl = userMetadataWithScopeURL + StringPool.QUESTION + FILTER + LR_USER_ID
					+ URLEncoder.encode(EQ + themeDisplay.getUserId(), UNICODE_TRANSFORMATION_FORMAT);

			String userMetadataResponse = omsbCommonApi.getData(userMetadataUrl);
			UserMetadataItem userMetadataItems = CustomObjectMapperUtil.readValue(userMetadataResponse,
					UserMetadataItem.class);

			if (Validator.isNotNull(userMetadataItems) && Validator.isNotNull(userMetadataItems.getItems())
					&& userMetadataItems.getItems().size() > 0) {
				for (UserMetadata userMetadata : userMetadataItems.getItems()) {
					ProgramMaster programMaster = programMasterLocalService
							.getProgramMaster(userMetadata.getProgramId());
					ProgramDTO programDTO = setProgramDTOobj(themeDisplay, programMaster);
					programDTOList.add(programDTO);
				}
			}
		} catch (UnsupportedEncodingException | PortalException e) {
			log.debug("error while creating program master lists");
		}

		return programDTOList;
	}

	public List<Role> getECMemberRoles(long groupId) {
		List<Role> roleList = new ArrayList<>();
		String roleMappingWithScopeURL = generateScopeListURL(LRObjectURL.REG_ROLE_MAPPING_URL, groupId);
		String roleMappingUrl = StringPool.BLANK;
		try {
			roleMappingUrl = roleMappingWithScopeURL + StringPool.QUESTION + FILTER + ROLE_TYPE
					+ URLEncoder.encode(EQ_EC_MEMBER_ROLE, UNICODE_TRANSFORMATION_FORMAT);
			String roleMappingResponse = omsbCommonApi.getData(roleMappingUrl);
			RoleMappingItem roleMappingItems = CustomObjectMapperUtil.readValue(roleMappingResponse,
					RoleMappingItem.class);

			if (Validator.isNotNull(roleMappingItems) && Validator.isNotNull(roleMappingItems.getItems())
					&& roleMappingItems.getItems().size() > 0) {
				for (RoleMapping roleMapping : roleMappingItems.getItems()) {
					Role role = roleLocalService.getRole(Long.valueOf(roleMapping.getRoleId()));
					roleList.add(role);
				}
			}
		} catch (UnsupportedEncodingException | PortalException e) {
			log.debug("error while creating program master lists");
		}
		return roleList;
	}

	public List<TrainingSiteByPdDTO> getTrainingSitesDataByProgramId(ThemeDisplay themeDisplay,
			long selectedProgramId) {
		List<TrainingSiteByPdDTO> trainingSites = new ArrayList<>();
		List<Long> siteIds = new ArrayList<>();
		if (Validator.isNotNull(selectedProgramId)) {
			List<ProgramDurationDetails> programDurationDetailsList = programDurationDetailsLocalService
					.findProgramDurationByProgramId(selectedProgramId);
			if (Validator.isNotNull(programDurationDetailsList) && programDurationDetailsList.size() > 0) {
				for (ProgramDurationDetails programDurationDetails : programDurationDetailsList) {
					List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = progDurRotTrainSitesRelLS
							.findByProgramDurationId(programDurationDetails.getProgDurationId());
					if (Validator.isNotNull(progdurationRotationTrainingsitesRels)
							&& progdurationRotationTrainingsitesRels.size() > 0) {
						for (ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel : progdurationRotationTrainingsitesRels) {
							TrainingSitesMaster trainingSitesMaster;
							try {
								trainingSitesMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(
										progdurationRotationTrainingsitesRel.getTrainingSitesId());
								if (Validator.isNotNull(trainingSitesMaster)
										&& !siteIds.contains(trainingSitesMaster.getTrainingSiteMasterId())) {
									TrainingSiteByPdDTO trainingSiteByPdDTO = new TrainingSiteByPdDTO();
									trainingSiteByPdDTO
											.setTrainingSiteId(trainingSitesMaster.getTrainingSiteMasterId());
									trainingSiteByPdDTO.setTrainingSiteName(
											trainingSitesMaster.getTrainingSiteName(themeDisplay.getLocale()));
									trainingSites.add(trainingSiteByPdDTO);
									siteIds.add(trainingSitesMaster.getTrainingSiteMasterId());
								}
							} catch (PortalException e) {
								log.error("unable to fetch training site");
							}
						}
					}
				}
			}
		}
		return trainingSites;
	}

	public List<RotationMaster> getRotationsOnTrainingSites(long selectedTrainingSiteId) {
		List<RotationMaster> rotationMasters = new ArrayList<>();
		if (Validator.isNotNull(selectedTrainingSiteId)) {
			List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = progDurRotTrainSitesRelLS
					.findByTrainingSitesId(selectedTrainingSiteId);
			if (Validator.isNotNull(progdurationRotationTrainingsitesRels)
					&& progdurationRotationTrainingsitesRels.size() > 0) {
				for (ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel : progdurationRotationTrainingsitesRels) {
					RotationMaster rotationMaster;
					try {
						rotationMaster = rotationMasterLocalService
								.getRotationMaster(progdurationRotationTrainingsitesRel.getRotationId());
						rotationMasters.add(rotationMaster);
					} catch (PortalException e) {
						log.error("unable to fetch rotation master");
					}
				}
			}
		}
		return rotationMasters;
	}

	private ProgramDTO setProgramDTOobj(ThemeDisplay themeDisplay, ProgramMaster programMaster) {
		ProgramDTO programDTO = new ProgramDTO();
		programDTO.setProgramMasterId(programMaster.getProgramMasterId());
		programDTO.setProgramCode(programMaster.getProgramCode(themeDisplay.getLocale()));
		programDTO.setProgramName(programMaster.getProgramName(themeDisplay.getLocale()));
		return programDTO;
	}

	public void setBankDetails(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			long ecMembershipRequestId) {
		BankDetails bankDetails = bankDetailsLocalService.findByEcMemberRequestId(ecMembershipRequestId);
		if (Validator.isNotNull(bankDetails)) {
			viewEcMemberRequestDTO.setBankBranch(bankDetails.getBankBranch(themeDisplay.getLocale()));
			viewEcMemberRequestDTO.setBankName(bankDetails.getBankName(themeDisplay.getLocale()));
			viewEcMemberRequestDTO.setAccountNo(bankDetails.getAccountNumber(themeDisplay.getLocale()));
		}
	}

	public void setDobData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, Person person) {
		String dateOfBirth = StringPool.BLANK;
		try {
			Date dob = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(person.getDateOfBirth());
			SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);
			dateOfBirth = sdf.format(dob);
			viewEcMemberRequestDTO.setDateOfBirth(dateOfBirth);
		} catch (ParseException e) {
			log.info("Error while parsing dob string to date, " + e.getMessage());
		}
	}

	public void setRotationData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			long ecMembershipRequestId) {
		try {
			List<EcMemberRequestRotations> ecMemberRequestRotations = ecMemberRequestRotationsLocalService
					.findByEcMemberRequestId(ecMembershipRequestId);

			if (Validator.isNotNull(ecMemberRequestRotations) && !ecMemberRequestRotations.isEmpty()
					&& ecMemberRequestRotations.size() > 0) {
				TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService
						.getTrainingSitesMaster(ecMemberRequestRotations.get(0).getTrainingSiteId());
				viewEcMemberRequestDTO.setTrainingSiteId(trainingSitesMaster.getTrainingSiteMasterId());
				viewEcMemberRequestDTO
						.setTrainingSiteName(trainingSitesMaster.getTrainingSiteName(themeDisplay.getLocale()));

				List<Long> selectedRotations = new ArrayList<>();
				String rotationMasterNames = StringPool.BLANK;
				for (EcMemberRequestRotations ecMemberRequestRotation : ecMemberRequestRotations) {
					RotationMaster rotationMaster = rotationMasterLocalService
							.getRotationMaster(ecMemberRequestRotation.getRotationId());
					selectedRotations.add(rotationMaster.getRotationMasterId());
					rotationMasterNames = rotationMasterNames + " "
							+ rotationMaster.getRotationName(themeDisplay.getLocale()) + ",";
				}
				rotationMasterNames = rotationMasterNames.substring(0, rotationMasterNames.length() - 1);
				viewEcMemberRequestDTO.setSelectedRotationMasters(selectedRotations);
				viewEcMemberRequestDTO.setRotationName(rotationMasterNames);
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public Role setRoleAndProgramData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		Role role = null;
		try {
			role = roleLocalService.getRole(ecMemberRequest.getPotentialEcMemberRoleId());
			if (Validator.isNotNull(role)) {
				viewEcMemberRequestDTO.setMembershipRoleId(role.getRoleId());
				viewEcMemberRequestDTO.setMembershipRoleName(role.getName());
			}
		} catch (PortalException e) {
			log.error("unable to fetch membership role");
		}

		ProgramMaster program;
		try {
			program = programMasterLocalService.getProgramMaster(ecMemberRequest.getProgramId());
			if (Validator.isNotNull(program)) {
				viewEcMemberRequestDTO.setProgramId(program.getProgramMasterId());
				viewEcMemberRequestDTO.setProgramName(program.getProgramName(themeDisplay.getLocale()));
			}
		} catch (PortalException e) {
			log.error("unable to get program master");
		}
		return role;
	}

	public void setPotentialMemberAffiliationData(ViewEcMemberRequestDTO viewEcMemberRequestDTO,
			ThemeDisplay themeDisplay, Person person) {
		String userMetadataWithScopeURL = generateScopeListURL(LRObjectURL.REG_USER_METADATA_URL,
				themeDisplay.getScopeGroupId());
		String userMetadataUrl = StringPool.BLANK;
		try {
			userMetadataUrl = userMetadataWithScopeURL + StringPool.QUESTION + FILTER + LR_USER_ID
					+ URLEncoder.encode(EQ + person.getLrUserId(), UNICODE_TRANSFORMATION_FORMAT);
			String userMetadataResponse = omsbCommonApi.getData(userMetadataUrl);
			UserMetadataItem userMetadataItems = CustomObjectMapperUtil.readValue(userMetadataResponse,
					UserMetadataItem.class);
			List<PotentialMemberAffiliationDTO> potentialMemberAffiliationDTOList = new ArrayList<PotentialMemberAffiliationDTO>();
			if (Validator.isNotNull(userMetadataItems) && Validator.isNotNull(userMetadataItems.getItems())
					&& userMetadataItems.getItems().size() > 0) {
				for (UserMetadata userMetadata : userMetadataItems.getItems()) {
					ProgramMaster programMaster = programMasterLocalService
							.getProgramMaster(userMetadata.getProgramId());

					PotentialMemberAffiliationDTO potentialMemberAffiliationDTO = new PotentialMemberAffiliationDTO();
					potentialMemberAffiliationDTO.setProgram(programMaster.getProgramName(themeDisplay.getLocale()));
					potentialMemberAffiliationDTO.setRole(roleLocalService.getRole(userMetadata.getRoleId()).getName());
					potentialMemberAffiliationDTOList.add(potentialMemberAffiliationDTO);

				}
			}

			viewEcMemberRequestDTO.setPotentialMemberAffiliationDTOs(potentialMemberAffiliationDTOList);
			log.debug("potentialMemberAffiliationDTOList" + potentialMemberAffiliationDTOList);
		} catch (UnsupportedEncodingException | PortalException e) {
			log.debug(e);
		}
	}

	public List<PotentialMemberAffiliationDTO> getPotentialMemberAffiliationData(Person person,
			ThemeDisplay themeDisplay) {
		List<EcMemberRequest> ecMemberRequestList = null;
		String userMetadataWithScopeURL = generateScopeListURL(LRObjectURL.REG_USER_METADATA_URL,
				themeDisplay.getScopeGroupId());
		String userMetadataUrl = StringPool.BLANK;
		List<PotentialMemberAffiliationDTO> potentialMemberAffiliationDTOList = new ArrayList<PotentialMemberAffiliationDTO>();
		try {
			userMetadataUrl = userMetadataWithScopeURL + StringPool.QUESTION + FILTER + LR_USER_ID
					+ URLEncoder.encode(EQ + person.getLrUserId(), UNICODE_TRANSFORMATION_FORMAT);
			String userMetadataResponse = omsbCommonApi.getData(userMetadataUrl);
			UserMetadataItem userMetadataItems = CustomObjectMapperUtil.readValue(userMetadataResponse,
					UserMetadataItem.class);
			Map<Long, PotentialMemberAffiliationDTO> requestMap = new HashMap<Long, PotentialMemberAffiliationDTO>();

			if (Validator.isNotNull(userMetadataItems) && Validator.isNotNull(userMetadataItems.getItems())
					&& userMetadataItems.getItems().size() > 0) {

				for (UserMetadata userMetadata : userMetadataItems.getItems()) {
					if (userMetadata.getProgramId() <= 0) {
						continue;
					}
					PotentialMemberAffiliationDTO potentialMemberAffiliationDTO = new PotentialMemberAffiliationDTO();
					ProgramMaster programMaster = programMasterLocalService
							.getProgramMaster(userMetadata.getProgramId());

					potentialMemberAffiliationDTO.setProgram(programMaster.getProgramName(themeDisplay.getLocale()));
					potentialMemberAffiliationDTO.setRole(roleLocalService.getRole(userMetadata.getRoleId()).getName());
					potentialMemberAffiliationDTO.setProgramId(programMaster.getProgramMasterId());
					potentialMemberAffiliationDTO.setPersonId(person.getLrUserId());
					potentialMemberAffiliationDTO.setStatus("Active");
					requestMap.put(potentialMemberAffiliationDTO.getProgramId(), potentialMemberAffiliationDTO);
				}
			}

			ecMemberRequestList = ecMemberRequestLocalService.findByPotentialEcMemberLruserid(person.getLrUserId());
			for (EcMemberRequest req : ecMemberRequestList) {
				ProgramMaster programMaster = programMasterLocalService.getProgramMaster(req.getProgramId());
				PotentialMemberAffiliationDTO potentialMemberAffiliationDTO = new PotentialMemberAffiliationDTO();
				potentialMemberAffiliationDTO.setProgram(programMaster.getProgramName(themeDisplay.getLocale()));
				potentialMemberAffiliationDTO.setProgramId(programMaster.getProgramMasterId());
				potentialMemberAffiliationDTO
						.setRole(roleLocalService.getRole(req.getPotentialEcMemberRoleId()).getName());
				if (req.getStatus() == 0) {
					potentialMemberAffiliationDTO.setStatus("Active");
				} else {
					potentialMemberAffiliationDTO.setStatus("In Process");
				}
				requestMap.put(potentialMemberAffiliationDTO.getProgramId(), potentialMemberAffiliationDTO);
			}
			potentialMemberAffiliationDTOList.addAll(requestMap.values());

		} catch (UnsupportedEncodingException | PortalException e) {
			log.error(e.getMessage());
		}
		return potentialMemberAffiliationDTOList;
	}

	public PersonalDetail fetchPersonDetailsByPersonId(long personId, ThemeDisplay themeDisplay)
			throws UnsupportedEncodingException {
		String personDetailsUrl = omsbCommonApi.getBaseURL() + LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL.replace(
				"{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + "?filter=personId%20eq%20" + personId;
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

	@SuppressWarnings("deprecation")
	public void setCvData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) throws PortalException {
		try {
			FileEntry cvFileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(ecMemberRequest.getCvId()));
			// String cvURL = DLUtil.getPreviewURL(cvFileEntry,
			// cvFileEntry.getFileVersion(), themeDisplay, null, true,true);

			String cvURL = DLURLHelperUtil.getPreviewURL(cvFileEntry, cvFileEntry.getLatestFileVersion(), themeDisplay,
					null);
			log.info("cvURL=========" + ecMemberRequest.getCvId());

			String cvName = cvFileEntry.getDescription();
			viewEcMemberRequestDTO.setCvName(cvName);
			viewEcMemberRequestDTO.setCvUrl(cvURL);
		} catch (Exception e) {
			log.debug(e);
		}
	}

	@SuppressWarnings("deprecation")
	public void setCoveringLetterData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		try {
			FileEntry coveringLetterFileEntry = DLAppServiceUtil
					.getFileEntry(Long.valueOf(ecMemberRequest.getCoveringLetterId()));
			// String coveringLetterURL = DLUtil.getPreviewURL(coveringLetterFileEntry,
			// coveringLetterFileEntry.getFileVersion(), themeDisplay, null, true, true);
			String coveringLetterURL = DLURLHelperUtil.getPreviewURL(coveringLetterFileEntry,
					coveringLetterFileEntry.getLatestFileVersion(), themeDisplay, null);
			String coveringLetterName = coveringLetterFileEntry.getDescription();
			viewEcMemberRequestDTO.setCoveringLetterName(coveringLetterName);
			viewEcMemberRequestDTO.setCoveringLetterUrl(coveringLetterURL);
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public void setNationalIdDocData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		try {
			String nationalIdDocumentInfoUrl = themeDisplay.getPortalURL()
					+ LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR,
							String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=id"
					+ URLEncoder.encode(" eq '" + ecMemberRequest.getPassportCopyId() + "'", DataflowConstants.UTF_8);
			String nationalIdDocumentInfoResponse = omsbCommonApi.getData(nationalIdDocumentInfoUrl);
			DocumentInfo nationalIdDocumentInfos = CustomObjectMapperUtil.readValue(nationalIdDocumentInfoResponse,
					DocumentInfo.class);
			if (Validator.isNotNull(nationalIdDocumentInfos) && Validator.isNotNull(nationalIdDocumentInfos.getItems())
					&& nationalIdDocumentInfos.getItems().size() > 0) {
				DocumentInfoItem nationalIdDocumentInfoItem = nationalIdDocumentInfos.getItems().get(0);
				FileEntry nationalIdFileEntry = DLAppServiceUtil
						.getFileEntry(nationalIdDocumentInfoItem.getFileEntryID());
				String nationalIdUrl = DLURLHelperUtil.getPreviewURL(nationalIdFileEntry,
						nationalIdFileEntry.getLatestFileVersion(), themeDisplay, "");
				viewEcMemberRequestDTO.setNationalIdName(nationalIdFileEntry.getFileName());
				viewEcMemberRequestDTO.setNationalIdUrl(nationalIdUrl);
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public void setCivilFrontAndBackCardId(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		FileEntry fileEntry = null;
		String civilCardBackPhotoUrl = null;
		String civilCardFrontPhotoUrl = null;
		try {
			PersonalDetail personalDetail = fetchPersonalDetailsByPersonId(themeDisplay,
					ecMemberRequest.getPotentialEcMemberLruserid());
			log.info("personalDetail " + personalDetail);
			if (Validator.isNotNull(personalDetail)) {
				fileEntry = DLAppServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
				civilCardFrontPhotoUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(),
						null, "");
				viewEcMemberRequestDTO.setCivilCardFrontPhotoUrl(civilCardFrontPhotoUrl);
				log.info("civilCardFrontPhotoUrl " + civilCardFrontPhotoUrl);
				fileEntry = DLAppServiceUtil.getFileEntry(personalDetail.getCivilCardBackPhotoId());
				civilCardBackPhotoUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null,
						"");
				viewEcMemberRequestDTO.setCivilCardBackPhotoUrl(civilCardBackPhotoUrl);
				log.info("civilCardBackPhotoUrl " + civilCardBackPhotoUrl);
			}
		} catch (UnsupportedEncodingException | PortalException e1) {
			log.error("Error " + e1);
		}

	}

	public void setPassportDocData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		log.debug("ecMemberRequest getPassportCopyId++++++++++" + ecMemberRequest.getPassportCopyId());
		try {
			String passportDocumentInfoUrl = themeDisplay.getPortalURL()
					+ LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR,
							String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=id"
					+ URLEncoder.encode(" eq '" + ecMemberRequest.getPassportCopyId() + "'", DataflowConstants.UTF_8);
			String passportDocumentInfoResponse = omsbCommonApi.getData(passportDocumentInfoUrl);
			DocumentInfo documentInfos = CustomObjectMapperUtil.readValue(passportDocumentInfoResponse,
					DocumentInfo.class);
			if (Validator.isNotNull(documentInfos) && Validator.isNotNull(documentInfos.getItems())
					&& documentInfos.getItems().size() > 0) {
				DocumentInfoItem documentInfoItem = documentInfos.getItems().get(0);
				try {
					log.debug("documentInfoI getFileEntryID+++++" + documentInfoItem.getFileEntryID());
					FileEntry passportFileEntry = DLAppServiceUtil.getFileEntry(documentInfoItem.getFileEntryID());
					String passportUrl = DLURLHelperUtil.getPreviewURL(passportFileEntry,
							passportFileEntry.getLatestFileVersion(), themeDisplay, null);
					log.debug("passportUrl------->>>" + passportUrl);
					viewEcMemberRequestDTO.setPassportName(passportFileEntry.getFileName());
					viewEcMemberRequestDTO.setPassportUrl(passportUrl);
				} catch (PortalException e) {
					log.error(e.getMessage());
				}
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public void setStatusData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, EcMemberRequest ecMemberRequest,
			ThemeDisplay themeDisplay) {
		EcMemberRequestState ecMemberRequestState;
		EcMemberRequestStatus ecMemberRequestStatus;
		try {
			ecMemberRequestState = ecMemberRequestStateLocalService
					.getEcMemberRequestState(ecMemberRequest.getLatestEcMemberRequestStateId());
			ecMemberRequestStatus = ecMemberRequestStatusLocalService
					.getEcMemberRequestStatus(ecMemberRequestState.getEcMemberRequestStatusId());
			if (Validator.isNotNull(ecMemberRequestStatus)) {
				viewEcMemberRequestDTO.setLatestStatusCode(ecMemberRequestStatus.getCode());

				String status = null;
				log.info("-----------------------------------------> "
						+ themeDisplay.getLocale().getLanguage().toLowerCase());
				if (themeDisplay.getLocale().getLanguage().toLowerCase().contains("ar")) {
					status = ecMemberRequestStatus.getNameAr();
				}

				if (status == null || status.isBlank()) {
					status = ecMemberRequestStatus.getNameEn();
				}

				viewEcMemberRequestDTO.setLatestStatus(status);
			}
		} catch (PortalException e) {
			log.error("unable to fetch latest status");
		}
	}

	public void setPersonRelatedData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		try {
			String personWithScopeURL = omsbCommonApi.getBaseURL()
					+ LRObjectURL.PERSON_URL.replace(SCOPE_ID, String.valueOf(themeDisplay.getScopeGroupId()));
			String personUrl = personWithScopeURL + StringPool.QUESTION + FILTER + ID
					+ URLEncoder.encode(EQ + SINGLE_QUOTE + ecMemberRequest.getPotentialEcMemberId() + SINGLE_QUOTE,
							UNICODE_TRANSFORMATION_FORMAT);

			String personResponse = omsbCommonApi.getData(personUrl);
			PersonItem personItems = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
			if (Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems())
					&& personItems.getItems().size() > 0) {
				Person person = personItems.getItems().get(0);
				viewEcMemberRequestDTO.setCivilId(person.getCivilId());
				viewEcMemberRequestDTO.setPersonId(person.getId());
				viewEcMemberRequestDTO.setPassportNumber(person.getPassportNumber());

				PersonalDetail personalDetail = fetchPersonDetailsByPersonId(person.getId(), themeDisplay);

				if (Validator.isNotNull(personalDetail)) {
					viewEcMemberRequestDTO.setGivenNameAsPassport(personalDetail.getGivenNameAsPassport());
					viewEcMemberRequestDTO.setNationalId(String.valueOf(personalDetail.getNationalityCountryId()));
				}

				setDobData(viewEcMemberRequestDTO, person);

				setPotentialMemberAffiliationData(viewEcMemberRequestDTO, themeDisplay, person);
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public void setCommentsSectionData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, long ecMembershipRequestId,
			Role role, User user, EcMemberRequest ecMemberRequest) {
		List<EcMemberRequestState> ecMemberRequestStates = null;
		if (ecMemberRequest.getPotentialEcMemberLruserid() == user.getUserId()) {
			ecMemberRequestStates = ecMemberRequestStateLocalService.findByVisibility(ecMembershipRequestId, true);
		} else {
			ecMemberRequestStates = ecMemberRequestStateLocalService.findByEcMemberRequestId(ecMembershipRequestId);
		}

		if (Validator.isNotNull(ecMemberRequestStates) && !ecMemberRequestStates.isEmpty()
				&& ecMemberRequestStates.size() > 0) {
			List<CommentsSection> commentsSections = new ArrayList<>();
			int count = 0;
			List<EcMemberRequestState> sortedList = ecMemberRequestStates.stream()
					.sorted(Comparator.comparing(EcMemberRequestState::getCreateDate).reversed())
					.collect(Collectors.toList());
			for (EcMemberRequestState ecMemberRequestState : sortedList) {
				count = count + 1;

				CommentsSection commentsSection = new CommentsSection();
				ecMemberRequestState.getCreatedByRoleId();
				commentsSection.setComment(ecMemberRequestState.getComments());
				if (Validator.isNotNull(ecMemberRequestState)
						&& Validator.isNotNull(ecMemberRequestState.getCreateDate())) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String createDateStr = simpleDateFormat.format(ecMemberRequestState.getCreateDate());
					commentsSection.setCreateDate(createDateStr);
				}

				try {
					User createdByUser = null;
					createdByUser = userLocalService.getUser(ecMemberRequestState.getCreatedBy());
					commentsSection.setCommenterUserName(
							Validator.isNotNull(createdByUser) ? createdByUser.getFullName() : StringPool.BLANK);
				} catch (PortalException e) {
					log.error("unable to fetch user");
				}

				Role role1 = null;
				try {
					role1 = roleLocalService.getRole(ecMemberRequestState.getCreatedByRoleId());
				} catch (PortalException e) {
					log.error("unable to fetch role");
				}
				commentsSection.setRoleName(Validator.isNotNull(role1) ? role1.getName() : StringPool.BLANK);

				if (count != 1) {
					commentsSections.add(commentsSection);
				}
				if (count == 1) {
					viewEcMemberRequestDTO.setLatestCommentSection(commentsSection);
				}
			}
			viewEcMemberRequestDTO.setCommentsSections(commentsSections);
		}
	}

	public void setEducationDetailsData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) {
		try {
			String educationDetailUrl = themeDisplay.getPortalURL()
					+ LRObjectURL.EDUCATION_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR,
							String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=personId"
					+ URLEncoder.encode(" eq " + ecMemberRequest.getPotentialEcMemberId(), DataflowConstants.UTF_8);

			String educationDetailResponse = omsbCommonApi.getData(educationDetailUrl);
			EducationalDetail educationDetails = CustomObjectMapperUtil.readValue(educationDetailResponse,
					EducationalDetail.class);
			if (Validator.isNotNull(educationDetails)) {
				for (EducationalDetailItem educationDetail : educationDetails.getItems()) {

					EducationalDetailsView educationalDetailsView = new EducationalDetailsView();
					educationalDetailsView
							.setTitle(getQualificationTitle(educationDetail.getQualificationAttained(), themeDisplay));
					educationalDetailsView.setInstitution(
							getInstitutionName(educationDetail.getIssuingAuthorityName(), themeDisplay));
					educationalDetailsView
							.setCountry(getCountryName(themeDisplay, educationDetail.getIssuingAuthorityCountryId()));
					educationalDetailsView.setGpa(educationDetail.getGpa());
					educationalDetailsView.setYear(String.valueOf(educationDetail.getYearOfGraduation()));
					educationalDetailsView
							.setDocUrl(getQualificationDocumentURL(themeDisplay, educationDetail.getId()));
					// educationalDetailsView.setDocName(docName);
					viewEcMemberRequestDTO.addEducationDetailsView(educationalDetailsView);
				}
			}
		} catch (Exception ex) {
			log.debug(ex);
		}
	}

	private String getCountryName(ThemeDisplay themeDisplay, long countryId) {

		String countryName = null;

		com.liferay.portal.kernel.model.Country country = null;
		try {
			country = CountryLocalServiceUtil.getCountry(countryId);
			countryName = country.getName(themeDisplay.getLocale());
		} catch (PortalException e) {
			log.error("unable to get the country having id :: " + countryId + " :::: " + e.getMessage());
		}

		if (Validator.isNull(countryName)) {
			CustomCountryItems countryItemResponse = null;

			try {
				String url = themeDisplay.getPortalURL() + LRObjectURL.REG_CUSTOM_COUNTRY_URL + countryId;
				String customCuntryResponse = omsbCommonApi.getData(url);

				countryItemResponse = CustomObjectMapperUtil.readValue(customCuntryResponse, CustomCountryItems.class);
				if (countryItemResponse != null) {
					countryName = countryItemResponse.getNationality();
				}
			} catch (NullPointerException e) {
				log.info(e.getMessage());
			}
		}
		return countryName;
	}

	private String getQualificationDocumentURL(ThemeDisplay themeDisplay, long educationDetailId) {
		String documentInfoUrl = null;
		String documentURL = null;
		try {
			documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=componentClassRefId"
					+ URLEncoder.encode(" eq " + educationDetailId, DataflowConstants.UTF_8);
		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();
		}
		String documentInfoUrlResponse = omsbCommonApi.getData(documentInfoUrl);
		DocumentInfo documentInfo = CustomObjectMapperUtil.readValue(documentInfoUrlResponse, DocumentInfo.class);
		log.debug("documentInfos.getItems().size() ::::" + documentInfo.getItems().size());
		if (Validator.isNotNull(documentInfo) && documentInfo.getItems().size() > 0) {
			DocumentInfoItem documentInfoItem = documentInfo.getItems().get(0);

			if (Validator.isNotNull(documentInfoItem.getFileEntryID()) && documentInfoItem.getFileEntryID() > 0) {
				try {
					FileEntry entry = DLAppLocalServiceUtil.getFileEntry(documentInfoItem.getFileEntryID());
					documentURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay,
							StringPool.BLANK);
					log.debug(" education qualification documentURL---->>>" + documentURL);
				} catch (PortalException e) {
					log.error("Error in  code :::" + e.getMessage());
				}
			}

		}
		return documentURL;
	}

	private String getQualificationTitle(String key, ThemeDisplay themeDisplay) {

		if (Validator.isNotNull(key)) {
			String qualificationAttained = null;
			try {
				qualificationAttained = commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION,
						key, themeDisplay.getCompanyId()).getName(themeDisplay.getLocale());

			} catch (Exception e) {
				log.error(e.getMessage());
			}

			if (Validator.isNull(qualificationAttained)) {
				try {
					List<ListTypeEntry> pickListEntries = getPickListEntries(LRPicklistConstants.QUALIFICATION,
							themeDisplay.getCompanyId());
					for (ListTypeEntry listTypeEntry : pickListEntries) {
						if (listTypeEntry.getKey().equals(key)) {
							return listTypeEntry.getName(themeDisplay.getLocale());
						}
					}
				} catch (Exception e) {
					// no need to handle..

				}
			} else {
				return qualificationAttained;
			}
		}

		return key;
	}

	private String getInstitutionName(String key, ThemeDisplay themeDisplay) {
		String authorityName = null;

		try {
			ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(Long.parseLong(key));
			authorityName = listTypeEntry.getName(themeDisplay.getLocale());
		} catch (Exception e) {
			log.error("unable to get the List type entry " + e.getMessage());
		}

		if (Validator.isNull(authorityName)) {
			try {
				List<ListTypeEntry> pickListEntries = getPickListEntries(LRPicklistConstants.UNIVERSITY,
						themeDisplay.getCompanyId());

				for (ListTypeEntry listTypeEntry : pickListEntries) {
					log.debug("listTypeEntry===========" + listTypeEntry.getKey());
					if (listTypeEntry.getKey().equals(key)) {
						return listTypeEntry.getName(themeDisplay.getLocale());
					}
				}
			} catch (Exception e) {
				// no need to handle..

			}
		} else {
			return authorityName;
		}
		return key;
	}

	public List<ListTypeEntry> getPickListEntries(String pickListName, long companyId) {
		try {
			return ListTypeEntryLocalServiceUtil.getListTypeEntries(ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(pickListName, companyId).getListTypeDefinitionId());
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		return new ArrayList<ListTypeEntry>();
	}

	public void setQualificationDocData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) throws UnsupportedEncodingException {
		String qualificationDocumentInfoUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=personId"
				+ URLEncoder.encode(" eq " + ecMemberRequest.getPotentialEcMemberId()
						+ " and documentType eq 'qualificationDocument'", DataflowConstants.UTF_8);
		String qualificationDocumentInfoResponse = omsbCommonApi.getData(qualificationDocumentInfoUrl);
		DocumentInfo qualificationDocumentInfos = CustomObjectMapperUtil.readValue(qualificationDocumentInfoResponse,
				DocumentInfo.class);
		if (Validator.isNotNull(qualificationDocumentInfos)
				&& Validator.isNotNull(qualificationDocumentInfos.getItems())
				&& qualificationDocumentInfos.getItems().size() > 0) {
			DocumentInfoItem qualificationDocumentInfoItem = qualificationDocumentInfos.getItems().get(0);
			try {
				FileEntry qualificationFileEntry = DLAppServiceUtil
						.getFileEntry(qualificationDocumentInfoItem.getFileEntryID());
				String qualificationUrl = DLURLHelperUtil.getPreviewURL(qualificationFileEntry,
						qualificationFileEntry.getLatestFileVersion(), null, "");
				viewEcMemberRequestDTO.setQualificationDocumentName(qualificationFileEntry.getFileName());
				viewEcMemberRequestDTO.setQualificationDocumentUrl(qualificationUrl);
			} catch (PortalException e) {
				log.error(e.getMessage());
				log.trace(e);
			}
		}
	}

	public DLFolder createDLFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay, boolean mountPoint,
			long parentFolderId, String folderName, String description, boolean hidden) {
		DLFolder dlFolder = null;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			serviceContext.setAddGuestPermissions(true);
			dlFolder = fetchFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
			if (Validator.isNull(dlFolder)) {
				dlFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), mountPoint, parentFolderId,
						folderName, description, hidden, serviceContext);
			}
		} catch (Exception e) {
			log.debug(e);
		}
		return dlFolder;
	}

	public DLFolder fetchFolder(long groupId, long parentFolderId, String name) {
		DLFolder dlFolder = null;
		try {
			dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, name);
		} catch (Exception e) {
			log.debug(e);
		}
		return dlFolder;
	}

	private String generateScopeListURL(String userMetadataRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + userMetadataRequestsUrl + "scopes/" + String.valueOf(siteId);
	}

	public static MemberRequestDetail getMemberRequestDetail(HttpServletRequest httpRequest, ThemeDisplay themeDisplay,
			ECMembershipRequestListDTO data) {

		MemberRequestDetail memberRequestDetail = new MemberRequestDetail(data);
		String statusCode = data.getStatusCode();
		log.debug("statusCode > " + statusCode);

		// workflow task
		long requestId = data.getEcMemberRequestId();
		boolean taskAssignableForUser = WorkflowUtil.isTaskAssignableForUser(themeDisplay,
				EcMemberRequest.class.getName(), requestId, themeDisplay.getUserId());

		log.debug("taskAssignableForUser > " + taskAssignableForUser);

		List<ActionDetail> actionList = new ArrayList<ActionDetail>();
		List<String> transitionNames = new ArrayList<String>();
		List<String> transitionLevels = new ArrayList<String>();

		if (taskAssignableForUser) {

			if ("MEMBER_DETAILS_ENTRY".equalsIgnoreCase(statusCode)) {
				if (data.getPassportCopyId() > 0 && data.getNationalIdCopyId() > 0) {
					statusCode = statusCode + ":EDIT";
				}
			}

			actionList = ActionManager.getActions(statusCode);

			memberRequestDetail.setActionList(actionList);

			long workflowTaskId = WorkflowUtil.getCurrentTaskId(themeDisplay, EcMemberRequest.class.getName(),
					requestId, themeDisplay.getUserId());
			WorkflowInstance workflowInstance = WorkflowUtil.getWorkflowInstace(EcMemberRequest.class.getName(),
					themeDisplay, requestId);
			memberRequestDetail.setWorkflowTaskId(workflowTaskId);
			memberRequestDetail.setWorkflowInstanceId(workflowInstance.getWorkflowInstanceId());

			transitionNames = WorkflowUtil.getNextTransitionNames(themeDisplay.getCompanyId(), workflowTaskId,
					themeDisplay.getUserId());

			if (transitionNames != null && transitionNames.size() > 0) {
				for (String transitionName : transitionNames) {
					transitionLevels.add(ActionManager.getTransitionLevel(transitionName, httpRequest));
				}
			}
		}

		memberRequestDetail.setActionList(actionList);
		memberRequestDetail.setTransitionNames(transitionNames);
		memberRequestDetail.setTransitionLevels(transitionLevels);

		log.debug("actionList > " + actionList);
		log.debug("transitionNames > " + transitionNames);
		log.debug("transitionLevels > " + transitionLevels);

		return memberRequestDetail;
	}

	public static WorkflowTaskDetail getMemberRequestWorkflowDetail(HttpServletRequest httpRequest,
			ThemeDisplay themeDisplay, EcMemberRequest ecMemberRequest) {
		WorkflowTaskDetail workflowTaskDetail = new WorkflowTaskDetail();

		try {

			if (ecMemberRequest.getLatestEcMemberRequestStateId() <= 0) {
				return workflowTaskDetail;
			}

			EcMemberRequestState ecMemberRequestStates = EcMemberRequestStateLocalServiceUtil
					.getEcMemberRequestState(ecMemberRequest.getLatestEcMemberRequestStateId());
			EcMemberRequestStatus requestStatus = EcMemberRequestStatusLocalServiceUtil
					.getEcMemberRequestStatus(ecMemberRequestStates.getEcMemberRequestStatusId());

			String statusCode = requestStatus.getCode();
			log.debug("statusCode > " + statusCode);

			// workflow task

			long requestId = ecMemberRequest.getEcMemberRequestId();

			workflowTaskDetail.setRequestId(requestId);

			boolean taskAssignableForUser = WorkflowUtil.isTaskAssignableForUser(themeDisplay,
					EcMemberRequest.class.getName(), requestId, themeDisplay.getUserId());

			log.debug("taskAssignableForUser > " + taskAssignableForUser);

			List<ActionDetail> actionList = new ArrayList<ActionDetail>();
			List<String> transitionNames = new ArrayList<String>();
			List<String> transitionLevels = new ArrayList<String>();

			if (taskAssignableForUser) {

				if ("MEMBER_DETAILS_ENTRY".equalsIgnoreCase(statusCode)) {
					if (ecMemberRequest.getPassportCopyId() > 0 && ecMemberRequest.getNationalIdCopyId() > 0) {
						statusCode = statusCode + ":EDIT";
					}
				}

				actionList = ActionManager.getActions(statusCode);

				workflowTaskDetail.setActionList(actionList);

				transitionNames = WorkflowUtil.getNextTransitionNames(themeDisplay, EcMemberRequest.class.getName(),
						requestId, themeDisplay.getUserId());

				long workflowTaskId = WorkflowUtil.getCurrentTaskId(themeDisplay, EcMemberRequest.class.getName(),
						requestId, themeDisplay.getUserId());
				WorkflowInstance workflowInstance = WorkflowUtil.getWorkflowInstace(EcMemberRequest.class.getName(),
						themeDisplay, requestId);
				workflowTaskDetail.setTaskId(workflowTaskId);
				workflowTaskDetail.setWorkflowInstanceId(workflowInstance.getWorkflowInstanceId());

				if (transitionNames != null && transitionNames.size() > 0) {
					for (String transitionName : transitionNames) {
						transitionLevels.add(ActionManager.getTransitionLevel(transitionName, httpRequest));
					}
				}
			}

			workflowTaskDetail.setActionList(actionList);
			workflowTaskDetail.setTransitionNames(transitionNames);
			workflowTaskDetail.setTransitionLevels(transitionLevels);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return workflowTaskDetail;
	}

	public EcMemberRequest createNewRequest(EcMemberRequest ecMemberRequest, User user, String viewUrl)
			throws PortalException {
		log.info("createNewRequest Start test");

		ecMemberRequest = EcMemberRequestLocalServiceUtil.updateRequest(ecMemberRequest);

		ProgramMaster programMaster = programMasterLocalService.getProgramMaster(ecMemberRequest.getProgramId());

		String programName = programMaster.getProgramName(Locale.ENGLISH);

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		log.debug("programName >" + programName);
		serviceContext.setAttribute("PROGRAM-NAME", programName);
		serviceContext.setAttribute("viewDetailsUrl", viewUrl);
		serviceContext.setAttribute("backURL", viewUrl);
		serviceContext.setAttribute("url", viewUrl);

		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
		workflowContext.put("viewDetailsUrl", viewUrl);
		workflowContext.put("PROGRAM-NAME", programName);

		AssetEntryLocalServiceUtil.updateEntry(user.getUserId(), ecMemberRequest.getGroupId(),
				EcMemberRequest.class.getName(), ecMemberRequest.getEcMemberRequestId(),
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());

		WorkflowHandlerRegistryUtil.startWorkflowInstance(ecMemberRequest.getCompanyId(), ecMemberRequest.getGroupId(),
				user.getUserId(), EcMemberRequest.class.getName(), ecMemberRequest.getEcMemberRequestId(),
				ecMemberRequest, serviceContext, workflowContext);

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}

		log.info("createNewRequest End");

		return ecMemberRequest;
	}

	public void submitTask(ThemeDisplay themeDisplay, long workflowInstanceId, long taskId, String transitionName,
			String comment) throws PortalException {

		WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);

		log.info("************** isCompleted >  " + task.isCompleted());

		if (task.isCompleted()) {
			return;
		}

		Map<String, Serializable> workflowContext = WorkflowInstanceManagerUtil
				.getWorkflowInstance(themeDisplay.getCompanyId(), workflowInstanceId).getWorkflowContext();

		workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, String.valueOf(themeDisplay.getUserId()));
		workflowContext.put(WorkflowConstants.CONTEXT_TASK_COMMENTS, comment);

		if (task.getAssigneeUserId() <= 0) { // task is not assigned to user
			List<User> userList = WorkflowTaskManagerUtil.getAssignableUsers(taskId);

			if (userList.stream().anyMatch(u -> u.getUserId() == themeDisplay.getUserId())) {
				log.info(" task is not assigned to user Auto assign");
				WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
						taskId, themeDisplay.getUserId(), "Auto assign", task.getDueDate(), workflowContext);
			}

			log.info(" task is assigned to user completeWorkflowTask");
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), taskId,
					transitionName, comment, workflowContext);
			log.info("completeWorkflowTask done");

		} else if (task.getAssigneeUserId() == themeDisplay.getUserId()) {

			log.info("task is assigned to user completeWorkflowTask");
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), taskId,
					transitionName, comment, workflowContext);
			log.info("task is not assigned to user completeWorkflowTask done");
		}

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}

	}

	public static Role getUserRole(long groupId, long userId) throws PortalException {
		String[] roleName = { "Potential EC Member", "Executive President", "EC Section Head", "Authorized Individual",
				"EC Section Staff", "GME Director", "VPAA", "Chairman" };
		List<Role> userRoles = UserLocalServiceUtil.getUser(userId).getRoles();
		for (int i = 0; i < roleName.length; i++) {
			for (Role role : userRoles) {
				if (role.getName().equals(roleName[i])) {
					return role;
				}
			}
		}

		return null;
	}

	public static void assignECMemberRole(EcMemberRequest ecMemberRequest, long companyId, long groupId) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(ecMemberRequest.getPotentialEcMemberLruserid());
			RoleLocalServiceUtil.addUserRole(user.getUserId(), ecMemberRequest.getPotentialEcMemberRoleId());
			UserLocalServiceUtil.updateUser(user);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		try {

			UserLocalServiceUtil.deleteRoleUser(
					RoleLocalServiceUtil.getRole(companyId, ECMemberRoles.POTENTIAL_EC_MEMBER).getRoleId(),
					user.getUserId());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void assignPotentialECMemberRole(EcMemberRequest ecMemberRequest, ServiceContext serviceContext) {
		log.info("checkPotentialECMemberRoleIsAssignOrNot called");
		User user = null;
		Role role;
		try {
			log.info("CompenyId " + serviceContext.getCompanyId());
			role = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), ECMemberRoles.POTENTIAL_EC_MEMBER);
			user = UserLocalServiceUtil.getUser(ecMemberRequest.getPotentialEcMemberLruserid());
			log.info("isPotentialECMember(user.getUserId(),role.getRoleId())  :  "
					+ isPotentialECMember(user.getUserId(), role.getRoleId()));
			if (!isPotentialECMember(user.getUserId(), role.getRoleId())) {

				RoleLocalServiceUtil.addUserRole(user.getUserId(), role.getRoleId());
				UserLocalServiceUtil.updateUser(user);
				log.info("Potential EC Member Role Update Successfully");
			}
		} catch (PortalException e) {

			e.printStackTrace();
		}
	}

	public static boolean isPotentialECMember(long userId, long roleId) {
		log.info("isPotentialECMember called");
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(userId);
		for (Role userRole : userRoles) {
			if (userRole.getRoleId() == roleId) {
				log.info("Inside Role Check");
				return true;
			}

		}

		return false;

	}

	@SuppressWarnings("deprecation")
	public void setNOCData(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) throws PortalException {
		log.info("setNOCData called");
		log.info("noc letter Id " + ecMemberRequest.getNoObjectionLetterId());
		try {
			DocumentInfoItem documentInfoItem = getDocumentInfoObjectByDocumentInfoId(
					ecMemberRequest.getNoObjectionLetterId());
			FileEntry nocFileEntry = DLAppServiceUtil.getFileEntry(documentInfoItem.getFileEntryID());
			String nocURL = DLURLHelperUtil.getPreviewURL(nocFileEntry, nocFileEntry.getLatestFileVersion(),
					themeDisplay, null);
			String nocName = nocFileEntry.getDescription();
			viewEcMemberRequestDTO.setNoObjectionLetterName(nocName);
			viewEcMemberRequestDTO.setNoObjectionLetterUrl(nocURL);
		} catch (Exception e) {
			log.debug(e);
		}
		log.info("setNocData methon end");
	}

	private DocumentInfoItem getDocumentInfoObjectByDocumentInfoId(long documentInfoId) {
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String payload = "{\"documentInfoId\": \"" + documentInfoId + "\"}";
		String url = getScopeURL(LRObjectURL.GET_DOCUMENT_INFO_BY_DOC_INFO_ID, documentInfoId);
		String response = httpConnector.executeGet(url, payload, headers);
		return CustomObjectMapperUtil.readValue(response, DocumentInfoItem.class);
	}

	private String getScopeURL(String url, long documentInfoId) {
		return omsbCommonApi.getBaseURL() + url.replace("{document-info-id}", String.valueOf(documentInfoId));
	}

	public UserMetadata addUserMetaData(EcMemberRequest ecMemberRequest) throws PortalException {
		EcMemberRequest ecMemberRequestObj = ecMemberRequestLocalService
				.getEcMemberRequest(ecMemberRequest.getEcMemberRequestId());
		log.debug("ecMemberRequest => " + ecMemberRequestObj);
		UserMetadata userMetaData = new UserMetadata();
		userMetaData.setLrUserId(ecMemberRequestObj.getPotentialEcMemberLruserid());
		userMetaData.setProgramId(ecMemberRequestObj.getProgramId());
		userMetaData.setRoleId(ecMemberRequestObj.getPotentialEcMemberRoleId());
		log.debug("userMetaData => " + userMetaData);
		return userMetaData;
	}

	public void saveUserMetadata(UserMetadata userMetadata, long groupId) {
		log.info("into saveUserMetadata function");
		String userMetadataDetailUrl = generateScopeListURL(LRObjectURL.REG_USER_METADATA_URL, groupId);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String userMetadataDetailMapper = CustomObjectMapperUtil.writeValueAsString(userMetadata, null);
		httpConnector.executePost(userMetadataDetailUrl, userMetadataDetailMapper, headers);
	}

	@SuppressWarnings("deprecation")
	public String getQararURL(ViewEcMemberRequestDTO viewEcMemberRequestDTO, ThemeDisplay themeDisplay,
			EcMemberRequest ecMemberRequest) throws PortalException {
		String qararURL = "";
		log.info("setQararData called");
		log.debug("qarar doc Id " + ecMemberRequest.getQararDocId());
		try {
			DocumentInfoItem documentInfoItem = getDocumentInfoObjectByDocumentInfoId(ecMemberRequest.getQararDocId());
			FileEntry qararFileEntry = DLAppServiceUtil.getFileEntry(documentInfoItem.getFileEntryID());
			qararURL = DLURLHelperUtil.getPreviewURL(qararFileEntry, qararFileEntry.getLatestFileVersion(),
					themeDisplay, null);
		} catch (Exception e) {
			log.debug(e);
		}
		log.info("setQararData methon end");
		return qararURL;
	}

	public PersonalDetail fetchPersonalDetailsByPersonId(ThemeDisplay themeDisplay, long lruserId)
			throws UnsupportedEncodingException {
		String personalDetailsUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + lruserId, DataflowConstants.UTF_8);

		String personalDetailsResponse = omsbCommonApi.getData(personalDetailsUrl);
		log.debug("personalDetailsUrl=====>" + personalDetailsResponse);
		PersonalDetailItem personalDetailsItem = CustomObjectMapperUtil.readValue(personalDetailsResponse,
				PersonalDetailItem.class);
		PersonalDetail personalDetail = null;
		if (Validator.isNotNull(personalDetailsItem) && Validator.isNotNull(personalDetailsItem.getItems())
				&& personalDetailsItem.getItems().size() > 0) {
			personalDetail = personalDetailsItem.getItems().get(0);
			log.debug("personDetail=====>" + personalDetail.getPassportNumber());

		}
		return personalDetail;
	}

	public EducationalDetailsItem fetchEducationDetailsItemByEducationId(ThemeDisplay themeDisplay, long educationId)
			throws UnsupportedEncodingException {
		String educationDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + educationId;
		String educationDetailResponse = omsbCommonApi.getData(educationDetailUrl);
		EducationalDetailsItem educationalDetailsItem = CustomObjectMapperUtil.readValue(educationDetailResponse,
				EducationalDetailsItem.class);
		return educationalDetailsItem;
	}

	public Person getPersonById(ThemeDisplay themeDisplay, long persononId) {
		Person person = null;
		try {
			String personWithScopeURL = omsbCommonApi.getBaseURL()
					+ LRObjectURL.PERSON_URL.replace(SCOPE_ID, String.valueOf(themeDisplay.getScopeGroupId()));
			String personUrl = personWithScopeURL + StringPool.QUESTION + FILTER + ID
					+ URLEncoder.encode(EQ + SINGLE_QUOTE + persononId + SINGLE_QUOTE, UNICODE_TRANSFORMATION_FORMAT);

			String personResponse = omsbCommonApi.getData(personUrl);
			PersonItem personItems = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);

			if (Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems())
					&& personItems.getItems().size() > 0) {
				person = personItems.getItems().get(0);
				log.info("person----------" + person);
			}
		} catch (Exception e) {
			log.debug(e);
		}
		return person;
	}

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progDurRotTrainSitesRelLS;

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

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
	private EcMemberRequestRotationsLocalService ecMemberRequestRotationsLocalService;

	@Reference(unbind = "-")
	private EcMemberRequestStatusLocalService ecMemberRequestStatusLocalService;

	@Reference(unbind = "-")
	private EcMemberRequestStateLocalService ecMemberRequestStateLocalService;

	private static final Log log = LogFactoryUtil.getLog(MembershipUtil.class);

	@Reference
	private OMSBHttpConnector httpConnector;

	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;

}

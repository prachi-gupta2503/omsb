package gov.omsb.faculty.membership.web.commands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipConstants;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.dto.CommentDetailsDTO;
import gov.omsb.faculty.membership.web.dto.EducationDetailsDTO;
import gov.omsb.faculty.membership.web.dto.ExistingAffiliationsDTO;
import gov.omsb.faculty.membership.web.dto.FacultyRequestDetailsDTO;
import gov.omsb.faculty.membership.web.dto.PersonalDetailsDTO;
import gov.omsb.faculty.membership.web.dto.WorkflowTaskDetail;
import gov.omsb.faculty.membership.web.util.FacultyDocumentUtil;
import gov.omsb.faculty.membership.web.util.FacultyMemebershipUtil;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.model.FacultyBankDetails;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.service.FacultyBankDetailsLocalService;
import gov.omsb.tms.service.FacultyRequestLocalService;
import gov.omsb.tms.service.FacultyRequestRotationsLocalService;
import gov.omsb.tms.service.FacultyRequestStateLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIPREQUEST, "mvc.command.name="
				+ FacultyMembershipConstants.VIEW_FACULTY_REQUEST_DETAILS_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ViewFacultyRequestDetailsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FacultyMembershipConstants.COMMENTS_DATE_FORMAT);

		long facultyRequestId = ParamUtil.getLong(renderRequest,
				FacultyMembershipConstants.FACULTY_REQUEST_ID_COLUMN_NAME);

		log.info("Faculty Request Id :: " + facultyRequestId);

		FacultyRequestDetailsDTO facultyRequestDetailsDTO = new FacultyRequestDetailsDTO();
		List<EducationDetailsDTO> educationDetailsDTOs = new ArrayList<>();
		PersonalDetailsDTO personalDetailsDTO = new PersonalDetailsDTO();
		List<ExistingAffiliationsDTO> existingAffiliationsDTOs = new ArrayList<>();
		List<CommentDetailsDTO> commentDetailsDTOs = new ArrayList<>();
		FacultyRequest facultyRequest = null;
		try {
			facultyRequest = facultyRequestLocalService.getFacultyRequest(facultyRequestId);

			if (Validator.isNotNull(facultyRequest)) {
				User facultyUser = userLocalService.getUser(facultyRequest.getPotentialFacultyId());

				String programName = programMasterLocalService.getProgramMaster(facultyRequest.getProgramId())
						.getProgramName(themeDisplay.getLocale());

				// FacultyRequestRotations for getting trainingSiteName & rotationName...
				/*
				 * FacultyRequestRotations facultyRequestRotation =
				 * facultyRequestRotationsLocalService
				 * .findByFacultyRequestIdAndIsActive(facultyRequestId, true);
				 */
				String trainingSiteName = StringPool.BLANK;
				String rotationName = StringPool.BLANK;

				/*
				 * if (Validator.isNotNull(facultyRequestRotation)) { trainingSiteName =
				 * trainingSitesMasterLocalService
				 * .getTrainingSitesMaster(facultyRequestRotation.getTrainingSiteId())
				 * .getTrainingSiteName(themeDisplay.getLocale());
				 * 
				 * rotationName =
				 * rotationMasterLocalService.getRotationMaster(facultyRequestRotation.
				 * getRotationId()) .getRotationName(themeDisplay.getLocale()); }
				 */

				// Person Object for getting civilNumber, passportNumber & dateOfBirth...
				Person person = facultyMemebershipUtil.getPersonByLrUserId(themeDisplay,
						facultyRequest.getPotentialFacultyId());

				String civilNumber = StringPool.BLANK;
				String passportNumber = StringPool.BLANK;
				String dateOfBirth = StringPool.BLANK;

				long personId = 0;

				if (Validator.isNotNull(person)) {
					personId = person.getId();
					civilNumber = person.getCivilId();
					passportNumber = person.getPassportNumber();
					dateOfBirth = facultyMemebershipUtil.getDobData(person.getDateOfBirth());
				}

				// Fetching PersonalDetail Object for getting email, mobile and
				// givenNameAsPassport data...
				PersonalDetail personalDetail = facultyMemebershipUtil.getPersonalDetailByPersonId(themeDisplay,
						personId);

				if (Validator.isNotNull(personalDetail)) {
					personalDetailsDTO.setEmail(personalDetail.getEmail());
					personalDetailsDTO.setMobile(personalDetail.getMobileNumber());
					personalDetailsDTO.setGivenNameAsPassport(personalDetail.getGivenNameAsPassport());
				}

				// Fetching BankDetails of the current person...
				String bankName = StringPool.BLANK;
				String accountNumber = StringPool.BLANK;
				String bankBranch = StringPool.BLANK;

				FacultyBankDetails facultyBankDetails = facultyBankDetailsLocalService
						.findByFacultyRequestId(facultyRequest.getFacultyRequestId());

				if (Validator.isNotNull(facultyBankDetails)) {
					bankName = facultyBankDetails.getBankName();
					accountNumber = facultyBankDetails.getAccountNo();
					bankBranch = facultyBankDetails.getBankBranch();
				}

				// Fetching facultyRoleName of the current person...
				String facultyRoleName = FacultyMemebershipUtil
						.getFacultyRoleNameByFacultyTypeId(facultyRequest.getPotentialFacultyTypeId(), themeDisplay);

				// Fetching every document names and its perview url...
				String cvFileName = facultyDocumentUtil.getFileNameByFileEntryId(facultyRequest.getCvId());
				String cvPreviewUrl = facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay,
						facultyRequest.getCvId());

				String coveringLetterFileName = facultyDocumentUtil
						.getFileNameByFileEntryId(facultyRequest.getCoveringLetterId());
				String coveringLetterPreviewUrl = facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay,
						facultyRequest.getCoveringLetterId());

				String passportCopyFileName = facultyDocumentUtil
						.getFileNameByFileEntryId(facultyRequest.getPassportCopyId());
				String passportCopyPreviewUrl = facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay,
						facultyRequest.getPassportCopyId());

				String nationalIdProofFileName = facultyDocumentUtil
						.getFileNameByFileEntryId(facultyRequest.getNotionalIdCopyId());
				String nationalIdProofPreviewUrl = facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay,
						facultyRequest.getNotionalIdCopyId());

				facultyRequestDetailsDTO.setProgramName(programName);
				facultyRequestDetailsDTO.setTrainingSiteName(trainingSiteName);
				facultyRequestDetailsDTO.setRotationName(rotationName);
				facultyRequestDetailsDTO.setFacultyName(facultyUser.getFullName());
				facultyRequestDetailsDTO.setFacultyRole(facultyRoleName);
				facultyRequestDetailsDTO.setCvFileName(cvFileName);
				facultyRequestDetailsDTO.setCvFileUrl(cvPreviewUrl);
				facultyRequestDetailsDTO.setCivilId(civilNumber);
				facultyRequestDetailsDTO.setPassportNumber(passportNumber);
				facultyRequestDetailsDTO.setDateOfBirth(dateOfBirth);
				facultyRequestDetailsDTO.setEmailId(facultyUser.getEmailAddress());
				facultyRequestDetailsDTO.setBankName(bankName);
				facultyRequestDetailsDTO.setAccountNumber(accountNumber);
				facultyRequestDetailsDTO.setBankBranchName(bankBranch);
				facultyRequestDetailsDTO.setCoveringLetterFileName(coveringLetterFileName);
				facultyRequestDetailsDTO.setCoveringLetterFileUrl(coveringLetterPreviewUrl);
				facultyRequestDetailsDTO.setPassportCopyFileName(passportCopyFileName);
				facultyRequestDetailsDTO.setPassportCopyFileUrl(passportCopyPreviewUrl);
				facultyRequestDetailsDTO.setNationalIdProofFileName(nationalIdProofFileName);
				facultyRequestDetailsDTO.setNationalIdProofFileUrl(nationalIdProofPreviewUrl);

				// Fetching the EducationDetail Object datas of the current person...
				List<EducationDetail> educationDetails = facultyMemebershipUtil
						.getEducationDetailsByPersonId(themeDisplay, personId);

				// educationDetailsDTOs = setEducationDetailsInDTO(educationDetailsDTOs,
				// educationDetails, themeDisplay);

				// Fetching Existing Affiliation Data of the Current Person...
				DynamicQuery existingAffiliationDQ = facultyRequestLocalService.dynamicQuery();
				existingAffiliationDQ
						.add(RestrictionsFactoryUtil.eq(FacultyMembershipConstants.POTENTIAL_FACULTY_ID_COLUMN_NAME,
								facultyRequest.getPotentialFacultyId()));
				List<FacultyRequest> facultyRequests = facultyRequestLocalService.dynamicQuery(existingAffiliationDQ);

				existingAffiliationsDTOs = setExistingAffiliationDetailsInDTO(existingAffiliationsDTOs, facultyRequests,
						facultyRequest, programName, themeDisplay);

				// Fetching the Comments of the current person...
				DynamicQuery facultyStatesDQ = facultyRequestStateLocalService.dynamicQuery();
				facultyStatesDQ
						.add(RestrictionsFactoryUtil.eq(FacultyMembershipConstants.FACULTY_REQUEST_ID_COLUMN_NAME,
								facultyRequest.getFacultyRequestId()));
				facultyStatesDQ.addOrder(OrderFactoryUtil.desc(FacultyMembershipConstants.CREATED_DATE_COLUMN_NAME));

				List<FacultyRequestState> facultyRequestStates = facultyRequestStateLocalService
						.dynamicQuery(facultyStatesDQ);

				commentDetailsDTOs = setCommentDetailsInDTO(commentDetailsDTOs, facultyRequestStates, themeDisplay,
						simpleDateFormat);

			} else {
				log.info("UNABLE TO FETCH FACULTY REQUEST WITH THE FACULTY ID");
			}

		} catch (PortalException e) {
			log.error("ERROR -> " + e.getMessage());
		}
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		renderRequest.setAttribute(FacultyMembershipConstants.FACULTY_MEMBERSHIP_DETAILS_KEY, facultyRequestDetailsDTO);
		renderRequest.setAttribute(FacultyMembershipConstants.EDUCATION_DETAILS_KEY, educationDetailsDTOs);
		renderRequest.setAttribute(FacultyMembershipConstants.PERSONAL_DETAILS_KEY, personalDetailsDTO);
		renderRequest.setAttribute(FacultyMembershipConstants.EXISTING_AFFILIATION_DETAILS_KEY,
				existingAffiliationsDTOs);
		renderRequest.setAttribute(FacultyMembershipConstants.COMMENT_DETAILS_KEY, commentDetailsDTOs);
		if (Validator.isNotNull(facultyRequest)){
			WorkflowTaskDetail workflowTaskDetail = MembershipUtil.getMemberRequestWorkflowDetail(httpRequest,
					themeDisplay, facultyRequest);
			renderRequest.setAttribute("workflowTaskDetail", workflowTaskDetail);
			log.info("##### workflowTaskDetail :: "+workflowTaskDetail);
		}
		return FacultyMembershipConstants.VIEW_FACULTY_REQUEST_DETAILS_JSP_PAGE;
	}

	private List<EducationDetailsDTO> setEducationDetailsInDTO(List<EducationDetailsDTO> educationDetailsDTOs,
			List<EducationDetail> educationDetails, ThemeDisplay themeDisplay) {

		if (Validator.isNotNull(educationDetails) && !educationDetails.isEmpty()) {
			for (EducationDetail educationDetail : educationDetails) {

				DocumentInfo documentInfo = facultyMemebershipUtil.getQualificationDocumentURL(themeDisplay,
						educationDetail.getId());

				EducationDetailsDTO educationDetailsDTO = new EducationDetailsDTO();

				educationDetailsDTO.setTitle(facultyMemebershipUtil
						.getQualificationTitle(educationDetail.getQualificationAttained(), themeDisplay));
				educationDetailsDTO.setInstitution(facultyMemebershipUtil
						.getInstitutionName(educationDetail.getIssuingAuthorityName(), themeDisplay));
				educationDetailsDTO.setCountry(facultyMemebershipUtil.getCountryName(themeDisplay,
						educationDetail.getIssuingAuthorityCountryId()));
				educationDetailsDTO.setGpa(educationDetail.getGpa());
				educationDetailsDTO.setYear(String.valueOf(educationDetail.getYearOfGraduation()));
				educationDetailsDTO
						.setDocName(facultyDocumentUtil.getFileNameByFileEntryId(documentInfo.getFileEntryID()));
				educationDetailsDTO.setDocUrl(
						facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay, documentInfo.getFileEntryID()));

				educationDetailsDTOs.add(educationDetailsDTO);
			}
		}

		return educationDetailsDTOs;

	}

	private List<ExistingAffiliationsDTO> setExistingAffiliationDetailsInDTO(
			List<ExistingAffiliationsDTO> existingAffiliationsDTOs, List<FacultyRequest> facultyRequests,
			FacultyRequest facultyRequest, String programName, ThemeDisplay themeDisplay) {

		for (FacultyRequest request : facultyRequests) {
			if (request.getFacultyRequestId() != facultyRequest.getFacultyRequestId()) {
				ExistingAffiliationsDTO existingAffiliationsDTO = new ExistingAffiliationsDTO();

				existingAffiliationsDTO.setProgramName(programName);
				existingAffiliationsDTO.setRoleName(FacultyMemebershipUtil
						.getFacultyRoleNameByFacultyTypeId(request.getPotentialFacultyTypeId(), themeDisplay));

				existingAffiliationsDTOs.add(existingAffiliationsDTO);
			}
		}

		return existingAffiliationsDTOs;

	}

	private List<CommentDetailsDTO> setCommentDetailsInDTO(List<CommentDetailsDTO> commentDetailsDTOs,
			List<FacultyRequestState> facultyRequestStates, ThemeDisplay themeDisplay,
			SimpleDateFormat simpleDateFormat) throws PortalException {

		for (FacultyRequestState facultyRequestState : facultyRequestStates) {
			User user = userLocalService.getUser(facultyRequestState.getCreatedBy());
			Role role = roleLocalService.getRole(facultyRequestState.getCreatedByRoleId());

			CommentDetailsDTO commentDetailsDTO = new CommentDetailsDTO();

			if (Validator.isNotNull(user)) {
				commentDetailsDTO.setCommentBy(user.getFullName());
			}
			if (Validator.isNotNull(role)) {
				commentDetailsDTO.setRole(role.getTitle(themeDisplay.getLocale()));
			}

			commentDetailsDTO.setDate(simpleDateFormat.format(facultyRequestState.getCreateDate()));
			commentDetailsDTO.setComment(facultyRequestState.getComments());

			commentDetailsDTOs.add(commentDetailsDTO);
		}

		return commentDetailsDTOs;

	}

	@Reference
	private FacultyRequestLocalService facultyRequestLocalService;

	@Reference
	private FacultyRequestRotationsLocalService facultyRequestRotationsLocalService;

	@Reference
	private FacultyBankDetailsLocalService facultyBankDetailsLocalService;

	@Reference
	private FacultyRequestStateLocalService facultyRequestStateLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private FacultyDocumentUtil facultyDocumentUtil;

	@Reference
	private FacultyMemebershipUtil facultyMemebershipUtil;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private RoleLocalService roleLocalService;

	private Log log = LogFactoryUtil.getLog(ViewFacultyRequestDetailsMVCRenderCommand.class.getName());

}
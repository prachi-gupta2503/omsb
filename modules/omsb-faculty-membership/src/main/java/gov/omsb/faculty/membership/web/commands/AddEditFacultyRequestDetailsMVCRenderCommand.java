package gov.omsb.faculty.membership.web.commands;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
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
import gov.omsb.faculty.membership.web.constants.FacultyMembershipConstants;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.dto.CommentDetailsDTO;
import gov.omsb.faculty.membership.web.dto.EducationDetailsDTO;
import gov.omsb.faculty.membership.web.dto.FacultyRequestDetailsDTO;
import gov.omsb.faculty.membership.web.dto.WorkflowTaskDetail;
import gov.omsb.faculty.membership.web.util.FacultyDocumentUtil;
import gov.omsb.faculty.membership.web.util.FacultyMemebershipUtil;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.model.FacultyBankDetails;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.service.FacultyBankDetailsLocalService;
import gov.omsb.tms.service.FacultyRequestLocalService;
import gov.omsb.tms.service.FacultyRequestLocalServiceUtil;
import gov.omsb.tms.service.FacultyRequestStateLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIPREQUEST, "mvc.command.name="
				+ FacultyMembershipConstants.ADD_EDIT_FACULTY_REQUEST_DETAILS_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class AddEditFacultyRequestDetailsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FacultyMembershipConstants.COMMENTS_DATE_FORMAT);

		long facultyRequestId = ParamUtil.getLong(renderRequest,
				FacultyMembershipConstants.FACULTY_REQUEST_ID_COLUMN_NAME);

		long personId = 0;

		log.info("    ##### AddEditFacultyRequestDetailsMVCRenderCommand Faculty Request Id :: " + facultyRequestId);

		FacultyRequestDetailsDTO facultyRequestDetailsDTO = new FacultyRequestDetailsDTO();
		List<EducationDetailsDTO> educationDetailsDTOs = new ArrayList<>();
		List<CommentDetailsDTO> commentDetailsDTOs = new ArrayList<>();

		try {
			FacultyRequest facultyRequest = facultyRequestLocalService.getFacultyRequest(facultyRequestId);

			String passportCopyFileName = facultyDocumentUtil
					.getFileNameByFileEntryId(facultyRequest.getPassportCopyId());
			String passportCopyPreviewUrl = facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay,
					facultyRequest.getPassportCopyId());

			String nationalIdProofFileName = facultyDocumentUtil
					.getFileNameByFileEntryId(facultyRequest.getNotionalIdCopyId());
			String nationalIdProofPreviewUrl = facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay,
					facultyRequest.getNotionalIdCopyId());

			// Fetching BankDetails of the current person...
			String bankName = StringPool.BLANK;
			String accountNumber = StringPool.BLANK;
			String bankBranch = StringPool.BLANK;

			FacultyBankDetails facultyBankDetails = facultyBankDetailsLocalService
					.findByFacultyRequestId(facultyRequestId);

			if (Validator.isNotNull(facultyBankDetails)) {
				bankName = facultyBankDetails.getBankName();
				accountNumber = facultyBankDetails.getAccountNo();
				bankBranch = facultyBankDetails.getBankBranch();
			}

			facultyRequestDetailsDTO.setBankName(bankName);
			facultyRequestDetailsDTO.setAccountNumber(accountNumber);
			facultyRequestDetailsDTO.setBankBranchName(bankBranch);
			facultyRequestDetailsDTO.setPassportCopyFileName(passportCopyFileName);
			facultyRequestDetailsDTO.setPassportCopyFileUrl(passportCopyPreviewUrl);
			facultyRequestDetailsDTO.setNationalIdProofFileName(nationalIdProofFileName);
			facultyRequestDetailsDTO.setNationalIdProofFileUrl(nationalIdProofPreviewUrl);

			// Person Object for getting civilNumber, passportNumber & dateOfBirth...
			Person person = facultyMemebershipUtil.getPersonByLrUserId(themeDisplay,
					facultyRequest.getPotentialFacultyId());

			if (Validator.isNotNull(person)) {
				personId = person.getId();
			}

			// Fetching the EducationDetail Object datas of the current person...
			List<EducationDetail> educationDetails = facultyMemebershipUtil.getEducationDetailsByPersonId(themeDisplay,
					personId);

			educationDetailsDTOs = setEducationDetailsInDTO(educationDetailsDTOs, educationDetails, themeDisplay);

			// Fetching the Comments of the current person...
			DynamicQuery facultyStatesDQ = facultyRequestStateLocalService.dynamicQuery();
			facultyStatesDQ.add(RestrictionsFactoryUtil.eq(FacultyMembershipConstants.FACULTY_REQUEST_ID_COLUMN_NAME,
					facultyRequest.getFacultyRequestId()));
			facultyStatesDQ.addOrder(OrderFactoryUtil.desc(FacultyMembershipConstants.CREATED_DATE_COLUMN_NAME));

			List<FacultyRequestState> facultyRequestStates = facultyRequestStateLocalService
					.dynamicQuery(facultyStatesDQ);

			commentDetailsDTOs = setCommentDetailsInDTO(commentDetailsDTOs, facultyRequestStates, themeDisplay,
					simpleDateFormat);

		} catch (PortalException e) {
			log.error("ERROR -> " + e.getMessage());
		}

		List<ListTypeEntry> institutionEntries = facultyMemebershipUtil.getInstitutions(themeDisplay);

		List<Country> countries = countryLocalService.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		List<Integer> years = facultyMemebershipUtil.getYears();

		renderRequest.setAttribute(FacultyMembershipConstants.FACULTY_MEMBERSHIP_DETAILS_KEY, facultyRequestDetailsDTO);
		renderRequest.setAttribute(FacultyMembershipConstants.EDUCATION_DETAILS_KEY, educationDetailsDTOs);
		renderRequest.setAttribute(FacultyMembershipConstants.COMMENT_DETAILS_KEY, commentDetailsDTOs);
		renderRequest.setAttribute(FacultyMembershipConstants.FACULTY_REQUEST_ID_COLUMN_NAME, facultyRequestId);
		renderRequest.setAttribute(FacultyMembershipConstants.PERSON_ID_KEY, personId);
		renderRequest.setAttribute(FacultyMembershipConstants.INSTITUTIONS_KEY, institutionEntries);
		renderRequest.setAttribute(FacultyMembershipConstants.COUNTRIES_KEY, countries);
		renderRequest.setAttribute(FacultyMembershipConstants.YEARS_KEY, years);

		FacultyRequest facultyRequest = null;
		try {
			facultyRequest = FacultyRequestLocalServiceUtil.getFacultyRequest(facultyRequestId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		WorkflowTaskDetail workflowTaskDetail = MembershipUtil.getMemberRequestWorkflowDetail(httpRequest, themeDisplay,
				facultyRequest);

		renderRequest.setAttribute("workflowTaskDetail", workflowTaskDetail);
		return FacultyMembershipConstants.ADD_EDIT_FACULTY_REQUEST_DETAILS_JSP_PAGE;
	}

	private List<EducationDetailsDTO> setEducationDetailsInDTO(List<EducationDetailsDTO> educationDetailsDTOs,
			List<EducationDetail> educationDetails, ThemeDisplay themeDisplay) {

		if (Validator.isNotNull(educationDetails) && !educationDetails.isEmpty()) {
			for (EducationDetail educationDetail : educationDetails) {

				DocumentInfo documentInfo = facultyMemebershipUtil.getQualificationDocumentURL(themeDisplay,
						educationDetail.getId());

				long fileEntryId = 0;

				if (Validator.isNotNull(documentInfo)) {
					fileEntryId = documentInfo.getFileEntryID();
				}

				EducationDetailsDTO educationDetailsDTO = new EducationDetailsDTO();

				educationDetailsDTO.setId(educationDetail.getId());
				educationDetailsDTO.setTitle(facultyMemebershipUtil
						.getQualificationTitle(educationDetail.getQualificationAttained(), themeDisplay));
				educationDetailsDTO.setInstitution(facultyMemebershipUtil
						.getInstitutionName(educationDetail.getIssuingAuthorityName(), themeDisplay));
				educationDetailsDTO.setCountry(facultyMemebershipUtil.getCountryName(themeDisplay,
						educationDetail.getIssuingAuthorityCountryId()));
				educationDetailsDTO.setGpa(educationDetail.getGpa());
				educationDetailsDTO.setYear(String.valueOf(educationDetail.getYearOfGraduation()));
				educationDetailsDTO.setDocName(facultyDocumentUtil.getFileNameByFileEntryId(fileEntryId));
				educationDetailsDTO
						.setDocUrl(facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay, fileEntryId));

				educationDetailsDTOs.add(educationDetailsDTO);

			}
		}

		return educationDetailsDTOs;

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
	private FacultyBankDetailsLocalService facultyBankDetailsLocalService;

	@Reference
	private FacultyRequestStateLocalService facultyRequestStateLocalService;

	@Reference
	private FacultyMemebershipUtil facultyMemebershipUtil;

	@Reference
	private FacultyDocumentUtil facultyDocumentUtil;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private CountryLocalService countryLocalService;

	private Log log = LogFactoryUtil.getLog(AddEditFacultyRequestDetailsMVCRenderCommand.class.getName());

}
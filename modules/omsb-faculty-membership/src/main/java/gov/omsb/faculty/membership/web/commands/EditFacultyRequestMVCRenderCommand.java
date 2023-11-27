package gov.omsb.faculty.membership.web.commands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.FacultyRequestConstants;
import gov.omsb.faculty.membership.web.dto.CommentDetailsDTO;
import gov.omsb.faculty.membership.web.dto.FacultyRequestDetailsDTO;
import gov.omsb.faculty.membership.web.dto.PersonalDetailsDTO;
import gov.omsb.faculty.membership.web.dto.WorkflowTaskDetail;
import gov.omsb.faculty.membership.web.util.FacultyDocumentUtil;
import gov.omsb.faculty.membership.web.util.GetPersonDetailsUtil;
import gov.omsb.faculty.membership.web.util.MasterDataUtil;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.model.FacultyRequestRotations;
import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.model.FacultyType;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.FacultyRequestLocalService;
import gov.omsb.tms.service.FacultyRequestLocalServiceUtil;
import gov.omsb.tms.service.FacultyRequestRotationsLocalService;
import gov.omsb.tms.service.FacultyRequestStateLocalService;
import gov.omsb.tms.service.FacultyTypeLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"mvc.command.name="
				+ FacultyRequestConstants.EDIT_FACULTY_REQUEST_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class EditFacultyRequestMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("edit render called");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		FacultyRequest facultyRequest = null;
		CommentDetailsDTO lastestComment = null;
		long facultyRequestId = ParamUtil.getLong(renderRequest, FacultyRequestConstants.FACULTY_REQUEST_ID);
		log.info("facultyRequestId :: " + facultyRequestId);
		try {
			facultyRequest = FacultyRequestLocalServiceUtil.getFacultyRequest(facultyRequestId);
		} catch (PortalException e) {
			log.error(e);
		}
		if (Validator.isNotNull(facultyRequest)) {
			PersonalDetailsDTO personalDetails = getPersonDetailsUtil.getPersonalDetails(themeDisplay,
					facultyRequest.getPotentialFacultyId());
			List<FacultyType> facultyTypeList = masterDataUtil.getFacultyType();
			FacultyRequestDetailsDTO facultyRequestDetails = getFacultyRequestDetails(facultyRequest, themeDisplay);
			if (facultyRequestDetails.getFacultyRoleId() != 0) {
				log.info("#### lastestComment" );
				lastestComment = getLastestComment(facultyRequestId,themeDisplay.getUserId());
				log.info("#### lastestComment" + lastestComment.getComment());
			
			}
			HttpServletRequest httpRequest = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			WorkflowTaskDetail workflowTaskDetail = MembershipUtil.getMemberRequestWorkflowDetail(httpRequest,
					themeDisplay, facultyRequest);
			log.info("#### workflowTaskDetail" + workflowTaskDetail);
			renderRequest.setAttribute(FacultyRequestConstants.PERSONAL_DETAILS, personalDetails);
			renderRequest.setAttribute(FacultyRequestConstants.FACULTY_TYPE_LIST, facultyTypeList);
			renderRequest.setAttribute(FacultyRequestConstants.FACULTY_REQUEST_DETAILS, facultyRequestDetails);
			renderRequest.setAttribute("workflowTaskDetail", workflowTaskDetail);
			renderRequest.setAttribute("lastestComment", lastestComment.getComment());

		}

		return FacultyRequestConstants.EDIT_FACULTY_REQUEST_PAGE;
	}

	private FacultyRequestDetailsDTO getFacultyRequestDetails(FacultyRequest facultyRequest,
			ThemeDisplay themeDisplay) {
		ProgramMaster programMaster = null;
		FacultyRequestRotations facultyRequestRotations;
		TrainingSitesMaster trainingSitesMaster = null;
		FileEntry cvFileName = null;
		FileEntry coveringLetterName = null;
		FacultyType facultyType = null;

		// set the all details in faculty request details dto
		FacultyRequestDetailsDTO facultyRequestDetailsDTO = new FacultyRequestDetailsDTO();
		facultyRequestDetailsDTO.setFacultyRequestDetailsId(facultyRequest.getFacultyRequestId());
		try {
			// set program master name
			programMaster = programMasterLocalService.getProgramMaster(facultyRequest.getProgramId());
			facultyRequestDetailsDTO.setProgramName(programMaster.getProgramName(themeDisplay.getLanguageId()));

			// set training site name
			facultyRequestRotations = facultyRequestRotationsLocalService
					.findByFacultyRequestIdAndIsActive(facultyRequest.getFacultyRequestId(), true);
			trainingSitesMaster = trainingSitesMasterLocalService
					.getTrainingSitesMaster(facultyRequestRotations.getTrainingSiteId());
			facultyRequestDetailsDTO
					.setTrainingSiteName(trainingSitesMaster.getTrainingSiteName(themeDisplay.getLanguageId()));

			// set cv file
			cvFileName = facultyDocumentUtil.getFileEntryByFileEntryId(facultyRequest.getCvId());
			facultyRequestDetailsDTO.setCvFileName(cvFileName.getDescription());
			String cvFileUrl = facultyDocumentUtil.getPreviewUrlByFileEntryId(themeDisplay, facultyRequest.getCvId());
			facultyRequestDetailsDTO.setCvFileUrl(cvFileUrl);
		} catch (PortalException e) {
			log.error(e);
		}

		// for edit edit mode when it was reject
		if (facultyRequest.getCoveringLetterId() != 0 || facultyRequest.getPotentialFacultyTypeId() != 0) {
			try {
				facultyType = facultyTypeLocalService.getFacultyType(facultyRequest.getPotentialFacultyTypeId());
				facultyRequestDetailsDTO.setFacultyRole(facultyType.getNameEn());
				facultyRequestDetailsDTO.setFacultyRoleId(facultyType.getFacultyTypeId());
				coveringLetterName = facultyDocumentUtil
						.getFileEntryByFileEntryId(facultyRequest.getCoveringLetterId());
				facultyRequestDetailsDTO.setCoveringLetterFileName(coveringLetterName.getDescription());
			} catch (PortalException e) {
				log.error(e);
			}
		}
		return facultyRequestDetailsDTO;
	}

	private CommentDetailsDTO getLastestComment(long facultyRequestId, long userId) {
		FacultyRequestState requestState = facultyRequestStateLocalService.findByRequestIdAndCreatedBy(facultyRequestId,
				userId);
		CommentDetailsDTO commentDetailsDTO = new CommentDetailsDTO();
		commentDetailsDTO.setComment(requestState.getComments());
		return commentDetailsDTO;
	}

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private GetPersonDetailsUtil getPersonDetailsUtil;

	@Reference
	private MasterDataUtil masterDataUtil;

	@Reference
	private FacultyRequestLocalService facultyRequestLocalService;

	@Reference
	private FacultyRequestStateLocalService facultyRequestStateLocalService;

	@Reference
	private FacultyTypeLocalService facultyTypeLocalService;

	@Reference
	private FacultyDocumentUtil facultyDocumentUtil;

	@Reference
	private FacultyRequestRotationsLocalService facultyRequestRotationsLocalService;

	private final Log log = LogFactoryUtil.getLog(EditFacultyRequestMVCRenderCommand.class);
}
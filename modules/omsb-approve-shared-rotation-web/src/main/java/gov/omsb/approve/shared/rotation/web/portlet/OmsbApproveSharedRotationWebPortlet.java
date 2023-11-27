package gov.omsb.approve.shared.rotation.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.approve.shared.rotation.web.constants.OmsbApproveSharedRotationWebPortletKeys;
import gov.omsb.approve.shared.rotation.web.portlet.model.SharedRotationRequestDTO;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.SharedRotationRequestDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.SharedRotationRequestDetailsLocalService;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbApproveSharedRotationWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="
				+ OmsbApproveSharedRotationWebPortletKeys.SHARED_ROTATION_APPROVAL_JSP,
		"javax.portlet.name=" + OmsbApproveSharedRotationWebPortletKeys.OMSBAPPROVESHAREDROTATIONWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbApproveSharedRotationWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		_logger.debug("render Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<SharedRotationRequestDTO> sharedRotationsList = new ArrayList<>();

		boolean showModal = ParamUtil.getBoolean(renderRequest, OmsbApproveSharedRotationWebPortletKeys.SHOW_MODAL);
		long sharedRotationRequestId = ParamUtil.getLong(renderRequest,
				OmsbApproveSharedRotationWebPortletKeys.SHARED_ROTATION_ID, 0);
		boolean isShowModel = Boolean.FALSE;

		List<SharedRotationRequestDetails> sharedRotationRequestDetails = sharedRotationRequestDetailsLocalService
				.getSharedRotationRequestDetailsByApproverId(themeDisplay.getUserId());

		for (SharedRotationRequestDetails sharedRotationRequestDetail : sharedRotationRequestDetails) {
			try {
				ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService
						.getProgramDurationDetails(sharedRotationRequestDetail.getProgramDurationId());
				ProgramMaster programMaster = programMasterLocalService
						.getProgramMaster(programDurationDetails.getProgramId());
				RotationMaster rotationMaster = rotationMasterLocalService
						.getRotationMaster(sharedRotationRequestDetail.getRotationId());
				User user = userLocalService.getUser(Long.valueOf(sharedRotationRequestDetail.getRequestRaisedBy()));
				sharedRotationsList.add(setSharedRotationRequestDTO(sharedRotationRequestDetail, programDurationDetails,
						programMaster, rotationMaster, user, themeDisplay.getLocale()));

				String[] requestedIds = sharedRotationRequestDetail.getRequestRaisedTo().split(StringPool.COMMA);
				if (showModal && sharedRotationRequestId != 0
						&& sharedRotationRequestDetail.getSharedRotationRequestDetailsId() == sharedRotationRequestId
						&& Arrays.asList(requestedIds).contains(String.valueOf(themeDisplay.getUserId()))
						&& OmsbApproveSharedRotationWebPortletKeys.STATUS_PENDING
								.equalsIgnoreCase(sharedRotationRequestDetail.getStatus())) {
					SharedRotationRequestDTO modalSharedRotationRequestDTO = setSharedRotationRequestDTO(
							sharedRotationRequestDetail, programDurationDetails, programMaster, rotationMaster, user, themeDisplay.getLocale());
					isShowModel = Boolean.TRUE;
					renderRequest.setAttribute(OmsbApproveSharedRotationWebPortletKeys.SHARED_ROTATION_REQUEST,
							modalSharedRotationRequestDTO);
				}
			} catch (PortalException e) {
				_logger.error(e);
			}
		}
		renderRequest.setAttribute(OmsbApproveSharedRotationWebPortletKeys.SHARED_ROTATIONS_LIST, sharedRotationsList.stream()
				.sorted(Comparator.comparing(SharedRotationRequestDTO::getModifiedDate).reversed())
				.collect(Collectors.toList()));
		renderRequest.setAttribute(OmsbApproveSharedRotationWebPortletKeys.SHOW_MODAL, isShowModel);
		super.render(renderRequest, renderResponse);
		_logger.debug("render Exit ::: ");

	}

	private SharedRotationRequestDTO setSharedRotationRequestDTO(
			SharedRotationRequestDetails sharedRotationRequestDetail, ProgramDurationDetails programDurationDetails,
			ProgramMaster programMaster, RotationMaster rotationMaster, User user, Locale currentLocale) {
		SharedRotationRequestDTO sharedRotationRequestDTO = new SharedRotationRequestDTO();
		sharedRotationRequestDTO
				.setSharedRotationRequestId(sharedRotationRequestDetail.getSharedRotationRequestDetailsId());
		sharedRotationRequestDTO.setProgramStructure(
				programMaster.getProgramName(currentLocale) + StringPool.OPEN_PARENTHESIS
						+ programDurationDetails.getAyApplicableForm() + StringPool.CLOSE_PARENTHESIS);
		sharedRotationRequestDTO.setRotation(rotationMaster.getRotationName(currentLocale));
		sharedRotationRequestDTO.setNoOfTraineesRequested(sharedRotationRequestDetail.getNoOfTraineesRequested());
		sharedRotationRequestDTO.setRequestRaisedBy(user.getFullName());
		sharedRotationRequestDTO.setApprovedTrainee(sharedRotationRequestDetail.getApprovedCount());
		sharedRotationRequestDTO.setRejectedTrainee(sharedRotationRequestDetail.getRejectedCount());
		sharedRotationRequestDTO.setStatus(sharedRotationRequestDetail.getStatus());
		sharedRotationRequestDTO.setModifiedDate(sharedRotationRequestDetail.getModifiedDate());
		
		return sharedRotationRequestDTO;
	}

	@Reference
	private SharedRotationRequestDetailsLocalService sharedRotationRequestDetailsLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbApproveSharedRotationWebPortlet.class);
}
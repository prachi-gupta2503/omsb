package gov.omsb.tms.ecm.web.commands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.ECMembershipRequestListDTO;
import gov.omsb.tms.custom.dto.ProgramDTO;
import gov.omsb.tms.ecm.web.constants.ECMemberRoles;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants;
import gov.omsb.tms.ecm.web.dto.MemberRequestDetail;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.EcMemberRequestRotations;
import gov.omsb.tms.model.EcMemberRequestState;
import gov.omsb.tms.model.EcMemberRequestStatus;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestRotationsLocalServiceUtil;
import gov.omsb.tms.service.EcMemberRequestStateLocalServiceUtil;
import gov.omsb.tms.service.EcMemberRequestStatusLocalService;
import gov.omsb.tms.service.EcMemberRequestStatusLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.TrainingSitesMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)

public class OmsbGetECMembershipRequestMVCRenderCommand implements MVCRenderCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(OmsbGetECMembershipRequestMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("***************** View Render ******************");

		String viewPage = "/jsp/view.jsp";
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();
			
		long potentialEcMemberLrUserid =0;
		List<ECMembershipRequestListDTO> eCMembershipRequestListDTO = null;
		long programId = 0;
		long roleId = 0;
		long statusId =0;
		
		if(isPotentialECMember(userId,themeDisplay)) {
			potentialEcMemberLrUserid = userId;
			viewPage= "/jsp/potential-member-view.jsp";
		
		}else {
			
			List<ProgramMaster> programMasterList = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS,	QueryUtil.ALL_POS);
			List<ProgramDTO> programDTOList = new ArrayList<>();
			for (ProgramMaster programMaster : programMasterList) {
				ProgramDTO programDTO = setProgramDTOobj(themeDisplay, programMaster);
				programDTOList.add(programDTO);
			}	
			renderRequest.setAttribute(OmsbEcMembershipConstants.PROGRAM_MASTER_LIST, programDTOList);
			
			List<EcMemberRequestStatus> ecMemberRequestStatusList = ecMemberRequestStatusLocalService
					.getEcMemberRequestStatuses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
			renderRequest.setAttribute(OmsbEcMembershipConstants.EC_MEMEBER_REQUEST_STATUS_LIST, ecMemberRequestStatusList);
			
			List<Role> ecMemberRoles = membershipUtil.getECMemberRoles(themeDisplay.getScopeGroupId());
			
			renderRequest.setAttribute(OmsbEcMembershipConstants.ROLE_LIST, ecMemberRoles);
			
			Boolean requester = isRequester(themeDisplay.getUser());
			if (requester) {
				renderRequest.setAttribute(OmsbEcMembershipConstants.REQUESTER, requester);
			}
			
			programId = ParamUtil.getLong(renderRequest, OmsbEcMembershipConstants.PROGRAM_ID);
			roleId = ParamUtil.getLong(renderRequest, OmsbEcMembershipConstants.ROLE_ID);
			statusId = ParamUtil.getLong(renderRequest, OmsbEcMembershipConstants.STATUS_ID);
			String isSearch = ParamUtil.getString(renderRequest, "isSearch","");
			LOGGER.info("programId - " + programId + "roleID - " + roleId + "statusID - " + statusId);

			PortletSession session = renderRequest.getPortletSession();
			if(isSearch.isBlank() && programId <=0 && roleId <=0 && statusId<=0) {
				if(session.getAttribute(OmsbEcMembershipConstants.PROGRAM_ID) !=null) {
					programId = (long) session.getAttribute(OmsbEcMembershipConstants.PROGRAM_ID);
				}
				if(session.getAttribute(OmsbEcMembershipConstants.ROLE_ID) !=null) {
					roleId = (long) session.getAttribute(OmsbEcMembershipConstants.ROLE_ID);
				}
				if(session.getAttribute(OmsbEcMembershipConstants.STATUS_ID) !=null) {
					statusId = (long) session.getAttribute(OmsbEcMembershipConstants.STATUS_ID);
				}
			}
			
			session.setAttribute(OmsbEcMembershipConstants.PROGRAM_ID, programId);
			session.setAttribute(OmsbEcMembershipConstants.ROLE_ID, roleId);
			session.setAttribute(OmsbEcMembershipConstants.STATUS_ID, statusId);
			
			
			renderRequest.setAttribute(OmsbEcMembershipConstants.PROGRAM_ID, programId);
			renderRequest.setAttribute(OmsbEcMembershipConstants.ROLE_ID, roleId);
			renderRequest.setAttribute(OmsbEcMembershipConstants.STATUS_ID, statusId);
		}
		
		eCMembershipRequestListDTO = ecMemberRequestLocalService.getECMembershipRequestData(programId, roleId,
				statusId, potentialEcMemberLrUserid, themeDisplay.getLocale().toString());

		//LOGGER.info(eCMembershipRequestListDTO);
		List<MemberRequestDetail> listOfECMember = getRequestList(eCMembershipRequestListDTO, themeDisplay,renderRequest);
		
		renderRequest.setAttribute(OmsbEcMembershipConstants.EC_MEMEBERSHIP_REQUEST_DATA_LIST, listOfECMember);
		
		return viewPage;
	}
	
	

	private List<MemberRequestDetail> getRequestList(List<ECMembershipRequestListDTO> ecMembershipRequestList,
			ThemeDisplay themeDisplay, RenderRequest renderRequest ) {
		List<MemberRequestDetail> listOfECMember = new ArrayList<MemberRequestDetail>();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		ecMembershipRequestList.forEach(data -> {

			MemberRequestDetail memberRequestDetail = MembershipUtil.getMemberRequestDetail(httpRequest, themeDisplay, data);

			listOfECMember.add(memberRequestDetail);

		});
		return listOfECMember;
	}

	public static Boolean isRequester(User user) {
		boolean isRequester = false;
		List<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			if (ECMemberRoles.PROGRAM_ADMIN.equalsIgnoreCase(role.getName())
					|| ECMemberRoles.PROGRAM_DIRECTOR.equalsIgnoreCase(role.getName())
					|| ECMemberRoles.PROGRAM_CHAIRMAN.equalsIgnoreCase(role.getName())
					|| "Program Administrator".equalsIgnoreCase(role.getName())) {
				isRequester = true;
				break;
			}
		}
		return isRequester;
	}
	private List<MemberRequestDetail> getPotentialECMemberRequestList(
			List<EcMemberRequest> ecMemberRequestList, long userId, String languageCode) {
		LOGGER.info("Inside getPotentialECMemberRequestList");
		List<MemberRequestDetail> listOfECMember = new ArrayList<MemberRequestDetail>();
		User user=null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (EcMemberRequest ecMemberRequest : ecMemberRequestList) {
			LOGGER.info("for start");
			MemberRequestDetail memberRequestDetail = new MemberRequestDetail();
			try {
				
				ProgramMaster programMaster = ProgramMasterLocalServiceUtil
						.getProgramMaster(ecMemberRequest.getProgramId());
				List<EcMemberRequestRotations> ecMemberRequestRotations = EcMemberRequestRotationsLocalServiceUtil
						.findByEcMemberRequestId(ecMemberRequest.getEcMemberRequestId());
				TrainingSitesMaster trainingSitesMaster = TrainingSitesMasterLocalServiceUtil
						.getTrainingSitesMaster(ecMemberRequestRotations.get(0).getTrainingSiteId());
				List<EcMemberRequestState> findByEcMemberRequestId = EcMemberRequestStateLocalServiceUtil
						.findByEcMemberRequestId(ecMemberRequest.getEcMemberRequestId());
				EcMemberRequestState ecMemberRequestState = EcMemberRequestStateLocalServiceUtil
						.findByEcMemberRequestId(ecMemberRequest.getEcMemberRequestId()).get(0);
				EcMemberRequestStatus ecMemberRequestStatus = EcMemberRequestStatusLocalServiceUtil
						.getEcMemberRequestStatus(ecMemberRequestState.getEcMemberRequestStatusId());
				Role role = RoleLocalServiceUtil.getRole(ecMemberRequest.getPotentialEcMemberRoleId());
				memberRequestDetail.setEcMemberRequestId(ecMemberRequest.getEcMemberRequestId());
				memberRequestDetail.setProgram(OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
						OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
				memberRequestDetail.setPotentialECMember(user.getFullName());
				memberRequestDetail.setRole(role.getName());
				memberRequestDetail.setStatus(ecMemberRequestStatus.getNameEn());
				listOfECMember.add(memberRequestDetail);
			LOGGER.info("for end");
			} catch (PortalException e) {
			LOGGER.error(e.getMessage());			
			}
		}

		return listOfECMember;
	}
	
	
	public boolean isPotentialECMember(long userId,ThemeDisplay themeDisplay) {
		List<Role> roles = themeDisplay.getUser().getRoles();
		for (Role role : roles) {
			if (role.getName().equals(ECMemberRoles.POTENTIAL_EC_MEMBER)) {
				LOGGER.info("Inside Role Check");
				return true;
			}

		}
		return false;
		
	}
	
	private ProgramDTO setProgramDTOobj(ThemeDisplay themeDisplay, ProgramMaster programMaster) {
		ProgramDTO programDTO = new ProgramDTO();
		programDTO.setProgramMasterId(programMaster.getProgramMasterId());
		programDTO.setProgramCode(programMaster.getProgramCode(themeDisplay.getLocale()));
		programDTO.setProgramName(programMaster.getProgramName(themeDisplay.getLocale()));
		return programDTO;
	}

	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private EcMemberRequestStatusLocalService ecMemberRequestStatusLocalService;

	@Reference
	private MembershipUtil membershipUtil;

}

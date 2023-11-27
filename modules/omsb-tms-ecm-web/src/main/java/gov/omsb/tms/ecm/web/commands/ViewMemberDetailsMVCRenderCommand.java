package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.*;

import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.dto.ViewEcMemberRequestDTO;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.BankDetailsLocalService;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestRotationsLocalService;
import gov.omsb.tms.service.EcMemberRequestStateLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

/**
 * @author Jinal Patel
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name="+ "/view/member-details" }, service = MVCRenderCommand.class)
public class ViewMemberDetailsMVCRenderCommand implements MVCRenderCommand {

	public static final String LR_USER_ID = "lrUserId";

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("view member details render");
		renderRequest.setAttribute(REDIRECT_URL, PortalUtil.getCurrentURL(renderRequest));

		ViewEcMemberRequestDTO viewEcMemberRequestDTO = new ViewEcMemberRequestDTO();

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String ecMembershipRequestIdStr = ParamUtil.getString(renderRequest, EC_MEMBERSHIP_REQUEST_ID);

		if (Validator.isNotNull(ecMembershipRequestIdStr) && !ecMembershipRequestIdStr.isBlank()) {
			long ecMembershipRequestId = Long.valueOf(ecMembershipRequestIdStr);
			try {
				EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMembershipRequestId);
				membershipUtil.setCoveringLetterData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);

				membershipUtil.setCvData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);

				String qararURL =  membershipUtil.getQararURL(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				viewEcMemberRequestDTO.setQarar(qararURL);

				Role role = membershipUtil.setRoleAndProgramData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);

				membershipUtil.setRotationData(viewEcMemberRequestDTO, themeDisplay, ecMembershipRequestId);

				membershipUtil.setBankDetails(viewEcMemberRequestDTO, themeDisplay, ecMembershipRequestId);

				membershipUtil.setPersonRelatedData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);

				membershipUtil.setPassportDocData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				
				membershipUtil.setNationalIdDocData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				
				membershipUtil.setQualificationDocData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				
				membershipUtil.setEducationDetailsData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
				
				membershipUtil.setCommentsSectionData(viewEcMemberRequestDTO, ecMembershipRequestId, role,themeDisplay.getUser(),ecMemberRequest);
			} catch (PortalException | UnsupportedEncodingException e) {
				log.error("unable to fetch ec member request details");
			}
		}
		renderRequest.setAttribute("memberDetails", viewEcMemberRequestDTO);
		return "/jsp/viewMemberDetails.jsp";
	}
	

	

	

	private String generateScopeListURL(String personRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + personRequestsUrl.replace("{scope-id}", String.valueOf(siteId));
	}
	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

	@Reference(unbind = "-")
	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;

	@Reference(unbind = "-")
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference(unbind = "-")
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference(unbind = "-")
	private EcMemberRequestRotationsLocalService ecMemberRequestRotationsLocalService;

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;

	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;

	@Reference(unbind = "-")
	private BankDetailsLocalService bankDetailsLocalService;

	@Reference(unbind = "-")
	private EcMemberRequestLocalService ecMemberRequestLocalService;
	
	@Reference(unbind = "-")
	private EcMemberRequestStateLocalService ecMemberRequestStateLocalService;

	private static final Log log = LogFactoryUtil.getLog(ViewMemberDetailsMVCRenderCommand.class);
}

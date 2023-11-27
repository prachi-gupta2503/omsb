package gov.omsb.faculty.membership.web.commands;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.common.dto.DocumentInfoItem;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.OmsbEcMembershipConstants;
import gov.omsb.faculty.membership.web.dto.WorkflowTaskDetail;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.model.BankDetails;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.service.FacultyRequestLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"mvc.command.name=/abcdf" }, service = MVCRenderCommand.class)
public class AddMembershipDetailsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info(" render invoked :: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String objectName = OmsbEcMembershipConstants.CUSTOM_COUNTRY_OBJECT_TABLE_NAME;
		long facultyRequestId = ParamUtil.getLong(renderRequest, "facultyRequestId");
		log.info("AddMembershipDetailsMVCRenderCommand  facultyRequestId--" + facultyRequestId);
		renderRequest.setAttribute("facultyRequestId", facultyRequestId);
		long lruserId = themeDisplay.getUserId();
		FacultyRequest facultyRequest = null;
		try {
			facultyRequest = FacultyRequestLocalServiceUtil.getFacultyRequest(facultyRequestId);
			// renderRequest.setAttribute("ecMemberRequestId",
			// ecMemberRequest.ecMemberRequestId);
		} catch (PortalException e1) {
			log.error(e1);
			throw new PortletException(e1);
		}
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		WorkflowTaskDetail workflowTaskDetail = MembershipUtil.getMemberRequestWorkflowDetail(httpRequest, themeDisplay,
				facultyRequest);

		renderRequest.setAttribute("workflowTaskDetail", workflowTaskDetail);
		/*
		 * List<ListTypeEntry> qualificationList =
		 * getPickListEntries(LRPicklistConstants.QUALIFICATION,
		 * themeDisplay.getCompanyId()); renderRequest.setAttribute("qualificationList",
		 * qualificationList); List<Country> countries =
		 * CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		 * renderRequest.setAttribute("countryList", countries); ViewEcMemberRequestDTO
		 * viewEcMemberRequestDTO = new ViewEcMemberRequestDTO(); Role role =
		 * membershipUtil.setRoleAndProgramData(viewEcMemberRequestDTO, themeDisplay,
		 * ecMemberRequest);
		 * membershipUtil.setCommentsSectionData(viewEcMemberRequestDTO,
		 * ecMemberRequestId, role, themeDisplay.getUser(), ecMemberRequest);
		 * renderRequest.setAttribute("memberDetails", viewEcMemberRequestDTO);
		 * 
		 * if (ecMemberRequest.getPassportCopyId() > 0 &&
		 * ecMemberRequest.getNationalIdCopyId() > 0) { try { DocumentInfoItem
		 * documentInfoPassport = fetchDocumentInfoByDocumentInfoId(themeDisplay,
		 * ecMemberRequest.getPassportCopyId()); log.info("documentInfoPassport" +
		 * documentInfoPassport.getdFFileName());
		 * renderRequest.setAttribute("documentInfoPassport", documentInfoPassport);
		 * DocumentInfoItem documentInfoNational =
		 * fetchDocumentInfoByDocumentInfoId(themeDisplay,
		 * ecMemberRequest.getNationalIdCopyId());
		 * renderRequest.setAttribute("documentInfonational", documentInfoNational);
		 * log.info("documentInfoNational" + documentInfoNational.getdFFileName());
		 * BankDetails bankDetails =
		 * bankDetailsLocalService.findByEcMemberRequestId(ecMemberRequestId);
		 * renderRequest.setAttribute("bankDetails", bankDetails); } catch
		 * (UnsupportedEncodingException e) {
		 * log.error("Error in fetching documment info id"); } catch (Exception ex) {
		 * log.error("Bank details are not found" + ex.getMessage()); } return
		 * OmsbEcMembershipConstants.EDIT_MEMBERSHIP_DETAILS_URL;
		 * 
		 * } else { return OmsbEcMembershipConstants.ADD_MEMBERSHIP_DETAILS_URL;
		 * 
		 * }
		 */
		return OmsbEcMembershipConstants.ADD_MEMBERSHIP_DETAILS_URL;
	}

	private static final Log log = LogFactoryUtil.getLog(AddMembershipDetailsMVCRenderCommand.class);

}

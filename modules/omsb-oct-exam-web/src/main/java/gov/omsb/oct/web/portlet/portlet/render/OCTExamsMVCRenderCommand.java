package gov.omsb.oct.web.portlet.portlet.render;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppeal;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDetails;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=/", }, service = MVCRenderCommand.class)
public class OCTExamsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest requestInsideThePortletReq = PortalUtil.getHttpServletRequest(renderRequest);
		String id = PortalUtil.getOriginalServletRequest(requestInsideThePortletReq).getParameter("eId");
		List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
				.collect(Collectors.toList());
		long companyId = themeDisplay.getCompanyId();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		String portalUrl = themeDisplay.getPortalURL();
		Locale locale = themeDisplay.getLocale();

		/* OC Exam title pickList dropdown */
		List<ListTypeEntry> examTitleList = omsbCommonApi
				.getListTypeEntriesByERC(LRPicklistConstants.PL_OC_EXAM_TITLE_ERC, companyId);
		renderRequest.setAttribute("examTitleList", examTitleList);
		
		try {
			renderRequest.setAttribute("id", Validator.isNotNull(id) ? id : StringPool.BLANK);
			List<OCTExamDetails> ocExamDetailsList = octExamUtil.getOCTExamDetailsList(companyId, scopeGroupId,
					portalUrl, locale);
			renderRequest.setAttribute("octExamDetailsList", ocExamDetailsList);

		} catch (PortalException | JsonProcessingException e) {
			logger.error("Error while getting Exam List : " + e.getMessage());
		}
		if (roleNames.contains(RoleNameConstants.OCT_ADMIN)) {
			return OmsbOctExamWebPortletKeys.VIEW_OCT_EXAMS_JSP;
		} else if (roleNames.contains(RoleNameConstants.EXAM_APPLICANT)) {
			
			List<ListTypeEntry> examTitles = omsbCommonApi.getListTypeEntriesByERC(
					LRPicklistConstants.PL_OC_EXAM_TITLE_ERC, PortalUtil.getDefaultCompanyId());
			List<OCTExamSchedule> octExamSchedules = octExamUtil.getOCTExamScheduleList(themeDisplay);
			if (Validator.isNotNull(octExamSchedules) && !octExamSchedules.isEmpty()) {
				for (OCTExamSchedule octExamSchedule : octExamSchedules) {
					//Fetch Payment Details
					OCTExamPayment octExamPayment=	octExamUtil.getPaymentByUserIdAndScheduleId(themeDisplay, themeDisplay.getUserId(), octExamSchedule.getId());
					if(Validator.isNotNull(octExamPayment)) {
						logger.info("OCExam Payment Id in render Method :: OCTExamsMVCRenderCommand Class :: "+octExamPayment.getId());
						try {
							ObjectEntry entry=ObjectEntryLocalServiceUtil.getObjectEntry(octExamPayment.getId());
							if(Validator.isNotNull(entry)) {
								octExamSchedule.setDateOfPayment(omsbCommonApi.convertDateToDDMMYYYYString(entry.getCreateDate()));
							}
							
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					//octExamPayment.getPaymentStatus();
					
					long examDefinitionId = octExamSchedule.getOctExamDefinitionId();
					OCTExamDefinition octExamDefinition = octExamUtil
							.getOCTExamDefinitionByDefinitionId(examDefinitionId, portalUrl);
					if (Validator.isNotNull(octExamDefinition)) {
						int cutOff = octExamDefinition.getCutOffWindow();
						// apply operation on cut off and the send the flag via exam schedule.
						boolean isRegistrationAllowed = octExamUtil.isRegistrationAllowed(cutOff,
								octExamSchedule.getExamDate(), octExamSchedule.getExamSlot());
						octExamSchedule.setRegistrationAllowed(isRegistrationAllowed);
					}
				}
			}

			renderRequest.setAttribute("examSchedules", octExamSchedules);
			renderRequest.setAttribute("octApplicant", true);
			renderRequest.setAttribute("examTitles", examTitles);

			return OmsbOctExamWebPortletKeys.APPLICANT_EXAM_LIST_JSP;
		} else if (roleNames.contains(RoleNameConstants.OCT_APPEAL_BODY)) {
			List<OCTExamAppeal> appealList = octExamAppealUtil.getAllAppealList(themeDisplay);
			renderRequest.setAttribute("appealList", appealList);
			return OmsbOctExamWebPortletKeys.APPLICANT_REQUESTS_JSP;
		}

		return OmsbOctExamWebPortletKeys.APPLICANT_EXAM_LIST_JSP;
		// return "/jsps/registration/test.jsp";

	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;
	@Reference
	private OCTExamAppealUtil octExamAppealUtil;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(OCTExamsMVCRenderCommand.class);

}

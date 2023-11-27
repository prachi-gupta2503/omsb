package gov.omsb.oct.web.portlet.portlet.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDetails;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.web.portlet.portlet.render.OCTExamsMVCRenderCommand;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="
				+ MVCCommandNames.ADMIN_SEARCH_OCT_EXAMS_DETAILS }, service = MVCResourceCommand.class)
public class SearchOCTExamsListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
				.collect(Collectors.toList());

		// TODO: Need to change VEHPC Admin to OC Admin
		if (roleNames.contains(RoleNameConstants.OCT_ADMIN)) {

			String examTitleIdString = ParamUtil.getString(resourceRequest, "examTitleId");
			long examTitleId = 0L;
			if (Validator.isNotNull(examTitleIdString)) {
				examTitleId = Long.parseLong(examTitleIdString);
			}

			List<OCTExamDetails> octExamDetailsList = searchOCTExamList(examTitleId, themeDisplay);
			resourceRequest.setAttribute("octExamsList", octExamDetailsList);

			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher(OmsbOctExamWebPortletKeys.ADMIN_SEARCHED_OCT_EXAMS_LIST_JSP);
			try {
				dispatcher.include(resourceRequest, resourceResponse);
			} catch (PortletException | IOException e) {
				logger.info(e.getMessage());
			}
		}

		return true;
	}

	/**
	 * Search OC Exams with and without filter
	 * 
	 * @param examTitleId
	 * @param themeDisplay
	 * @return
	 */
	private List<OCTExamDetails> searchOCTExamList(long examTitleId, ThemeDisplay themeDisplay) {
		List<OCTExamDetails> octExamDetailsList = Collections.emptyList();

		long companyId = themeDisplay.getCompanyId();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		String portalUrl = themeDisplay.getPortalURL();
		Locale locale = themeDisplay.getLocale();

		try {
			if (Validator.isNotNull(examTitleId)) {
				octExamDetailsList = octExamUtil.getOCTExamDetailsListByExamTitle(companyId, scopeGroupId, portalUrl,
						examTitleId, locale);
			} else {
				octExamDetailsList = octExamUtil.getOCTExamDetailsList(companyId, scopeGroupId, portalUrl, locale);
			}

		} catch (JsonProcessingException | PortalException e) {
			logger.error(e.getMessage());
		}

		return octExamDetailsList;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	private static final Log logger = LogFactoryUtil.getLog(OCTExamsMVCRenderCommand.class);
}

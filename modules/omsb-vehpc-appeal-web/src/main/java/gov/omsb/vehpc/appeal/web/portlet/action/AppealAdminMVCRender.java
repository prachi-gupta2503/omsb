package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealItems;
import gov.omsb.vehpc.appeal.util.HeaderUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
		"mvc.command.name=" + AppealConstants.APPEAL_ADMIN_LIST }, service = MVCRenderCommand.class)
public class AppealAdminMVCRender implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("APPEAL_ADMIN_LIST Render()>>>Invoked>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
		String response = oMSBHttpConnector.executeGet(themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL
				+ "scopes/" + themeDisplay.getScopeGroupId(), "", headerUtil.getHeaders());
		logger.info("this is the response =--=-==================================" + response);
		EquivalencyAppealItems appealItems = CustomObjectMapperUtil.readValue(response, EquivalencyAppealItems.class);
		logger.info("descisionItem size ??" + appealItems.getItems().size());
		List<EquivalencyAppeal> appeals = new ArrayList<>();
		for (EquivalencyAppeal appeal : appealItems.getItems()) {
			EquivalencyAppeal equivalencyappeal = new EquivalencyAppeal();
			equivalencyappeal.setDateCreated(omsbCommonApi.convertDate(appeal.getDateCreated()));
			equivalencyappeal.setDocumentInfoId(appeal.getDocumentInfoId());
			equivalencyappeal.setId(appeal.getId());
			User AppellantUserId = userLocalService.fetchUser(appeal.getAppellantUserId());
			if (Validator.isNotNull(AppellantUserId)) {
				equivalencyappeal.setAppellantName(AppellantUserId.getFullName());
			}
			equivalencyappeal.setAppellantUserId(appeal.getAppellantUserId());
			equivalencyappeal.setEqLevelId(appeal.getEqLevelId());

			appeals.add(equivalencyappeal);
		}
		renderRequest.setAttribute("equivalencyAppealList", appeals);

		ListTypeDefinition definition = null;
		try {

			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_Equivalency_Level", themeDisplay.getCompanyId());
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		
		
		List<ListTypeEntry> equivalencyLevelList = new ArrayList<>();
		equivalencyLevelList = ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId());
		List<Role> roles = themeDisplay.getUser().getRoles();
		List<String> roleNames = roles.stream().map(Role::getName).collect(Collectors.toList());
		boolean hasVehpcCommitteeRole = hasUserRole(themeDisplay, themeDisplay.getUserId(),RoleNameConstants.VEHPC_COMMITTEE);
		boolean hasExecutePresidentRole = hasUserRole(themeDisplay, themeDisplay.getUserId(),RoleNameConstants.EXECUTIVE_PRESIDENT);
		boolean hasVehpcCAdminRole = hasUserRole(themeDisplay, themeDisplay.getUserId(), RoleNameConstants.VEHPC_ADMIN);
		renderRequest.setAttribute("hasVehpcCommitteeRole", hasVehpcCommitteeRole);
		renderRequest.setAttribute("hasExecutePresidentRole", hasExecutePresidentRole);
		renderRequest.setAttribute("hasVehpcCAdminRole", hasVehpcCAdminRole);
		renderRequest.setAttribute("equivalencyLevelList", equivalencyLevelList);
		return AppealConstants.APPEAL_ADMIN_LIST_JSP;
	}

	private boolean hasUserRole(ThemeDisplay themeDisplay, long userId, String roleName) {
		Role role = roleLocalService.fetchRole(themeDisplay.getCompanyId(), roleName);
		if (Validator.isNotNull(role)) {
			return roleLocalService.hasUserRole(userId, role.getRoleId());
		}
		return false;

	}
	
	@Reference(unbind = "-")
	private UserLocalService userLocalService;
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;
	
	@Reference(unbind = "-")
	private HeaderUtil headerUtil;

	private final Log logger = LogFactoryUtil.getLog(AppealAdminMVCRender.class);

}

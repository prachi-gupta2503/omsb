package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.vehpc.appeal.dto.web.SearchDto;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, 
		property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
					"mvc.command.name=/" }, 
					service = MVCRenderCommand.class)
public class AppealDefaultMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long startTime = System.currentTimeMillis();
		logger.info("start time ??   " + System.currentTimeMillis());
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Role> roles = themeDisplay.getUser().getRoles();
		List<String> roleNames = roles.stream().map(Role::getName).collect(Collectors.toList());
		logger.info("roles name     " + roleNames);
		boolean hasEmployeeRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(), RoleNameConstants.EMPLOYEE);
		boolean hasEmployerRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(), RoleNameConstants.EMPLOYER);
		boolean hasVehpcCommitteeRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),RoleNameConstants.VEHPC_COMMITTEE);
		boolean hasExecutePresidentRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),RoleNameConstants.EXECUTIVE_PRESIDENT);
		boolean hasVehpcCAdminRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(), RoleNameConstants.VEHPC_ADMIN);
		renderRequest.setAttribute("roleNames", roleNames);
		renderRequest.setAttribute("hasEmployeeRole", hasEmployeeRole);
		renderRequest.setAttribute("hasEmployerRole", hasEmployerRole);
		renderRequest.setAttribute("hasVehpcCommitteeRole", hasVehpcCommitteeRole);
		renderRequest.setAttribute("hasExecutePresidentRole", hasExecutePresidentRole);
		renderRequest.setAttribute("hasVehpcCAdminRole", hasVehpcCAdminRole);
		if(hasEmployeeRole || hasEmployerRole) {
			 List<SearchDto> searchDtos =appealUtil.getAllDecisionLevelData(themeDisplay, hasEmployerRole);
			 logger.info("list size of searchDtos ?? " + searchDtos.size());
			 searchDtos.sort(Comparator.comparing(SearchDto::getEquivalencyDecisionId).reversed());
			renderRequest.setAttribute("searchDtos", searchDtos);
			}
		if(hasVehpcCommitteeRole || hasExecutePresidentRole || hasVehpcCAdminRole) {
			Set<SearchDto> 	adminSearchDtos = appealUtil.getAllData(themeDisplay);
			List<SearchDto> searchList = new ArrayList<>(adminSearchDtos);
			searchList.sort(Comparator.comparing(SearchDto::getId).reversed());
			renderRequest.setAttribute("adminSearchDtos", searchList);
		}
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					AppealConstants.PL_EQ_LEVEL, themeDisplay.getCompanyId());
			List<ListTypeEntry> equivalencyLevelList = ListTypeEntryLocalServiceUtil
					.getListTypeEntries(definition.getListTypeDefinitionId());
			renderRequest.setAttribute("equivalencyLevelList", equivalencyLevelList);
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		
		renderRequest.setAttribute("appealStatusColur", appealUtil.getColorMap() );
		logger.info("total time taken ?? " + (System.currentTimeMillis() - startTime));
		
		return null;
	}

	

	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;
	
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	private static final Log logger = LogFactoryUtil.getLog(AppealDefaultMVCRenderCommand.class);

}

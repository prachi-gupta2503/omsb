package gov.omsb.vehpc.verification.web.portlet.action;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.vehpc.verification.util.VerificationUtil;
import gov.omsb.verification.dto.Person;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;
import omsb.vehpc.verification.web.constants.VerificationJSPPath;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class VerificationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		_log.info("render()>>>>method started>>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), RoleNameConstants.VEHPC_ADMIN);
			if (Validator.isNotNull(role)) {
				renderRequest.setAttribute("vehpcAdmin", UserLocalServiceUtil.hasRoleUser(role.getRoleId(), themeDisplay.getUserId()));
			}
			/* CaseStatus pickList dropdown */
			ListTypeDefinition caseStatus = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode("PL_CASE_STATUS_ERC", themeDisplay.getCompanyId());
			List<ListTypeEntry> caseStatusList = ListTypeEntryLocalServiceUtil.getListTypeEntries(caseStatus.getListTypeDefinitionId());
			/* fetch all verification */
			List<Person> persons= verificationUtil.getVerificationDetails(renderRequest,renderResponse);
			_log.info("persons::::::::VerificationMVCRenderCommand::::::::"+persons);
			renderRequest.setAttribute("persons", persons);
			renderRequest.setAttribute("statusCount", verificationUtil.getCaseStatusCount(String.valueOf(themeDisplay.getScopeGroupId())));
			renderRequest.setAttribute("caseStatusList", caseStatusList);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		_log.info("render()>>>>method ended>>>>");
		return VerificationJSPPath.VIEW_VERIFICATION;
	}
	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "_") 
	private VerificationUtil verificationUtil;
	
	private static final Log _log = LogFactoryUtil.getLog(VerificationMVCRenderCommand.class);
}
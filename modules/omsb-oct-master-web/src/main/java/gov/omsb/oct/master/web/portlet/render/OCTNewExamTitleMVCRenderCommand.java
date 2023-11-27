package gov.omsb.oct.master.web.portlet.render;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;
import gov.omsb.oct.master.web.portlet.dto.CodeItem;
import gov.omsb.oct.master.web.portlet.dto.OCTExamTitleCodeMapping;
import gov.omsb.oct.master.web.portlet.dto.OCTNewExamTitle;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_NEW_EXAM_TITLE_RENDER, }, service = MVCRenderCommand.class)

public class OCTNewExamTitleMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<OCTNewExamTitle> listOctExamTitle = new ArrayList<OCTNewExamTitle>();
		ListTypeDefinition listTypeDefinition;

		long titleId = ParamUtil.getLong(renderRequest, "titleId");
		try {
			if(Validator.isNotNull(titleId) && titleId > 0) {
				ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(titleId);
				if(Validator.isNotNull(listEntry)) {
					logger.info("titleId  ===== " + titleId);
					logger.info(listEntry.toString());
					logger.info(listEntry.getName());
					renderRequest.setAttribute("titleId", titleId);
					renderRequest.setAttribute("titleNameMap", listEntry.getName());
					
					OCTExamTitleCodeMapping codeMapping= getexamCodeByTitleId(themeDisplay, titleId);
					if(Validator.isNotNull(codeMapping)) {
						renderRequest.setAttribute("code", codeMapping.getCode());
						renderRequest.setAttribute("id", codeMapping.getId());
					}
				}
			}
			listTypeDefinition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(OmsbOctMasterWebPortletKeys.EXAM_TITLE_PL_ERC, themeDisplay.getCompanyId());
			if (Validator.isNotNull(listTypeDefinition)) {
				List<ListTypeEntry> listEntries = ListTypeEntryLocalServiceUtil
						.getListTypeEntries(listTypeDefinition.getListTypeDefinitionId(), -1, -1);

				List<String> languageCodes = new ArrayList<>();
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);

				for (ListTypeEntry entry : listEntries) {
					String key = entry.getKey();
					String en_Name = "", ar_Name = "";
					Map<Locale, String> nameMap = entry.getNameMap();
					Locale en_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
					en_Name = nameMap.get(en_LanguageLocale);

					Locale ar_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
					ar_Name = nameMap.get(ar_LanguageLocale);

					OCTExamTitleCodeMapping codeMapping= getexamCodeByTitleId(themeDisplay, entry.getListTypeEntryId());
					
					OCTNewExamTitle octNewExamTitle = new OCTNewExamTitle();
					octNewExamTitle.setKey(key);
					octNewExamTitle.setNameArabic(ar_Name);
					octNewExamTitle.setNameEnglish(en_Name);
					octNewExamTitle.setExternalReferenceCode(entry.getExternalReferenceCode());
					octNewExamTitle.setId(entry.getListTypeEntryId());
					if(Validator.isNotNull(codeMapping)) {
						octNewExamTitle.setExamCode(codeMapping.getCode());
					}
					listOctExamTitle.add(octNewExamTitle);
				}

			}
			renderRequest.setAttribute("listOctExamTitle", listOctExamTitle);

		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return OmsbOctMasterWebPortletKeys.OCT_EXAM_TITLE_JSP;
	}
	
	private OCTExamTitleCodeMapping getexamCodeByTitleId(ThemeDisplay themeDisplay, long titleId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_TITLE_MAPPING_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=picklistId"
				+ URLEncoder.encode(" eq " + titleId, StandardCharsets.UTF_8) + "&sort=id:desc&pageSize=0";

		logger.info("url ==================== " + url);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("response ==================== " + response);
		OCTExamTitleCodeMapping exam1 = null;
		CodeItem examList = CustomObjectMapperUtil.readValue(response, CodeItem.class);
		for (OCTExamTitleCodeMapping exam : examList.getItems()) {
			exam1 = exam;
			logger.info(exam1.getPicklistId());
			logger.info(exam1.getCode());	
			logger.info(exam1.getId());
		}
		return exam1;
	}

	private long getGroupId() {
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			logger.info("Guest Group Id is ?? " + group.getGroupId());
			return group.getGroupId();
		}
		return 0;
	}
	
	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	
	private static final Log logger = LogFactoryUtil.getLog(OCTNewExamTitleMVCRenderCommand.class);

}
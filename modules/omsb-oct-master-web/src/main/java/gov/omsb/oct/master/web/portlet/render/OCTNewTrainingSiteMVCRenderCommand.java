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
import gov.omsb.oct.master.web.portlet.dto.OCTNewTrainingSite;
import gov.omsb.oct.master.web.portlet.dto.OCTNewTrainingSiteItems;
import gov.omsb.oct.master.web.portlet.dto.OCTrainingSiteSeatsMapping;
import gov.omsb.oct.master.web.portlet.dto.SeatsItem;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_NEW_TRAINING_SITE_RENDER, }, service = MVCRenderCommand.class)

public class OCTNewTrainingSiteMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<OCTNewTrainingSite> listOctTrainingSite = new ArrayList<OCTNewTrainingSite>();
		long siteId = ParamUtil.getLong(renderRequest, "siteId");
		long trainingSiteId = ParamUtil.getLong(renderRequest, "trainingSiteId");
		ListTypeDefinition listTypeDefinition;
		try {
			if (Validator.isNotNull(siteId) && siteId > 0) {
				ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(siteId);
				if (Validator.isNotNull(listEntry)) {
					renderRequest.setAttribute("siteId", siteId);
					renderRequest.setAttribute("siteNameMap", listEntry.getName());
					OCTrainingSiteSeatsMapping seatsMapping = getTrainingSiteBySiteId(themeDisplay, siteId);
					OCTrainingSiteSeatsMapping newTrainingSite = getStatusByTrainingSite(themeDisplay, siteId);
					if (Validator.isNotNull(seatsMapping)) {
						renderRequest.setAttribute("seats", seatsMapping.getSeats());
						renderRequest.setAttribute("status", newTrainingSite.getStatusId());
						renderRequest.setAttribute("id", seatsMapping.getId());
					}
					
					
				}

				listTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
						OmsbOctMasterWebPortletKeys.TRAINING_SITE_PL_ERC, themeDisplay.getCompanyId());
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
						OCTrainingSiteSeatsMapping seatsMapping = getTrainingSiteBySiteId(themeDisplay,
								entry.getListTypeEntryId());
						OCTNewTrainingSite octNewTrainingSite = new OCTNewTrainingSite();
						octNewTrainingSite.setKey(key);
						octNewTrainingSite.setNameArabic(ar_Name);
						octNewTrainingSite.setNameEnglish(en_Name);
						octNewTrainingSite.setExternalReferenceCode(entry.getExternalReferenceCode());
						octNewTrainingSite.setId(entry.getListTypeEntryId());
						OCTrainingSiteSeatsMapping newTrainingSite = getStatusByTrainingSite(themeDisplay,
								entry.getListTypeEntryId());

						if (Validator.isNotNull(seatsMapping)) {
							octNewTrainingSite.setSeats(seatsMapping.getSeats());
						}
						if (Validator.isNotNull(newTrainingSite)) {
							octNewTrainingSite.setStatusId(newTrainingSite.getStatusId());
						}

						listOctTrainingSite.add(octNewTrainingSite);
					}
				}
				renderRequest.setAttribute("listOctTrainingSite", listOctTrainingSite);

			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return OmsbOctMasterWebPortletKeys.OCT_TRAINING_SITE_JSP;
	}
	
	private OCTrainingSiteSeatsMapping getTrainingSiteBySiteId(ThemeDisplay themeDisplay, long titleId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_TRAINING_SITE_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=picklistId"
				+ URLEncoder.encode(" eq " + titleId, StandardCharsets.UTF_8) + "&sort=id:desc&pageSize=0";
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		OCTrainingSiteSeatsMapping trainingSite = null;
		SeatsItem seatsList = CustomObjectMapperUtil.readValue(response, SeatsItem.class);
			for (OCTrainingSiteSeatsMapping seats : seatsList.getItems()) {
				trainingSite = seats;
			}
		return trainingSite;
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
	
	private OCTrainingSiteSeatsMapping getStatusByTrainingSite(ThemeDisplay themeDisplay, long titleId) {
		String url = themeDisplay.getPortalURL() + MVCCommandNames.OC_TRAINING_SITE_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=picklistId"
				+ URLEncoder.encode(" eq " + titleId, StandardCharsets.UTF_8) + "&sort=id:desc&pageSize=0";
		logger.info("url ==================== " + url);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("response ==================== " + response);
		OCTrainingSiteSeatsMapping trainingSite = null;
		SeatsItem seatsList = CustomObjectMapperUtil.readValue(response, SeatsItem.class);
		for (OCTrainingSiteSeatsMapping seats : seatsList.getItems()) {
			trainingSite = seats;
		}
		return trainingSite;
	}
	

	@Reference(unbind  = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind =  "_")
	private OMSBHttpConnector omsbHttpConnector;
	
	private static final Log logger = LogFactoryUtil.getLog(OCTNewTrainingSiteMVCRenderCommand.class);

}
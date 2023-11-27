package gov.omsb.exam.master.web.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;
import gov.omsb.exam.master.web.portlet.dto.OMSBExamSpeciality;
import gov.omsb.exam.master.web.portlet.dto.OMSBSpecialityMapping;
import gov.omsb.exam.master.web.portlet.dto.SubSpecialityItems;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.GET_SUB_SPECIALITY_DETAILS }, service = MVCResourceCommand.class)

public class GetSubSpecialityDetailMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long specialityId = ParamUtil.getLong(resourceRequest, "speciality");

		List<OMSBExamSpeciality> viewExams = new ArrayList<>();
		viewExams = getListSubSpecialityBySpecialityId(themeDisplay, specialityId);

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		ObjectMapper obj = new ObjectMapper();
		obj.enable(SerializationFeature.INDENT_OUTPUT);
		String jsonList = obj.writeValueAsString(viewExams);
		jsonObj.put("subSpeciality", jsonList);
		PrintWriter printWriter = resourceResponse.getWriter();
		printWriter.print(jsonObj.toString());

	}

	private List<OMSBExamSpeciality> getListSubSpecialityBySpecialityId(ThemeDisplay themeDisplay, long specialityId) {

		logger.info("calling ajax for speciality Mapping ");
		String url = themeDisplay.getPortalURL() + LRObjectURL.SPECIALITY_MAPPING_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=speciality"
				+ URLEncoder.encode(" eq " + specialityId, StandardCharsets.UTF_8) + "&sort=id:desc&pageSize=0";
		
		logger.info("getListSubSpecialityBySpecialityId URL :::::"+url);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());

		SubSpecialityItems examList = CustomObjectMapperUtil.readValue(response, SubSpecialityItems.class);
		ListTypeDefinition listTypeDefinition;
		List<OMSBExamSpeciality> listSubSpeciality = new ArrayList<OMSBExamSpeciality>();

		try {
			if (Validator.isNotNull(examList) && Validator.isNotNull(examList.getItems())
					&& !examList.getItems().isEmpty()) {

				for (OMSBSpecialityMapping exam : examList.getItems()) {
					OMSBSpecialityMapping exam1 = exam;

					if (Validator.isNotNull(exam1) && Validator.isNotNull(exam1.getSubSpeciality())) {
						logger.info("exam1.getSubSpeciality() :::::"+exam1.getSubSpeciality());

						listTypeDefinition = ListTypeDefinitionLocalServiceUtil
								.getListTypeDefinitionByExternalReferenceCode(
										OmsbExamMasterWebPortletKeys.SPECIALITY_MASTER_PL_ERC,
										themeDisplay.getCompanyId());

						if (Validator.isNotNull(listTypeDefinition)) {
							ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil
									.fetchListTypeEntry(exam1.getSubSpeciality());

							if (Validator.isNotNull(listEntry)) {
								Map<Locale, String> nameMap = listEntry.getNameMap();
								if (Validator.isNotNull(nameMap)) {
									String en_Name = StringPool.BLANK, ar_Name = StringPool.BLANK;

									Locale en_LanguageLocale = LocaleUtil
											.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
									en_Name = nameMap.get(en_LanguageLocale);
									logger.info("getListSubSpecialityBySpecialityId en_Name :::::"+en_Name);
									Locale ar_LanguageLocale = LocaleUtil
											.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
									ar_Name = nameMap.get(ar_LanguageLocale);

									OMSBExamSpeciality omsbSubSpeciality = new OMSBExamSpeciality();
									omsbSubSpeciality.setNameArabic(ar_Name);
									omsbSubSpeciality.setNameEnglish(en_Name);
									omsbSubSpeciality.setExternalReferenceCode(listEntry.getExternalReferenceCode());
									omsbSubSpeciality.setId(listEntry.getListTypeEntryId());

									listSubSpeciality.add(omsbSubSpeciality);
								}

							}

						} else {
							logger.info("not found type defintiion");
						}
					} else {
						logger.info("not found sub data");
					}

				}
				return listSubSpeciality;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
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

	private static final Log logger = LogFactoryUtil.getLog(GetSubSpecialityDetailMVCResourceCommand.class);
}

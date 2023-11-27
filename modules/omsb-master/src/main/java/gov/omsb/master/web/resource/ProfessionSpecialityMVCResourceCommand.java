package gov.omsb.master.web.resource;

import com.liferay.adaptive.media.exception.AMRuntimeException.UnsupportedEncodingException;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.master.web.constants.MVCCommandNames;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;
import gov.omsb.master.web.portlet.dto.OmsbProfessionSpeciality;
import gov.omsb.master.web.portlet.dto.OmsbProfessionSpecialityItems;
import gov.omsb.master.web.portlet.dto.Worksectors;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name="
				+ MVCCommandNames.PROFESSION_PRI_SPECILAITY_RESOURCE_COMMAND}, service = MVCResourceCommand.class)
public class ProfessionSpecialityMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		logger.info("ProfessionSpecialityMVCResourceCommand Started ()");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long profession = ParamUtil.getLong(resourceRequest, "profession");
		OmsbProfessionSpecialityItems omsbProfessionSpecialityItems = getSpecialityByProfession(themeDisplay, profession);
		logger.info("OmsbProfessionSpecialityItems   "+ omsbProfessionSpecialityItems);
		if (Validator.isNotNull(omsbProfessionSpecialityItems) && Validator.isNotNull(omsbProfessionSpecialityItems.getItems())
				&& !omsbProfessionSpecialityItems.getItems().isEmpty()) {
			for (OmsbProfessionSpeciality items : omsbProfessionSpecialityItems.getItems()) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("speciality", omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(items.getSpeciality(), themeDisplay.getLocale()));
				object.put("specialityId",items.getSpeciality());
				jsonArray.put(object);
			}
			logger.info("jsonArray   "+jsonArray.toJSONString());
		}
		resourceResponse.getWriter().write(jsonArray.toString());
	}
	
	public OmsbProfessionSpecialityItems getSpecialityByProfession(ThemeDisplay themeDisplay, long profession)
			throws UnsupportedEncodingException {
		String professionSpecialityUrl =  themeDisplay.getPortalURL() + MVCCommandNames.PROFESSION_SPECIALITY_URL + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=profession" 
				+URLEncoder.encode(" eq " + profession, StandardCharsets.UTF_8);
		String professionSpecialityUrlResponse = omsbCommonApi.getData(professionSpecialityUrl);
		logger.info("professionSpecialityUrl::" + professionSpecialityUrl);
		logger.info("professionSpecialityUrlResponse==============="+professionSpecialityUrlResponse);
		return CustomObjectMapperUtil.readValue(professionSpecialityUrlResponse, OmsbProfessionSpecialityItems.class);
	}
	
	
	private static final Log logger = LogFactoryUtil.getLog(ProfessionSpecialityMVCResourceCommand.class);
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

}

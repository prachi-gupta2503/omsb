package gov.omsb.registration.web.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.ProfessionSpecialty;
import gov.omsb.registration.web.dto.ProfessionSpecialtyItems;
import gov.omsb.registration.web.dto.SpecialityItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.FETCH_SPECIALITY_BY_PROFESSION
	    }, 
	    service = MVCResourceCommand.class
)
public class GetSpecialityMVCResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		try {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		logger.info("GetSpecialtyResource command Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long profession  = ParamUtil.getLong(resourceRequest, "profession");
		logger.info("profession Id   "+profession);
		ProfessionSpecialtyItems professionSpecialtyItems = getProfessionSpecialityByProfessionId(themeDisplay, profession);
		logger.info("ProfessionSpecialtyItems size   "+professionSpecialtyItems.getItems().size());
			if (Validator.isNotNull(professionSpecialtyItems) && Validator.isNotNull(professionSpecialtyItems.getItems())
					&& !professionSpecialtyItems.getItems().isEmpty()) {
				logger.info("inside if---");
				for (ProfessionSpecialty items : professionSpecialtyItems.getItems()) {
					
					JSONObject object = JSONFactoryUtil.createJSONObject();
					object.put("specialty", items.getSpeciality());
					object.put("specialtyName", commonApi
							.getListTypeEntryNameBylistTypeEntryId(items.getSpeciality(), themeDisplay.getLocale()));
					jsonArray.put(object);
				}
				
				logger.info("jsonArray   "+jsonArray.toJSONString());
			}
			resourceResponse.getWriter().write(jsonArray.toString());
		} catch ( IOException e) {
			logger.error(e.getMessage());
		}
		return false;	}
	public ProfessionSpecialtyItems getProfessionSpecialityByProfessionId(ThemeDisplay themeDisplay, long professionId)
			throws UnsupportedEncodingException {

		String url =  themeDisplay.getPortalURL() + MVCCommands.PROFESSION_SPECIALITY_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=profession" 
				+URLEncoder.encode(" eq " + professionId	 , StandardCharsets.UTF_8);
		String response = commonApi.getData(url);
		logger.info("url::" + url);
		return CustomObjectMapperUtil.readValue(response, ProfessionSpecialtyItems.class);
	}
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	private static final Log logger = LogFactoryUtil.getLog(GetSpecialityMVCResourceCommand.class);
}

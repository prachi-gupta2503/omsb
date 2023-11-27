package gov.omsb.registration.web.resource;

import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
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
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.Speciality;
import gov.omsb.registration.web.dto.SpecialityItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SPECIALITY_AND_SUBSPECIALITY_MVC_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
)
public class SpecialityMVCResourceCommand implements MVCResourceCommand {

	private static final Log logger = LogFactoryUtil.getLog(SpecialityMVCResourceCommand.class);
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
	
		try {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		logger.info("SpecialityMVCResourceCommand Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long primarySpecialityId = ParamUtil.getLong(resourceRequest, "primarySpeciality");
		logger.info("primarySpecialityKey   "+primarySpecialityId);
		SpecialityItems specialityItems = getSpecialityItemsKey(themeDisplay, primarySpecialityId);
			if (Validator.isNotNull(specialityItems) && Validator.isNotNull(specialityItems.getItems())
					&& !specialityItems.getItems().isEmpty()) {
				for (Speciality items : specialityItems.getItems()) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					object.put("subSpecilaity", items.getSubSpeciality());
					object.put("subSpecilaityName", commonApi
							.getListTypeEntryNameBylistTypeEntryId(items.getSubSpeciality(), themeDisplay.getLocale()));
					jsonArray.put(object);
				}
				
				logger.info("jsonArray   "+jsonArray.toJSONString());
			}
			resourceResponse.getWriter().write(jsonArray.toString());
		} catch ( IOException e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	
	public SpecialityItems getSpecialityItemsKey(ThemeDisplay themeDisplay, long speciality)
			throws UnsupportedEncodingException {

		String specialityMasterUrl =  themeDisplay.getPortalURL() + MVCCommands.SPECIALITY_MASTER_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=speciality" 
				+URLEncoder.encode(" eq " + speciality	 , StandardCharsets.UTF_8);
		String specialityMasterResponse = commonApi.getData(specialityMasterUrl);
		logger.info("specialityMasterUrl::" + specialityMasterUrl);
		return CustomObjectMapperUtil.readValue(specialityMasterResponse, SpecialityItems.class);
	}

	@Reference(unbind = "_")
	private UserLocalService userService;
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "_")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	@Reference
	private DLAppLocalService _dlAppLocalService;

	@Reference
	private UserService _userService;
	
	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;
    
    @Reference(unbind = "_")
	private RoleLocalService roleLocalService;
}


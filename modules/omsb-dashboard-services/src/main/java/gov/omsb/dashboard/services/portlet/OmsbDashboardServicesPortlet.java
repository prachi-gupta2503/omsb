package gov.omsb.dashboard.services.portlet;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.dashboard.services.constants.OmsbDashboardServicesPortletKeys;
import gov.omsb.dashboard.services.dto.Services;
import gov.omsb.dashboard.services.dto.ServicesItem;

/**
 * @author anitas
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbDashboardServices",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmsbDashboardServicesPortletKeys.OMSBDASHBOARDSERVICES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbDashboardServicesPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServicesItem services = getServices(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId());
		_log.info("services :: "+services);
		List<Services> serviceList=new ArrayList<>();
		if(Validator.isNotNull(services) && Validator.isNotNull(services.getItems())) {
		
			for(Services service:services.getItems()) {
			try {
				_log.info("name" +commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SERVICE, service.getServiceId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
				service.setServiceId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SERVICE, service.getServiceId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
				serviceList.add(service);
				
				_log.info(service);
			}
			catch(Exception e) {
				_log.error("unable to get the list type with key : "+service.getServiceId()+"  ::: "+e.getMessage());
			}
			}
		}
		
		renderRequest.setAttribute("serviceList",serviceList);
		super.render(renderRequest, renderResponse);
	}
	
	public ServicesItem getServices(String portalURL,long groupId) {
	    StringBuilder sbURL = new StringBuilder(
	                           portalURL +OmsbDashboardServicesPortletKeys.SERVICE_URL + groupId);
	           _log.info("url::get Work Sector:::::" + sbURL);                
	           return getItems(sbURL.toString()+ "?sort=id:desc&pageSize=0", ServicesItem.class);
	}  
	
	public <T> T getItems(String url, Class<T> clazz) {
		String response = commonApi.getData(url);
		if (Validator.isNotNull(response)) {
			return CustomObjectMapperUtil.readValue(response, clazz);
		}
		return null;
	}
	
	public static final Log _log= LogFactoryUtil.getLog(OmsbDashboardServicesPortlet.class);
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
}
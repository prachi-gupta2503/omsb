package gov.omsb.registration.web.render;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(immediate = true, 
			property = { 
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+ MVCCommands.VIEW_REGISTRATION_EDUCATION_DETAILS},
			service = MVCRenderCommand.class)
public class ViewEducationalDetailMVCRenderCommand implements MVCRenderCommand {
	
	public static final Log _log=LogFactoryUtil.getLog(ViewEducationalDetailMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ListTypeEntry> qualificationList = registrationUtil.getPickListEntries(LRPicklistConstants.QUALIFICATION, themeDisplay.getCompanyId());
		List<ListTypeEntry> institutionList = registrationUtil.getPickListEntries(LRPicklistConstants.INSTITUTION, themeDisplay.getCompanyId());
	//	CountryItem customCountryItems = registrationUtil.getCustomCountryItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
		List<Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long personId = ParamUtil.getLong(renderRequest, "personId");
		long lrUserId = ParamUtil.getLong(renderRequest, "lrUserId");
		String civilId = ParamUtil.getString(renderRequest, "civilId");
		String passportNumber = ParamUtil.getString(renderRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(renderRequest, "dateOfBirth");
		
		//personId=149056;
		
		
		if(Validator.isNotNull(personId) && personId>0) {
			try {
	        	EducationDetailItem educationalDetailItem = registrationUtil.fetchEducationDetailByPersonId(themeDisplay, ParamUtil.getLong(renderRequest, "personId"));
	            if(Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size()>0) {
	            	_log.info("educationalDetail ::::::::::::::::::"+educationalDetailItem.getItems().get(0).getPersonId());
	                List<EducationDetail>  educationalDetailItemList =educationalDetailItem.getItems();
	                for(EducationDetail detail : educationalDetailItemList) {
	                	if(Validator.isNotNull( detail.getQualificationAttained())) {
	                		try {
								detail.setQualificationAttained(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, detail.getQualificationAttained(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
							} catch (Exception e) {
								_log.error(e.getMessage());
							}
	                	}
	                    if(Validator.isNotNull( detail.getIssuingAuthorityName())) {
	                    	
	                    	ListTypeEntry listEntry;
							try {
								listEntry = ListTypeEntryLocalServiceUtil
										.fetchListTypeEntry(Long.parseLong(detail.getIssuingAuthorityName()));
								detail.setIssuingAuthorityName(listEntry.getName(Locale.getDefault()));
							} catch (Exception e1) {
								_log.error(e1.getMessage());
							}
	                    	
	                    	
//	                    	detail.setIssuingAuthorityName(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.INSTITUTION, detail.getIssuingAuthorityName(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
	                    	
	                    }
	                    if(Validator.isNotNull( detail.getIssuingAuthorityCountryId())) {
	                    //	Country country = registrationUtil.getCustomCountryById(themeDisplay.getPortalURL(), detail.getIssuingAuthorityCountryId());
	                    	Country country=null;
							try {
								country = CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId());
								detail.setIssuingAuthorityCountry(country.getName(themeDisplay.getLocale()));
							} catch (Exception e) {
								_log.error("unable to get the country having id :: "+detail.getIssuingAuthorityCountryId()+ " :::: "+e.getMessage());
							}
	                    }
	                }

	                _log.info("educationalDetailItemList ::::" +educationalDetailItemList.size());
	                _log.info("educationalDetailItemList ::::" +educationalDetailItemList.get(0).getIssuingAuthorityCountryId());
	                renderRequest.setAttribute("educationalDetailItemList", educationalDetailItemList);
	            }
	        } catch (UnsupportedEncodingException e) {
	            _log.error(e.getMessage());
	        }		
			renderRequest.setAttribute("personId", personId);
		}
		
		if(Validator.isNotNull(qualificationList) && qualificationList.size()>0) {
			JSONArray qualificationArray=JSONFactoryUtil.createJSONArray();
			for(ListTypeEntry lt:qualificationList) {
				JSONObject qualificationObject=JSONFactoryUtil.createJSONObject();
				qualificationObject.put("key", lt.getKey());
				qualificationObject.put("name", lt.getName(themeDisplay.getLocale()));
				qualificationArray.put(qualificationObject);
			}
			renderRequest.setAttribute("qualificationArray", qualificationArray);
		} 
		
		if(Validator.isNotNull(countries)  && countries.size()>0) {
			JSONArray countryArray=JSONFactoryUtil.createJSONArray();
				for(Country country :countries) {
					JSONObject countryObject=JSONFactoryUtil.createJSONObject();
					countryObject.put("id", country.getCountryId());
					countryObject.put("nationality", country.getName(themeDisplay.getLocale()));
					countryArray.put(countryObject);
				}
		//	}
			_log.info("countryArray ::::" +countryArray);
			renderRequest.setAttribute("countryArray", countryArray);
			renderRequest.setAttribute("customCountries", countries);
		}
		renderRequest.setAttribute("lrUserId", lrUserId);
		renderRequest.setAttribute("qualificationList", qualificationList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("institutionList", institutionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("civilId", civilId);
		renderRequest.setAttribute("passportNumber", passportNumber);
		renderRequest.setAttribute("dateOfBirth", dateOfBirth);
		return OmsbRegistrationWebPortletKeys.REGISTRATION_EDUCATION_DETAILS_JSP;
	}	

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
}
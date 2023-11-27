package gov.omsb.registration.web.resource;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.dto.WorkSectorItems;
import gov.omsb.registration.web.render.ViewEducationalDetailMVCRenderCommand;
import gov.omsb.registration.web.util.RegistrationUtil;

/**
 * @author Mahaboob
 */


@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.WORK_DETAIL_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class ViewWorkDetailMVCResourceCommand implements MVCResourceCommand {

	
	public static final Log logger=LogFactoryUtil.getLog(ViewWorkDetailMVCResourceCommand.class);
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long personId = ParamUtil.getLong(resourceRequest, "personId");
		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		
		List<ListTypeEntry> workSectorTypes = registrationUtil.getPickListEntries(LRPicklistConstants.WORK_SECTOR_TYPE, themeDisplay.getCompanyId());
	//	List<ListTypeEntry> wilayats = registrationUtil.getPickListEntries(LRPicklistConstants.WILAYAT, themeDisplay.getCompanyId());
		List<ListTypeEntry> governorate=registrationUtil.getPickListEntries(LRPicklistConstants.GOVERNORATE, themeDisplay.getCompanyId());
		List<ListTypeEntry> designations = registrationUtil.getPickListEntries(LRPicklistConstants.DESIGNATION, themeDisplay.getCompanyId());
		
		if (Validator.isNotNull(personId)) {
			//Get Primary Work Detail 
			EmploymentDetailItem workDetailItems = null;
			try {
				workDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(), personId,"1");
			} catch (Exception e) {
				logger.error("workDetailItems exception:" + e.getMessage());
			}
			EmploymentDetailItem secondaryWorkDetailItems = null;
			try {
				secondaryWorkDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(), personId,"2");
			} catch (Exception e) {
				logger.error("secondaryWorkDetailItems exception:" + e.getMessage());
			}
			logger.info("workDetailItems ::::" +workDetailItems);
			if(Validator.isNotNull(workDetailItems.getItems()) && workDetailItems.getItems().size()>0) {
				EmploymentDetail workDetail=workDetailItems.getItems().get(0);
				try {
					//Get Work sector Type 
					if(Validator.isNotNull(workDetail.getWorkSectorType())) {
						long workSectorTypeID=Long.parseLong(workDetail.getWorkSectorType());
						ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
						if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
							WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorType());
							logger.info("workSectorItems in other than other :: "+workSectorItems.getItems().size());
							workDetail.setWorkSectorItems(workSectorItems);
						}
					}
						
					//Get Work sector  
					if(Validator.isNotNull(workDetail.getWorkSectorId()) && workDetail.getWorkSectorId()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId());
						workDetail.setWorkSubSectorItems(workSectorItems);
					}

					//Get Work Sub Sector 
					if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId());
						workDetail.setWorkSubSectorItems(workSectorItems);
					}

					//Get work second sub sectors 
					if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId2());
						workDetail.setWorkSecondSubSectorItems(workSectorItems);
					}

					if(Validator.isNotNull(workDetail.getStaffIdCard()) && Long.valueOf(workDetail.getStaffIdCard()) > 0) {
						workDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(workDetail.getStaffIdCard())).getDescription());
						try {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(workDetail.getStaffIdCard()));
							workDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
						} catch (PortalException e) {
							logger.error("Error in  code :::" + e.getMessage());
						}
					}

					if(Validator.isNotNull( workDetail.getWorkSector())) {
						WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, workDetail.getWorkSector());
						if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
							workDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
                    }
					logger.debug("workDetail :: " + workDetail);
				} catch (Exception e) {
					logger.error("Error :::::"+e.getMessage());
				}
				logger.info("workDetailItems Size :::::"+ workDetailItems.getItems().size());
				resourceRequest.setAttribute("primaryworkDetail", workDetail);
			}
			
			//Get secondary work detail
			if(Validator.isNotNull(secondaryWorkDetailItems.getItems()) && secondaryWorkDetailItems.getItems().size()>0) {
				EmploymentDetail secondaryWorkDetail=secondaryWorkDetailItems.getItems().get(0);
				try {
					//Get Work sector Type 
					if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorType())) {
						long workSectorTypeID=Long.parseLong(secondaryWorkDetail.getWorkSectorType());
						ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
						//Get Work sector  
						if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
							WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorType());
							logger.info("workSectorItems in other than other :: "+workSectorItems.getItems().size());
							secondaryWorkDetail.setWorkSectorItems(workSectorItems);
						}
					}
					
					if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId()) && secondaryWorkDetail.getWorkSectorId()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId());
						secondaryWorkDetail.setWorkSubSectorItems(workSectorItems);
					}
										
					//Get Work Sub Sector 
					if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId2()) && secondaryWorkDetail.getWorkSectorId2()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId());
						secondaryWorkDetail.setWorkSubSectorItems(workSectorItems);
					}
					
					
					//Get work second sub sectors 
					/*if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId3()) && secondaryWorkDetail.getWorkSectorId3()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId2());
						secondaryWorkDetail.setWorkSecondSubSectorItems(workSectorItems);
					}*/
					
					//Get work second sub sectors 
					if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId2()) && secondaryWorkDetail.getWorkSectorId2()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId2());
						secondaryWorkDetail.setWorkSecondSubSectorItems(workSectorItems);
					}
					
					if(Validator.isNotNull(secondaryWorkDetail.getStaffIdCard()) && Long.valueOf(secondaryWorkDetail.getStaffIdCard()) > 0) {
						secondaryWorkDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(secondaryWorkDetail.getStaffIdCard())).getDescription());
						try {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(secondaryWorkDetail.getStaffIdCard()));
							secondaryWorkDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
						} catch (PortalException e) {
							logger.error("Error in  code :::" + e.getMessage());
						}
					}
					
					if(Validator.isNotNull( secondaryWorkDetail.getWorkSector())) {
						WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, secondaryWorkDetail.getWorkSector());
						if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
							secondaryWorkDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
                    }
			} catch (Exception e) {
				logger.error("Error :::::"+e.getMessage());
			}
			logger.info("secondaryWorkDetailItems Size :::::"+ secondaryWorkDetailItems.getItems().size());
			resourceRequest.setAttribute("secondaryWorkDetail", secondaryWorkDetail);
		}
			
			//Getting Secondary work detail logic here 
			PersonalDetailItem personalDetailItem = registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
			if(Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size()>0) {
				logger.info("agreed : "+personalDetailItem.getItems().get(0).isAgreed());
				logger.info("declared : "+personalDetailItem.getItems().get(0).isDeclaration());
				resourceRequest.setAttribute("isAgreed", personalDetailItem.getItems().get(0).isAgreed());
				resourceRequest.setAttribute("isDeclared", personalDetailItem.getItems().get(0).isDeclaration());
				
				long cvDocumentId = personalDetailItem.getItems().get(0).getCvDocumentId();
				resourceRequest.setAttribute("cvDocumentId", cvDocumentId);
				if(cvDocumentId>0) {
					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(cvDocumentId);
						resourceRequest.setAttribute("cvDocument", entry.getDescription());
						String documentViewURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "");
						logger.info("documentViewURL :::::"+documentViewURL);
						resourceRequest.setAttribute("cvDocumentURL",documentViewURL);
					}catch(PortalException e) {
						logger.error("unable to get the file entry having id "+cvDocumentId);
					}
				}
				resourceRequest.setAttribute("cvDocumentId", cvDocumentId);				
			}
			logger.info(" workSectorTypes :: " + workSectorTypes + "workDetailItems " + workDetailItems);
		}
		
		resourceRequest.setAttribute("workSectorTypeList", workSectorTypes.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("wilayats", governorate.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("designations", designations.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("personId", personId);
		resourceRequest.setAttribute("lrUserId", lrUserId);
		
		boolean isNext=ParamUtil.getBoolean(resourceRequest, "isNext") ;
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_WORK_DETAILS_JSP);
		logger.info(isNext);
		if(!isNext) {
			
			setEducationData(resourceRequest, resourceResponse);
			
			dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_EDUCATION_DETAILS_JSP);
		}
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	private void setEducationData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		// TODO Auto-generated method stub

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ListTypeEntry> qualificationList = registrationUtil.getPickListEntries(LRPicklistConstants.QUALIFICATION, themeDisplay.getCompanyId());
		List<ListTypeEntry> institutionList = registrationUtil.getPickListEntries(LRPicklistConstants.INSTITUTION, themeDisplay.getCompanyId());
	//	CountryItem customCountryItems = registrationUtil.getCustomCountryItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
		List<Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long personId = ParamUtil.getLong(resourceRequest, "personId");
		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		String civilId = ParamUtil.getString(resourceRequest, "civilId");
		String passportNumber = ParamUtil.getString(resourceRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(resourceRequest, "dateOfBirth");
		if(Validator.isNotNull(personId) && personId>0) {
			try {
	        	EducationDetailItem educationalDetailItem = registrationUtil.fetchEducationDetailByPersonId(themeDisplay, ParamUtil.getLong(resourceRequest, "personId"));
	            if(Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size()>0) {
	            	LOGGER.info("educationalDetail ::::::::::::::::::"+educationalDetailItem.getItems().get(0).getPersonId());
	                List<EducationDetail>  educationalDetailItemList =educationalDetailItem.getItems();
	                for(EducationDetail detail : educationalDetailItemList) {
	                	if(Validator.isNotNull( detail.getQualificationAttained())) {
	                		detail.setQualificationAttained(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, detail.getQualificationAttained(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
	                	}
	                    if(Validator.isNotNull( detail.getIssuingAuthorityName())) {
	                    	ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil
									.fetchListTypeEntry(Long.parseLong(detail.getIssuingAuthorityName()));
//	                    	detail.setIssuingAuthorityName(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.INSTITUTION, detail.getIssuingAuthorityName(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
	                    	detail.setIssuingAuthorityName(listEntry.getName(Locale.getDefault()));
	                    }
	                    if(Validator.isNotNull( detail.getIssuingAuthorityCountryId())) {
	                    //	Country country = registrationUtil.getCustomCountryById(themeDisplay.getPortalURL(), detail.getIssuingAuthorityCountryId());
	                    	Country country=null;
							try {
								country = CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId());
								detail.setIssuingAuthorityCountry(country.getName(themeDisplay.getLocale()));
								
								
							} catch (PortalException e) {
								LOGGER.error("unable to get the country having id :: "+detail.getIssuingAuthorityCountryId()+ " :::: "+e.getMessage());
							}
	                    }
	                }

	                LOGGER.info("educationalDetailItemList ::::" +educationalDetailItemList.size());
	                LOGGER.info("educationalDetailItemList ::::" +educationalDetailItemList.get(0).getIssuingAuthorityCountryId());
	                resourceRequest.setAttribute("educationalDetailItemList", educationalDetailItemList);
	            }
	        } catch (UnsupportedEncodingException e) {
	            LOGGER.error(e.getMessage());
	        }		
			resourceRequest.setAttribute("personId", personId);
		}
		
		if(Validator.isNotNull(qualificationList) && qualificationList.size()>0) {
			JSONArray qualificationArray=JSONFactoryUtil.createJSONArray();
			for(ListTypeEntry lt:qualificationList) {
				JSONObject qualificationObject=JSONFactoryUtil.createJSONObject();
				qualificationObject.put("key", lt.getKey());
				qualificationObject.put("name", lt.getName(themeDisplay.getLocale()));
				qualificationArray.put(qualificationObject);
			}
			resourceRequest.setAttribute("qualificationArray", qualificationArray);
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
			LOGGER.info("countryArray ::::" +countryArray);
			resourceRequest.setAttribute("countryArray", countryArray);
			resourceRequest.setAttribute("customCountries", countries);
		}
		resourceRequest.setAttribute("lrUserId", lrUserId);
		resourceRequest.setAttribute("qualificationList", qualificationList);
		resourceRequest.setAttribute("institutionList", institutionList);
		resourceRequest.setAttribute("civilId", civilId);
		resourceRequest.setAttribute("passportNumber", passportNumber);
		resourceRequest.setAttribute("dateOfBirth", dateOfBirth);
	}

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(ViewWorkDetailMVCResourceCommand.class);

}
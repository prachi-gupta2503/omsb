package gov.omsb.registration.web.render;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.dto.WorkSectorItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(immediate = true, 
property = {
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name="+ MVCCommands.VIEW_REGISTRATION_WORK_DETAILS},
service = MVCRenderCommand.class)
public class ViewWorkDetailsMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long personId = ParamUtil.getLong(renderRequest, "personId");
		long lrUserId = ParamUtil.getLong(renderRequest, "lrUserId");
		
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
						workDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(workDetail.getStaffIdCard())).getFileName());
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
				renderRequest.setAttribute("primaryworkDetail", workDetail);
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
						secondaryWorkDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(secondaryWorkDetail.getStaffIdCard())).getFileName());
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
			renderRequest.setAttribute("secondaryWorkDetail", secondaryWorkDetail);
		}
			
			//Getting Secondary work detail logic here 
			PersonalDetailItem personalDetailItem = registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
			if(Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size()>0) {
				logger.info("agreed : "+personalDetailItem.getItems().get(0).isAgreed());
				logger.info("declared : "+personalDetailItem.getItems().get(0).isDeclaration());
				renderRequest.setAttribute("isAgreed", personalDetailItem.getItems().get(0).isAgreed());
				renderRequest.setAttribute("isDeclared", personalDetailItem.getItems().get(0).isDeclaration());
				
				long cvDocumentId = personalDetailItem.getItems().get(0).getCvDocumentId();
				renderRequest.setAttribute("cvDocumentId", cvDocumentId);
				if(cvDocumentId>0) {
					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(cvDocumentId);
						renderRequest.setAttribute("cvDocument", entry.getDescription());
						String documentViewURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "");
						logger.info("documentViewURL :::::"+documentViewURL);
						renderRequest.setAttribute("cvDocumentURL",documentViewURL);
					}catch(PortalException e) {
						logger.error("unable to get the file entry having id "+cvDocumentId);
					}
				}
				renderRequest.setAttribute("cvDocumentId", cvDocumentId);				
			}
			logger.info(" workSectorTypes :: " + workSectorTypes + "workDetailItems " + workDetailItems);
		}
		
		renderRequest.setAttribute("workSectorTypeList", workSectorTypes.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("wilayats", governorate.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("designations", designations.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("personId", personId);
		renderRequest.setAttribute("lrUserId", lrUserId);
		
		return OmsbRegistrationWebPortletKeys.REGISTRATION_WORK_DETAILS_JSP;
	}
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	private final Log logger=LogFactoryUtil.getLog(ViewWorkDetailsMVCRenderCommand.class);
}

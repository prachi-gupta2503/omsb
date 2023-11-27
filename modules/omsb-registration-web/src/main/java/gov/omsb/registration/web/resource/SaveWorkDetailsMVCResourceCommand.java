package gov.omsb.registration.web.resource;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SAVE_REGISTRATION_WORK_DETAILS_SR
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class SaveWorkDetailsMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(SaveWorkDetailsMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		try {
			_log.info("Entry into SaveWorkDetailsMVCResourceCommand ::");
			
			EmploymentDetail employmentDetail = null;
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
			Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(),
					CommonConstants.GUEST_GROUP_KEY);
			long groupId = group.getGroupId();
			File file = null;
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long personId = ParamUtil.getLong(resourceRequest, "personId");
			long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
			long employed = ParamUtil.getLong(resourceRequest, "employed");
			//String firstDeclareValue = ParamUtil.get(resourceRequest, "declare1", "");
			//String secondDeclareValue = ParamUtil.get(resourceRequest, "declare2", "");
			
			int i=3;
			
			String workSectorType = ParamUtil.getString(resourceRequest, "workSectorType_" + i);
			String worksectortypeother = ParamUtil.getString(resourceRequest, "worksectortypeother_" + i);
			long workSector = ParamUtil.getLong(resourceRequest, "worksector_" + i);
			String worksectorother = ParamUtil.getString(resourceRequest, "worksectorother_" + i);
			long firstsubworksector = ParamUtil.getLong(resourceRequest, "first_sub_worksector_" + i);
			String worksubsectorother = ParamUtil.getString(resourceRequest, "work_sub_sectorother_" + i);
			String designationother = ParamUtil.getString(resourceRequest, "designationother_" + i);
			//String designationother3 = ParamUtil.getString(resourceRequest, "designationother_3");
			long id = ParamUtil.getLong(resourceRequest, "id");
			file = uploadPortletRequest.getFile("staffIdCard_" + i);
			String fileName = uploadPortletRequest.getFileName("staffIdCard_" + i);
	
			String mimeType = uploadPortletRequest.getContentType("staffIdCard_" + i);
			
			long secondSubWorksector = ParamUtil.getLong(resourceRequest, "second_sub_worksector_" + i);
			String worksecondsectorother = ParamUtil.getString(resourceRequest, "worksecondsectorother_" + i);

			//_log.info("designationother3 ::: "+i+" :::"+designationother3);
			_log.info("id ::: "+i+" :::"+id);
			_log.info("file ::: "+i+" :::"+file);
			_log.info("fileName ::: "+i+" :::"+fileName);
			_log.info("mimeType ::: "+i+" :::"+mimeType);
			_log.info("personId ::: "+i+" :::"+personId);
			_log.info("lrUserId ::: "+i+" :::"+lrUserId);
			_log.info("workSectorType ::: "+i+" :::"+workSectorType);
			_log.info("worksectortypeother ::: "+i+" :::"+worksectortypeother);
			_log.info("workSector ::: "+i+" :::"+workSector);
			_log.info("worksectorother ::: "+i+" :::"+worksectorother);
			_log.info("firstsubworksector ::: "+i+" :::"+firstsubworksector);
			_log.info("worksubsectorother ::: "+i+" :::"+worksubsectorother);
			_log.info("designationother ::: "+i+" :::"+designationother);
			_log.info("secondSubWorksector ::: "+i+" :::"+secondSubWorksector);
			_log.info("worksecondsectorother ::: "+i+" :::"+worksecondsectorother);
			
			_log.info(" employed : "+ employed);
			
			saveEmploymentDetail(resourceRequest, employmentDetail, uploadPortletRequest, groupId, themeDisplay, personId, lrUserId, employed);
			
			//Set value
			registrationUtil.setWorkDetails(resourceRequest, resourceResponse);
			
			
			
			
		/*	long personId=	ParamUtil.getLong(resourceRequest, "personId");
			_log.info("personId :::"+personId);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String qualification = ParamUtil.getString(resourceRequest, "qualification");
			String institution = ParamUtil.getString(resourceRequest, "institution");
			long countryId = ParamUtil.getLong(resourceRequest, "country");
			String gpa = ParamUtil.getString(resourceRequest, "gpa");
			int yearOfGraduation = ParamUtil.getInteger(resourceRequest, "year");
			long id = ParamUtil.getLong(resourceRequest, "id");
			
			long lrUSerId=ParamUtil.getLong(resourceRequest, "lrUserId");
			
			
			_log.info("lrUSerId :::::" +lrUSerId);
			
			
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
			uploadPortletRequest.getContentType("qualificationDoc");
			EducationDetail educationDetail = registrationUtil.setEducationDetailsData(resourceRequest, themeDisplay,
					themeDisplay.getScopeGroupId(), qualification, institution, countryId, gpa, yearOfGraduation, id);
			JSONObject obj = JSONFactoryUtil.createJSONObject();

			if (educationDetail.getId() > 0) {
				obj.put("isValid", true);
			} else {
				obj.put("isValid", false);
			}
				*/
		//	registrationUtil.setEducationDetails(resourceRequest, resourceResponse);
			 
			
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error, "+e.getMessage());
			return Boolean.TRUE;
		}
	}
	
	
	
	public EmploymentDetail saveEmploymentDetail(ResourceRequest actionRequest, EmploymentDetail employmentDetail,
			UploadPortletRequest uploadPortletRequest, long groupId, ThemeDisplay themeDisplay, long personId,
			long lrUserId, long employed) {
		File file;
		//if (employed == 1) {
			//for (int i = 1; i <= 2; i++) {
				int i=3;
				
				String workSectorType = ParamUtil.getString(actionRequest, "workSectorType_" + i);
				String worksectortypeother = ParamUtil.getString(actionRequest, "worksectortypeother_" + i);
				long workSector = ParamUtil.getLong(actionRequest, "worksector_" + i);
				String worksectorother = ParamUtil.getString(actionRequest, "worksectorother_" + i);
				
				long firstsubworksector = ParamUtil.getLong(actionRequest, "first_sub_worksector_" + i);
				String worksubsectorother = ParamUtil.getString(actionRequest, "work_sub_sectorother_" + i);
				
				long secondSubWorksector = ParamUtil.getLong(actionRequest, "second_sub_worksector_" + i);
				String worksecondsectorother = ParamUtil.getString(actionRequest, "worksecondsectorother_" + i);
	
				
				
				_log.info("workSectorType ::: "+i+" :::"+workSectorType);
				_log.info("workSector ::: "+i+" :::"+workSector);
				_log.info("worksectorother ::: "+i+" :::"+worksectorother);
				_log.info("firstsubworksector ::: "+i+" :::"+firstsubworksector);
				_log.info("worksubsectorother ::: "+i+" :::"+worksubsectorother);
				_log.info("secondSubWorksector ::: "+i+" :::"+secondSubWorksector);
				_log.info("worksecondsectorother ::: "+i+" :::"+worksecondsectorother);
				
				
				ListTypeEntry listTypeEntry =null;
			      if(Validator.isNotNull(workSectorType)) {
			    	  long workSectorTypeID=Long.parseLong(workSectorType);
			    	   try {
						listTypeEntry	 =ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
					} catch (PortalException e) {
						_log.error("Exception ::"+e.getMessage());
					}
			    	   _log.info("listTypeEntry ::: " +listTypeEntry);
			    	   _log.info("listTypeEntry key ::: " +listTypeEntry.getKey());
			    	   _log.info("listTypeEntry  Name ::: " +listTypeEntry.getName(themeDisplay.getLocale()));
			      }
			      
			      if(Validator.isNotNull(firstsubworksector) && firstsubworksector>0) {
			    	  worksubsectorother=StringPool.BLANK;
			      }
				
			      _log.info("workSectorType :::"+workSectorType);
			      _log.info("worksectortypeother :::"+worksectortypeother);
			      _log.info("workSector :::"+workSector);
			      _log.info("worksectorother :::"+worksectorother);
			      _log.info("firstsubworksector :::"+firstsubworksector);
			      _log.info("worksubsectorother :::"+worksubsectorother);
				
				//String workSectorType = ParamUtil.getString(actionRequest, "workSectorType_" + i);
				//String workSector = ParamUtil.getString(actionRequest, "worksector_" + i);
				//String workSectorOther = ParamUtil.getString(actionRequest, "worksectorother_" + i);
					
				if(Validator.isNotNull(listTypeEntry)) {
			    	  if(!listTypeEntry.getKey().equalsIgnoreCase("others")) {
			    		  worksectortypeother=StringPool.BLANK;
			    	  }else {
			    		  workSector=0;
			    		  firstsubworksector=0;
			    		  worksectorother=StringPool.BLANK;
			    		  worksubsectorother=StringPool.BLANK;
			    		  
			    		  secondSubWorksector=0;
			    		  worksecondsectorother=StringPool.BLANK;
			    	  }
			      }
				if(workSector==0 && Validator.isNotNull(worksectorother)) {
					firstsubworksector=0;
					worksubsectorother=StringPool.BLANK;
					
					secondSubWorksector=0;
		    		 worksecondsectorother=StringPool.BLANK;
				}
				
				if(firstsubworksector==0 && Validator.isNotNull(worksubsectorother)) {
					secondSubWorksector=0;
		    		worksecondsectorother=StringPool.BLANK;
				}
				
				String wilayat = ParamUtil.getString(actionRequest, "wilayats_" + i);
				String designation = ParamUtil.getString(actionRequest, "designations_" + i);
				String designationother = ParamUtil.getString(actionRequest, "designationother_" + i);
				//Boolean isPrimaryWorkDetail = ParamUtil.getBoolean(actionRequest, "isPrimary_" + i);

				long id = ParamUtil.getLong(actionRequest, "id");
				file = uploadPortletRequest.getFile("staffIdCard_" + i);
				String fileName = uploadPortletRequest.getFileName("staffIdCard_" + i);
		
				String mimeType = uploadPortletRequest.getContentType("staffIdCard_" + i);
				long uploadFileId = ParamUtil.getLong(actionRequest, "uploadFile_" + i);
				String fileEntryId = Validator.isNotNull(uploadFileId) ? String.valueOf(uploadFileId): StringPool.BLANK;
					
				_log.debug("id :: " +
				  id + " personId : " + personId + " lrUserId : " + lrUserId + " employed " +
				  employed + " workSectorType : " + workSectorType + " workSector : " +
				  workSector + " workSectorOther : " + worksectorother + " wilayat :: " +
				  wilayat + "  designation  : " + designationother + " fileName :: " + fileName
				  + " designation :: " + designation); 
				
				if(Validator.isNotNull(id) && id>0) {
					EmploymentDetail employmentDetailById = null;
					
					try {
						employmentDetailById=registrationUtil.getItems(themeDisplay.getPortalURL() + "/o/c/employmentdetails/" + id, EmploymentDetail.class);
					} catch (Exception e) {
						_log.error("Exception ::"+e.getMessage());
					}
					
					
					if(Validator.isNotNull(employmentDetailById)) {
						fileEntryId=employmentDetailById.getStaffIdCard();
						
						_log.info("fileEntryId for old :::" +fileEntryId);
						
						//Delete Old Record 
						_log.info("inside delete  condition"); 
						  Map<String, String> headers =commonApi.getHttpHeaderInfoAndBasicAuth();
						  String url =themeDisplay.getPortalURL() + LRObjectURL.REG_EMPLOYMENT_DETAIL_URL + id;
						  _log.info("url : " + url); 
						  httpConnector.executeDelete(url, headers);
					}
					
				}
				  
				  //Adding New Record 
				  if (Validator.isNotNull(workSectorType) || Validator.isNotNull(workSector) || Validator.isNotNull(designation)) {
					  
					  if(Validator.isNotNull(fileName)) {
						  fileEntryId =registrationUtil.uploadFileByGuest(themeDisplay, groupId, personId,DataflowConstants.EMPLOYMENT_COMPONENT_KEY, file, fileName);
						  _log.info("fileEntryId : " + fileEntryId); 
					  } 
						_log.info("fileEntryId final :::" +fileEntryId);
					  employmentDetail = registrationUtil.setWorkDetailNew(lrUserId, themeDisplay, workSectorType,workSector, worksectorother, wilayat, designation, designationother,
							  			fileEntryId, personId,"0",worksectortypeother,firstsubworksector,worksubsectorother,secondSubWorksector,worksecondsectorother); 
					  _log.info("employmentDetail :::::::::::::::::::::"+employmentDetail); 
				 }
			//}
			
			//Update Regis
		      //Update User status
				/*if(Validator.isNotNull(personId) && personId>0) {
					PersonalDetailItem personDetailItem=registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
					if(Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size()>0) {
						try {
							PersonalDetail personalDetail=personDetailItem.getItems().get(0);
							personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.WORK_DETAILS);
							registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);
						} catch (Exception e) {
							_log.error(e.getMessage());
						}
					}	
				}*/
			
			
		//}
		
		/*if (employed == 0) {
			EmploymentDetailItem employmentDetailItem = getWorkDetailsByPersonId(themeDisplay.getPortalURL(),
					themeDisplay.getScopeGroupId(), personId);
			if (Validator.isNotNull(employmentDetailItem) && employmentDetailItem.getItems().size() > 0) {
				for (EmploymentDetail detail : employmentDetailItem.getItems()) {
					deleteWorkDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), detail.getId());
				}
			}
		}*/
		 
		return employmentDetail;
	}
	
	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
}

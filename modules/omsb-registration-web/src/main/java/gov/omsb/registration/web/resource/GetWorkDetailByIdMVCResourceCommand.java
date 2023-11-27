package gov.omsb.registration.web.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.DocumentInfoItem;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.WorkSector;
import gov.omsb.registration.web.dto.WorkSectorItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.GET_REGISTRATION_WORK_DETAILS_SR
	    }, 
	    service = MVCResourceCommand.class 
)
public class GetWorkDetailByIdMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(GetWorkDetailByIdMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("GetWorkDetailByIdMVCResourceCommand Invoked ::::");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long id = ParamUtil.getLong(resourceRequest, "id");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			 JSONArray jsonArray= JSONFactoryUtil.createJSONArray();
			 JSONArray jsonArray2= JSONFactoryUtil.createJSONArray();
			 JSONArray jsonArray3= JSONFactoryUtil.createJSONArray();
			if(id>0) {
				EmploymentDetail employmentDetail = registrationUtil.getItems(themeDisplay.getPortalURL() + "/o/c/employmentdetails/" + id, EmploymentDetail.class);
				
				/*
				 * String documentInfoUrl = themeDisplay.getPortalURL() +
				 * LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES + StringPool.SLASH
				 * + themeDisplay.getScopeGroupId() + StringPool.QUESTION +
				 * "filter=componentClassRefId" + URLEncoder.encode(" eq " +
				 * employmentDetail.getId(), DataflowConstants.UTF_8); DocumentInfoItem
				 * documentInfoItems =
				 * CustomObjectMapperUtil.readValue(omsbCommonApi.getData(documentInfoUrl),
				 * DocumentInfoItem.class);
				 */
				
				
				
				if(Validator.isNotNull(employmentDetail.getStaffIdCard()) ) {
					//if(Validator.isNotNull(documentInfo.getFileEntryID()) && documentInfo.getFileEntryID()>0) {
						try {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(Long.parseLong(employmentDetail.getStaffIdCard()));
							String documentURL =DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK);
							employmentDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
							employmentDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(employmentDetail.getStaffIdCard())).getFileName());
						
						} catch (PortalException e) {
							_log.error("Error in  code :::" + e.getMessage());
						}
					//}
					//employmentDetail.setDocumentInfo(documentInfo);
				}
				
				_log.info("employmentDetail 1::: " +employmentDetail.getWorkSectorType());
				ListTypeEntry listTypeEntry = null;
				long workSectorTypeID = Long.parseLong(employmentDetail.getWorkSectorType());
				try {
					listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
				} catch (PortalException e) {
					_log.error("Exception in code :::" + e.getMessage());
				}
				
				
				
				if(!listTypeEntry.getName(themeDisplay.getLocale()).equalsIgnoreCase("Others")) {
					
					WorkSectorItems workSectorItems =	registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), employmentDetail.getWorkSectorType());
					
					
					_log.info("workSectorItems getItems _____________::::" +workSectorItems.getItems());
					
					
					if(Validator.isNotNull(workSectorItems) && Validator.isNotNull(workSectorItems.getItems()) && workSectorItems.getItems().size()>0) {
						if(Validator.isNotNull(workSectorItems.getItems()) && workSectorItems.getItems().size()>0) {
		    	  			for(WorkSector workSector : workSectorItems.getItems()) {
		    	  				JSONObject object =JSONFactoryUtil.createJSONObject();
		    	  				object.put("id", workSector.getId());
		    	  				object.put("value", workSector.getWorkSector());
		    	  				jsonArray.put(object);
		    	  			}
		    	  		}
						JSONObject otherObj =JSONFactoryUtil.createJSONObject();
		  				otherObj.put("id", "other");
		  				otherObj.put("value", "Other");
						jsonArray.put(otherObj);
					}
					
					
					
					_log.info("employmentDetail.getWorkSector2()" +employmentDetail.getWorkSectorId2());
					
					
					if(Validator.isNotNull(employmentDetail.getWorkSectorId2()) && employmentDetail.getWorkSectorId2()>0){
						
						_log.info("inside get getWorkSector2  :::::");
						//long workSectorParentId=Long.parseLong(employmentDetail.getWorkSector2());
						WorkSectorItems workSectorItems2 = registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),employmentDetail.getWorkSectorId() );
					     _log.info("workSectorItems2 :: "+workSectorItems2.getItems().size());
							
							if(Validator.isNotNull(workSectorItems2.getItems()) && workSectorItems2.getItems().size()>0) {
								for(WorkSector workSector : workSectorItems2.getItems()) {
									JSONObject object2 =JSONFactoryUtil.createJSONObject();
									object2.put("id", workSector.getId());
									object2.put("value", workSector.getWorkSector());
									jsonArray2.put(object2);
								}
							}
							JSONObject object2 =JSONFactoryUtil.createJSONObject();
							object2.put("id", "other");
							object2.put("value", "Other");
							jsonArray2.put(object2);
						
					}
					
					
					
					
					
					if(Validator.isNotNull(employmentDetail.getWorkSectorId3()) && employmentDetail.getWorkSectorId3()>0){
						
						_log.info("inside get getWorkSector3  :::::");
						//long workSectorParentId=Long.parseLong(employmentDetail.getWorkSector2());
						WorkSectorItems workSectorItems3 = registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),employmentDetail.getWorkSectorId2() );
					     _log.info("workSectorItems3 :: "+workSectorItems3.getItems().size());
							
							if(Validator.isNotNull(workSectorItems3.getItems()) && workSectorItems3.getItems().size()>0) {
								for(WorkSector workSector2 : workSectorItems3.getItems()) {
									JSONObject object3 =JSONFactoryUtil.createJSONObject();
									object3.put("id", workSector2.getId());
									object3.put("value", workSector2.getWorkSector());
									jsonArray3.put(object3);
								}
							}
							JSONObject object3 =JSONFactoryUtil.createJSONObject();
							object3.put("id", "other");
							object3.put("value", "Other");
							jsonArray3.put(object3);
						
					}
				}
				
				if(Validator.isNotNull(employmentDetail) && employmentDetail.getId()>0) {
					jsonObject.put("isValid", Boolean.TRUE);
					ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
					jsonObject.put("workDetail", ow.writeValueAsString(employmentDetail));
					jsonObject.put("workSectorData", jsonArray.toJSONString());
					jsonObject.put("workSectorData2", jsonArray2.toJSONString());
					jsonObject.put("workSectorData3", jsonArray3.toJSONString());
				}
			}
			_log.info("Serversource Response JSON : "+jsonObject);
			
			resourceResponse.getWriter().print(jsonObject.toJSONString());
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error ::, "+e.getMessage());
			return Boolean.TRUE;
		}
}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;	
}

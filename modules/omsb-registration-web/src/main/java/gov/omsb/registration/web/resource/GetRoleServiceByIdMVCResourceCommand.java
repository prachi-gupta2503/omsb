package gov.omsb.registration.web.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.GET_REGISTRATION_ROLE_SERVICE_SR
	    }, 
	    service = MVCResourceCommand.class 
)
public class GetRoleServiceByIdMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(GetRoleServiceByIdMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("GetRoleServiceByIdMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long id = ParamUtil.getLong(resourceRequest, "id");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			
			if(id>0) {
				UserMetadata userMetadata = registrationUtil.getItems(themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + id, UserMetadata.class);
				
				if(Validator.isNotNull(userMetadata)) {
				try {
					userMetadata.setRoleName(RoleLocalServiceUtil.getRole(userMetadata.getRoleId()).getName());
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
			
				long programTypeId=0;	
				_log.info("userMetadata.getProgramId() :::::"+userMetadata.getProgramId());
				if(Validator.isNotNull(userMetadata.getProgramId())) {
				try {
					 ProgramMaster programMaster=ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId());
					 programTypeId= ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId()).getProgramTypeId();
					 userMetadata.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),"ProgramName",
								themeDisplay.getLocale().toString())      );
				} catch (Exception e) {
					_log.error(e.getMessage());
				}
				userMetadata.setProgramTypeId(programTypeId);
				if(programTypeId>0) {
					try {
						_log.info("ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName() :::"+ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName());
						userMetadata.setProgramTypeName(CommonUtil.getValueByLanguage(ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName(), OmsbRegistrationWebPortletKeys.PROGRAM_TYPE_NAME,
								themeDisplay.getLocale().toString()));
					} catch (PortalException e) {
						_log.error(e.getMessage());
					}
				}
				}
			
				}
				
				
				
			/*	String documentInfoUrl = themeDisplay.getPortalURL()
						+ LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
						+ StringPool.QUESTION + "filter=componentClassRefId"
						+ URLEncoder.encode(" eq " + educationDetail.getId(), DataflowConstants.UTF_8);
				DocumentInfoItem documentInfoItems = CustomObjectMapperUtil.readValue(omsbCommonApi.getData(documentInfoUrl), DocumentInfoItem.class);
				if(Validator.isNotNull(documentInfoItems) && documentInfoItems.getItems().size()>0) {
					DocumentInfo documentInfo = documentInfoItems.getItems().get(0);
					if(Validator.isNotNull(documentInfo.getFileEntryID()) && documentInfo.getFileEntryID()>0) {
						try {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(documentInfo.getFileEntryID());
							String documentURL =DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK);
							documentInfo.setDocumentURL(documentURL);
						} catch (PortalException e) {
							_log.error("Error in  code :::" + e.getMessage());
						}
					}
					educationDetail.setDocumentInfo(documentInfo);
				}	*/			
				if(Validator.isNotNull(userMetadata) && userMetadata.getId()>0) {
					jsonObject.put("isValid", Boolean.TRUE);
					ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
					jsonObject.put("userMetadata", ow.writeValueAsString(userMetadata));
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

package gov.omsb.registration.web.resource;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.servlet.SessionMessages;
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
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.action.SaveWorkDetailsMVCActionCommand;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SAVE_REGISTRATION_WORK_DETAIL
	    },
	    service = MVCResourceCommand.class
	    
)
public class SaveWorkDetailsResourceCommand implements MVCResourceCommand {

	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		logger.info("SaveWorkDetailsMVCActionCommand saveWorkDetail	1 ::::");
		EmploymentDetail employmentDetail = null;
		
		//changes abhi
		
		/*for (int i = 1; i <= 2; i++) {
			String workSectorType = ParamUtil.getString(resourceRequest, "workSectorType_" + i);
			String worksectortypeother = ParamUtil.getString(resourceRequest, "worksectortypeother_" + i);
			
			String workSector = ParamUtil.getString(resourceRequest, "worksector_" + i);
			String worksectorother = ParamUtil.getString(resourceRequest, "worksectorother_" + i);
			
			String firstsubworksector = ParamUtil.getString(resourceRequest, "first-sub-worksector_" + i);
			String worksubsectorother = ParamUtil.getString(resourceRequest, "work_sub_sectorother_" + i);
			
			logger.info("workSectorType :::"+workSectorType);
			logger.info("worksectortypeother :::"+worksectortypeother);
			logger.info("workSector :::"+workSector);
			logger.info("worksectorother :::"+worksectorother);
			logger.info("firstsubworksector :::"+firstsubworksector);
			logger.info("worksubsectorother :::"+worksubsectorother);
			
			//workSectorType_2
			//worksectortypeother_2
			//worksector_2
			//worksectorother_2
			//second-sub-worksector_2
			//work_sub_sectorother_2
			
			String wilayat = ParamUtil.getString(resourceRequest, "wilayats_" + i);
			String designation = ParamUtil.getString(resourceRequest, "designations_" + i);
			String designationother = ParamUtil.getString(resourceRequest, "designationother_" + i);
			Boolean isPrimaryWorkDetail = ParamUtil.getBoolean(resourceRequest, "isPrimary_" + i);
		
		}
		
		*/
		//changes abhi
		
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
			Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(),
					CommonConstants.GUEST_GROUP_KEY);
			long groupId = group.getGroupId();
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long personId = ParamUtil.getLong(resourceRequest, "personId");
			long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
			long employed = ParamUtil.getLong(resourceRequest, "employed");
			String firstDeclareValue = ParamUtil.get(resourceRequest, "declare1", "");
			String secondDeclareValue = ParamUtil.get(resourceRequest, "declare2", "");
			logger.info("firstDeclareValue : " + firstDeclareValue + " second " + secondDeclareValue + " employed : "+ employed);
			
			if(firstDeclareValue.equalsIgnoreCase("on")) {
			employmentDetail = registrationUtil.saveEmploymentDetail(resourceRequest, employmentDetail, uploadPortletRequest, groupId,themeDisplay, personId, lrUserId, employed);
			
			//Update Regis
		      //Update User status
				if(Validator.isNotNull(personId) && personId>0) {
					try {
						PersonalDetailItem personDetailItem=registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
						if(Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size()>0) {
							try {
								PersonalDetail personalDetail=personDetailItem.getItems().get(0);
								personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.WORK_DETAILS);
								
								FileEntry cvDocumentFileEntry = registrationUtil.fileUpload(resourceRequest, themeDisplay, OmsbRegistrationWebPortletKeys.CV_DOCUMENT_FOLDERNAME, "cvDocument");
								if (Validator.isNotNull(cvDocumentFileEntry)) {
									personalDetail.setCvDocumentId(cvDocumentFileEntry.getFileEntryId());
								}
								
								registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);
							} catch (Exception e) {
								logger.error(e.getMessage());
							}
						}
					} catch (Exception e) {
						logger.error(e.getMessage());
					}
				}
			
			
			PersonalDetailItem personDetailItem = registrationUtil.fetchPersonalDetailsByPersonId(personId,themeDisplay);
			logger.info(personDetailItem);
			if (Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size() > 0) {
				try {
					PersonalDetail personalDetail = personDetailItem.getItems().get(0);
					if (firstDeclareValue.equalsIgnoreCase("on")) {
						personalDetail.setDeclaration(true);
					}
					else {
						personalDetail.setDeclaration(false);
					}
					if (secondDeclareValue.equalsIgnoreCase("on")) {
						personalDetail.setAgreed(true);
					}
					else {
						personalDetail.setAgreed(false);
					}

					registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
							personalDetail);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
			}
		} catch (Exception e) {
			logger.info("unable to save the work detail ");
		}
		
//		if (Validator.isNotNull(employmentDetail)) {
//			resourceResponse.getRenderParameters().setValue("lrUserId", ParamUtil.getString(resourceRequest, "lrUserId"));
//			resourceResponse.getRenderParameters().setValue("personId", ParamUtil.getString(resourceRequest, "personId"));
			boolean isNext = ParamUtil.getBoolean(resourceRequest, "isNext");
			logger.info("isNext::: " + isNext);
			if (!isNext) {
//				resourceResponse.getRenderParameters().setValue("mvcRenderCommandName",
//						MVCCommands.VIEW_REGISTRATION_WORK_DETAILS);
			} else {
//				resourceResponse.getRenderParameters().setValue("mvcRenderCommandName",
//						MVCCommands.VIEW_REGISTRATION_ROLE_SERVICE);
			}
			SessionMessages.add(resourceRequest,"success-work-detail");
	//		SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    //			SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		//}
			return isNext;
	}

	@Reference(unbind = "-")
	private RegistrationUtil registrationUtil;

	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	private Log logger = LogFactoryUtil.getLog(SaveWorkDetailsMVCActionCommand.class);


}

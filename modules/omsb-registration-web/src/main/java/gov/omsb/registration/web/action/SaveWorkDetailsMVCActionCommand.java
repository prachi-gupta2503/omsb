package gov.omsb.registration.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(property = { "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name=" + MVCCommands.ADD_WORK_DETAIL }, service = MVCActionCommand.class)
public class SaveWorkDetailsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("SaveWorkDetailsMVCActionCommand saveWorkDetail	1 ::::");
		EmploymentDetail employmentDetail = null;
		
		//changes abhi
		
		/*for (int i = 1; i <= 2; i++) {
			String workSectorType = ParamUtil.getString(actionRequest, "workSectorType_" + i);
			String worksectortypeother = ParamUtil.getString(actionRequest, "worksectortypeother_" + i);
			
			String workSector = ParamUtil.getString(actionRequest, "worksector_" + i);
			String worksectorother = ParamUtil.getString(actionRequest, "worksectorother_" + i);
			
			String firstsubworksector = ParamUtil.getString(actionRequest, "first-sub-worksector_" + i);
			String worksubsectorother = ParamUtil.getString(actionRequest, "work_sub_sectorother_" + i);
			
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
			
			String wilayat = ParamUtil.getString(actionRequest, "wilayats_" + i);
			String designation = ParamUtil.getString(actionRequest, "designations_" + i);
			String designationother = ParamUtil.getString(actionRequest, "designationother_" + i);
			Boolean isPrimaryWorkDetail = ParamUtil.getBoolean(actionRequest, "isPrimary_" + i);
		
		}
		
		*/
		//changes abhi
		
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(),
					CommonConstants.GUEST_GROUP_KEY);
			long groupId = group.getGroupId();
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long personId = ParamUtil.getLong(actionRequest, "personId");
			long lrUserId = ParamUtil.getLong(actionRequest, "lrUserId");
			long employed = ParamUtil.getLong(actionRequest, "employed");
			String firstDeclareValue = ParamUtil.get(actionRequest, "declare1", "");
			String secondDeclareValue = ParamUtil.get(actionRequest, "declare2", "");
			logger.info("firstDeclareValue : " + firstDeclareValue + " second " + secondDeclareValue + " employed : "+ employed);
			
			if(firstDeclareValue.equalsIgnoreCase("on")) {
			employmentDetail = registrationUtil.saveEmploymentDetail(actionRequest, employmentDetail, uploadPortletRequest, groupId,themeDisplay, personId, lrUserId, employed);
			
			//Update Regis
		      //Update User status
				if(Validator.isNotNull(personId) && personId>0) {
					try {
						PersonalDetailItem personDetailItem=registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
						if(Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size()>0) {
							try {
								PersonalDetail personalDetail=personDetailItem.getItems().get(0);
								personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.WORK_DETAILS);
								
								FileEntry cvDocumentFileEntry = registrationUtil.fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.CV_DOCUMENT_FOLDERNAME, "cvDocument");
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
			actionResponse.getRenderParameters().setValue("lrUserId", ParamUtil.getString(actionRequest, "lrUserId"));
			actionResponse.getRenderParameters().setValue("personId", ParamUtil.getString(actionRequest, "personId"));
			boolean isNext = ParamUtil.getBoolean(actionRequest, "isNext");
			logger.info("isNext::: " + isNext);
			if (!isNext) {
				actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
						MVCCommands.VIEW_REGISTRATION_WORK_DETAILS);
			} else {
				actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
						MVCCommands.VIEW_REGISTRATION_ROLE_SERVICE);
			}
			SessionMessages.add(actionRequest,"success-work-detail");
	//		SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    //			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		//}
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

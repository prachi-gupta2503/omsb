package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.COMMENTS_PARAM;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.COVERING_LETTER;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.COVERING_LETTER_FOLDER_NAME;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.CURRICULAM_VITAE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.CURRICULAM_VITAE_FOLDER_NAME;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EC_MEMBER_REQUEST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.MEMBERSHIP_ROLE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PERSON_ID;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PROGRAM_NAME;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.SAVE_EC_MEMBERSHIP_REQUEST;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.dto.DocumentInfoItem;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestStateLocalService;
import gov.omsb.tms.service.EcMemberRequestStatusLocalService;

/**
 * @author jinal.patel
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name=" + SAVE_EC_MEMBERSHIP_REQUEST }, service = MVCActionCommand.class)
public class AddEcMembershipRequestMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(AddEcMembershipRequestMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("***********************Add new ec member request action called**************************");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// String redirectURL = ParamUtil.getString(actionRequest, REDIRECT_URL);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String programName = ParamUtil.getString(actionRequest, PROGRAM_NAME);
		String personId = ParamUtil.getString(actionRequest, PERSON_ID);
		String potentialMemberLruserId = ParamUtil.getString(actionRequest, "lrUserId");
		String membershipRole = ParamUtil.getString(actionRequest, MEMBERSHIP_ROLE);
		File coveringLetter = uploadPortletRequest.getFile(COVERING_LETTER);
		File curriculamVitae = uploadPortletRequest.getFile(CURRICULAM_VITAE);
		String coveringLetterName = uploadPortletRequest.getFileName(COVERING_LETTER);
		String curriculamVitaeName = uploadPortletRequest.getFileName(CURRICULAM_VITAE);
		String comments = ParamUtil.getString(actionRequest, COMMENTS_PARAM);
		log.info(" potentialMemberLruserId--------" + potentialMemberLruserId);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		serviceContext.setAddGuestPermissions(true);
		long lruserId = Long.parseLong(potentialMemberLruserId);

		String portletId = themeDisplay.getPortletDisplay().getId();

		long requestId = CounterLocalServiceUtil.increment(EcMemberRequest.class.getName());
		EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.createEcMemberRequest(requestId);
		setEcMemberRequestObject(actionRequest, themeDisplay, programName, personId, membershipRole, coveringLetter,
				curriculamVitae, coveringLetterName, curriculamVitaeName, serviceContext, ecMemberRequest, comments,
				potentialMemberLruserId);

		ecMemberRequest.setUserId(themeDisplay.getUserId());
		PersonalDetail personalDetail = membershipUtil.fetchPersonalDetailsByPersonId(themeDisplay,
				lruserId);
		log.info(" personalDetail--------" + personalDetail.getPassportPhotoId());
		if (personalDetail.getPassportPhotoId() > 0) {
			FileEntry passportEntry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getPassportPhotoId());
			DocumentInfoItem passportDocument = addDocumentInfo(ecMemberRequest, passportEntry,
					themeDisplay.getScopeGroupId());
			ecMemberRequest.setPassportCopyId(passportDocument.getId());
		}
		if (personalDetail.getCivilCardFrontPhotoId() > 0) {
			FileEntry civilIdEntry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
			DocumentInfoItem civilIdDocument = addDocumentInfo(ecMemberRequest, civilIdEntry,
					themeDisplay.getScopeGroupId());
			ecMemberRequest.setNationalIdCopyId(civilIdDocument.getId());
		}
		// Create a PortletURL for the render phase of the current portlet
		PortletURL renderURL = PortletURLFactoryUtil.create(actionRequest, portletId, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		renderURL.getRenderParameters().setValue("mvcRenderCommandName",
				ECMembershipRequestPortletKeys.VIEW_EC_MEMBER_DETAILS);
		renderURL.getRenderParameters().setValue(ECMembershipRequestPortletKeys.EC_MEMBERSHIP_REQUEST_ID,
				String.valueOf(requestId));

		ecMemberRequest = membershipUtil.createNewRequest(ecMemberRequest, themeDisplay.getUser(),
				renderURL.toString());
		ecMemberRequest = ecMemberRequestLocalService.fetchEcMemberRequest(requestId);

		SessionMessages.add(actionRequest, "ec-request-added-successfully");
		// actionResponse.sendRedirect(redirectURL);
	}

	@SuppressWarnings("deprecation")
	private void setEcMemberRequestObject(ActionRequest actionRequest, ThemeDisplay themeDisplay, String programName,
			String personId, String membershipRole, File coveringLetter, File curriculamVitae,
			String coveringLetterName, String curriculamVitaeName, ServiceContext serviceContext,
			EcMemberRequest ecMemberRequest, String comments, String potentialMemberLruserId) throws PortalException {
		if (Validator.isNotNull(coveringLetter)) {

			String title = membershipUtil.generateFileName(coveringLetterName);
			FileEntry coveringLetterFileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
					themeDisplay.getScopeGroupId(),
					createCoveringLetterFolder(actionRequest, themeDisplay).getFolderId(), title,
					MimeTypesUtil.getContentType(coveringLetter), title, coveringLetterName, StringPool.BLANK,
					coveringLetter, serviceContext);
			ecMemberRequest.setCoveringLetterId(coveringLetterFileEntry.getFileEntryId());
		}
		if (Validator.isNotNull(curriculamVitae)) {

			String title = membershipUtil.generateFileName(curriculamVitaeName);
			FileEntry curriculamVitaeFileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
					themeDisplay.getScopeGroupId(),
					createCurriculamVitaeFolder(actionRequest, themeDisplay).getFolderId(), title,
					MimeTypesUtil.getContentType(curriculamVitae), title, curriculamVitaeName, StringPool.BLANK,
					curriculamVitae, serviceContext);
			ecMemberRequest.setCvId(curriculamVitaeFileEntry.getFileEntryId());
		}
		if (Validator.isNotNull(potentialMemberLruserId) && !potentialMemberLruserId.isBlank()) {
			ecMemberRequest.setPotentialEcMemberLruserid(Long.valueOf(potentialMemberLruserId));
		}
		ecMemberRequest.setCompanyId(themeDisplay.getCompanyId());
		ecMemberRequest.setCreateDate(new Date());
		ecMemberRequest.setGroupId(themeDisplay.getScopeGroupId());
		ecMemberRequest.setModifiedDate(new Date());
		if (Validator.isNotNull(personId) && !personId.isBlank()) {
			ecMemberRequest.setPotentialEcMemberId(Long.valueOf(personId));
		}
		ecMemberRequest.setPotentialEcMemberRoleId(Long.valueOf(membershipRole));
		ecMemberRequest.setProgramId(Long.valueOf(programName));
		ecMemberRequest.setComments(comments, themeDisplay.getLocale());
	}

	public static DLFolder createCoveringLetterFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		DLFolder ecMemberRequestFolder = createDLFolder(actionRequest, themeDisplay, false,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, EC_MEMBER_REQUEST, StringPool.BLANK, false);
		DLFolder coveringLetterFolder = createDLFolder(actionRequest, themeDisplay, false,
				ecMemberRequestFolder.getFolderId(), COVERING_LETTER_FOLDER_NAME, StringPool.BLANK, false);
		return coveringLetterFolder;
	}

	public static DLFolder createCurriculamVitaeFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		DLFolder ecMemberRequestFolder = createDLFolder(actionRequest, themeDisplay, false,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, EC_MEMBER_REQUEST, StringPool.BLANK, false);
		DLFolder curriculamVitaeFolder = createDLFolder(actionRequest, themeDisplay, false,
				ecMemberRequestFolder.getFolderId(), CURRICULAM_VITAE_FOLDER_NAME, StringPool.BLANK, false);
		return curriculamVitaeFolder;
	}

	public static DLFolder createDLFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay, boolean mountPoint,
			long parentFolderId, String folderName, String description, boolean hidden) {
		DLFolder dlFolder = null;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			serviceContext.setAddGuestPermissions(true);
			dlFolder = fetchFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
			if (Validator.isNull(dlFolder)) {
				dlFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), mountPoint, parentFolderId,
						folderName, description, hidden, serviceContext);
			}
		} catch (Exception e1) {
			log.error("Error while creating folder");
		}
		return dlFolder;
	}

	public static DLFolder fetchFolder(long groupId, long parentFolderId, String name) {
		DLFolder dlFolder = null;
		try {
			dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, name);
		} catch (Exception e) {
			log.error("Error while fetching DL folder - " + name);
		}
		return dlFolder;
	}

	private DocumentInfoItem addDocumentInfo(EcMemberRequest ecMemberRequest, FileEntry fileEntry, long groupId) {
		DocumentInfoItem saveDocumentInfo = new DocumentInfoItem();
		saveDocumentInfo.setId(saveDocumentInfo.getId());
		saveDocumentInfo.setdFFileName(fileEntry.getDescription());
		saveDocumentInfo.setFileEntryID(fileEntry.getFileEntryId());
		saveDocumentInfo.setPersonId(ecMemberRequest.getPotentialEcMemberId());
		DocumentInfoItem documentInfo = saveDocumentInfo(saveDocumentInfo, groupId);
		return documentInfo;
	}

	private DocumentInfoItem saveDocumentInfo(DocumentInfoItem documentInfoItem, long groupId) {
		String documentInfoUrl = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, groupId);
		log.info("documentInfoUrl" + documentInfoUrl);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		log.info("headers" + headers);
		String documentDetailMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoItem, null);
		log.info("documentDetailMapper" + documentDetailMapper);
		String response = httpConnector.executePost(documentInfoUrl, documentDetailMapper, headers);
		log.info("response" + response);
		return CustomObjectMapperUtil.readValue(response, DocumentInfoItem.class);
	}

	private String generateScopeListURL(String requestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + requestsUrl.replace("{scope-id}", String.valueOf(siteId));
	}

	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

	@Reference
	private EcMemberRequestStatusLocalService ecMemberRequestStatusLocalService;

	@Reference
	private EcMemberRequestStateLocalService ecMemberRequestStateLocalService;

	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector httpConnector;
}

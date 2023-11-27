package omsb.vehpc.equivalency.mvc.commands.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.font.FontProvider;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EquivalencyRequestCertificate;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificate;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevelItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatus;
import omsb.vehpc.equivalency.dto.web.EquivalencyStatus;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.CertificateHtmlConstants;
import omsb.vehpc.equivalency.web.constants.EquivalencyCertificateConstants;
import omsb.vehpc.equivalency.web.constants.EquivalencyStatusConstants;
import omsb.vehpc.equivalency.web.constants.EquivalencyWorkflowStatusEnum;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.WORKFLOW_UPDATE }, service = MVCActionCommand.class)
public class WorkFlowUpdateMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("Workflow update>>>>>>>>>>>>>>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String markInsufficientWftransitionName = ParamUtil.getString(actionRequest,
				"markInsufficientWftransitionName");
		long markInsufficientEqId = ParamUtil.getLong(actionRequest, "markInsufficientEqId");

		String initiationWfTransitionName = ParamUtil.getString(actionRequest, "initiationWfTransitionName");
		long initiateEqId = ParamUtil.getLong(actionRequest, "initiateEqId");
		String comments = ParamUtil.getString(actionRequest, "comments");
		String htmlCertificateDiv = ParamUtil.getString(actionRequest, "htmlDivData");
		LOGGER.info("WorkFlowUpdateMVCActionCommand : : :comments: : " + comments);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long siteId = themeDisplay.getLayout().getGroupId();

		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		String className = getObjectClassName(themeDisplay.getCompanyId());
		String intiateFileName = "caseReportFile";
		long initiatePersonId = ParamUtil.getLong(actionRequest, "initiatePersonId");
		String assignWfTransitionName = ParamUtil.getString(actionRequest, "assignWfTransitionName");
		long assignEqId = ParamUtil.getLong(actionRequest, "assignEqId");

		/* VEHPC Section parameters */
		String equatTransitionName = ParamUtil.getString(actionRequest, "equatTransitionName");
		long equateEquivalencyId = ParamUtil.getLong(actionRequest, "equateEquivalencyId");
		long totalCountOfCertificates = ParamUtil.getLong(actionRequest, "totalCountOfCertificates");
		boolean isAdminEquating = ParamUtil.getBoolean(uploadPortletRequest, "isAdmin");

		LOGGER.info("totalCountOfCertificates >>>>>" + totalCountOfCertificates + ";;;" + isAdminEquating);
		LOGGER.info("initiatePersonId >>>>>" + initiatePersonId + " and equivalencyId is ?? " + assignEqId);
		long classPk = 0;
		if (markInsufficientEqId > 0) {
			classPk = markInsufficientEqId;
		} else if (initiateEqId > 0) {
			classPk = initiateEqId;
		} else if (equateEquivalencyId > 0) {
			classPk = equateEquivalencyId;
		} else if (assignEqId > 0) {
			classPk = assignEqId;
		}
		LOGGER.info("classPk >>>>>" + classPk);
		String transitionName = StringPool.BLANK;
		if (!markInsufficientWftransitionName.equalsIgnoreCase(StringPool.BLANK)) {
			transitionName = markInsufficientWftransitionName;
		} else if (!initiationWfTransitionName.equalsIgnoreCase(StringPool.BLANK)) {
			transitionName = initiationWfTransitionName;
		} else if (!equatTransitionName.equalsIgnoreCase(StringPool.BLANK)) {
			transitionName = equatTransitionName;
		} else if (!assignWfTransitionName.equalsIgnoreCase(StringPool.BLANK)) {
			transitionName = assignWfTransitionName;
		}
		LOGGER.info("transitionName ?? " + transitionName + " userId ??  " + userId);
		// get Logged In Role Name
//		boolean isAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN,
//				themeDisplay.getUserId());
//		String roleName;
//		if (!isAdmin) {
//			roleName = RoleNameConstants.VEHPC_COMMITTEE;
//		} else {
//			roleName = RoleNameConstants.VEHPC_ADMIN;
//		}

		EquivalencyStatus equivalencyStatus = new EquivalencyStatus();

		/**
		 * Object Mapper Initialization
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		/**
		 * Basic Auth and Header Infomation
		 */
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();

		/**
		 * Workflow Task Excution based on Transition
		 */
		WorkflowInstanceLink wil;
		try {
			wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, groupId, className, classPk);
			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
					wil.getWorkflowInstanceId());
			Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();

			List<Integer> logTypes_assign = new ArrayList<Integer>();
			logTypes_assign.add(WorkflowLog.TASK_ASSIGN);
			List<WorkflowLog> workflowLogs_assign = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(companyId,
					wil.getWorkflowInstanceId(), logTypes_assign, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
			if (workflowLogs_assign.size() > 0) {
				long workflowTaskId = workflowLogs_assign.get(workflowLogs_assign.size() - 1).getWorkflowTaskId();
				if (transitionName.equalsIgnoreCase("assignToMe")) {
					LOGGER.info("assignToMe...");
					if (workflowLogs_assign.get(workflowLogs_assign.size() - 1).getUserId() <= 0) {
						WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, userId, workflowTaskId,
								themeDisplay.getUserId(), "", new Date(), workflowContext);
					}

				} else {
					LOGGER.info("completeWorkflowTask...");
					if (!transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.RESUBMIT.getText())) {
						try {
							WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, userId, workflowTaskId,
									themeDisplay.getUserId(), "", new Date(), workflowContext);
						} catch (Exception e) {
							LOGGER.error("Exception while assign workflow to user ", e);
						}
					}
					WorkflowTaskManagerUtil.completeWorkflowTask(companyId, userId, workflowTaskId, transitionName,
							comments, workflowContext);
					LOGGER.info("completeWorkflowTask...");

					if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.INITIATE.getText())) {

						equivalencyStatus.setKey(EquivalencyStatusConstants.INITIATED_KEY);
						equivalencyStatus.setName(EquivalencyStatusConstants.INITIATED);

						DocumentInfo fileUploadDetails = new DocumentInfo();
						fileUploadDetails.setPersonId((int) initiatePersonId);
						fileUploadDetails.setEquivalencyRequestId(classPk);
						fileUploadDetails.setDocumentType(OmsbVehpcEquivalencyWebPortletKeys.CASE_REPORT);

						uploadCaseReportFile(intiateFileName, uploadPortletRequest, themeDisplay, siteId, objectMapper,
								headersInfo, fileUploadDetails);

						LOGGER.info("IN Initiate Condition>>>>>>>>>.");

					} else if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.EQUATE.getText())) {

						equivalencyStatus.setKey(EquivalencyStatusConstants.EQUATED_KEY);
						equivalencyStatus.setName(EquivalencyStatusConstants.EQUATED);

						if (totalCountOfCertificates > 0 && !isAdminEquating) {
							for (int i = 0; i < totalCountOfCertificates; i++) {
								long documentInfoId = ParamUtil.getLong(uploadPortletRequest, "documentInfoId" + i);
								String equivalencyLevelCommittee = ParamUtil.getString(uploadPortletRequest,
										"equivalencyLevel" + i);
								String equivalencyLevelComments = ParamUtil.getString(uploadPortletRequest,
										"equivalencyLevelComments" + i);
								comments = equivalencyLevelComments;
								EquivalencyLevel equivalencyLevel = new EquivalencyLevel();
								equivalencyLevel.setKey(equivalencyLevelCommittee);
								equivalencyLevel.setName(equivalencyLevelCommittee);

								equivalencyUtil.saveEquivalencyDecision(themeDisplay, equivalencyLevelComments,
										documentInfoId, classPk, equivalencyLevel, "", equivalencyStatus);
							}
						}
					} else if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.COMPLETE.getText())) {
						equivalencyStatus.setKey(EquivalencyStatusConstants.COMPLETED_KEY);
						equivalencyStatus.setName(EquivalencyStatusConstants.COMPLETED);

						if (totalCountOfCertificates > 0) {
							for (int i = 0; i < totalCountOfCertificates; i++) {
								long documentInfoId = ParamUtil.getLong(uploadPortletRequest, "documentInfoId" + i);
								String equivalencyLevelAdmin = ParamUtil.getString(uploadPortletRequest,
										"equivalencyLevelAdmin" + i);
								String equivalencyLevelReason = ParamUtil.getString(uploadPortletRequest,
										"equivalencyLevelReason" + i);
								String equivalencyLevelAdminComments = ParamUtil.getString(uploadPortletRequest,
										"equivalencyLevelAdminComments" + i);
								String equivalencyLevelOtherReason = ParamUtil.getString(uploadPortletRequest,
										"equivalencyLevelOtherReason" + i);
								comments = equivalencyLevelAdminComments;
								EquivalencyLevel equivalencyLevel = new EquivalencyLevel();
								equivalencyLevel.setKey(equivalencyLevelAdmin);
								equivalencyLevel.setName(equivalencyLevelAdmin);

								LOGGER.info("equivalencyLevelAdmin >>>>>" + equivalencyLevelAdmin);
								LOGGER.info("equivalencyLevelAdminComments >>>>>" + equivalencyLevelAdminComments);
								equivalencyUtil.saveEquivalencyDecision(themeDisplay, equivalencyLevelAdminComments,
										documentInfoId, classPk, equivalencyLevel, equivalencyLevelReason,
										equivalencyStatus);

								// Add Equivalency Decision Level

								EquivalencyDecisionLevel equivalencyDecisionLevel = new EquivalencyDecisionLevel();
								equivalencyDecisionLevel.setComments(comments);
								equivalencyDecisionLevel.setDocumentInfoId(documentInfoId);
								equivalencyDecisionLevel.setEquivalencyLevelId(equivalencyLevel);
								equivalencyDecisionLevel.setEqRequestId(classPk);
								equivalencyDecisionLevel.setEquivalencyLevelReason(equivalencyLevelReason);
								equivalencyDecisionLevel.setEquivalencyLevelOtherReason(equivalencyLevelOtherReason);
								EquivalencyDecisionLevel level = addEquivalencyDecisionLevel(siteId, headersInfo,
										equivalencyDecisionLevel, objectMapper);
								if (Validator.isNotNull(level)) {
									equivalencyUtil.uploadDocuments(classPk, 0, themeDisplay, actionRequest,
											initiatePersonId, level.getId(), "additionalAttachment" + i,
											OmsbVehpcEquivalencyWebPortletKeys.ADMIN_FINAL_LEVEL_DOCUMENTS_TYPE);
									level.getId();
								}
							}

						}

		/**
		 * Generate Certificate
		 */
//						DLFileEntry fileEntry = null;
//						try {
//							fileEntry = createDecisionLevelCertificate(actionRequest, classPk);
//						} catch (Exception e) {
//							LOGGER.error(e.getMessage(), e);
//						}
		
					DLFileEntry fileEntry = null;
					String htmlData = CertificateHtmlConstants.HTML_HEAD + htmlCertificateDiv + CertificateHtmlConstants.HTML_FOOT;
					if (Validator.isNotNull(htmlCertificateDiv) && !htmlCertificateDiv.equals(StringPool.BLANK)) {
						fileEntry = createDecisionLevelCertificate(actionRequest,classPk, htmlData);
					} else {
						long folderId = 0;
						ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
						File file = uploadPortletRequest.getFile("certificateUploadFile");
						try (InputStream is = new FileInputStream(file)) {
							serviceContext.setAddGroupPermissions(true);
							serviceContext.setAddGuestPermissions(true);
							long timeStamp = new Date().getTime();
							String fileName = EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + "_" + timeStamp + ".pdf";
							fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(),
									themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), folderId, fileName,
									ContentTypes.APPLICATION_PDF,
									EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + "_" + timeStamp,
									EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_URL,
									EquivalencyCertificateConstants.CERTIFICATE, StringPool.BLANK, 0L, null, file, is,
									file.length(), null, null, serviceContext);
			
						} catch (Exception e) {
							LOGGER.error("Exception while uploading the equivalency certificate:::::", e);
						}
					}

						/**
						 * Add Certificate to Table
						 */
						if (Validator.isNotNull(fileEntry)) {
							EquivalencyCertificate equivalencyCertificate = new EquivalencyCertificate();
							equivalencyCertificate.setEquivalencyRequestId(classPk);
							equivalencyCertificate.setFileEntryId(String.valueOf(fileEntry.getFileEntryId()));
							equivalencyCertificate.setFileName(fileEntry.getFileName());

							addCertificateToEquivalencyCetrificateTable(siteId,
									equivalencyCertificate, headersInfo, objectMapper);
						}
					} else if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.INSUFFICENT.getText())) {
						equivalencyStatus.setKey(EquivalencyStatusConstants.INSUFFICIENT_KEY);
						equivalencyStatus.setName(EquivalencyStatusConstants.INSUFFICIENT);
					} else if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.RESUBMIT.getText())) {
						// to be uncommented
						equivalencyStatus.setKey(EquivalencyStatusConstants.CREATED_KEY);
						equivalencyStatus.setName(EquivalencyStatusConstants.CREATED);
						updateResubmitCertificates(themeDisplay, uploadPortletRequest, assignEqId);
					}

					// Save Equivalenty Request Status if Transaction is not EQUATE OR COMPLETE
					String res = StringPool.BLANK;
					if (!transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.EQUATE.getText())
							&& !transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.COMPLETE.getText())) {
						EquivalencyRequestStatus equivalencyRequestStatus = new EquivalencyRequestStatus();
						equivalencyRequestStatus.setComments(comments);
						LOGGER.info(
								"equivalencyRequestStatus.getComments()equivalencyRequestStatus.getComments()LLLLLLLLLLLLLL"
										+ equivalencyRequestStatus.getComments());
						equivalencyRequestStatus.setCommenterUserId(themeDisplay.getUserId());
						equivalencyRequestStatus.setEquivalencyRequestId(classPk);
						equivalencyRequestStatus.setEquivalencyStatusId(equivalencyStatus);

						String equivalencyRequestStatusPayload = "";
						try {
							equivalencyRequestStatusPayload = objectMapper.writeValueAsString(equivalencyRequestStatus);
						} catch (JsonProcessingException e) {
							LOGGER.error(e.getMessage());
						}

						String officialRequestfileUploadDetailURL = generateScopeListURL(
								LRObjectURL.EQUIVALENCY_REQUEST_STATUS_URL, siteId);

						res = oMSBHttpConnector.executePost(officialRequestfileUploadDetailURL,
								equivalencyRequestStatusPayload, headersInfo);
						LOGGER.info("Equivalency Status key is >>>>>>>>>" + equivalencyStatus.getKey());
					}

					EquivalencyRequestStatus status = CustomObjectMapperUtil.readValue(res,
							EquivalencyRequestStatus.class);
					if (Validator.isNotNull(status)
							&& transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.INITIATE.getText())) {
						equivalencyUtil.uploadDocuments(classPk, 0, themeDisplay, actionRequest, initiatePersonId,
								status.getId(), "initiateMultiFile",
								OmsbVehpcEquivalencyWebPortletKeys.ADMIN_SEND_TO_COMMITTEE_DOCUMENTS_TYPE);
					} else if (Validator.isNotNull(status)
							&& transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.INSUFFICENT.getText())) {
						equivalencyUtil.uploadDocuments(classPk, 0, themeDisplay, actionRequest, initiatePersonId,
								status.getId(), "insufMultiFile",
								OmsbVehpcEquivalencyWebPortletKeys.ADMIN_INSUFFICIENT_DOCUMENTS_TYPE);
					}

					updateEquivalencyRequestById(siteId, classPk, headersInfo, equivalencyStatus.getKey(), companyId);
					LOGGER.info("res" + res);

				}
			}

			// WF Notifications start
			if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.INSUFFICENT.getText())) {
				LOGGER.info("INSUFFFICIEENT >>>>>>>>>>>>>>>>>>>>>> " + classPk);
				EquivalencyRequest eqRequest = equivalencyUtil.getEquivalencyRequestById(classPk);
				if (Validator.isNotNull(eqRequest)) {
					long employerUserId = eqRequest.getEmployerUserID();
					JSONArray getPersonJsonArrayResponse = JSONFactoryUtil
							.createJSONObject(equivalencyUtil.getPersonById(eqRequest.getPersonId(),
									themeDisplay.getScopeGroupId()))
							.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
					if (Validator.isNotNull(getPersonJsonArrayResponse.getJSONObject(0).getString("lrUserId"))) {
						String lrUserId = getPersonJsonArrayResponse.getJSONObject(0).getString("lrUserId");
						equivalencyUtil.sendEquivalencyNotificationToUser(themeDisplay, Long.valueOf(lrUserId),
								OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_INSUFFICIENT_NOTIFICATION);
						LOGGER.info("INSUFFFICIEENT >>>>>>>>>>>>>>>>>>>>> " + lrUserId);
					}

					LOGGER.info("INSUFFFICIEENT >>>>>>>>>>>>>>>>>>>>> " + employerUserId);
					equivalencyUtil.sendEquivalencyNotificationToUser(themeDisplay, employerUserId,
							OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_INSUFFICIENT_NOTIFICATION);

				}

			} else if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.RESUBMIT.getText())) {
				LOGGER.info("REESUBMIIT >>>>>>>>>>>>>>>>>>>>>> ");
				equivalencyUtil.sendEquivalencyNotification(themeDisplay, RoleNameConstants.VEHPC_ADMIN,
						OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_RESUBMIT_NOTIFICATION);

			} else if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.INITIATE.getText())) {
				LOGGER.info("INIITIATED >>>>>>>>>>>>>>>>>>>>>> ");
				equivalencyUtil.sendEquivalencyNotification(themeDisplay, RoleNameConstants.VEHPC_COMMITTEE,
						OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_SEND_COMMITTEE_NOTIFICATION);

			} else if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.EQUATE.getText())) {
				LOGGER.info("EQUAATEDD >>>>>>>>>>>>>>>>>>>>>> ");
				equivalencyUtil.sendEquivalencyNotification(themeDisplay, RoleNameConstants.VEHPC_ADMIN,
						OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_SEND_EQUATE_NOTIFICATION_ADMIN);

			} else if (transitionName.equalsIgnoreCase(EquivalencyWorkflowStatusEnum.COMPLETE.getText())) {
				LOGGER.info("COMPLEETED >>>>>>>>>>>>>>>>>>>>>> " + classPk);
				EquivalencyRequest eqRequest = equivalencyUtil.getEquivalencyRequestById(classPk);
				if (Validator.isNotNull(eqRequest)) {
					long employerUserId = eqRequest.getEmployerUserID();
					JSONArray getPersonJsonArrayResponse = JSONFactoryUtil
							.createJSONObject(equivalencyUtil.getPersonById(eqRequest.getPersonId(),
									themeDisplay.getScopeGroupId()))
							.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
					if (Validator.isNotNull(getPersonJsonArrayResponse.getJSONObject(0).getString("lrUserId"))) {
						String lrUserId = getPersonJsonArrayResponse.getJSONObject(0).getString("lrUserId");
						equivalencyUtil.sendEquivalencyNotificationToUser(themeDisplay, Long.valueOf(lrUserId),
								OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_COMPLETED_NOTIFICATION);
						LOGGER.info("COMPLEETED >>>>>>>>>>>>>>>>>>>>> " + lrUserId);
					}

					LOGGER.info("COMPLEETED >>>>>>>>>>>>>>>>>>>>> " + employerUserId);
					equivalencyUtil.sendEquivalencyNotificationToUser(themeDisplay, employerUserId,
							OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_COMPLETED_NOTIFICATION);

				}

			}

			// WF Notifications ends

		} catch (PortalException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	private void updateResubmitCertificates(ThemeDisplay themeDisplay, UploadPortletRequest uploadPortletRequest,
			long equivalencyRequestId) {
		LOGGER.info("calling updateResubmitCertificates");
		long certificateToBeEvaluatedCount = ParamUtil.getLong(uploadPortletRequest, "certificateToBeEvaluatedCount");
		long otherDocumentCount = ParamUtil.getLong(uploadPortletRequest, "otherDocumentCount");
		long personId = 0;

		EquivalencyRequest eqRequest = equivalencyUtil.getEquivalencyRequestById(equivalencyRequestId);
		if (Validator.isNotNull(eqRequest)) {
			personId = eqRequest.getPersonId();
		}

		// List<EducationalDetailItem> educationDetailItemList =
		// equivalencyUtil.getEducationByEquivalencyId(themeDisplay,
		// equivalencyRequestId);
		// deleteEquivalencyEducationdata(themeDisplay, educationDetailItemList);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();

		LOGGER.info("personId is ?? " + personId);
		LOGGER.info("calling certificateToBeEvaluatedCount is ?? " + certificateToBeEvaluatedCount);
		LOGGER.info("equivalencyId is ?? " + equivalencyRequestId);

		List<DocumentInfo> documentInfoItemsList = getDocumentInfoListByEqRequestId(themeDisplay, equivalencyRequestId,
				objectMapper);
		DocumentInfo certificateToEvaFileUploadDetails = new DocumentInfo();
		certificateToEvaFileUploadDetails.setPersonId(personId);
		certificateToEvaFileUploadDetails.setEquivalencyRequestId(equivalencyRequestId);
		DocumentInfo otherDocumentFileUploadDetails = new DocumentInfo();
		otherDocumentFileUploadDetails.setPersonId(personId);
		otherDocumentFileUploadDetails.setEquivalencyRequestId(equivalencyRequestId);
		try {
			equivalencyUtil.addCertificatesToEvaluatedDocuments(personId, certificateToBeEvaluatedCount,
					uploadPortletRequest, themeDisplay, objectMapper, headersInfo, certificateToEvaFileUploadDetails,
					equivalencyRequestId);

			if (otherDocumentCount > 0) {
				addOtherDocuments(otherDocumentCount, uploadPortletRequest, themeDisplay,
						themeDisplay.getScopeGroupId(), objectMapper, headersInfo, otherDocumentFileUploadDetails,
						equivalencyRequestId);
			}

			deleteEquivalencyDocumentdata(themeDisplay, documentInfoItemsList);
		} catch (JsonProcessingException | JSONException e) {
			LOGGER.error("Exception while calling updateResubmitCertificates method :: ", e);
		}
	}

	private void addOtherDocuments(long noOfDocument, UploadPortletRequest uploadPortletRequest,
			ThemeDisplay themeDisplay, long siteId, ObjectMapper objectMapper, Map<String, String> headersInfo,
			DocumentInfo OtherDocumentFileUploadDetails, long equivalencyRequestId)
			throws JsonProcessingException, JSONException {
		String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL,
				themeDisplay.getScopeGroupId());
		LOGGER.info("noOfDocument:::::addOtherDocuments:::::::::" + noOfDocument);
		for (int i = 2; i <= (noOfDocument); i++) {
			String documentType = ParamUtil.getString(uploadPortletRequest, "documentType" + i);
			EquivalencyDocumentType otherDocumentEqDocType = new EquivalencyDocumentType();
			otherDocumentEqDocType.setEquivalencyDocType("Other Documents");
			otherDocumentEqDocType.setEquivalencyRequestId(equivalencyRequestId);
			otherDocumentEqDocType.setQualification(documentType);
			String eqDocTypeOtherDocumentPayload = objectMapper.writeValueAsString(otherDocumentEqDocType);
			String otherDocumentDocTypeResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL,
					eqDocTypeOtherDocumentPayload, headersInfo);

			JSONObject otherDocumentDocTypeResponseJson = JSONFactoryUtil
					.createJSONObject(otherDocumentDocTypeResponse);
			OtherDocumentFileUploadDetails.setEquivalencyDocTypeId(otherDocumentDocTypeResponseJson.getInt("id"));
			OtherDocumentFileUploadDetails.setDocumentType("otherDocuments");
			OtherDocumentFileUploadDetails.setComponentId(2);
			Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
			FileItem[] attachmentFileNos = files.get("attachmentFile" + i);
			if (attachmentFileNos.length > 0) {
				// long fileEntryId = addDocument(uploadPortletRequest, themeDisplay, fileName,
				// childfolderOtherDocument);
				try {
					long fileEntryId = equivalencyUtil
							.fileUpload(uploadPortletRequest, "Other Document", "attachmentFile" + i).get(0)
							.getFileEntryId();
					OtherDocumentFileUploadDetails.setFileEntryID(fileEntryId);
				} catch (PortalException | IOException e) {
					LOGGER.error(e.getMessage());
				}
				try {
					String otherDocumentFileUploadDetailsPayload = objectMapper
							.writeValueAsString(OtherDocumentFileUploadDetails);
					String otherDocumentfileUploadDetailURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL,
							siteId);
					LOGGER.info("otherDocumentfileUploadDetailURL :" + otherDocumentfileUploadDetailURL);
					oMSBHttpConnector.executePost(otherDocumentfileUploadDetailURL,
							otherDocumentFileUploadDetailsPayload, headersInfo);
				} catch (JsonProcessingException e) {
					LOGGER.error(e.getMessage());
				}
			}
		}
	}

	private List<DocumentInfo> getDocumentInfoListByEqRequestId(ThemeDisplay themeDisplay, long equivalencyRequestId,
			ObjectMapper objectMapper) {
		List<DocumentInfo> documentInfoItemsList = new ArrayList<>();
		try {
			String documentInfoResponse = oMSBHttpConnector
					.executeGet(
							omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID
									+ themeDisplay.getScopeGroupId() + "?filter=equivalencyRequestId%20eq%20"
									+ equivalencyRequestId,
							StringPool.BLANK, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			LOGGER.info("documentInfoResponse :" + documentInfoResponse);
			JSONObject documentInfoJsonObj = JSONFactoryUtil.createJSONObject(documentInfoResponse);
			JSONArray itemsArray = documentInfoJsonObj.getJSONArray("items");
			documentInfoItemsList = objectMapper.readValue(itemsArray.toString(),
					new TypeReference<List<DocumentInfo>>() {
					});
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return documentInfoItemsList;
	}

	private void deleteEquivalencyDocumentdata(ThemeDisplay themeDisplay, List<DocumentInfo> documentInfoItemsList) {
		try {
			for (DocumentInfo info : documentInfoItemsList) {
				if (info.getDocumentType().equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ETBA_DOCUMENTS_TYPE)) {
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + info.getId();
					oMSBHttpConnector.executeDelete(url, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

					String eqDocTypeURL = themeDisplay.getPortalURL() + LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK
							+ info.getEquivalencyDocTypeId();
					oMSBHttpConnector.executeDelete(eqDocTypeURL, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
				}

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

//	private void deleteEquivalencyEducationdata(ThemeDisplay themeDisplay,
//			List<EducationalDetailItem> educationDetailItemList) {
//		try {
//			for (EducationalDetailItem education : educationDetailItemList) {
//				String url = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + education.getId();
//				oMSBHttpConnector.executeDelete(url, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
//			}
//		} catch (Exception e) {
//			LOGGER.error(e.getMessage(), e);
//		}
//
//	}

	private void updateEquivalencyRequestById(long siteId, long eqRequestId, Map<String, String> headersInfo,
			String statusKey, long companyId) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EQUIVALENCY_STATUS,
				statusKey, companyId);
		long statusId = 0;
		if (Validator.isNotNull(entry)) {
			statusId = entry.getListTypeEntryId();
		}
		String url = omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + eqRequestId;
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("equivalencyStatusId", statusId);
		oMSBHttpConnector.executePut(url, object.toString(), headersInfo);
	}

	private String addCertificateToEquivalencyCetrificateTable(long siteId,
			omsb.vehpc.equivalency.dto.web.EquivalencyCertificate equivalencyCertificate,
			Map<String, String> headersInfo, ObjectMapper objectMapper) {

		String equivalencyCertificatePayload = "";
		try {
			equivalencyCertificatePayload = objectMapper.writeValueAsString(equivalencyCertificate);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage());
		}

		String officialRequestfileUploadDetailURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_CERTIFICATE_URL,
				siteId);
		return oMSBHttpConnector.executePost(officialRequestfileUploadDetailURL, equivalencyCertificatePayload,
				headersInfo);
	}

	/**
	 * 
	 * @param renderRequest
	 * @param eqRequestId
	 * @return
	 */
	public DLFileEntry createDecisionLevelCertificate(PortletRequest renderRequest, long eqRequestId, String html) {
		DLFileEntry fileEntry = null;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
			serviceContext.setAddGroupPermissions(true);
			DLFolder userFolder = null, equivalencyFolder = null, equivalencyCertificateFolder = null;
			DynamicQuery folderQuery;

			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name")
					.eq(String.valueOf(String.valueOf(themeDisplay.getUserId()) + " documents")));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery
					.add(PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
			List<DLFolder> folderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> folderNameList = folderList.parallelStream().map(DLFolder::getName)
					.collect(Collectors.toList());
			if (!folderNameList.contains(String.valueOf(themeDisplay.getUserId()) + " documents")) {
				userFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE,
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						String.valueOf(themeDisplay.getUserId()) + " documents",
						EquivalencyCertificateConstants.USER + " documents", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name")
						.eq(String.valueOf(themeDisplay.getUserId()) + " documents"));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(
						PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
				userFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name")
					.eq(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY)));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(userFolder.getFolderId()));
			List<DLFolder> equivalencyFolderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> equivalencyFolderNameList = equivalencyFolderList.parallelStream().map(DLFolder::getName)
					.collect(Collectors.toList());
			if (!equivalencyFolderNameList.contains(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY))) {
				equivalencyFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE,
						userFolder.getFolderId(), EquivalencyCertificateConstants.EQUIVALENCY,
						EquivalencyCertificateConstants.EQUIVALENCY + " documents", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name")
						.eq(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY)));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(userFolder.getFolderId()));
				equivalencyFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(
					PropertyFactoryUtil.forName("name").eq(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(equivalencyFolder.getFolderId()));
			List<DLFolder> equivalencyCertificateFolderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> equivalencyCertificateFolderNameList = equivalencyCertificateFolderList.parallelStream()
					.map(DLFolder::getName).collect(Collectors.toList());
			if (!equivalencyCertificateFolderNameList
					.contains(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE))) {
				equivalencyCertificateFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK,
						themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(),
						Boolean.FALSE, equivalencyFolder.getFolderId(),
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE,
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + " documents", Boolean.FALSE,
						serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name")
						.eq(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(equivalencyFolder.getFolderId()));
				equivalencyCertificateFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			File file = generatePdfDocument(html, themeDisplay);
			if (Validator.isNotNull(file)) {
				InputStream inputStream = new FileInputStream(file);
				long timeStamp = new Date().getTime();
				fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(),
						equivalencyCertificateFolder.getFolderId(),
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + "_" + timeStamp + ".pdf",
						ContentTypes.APPLICATION_PDF,
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + "_" + timeStamp,
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_URL,
						EquivalencyCertificateConstants.CERTIFICATE, StringPool.BLANK, 0L, null, file, inputStream,
						file.length(), null, null, serviceContext);
				String download = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ fileEntry.getGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH
						+ URLEncoder.encode(HtmlUtil.unescape(fileEntry.getTitle()), DataflowConstants.UTF_8)
						+ StringPool.SLASH + fileEntry.getUuid() + "?version=" + fileEntry.getVersion();
				LOGGER.info("Download >>>>>" + download);
				LOGGER.info("fileEntry >>>>>" + fileEntry.getFileEntryId());
			}

		} catch (IOException | PortalException e) {
			LOGGER.error("Error while generting PDF file, " + e.getMessage());
		} finally {
			try {
				Files.walk(Paths.get(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH))
						.filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
			} catch (IOException e) {
				LOGGER.error("Error while deleting all files from directory, " + e.getMessage());
			}

		}
		return fileEntry;

	}

	private File generatePdfDocument(String certHTML, ThemeDisplay themeDisplay) {
		try {
			Path dirPath = Paths.get(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH);
			if (!Files.exists(dirPath)) {

				Files.createDirectory(dirPath);

				Path filePath = dirPath.resolve(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_NAME);
				if (!Files.exists(filePath)) {
					Files.createFile(filePath);
				}
			}
			File file = new File(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH
					+ EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_NAME);
			PdfDocument pdfDocument = new PdfDocument(new PdfWriter(file));
			ConverterProperties properties = new ConverterProperties();
			Rectangle rect = new Rectangle(1200, 1600);
			pdfDocument.setDefaultPageSize(new PageSize(rect));
			properties.setBaseUri(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_IMAGE_FILE_PATH);
			FontProvider fontProvider = new DefaultFontProvider(false, false, false);
			FontProgram fontProgram = FontProgramFactory
					.createFont(themeDisplay.getPathThemeCss() + "/fonts/Lateef/Lateef-Regular.ttf");
			fontProvider.addFont(fontProgram);
			FontProgram fontProgram2 = FontProgramFactory
					.createFont(themeDisplay.getPathThemeCss() + "/certificate-fonts/FontEnglish.ttf");
			fontProvider.addFont(fontProgram2);

			properties.setFontProvider(fontProvider);

			Document document = HtmlConverter.convertToDocument(certHTML, pdfDocument, properties);
			document.setMargins(0, 0, 0, 0);
			document.close();
			pdfDocument.close();

			return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param eqRequestId
	 * @param themeDisplay
	 * @param html
	 * @return
	 */
	public String getCertificateDetailByDDMTemplate(long eqRequestId, ThemeDisplay themeDisplay, String html) {
		try {
			html = html.replace("$[date]", getDate());
			LOGGER.info("getCertificateDetailByDDMTemplate calling ");
			EquivalencyRequest eqRequest = getEquivalencyRequestById(eqRequestId, themeDisplay);
			if (Validator.isNotNull(eqRequest)) {
//			  eqRequest.getEmployerUserID()// get name from user table
				User user = UserLocalServiceUtil.getUser(eqRequest.getEmployerUserID());
				LOGGER.info("person Id is ?? " + eqRequest.getPersonId());
				Person person = getPersonDetailById(eqRequest.getPersonId(), themeDisplay);
				PersonalDetail personal = getPersonalDetailByPersonId(eqRequest.getPersonId(), themeDisplay);
				if (Validator.isNotNull(person) && Validator.isNotNull(personal)) {
					List<EquivalencyRequestCertificate> list = getDecisionLevelByEqRequestId(themeDisplay, eqRequestId,
							personal, person);
					if (Validator.isNotNull(list) && !list.isEmpty()) {
						LOGGER.info("list size ?? " + list.size());

						// html = html.replace("$[issueCountry]",
						// equivalencyUtil.getCountryByCountryId(themeDisplay.getPortalURL(),
						// themeDisplay.getScopeGroupId(),
						// Long.valueOf(list.get(0).getIssueCountry())).getItems().get(0).getNationality());

						html = html.replace("$[name]",
								Validator.isNotNull(list.get(0).getName()) ? list.get(0).getName() : "");
						html = html.replace("$[passportNumber]",
								Validator.isNotNull(list.get(0).getPassportNumber()) ? list.get(0).getPassportNumber()
										: "");
						html = html.replace("$[dob]",
								Validator.isNotNull(list.get(0).getDob()) ? list.get(0).getDob() : "");
						html = html.replace("$[certificateName]",
								Validator.isNotNull(list.get(0).getCertificateName()) ? list.get(0).getCertificateName()
										: "");
						html = html.replace("$[issueCountry]",
								Validator.isNotNull(list.get(0).getIssueCountry()) ? list.get(0).getIssueCountry()
										: "");
						html = html.replace("$[graduationYear]",
								Validator.isNotNull(list.get(0).getGraduationYear()) ? list.get(0).getGraduationYear()
										: "");
						html = html.replace("$[eqLevel]",
								Validator.isNotNull(list.get(0).getEqLevel()) ? list.get(0).getEqLevel() : "");
						html = html.replace("$[remarks]",
								Validator.isNotNull(list.get(0).getRemarks()) ? list.get(0).getRemarks() : "");
						if (Validator.isNotNull(user)) {
							LOGGER.info("user name ?? " + user.getFullName());
							html = html.replace("$[employerName]",
									Validator.isNotNull(user.getFullName()) ? user.getFullName() : "");
						}

					}
				}
			}
			LOGGER.info("getCertificateDetailByDDMTemplate calling ends here");
			return html;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return html;
	}

	private EquivalencyDecisionLevel addEquivalencyDecisionLevel(long siteId, Map<String, String> headersInfo,
			EquivalencyDecisionLevel equivalencyDecisionLevel, ObjectMapper objectMapper) {

		String equivalencyDecisionLevelPayload = "";
		try {
			equivalencyDecisionLevelPayload = objectMapper.writeValueAsString(equivalencyDecisionLevel);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage());
		}

		String equivalencyDecisionLevelURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DECISION_LEVELS_URL, siteId);
		String res = oMSBHttpConnector.executePost(equivalencyDecisionLevelURL, equivalencyDecisionLevelPayload,
				headersInfo);
		EquivalencyDecisionLevel level = CustomObjectMapperUtil.readValue(res, EquivalencyDecisionLevel.class);
		LOGGER.info("Equivalency Decision Level Added and response is >>>>>>>>>" + res);
		LOGGER.info("Equivalency Decision Level Added>>>>>>>>>");
		return level;
	}

	public Person getPersonDetailById(long personId, ThemeDisplay themeDisplay) {
		String personURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSON_BY_ID_URL2 + personId;
		String personResponse = omsbCommonApi.getData(personURL);
		LOGGER.info("personalResponse ?? " + personResponse);
		if (personResponse.contains("dateOfBirth")) {
			return CustomObjectMapperUtil.readValue(personResponse, Person.class);
		}
		return null;
	}

	public PersonalDetail getPersonalDetailByPersonId(long personId, ThemeDisplay themeDisplay) {
		String personalURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL2
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "search=" + personId;
		// String personalResponse = omsbCommonApi.getData(personalURL);
		String personalResponse = omsbCommonApi.getData(personalURL);
		LOGGER.debug("personalResponse ?? " + personalResponse);
		PersonalDetailItem personalItems = CustomObjectMapperUtil.readValue(personalResponse, PersonalDetailItem.class);
		if (Validator.isNotNull(personalItems) && Validator.isNotNull(personalItems.getItems())
				&& !personalItems.getItems().isEmpty()) {
			return personalItems.getItems().get(0);
		}
		return null;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param eqRequestId
	 * @param personal
	 * @param person
	 * @return
	 */
	private List<EquivalencyRequestCertificate> getDecisionLevelByEqRequestId(ThemeDisplay themeDisplay,
			long eqRequestId, PersonalDetail personal, Person person) {
		List<EquivalencyRequestCertificate> certificateList = new ArrayList<>();
		String equivalencyDecisionLevellURL = themeDisplay.getPortalURL()
				+ LRObjectURL.EQUIVALENCY_DECISION_LEVELS_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=eqRequestId"
				+ URLEncoder.encode(" eq " + eqRequestId, StandardCharsets.UTF_8);
		String dLResponse = omsbCommonApi.getData(equivalencyDecisionLevellURL);
		LOGGER.info("decisionLevelResponse ?? " + dLResponse);
		EquivalencyDecisionLevelItems decisionLevelItems = CustomObjectMapperUtil.readValue(dLResponse,
				EquivalencyDecisionLevelItems.class);
		if (Validator.isNotNull(decisionLevelItems) && Validator.isNotNull(decisionLevelItems.getItems())
				&& !decisionLevelItems.getItems().isEmpty()) {
			LOGGER.info("level size is  ?? " + decisionLevelItems.getItems().size());
			for (EquivalencyDecisionLevel level : decisionLevelItems.getItems()) {
				LOGGER.info("level is ?? " + level);
				if (Validator.isNotNull(level)) {
					DocumentInfo document = getDocumentInfoById(level.getDocumentInfoId(), themeDisplay);
					EducationDetail education = getEducationDetailById(themeDisplay, document.getComponentClassRefId());
					certificateList.add(setCertificateDetail(personal, person, education, level));
				}
			}
		}
		return certificateList;
	}

	public EquivalencyRequest getEquivalencyRequestById(long eqRequestId, ThemeDisplay themeDisplay) {
		// find the role of logged in user Id
		// if employer then emplyerId = themeDisplay.UserId
		// if employee then find the personId for logged in userId and in Url personId
		// == personId
		String eqRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + eqRequestId;
		String response = omsbCommonApi.getData(eqRequestUrl);
		LOGGER.debug("EquivalencyRequest API response is ?? " + response);
		// EquivalencyRequest request = CustomObjectMapperUtil.readValue(response,
		// EquivalencyRequest.class);
		return CustomObjectMapperUtil.readValue(response, EquivalencyRequest.class);
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param id
	 * @return
	 */
	private EducationDetail getEducationDetailById(ThemeDisplay themeDisplay, long id) {
		String educationDetailURL = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + id;
		String educationResponse = omsbCommonApi.getData(educationDetailURL);
		LOGGER.info(educationDetailURL + ":educationResponse ??? " + educationResponse);
		if (educationResponse.contains("personId")) {
			return CustomObjectMapperUtil.readValue(educationResponse, EducationDetail.class);
		}
		return null;
	}

	public DocumentInfo getDocumentInfoById(long documentInfoId, ThemeDisplay themeDisplay) {
		String documentInfoURL = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + documentInfoId;
		String documentInfoResponse = omsbCommonApi.getData(documentInfoURL);
		LOGGER.info("documentInfoResponse ?? " + documentInfoResponse);
		return CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfo.class);
	}

	public String getObjectClassName(long companyId) {
		ObjectDefinition definition = null;
		try {
			definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode("OB_EUIVALENCY_REQUEST_ERC",
					companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void uploadCaseReportFile(String fileParam, UploadPortletRequest uploadPortletRequest,
			ThemeDisplay themeDisplay, long siteId, ObjectMapper objectMapper, Map<String, String> headersInfo,
			DocumentInfo fileUploadDetails) throws java.io.IOException {
		String caseReportFileFolder = "Case Report File";
		String fileName = uploadPortletRequest.getFileName(fileParam);
		fileUploadDetails.setdFFileName(fileName);
		List<FileEntry> fileEntries = null;
		try {
			fileEntries = fileUpload(uploadPortletRequest, caseReportFileFolder, fileParam);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		for (FileEntry fileEntry : fileEntries) {
			LOGGER.info("File Names >>>> " + fileEntry.getFileName() + "  :File Entry Id >>>> "
					+ fileEntry.getFileEntryId());

			fileUploadDetails.setFileEntryID(fileEntry.getFileEntryId());
			fileUploadDetails.setdFFileName(fileEntry.getFileName());

			String fileUploadDetailsPayload = null;
			try {
				EquivalencyDocumentType caseReportDocType = new EquivalencyDocumentType();
				caseReportDocType.setEquivalencyDocType(fileUploadDetails.getDocumentType());
				caseReportDocType.setEquivalencyRequestId(fileUploadDetails.getEquivalencyRequestId());
				String caseReportFileUploadDetailsPayload = objectMapper.writeValueAsString(caseReportDocType);
				String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL,
						themeDisplay.getScopeGroupId());
				String equivalencyDocResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL,
						caseReportFileUploadDetailsPayload, headersInfo);
				JSONObject otherDocumentDocTypeResponseJson = JSONFactoryUtil.createJSONObject(equivalencyDocResponse);
				fileUploadDetails.setEquivalencyDocTypeId(otherDocumentDocTypeResponseJson.getInt("id"));
				fileUploadDetailsPayload = objectMapper.writeValueAsString(fileUploadDetails);
				String officialRequestfileUploadDetailURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, siteId);
				String res = oMSBHttpConnector.executePost(officialRequestfileUploadDetailURL, fileUploadDetailsPayload,
						headersInfo);
				LOGGER.info("Case Report File Uploaded>>>>>>>>>>>>>" + res);
			} catch (JsonProcessingException | JSONException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	private String getDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd MMM YYYY");
		return format.format(date);
	}

	/**
	 * 
	 * @param personal
	 * @param person
	 * @param education
	 * @param level
	 * @return
	 */
	private EquivalencyRequestCertificate setCertificateDetail(PersonalDetail personal, Person person,
			EducationDetail education, EquivalencyDecisionLevel level) {
		EquivalencyRequestCertificate certificate = new EquivalencyRequestCertificate();
		String giveName = "";
		String dob = "";
		String passportNumber = "";
		String qualification = "";
		String conferredDate = "";
		String issueCountry = "";
		String levelName = "";
		String comments = "";
		// LOGGER.info(education.getId()+"
		// QUALIFICATION:::"+education.getQualificationAttained()+"
		// QualificationConferredDate :"+education.getQualificationConferredDate()+" ,
		// education.getIssuingAuthorityCountryId() :
		// "+education.getIssuingAuthorityCountryId());
		if (Validator.isNotNull(personal)) {
			giveName = personal.getGivenNameAsPassport();
		}
		if (Validator.isNotNull(person)) {
			dob = omsbCommonApi.convertDateFormatToDDMMYYYY(
					Validator.isNotNull(person.getDateOfBirth()) ? person.getDateOfBirth() : "");
			passportNumber = person.getPassportNumber();
		}
		if (Validator.isNotNull(education)) {
			qualification = education.getQualificationAttained();
			conferredDate = omsbCommonApi
					.convertDateFormatToDDMMYYYY(Validator.isNotNull(education.getQualificationConferredDate())
							? education.getQualificationConferredDate()
							: "");
			issueCountry = String.valueOf(education.getIssuingAuthorityName());
		}
		if (Validator.isNotNull(level) && Validator.isNotNull(level.getEquivalencyLevelId())) {
			levelName = level.getEquivalencyLevelId().getName();
			comments = level.getComments();
		}
		certificate.setName(giveName);
		certificate.setDob(dob);
		certificate.setPassportNumber(passportNumber);
		certificate.setCertificateName(qualification);
		certificate.setGraduationYear(conferredDate);
		certificate.setIssueCountry(issueCountry);
		certificate.setEqLevel(levelName);
		certificate.setRemarks(comments);
		return certificate;
	}

	private String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL()
				+ equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}

	public static List<FileEntry> fileUpload(UploadPortletRequest uploadPortletRequest, String folderName,
			String fileParamName) throws PortalException, java.io.IOException {
		List<FileEntry> fileEntries = new ArrayList<>();
		long fileEntryId = 0;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
				uploadPortletRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long repositoryId = themeDisplay.getScopeGroupId();
		Folder folder = getFolder(uploadPortletRequest, folderName);
		if (Validator.isNull(folder)) {
			folder = createNewFolder(uploadPortletRequest, folderName);
		}
		LOGGER.info(" folder ID is - --  >" + folder.getFolderId());
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		LOGGER.info("files..." + files.size());
		FileItem[] items = files.get(fileParamName);
		// for (Entry<String, FileItem[]> file2 : files.entrySet()) {
		// FileItem item[] =file2.getValue();
		try {
			for (FileItem fileItem : items) {
				FileEntry fileEntry = null;
				InputStream is;
				File file;
				String title, description, mimeType;
				mimeType = fileItem.getContentType();
				file = fileItem.getStoreLocation();
				is = fileItem.getInputStream();
				title = System.currentTimeMillis() + fileItem.getFileName();
				description = title;
				FileEntry existingfileEntry = null;
				try {
					existingfileEntry = DLAppLocalServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), title);
					LOGGER.info("existingfileEntry : " + existingfileEntry);
				} catch (PortalException e) {
					LOGGER.error(e.getMessage(), e);
				}
				try {
					if (Validator.isNotNull(existingfileEntry)) {
						fileEntry = DLAppServiceUtil.updateFileEntry(existingfileEntry.getFileEntryId(),
								existingfileEntry.getFileName(), mimeType, title, title, description, "",
								DLVersionNumberIncrease.MAJOR, is, existingfileEntry.getSize(), null, null,
								serviceContext);
					} else {
						fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType,
								title, description, "", file, serviceContext);
						fileEntryId = fileEntry.getFileEntryId();
						LOGGER.info("Multiple file entries are - - - > " + fileEntryId);
					}
					fileEntries.add(fileEntry);
				} catch (PortalException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		// }
		return fileEntries;
	}

	public static Folder getFolder(UploadPortletRequest uploadPortletRequest, String folderName) {
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, folderName);
			LOGGER.info(folderName + " Exist >>>>>>>");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return folder;
	}

	public static Folder createNewFolder(UploadPortletRequest uploadPortletRequest, String folderName) {
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
					uploadPortletRequest);
			LOGGER.info("Creating folder name with this name- - - >" + folderName);
			folder = DLAppLocalServiceUtil.addFolder(folderName, themeDisplay.getUserId(), repositoryId,
					PARENT_FOLDER_ID, folderName, ROOT_FOLDER_DESCRIPTION, serviceContext);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return folder;
	}

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;

	private static final Log LOGGER = LogFactoryUtil.getLog(WorkFlowUpdateMVCActionCommand.class);
	private static String ROOT_FOLDER_DESCRIPTION = "This folder is create for Upload documents";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
}

package omsb.vehpc.equivalency.util;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.properties.BaseDirection;
import com.itextpdf.layout.properties.TextAlignment;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EquivalencyRequestCertificate;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevelItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.web.constants.EquivalencyCertificateConstants;

@Component(immediate = true, service = CertificateUtil.class)
public class CertificateUtil {
	 public DLFileEntry createDecisionLevelCertificate(PortletRequest renderRequest, long eqRequestId) {
			DLFileEntry fileEntry = null;
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
				serviceContext.setAddGroupPermissions(true);
				long ddmStructureClassNameId = ClassNameLocalServiceUtil.getClassNameId(DDMStructure.class);
				DDMTemplate template = DDMTemplateLocalServiceUtil.fetchTemplate(themeDisplay.getScopeGroupId(), ddmStructureClassNameId, CommonConstants.EQUIVALENCY_CERT_TEMPLATE_KEY);
				String html = template.getScript();
				String certHTML = getValues(eqRequestId, themeDisplay, html);
				logger.info("certHmlt ?? " + certHTML);
				
				DLFolder equivalencyCertificateFolder = createFolder(themeDisplay, serviceContext);
				logger.info("equivalencyCertificateFolder is ?? " + equivalencyCertificateFolder );
				Path dirPath = Paths.get(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH);
				if (!Files.exists(dirPath)) {
					Files.createDirectory(dirPath);
					
					Path filePath = dirPath.resolve(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_NAME);
				    if (!Files.exists(filePath)) {
				      Files.createFile(filePath);
				    }	
				}
				
				File file = new File(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH+EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_NAME);
				PdfDocument pdfDocument = new PdfDocument(new PdfWriter(file));
				ConverterProperties properties = new ConverterProperties();
				Rectangle rect = new Rectangle(750, 1000);
				pdfDocument.setDefaultPageSize(new PageSize(rect));
				properties.setBaseUri(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_IMAGE_FILE_PATH);
				Document document = HtmlConverter.convertToDocument(certHTML, pdfDocument, properties);
				document.setMargins(0,0,0,0);
				document.close();
				pdfDocument.close();
			

				InputStream inputStream = new FileInputStream(file); 
				long timeStamp = new Date().getTime();
				if (Validator.isNotNull(equivalencyCertificateFolder)) {
				fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), 
						equivalencyCertificateFolder.getFolderId(), EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE+"_"+timeStamp+".pdf", ContentTypes.APPLICATION_PDF, EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE+"_"+timeStamp, 
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_URL, EquivalencyCertificateConstants.CERTIFICATE, StringPool.BLANK, 0L, null,
						file, inputStream, file.length(), null, null, serviceContext);
				}
				String download = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + fileEntry.getGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH + URLEncoder.encode(HtmlUtil.unescape(fileEntry.getTitle()), DataflowConstants.UTF_8) + StringPool.SLASH + fileEntry.getUuid() + "?version=" + fileEntry.getVersion();
				logger.info("Download >>>>>"+download);
				logger.info("fileEntry >>>>>"+fileEntry.getFileEntryId());
				
			}catch (IOException | PortalException e) {
				logger.error("Error while generting PDF file, "+e.getMessage());
			} finally {
				try {
					Files.walk(Paths.get(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH))
					.filter(Files::isRegularFile)
					.map(Path::toFile)
					.forEach(File::delete);
				} catch (IOException e) {
					logger.error("Error while deleting all files from directory, "+e.getMessage());
				}
				
			}
			return fileEntry;
			
		}
	  
	  /**
	   * 
	   * @param eqRequestId
	   * @param themeDisplay
	   * @param html
	   * @return
	   */
	  public String getValues(long eqRequestId, ThemeDisplay themeDisplay, String html) {
		  try {
		  html = html.replace("$[date]", getDate());
		  logger.info("getCertificateDetailByDDMTemplate calling ");
		  EquivalencyRequest eqRequest = equivalencyUtil.getEquivalencyRequestById(eqRequestId);
		  if (Validator.isNotNull(eqRequest)) {
			  User user = UserLocalServiceUtil.getUser(eqRequest.getEmployerUserID());
			  logger.info("person Id is ?? " + eqRequest.getPersonId());
			  Person person = getPersonDetailById(eqRequest.getPersonId(), themeDisplay);
			  PersonalDetail personal = getPersonalDetailByPersonId(eqRequest.getPersonId(), themeDisplay);
			  logger.info("personal :: " + personal);
			  if (Validator.isNotNull(person) && Validator.isNotNull(personal)) {
				  logger.info("inside condition :: " );
				  html = replaceValues(themeDisplay, eqRequestId, person, personal, html, user);
			  }
		  }
		  logger.info("getCertificateDetailByDDMTemplate calling ends here :: " + html);
		  return html;
		  }catch (Exception e) {
			  logger.error(e.getMessage(), e);
		}
		return html;
	  }
	  
	  private String replaceValues(ThemeDisplay themeDisplay, long eqRequestId, Person person, PersonalDetail personal, String html, User user) {
		  List<EquivalencyRequestCertificate> list = getDecisionLevelByEqRequestId(themeDisplay, eqRequestId, personal, person);
		  if (Validator.isNotNull(list) && !list.isEmpty()) {
			  logger.info("list size ?? " + list.size());
			  html = html.replace("$[name]", Validator.isNotNull(list.get(0).getName())?list.get(0).getName():"");
			  html = html.replace("$[passportNumber]", Validator.isNotNull(list.get(0).getPassportNumber())?list.get(0).getPassportNumber():"");
			  html = html.replace("$[dob]", Validator.isNotNull(list.get(0).getDob())?list.get(0).getDob():"");
			  html = html.replace("$[certificateName]", Validator.isNotNull(list.get(0).getCertificateName())?list.get(0).getCertificateName():"");
			  html = html.replace("$[issueCountry]", Validator.isNotNull(list.get(0).getIssueCountry())?list.get(0).getIssueCountry():"");
			  html = html.replace("$[graduationYear]", Validator.isNotNull(list.get(0).getGraduationYear())?list.get(0).getGraduationYear():"");
			  html = html.replace("$[eqLevel]", Validator.isNotNull(list.get(0).getEqLevel())?list.get(0).getEqLevel():"");
			  html = html.replace("$[remarks]", Validator.isNotNull(list.get(0).getRemarks())?list.get(0).getRemarks():"");
			  if(Validator.isNotNull(user)) {
				  logger.info("user name ?? " + user.getFullName());
				  html = html.replace("$[employerName]", Validator.isNotNull(user.getFullName())?user.getFullName():"");
			  }
		  }
		return html;
	  }
	  
	  public String getDate() {
		  Date date = new Date();
		  DateFormat format = new SimpleDateFormat("dd MMM YYYY");
		  return format.format(date);
	  }
	  
	  public Person getPersonDetailById(long personId, ThemeDisplay themeDisplay) {
			String personURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSON_BY_ID_URL2 + personId;
			String personResponse = omsbCommonApi.getData(personURL);
			logger.info("personalResponse ?? " + personResponse);
			if (personResponse.contains("dateOfBirth")) {
				return CustomObjectMapperUtil.readValue(personResponse, Person.class);
			}
			return null;
		}
	  
	  public PersonalDetail getPersonalDetailByPersonId(long personId, ThemeDisplay themeDisplay) {
			String personalURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL2 + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "search="+ personId;
			String personalResponse = omsbCommonApi.getData(personalURL);
			logger.debug("personalResponse ?? " + personalResponse);
			PersonalDetailItem personalItems = CustomObjectMapperUtil.readValue(personalResponse, PersonalDetailItem.class);
			if (Validator.isNotNull(personalItems) && Validator.isNotNull(personalItems.getItems()) && !personalItems.getItems().isEmpty()) {
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
	  public List<EquivalencyRequestCertificate> getDecisionLevelByEqRequestId(ThemeDisplay themeDisplay, long eqRequestId, PersonalDetail personal, Person person) {
		  List<EquivalencyRequestCertificate> certificateList = new ArrayList<>();
		  String equivalencyDecisionLevellURL = themeDisplay.getPortalURL()
					+ LRObjectURL.EQUIVALENCY_DECISION_LEVELS_URL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=eqRequestId"
							+ URLEncoder.encode(" eq " + eqRequestId, StandardCharsets.UTF_8); 
			String dLResponse = omsbCommonApi.getData(equivalencyDecisionLevellURL);
			logger.info("decisionLevelResponse ?? " + dLResponse);
			EquivalencyDecisionLevelItems decisionLevelItems = CustomObjectMapperUtil.readValue(dLResponse, EquivalencyDecisionLevelItems.class);
			if (Validator.isNotNull(decisionLevelItems) && Validator.isNotNull(decisionLevelItems.getItems()) && !decisionLevelItems.getItems().isEmpty()) {
				logger.info("level size is  ?? " + decisionLevelItems.getItems().size());
				for (EquivalencyDecisionLevel level : decisionLevelItems.getItems()) {
					logger.info("level is ?? " + level);
					if (Validator.isNotNull(level)) {
						DocumentInfo document = appealUtil.getDocumentInfoById(level.getDocumentInfoId(), themeDisplay);
						EducationDetail education = getEducationDetailById(themeDisplay, document.getComponentClassRefId());
						certificateList.add(setCertificateDetail(personal, person, education, level));
					}
				}
			}
			return certificateList;
	  }
	  
	  public EducationDetail getEducationDetailById(ThemeDisplay themeDisplay, long id) {
		  String educationDetailURL = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + id;
		  String educationResponse = omsbCommonApi.getData(educationDetailURL);
		  logger.info(educationDetailURL+":educationResponse ??? " + educationResponse);
		  if (educationResponse.contains("personId")) {
			  return CustomObjectMapperUtil.readValue(educationResponse, EducationDetail.class);
		  }
		  return null;
	  }
	  
	  public EquivalencyRequestCertificate setCertificateDetail(PersonalDetail personal, Person person, EducationDetail education, EquivalencyDecisionLevel level) {
		  EquivalencyRequestCertificate certificate = new EquivalencyRequestCertificate();
		  String giveName = "";
		  String dob = "";
		  String passportNumber = "";
		  String qualification = "";
		  String conferredDate = "";
		  String issueCountry = "";
		  String levelName = "";
		  String comments = "";
		 // LOGGER.info(education.getId()+" QUALIFICATION:::"+education.getQualificationAttained()+" QualificationConferredDate :"+education.getQualificationConferredDate()+" , education.getIssuingAuthorityCountryId() : "+education.getIssuingAuthorityCountryId());
		  if (Validator.isNotNull(personal)) {
			  giveName = personal.getGivenNameAsPassport();
		  }
		  if (Validator.isNotNull(person)) {
			  dob = omsbCommonApi.convertDateFormatToDDMMYYYY(Validator.isNotNull(person.getDateOfBirth())?person.getDateOfBirth():"");
			  passportNumber = person.getPassportNumber();
		  }
		  if (Validator.isNotNull(education)) {
			 qualification = education.getQualificationAttained();
			 conferredDate = omsbCommonApi.convertDateFormatToDDMMYYYY(Validator.isNotNull(education.getQualificationConferredDate())?education.getQualificationConferredDate():"");
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
	  
	  public String getSingleCertificateValueByJournalArticle(long groupId) {
		  JournalArticle article = null;
		try {
			article = journalArticleLocalService.getArticleByUrlTitle(groupId, "equivalency-certificate-single-doc");
		} catch (PortalException e) {
			logger.error("Exception while getting web content for certificate :::", e);
		}
		  if (Validator.isNotNull(article)) {
			  String content = article.getContentByLocale("en_US");
			  logger.info("content is ?? " + content);
			  logger.info("main content is ?? " + readXMLData(content, "equivalencyCertificate"));
			  return readXMLData(content, "equivalencyCertificate");
		  }
		  return "";
	  }
	  
	  public String readXMLData(String content, String key) {
			String fieldValue = StringPool.BLANK;
			try {

				com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(content);

				Node node = document.selectSingleNode("/root/dynamic-element[@field-reference='" + key + "']/dynamic-content");

				if (Validator.isNotNull(node)) {
					return fieldValue = node.getText();
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return fieldValue;

		}
	  
	  public DLFolder createFolder(ThemeDisplay themeDisplay, ServiceContext serviceContext) {
		  	DLFolder userFolder = null, equivalencyFolder = null, equivalencyCertificateFolder = null;
			DynamicQuery folderQuery;
			try {
			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name").eq(String.valueOf(String.valueOf(themeDisplay.getUserId())+" documents")));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
			List<DLFolder> folderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> folderNameList = folderList.parallelStream().map(DLFolder::getName).collect(Collectors.toList());
			if(!folderNameList.contains(String.valueOf(themeDisplay.getUserId())+" documents")) {
				userFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, String.valueOf(themeDisplay.getUserId())+" documents", EquivalencyCertificateConstants.USER+" documents", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name").eq(String.valueOf(themeDisplay.getUserId())+" documents"));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
				userFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}
			
			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name").eq(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY)));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(userFolder.getFolderId()));
			List<DLFolder> equivalencyFolderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> equivalencyFolderNameList = equivalencyFolderList.parallelStream().map(DLFolder::getName).collect(Collectors.toList());			
			if(!equivalencyFolderNameList.contains(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY))) {
				equivalencyFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE, userFolder.getFolderId(), EquivalencyCertificateConstants.EQUIVALENCY, EquivalencyCertificateConstants.EQUIVALENCY+" documents", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name").eq(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY)));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(userFolder.getFolderId()));
				equivalencyFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}
			
			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name").eq(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(equivalencyFolder.getFolderId()));
			List<DLFolder> equivalencyCertificateFolderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> equivalencyCertificateFolderNameList = equivalencyCertificateFolderList.parallelStream().map(DLFolder::getName).collect(Collectors.toList());
			if(!equivalencyCertificateFolderNameList.contains(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE))) {
				equivalencyCertificateFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE, equivalencyFolder.getFolderId(), EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE, EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE+" documents", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name").eq(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(equivalencyFolder.getFolderId()));
				equivalencyCertificateFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}
			} catch (PortalException e) {
				logger.error("Exception while creating folders:::", e);
			}
			return equivalencyCertificateFolder;
	  }
	  
	  
	  public DLFileEntry createCertificate(PortletRequest renderRequest, long eqRequestId, String html) {
			DLFileEntry fileEntry = null;
		  	long timeStamp = new Date().getTime();
			String fileName = EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE+"_"+timeStamp+".pdf";

			File file = new File(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH+EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_NAME);
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
				serviceContext.setAddGroupPermissions(true);
				
				DLFolder equivalencyCertificateFolder = createFolder(themeDisplay, serviceContext);
				logger.info("equivalencyCertificateFolder is ?? " + equivalencyCertificateFolder );
			
				Path dirPath = Paths.get(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH);
				if (!Files.exists(dirPath)) {
					Files.createDirectory(dirPath);
					
					Path filePath = dirPath.resolve(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_NAME);
				    if (!Files.exists(filePath)) {
				      Files.createFile(filePath);
				    }	
				}
				
			//	Document document = new Document(new PdfDocument(new PdfWriter(file)));
				PdfWriter pdfWriter = new PdfWriter(file);
				PdfDocument pdfDocument = new PdfDocument(pdfWriter);
				ConverterProperties properties = new ConverterProperties();
				Rectangle rect = new Rectangle(750, 1000);
				pdfDocument.setDefaultPageSize(new PageSize(rect));
				String fontPath = "C:\\Users\\aftaba\\Downloads\\Noto_Naskh_Arabic\\static\\NotoNaskhArabic-Bold.ttf";
			//	String fontPath = "C:\\windows\\fonts\\arial.ttf";
				FontProgram fontProgram = FontProgramFactory.createFont(fontPath);
				PdfFont font = PdfFontFactory.createFont(fontProgram);
			/*
			 * FontProvider provider = new FontProvider(); provider.addFont(fontPath,
			 * StandardCharsets.UTF_8.name());
			 * 
			 * properties.setFontProvider(provider);
			 */
				StringBuilder url = new StringBuilder();
				url.append(themeDisplay.getPortalURL());
				url.append(StringPool.SLASH);
				url.append("documents/d/");
				url.append(themeDisplay.getScopeGroupName());
				url.append("/"+fileName);
				logger.info("url for qr code is ? " + url.toString());
				BarcodeQRCode barcodeQRCode = new BarcodeQRCode(url.toString());
			    PdfFormXObject pdfFormXObject =
			        barcodeQRCode.createFormXObject(ColorConstants.BLACK, pdfDocument);
			    Image qrCodeImage =
			        new Image(pdfFormXObject).setWidth(100f).setHeight(100f);
			    
			    //document.add(qrCodeImage);
				/*
			 * PdfFont font = PdfFontFactory.createFont(fontProgram); FontSet set = new
			 * FontSet(); logger.info(" Path context ?? " + themeDisplay.getPathContext() );
			 * //set.addFont("");
			 */		
					
				properties.setBaseUri(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_IMAGE_FILE_PATH);
				
			//	properties.setCharset("UTF-8");
			//	properties.setFontProvider(new FontProvider(set));
				Document document = HtmlConverter.convertToDocument(html, pdfDocument, properties);
				 
            	FontProvider fontProvider = new DefaultFontProvider(false, false, false);
	            FontProgram fp = FontProgramFactory.createFont("C:\\Users\\aftaba\\Downloads\\Noto_Naskh_Arabic\\static\\NotoNaskhArabic-Regular.ttf");
			    fontProvider.addFont(fp);
				properties.setFontProvider(fontProvider);
				File htmlFile = new File("C:\\Users\\aftaba\\Desktop\\test.html"); 
				File pdfFile = new File("C:\\Users\\aftaba\\Desktop\\test.pdf");
				HtmlConverter.convertToPdf(htmlFile, pdfFile, properties);
				document.setMargins(0,0,0,0);
			//	document.setFontProvider(provider);
				document.setFont(font);
				document.setTextAlignment(TextAlignment.RIGHT);
				String[] fontFamily = {"font-family: 'Noto Naskh Arabic', serif;"};
			//	document.setFontFamily(fontFamily);
				document.setBaseDirection(BaseDirection.RIGHT_TO_LEFT);
				document.add(new Paragraph().add(qrCodeImage));
				document.close();
				pdfDocument.close();
			
				//themeDisplay.get
				InputStream inputStream = new FileInputStream(file); 

				/*if (Validator.isNotNull(equivalencyCertificateFolder)) {
				fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), 
						equivalencyCertificateFolder.getFolderId(), fileName, ContentTypes.APPLICATION_PDF, EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE+"_"+timeStamp,
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_URL, EquivalencyCertificateConstants.CERTIFICATE, StringPool.BLANK, 0L, null,
						file, inputStream, file.length(), null, null, serviceContext);
				}
				String download = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + fileEntry.getGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH + URLEncoder.encode(HtmlUtil.unescape(fileEntry.getTitle()), DataflowConstants.UTF_8) + StringPool.SLASH + fileEntry.getUuid() + "?version=" + fileEntry.getVersion();
				logger.info("Download >>>>>"+download);
				logger.info("fileEntry >>>>>"+fileEntry.getFileEntryId());
				*/
			}catch (IOException | PortalException e) {
				logger.error("Error while generting PDF file, ", e );
			} finally {
				try {
					Files.walk(Paths.get(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH))
					.filter(Files::isRegularFile)
					.map(Path::toFile)
					.forEach(File::delete);
				} catch (IOException e) {
					logger.error("Error while deleting all files from directory, "+e.getMessage());
				}
				
			}
			return fileEntry;
			
		}
	  
	  public static final String[] FONTS = {
	            
	    };
	 
	  
	  private static final Log logger = LogFactoryUtil.getLog(CertificateUtil.class);
	  
	  @Reference(unbind = "-")
	  private EquivalencyUtil equivalencyUtil;
	  
	  @Reference(unbind = "-")
	  private AppealUtil appealUtil;
	  
	  @Reference(unbind = "-")
	  private OMSBCommonApi  omsbCommonApi;
	  
	  @Reference
	  private JournalArticleLocalService journalArticleLocalService; 
}

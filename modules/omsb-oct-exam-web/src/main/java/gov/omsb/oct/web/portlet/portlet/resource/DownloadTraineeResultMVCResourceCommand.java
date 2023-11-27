package gov.omsb.oct.web.portlet.portlet.resource;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.DOWNLOAD_TRAINEE_RESULT }, service = MVCResourceCommand.class)

public class DownloadTraineeResultMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(resourceRequest, OCTExamConstants.CMD);
		if (cmd.equalsIgnoreCase(OCTExamConstants.DOWNLOAD_TRAINEE_RESULT)) {
			downloadTraineeExamResult(themeDisplay, resourceRequest, resourceResponse);
		}
	}

	public void downloadTraineeExamResult(ThemeDisplay themeDisplay, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		try {
			byte[] pdfContent = generatePdfContent(themeDisplay, resourceRequest, resourceResponse);

			resourceResponse.setContentType(OCTExamConstants.CONTENTE_TYPE);
			resourceResponse.setContentLength(pdfContent.length);
			resourceResponse.setProperty(OCTExamConstants.CONTENT, OCTExamConstants.FILE_NAME);

			OutputStream responseOutputStream = resourceResponse.getPortletOutputStream();
			responseOutputStream.write(pdfContent);
			responseOutputStream.flush();
			responseOutputStream.close();

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	private byte[] generatePdfContent(ThemeDisplay themeDisplay, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		try {
			JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),
					OCTExamConstants.DOWNLOAD_RESULT);

			String emailTitle = StringPool.BLANK;
			String resultContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {

				String content = article.getContentByLocale("en_US");
				emailTitle = readXMLData(content, "emailTitle");
				resultContent = readXMLData(content, "emailContent");

				String omsbId = ParamUtil.getString(resourceRequest, OCTExamConstants.TRAINEE_OMSB_ID);
				String finalResult = ParamUtil.getString(resourceRequest, OCTExamConstants.TRAINEE_FINAL_RESULT);
				String percentage = ParamUtil.getString(resourceRequest, OCTExamConstants.TRAINEE_PERCENTAGE);
				String examRefNo = ParamUtil.getString(resourceRequest, OCTExamConstants.TRAINEE_REF_NUMBER);
				String examTitle = ParamUtil.getString(resourceRequest, OCTExamConstants.EXAMTITLE);

				User user = UserLocalServiceUtil.getUser(Long.valueOf(omsbId));
				if (Validator.isNotNull(user)) {
					FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
					if (Validator.isNotNull(entry)) {
						String userPortraitURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(),
								themeDisplay, "");
						logger.info("userPortraitURL::" + userPortraitURL);
						resultContent = resultContent.replace("$[userPortraitURL]", userPortraitURL);
					}
				}
				resultContent = resultContent.replace("$[candidateId]", omsbId);
				resultContent = resultContent.replace("$[candidate]", user.getFullName());
				resultContent = resultContent.replace("$[result]", finalResult);
				resultContent = resultContent.replace("$[examCode]", examRefNo);
				resultContent = resultContent.replace("$[percentage]", percentage);
				resultContent = resultContent.replace("$[examTitle]", examTitle);
				resultContent = resultContent.replace("$[registrationId]", examRefNo);
				resultContent = resultContent.replace("$[validateionId]", examRefNo);

			}

			Path dirPath = Paths.get(OmsbOctExamWebPortletKeys.OCT_EXAM_FILE_PATH);
			if (!Files.exists(dirPath)) {
				Files.createDirectory(dirPath);

				Path filePath = dirPath.resolve(OmsbOctExamWebPortletKeys.OCT_EXAM_FILE_NAME);
				if (!Files.exists(filePath)) {
					Files.createFile(filePath);
				}
			}
			File file = new File(
					OmsbOctExamWebPortletKeys.OCT_EXAM_FILE_PATH + OmsbOctExamWebPortletKeys.OCT_EXAM_FILE_NAME);
			PdfDocument pdfDocument = new PdfDocument(new PdfWriter(file));
			ConverterProperties properties = new ConverterProperties();
			Rectangle rect = new Rectangle(750, 1000);
			pdfDocument.setDefaultPageSize(new PageSize(rect));
			properties.setBaseUri(OmsbOctExamWebPortletKeys.OCT_EXAM_IMAGE_FILE_PATH);
			com.itextpdf.layout.Document document = HtmlConverter.convertToDocument(resultContent, pdfDocument,
					properties);
			document.setMargins(0, 0, 0, 0);
			document.close();
			pdfDocument.close();

			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = fileInputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, bytesRead);
			}
			fileInputStream.close();

			return byteArrayOutputStream.toByteArray();

		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	private static String readXMLData(String content, String Key) {
		String fieldValue = StringPool.BLANK;
		try {
			Document document = SAXReaderUtil.read(content);

			Node node = document
					.selectSingleNode("/root/dynamic-element[@field-reference='" + Key + "']/dynamic-content");

			if (Validator.isNotNull(node)) {
				return fieldValue = node.getText();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return fieldValue;
	}

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	private static final Log logger = LogFactoryUtil.getLog(DownloadTraineeResultMVCResourceCommand.class);
}
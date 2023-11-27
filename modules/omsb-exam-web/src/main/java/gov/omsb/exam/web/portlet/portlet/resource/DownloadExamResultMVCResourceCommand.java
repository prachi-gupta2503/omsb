package gov.omsb.exam.web.portlet.portlet.resource;

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

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.DOWNLOAD_RESULT }, service = MVCResourceCommand.class)

public class DownloadExamResultMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(resourceRequest, OMSBExamWebPortletKeys.CMD);
		if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.DOWNLOAD_EXAM_RESULT)) {
			downloadExamResult(themeDisplay, resourceRequest, resourceResponse);
		}
	}

	public void downloadExamResult(ThemeDisplay themeDisplay, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		try {
			byte[] pdfContent = generatePdfContent(themeDisplay, resourceRequest, resourceResponse);

			resourceResponse.setContentType("application/pdf");
			resourceResponse.setContentLength(pdfContent.length);
			resourceResponse.setProperty("Content-Disposition", "attachment; filename=exam-result.pdf");

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
					MVCCommands.DOWNLOAD_TRAINEE_RESULT);

			String resultContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {

				String content = article.getContentByLocale("en_US");
				resultContent = readXMLData(content, "emailContent");

				String omsbId = ParamUtil.getString(resourceRequest, MVCCommands.TRAINEE_OMSB_ID);
				String finalResult = ParamUtil.getString(resourceRequest, MVCCommands.TRAINEE_FINAL_RESULT);
				String percentage = ParamUtil.getString(resourceRequest, MVCCommands.TRAINEE_PERCENTAGE);
				String examRefNo = ParamUtil.getString(resourceRequest, MVCCommands.TRAINEE_REF_NUMBER);
				String examType = ParamUtil.getString(resourceRequest, MVCCommands.TRAINEE_EXAM_TYPE);
				String programName = ParamUtil.getString(resourceRequest, MVCCommands.PROGRAM_NAME);

				User user = UserLocalServiceUtil.getUser(Long.valueOf(omsbId));
				FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
				String userPortraitURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "");
//				String userPortraitURL = user.getPortraitURL(themeDisplay);
				 logger.info("userPortraitURL::"+userPortraitURL);
				resultContent = resultContent.replace("$[userPortraitURL]", userPortraitURL);
				resultContent = resultContent.replace("$[candidateId]", omsbId);
				resultContent = resultContent.replace("$[candidate]", user.getFullName());
				resultContent = resultContent.replace("$[result]", finalResult);
				resultContent = resultContent.replace("$[examCode]", examRefNo);
				resultContent = resultContent.replace("$[percentage]", percentage);
				resultContent = resultContent.replace("$[examType]", examType);
				resultContent = resultContent.replace("$[registrationId]", examRefNo);
				resultContent = resultContent.replace("$[validateionId]", examRefNo);
				resultContent = resultContent.replace("$[programName]", programName);

			}

			Path dirPath = Paths.get(OMSBExamWebPortletKeys.OCT_EXAM_FILE_PATH);
			if (!Files.exists(dirPath)) {
				Files.createDirectory(dirPath);

				Path filePath = dirPath.resolve(OMSBExamWebPortletKeys.OCT_EXAM_FILE_NAME);
				if (!Files.exists(filePath)) {
					Files.createFile(filePath);
				}
			}
			File file = new File(OMSBExamWebPortletKeys.OCT_EXAM_FILE_PATH + OMSBExamWebPortletKeys.OCT_EXAM_FILE_NAME);
			PdfDocument pdfDocument = new PdfDocument(new PdfWriter(file));
			ConverterProperties properties = new ConverterProperties();
			Rectangle rect = new Rectangle(750, 1000);
			pdfDocument.setDefaultPageSize(new PageSize(rect));
			properties.setBaseUri(OMSBExamWebPortletKeys.OCT_EXAM_IMAGE_FILE_PATH);
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
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ExamUtil examUtil;

	private static final Log logger = LogFactoryUtil.getLog(DownloadExamResultMVCResourceCommand.class);
}
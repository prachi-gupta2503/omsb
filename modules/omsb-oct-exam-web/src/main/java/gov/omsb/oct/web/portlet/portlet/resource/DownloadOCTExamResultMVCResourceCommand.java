package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResult;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_OCT_EXAM_RESULT }, service = MVCResourceCommand.class

)
public class DownloadOCTExamResultMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws JSONException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		logger.info("Inside the doServeResource");
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		System.out.println(cmd);
		if (cmd.equalsIgnoreCase(OmsbOctExamWebPortletKeys.VIEW_OCT_EXAM_RESULT_EXCEL)) {
			downloadExcelExamResult(themeDisplay, resourceRequest, resourceResponse);
		}
	}

	public void downloadExcelExamResult(ThemeDisplay themeDisplay, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		logger.info("Inside the downloadExcelExamResult");
			long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet(OmsbOctExamWebPortletKeys.OCT_RESULT_TEMPLATE_SHEET);
			XSSFFont font = workbook.createFont();
			font.setBold(true);
			font.setFontName(OmsbOctExamWebPortletKeys.CALIBRI);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			XSSFRow row = sheet.createRow(0);
			row.setHeightInPoints(15);
			
//			row.createCell(0).setCellValue(OmsbOctExamWebPortletKeys.CANDIDATE_ID);
//			row.getCell(0).setCellStyle(style);
////			
//			row.createCell(1).setCellValue(OmsbOctExamWebPortletKeys.FULL_NAME);
//			row.getCell(1).setCellStyle(style);
//			row.createCell(2).setCellValue(OmsbOctExamWebPortletKeys.RESULT);
//			row.getCell(2).setCellStyle(style);
//			row.createCell(3).setCellValue(OmsbOctExamWebPortletKeys.PERCENTAGE_EXCEL);
//			row.getCell(3).setCellStyle(style);
//			row.createCell(4).setCellValue(OmsbOctExamWebPortletKeys.APPEARED_EXCEL);
//			row.getCell(4).setCellStyle(style);
			
		    String[] columnTitles = {
		            OmsbOctExamWebPortletKeys.CANDIDATE_ID,
		            OmsbOctExamWebPortletKeys.FULL_NAME,
		            OmsbOctExamWebPortletKeys.RESULT,
		            OmsbOctExamWebPortletKeys.PERCENTAGE_EXCEL,
		            OmsbOctExamWebPortletKeys.APPEARED_EXCEL
		        };
		    int[] columnWidths = {
		    	    5000, 
		    	    5000, 
		    	    3000, 
		    	    4000, 
		    	    3000  
		    	};
		        for (int i = 0; i < columnTitles.length; i++) {
		            row.createCell(i).setCellValue(columnTitles[i]);
		            row.getCell(i).setCellStyle(style);
		            sheet.setColumnWidth(i, columnWidths[i]);
		        }
		        
//			int lastColumnIndex = sheet.getRow(0).getLastCellNum() - 1;
//			for (int i = 0; i <= lastColumnIndex; i++) {
//				sheet.autoSizeColumn(i);
//			}

			XSSFFont fontData = workbook.createFont();
			fontData.setFontName(OmsbOctExamWebPortletKeys.CALIBRI);
			CellStyle styleData = workbook.createCellStyle();
			styleData.setFont(fontData);
			styleData.setBorderTop(BorderStyle.THIN);
			styleData.setBorderBottom(BorderStyle.THIN);
			styleData.setBorderLeft(BorderStyle.THIN);
			styleData.setBorderRight(BorderStyle.THIN);

			List<OCTRegistration> registrations = examUtil.getOCTRegistrationByScheduleIdAndStatus(themeDisplay, examScheduleId, OCTExamConstants.REGISTERED_STATUS_KEY);
			logger.info("registrations size::: " + registrations.size());
			int rowNum = 1;
			for (OCTRegistration registration : registrations) {
				OCTExamResultItem examResult = examUtil.getOCTExamResultByUserId(themeDisplay, registration.getLrUserId());
					XSSFRow columnData = sheet.createRow(rowNum);
					logger.info("FullName::::" + registration.getName());
					
					columnData.createCell(0).setCellValue(registration.getLrUserId());
					columnData.getCell(0).setCellStyle(styleData);
					
					columnData.createCell(1).setCellValue(registration.getName());
					columnData.getCell(1).setCellStyle(styleData);
					
					if (Validator.isNotNull(examResult)) {
						logger.info("exam result::"+examResult.getResult());
						
						
						columnData.createCell(2).setCellValue(examResult.getResult());
						columnData.getCell(2).setCellStyle(styleData);
						columnData.createCell(3).setCellValue(examResult.getPercentage());
						columnData.getCell(3).setCellStyle(styleData);
						columnData.createCell(4).setCellValue(examResult.isAppeared());
						columnData.getCell(4).setCellStyle(styleData);
						
					}
					rowNum++;
					
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			workbook.write(baos);
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);

			ServletResponseUtil.sendFile(httpRequest, httpResponse, OmsbOctExamWebPortletKeys.OCT_RESULT_TEMPLATE,
					baos.toByteArray(), ContentTypes.APPLICATION_VND_MS_EXCEL);
			baos.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	Log logger = LogFactoryUtil.getLog(DownloadOCTExamResultMVCResourceCommand.class);
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil examUtil;
}

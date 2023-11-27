package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayOutputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.DOWNLOAD_TRAINEE_LIST }, service = MVCActionCommand.class)
public class DownloadTraineeListMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		downloadListOfSelectedTrainees(themeDisplay, actionRequest, actionResponse);
	}
	public void downloadListOfSelectedTrainees(ThemeDisplay themeDisplay, ActionRequest actionRequest,
			ActionResponse actionResponse) {
		logger.info("downloadListOfSelectedTrainees () started ");
		String traineeList = ParamUtil.getString(actionRequest, OmsbOctExamWebPortletKeys.SELECTED_TRAINEES);
		String examTitle = ParamUtil.getString(actionRequest, OmsbOctExamWebPortletKeys.EXAM_TITLES);
		logger.info("examTitle "+examTitle);
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet(OmsbOctExamWebPortletKeys.RESULT);
			XSSFFont font = workbook.createFont();
			font.setBold(true);
			font.setFontName(OmsbOctExamWebPortletKeys.CALIBRI);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);

			XSSFCellStyle valueStyle = workbook.createCellStyle();
			valueStyle.setBorderTop(BorderStyle.THIN);
			valueStyle.setBorderBottom(BorderStyle.THIN);
			valueStyle.setBorderLeft(BorderStyle.THIN);
			valueStyle.setBorderRight(BorderStyle.THIN);

			XSSFRow row = sheet.createRow(0);
			row.createCell(4).setCellValue(OmsbOctExamWebPortletKeys.TRAINEE_LIST);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 5));

			XSSFRow firstRow = sheet.createRow(2);
			firstRow.setHeightInPoints(15);

			firstRow.createCell(0).setCellValue(OmsbOctExamWebPortletKeys.FULL_NAME);
			firstRow.getCell(0).setCellStyle(style);
			sheet.setColumnWidth(0, 3000);

			firstRow.createCell(1).setCellValue(OmsbOctExamWebPortletKeys.OMSB_ID);
			firstRow.getCell(1).setCellStyle(style);
			sheet.setColumnWidth(4, 3000);

			firstRow.createCell(2).setCellValue(OmsbOctExamWebPortletKeys.EXAM_TITLE);
			firstRow.getCell(2).setCellStyle(style);
			sheet.setColumnWidth(7, 3000);

			firstRow.createCell(3).setCellValue(OmsbOctExamWebPortletKeys.NO_OF_ATTEMPTS);
			firstRow.getCell(3).setCellStyle(style);
			sheet.setColumnWidth(4, 3000);

			firstRow.createCell(4).setCellValue(OmsbOctExamWebPortletKeys.DATE_OF_PAYMENT);
			firstRow.getCell(4).setCellStyle(style);
			sheet.setColumnWidth(4, 3000);

			firstRow.createCell(5).setCellValue(OmsbOctExamWebPortletKeys.TRAINING_LEVEL);
			firstRow.getCell(5).setCellStyle(style);
			sheet.setColumnWidth(4, 3000);

			firstRow.createCell(6).setCellValue(OmsbOctExamWebPortletKeys.EMAIL_ADDRESS);
			firstRow.getCell(6).setCellStyle(style);
			sheet.setColumnWidth(7, 3000);

			firstRow.createCell(7).setCellValue(OmsbOctExamWebPortletKeys.PHONE_NUMBER);
			firstRow.getCell(7).setCellStyle(style);
			sheet.setColumnWidth(7, 3000);

			firstRow.createCell(8).setCellValue(OmsbOctExamWebPortletKeys.GENDER);
			firstRow.getCell(8).setCellStyle(style);
			sheet.setColumnWidth(4, 3000);
			logger.info("trainee list size:"+traineeList);
			if (Validator.isNotNull(traineeList)) {
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(traineeList);
				int rowData = 3;
				for (int i = 0; i < jsonArray.length(); i++) {

					XSSFRow values = sheet.createRow(rowData++);
					JSONObject jsonValue = jsonArray.getJSONObject(i);
					long userId = Integer.parseInt(jsonValue.getString("omsbId"));
					logger.info("userId::"+userId);
					
					User user = userLocalService.getUser(userId);
					logger.info("user name::"+user.getFullName());
					
					values.createCell(0).setCellValue(user.getFullName());
					values.getCell(0).setCellStyle(valueStyle);

					values.createCell(1).setCellValue(user.getUserId());
					values.getCell(1).setCellStyle(valueStyle);

					values.createCell(6).setCellValue(user.getEmailAddress());
					values.getCell(6).setCellStyle(valueStyle);

					values.createCell(4).setCellValue("");
					values.getCell(4).setCellStyle(valueStyle);

					values.createCell(5).setCellValue("");
					values.getCell(5).setCellStyle(valueStyle);

					OCTRegistrationItem registrationItem = octExamUtil.getExamRegistrationByUserId(themeDisplay, userId);

					if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())) {

						registrationItem.sortByIdInReverseOrder();

						values.createCell(2).setCellValue(examTitle);
						values.getCell(2).setCellStyle(valueStyle);

						values.createCell(5).setCellValue(registrationItem.getItems().get(0).getDateOfPayment());
						values.getCell(5).setCellStyle(valueStyle);

					}

					PersonalDetailItem personalDetailItem = octExamUtil.getPersonalDetailsByUserId(themeDisplay, userId);

					if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())) {

						values.createCell(7).setCellValue(personalDetailItem.getItems().get(0).getMobileNumber());
						values.getCell(7).setCellStyle(valueStyle);

						values.createCell(8).setCellValue(octExamUtil.getGenderByGenderId(personalDetailItem.getItems().get(0).getGenderId()));
						values.getCell(8).setCellStyle(valueStyle);
					}
				}
			}

			int lastColumnIndex = sheet.getRow(2).getLastCellNum() - 1;

			for (int i = 0; i <= lastColumnIndex; i++) {
				sheet.autoSizeColumn(i);
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			workbook.write(baos);

			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(actionResponse);

			ServletResponseUtil.sendFile(httpRequest, httpResponse, OmsbOctExamWebPortletKeys.LIST_OF_TRAINEES,
					baos.toByteArray(), ContentTypes.APPLICATION_VND_MS_EXCEL);

			baos.close();
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("downloadListOfSelectedTrainees () ended ");
	}
	
	
	
	@Reference(unbind = "_")
	private UserLocalService userLocalService;
	
	@Reference
	private OCTExamUtil octExamUtil;
	
	private Log logger = LogFactoryUtil.getLog(DownloadTraineeListMVCActionCommand.class);
}



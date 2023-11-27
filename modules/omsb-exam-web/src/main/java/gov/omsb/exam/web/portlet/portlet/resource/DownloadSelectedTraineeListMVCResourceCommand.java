package gov.omsb.exam.web.portlet.portlet.resource;

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

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.portlet.action.SaveExamScheduleMVCActionCommand;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.DOWNLOAD_TRAINEE_LIST }, service = MVCActionCommand.class)

public class DownloadSelectedTraineeListMVCResourceCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(actionRequest, OMSBExamWebPortletKeys.CMD);

		String exam = ParamUtil.getString(actionRequest, "examType");
		logger.info("Exam Type ..... " + exam);

		if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.DOWNLOAD_TRAINEES)
				&& exam.equalsIgnoreCase(OMSBExamWebPortletKeys.SELECTION_EXAM)) {

			downloadSelectionExamListOfSelectedTrainees(themeDisplay, actionRequest, actionResponse);

		} else if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.DOWNLOAD_TRAINEES)) {
			downloadListOfSelectedTrainees(themeDisplay, actionRequest, actionResponse);
		}
	}

	public void downloadListOfSelectedTrainees(ThemeDisplay themeDisplay, ActionRequest resourceRequest,
			ActionResponse resourceResponse) {

		String traineeList = ParamUtil.getString(resourceRequest, OMSBExamWebPortletKeys.SELECTED_TRAINEES);

		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet(OMSBExamWebPortletKeys.RESULT);
			XSSFFont font = workbook.createFont();
			font.setBold(true);
			font.setFontName(OMSBExamWebPortletKeys.CALIBRI);
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
			row.createCell(4).setCellValue(OMSBExamWebPortletKeys.TRAINEE_LIST);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 5));

			XSSFRow firstRow = sheet.createRow(2);
			firstRow.setHeightInPoints(15);

			firstRow.createCell(0).setCellValue(OMSBExamWebPortletKeys.FULL_NAME);
			firstRow.getCell(0).setCellStyle(style);
			sheet.setColumnWidth(0, 3000);

			firstRow.createCell(1).setCellValue(OMSBExamWebPortletKeys.OMSB_ID);
			firstRow.getCell(1).setCellStyle(style);
			sheet.setColumnWidth(1, 3000);

			firstRow.createCell(2).setCellValue(OMSBExamWebPortletKeys.PROGRAM);
			firstRow.getCell(2).setCellStyle(style);
			sheet.setColumnWidth(2, 3000);

			firstRow.createCell(3).setCellValue(OMSBExamWebPortletKeys.EXAM_TYPE);
			firstRow.getCell(3).setCellStyle(style);
			sheet.setColumnWidth(3, 3000);

			firstRow.createCell(4).setCellValue(OMSBExamWebPortletKeys.NO_OF_ATTEMPTS);
			firstRow.getCell(4).setCellStyle(style);
			sheet.setColumnWidth(4, 3000);

			firstRow.createCell(5).setCellValue(OMSBExamWebPortletKeys.DATE_OF_PAYMENT);
			firstRow.getCell(5).setCellStyle(style);
			sheet.setColumnWidth(5, 3000);

			firstRow.createCell(6).setCellValue(OMSBExamWebPortletKeys.TRAINING_LEVEL);
			firstRow.getCell(6).setCellStyle(style);
			sheet.setColumnWidth(6, 3000);

			firstRow.createCell(7).setCellValue(OMSBExamWebPortletKeys.EMAIL_ADDRESS);
			firstRow.getCell(7).setCellStyle(style);
			sheet.setColumnWidth(7, 3000);

			firstRow.createCell(8).setCellValue(OMSBExamWebPortletKeys.PHONE_NUMBER);
			firstRow.getCell(8).setCellStyle(style);
			sheet.setColumnWidth(8, 3000);

			firstRow.createCell(9).setCellValue(OMSBExamWebPortletKeys.GENDER);
			firstRow.getCell(9).setCellStyle(style);
			sheet.setColumnWidth(9, 3000);

			if (Validator.isNotNull(traineeList)) {
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(traineeList);
				int rowData = 3;
				for (int i = 0; i < jsonArray.length(); i++) {

					XSSFRow values = sheet.createRow(rowData++);
					JSONObject jsonValue = jsonArray.getJSONObject(i);
					long userId = Integer.parseInt(jsonValue.getString("omsbId"));
					User user = userLocalService.getUser(userId);

					values.createCell(0).setCellValue(user.getFullName());
					values.getCell(0).setCellStyle(valueStyle);

					values.createCell(1).setCellValue(user.getUserId());
					values.getCell(1).setCellStyle(valueStyle);

					values.createCell(7).setCellValue(user.getEmailAddress());
					values.getCell(7).setCellStyle(valueStyle);

					values.createCell(4).setCellValue("");
					values.getCell(4).setCellStyle(valueStyle);

					values.createCell(6).setCellValue("");
					values.getCell(6).setCellStyle(valueStyle);

					RegistrationItem registrationItem = examUtil.getExamRegistrationByUserId(themeDisplay, userId);

					if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())) {

						registrationItem.sortByIdInReverseOrder();

						String programName = examUtil
								.getProgramByProgramId(registrationItem.getItems().get(0).getProgramId(), themeDisplay);

						String examType = examUtil.getExamType(registrationItem.getItems().get(0).getExamTypeId(),
								themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale());

						values.createCell(2).setCellValue(programName);
						values.getCell(2).setCellStyle(valueStyle);

						values.createCell(3).setCellValue(examType);
						values.getCell(3).setCellStyle(valueStyle);

						values.createCell(5).setCellValue(registrationItem.getItems().get(0).getDateOfPayment());
						values.getCell(5).setCellStyle(valueStyle);

					}

					PersonalDetailItem personalDetailItem = examUtil.getPersonalDetailsByUserId(themeDisplay, userId);

					if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())) {

						values.createCell(8).setCellValue(personalDetailItem.getItems().get(0).getMobileNumber());
						values.getCell(8).setCellStyle(valueStyle);

						values.createCell(9).setCellValue(personalDetailItem.getItems().get(0).getGenderId());
						values.getCell(9).setCellStyle(valueStyle);
					}
				}
			}

			int lastColumnIndex = sheet.getRow(2).getLastCellNum() - 1;

			for (int i = 0; i <= lastColumnIndex; i++) {
				sheet.autoSizeColumn(i);
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			workbook.write(baos);

			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);

			ServletResponseUtil.sendFile(httpRequest, httpResponse, OMSBExamWebPortletKeys.LIST_OF_TRAINEES,
					baos.toByteArray(), ContentTypes.APPLICATION_VND_MS_EXCEL);

			baos.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void downloadSelectionExamListOfSelectedTrainees(ThemeDisplay themeDisplay, ActionRequest resourceRequest,
			ActionResponse resourceResponse) {

		String traineeList = ParamUtil.getString(resourceRequest, OMSBExamWebPortletKeys.SELECTED_TRAINEES);

		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet(OMSBExamWebPortletKeys.RESULT);
			XSSFFont font = workbook.createFont();
			font.setBold(true);
			font.setFontName(OMSBExamWebPortletKeys.CALIBRI);
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
			row.createCell(4).setCellValue(OMSBExamWebPortletKeys.TRAINEE_LIST);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 5));

			XSSFRow firstRow = sheet.createRow(2);
			firstRow.setHeightInPoints(15);

			firstRow.createCell(0).setCellValue(OMSBExamWebPortletKeys.FULL_NAME);
			firstRow.getCell(0).setCellStyle(style);
			sheet.setColumnWidth(0, 3000);

			firstRow.createCell(1).setCellValue(OMSBExamWebPortletKeys.CIVIL_ID);
			firstRow.getCell(1).setCellStyle(style);
			sheet.setColumnWidth(1, 3000);

			firstRow.createCell(2).setCellValue(OMSBExamWebPortletKeys.NATIONALITY);
			firstRow.getCell(2).setCellStyle(style);
			sheet.setColumnWidth(2, 3000);

			firstRow.createCell(3).setCellValue(OMSBExamWebPortletKeys.PASSPORT_NO);
			firstRow.getCell(3).setCellStyle(style);
			sheet.setColumnWidth(3, 3000);

			firstRow.createCell(4).setCellValue(OMSBExamWebPortletKeys.SCHOOL_OF_GRADUATES);
			firstRow.getCell(4).setCellStyle(style);
			sheet.setColumnWidth(4, 3000);

			firstRow.createCell(5).setCellValue(OMSBExamWebPortletKeys.YEAR_OF_GRADUATE);
			firstRow.getCell(5).setCellStyle(style);
			sheet.setColumnWidth(5, 3000);

			firstRow.createCell(6).setCellValue(OMSBExamWebPortletKeys.EXAM_TYPE);
			firstRow.getCell(6).setCellStyle(style);
			sheet.setColumnWidth(6, 3000);

			firstRow.createCell(7).setCellValue(OMSBExamWebPortletKeys.NO_OF_ATTEMPTS);
			firstRow.getCell(7).setCellStyle(style);
			sheet.setColumnWidth(7, 3000);

			firstRow.createCell(8).setCellValue(OMSBExamWebPortletKeys.DATE_OF_PAYMENT);
			firstRow.getCell(8).setCellStyle(style);
			sheet.setColumnWidth(8, 3000);

			firstRow.createCell(9).setCellValue(OMSBExamWebPortletKeys.TRAINING_LEVEL);
			firstRow.getCell(9).setCellStyle(style);
			sheet.setColumnWidth(9, 3000);

			firstRow.createCell(10).setCellValue(OMSBExamWebPortletKeys.EMAIL_ADDRESS);
			firstRow.getCell(10).setCellStyle(style);
			sheet.setColumnWidth(10, 3000);

			firstRow.createCell(11).setCellValue(OMSBExamWebPortletKeys.PHONE_NUMBER);
			firstRow.getCell(11).setCellStyle(style);
			sheet.setColumnWidth(11, 3000);

			firstRow.createCell(12).setCellValue(OMSBExamWebPortletKeys.GENDER);
			firstRow.getCell(12).setCellStyle(style);
			sheet.setColumnWidth(12, 3000);

			if (Validator.isNotNull(traineeList)) {
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(traineeList);
				int rowData = 3;
				for (int i = 0; i < jsonArray.length(); i++) {

					XSSFRow values = sheet.createRow(rowData++);
					JSONObject jsonValue = jsonArray.getJSONObject(i);
					long userId = Integer.parseInt(jsonValue.getString("omsbId"));
					User user = userLocalService.getUser(userId);

					values.createCell(0).setCellValue(user.getFullName());
					values.getCell(0).setCellStyle(valueStyle);

					values.createCell(10).setCellValue(user.getEmailAddress());
					values.getCell(10).setCellStyle(valueStyle);

					values.createCell(2).setCellValue("");
					values.getCell(2).setCellStyle(valueStyle);

					values.createCell(4).setCellValue("");
					values.getCell(4).setCellStyle(valueStyle);

					values.createCell(5).setCellValue("");
					values.getCell(5).setCellStyle(valueStyle);

					values.createCell(7).setCellValue("");
					values.getCell(7).setCellStyle(valueStyle);

					values.createCell(9).setCellValue("");
					values.getCell(9).setCellStyle(valueStyle);

					PersonItem personItem = examUtil.getPersonByUserId(themeDisplay, userId);

					if (Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems())) {

						values.createCell(1).setCellValue(personItem.getItems().get(0).getCivilId());
						values.getCell(1).setCellStyle(valueStyle);

						values.createCell(3).setCellValue(personItem.getItems().get(0).getPassportNumber());
						values.getCell(3).setCellStyle(valueStyle);

					}

					RegistrationItem registrationItem = examUtil.getExamRegistrationByUserId(themeDisplay, userId);

					if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())) {

						registrationItem.sortByIdInReverseOrder();

						String examType = examUtil.getExamType(registrationItem.getItems().get(0).getExamTypeId(),
								themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale());

						values.createCell(6).setCellValue(examType);
						values.getCell(6).setCellStyle(valueStyle);

						values.createCell(8).setCellValue(registrationItem.getItems().get(0).getDateOfPayment());
						values.getCell(8).setCellStyle(valueStyle);

					}

					PersonalDetailItem personalDetailItem = examUtil.getPersonalDetailsByUserId(themeDisplay, userId);

					if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())) {

						values.createCell(11).setCellValue(personalDetailItem.getItems().get(0).getMobileNumber());
						values.getCell(11).setCellStyle(valueStyle);

						values.createCell(12).setCellValue(personalDetailItem.getItems().get(0).getGenderId());
						values.getCell(12).setCellStyle(valueStyle);
					}
				}
			}

			int lastColumnIndex = sheet.getRow(2).getLastCellNum() - 1;

			for (int i = 0; i <= lastColumnIndex; i++) {
				sheet.autoSizeColumn(i);
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			workbook.write(baos);

			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);

			ServletResponseUtil.sendFile(httpRequest, httpResponse, OMSBExamWebPortletKeys.LIST_OF_TRAINEES,
					baos.toByteArray(), ContentTypes.APPLICATION_VND_MS_EXCEL);

			baos.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ScheduleUtil scheduleUtil;

	@Reference(unbind = "-")
	private ExamUtil examUtil;

	@Reference(unbind = "_")
	private UserLocalService userLocalService;

	private Log logger = LogFactoryUtil.getLog(SaveExamScheduleMVCActionCommand.class);

}

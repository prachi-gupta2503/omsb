package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamResult;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_EXAM_RESULT }, service = MVCResourceCommand.class

)
public class ViewExamResultMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws JSONException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.VIEW_EXAM_RESULT_EXCEL)) {
			downloadExcelExamResult(themeDisplay, resourceRequest, resourceResponse);
		}
	}

	public void downloadExcelExamResult(ThemeDisplay themeDisplay, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
			long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
			long examDefinitionId = ParamUtil.getLong(resourceRequest, "examDefinitionId");
			long examTypeId = ParamUtil.getLong(resourceRequest, "examTypeId");
			long programId = ParamUtil.getLong(resourceRequest, "programId");
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet(OMSBExamWebPortletKeys.RESULT_TEMPLATE_SHEET);
			XSSFFont font = workbook.createFont();
			font.setBold(true);
			font.setFontName(OMSBExamWebPortletKeys.CALIBRI);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			XSSFRow row = sheet.createRow(0);
			row.setHeightInPoints(15);
			/*
			 * row.createCell(0).setCellValue(OMSBExamWebPortletKeys.FULL_NAME);
			 * row.getCell(0).setCellStyle(style);
			 * row.createCell(1).setCellValue(OMSBExamWebPortletKeys.RESULT);
			 * row.getCell(1).setCellStyle(style);
			 * row.createCell(2).setCellValue(OMSBExamWebPortletKeys.PERCENTAGE);
			 * row.getCell(2).setCellStyle(style);
			 * row.createCell(3).setCellValue(OMSBExamWebPortletKeys.APPEARED);
			 * row.getCell(3).setCellStyle(style); int lastColumnIndex =
			 * sheet.getRow(0).getLastCellNum() - 1; for (int i = 0; i <= lastColumnIndex;
			 * i++) { sheet.autoSizeColumn(i); }
			 */
			 String[] columnTitles = {
					 OMSBExamWebPortletKeys.OMSB_ID,
					 OMSBExamWebPortletKeys.FULL_NAME,
					 OMSBExamWebPortletKeys.EXAM_PROGRAM_NAME,
					 OMSBExamWebPortletKeys.EXAM_TYPE,
					 OMSBExamWebPortletKeys.NO_OF_ATTEMPTS,
					 OMSBExamWebPortletKeys.DATE_OF_PREVIOUS_ATTEMPT,
					 OMSBExamWebPortletKeys.TRAINING_LEVEL,
					 OMSBExamWebPortletKeys.EMAIL_ID,
					 OMSBExamWebPortletKeys.PHONE_NO,
					 OMSBExamWebPortletKeys.GENDER,
					 OMSBExamWebPortletKeys.RESULT,
					 OMSBExamWebPortletKeys.EXAM_PERCENTAGE,
					 OMSBExamWebPortletKeys.EXAM_APPEARED
			        };
			    int[] columnWidths = {5000, 5000, 3000, 4000, 4000, 4000, 4000, 4000, 6000, 3000,
			    		3000, 3000, 3000
			    	};
			        for (int i = 0; i < columnTitles.length; i++) {
			            row.createCell(i).setCellValue(columnTitles[i]);
			            row.getCell(i).setCellStyle(style);
			            sheet.setColumnWidth(i, columnWidths[i]);
			        }

			XSSFFont fontData = workbook.createFont();
			fontData.setFontName(OMSBExamWebPortletKeys.CALIBRI);
			CellStyle styleData = workbook.createCellStyle();
			styleData.setFont(fontData);
			styleData.setBorderTop(BorderStyle.THIN);
			styleData.setBorderBottom(BorderStyle.THIN);
			styleData.setBorderLeft(BorderStyle.THIN);
			styleData.setBorderRight(BorderStyle.THIN);

			List<Registration> registrations = examUtil.getRegistrationByScheduleId(themeDisplay, examTypeId, programId, examScheduleId, examDefinitionId);
			logger.info("registrations size::: " + registrations.size());
			int rowNum = 1;
			for (Registration registration : registrations) {
				
				ExamResult examResult = examUtil.getExamResultByUserId(themeDisplay, registration.getLrUserId());
					XSSFRow columnData = sheet.createRow(rowNum);
					logger.info("FullName::::" + registration.getName());
					columnData.createCell(0).setCellValue(registration.getLrUserId());
					columnData.getCell(0).setCellStyle(styleData);
					columnData.createCell(1).setCellValue(registration.getName());
					columnData.getCell(1).setCellStyle(styleData);
					if(programId > 0) {
						columnData.createCell(2).setCellValue(examUtil.getProgramByProgramId(programId, themeDisplay));
						columnData.getCell(2).setCellStyle(styleData);
					} 
					if(examTypeId > 0) {
						columnData.createCell(3).setCellValue(examUtil.getExamType(examTypeId, themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
						columnData.getCell(3).setCellStyle(styleData);
					}
					columnData.createCell(4).setCellValue(registration.getNoOfAttempt());
					columnData.getCell(4).setCellStyle(styleData);
					
					columnData.createCell(5).setCellValue("");
					columnData.getCell(5).setCellStyle(styleData);
					
					columnData.createCell(6).setCellValue("");
					columnData.getCell(6).setCellStyle(styleData);
					
					
					try {
						User user = UserLocalServiceUtil.getUser(registration.getLrUserId());
						if(Validator.isNotNull(user)) {
							columnData.createCell(7).setCellValue(user.getEmailAddress());
							columnData.getCell(7).setCellStyle(styleData);
							List<Person> person = examUtil.getPersonDetail(themeDisplay, user.getUserId());
							if(Validator.isNotNull(person) && !person.isEmpty()) {
							List<PersonalDetail> personalDetailItem = examUtil.getPersonalDetail(themeDisplay, person.get(0).getId());
								if (Validator.isNotNull(personalDetailItem) && !personalDetailItem.isEmpty()) {
									columnData.createCell(8).setCellValue(personalDetailItem.get(0).getMobileNumber());
									columnData.getCell(8).setCellStyle(styleData);
									if (personalDetailItem.get(0).getGenderId() > 0) {
										columnData.createCell(9).setCellValue(examUtil.getGenderName(personalDetailItem));
										columnData.getCell(9).setCellStyle(styleData);
									}
								}
							}
							
						}
					}catch (Exception e) {
						logger.error("user is not found with this user id: "+registration.getLrUserId());
					}
					
					if (Validator.isNotNull(examResult) && Validator.isNotNull(examResult.getItems())
							&& !examResult.getItems().isEmpty()) {
						ExamResultItem examResultItem = examResult.getItems().get(0);
						logger.info("exam result::"+examResultItem.getResult());
						columnData.createCell(10).setCellValue(examResultItem.getResult());
						columnData.getCell(10).setCellStyle(styleData);
						columnData.createCell(11).setCellValue(examResultItem.getPercentage());
						columnData.getCell(11).setCellStyle(styleData);
						columnData.createCell(12).setCellValue(examResultItem.isAppeared());
						columnData.getCell(12).setCellStyle(styleData);
					}
					rowNum++;
					
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			workbook.write(baos);
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);

			ServletResponseUtil.sendFile(httpRequest, httpResponse, OMSBExamWebPortletKeys.RESULT_TEMPLATE,
					baos.toByteArray(), ContentTypes.APPLICATION_VND_MS_EXCEL);
			baos.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	Log logger = LogFactoryUtil.getLog(ViewExamResultMVCResourceCommand.class);
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ExamUtil examUtil;
}

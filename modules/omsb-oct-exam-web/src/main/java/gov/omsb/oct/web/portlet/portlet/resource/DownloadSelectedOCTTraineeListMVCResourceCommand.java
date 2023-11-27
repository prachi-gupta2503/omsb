package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.petra.string.StringPool;
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
import java.net.URLEncoder;
import java.util.Map;

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
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" +OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.DOWNLOAD_OCT_TRAINEE_LIST }, service = MVCActionCommand.class)

public class DownloadSelectedOCTTraineeListMVCResourceCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(actionRequest, OmsbOctExamWebPortletKeys.CMD);
		if (cmd.equalsIgnoreCase(OmsbOctExamWebPortletKeys.DOWNLOAD_OCT_TRAINEES)) {
			downloadListOfSelectedTrainees(themeDisplay, actionRequest, actionResponse);
		}
	}

	public void downloadListOfSelectedTrainees(ThemeDisplay themeDisplay, ActionRequest resourceRequest,
			ActionResponse resourceResponse) {

		String traineeList = ParamUtil.getString(resourceRequest, OmsbOctExamWebPortletKeys.SELECTED_OCT_TRAINEES);
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
			row.createCell(3).setCellValue(OmsbOctExamWebPortletKeys.OCT_TRAINEE_LIST);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 4));

			XSSFRow firstRow = sheet.createRow(2);
			firstRow.setHeightInPoints(15);

			firstRow.createCell(0).setCellValue(OmsbOctExamWebPortletKeys.FULL_NAME);
			firstRow.getCell(0).setCellStyle(style);
			sheet.setColumnWidth(0, 3000);

			firstRow.createCell(1).setCellValue(OmsbOctExamWebPortletKeys.OMSB_ID);
			firstRow.getCell(1).setCellStyle(style);
			sheet.setColumnWidth(1, 3000);

			firstRow.createCell(2).setCellValue(OmsbOctExamWebPortletKeys.EMAIL_ADDRESS);
			firstRow.getCell(2).setCellStyle(style);
			sheet.setColumnWidth(2, 3000);

			firstRow.createCell(3).setCellValue(OmsbOctExamWebPortletKeys.PHONE_NUMBER);
			firstRow.getCell(3).setCellStyle(style);
			sheet.setColumnWidth(3, 3000);

//			firstRow.createCell(4).setCellValue(OmsbOctExamWebPortletKeys.PROGRAM);
//			firstRow.getCell(4).setCellStyle(style);
//
//			firstRow.createCell(5).setCellValue(OmsbOctExamWebPortletKeys.RESIDENCY_LEVEL);
//			firstRow.getCell(5).setCellStyle(style);

			firstRow.createCell(6).setCellValue(OmsbOctExamWebPortletKeys.NO_OF_ATTEMPTS);
			firstRow.getCell(6).setCellStyle(style);

			firstRow.createCell(7).setCellValue(OmsbOctExamWebPortletKeys.STATUS_OF_PAYMENT);
			firstRow.getCell(7).setCellStyle(style);

			if (Validator.isNotNull(traineeList)) {
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(traineeList);
				int rowData = 3;
				for (int i = 0; i < jsonArray.length(); i++) {

					XSSFRow values = sheet.createRow(rowData++);
					JSONObject jsonValue = jsonArray.getJSONObject(i);
					long userId = Integer.parseInt(jsonValue.getString("omsbId"));
					User user = userLocalService.getUser(userId);

					values.createCell(0).setCellValue(jsonValue.getString("firstName"));
					values.getCell(0).setCellStyle(valueStyle);

					values.createCell(1).setCellValue(jsonValue.getString("omsbId"));
					values.getCell(1).setCellStyle(valueStyle);

					values.createCell(2).setCellValue(user.getEmailAddress());
					values.getCell(2).setCellStyle(valueStyle);

					String personURL = themeDisplay.getPortalURL() + LRObjectURL.REG_PERSON_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
							+ "filter=lrUserId" + URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8);
					String personResponse = omsbCommonApi.getData(personURL);
					PersonItem person = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);

					String personDetailsURL = themeDisplay.getPortalURL() + LRObjectURL.REG_PERSONAL_DETAILS_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=personId"
							+ URLEncoder.encode(" eq " + person.getItems().get(0).getId(), DataflowConstants.UTF_8);
					String personalDetailsResponse = omsbCommonApi.getData(personDetailsURL);
					PersonalDetailItem personalDetails = CustomObjectMapperUtil.readValue(personalDetailsResponse,
							PersonalDetailItem.class);

					values.createCell(3).setCellValue(personalDetails.getItems().get(0).getMobileNumber());
					values.getCell(3).setCellStyle(valueStyle);

					String examRegistrationURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_REGISTERATION_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=lrUserId"
							+ URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8);
					String examRegistrationResponse = omsbCommonApi.getData(examRegistrationURL);
					OCTRegistrationItem registration = CustomObjectMapperUtil.readValue(examRegistrationResponse,
							OCTRegistrationItem.class);

					values.createCell(6).setCellValue(registration.getItems().get(0).getNoOfAttempt());
					values.getCell(6).setCellStyle(valueStyle);

//					String programName = examUtil.getProgramByProgramId(registration.getItems().get(0).getProgramId(),
//							themeDisplay);
//
//					values.createCell(4).setCellValue(programName);
					values.getCell(4).setCellStyle(valueStyle);
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

			ServletResponseUtil.sendFile(httpRequest, httpResponse, OmsbOctExamWebPortletKeys.LIST_OF_TRAINEES,
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
	private OCTExamUtil examUtil;

	@Reference(unbind = "_")
	private UserLocalService userLocalService;

	private Log logger = LogFactoryUtil.getLog(DownloadSelectedOCTTraineeListMVCResourceCommand.class);

}

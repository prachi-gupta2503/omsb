package gov.omsb.object.data.portlet;

import gov.omsb.object.data.constants.OmsbObjectDataImportPortletKeys;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionServiceUtil;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.ProcessAction;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

/**
 * @author AftabA
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbObjectDataImport",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmsbObjectDataImportPortletKeys.OMSBOBJECTDATAIMPORT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbObjectDataImportPortlet extends MVCPortlet {
	
	@ProcessAction(name ="importData") 
	public void importData(ActionRequest actionRequest, ActionResponse actionResponse) {
		logger.info("Invoking importData method::::::::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String erc = ParamUtil.getString(actionRequest, "erc");
		logger.info("erc ::::::::" + erc);
		addData(actionRequest, themeDisplay, erc);
	}
	
	public void executeDataImport(PortletRequest request, ThemeDisplay themeDisplay, String erc, Map<String, Serializable> values) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			ObjectDefinition definition = ObjectDefinitionServiceUtil.getObjectDefinitionByExternalReferenceCode(erc, themeDisplay.getCompanyId());
			if (definition != null) {
				ObjectEntryLocalServiceUtil.addObjectEntry(themeDisplay.getUserId(),
				  themeDisplay.getScopeGroupId(), definition.getObjectDefinitionId(),
				  values, serviceContext);
			}
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void addData(PortletRequest request,  ThemeDisplay themeDisplay, String erc) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		File file = uploadRequest.getFile("inputFile");
		try (InputStream inputStream = new FileInputStream(file);
				XSSFWorkbook  workbook = new XSSFWorkbook(inputStream);	
				){
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			logger.info("last row ?? " + sheet.getLastRowNum());
			XSSFRow headerRow = sheet.getRow(0);
			List<String> headerList = new ArrayList<>();
			for (int head = 0; head< headerRow.getLastCellNum(); head++) {
				headerList.add(headerRow.getCell(head).getStringCellValue());
			}
				
			 for(int i=1; i<= sheet.getLastRowNum(); i++){
				 Map<String, Serializable> dataMap = new HashMap<>();
				 XSSFRow row = sheet.getRow(i); 
				 logger.info("row index ?? " + i);
				 logger.info("last cell ?? " + row.getLastCellNum());
				 for (int j=0; j < row.getLastCellNum(); j++) {
					 logger.info("cell index ?? " + j);
					 
					 String cellValue = "";
                     if (row.getCell(j).getCellType() == CellType.STRING) {
                         cellValue = row.getCell(j).toString();
                     }
                     if (row.getCell(j).getCellType() == CellType.NUMERIC) {
                         cellValue = String.valueOf(row.getCell(j).getRawValue());
                     }

                     logger.info(" header value " + headerList.get(j) + "  cellValue ?? " + cellValue);
                     dataMap.put(headerList.get(j), cellValue);
				 }
				 executeDataImport(request, themeDisplay, erc, dataMap);
			 }
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private static final Log logger = LogFactoryUtil.getLog(OmsbObjectDataImportPortlet.class);
	
}
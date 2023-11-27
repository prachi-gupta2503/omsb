/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gov.omsb.form.builder.service.impl;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.form.builder.exception.NoSuchFormDefinitionException;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.model.FormRecordEntry;
import gov.omsb.form.builder.model.impl.FormDefinitionImpl;
import gov.omsb.form.builder.service.FormDefinitionLocalServiceUtil;
import gov.omsb.form.builder.service.FormRecordEntryLocalServiceUtil;
import gov.omsb.form.builder.service.base.FormDefinitionLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.form.builder.model.FormDefinition",
	service = AopService.class
)
public class FormDefinitionLocalServiceImpl
	extends FormDefinitionLocalServiceBaseImpl {
	/**
	 * Increamenting Primary key
	 */
	
	@Reference
	OMSBEmailTemplateMasterCommonApi emailTemplateMasterCommonApi;
	
	private static final Log log = LogFactoryUtil.getLog(FormDefinitionLocalServiceImpl.class);
	
	public FormDefinition getInstance() {
		FormDefinition formDefinition = new FormDefinitionImpl();
		return formDefinition;
	}
	/**
	 * Finder tag for UserId
	 * @throws NoSuchFormDefinitionException 
	 */
	public List<FormDefinition> findFormDefinitionByFormName(String formName) throws NoSuchFormDefinitionException {
		return formDefinitionPersistence.findByFormName(formName);
	}
	
	public FormDefinition findFormDefinitionByFormDefinitionIdAndFormVersion(long formDefinitionId,String formVersion) throws NoSuchFormDefinitionException  {
		return formDefinitionPersistence.findByFormDefinitionIdAndFormVersion(formDefinitionId, formVersion);
	}
	
	public void sendEmail(String fromAddress, String toAddress, String subject, String body, String[] ccAddress, String[] bccAddress) {
		emailTemplateMasterCommonApi.sendEmail(fromAddress, toAddress, subject, body, ccAddress, bccAddress);
	}
	
	public void sendEmailWithAttachment(String fromAddress, String toAddress, String subject, String body, List<File> attachments, String[] ccAddress, String[] bccAddress) {
		emailTemplateMasterCommonApi.sendEmailWithAttachments(fromAddress, toAddress, subject, body, attachments, ccAddress, bccAddress);
	}
	
	public List<File> fetchAttachments(long emailTemplateMasterId, long groupId) {
		return emailTemplateMasterCommonApi.fetchEmailTemplateAttachments(emailTemplateMasterId, groupId);
	}
	
	public boolean isTableNameExists(String tableName) {
		Connection connection = null;
		 try {
		        DataSource dataSource = (DataSource) InfrastructureUtil.getDataSource();
		        connection =  dataSource.getConnection();
		        DatabaseMetaData md = connection.getMetaData();
		        String[] type = {"TABLE"};
		        ResultSet rs = md.getTables(null, null, tableName, type);
		        while (rs.next()) {
		        	return true;		        
		        }return false;
		        
	    } catch (SQLException e) {
	    	//log.info("### Table Not Found ###");
			return false;
	    }
		finally {
			if(Validator.isNotNull(connection)) {
				try {
					connection.close();
				} catch (SQLException e) {
					//log.error(e.getMessage());
				}
			}
		}
	}
	
	public boolean isColumnNameExists(String formName, String key) {
		String formattedFormName = StringPool.BLANK;
		if(Validator.isNotNull(formName)) {
			formattedFormName = "df_"+formName.replaceAll("\\s+", "_").toLowerCase();
		}
		List<String> columnNames = formDefinitionLocalService.getColumnNames("'"+formattedFormName+"'");
		return (Validator.isNotNull(columnNames) && !columnNames.isEmpty() && columnNames.contains(key.toLowerCase()));
	}
	
	public String creatorEmailAddress(String recordId, long formRecordEntryId) {
		FormRecordEntry formRecordEntry;
		String emailTo = StringPool.BLANK;
		try {
			formRecordEntry = FormRecordEntryLocalServiceUtil.getFormRecordEntry(formRecordEntryId);
			JSONArray jsonArray = FormDefinitionLocalServiceUtil.getDataSelectQuery(formRecordEntry.getDfTableName(), "createdby, formversion", " where id=" + Long.parseLong(recordId));
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				long userId = jsonObject.getLong("createdby");
				emailTo = UserLocalServiceUtil.getUser(userId).getEmailAddress();
			}
		} catch (PortalException e) {
			log.error("Error in creatorEmailAddress");
		}
		return emailTo;
	}
	
	public String updatedEmailTemplateBody(String emailBody, String formDefinitionId, String recordId, long groupId) {
		FormDefinition formDefinition = null;
		List<String> keyList = new ArrayList<>();
		List<Long> fileEntryIds = new ArrayList<>();
		try {
			formDefinition = formDefinitionLocalService.getFormDefinition(Long.parseLong(formDefinitionId));
			if(Validator.isNotNull(formDefinition)) {
				JSONObject formDefJsonObject = JSONFactoryUtil.createJSONObject(formDefinition.getFormConfig());
				if(Validator.isNotNull(formDefJsonObject) && formDefJsonObject.has("name")) {
					String tableName = formDefJsonObject.getString("name");
					String formattedFormName = "df_"+tableName.replaceAll("\\s+", "_").toLowerCase();
					if(isTableNameExists(formattedFormName)) {
						JSONArray formDefFieldsArray = JSONFactoryUtil.createJSONArray(formDefJsonObject.getString("fields"));
						String columnNames = StringPool.BLANK;
						if(Validator.isNotNull(formDefFieldsArray) && formDefFieldsArray.length()>0) {
							for(int i=0; i<formDefFieldsArray.length(); i++) {
								JSONObject field = (JSONObject) formDefFieldsArray.get(i);
								String key = field.getString("key");
								if(emailBody.contains("[$" + key + "$]")) {
									keyList.add(key);
									if(isColumnNameExists(tableName, key)) {
										columnNames = columnNames + key + StringPool.COMMA;
									}
								} 
							}
							if(Validator.isNotNull(columnNames) && !columnNames.isBlank()) {
								columnNames = columnNames.substring(0, columnNames.length()-1);
								JSONArray recordDataJsonArr = getDataSelectQuery(formattedFormName, columnNames, "where id="+recordId);
								log.info("recordDataJsonArr :: "+recordDataJsonArr);
								if(recordDataJsonArr.length()>0) { 
									JSONObject dataJson = JSONFactoryUtil.createJSONObject(); 
									for(int i = 0;i < recordDataJsonArr.length(); i++){
										dataJson = recordDataJsonArr.getJSONObject(i);
										log.info("keyList :: "+keyList);
										Map<String, String> keyValueMap = new HashMap<>();
										for(String newKey : keyList) {
											if(emailBody.contains("[$" + newKey + "$]")) {
												String value = dataJson.getString(newKey);
												if(Validator.isNotNull(value)) {
													keyValueMap.put(newKey, value);
												} else {
													keyValueMap.put(newKey, StringPool.BLANK);
												}
											}
										}
										emailBody = emailTemplateMasterCommonApi.replaceEmailTemplate(emailBody, keyValueMap);
										List<File> dlFileEntries = emailTemplateMasterCommonApi.fetchEmailTemplateAttachments(3, groupId);
										log.info("dlFileEntries ::: "+dlFileEntries);
									}
								}
								return emailBody;
							} else {
								return emailBody;
							}
						}
					}
				}
			}
		} catch (PortalException pe) {
			log.error("Error while fetching formDefinitionId");
		}
		
		return emailBody;
	}
	
	public boolean createFormTable(String formName) {
		return formDefinitionFinder.createFormTable(formName);
	}
	
	public boolean alterFormTable(String formName, String columnName, String dataType) {
		return formDefinitionFinder.alterFormTable(formName, columnName, dataType);
	}
	
	public List<String> getColumnNames(String tableName){
		return formDefinitionFinder.getColumnNames(tableName);
	}
	
	public boolean isTableExists(String tableName) {
		return formDefinitionFinder.isTableExists(tableName);
	}
	
	public boolean modifyTableName(String oldTableName, String newTableName) {
		return formDefinitionFinder.modifyTableName(oldTableName, newTableName);
	}

	public boolean insertIntoTable(String tableName, String columnNames, String columnValues) {
		return formDefinitionFinder.insertIntoTable(tableName, columnNames, columnValues);
	}
	
	public boolean updateTableRecord(String tableName, String columnValues, String latestRecordCondition) {
		return formDefinitionFinder.updateTableRecord(tableName, columnValues, latestRecordCondition);
	}
	
	public boolean updateMasterTableRecord(String tableName, String columnValues, String latestRecordCondition) {
		return formDefinitionFinder.updateMasterTableRecord(tableName, columnValues, latestRecordCondition);
	}
	
	public Long getSelectLatestRecord(String tableName) {
		return formDefinitionFinder.getSelectLatestRecord(tableName);
	}
	
	public JSONArray getDataSelectQuery(String tableName, String columnNames, String whereCondition) {
		return formDefinitionFinder.getDataSelectQuery(tableName, columnNames, whereCondition);
	}
	
	public JSONObject getColumnNamesWithDatatype(String tableName) {
		return formDefinitionFinder.getColumnNamesWithDatatype(tableName);
	}
	
	public boolean createMasterTable(String tableName, String columnName) {
		return formDefinitionFinder.createMasterTable(tableName, columnName);
	}
	
	public boolean createMasterTableMapping(String tableName, String columnName) {
		return formDefinitionFinder.createMasterTableMapping(tableName, columnName);
	}

	public Long getLastestMasterTableId(String tableName) {
		return formDefinitionFinder.getLastestMasterTableId(tableName);
	}
	
	public Long getSelectLatestMasterRecord(String tableName) {
		return formDefinitionFinder.getSelectLatestMasterRecord(tableName);
	}
	
	public boolean updateMasterRecord(String tableName, String columnName, String columnValue, String latestRecord) {
		return formDefinitionFinder.updateMasterRecord(tableName, columnName, columnValue, latestRecord);
	}

	public List<FormDefinition> getFormDefinitionByStatus(long groupId, int status){
		return formDefinitionPersistence.findByStatus(groupId, status);
	}
	
	public List<FormDefinition> getFormDefinitionByStatus(long groupId, int status, int start, int end){
		return formDefinitionPersistence.findByStatus(groupId, status, start, end);
	}
	
	public boolean deleteFormRecords(String tableName, String recordIds){
		return formDefinitionFinder.deleteFormRecords(tableName, recordIds);
	}
	
	public List<FormDefinition> getLatestFormDefinition(long groupId, long companyId) {
		return formDefinitionFinder.getLatestFormDefinition(groupId, companyId);
	}
}
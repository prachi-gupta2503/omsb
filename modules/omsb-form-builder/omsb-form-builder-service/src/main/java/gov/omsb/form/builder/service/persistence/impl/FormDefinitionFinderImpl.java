package gov.omsb.form.builder.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.model.impl.FormDefinitionImpl;
import gov.omsb.form.builder.service.persistence.FormDefinitionFinder;

@Component(service = FormDefinitionFinder.class)
public class FormDefinitionFinderImpl extends FormDefinitionFinderBaseImpl implements FormDefinitionFinder {
	
	@Reference
	private CustomSQL customSQL;
	
	private static Log log = LogFactoryUtil.getLog(FormDefinitionFinderImpl.class);
	private Session session = null;
	
	public boolean createMasterTable(String tableName, String columnName) {
		boolean result = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "createMasterTable");
	        sql = sql.replaceAll("DF_MASTER_TABLE", tableName);
	        sql = sql.replaceAll("COLUMN_NAME", columnName);
	        
	        log.info("FormDefinitionFinderImpl >>> createMasterTable >>> SQL updated :: " + sql);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        sqlQuery.executeUpdate();
	        result = true;
	        return result;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> createMasterTable >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	public boolean createMasterTableMapping(String tableName, String columnName) {
		boolean result = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "createMasterTableMapping");
	        sql = sql.replaceAll("DF_MASTER_TABLE", tableName);
	        sql = sql.replaceAll("COLUMN_NAME", columnName);
	        
	        log.info("FormDefinitionFinderImpl >>> createMasterTableMapping >>> SQL updated :: " + sql);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        sqlQuery.executeUpdate();
	        result = true;
	        return result;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> createMasterTableMapping >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	public boolean createFormTable(String formName) {
		boolean result = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "createFormTable");
	        sql = sql.replaceAll("DF_FORM_NAME", formName);
	        
	        log.info("FormDefinitionFinderImpl >>> createFormTable >>> SQL updated :: " + sql);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        sqlQuery.executeUpdate();
	        result = true;
	        return result;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> createFormTable >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	public boolean alterFormTable(String formName, String columnName, String dataType) {
		boolean result = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "alterFormTable");
	        sql = sql.replaceAll("DF_FORM_NAME", formName);
	        sql = sql.replaceAll("COLUMN_NAME_DATA_TYPE", columnName+ " "+dataType);
	        log.info("FormDefinitionFinderImpl >>> alterFormTable >>> SQL updated :: " + sql);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        sqlQuery.executeUpdate();
	        result = true;
	        return result;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> alterFormTable >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public boolean isTableExists(String tableName) {
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "isTableExists");
	        sql = sql.replaceAll("SQL_TABLE_NAME", tableName);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        List<Boolean> result = (List<Boolean>) sqlQuery.list();
	        if(Validator.isNotNull(result) && !result.isEmpty() && result.size()>0) {
	        	return (result.get(0)); 
	        } else {
	        	return false;
	        }
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> isTableExists >>> Exception Occurred :: " +e);
			return false;
		} finally {
			closeSession(session);
		}
	}
	
	@Override
	public List<String> getColumnNames(String tableName) {
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getColumnNames");
		    sql = sql.replaceAll("SQL_TABLE_NAME", tableName);
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    return (List<String>) query.list();
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> getColumnNames >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	@Override
	public JSONObject getColumnNamesWithDatatype(String tableName) {
		JSONObject columnNameWithDT = JSONFactoryUtil.createJSONObject();
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getColumnNames");
			sql = sql.replaceAll("COLUMN_NAME", "column_name, data_type");
			sql = sql.replaceAll("SQL_TABLE_NAME", "'"+tableName+"'");
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    List<Object> results = (List<Object>) query.list();
		    for(int i = 0; i< results.size() ; i++ ){
		    	Object[] data = (Object[]) results.get(i);
		    	columnNameWithDT.put((String)data[0], (String)data[1]);
		    }
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> getColumnNames >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return columnNameWithDT;
	}

	public boolean modifyTableName(String oldTableName, String newTableName) {
		boolean isModified = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "modifyTableName");
	        sql = sql.replaceAll("OLD_TABLE_NAME", oldTableName);
	        sql = sql.replaceAll("NEW_TABLE_NAME", newTableName);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        List<String> result = (List<String>) sqlQuery.list();
	        if(Validator.isNotNull(result) && !result.isEmpty() && result.size()>0) {
	        	return (result.get(0).equalsIgnoreCase("true")); 
	        } else {
	        	return isModified;
	        }
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> modifyTableName >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return isModified;
	}
	
	public boolean insertIntoTable(String tableName, String columnNames, String columnValues) {
		boolean result = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "insertIntoTable");
	        sql = sql.replaceAll("TABLE_NAME", tableName);
	        sql = sql.replaceAll("COLUMN_NAMES", columnNames);
	        sql = sql.replaceAll("COLUMN_VALUES", columnValues);
	        log.info("FormDefinitionFinderImpl >>> insertIntoTable >>> SQL updated :: " + sql);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        sqlQuery.executeUpdate();
	        result = true;
	        return result;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> insertIntoTable >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	public boolean updateTableRecord(String tableName, String columnValues, String latestRecordCondition) {
		boolean result = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "updateTableRecord");
	        sql = sql.replaceAll("TABLE_NAME", tableName);
	        sql = sql.replaceAll("COLUMN_VALUES", columnValues);
	        sql = sql.replaceAll("LATEST_RECORD", latestRecordCondition);
	        log.info("FormDefinitionFinderImpl >>> updateTableRecord >>> SQL updated :: " + sql);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        sqlQuery.executeUpdate();
	        result = true;
	        return result;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> updateTableRecord >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	public boolean updateMasterTableRecord(String tableName, String columnValues, String latestRecordCondition) {
		boolean result = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "updateMasterTableRecord");
	        sql = sql.replaceAll("TABLE_NAME", tableName);
	        sql = sql.replaceAll("COLUMN_VALUES", columnValues);
	        sql = sql.replaceAll("LATEST_RECORD", latestRecordCondition);
	        log.info("FormDefinitionFinderImpl >>> updateMasterTableRecord >>> SQL updated :: " + sql);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        sqlQuery.executeUpdate();
	        result = true;
	        return result;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> updateMasterTableRecord >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	public boolean updateMasterRecord(String tableName, String columnName, String columnValue, String latestRecord) {
		boolean result = false;
		try {
			session = openSession();
	        String sql = customSQL.get(getClass(), "updateMasterRecord");
	        sql = sql.replaceAll("TABLE_NAME", tableName);
	        sql = sql.replaceAll("COLUMN_NAME", columnName);
	        sql = sql.replaceAll("COLUMN_VALUE", columnValue);
	        sql = sql.replaceAll("LATEST_RECORD", latestRecord);
	        log.info("FormDefinitionFinderImpl >>> updateMasterRecord >>> SQL updated :: " + sql);
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setCacheable(false);
	        sqlQuery.executeUpdate();
	        result = true;
	        return result;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> updateMasterRecord >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	
	public Long getSelectLatestRecord(String tableName) {
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "selectLatestRecord");
		    sql = sql.replaceAll("TABLE_NAME", tableName);
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    List<Integer> result = (List<Integer>) query.list();
		    if(Validator.isNotNull(result) && !result.isEmpty() && result.size()>0) {
	        	return (result.get(0).longValue()); 
	        } else {
	        	return 0l;
	        }
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> getColumnNames >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return 0l;
	}
	
	public Long getSelectLatestMasterRecord(String tableName) {
		long recordId = 0;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "selectLatestMasterRecord");
		    sql = sql.replaceAll("TABLE_NAME", tableName);
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    List<Object> results = (List<Object>) query.list();

            if (!results.isEmpty()) {
            	Object result = results.get(0);
                String recordIdString = result.toString();
                recordId = Long.parseLong(recordIdString);
            }
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> selectLatestMasterRecord >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return recordId;
	}
	
	public Long getLastestMasterTableId(String tableName) {
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getLastestMasterTableId");
		    sql = sql.replaceAll("DF_MASTER_TABLE", tableName);
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    List<Integer> result = (List<Integer>) query.list();
		    if(Validator.isNotNull(result) && !result.isEmpty() && result.size()>0) {
	        	return (result.get(0).longValue()); 
	        } else {
	        	return 0l;
	        }
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> getLastestMasterTableId >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return 0l;
	}
	
	@Override
	public JSONArray getDataSelectQuery(String tableName, String columnNames, String whereCondition) {
		JSONArray records = JSONFactoryUtil.createJSONArray();
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getDataSelectQuery");
		    sql = sql.replaceAll("TABLE_NAME", tableName);
		    sql = sql.replaceAll("COLUMN_NAMES", columnNames);
		    if(Validator.isNotNull(whereCondition)) {
		    	sql = sql.concat(" " + whereCondition);
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    List<Object> results = (List<Object>) query.list();
		    String[] columns = columnNames.split(",");
		    for(int i = 0; i< results.size() ; i++ ){
		    	JSONObject record = JSONFactoryUtil.createJSONObject();
		    	if(columns.length > 1) {
		    		Object[] data = (Object[]) results.get(i);
			    	for(int j = 0; j < data.length ; j++) {
			    		String currentColumn = columns[j];
			    		try {
	                        JSONObject json = JSONFactoryUtil.createJSONObject(data[j].toString());
			    			String encodeJson = new String(Base64.getEncoder().encode(data[j].toString().getBytes()));
			    			record.put(currentColumn, encodeJson);
			    		} catch(Exception e) {
			    			Object colData = data[j];
				    		record.put(currentColumn, colData);
			    		}
			    	}
		    	} else {
		    		try {
                        JSONObject json = JSONFactoryUtil.createJSONObject(results.get(i).toString());
		    			String encodeJson = new String(Base64.getEncoder().encode(results.get(i).toString().getBytes()));
		    			record.put(columnNames, encodeJson);
		    		} catch(Exception e) {
		    			Object colData = results.get(i);
			    		record.put(columnNames, colData);
		    		}
		    	}
		    	records.put(record);
		    }
		    return records;
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> getColumnNames >>> Exception Occurred :: " +e);
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public boolean deleteFormRecords(String tableName, String recordIds) {
		boolean result = false;
		if(Validator.isNotNull(tableName) && Validator.isNotNull(recordIds)) {
			try {
				session = openSession();
		        String sql = customSQL.get(getClass(), "deleteFormRecords");
		        sql = sql.replaceAll("TABLE_NAME", tableName);
		        sql = sql.replaceAll("RECORD_IDS", recordIds);
		        log.info("FormDefinitionFinderImpl >>> deleteFormRecords >>> SQL updated :: " + sql);
		        SQLQuery sqlQuery = session.createSQLQuery(sql);
		        sqlQuery.setCacheable(false);
		        sqlQuery.executeUpdate();
		        result = true;
		        return result;
			} catch (Exception e) {
				log.error("FormDefinitionFinderImpl >>> deleteFormRecords >>> Exception Occurred :: " +e);
			} finally {
				closeSession(session);
			}
		}
		return result;
	}
	
	public List<FormDefinition> getLatestFormDefinition(long groupId, long companyId) {
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getLatestFormDefinition");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(true);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(groupId);
			queryPos.add(companyId);
		    List<FormDefinition> formDefinitions = new ArrayList<>();
		    List<Object> results = (List<Object>) sqlQuery.list();
		    if(Validator.isNotNull(results)) {
		    	for(int i = 0; i< results.size() ; i++ ){
		    		Object[] data = (Object[]) results.get(i);
		    		BigInteger bigintPK = (BigInteger)data[0];
		    		FormDefinition formDefinition = formDefinitionPersistence.findByPrimaryKey(bigintPK.longValue());
		    		formDefinitions.add(formDefinition);
			    }
		    	return formDefinitions;
		    }
		} catch (Exception e) {
			log.error("FormDefinitionFinderImpl >>> getLatestFormDefinition >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return new ArrayList<>();
	}
}

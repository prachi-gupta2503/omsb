package gov.omsb.form.builder.portlet.util;

import static gov.omsb.form.builder.constants.FormBuilderConstants.*;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManager;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.service.FormDefinitionLocalService;


@Component(
		immediate=true,
		service = FormConfigurationUtil.class
)
public class FormConfigurationUtil {
	
	private static final Log log = LogFactoryUtil.getLog(FormConfigurationUtil.class);
	private static final String FLOAT_FORMAT = "%.1f";

	// Create table in database
	public boolean createTable(String tableName) {
		boolean isTableNameExists = isTableExists(tableName);
		if(!isTableNameExists) {
			formDefinitionLocalService.createFormTable(tableName);
			log.info("### Table Created ###");
			return true;
		} else {
			log.info("### Table Already Exists ###");
			return false;
		}
	}
	
	// Add Column in new table created
	public boolean addColumn(String tableName, String columnName, String dataType) {
		boolean isTableNameExists = isTableExists(tableName);
		List<String> columnNames = formDefinitionLocalService.getColumnNames("'"+tableName+"'");
		if(isTableNameExists && Validator.isNotNull(columnName) && !columnName.isEmpty() && !columnNames.contains(columnName)) {
			formDefinitionLocalService.alterFormTable(tableName, columnName, dataType);
			log.info("### Table Updated ###");
			return true;
		} else {
			log.info("### Column already exists ###");
			return false;
		}
	}
	
	//Add entry in df_form_definition table
	public FormDefinition addEditFormDefinition(ServiceContext serviceContext, long formDefinitionId,
			ThemeDisplay themeDisplay, String formName, String formDescription, String formTitle, String formConfig,
			String formVersion, int actionType, String workflowDefinition) {
		log.info("Form Version in Config Util: " + formVersion);
		FormDefinition formDefinition = null;
		FormDefinition updatedFormDefinition = null;
		Date date = new Date();
		try {
			if (Validator.isNotNull(formDefinitionId) && formDefinitionId > 0 && actionType == SUBMIT_FORM && Validator.isNotNull(formVersion)) {
				formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
				formDefinition.setModifiedDate(date);
				formDefinition.setModifiedBy(themeDisplay.getUserId());
				if(formDefinition.getStatus() != WorkflowConstants.STATUS_DRAFT && formDefinition.getStatus() != WorkflowConstants.STATUS_INCOMPLETE) {
					formDefinition.setFormVersion(String.format(FLOAT_FORMAT, (Float.parseFloat(formVersion) + 0.1)));
				} else {
					formDefinition.setFormVersion(formVersion);
				}
			} else if(Validator.isNotNull(formDefinitionId) && formDefinitionId > 0 && actionType == SUBMIT_FORM) {
				formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
				List<FormDefinition> formDefinitions = formDefinitionLocalService.findFormDefinitionByFormName(formDefinition.getFormName());
				if(Validator.isNotNull(formDefinitions) && formDefinitions.size()==1) {
					formDefinition.setFormVersion("1.0");
				} else if(Validator.isNotNull(formDefinitions) && formDefinitions.size()>1) {
					//fetch latest version and add to it
					float latestVersion = Float.parseFloat("1.0");
					for(FormDefinition formdef : formDefinitions) {
						if(Validator.isNotNull(formdef.getFormVersion()) && (Float.parseFloat(formdef.getFormVersion()) > latestVersion)) {
							latestVersion = Float.parseFloat(formdef.getFormVersion());
						}
					}
					if(formDefinition.getStatus() != WorkflowConstants.STATUS_DRAFT && formDefinition.getStatus() != WorkflowConstants.STATUS_INCOMPLETE) {
						formDefinition.setFormVersion(String.format(FLOAT_FORMAT, (latestVersion + 0.1)));
					} else {
						formDefinition.setFormVersion(String.valueOf(latestVersion));
					}
				}
				formDefinition.setModifiedDate(date);
				formDefinition.setModifiedBy(themeDisplay.getUserId());
			}else if((Validator.isNull(formDefinitionId) || formDefinitionId <= 0)  && actionType != SUBMIT_FORM) {
				formDefinition = formDefinitionLocalService.createFormDefinition(counterLocalService.increment());
				formDefinition.setStatus(WorkflowConstants.STATUS_ANY);
				formDefinition.setCreatedDate(date);
				formDefinition.setCreatedBy(themeDisplay.getUserId());
				formDefinition.setFormVersion(null);
			} else if(Validator.isNotNull(formDefinitionId) && formDefinitionId > 0  && actionType != SUBMIT_FORM){
				formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
				formDefinition.setModifiedDate(date);
				formDefinition.setModifiedBy(themeDisplay.getUserId());
			}
			User user = userLocalService.getUser(serviceContext.getUserId());

			formDefinition.setFormName(formName);
			formDefinition.setFormDescription(formDescription);
			formDefinition.setFormTitle(formTitle);
			formDefinition.setFormConfig(formConfig);
			formDefinition.setGroupId(themeDisplay.getScopeGroupId());
			formDefinition.setStatusByUserId(user.getUserId());
			formDefinition.setStatusDate(new Date());
			formDefinition.setStatusByUserName(user.getFullName());
			formDefinition.setStatusByUserUuid(user.getUserUuid());

			updatedFormDefinition = formDefinitionLocalService.updateFormDefinition(formDefinition);
			int formDefinitionWorkflowStatus = updatedFormDefinition.getStatus();
			if (Validator.isNotNull(actionType) && actionType == SUBMIT_FORM && formDefinitionId > 0
					&& formConfig.contains(FIELDS) && Validator.isNotNull(workflowDefinition)
					&& (formDefinitionWorkflowStatus == WorkflowConstants.STATUS_ANY
							|| formDefinitionWorkflowStatus == WorkflowConstants.STATUS_INCOMPLETE)) {
				new FormUtil(workflowDefinitionLinkLocalService);
				FormUtil.addUpdatedWorkflowDefinitionLink(themeDisplay, themeDisplay.getScopeGroupId(),
						FormDefinition.class.getName(), workflowDefinition);
				if (formDefinitionWorkflowStatus == WorkflowConstants.STATUS_INCOMPLETE) {
					log.info("### Workflow Completing while adding/updating ###");
					completeWorkflowTask(themeDisplay, formDefinition);
				} else {
					log.info("### Initializing Workflow ###");
					serviceContext.setAttribute(FormBuilderConstants.PORTAL_URL, themeDisplay.getPortalURL());
					initWokflow(user, serviceContext, formDefinition);
				}
				formDefinition.setStatus(WorkflowConstants.STATUS_DRAFT);
				updatedFormDefinition = formDefinitionLocalService.updateFormDefinition(formDefinition);
			} else if (Validator.isNotNull(actionType) && actionType == SUBMIT_FORM && formDefinitionId > 0
					&& formConfig.contains(FIELDS) && Validator.isNull(workflowDefinition)
					&& (formDefinitionWorkflowStatus == WorkflowConstants.STATUS_ANY
							|| formDefinitionWorkflowStatus == WorkflowConstants.STATUS_INCOMPLETE)) {
				formDefinition.setStatus(WorkflowConstants.STATUS_APPROVED);
				updatedFormDefinition = formDefinitionLocalService.updateFormDefinition(formDefinition);
			}
			log.info("### Form Definition Updated ###");
		} catch (PortalException | SystemException e) {
			log.error("### Exception occured while add/edit Form Definition ###" + e.getMessage(), e);
		}
		return updatedFormDefinition;
	}
	
	public FormDefinition updateStatus(long userId, long formDefinitionId, int status, ServiceContext serviceContext) {

		FormDefinition formDefinition = null;
		User user = null;
		try {
			formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
			formDefinition.setStatus(status);
			formDefinition.setStatusByUserId(userId);
			formDefinition.setStatusDate(new Date());
			user = userLocalService.getUser(userId);
			formDefinition.setStatusByUserName(user.getFullName());
			formDefinition.setStatusByUserUuid(user.getUserUuid());
			if (status == WorkflowConstants.STATUS_APPROVED) {
				// update the asset status to visibile
				//formDefinition.setInitWorkflowStatus(Boolean.FALSE);
				assetEntryLocalService.updateEntry(FormDefinition.class.getName(), formDefinitionId, new Date(), null, true, true);
			} else {
				// set formDefinition entity status to false
				assetEntryLocalService.updateVisible(FormDefinition.class.getName(), formDefinitionId, false);
			}
		} catch (PortalException e) {	
			log.error("error occured while updating status of form definition: "+e.getMessage());
		}
		formDefinition = formDefinitionLocalService.updateFormDefinition(formDefinition);
		return formDefinition;
	}
	
	//Modify table name
	public boolean modifyTableName(String oldTableName, String newTableName) {
		boolean isTableNameExists = formDefinitionLocalService.isTableExists(oldTableName);
		if(isTableNameExists) {
			formDefinitionLocalService.modifyTableName(oldTableName, newTableName);
			log.info("### Table Name Changed ###");
			return true;
		} else {
			log.info("### Table not exists ###");
			return false;
		}
	}
	
	public static List<String> getColumnsName(String tableName){
		List<String> columns = new ArrayList<>();
		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();
			Connection connection = dataSource.getConnection();
			DatabaseMetaData md = connection.getMetaData();
			ResultSet rs = md.getTables(null, null, tableName, null);
			if (rs.next()) {
				ResultSet cols = md.getColumns(null, null, tableName, null);
				while (cols.next()) {
					columns.add(cols.getString(4));
				}
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	
		return columns;
	}
	
	public static boolean isTableExists(String tableName) {
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
	    	log.info("### Table Not Found ###");
			return false;
	    }
		finally {
			if(Validator.isNotNull(connection)) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
			}
		}
	}
	
	public static JSONArray getAllTables() {
		Connection connection = null;
		JSONArray tableNamesArray = JSONFactoryUtil.createJSONArray();
		 try {
		        DataSource dataSource = (DataSource) InfrastructureUtil.getDataSource();
		        connection =  dataSource.getConnection();
		        DatabaseMetaData md = connection.getMetaData();
		        String[] type = {"TABLE"};
		        //ResultSet rs = md.getTables(null, null, "df_%", type);
		        ResultSet rs = md.getTables(null, null, "%", type);
		        while (rs.next()) {
		        	tableNamesArray.put(rs.getString("TABLE_NAME"));        
		        }
	    } catch (SQLException e) {
	    	log.info("### Table Not Found ###");
	    }
		finally {
			if(Validator.isNotNull(connection)) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
			}
		}
		return tableNamesArray;
	}
	
	/*public JSONObject getFormLists(){
		JSONObject nameVersionsJson = JSONFactoryUtil.createJSONObject();
		List<FormDefinition> formDefinitions = formDefinitionLocalService.getFormDefinitions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(Validator.isNotNull(formDefinitions) && !formDefinitions.isEmpty() && formDefinitions.size() > 0) {
			for(FormDefinition formDefinition : formDefinitions) {
				if(Validator.isNotNull(nameVersionsJson) && nameVersionsJson.has(formDefinition.getFormName())) {
					JSONObject versionJson = nameVersionsJson.getJSONObject(formDefinition.getFormName());
					versionJson.put(formDefinition.getFormVersion(), formDefinition.getFormDefinitionId());
					nameVersionsJson.put(formDefinition.getFormName(), versionJson);
				} else {
					JSONObject versionJson = JSONFactoryUtil.createJSONObject();
					versionJson.put(formDefinition.getFormVersion(), formDefinition.getFormDefinitionId());
					nameVersionsJson.put(formDefinition.getFormName(), versionJson);
				}
			}
			
		}
		return nameVersionsJson;
	}*/
	
	public JSONObject getFormLists(long companyId, long groupId){
		JSONObject formDefinitionJson = null;
		List<FormDefinition> formDefinitions = formDefinitionLocalService.getLatestFormDefinition(groupId, companyId);
		if(Validator.isNotNull(formDefinitions) && !formDefinitions.isEmpty() && formDefinitions.size() > 0) {
			formDefinitionJson = JSONFactoryUtil.createJSONObject();
			JSONObject formDefinitionIdJson = null;
			for(FormDefinition formDefinition : formDefinitions) {
				formDefinitionIdJson = JSONFactoryUtil.createJSONObject();
				JSONObject formDefinitionNameJson = null;
				if(Validator.isNotNull(formDefinitionJson) && formDefinitionJson.has(formDefinition.getFormName())) {
					formDefinitionNameJson = formDefinitionJson.getJSONObject(formDefinition.getFormName());
					formDefinitionNameJson = getFormDataJsonObject(formDefinition, formDefinitionIdJson);
				} else {
					formDefinitionNameJson = JSONFactoryUtil.createJSONObject();
					formDefinitionNameJson = getFormDataJsonObject(formDefinition, formDefinitionIdJson);
				}
				formDefinitionJson.put(formDefinition.getFormName(), formDefinitionNameJson);
			}
		}
		return formDefinitionJson;
	}
	
	private JSONObject getFormDataJsonObject(FormDefinition formDefinition, JSONObject formDefinitionIdJson) {
		JSONObject formDefinitionDataJson = JSONFactoryUtil.createJSONObject();;
		formDefinitionDataJson.put(FormBuilderConstants.VERSION, formDefinition.getFormVersion());
		formDefinitionDataJson.put(FormBuilderConstants.STATUS, WorkflowConstants.getStatusCssClass(formDefinition.getStatus()));
		formDefinitionIdJson.put(String.valueOf(formDefinition.getFormDefinitionId()), formDefinitionDataJson);
		return formDefinitionIdJson;
	};
	
	private void initWokflow(User user, ServiceContext serviceContext, FormDefinition formDefinition) {
		log.info("### Init Workflow ###");
		try {
			AssetEntry assetEntry = assetEntryLocalService.updateEntry( user.getUserId(), serviceContext.getScopeGroupId(), new Date(),
			        new Date(), FormDefinition.class.getName(), formDefinition.getFormDefinitionId(), formDefinition.getUuid(), 0, null, null, true, false, new Date(), null,
			        new Date(), null, ContentTypes.TEXT_HTML, formDefinition.getFormName(), formDefinition.getFormName(), null, null, null, 0, 0, null);
			Indexer<FormDefinition> indexer = IndexerRegistryUtil.nullSafeGetIndexer(FormDefinition.class);
			indexer.reindex(formDefinition);
			log.info("### Starting Workflow ###");
			WorkflowHandlerRegistryUtil.startWorkflowInstance(formDefinition.getCompanyId(), formDefinition.getGroupId(), user.getUserId(), FormDefinition.class.getName(),
	    		formDefinition.getPrimaryKey(), formDefinition, serviceContext);
			log.info("### Workflow Started ###");
		} catch (PortalException e) {
			log.error("error occured while initializing workflow: " + e.getMessage());
		}
	}
	
	private void completeWorkflowTask(ThemeDisplay themeDisplay, FormDefinition formDefinition) {
		log.info("### completeWorkflowTask ###");
		long companyId = themeDisplay.getCompanyId();
		WorkflowInstanceLink wil;
		try {
			Map<String, Serializable> workflowContext = getWorkflowContext(themeDisplay, formDefinition);
			wil = workflowInstanceLinkLocalService.getWorkflowInstanceLink(companyId, formDefinition.getGroupId(), 
					FormDefinition.class.getName(), formDefinition.getFormDefinitionId());
			List<Integer> logTypes_assign = new ArrayList<Integer>();
	        logTypes_assign.add(WorkflowLog.TASK_ASSIGN);
	        List<WorkflowLog> workflowLogs_assign = workflowLogManager.getWorkflowLogsByWorkflowInstance(companyId, wil.getWorkflowInstanceId(),
	        		logTypes_assign, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
	        if(workflowLogs_assign.size() > 0){             
                long workflowTaskId = workflowLogs_assign.get(workflowLogs_assign.size()-1).getWorkflowTaskId();
                log.info("Workflow Task Id: "+workflowTaskId);
                workflowTaskManager.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), workflowTaskId, "resubmit", StringPool.BLANK, workflowContext);
            }
		} catch (Exception e) {
			log.error("error occured while getting workflow task id :" + e.getMessage());
		}
	}

	private Map<String, Serializable> getWorkflowContext(ThemeDisplay themeDisplay,FormDefinition formDefinition) throws Exception {
		long companyId = themeDisplay.getCompanyId();
		WorkflowInstanceLink wil= workflowInstanceLinkLocalService.getWorkflowInstanceLink(companyId, formDefinition.getGroupId(), FormDefinition.class.getName(), formDefinition.getFormDefinitionId());
        WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, wil.getWorkflowInstanceId());
        Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		return workflowContext;
	}
	
	public FormDefinition createNewFormVersion(FormDefinition formDefinition) {
		double updatedFormVersion = Double.valueOf(formDefinition.getFormVersion());
		String newFormVersion = String.format(FLOAT_FORMAT, (updatedFormVersion + 0.1));
		formDefinition.setFormDefinitionId(-1);
		formDefinition.setStatus(WorkflowConstants.STATUS_ANY);
		formDefinition.setFormVersion(null);
		formDefinition.setUuid(StringPool.BLANK);
		formDefinition = formDefinitionLocalService.addFormDefinition(formDefinition);
		return formDefinition;
	}
	
	public JSONObject getFormBuilderRoles(ThemeDisplay themeDisplay) {
		JSONObject rolesJson = JSONFactoryUtil.createJSONObject();
		long rolesVocabId = getVocabIdByVocabName("Roles");
		List<AssetCategory> rolesCategoryList = assetCategoryLocalService.getVocabularyCategories(rolesVocabId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		if(ListUtil.isNotEmpty(rolesCategoryList)) {
			for (AssetCategory assetCategory : rolesCategoryList) {
				String description = assetCategory.getDescription(themeDisplay.getLocale()).replaceAll("<[^>]*>", "");
				try {
					JSONArray categoryJsonArr = JSONFactoryUtil.createJSONArray(description);
					JSONArray rolesJsonArr = JSONFactoryUtil.createJSONArray();
					for(int i=0; i<categoryJsonArr.length(); i++) {
						JSONObject roleJson = categoryJsonArr.getJSONObject(i);
						String roleKey = roleJson.getString("key");
						Role role = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), roleKey);
						if(Validator.isNotNull(role)) {
							JSONObject roleJsonObj = JSONFactoryUtil.createJSONObject();
							roleJsonObj.put("id", role.getRoleId());
							roleJsonObj.put("name", roleJson.getString("name"));
							rolesJsonArr.put(roleJsonObj);
						}
					}
					rolesJson.put(assetCategory.getName(), rolesJsonArr);
				} catch (JSONException e) {
					log.error("Unable to create json with description");
				}
			}
		}
		return rolesJson;
	}
	
	/**
	 * This method is used to fetch vocabulary id on the basis of vocabulary name
	 * @param vocabName
	 * @return vocabulary id
	 */
	private long getVocabIdByVocabName(String vocabName) {
		try {
			long globalGroupId = groupLocalService.getCompanyGroup(PortalUtil.getDefaultCompanyId()).getGroupId();
			return assetVocabularyLocalService.fetchGroupVocabulary(globalGroupId, vocabName.toLowerCase()).getVocabularyId();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return 0;
	}
	
	@Reference
	private GroupLocalService groupLocalService;
	
	@Reference
	private AssetVocabularyLocalService assetVocabularyLocalService;
	
	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private FormDefinitionLocalService formDefinitionLocalService;
	
	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private AssetEntryLocalService assetEntryLocalService;
	
	@Reference
	private WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService;
	
	@Reference
	protected WorkflowTaskManager workflowTaskManager;
	
	@Reference
	private WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
	
	@Reference
	private WorkflowLogManager workflowLogManager;
	
}

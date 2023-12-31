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

package gov.omsb.form.builder.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.service.FormDefinitionLocalService;
import gov.omsb.form.builder.service.FormDefinitionLocalServiceUtil;
import gov.omsb.form.builder.service.persistence.FormDefinitionFinder;
import gov.omsb.form.builder.service.persistence.FormDefinitionPersistence;
import gov.omsb.form.builder.service.persistence.FormRecordEntryPersistence;
import gov.omsb.form.builder.service.persistence.RangeOptionMasterPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the form definition local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link gov.omsb.form.builder.service.impl.FormDefinitionLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see gov.omsb.form.builder.service.impl.FormDefinitionLocalServiceImpl
 * @generated
 */
public abstract class FormDefinitionLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, FormDefinitionLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>FormDefinitionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>FormDefinitionLocalServiceUtil</code>.
	 */

	/**
	 * Adds the form definition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FormDefinition addFormDefinition(FormDefinition formDefinition) {
		formDefinition.setNew(true);

		return formDefinitionPersistence.update(formDefinition);
	}

	/**
	 * Creates a new form definition with the primary key. Does not add the form definition to the database.
	 *
	 * @param formDefinitionId the primary key for the new form definition
	 * @return the new form definition
	 */
	@Override
	@Transactional(enabled = false)
	public FormDefinition createFormDefinition(long formDefinitionId) {
		return formDefinitionPersistence.create(formDefinitionId);
	}

	/**
	 * Deletes the form definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition that was removed
	 * @throws PortalException if a form definition with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FormDefinition deleteFormDefinition(long formDefinitionId)
		throws PortalException {

		return formDefinitionPersistence.remove(formDefinitionId);
	}

	/**
	 * Deletes the form definition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FormDefinition deleteFormDefinition(FormDefinition formDefinition) {
		return formDefinitionPersistence.remove(formDefinition);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return formDefinitionPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			FormDefinition.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return formDefinitionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return formDefinitionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return formDefinitionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return formDefinitionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return formDefinitionPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public FormDefinition fetchFormDefinition(long formDefinitionId) {
		return formDefinitionPersistence.fetchByPrimaryKey(formDefinitionId);
	}

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchFormDefinitionByUuidAndGroupId(
		String uuid, long groupId) {

		return formDefinitionPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the form definition with the primary key.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition
	 * @throws PortalException if a form definition with the primary key could not be found
	 */
	@Override
	public FormDefinition getFormDefinition(long formDefinitionId)
		throws PortalException {

		return formDefinitionPersistence.findByPrimaryKey(formDefinitionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(formDefinitionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(FormDefinition.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("formDefinitionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			formDefinitionLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(FormDefinition.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"formDefinitionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(formDefinitionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(FormDefinition.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("formDefinitionId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return formDefinitionPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement FormDefinitionLocalServiceImpl#deleteFormDefinition(FormDefinition) to avoid orphaned data");
		}

		return formDefinitionLocalService.deleteFormDefinition(
			(FormDefinition)persistedModel);
	}

	@Override
	public BasePersistence<FormDefinition> getBasePersistence() {
		return formDefinitionPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return formDefinitionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the form definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the form definitions
	 * @param companyId the primary key of the company
	 * @return the matching form definitions, or an empty list if no matches were found
	 */
	@Override
	public List<FormDefinition> getFormDefinitionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return formDefinitionPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of form definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the form definitions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching form definitions, or an empty list if no matches were found
	 */
	@Override
	public List<FormDefinition> getFormDefinitionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return formDefinitionPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition
	 * @throws PortalException if a matching form definition could not be found
	 */
	@Override
	public FormDefinition getFormDefinitionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return formDefinitionPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of form definitions
	 */
	@Override
	public List<FormDefinition> getFormDefinitions(int start, int end) {
		return formDefinitionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of form definitions.
	 *
	 * @return the number of form definitions
	 */
	@Override
	public int getFormDefinitionsCount() {
		return formDefinitionPersistence.countAll();
	}

	/**
	 * Updates the form definition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FormDefinition updateFormDefinition(FormDefinition formDefinition) {
		return formDefinitionPersistence.update(formDefinition);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			FormDefinitionLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		formDefinitionLocalService = (FormDefinitionLocalService)aopProxy;

		_setLocalServiceUtilService(formDefinitionLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return FormDefinitionLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return FormDefinition.class;
	}

	protected String getModelClassName() {
		return FormDefinition.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = formDefinitionPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		FormDefinitionLocalService formDefinitionLocalService) {

		try {
			Field field = FormDefinitionLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, formDefinitionLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected FormDefinitionLocalService formDefinitionLocalService;

	@Reference
	protected FormDefinitionPersistence formDefinitionPersistence;

	@Reference
	protected FormDefinitionFinder formDefinitionFinder;

	@Reference
	protected FormRecordEntryPersistence formRecordEntryPersistence;

	@Reference
	protected RangeOptionMasterPersistence rangeOptionMasterPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		FormDefinitionLocalServiceBaseImpl.class);

}
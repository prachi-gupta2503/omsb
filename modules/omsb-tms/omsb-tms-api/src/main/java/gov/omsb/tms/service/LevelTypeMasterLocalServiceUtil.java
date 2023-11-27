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

package gov.omsb.tms.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.LevelTypeMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LevelTypeMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.LevelTypeMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LevelTypeMasterLocalService
 * @generated
 */
public class LevelTypeMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.LevelTypeMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the level type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelTypeMaster the level type master
	 * @return the level type master that was added
	 */
	public static LevelTypeMaster addLevelTypeMaster(
		LevelTypeMaster levelTypeMaster) {

		return getService().addLevelTypeMaster(levelTypeMaster);
	}

	/**
	 * Creates a new level type master with the primary key. Does not add the level type master to the database.
	 *
	 * @param LevelTypeMasterId the primary key for the new level type master
	 * @return the new level type master
	 */
	public static LevelTypeMaster createLevelTypeMaster(
		long LevelTypeMasterId) {

		return getService().createLevelTypeMaster(LevelTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the level type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelTypeMaster the level type master
	 * @return the level type master that was removed
	 */
	public static LevelTypeMaster deleteLevelTypeMaster(
		LevelTypeMaster levelTypeMaster) {

		return getService().deleteLevelTypeMaster(levelTypeMaster);
	}

	/**
	 * Deletes the level type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master that was removed
	 * @throws PortalException if a level type master with the primary key could not be found
	 */
	public static LevelTypeMaster deleteLevelTypeMaster(long LevelTypeMasterId)
		throws PortalException {

		return getService().deleteLevelTypeMaster(LevelTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static LevelTypeMaster fetchLevelTypeMaster(long LevelTypeMasterId) {
		return getService().fetchLevelTypeMaster(LevelTypeMasterId);
	}

	/**
	 * Returns the level type master matching the UUID and group.
	 *
	 * @param uuid the level type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchLevelTypeMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLevelTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	public static List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName) {

		return getService().findByLevelTypeNameByLike(levelTypeName);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the level type master with the primary key.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master
	 * @throws PortalException if a level type master with the primary key could not be found
	 */
	public static LevelTypeMaster getLevelTypeMaster(long LevelTypeMasterId)
		throws PortalException {

		return getService().getLevelTypeMaster(LevelTypeMasterId);
	}

	/**
	 * Returns the level type master matching the UUID and group.
	 *
	 * @param uuid the level type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching level type master
	 * @throws PortalException if a matching level type master could not be found
	 */
	public static LevelTypeMaster getLevelTypeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLevelTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the level type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of level type masters
	 */
	public static List<LevelTypeMaster> getLevelTypeMasters(
		int start, int end) {

		return getService().getLevelTypeMasters(start, end);
	}

	/**
	 * Returns all the level type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the level type masters
	 * @param companyId the primary key of the company
	 * @return the matching level type masters, or an empty list if no matches were found
	 */
	public static List<LevelTypeMaster> getLevelTypeMastersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLevelTypeMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of level type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the level type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching level type masters, or an empty list if no matches were found
	 */
	public static List<LevelTypeMaster> getLevelTypeMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getService().getLevelTypeMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of level type masters.
	 *
	 * @return the number of level type masters
	 */
	public static int getLevelTypeMastersCount() {
		return getService().getLevelTypeMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the level type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelTypeMaster the level type master
	 * @return the level type master that was updated
	 */
	public static LevelTypeMaster updateLevelTypeMaster(
		LevelTypeMaster levelTypeMaster) {

		return getService().updateLevelTypeMaster(levelTypeMaster);
	}

	public static LevelTypeMasterLocalService getService() {
		return _service;
	}

	private static volatile LevelTypeMasterLocalService _service;

}
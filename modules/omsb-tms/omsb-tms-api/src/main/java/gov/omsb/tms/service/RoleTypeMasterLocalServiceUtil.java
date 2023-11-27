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

import gov.omsb.tms.model.RoleTypeMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RoleTypeMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.RoleTypeMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeMasterLocalService
 * @generated
 */
public class RoleTypeMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.RoleTypeMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the role type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeMaster the role type master
	 * @return the role type master that was added
	 */
	public static RoleTypeMaster addRoleTypeMaster(
		RoleTypeMaster roleTypeMaster) {

		return getService().addRoleTypeMaster(roleTypeMaster);
	}

	public static RoleTypeMaster addUpdateRoleTypeMaster(
		RoleTypeMaster roleTypeMaster, List<String> roleTypeNames,
		boolean isCreate) {

		return getService().addUpdateRoleTypeMaster(
			roleTypeMaster, roleTypeNames, isCreate);
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
	 * Creates a new role type master with the primary key. Does not add the role type master to the database.
	 *
	 * @param roleTypeMasterId the primary key for the new role type master
	 * @return the new role type master
	 */
	public static RoleTypeMaster createRoleTypeMaster(long roleTypeMasterId) {
		return getService().createRoleTypeMaster(roleTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the role type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master that was removed
	 * @throws PortalException if a role type master with the primary key could not be found
	 */
	public static RoleTypeMaster deleteRoleTypeMaster(long roleTypeMasterId)
		throws PortalException {

		return getService().deleteRoleTypeMaster(roleTypeMasterId);
	}

	/**
	 * Deletes the role type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeMaster the role type master
	 * @return the role type master that was removed
	 */
	public static RoleTypeMaster deleteRoleTypeMaster(
		RoleTypeMaster roleTypeMaster) {

		return getService().deleteRoleTypeMaster(roleTypeMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeMasterModelImpl</code>.
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

	public static RoleTypeMaster fetchRoleTypeMaster(long roleTypeMasterId) {
		return getService().fetchRoleTypeMaster(roleTypeMasterId);
	}

	/**
	 * Returns the role type master matching the UUID and group.
	 *
	 * @param uuid the role type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchRoleTypeMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchRoleTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	public static List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName) {

		return getService().findByRoleTypeNameByLike(roleTypeName);
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
	 * Returns the role type master with the primary key.
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master
	 * @throws PortalException if a role type master with the primary key could not be found
	 */
	public static RoleTypeMaster getRoleTypeMaster(long roleTypeMasterId)
		throws PortalException {

		return getService().getRoleTypeMaster(roleTypeMasterId);
	}

	/**
	 * Returns the role type master matching the UUID and group.
	 *
	 * @param uuid the role type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role type master
	 * @throws PortalException if a matching role type master could not be found
	 */
	public static RoleTypeMaster getRoleTypeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getRoleTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the role type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of role type masters
	 */
	public static List<RoleTypeMaster> getRoleTypeMasters(int start, int end) {
		return getService().getRoleTypeMasters(start, end);
	}

	/**
	 * Returns all the role type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the role type masters
	 * @param companyId the primary key of the company
	 * @return the matching role type masters, or an empty list if no matches were found
	 */
	public static List<RoleTypeMaster> getRoleTypeMastersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getRoleTypeMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of role type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the role type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching role type masters, or an empty list if no matches were found
	 */
	public static List<RoleTypeMaster> getRoleTypeMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getService().getRoleTypeMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of role type masters.
	 *
	 * @return the number of role type masters
	 */
	public static int getRoleTypeMastersCount() {
		return getService().getRoleTypeMastersCount();
	}

	/**
	 * Updates the role type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeMaster the role type master
	 * @return the role type master that was updated
	 */
	public static RoleTypeMaster updateRoleTypeMaster(
		RoleTypeMaster roleTypeMaster) {

		return getService().updateRoleTypeMaster(roleTypeMaster);
	}

	public static Boolean validateRoleTypeNames(
		List<String> roleTypeNames, RoleTypeMaster roleTypeMaster) {

		return getService().validateRoleTypeNames(
			roleTypeNames, roleTypeMaster);
	}

	public static RoleTypeMasterLocalService getService() {
		return _service;
	}

	private static volatile RoleTypeMasterLocalService _service;

}
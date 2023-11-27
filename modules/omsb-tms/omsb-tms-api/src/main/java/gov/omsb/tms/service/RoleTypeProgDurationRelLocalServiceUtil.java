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

import gov.omsb.tms.model.RoleTypeProgDurationRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for RoleTypeProgDurationRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.RoleTypeProgDurationRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeProgDurationRelLocalService
 * @generated
 */
public class RoleTypeProgDurationRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.RoleTypeProgDurationRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the role type prog duration rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 * @return the role type prog duration rel that was added
	 */
	public static RoleTypeProgDurationRel addRoleTypeProgDurationRel(
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		return getService().addRoleTypeProgDurationRel(roleTypeProgDurationRel);
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
	 * Creates a new role type prog duration rel with the primary key. Does not add the role type prog duration rel to the database.
	 *
	 * @param RoleTypeProgDurationRelId the primary key for the new role type prog duration rel
	 * @return the new role type prog duration rel
	 */
	public static RoleTypeProgDurationRel createRoleTypeProgDurationRel(
		long RoleTypeProgDurationRelId) {

		return getService().createRoleTypeProgDurationRel(
			RoleTypeProgDurationRelId);
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
	 * Deletes the role type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel that was removed
	 * @throws PortalException if a role type prog duration rel with the primary key could not be found
	 */
	public static RoleTypeProgDurationRel deleteRoleTypeProgDurationRel(
			long RoleTypeProgDurationRelId)
		throws PortalException {

		return getService().deleteRoleTypeProgDurationRel(
			RoleTypeProgDurationRelId);
	}

	/**
	 * Deletes the role type prog duration rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 * @return the role type prog duration rel that was removed
	 */
	public static RoleTypeProgDurationRel deleteRoleTypeProgDurationRel(
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		return getService().deleteRoleTypeProgDurationRel(
			roleTypeProgDurationRel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeProgDurationRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeProgDurationRelModelImpl</code>.
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

	public static RoleTypeProgDurationRel fetchRoleTypeProgDurationRel(
		long RoleTypeProgDurationRelId) {

		return getService().fetchRoleTypeProgDurationRel(
			RoleTypeProgDurationRelId);
	}

	/**
	 * Returns the role type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the role type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel
		fetchRoleTypeProgDurationRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchRoleTypeProgDurationRelByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId) {

		return getService().findByProgramDurationId(programDurationId);
	}

	public static RoleTypeProgDurationRel
		findByProgramDurationIdAndRoleTypeMasterId(
			long programDurationId, long roleTypeMasterId) {

		return getService().findByProgramDurationIdAndRoleTypeMasterId(
			programDurationId, roleTypeMasterId);
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

	public static Map<Long, String> getOtherRoleTypesFromRoleMaster(
		long programDurationId, String type, String languageCode) {

		return getService().getOtherRoleTypesFromRoleMaster(
			programDurationId, type, languageCode);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the role type prog duration rel with the primary key.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel
	 * @throws PortalException if a role type prog duration rel with the primary key could not be found
	 */
	public static RoleTypeProgDurationRel getRoleTypeProgDurationRel(
			long RoleTypeProgDurationRelId)
		throws PortalException {

		return getService().getRoleTypeProgDurationRel(
			RoleTypeProgDurationRelId);
	}

	/**
	 * Returns the role type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the role type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role type prog duration rel
	 * @throws PortalException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel
			getRoleTypeProgDurationRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getRoleTypeProgDurationRelByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> getRoleTypeProgDurationRels(
		int start, int end) {

		return getService().getRoleTypeProgDurationRels(start, end);
	}

	/**
	 * Returns all the role type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the role type prog duration rels
	 * @param companyId the primary key of the company
	 * @return the matching role type prog duration rels, or an empty list if no matches were found
	 */
	public static List<RoleTypeProgDurationRel>
		getRoleTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getRoleTypeProgDurationRelsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of role type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the role type prog duration rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching role type prog duration rels, or an empty list if no matches were found
	 */
	public static List<RoleTypeProgDurationRel>
		getRoleTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getService().getRoleTypeProgDurationRelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of role type prog duration rels.
	 *
	 * @return the number of role type prog duration rels
	 */
	public static int getRoleTypeProgDurationRelsCount() {
		return getService().getRoleTypeProgDurationRelsCount();
	}

	/**
	 * Updates the role type prog duration rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 * @return the role type prog duration rel that was updated
	 */
	public static RoleTypeProgDurationRel updateRoleTypeProgDurationRel(
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		return getService().updateRoleTypeProgDurationRel(
			roleTypeProgDurationRel);
	}

	public static RoleTypeProgDurationRelLocalService getService() {
		return _service;
	}

	private static volatile RoleTypeProgDurationRelLocalService _service;

}
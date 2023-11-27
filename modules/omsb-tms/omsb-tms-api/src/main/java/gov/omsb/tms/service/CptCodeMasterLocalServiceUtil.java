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

import gov.omsb.tms.model.CptCodeMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CptCodeMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.CptCodeMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CptCodeMasterLocalService
 * @generated
 */
public class CptCodeMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.CptCodeMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cpt code master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was added
	 */
	public static CptCodeMaster addCptCodeMaster(CptCodeMaster cptCodeMaster) {
		return getService().addCptCodeMaster(cptCodeMaster);
	}

	/**
	 * Creates a new cpt code master with the primary key. Does not add the cpt code master to the database.
	 *
	 * @param cptCodeMasterId the primary key for the new cpt code master
	 * @return the new cpt code master
	 */
	public static CptCodeMaster createCptCodeMaster(long cptCodeMasterId) {
		return getService().createCptCodeMaster(cptCodeMasterId);
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
	 * Deletes the cpt code master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was removed
	 */
	public static CptCodeMaster deleteCptCodeMaster(
		CptCodeMaster cptCodeMaster) {

		return getService().deleteCptCodeMaster(cptCodeMaster);
	}

	/**
	 * Deletes the cpt code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master that was removed
	 * @throws PortalException if a cpt code master with the primary key could not be found
	 */
	public static CptCodeMaster deleteCptCodeMaster(long cptCodeMasterId)
		throws PortalException {

		return getService().deleteCptCodeMaster(cptCodeMasterId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
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

	public static CptCodeMaster fetchCptCodeMaster(long cptCodeMasterId) {
		return getService().fetchCptCodeMaster(cptCodeMasterId);
	}

	/**
	 * Returns the cpt code master matching the UUID and group.
	 *
	 * @param uuid the cpt code master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchCptCodeMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCptCodeMasterByUuidAndGroupId(uuid, groupId);
	}

	public static List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName) {

		return getService().findByCptCodeNameByLike(cptCodeName);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cpt code master with the primary key.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master
	 * @throws PortalException if a cpt code master with the primary key could not be found
	 */
	public static CptCodeMaster getCptCodeMaster(long cptCodeMasterId)
		throws PortalException {

		return getService().getCptCodeMaster(cptCodeMasterId);
	}

	/**
	 * Returns the cpt code master matching the UUID and group.
	 *
	 * @param uuid the cpt code master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cpt code master
	 * @throws PortalException if a matching cpt code master could not be found
	 */
	public static CptCodeMaster getCptCodeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCptCodeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of cpt code masters
	 */
	public static List<CptCodeMaster> getCptCodeMasters(int start, int end) {
		return getService().getCptCodeMasters(start, end);
	}

	/**
	 * Returns all the cpt code masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the cpt code masters
	 * @param companyId the primary key of the company
	 * @return the matching cpt code masters, or an empty list if no matches were found
	 */
	public static List<CptCodeMaster> getCptCodeMastersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCptCodeMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of cpt code masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the cpt code masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cpt code masters, or an empty list if no matches were found
	 */
	public static List<CptCodeMaster> getCptCodeMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getService().getCptCodeMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cpt code masters.
	 *
	 * @return the number of cpt code masters
	 */
	public static int getCptCodeMastersCount() {
		return getService().getCptCodeMastersCount();
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
	 * Updates the cpt code master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was updated
	 */
	public static CptCodeMaster updateCptCodeMaster(
		CptCodeMaster cptCodeMaster) {

		return getService().updateCptCodeMaster(cptCodeMaster);
	}

	public static CptCodeMasterLocalService getService() {
		return _service;
	}

	private static volatile CptCodeMasterLocalService _service;

}
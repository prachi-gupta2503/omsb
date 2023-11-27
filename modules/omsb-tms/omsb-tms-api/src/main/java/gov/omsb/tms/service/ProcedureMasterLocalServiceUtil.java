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

import gov.omsb.tms.model.ProcedureMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for ProcedureMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProcedureMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureMasterLocalService
 * @generated
 */
public class ProcedureMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProcedureMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addLocalizedValue(
		Map<java.util.Locale, String> localizationMap, List<String> values,
		String languageCode) {

		getService().addLocalizedValue(localizationMap, values, languageCode);
	}

	/**
	 * Adds the procedure master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureMaster the procedure master
	 * @return the procedure master that was added
	 */
	public static ProcedureMaster addProcedureMaster(
		ProcedureMaster procedureMaster) {

		return getService().addProcedureMaster(procedureMaster);
	}

	public static ProcedureMaster addUpdateProcedureMaster(
		ProcedureMaster procedureMaster, List<String> procedureNames,
		boolean isCreate) {

		return getService().addUpdateProcedureMaster(
			procedureMaster, procedureNames, isCreate);
	}

	public static boolean checkProcedureNames(
		List<String> procedureNames, javax.portlet.ActionRequest actionRequest,
		ProcedureMaster procedureMaster) {

		return getService().checkProcedureNames(
			procedureNames, actionRequest, procedureMaster);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static boolean createProcedureMaster(
		javax.portlet.ActionRequest actionRequest,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return getService().createProcedureMaster(actionRequest, themeDisplay);
	}

	/**
	 * Creates a new procedure master with the primary key. Does not add the procedure master to the database.
	 *
	 * @param procedureMasterId the primary key for the new procedure master
	 * @return the new procedure master
	 */
	public static ProcedureMaster createProcedureMaster(
		long procedureMasterId) {

		return getService().createProcedureMaster(procedureMasterId);
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
	 * Deletes the procedure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master that was removed
	 * @throws PortalException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster deleteProcedureMaster(long procedureMasterId)
		throws PortalException {

		return getService().deleteProcedureMaster(procedureMasterId);
	}

	/**
	 * Deletes the procedure master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureMaster the procedure master
	 * @return the procedure master that was removed
	 */
	public static ProcedureMaster deleteProcedureMaster(
		ProcedureMaster procedureMaster) {

		return getService().deleteProcedureMaster(procedureMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureMasterModelImpl</code>.
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

	public static ProcedureMaster fetchProcedureMaster(long procedureMasterId) {
		return getService().fetchProcedureMaster(procedureMasterId);
	}

	/**
	 * Returns the procedure master matching the UUID and group.
	 *
	 * @param uuid the procedure master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchProcedureMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProcedureMasterByUuidAndGroupId(uuid, groupId);
	}

	public static List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return getService().findByProcedureGroupMasterId(
			procedureGroupMasterId);
	}

	public static List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName) {

		return getService().findByProcedureNameByLike(procedureName);
	}

	public static List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId) {

		return getService().findByProcedureNameByLikeAndProcedureGroupMasterId(
			procedureName, procedureGroupMasterId);
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
	 * Returns the procedure master with the primary key.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master
	 * @throws PortalException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster getProcedureMaster(long procedureMasterId)
		throws PortalException {

		return getService().getProcedureMaster(procedureMasterId);
	}

	/**
	 * Returns the procedure master matching the UUID and group.
	 *
	 * @param uuid the procedure master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure master
	 * @throws PortalException if a matching procedure master could not be found
	 */
	public static ProcedureMaster getProcedureMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProcedureMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of procedure masters
	 */
	public static List<ProcedureMaster> getProcedureMasters(
		int start, int end) {

		return getService().getProcedureMasters(start, end);
	}

	/**
	 * Returns all the procedure masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure masters
	 * @param companyId the primary key of the company
	 * @return the matching procedure masters, or an empty list if no matches were found
	 */
	public static List<ProcedureMaster> getProcedureMastersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProcedureMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of procedure masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procedure masters, or an empty list if no matches were found
	 */
	public static List<ProcedureMaster> getProcedureMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getService().getProcedureMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of procedure masters.
	 *
	 * @return the number of procedure masters
	 */
	public static int getProcedureMastersCount() {
		return getService().getProcedureMastersCount();
	}

	public static boolean updateProcedureMaster(
			javax.portlet.ActionRequest actionRequest, long procedureMasterId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws PortalException {

		return getService().updateProcedureMaster(
			actionRequest, procedureMasterId, themeDisplay);
	}

	/**
	 * Updates the procedure master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureMaster the procedure master
	 * @return the procedure master that was updated
	 */
	public static ProcedureMaster updateProcedureMaster(
		ProcedureMaster procedureMaster) {

		return getService().updateProcedureMaster(procedureMaster);
	}

	public static boolean validateProcedure(
		javax.portlet.ActionRequest actionRequest,
		ProcedureMaster procedureMaster) {

		return getService().validateProcedure(actionRequest, procedureMaster);
	}

	public static boolean validateProcedureNames(
		List<String> procedureNames, ProcedureMaster procedureMaster,
		long procedureGroupMasterId) {

		return getService().validateProcedureNames(
			procedureNames, procedureMaster, procedureGroupMasterId);
	}

	public static ProcedureMasterLocalService getService() {
		return _service;
	}

	private static volatile ProcedureMasterLocalService _service;

}
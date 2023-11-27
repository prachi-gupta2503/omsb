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

import gov.omsb.tms.model.ProcedureGroupMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for ProcedureGroupMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProcedureGroupMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupMasterLocalService
 * @generated
 */
public class ProcedureGroupMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProcedureGroupMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addLocalizedValue(
		Map<java.util.Locale, String> localizationMap, List<String> values,
		String languageCode) {

		getService().addLocalizedValue(localizationMap, values, languageCode);
	}

	/**
	 * Adds the procedure group master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupMaster the procedure group master
	 * @return the procedure group master that was added
	 */
	public static ProcedureGroupMaster addProcedureGroupMaster(
		ProcedureGroupMaster procedureGroupMaster) {

		return getService().addProcedureGroupMaster(procedureGroupMaster);
	}

	public static ProcedureGroupMaster addUpdateProcedureGroupMaster(
		ProcedureGroupMaster procedureGroupMaster,
		List<String> procedureGroupNames, boolean isCreate) {

		return getService().addUpdateProcedureGroupMaster(
			procedureGroupMaster, procedureGroupNames, isCreate);
	}

	public static boolean checkProcedureGroupNames(
		List<String> procedureGroupNames,
		javax.portlet.ActionRequest actionRequest,
		ProcedureGroupMaster procedureGroupMaster) {

		return getService().checkProcedureGroupNames(
			procedureGroupNames, actionRequest, procedureGroupMaster);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static boolean createProcedureGroupMaster(
		javax.portlet.ActionRequest actionRequest,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return getService().createProcedureGroupMaster(
			actionRequest, themeDisplay);
	}

	/**
	 * Creates a new procedure group master with the primary key. Does not add the procedure group master to the database.
	 *
	 * @param procedureGroupMasterId the primary key for the new procedure group master
	 * @return the new procedure group master
	 */
	public static ProcedureGroupMaster createProcedureGroupMaster(
		long procedureGroupMasterId) {

		return getService().createProcedureGroupMaster(procedureGroupMasterId);
	}

	public static boolean createProcedureGroupMaster(
		javax.portlet.PortletRequest request) {

		return getService().createProcedureGroupMaster(request);
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
	 * Deletes the procedure group master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master that was removed
	 * @throws PortalException if a procedure group master with the primary key could not be found
	 */
	public static ProcedureGroupMaster deleteProcedureGroupMaster(
			long procedureGroupMasterId)
		throws PortalException {

		return getService().deleteProcedureGroupMaster(procedureGroupMasterId);
	}

	/**
	 * Deletes the procedure group master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupMaster the procedure group master
	 * @return the procedure group master that was removed
	 */
	public static ProcedureGroupMaster deleteProcedureGroupMaster(
		ProcedureGroupMaster procedureGroupMaster) {

		return getService().deleteProcedureGroupMaster(procedureGroupMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupMasterModelImpl</code>.
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

	public static ProcedureGroupMaster fetchProcedureGroupMaster(
		long procedureGroupMasterId) {

		return getService().fetchProcedureGroupMaster(procedureGroupMasterId);
	}

	/**
	 * Returns the procedure group master matching the UUID and group.
	 *
	 * @param uuid the procedure group master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster
		fetchProcedureGroupMasterByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProcedureGroupMasterByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName) {

		return getService().findByprocedureGroupNameByLike(procedureGroupName);
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
	 * Returns the procedure group master with the primary key.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master
	 * @throws PortalException if a procedure group master with the primary key could not be found
	 */
	public static ProcedureGroupMaster getProcedureGroupMaster(
			long procedureGroupMasterId)
		throws PortalException {

		return getService().getProcedureGroupMaster(procedureGroupMasterId);
	}

	/**
	 * Returns the procedure group master matching the UUID and group.
	 *
	 * @param uuid the procedure group master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure group master
	 * @throws PortalException if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster getProcedureGroupMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProcedureGroupMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of procedure group masters
	 */
	public static List<ProcedureGroupMaster> getProcedureGroupMasters(
		int start, int end) {

		return getService().getProcedureGroupMasters(start, end);
	}

	/**
	 * Returns all the procedure group masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure group masters
	 * @param companyId the primary key of the company
	 * @return the matching procedure group masters, or an empty list if no matches were found
	 */
	public static List<ProcedureGroupMaster>
		getProcedureGroupMastersByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getProcedureGroupMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of procedure group masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure group masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procedure group masters, or an empty list if no matches were found
	 */
	public static List<ProcedureGroupMaster>
		getProcedureGroupMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getService().getProcedureGroupMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of procedure group masters.
	 *
	 * @return the number of procedure group masters
	 */
	public static int getProcedureGroupMastersCount() {
		return getService().getProcedureGroupMastersCount();
	}

	public static boolean updateProcedureGroupMaster(
			javax.portlet.ActionRequest actionRequest,
			long procedureGroupMasterId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws PortalException {

		return getService().updateProcedureGroupMaster(
			actionRequest, procedureGroupMasterId, themeDisplay);
	}

	/**
	 * Updates the procedure group master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupMaster the procedure group master
	 * @return the procedure group master that was updated
	 */
	public static ProcedureGroupMaster updateProcedureGroupMaster(
		ProcedureGroupMaster procedureGroupMaster) {

		return getService().updateProcedureGroupMaster(procedureGroupMaster);
	}

	public static boolean validateProcedureGroup(
		javax.portlet.ActionRequest actionRequest,
		ProcedureGroupMaster procedureGroupMaster) {

		return getService().validateProcedureGroup(
			actionRequest, procedureGroupMaster);
	}

	public static boolean validateProcedureGroupNames(
		List<String> procedureGroupNames,
		ProcedureGroupMaster procedureGroupMaster) {

		return getService().validateProcedureGroupNames(
			procedureGroupNames, procedureGroupMaster);
	}

	public static ProcedureGroupMasterLocalService getService() {
		return _service;
	}

	private static volatile ProcedureGroupMasterLocalService _service;

}
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

import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProcedureGroupProceduresCPTCodeRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProcedureGroupProceduresCPTCodeRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupProceduresCPTCodeRelLocalService
 * @generated
 */
public class ProcedureGroupProceduresCPTCodeRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProcedureGroupProceduresCPTCodeRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the procedure group procedures cpt code rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupProceduresCPTCodeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupProceduresCPTCodeRel the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was added
	 */
	public static ProcedureGroupProceduresCPTCodeRel
		addProcedureGroupProceduresCPTCodeRel(
			ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel) {

		return getService().addProcedureGroupProceduresCPTCodeRel(
			procedureGroupProceduresCPTCodeRel);
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
	 * Creates a new procedure group procedures cpt code rel with the primary key. Does not add the procedure group procedures cpt code rel to the database.
	 *
	 * @param pgProcedureCptCodeRelId the primary key for the new procedure group procedures cpt code rel
	 * @return the new procedure group procedures cpt code rel
	 */
	public static ProcedureGroupProceduresCPTCodeRel
		createProcedureGroupProceduresCPTCodeRel(long pgProcedureCptCodeRelId) {

		return getService().createProcedureGroupProceduresCPTCodeRel(
			pgProcedureCptCodeRelId);
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
	 * Deletes the procedure group procedures cpt code rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupProceduresCPTCodeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was removed
	 * @throws PortalException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel
			deleteProcedureGroupProceduresCPTCodeRel(
				long pgProcedureCptCodeRelId)
		throws PortalException {

		return getService().deleteProcedureGroupProceduresCPTCodeRel(
			pgProcedureCptCodeRelId);
	}

	/**
	 * Deletes the procedure group procedures cpt code rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupProceduresCPTCodeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupProceduresCPTCodeRel the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was removed
	 */
	public static ProcedureGroupProceduresCPTCodeRel
		deleteProcedureGroupProceduresCPTCodeRel(
			ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel) {

		return getService().deleteProcedureGroupProceduresCPTCodeRel(
			procedureGroupProceduresCPTCodeRel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
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

	public static ProcedureGroupProceduresCPTCodeRel
		fetchProcedureGroupProceduresCPTCodeRel(long pgProcedureCptCodeRelId) {

		return getService().fetchProcedureGroupProceduresCPTCodeRel(
			pgProcedureCptCodeRelId);
	}

	/**
	 * Returns the procedure group procedures cpt code rel matching the UUID and group.
	 *
	 * @param uuid the procedure group procedures cpt code rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel
		fetchProcedureGroupProceduresCPTCodeRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchProcedureGroupProceduresCPTCodeRelByUuidAndGroupId(
				uuid, groupId);
	}

	public static List<ProcedureGroupProceduresCPTCodeRel>
		findByProcedureGroupId(long procedureGroupId) {

		return getService().findByProcedureGroupId(procedureGroupId);
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
	 * Returns the procedure group procedures cpt code rel with the primary key.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel
	 * @throws PortalException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel
			getProcedureGroupProceduresCPTCodeRel(long pgProcedureCptCodeRelId)
		throws PortalException {

		return getService().getProcedureGroupProceduresCPTCodeRel(
			pgProcedureCptCodeRelId);
	}

	/**
	 * Returns the procedure group procedures cpt code rel matching the UUID and group.
	 *
	 * @param uuid the procedure group procedures cpt code rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure group procedures cpt code rel
	 * @throws PortalException if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel
			getProcedureGroupProceduresCPTCodeRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().
			getProcedureGroupProceduresCPTCodeRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel>
		getProcedureGroupProceduresCPTCodeRels(int start, int end) {

		return getService().getProcedureGroupProceduresCPTCodeRels(start, end);
	}

	/**
	 * Returns all the procedure group procedures cpt code rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure group procedures cpt code rels
	 * @param companyId the primary key of the company
	 * @return the matching procedure group procedures cpt code rels, or an empty list if no matches were found
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel>
		getProcedureGroupProceduresCPTCodeRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getProcedureGroupProceduresCPTCodeRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of procedure group procedures cpt code rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure group procedures cpt code rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procedure group procedures cpt code rels, or an empty list if no matches were found
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel>
		getProcedureGroupProceduresCPTCodeRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator) {

		return getService().
			getProcedureGroupProceduresCPTCodeRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels.
	 *
	 * @return the number of procedure group procedures cpt code rels
	 */
	public static int getProcedureGroupProceduresCPTCodeRelsCount() {
		return getService().getProcedureGroupProceduresCPTCodeRelsCount();
	}

	/**
	 * Updates the procedure group procedures cpt code rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupProceduresCPTCodeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupProceduresCPTCodeRel the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was updated
	 */
	public static ProcedureGroupProceduresCPTCodeRel
		updateProcedureGroupProceduresCPTCodeRel(
			ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel) {

		return getService().updateProcedureGroupProceduresCPTCodeRel(
			procedureGroupProceduresCPTCodeRel);
	}

	public static ProcedureGroupProceduresCPTCodeRelLocalService getService() {
		return _service;
	}

	private static volatile ProcedureGroupProceduresCPTCodeRelLocalService
		_service;

}
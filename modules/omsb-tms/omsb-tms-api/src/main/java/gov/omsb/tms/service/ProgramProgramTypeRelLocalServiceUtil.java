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

import gov.omsb.tms.model.ProgramProgramTypeRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgramProgramTypeRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgramProgramTypeRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramProgramTypeRelLocalService
 * @generated
 */
public class ProgramProgramTypeRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgramProgramTypeRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the program program type rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramProgramTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programProgramTypeRel the program program type rel
	 * @return the program program type rel that was added
	 */
	public static ProgramProgramTypeRel addProgramProgramTypeRel(
		ProgramProgramTypeRel programProgramTypeRel) {

		return getService().addProgramProgramTypeRel(programProgramTypeRel);
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
	 * Creates a new program program type rel with the primary key. Does not add the program program type rel to the database.
	 *
	 * @param programPtId the primary key for the new program program type rel
	 * @return the new program program type rel
	 */
	public static ProgramProgramTypeRel createProgramProgramTypeRel(
		long programPtId) {

		return getService().createProgramProgramTypeRel(programPtId);
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
	 * Deletes the program program type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramProgramTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel that was removed
	 * @throws PortalException if a program program type rel with the primary key could not be found
	 */
	public static ProgramProgramTypeRel deleteProgramProgramTypeRel(
			long programPtId)
		throws PortalException {

		return getService().deleteProgramProgramTypeRel(programPtId);
	}

	/**
	 * Deletes the program program type rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramProgramTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programProgramTypeRel the program program type rel
	 * @return the program program type rel that was removed
	 */
	public static ProgramProgramTypeRel deleteProgramProgramTypeRel(
		ProgramProgramTypeRel programProgramTypeRel) {

		return getService().deleteProgramProgramTypeRel(programProgramTypeRel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramProgramTypeRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramProgramTypeRelModelImpl</code>.
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

	public static ProgramProgramTypeRel fetchProgramProgramTypeRel(
		long programPtId) {

		return getService().fetchProgramProgramTypeRel(programPtId);
	}

	/**
	 * Returns the program program type rel matching the UUID and group.
	 *
	 * @param uuid the program program type rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel
		fetchProgramProgramTypeRelByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProgramProgramTypeRelByUuidAndGroupId(
			uuid, groupId);
	}

	public static ProgramProgramTypeRel findByProgramAndProgramTypeId(
		long programMasterId, long programTypeMasterId) {

		return getService().findByProgramAndProgramTypeId(
			programMasterId, programTypeMasterId);
	}

	public static ProgramProgramTypeRel findByProgramId(long programMasterId) {
		return getService().findByProgramId(programMasterId);
	}

	public static List<ProgramProgramTypeRel> findProgramMasterByPerogramTypeId(
		long programTypeId) {

		return getService().findProgramMasterByPerogramTypeId(programTypeId);
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
	 * Returns the program program type rel with the primary key.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel
	 * @throws PortalException if a program program type rel with the primary key could not be found
	 */
	public static ProgramProgramTypeRel getProgramProgramTypeRel(
			long programPtId)
		throws PortalException {

		return getService().getProgramProgramTypeRel(programPtId);
	}

	/**
	 * Returns the program program type rel matching the UUID and group.
	 *
	 * @param uuid the program program type rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program program type rel
	 * @throws PortalException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel
			getProgramProgramTypeRelByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getProgramProgramTypeRelByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the program program type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of program program type rels
	 */
	public static List<ProgramProgramTypeRel> getProgramProgramTypeRels(
		int start, int end) {

		return getService().getProgramProgramTypeRels(start, end);
	}

	/**
	 * Returns all the program program type rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program program type rels
	 * @param companyId the primary key of the company
	 * @return the matching program program type rels, or an empty list if no matches were found
	 */
	public static List<ProgramProgramTypeRel>
		getProgramProgramTypeRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getProgramProgramTypeRelsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of program program type rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program program type rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program program type rels, or an empty list if no matches were found
	 */
	public static List<ProgramProgramTypeRel>
		getProgramProgramTypeRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getService().getProgramProgramTypeRelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program program type rels.
	 *
	 * @return the number of program program type rels
	 */
	public static int getProgramProgramTypeRelsCount() {
		return getService().getProgramProgramTypeRelsCount();
	}

	/**
	 * Updates the program program type rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramProgramTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programProgramTypeRel the program program type rel
	 * @return the program program type rel that was updated
	 */
	public static ProgramProgramTypeRel updateProgramProgramTypeRel(
		ProgramProgramTypeRel programProgramTypeRel) {

		return getService().updateProgramProgramTypeRel(programProgramTypeRel);
	}

	public static ProgramProgramTypeRelLocalService getService() {
		return _service;
	}

	private static volatile ProgramProgramTypeRelLocalService _service;

}
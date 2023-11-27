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

import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgdurationRotationTlPgProcedurePtRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTlPgProcedurePtRelLocalService
 * @generated
 */
public class ProgdurationRotationTlPgProcedurePtRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the progduration rotation tl pg procedure pt rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was added
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		addProgdurationRotationTlPgProcedurePtRel(
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		return getService().addProgdurationRotationTlPgProcedurePtRel(
			progdurationRotationTlPgProcedurePtRel);
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
	 * Creates a new progduration rotation tl pg procedure pt rel with the primary key. Does not add the progduration rotation tl pg procedure pt rel to the database.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key for the new progduration rotation tl pg procedure pt rel
	 * @return the new progduration rotation tl pg procedure pt rel
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		createProgdurationRotationTlPgProcedurePtRel(
			long progdurationRotationTlPgProcedurePtRelId) {

		return getService().createProgdurationRotationTlPgProcedurePtRel(
			progdurationRotationTlPgProcedurePtRelId);
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
	 * Deletes the progduration rotation tl pg procedure pt rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 * @throws PortalException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			deleteProgdurationRotationTlPgProcedurePtRel(
				long progdurationRotationTlPgProcedurePtRelId)
		throws PortalException {

		return getService().deleteProgdurationRotationTlPgProcedurePtRel(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Deletes the progduration rotation tl pg procedure pt rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		deleteProgdurationRotationTlPgProcedurePtRel(
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		return getService().deleteProgdurationRotationTlPgProcedurePtRel(
			progdurationRotationTlPgProcedurePtRel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
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

	public static ProgdurationRotationTlPgProcedurePtRel
		fetchProgdurationRotationTlPgProcedurePtRel(
			long progdurationRotationTlPgProcedurePtRelId) {

		return getService().fetchProgdurationRotationTlPgProcedurePtRel(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation tl pg procedure pt rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
				uuid, groupId);
	}

	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(long programDurationId) {

		return getService().findByProgramDurationId(programDurationId);
	}

	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId) {

		return getService().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId);
	}

	public static ProgdurationRotationTlPgProcedurePtRel
		findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId) {

		return getService().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				programDurationId, procedureGroupId, procedureId, rotationId);
	}

	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findProgdurationRotationTlPgProcedurePtRelByProcedureGroupId(
			long procedureGroupId) {

		return getService().
			findProgdurationRotationTlPgProcedurePtRelByProcedureGroupId(
				procedureGroupId);
	}

	public static ProgdurationRotationTlPgProcedurePtRel
		findProgdurationRotationTlPgProcedurePtRelByProcedureId(
			long procedureId) {

		return getService().
			findProgdurationRotationTlPgProcedurePtRelByProcedureId(
				procedureId);
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
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel
	 * @throws PortalException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			getProgdurationRotationTlPgProcedurePtRel(
				long progdurationRotationTlPgProcedurePtRelId)
		throws PortalException {

		return getService().getProgdurationRotationTlPgProcedurePtRel(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation tl pg procedure pt rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws PortalException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			getProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().
			getProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		getProgdurationRotationTlPgProcedurePtRels(int start, int end) {

		return getService().getProgdurationRotationTlPgProcedurePtRels(
			start, end);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation tl pg procedure pt rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation tl pg procedure pt rels, or an empty list if no matches were found
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of progduration rotation tl pg procedure pt rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation tl pg procedure pt rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration rotation tl pg procedure pt rels, or an empty list if no matches were found
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getService().
			getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels.
	 *
	 * @return the number of progduration rotation tl pg procedure pt rels
	 */
	public static int getProgdurationRotationTlPgProcedurePtRelsCount() {
		return getService().getProgdurationRotationTlPgProcedurePtRelsCount();
	}

	public static List<gov.omsb.tms.custom.dto.SetupProcedureDTO>
		getSetUpProcedureDetails(String languageCode) {

		return getService().getSetUpProcedureDetails(languageCode);
	}

	/**
	 * Updates the progduration rotation tl pg procedure pt rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was updated
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		updateProgdurationRotationTlPgProcedurePtRel(
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		return getService().updateProgdurationRotationTlPgProcedurePtRel(
			progdurationRotationTlPgProcedurePtRel);
	}

	public static ProgdurationRotationTlPgProcedurePtRelLocalService
		getService() {

		return _service;
	}

	private static volatile ProgdurationRotationTlPgProcedurePtRelLocalService
		_service;

}
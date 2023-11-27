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

import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgdurationCompetenciesRequirementsRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgdurationCompetenciesRequirementsRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationCompetenciesRequirementsRelLocalService
 * @generated
 */
public class ProgdurationCompetenciesRequirementsRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgdurationCompetenciesRequirementsRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ProgdurationCompetenciesRequirementsRel
		addProgdurationCompetenciesRequirementsRel(
			long groupId, long companyId, long progDurationId,
			long competenciesMasterId, String requirements) {

		return getService().addProgdurationCompetenciesRequirementsRel(
			groupId, companyId, progDurationId, competenciesMasterId,
			requirements);
	}

	/**
	 * Adds the progduration competencies requirements rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationCompetenciesRequirementsRel the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was added
	 */
	public static ProgdurationCompetenciesRequirementsRel
		addProgdurationCompetenciesRequirementsRel(
			ProgdurationCompetenciesRequirementsRel
				progdurationCompetenciesRequirementsRel) {

		return getService().addProgdurationCompetenciesRequirementsRel(
			progdurationCompetenciesRequirementsRel);
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
	 * Creates a new progduration competencies requirements rel with the primary key. Does not add the progduration competencies requirements rel to the database.
	 *
	 * @param progdurationCompetenciesRelId the primary key for the new progduration competencies requirements rel
	 * @return the new progduration competencies requirements rel
	 */
	public static ProgdurationCompetenciesRequirementsRel
		createProgdurationCompetenciesRequirementsRel(
			long progdurationCompetenciesRelId) {

		return getService().createProgdurationCompetenciesRequirementsRel(
			progdurationCompetenciesRelId);
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
	 * Deletes the progduration competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was removed
	 * @throws PortalException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel
			deleteProgdurationCompetenciesRequirementsRel(
				long progdurationCompetenciesRelId)
		throws PortalException {

		return getService().deleteProgdurationCompetenciesRequirementsRel(
			progdurationCompetenciesRelId);
	}

	/**
	 * Deletes the progduration competencies requirements rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationCompetenciesRequirementsRel the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was removed
	 */
	public static ProgdurationCompetenciesRequirementsRel
		deleteProgdurationCompetenciesRequirementsRel(
			ProgdurationCompetenciesRequirementsRel
				progdurationCompetenciesRequirementsRel) {

		return getService().deleteProgdurationCompetenciesRequirementsRel(
			progdurationCompetenciesRequirementsRel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationCompetenciesRequirementsRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationCompetenciesRequirementsRelModelImpl</code>.
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

	public static ProgdurationCompetenciesRequirementsRel
		fetchProgdurationCompetenciesRequirementsRel(
			long progdurationCompetenciesRelId) {

		return getService().fetchProgdurationCompetenciesRequirementsRel(
			progdurationCompetenciesRelId);
	}

	/**
	 * Returns the progduration competencies requirements rel matching the UUID and group.
	 *
	 * @param uuid the progduration competencies requirements rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel
		fetchProgdurationCompetenciesRequirementsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchProgdurationCompetenciesRequirementsRelByUuidAndGroupId(
				uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<ProgdurationCompetenciesRequirementsRel>
		getByProgDurationId(long progDurationId) {

		return getService().getByProgDurationId(progDurationId);
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
	 * Returns the progduration competencies requirements rel with the primary key.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel
	 * @throws PortalException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel
			getProgdurationCompetenciesRequirementsRel(
				long progdurationCompetenciesRelId)
		throws PortalException {

		return getService().getProgdurationCompetenciesRequirementsRel(
			progdurationCompetenciesRelId);
	}

	/**
	 * Returns the progduration competencies requirements rel matching the UUID and group.
	 *
	 * @param uuid the progduration competencies requirements rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration competencies requirements rel
	 * @throws PortalException if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel
			getProgdurationCompetenciesRequirementsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().
			getProgdurationCompetenciesRequirementsRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @return the range of progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel>
		getProgdurationCompetenciesRequirementsRels(int start, int end) {

		return getService().getProgdurationCompetenciesRequirementsRels(
			start, end);
	}

	/**
	 * Returns all the progduration competencies requirements rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration competencies requirements rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration competencies requirements rels, or an empty list if no matches were found
	 */
	public static List<ProgdurationCompetenciesRequirementsRel>
		getProgdurationCompetenciesRequirementsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getProgdurationCompetenciesRequirementsRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of progduration competencies requirements rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration competencies requirements rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration competencies requirements rels, or an empty list if no matches were found
	 */
	public static List<ProgdurationCompetenciesRequirementsRel>
		getProgdurationCompetenciesRequirementsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgdurationCompetenciesRequirementsRel>
				orderByComparator) {

		return getService().
			getProgdurationCompetenciesRequirementsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration competencies requirements rels.
	 *
	 * @return the number of progduration competencies requirements rels
	 */
	public static int getProgdurationCompetenciesRequirementsRelsCount() {
		return getService().getProgdurationCompetenciesRequirementsRelsCount();
	}

	/**
	 * Updates the progduration competencies requirements rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationCompetenciesRequirementsRel the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was updated
	 */
	public static ProgdurationCompetenciesRequirementsRel
		updateProgdurationCompetenciesRequirementsRel(
			ProgdurationCompetenciesRequirementsRel
				progdurationCompetenciesRequirementsRel) {

		return getService().updateProgdurationCompetenciesRequirementsRel(
			progdurationCompetenciesRequirementsRel);
	}

	public static ProgdurationCompetenciesRequirementsRelLocalService
		getService() {

		return _service;
	}

	private static volatile ProgdurationCompetenciesRequirementsRelLocalService
		_service;

}
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

import gov.omsb.tms.model.TraineeCohortDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TraineeCohortDetails. This utility wraps
 * <code>gov.omsb.tms.service.impl.TraineeCohortDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeCohortDetailsLocalService
 * @generated
 */
public class TraineeCohortDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TraineeCohortDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the trainee cohort details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeCohortDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 * @return the trainee cohort details that was added
	 */
	public static TraineeCohortDetails addTraineeCohortDetails(
		TraineeCohortDetails traineeCohortDetails) {

		return getService().addTraineeCohortDetails(traineeCohortDetails);
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
	 * Creates a new trainee cohort details with the primary key. Does not add the trainee cohort details to the database.
	 *
	 * @param traineeCohortDetailsId the primary key for the new trainee cohort details
	 * @return the new trainee cohort details
	 */
	public static TraineeCohortDetails createTraineeCohortDetails(
		long traineeCohortDetailsId) {

		return getService().createTraineeCohortDetails(traineeCohortDetailsId);
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
	 * Deletes the trainee cohort details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeCohortDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details that was removed
	 * @throws PortalException if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails deleteTraineeCohortDetails(
			long traineeCohortDetailsId)
		throws PortalException {

		return getService().deleteTraineeCohortDetails(traineeCohortDetailsId);
	}

	/**
	 * Deletes the trainee cohort details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeCohortDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 * @return the trainee cohort details that was removed
	 */
	public static TraineeCohortDetails deleteTraineeCohortDetails(
		TraineeCohortDetails traineeCohortDetails) {

		return getService().deleteTraineeCohortDetails(traineeCohortDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeCohortDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeCohortDetailsModelImpl</code>.
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

	public static TraineeCohortDetails fetchTraineeCohortDetails(
		long traineeCohortDetailsId) {

		return getService().fetchTraineeCohortDetails(traineeCohortDetailsId);
	}

	/**
	 * Returns the trainee cohort details matching the UUID and group.
	 *
	 * @param uuid the trainee cohort details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
		fetchTraineeCohortDetailsByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchTraineeCohortDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		return getService().findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId);
	}

	public static List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId) {

		return getService().
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId);
	}

	public static TraineeCohortDetails
		findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId) {

		return getService().
			findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId);
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
	 * Returns the trainee cohort details with the primary key.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details
	 * @throws PortalException if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails getTraineeCohortDetails(
			long traineeCohortDetailsId)
		throws PortalException {

		return getService().getTraineeCohortDetails(traineeCohortDetailsId);
	}

	/**
	 * Returns the trainee cohort details matching the UUID and group.
	 *
	 * @param uuid the trainee cohort details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee cohort details
	 * @throws PortalException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails getTraineeCohortDetailsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTraineeCohortDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> getTraineeCohortDetailses(
		int start, int end) {

		return getService().getTraineeCohortDetailses(start, end);
	}

	/**
	 * Returns all the trainee cohort detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee cohort detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee cohort detailses, or an empty list if no matches were found
	 */
	public static List<TraineeCohortDetails>
		getTraineeCohortDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getTraineeCohortDetailsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of trainee cohort detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee cohort detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee cohort detailses, or an empty list if no matches were found
	 */
	public static List<TraineeCohortDetails>
		getTraineeCohortDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getService().getTraineeCohortDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee cohort detailses.
	 *
	 * @return the number of trainee cohort detailses
	 */
	public static int getTraineeCohortDetailsesCount() {
		return getService().getTraineeCohortDetailsesCount();
	}

	/**
	 * Updates the trainee cohort details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeCohortDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 * @return the trainee cohort details that was updated
	 */
	public static TraineeCohortDetails updateTraineeCohortDetails(
		TraineeCohortDetails traineeCohortDetails) {

		return getService().updateTraineeCohortDetails(traineeCohortDetails);
	}

	public static TraineeCohortDetailsLocalService getService() {
		return _service;
	}

	private static volatile TraineeCohortDetailsLocalService _service;

}
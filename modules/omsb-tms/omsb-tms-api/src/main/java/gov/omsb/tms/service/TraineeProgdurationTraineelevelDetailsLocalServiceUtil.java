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

import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TraineeProgdurationTraineelevelDetails. This utility wraps
 * <code>gov.omsb.tms.service.impl.TraineeProgdurationTraineelevelDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeProgdurationTraineelevelDetailsLocalService
 * @generated
 */
public class TraineeProgdurationTraineelevelDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TraineeProgdurationTraineelevelDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the trainee progduration traineelevel details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeProgdurationTraineelevelDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was added
	 */
	public static TraineeProgdurationTraineelevelDetails
		addTraineeProgdurationTraineelevelDetails(
			TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails) {

		return getService().addTraineeProgdurationTraineelevelDetails(
			traineeProgdurationTraineelevelDetails);
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
	 * Creates a new trainee progduration traineelevel details with the primary key. Does not add the trainee progduration traineelevel details to the database.
	 *
	 * @param traineePdTlErDetailsId the primary key for the new trainee progduration traineelevel details
	 * @return the new trainee progduration traineelevel details
	 */
	public static TraineeProgdurationTraineelevelDetails
		createTraineeProgdurationTraineelevelDetails(
			long traineePdTlErDetailsId) {

		return getService().createTraineeProgdurationTraineelevelDetails(
			traineePdTlErDetailsId);
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
	 * Deletes the trainee progduration traineelevel details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeProgdurationTraineelevelDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was removed
	 * @throws PortalException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
			deleteTraineeProgdurationTraineelevelDetails(
				long traineePdTlErDetailsId)
		throws PortalException {

		return getService().deleteTraineeProgdurationTraineelevelDetails(
			traineePdTlErDetailsId);
	}

	/**
	 * Deletes the trainee progduration traineelevel details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeProgdurationTraineelevelDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was removed
	 */
	public static TraineeProgdurationTraineelevelDetails
		deleteTraineeProgdurationTraineelevelDetails(
			TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails) {

		return getService().deleteTraineeProgdurationTraineelevelDetails(
			traineeProgdurationTraineelevelDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeProgdurationTraineelevelDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeProgdurationTraineelevelDetailsModelImpl</code>.
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

	public static TraineeProgdurationTraineelevelDetails
		fetchTraineeProgdurationTraineelevelDetails(
			long traineePdTlErDetailsId) {

		return getService().fetchTraineeProgdurationTraineelevelDetails(
			traineePdTlErDetailsId);
	}

	/**
	 * Returns the trainee progduration traineelevel details matching the UUID and group.
	 *
	 * @param uuid the trainee progduration traineelevel details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
		fetchTraineeProgdurationTraineelevelDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchTraineeProgdurationTraineelevelDetailsByUuidAndGroupId(
				uuid, groupId);
	}

	public static List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId) {

		return getService().findByTraineeId(traineeId);
	}

	public static List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId) {

		return getService().findByTraineeIdAndProgramDurationId(
			traineeId, programDurationId);
	}

	public static TraineeProgdurationTraineelevelDetails
		findByTraineeIdAndTraineeLevelId(long traineeId, long traineeLevelId) {

		return getService().findByTraineeIdAndTraineeLevelId(
			traineeId, traineeLevelId);
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
	 * Returns the trainee progduration traineelevel details with the primary key.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details
	 * @throws PortalException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
			getTraineeProgdurationTraineelevelDetails(
				long traineePdTlErDetailsId)
		throws PortalException {

		return getService().getTraineeProgdurationTraineelevelDetails(
			traineePdTlErDetailsId);
	}

	/**
	 * Returns the trainee progduration traineelevel details matching the UUID and group.
	 *
	 * @param uuid the trainee progduration traineelevel details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee progduration traineelevel details
	 * @throws PortalException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
			getTraineeProgdurationTraineelevelDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().
			getTraineeProgdurationTraineelevelDetailsByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		getTraineeProgdurationTraineelevelDetailses(int start, int end) {

		return getService().getTraineeProgdurationTraineelevelDetailses(
			start, end);
	}

	/**
	 * Returns all the trainee progduration traineelevel detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee progduration traineelevel detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee progduration traineelevel detailses, or an empty list if no matches were found
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		getTraineeProgdurationTraineelevelDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getTraineeProgdurationTraineelevelDetailsesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of trainee progduration traineelevel detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee progduration traineelevel detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee progduration traineelevel detailses, or an empty list if no matches were found
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		getTraineeProgdurationTraineelevelDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator) {

		return getService().
			getTraineeProgdurationTraineelevelDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses.
	 *
	 * @return the number of trainee progduration traineelevel detailses
	 */
	public static int getTraineeProgdurationTraineelevelDetailsesCount() {
		return getService().getTraineeProgdurationTraineelevelDetailsesCount();
	}

	/**
	 * Updates the trainee progduration traineelevel details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeProgdurationTraineelevelDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was updated
	 */
	public static TraineeProgdurationTraineelevelDetails
		updateTraineeProgdurationTraineelevelDetails(
			TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails) {

		return getService().updateTraineeProgdurationTraineelevelDetails(
			traineeProgdurationTraineelevelDetails);
	}

	public static TraineeProgdurationTraineelevelDetailsLocalService
		getService() {

		return _service;
	}

	private static volatile TraineeProgdurationTraineelevelDetailsLocalService
		_service;

}
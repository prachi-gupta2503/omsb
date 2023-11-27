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

import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TraineeElectiverotationPriorityDetails. This utility wraps
 * <code>gov.omsb.tms.service.impl.TraineeElectiverotationPriorityDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeElectiverotationPriorityDetailsLocalService
 * @generated
 */
public class TraineeElectiverotationPriorityDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TraineeElectiverotationPriorityDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the trainee electiverotation priority details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeElectiverotationPriorityDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was added
	 */
	public static TraineeElectiverotationPriorityDetails
		addTraineeElectiverotationPriorityDetails(
			TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails) {

		return getService().addTraineeElectiverotationPriorityDetails(
			traineeElectiverotationPriorityDetails);
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
	 * Creates a new trainee electiverotation priority details with the primary key. Does not add the trainee electiverotation priority details to the database.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key for the new trainee electiverotation priority details
	 * @return the new trainee electiverotation priority details
	 */
	public static TraineeElectiverotationPriorityDetails
		createTraineeElectiverotationPriorityDetails(
			long traineeElectiverotationPriorityDetailsId) {

		return getService().createTraineeElectiverotationPriorityDetails(
			traineeElectiverotationPriorityDetailsId);
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
	 * Deletes the trainee electiverotation priority details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeElectiverotationPriorityDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was removed
	 * @throws PortalException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public static TraineeElectiverotationPriorityDetails
			deleteTraineeElectiverotationPriorityDetails(
				long traineeElectiverotationPriorityDetailsId)
		throws PortalException {

		return getService().deleteTraineeElectiverotationPriorityDetails(
			traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Deletes the trainee electiverotation priority details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeElectiverotationPriorityDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was removed
	 */
	public static TraineeElectiverotationPriorityDetails
		deleteTraineeElectiverotationPriorityDetails(
			TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails) {

		return getService().deleteTraineeElectiverotationPriorityDetails(
			traineeElectiverotationPriorityDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeElectiverotationPriorityDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeElectiverotationPriorityDetailsModelImpl</code>.
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

	public static TraineeElectiverotationPriorityDetails
		fetchTraineeElectiverotationPriorityDetails(
			long traineeElectiverotationPriorityDetailsId) {

		return getService().fetchTraineeElectiverotationPriorityDetails(
			traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Returns the trainee electiverotation priority details matching the UUID and group.
	 *
	 * @param uuid the trainee electiverotation priority details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails
		fetchTraineeElectiverotationPriorityDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchTraineeElectiverotationPriorityDetailsByUuidAndGroupId(
				uuid, groupId);
	}

	public static List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(long traineePdTlErDetailsId) {

		return getService().findByTraineePdTlErDetailsId(
			traineePdTlErDetailsId);
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
	 * Returns the trainee electiverotation priority details with the primary key.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details
	 * @throws PortalException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public static TraineeElectiverotationPriorityDetails
			getTraineeElectiverotationPriorityDetails(
				long traineeElectiverotationPriorityDetailsId)
		throws PortalException {

		return getService().getTraineeElectiverotationPriorityDetails(
			traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Returns the trainee electiverotation priority details matching the UUID and group.
	 *
	 * @param uuid the trainee electiverotation priority details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee electiverotation priority details
	 * @throws PortalException if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails
			getTraineeElectiverotationPriorityDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().
			getTraineeElectiverotationPriorityDetailsByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		getTraineeElectiverotationPriorityDetailses(int start, int end) {

		return getService().getTraineeElectiverotationPriorityDetailses(
			start, end);
	}

	/**
	 * Returns all the trainee electiverotation priority detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee electiverotation priority detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee electiverotation priority detailses, or an empty list if no matches were found
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		getTraineeElectiverotationPriorityDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getTraineeElectiverotationPriorityDetailsesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of trainee electiverotation priority detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee electiverotation priority detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee electiverotation priority detailses, or an empty list if no matches were found
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		getTraineeElectiverotationPriorityDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator) {

		return getService().
			getTraineeElectiverotationPriorityDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses.
	 *
	 * @return the number of trainee electiverotation priority detailses
	 */
	public static int getTraineeElectiverotationPriorityDetailsesCount() {
		return getService().getTraineeElectiverotationPriorityDetailsesCount();
	}

	/**
	 * Updates the trainee electiverotation priority details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeElectiverotationPriorityDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was updated
	 */
	public static TraineeElectiverotationPriorityDetails
		updateTraineeElectiverotationPriorityDetails(
			TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails) {

		return getService().updateTraineeElectiverotationPriorityDetails(
			traineeElectiverotationPriorityDetails);
	}

	public static TraineeElectiverotationPriorityDetailsLocalService
		getService() {

		return _service;
	}

	private static volatile TraineeElectiverotationPriorityDetailsLocalService
		_service;

}
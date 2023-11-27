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

import gov.omsb.tms.model.TraineeSponsorDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TraineeSponsorDetails. This utility wraps
 * <code>gov.omsb.tms.service.impl.TraineeSponsorDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeSponsorDetailsLocalService
 * @generated
 */
public class TraineeSponsorDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TraineeSponsorDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the trainee sponsor details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeSponsorDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 * @return the trainee sponsor details that was added
	 */
	public static TraineeSponsorDetails addTraineeSponsorDetails(
		TraineeSponsorDetails traineeSponsorDetails) {

		return getService().addTraineeSponsorDetails(traineeSponsorDetails);
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
	 * Creates a new trainee sponsor details with the primary key. Does not add the trainee sponsor details to the database.
	 *
	 * @param traineeSponsorDetailsId the primary key for the new trainee sponsor details
	 * @return the new trainee sponsor details
	 */
	public static TraineeSponsorDetails createTraineeSponsorDetails(
		long traineeSponsorDetailsId) {

		return getService().createTraineeSponsorDetails(
			traineeSponsorDetailsId);
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
	 * Deletes the trainee sponsor details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeSponsorDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details that was removed
	 * @throws PortalException if a trainee sponsor details with the primary key could not be found
	 */
	public static TraineeSponsorDetails deleteTraineeSponsorDetails(
			long traineeSponsorDetailsId)
		throws PortalException {

		return getService().deleteTraineeSponsorDetails(
			traineeSponsorDetailsId);
	}

	/**
	 * Deletes the trainee sponsor details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeSponsorDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 * @return the trainee sponsor details that was removed
	 */
	public static TraineeSponsorDetails deleteTraineeSponsorDetails(
		TraineeSponsorDetails traineeSponsorDetails) {

		return getService().deleteTraineeSponsorDetails(traineeSponsorDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeSponsorDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeSponsorDetailsModelImpl</code>.
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

	public static TraineeSponsorDetails fetchTraineeSponsorDetails(
		long traineeSponsorDetailsId) {

		return getService().fetchTraineeSponsorDetails(traineeSponsorDetailsId);
	}

	/**
	 * Returns the trainee sponsor details matching the UUID and group.
	 *
	 * @param uuid the trainee sponsor details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails
		fetchTraineeSponsorDetailsByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchTraineeSponsorDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the trainee sponsor details with the primary key.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details
	 * @throws PortalException if a trainee sponsor details with the primary key could not be found
	 */
	public static TraineeSponsorDetails getTraineeSponsorDetails(
			long traineeSponsorDetailsId)
		throws PortalException {

		return getService().getTraineeSponsorDetails(traineeSponsorDetailsId);
	}

	public static TraineeSponsorDetails getTraineeSponsorDetailsByTraineeId(
		long traineeId) {

		return getService().getTraineeSponsorDetailsByTraineeId(traineeId);
	}

	/**
	 * Returns the trainee sponsor details matching the UUID and group.
	 *
	 * @param uuid the trainee sponsor details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee sponsor details
	 * @throws PortalException if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails
			getTraineeSponsorDetailsByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getTraineeSponsorDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> getTraineeSponsorDetailses(
		int start, int end) {

		return getService().getTraineeSponsorDetailses(start, end);
	}

	/**
	 * Returns all the trainee sponsor detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee sponsor detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee sponsor detailses, or an empty list if no matches were found
	 */
	public static List<TraineeSponsorDetails>
		getTraineeSponsorDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getTraineeSponsorDetailsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of trainee sponsor detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee sponsor detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee sponsor detailses, or an empty list if no matches were found
	 */
	public static List<TraineeSponsorDetails>
		getTraineeSponsorDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getService().getTraineeSponsorDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee sponsor detailses.
	 *
	 * @return the number of trainee sponsor detailses
	 */
	public static int getTraineeSponsorDetailsesCount() {
		return getService().getTraineeSponsorDetailsesCount();
	}

	/**
	 * Updates the trainee sponsor details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeSponsorDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 * @return the trainee sponsor details that was updated
	 */
	public static TraineeSponsorDetails updateTraineeSponsorDetails(
		TraineeSponsorDetails traineeSponsorDetails) {

		return getService().updateTraineeSponsorDetails(traineeSponsorDetails);
	}

	public static TraineeSponsorDetailsLocalService getService() {
		return _service;
	}

	private static volatile TraineeSponsorDetailsLocalService _service;

}
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

import gov.omsb.tms.model.EcMemberRequestState;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EcMemberRequestState. This utility wraps
 * <code>gov.omsb.tms.service.impl.EcMemberRequestStateLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStateLocalService
 * @generated
 */
public class EcMemberRequestStateLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.EcMemberRequestStateLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static EcMemberRequestState addComments(
		String comment, long ecMemberRequestId) {

		return getService().addComments(comment, ecMemberRequestId);
	}

	/**
	 * Adds the ec member request state to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestState the ec member request state
	 * @return the ec member request state that was added
	 */
	public static EcMemberRequestState addEcMemberRequestState(
		EcMemberRequestState ecMemberRequestState) {

		return getService().addEcMemberRequestState(ecMemberRequestState);
	}

	public static EcMemberRequestState addRequestState(
		String comment, long ecMemberRequestId, long statusId, long userId,
		long roleId, boolean isPublic) {

		return getService().addRequestState(
			comment, ecMemberRequestId, statusId, userId, roleId, isPublic);
	}

	/**
	 * Creates a new ec member request state with the primary key. Does not add the ec member request state to the database.
	 *
	 * @param ecMemberRequestStateId the primary key for the new ec member request state
	 * @return the new ec member request state
	 */
	public static EcMemberRequestState createEcMemberRequestState(
		long ecMemberRequestStateId) {

		return getService().createEcMemberRequestState(ecMemberRequestStateId);
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
	 * Deletes the ec member request state from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestState the ec member request state
	 * @return the ec member request state that was removed
	 */
	public static EcMemberRequestState deleteEcMemberRequestState(
		EcMemberRequestState ecMemberRequestState) {

		return getService().deleteEcMemberRequestState(ecMemberRequestState);
	}

	/**
	 * Deletes the ec member request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state that was removed
	 * @throws PortalException if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState deleteEcMemberRequestState(
			long ecMemberRequestStateId)
		throws PortalException {

		return getService().deleteEcMemberRequestState(ecMemberRequestStateId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStateModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStateModelImpl</code>.
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

	public static List<gov.omsb.tms.custom.dto.ECMembershipRequestStateDTO>
		eCMembershipRequestStateList(long emMemberRequestId) {

		return getService().eCMembershipRequestStateList(emMemberRequestId);
	}

	public static EcMemberRequestState fetchEcMemberRequestState(
		long ecMemberRequestStateId) {

		return getService().fetchEcMemberRequestState(ecMemberRequestStateId);
	}

	/**
	 * Returns the ec member request state matching the UUID and group.
	 *
	 * @param uuid the ec member request state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState
		fetchEcMemberRequestStateByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchEcMemberRequestStateByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId) {

		return getService().findByEcMemberRequestId(ecMemberRequestId);
	}

	public static List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic) {

		return getService().findByVisibility(ecMemberRequestId, isPublic);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ec member request state with the primary key.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state
	 * @throws PortalException if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState getEcMemberRequestState(
			long ecMemberRequestStateId)
		throws PortalException {

		return getService().getEcMemberRequestState(ecMemberRequestStateId);
	}

	/**
	 * Returns the ec member request state matching the UUID and group.
	 *
	 * @param uuid the ec member request state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request state
	 * @throws PortalException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState getEcMemberRequestStateByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEcMemberRequestStateByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of ec member request states
	 */
	public static List<EcMemberRequestState> getEcMemberRequestStates(
		int start, int end) {

		return getService().getEcMemberRequestStates(start, end);
	}

	/**
	 * Returns all the ec member request states matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request states
	 * @param companyId the primary key of the company
	 * @return the matching ec member request states, or an empty list if no matches were found
	 */
	public static List<EcMemberRequestState>
		getEcMemberRequestStatesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getEcMemberRequestStatesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of ec member request states matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request states
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ec member request states, or an empty list if no matches were found
	 */
	public static List<EcMemberRequestState>
		getEcMemberRequestStatesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getService().getEcMemberRequestStatesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ec member request states.
	 *
	 * @return the number of ec member request states
	 */
	public static int getEcMemberRequestStatesCount() {
		return getService().getEcMemberRequestStatesCount();
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
	 * Updates the ec member request state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestState the ec member request state
	 * @return the ec member request state that was updated
	 */
	public static EcMemberRequestState updateEcMemberRequestState(
		EcMemberRequestState ecMemberRequestState) {

		return getService().updateEcMemberRequestState(ecMemberRequestState);
	}

	public static EcMemberRequestStateLocalService getService() {
		return _service;
	}

	private static volatile EcMemberRequestStateLocalService _service;

}
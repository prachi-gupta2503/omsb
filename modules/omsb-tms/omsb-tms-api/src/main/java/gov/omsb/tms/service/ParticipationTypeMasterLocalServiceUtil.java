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

import gov.omsb.tms.model.ParticipationTypeMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ParticipationTypeMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.ParticipationTypeMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ParticipationTypeMasterLocalService
 * @generated
 */
public class ParticipationTypeMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ParticipationTypeMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the participation type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was added
	 */
	public static ParticipationTypeMaster addParticipationTypeMaster(
		ParticipationTypeMaster participationTypeMaster) {

		return getService().addParticipationTypeMaster(participationTypeMaster);
	}

	public static ParticipationTypeMaster addUpdateParticipationTypeMaster(
		ParticipationTypeMaster participationTypeMaster,
		List<String> participationTypeNames, boolean isCreate) {

		return getService().addUpdateParticipationTypeMaster(
			participationTypeMaster, participationTypeNames, isCreate);
	}

	/**
	 * Creates a new participation type master with the primary key. Does not add the participation type master to the database.
	 *
	 * @param participationTypeMasterId the primary key for the new participation type master
	 * @return the new participation type master
	 */
	public static ParticipationTypeMaster createParticipationTypeMaster(
		long participationTypeMasterId) {

		return getService().createParticipationTypeMaster(
			participationTypeMasterId);
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
	 * Deletes the participation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master that was removed
	 * @throws PortalException if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster deleteParticipationTypeMaster(
			long participationTypeMasterId)
		throws PortalException {

		return getService().deleteParticipationTypeMaster(
			participationTypeMasterId);
	}

	/**
	 * Deletes the participation type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was removed
	 */
	public static ParticipationTypeMaster deleteParticipationTypeMaster(
		ParticipationTypeMaster participationTypeMaster) {

		return getService().deleteParticipationTypeMaster(
			participationTypeMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
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

	public static ParticipationTypeMaster fetchParticipationTypeMaster(
		long participationTypeMasterId) {

		return getService().fetchParticipationTypeMaster(
			participationTypeMasterId);
	}

	/**
	 * Returns the participation type master matching the UUID and group.
	 *
	 * @param uuid the participation type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster
		fetchParticipationTypeMasterByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchParticipationTypeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId) {

		return getService().
			findByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId);
	}

	public static List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId) {

		return getService().findByProgramDurationId(programDurationId);
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
	 * Returns the participation type master with the primary key.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master
	 * @throws PortalException if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster getParticipationTypeMaster(
			long participationTypeMasterId)
		throws PortalException {

		return getService().getParticipationTypeMaster(
			participationTypeMasterId);
	}

	/**
	 * Returns the participation type master matching the UUID and group.
	 *
	 * @param uuid the participation type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation type master
	 * @throws PortalException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster
			getParticipationTypeMasterByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getParticipationTypeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of participation type masters
	 */
	public static List<ParticipationTypeMaster> getParticipationTypeMasters(
		int start, int end) {

		return getService().getParticipationTypeMasters(start, end);
	}

	/**
	 * Returns all the participation type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the participation type masters
	 * @param companyId the primary key of the company
	 * @return the matching participation type masters, or an empty list if no matches were found
	 */
	public static List<ParticipationTypeMaster>
		getParticipationTypeMastersByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getParticipationTypeMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of participation type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the participation type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching participation type masters, or an empty list if no matches were found
	 */
	public static List<ParticipationTypeMaster>
		getParticipationTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getService().getParticipationTypeMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of participation type masters.
	 *
	 * @return the number of participation type masters
	 */
	public static int getParticipationTypeMastersCount() {
		return getService().getParticipationTypeMastersCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the participation type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was updated
	 */
	public static ParticipationTypeMaster updateParticipationTypeMaster(
		ParticipationTypeMaster participationTypeMaster) {

		return getService().updateParticipationTypeMaster(
			participationTypeMaster);
	}

	public static Boolean validateParticipationTypeNames(
		List<String> participationTypeNames, long programDurationId,
		ParticipationTypeMaster participationTypeMaster) {

		return getService().validateParticipationTypeNames(
			participationTypeNames, programDurationId, participationTypeMaster);
	}

	public static ParticipationTypeMasterLocalService getService() {
		return _service;
	}

	private static volatile ParticipationTypeMasterLocalService _service;

}
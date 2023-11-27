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

import gov.omsb.tms.model.RotationMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RotationMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.RotationMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RotationMasterLocalService
 * @generated
 */
public class RotationMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.RotationMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the rotation master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was added
	 */
	public static RotationMaster addRotationMaster(
		RotationMaster rotationMaster) {

		return getService().addRotationMaster(rotationMaster);
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
	 * Creates a new rotation master with the primary key. Does not add the rotation master to the database.
	 *
	 * @param rotationMasterId the primary key for the new rotation master
	 * @return the new rotation master
	 */
	public static RotationMaster createRotationMaster(long rotationMasterId) {
		return getService().createRotationMaster(rotationMasterId);
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
	 * Deletes the rotation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master that was removed
	 * @throws PortalException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster deleteRotationMaster(long rotationMasterId)
		throws PortalException {

		return getService().deleteRotationMaster(rotationMasterId);
	}

	/**
	 * Deletes the rotation master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was removed
	 */
	public static RotationMaster deleteRotationMaster(
		RotationMaster rotationMaster) {

		return getService().deleteRotationMaster(rotationMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
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

	public static RotationMaster fetchRotationMaster(long rotationMasterId) {
		return getService().fetchRotationMaster(rotationMasterId);
	}

	/**
	 * Returns the rotation master matching the UUID and group.
	 *
	 * @param uuid the rotation master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchRotationMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchRotationMasterByUuidAndGroupId(uuid, groupId);
	}

	public static List<RotationMaster> findByRotationCodeByLike(
		String rotationCode) {

		return getService().findByRotationCodeByLike(rotationCode);
	}

	public static List<RotationMaster> findByRotationNameByLike(
		String rotationName) {

		return getService().findByRotationNameByLike(rotationName);
	}

	public static List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus) {

		return getService().findByRotationStatus(rotationStatus);
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

	public static List<RotationMaster> getRotationListByIdsAndStatus(
		List<Long> ids, Boolean status) {

		return getService().getRotationListByIdsAndStatus(ids, status);
	}

	/**
	 * Returns the rotation master with the primary key.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master
	 * @throws PortalException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster getRotationMaster(long rotationMasterId)
		throws PortalException {

		return getService().getRotationMaster(rotationMasterId);
	}

	/**
	 * Returns the rotation master matching the UUID and group.
	 *
	 * @param uuid the rotation master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation master
	 * @throws PortalException if a matching rotation master could not be found
	 */
	public static RotationMaster getRotationMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getRotationMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of rotation masters
	 */
	public static List<RotationMaster> getRotationMasters(int start, int end) {
		return getService().getRotationMasters(start, end);
	}

	/**
	 * Returns all the rotation masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation masters
	 * @param companyId the primary key of the company
	 * @return the matching rotation masters, or an empty list if no matches were found
	 */
	public static List<RotationMaster> getRotationMastersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getRotationMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of rotation masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching rotation masters, or an empty list if no matches were found
	 */
	public static List<RotationMaster> getRotationMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getService().getRotationMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rotation masters.
	 *
	 * @return the number of rotation masters
	 */
	public static int getRotationMastersCount() {
		return getService().getRotationMastersCount();
	}

	public static List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTraineeLevelId(long traineeLevelId, String languageCode) {

		return getService().getRotationsByTraineeLevelId(
			traineeLevelId, languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTraineeLevelIdAndProgramDurationId(
			long traineeLevelId, long programDurationId, String languageCode) {

		return getService().getRotationsByTraineeLevelIdAndProgramDurationId(
			traineeLevelId, programDurationId, languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.RotationDTO>
		getRotationsByTrainingSiteAndCohort(
			long trainingSiteId, long programDurationId, String languageCode) {

		return getService().getRotationsByTrainingSiteAndCohort(
			trainingSiteId, programDurationId, languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.RotationStructureDTO>
		getRotationStructure(long rotationId, String languageCode) {

		return getService().getRotationStructure(rotationId, languageCode);
	}

	/**
	 * Updates the rotation master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was updated
	 */
	public static RotationMaster updateRotationMaster(
		RotationMaster rotationMaster) {

		return getService().updateRotationMaster(rotationMaster);
	}

	public static RotationMasterLocalService getService() {
		return _service;
	}

	private static volatile RotationMasterLocalService _service;

}
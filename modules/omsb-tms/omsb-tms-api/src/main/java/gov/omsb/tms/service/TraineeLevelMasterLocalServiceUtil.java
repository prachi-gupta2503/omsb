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

import gov.omsb.tms.model.TraineeLevelMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for TraineeLevelMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.TraineeLevelMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLevelMasterLocalService
 * @generated
 */
public class TraineeLevelMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TraineeLevelMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addLocalizedValue(
		Map<java.util.Locale, String> localizationMap, List<String> values,
		String languageCode) {

		getService().addLocalizedValue(localizationMap, values, languageCode);
	}

	/**
	 * Adds the trainee level master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLevelMaster the trainee level master
	 * @return the trainee level master that was added
	 */
	public static TraineeLevelMaster addTraineeLevelMaster(
		TraineeLevelMaster traineeLevelMaster) {

		return getService().addTraineeLevelMaster(traineeLevelMaster);
	}

	public static boolean checkTraineeLevel(
		List<String> traineeLevelNames,
		javax.portlet.ActionRequest actionRequest,
		TraineeLevelMaster traineeLevelMaster) {

		return getService().checkTraineeLevel(
			traineeLevelNames, actionRequest, traineeLevelMaster);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static boolean createTraineeLevelMaster(
		javax.portlet.ActionRequest actionRequest,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return getService().createTraineeLevelMaster(
			actionRequest, themeDisplay);
	}

	/**
	 * Creates a new trainee level master with the primary key. Does not add the trainee level master to the database.
	 *
	 * @param traineeLevelMasterId the primary key for the new trainee level master
	 * @return the new trainee level master
	 */
	public static TraineeLevelMaster createTraineeLevelMaster(
		long traineeLevelMasterId) {

		return getService().createTraineeLevelMaster(traineeLevelMasterId);
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
	 * Deletes the trainee level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master that was removed
	 * @throws PortalException if a trainee level master with the primary key could not be found
	 */
	public static TraineeLevelMaster deleteTraineeLevelMaster(
			long traineeLevelMasterId)
		throws PortalException {

		return getService().deleteTraineeLevelMaster(traineeLevelMasterId);
	}

	/**
	 * Deletes the trainee level master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLevelMaster the trainee level master
	 * @return the trainee level master that was removed
	 */
	public static TraineeLevelMaster deleteTraineeLevelMaster(
		TraineeLevelMaster traineeLevelMaster) {

		return getService().deleteTraineeLevelMaster(traineeLevelMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLevelMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLevelMasterModelImpl</code>.
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

	public static TraineeLevelMaster fetchTraineeLevelMaster(
		long traineeLevelMasterId) {

		return getService().fetchTraineeLevelMaster(traineeLevelMasterId);
	}

	/**
	 * Returns the trainee level master matching the UUID and group.
	 *
	 * @param uuid the trainee level master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public static TraineeLevelMaster fetchTraineeLevelMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTraineeLevelMasterByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<TraineeLevelMaster> findByTraineeLevelIds(
		List<Long> traineeLevelIds) {

		return getService().findByTraineeLevelIds(traineeLevelIds);
	}

	public static List<TraineeLevelMaster> findByTraineeLevelName(
		String traineeLevelName) {

		return getService().findByTraineeLevelName(traineeLevelName);
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

	public static List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
		getTraineeLevelListByDurationId(long durationId) {

		return getService().getTraineeLevelListByDurationId(durationId);
	}

	/**
	 * Returns the trainee level master with the primary key.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master
	 * @throws PortalException if a trainee level master with the primary key could not be found
	 */
	public static TraineeLevelMaster getTraineeLevelMaster(
			long traineeLevelMasterId)
		throws PortalException {

		return getService().getTraineeLevelMaster(traineeLevelMasterId);
	}

	public static List<gov.omsb.tms.custom.dto.ProgramStructureDTO>
		getTraineeLevelMasterByProgramId(long programId) {

		return getService().getTraineeLevelMasterByProgramId(programId);
	}

	/**
	 * Returns the trainee level master matching the UUID and group.
	 *
	 * @param uuid the trainee level master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee level master
	 * @throws PortalException if a matching trainee level master could not be found
	 */
	public static TraineeLevelMaster getTraineeLevelMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTraineeLevelMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of trainee level masters
	 */
	public static List<TraineeLevelMaster> getTraineeLevelMasters(
		int start, int end) {

		return getService().getTraineeLevelMasters(start, end);
	}

	/**
	 * Returns all the trainee level masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee level masters
	 * @param companyId the primary key of the company
	 * @return the matching trainee level masters, or an empty list if no matches were found
	 */
	public static List<TraineeLevelMaster>
		getTraineeLevelMastersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getTraineeLevelMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of trainee level masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee level masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee level masters, or an empty list if no matches were found
	 */
	public static List<TraineeLevelMaster>
		getTraineeLevelMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<TraineeLevelMaster> orderByComparator) {

		return getService().getTraineeLevelMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee level masters.
	 *
	 * @return the number of trainee level masters
	 */
	public static int getTraineeLevelMastersCount() {
		return getService().getTraineeLevelMastersCount();
	}

	public static boolean updateTraineeLevelMaster(
			javax.portlet.ActionRequest actionRequest,
			long traineeLevelMasterId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws PortalException {

		return getService().updateTraineeLevelMaster(
			actionRequest, traineeLevelMasterId, themeDisplay);
	}

	/**
	 * Updates the trainee level master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLevelMaster the trainee level master
	 * @return the trainee level master that was updated
	 */
	public static TraineeLevelMaster updateTraineeLevelMaster(
		TraineeLevelMaster traineeLevelMaster) {

		return getService().updateTraineeLevelMaster(traineeLevelMaster);
	}

	public static boolean validateTraineeLevel(
		javax.portlet.ActionRequest actionRequest,
		TraineeLevelMaster traineeLevelMaster) {

		return getService().validateTraineeLevel(
			actionRequest, traineeLevelMaster);
	}

	public static TraineeLevelMasterLocalService getService() {
		return _service;
	}

	private static volatile TraineeLevelMasterLocalService _service;

}
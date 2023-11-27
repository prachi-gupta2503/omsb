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

import gov.omsb.tms.model.OmsbTmsFinder;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for OmsbTmsFinder. This utility wraps
 * <code>gov.omsb.tms.service.impl.OmsbTmsFinderLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OmsbTmsFinderLocalService
 * @generated
 */
public class OmsbTmsFinderLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.OmsbTmsFinderLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the omsb tms finder to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OmsbTmsFinderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param omsbTmsFinder the omsb tms finder
	 * @return the omsb tms finder that was added
	 */
	public static OmsbTmsFinder addOmsbTmsFinder(OmsbTmsFinder omsbTmsFinder) {
		return getService().addOmsbTmsFinder(omsbTmsFinder);
	}

	/**
	 * Creates a new omsb tms finder with the primary key. Does not add the omsb tms finder to the database.
	 *
	 * @param omsbTmsFinderId the primary key for the new omsb tms finder
	 * @return the new omsb tms finder
	 */
	public static OmsbTmsFinder createOmsbTmsFinder(long omsbTmsFinderId) {
		return getService().createOmsbTmsFinder(omsbTmsFinderId);
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
	 * Deletes the omsb tms finder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OmsbTmsFinderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder that was removed
	 * @throws PortalException if a omsb tms finder with the primary key could not be found
	 */
	public static OmsbTmsFinder deleteOmsbTmsFinder(long omsbTmsFinderId)
		throws PortalException {

		return getService().deleteOmsbTmsFinder(omsbTmsFinderId);
	}

	/**
	 * Deletes the omsb tms finder from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OmsbTmsFinderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param omsbTmsFinder the omsb tms finder
	 * @return the omsb tms finder that was removed
	 */
	public static OmsbTmsFinder deleteOmsbTmsFinder(
		OmsbTmsFinder omsbTmsFinder) {

		return getService().deleteOmsbTmsFinder(omsbTmsFinder);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.OmsbTmsFinderModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.OmsbTmsFinderModelImpl</code>.
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

	public static OmsbTmsFinder fetchOmsbTmsFinder(long omsbTmsFinderId) {
		return getService().fetchOmsbTmsFinder(omsbTmsFinderId);
	}

	/**
	 * Returns the omsb tms finder matching the UUID and group.
	 *
	 * @param uuid the omsb tms finder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder fetchOmsbTmsFinderByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchOmsbTmsFinderByUuidAndGroupId(uuid, groupId);
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
	 * Returns the omsb tms finder with the primary key.
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder
	 * @throws PortalException if a omsb tms finder with the primary key could not be found
	 */
	public static OmsbTmsFinder getOmsbTmsFinder(long omsbTmsFinderId)
		throws PortalException {

		return getService().getOmsbTmsFinder(omsbTmsFinderId);
	}

	/**
	 * Returns the omsb tms finder matching the UUID and group.
	 *
	 * @param uuid the omsb tms finder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching omsb tms finder
	 * @throws PortalException if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder getOmsbTmsFinderByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getOmsbTmsFinderByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the omsb tms finders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @return the range of omsb tms finders
	 */
	public static List<OmsbTmsFinder> getOmsbTmsFinders(int start, int end) {
		return getService().getOmsbTmsFinders(start, end);
	}

	/**
	 * Returns all the omsb tms finders matching the UUID and company.
	 *
	 * @param uuid the UUID of the omsb tms finders
	 * @param companyId the primary key of the company
	 * @return the matching omsb tms finders, or an empty list if no matches were found
	 */
	public static List<OmsbTmsFinder> getOmsbTmsFindersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getOmsbTmsFindersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of omsb tms finders matching the UUID and company.
	 *
	 * @param uuid the UUID of the omsb tms finders
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching omsb tms finders, or an empty list if no matches were found
	 */
	public static List<OmsbTmsFinder> getOmsbTmsFindersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getService().getOmsbTmsFindersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of omsb tms finders.
	 *
	 * @return the number of omsb tms finders
	 */
	public static int getOmsbTmsFindersCount() {
		return getService().getOmsbTmsFindersCount();
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
	 * Updates the omsb tms finder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OmsbTmsFinderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param omsbTmsFinder the omsb tms finder
	 * @return the omsb tms finder that was updated
	 */
	public static OmsbTmsFinder updateOmsbTmsFinder(
		OmsbTmsFinder omsbTmsFinder) {

		return getService().updateOmsbTmsFinder(omsbTmsFinder);
	}

	public static OmsbTmsFinderLocalService getService() {
		return _service;
	}

	private static volatile OmsbTmsFinderLocalService _service;

}
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

import gov.omsb.tms.model.VisitTypeProgDurationRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for VisitTypeProgDurationRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.VisitTypeProgDurationRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeProgDurationRelLocalService
 * @generated
 */
public class VisitTypeProgDurationRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.VisitTypeProgDurationRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the visit type prog duration rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeProgDurationRel the visit type prog duration rel
	 * @return the visit type prog duration rel that was added
	 */
	public static VisitTypeProgDurationRel addVisitTypeProgDurationRel(
		VisitTypeProgDurationRel visitTypeProgDurationRel) {

		return getService().addVisitTypeProgDurationRel(
			visitTypeProgDurationRel);
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
	 * Creates a new visit type prog duration rel with the primary key. Does not add the visit type prog duration rel to the database.
	 *
	 * @param VisitTypeProgDurationRelId the primary key for the new visit type prog duration rel
	 * @return the new visit type prog duration rel
	 */
	public static VisitTypeProgDurationRel createVisitTypeProgDurationRel(
		long VisitTypeProgDurationRelId) {

		return getService().createVisitTypeProgDurationRel(
			VisitTypeProgDurationRelId);
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
	 * Deletes the visit type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel that was removed
	 * @throws PortalException if a visit type prog duration rel with the primary key could not be found
	 */
	public static VisitTypeProgDurationRel deleteVisitTypeProgDurationRel(
			long VisitTypeProgDurationRelId)
		throws PortalException {

		return getService().deleteVisitTypeProgDurationRel(
			VisitTypeProgDurationRelId);
	}

	/**
	 * Deletes the visit type prog duration rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeProgDurationRel the visit type prog duration rel
	 * @return the visit type prog duration rel that was removed
	 */
	public static VisitTypeProgDurationRel deleteVisitTypeProgDurationRel(
		VisitTypeProgDurationRel visitTypeProgDurationRel) {

		return getService().deleteVisitTypeProgDurationRel(
			visitTypeProgDurationRel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeProgDurationRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeProgDurationRelModelImpl</code>.
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

	public static VisitTypeProgDurationRel fetchVisitTypeProgDurationRel(
		long VisitTypeProgDurationRelId) {

		return getService().fetchVisitTypeProgDurationRel(
			VisitTypeProgDurationRelId);
	}

	/**
	 * Returns the visit type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the visit type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public static VisitTypeProgDurationRel
		fetchVisitTypeProgDurationRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchVisitTypeProgDurationRelByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId) {

		return getService().findByProgramDurationId(programDurationId);
	}

	public static VisitTypeProgDurationRel
		findByProgramDurationIdAndVisitTypeMasterId(
			long programDurationId, long visitTypeMasterId) {

		return getService().findByProgramDurationIdAndVisitTypeMasterId(
			programDurationId, visitTypeMasterId);
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

	public static Map<Long, String> getOtherVisitTypesFromVisitMaster(
		long programDurationId, String type, String languageCode) {

		return getService().getOtherVisitTypesFromVisitMaster(
			programDurationId, type, languageCode);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the visit type prog duration rel with the primary key.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel
	 * @throws PortalException if a visit type prog duration rel with the primary key could not be found
	 */
	public static VisitTypeProgDurationRel getVisitTypeProgDurationRel(
			long VisitTypeProgDurationRelId)
		throws PortalException {

		return getService().getVisitTypeProgDurationRel(
			VisitTypeProgDurationRelId);
	}

	/**
	 * Returns the visit type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the visit type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visit type prog duration rel
	 * @throws PortalException if a matching visit type prog duration rel could not be found
	 */
	public static VisitTypeProgDurationRel
			getVisitTypeProgDurationRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getVisitTypeProgDurationRelByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the visit type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of visit type prog duration rels
	 */
	public static List<VisitTypeProgDurationRel> getVisitTypeProgDurationRels(
		int start, int end) {

		return getService().getVisitTypeProgDurationRels(start, end);
	}

	/**
	 * Returns all the visit type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the visit type prog duration rels
	 * @param companyId the primary key of the company
	 * @return the matching visit type prog duration rels, or an empty list if no matches were found
	 */
	public static List<VisitTypeProgDurationRel>
		getVisitTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getVisitTypeProgDurationRelsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of visit type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the visit type prog duration rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching visit type prog duration rels, or an empty list if no matches were found
	 */
	public static List<VisitTypeProgDurationRel>
		getVisitTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		return getService().getVisitTypeProgDurationRelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of visit type prog duration rels.
	 *
	 * @return the number of visit type prog duration rels
	 */
	public static int getVisitTypeProgDurationRelsCount() {
		return getService().getVisitTypeProgDurationRelsCount();
	}

	/**
	 * Updates the visit type prog duration rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeProgDurationRel the visit type prog duration rel
	 * @return the visit type prog duration rel that was updated
	 */
	public static VisitTypeProgDurationRel updateVisitTypeProgDurationRel(
		VisitTypeProgDurationRel visitTypeProgDurationRel) {

		return getService().updateVisitTypeProgDurationRel(
			visitTypeProgDurationRel);
	}

	public static VisitTypeProgDurationRelLocalService getService() {
		return _service;
	}

	private static volatile VisitTypeProgDurationRelLocalService _service;

}
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

import gov.omsb.tms.model.ProgramWorkflowDetailsRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgramWorkflowDetailsRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgramWorkflowDetailsRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramWorkflowDetailsRelLocalService
 * @generated
 */
public class ProgramWorkflowDetailsRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgramWorkflowDetailsRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the program workflow details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was added
	 */
	public static ProgramWorkflowDetailsRel addProgramWorkflowDetailsRel(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		return getService().addProgramWorkflowDetailsRel(
			programWorkflowDetailsRel);
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
	 * Creates a new program workflow details rel with the primary key. Does not add the program workflow details rel to the database.
	 *
	 * @param programWorkflowDetailsRelId the primary key for the new program workflow details rel
	 * @return the new program workflow details rel
	 */
	public static ProgramWorkflowDetailsRel createProgramWorkflowDetailsRel(
		long programWorkflowDetailsRelId) {

		return getService().createProgramWorkflowDetailsRel(
			programWorkflowDetailsRelId);
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
	 * Deletes the program workflow details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel that was removed
	 * @throws PortalException if a program workflow details rel with the primary key could not be found
	 */
	public static ProgramWorkflowDetailsRel deleteProgramWorkflowDetailsRel(
			long programWorkflowDetailsRelId)
		throws PortalException {

		return getService().deleteProgramWorkflowDetailsRel(
			programWorkflowDetailsRelId);
	}

	/**
	 * Deletes the program workflow details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was removed
	 */
	public static ProgramWorkflowDetailsRel deleteProgramWorkflowDetailsRel(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		return getService().deleteProgramWorkflowDetailsRel(
			programWorkflowDetailsRel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
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

	public static ProgramWorkflowDetailsRel fetchProgramWorkflowDetailsRel(
		long programWorkflowDetailsRelId) {

		return getService().fetchProgramWorkflowDetailsRel(
			programWorkflowDetailsRelId);
	}

	/**
	 * Returns the program workflow details rel matching the UUID and group.
	 *
	 * @param uuid the program workflow details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel
		fetchProgramWorkflowDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchProgramWorkflowDetailsRelByUuidAndGroupId(
			uuid, groupId);
	}

	public static ProgramWorkflowDetailsRel findByProgramId(long programId) {
		return getService().findByProgramId(programId);
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
	 * Returns the program workflow details rel with the primary key.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel
	 * @throws PortalException if a program workflow details rel with the primary key could not be found
	 */
	public static ProgramWorkflowDetailsRel getProgramWorkflowDetailsRel(
			long programWorkflowDetailsRelId)
		throws PortalException {

		return getService().getProgramWorkflowDetailsRel(
			programWorkflowDetailsRelId);
	}

	/**
	 * Returns the program workflow details rel matching the UUID and group.
	 *
	 * @param uuid the program workflow details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program workflow details rel
	 * @throws PortalException if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel
			getProgramWorkflowDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getProgramWorkflowDetailsRelByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> getProgramWorkflowDetailsRels(
		int start, int end) {

		return getService().getProgramWorkflowDetailsRels(start, end);
	}

	/**
	 * Returns all the program workflow details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program workflow details rels
	 * @param companyId the primary key of the company
	 * @return the matching program workflow details rels, or an empty list if no matches were found
	 */
	public static List<ProgramWorkflowDetailsRel>
		getProgramWorkflowDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getProgramWorkflowDetailsRelsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of program workflow details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program workflow details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program workflow details rels, or an empty list if no matches were found
	 */
	public static List<ProgramWorkflowDetailsRel>
		getProgramWorkflowDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getService().getProgramWorkflowDetailsRelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program workflow details rels.
	 *
	 * @return the number of program workflow details rels
	 */
	public static int getProgramWorkflowDetailsRelsCount() {
		return getService().getProgramWorkflowDetailsRelsCount();
	}

	/**
	 * Updates the program workflow details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was updated
	 */
	public static ProgramWorkflowDetailsRel updateProgramWorkflowDetailsRel(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		return getService().updateProgramWorkflowDetailsRel(
			programWorkflowDetailsRel);
	}

	public static ProgramWorkflowDetailsRelLocalService getService() {
		return _service;
	}

	private static volatile ProgramWorkflowDetailsRelLocalService _service;

}
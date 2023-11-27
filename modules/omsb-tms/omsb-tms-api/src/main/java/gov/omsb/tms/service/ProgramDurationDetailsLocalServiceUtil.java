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

import gov.omsb.tms.model.ProgramDurationDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgramDurationDetails. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgramDurationDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDurationDetailsLocalService
 * @generated
 */
public class ProgramDurationDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgramDurationDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the program duration details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDurationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDurationDetails the program duration details
	 * @return the program duration details that was added
	 */
	public static ProgramDurationDetails addProgramDurationDetails(
		ProgramDurationDetails programDurationDetails) {

		return getService().addProgramDurationDetails(programDurationDetails);
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
	 * Creates a new program duration details with the primary key. Does not add the program duration details to the database.
	 *
	 * @param progDurationId the primary key for the new program duration details
	 * @return the new program duration details
	 */
	public static ProgramDurationDetails createProgramDurationDetails(
		long progDurationId) {

		return getService().createProgramDurationDetails(progDurationId);
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
	 * Deletes the program duration details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDurationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details that was removed
	 * @throws PortalException if a program duration details with the primary key could not be found
	 */
	public static ProgramDurationDetails deleteProgramDurationDetails(
			long progDurationId)
		throws PortalException {

		return getService().deleteProgramDurationDetails(progDurationId);
	}

	/**
	 * Deletes the program duration details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDurationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDurationDetails the program duration details
	 * @return the program duration details that was removed
	 */
	public static ProgramDurationDetails deleteProgramDurationDetails(
		ProgramDurationDetails programDurationDetails) {

		return getService().deleteProgramDurationDetails(
			programDurationDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDurationDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDurationDetailsModelImpl</code>.
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

	public static ProgramDurationDetails fetchProgramDurationDetails(
		long progDurationId) {

		return getService().fetchProgramDurationDetails(progDurationId);
	}

	/**
	 * Returns the program duration details matching the UUID and group.
	 *
	 * @param uuid the program duration details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails
		fetchProgramDurationDetailsByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProgramDurationDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	public static ProgramDurationDetails findByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm) {

		return getService().findByProgramIdAndAYApplicableFrom(
			programId, ayApplicableForm);
	}

	public static List<ProgramDurationDetails> findProgramDurationByProgramId(
		long programId) {

		return getService().findProgramDurationByProgramId(programId);
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

	public static List<gov.omsb.tms.custom.dto.ProgramCohortDTO>
		getProgramAndCohortsFromProgramDuration(
			List<Long> programIds, List<String> yearRange,
			String languageCode) {

		return getService().getProgramAndCohortsFromProgramDuration(
			programIds, yearRange, languageCode);
	}

	/**
	 * Returns the program duration details with the primary key.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details
	 * @throws PortalException if a program duration details with the primary key could not be found
	 */
	public static ProgramDurationDetails getProgramDurationDetails(
			long progDurationId)
		throws PortalException {

		return getService().getProgramDurationDetails(progDurationId);
	}

	/**
	 * Returns the program duration details matching the UUID and group.
	 *
	 * @param uuid the program duration details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duration details
	 * @throws PortalException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails
			getProgramDurationDetailsByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getProgramDurationDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of program duration detailses
	 */
	public static List<ProgramDurationDetails> getProgramDurationDetailses(
		int start, int end) {

		return getService().getProgramDurationDetailses(start, end);
	}

	/**
	 * Returns all the program duration detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duration detailses
	 * @param companyId the primary key of the company
	 * @return the matching program duration detailses, or an empty list if no matches were found
	 */
	public static List<ProgramDurationDetails>
		getProgramDurationDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getProgramDurationDetailsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of program duration detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duration detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program duration detailses, or an empty list if no matches were found
	 */
	public static List<ProgramDurationDetails>
		getProgramDurationDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getService().getProgramDurationDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program duration detailses.
	 *
	 * @return the number of program duration detailses
	 */
	public static int getProgramDurationDetailsesCount() {
		return getService().getProgramDurationDetailsesCount();
	}

	public static List<Long> getProgramDurationIdFromProgramIds(
		List<Long> programIds) {

		return getService().getProgramDurationIdFromProgramIds(programIds);
	}

	/**
	 * Updates the program duration details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDurationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDurationDetails the program duration details
	 * @return the program duration details that was updated
	 */
	public static ProgramDurationDetails updateProgramDurationDetails(
		ProgramDurationDetails programDurationDetails) {

		return getService().updateProgramDurationDetails(
			programDurationDetails);
	}

	public static ProgramDurationDetailsLocalService getService() {
		return _service;
	}

	private static volatile ProgramDurationDetailsLocalService _service;

}
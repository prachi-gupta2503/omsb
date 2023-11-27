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

import gov.omsb.tms.model.ProgramTypeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for ProgramTypeMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgramTypeMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramTypeMasterLocalService
 * @generated
 */
public class ProgramTypeMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgramTypeMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addLocalizedValue(
		Map<java.util.Locale, String> localizationMap, List<String> values,
		String languageCode) {

		getService().addLocalizedValue(localizationMap, values, languageCode);
	}

	/**
	 * Adds the program type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programTypeMaster the program type master
	 * @return the program type master that was added
	 */
	public static ProgramTypeMaster addProgramTypeMaster(
		ProgramTypeMaster programTypeMaster) {

		return getService().addProgramTypeMaster(programTypeMaster);
	}

	public static boolean checkprogramTypeNames(
		List<String> programTypeNames,
		javax.portlet.ActionRequest actionRequest,
		ProgramTypeMaster programTypeMaster) {

		return getService().checkprogramTypeNames(
			programTypeNames, actionRequest, programTypeMaster);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static boolean createProgramTypeMaster(
		javax.portlet.ActionRequest actionRequest,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return getService().createProgramTypeMaster(
			actionRequest, themeDisplay);
	}

	/**
	 * Creates a new program type master with the primary key. Does not add the program type master to the database.
	 *
	 * @param programTypeMasterId the primary key for the new program type master
	 * @return the new program type master
	 */
	public static ProgramTypeMaster createProgramTypeMaster(
		long programTypeMasterId) {

		return getService().createProgramTypeMaster(programTypeMasterId);
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
	 * Deletes the program type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master that was removed
	 * @throws PortalException if a program type master with the primary key could not be found
	 */
	public static ProgramTypeMaster deleteProgramTypeMaster(
			long programTypeMasterId)
		throws PortalException {

		return getService().deleteProgramTypeMaster(programTypeMasterId);
	}

	/**
	 * Deletes the program type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programTypeMaster the program type master
	 * @return the program type master that was removed
	 */
	public static ProgramTypeMaster deleteProgramTypeMaster(
		ProgramTypeMaster programTypeMaster) {

		return getService().deleteProgramTypeMaster(programTypeMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramTypeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramTypeMasterModelImpl</code>.
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

	public static ProgramTypeMaster fetchProgramTypeMaster(
		long programTypeMasterId) {

		return getService().fetchProgramTypeMaster(programTypeMasterId);
	}

	/**
	 * Returns the program type master matching the UUID and group.
	 *
	 * @param uuid the program type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchProgramTypeMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProgramTypeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName) {

		return getService().findByProgramTypeNameByLike(programTypeName);
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
	 * Returns the program type master with the primary key.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master
	 * @throws PortalException if a program type master with the primary key could not be found
	 */
	public static ProgramTypeMaster getProgramTypeMaster(
			long programTypeMasterId)
		throws PortalException {

		return getService().getProgramTypeMaster(programTypeMasterId);
	}

	/**
	 * Returns the program type master matching the UUID and group.
	 *
	 * @param uuid the program type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program type master
	 * @throws PortalException if a matching program type master could not be found
	 */
	public static ProgramTypeMaster getProgramTypeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProgramTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of program type masters
	 */
	public static List<ProgramTypeMaster> getProgramTypeMasters(
		int start, int end) {

		return getService().getProgramTypeMasters(start, end);
	}

	/**
	 * Returns all the program type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the program type masters
	 * @param companyId the primary key of the company
	 * @return the matching program type masters, or an empty list if no matches were found
	 */
	public static List<ProgramTypeMaster>
		getProgramTypeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getProgramTypeMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of program type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the program type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program type masters, or an empty list if no matches were found
	 */
	public static List<ProgramTypeMaster>
		getProgramTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getService().getProgramTypeMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program type masters.
	 *
	 * @return the number of program type masters
	 */
	public static int getProgramTypeMastersCount() {
		return getService().getProgramTypeMastersCount();
	}

	public static boolean updateProgramTypeMaster(
			javax.portlet.ActionRequest actionRequest, long programTypeMasterId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws PortalException {

		return getService().updateProgramTypeMaster(
			actionRequest, programTypeMasterId, themeDisplay);
	}

	/**
	 * Updates the program type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programTypeMaster the program type master
	 * @return the program type master that was updated
	 */
	public static ProgramTypeMaster updateProgramTypeMaster(
		ProgramTypeMaster programTypeMaster) {

		return getService().updateProgramTypeMaster(programTypeMaster);
	}

	public static boolean validateProgramType(
		javax.portlet.ActionRequest actionRequest,
		ProgramTypeMaster programTypeMaster) {

		return getService().validateProgramType(
			actionRequest, programTypeMaster);
	}

	public static ProgramTypeMasterLocalService getService() {
		return _service;
	}

	private static volatile ProgramTypeMasterLocalService _service;

}
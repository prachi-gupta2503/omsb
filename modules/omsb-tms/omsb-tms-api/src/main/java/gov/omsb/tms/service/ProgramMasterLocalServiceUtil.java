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

import gov.omsb.tms.model.ProgramMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgramMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgramMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramMasterLocalService
 * @generated
 */
public class ProgramMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgramMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the program master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programMaster the program master
	 * @return the program master that was added
	 */
	public static ProgramMaster addProgramMaster(ProgramMaster programMaster) {
		return getService().addProgramMaster(programMaster);
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
	 * Creates a new program master with the primary key. Does not add the program master to the database.
	 *
	 * @param programMasterId the primary key for the new program master
	 * @return the new program master
	 */
	public static ProgramMaster createProgramMaster(long programMasterId) {
		return getService().createProgramMaster(programMasterId);
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
	 * Deletes the program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master that was removed
	 * @throws PortalException if a program master with the primary key could not be found
	 */
	public static ProgramMaster deleteProgramMaster(long programMasterId)
		throws PortalException {

		return getService().deleteProgramMaster(programMasterId);
	}

	/**
	 * Deletes the program master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programMaster the program master
	 * @return the program master that was removed
	 */
	public static ProgramMaster deleteProgramMaster(
		ProgramMaster programMaster) {

		return getService().deleteProgramMaster(programMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramMasterModelImpl</code>.
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

	public static ProgramMaster fetchProgramMaster(long programMasterId) {
		return getService().fetchProgramMaster(programMasterId);
	}

	/**
	 * Returns the program master matching the UUID and group.
	 *
	 * @param uuid the program master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchProgramMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProgramMasterByUuidAndGroupId(uuid, groupId);
	}

	public static List<ProgramMaster> findByProgramCodeByLike(
		String programCode) {

		return getService().findByProgramCodeByLike(programCode);
	}

	public static List<ProgramMaster> findByProgramMasterId(
		List<Long> programIds) {

		return getService().findByProgramMasterId(programIds);
	}

	public static List<ProgramMaster> findByProgramNameByLike(
		String programName) {

		return getService().findByProgramNameByLike(programName);
	}

	public static List<ProgramMaster> findByProgramStatus(
		Boolean programStatus) {

		return getService().findByProgramStatus(programStatus);
	}

	public static List<ProgramMaster> findProgramByPorgramType(
		long programTypeId) {

		return getService().findProgramByPorgramType(programTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<gov.omsb.tms.custom.dto.ProgramDTO> getAllProgramList(
		String languageCode) {

		return getService().getAllProgramList(languageCode);
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

	public static gov.omsb.tms.custom.dto.ProgramDTO getProgramDetails(
		long programId, String languageCode) {

		return getService().getProgramDetails(programId, languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.ProgramDTO>
		getProgramDTOListByIds(List<Long> ids, String languageCode) {

		return getService().getProgramDTOListByIds(ids, languageCode);
	}

	public static List<ProgramMaster> getProgramListByIds(List<Long> ids) {
		return getService().getProgramListByIds(ids);
	}

	public static List<ProgramMaster> getProgramListByIdsAndStatus(
		List<Long> ids, Boolean status) {

		return getService().getProgramListByIdsAndStatus(ids, status);
	}

	/**
	 * Returns the program master with the primary key.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master
	 * @throws PortalException if a program master with the primary key could not be found
	 */
	public static ProgramMaster getProgramMaster(long programMasterId)
		throws PortalException {

		return getService().getProgramMaster(programMasterId);
	}

	/**
	 * Returns the program master matching the UUID and group.
	 *
	 * @param uuid the program master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program master
	 * @throws PortalException if a matching program master could not be found
	 */
	public static ProgramMaster getProgramMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProgramMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of program masters
	 */
	public static List<ProgramMaster> getProgramMasters(int start, int end) {
		return getService().getProgramMasters(start, end);
	}

	/**
	 * Returns all the program masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the program masters
	 * @param companyId the primary key of the company
	 * @return the matching program masters, or an empty list if no matches were found
	 */
	public static List<ProgramMaster> getProgramMastersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProgramMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of program masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the program masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program masters, or an empty list if no matches were found
	 */
	public static List<ProgramMaster> getProgramMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getService().getProgramMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program masters.
	 *
	 * @return the number of program masters
	 */
	public static int getProgramMastersCount() {
		return getService().getProgramMastersCount();
	}

	public static List<gov.omsb.tms.custom.dto.ProgramStructureDTO>
		getProgramStructure(long programDurationId, String languageCode) {

		return getService().getProgramStructure(
			programDurationId, languageCode);
	}

	/**
	 * Updates the program master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programMaster the program master
	 * @return the program master that was updated
	 */
	public static ProgramMaster updateProgramMaster(
		ProgramMaster programMaster) {

		return getService().updateProgramMaster(programMaster);
	}

	public static ProgramMasterLocalService getService() {
		return _service;
	}

	private static volatile ProgramMasterLocalService _service;

}
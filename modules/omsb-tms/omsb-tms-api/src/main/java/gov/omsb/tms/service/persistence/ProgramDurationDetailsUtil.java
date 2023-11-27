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

package gov.omsb.tms.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.ProgramDurationDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the program duration details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgramDurationDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDurationDetailsPersistence
 * @generated
 */
public class ProgramDurationDetailsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		ProgramDurationDetails programDurationDetails) {

		getPersistence().clearCache(programDurationDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProgramDurationDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgramDurationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgramDurationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgramDurationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgramDurationDetails update(
		ProgramDurationDetails programDurationDetails) {

		return getPersistence().update(programDurationDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgramDurationDetails update(
		ProgramDurationDetails programDurationDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(programDurationDetails, serviceContext);
	}

	/**
	 * Returns all the program duration detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails findByUuid_First(
			String uuid,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public static ProgramDurationDetails[] findByUuid_PrevAndNext(
			long progDurationId, String uuid,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			progDurationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the program duration detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of program duration detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duration detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the program duration details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duration details that was removed
	 */
	public static ProgramDurationDetails removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of program duration detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duration detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public static ProgramDurationDetails[] findByUuid_C_PrevAndNext(
			long progDurationId, String uuid, long companyId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			progDurationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the program duration detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duration detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the program duration detailses where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByProgramId(long programId) {
		return getPersistence().findByProgramId(programId);
	}

	/**
	 * Returns a range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end) {

		return getPersistence().findByProgramId(programId, start, end);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().findByProgramId(
			programId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	public static List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramId(
			programId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails findByProgramId_First(
			long programId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByProgramId_First(
			programId, orderByComparator);
	}

	/**
	 * Returns the first program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByProgramId_First(
		long programId,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().fetchByProgramId_First(
			programId, orderByComparator);
	}

	/**
	 * Returns the last program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails findByProgramId_Last(
			long programId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByProgramId_Last(
			programId, orderByComparator);
	}

	/**
	 * Returns the last program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByProgramId_Last(
		long programId,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().fetchByProgramId_Last(
			programId, orderByComparator);
	}

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where programId = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public static ProgramDurationDetails[] findByProgramId_PrevAndNext(
			long progDurationId, long programId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByProgramId_PrevAndNext(
			progDurationId, programId, orderByComparator);
	}

	/**
	 * Removes all the program duration detailses where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 */
	public static void removeByProgramId(long programId) {
		getPersistence().removeByProgramId(programId);
	}

	/**
	 * Returns the number of program duration detailses where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program duration detailses
	 */
	public static int countByProgramId(long programId) {
		return getPersistence().countByProgramId(programId);
	}

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails findByProgramIdAndAYApplicableFrom(
			long programId, String ayApplicableForm)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByProgramIdAndAYApplicableFrom(
			programId, ayApplicableForm);
	}

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm) {

		return getPersistence().fetchByProgramIdAndAYApplicableFrom(
			programId, ayApplicableForm);
	}

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public static ProgramDurationDetails fetchByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm, boolean useFinderCache) {

		return getPersistence().fetchByProgramIdAndAYApplicableFrom(
			programId, ayApplicableForm, useFinderCache);
	}

	/**
	 * Removes the program duration details where programId = &#63; and ayApplicableForm = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the program duration details that was removed
	 */
	public static ProgramDurationDetails removeByProgramIdAndAYApplicableFrom(
			long programId, String ayApplicableForm)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().removeByProgramIdAndAYApplicableFrom(
			programId, ayApplicableForm);
	}

	/**
	 * Returns the number of program duration detailses where programId = &#63; and ayApplicableForm = &#63;.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the number of matching program duration detailses
	 */
	public static int countByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm) {

		return getPersistence().countByProgramIdAndAYApplicableFrom(
			programId, ayApplicableForm);
	}

	/**
	 * Caches the program duration details in the entity cache if it is enabled.
	 *
	 * @param programDurationDetails the program duration details
	 */
	public static void cacheResult(
		ProgramDurationDetails programDurationDetails) {

		getPersistence().cacheResult(programDurationDetails);
	}

	/**
	 * Caches the program duration detailses in the entity cache if it is enabled.
	 *
	 * @param programDurationDetailses the program duration detailses
	 */
	public static void cacheResult(
		List<ProgramDurationDetails> programDurationDetailses) {

		getPersistence().cacheResult(programDurationDetailses);
	}

	/**
	 * Creates a new program duration details with the primary key. Does not add the program duration details to the database.
	 *
	 * @param progDurationId the primary key for the new program duration details
	 * @return the new program duration details
	 */
	public static ProgramDurationDetails create(long progDurationId) {
		return getPersistence().create(progDurationId);
	}

	/**
	 * Removes the program duration details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details that was removed
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public static ProgramDurationDetails remove(long progDurationId)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().remove(progDurationId);
	}

	public static ProgramDurationDetails updateImpl(
		ProgramDurationDetails programDurationDetails) {

		return getPersistence().updateImpl(programDurationDetails);
	}

	/**
	 * Returns the program duration details with the primary key or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public static ProgramDurationDetails findByPrimaryKey(long progDurationId)
		throws gov.omsb.tms.exception.NoSuchProgramDurationDetailsException {

		return getPersistence().findByPrimaryKey(progDurationId);
	}

	/**
	 * Returns the program duration details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details, or <code>null</code> if a program duration details with the primary key could not be found
	 */
	public static ProgramDurationDetails fetchByPrimaryKey(
		long progDurationId) {

		return getPersistence().fetchByPrimaryKey(progDurationId);
	}

	/**
	 * Returns all the program duration detailses.
	 *
	 * @return the program duration detailses
	 */
	public static List<ProgramDurationDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of program duration detailses
	 */
	public static List<ProgramDurationDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program duration detailses
	 */
	public static List<ProgramDurationDetails> findAll(
		int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program duration detailses
	 */
	public static List<ProgramDurationDetails> findAll(
		int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the program duration detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of program duration detailses.
	 *
	 * @return the number of program duration detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgramDurationDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgramDurationDetailsPersistence _persistence;

}
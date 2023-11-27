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

import gov.omsb.tms.model.ProgramMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the program master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgramMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramMasterPersistence
 * @generated
 */
public class ProgramMasterUtil {

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
	public static void clearCache(ProgramMaster programMaster) {
		getPersistence().clearCache(programMaster);
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
	public static Map<Serializable, ProgramMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgramMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgramMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgramMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgramMaster update(ProgramMaster programMaster) {
		return getPersistence().update(programMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgramMaster update(
		ProgramMaster programMaster, ServiceContext serviceContext) {

		return getPersistence().update(programMaster, serviceContext);
	}

	/**
	 * Returns all the program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program masters
	 */
	public static List<ProgramMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public static List<ProgramMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByUuid_First(
			String uuid, OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByUuid_First(
		String uuid, OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByUuid_Last(
			String uuid, OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByUuid_Last(
		String uuid, OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where uuid = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public static ProgramMaster[] findByUuid_PrevAndNext(
			long programMasterId, String uuid,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			programMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the program masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the program master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program master that was removed
	 */
	public static ProgramMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of program masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program masters
	 */
	public static List<ProgramMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public static List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public static ProgramMaster[] findByUuid_C_PrevAndNext(
			long programMasterId, String uuid, long companyId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			programMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the program masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the program masters where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @return the matching program masters
	 */
	public static List<ProgramMaster> findByProgramStatus(
		Boolean programStatus) {

		return getPersistence().findByProgramStatus(programStatus);
	}

	/**
	 * Returns a range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end) {

		return getPersistence().findByProgramStatus(programStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().findByProgramStatus(
			programStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramStatus(
			programStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByProgramStatus_First(
			Boolean programStatus,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramStatus_First(
			programStatus, orderByComparator);
	}

	/**
	 * Returns the first program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByProgramStatus_First(
		Boolean programStatus,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByProgramStatus_First(
			programStatus, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByProgramStatus_Last(
			Boolean programStatus,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramStatus_Last(
			programStatus, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByProgramStatus_Last(
		Boolean programStatus,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByProgramStatus_Last(
			programStatus, orderByComparator);
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public static ProgramMaster[] findByProgramStatus_PrevAndNext(
			long programMasterId, Boolean programStatus,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramStatus_PrevAndNext(
			programMasterId, programStatus, orderByComparator);
	}

	/**
	 * Removes all the program masters where programStatus = &#63; from the database.
	 *
	 * @param programStatus the program status
	 */
	public static void removeByProgramStatus(Boolean programStatus) {
		getPersistence().removeByProgramStatus(programStatus);
	}

	/**
	 * Returns the number of program masters where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @return the number of matching program masters
	 */
	public static int countByProgramStatus(Boolean programStatus) {
		return getPersistence().countByProgramStatus(programStatus);
	}

	/**
	 * Returns all the program masters where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @return the matching program masters
	 */
	public static List<ProgramMaster> findByProgramNameByLike(
		String programName) {

		return getPersistence().findByProgramNameByLike(programName);
	}

	/**
	 * Returns a range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end) {

		return getPersistence().findByProgramNameByLike(
			programName, start, end);
	}

	/**
	 * Returns an ordered range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().findByProgramNameByLike(
			programName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramNameByLike(
			programName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByProgramNameByLike_First(
			String programName,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramNameByLike_First(
			programName, orderByComparator);
	}

	/**
	 * Returns the first program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByProgramNameByLike_First(
		String programName,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByProgramNameByLike_First(
			programName, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByProgramNameByLike_Last(
			String programName,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramNameByLike_Last(
			programName, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByProgramNameByLike_Last(
		String programName,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByProgramNameByLike_Last(
			programName, orderByComparator);
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public static ProgramMaster[] findByProgramNameByLike_PrevAndNext(
			long programMasterId, String programName,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramNameByLike_PrevAndNext(
			programMasterId, programName, orderByComparator);
	}

	/**
	 * Removes all the program masters where programName LIKE &#63; from the database.
	 *
	 * @param programName the program name
	 */
	public static void removeByProgramNameByLike(String programName) {
		getPersistence().removeByProgramNameByLike(programName);
	}

	/**
	 * Returns the number of program masters where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @return the number of matching program masters
	 */
	public static int countByProgramNameByLike(String programName) {
		return getPersistence().countByProgramNameByLike(programName);
	}

	/**
	 * Returns all the program masters where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @return the matching program masters
	 */
	public static List<ProgramMaster> findByProgramCodeByLike(
		String programCode) {

		return getPersistence().findByProgramCodeByLike(programCode);
	}

	/**
	 * Returns a range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end) {

		return getPersistence().findByProgramCodeByLike(
			programCode, start, end);
	}

	/**
	 * Returns an ordered range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().findByProgramCodeByLike(
			programCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramCodeByLike(
			programCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByProgramCodeByLike_First(
			String programCode,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramCodeByLike_First(
			programCode, orderByComparator);
	}

	/**
	 * Returns the first program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByProgramCodeByLike_First(
		String programCode,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByProgramCodeByLike_First(
			programCode, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByProgramCodeByLike_Last(
			String programCode,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramCodeByLike_Last(
			programCode, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByProgramCodeByLike_Last(
		String programCode,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByProgramCodeByLike_Last(
			programCode, orderByComparator);
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public static ProgramMaster[] findByProgramCodeByLike_PrevAndNext(
			long programMasterId, String programCode,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByProgramCodeByLike_PrevAndNext(
			programMasterId, programCode, orderByComparator);
	}

	/**
	 * Removes all the program masters where programCode LIKE &#63; from the database.
	 *
	 * @param programCode the program code
	 */
	public static void removeByProgramCodeByLike(String programCode) {
		getPersistence().removeByProgramCodeByLike(programCode);
	}

	/**
	 * Returns the number of program masters where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @return the number of matching program masters
	 */
	public static int countByProgramCodeByLike(String programCode) {
		return getPersistence().countByProgramCodeByLike(programCode);
	}

	/**
	 * Returns all the program masters where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the matching program masters
	 */
	public static List<ProgramMaster> findByprogramTypeId(long programTypeId) {
		return getPersistence().findByprogramTypeId(programTypeId);
	}

	/**
	 * Returns a range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public static List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end) {

		return getPersistence().findByprogramTypeId(programTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().findByprogramTypeId(
			programTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public static List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByprogramTypeId(
			programTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByprogramTypeId_First(
			long programTypeId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByprogramTypeId_First(
			programTypeId, orderByComparator);
	}

	/**
	 * Returns the first program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByprogramTypeId_First(
		long programTypeId,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByprogramTypeId_First(
			programTypeId, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public static ProgramMaster findByprogramTypeId_Last(
			long programTypeId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByprogramTypeId_Last(
			programTypeId, orderByComparator);
	}

	/**
	 * Returns the last program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public static ProgramMaster fetchByprogramTypeId_Last(
		long programTypeId,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().fetchByprogramTypeId_Last(
			programTypeId, orderByComparator);
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public static ProgramMaster[] findByprogramTypeId_PrevAndNext(
			long programMasterId, long programTypeId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByprogramTypeId_PrevAndNext(
			programMasterId, programTypeId, orderByComparator);
	}

	/**
	 * Removes all the program masters where programTypeId = &#63; from the database.
	 *
	 * @param programTypeId the program type ID
	 */
	public static void removeByprogramTypeId(long programTypeId) {
		getPersistence().removeByprogramTypeId(programTypeId);
	}

	/**
	 * Returns the number of program masters where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the number of matching program masters
	 */
	public static int countByprogramTypeId(long programTypeId) {
		return getPersistence().countByprogramTypeId(programTypeId);
	}

	/**
	 * Caches the program master in the entity cache if it is enabled.
	 *
	 * @param programMaster the program master
	 */
	public static void cacheResult(ProgramMaster programMaster) {
		getPersistence().cacheResult(programMaster);
	}

	/**
	 * Caches the program masters in the entity cache if it is enabled.
	 *
	 * @param programMasters the program masters
	 */
	public static void cacheResult(List<ProgramMaster> programMasters) {
		getPersistence().cacheResult(programMasters);
	}

	/**
	 * Creates a new program master with the primary key. Does not add the program master to the database.
	 *
	 * @param programMasterId the primary key for the new program master
	 * @return the new program master
	 */
	public static ProgramMaster create(long programMasterId) {
		return getPersistence().create(programMasterId);
	}

	/**
	 * Removes the program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master that was removed
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public static ProgramMaster remove(long programMasterId)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().remove(programMasterId);
	}

	public static ProgramMaster updateImpl(ProgramMaster programMaster) {
		return getPersistence().updateImpl(programMaster);
	}

	/**
	 * Returns the program master with the primary key or throws a <code>NoSuchProgramMasterException</code> if it could not be found.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public static ProgramMaster findByPrimaryKey(long programMasterId)
		throws gov.omsb.tms.exception.NoSuchProgramMasterException {

		return getPersistence().findByPrimaryKey(programMasterId);
	}

	/**
	 * Returns the program master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master, or <code>null</code> if a program master with the primary key could not be found
	 */
	public static ProgramMaster fetchByPrimaryKey(long programMasterId) {
		return getPersistence().fetchByPrimaryKey(programMasterId);
	}

	/**
	 * Returns all the program masters.
	 *
	 * @return the program masters
	 */
	public static List<ProgramMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of program masters
	 */
	public static List<ProgramMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program masters
	 */
	public static List<ProgramMaster> findAll(
		int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program masters
	 */
	public static List<ProgramMaster> findAll(
		int start, int end, OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the program masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of program masters.
	 *
	 * @return the number of program masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgramMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgramMasterPersistence _persistence;

}
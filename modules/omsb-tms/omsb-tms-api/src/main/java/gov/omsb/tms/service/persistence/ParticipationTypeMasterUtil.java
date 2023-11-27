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

import gov.omsb.tms.model.ParticipationTypeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the participation type master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ParticipationTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ParticipationTypeMasterPersistence
 * @generated
 */
public class ParticipationTypeMasterUtil {

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
		ParticipationTypeMaster participationTypeMaster) {

		getPersistence().clearCache(participationTypeMaster);
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
	public static Map<Serializable, ParticipationTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ParticipationTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ParticipationTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ParticipationTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ParticipationTypeMaster update(
		ParticipationTypeMaster participationTypeMaster) {

		return getPersistence().update(participationTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ParticipationTypeMaster update(
		ParticipationTypeMaster participationTypeMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(participationTypeMaster, serviceContext);
	}

	/**
	 * Returns all the participation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the participation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the participation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the participation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster findByUuid_First(
			String uuid,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster fetchByUuid_First(
		String uuid,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster findByUuid_Last(
			String uuid,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster fetchByUuid_Last(
		String uuid,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster[] findByUuid_PrevAndNext(
			long participationTypeMasterId, String uuid,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			participationTypeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the participation type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of participation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching participation type masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchParticipationTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the participation type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the participation type master that was removed
	 */
	public static ParticipationTypeMaster removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of participation type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching participation type masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster[] findByUuid_C_PrevAndNext(
			long participationTypeMasterId, String uuid, long companyId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			participationTypeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the participation type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching participation type masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the participation type masters where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the participation type masters where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the participation type masters where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the participation type masters where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster[] findByProgramDurationId_PrevAndNext(
			long participationTypeMasterId, long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			participationTypeMasterId, programDurationId, orderByComparator);
	}

	/**
	 * Removes all the participation type masters where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of participation type masters where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching participation type masters
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @return the matching participation type masters
	 */
	public static List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId) {

		return getPersistence().
			findByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId);
	}

	/**
	 * Returns a range of all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end) {

		return getPersistence().
			findByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end,
			OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().
			findByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId, start, end,
				orderByComparator);
	}

	/**
	 * Returns an ordered range of all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching participation type masters
	 */
	public static List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end,
			OrderByComparator<ParticipationTypeMaster> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId, start, end,
				orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster
			findByParticipationTypeNameByLikeAndProgramDurationId_First(
				String participationTypeName, long programDurationId,
				OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().
			findByParticipationTypeNameByLikeAndProgramDurationId_First(
				participationTypeName, programDurationId, orderByComparator);
	}

	/**
	 * Returns the first participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster
		fetchByParticipationTypeNameByLikeAndProgramDurationId_First(
			String participationTypeName, long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().
			fetchByParticipationTypeNameByLikeAndProgramDurationId_First(
				participationTypeName, programDurationId, orderByComparator);
	}

	/**
	 * Returns the last participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster
			findByParticipationTypeNameByLikeAndProgramDurationId_Last(
				String participationTypeName, long programDurationId,
				OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().
			findByParticipationTypeNameByLikeAndProgramDurationId_Last(
				participationTypeName, programDurationId, orderByComparator);
	}

	/**
	 * Returns the last participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public static ParticipationTypeMaster
		fetchByParticipationTypeNameByLikeAndProgramDurationId_Last(
			String participationTypeName, long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().
			fetchByParticipationTypeNameByLikeAndProgramDurationId_Last(
				participationTypeName, programDurationId, orderByComparator);
	}

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster[]
			findByParticipationTypeNameByLikeAndProgramDurationId_PrevAndNext(
				long participationTypeMasterId, String participationTypeName,
				long programDurationId,
				OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().
			findByParticipationTypeNameByLikeAndProgramDurationId_PrevAndNext(
				participationTypeMasterId, participationTypeName,
				programDurationId, orderByComparator);
	}

	/**
	 * Removes all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63; from the database.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 */
	public static void removeByParticipationTypeNameByLikeAndProgramDurationId(
		String participationTypeName, long programDurationId) {

		getPersistence().
			removeByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId);
	}

	/**
	 * Returns the number of participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @return the number of matching participation type masters
	 */
	public static int countByParticipationTypeNameByLikeAndProgramDurationId(
		String participationTypeName, long programDurationId) {

		return getPersistence().
			countByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId);
	}

	/**
	 * Caches the participation type master in the entity cache if it is enabled.
	 *
	 * @param participationTypeMaster the participation type master
	 */
	public static void cacheResult(
		ParticipationTypeMaster participationTypeMaster) {

		getPersistence().cacheResult(participationTypeMaster);
	}

	/**
	 * Caches the participation type masters in the entity cache if it is enabled.
	 *
	 * @param participationTypeMasters the participation type masters
	 */
	public static void cacheResult(
		List<ParticipationTypeMaster> participationTypeMasters) {

		getPersistence().cacheResult(participationTypeMasters);
	}

	/**
	 * Creates a new participation type master with the primary key. Does not add the participation type master to the database.
	 *
	 * @param participationTypeMasterId the primary key for the new participation type master
	 * @return the new participation type master
	 */
	public static ParticipationTypeMaster create(
		long participationTypeMasterId) {

		return getPersistence().create(participationTypeMasterId);
	}

	/**
	 * Removes the participation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master that was removed
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster remove(long participationTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().remove(participationTypeMasterId);
	}

	public static ParticipationTypeMaster updateImpl(
		ParticipationTypeMaster participationTypeMaster) {

		return getPersistence().updateImpl(participationTypeMaster);
	}

	/**
	 * Returns the participation type master with the primary key or throws a <code>NoSuchParticipationTypeMasterException</code> if it could not be found.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster findByPrimaryKey(
			long participationTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchParticipationTypeMasterException {

		return getPersistence().findByPrimaryKey(participationTypeMasterId);
	}

	/**
	 * Returns the participation type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master, or <code>null</code> if a participation type master with the primary key could not be found
	 */
	public static ParticipationTypeMaster fetchByPrimaryKey(
		long participationTypeMasterId) {

		return getPersistence().fetchByPrimaryKey(participationTypeMasterId);
	}

	/**
	 * Returns all the participation type masters.
	 *
	 * @return the participation type masters
	 */
	public static List<ParticipationTypeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of participation type masters
	 */
	public static List<ParticipationTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of participation type masters
	 */
	public static List<ParticipationTypeMaster> findAll(
		int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of participation type masters
	 */
	public static List<ParticipationTypeMaster> findAll(
		int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the participation type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of participation type masters.
	 *
	 * @return the number of participation type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ParticipationTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ParticipationTypeMasterPersistence _persistence;

}
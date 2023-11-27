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

import gov.omsb.tms.model.EligibilityDegreeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the eligibility degree master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.EligibilityDegreeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EligibilityDegreeMasterPersistence
 * @generated
 */
public class EligibilityDegreeMasterUtil {

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
		EligibilityDegreeMaster eligibilityDegreeMaster) {

		getPersistence().clearCache(eligibilityDegreeMaster);
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
	public static Map<Serializable, EligibilityDegreeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EligibilityDegreeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EligibilityDegreeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EligibilityDegreeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EligibilityDegreeMaster update(
		EligibilityDegreeMaster eligibilityDegreeMaster) {

		return getPersistence().update(eligibilityDegreeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EligibilityDegreeMaster update(
		EligibilityDegreeMaster eligibilityDegreeMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(eligibilityDegreeMaster, serviceContext);
	}

	/**
	 * Returns all the eligibility degree masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster findByUuid_First(
			String uuid,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster fetchByUuid_First(
		String uuid,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster findByUuid_Last(
			String uuid,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster fetchByUuid_Last(
		String uuid,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public static EligibilityDegreeMaster[] findByUuid_PrevAndNext(
			long eligibilityDegreeMasterId, String uuid,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			eligibilityDegreeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the eligibility degree masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching eligibility degree masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEligibilityDegreeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the eligibility degree master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the eligibility degree master that was removed
	 */
	public static EligibilityDegreeMaster removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching eligibility degree masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public static EligibilityDegreeMaster[] findByUuid_C_PrevAndNext(
			long eligibilityDegreeMasterId, String uuid, long companyId,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			eligibilityDegreeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the eligibility degree masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching eligibility degree masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @return the matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String eligibilityDegree) {

		return getPersistence().findByeligibilityDegreeByLike(
			eligibilityDegree);
	}

	/**
	 * Returns a range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String eligibilityDegree, int start, int end) {

		return getPersistence().findByeligibilityDegreeByLike(
			eligibilityDegree, start, end);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String eligibilityDegree, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().findByeligibilityDegreeByLike(
			eligibilityDegree, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String eligibilityDegree, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByeligibilityDegreeByLike(
			eligibilityDegree, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster findByeligibilityDegreeByLike_First(
			String eligibilityDegree,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByeligibilityDegreeByLike_First(
			eligibilityDegree, orderByComparator);
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster fetchByeligibilityDegreeByLike_First(
		String eligibilityDegree,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().fetchByeligibilityDegreeByLike_First(
			eligibilityDegree, orderByComparator);
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster findByeligibilityDegreeByLike_Last(
			String eligibilityDegree,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByeligibilityDegreeByLike_Last(
			eligibilityDegree, orderByComparator);
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public static EligibilityDegreeMaster fetchByeligibilityDegreeByLike_Last(
		String eligibilityDegree,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().fetchByeligibilityDegreeByLike_Last(
			eligibilityDegree, orderByComparator);
	}

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public static EligibilityDegreeMaster[]
			findByeligibilityDegreeByLike_PrevAndNext(
				long eligibilityDegreeMasterId, String eligibilityDegree,
				OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByeligibilityDegreeByLike_PrevAndNext(
			eligibilityDegreeMasterId, eligibilityDegree, orderByComparator);
	}

	/**
	 * Removes all the eligibility degree masters where eligibilityDegree LIKE &#63; from the database.
	 *
	 * @param eligibilityDegree the eligibility degree
	 */
	public static void removeByeligibilityDegreeByLike(
		String eligibilityDegree) {

		getPersistence().removeByeligibilityDegreeByLike(eligibilityDegree);
	}

	/**
	 * Returns the number of eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @return the number of matching eligibility degree masters
	 */
	public static int countByeligibilityDegreeByLike(String eligibilityDegree) {
		return getPersistence().countByeligibilityDegreeByLike(
			eligibilityDegree);
	}

	/**
	 * Caches the eligibility degree master in the entity cache if it is enabled.
	 *
	 * @param eligibilityDegreeMaster the eligibility degree master
	 */
	public static void cacheResult(
		EligibilityDegreeMaster eligibilityDegreeMaster) {

		getPersistence().cacheResult(eligibilityDegreeMaster);
	}

	/**
	 * Caches the eligibility degree masters in the entity cache if it is enabled.
	 *
	 * @param eligibilityDegreeMasters the eligibility degree masters
	 */
	public static void cacheResult(
		List<EligibilityDegreeMaster> eligibilityDegreeMasters) {

		getPersistence().cacheResult(eligibilityDegreeMasters);
	}

	/**
	 * Creates a new eligibility degree master with the primary key. Does not add the eligibility degree master to the database.
	 *
	 * @param eligibilityDegreeMasterId the primary key for the new eligibility degree master
	 * @return the new eligibility degree master
	 */
	public static EligibilityDegreeMaster create(
		long eligibilityDegreeMasterId) {

		return getPersistence().create(eligibilityDegreeMasterId);
	}

	/**
	 * Removes the eligibility degree master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master that was removed
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public static EligibilityDegreeMaster remove(long eligibilityDegreeMasterId)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().remove(eligibilityDegreeMasterId);
	}

	public static EligibilityDegreeMaster updateImpl(
		EligibilityDegreeMaster eligibilityDegreeMaster) {

		return getPersistence().updateImpl(eligibilityDegreeMaster);
	}

	/**
	 * Returns the eligibility degree master with the primary key or throws a <code>NoSuchEligibilityDegreeMasterException</code> if it could not be found.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public static EligibilityDegreeMaster findByPrimaryKey(
			long eligibilityDegreeMasterId)
		throws gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException {

		return getPersistence().findByPrimaryKey(eligibilityDegreeMasterId);
	}

	/**
	 * Returns the eligibility degree master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master, or <code>null</code> if a eligibility degree master with the primary key could not be found
	 */
	public static EligibilityDegreeMaster fetchByPrimaryKey(
		long eligibilityDegreeMasterId) {

		return getPersistence().fetchByPrimaryKey(eligibilityDegreeMasterId);
	}

	/**
	 * Returns all the eligibility degree masters.
	 *
	 * @return the eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findAll(
		int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of eligibility degree masters
	 */
	public static List<EligibilityDegreeMaster> findAll(
		int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the eligibility degree masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of eligibility degree masters.
	 *
	 * @return the number of eligibility degree masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EligibilityDegreeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EligibilityDegreeMasterPersistence _persistence;

}
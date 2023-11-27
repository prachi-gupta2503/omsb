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

import gov.omsb.tms.model.QararRequest;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the qarar request service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.QararRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QararRequestPersistence
 * @generated
 */
public class QararRequestUtil {

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
	public static void clearCache(QararRequest qararRequest) {
		getPersistence().clearCache(qararRequest);
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
	public static Map<Serializable, QararRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QararRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QararRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QararRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QararRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QararRequest update(QararRequest qararRequest) {
		return getPersistence().update(qararRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QararRequest update(
		QararRequest qararRequest, ServiceContext serviceContext) {

		return getPersistence().update(qararRequest, serviceContext);
	}

	/**
	 * Returns all the qarar requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching qarar requests
	 */
	public static List<QararRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the qarar requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @return the range of matching qarar requests
	 */
	public static List<QararRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the qarar requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qarar requests
	 */
	public static List<QararRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QararRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qarar requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qarar requests
	 */
	public static List<QararRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QararRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public static QararRequest findByUuid_First(
			String uuid, OrderByComparator<QararRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchByUuid_First(
		String uuid, OrderByComparator<QararRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public static QararRequest findByUuid_Last(
			String uuid, OrderByComparator<QararRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchByUuid_Last(
		String uuid, OrderByComparator<QararRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the qarar requests before and after the current qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param qararRequestId the primary key of the current qarar request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qarar request
	 * @throws NoSuchQararRequestException if a qarar request with the primary key could not be found
	 */
	public static QararRequest[] findByUuid_PrevAndNext(
			long qararRequestId, String uuid,
			OrderByComparator<QararRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			qararRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the qarar requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of qarar requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching qarar requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the qarar request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchQararRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public static QararRequest findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the qarar request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the qarar request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the qarar request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the qarar request that was removed
	 */
	public static QararRequest removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of qarar requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching qarar requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the qarar requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching qarar requests
	 */
	public static List<QararRequest> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the qarar requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @return the range of matching qarar requests
	 */
	public static List<QararRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the qarar requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qarar requests
	 */
	public static List<QararRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<QararRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qarar requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qarar requests
	 */
	public static List<QararRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<QararRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public static QararRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<QararRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<QararRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public static QararRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<QararRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<QararRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the qarar requests before and after the current qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param qararRequestId the primary key of the current qarar request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qarar request
	 * @throws NoSuchQararRequestException if a qarar request with the primary key could not be found
	 */
	public static QararRequest[] findByUuid_C_PrevAndNext(
			long qararRequestId, String uuid, long companyId,
			OrderByComparator<QararRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			qararRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the qarar requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of qarar requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching qarar requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the qarar request where docTreeId = &#63; or throws a <code>NoSuchQararRequestException</code> if it could not be found.
	 *
	 * @param docTreeId the doc tree ID
	 * @return the matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public static QararRequest findByDocTreeId(long docTreeId)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByDocTreeId(docTreeId);
	}

	/**
	 * Returns the qarar request where docTreeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param docTreeId the doc tree ID
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchByDocTreeId(long docTreeId) {
		return getPersistence().fetchByDocTreeId(docTreeId);
	}

	/**
	 * Returns the qarar request where docTreeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param docTreeId the doc tree ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchByDocTreeId(
		long docTreeId, boolean useFinderCache) {

		return getPersistence().fetchByDocTreeId(docTreeId, useFinderCache);
	}

	/**
	 * Removes the qarar request where docTreeId = &#63; from the database.
	 *
	 * @param docTreeId the doc tree ID
	 * @return the qarar request that was removed
	 */
	public static QararRequest removeByDocTreeId(long docTreeId)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().removeByDocTreeId(docTreeId);
	}

	/**
	 * Returns the number of qarar requests where docTreeId = &#63;.
	 *
	 * @param docTreeId the doc tree ID
	 * @return the number of matching qarar requests
	 */
	public static int countByDocTreeId(long docTreeId) {
		return getPersistence().countByDocTreeId(docTreeId);
	}

	/**
	 * Caches the qarar request in the entity cache if it is enabled.
	 *
	 * @param qararRequest the qarar request
	 */
	public static void cacheResult(QararRequest qararRequest) {
		getPersistence().cacheResult(qararRequest);
	}

	/**
	 * Caches the qarar requests in the entity cache if it is enabled.
	 *
	 * @param qararRequests the qarar requests
	 */
	public static void cacheResult(List<QararRequest> qararRequests) {
		getPersistence().cacheResult(qararRequests);
	}

	/**
	 * Creates a new qarar request with the primary key. Does not add the qarar request to the database.
	 *
	 * @param qararRequestId the primary key for the new qarar request
	 * @return the new qarar request
	 */
	public static QararRequest create(long qararRequestId) {
		return getPersistence().create(qararRequestId);
	}

	/**
	 * Removes the qarar request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request that was removed
	 * @throws NoSuchQararRequestException if a qarar request with the primary key could not be found
	 */
	public static QararRequest remove(long qararRequestId)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().remove(qararRequestId);
	}

	public static QararRequest updateImpl(QararRequest qararRequest) {
		return getPersistence().updateImpl(qararRequest);
	}

	/**
	 * Returns the qarar request with the primary key or throws a <code>NoSuchQararRequestException</code> if it could not be found.
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request
	 * @throws NoSuchQararRequestException if a qarar request with the primary key could not be found
	 */
	public static QararRequest findByPrimaryKey(long qararRequestId)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getPersistence().findByPrimaryKey(qararRequestId);
	}

	/**
	 * Returns the qarar request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request, or <code>null</code> if a qarar request with the primary key could not be found
	 */
	public static QararRequest fetchByPrimaryKey(long qararRequestId) {
		return getPersistence().fetchByPrimaryKey(qararRequestId);
	}

	/**
	 * Returns all the qarar requests.
	 *
	 * @return the qarar requests
	 */
	public static List<QararRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the qarar requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @return the range of qarar requests
	 */
	public static List<QararRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the qarar requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qarar requests
	 */
	public static List<QararRequest> findAll(
		int start, int end, OrderByComparator<QararRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qarar requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qarar requests
	 */
	public static List<QararRequest> findAll(
		int start, int end, OrderByComparator<QararRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the qarar requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of qarar requests.
	 *
	 * @return the number of qarar requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QararRequestPersistence getPersistence() {
		return _persistence;
	}

	private static volatile QararRequestPersistence _persistence;

}
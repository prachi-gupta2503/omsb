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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import gov.omsb.tms.exception.NoSuchQararRequestException;
import gov.omsb.tms.model.QararRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the qarar request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QararRequestUtil
 * @generated
 */
@ProviderType
public interface QararRequestPersistence extends BasePersistence<QararRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QararRequestUtil} to access the qarar request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the qarar requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching qarar requests
	 */
	public java.util.List<QararRequest> findByUuid(String uuid);

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
	public java.util.List<QararRequest> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<QararRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator);

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
	public java.util.List<QararRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public QararRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
				orderByComparator)
		throws NoSuchQararRequestException;

	/**
	 * Returns the first qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public QararRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator);

	/**
	 * Returns the last qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public QararRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
				orderByComparator)
		throws NoSuchQararRequestException;

	/**
	 * Returns the last qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public QararRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator);

	/**
	 * Returns the qarar requests before and after the current qarar request in the ordered set where uuid = &#63;.
	 *
	 * @param qararRequestId the primary key of the current qarar request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qarar request
	 * @throws NoSuchQararRequestException if a qarar request with the primary key could not be found
	 */
	public QararRequest[] findByUuid_PrevAndNext(
			long qararRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
				orderByComparator)
		throws NoSuchQararRequestException;

	/**
	 * Removes all the qarar requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of qarar requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching qarar requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the qarar request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchQararRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public QararRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchQararRequestException;

	/**
	 * Returns the qarar request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public QararRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the qarar request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public QararRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the qarar request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the qarar request that was removed
	 */
	public QararRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchQararRequestException;

	/**
	 * Returns the number of qarar requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching qarar requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the qarar requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching qarar requests
	 */
	public java.util.List<QararRequest> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<QararRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<QararRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator);

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
	public java.util.List<QararRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public QararRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
				orderByComparator)
		throws NoSuchQararRequestException;

	/**
	 * Returns the first qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public QararRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator);

	/**
	 * Returns the last qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public QararRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
				orderByComparator)
		throws NoSuchQararRequestException;

	/**
	 * Returns the last qarar request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public QararRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator);

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
	public QararRequest[] findByUuid_C_PrevAndNext(
			long qararRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
				orderByComparator)
		throws NoSuchQararRequestException;

	/**
	 * Removes all the qarar requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of qarar requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching qarar requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the qarar request where docTreeId = &#63; or throws a <code>NoSuchQararRequestException</code> if it could not be found.
	 *
	 * @param docTreeId the doc tree ID
	 * @return the matching qarar request
	 * @throws NoSuchQararRequestException if a matching qarar request could not be found
	 */
	public QararRequest findByDocTreeId(long docTreeId)
		throws NoSuchQararRequestException;

	/**
	 * Returns the qarar request where docTreeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param docTreeId the doc tree ID
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public QararRequest fetchByDocTreeId(long docTreeId);

	/**
	 * Returns the qarar request where docTreeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param docTreeId the doc tree ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public QararRequest fetchByDocTreeId(
		long docTreeId, boolean useFinderCache);

	/**
	 * Removes the qarar request where docTreeId = &#63; from the database.
	 *
	 * @param docTreeId the doc tree ID
	 * @return the qarar request that was removed
	 */
	public QararRequest removeByDocTreeId(long docTreeId)
		throws NoSuchQararRequestException;

	/**
	 * Returns the number of qarar requests where docTreeId = &#63;.
	 *
	 * @param docTreeId the doc tree ID
	 * @return the number of matching qarar requests
	 */
	public int countByDocTreeId(long docTreeId);

	/**
	 * Caches the qarar request in the entity cache if it is enabled.
	 *
	 * @param qararRequest the qarar request
	 */
	public void cacheResult(QararRequest qararRequest);

	/**
	 * Caches the qarar requests in the entity cache if it is enabled.
	 *
	 * @param qararRequests the qarar requests
	 */
	public void cacheResult(java.util.List<QararRequest> qararRequests);

	/**
	 * Creates a new qarar request with the primary key. Does not add the qarar request to the database.
	 *
	 * @param qararRequestId the primary key for the new qarar request
	 * @return the new qarar request
	 */
	public QararRequest create(long qararRequestId);

	/**
	 * Removes the qarar request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request that was removed
	 * @throws NoSuchQararRequestException if a qarar request with the primary key could not be found
	 */
	public QararRequest remove(long qararRequestId)
		throws NoSuchQararRequestException;

	public QararRequest updateImpl(QararRequest qararRequest);

	/**
	 * Returns the qarar request with the primary key or throws a <code>NoSuchQararRequestException</code> if it could not be found.
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request
	 * @throws NoSuchQararRequestException if a qarar request with the primary key could not be found
	 */
	public QararRequest findByPrimaryKey(long qararRequestId)
		throws NoSuchQararRequestException;

	/**
	 * Returns the qarar request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request, or <code>null</code> if a qarar request with the primary key could not be found
	 */
	public QararRequest fetchByPrimaryKey(long qararRequestId);

	/**
	 * Returns all the qarar requests.
	 *
	 * @return the qarar requests
	 */
	public java.util.List<QararRequest> findAll();

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
	public java.util.List<QararRequest> findAll(int start, int end);

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
	public java.util.List<QararRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator);

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
	public java.util.List<QararRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QararRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the qarar requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of qarar requests.
	 *
	 * @return the number of qarar requests
	 */
	public int countAll();

}
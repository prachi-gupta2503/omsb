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

import gov.omsb.tms.exception.NoSuchEcMemberRequestException;
import gov.omsb.tms.model.EcMemberRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ec member request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestUtil
 * @generated
 */
@ProviderType
public interface EcMemberRequestPersistence
	extends BasePersistence<EcMemberRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EcMemberRequestUtil} to access the ec member request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ec member requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public EcMemberRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public EcMemberRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public EcMemberRequest[] findByUuid_PrevAndNext(
			long ecMemberRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Removes all the ec member requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ec member requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public EcMemberRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ec member request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request that was removed
	 */
	public EcMemberRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the number of ec member requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public EcMemberRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public EcMemberRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public EcMemberRequest[] findByUuid_C_PrevAndNext(
			long ecMemberRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Removes all the ec member requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public EcMemberRequest findByPotentialEcMemberId(long potentialEcMemberId)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByPotentialEcMemberId(long potentialEcMemberId);

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByPotentialEcMemberId(
		long potentialEcMemberId, boolean useFinderCache);

	/**
	 * Removes the ec member request where potentialEcMemberId = &#63; from the database.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the ec member request that was removed
	 */
	public EcMemberRequest removeByPotentialEcMemberId(long potentialEcMemberId)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the number of ec member requests where potentialEcMemberId = &#63;.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the number of matching ec member requests
	 */
	public int countByPotentialEcMemberId(long potentialEcMemberId);

	/**
	 * Returns all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @return the matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid);

	/**
	 * Returns a range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end);

	/**
	 * Returns an ordered range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	public java.util.List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public EcMemberRequest findByPotentialEcMemberLruserid_First(
			long potentialEcMemberLruserid,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the first ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByPotentialEcMemberLruserid_First(
		long potentialEcMemberLruserid,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns the last ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public EcMemberRequest findByPotentialEcMemberLruserid_Last(
			long potentialEcMemberLruserid,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the last ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public EcMemberRequest fetchByPotentialEcMemberLruserid_Last(
		long potentialEcMemberLruserid,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public EcMemberRequest[] findByPotentialEcMemberLruserid_PrevAndNext(
			long ecMemberRequestId, long potentialEcMemberLruserid,
			com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
				orderByComparator)
		throws NoSuchEcMemberRequestException;

	/**
	 * Removes all the ec member requests where potentialEcMemberLruserid = &#63; from the database.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 */
	public void removeByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid);

	/**
	 * Returns the number of ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @return the number of matching ec member requests
	 */
	public int countByPotentialEcMemberLruserid(long potentialEcMemberLruserid);

	/**
	 * Caches the ec member request in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequest the ec member request
	 */
	public void cacheResult(EcMemberRequest ecMemberRequest);

	/**
	 * Caches the ec member requests in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequests the ec member requests
	 */
	public void cacheResult(java.util.List<EcMemberRequest> ecMemberRequests);

	/**
	 * Creates a new ec member request with the primary key. Does not add the ec member request to the database.
	 *
	 * @param ecMemberRequestId the primary key for the new ec member request
	 * @return the new ec member request
	 */
	public EcMemberRequest create(long ecMemberRequestId);

	/**
	 * Removes the ec member request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request that was removed
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public EcMemberRequest remove(long ecMemberRequestId)
		throws NoSuchEcMemberRequestException;

	public EcMemberRequest updateImpl(EcMemberRequest ecMemberRequest);

	/**
	 * Returns the ec member request with the primary key or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public EcMemberRequest findByPrimaryKey(long ecMemberRequestId)
		throws NoSuchEcMemberRequestException;

	/**
	 * Returns the ec member request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request, or <code>null</code> if a ec member request with the primary key could not be found
	 */
	public EcMemberRequest fetchByPrimaryKey(long ecMemberRequestId);

	/**
	 * Returns all the ec member requests.
	 *
	 * @return the ec member requests
	 */
	public java.util.List<EcMemberRequest> findAll();

	/**
	 * Returns a range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of ec member requests
	 */
	public java.util.List<EcMemberRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member requests
	 */
	public java.util.List<EcMemberRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member requests
	 */
	public java.util.List<EcMemberRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ec member requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ec member requests.
	 *
	 * @return the number of ec member requests
	 */
	public int countAll();

}
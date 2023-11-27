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

import gov.omsb.tms.exception.NoSuchSharedRotationRequestDetailsException;
import gov.omsb.tms.model.SharedRotationRequestDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the shared rotation request details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationRequestDetailsUtil
 * @generated
 */
@ProviderType
public interface SharedRotationRequestDetailsPersistence
	extends BasePersistence<SharedRotationRequestDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SharedRotationRequestDetailsUtil} to access the shared rotation request details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the shared rotation request detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public SharedRotationRequestDetails[] findByUuid_PrevAndNext(
			long sharedRotationRequestDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Removes all the shared rotation request detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching shared rotation request detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSharedRotationRequestDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the shared rotation request details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the shared rotation request details that was removed
	 */
	public SharedRotationRequestDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching shared rotation request detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public SharedRotationRequestDetails[] findByUuid_C_PrevAndNext(
			long sharedRotationRequestDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Removes all the shared rotation request detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching shared rotation request detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @return the matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy);

	/**
	 * Returns a range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end);

	/**
	 * Returns an ordered range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails findByRequestRaisedBy_First(
			String requestRaisedBy,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the first shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails fetchByRequestRaisedBy_First(
		String requestRaisedBy,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns the last shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails findByRequestRaisedBy_Last(
			String requestRaisedBy,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the last shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public SharedRotationRequestDetails fetchByRequestRaisedBy_Last(
		String requestRaisedBy,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public SharedRotationRequestDetails[] findByRequestRaisedBy_PrevAndNext(
			long sharedRotationRequestDetailsId, String requestRaisedBy,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Removes all the shared rotation request detailses where requestRaisedBy = &#63; from the database.
	 *
	 * @param requestRaisedBy the request raised by
	 */
	public void removeByRequestRaisedBy(String requestRaisedBy);

	/**
	 * Returns the number of shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @return the number of matching shared rotation request detailses
	 */
	public int countByRequestRaisedBy(String requestRaisedBy);

	/**
	 * Caches the shared rotation request details in the entity cache if it is enabled.
	 *
	 * @param sharedRotationRequestDetails the shared rotation request details
	 */
	public void cacheResult(
		SharedRotationRequestDetails sharedRotationRequestDetails);

	/**
	 * Caches the shared rotation request detailses in the entity cache if it is enabled.
	 *
	 * @param sharedRotationRequestDetailses the shared rotation request detailses
	 */
	public void cacheResult(
		java.util.List<SharedRotationRequestDetails>
			sharedRotationRequestDetailses);

	/**
	 * Creates a new shared rotation request details with the primary key. Does not add the shared rotation request details to the database.
	 *
	 * @param sharedRotationRequestDetailsId the primary key for the new shared rotation request details
	 * @return the new shared rotation request details
	 */
	public SharedRotationRequestDetails create(
		long sharedRotationRequestDetailsId);

	/**
	 * Removes the shared rotation request details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details that was removed
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public SharedRotationRequestDetails remove(
			long sharedRotationRequestDetailsId)
		throws NoSuchSharedRotationRequestDetailsException;

	public SharedRotationRequestDetails updateImpl(
		SharedRotationRequestDetails sharedRotationRequestDetails);

	/**
	 * Returns the shared rotation request details with the primary key or throws a <code>NoSuchSharedRotationRequestDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public SharedRotationRequestDetails findByPrimaryKey(
			long sharedRotationRequestDetailsId)
		throws NoSuchSharedRotationRequestDetailsException;

	/**
	 * Returns the shared rotation request details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details, or <code>null</code> if a shared rotation request details with the primary key could not be found
	 */
	public SharedRotationRequestDetails fetchByPrimaryKey(
		long sharedRotationRequestDetailsId);

	/**
	 * Returns all the shared rotation request detailses.
	 *
	 * @return the shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findAll();

	/**
	 * Returns a range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of shared rotation request detailses
	 */
	public java.util.List<SharedRotationRequestDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the shared rotation request detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of shared rotation request detailses.
	 *
	 * @return the number of shared rotation request detailses
	 */
	public int countAll();

}
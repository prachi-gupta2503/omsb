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

import gov.omsb.tms.exception.NoSuchSharedRotationApproverDetailsException;
import gov.omsb.tms.model.SharedRotationApproverDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the shared rotation approver details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationApproverDetailsUtil
 * @generated
 */
@ProviderType
public interface SharedRotationApproverDetailsPersistence
	extends BasePersistence<SharedRotationApproverDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SharedRotationApproverDetailsUtil} to access the shared rotation approver details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of matching shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator);

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator);

	/**
	 * Returns the shared rotation approver detailses before and after the current shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the current shared rotation approver details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	public SharedRotationApproverDetails[] findByUuid_PrevAndNext(
			long sharedRotationApproverDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Removes all the shared rotation approver detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching shared rotation approver detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the shared rotation approver details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the shared rotation approver details that was removed
	 */
	public SharedRotationApproverDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching shared rotation approver detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of matching shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator);

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator);

	/**
	 * Returns the shared rotation approver detailses before and after the current shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the current shared rotation approver details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	public SharedRotationApproverDetails[] findByUuid_C_PrevAndNext(
			long sharedRotationApproverDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Removes all the shared rotation approver detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching shared rotation approver detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails findBySharedRotationRequestDetailsId(
			long sharedRotationRequestDetailsId)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails fetchBySharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId);

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public SharedRotationApproverDetails fetchBySharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId, boolean useFinderCache);

	/**
	 * Removes the shared rotation approver details where sharedRotationRequestDetailsId = &#63; from the database.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the shared rotation approver details that was removed
	 */
	public SharedRotationApproverDetails removeBySharedRotationRequestDetailsId(
			long sharedRotationRequestDetailsId)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the number of shared rotation approver detailses where sharedRotationRequestDetailsId = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the number of matching shared rotation approver detailses
	 */
	public int countBySharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId);

	/**
	 * Caches the shared rotation approver details in the entity cache if it is enabled.
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 */
	public void cacheResult(
		SharedRotationApproverDetails sharedRotationApproverDetails);

	/**
	 * Caches the shared rotation approver detailses in the entity cache if it is enabled.
	 *
	 * @param sharedRotationApproverDetailses the shared rotation approver detailses
	 */
	public void cacheResult(
		java.util.List<SharedRotationApproverDetails>
			sharedRotationApproverDetailses);

	/**
	 * Creates a new shared rotation approver details with the primary key. Does not add the shared rotation approver details to the database.
	 *
	 * @param sharedRotationApproverDetailsId the primary key for the new shared rotation approver details
	 * @return the new shared rotation approver details
	 */
	public SharedRotationApproverDetails create(
		long sharedRotationApproverDetailsId);

	/**
	 * Removes the shared rotation approver details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details that was removed
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	public SharedRotationApproverDetails remove(
			long sharedRotationApproverDetailsId)
		throws NoSuchSharedRotationApproverDetailsException;

	public SharedRotationApproverDetails updateImpl(
		SharedRotationApproverDetails sharedRotationApproverDetails);

	/**
	 * Returns the shared rotation approver details with the primary key or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	public SharedRotationApproverDetails findByPrimaryKey(
			long sharedRotationApproverDetailsId)
		throws NoSuchSharedRotationApproverDetailsException;

	/**
	 * Returns the shared rotation approver details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details, or <code>null</code> if a shared rotation approver details with the primary key could not be found
	 */
	public SharedRotationApproverDetails fetchByPrimaryKey(
		long sharedRotationApproverDetailsId);

	/**
	 * Returns all the shared rotation approver detailses.
	 *
	 * @return the shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findAll();

	/**
	 * Returns a range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of shared rotation approver detailses
	 */
	public java.util.List<SharedRotationApproverDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SharedRotationApproverDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the shared rotation approver detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of shared rotation approver detailses.
	 *
	 * @return the number of shared rotation approver detailses
	 */
	public int countAll();

}
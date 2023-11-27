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

import gov.omsb.tms.exception.NoSuchEcMemberRequestStateException;
import gov.omsb.tms.model.EcMemberRequestState;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ec member request state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStateUtil
 * @generated
 */
@ProviderType
public interface EcMemberRequestStatePersistence
	extends BasePersistence<EcMemberRequestState> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EcMemberRequestStateUtil} to access the ec member request state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ec member request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByUuid(String uuid);

	/**
	 * Returns a range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public EcMemberRequestState[] findByUuid_PrevAndNext(
			long ecMemberRequestStateId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Removes all the ec member request states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ec member request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member request states
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ec member request state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request state that was removed
	 */
	public EcMemberRequestState removeByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the number of ec member request states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member request states
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public EcMemberRequestState[] findByUuid_C_PrevAndNext(
			long ecMemberRequestStateId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Removes all the ec member request states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member request states
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId);

	/**
	 * Returns a range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByEcMemberRequestId_First(
			long ecMemberRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByEcMemberRequestId_First(
		long ecMemberRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByEcMemberRequestId_Last(
			long ecMemberRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByEcMemberRequestId_Last(
		long ecMemberRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public EcMemberRequestState[] findByEcMemberRequestId_PrevAndNext(
			long ecMemberRequestStateId, long ecMemberRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Removes all the ec member request states where ecMemberRequestId = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 */
	public void removeByEcMemberRequestId(long ecMemberRequestId);

	/**
	 * Returns the number of ec member request states where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the number of matching ec member request states
	 */
	public int countByEcMemberRequestId(long ecMemberRequestId);

	/**
	 * Returns all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @return the matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic);

	/**
	 * Returns a range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	public java.util.List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByVisibility_First(
			long ecMemberRequestId, boolean isPublic,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByVisibility_First(
		long ecMemberRequestId, boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public EcMemberRequestState findByVisibility_Last(
			long ecMemberRequestId, boolean isPublic,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public EcMemberRequestState fetchByVisibility_Last(
		long ecMemberRequestId, boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public EcMemberRequestState[] findByVisibility_PrevAndNext(
			long ecMemberRequestStateId, long ecMemberRequestId,
			boolean isPublic,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Removes all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 */
	public void removeByVisibility(long ecMemberRequestId, boolean isPublic);

	/**
	 * Returns the number of ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @return the number of matching ec member request states
	 */
	public int countByVisibility(long ecMemberRequestId, boolean isPublic);

	/**
	 * Caches the ec member request state in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestState the ec member request state
	 */
	public void cacheResult(EcMemberRequestState ecMemberRequestState);

	/**
	 * Caches the ec member request states in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStates the ec member request states
	 */
	public void cacheResult(
		java.util.List<EcMemberRequestState> ecMemberRequestStates);

	/**
	 * Creates a new ec member request state with the primary key. Does not add the ec member request state to the database.
	 *
	 * @param ecMemberRequestStateId the primary key for the new ec member request state
	 * @return the new ec member request state
	 */
	public EcMemberRequestState create(long ecMemberRequestStateId);

	/**
	 * Removes the ec member request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state that was removed
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public EcMemberRequestState remove(long ecMemberRequestStateId)
		throws NoSuchEcMemberRequestStateException;

	public EcMemberRequestState updateImpl(
		EcMemberRequestState ecMemberRequestState);

	/**
	 * Returns the ec member request state with the primary key or throws a <code>NoSuchEcMemberRequestStateException</code> if it could not be found.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public EcMemberRequestState findByPrimaryKey(long ecMemberRequestStateId)
		throws NoSuchEcMemberRequestStateException;

	/**
	 * Returns the ec member request state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state, or <code>null</code> if a ec member request state with the primary key could not be found
	 */
	public EcMemberRequestState fetchByPrimaryKey(long ecMemberRequestStateId);

	/**
	 * Returns all the ec member request states.
	 *
	 * @return the ec member request states
	 */
	public java.util.List<EcMemberRequestState> findAll();

	/**
	 * Returns a range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of ec member request states
	 */
	public java.util.List<EcMemberRequestState> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member request states
	 */
	public java.util.List<EcMemberRequestState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member request states
	 */
	public java.util.List<EcMemberRequestState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ec member request states from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ec member request states.
	 *
	 * @return the number of ec member request states
	 */
	public int countAll();

}
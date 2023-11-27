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

import gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException;
import gov.omsb.tms.model.EcMemberRequestStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ec member request status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStatusUtil
 * @generated
 */
@ProviderType
public interface EcMemberRequestStatusPersistence
	extends BasePersistence<EcMemberRequestStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EcMemberRequestStatusUtil} to access the ec member request status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ec member request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByUuid(String uuid);

	/**
	 * Returns a range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public EcMemberRequestStatus[] findByUuid_PrevAndNext(
			long ecMemberRequestStatusId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Removes all the ec member request statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ec member request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member request statuses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus findByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ec member request status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request status that was removed
	 */
	public EcMemberRequestStatus removeByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the number of ec member request statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member request statuses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public EcMemberRequestStatus[] findByUuid_C_PrevAndNext(
			long ecMemberRequestStatusId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Removes all the ec member request statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member request statuses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the ec member request statuses where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByCode(String code);

	/**
	 * Returns a range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the first ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns the last ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the last ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public EcMemberRequestStatus[] findByCode_PrevAndNext(
			long ecMemberRequestStatusId, String code,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Removes all the ec member request statuses where code LIKE &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of ec member request statuses where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the number of matching ec member request statuses
	 */
	public int countByCode(String code);

	/**
	 * Returns the ec member request status where nameEn = &#63; or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param nameEn the name en
	 * @return the matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus findByNameEn(String nameEn)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the ec member request status where nameEn = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nameEn the name en
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByNameEn(String nameEn);

	/**
	 * Returns the ec member request status where nameEn = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nameEn the name en
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public EcMemberRequestStatus fetchByNameEn(
		String nameEn, boolean useFinderCache);

	/**
	 * Removes the ec member request status where nameEn = &#63; from the database.
	 *
	 * @param nameEn the name en
	 * @return the ec member request status that was removed
	 */
	public EcMemberRequestStatus removeByNameEn(String nameEn)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the number of ec member request statuses where nameEn = &#63;.
	 *
	 * @param nameEn the name en
	 * @return the number of matching ec member request statuses
	 */
	public int countByNameEn(String nameEn);

	/**
	 * Caches the ec member request status in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStatus the ec member request status
	 */
	public void cacheResult(EcMemberRequestStatus ecMemberRequestStatus);

	/**
	 * Caches the ec member request statuses in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStatuses the ec member request statuses
	 */
	public void cacheResult(
		java.util.List<EcMemberRequestStatus> ecMemberRequestStatuses);

	/**
	 * Creates a new ec member request status with the primary key. Does not add the ec member request status to the database.
	 *
	 * @param ecMemberRequestStatusId the primary key for the new ec member request status
	 * @return the new ec member request status
	 */
	public EcMemberRequestStatus create(long ecMemberRequestStatusId);

	/**
	 * Removes the ec member request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status that was removed
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public EcMemberRequestStatus remove(long ecMemberRequestStatusId)
		throws NoSuchEcMemberRequestStatusException;

	public EcMemberRequestStatus updateImpl(
		EcMemberRequestStatus ecMemberRequestStatus);

	/**
	 * Returns the ec member request status with the primary key or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public EcMemberRequestStatus findByPrimaryKey(long ecMemberRequestStatusId)
		throws NoSuchEcMemberRequestStatusException;

	/**
	 * Returns the ec member request status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status, or <code>null</code> if a ec member request status with the primary key could not be found
	 */
	public EcMemberRequestStatus fetchByPrimaryKey(
		long ecMemberRequestStatusId);

	/**
	 * Returns all the ec member request statuses.
	 *
	 * @return the ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findAll();

	/**
	 * Returns a range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member request statuses
	 */
	public java.util.List<EcMemberRequestStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcMemberRequestStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ec member request statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ec member request statuses.
	 *
	 * @return the number of ec member request statuses
	 */
	public int countAll();

}
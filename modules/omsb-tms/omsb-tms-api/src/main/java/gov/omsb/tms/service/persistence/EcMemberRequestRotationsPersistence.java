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

import gov.omsb.tms.exception.NoSuchEcMemberRequestRotationsException;
import gov.omsb.tms.model.EcMemberRequestRotations;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ec member request rotations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestRotationsUtil
 * @generated
 */
@ProviderType
public interface EcMemberRequestRotationsPersistence
	extends BasePersistence<EcMemberRequestRotations> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EcMemberRequestRotationsUtil} to access the ec member request rotations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ec member request rotationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByUuid(String uuid);

	/**
	 * Returns a range of all the ec member request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @return the range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the first ec member request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns the last ec member request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the last ec member request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns the ec member request rotationses before and after the current ec member request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestRotationsId the primary key of the current ec member request rotations
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a ec member request rotations with the primary key could not be found
	 */
	public EcMemberRequestRotations[] findByUuid_PrevAndNext(
			long ecMemberRequestRotationsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Removes all the ec member request rotationses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ec member request rotationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member request rotationses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ec member request rotations where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestRotationsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations findByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the ec member request rotations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ec member request rotations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ec member request rotations where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request rotations that was removed
	 */
	public EcMemberRequestRotations removeByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the number of ec member request rotationses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member request rotationses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ec member request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ec member request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @return the range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the first ec member request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns the last ec member request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the last ec member request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns the ec member request rotationses before and after the current ec member request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestRotationsId the primary key of the current ec member request rotations
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a ec member request rotations with the primary key could not be found
	 */
	public EcMemberRequestRotations[] findByUuid_C_PrevAndNext(
			long ecMemberRequestRotationsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Removes all the ec member request rotationses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ec member request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member request rotationses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the ec member request rotationses where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByEcMemberRequestId(
		long ecMemberRequestId);

	/**
	 * Returns a range of all the ec member request rotationses where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @return the range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end);

	/**
	 * Returns an ordered range of all the ec member request rotationses where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request rotationses where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ec member request rotations in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations findByEcMemberRequestId_First(
			long ecMemberRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the first ec member request rotations in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations fetchByEcMemberRequestId_First(
		long ecMemberRequestId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns the last ec member request rotations in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations findByEcMemberRequestId_Last(
			long ecMemberRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the last ec member request rotations in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	public EcMemberRequestRotations fetchByEcMemberRequestId_Last(
		long ecMemberRequestId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns the ec member request rotationses before and after the current ec member request rotations in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestRotationsId the primary key of the current ec member request rotations
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a ec member request rotations with the primary key could not be found
	 */
	public EcMemberRequestRotations[] findByEcMemberRequestId_PrevAndNext(
			long ecMemberRequestRotationsId, long ecMemberRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EcMemberRequestRotations> orderByComparator)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Removes all the ec member request rotationses where ecMemberRequestId = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 */
	public void removeByEcMemberRequestId(long ecMemberRequestId);

	/**
	 * Returns the number of ec member request rotationses where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the number of matching ec member request rotationses
	 */
	public int countByEcMemberRequestId(long ecMemberRequestId);

	/**
	 * Caches the ec member request rotations in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestRotations the ec member request rotations
	 */
	public void cacheResult(EcMemberRequestRotations ecMemberRequestRotations);

	/**
	 * Caches the ec member request rotationses in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestRotationses the ec member request rotationses
	 */
	public void cacheResult(
		java.util.List<EcMemberRequestRotations> ecMemberRequestRotationses);

	/**
	 * Creates a new ec member request rotations with the primary key. Does not add the ec member request rotations to the database.
	 *
	 * @param ecMemberRequestRotationsId the primary key for the new ec member request rotations
	 * @return the new ec member request rotations
	 */
	public EcMemberRequestRotations create(long ecMemberRequestRotationsId);

	/**
	 * Removes the ec member request rotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestRotationsId the primary key of the ec member request rotations
	 * @return the ec member request rotations that was removed
	 * @throws NoSuchEcMemberRequestRotationsException if a ec member request rotations with the primary key could not be found
	 */
	public EcMemberRequestRotations remove(long ecMemberRequestRotationsId)
		throws NoSuchEcMemberRequestRotationsException;

	public EcMemberRequestRotations updateImpl(
		EcMemberRequestRotations ecMemberRequestRotations);

	/**
	 * Returns the ec member request rotations with the primary key or throws a <code>NoSuchEcMemberRequestRotationsException</code> if it could not be found.
	 *
	 * @param ecMemberRequestRotationsId the primary key of the ec member request rotations
	 * @return the ec member request rotations
	 * @throws NoSuchEcMemberRequestRotationsException if a ec member request rotations with the primary key could not be found
	 */
	public EcMemberRequestRotations findByPrimaryKey(
			long ecMemberRequestRotationsId)
		throws NoSuchEcMemberRequestRotationsException;

	/**
	 * Returns the ec member request rotations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestRotationsId the primary key of the ec member request rotations
	 * @return the ec member request rotations, or <code>null</code> if a ec member request rotations with the primary key could not be found
	 */
	public EcMemberRequestRotations fetchByPrimaryKey(
		long ecMemberRequestRotationsId);

	/**
	 * Returns all the ec member request rotationses.
	 *
	 * @return the ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findAll();

	/**
	 * Returns a range of all the ec member request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @return the range of ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ec member request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator);

	/**
	 * Returns an ordered range of all the ec member request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member request rotationses
	 */
	public java.util.List<EcMemberRequestRotations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EcMemberRequestRotations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ec member request rotationses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ec member request rotationses.
	 *
	 * @return the number of ec member request rotationses
	 */
	public int countAll();

}
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

import gov.omsb.tms.exception.NoSuchParticipationTypeMasterException;
import gov.omsb.tms.model.ParticipationTypeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the participation type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ParticipationTypeMasterUtil
 * @generated
 */
@ProviderType
public interface ParticipationTypeMasterPersistence
	extends BasePersistence<ParticipationTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParticipationTypeMasterUtil} to access the participation type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the participation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching participation type masters
	 */
	public java.util.List<ParticipationTypeMaster> findByUuid(String uuid);

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
	public java.util.List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

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
	public java.util.List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public ParticipationTypeMaster[] findByUuid_PrevAndNext(
			long participationTypeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Removes all the participation type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of participation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching participation type masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchParticipationTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the participation type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the participation type master that was removed
	 */
	public ParticipationTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the number of participation type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching participation type masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching participation type masters
	 */
	public java.util.List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

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
	public java.util.List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

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
	public ParticipationTypeMaster[] findByUuid_C_PrevAndNext(
			long participationTypeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Removes all the participation type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching participation type masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the participation type masters where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching participation type masters
	 */
	public java.util.List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId);

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
	public java.util.List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end);

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
	public java.util.List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

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
	public java.util.List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster findByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the first participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster fetchByProgramDurationId_First(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

	/**
	 * Returns the last participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster findByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the last participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster fetchByProgramDurationId_Last(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public ParticipationTypeMaster[] findByProgramDurationId_PrevAndNext(
			long participationTypeMasterId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Removes all the participation type masters where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of participation type masters where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching participation type masters
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @return the matching participation type masters
	 */
	public java.util.List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId);

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
	public java.util.List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end);

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
	public java.util.List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator);

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
	public java.util.List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster
			findByParticipationTypeNameByLikeAndProgramDurationId_First(
				String participationTypeName, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the first participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster
		fetchByParticipationTypeNameByLikeAndProgramDurationId_First(
			String participationTypeName, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator);

	/**
	 * Returns the last participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster
			findByParticipationTypeNameByLikeAndProgramDurationId_Last(
				String participationTypeName, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the last participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	public ParticipationTypeMaster
		fetchByParticipationTypeNameByLikeAndProgramDurationId_Last(
			String participationTypeName, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ParticipationTypeMaster> orderByComparator);

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
	public ParticipationTypeMaster[]
			findByParticipationTypeNameByLikeAndProgramDurationId_PrevAndNext(
				long participationTypeMasterId, String participationTypeName,
				long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Removes all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63; from the database.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 */
	public void removeByParticipationTypeNameByLikeAndProgramDurationId(
		String participationTypeName, long programDurationId);

	/**
	 * Returns the number of participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @return the number of matching participation type masters
	 */
	public int countByParticipationTypeNameByLikeAndProgramDurationId(
		String participationTypeName, long programDurationId);

	/**
	 * Caches the participation type master in the entity cache if it is enabled.
	 *
	 * @param participationTypeMaster the participation type master
	 */
	public void cacheResult(ParticipationTypeMaster participationTypeMaster);

	/**
	 * Caches the participation type masters in the entity cache if it is enabled.
	 *
	 * @param participationTypeMasters the participation type masters
	 */
	public void cacheResult(
		java.util.List<ParticipationTypeMaster> participationTypeMasters);

	/**
	 * Creates a new participation type master with the primary key. Does not add the participation type master to the database.
	 *
	 * @param participationTypeMasterId the primary key for the new participation type master
	 * @return the new participation type master
	 */
	public ParticipationTypeMaster create(long participationTypeMasterId);

	/**
	 * Removes the participation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master that was removed
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public ParticipationTypeMaster remove(long participationTypeMasterId)
		throws NoSuchParticipationTypeMasterException;

	public ParticipationTypeMaster updateImpl(
		ParticipationTypeMaster participationTypeMaster);

	/**
	 * Returns the participation type master with the primary key or throws a <code>NoSuchParticipationTypeMasterException</code> if it could not be found.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	public ParticipationTypeMaster findByPrimaryKey(
			long participationTypeMasterId)
		throws NoSuchParticipationTypeMasterException;

	/**
	 * Returns the participation type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master, or <code>null</code> if a participation type master with the primary key could not be found
	 */
	public ParticipationTypeMaster fetchByPrimaryKey(
		long participationTypeMasterId);

	/**
	 * Returns all the participation type masters.
	 *
	 * @return the participation type masters
	 */
	public java.util.List<ParticipationTypeMaster> findAll();

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
	public java.util.List<ParticipationTypeMaster> findAll(int start, int end);

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
	public java.util.List<ParticipationTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator);

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
	public java.util.List<ParticipationTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ParticipationTypeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the participation type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of participation type masters.
	 *
	 * @return the number of participation type masters
	 */
	public int countAll();

}
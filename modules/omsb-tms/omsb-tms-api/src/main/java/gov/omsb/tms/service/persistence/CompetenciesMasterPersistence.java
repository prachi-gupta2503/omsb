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

import gov.omsb.tms.exception.NoSuchCompetenciesMasterException;
import gov.omsb.tms.model.CompetenciesMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the competencies master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompetenciesMasterUtil
 * @generated
 */
@ProviderType
public interface CompetenciesMasterPersistence
	extends BasePersistence<CompetenciesMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompetenciesMasterUtil} to access the competencies master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the competencies masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching competencies masters
	 */
	public java.util.List<CompetenciesMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of matching competencies masters
	 */
	public java.util.List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competencies masters
	 */
	public java.util.List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching competencies masters
	 */
	public java.util.List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public CompetenciesMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
				orderByComparator)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public CompetenciesMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator);

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public CompetenciesMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
				orderByComparator)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public CompetenciesMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator);

	/**
	 * Returns the competencies masters before and after the current competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param competenciesMasterId the primary key of the current competencies master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	public CompetenciesMaster[] findByUuid_PrevAndNext(
			long competenciesMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
				orderByComparator)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Removes all the competencies masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of competencies masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching competencies masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCompetenciesMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public CompetenciesMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public CompetenciesMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public CompetenciesMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the competencies master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the competencies master that was removed
	 */
	public CompetenciesMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Returns the number of competencies masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching competencies masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching competencies masters
	 */
	public java.util.List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of matching competencies masters
	 */
	public java.util.List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competencies masters
	 */
	public java.util.List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching competencies masters
	 */
	public java.util.List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public CompetenciesMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
				orderByComparator)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public CompetenciesMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator);

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public CompetenciesMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
				orderByComparator)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public CompetenciesMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator);

	/**
	 * Returns the competencies masters before and after the current competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param competenciesMasterId the primary key of the current competencies master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	public CompetenciesMaster[] findByUuid_C_PrevAndNext(
			long competenciesMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
				orderByComparator)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Removes all the competencies masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching competencies masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the competencies master in the entity cache if it is enabled.
	 *
	 * @param competenciesMaster the competencies master
	 */
	public void cacheResult(CompetenciesMaster competenciesMaster);

	/**
	 * Caches the competencies masters in the entity cache if it is enabled.
	 *
	 * @param competenciesMasters the competencies masters
	 */
	public void cacheResult(
		java.util.List<CompetenciesMaster> competenciesMasters);

	/**
	 * Creates a new competencies master with the primary key. Does not add the competencies master to the database.
	 *
	 * @param competenciesMasterId the primary key for the new competencies master
	 * @return the new competencies master
	 */
	public CompetenciesMaster create(long competenciesMasterId);

	/**
	 * Removes the competencies master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master that was removed
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	public CompetenciesMaster remove(long competenciesMasterId)
		throws NoSuchCompetenciesMasterException;

	public CompetenciesMaster updateImpl(CompetenciesMaster competenciesMaster);

	/**
	 * Returns the competencies master with the primary key or throws a <code>NoSuchCompetenciesMasterException</code> if it could not be found.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	public CompetenciesMaster findByPrimaryKey(long competenciesMasterId)
		throws NoSuchCompetenciesMasterException;

	/**
	 * Returns the competencies master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master, or <code>null</code> if a competencies master with the primary key could not be found
	 */
	public CompetenciesMaster fetchByPrimaryKey(long competenciesMasterId);

	/**
	 * Returns all the competencies masters.
	 *
	 * @return the competencies masters
	 */
	public java.util.List<CompetenciesMaster> findAll();

	/**
	 * Returns a range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of competencies masters
	 */
	public java.util.List<CompetenciesMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of competencies masters
	 */
	public java.util.List<CompetenciesMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of competencies masters
	 */
	public java.util.List<CompetenciesMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompetenciesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the competencies masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of competencies masters.
	 *
	 * @return the number of competencies masters
	 */
	public int countAll();

}
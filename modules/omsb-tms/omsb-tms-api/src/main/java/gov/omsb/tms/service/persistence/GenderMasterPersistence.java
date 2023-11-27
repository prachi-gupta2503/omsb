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

import gov.omsb.tms.exception.NoSuchGenderMasterException;
import gov.omsb.tms.model.GenderMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gender master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GenderMasterUtil
 * @generated
 */
@ProviderType
public interface GenderMasterPersistence extends BasePersistence<GenderMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GenderMasterUtil} to access the gender master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the gender masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching gender masters
	 */
	public java.util.List<GenderMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the gender masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @return the range of matching gender masters
	 */
	public java.util.List<GenderMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the gender masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gender masters
	 */
	public java.util.List<GenderMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the gender masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gender masters
	 */
	public java.util.List<GenderMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gender master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public GenderMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
				orderByComparator)
		throws NoSuchGenderMasterException;

	/**
	 * Returns the first gender master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public GenderMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator);

	/**
	 * Returns the last gender master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public GenderMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
				orderByComparator)
		throws NoSuchGenderMasterException;

	/**
	 * Returns the last gender master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public GenderMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator);

	/**
	 * Returns the gender masters before and after the current gender master in the ordered set where uuid = &#63;.
	 *
	 * @param genderMasterId the primary key of the current gender master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gender master
	 * @throws NoSuchGenderMasterException if a gender master with the primary key could not be found
	 */
	public GenderMaster[] findByUuid_PrevAndNext(
			long genderMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
				orderByComparator)
		throws NoSuchGenderMasterException;

	/**
	 * Removes all the gender masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of gender masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching gender masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the gender master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGenderMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public GenderMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchGenderMasterException;

	/**
	 * Returns the gender master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public GenderMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the gender master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public GenderMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the gender master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the gender master that was removed
	 */
	public GenderMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchGenderMasterException;

	/**
	 * Returns the number of gender masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching gender masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching gender masters
	 */
	public java.util.List<GenderMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @return the range of matching gender masters
	 */
	public java.util.List<GenderMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gender masters
	 */
	public java.util.List<GenderMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gender masters
	 */
	public java.util.List<GenderMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public GenderMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
				orderByComparator)
		throws NoSuchGenderMasterException;

	/**
	 * Returns the first gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public GenderMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator);

	/**
	 * Returns the last gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public GenderMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
				orderByComparator)
		throws NoSuchGenderMasterException;

	/**
	 * Returns the last gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public GenderMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator);

	/**
	 * Returns the gender masters before and after the current gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param genderMasterId the primary key of the current gender master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gender master
	 * @throws NoSuchGenderMasterException if a gender master with the primary key could not be found
	 */
	public GenderMaster[] findByUuid_C_PrevAndNext(
			long genderMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
				orderByComparator)
		throws NoSuchGenderMasterException;

	/**
	 * Removes all the gender masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching gender masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the gender master in the entity cache if it is enabled.
	 *
	 * @param genderMaster the gender master
	 */
	public void cacheResult(GenderMaster genderMaster);

	/**
	 * Caches the gender masters in the entity cache if it is enabled.
	 *
	 * @param genderMasters the gender masters
	 */
	public void cacheResult(java.util.List<GenderMaster> genderMasters);

	/**
	 * Creates a new gender master with the primary key. Does not add the gender master to the database.
	 *
	 * @param genderMasterId the primary key for the new gender master
	 * @return the new gender master
	 */
	public GenderMaster create(long genderMasterId);

	/**
	 * Removes the gender master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genderMasterId the primary key of the gender master
	 * @return the gender master that was removed
	 * @throws NoSuchGenderMasterException if a gender master with the primary key could not be found
	 */
	public GenderMaster remove(long genderMasterId)
		throws NoSuchGenderMasterException;

	public GenderMaster updateImpl(GenderMaster genderMaster);

	/**
	 * Returns the gender master with the primary key or throws a <code>NoSuchGenderMasterException</code> if it could not be found.
	 *
	 * @param genderMasterId the primary key of the gender master
	 * @return the gender master
	 * @throws NoSuchGenderMasterException if a gender master with the primary key could not be found
	 */
	public GenderMaster findByPrimaryKey(long genderMasterId)
		throws NoSuchGenderMasterException;

	/**
	 * Returns the gender master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genderMasterId the primary key of the gender master
	 * @return the gender master, or <code>null</code> if a gender master with the primary key could not be found
	 */
	public GenderMaster fetchByPrimaryKey(long genderMasterId);

	/**
	 * Returns all the gender masters.
	 *
	 * @return the gender masters
	 */
	public java.util.List<GenderMaster> findAll();

	/**
	 * Returns a range of all the gender masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @return the range of gender masters
	 */
	public java.util.List<GenderMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the gender masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gender masters
	 */
	public java.util.List<GenderMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the gender masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gender masters
	 */
	public java.util.List<GenderMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GenderMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gender masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gender masters.
	 *
	 * @return the number of gender masters
	 */
	public int countAll();

}
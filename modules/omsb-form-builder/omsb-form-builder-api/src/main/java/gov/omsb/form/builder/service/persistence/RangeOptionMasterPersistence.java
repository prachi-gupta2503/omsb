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

package gov.omsb.form.builder.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import gov.omsb.form.builder.exception.NoSuchRangeOptionMasterException;
import gov.omsb.form.builder.model.RangeOptionMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the range option master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RangeOptionMasterUtil
 * @generated
 */
@ProviderType
public interface RangeOptionMasterPersistence
	extends BasePersistence<RangeOptionMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RangeOptionMasterUtil} to access the range option master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the range option masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching range option masters
	 */
	public java.util.List<RangeOptionMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the range option masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @return the range of matching range option masters
	 */
	public java.util.List<RangeOptionMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the range option masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching range option masters
	 */
	public java.util.List<RangeOptionMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the range option masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching range option masters
	 */
	public java.util.List<RangeOptionMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first range option master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public RangeOptionMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
				orderByComparator)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Returns the first range option master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public RangeOptionMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator);

	/**
	 * Returns the last range option master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public RangeOptionMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
				orderByComparator)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Returns the last range option master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public RangeOptionMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator);

	/**
	 * Returns the range option masters before and after the current range option master in the ordered set where uuid = &#63;.
	 *
	 * @param rangeOptionId the primary key of the current range option master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next range option master
	 * @throws NoSuchRangeOptionMasterException if a range option master with the primary key could not be found
	 */
	public RangeOptionMaster[] findByUuid_PrevAndNext(
			long rangeOptionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
				orderByComparator)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Removes all the range option masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of range option masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching range option masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the range option master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRangeOptionMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public RangeOptionMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Returns the range option master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public RangeOptionMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the range option master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public RangeOptionMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the range option master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the range option master that was removed
	 */
	public RangeOptionMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Returns the number of range option masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching range option masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching range option masters
	 */
	public java.util.List<RangeOptionMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @return the range of matching range option masters
	 */
	public java.util.List<RangeOptionMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching range option masters
	 */
	public java.util.List<RangeOptionMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching range option masters
	 */
	public java.util.List<RangeOptionMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public RangeOptionMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
				orderByComparator)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Returns the first range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public RangeOptionMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator);

	/**
	 * Returns the last range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public RangeOptionMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
				orderByComparator)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Returns the last range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public RangeOptionMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator);

	/**
	 * Returns the range option masters before and after the current range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rangeOptionId the primary key of the current range option master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next range option master
	 * @throws NoSuchRangeOptionMasterException if a range option master with the primary key could not be found
	 */
	public RangeOptionMaster[] findByUuid_C_PrevAndNext(
			long rangeOptionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
				orderByComparator)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Removes all the range option masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching range option masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the range option master in the entity cache if it is enabled.
	 *
	 * @param rangeOptionMaster the range option master
	 */
	public void cacheResult(RangeOptionMaster rangeOptionMaster);

	/**
	 * Caches the range option masters in the entity cache if it is enabled.
	 *
	 * @param rangeOptionMasters the range option masters
	 */
	public void cacheResult(
		java.util.List<RangeOptionMaster> rangeOptionMasters);

	/**
	 * Creates a new range option master with the primary key. Does not add the range option master to the database.
	 *
	 * @param rangeOptionId the primary key for the new range option master
	 * @return the new range option master
	 */
	public RangeOptionMaster create(long rangeOptionId);

	/**
	 * Removes the range option master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rangeOptionId the primary key of the range option master
	 * @return the range option master that was removed
	 * @throws NoSuchRangeOptionMasterException if a range option master with the primary key could not be found
	 */
	public RangeOptionMaster remove(long rangeOptionId)
		throws NoSuchRangeOptionMasterException;

	public RangeOptionMaster updateImpl(RangeOptionMaster rangeOptionMaster);

	/**
	 * Returns the range option master with the primary key or throws a <code>NoSuchRangeOptionMasterException</code> if it could not be found.
	 *
	 * @param rangeOptionId the primary key of the range option master
	 * @return the range option master
	 * @throws NoSuchRangeOptionMasterException if a range option master with the primary key could not be found
	 */
	public RangeOptionMaster findByPrimaryKey(long rangeOptionId)
		throws NoSuchRangeOptionMasterException;

	/**
	 * Returns the range option master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rangeOptionId the primary key of the range option master
	 * @return the range option master, or <code>null</code> if a range option master with the primary key could not be found
	 */
	public RangeOptionMaster fetchByPrimaryKey(long rangeOptionId);

	/**
	 * Returns all the range option masters.
	 *
	 * @return the range option masters
	 */
	public java.util.List<RangeOptionMaster> findAll();

	/**
	 * Returns a range of all the range option masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @return the range of range option masters
	 */
	public java.util.List<RangeOptionMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the range option masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of range option masters
	 */
	public java.util.List<RangeOptionMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the range option masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of range option masters
	 */
	public java.util.List<RangeOptionMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RangeOptionMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the range option masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of range option masters.
	 *
	 * @return the number of range option masters
	 */
	public int countAll();

}
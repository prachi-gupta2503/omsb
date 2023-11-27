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

import gov.omsb.tms.exception.NoSuchTraineeLevelMasterException;
import gov.omsb.tms.model.TraineeLevelMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trainee level master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLevelMasterUtil
 * @generated
 */
@ProviderType
public interface TraineeLevelMasterPersistence
	extends BasePersistence<TraineeLevelMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraineeLevelMasterUtil} to access the trainee level master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainee level masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the trainee level masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trainee level masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee level masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the first trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns the last trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the last trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns the trainee level masters before and after the current trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param traineeLevelMasterId the primary key of the current trainee level master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	public TraineeLevelMaster[] findByUuid_PrevAndNext(
			long traineeLevelMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Removes all the trainee level masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainee level masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee level masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trainee level master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeLevelMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the trainee level master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the trainee level master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trainee level master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee level master that was removed
	 */
	public TraineeLevelMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the number of trainee level masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee level masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the first trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns the last trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the last trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns the trainee level masters before and after the current trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeLevelMasterId the primary key of the current trainee level master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	public TraineeLevelMaster[] findByUuid_C_PrevAndNext(
			long traineeLevelMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Removes all the trainee level masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee level masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @return the matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findBytraineeLevelNameByLike(
		String traineeLevelName);

	/**
	 * Returns a range of all the trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelName the trainee level name
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findBytraineeLevelNameByLike(
		String traineeLevelName, int start, int end);

	/**
	 * Returns an ordered range of all the trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelName the trainee level name
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findBytraineeLevelNameByLike(
		String traineeLevelName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelName the trainee level name
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findBytraineeLevelNameByLike(
		String traineeLevelName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster findBytraineeLevelNameByLike_First(
			String traineeLevelName,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the first trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster fetchBytraineeLevelNameByLike_First(
		String traineeLevelName,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns the last trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster findBytraineeLevelNameByLike_Last(
			String traineeLevelName,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the last trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	public TraineeLevelMaster fetchBytraineeLevelNameByLike_Last(
		String traineeLevelName,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns the trainee level masters before and after the current trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelMasterId the primary key of the current trainee level master
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	public TraineeLevelMaster[] findBytraineeLevelNameByLike_PrevAndNext(
			long traineeLevelMasterId, String traineeLevelName,
			com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
				orderByComparator)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Removes all the trainee level masters where traineeLevelName LIKE &#63; from the database.
	 *
	 * @param traineeLevelName the trainee level name
	 */
	public void removeBytraineeLevelNameByLike(String traineeLevelName);

	/**
	 * Returns the number of trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @return the number of matching trainee level masters
	 */
	public int countBytraineeLevelNameByLike(String traineeLevelName);

	/**
	 * Caches the trainee level master in the entity cache if it is enabled.
	 *
	 * @param traineeLevelMaster the trainee level master
	 */
	public void cacheResult(TraineeLevelMaster traineeLevelMaster);

	/**
	 * Caches the trainee level masters in the entity cache if it is enabled.
	 *
	 * @param traineeLevelMasters the trainee level masters
	 */
	public void cacheResult(
		java.util.List<TraineeLevelMaster> traineeLevelMasters);

	/**
	 * Creates a new trainee level master with the primary key. Does not add the trainee level master to the database.
	 *
	 * @param traineeLevelMasterId the primary key for the new trainee level master
	 * @return the new trainee level master
	 */
	public TraineeLevelMaster create(long traineeLevelMasterId);

	/**
	 * Removes the trainee level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master that was removed
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	public TraineeLevelMaster remove(long traineeLevelMasterId)
		throws NoSuchTraineeLevelMasterException;

	public TraineeLevelMaster updateImpl(TraineeLevelMaster traineeLevelMaster);

	/**
	 * Returns the trainee level master with the primary key or throws a <code>NoSuchTraineeLevelMasterException</code> if it could not be found.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	public TraineeLevelMaster findByPrimaryKey(long traineeLevelMasterId)
		throws NoSuchTraineeLevelMasterException;

	/**
	 * Returns the trainee level master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master, or <code>null</code> if a trainee level master with the primary key could not be found
	 */
	public TraineeLevelMaster fetchByPrimaryKey(long traineeLevelMasterId);

	/**
	 * Returns all the trainee level masters.
	 *
	 * @return the trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findAll();

	/**
	 * Returns a range of all the trainee level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the trainee level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee level masters
	 */
	public java.util.List<TraineeLevelMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeLevelMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainee level masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainee level masters.
	 *
	 * @return the number of trainee level masters
	 */
	public int countAll();

}
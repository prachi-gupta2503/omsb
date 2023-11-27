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

import gov.omsb.tms.exception.NoSuchTrainingSitesMasterException;
import gov.omsb.tms.model.TrainingSitesMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the training sites master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSitesMasterUtil
 * @generated
 */
@ProviderType
public interface TrainingSitesMasterPersistence
	extends BasePersistence<TrainingSitesMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrainingSitesMasterUtil} to access the training sites master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the training sites masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public TrainingSitesMaster[] findByUuid_PrevAndNext(
			long trainingSiteMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Removes all the training sites masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of training sites masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching training sites masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTrainingSitesMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the training sites master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the training sites master that was removed
	 */
	public TrainingSitesMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the number of training sites masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching training sites masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public TrainingSitesMaster[] findByUuid_C_PrevAndNext(
			long trainingSiteMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Removes all the training sites masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching training sites masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @return the matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus);

	/**
	 * Returns a range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end);

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByTrainingSiteStatus_First(
			Boolean trainingSiteStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByTrainingSiteStatus_First(
		Boolean trainingSiteStatus,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByTrainingSiteStatus_Last(
			Boolean trainingSiteStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByTrainingSiteStatus_Last(
		Boolean trainingSiteStatus,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public TrainingSitesMaster[] findByTrainingSiteStatus_PrevAndNext(
			long trainingSiteMasterId, Boolean trainingSiteStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Removes all the training sites masters where trainingSiteStatus = &#63; from the database.
	 *
	 * @param trainingSiteStatus the training site status
	 */
	public void removeByTrainingSiteStatus(Boolean trainingSiteStatus);

	/**
	 * Returns the number of training sites masters where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @return the number of matching training sites masters
	 */
	public int countByTrainingSiteStatus(Boolean trainingSiteStatus);

	/**
	 * Returns all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @return the matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName);

	/**
	 * Returns a range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end);

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByTrainingSiteNameByLike_First(
			String trainingSiteName,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByTrainingSiteNameByLike_First(
		String trainingSiteName,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByTrainingSiteNameByLike_Last(
			String trainingSiteName,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByTrainingSiteNameByLike_Last(
		String trainingSiteName,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public TrainingSitesMaster[] findByTrainingSiteNameByLike_PrevAndNext(
			long trainingSiteMasterId, String trainingSiteName,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Removes all the training sites masters where trainingSiteName LIKE &#63; from the database.
	 *
	 * @param trainingSiteName the training site name
	 */
	public void removeByTrainingSiteNameByLike(String trainingSiteName);

	/**
	 * Returns the number of training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @return the number of matching training sites masters
	 */
	public int countByTrainingSiteNameByLike(String trainingSiteName);

	/**
	 * Returns all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @return the matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode);

	/**
	 * Returns a range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end);

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByTrainingSiteCodeByLike_First(
			String trainingSiteCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByTrainingSiteCodeByLike_First(
		String trainingSiteCode,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public TrainingSitesMaster findByTrainingSiteCodeByLike_Last(
			String trainingSiteCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public TrainingSitesMaster fetchByTrainingSiteCodeByLike_Last(
		String trainingSiteCode,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public TrainingSitesMaster[] findByTrainingSiteCodeByLike_PrevAndNext(
			long trainingSiteMasterId, String trainingSiteCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Removes all the training sites masters where trainingSiteCode LIKE &#63; from the database.
	 *
	 * @param trainingSiteCode the training site code
	 */
	public void removeByTrainingSiteCodeByLike(String trainingSiteCode);

	/**
	 * Returns the number of training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @return the number of matching training sites masters
	 */
	public int countByTrainingSiteCodeByLike(String trainingSiteCode);

	/**
	 * Caches the training sites master in the entity cache if it is enabled.
	 *
	 * @param trainingSitesMaster the training sites master
	 */
	public void cacheResult(TrainingSitesMaster trainingSitesMaster);

	/**
	 * Caches the training sites masters in the entity cache if it is enabled.
	 *
	 * @param trainingSitesMasters the training sites masters
	 */
	public void cacheResult(
		java.util.List<TrainingSitesMaster> trainingSitesMasters);

	/**
	 * Creates a new training sites master with the primary key. Does not add the training sites master to the database.
	 *
	 * @param trainingSiteMasterId the primary key for the new training sites master
	 * @return the new training sites master
	 */
	public TrainingSitesMaster create(long trainingSiteMasterId);

	/**
	 * Removes the training sites master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master that was removed
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public TrainingSitesMaster remove(long trainingSiteMasterId)
		throws NoSuchTrainingSitesMasterException;

	public TrainingSitesMaster updateImpl(
		TrainingSitesMaster trainingSitesMaster);

	/**
	 * Returns the training sites master with the primary key or throws a <code>NoSuchTrainingSitesMasterException</code> if it could not be found.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public TrainingSitesMaster findByPrimaryKey(long trainingSiteMasterId)
		throws NoSuchTrainingSitesMasterException;

	/**
	 * Returns the training sites master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master, or <code>null</code> if a training sites master with the primary key could not be found
	 */
	public TrainingSitesMaster fetchByPrimaryKey(long trainingSiteMasterId);

	/**
	 * Returns all the training sites masters.
	 *
	 * @return the training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findAll();

	/**
	 * Returns a range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of training sites masters
	 */
	public java.util.List<TrainingSitesMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSitesMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the training sites masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of training sites masters.
	 *
	 * @return the number of training sites masters
	 */
	public int countAll();

}
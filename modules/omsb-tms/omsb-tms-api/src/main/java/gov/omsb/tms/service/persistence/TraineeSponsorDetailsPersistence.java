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

import gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException;
import gov.omsb.tms.model.TraineeSponsorDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trainee sponsor details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeSponsorDetailsUtil
 * @generated
 */
@ProviderType
public interface TraineeSponsorDetailsPersistence
	extends BasePersistence<TraineeSponsorDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraineeSponsorDetailsUtil} to access the trainee sponsor details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of matching trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator);

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator);

	/**
	 * Returns the trainee sponsor detailses before and after the current trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeSponsorDetailsId the primary key of the current trainee sponsor details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	public TraineeSponsorDetails[] findByUuid_PrevAndNext(
			long traineeSponsorDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Removes all the trainee sponsor detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee sponsor detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trainee sponsor details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee sponsor details that was removed
	 */
	public TraineeSponsorDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee sponsor detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of matching trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator);

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator);

	/**
	 * Returns the trainee sponsor detailses before and after the current trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeSponsorDetailsId the primary key of the current trainee sponsor details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	public TraineeSponsorDetails[] findByUuid_C_PrevAndNext(
			long traineeSponsorDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Removes all the trainee sponsor detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee sponsor detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails findBytraineeId(long traineeId)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails fetchBytraineeId(long traineeId);

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public TraineeSponsorDetails fetchBytraineeId(
		long traineeId, boolean useFinderCache);

	/**
	 * Removes the trainee sponsor details where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the trainee sponsor details that was removed
	 */
	public TraineeSponsorDetails removeBytraineeId(long traineeId)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the number of trainee sponsor detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee sponsor detailses
	 */
	public int countBytraineeId(long traineeId);

	/**
	 * Caches the trainee sponsor details in the entity cache if it is enabled.
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 */
	public void cacheResult(TraineeSponsorDetails traineeSponsorDetails);

	/**
	 * Caches the trainee sponsor detailses in the entity cache if it is enabled.
	 *
	 * @param traineeSponsorDetailses the trainee sponsor detailses
	 */
	public void cacheResult(
		java.util.List<TraineeSponsorDetails> traineeSponsorDetailses);

	/**
	 * Creates a new trainee sponsor details with the primary key. Does not add the trainee sponsor details to the database.
	 *
	 * @param traineeSponsorDetailsId the primary key for the new trainee sponsor details
	 * @return the new trainee sponsor details
	 */
	public TraineeSponsorDetails create(long traineeSponsorDetailsId);

	/**
	 * Removes the trainee sponsor details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details that was removed
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	public TraineeSponsorDetails remove(long traineeSponsorDetailsId)
		throws NoSuchTraineeSponsorDetailsException;

	public TraineeSponsorDetails updateImpl(
		TraineeSponsorDetails traineeSponsorDetails);

	/**
	 * Returns the trainee sponsor details with the primary key or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	public TraineeSponsorDetails findByPrimaryKey(long traineeSponsorDetailsId)
		throws NoSuchTraineeSponsorDetailsException;

	/**
	 * Returns the trainee sponsor details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details, or <code>null</code> if a trainee sponsor details with the primary key could not be found
	 */
	public TraineeSponsorDetails fetchByPrimaryKey(
		long traineeSponsorDetailsId);

	/**
	 * Returns all the trainee sponsor detailses.
	 *
	 * @return the trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findAll();

	/**
	 * Returns a range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee sponsor detailses
	 */
	public java.util.List<TraineeSponsorDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeSponsorDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainee sponsor detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainee sponsor detailses.
	 *
	 * @return the number of trainee sponsor detailses
	 */
	public int countAll();

}
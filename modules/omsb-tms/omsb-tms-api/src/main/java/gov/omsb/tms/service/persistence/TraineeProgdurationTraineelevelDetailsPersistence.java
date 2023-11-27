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

import gov.omsb.tms.exception.NoSuchTraineeProgdurationTraineelevelDetailsException;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trainee progduration traineelevel details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeProgdurationTraineelevelDetailsUtil
 * @generated
 */
@ProviderType
public interface TraineeProgdurationTraineelevelDetailsPersistence
	extends BasePersistence<TraineeProgdurationTraineelevelDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraineeProgdurationTraineelevelDetailsUtil} to access the trainee progduration traineelevel details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public TraineeProgdurationTraineelevelDetails[] findByUuid_PrevAndNext(
			long traineePdTlErDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Removes all the trainee progduration traineelevel detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails findByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee progduration traineelevel details that was removed
	 */
	public TraineeProgdurationTraineelevelDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public TraineeProgdurationTraineelevelDetails[] findByUuid_C_PrevAndNext(
			long traineePdTlErDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Removes all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails>
		findByTraineeId(long traineeId);

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails>
		findByTraineeId(long traineeId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails>
		findByTraineeId(
			long traineeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails>
		findByTraineeId(
			long traineeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails findByTraineeId_First(
			long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByTraineeId_First(
		long traineeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails findByTraineeId_Last(
			long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByTraineeId_Last(
		long traineeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public TraineeProgdurationTraineelevelDetails[] findByTraineeId_PrevAndNext(
			long traineePdTlErDetailsId, long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Removes all the trainee progduration traineelevel detailses where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	public void removeByTraineeId(long traineeId);

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public int countByTraineeId(long traineeId);

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndTraineeLevelId(
				long traineeId, long traineeLevelId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndTraineeLevelId(long traineeId, long traineeLevelId);

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndTraineeLevelId(
			long traineeId, long traineeLevelId, boolean useFinderCache);

	/**
	 * Removes the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the trainee progduration traineelevel details that was removed
	 */
	public TraineeProgdurationTraineelevelDetails
			removeByTraineeIdAndTraineeLevelId(
				long traineeId, long traineeLevelId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public int countByTraineeIdAndTraineeLevelId(
		long traineeId, long traineeLevelId);

	/**
	 * Returns all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId);

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndProgramDurationId_First(
				long traineeId, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndProgramDurationId_First(
			long traineeId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndProgramDurationId_Last(
				long traineeId, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndProgramDurationId_Last(
			long traineeId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public TraineeProgdurationTraineelevelDetails[]
			findByTraineeIdAndProgramDurationId_PrevAndNext(
				long traineePdTlErDetailsId, long traineeId,
				long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeProgdurationTraineelevelDetails> orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Removes all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 */
	public void removeByTraineeIdAndProgramDurationId(
		long traineeId, long programDurationId);

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public int countByTraineeIdAndProgramDurationId(
		long traineeId, long programDurationId);

	/**
	 * Caches the trainee progduration traineelevel details in the entity cache if it is enabled.
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 */
	public void cacheResult(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails);

	/**
	 * Caches the trainee progduration traineelevel detailses in the entity cache if it is enabled.
	 *
	 * @param traineeProgdurationTraineelevelDetailses the trainee progduration traineelevel detailses
	 */
	public void cacheResult(
		java.util.List<TraineeProgdurationTraineelevelDetails>
			traineeProgdurationTraineelevelDetailses);

	/**
	 * Creates a new trainee progduration traineelevel details with the primary key. Does not add the trainee progduration traineelevel details to the database.
	 *
	 * @param traineePdTlErDetailsId the primary key for the new trainee progduration traineelevel details
	 * @return the new trainee progduration traineelevel details
	 */
	public TraineeProgdurationTraineelevelDetails create(
		long traineePdTlErDetailsId);

	/**
	 * Removes the trainee progduration traineelevel details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was removed
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public TraineeProgdurationTraineelevelDetails remove(
			long traineePdTlErDetailsId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	public TraineeProgdurationTraineelevelDetails updateImpl(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails);

	/**
	 * Returns the trainee progduration traineelevel details with the primary key or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public TraineeProgdurationTraineelevelDetails findByPrimaryKey(
			long traineePdTlErDetailsId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException;

	/**
	 * Returns the trainee progduration traineelevel details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details, or <code>null</code> if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public TraineeProgdurationTraineelevelDetails fetchByPrimaryKey(
		long traineePdTlErDetailsId);

	/**
	 * Returns all the trainee progduration traineelevel detailses.
	 *
	 * @return the trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findAll();

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee progduration traineelevel detailses
	 */
	public java.util.List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeProgdurationTraineelevelDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainee progduration traineelevel detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainee progduration traineelevel detailses.
	 *
	 * @return the number of trainee progduration traineelevel detailses
	 */
	public int countAll();

}
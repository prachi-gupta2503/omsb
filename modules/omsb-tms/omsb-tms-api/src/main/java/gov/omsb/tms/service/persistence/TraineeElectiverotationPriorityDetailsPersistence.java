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

import gov.omsb.tms.exception.NoSuchTraineeElectiverotationPriorityDetailsException;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trainee electiverotation priority details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeElectiverotationPriorityDetailsUtil
 * @generated
 */
@ProviderType
public interface TraineeElectiverotationPriorityDetailsPersistence
	extends BasePersistence<TraineeElectiverotationPriorityDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraineeElectiverotationPriorityDetailsUtil} to access the trainee electiverotation priority details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public TraineeElectiverotationPriorityDetails[] findByUuid_PrevAndNext(
			long traineeElectiverotationPriorityDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Removes all the trainee electiverotation priority detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeElectiverotationPriorityDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails findByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee electiverotation priority details that was removed
	 */
	public TraineeElectiverotationPriorityDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public TraineeElectiverotationPriorityDetails[] findByUuid_C_PrevAndNext(
			long traineeElectiverotationPriorityDetailsId, String uuid,
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Removes all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @return the matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(long traineePdTlErDetailsId);

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails
			findByTraineePdTlErDetailsId_First(
				long traineePdTlErDetailsId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails
		fetchByTraineePdTlErDetailsId_First(
			long traineePdTlErDetailsId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails
			findByTraineePdTlErDetailsId_Last(
				long traineePdTlErDetailsId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public TraineeElectiverotationPriorityDetails
		fetchByTraineePdTlErDetailsId_Last(
			long traineePdTlErDetailsId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public TraineeElectiverotationPriorityDetails[]
			findByTraineePdTlErDetailsId_PrevAndNext(
				long traineeElectiverotationPriorityDetailsId,
				long traineePdTlErDetailsId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeElectiverotationPriorityDetails> orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Removes all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63; from the database.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 */
	public void removeByTraineePdTlErDetailsId(long traineePdTlErDetailsId);

	/**
	 * Returns the number of trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	public int countByTraineePdTlErDetailsId(long traineePdTlErDetailsId);

	/**
	 * Caches the trainee electiverotation priority details in the entity cache if it is enabled.
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 */
	public void cacheResult(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails);

	/**
	 * Caches the trainee electiverotation priority detailses in the entity cache if it is enabled.
	 *
	 * @param traineeElectiverotationPriorityDetailses the trainee electiverotation priority detailses
	 */
	public void cacheResult(
		java.util.List<TraineeElectiverotationPriorityDetails>
			traineeElectiverotationPriorityDetailses);

	/**
	 * Creates a new trainee electiverotation priority details with the primary key. Does not add the trainee electiverotation priority details to the database.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key for the new trainee electiverotation priority details
	 * @return the new trainee electiverotation priority details
	 */
	public TraineeElectiverotationPriorityDetails create(
		long traineeElectiverotationPriorityDetailsId);

	/**
	 * Removes the trainee electiverotation priority details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was removed
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public TraineeElectiverotationPriorityDetails remove(
			long traineeElectiverotationPriorityDetailsId)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	public TraineeElectiverotationPriorityDetails updateImpl(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails);

	/**
	 * Returns the trainee electiverotation priority details with the primary key or throws a <code>NoSuchTraineeElectiverotationPriorityDetailsException</code> if it could not be found.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public TraineeElectiverotationPriorityDetails findByPrimaryKey(
			long traineeElectiverotationPriorityDetailsId)
		throws NoSuchTraineeElectiverotationPriorityDetailsException;

	/**
	 * Returns the trainee electiverotation priority details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details, or <code>null</code> if a trainee electiverotation priority details with the primary key could not be found
	 */
	public TraineeElectiverotationPriorityDetails fetchByPrimaryKey(
		long traineeElectiverotationPriorityDetailsId);

	/**
	 * Returns all the trainee electiverotation priority detailses.
	 *
	 * @return the trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findAll();

	/**
	 * Returns a range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee electiverotation priority detailses
	 */
	public java.util.List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeElectiverotationPriorityDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainee electiverotation priority detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainee electiverotation priority detailses.
	 *
	 * @return the number of trainee electiverotation priority detailses
	 */
	public int countAll();

}
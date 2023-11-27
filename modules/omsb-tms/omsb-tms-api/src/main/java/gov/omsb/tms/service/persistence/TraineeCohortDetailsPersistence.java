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

import gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException;
import gov.omsb.tms.model.TraineeCohortDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trainee cohort details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeCohortDetailsUtil
 * @generated
 */
@ProviderType
public interface TraineeCohortDetailsPersistence
	extends BasePersistence<TraineeCohortDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraineeCohortDetailsUtil} to access the trainee cohort details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainee cohort detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public TraineeCohortDetails[] findByUuid_PrevAndNext(
			long traineeCohortDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Removes all the trainee cohort detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee cohort detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trainee cohort details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee cohort details that was removed
	 */
	public TraineeCohortDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee cohort detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public TraineeCohortDetails[] findByUuid_C_PrevAndNext(
			long traineeCohortDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Removes all the trainee cohort detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee cohort detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId);

	/**
	 * Returns a range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
				long traineeAdmissionDetailsRelId, String cohortYear,
				long traineeLevelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator);

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
				long traineeAdmissionDetailsRelId, String cohortYear,
				long traineeLevelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator);

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public TraineeCohortDetails[]
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_PrevAndNext(
				long traineeCohortDetailsId, long traineeAdmissionDetailsRelId,
				String cohortYear, long traineeLevelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Removes all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 */
	public void
		removeByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId);

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching trainee cohort detailses
	 */
	public int
		countByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId);

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				long traineeAdmissionDetailsRelId,
				Boolean isCurrentTraineeLevel)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel);

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel,
			boolean useFinderCache);

	/**
	 * Removes the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the trainee cohort details that was removed
	 */
	public TraineeCohortDetails
			removeByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				long traineeAdmissionDetailsRelId,
				Boolean isCurrentTraineeLevel)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the number of matching trainee cohort detailses
	 */
	public int countByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
		long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel);

	/**
	 * Returns all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @return the matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelId(long traineeAdmissionDetailsRelId);

	/**
	 * Returns a range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelId(
			long traineeAdmissionDetailsRelId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelId(
			long traineeAdmissionDetailsRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelId(
			long traineeAdmissionDetailsRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails findByTraineeAdmissionDetailsRelId_First(
			long traineeAdmissionDetailsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails fetchByTraineeAdmissionDetailsRelId_First(
		long traineeAdmissionDetailsRelId,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails findByTraineeAdmissionDetailsRelId_Last(
			long traineeAdmissionDetailsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public TraineeCohortDetails fetchByTraineeAdmissionDetailsRelId_Last(
		long traineeAdmissionDetailsRelId,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public TraineeCohortDetails[]
			findByTraineeAdmissionDetailsRelId_PrevAndNext(
				long traineeCohortDetailsId, long traineeAdmissionDetailsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Removes all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 */
	public void removeByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId);

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @return the number of matching trainee cohort detailses
	 */
	public int countByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId);

	/**
	 * Caches the trainee cohort details in the entity cache if it is enabled.
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 */
	public void cacheResult(TraineeCohortDetails traineeCohortDetails);

	/**
	 * Caches the trainee cohort detailses in the entity cache if it is enabled.
	 *
	 * @param traineeCohortDetailses the trainee cohort detailses
	 */
	public void cacheResult(
		java.util.List<TraineeCohortDetails> traineeCohortDetailses);

	/**
	 * Creates a new trainee cohort details with the primary key. Does not add the trainee cohort details to the database.
	 *
	 * @param traineeCohortDetailsId the primary key for the new trainee cohort details
	 * @return the new trainee cohort details
	 */
	public TraineeCohortDetails create(long traineeCohortDetailsId);

	/**
	 * Removes the trainee cohort details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details that was removed
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public TraineeCohortDetails remove(long traineeCohortDetailsId)
		throws NoSuchTraineeCohortDetailsException;

	public TraineeCohortDetails updateImpl(
		TraineeCohortDetails traineeCohortDetails);

	/**
	 * Returns the trainee cohort details with the primary key or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public TraineeCohortDetails findByPrimaryKey(long traineeCohortDetailsId)
		throws NoSuchTraineeCohortDetailsException;

	/**
	 * Returns the trainee cohort details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details, or <code>null</code> if a trainee cohort details with the primary key could not be found
	 */
	public TraineeCohortDetails fetchByPrimaryKey(long traineeCohortDetailsId);

	/**
	 * Returns all the trainee cohort detailses.
	 *
	 * @return the trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findAll();

	/**
	 * Returns a range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee cohort detailses
	 */
	public java.util.List<TraineeCohortDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraineeCohortDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainee cohort detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainee cohort detailses.
	 *
	 * @return the number of trainee cohort detailses
	 */
	public int countAll();

}
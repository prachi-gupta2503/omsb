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

import gov.omsb.tms.exception.NoSuchFacultyBankDetailsException;
import gov.omsb.tms.model.FacultyBankDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faculty bank details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyBankDetailsUtil
 * @generated
 */
@ProviderType
public interface FacultyBankDetailsPersistence
	extends BasePersistence<FacultyBankDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyBankDetailsUtil} to access the faculty bank details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faculty bank detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the faculty bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @return the range of matching faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the faculty bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
				orderByComparator)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the first faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator);

	/**
	 * Returns the last faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
				orderByComparator)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the last faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator);

	/**
	 * Returns the faculty bank detailses before and after the current faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param facultyBankDetailsId the primary key of the current faculty bank details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a faculty bank details with the primary key could not be found
	 */
	public FacultyBankDetails[] findByUuid_PrevAndNext(
			long facultyBankDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
				orderByComparator)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Removes all the faculty bank detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of faculty bank detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty bank detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the faculty bank details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyBankDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the faculty bank details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the faculty bank details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the faculty bank details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty bank details that was removed
	 */
	public FacultyBankDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the number of faculty bank detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty bank detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @return the range of matching faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
				orderByComparator)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the first faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator);

	/**
	 * Returns the last faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
				orderByComparator)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the last faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator);

	/**
	 * Returns the faculty bank detailses before and after the current faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyBankDetailsId the primary key of the current faculty bank details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a faculty bank details with the primary key could not be found
	 */
	public FacultyBankDetails[] findByUuid_C_PrevAndNext(
			long facultyBankDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
				orderByComparator)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Removes all the faculty bank detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty bank detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the faculty bank details where facultyRequestId = &#63; or throws a <code>NoSuchFacultyBankDetailsException</code> if it could not be found.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails findByfacultyRequestId(long facultyRequestId)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the faculty bank details where facultyRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails fetchByfacultyRequestId(long facultyRequestId);

	/**
	 * Returns the faculty bank details where facultyRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public FacultyBankDetails fetchByfacultyRequestId(
		long facultyRequestId, boolean useFinderCache);

	/**
	 * Removes the faculty bank details where facultyRequestId = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the faculty bank details that was removed
	 */
	public FacultyBankDetails removeByfacultyRequestId(long facultyRequestId)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the number of faculty bank detailses where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the number of matching faculty bank detailses
	 */
	public int countByfacultyRequestId(long facultyRequestId);

	/**
	 * Caches the faculty bank details in the entity cache if it is enabled.
	 *
	 * @param facultyBankDetails the faculty bank details
	 */
	public void cacheResult(FacultyBankDetails facultyBankDetails);

	/**
	 * Caches the faculty bank detailses in the entity cache if it is enabled.
	 *
	 * @param facultyBankDetailses the faculty bank detailses
	 */
	public void cacheResult(
		java.util.List<FacultyBankDetails> facultyBankDetailses);

	/**
	 * Creates a new faculty bank details with the primary key. Does not add the faculty bank details to the database.
	 *
	 * @param facultyBankDetailsId the primary key for the new faculty bank details
	 * @return the new faculty bank details
	 */
	public FacultyBankDetails create(long facultyBankDetailsId);

	/**
	 * Removes the faculty bank details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyBankDetailsId the primary key of the faculty bank details
	 * @return the faculty bank details that was removed
	 * @throws NoSuchFacultyBankDetailsException if a faculty bank details with the primary key could not be found
	 */
	public FacultyBankDetails remove(long facultyBankDetailsId)
		throws NoSuchFacultyBankDetailsException;

	public FacultyBankDetails updateImpl(FacultyBankDetails facultyBankDetails);

	/**
	 * Returns the faculty bank details with the primary key or throws a <code>NoSuchFacultyBankDetailsException</code> if it could not be found.
	 *
	 * @param facultyBankDetailsId the primary key of the faculty bank details
	 * @return the faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a faculty bank details with the primary key could not be found
	 */
	public FacultyBankDetails findByPrimaryKey(long facultyBankDetailsId)
		throws NoSuchFacultyBankDetailsException;

	/**
	 * Returns the faculty bank details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyBankDetailsId the primary key of the faculty bank details
	 * @return the faculty bank details, or <code>null</code> if a faculty bank details with the primary key could not be found
	 */
	public FacultyBankDetails fetchByPrimaryKey(long facultyBankDetailsId);

	/**
	 * Returns all the faculty bank detailses.
	 *
	 * @return the faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findAll();

	/**
	 * Returns a range of all the faculty bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @return the range of faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faculty bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty bank detailses
	 */
	public java.util.List<FacultyBankDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyBankDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faculty bank detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faculty bank detailses.
	 *
	 * @return the number of faculty bank detailses
	 */
	public int countAll();

}
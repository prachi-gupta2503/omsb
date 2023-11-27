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

import gov.omsb.tms.exception.NoSuchFacultyRotationTsBlockDetailsRelException;
import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faculty rotation ts block details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRotationTsBlockDetailsRelUtil
 * @generated
 */
@ProviderType
public interface FacultyRotationTsBlockDetailsRelPersistence
	extends BasePersistence<FacultyRotationTsBlockDetailsRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyRotationTsBlockDetailsRelUtil} to access the faculty rotation ts block details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel[] findByUuid_PrevAndNext(
			long facultyRotationTsBlockDetailsRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Removes all the faculty rotation ts block details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty rotation ts block details rel that was removed
	 */
	public FacultyRotationTsBlockDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel[] findByUuid_C_PrevAndNext(
			long facultyRotationTsBlockDetailsRelId, String uuid,
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Removes all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @return the matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId);

	/**
	 * Returns a range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByFacultyId_First(
			long facultyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByFacultyId_First(
		long facultyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByFacultyId_Last(
			long facultyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByFacultyId_Last(
		long facultyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel[] findByFacultyId_PrevAndNext(
			long facultyRotationTsBlockDetailsRelId, long facultyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Removes all the faculty rotation ts block details rels where facultyId = &#63; from the database.
	 *
	 * @param facultyId the faculty ID
	 */
	public void removeByFacultyId(long facultyId);

	/**
	 * Returns the number of faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public int countByFacultyId(long facultyId);

	/**
	 * Returns all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId);

	/**
	 * Returns a range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_First(
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_First(
			long progDurationRotationTsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_Last(
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_Last(
			long progDurationRotationTsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel[]
			findByProgDurationRotationTsRelId_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId,
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Removes all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	public void removeByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId);

	/**
	 * Returns the number of faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public int countByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId);

	/**
	 * Returns all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @return the matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(long facultyId, String status);

	/**
	 * Returns a range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(
			long facultyId, String status, int start, int end);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(
			long facultyId, String status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(
			long facultyId, String status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByFacultyIdAndStatus_First(
			long facultyId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByFacultyIdAndStatus_First(
		long facultyId, String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByFacultyIdAndStatus_Last(
			long facultyId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByFacultyIdAndStatus_Last(
		long facultyId, String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel[]
			findByFacultyIdAndStatus_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId, long facultyId,
				String status,
				com.liferay.portal.kernel.util.OrderByComparator
					<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Removes all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63; from the database.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 */
	public void removeByFacultyIdAndStatus(long facultyId, String status);

	/**
	 * Returns the number of faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public int countByFacultyIdAndStatus(long facultyId, String status);

	/**
	 * Returns all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId);

	/**
	 * Returns a range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public FacultyRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel[]
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId,
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<FacultyRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Removes all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	public void
		removeByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId);

	/**
	 * Returns the number of faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public int countByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
		long blocksMetadataDetailsRelId, long progDurationRotationTsRelId);

	/**
	 * Caches the faculty rotation ts block details rel in the entity cache if it is enabled.
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 */
	public void cacheResult(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel);

	/**
	 * Caches the faculty rotation ts block details rels in the entity cache if it is enabled.
	 *
	 * @param facultyRotationTsBlockDetailsRels the faculty rotation ts block details rels
	 */
	public void cacheResult(
		java.util.List<FacultyRotationTsBlockDetailsRel>
			facultyRotationTsBlockDetailsRels);

	/**
	 * Creates a new faculty rotation ts block details rel with the primary key. Does not add the faculty rotation ts block details rel to the database.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key for the new faculty rotation ts block details rel
	 * @return the new faculty rotation ts block details rel
	 */
	public FacultyRotationTsBlockDetailsRel create(
		long facultyRotationTsBlockDetailsRelId);

	/**
	 * Removes the faculty rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was removed
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel remove(
			long facultyRotationTsBlockDetailsRelId)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	public FacultyRotationTsBlockDetailsRel updateImpl(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel);

	/**
	 * Returns the faculty rotation ts block details rel with the primary key or throws a <code>NoSuchFacultyRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel findByPrimaryKey(
			long facultyRotationTsBlockDetailsRelId)
		throws NoSuchFacultyRotationTsBlockDetailsRelException;

	/**
	 * Returns the faculty rotation ts block details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel, or <code>null</code> if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public FacultyRotationTsBlockDetailsRel fetchByPrimaryKey(
		long facultyRotationTsBlockDetailsRelId);

	/**
	 * Returns all the faculty rotation ts block details rels.
	 *
	 * @return the faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findAll();

	/**
	 * Returns a range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty rotation ts block details rels
	 */
	public java.util.List<FacultyRotationTsBlockDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faculty rotation ts block details rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faculty rotation ts block details rels.
	 *
	 * @return the number of faculty rotation ts block details rels
	 */
	public int countAll();

}
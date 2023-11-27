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

import gov.omsb.tms.exception.NoSuchProgdurationRotationTraineelevelBlocksRelException;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the progduration rotation traineelevel blocks rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTraineelevelBlocksRelUtil
 * @generated
 */
@ProviderType
public interface ProgdurationRotationTraineelevelBlocksRelPersistence
	extends BasePersistence<ProgdurationRotationTraineelevelBlocksRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgdurationRotationTraineelevelBlocksRelUtil} to access the progduration rotation traineelevel blocks rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel[] findByUuid_PrevAndNext(
			long progdurationRotationTlBlocksRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 */
	public ProgdurationRotationTraineelevelBlocksRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByUuid_C(String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByUuid_C(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByUuid_C(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel[] findByUuid_C_PrevAndNext(
			long progdurationRotationTlBlocksRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelId(long traineeLevelId);

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelId(long traineeLevelId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelId(
			long traineeLevelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelId(
			long traineeLevelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel findByTraineeLevelId_First(
			long traineeLevelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelId_First(
			long traineeLevelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel findByTraineeLevelId_Last(
			long traineeLevelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel fetchByTraineeLevelId_Last(
		long traineeLevelId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByTraineeLevelId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 */
	public void removeByTraineeLevelId(long traineeLevelId);

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByTraineeLevelId(long traineeLevelId);

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(long programDurationId);

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationId_First(
				long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationId_Last(
				long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId);

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelId_First(
				long traineeLevelId, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelId_First(
			long traineeLevelId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelId_Last(
				long traineeLevelId, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelId_Last(
			long traineeLevelId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationIdAndTraineeLevelId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationIdAndTraineeLevelId(
		long traineeLevelId, long programDurationId);

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByProgramDurationIdAndTraineeLevelId(
		long traineeLevelId, long programDurationId);

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
			long traineeLevelId, long programDurationId, long rotationId);

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
			long traineeLevelId, long programDurationId, long rotationId,
			boolean useFinderCache);

	/**
	 * Removes the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			removeByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByProgramDurationIdAndTraineeLevelIdAndRotationId(
		long traineeLevelId, long programDurationId, long rotationId);

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId);

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndRotationId_First(
				long programDurationId, long rotationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndRotationId_First(
			long programDurationId, long rotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndRotationId_Last(
				long programDurationId, long rotationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndRotationId_Last(
			long programDurationId, long rotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationIdAndRotationId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long programDurationId,
				long rotationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 */
	public void removeByProgramDurationIdAndRotationId(
		long programDurationId, long rotationId);

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByProgramDurationIdAndRotationId(
		long programDurationId, long rotationId);

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType);

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByTraineeLevelIdAndRotationType_First(
				long traineeLevelId, long rotationType,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelIdAndRotationType_First(
			long traineeLevelId, long rotationType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
			findByTraineeLevelIdAndRotationType_Last(
				long traineeLevelId, long rotationType,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelIdAndRotationType_Last(
			long traineeLevelId, long rotationType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByTraineeLevelIdAndRotationType_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				long rotationType,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTraineelevelBlocksRel>
						orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 */
	public void removeByTraineeLevelIdAndRotationType(
		long traineeLevelId, long rotationType);

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public int countByTraineeLevelIdAndRotationType(
		long traineeLevelId, long rotationType);

	/**
	 * Caches the progduration rotation traineelevel blocks rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 */
	public void cacheResult(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel);

	/**
	 * Caches the progduration rotation traineelevel blocks rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTraineelevelBlocksRels the progduration rotation traineelevel blocks rels
	 */
	public void cacheResult(
		java.util.List<ProgdurationRotationTraineelevelBlocksRel>
			progdurationRotationTraineelevelBlocksRels);

	/**
	 * Creates a new progduration rotation traineelevel blocks rel with the primary key. Does not add the progduration rotation traineelevel blocks rel to the database.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key for the new progduration rotation traineelevel blocks rel
	 * @return the new progduration rotation traineelevel blocks rel
	 */
	public ProgdurationRotationTraineelevelBlocksRel create(
		long progdurationRotationTlBlocksRelId);

	/**
	 * Removes the progduration rotation traineelevel blocks rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel remove(
			long progdurationRotationTlBlocksRelId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	public ProgdurationRotationTraineelevelBlocksRel updateImpl(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel);

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel findByPrimaryKey(
			long progdurationRotationTlBlocksRelId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel, or <code>null</code> if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public ProgdurationRotationTraineelevelBlocksRel fetchByPrimaryKey(
		long progdurationRotationTlBlocksRelId);

	/**
	 * Returns all the progduration rotation traineelevel blocks rels.
	 *
	 * @return the progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel> findAll();

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation traineelevel blocks rels
	 */
	public java.util.List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTraineelevelBlocksRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the progduration rotation traineelevel blocks rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels.
	 *
	 * @return the number of progduration rotation traineelevel blocks rels
	 */
	public int countAll();

}
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

import gov.omsb.tms.exception.NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the progduration traineelevel blocks level type rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationTraineelevelBlocksLevelTypeRelUtil
 * @generated
 */
@ProviderType
public interface ProgdurationTraineelevelBlocksLevelTypeRelPersistence
	extends BasePersistence<ProgdurationTraineelevelBlocksLevelTypeRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgdurationTraineelevelBlocksLevelTypeRelUtil} to access the progduration traineelevel blocks level type rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByUuid(String uuid);

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByUuid(
			String uuid, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByUuid(
			String uuid, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel[] findByUuid_PrevAndNext(
			long progdurationTlBlocksLtId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Removes all the progduration traineelevel blocks level type rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration traineelevel blocks level type rel that was removed
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByUuid_C(String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByUuid_C(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByUuid_C(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel[]
			findByUuid_C_PrevAndNext(
				long progdurationTlBlocksLtId, String uuid, long companyId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationTraineelevelBlocksLevelTypeRel>
						orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Removes all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(long programDurationId);

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationId_First(
				long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationTraineelevelBlocksLevelTypeRel>
						orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationId_Last(
				long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationTraineelevelBlocksLevelTypeRel>
						orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationTlBlocksLtId, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationTraineelevelBlocksLevelTypeRel>
						orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Removes all the progduration traineelevel blocks level type rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationIdAndTraineeLevelId(
				long programDurationId, long traineeLevelId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId);

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId,
			boolean useFinderCache);

	/**
	 * Removes the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the progduration traineelevel blocks level type rel that was removed
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel
			removeByProgramDurationIdAndTraineeLevelId(
				long programDurationId, long traineeLevelId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where programDurationId = &#63; and traineeLevelId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public int countByProgramDurationIdAndTraineeLevelId(
		long programDurationId, long traineeLevelId);

	/**
	 * Caches the progduration traineelevel blocks level type rel in the entity cache if it is enabled.
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRel the progduration traineelevel blocks level type rel
	 */
	public void cacheResult(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel);

	/**
	 * Caches the progduration traineelevel blocks level type rels in the entity cache if it is enabled.
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRels the progduration traineelevel blocks level type rels
	 */
	public void cacheResult(
		java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel>
			progdurationTraineelevelBlocksLevelTypeRels);

	/**
	 * Creates a new progduration traineelevel blocks level type rel with the primary key. Does not add the progduration traineelevel blocks level type rel to the database.
	 *
	 * @param progdurationTlBlocksLtId the primary key for the new progduration traineelevel blocks level type rel
	 * @return the new progduration traineelevel blocks level type rel
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel create(
		long progdurationTlBlocksLtId);

	/**
	 * Removes the progduration traineelevel blocks level type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel that was removed
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel remove(
			long progdurationTlBlocksLtId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	public ProgdurationTraineelevelBlocksLevelTypeRel updateImpl(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel);

	/**
	 * Returns the progduration traineelevel blocks level type rel with the primary key or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel findByPrimaryKey(
			long progdurationTlBlocksLtId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;

	/**
	 * Returns the progduration traineelevel blocks level type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel, or <code>null</code> if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByPrimaryKey(
		long progdurationTlBlocksLtId);

	/**
	 * Returns all the progduration traineelevel blocks level type rels.
	 *
	 * @return the progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll();

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration traineelevel blocks level type rels
	 */
	public java.util.List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationTraineelevelBlocksLevelTypeRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the progduration traineelevel blocks level type rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of progduration traineelevel blocks level type rels.
	 *
	 * @return the number of progduration traineelevel blocks level type rels
	 */
	public int countAll();

}
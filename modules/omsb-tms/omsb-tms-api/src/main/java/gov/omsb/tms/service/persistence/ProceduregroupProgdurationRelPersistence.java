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

import gov.omsb.tms.exception.NoSuchProceduregroupProgdurationRelException;
import gov.omsb.tms.model.ProceduregroupProgdurationRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the proceduregroup progduration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProceduregroupProgdurationRelUtil
 * @generated
 */
@ProviderType
public interface ProceduregroupProgdurationRelPersistence
	extends BasePersistence<ProceduregroupProgdurationRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProceduregroupProgdurationRelUtil} to access the proceduregroup progduration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public ProceduregroupProgdurationRel[] findByUuid_PrevAndNext(
			long pgPdRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Removes all the proceduregroup progduration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching proceduregroup progduration rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the proceduregroup progduration rel that was removed
	 */
	public ProceduregroupProgdurationRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public ProceduregroupProgdurationRel[] findByUuid_C_PrevAndNext(
			long pgPdRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Removes all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel>
		findByProgramDurationId(long programDurationId);

	/**
	 * Returns a range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel>
		findByProgramDurationId(long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByProgramDurationId_First(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public ProceduregroupProgdurationRel[] findByProgramDurationId_PrevAndNext(
			long pgPdRelId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Removes all the proceduregroup progduration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(long procedureGroupMasterId);

	/**
	 * Returns a range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByProcedureGroupMasterId_First(
		long procedureGroupMasterId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel findByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel fetchByProcedureGroupMasterId_Last(
		long procedureGroupMasterId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public ProceduregroupProgdurationRel[]
			findByProcedureGroupMasterId_PrevAndNext(
				long pgPdRelId, long procedureGroupMasterId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Removes all the proceduregroup progduration rels where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	public void removeByProcedureGroupMasterId(long procedureGroupMasterId);

	/**
	 * Returns the number of proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public int countByProcedureGroupMasterId(long procedureGroupMasterId);

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel
			findByProgramDurationIdAndProcedureGroupMasterId(
				long programDurationId, long procedureGroupMasterId)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterId(
			long programDurationId, long procedureGroupMasterId);

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public ProceduregroupProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterId(
			long programDurationId, long procedureGroupMasterId,
			boolean useFinderCache);

	/**
	 * Removes the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the proceduregroup progduration rel that was removed
	 */
	public ProceduregroupProgdurationRel
			removeByProgramDurationIdAndProcedureGroupMasterId(
				long programDurationId, long procedureGroupMasterId)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the number of proceduregroup progduration rels where programDurationId = &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public int countByProgramDurationIdAndProcedureGroupMasterId(
		long programDurationId, long procedureGroupMasterId);

	/**
	 * Caches the proceduregroup progduration rel in the entity cache if it is enabled.
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 */
	public void cacheResult(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel);

	/**
	 * Caches the proceduregroup progduration rels in the entity cache if it is enabled.
	 *
	 * @param proceduregroupProgdurationRels the proceduregroup progduration rels
	 */
	public void cacheResult(
		java.util.List<ProceduregroupProgdurationRel>
			proceduregroupProgdurationRels);

	/**
	 * Creates a new proceduregroup progduration rel with the primary key. Does not add the proceduregroup progduration rel to the database.
	 *
	 * @param pgPdRelId the primary key for the new proceduregroup progduration rel
	 * @return the new proceduregroup progduration rel
	 */
	public ProceduregroupProgdurationRel create(long pgPdRelId);

	/**
	 * Removes the proceduregroup progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was removed
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public ProceduregroupProgdurationRel remove(long pgPdRelId)
		throws NoSuchProceduregroupProgdurationRelException;

	public ProceduregroupProgdurationRel updateImpl(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel);

	/**
	 * Returns the proceduregroup progduration rel with the primary key or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public ProceduregroupProgdurationRel findByPrimaryKey(long pgPdRelId)
		throws NoSuchProceduregroupProgdurationRelException;

	/**
	 * Returns the proceduregroup progduration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel, or <code>null</code> if a proceduregroup progduration rel with the primary key could not be found
	 */
	public ProceduregroupProgdurationRel fetchByPrimaryKey(long pgPdRelId);

	/**
	 * Returns all the proceduregroup progduration rels.
	 *
	 * @return the proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findAll();

	/**
	 * Returns a range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proceduregroup progduration rels
	 */
	public java.util.List<ProceduregroupProgdurationRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProceduregroupProgdurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the proceduregroup progduration rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of proceduregroup progduration rels.
	 *
	 * @return the number of proceduregroup progduration rels
	 */
	public int countAll();

}
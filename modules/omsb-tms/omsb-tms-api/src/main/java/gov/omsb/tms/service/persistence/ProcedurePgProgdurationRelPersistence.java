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

import gov.omsb.tms.exception.NoSuchProcedurePgProgdurationRelException;
import gov.omsb.tms.model.ProcedurePgProgdurationRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the procedure pg progduration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedurePgProgdurationRelUtil
 * @generated
 */
@ProviderType
public interface ProcedurePgProgdurationRelPersistence
	extends BasePersistence<ProcedurePgProgdurationRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcedurePgProgdurationRelUtil} to access the procedure pg progduration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByUuid(String uuid);

	/**
	 * Returns a range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public ProcedurePgProgdurationRel[] findByUuid_PrevAndNext(
			long procedurePgPdRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Removes all the procedure pg progduration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure pg progduration rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the procedure pg progduration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure pg progduration rel that was removed
	 */
	public ProcedurePgProgdurationRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public ProcedurePgProgdurationRel[] findByUuid_C_PrevAndNext(
			long procedurePgPdRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Removes all the procedure pg progduration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId);

	/**
	 * Returns a range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByProgramDurationId_First(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public ProcedurePgProgdurationRel[] findByProgramDurationId_PrevAndNext(
			long procedurePgPdRelId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Removes all the procedure pg progduration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel>
		findByProcedureGroupMasterId(long procedureGroupMasterId);

	/**
	 * Returns a range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByProcedureGroupMasterId_First(
		long procedureGroupMasterId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByProcedureGroupMasterId_Last(
		long procedureGroupMasterId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public ProcedurePgProgdurationRel[]
			findByProcedureGroupMasterId_PrevAndNext(
				long procedurePgPdRelId, long procedureGroupMasterId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Removes all the procedure pg progduration rels where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	public void removeByProcedureGroupMasterId(long procedureGroupMasterId);

	/**
	 * Returns the number of procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public int countByProcedureGroupMasterId(long procedureGroupMasterId);

	/**
	 * Returns all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId);

	/**
	 * Returns a range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByProcedureMasterId_First(
			long procedureMasterId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByProcedureMasterId_First(
		long procedureMasterId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel findByProcedureMasterId_Last(
			long procedureMasterId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel fetchByProcedureMasterId_Last(
		long procedureMasterId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public ProcedurePgProgdurationRel[] findByProcedureMasterId_PrevAndNext(
			long procedurePgPdRelId, long procedureMasterId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Removes all the procedure pg progduration rels where procedureMasterId = &#63; from the database.
	 *
	 * @param procedureMasterId the procedure master ID
	 */
	public void removeByProcedureMasterId(long procedureMasterId);

	/**
	 * Returns the number of procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public int countByProcedureMasterId(long procedureMasterId);

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel
			findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				long programDurationId, long procedureGroupMasterId,
				long procedureMasterId)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId);

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public ProcedurePgProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId, boolean useFinderCache);

	/**
	 * Removes the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the procedure pg progduration rel that was removed
	 */
	public ProcedurePgProgdurationRel
			removeByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				long programDurationId, long procedureGroupMasterId,
				long procedureMasterId)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the number of procedure pg progduration rels where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public int
		countByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId);

	/**
	 * Caches the procedure pg progduration rel in the entity cache if it is enabled.
	 *
	 * @param procedurePgProgdurationRel the procedure pg progduration rel
	 */
	public void cacheResult(
		ProcedurePgProgdurationRel procedurePgProgdurationRel);

	/**
	 * Caches the procedure pg progduration rels in the entity cache if it is enabled.
	 *
	 * @param procedurePgProgdurationRels the procedure pg progduration rels
	 */
	public void cacheResult(
		java.util.List<ProcedurePgProgdurationRel> procedurePgProgdurationRels);

	/**
	 * Creates a new procedure pg progduration rel with the primary key. Does not add the procedure pg progduration rel to the database.
	 *
	 * @param procedurePgPdRelId the primary key for the new procedure pg progduration rel
	 * @return the new procedure pg progduration rel
	 */
	public ProcedurePgProgdurationRel create(long procedurePgPdRelId);

	/**
	 * Removes the procedure pg progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel that was removed
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public ProcedurePgProgdurationRel remove(long procedurePgPdRelId)
		throws NoSuchProcedurePgProgdurationRelException;

	public ProcedurePgProgdurationRel updateImpl(
		ProcedurePgProgdurationRel procedurePgProgdurationRel);

	/**
	 * Returns the procedure pg progduration rel with the primary key or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public ProcedurePgProgdurationRel findByPrimaryKey(long procedurePgPdRelId)
		throws NoSuchProcedurePgProgdurationRelException;

	/**
	 * Returns the procedure pg progduration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel, or <code>null</code> if a procedure pg progduration rel with the primary key could not be found
	 */
	public ProcedurePgProgdurationRel fetchByPrimaryKey(
		long procedurePgPdRelId);

	/**
	 * Returns all the procedure pg progduration rels.
	 *
	 * @return the procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findAll();

	/**
	 * Returns a range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure pg progduration rels
	 */
	public java.util.List<ProcedurePgProgdurationRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the procedure pg progduration rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of procedure pg progduration rels.
	 *
	 * @return the number of procedure pg progduration rels
	 */
	public int countAll();

}
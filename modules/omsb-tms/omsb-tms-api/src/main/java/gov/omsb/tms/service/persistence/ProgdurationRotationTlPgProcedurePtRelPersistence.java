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

import gov.omsb.tms.exception.NoSuchProgdurationRotationTlPgProcedurePtRelException;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the progduration rotation tl pg procedure pt rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTlPgProcedurePtRelUtil
 * @generated
 */
@ProviderType
public interface ProgdurationRotationTlPgProcedurePtRelPersistence
	extends BasePersistence<ProgdurationRotationTlPgProcedurePtRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgdurationRotationTlPgProcedurePtRelUtil} to access the progduration rotation tl pg procedure pt rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel[] findByUuid_PrevAndNext(
			long progdurationRotationTlPgProcedurePtRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	public ProgdurationRotationTlPgProcedurePtRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel[] findByUuid_C_PrevAndNext(
			long progdurationRotationTlPgProcedurePtRelId, String uuid,
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProcedureGroupId(long procedureGroupId);

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProcedureGroupId(long procedureGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProcedureGroupId(
			long procedureGroupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProcedureGroupId(
			long procedureGroupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByProcedureGroupId_First(
			long procedureGroupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByProcedureGroupId_First(
		long procedureGroupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByProcedureGroupId_Last(
			long procedureGroupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByProcedureGroupId_Last(
		long procedureGroupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel[]
			findByProcedureGroupId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long procedureGroupId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63; from the database.
	 *
	 * @param procedureGroupId the procedure group ID
	 */
	public void removeByProcedureGroupId(long procedureGroupId);

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public int countByProcedureGroupId(long procedureGroupId);

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByProcedureId(
			long procedureId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByProcedureId(
		long procedureId);

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param procedureId the procedure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByProcedureId(
		long procedureId, boolean useFinderCache);

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where procedureId = &#63; from the database.
	 *
	 * @param procedureId the procedure ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	public ProgdurationRotationTlPgProcedurePtRel removeByProcedureId(
			long procedureId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where procedureId = &#63;.
	 *
	 * @param procedureId the procedure ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public int countByProcedureId(long procedureId);

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(long programDurationId);

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByProgramDurationId_Last(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId);

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
				long programDurationId, long procedureGroupId, long procedureId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
			long programDurationId, long procedureGroupId, long procedureId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
				long programDurationId, long procedureGroupId, long procedureId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
			long programDurationId, long procedureGroupId, long procedureId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel[]
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long programDurationId, long procedureGroupId, long procedureId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTlPgProcedurePtRel> orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 */
	public void removeByProgramDurationIdAndProcedureGroupIdAndProcedureId(
		long programDurationId, long procedureGroupId, long procedureId);

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public int countByProgramDurationIdAndProcedureGroupIdAndProcedureId(
		long programDurationId, long procedureGroupId, long procedureId);

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				long programDurationId, long procedureGroupId, long procedureId,
				long rotationId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId);

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId, boolean useFinderCache);

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	public ProgdurationRotationTlPgProcedurePtRel
			removeByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				long programDurationId, long procedureGroupId, long procedureId,
				long rotationId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public int
		countByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId);

	/**
	 * Caches the progduration rotation tl pg procedure pt rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 */
	public void cacheResult(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel);

	/**
	 * Caches the progduration rotation tl pg procedure pt rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTlPgProcedurePtRels the progduration rotation tl pg procedure pt rels
	 */
	public void cacheResult(
		java.util.List<ProgdurationRotationTlPgProcedurePtRel>
			progdurationRotationTlPgProcedurePtRels);

	/**
	 * Creates a new progduration rotation tl pg procedure pt rel with the primary key. Does not add the progduration rotation tl pg procedure pt rel to the database.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key for the new progduration rotation tl pg procedure pt rel
	 * @return the new progduration rotation tl pg procedure pt rel
	 */
	public ProgdurationRotationTlPgProcedurePtRel create(
		long progdurationRotationTlPgProcedurePtRelId);

	/**
	 * Removes the progduration rotation tl pg procedure pt rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel remove(
			long progdurationRotationTlPgProcedurePtRelId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	public ProgdurationRotationTlPgProcedurePtRel updateImpl(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel);

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel findByPrimaryKey(
			long progdurationRotationTlPgProcedurePtRelId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException;

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel, or <code>null</code> if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public ProgdurationRotationTlPgProcedurePtRel fetchByPrimaryKey(
		long progdurationRotationTlPgProcedurePtRelId);

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels.
	 *
	 * @return the progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findAll();

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation tl pg procedure pt rels
	 */
	public java.util.List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTlPgProcedurePtRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels.
	 *
	 * @return the number of progduration rotation tl pg procedure pt rels
	 */
	public int countAll();

}
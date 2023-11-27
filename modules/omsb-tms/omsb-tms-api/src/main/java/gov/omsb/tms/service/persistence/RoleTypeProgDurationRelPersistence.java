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

import gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException;
import gov.omsb.tms.model.RoleTypeProgDurationRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the role type prog duration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeProgDurationRelUtil
 * @generated
 */
@ProviderType
public interface RoleTypeProgDurationRelPersistence
	extends BasePersistence<RoleTypeProgDurationRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoleTypeProgDurationRelUtil} to access the role type prog duration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the role type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByUuid(String uuid);

	/**
	 * Returns a range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public RoleTypeProgDurationRel[] findByUuid_PrevAndNext(
			long RoleTypeProgDurationRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Removes all the role type prog duration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role type prog duration rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the role type prog duration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role type prog duration rel that was removed
	 */
	public RoleTypeProgDurationRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role type prog duration rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public RoleTypeProgDurationRel[] findByUuid_C_PrevAndNext(
			long RoleTypeProgDurationRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Removes all the role type prog duration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role type prog duration rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId);

	/**
	 * Returns a range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel findByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the first role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByProgramDurationId_First(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the last role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel findByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the last role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public RoleTypeProgDurationRel[] findByProgramDurationId_PrevAndNext(
			long RoleTypeProgDurationRelId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Removes all the role type prog duration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of role type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching role type prog duration rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel findByProgramDurationIdAndRoleTypeMasterId(
			long programDurationId, long roleTypeMasterId)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByProgramDurationIdAndRoleTypeMasterId(
		long programDurationId, long roleTypeMasterId);

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public RoleTypeProgDurationRel fetchByProgramDurationIdAndRoleTypeMasterId(
		long programDurationId, long roleTypeMasterId, boolean useFinderCache);

	/**
	 * Removes the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the role type prog duration rel that was removed
	 */
	public RoleTypeProgDurationRel removeByProgramDurationIdAndRoleTypeMasterId(
			long programDurationId, long roleTypeMasterId)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the number of role type prog duration rels where programDurationId = &#63; and roleTypeMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the number of matching role type prog duration rels
	 */
	public int countByProgramDurationIdAndRoleTypeMasterId(
		long programDurationId, long roleTypeMasterId);

	/**
	 * Caches the role type prog duration rel in the entity cache if it is enabled.
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 */
	public void cacheResult(RoleTypeProgDurationRel roleTypeProgDurationRel);

	/**
	 * Caches the role type prog duration rels in the entity cache if it is enabled.
	 *
	 * @param roleTypeProgDurationRels the role type prog duration rels
	 */
	public void cacheResult(
		java.util.List<RoleTypeProgDurationRel> roleTypeProgDurationRels);

	/**
	 * Creates a new role type prog duration rel with the primary key. Does not add the role type prog duration rel to the database.
	 *
	 * @param RoleTypeProgDurationRelId the primary key for the new role type prog duration rel
	 * @return the new role type prog duration rel
	 */
	public RoleTypeProgDurationRel create(long RoleTypeProgDurationRelId);

	/**
	 * Removes the role type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel that was removed
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public RoleTypeProgDurationRel remove(long RoleTypeProgDurationRelId)
		throws NoSuchRoleTypeProgDurationRelException;

	public RoleTypeProgDurationRel updateImpl(
		RoleTypeProgDurationRel roleTypeProgDurationRel);

	/**
	 * Returns the role type prog duration rel with the primary key or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public RoleTypeProgDurationRel findByPrimaryKey(
			long RoleTypeProgDurationRelId)
		throws NoSuchRoleTypeProgDurationRelException;

	/**
	 * Returns the role type prog duration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel, or <code>null</code> if a role type prog duration rel with the primary key could not be found
	 */
	public RoleTypeProgDurationRel fetchByPrimaryKey(
		long RoleTypeProgDurationRelId);

	/**
	 * Returns all the role type prog duration rels.
	 *
	 * @return the role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findAll();

	/**
	 * Returns a range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role type prog duration rels
	 */
	public java.util.List<RoleTypeProgDurationRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RoleTypeProgDurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the role type prog duration rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of role type prog duration rels.
	 *
	 * @return the number of role type prog duration rels
	 */
	public int countAll();

}
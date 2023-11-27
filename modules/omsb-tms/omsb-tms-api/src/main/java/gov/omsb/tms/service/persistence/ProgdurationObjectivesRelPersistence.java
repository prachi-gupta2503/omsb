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

import gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException;
import gov.omsb.tms.model.ProgdurationObjectivesRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the progduration objectives rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationObjectivesRelUtil
 * @generated
 */
@ProviderType
public interface ProgdurationObjectivesRelPersistence
	extends BasePersistence<ProgdurationObjectivesRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgdurationObjectivesRelUtil} to access the progduration objectives rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the progduration objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findByUuid(String uuid);

	/**
	 * Returns a range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of matching progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator);

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator);

	/**
	 * Returns the progduration objectives rels before and after the current progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param PDObjectivesId the primary key of the current progduration objectives rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	public ProgdurationObjectivesRel[] findByUuid_PrevAndNext(
			long PDObjectivesId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Removes all the progduration objectives rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration objectives rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationObjectivesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the progduration objectives rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration objectives rel that was removed
	 */
	public ProgdurationObjectivesRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration objectives rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of matching progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator);

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public ProgdurationObjectivesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator);

	/**
	 * Returns the progduration objectives rels before and after the current progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param PDObjectivesId the primary key of the current progduration objectives rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	public ProgdurationObjectivesRel[] findByUuid_C_PrevAndNext(
			long PDObjectivesId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Removes all the progduration objectives rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration objectives rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the progduration objectives rel in the entity cache if it is enabled.
	 *
	 * @param progdurationObjectivesRel the progduration objectives rel
	 */
	public void cacheResult(
		ProgdurationObjectivesRel progdurationObjectivesRel);

	/**
	 * Caches the progduration objectives rels in the entity cache if it is enabled.
	 *
	 * @param progdurationObjectivesRels the progduration objectives rels
	 */
	public void cacheResult(
		java.util.List<ProgdurationObjectivesRel> progdurationObjectivesRels);

	/**
	 * Creates a new progduration objectives rel with the primary key. Does not add the progduration objectives rel to the database.
	 *
	 * @param PDObjectivesId the primary key for the new progduration objectives rel
	 * @return the new progduration objectives rel
	 */
	public ProgdurationObjectivesRel create(long PDObjectivesId);

	/**
	 * Removes the progduration objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel that was removed
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	public ProgdurationObjectivesRel remove(long PDObjectivesId)
		throws NoSuchProgdurationObjectivesRelException;

	public ProgdurationObjectivesRel updateImpl(
		ProgdurationObjectivesRel progdurationObjectivesRel);

	/**
	 * Returns the progduration objectives rel with the primary key or throws a <code>NoSuchProgdurationObjectivesRelException</code> if it could not be found.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	public ProgdurationObjectivesRel findByPrimaryKey(long PDObjectivesId)
		throws NoSuchProgdurationObjectivesRelException;

	/**
	 * Returns the progduration objectives rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel, or <code>null</code> if a progduration objectives rel with the primary key could not be found
	 */
	public ProgdurationObjectivesRel fetchByPrimaryKey(long PDObjectivesId);

	/**
	 * Returns all the progduration objectives rels.
	 *
	 * @return the progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findAll();

	/**
	 * Returns a range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration objectives rels
	 */
	public java.util.List<ProgdurationObjectivesRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationObjectivesRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the progduration objectives rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of progduration objectives rels.
	 *
	 * @return the number of progduration objectives rels
	 */
	public int countAll();

}
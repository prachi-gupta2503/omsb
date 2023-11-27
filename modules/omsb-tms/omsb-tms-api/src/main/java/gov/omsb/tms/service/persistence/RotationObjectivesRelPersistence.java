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

import gov.omsb.tms.exception.NoSuchRotationObjectivesRelException;
import gov.omsb.tms.model.RotationObjectivesRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rotation objectives rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationObjectivesRelUtil
 * @generated
 */
@ProviderType
public interface RotationObjectivesRelPersistence
	extends BasePersistence<RotationObjectivesRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RotationObjectivesRelUtil} to access the rotation objectives rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the rotation objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findByUuid(String uuid);

	/**
	 * Returns a range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public RotationObjectivesRel[] findByUuid_PrevAndNext(
			long rotationObjectivesRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Removes all the rotation objectives rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation objectives rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationObjectivesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel findByUUID_G(String uuid, long groupId)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the rotation objectives rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation objectives rel that was removed
	 */
	public RotationObjectivesRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation objectives rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public RotationObjectivesRel[] findByUuid_C_PrevAndNext(
			long rotationObjectivesRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Removes all the rotation objectives rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation objectives rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId);

	/**
	 * Returns a range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel findByRotationIdAndProgramDurationId_First(
			long rotationId, long progDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the first rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel fetchByRotationIdAndProgramDurationId_First(
		long rotationId, long progDurationId,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns the last rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel findByRotationIdAndProgramDurationId_Last(
			long rotationId, long progDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the last rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public RotationObjectivesRel fetchByRotationIdAndProgramDurationId_Last(
		long rotationId, long progDurationId,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public RotationObjectivesRel[]
			findByRotationIdAndProgramDurationId_PrevAndNext(
				long rotationObjectivesRelId, long rotationId,
				long progDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Removes all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 */
	public void removeByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId);

	/**
	 * Returns the number of rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the number of matching rotation objectives rels
	 */
	public int countByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId);

	/**
	 * Caches the rotation objectives rel in the entity cache if it is enabled.
	 *
	 * @param rotationObjectivesRel the rotation objectives rel
	 */
	public void cacheResult(RotationObjectivesRel rotationObjectivesRel);

	/**
	 * Caches the rotation objectives rels in the entity cache if it is enabled.
	 *
	 * @param rotationObjectivesRels the rotation objectives rels
	 */
	public void cacheResult(
		java.util.List<RotationObjectivesRel> rotationObjectivesRels);

	/**
	 * Creates a new rotation objectives rel with the primary key. Does not add the rotation objectives rel to the database.
	 *
	 * @param rotationObjectivesRelId the primary key for the new rotation objectives rel
	 * @return the new rotation objectives rel
	 */
	public RotationObjectivesRel create(long rotationObjectivesRelId);

	/**
	 * Removes the rotation objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel that was removed
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public RotationObjectivesRel remove(long rotationObjectivesRelId)
		throws NoSuchRotationObjectivesRelException;

	public RotationObjectivesRel updateImpl(
		RotationObjectivesRel rotationObjectivesRel);

	/**
	 * Returns the rotation objectives rel with the primary key or throws a <code>NoSuchRotationObjectivesRelException</code> if it could not be found.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public RotationObjectivesRel findByPrimaryKey(long rotationObjectivesRelId)
		throws NoSuchRotationObjectivesRelException;

	/**
	 * Returns the rotation objectives rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel, or <code>null</code> if a rotation objectives rel with the primary key could not be found
	 */
	public RotationObjectivesRel fetchByPrimaryKey(
		long rotationObjectivesRelId);

	/**
	 * Returns all the rotation objectives rels.
	 *
	 * @return the rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findAll();

	/**
	 * Returns a range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation objectives rels
	 */
	public java.util.List<RotationObjectivesRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationObjectivesRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rotation objectives rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rotation objectives rels.
	 *
	 * @return the number of rotation objectives rels
	 */
	public int countAll();

}
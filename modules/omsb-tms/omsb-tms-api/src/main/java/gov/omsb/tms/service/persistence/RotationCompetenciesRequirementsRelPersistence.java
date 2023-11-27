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

import gov.omsb.tms.exception.NoSuchRotationCompetenciesRequirementsRelException;
import gov.omsb.tms.model.RotationCompetenciesRequirementsRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rotation competencies requirements rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationCompetenciesRequirementsRelUtil
 * @generated
 */
@ProviderType
public interface RotationCompetenciesRequirementsRelPersistence
	extends BasePersistence<RotationCompetenciesRequirementsRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RotationCompetenciesRequirementsRelUtil} to access the rotation competencies requirements rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public RotationCompetenciesRequirementsRel[] findByUuid_PrevAndNext(
			long rotationCompetenciesRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Removes all the rotation competencies requirements rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation competencies requirements rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation competencies requirements rel that was removed
	 */
	public RotationCompetenciesRequirementsRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public RotationCompetenciesRequirementsRel[] findByUuid_C_PrevAndNext(
			long rotationCompetenciesRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Removes all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId);

	/**
	 * Returns a range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel
			findByRotationIdAndProgramDurationId_First(
				long rotationId, long progDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel
		fetchByRotationIdAndProgramDurationId_First(
			long rotationId, long progDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel
			findByRotationIdAndProgramDurationId_Last(
				long rotationId, long progDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public RotationCompetenciesRequirementsRel
		fetchByRotationIdAndProgramDurationId_Last(
			long rotationId, long progDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public RotationCompetenciesRequirementsRel[]
			findByRotationIdAndProgramDurationId_PrevAndNext(
				long rotationCompetenciesRelId, long rotationId,
				long progDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<RotationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Removes all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 */
	public void removeByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId);

	/**
	 * Returns the number of rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	public int countByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId);

	/**
	 * Caches the rotation competencies requirements rel in the entity cache if it is enabled.
	 *
	 * @param rotationCompetenciesRequirementsRel the rotation competencies requirements rel
	 */
	public void cacheResult(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel);

	/**
	 * Caches the rotation competencies requirements rels in the entity cache if it is enabled.
	 *
	 * @param rotationCompetenciesRequirementsRels the rotation competencies requirements rels
	 */
	public void cacheResult(
		java.util.List<RotationCompetenciesRequirementsRel>
			rotationCompetenciesRequirementsRels);

	/**
	 * Creates a new rotation competencies requirements rel with the primary key. Does not add the rotation competencies requirements rel to the database.
	 *
	 * @param rotationCompetenciesRelId the primary key for the new rotation competencies requirements rel
	 * @return the new rotation competencies requirements rel
	 */
	public RotationCompetenciesRequirementsRel create(
		long rotationCompetenciesRelId);

	/**
	 * Removes the rotation competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel that was removed
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public RotationCompetenciesRequirementsRel remove(
			long rotationCompetenciesRelId)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	public RotationCompetenciesRequirementsRel updateImpl(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel);

	/**
	 * Returns the rotation competencies requirements rel with the primary key or throws a <code>NoSuchRotationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public RotationCompetenciesRequirementsRel findByPrimaryKey(
			long rotationCompetenciesRelId)
		throws NoSuchRotationCompetenciesRequirementsRelException;

	/**
	 * Returns the rotation competencies requirements rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel, or <code>null</code> if a rotation competencies requirements rel with the primary key could not be found
	 */
	public RotationCompetenciesRequirementsRel fetchByPrimaryKey(
		long rotationCompetenciesRelId);

	/**
	 * Returns all the rotation competencies requirements rels.
	 *
	 * @return the rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findAll();

	/**
	 * Returns a range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation competencies requirements rels
	 */
	public java.util.List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RotationCompetenciesRequirementsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rotation competencies requirements rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rotation competencies requirements rels.
	 *
	 * @return the number of rotation competencies requirements rels
	 */
	public int countAll();

}
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

import gov.omsb.tms.exception.NoSuchProgdurationCompetenciesRequirementsRelException;
import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the progduration competencies requirements rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationCompetenciesRequirementsRelUtil
 * @generated
 */
@ProviderType
public interface ProgdurationCompetenciesRequirementsRelPersistence
	extends BasePersistence<ProgdurationCompetenciesRequirementsRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgdurationCompetenciesRequirementsRelUtil} to access the progduration competencies requirements rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the progduration competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the progduration competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @return the range of matching progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Returns the first progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the last progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Returns the last progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the progduration competencies requirements rels before and after the current progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the current progduration competencies requirements rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel[] findByUuid_PrevAndNext(
			long progdurationCompetenciesRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Removes all the progduration competencies requirements rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of progduration competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration competencies requirements rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the progduration competencies requirements rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Returns the progduration competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the progduration competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the progduration competencies requirements rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration competencies requirements rel that was removed
	 */
	public ProgdurationCompetenciesRequirementsRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Returns the number of progduration competencies requirements rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration competencies requirements rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @return the range of matching progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Returns the first progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the last progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Returns the last progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns the progduration competencies requirements rels before and after the current progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the current progduration competencies requirements rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel[] findByUuid_C_PrevAndNext(
			long progdurationCompetenciesRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationCompetenciesRequirementsRel> orderByComparator)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Removes all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration competencies requirements rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the progduration competencies requirements rel in the entity cache if it is enabled.
	 *
	 * @param progdurationCompetenciesRequirementsRel the progduration competencies requirements rel
	 */
	public void cacheResult(
		ProgdurationCompetenciesRequirementsRel
			progdurationCompetenciesRequirementsRel);

	/**
	 * Caches the progduration competencies requirements rels in the entity cache if it is enabled.
	 *
	 * @param progdurationCompetenciesRequirementsRels the progduration competencies requirements rels
	 */
	public void cacheResult(
		java.util.List<ProgdurationCompetenciesRequirementsRel>
			progdurationCompetenciesRequirementsRels);

	/**
	 * Creates a new progduration competencies requirements rel with the primary key. Does not add the progduration competencies requirements rel to the database.
	 *
	 * @param progdurationCompetenciesRelId the primary key for the new progduration competencies requirements rel
	 * @return the new progduration competencies requirements rel
	 */
	public ProgdurationCompetenciesRequirementsRel create(
		long progdurationCompetenciesRelId);

	/**
	 * Removes the progduration competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was removed
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel remove(
			long progdurationCompetenciesRelId)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	public ProgdurationCompetenciesRequirementsRel updateImpl(
		ProgdurationCompetenciesRequirementsRel
			progdurationCompetenciesRequirementsRel);

	/**
	 * Returns the progduration competencies requirements rel with the primary key or throws a <code>NoSuchProgdurationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel findByPrimaryKey(
			long progdurationCompetenciesRelId)
		throws NoSuchProgdurationCompetenciesRequirementsRelException;

	/**
	 * Returns the progduration competencies requirements rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel, or <code>null</code> if a progduration competencies requirements rel with the primary key could not be found
	 */
	public ProgdurationCompetenciesRequirementsRel fetchByPrimaryKey(
		long progdurationCompetenciesRelId);

	/**
	 * Returns all the progduration competencies requirements rels.
	 *
	 * @return the progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findAll();

	/**
	 * Returns a range of all the progduration competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @return the range of progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration competencies requirements rels
	 */
	public java.util.List<ProgdurationCompetenciesRequirementsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationCompetenciesRequirementsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the progduration competencies requirements rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of progduration competencies requirements rels.
	 *
	 * @return the number of progduration competencies requirements rels
	 */
	public int countAll();

}
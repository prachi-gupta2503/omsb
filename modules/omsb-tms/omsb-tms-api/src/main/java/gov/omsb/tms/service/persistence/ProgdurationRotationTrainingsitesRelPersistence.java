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

import gov.omsb.tms.exception.NoSuchProgdurationRotationTrainingsitesRelException;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the progduration rotation trainingsites rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTrainingsitesRelUtil
 * @generated
 */
@ProviderType
public interface ProgdurationRotationTrainingsitesRelPersistence
	extends BasePersistence<ProgdurationRotationTrainingsitesRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgdurationRotationTrainingsitesRelUtil} to access the progduration rotation trainingsites rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel[] findByUuid_PrevAndNext(
			long progdurationRotationTsRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Removes all the progduration rotation trainingsites rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public ProgdurationRotationTrainingsitesRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel[] findByUuid_C_PrevAndNext(
			long progdurationRotationTsRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Removes all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(long programDurationId);

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByProgramDurationId_First(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByProgramDurationId_Last(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTsRelId, long programDurationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Removes all the progduration rotation trainingsites rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByRotationId(long rotationId);

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByRotationId(long rotationId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByRotationId(
			long rotationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByRotationId(
			long rotationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByRotationId_First(
			long rotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByRotationId_First(
		long rotationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByRotationId_Last(
			long rotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByRotationId_Last(
		long rotationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel[] findByRotationId_PrevAndNext(
			long progdurationRotationTsRelId, long rotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Removes all the progduration rotation trainingsites rels where rotationId = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 */
	public void removeByRotationId(long rotationId);

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByRotationId(long rotationId);

	/**
	 * Returns all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(long trainingSitesId);

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(long trainingSitesId, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(
			long trainingSitesId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(
			long trainingSitesId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByTrainingSitesId_First(
			long trainingSitesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByTrainingSitesId_First(
		long trainingSitesId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByTrainingSitesId_Last(
			long trainingSitesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByTrainingSitesId_Last(
		long trainingSitesId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel[]
			findByTrainingSitesId_PrevAndNext(
				long progdurationRotationTsRelId, long trainingSitesId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Removes all the progduration rotation trainingsites rels where trainingSitesId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 */
	public void removeByTrainingSitesId(long trainingSitesId);

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByTrainingSitesId(long trainingSitesId);

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByTrainingSiteAndRotationId(long trainingSitesId, long rotationId);

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, boolean useFinderCache);

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public ProgdurationRotationTrainingsitesRel
			removeByTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and rotationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByTrainingSiteAndRotationId(
		long trainingSitesId, long rotationId);

	/**
	 * Returns all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @return the matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation);

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
			findByRotationIdAndIsSharedRotation_First(
				long rotationId, boolean isSharedRotation,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByRotationIdAndIsSharedRotation_First(
			long rotationId, boolean isSharedRotation,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
			findByRotationIdAndIsSharedRotation_Last(
				long rotationId, boolean isSharedRotation,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByRotationIdAndIsSharedRotation_Last(
			long rotationId, boolean isSharedRotation,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel[]
			findByRotationIdAndIsSharedRotation_PrevAndNext(
				long progdurationRotationTsRelId, long rotationId,
				boolean isSharedRotation,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProgdurationRotationTrainingsitesRel> orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Removes all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 */
	public void removeByRotationIdAndIsSharedRotation(
		long rotationId, boolean isSharedRotation);

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByRotationIdAndIsSharedRotation(
		long rotationId, boolean isSharedRotation);

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
			findByProgDurationTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId, long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, long programDurationId);

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, long programDurationId,
			boolean useFinderCache);

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public ProgdurationRotationTrainingsitesRel
			removeByProgDurationTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId, long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByProgDurationTrainingSiteAndRotationId(
		long trainingSitesId, long rotationId, long programDurationId);

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
			findByProgDurationAndTrainingSite(
				long trainingSitesId, long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationAndTrainingSite(
			long trainingSitesId, long programDurationId);

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationAndTrainingSite(
			long trainingSitesId, long programDurationId,
			boolean useFinderCache);

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public ProgdurationRotationTrainingsitesRel
			removeByProgDurationAndTrainingSite(
				long trainingSitesId, long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and programDurationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByProgDurationAndTrainingSite(
		long trainingSitesId, long programDurationId);

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
			findByProgDurationRotationOwningProgramAndRotationId(
				long rotationOwningProgramId, long rotationId,
				long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationRotationOwningProgramAndRotationId(
			long rotationOwningProgramId, long rotationId,
			long programDurationId);

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationRotationOwningProgramAndRotationId(
			long rotationOwningProgramId, long rotationId,
			long programDurationId, boolean useFinderCache);

	/**
	 * Removes the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public ProgdurationRotationTrainingsitesRel
			removeByProgDurationRotationOwningProgramAndRotationId(
				long rotationOwningProgramId, long rotationId,
				long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63;.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public int countByProgDurationRotationOwningProgramAndRotationId(
		long rotationOwningProgramId, long rotationId, long programDurationId);

	/**
	 * Caches the progduration rotation trainingsites rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTrainingsitesRel the progduration rotation trainingsites rel
	 */
	public void cacheResult(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel);

	/**
	 * Caches the progduration rotation trainingsites rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTrainingsitesRels the progduration rotation trainingsites rels
	 */
	public void cacheResult(
		java.util.List<ProgdurationRotationTrainingsitesRel>
			progdurationRotationTrainingsitesRels);

	/**
	 * Creates a new progduration rotation trainingsites rel with the primary key. Does not add the progduration rotation trainingsites rel to the database.
	 *
	 * @param progdurationRotationTsRelId the primary key for the new progduration rotation trainingsites rel
	 * @return the new progduration rotation trainingsites rel
	 */
	public ProgdurationRotationTrainingsitesRel create(
		long progdurationRotationTsRelId);

	/**
	 * Removes the progduration rotation trainingsites rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel that was removed
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel remove(
			long progdurationRotationTsRelId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	public ProgdurationRotationTrainingsitesRel updateImpl(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel);

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel findByPrimaryKey(
			long progdurationRotationTsRelId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel, or <code>null</code> if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public ProgdurationRotationTrainingsitesRel fetchByPrimaryKey(
		long progdurationRotationTsRelId);

	/**
	 * Returns all the progduration rotation trainingsites rels.
	 *
	 * @return the progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findAll();

	/**
	 * Returns a range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator);

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation trainingsites rels
	 */
	public java.util.List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgdurationRotationTrainingsitesRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the progduration rotation trainingsites rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of progduration rotation trainingsites rels.
	 *
	 * @return the number of progduration rotation trainingsites rels
	 */
	public int countAll();

}
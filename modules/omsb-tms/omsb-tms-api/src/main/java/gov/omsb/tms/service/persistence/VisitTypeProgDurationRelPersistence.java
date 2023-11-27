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

import gov.omsb.tms.exception.NoSuchVisitTypeProgDurationRelException;
import gov.omsb.tms.model.VisitTypeProgDurationRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the visit type prog duration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeProgDurationRelUtil
 * @generated
 */
@ProviderType
public interface VisitTypeProgDurationRelPersistence
	extends BasePersistence<VisitTypeProgDurationRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VisitTypeProgDurationRelUtil} to access the visit type prog duration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the visit type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByUuid(String uuid);

	/**
	 * Returns a range of all the visit type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the visit type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the visit type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the first visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the last visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the last visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the visit type prog duration rels before and after the current visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the current visit type prog duration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	public VisitTypeProgDurationRel[] findByUuid_PrevAndNext(
			long VisitTypeProgDurationRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Removes all the visit type prog duration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of visit type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching visit type prog duration rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the visit type prog duration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVisitTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the visit type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the visit type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the visit type prog duration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the visit type prog duration rel that was removed
	 */
	public VisitTypeProgDurationRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the number of visit type prog duration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching visit type prog duration rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the first visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the last visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the last visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the visit type prog duration rels before and after the current visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the current visit type prog duration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	public VisitTypeProgDurationRel[] findByUuid_C_PrevAndNext(
			long VisitTypeProgDurationRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Removes all the visit type prog duration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching visit type prog duration rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the visit type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId);

	/**
	 * Returns a range of all the visit type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the visit type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the visit type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel findByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the first visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel fetchByProgramDurationId_First(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the last visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel findByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the last visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns the visit type prog duration rels before and after the current visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the current visit type prog duration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	public VisitTypeProgDurationRel[] findByProgramDurationId_PrevAndNext(
			long VisitTypeProgDurationRelId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Removes all the visit type prog duration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of visit type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching visit type prog duration rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns the visit type prog duration rel where programDurationId = &#63; and visitTypeMasterId = &#63; or throws a <code>NoSuchVisitTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @return the matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel findByProgramDurationIdAndVisitTypeMasterId(
			long programDurationId, long visitTypeMasterId)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the visit type prog duration rel where programDurationId = &#63; and visitTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel
		fetchByProgramDurationIdAndVisitTypeMasterId(
			long programDurationId, long visitTypeMasterId);

	/**
	 * Returns the visit type prog duration rel where programDurationId = &#63; and visitTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	public VisitTypeProgDurationRel
		fetchByProgramDurationIdAndVisitTypeMasterId(
			long programDurationId, long visitTypeMasterId,
			boolean useFinderCache);

	/**
	 * Removes the visit type prog duration rel where programDurationId = &#63; and visitTypeMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @return the visit type prog duration rel that was removed
	 */
	public VisitTypeProgDurationRel
			removeByProgramDurationIdAndVisitTypeMasterId(
				long programDurationId, long visitTypeMasterId)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the number of visit type prog duration rels where programDurationId = &#63; and visitTypeMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @return the number of matching visit type prog duration rels
	 */
	public int countByProgramDurationIdAndVisitTypeMasterId(
		long programDurationId, long visitTypeMasterId);

	/**
	 * Caches the visit type prog duration rel in the entity cache if it is enabled.
	 *
	 * @param visitTypeProgDurationRel the visit type prog duration rel
	 */
	public void cacheResult(VisitTypeProgDurationRel visitTypeProgDurationRel);

	/**
	 * Caches the visit type prog duration rels in the entity cache if it is enabled.
	 *
	 * @param visitTypeProgDurationRels the visit type prog duration rels
	 */
	public void cacheResult(
		java.util.List<VisitTypeProgDurationRel> visitTypeProgDurationRels);

	/**
	 * Creates a new visit type prog duration rel with the primary key. Does not add the visit type prog duration rel to the database.
	 *
	 * @param VisitTypeProgDurationRelId the primary key for the new visit type prog duration rel
	 * @return the new visit type prog duration rel
	 */
	public VisitTypeProgDurationRel create(long VisitTypeProgDurationRelId);

	/**
	 * Removes the visit type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel that was removed
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	public VisitTypeProgDurationRel remove(long VisitTypeProgDurationRelId)
		throws NoSuchVisitTypeProgDurationRelException;

	public VisitTypeProgDurationRel updateImpl(
		VisitTypeProgDurationRel visitTypeProgDurationRel);

	/**
	 * Returns the visit type prog duration rel with the primary key or throws a <code>NoSuchVisitTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	public VisitTypeProgDurationRel findByPrimaryKey(
			long VisitTypeProgDurationRelId)
		throws NoSuchVisitTypeProgDurationRelException;

	/**
	 * Returns the visit type prog duration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel, or <code>null</code> if a visit type prog duration rel with the primary key could not be found
	 */
	public VisitTypeProgDurationRel fetchByPrimaryKey(
		long VisitTypeProgDurationRelId);

	/**
	 * Returns all the visit type prog duration rels.
	 *
	 * @return the visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findAll();

	/**
	 * Returns a range of all the visit type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the visit type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator);

	/**
	 * Returns an ordered range of all the visit type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visit type prog duration rels
	 */
	public java.util.List<VisitTypeProgDurationRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<VisitTypeProgDurationRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the visit type prog duration rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of visit type prog duration rels.
	 *
	 * @return the number of visit type prog duration rels
	 */
	public int countAll();

}
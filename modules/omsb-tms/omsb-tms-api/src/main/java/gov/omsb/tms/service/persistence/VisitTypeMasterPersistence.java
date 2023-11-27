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

import gov.omsb.tms.exception.NoSuchVisitTypeMasterException;
import gov.omsb.tms.model.VisitTypeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the visit type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeMasterUtil
 * @generated
 */
@ProviderType
public interface VisitTypeMasterPersistence
	extends BasePersistence<VisitTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VisitTypeMasterUtil} to access the visit type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the visit type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public VisitTypeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public VisitTypeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public VisitTypeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public VisitTypeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public VisitTypeMaster[] findByUuid_PrevAndNext(
			long visitTypeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Removes all the visit type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of visit type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching visit type masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVisitTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public VisitTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public VisitTypeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public VisitTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the visit type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the visit type master that was removed
	 */
	public VisitTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the number of visit type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching visit type masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public VisitTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public VisitTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public VisitTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public VisitTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public VisitTypeMaster[] findByUuid_C_PrevAndNext(
			long visitTypeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Removes all the visit type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching visit type masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @return the matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName);

	/**
	 * Returns a range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end);

	/**
	 * Returns an ordered range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	public java.util.List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public VisitTypeMaster findByVisitTypeNameByLike_First(
			String visitTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the first visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public VisitTypeMaster fetchByVisitTypeNameByLike_First(
		String visitTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns the last visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public VisitTypeMaster findByVisitTypeNameByLike_Last(
			String visitTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the last visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public VisitTypeMaster fetchByVisitTypeNameByLike_Last(
		String visitTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public VisitTypeMaster[] findByVisitTypeNameByLike_PrevAndNext(
			long visitTypeMasterId, String visitTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
				orderByComparator)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Removes all the visit type masters where visitTypeName LIKE &#63; from the database.
	 *
	 * @param visitTypeName the visit type name
	 */
	public void removeByVisitTypeNameByLike(String visitTypeName);

	/**
	 * Returns the number of visit type masters where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @return the number of matching visit type masters
	 */
	public int countByVisitTypeNameByLike(String visitTypeName);

	/**
	 * Caches the visit type master in the entity cache if it is enabled.
	 *
	 * @param visitTypeMaster the visit type master
	 */
	public void cacheResult(VisitTypeMaster visitTypeMaster);

	/**
	 * Caches the visit type masters in the entity cache if it is enabled.
	 *
	 * @param visitTypeMasters the visit type masters
	 */
	public void cacheResult(java.util.List<VisitTypeMaster> visitTypeMasters);

	/**
	 * Creates a new visit type master with the primary key. Does not add the visit type master to the database.
	 *
	 * @param visitTypeMasterId the primary key for the new visit type master
	 * @return the new visit type master
	 */
	public VisitTypeMaster create(long visitTypeMasterId);

	/**
	 * Removes the visit type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master that was removed
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public VisitTypeMaster remove(long visitTypeMasterId)
		throws NoSuchVisitTypeMasterException;

	public VisitTypeMaster updateImpl(VisitTypeMaster visitTypeMaster);

	/**
	 * Returns the visit type master with the primary key or throws a <code>NoSuchVisitTypeMasterException</code> if it could not be found.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public VisitTypeMaster findByPrimaryKey(long visitTypeMasterId)
		throws NoSuchVisitTypeMasterException;

	/**
	 * Returns the visit type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master, or <code>null</code> if a visit type master with the primary key could not be found
	 */
	public VisitTypeMaster fetchByPrimaryKey(long visitTypeMasterId);

	/**
	 * Returns all the visit type masters.
	 *
	 * @return the visit type masters
	 */
	public java.util.List<VisitTypeMaster> findAll();

	/**
	 * Returns a range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of visit type masters
	 */
	public java.util.List<VisitTypeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visit type masters
	 */
	public java.util.List<VisitTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visit type masters
	 */
	public java.util.List<VisitTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisitTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the visit type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of visit type masters.
	 *
	 * @return the number of visit type masters
	 */
	public int countAll();

}
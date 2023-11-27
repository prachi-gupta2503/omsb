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

import gov.omsb.tms.exception.NoSuchCptCodeMasterException;
import gov.omsb.tms.model.CptCodeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cpt code master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CptCodeMasterUtil
 * @generated
 */
@ProviderType
public interface CptCodeMasterPersistence
	extends BasePersistence<CptCodeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CptCodeMasterUtil} to access the cpt code master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cpt code masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public CptCodeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public CptCodeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public CptCodeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public CptCodeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public CptCodeMaster[] findByUuid_PrevAndNext(
			long cptCodeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Removes all the cpt code masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cpt code masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cpt code masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCptCodeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public CptCodeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public CptCodeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public CptCodeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the cpt code master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cpt code master that was removed
	 */
	public CptCodeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the number of cpt code masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cpt code masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public CptCodeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public CptCodeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public CptCodeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public CptCodeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public CptCodeMaster[] findByUuid_C_PrevAndNext(
			long cptCodeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Removes all the cpt code masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cpt code masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @return the matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName);

	/**
	 * Returns a range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end);

	/**
	 * Returns an ordered range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	public java.util.List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public CptCodeMaster findByCptCodeNameByLike_First(
			String cptCodeName,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the first cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public CptCodeMaster fetchByCptCodeNameByLike_First(
		String cptCodeName,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns the last cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public CptCodeMaster findByCptCodeNameByLike_Last(
			String cptCodeName,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the last cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public CptCodeMaster fetchByCptCodeNameByLike_Last(
		String cptCodeName,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public CptCodeMaster[] findByCptCodeNameByLike_PrevAndNext(
			long cptCodeMasterId, String cptCodeName,
			com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
				orderByComparator)
		throws NoSuchCptCodeMasterException;

	/**
	 * Removes all the cpt code masters where cptCodeName LIKE &#63; from the database.
	 *
	 * @param cptCodeName the cpt code name
	 */
	public void removeByCptCodeNameByLike(String cptCodeName);

	/**
	 * Returns the number of cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @return the number of matching cpt code masters
	 */
	public int countByCptCodeNameByLike(String cptCodeName);

	/**
	 * Caches the cpt code master in the entity cache if it is enabled.
	 *
	 * @param cptCodeMaster the cpt code master
	 */
	public void cacheResult(CptCodeMaster cptCodeMaster);

	/**
	 * Caches the cpt code masters in the entity cache if it is enabled.
	 *
	 * @param cptCodeMasters the cpt code masters
	 */
	public void cacheResult(java.util.List<CptCodeMaster> cptCodeMasters);

	/**
	 * Creates a new cpt code master with the primary key. Does not add the cpt code master to the database.
	 *
	 * @param cptCodeMasterId the primary key for the new cpt code master
	 * @return the new cpt code master
	 */
	public CptCodeMaster create(long cptCodeMasterId);

	/**
	 * Removes the cpt code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master that was removed
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public CptCodeMaster remove(long cptCodeMasterId)
		throws NoSuchCptCodeMasterException;

	public CptCodeMaster updateImpl(CptCodeMaster cptCodeMaster);

	/**
	 * Returns the cpt code master with the primary key or throws a <code>NoSuchCptCodeMasterException</code> if it could not be found.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public CptCodeMaster findByPrimaryKey(long cptCodeMasterId)
		throws NoSuchCptCodeMasterException;

	/**
	 * Returns the cpt code master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master, or <code>null</code> if a cpt code master with the primary key could not be found
	 */
	public CptCodeMaster fetchByPrimaryKey(long cptCodeMasterId);

	/**
	 * Returns all the cpt code masters.
	 *
	 * @return the cpt code masters
	 */
	public java.util.List<CptCodeMaster> findAll();

	/**
	 * Returns a range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of cpt code masters
	 */
	public java.util.List<CptCodeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cpt code masters
	 */
	public java.util.List<CptCodeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cpt code masters
	 */
	public java.util.List<CptCodeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CptCodeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cpt code masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cpt code masters.
	 *
	 * @return the number of cpt code masters
	 */
	public int countAll();

}
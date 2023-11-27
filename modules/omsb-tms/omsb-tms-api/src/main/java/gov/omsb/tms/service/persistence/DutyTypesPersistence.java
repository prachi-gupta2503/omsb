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

import gov.omsb.tms.exception.NoSuchDutyTypesException;
import gov.omsb.tms.model.DutyTypes;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the duty types service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyTypesUtil
 * @generated
 */
@ProviderType
public interface DutyTypesPersistence extends BasePersistence<DutyTypes> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DutyTypesUtil} to access the duty types persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the duty typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty typeses
	 */
	public java.util.List<DutyTypes> findByUuid(String uuid);

	/**
	 * Returns a range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of matching duty typeses
	 */
	public java.util.List<DutyTypes> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty typeses
	 */
	public java.util.List<DutyTypes> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty typeses
	 */
	public java.util.List<DutyTypes> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public DutyTypes findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
				orderByComparator)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator);

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public DutyTypes findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
				orderByComparator)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator);

	/**
	 * Returns the duty typeses before and after the current duty types in the ordered set where uuid = &#63;.
	 *
	 * @param dutyTypeId the primary key of the current duty types
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	public DutyTypes[] findByUuid_PrevAndNext(
			long dutyTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
				orderByComparator)
		throws NoSuchDutyTypesException;

	/**
	 * Removes all the duty typeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of duty typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty typeses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public DutyTypes findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the duty types where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty types that was removed
	 */
	public DutyTypes removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the number of duty typeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty typeses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty typeses
	 */
	public java.util.List<DutyTypes> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of matching duty typeses
	 */
	public java.util.List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty typeses
	 */
	public java.util.List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty typeses
	 */
	public java.util.List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public DutyTypes findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
				orderByComparator)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator);

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public DutyTypes findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
				orderByComparator)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator);

	/**
	 * Returns the duty typeses before and after the current duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyTypeId the primary key of the current duty types
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	public DutyTypes[] findByUuid_C_PrevAndNext(
			long dutyTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
				orderByComparator)
		throws NoSuchDutyTypesException;

	/**
	 * Removes all the duty typeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty typeses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the duty types where dutyType = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyType the duty type
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public DutyTypes findByDutyType(String dutyType)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the duty types where dutyType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyType the duty type
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByDutyType(String dutyType);

	/**
	 * Returns the duty types where dutyType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByDutyType(String dutyType, boolean useFinderCache);

	/**
	 * Removes the duty types where dutyType = &#63; from the database.
	 *
	 * @param dutyType the duty type
	 * @return the duty types that was removed
	 */
	public DutyTypes removeByDutyType(String dutyType)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the number of duty typeses where dutyType = &#63;.
	 *
	 * @param dutyType the duty type
	 * @return the number of matching duty typeses
	 */
	public int countByDutyType(String dutyType);

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public DutyTypes findByDutyTypeAndStatus(String dutyType, String status)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByDutyTypeAndStatus(String dutyType, String status);

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public DutyTypes fetchByDutyTypeAndStatus(
		String dutyType, String status, boolean useFinderCache);

	/**
	 * Removes the duty types where dutyType = &#63; and status = &#63; from the database.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the duty types that was removed
	 */
	public DutyTypes removeByDutyTypeAndStatus(String dutyType, String status)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the number of duty typeses where dutyType = &#63; and status = &#63;.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the number of matching duty typeses
	 */
	public int countByDutyTypeAndStatus(String dutyType, String status);

	/**
	 * Caches the duty types in the entity cache if it is enabled.
	 *
	 * @param dutyTypes the duty types
	 */
	public void cacheResult(DutyTypes dutyTypes);

	/**
	 * Caches the duty typeses in the entity cache if it is enabled.
	 *
	 * @param dutyTypeses the duty typeses
	 */
	public void cacheResult(java.util.List<DutyTypes> dutyTypeses);

	/**
	 * Creates a new duty types with the primary key. Does not add the duty types to the database.
	 *
	 * @param dutyTypeId the primary key for the new duty types
	 * @return the new duty types
	 */
	public DutyTypes create(long dutyTypeId);

	/**
	 * Removes the duty types with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types that was removed
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	public DutyTypes remove(long dutyTypeId) throws NoSuchDutyTypesException;

	public DutyTypes updateImpl(DutyTypes dutyTypes);

	/**
	 * Returns the duty types with the primary key or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	public DutyTypes findByPrimaryKey(long dutyTypeId)
		throws NoSuchDutyTypesException;

	/**
	 * Returns the duty types with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types, or <code>null</code> if a duty types with the primary key could not be found
	 */
	public DutyTypes fetchByPrimaryKey(long dutyTypeId);

	/**
	 * Returns all the duty typeses.
	 *
	 * @return the duty typeses
	 */
	public java.util.List<DutyTypes> findAll();

	/**
	 * Returns a range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of duty typeses
	 */
	public java.util.List<DutyTypes> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty typeses
	 */
	public java.util.List<DutyTypes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty typeses
	 */
	public java.util.List<DutyTypes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyTypes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the duty typeses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of duty typeses.
	 *
	 * @return the number of duty typeses
	 */
	public int countAll();

}
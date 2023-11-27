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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the faculty rotation ts block details rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.FacultyRotationTsBlockDetailsRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRotationTsBlockDetailsRelPersistence
 * @generated
 */
public class FacultyRotationTsBlockDetailsRelUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		getPersistence().clearCache(facultyRotationTsBlockDetailsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, FacultyRotationTsBlockDetailsRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FacultyRotationTsBlockDetailsRel update(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		return getPersistence().update(facultyRotationTsBlockDetailsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FacultyRotationTsBlockDetailsRel update(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			facultyRotationTsBlockDetailsRel, serviceContext);
	}

	/**
	 * Returns all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel[] findByUuid_PrevAndNext(
			long facultyRotationTsBlockDetailsRelId, String uuid,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_PrevAndNext(
			facultyRotationTsBlockDetailsRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the faculty rotation ts block details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty rotation ts block details rel that was removed
	 */
	public static FacultyRotationTsBlockDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel[] findByUuid_C_PrevAndNext(
			long facultyRotationTsBlockDetailsRelId, String uuid,
			long companyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			facultyRotationTsBlockDetailsRelId, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @return the matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId) {

		return getPersistence().findByFacultyId(facultyId);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end) {

		return getPersistence().findByFacultyId(facultyId, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findByFacultyId(
			facultyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFacultyId(
			facultyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel findByFacultyId_First(
			long facultyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByFacultyId_First(
			facultyId, orderByComparator);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByFacultyId_First(
		long facultyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByFacultyId_First(
			facultyId, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel findByFacultyId_Last(
			long facultyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByFacultyId_Last(
			facultyId, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByFacultyId_Last(
		long facultyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByFacultyId_Last(
			facultyId, orderByComparator);
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel[]
			findByFacultyId_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId, long facultyId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByFacultyId_PrevAndNext(
			facultyRotationTsBlockDetailsRelId, facultyId, orderByComparator);
	}

	/**
	 * Removes all the faculty rotation ts block details rels where facultyId = &#63; from the database.
	 *
	 * @param facultyId the faculty ID
	 */
	public static void removeByFacultyId(long facultyId) {
		getPersistence().removeByFacultyId(facultyId);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public static int countByFacultyId(long facultyId) {
		return getPersistence().countByFacultyId(facultyId);
	}

	/**
	 * Returns all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {

		return getPersistence().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end) {

		return getPersistence().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_First(
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByProgDurationRotationTsRelId_First(
			progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_First(
			long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByProgDurationRotationTsRelId_First(
			progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_Last(
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByProgDurationRotationTsRelId_Last(
			progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_Last(
			long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByProgDurationRotationTsRelId_Last(
			progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel[]
			findByProgDurationRotationTsRelId_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByProgDurationRotationTsRelId_PrevAndNext(
			facultyRotationTsBlockDetailsRelId, progDurationRotationTsRelId,
			orderByComparator);
	}

	/**
	 * Removes all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	public static void removeByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		getPersistence().removeByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public static int countByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		return getPersistence().countByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
	}

	/**
	 * Returns all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @return the matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(long facultyId, String status) {

		return getPersistence().findByFacultyIdAndStatus(facultyId, status);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(
			long facultyId, String status, int start, int end) {

		return getPersistence().findByFacultyIdAndStatus(
			facultyId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(
			long facultyId, String status, int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().findByFacultyIdAndStatus(
			facultyId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(
			long facultyId, String status, int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByFacultyIdAndStatus(
			facultyId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			findByFacultyIdAndStatus_First(
				long facultyId, String status,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByFacultyIdAndStatus_First(
			facultyId, status, orderByComparator);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
		fetchByFacultyIdAndStatus_First(
			long facultyId, String status,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByFacultyIdAndStatus_First(
			facultyId, status, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			findByFacultyIdAndStatus_Last(
				long facultyId, String status,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByFacultyIdAndStatus_Last(
			facultyId, status, orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
		fetchByFacultyIdAndStatus_Last(
			long facultyId, String status,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByFacultyIdAndStatus_Last(
			facultyId, status, orderByComparator);
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel[]
			findByFacultyIdAndStatus_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId, long facultyId,
				String status,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByFacultyIdAndStatus_PrevAndNext(
			facultyRotationTsBlockDetailsRelId, facultyId, status,
			orderByComparator);
	}

	/**
	 * Removes all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63; from the database.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 */
	public static void removeByFacultyIdAndStatus(
		long facultyId, String status) {

		getPersistence().removeByFacultyIdAndStatus(facultyId, status);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public static int countByFacultyIdAndStatus(long facultyId, String status) {
		return getPersistence().countByFacultyIdAndStatus(facultyId, status);
	}

	/**
	 * Returns all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId) {

		return getPersistence().
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end) {

		return getPersistence().
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId, start,
				end);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId, start,
				end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId, start,
				end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId,
				orderByComparator);
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().
			fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId,
				orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId,
				orderByComparator);
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().
			fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId,
				orderByComparator);
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel[]
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId,
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_PrevAndNext(
				facultyRotationTsBlockDetailsRelId, blocksMetadataDetailsRelId,
				progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Removes all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	public static void
		removeByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId) {

		getPersistence().
			removeByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	public static int
		countByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId) {

		return getPersistence().
			countByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId);
	}

	/**
	 * Caches the faculty rotation ts block details rel in the entity cache if it is enabled.
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 */
	public static void cacheResult(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		getPersistence().cacheResult(facultyRotationTsBlockDetailsRel);
	}

	/**
	 * Caches the faculty rotation ts block details rels in the entity cache if it is enabled.
	 *
	 * @param facultyRotationTsBlockDetailsRels the faculty rotation ts block details rels
	 */
	public static void cacheResult(
		List<FacultyRotationTsBlockDetailsRel>
			facultyRotationTsBlockDetailsRels) {

		getPersistence().cacheResult(facultyRotationTsBlockDetailsRels);
	}

	/**
	 * Creates a new faculty rotation ts block details rel with the primary key. Does not add the faculty rotation ts block details rel to the database.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key for the new faculty rotation ts block details rel
	 * @return the new faculty rotation ts block details rel
	 */
	public static FacultyRotationTsBlockDetailsRel create(
		long facultyRotationTsBlockDetailsRelId) {

		return getPersistence().create(facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Removes the faculty rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was removed
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel remove(
			long facultyRotationTsBlockDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().remove(facultyRotationTsBlockDetailsRelId);
	}

	public static FacultyRotationTsBlockDetailsRel updateImpl(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		return getPersistence().updateImpl(facultyRotationTsBlockDetailsRel);
	}

	/**
	 * Returns the faculty rotation ts block details rel with the primary key or throws a <code>NoSuchFacultyRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel findByPrimaryKey(
			long facultyRotationTsBlockDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchFacultyRotationTsBlockDetailsRelException {

		return getPersistence().findByPrimaryKey(
			facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the faculty rotation ts block details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel, or <code>null</code> if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel fetchByPrimaryKey(
		long facultyRotationTsBlockDetailsRelId) {

		return getPersistence().fetchByPrimaryKey(
			facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns all the faculty rotation ts block details rels.
	 *
	 * @return the faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findAll(
		int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel> findAll(
		int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the faculty rotation ts block details rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of faculty rotation ts block details rels.
	 *
	 * @return the number of faculty rotation ts block details rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FacultyRotationTsBlockDetailsRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FacultyRotationTsBlockDetailsRelPersistence
		_persistence;

}
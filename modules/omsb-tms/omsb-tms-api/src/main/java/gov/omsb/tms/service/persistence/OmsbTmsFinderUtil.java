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

import gov.omsb.tms.model.OmsbTmsFinder;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the omsb tms finder service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.OmsbTmsFinderPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OmsbTmsFinderPersistence
 * @generated
 */
public class OmsbTmsFinderUtil {

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
	public static void clearCache(OmsbTmsFinder omsbTmsFinder) {
		getPersistence().clearCache(omsbTmsFinder);
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
	public static Map<Serializable, OmsbTmsFinder> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OmsbTmsFinder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OmsbTmsFinder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OmsbTmsFinder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OmsbTmsFinder update(OmsbTmsFinder omsbTmsFinder) {
		return getPersistence().update(omsbTmsFinder);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OmsbTmsFinder update(
		OmsbTmsFinder omsbTmsFinder, ServiceContext serviceContext) {

		return getPersistence().update(omsbTmsFinder, serviceContext);
	}

	/**
	 * Returns all the omsb tms finders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching omsb tms finders
	 */
	public static List<OmsbTmsFinder> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the omsb tms finders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @return the range of matching omsb tms finders
	 */
	public static List<OmsbTmsFinder> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching omsb tms finders
	 */
	public static List<OmsbTmsFinder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching omsb tms finders
	 */
	public static List<OmsbTmsFinder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder findByUuid_First(
			String uuid, OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder fetchByUuid_First(
		String uuid, OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder findByUuid_Last(
			String uuid, OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder fetchByUuid_Last(
		String uuid, OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the omsb tms finders before and after the current omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param omsbTmsFinderId the primary key of the current omsb tms finder
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	public static OmsbTmsFinder[] findByUuid_PrevAndNext(
			long omsbTmsFinderId, String uuid,
			OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().findByUuid_PrevAndNext(
			omsbTmsFinderId, uuid, orderByComparator);
	}

	/**
	 * Removes all the omsb tms finders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of omsb tms finders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching omsb tms finders
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the omsb tms finder where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchOmsbTmsFinderException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the omsb tms finder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the omsb tms finder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the omsb tms finder where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the omsb tms finder that was removed
	 */
	public static OmsbTmsFinder removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of omsb tms finders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching omsb tms finders
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching omsb tms finders
	 */
	public static List<OmsbTmsFinder> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @return the range of matching omsb tms finders
	 */
	public static List<OmsbTmsFinder> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching omsb tms finders
	 */
	public static List<OmsbTmsFinder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching omsb tms finders
	 */
	public static List<OmsbTmsFinder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	public static OmsbTmsFinder fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the omsb tms finders before and after the current omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param omsbTmsFinderId the primary key of the current omsb tms finder
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	public static OmsbTmsFinder[] findByUuid_C_PrevAndNext(
			long omsbTmsFinderId, String uuid, long companyId,
			OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().findByUuid_C_PrevAndNext(
			omsbTmsFinderId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the omsb tms finders where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching omsb tms finders
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the omsb tms finder in the entity cache if it is enabled.
	 *
	 * @param omsbTmsFinder the omsb tms finder
	 */
	public static void cacheResult(OmsbTmsFinder omsbTmsFinder) {
		getPersistence().cacheResult(omsbTmsFinder);
	}

	/**
	 * Caches the omsb tms finders in the entity cache if it is enabled.
	 *
	 * @param omsbTmsFinders the omsb tms finders
	 */
	public static void cacheResult(List<OmsbTmsFinder> omsbTmsFinders) {
		getPersistence().cacheResult(omsbTmsFinders);
	}

	/**
	 * Creates a new omsb tms finder with the primary key. Does not add the omsb tms finder to the database.
	 *
	 * @param omsbTmsFinderId the primary key for the new omsb tms finder
	 * @return the new omsb tms finder
	 */
	public static OmsbTmsFinder create(long omsbTmsFinderId) {
		return getPersistence().create(omsbTmsFinderId);
	}

	/**
	 * Removes the omsb tms finder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder that was removed
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	public static OmsbTmsFinder remove(long omsbTmsFinderId)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().remove(omsbTmsFinderId);
	}

	public static OmsbTmsFinder updateImpl(OmsbTmsFinder omsbTmsFinder) {
		return getPersistence().updateImpl(omsbTmsFinder);
	}

	/**
	 * Returns the omsb tms finder with the primary key or throws a <code>NoSuchOmsbTmsFinderException</code> if it could not be found.
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	public static OmsbTmsFinder findByPrimaryKey(long omsbTmsFinderId)
		throws gov.omsb.tms.exception.NoSuchOmsbTmsFinderException {

		return getPersistence().findByPrimaryKey(omsbTmsFinderId);
	}

	/**
	 * Returns the omsb tms finder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder, or <code>null</code> if a omsb tms finder with the primary key could not be found
	 */
	public static OmsbTmsFinder fetchByPrimaryKey(long omsbTmsFinderId) {
		return getPersistence().fetchByPrimaryKey(omsbTmsFinderId);
	}

	/**
	 * Returns all the omsb tms finders.
	 *
	 * @return the omsb tms finders
	 */
	public static List<OmsbTmsFinder> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the omsb tms finders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @return the range of omsb tms finders
	 */
	public static List<OmsbTmsFinder> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of omsb tms finders
	 */
	public static List<OmsbTmsFinder> findAll(
		int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of omsb tms finders
	 */
	public static List<OmsbTmsFinder> findAll(
		int start, int end, OrderByComparator<OmsbTmsFinder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the omsb tms finders from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of omsb tms finders.
	 *
	 * @return the number of omsb tms finders
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OmsbTmsFinderPersistence getPersistence() {
		return _persistence;
	}

	private static volatile OmsbTmsFinderPersistence _persistence;

}
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

package gov.omsb.form.builder.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.form.builder.model.FormRecordEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the form record entry service. This utility wraps <code>gov.omsb.form.builder.service.persistence.impl.FormRecordEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormRecordEntryPersistence
 * @generated
 */
public class FormRecordEntryUtil {

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
	public static void clearCache(FormRecordEntry formRecordEntry) {
		getPersistence().clearCache(formRecordEntry);
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
	public static Map<Serializable, FormRecordEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FormRecordEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FormRecordEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FormRecordEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FormRecordEntry update(FormRecordEntry formRecordEntry) {
		return getPersistence().update(formRecordEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FormRecordEntry update(
		FormRecordEntry formRecordEntry, ServiceContext serviceContext) {

		return getPersistence().update(formRecordEntry, serviceContext);
	}

	/**
	 * Returns all the form record entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching form record entries
	 */
	public static List<FormRecordEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the form record entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of matching form record entries
	 */
	public static List<FormRecordEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the form record entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form record entries
	 */
	public static List<FormRecordEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the form record entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form record entries
	 */
	public static List<FormRecordEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public static FormRecordEntry findByUuid_First(
			String uuid, OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByUuid_First(
		String uuid, OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public static FormRecordEntry findByUuid_Last(
			String uuid, OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByUuid_Last(
		String uuid, OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the form record entries before and after the current form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param formRecordEntryId the primary key of the current form record entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	public static FormRecordEntry[] findByUuid_PrevAndNext(
			long formRecordEntryId, String uuid,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			formRecordEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the form record entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of form record entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching form record entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public static FormRecordEntry findByUUID_G(String uuid, long groupId)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the form record entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form record entry that was removed
	 */
	public static FormRecordEntry removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of form record entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching form record entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching form record entries
	 */
	public static List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of matching form record entries
	 */
	public static List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form record entries
	 */
	public static List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form record entries
	 */
	public static List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public static FormRecordEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public static FormRecordEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the form record entries before and after the current form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param formRecordEntryId the primary key of the current form record entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	public static FormRecordEntry[] findByUuid_C_PrevAndNext(
			long formRecordEntryId, String uuid, long companyId,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			formRecordEntryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the form record entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching form record entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching form record entries
	 */
	public static List<FormRecordEntry> findByStatus(long groupId, int status) {
		return getPersistence().findByStatus(groupId, status);
	}

	/**
	 * Returns a range of all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of matching form record entries
	 */
	public static List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end) {

		return getPersistence().findByStatus(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form record entries
	 */
	public static List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().findByStatus(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form record entries
	 */
	public static List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public static FormRecordEntry findByStatus_First(
			long groupId, int status,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByStatus_First(
		long groupId, int status,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().fetchByStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public static FormRecordEntry findByStatus_Last(
			long groupId, int status,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByStatus_Last(
		long groupId, int status,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().fetchByStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the form record entries before and after the current form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param formRecordEntryId the primary key of the current form record entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	public static FormRecordEntry[] findByStatus_PrevAndNext(
			long formRecordEntryId, long groupId, int status,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByStatus_PrevAndNext(
			formRecordEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the form record entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByStatus(long groupId, int status) {
		getPersistence().removeByStatus(groupId, status);
	}

	/**
	 * Returns the number of form record entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching form record entries
	 */
	public static int countByStatus(long groupId, int status) {
		return getPersistence().countByStatus(groupId, status);
	}

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public static FormRecordEntry findByFormDefinitionIdAndRecordId(
			long formDefinitionId, long recordId)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId);
	}

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId) {

		return getPersistence().fetchByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId);
	}

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId, boolean useFinderCache) {

		return getPersistence().fetchByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId, useFinderCache);
	}

	/**
	 * Removes the form record entry where formDefinitionId = &#63; and recordId = &#63; from the database.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the form record entry that was removed
	 */
	public static FormRecordEntry removeByFormDefinitionIdAndRecordId(
			long formDefinitionId, long recordId)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().removeByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId);
	}

	/**
	 * Returns the number of form record entries where formDefinitionId = &#63; and recordId = &#63;.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the number of matching form record entries
	 */
	public static int countByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId) {

		return getPersistence().countByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId);
	}

	/**
	 * Caches the form record entry in the entity cache if it is enabled.
	 *
	 * @param formRecordEntry the form record entry
	 */
	public static void cacheResult(FormRecordEntry formRecordEntry) {
		getPersistence().cacheResult(formRecordEntry);
	}

	/**
	 * Caches the form record entries in the entity cache if it is enabled.
	 *
	 * @param formRecordEntries the form record entries
	 */
	public static void cacheResult(List<FormRecordEntry> formRecordEntries) {
		getPersistence().cacheResult(formRecordEntries);
	}

	/**
	 * Creates a new form record entry with the primary key. Does not add the form record entry to the database.
	 *
	 * @param formRecordEntryId the primary key for the new form record entry
	 * @return the new form record entry
	 */
	public static FormRecordEntry create(long formRecordEntryId) {
		return getPersistence().create(formRecordEntryId);
	}

	/**
	 * Removes the form record entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry that was removed
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	public static FormRecordEntry remove(long formRecordEntryId)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().remove(formRecordEntryId);
	}

	public static FormRecordEntry updateImpl(FormRecordEntry formRecordEntry) {
		return getPersistence().updateImpl(formRecordEntry);
	}

	/**
	 * Returns the form record entry with the primary key or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	public static FormRecordEntry findByPrimaryKey(long formRecordEntryId)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getPersistence().findByPrimaryKey(formRecordEntryId);
	}

	/**
	 * Returns the form record entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry, or <code>null</code> if a form record entry with the primary key could not be found
	 */
	public static FormRecordEntry fetchByPrimaryKey(long formRecordEntryId) {
		return getPersistence().fetchByPrimaryKey(formRecordEntryId);
	}

	/**
	 * Returns all the form record entries.
	 *
	 * @return the form record entries
	 */
	public static List<FormRecordEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the form record entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of form record entries
	 */
	public static List<FormRecordEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the form record entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form record entries
	 */
	public static List<FormRecordEntry> findAll(
		int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the form record entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of form record entries
	 */
	public static List<FormRecordEntry> findAll(
		int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the form record entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of form record entries.
	 *
	 * @return the number of form record entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FormRecordEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FormRecordEntryPersistence _persistence;

}
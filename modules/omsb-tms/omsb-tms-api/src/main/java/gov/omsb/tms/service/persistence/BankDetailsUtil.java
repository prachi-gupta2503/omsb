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

import gov.omsb.tms.model.BankDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the bank details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.BankDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankDetailsPersistence
 * @generated
 */
public class BankDetailsUtil {

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
	public static void clearCache(BankDetails bankDetails) {
		getPersistence().clearCache(bankDetails);
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
	public static Map<Serializable, BankDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BankDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BankDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BankDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BankDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BankDetails update(BankDetails bankDetails) {
		return getPersistence().update(bankDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BankDetails update(
		BankDetails bankDetails, ServiceContext serviceContext) {

		return getPersistence().update(bankDetails, serviceContext);
	}

	/**
	 * Returns all the bank detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bank detailses
	 */
	public static List<BankDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @return the range of matching bank detailses
	 */
	public static List<BankDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bank detailses
	 */
	public static List<BankDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bank detailses
	 */
	public static List<BankDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public static BankDetails findByUuid_First(
			String uuid, OrderByComparator<BankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchByUuid_First(
		String uuid, OrderByComparator<BankDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public static BankDetails findByUuid_Last(
			String uuid, OrderByComparator<BankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchByUuid_Last(
		String uuid, OrderByComparator<BankDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the bank detailses before and after the current bank details in the ordered set where uuid = &#63;.
	 *
	 * @param bankDetailsId the primary key of the current bank details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank details
	 * @throws NoSuchBankDetailsException if a bank details with the primary key could not be found
	 */
	public static BankDetails[] findByUuid_PrevAndNext(
			long bankDetailsId, String uuid,
			OrderByComparator<BankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			bankDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the bank detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of bank detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bank detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the bank details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBankDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public static BankDetails findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the bank details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the bank details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the bank details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bank details that was removed
	 */
	public static BankDetails removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of bank detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bank detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bank detailses
	 */
	public static List<BankDetails> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @return the range of matching bank detailses
	 */
	public static List<BankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bank detailses
	 */
	public static List<BankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BankDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bank detailses
	 */
	public static List<BankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BankDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public static BankDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BankDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public static BankDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BankDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the bank detailses before and after the current bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bankDetailsId the primary key of the current bank details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank details
	 * @throws NoSuchBankDetailsException if a bank details with the primary key could not be found
	 */
	public static BankDetails[] findByUuid_C_PrevAndNext(
			long bankDetailsId, String uuid, long companyId,
			OrderByComparator<BankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			bankDetailsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the bank detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bank detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the bank details where ecMemberRequestId = &#63; or throws a <code>NoSuchBankDetailsException</code> if it could not be found.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public static BankDetails findByEcMemberRequestId(long ecMemberRequestId)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Returns the bank details where ecMemberRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchByEcMemberRequestId(long ecMemberRequestId) {
		return getPersistence().fetchByEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Returns the bank details where ecMemberRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchByEcMemberRequestId(
		long ecMemberRequestId, boolean useFinderCache) {

		return getPersistence().fetchByEcMemberRequestId(
			ecMemberRequestId, useFinderCache);
	}

	/**
	 * Removes the bank details where ecMemberRequestId = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the bank details that was removed
	 */
	public static BankDetails removeByEcMemberRequestId(long ecMemberRequestId)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().removeByEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Returns the number of bank detailses where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the number of matching bank detailses
	 */
	public static int countByEcMemberRequestId(long ecMemberRequestId) {
		return getPersistence().countByEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Caches the bank details in the entity cache if it is enabled.
	 *
	 * @param bankDetails the bank details
	 */
	public static void cacheResult(BankDetails bankDetails) {
		getPersistence().cacheResult(bankDetails);
	}

	/**
	 * Caches the bank detailses in the entity cache if it is enabled.
	 *
	 * @param bankDetailses the bank detailses
	 */
	public static void cacheResult(List<BankDetails> bankDetailses) {
		getPersistence().cacheResult(bankDetailses);
	}

	/**
	 * Creates a new bank details with the primary key. Does not add the bank details to the database.
	 *
	 * @param bankDetailsId the primary key for the new bank details
	 * @return the new bank details
	 */
	public static BankDetails create(long bankDetailsId) {
		return getPersistence().create(bankDetailsId);
	}

	/**
	 * Removes the bank details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details that was removed
	 * @throws NoSuchBankDetailsException if a bank details with the primary key could not be found
	 */
	public static BankDetails remove(long bankDetailsId)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().remove(bankDetailsId);
	}

	public static BankDetails updateImpl(BankDetails bankDetails) {
		return getPersistence().updateImpl(bankDetails);
	}

	/**
	 * Returns the bank details with the primary key or throws a <code>NoSuchBankDetailsException</code> if it could not be found.
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details
	 * @throws NoSuchBankDetailsException if a bank details with the primary key could not be found
	 */
	public static BankDetails findByPrimaryKey(long bankDetailsId)
		throws gov.omsb.tms.exception.NoSuchBankDetailsException {

		return getPersistence().findByPrimaryKey(bankDetailsId);
	}

	/**
	 * Returns the bank details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details, or <code>null</code> if a bank details with the primary key could not be found
	 */
	public static BankDetails fetchByPrimaryKey(long bankDetailsId) {
		return getPersistence().fetchByPrimaryKey(bankDetailsId);
	}

	/**
	 * Returns all the bank detailses.
	 *
	 * @return the bank detailses
	 */
	public static List<BankDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @return the range of bank detailses
	 */
	public static List<BankDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bank detailses
	 */
	public static List<BankDetails> findAll(
		int start, int end, OrderByComparator<BankDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bank detailses
	 */
	public static List<BankDetails> findAll(
		int start, int end, OrderByComparator<BankDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bank detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bank detailses.
	 *
	 * @return the number of bank detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BankDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BankDetailsPersistence _persistence;

}
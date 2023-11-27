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

import gov.omsb.tms.model.PatientTypeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the patient type master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.PatientTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeMasterPersistence
 * @generated
 */
public class PatientTypeMasterUtil {

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
	public static void clearCache(PatientTypeMaster patientTypeMaster) {
		getPersistence().clearCache(patientTypeMaster);
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
	public static Map<Serializable, PatientTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PatientTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PatientTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PatientTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PatientTypeMaster update(
		PatientTypeMaster patientTypeMaster) {

		return getPersistence().update(patientTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PatientTypeMaster update(
		PatientTypeMaster patientTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(patientTypeMaster, serviceContext);
	}

	/**
	 * Returns all the patient type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient type masters
	 */
	public static List<PatientTypeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the patient type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the patient type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patient type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public static PatientTypeMaster findByUuid_First(
			String uuid, OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public static PatientTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public static PatientTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public static PatientTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the patient type masters before and after the current patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param patientTypeMasterId the primary key of the current patient type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public static PatientTypeMaster[] findByUuid_PrevAndNext(
			long patientTypeMasterId, String uuid,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			patientTypeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the patient type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of patient type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient type masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPatientTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public static PatientTypeMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public static PatientTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public static PatientTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the patient type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient type master that was removed
	 */
	public static PatientTypeMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of patient type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient type masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient type masters
	 */
	public static List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public static PatientTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public static PatientTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public static PatientTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public static PatientTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the patient type masters before and after the current patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param patientTypeMasterId the primary key of the current patient type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public static PatientTypeMaster[] findByUuid_C_PrevAndNext(
			long patientTypeMasterId, String uuid, long companyId,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			patientTypeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the patient type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient type masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @return the matching patient type masters
	 */
	public static List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName) {

		return getPersistence().findByPatientTypeNameByLike(patientTypeName);
	}

	/**
	 * Returns a range of all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param patientTypeName the patient type name
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end) {

		return getPersistence().findByPatientTypeNameByLike(
			patientTypeName, start, end);
	}

	/**
	 * Returns an ordered range of all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param patientTypeName the patient type name
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().findByPatientTypeNameByLike(
			patientTypeName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param patientTypeName the patient type name
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type masters
	 */
	public static List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPatientTypeNameByLike(
			patientTypeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public static PatientTypeMaster findByPatientTypeNameByLike_First(
			String patientTypeName,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByPatientTypeNameByLike_First(
			patientTypeName, orderByComparator);
	}

	/**
	 * Returns the first patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public static PatientTypeMaster fetchByPatientTypeNameByLike_First(
		String patientTypeName,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().fetchByPatientTypeNameByLike_First(
			patientTypeName, orderByComparator);
	}

	/**
	 * Returns the last patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public static PatientTypeMaster findByPatientTypeNameByLike_Last(
			String patientTypeName,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByPatientTypeNameByLike_Last(
			patientTypeName, orderByComparator);
	}

	/**
	 * Returns the last patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public static PatientTypeMaster fetchByPatientTypeNameByLike_Last(
		String patientTypeName,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().fetchByPatientTypeNameByLike_Last(
			patientTypeName, orderByComparator);
	}

	/**
	 * Returns the patient type masters before and after the current patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeMasterId the primary key of the current patient type master
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public static PatientTypeMaster[] findByPatientTypeNameByLike_PrevAndNext(
			long patientTypeMasterId, String patientTypeName,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByPatientTypeNameByLike_PrevAndNext(
			patientTypeMasterId, patientTypeName, orderByComparator);
	}

	/**
	 * Removes all the patient type masters where patientTypeName LIKE &#63; from the database.
	 *
	 * @param patientTypeName the patient type name
	 */
	public static void removeByPatientTypeNameByLike(String patientTypeName) {
		getPersistence().removeByPatientTypeNameByLike(patientTypeName);
	}

	/**
	 * Returns the number of patient type masters where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @return the number of matching patient type masters
	 */
	public static int countByPatientTypeNameByLike(String patientTypeName) {
		return getPersistence().countByPatientTypeNameByLike(patientTypeName);
	}

	/**
	 * Caches the patient type master in the entity cache if it is enabled.
	 *
	 * @param patientTypeMaster the patient type master
	 */
	public static void cacheResult(PatientTypeMaster patientTypeMaster) {
		getPersistence().cacheResult(patientTypeMaster);
	}

	/**
	 * Caches the patient type masters in the entity cache if it is enabled.
	 *
	 * @param patientTypeMasters the patient type masters
	 */
	public static void cacheResult(List<PatientTypeMaster> patientTypeMasters) {
		getPersistence().cacheResult(patientTypeMasters);
	}

	/**
	 * Creates a new patient type master with the primary key. Does not add the patient type master to the database.
	 *
	 * @param patientTypeMasterId the primary key for the new patient type master
	 * @return the new patient type master
	 */
	public static PatientTypeMaster create(long patientTypeMasterId) {
		return getPersistence().create(patientTypeMasterId);
	}

	/**
	 * Removes the patient type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master that was removed
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public static PatientTypeMaster remove(long patientTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().remove(patientTypeMasterId);
	}

	public static PatientTypeMaster updateImpl(
		PatientTypeMaster patientTypeMaster) {

		return getPersistence().updateImpl(patientTypeMaster);
	}

	/**
	 * Returns the patient type master with the primary key or throws a <code>NoSuchPatientTypeMasterException</code> if it could not be found.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public static PatientTypeMaster findByPrimaryKey(long patientTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchPatientTypeMasterException {

		return getPersistence().findByPrimaryKey(patientTypeMasterId);
	}

	/**
	 * Returns the patient type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master, or <code>null</code> if a patient type master with the primary key could not be found
	 */
	public static PatientTypeMaster fetchByPrimaryKey(
		long patientTypeMasterId) {

		return getPersistence().fetchByPrimaryKey(patientTypeMasterId);
	}

	/**
	 * Returns all the patient type masters.
	 *
	 * @return the patient type masters
	 */
	public static List<PatientTypeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the patient type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of patient type masters
	 */
	public static List<PatientTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the patient type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patient type masters
	 */
	public static List<PatientTypeMaster> findAll(
		int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patient type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of patient type masters
	 */
	public static List<PatientTypeMaster> findAll(
		int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the patient type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of patient type masters.
	 *
	 * @return the number of patient type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PatientTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PatientTypeMasterPersistence _persistence;

}
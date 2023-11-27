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

import gov.omsb.tms.model.PatientTypeProgDurationRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the patient type prog duration rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.PatientTypeProgDurationRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeProgDurationRelPersistence
 * @generated
 */
public class PatientTypeProgDurationRelUtil {

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
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		getPersistence().clearCache(patientTypeProgDurationRel);
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
	public static Map<Serializable, PatientTypeProgDurationRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PatientTypeProgDurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PatientTypeProgDurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PatientTypeProgDurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PatientTypeProgDurationRel update(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		return getPersistence().update(patientTypeProgDurationRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PatientTypeProgDurationRel update(
		PatientTypeProgDurationRel patientTypeProgDurationRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			patientTypeProgDurationRel, serviceContext);
	}

	/**
	 * Returns all the patient type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the patient type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel findByUuid_First(
			String uuid,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the patient type prog duration rels before and after the current patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the current patient type prog duration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	public static PatientTypeProgDurationRel[] findByUuid_PrevAndNext(
			long PatientTypeProgDurationRelId, String uuid,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByUuid_PrevAndNext(
			PatientTypeProgDurationRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the patient type prog duration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of patient type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient type prog duration rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the patient type prog duration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPatientTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the patient type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the patient type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the patient type prog duration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient type prog duration rel that was removed
	 */
	public static PatientTypeProgDurationRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of patient type prog duration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient type prog duration rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the patient type prog duration rels before and after the current patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the current patient type prog duration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	public static PatientTypeProgDurationRel[] findByUuid_C_PrevAndNext(
			long PatientTypeProgDurationRelId, String uuid, long companyId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			PatientTypeProgDurationRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the patient type prog duration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient type prog duration rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the patient type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByProgramDurationId(
		long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the patient type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the patient type prog duration rels before and after the current patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the current patient type prog duration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	public static PatientTypeProgDurationRel[]
			findByProgramDurationId_PrevAndNext(
				long PatientTypeProgDurationRelId, long programDurationId,
				OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			PatientTypeProgDurationRelId, programDurationId, orderByComparator);
	}

	/**
	 * Removes all the patient type prog duration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of patient type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching patient type prog duration rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the patient type prog duration rel where programDurationId = &#63; and patientTypeMasterId = &#63; or throws a <code>NoSuchPatientTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @return the matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel
			findByProgramDurationIdAndPatientTypeMasterId(
				long programDurationId, long patientTypeMasterId)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByProgramDurationIdAndPatientTypeMasterId(
			programDurationId, patientTypeMasterId);
	}

	/**
	 * Returns the patient type prog duration rel where programDurationId = &#63; and patientTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel
		fetchByProgramDurationIdAndPatientTypeMasterId(
			long programDurationId, long patientTypeMasterId) {

		return getPersistence().fetchByProgramDurationIdAndPatientTypeMasterId(
			programDurationId, patientTypeMasterId);
	}

	/**
	 * Returns the patient type prog duration rel where programDurationId = &#63; and patientTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	public static PatientTypeProgDurationRel
		fetchByProgramDurationIdAndPatientTypeMasterId(
			long programDurationId, long patientTypeMasterId,
			boolean useFinderCache) {

		return getPersistence().fetchByProgramDurationIdAndPatientTypeMasterId(
			programDurationId, patientTypeMasterId, useFinderCache);
	}

	/**
	 * Removes the patient type prog duration rel where programDurationId = &#63; and patientTypeMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @return the patient type prog duration rel that was removed
	 */
	public static PatientTypeProgDurationRel
			removeByProgramDurationIdAndPatientTypeMasterId(
				long programDurationId, long patientTypeMasterId)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().removeByProgramDurationIdAndPatientTypeMasterId(
			programDurationId, patientTypeMasterId);
	}

	/**
	 * Returns the number of patient type prog duration rels where programDurationId = &#63; and patientTypeMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @return the number of matching patient type prog duration rels
	 */
	public static int countByProgramDurationIdAndPatientTypeMasterId(
		long programDurationId, long patientTypeMasterId) {

		return getPersistence().countByProgramDurationIdAndPatientTypeMasterId(
			programDurationId, patientTypeMasterId);
	}

	/**
	 * Caches the patient type prog duration rel in the entity cache if it is enabled.
	 *
	 * @param patientTypeProgDurationRel the patient type prog duration rel
	 */
	public static void cacheResult(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		getPersistence().cacheResult(patientTypeProgDurationRel);
	}

	/**
	 * Caches the patient type prog duration rels in the entity cache if it is enabled.
	 *
	 * @param patientTypeProgDurationRels the patient type prog duration rels
	 */
	public static void cacheResult(
		List<PatientTypeProgDurationRel> patientTypeProgDurationRels) {

		getPersistence().cacheResult(patientTypeProgDurationRels);
	}

	/**
	 * Creates a new patient type prog duration rel with the primary key. Does not add the patient type prog duration rel to the database.
	 *
	 * @param PatientTypeProgDurationRelId the primary key for the new patient type prog duration rel
	 * @return the new patient type prog duration rel
	 */
	public static PatientTypeProgDurationRel create(
		long PatientTypeProgDurationRelId) {

		return getPersistence().create(PatientTypeProgDurationRelId);
	}

	/**
	 * Removes the patient type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel that was removed
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	public static PatientTypeProgDurationRel remove(
			long PatientTypeProgDurationRelId)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().remove(PatientTypeProgDurationRelId);
	}

	public static PatientTypeProgDurationRel updateImpl(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		return getPersistence().updateImpl(patientTypeProgDurationRel);
	}

	/**
	 * Returns the patient type prog duration rel with the primary key or throws a <code>NoSuchPatientTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	public static PatientTypeProgDurationRel findByPrimaryKey(
			long PatientTypeProgDurationRelId)
		throws gov.omsb.tms.exception.
			NoSuchPatientTypeProgDurationRelException {

		return getPersistence().findByPrimaryKey(PatientTypeProgDurationRelId);
	}

	/**
	 * Returns the patient type prog duration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel, or <code>null</code> if a patient type prog duration rel with the primary key could not be found
	 */
	public static PatientTypeProgDurationRel fetchByPrimaryKey(
		long PatientTypeProgDurationRelId) {

		return getPersistence().fetchByPrimaryKey(PatientTypeProgDurationRelId);
	}

	/**
	 * Returns all the patient type prog duration rels.
	 *
	 * @return the patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the patient type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of patient type prog duration rels
	 */
	public static List<PatientTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the patient type prog duration rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of patient type prog duration rels.
	 *
	 * @return the number of patient type prog duration rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PatientTypeProgDurationRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PatientTypeProgDurationRelPersistence _persistence;

}
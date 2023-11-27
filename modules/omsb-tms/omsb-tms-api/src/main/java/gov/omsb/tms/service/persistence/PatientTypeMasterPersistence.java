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

import gov.omsb.tms.exception.NoSuchPatientTypeMasterException;
import gov.omsb.tms.model.PatientTypeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the patient type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeMasterUtil
 * @generated
 */
@ProviderType
public interface PatientTypeMasterPersistence
	extends BasePersistence<PatientTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PatientTypeMasterUtil} to access the patient type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the patient type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient type masters
	 */
	public java.util.List<PatientTypeMaster> findByUuid(String uuid);

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
	public java.util.List<PatientTypeMaster> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PatientTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

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
	public java.util.List<PatientTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public PatientTypeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public PatientTypeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public PatientTypeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public PatientTypeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

	/**
	 * Returns the patient type masters before and after the current patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param patientTypeMasterId the primary key of the current patient type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public PatientTypeMaster[] findByUuid_PrevAndNext(
			long patientTypeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Removes all the patient type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of patient type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient type masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPatientTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public PatientTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public PatientTypeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public PatientTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the patient type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient type master that was removed
	 */
	public PatientTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the number of patient type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient type masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient type masters
	 */
	public java.util.List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

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
	public java.util.List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public PatientTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public PatientTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public PatientTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public PatientTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

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
	public PatientTypeMaster[] findByUuid_C_PrevAndNext(
			long patientTypeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Removes all the patient type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient type masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @return the matching patient type masters
	 */
	public java.util.List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName);

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
	public java.util.List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end);

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
	public java.util.List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

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
	public java.util.List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public PatientTypeMaster findByPatientTypeNameByLike_First(
			String patientTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the first patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public PatientTypeMaster fetchByPatientTypeNameByLike_First(
		String patientTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

	/**
	 * Returns the last patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	public PatientTypeMaster findByPatientTypeNameByLike_Last(
			String patientTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the last patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	public PatientTypeMaster fetchByPatientTypeNameByLike_Last(
		String patientTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

	/**
	 * Returns the patient type masters before and after the current patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeMasterId the primary key of the current patient type master
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public PatientTypeMaster[] findByPatientTypeNameByLike_PrevAndNext(
			long patientTypeMasterId, String patientTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
				orderByComparator)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Removes all the patient type masters where patientTypeName LIKE &#63; from the database.
	 *
	 * @param patientTypeName the patient type name
	 */
	public void removeByPatientTypeNameByLike(String patientTypeName);

	/**
	 * Returns the number of patient type masters where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @return the number of matching patient type masters
	 */
	public int countByPatientTypeNameByLike(String patientTypeName);

	/**
	 * Caches the patient type master in the entity cache if it is enabled.
	 *
	 * @param patientTypeMaster the patient type master
	 */
	public void cacheResult(PatientTypeMaster patientTypeMaster);

	/**
	 * Caches the patient type masters in the entity cache if it is enabled.
	 *
	 * @param patientTypeMasters the patient type masters
	 */
	public void cacheResult(
		java.util.List<PatientTypeMaster> patientTypeMasters);

	/**
	 * Creates a new patient type master with the primary key. Does not add the patient type master to the database.
	 *
	 * @param patientTypeMasterId the primary key for the new patient type master
	 * @return the new patient type master
	 */
	public PatientTypeMaster create(long patientTypeMasterId);

	/**
	 * Removes the patient type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master that was removed
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public PatientTypeMaster remove(long patientTypeMasterId)
		throws NoSuchPatientTypeMasterException;

	public PatientTypeMaster updateImpl(PatientTypeMaster patientTypeMaster);

	/**
	 * Returns the patient type master with the primary key or throws a <code>NoSuchPatientTypeMasterException</code> if it could not be found.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	public PatientTypeMaster findByPrimaryKey(long patientTypeMasterId)
		throws NoSuchPatientTypeMasterException;

	/**
	 * Returns the patient type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master, or <code>null</code> if a patient type master with the primary key could not be found
	 */
	public PatientTypeMaster fetchByPrimaryKey(long patientTypeMasterId);

	/**
	 * Returns all the patient type masters.
	 *
	 * @return the patient type masters
	 */
	public java.util.List<PatientTypeMaster> findAll();

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
	public java.util.List<PatientTypeMaster> findAll(int start, int end);

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
	public java.util.List<PatientTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator);

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
	public java.util.List<PatientTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the patient type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of patient type masters.
	 *
	 * @return the number of patient type masters
	 */
	public int countAll();

}
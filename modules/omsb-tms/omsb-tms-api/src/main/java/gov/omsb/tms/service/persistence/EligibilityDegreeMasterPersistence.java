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

import gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException;
import gov.omsb.tms.model.EligibilityDegreeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the eligibility degree master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EligibilityDegreeMasterUtil
 * @generated
 */
@ProviderType
public interface EligibilityDegreeMasterPersistence
	extends BasePersistence<EligibilityDegreeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EligibilityDegreeMasterUtil} to access the eligibility degree master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the eligibility degree masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public EligibilityDegreeMaster[] findByUuid_PrevAndNext(
			long eligibilityDegreeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Removes all the eligibility degree masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching eligibility degree masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEligibilityDegreeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the eligibility degree master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the eligibility degree master that was removed
	 */
	public EligibilityDegreeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching eligibility degree masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public EligibilityDegreeMaster[] findByUuid_C_PrevAndNext(
			long eligibilityDegreeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Removes all the eligibility degree masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching eligibility degree masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @return the matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster>
		findByeligibilityDegreeByLike(String eligibilityDegree);

	/**
	 * Returns a range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster>
		findByeligibilityDegreeByLike(
			String eligibilityDegree, int start, int end);

	/**
	 * Returns an ordered range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster>
		findByeligibilityDegreeByLike(
			String eligibilityDegree, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns an ordered range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster>
		findByeligibilityDegreeByLike(
			String eligibilityDegree, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster findByeligibilityDegreeByLike_First(
			String eligibilityDegree,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the first eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster fetchByeligibilityDegreeByLike_First(
		String eligibilityDegree,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns the last eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster findByeligibilityDegreeByLike_Last(
			String eligibilityDegree,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the last eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	public EligibilityDegreeMaster fetchByeligibilityDegreeByLike_Last(
		String eligibilityDegree,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public EligibilityDegreeMaster[] findByeligibilityDegreeByLike_PrevAndNext(
			long eligibilityDegreeMasterId, String eligibilityDegree,
			com.liferay.portal.kernel.util.OrderByComparator
				<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Removes all the eligibility degree masters where eligibilityDegree LIKE &#63; from the database.
	 *
	 * @param eligibilityDegree the eligibility degree
	 */
	public void removeByeligibilityDegreeByLike(String eligibilityDegree);

	/**
	 * Returns the number of eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @return the number of matching eligibility degree masters
	 */
	public int countByeligibilityDegreeByLike(String eligibilityDegree);

	/**
	 * Caches the eligibility degree master in the entity cache if it is enabled.
	 *
	 * @param eligibilityDegreeMaster the eligibility degree master
	 */
	public void cacheResult(EligibilityDegreeMaster eligibilityDegreeMaster);

	/**
	 * Caches the eligibility degree masters in the entity cache if it is enabled.
	 *
	 * @param eligibilityDegreeMasters the eligibility degree masters
	 */
	public void cacheResult(
		java.util.List<EligibilityDegreeMaster> eligibilityDegreeMasters);

	/**
	 * Creates a new eligibility degree master with the primary key. Does not add the eligibility degree master to the database.
	 *
	 * @param eligibilityDegreeMasterId the primary key for the new eligibility degree master
	 * @return the new eligibility degree master
	 */
	public EligibilityDegreeMaster create(long eligibilityDegreeMasterId);

	/**
	 * Removes the eligibility degree master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master that was removed
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public EligibilityDegreeMaster remove(long eligibilityDegreeMasterId)
		throws NoSuchEligibilityDegreeMasterException;

	public EligibilityDegreeMaster updateImpl(
		EligibilityDegreeMaster eligibilityDegreeMaster);

	/**
	 * Returns the eligibility degree master with the primary key or throws a <code>NoSuchEligibilityDegreeMasterException</code> if it could not be found.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	public EligibilityDegreeMaster findByPrimaryKey(
			long eligibilityDegreeMasterId)
		throws NoSuchEligibilityDegreeMasterException;

	/**
	 * Returns the eligibility degree master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master, or <code>null</code> if a eligibility degree master with the primary key could not be found
	 */
	public EligibilityDegreeMaster fetchByPrimaryKey(
		long eligibilityDegreeMasterId);

	/**
	 * Returns all the eligibility degree masters.
	 *
	 * @return the eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findAll();

	/**
	 * Returns a range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns an ordered range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of eligibility degree masters
	 */
	public java.util.List<EligibilityDegreeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EligibilityDegreeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the eligibility degree masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of eligibility degree masters.
	 *
	 * @return the number of eligibility degree masters
	 */
	public int countAll();

}
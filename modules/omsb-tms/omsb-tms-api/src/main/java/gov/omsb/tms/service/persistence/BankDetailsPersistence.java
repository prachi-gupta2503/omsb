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

import gov.omsb.tms.exception.NoSuchBankDetailsException;
import gov.omsb.tms.model.BankDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the bank details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankDetailsUtil
 * @generated
 */
@ProviderType
public interface BankDetailsPersistence extends BasePersistence<BankDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BankDetailsUtil} to access the bank details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the bank detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bank detailses
	 */
	public java.util.List<BankDetails> findByUuid(String uuid);

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
	public java.util.List<BankDetails> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<BankDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator);

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
	public java.util.List<BankDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public BankDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
				orderByComparator)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the first bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public BankDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator);

	/**
	 * Returns the last bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public BankDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
				orderByComparator)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the last bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public BankDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator);

	/**
	 * Returns the bank detailses before and after the current bank details in the ordered set where uuid = &#63;.
	 *
	 * @param bankDetailsId the primary key of the current bank details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank details
	 * @throws NoSuchBankDetailsException if a bank details with the primary key could not be found
	 */
	public BankDetails[] findByUuid_PrevAndNext(
			long bankDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
				orderByComparator)
		throws NoSuchBankDetailsException;

	/**
	 * Removes all the bank detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bank detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bank detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the bank details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBankDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public BankDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the bank details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public BankDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the bank details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public BankDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the bank details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bank details that was removed
	 */
	public BankDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the number of bank detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bank detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bank detailses
	 */
	public java.util.List<BankDetails> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<BankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<BankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator);

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
	public java.util.List<BankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public BankDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
				orderByComparator)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the first bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public BankDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator);

	/**
	 * Returns the last bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public BankDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
				orderByComparator)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the last bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public BankDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator);

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
	public BankDetails[] findByUuid_C_PrevAndNext(
			long bankDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
				orderByComparator)
		throws NoSuchBankDetailsException;

	/**
	 * Removes all the bank detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bank detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the bank details where ecMemberRequestId = &#63; or throws a <code>NoSuchBankDetailsException</code> if it could not be found.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the matching bank details
	 * @throws NoSuchBankDetailsException if a matching bank details could not be found
	 */
	public BankDetails findByEcMemberRequestId(long ecMemberRequestId)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the bank details where ecMemberRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public BankDetails fetchByEcMemberRequestId(long ecMemberRequestId);

	/**
	 * Returns the bank details where ecMemberRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public BankDetails fetchByEcMemberRequestId(
		long ecMemberRequestId, boolean useFinderCache);

	/**
	 * Removes the bank details where ecMemberRequestId = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the bank details that was removed
	 */
	public BankDetails removeByEcMemberRequestId(long ecMemberRequestId)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the number of bank detailses where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the number of matching bank detailses
	 */
	public int countByEcMemberRequestId(long ecMemberRequestId);

	/**
	 * Caches the bank details in the entity cache if it is enabled.
	 *
	 * @param bankDetails the bank details
	 */
	public void cacheResult(BankDetails bankDetails);

	/**
	 * Caches the bank detailses in the entity cache if it is enabled.
	 *
	 * @param bankDetailses the bank detailses
	 */
	public void cacheResult(java.util.List<BankDetails> bankDetailses);

	/**
	 * Creates a new bank details with the primary key. Does not add the bank details to the database.
	 *
	 * @param bankDetailsId the primary key for the new bank details
	 * @return the new bank details
	 */
	public BankDetails create(long bankDetailsId);

	/**
	 * Removes the bank details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details that was removed
	 * @throws NoSuchBankDetailsException if a bank details with the primary key could not be found
	 */
	public BankDetails remove(long bankDetailsId)
		throws NoSuchBankDetailsException;

	public BankDetails updateImpl(BankDetails bankDetails);

	/**
	 * Returns the bank details with the primary key or throws a <code>NoSuchBankDetailsException</code> if it could not be found.
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details
	 * @throws NoSuchBankDetailsException if a bank details with the primary key could not be found
	 */
	public BankDetails findByPrimaryKey(long bankDetailsId)
		throws NoSuchBankDetailsException;

	/**
	 * Returns the bank details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details, or <code>null</code> if a bank details with the primary key could not be found
	 */
	public BankDetails fetchByPrimaryKey(long bankDetailsId);

	/**
	 * Returns all the bank detailses.
	 *
	 * @return the bank detailses
	 */
	public java.util.List<BankDetails> findAll();

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
	public java.util.List<BankDetails> findAll(int start, int end);

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
	public java.util.List<BankDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator);

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
	public java.util.List<BankDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the bank detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bank detailses.
	 *
	 * @return the number of bank detailses
	 */
	public int countAll();

}
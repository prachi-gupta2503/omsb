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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import gov.omsb.form.builder.exception.NoSuchFormRecordEntryException;
import gov.omsb.form.builder.model.FormRecordEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the form record entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormRecordEntryUtil
 * @generated
 */
@ProviderType
public interface FormRecordEntryPersistence
	extends BasePersistence<FormRecordEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormRecordEntryUtil} to access the form record entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the form record entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching form record entries
	 */
	public java.util.List<FormRecordEntry> findByUuid(String uuid);

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
	public java.util.List<FormRecordEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<FormRecordEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

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
	public java.util.List<FormRecordEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public FormRecordEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public FormRecordEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

	/**
	 * Returns the form record entries before and after the current form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param formRecordEntryId the primary key of the current form record entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	public FormRecordEntry[] findByUuid_PrevAndNext(
			long formRecordEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Removes all the form record entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of form record entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching form record entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public FormRecordEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the form record entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form record entry that was removed
	 */
	public FormRecordEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the number of form record entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching form record entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching form record entries
	 */
	public java.util.List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

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
	public java.util.List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public FormRecordEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public FormRecordEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

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
	public FormRecordEntry[] findByUuid_C_PrevAndNext(
			long formRecordEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Removes all the form record entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching form record entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching form record entries
	 */
	public java.util.List<FormRecordEntry> findByStatus(
		long groupId, int status);

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
	public java.util.List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end);

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
	public java.util.List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

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
	public java.util.List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public FormRecordEntry findByStatus_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the first form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByStatus_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

	/**
	 * Returns the last form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public FormRecordEntry findByStatus_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the last form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByStatus_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

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
	public FormRecordEntry[] findByStatus_PrevAndNext(
			long formRecordEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
				orderByComparator)
		throws NoSuchFormRecordEntryException;

	/**
	 * Removes all the form record entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByStatus(long groupId, int status);

	/**
	 * Returns the number of form record entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching form record entries
	 */
	public int countByStatus(long groupId, int status);

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	public FormRecordEntry findByFormDefinitionIdAndRecordId(
			long formDefinitionId, long recordId)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId);

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public FormRecordEntry fetchByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId, boolean useFinderCache);

	/**
	 * Removes the form record entry where formDefinitionId = &#63; and recordId = &#63; from the database.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the form record entry that was removed
	 */
	public FormRecordEntry removeByFormDefinitionIdAndRecordId(
			long formDefinitionId, long recordId)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the number of form record entries where formDefinitionId = &#63; and recordId = &#63;.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the number of matching form record entries
	 */
	public int countByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId);

	/**
	 * Caches the form record entry in the entity cache if it is enabled.
	 *
	 * @param formRecordEntry the form record entry
	 */
	public void cacheResult(FormRecordEntry formRecordEntry);

	/**
	 * Caches the form record entries in the entity cache if it is enabled.
	 *
	 * @param formRecordEntries the form record entries
	 */
	public void cacheResult(java.util.List<FormRecordEntry> formRecordEntries);

	/**
	 * Creates a new form record entry with the primary key. Does not add the form record entry to the database.
	 *
	 * @param formRecordEntryId the primary key for the new form record entry
	 * @return the new form record entry
	 */
	public FormRecordEntry create(long formRecordEntryId);

	/**
	 * Removes the form record entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry that was removed
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	public FormRecordEntry remove(long formRecordEntryId)
		throws NoSuchFormRecordEntryException;

	public FormRecordEntry updateImpl(FormRecordEntry formRecordEntry);

	/**
	 * Returns the form record entry with the primary key or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	public FormRecordEntry findByPrimaryKey(long formRecordEntryId)
		throws NoSuchFormRecordEntryException;

	/**
	 * Returns the form record entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry, or <code>null</code> if a form record entry with the primary key could not be found
	 */
	public FormRecordEntry fetchByPrimaryKey(long formRecordEntryId);

	/**
	 * Returns all the form record entries.
	 *
	 * @return the form record entries
	 */
	public java.util.List<FormRecordEntry> findAll();

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
	public java.util.List<FormRecordEntry> findAll(int start, int end);

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
	public java.util.List<FormRecordEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator);

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
	public java.util.List<FormRecordEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormRecordEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the form record entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of form record entries.
	 *
	 * @return the number of form record entries
	 */
	public int countAll();

}
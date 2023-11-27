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

import gov.omsb.form.builder.exception.NoSuchFormDefinitionException;
import gov.omsb.form.builder.model.FormDefinition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the form definition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinitionUtil
 * @generated
 */
@ProviderType
public interface FormDefinitionPersistence
	extends BasePersistence<FormDefinition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormDefinitionUtil} to access the form definition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the form definitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching form definitions
	 */
	public java.util.List<FormDefinition> findByUuid(String uuid);

	/**
	 * Returns a range of all the form definitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the form definitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the form definitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns the form definitions before and after the current form definition in the ordered set where uuid = &#63;.
	 *
	 * @param formDefinitionId the primary key of the current form definition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public FormDefinition[] findByUuid_PrevAndNext(
			long formDefinitionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Removes all the form definitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of form definitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching form definitions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByUUID_G(String uuid, long groupId)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the form definition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form definition that was removed
	 */
	public FormDefinition removeByUUID_G(String uuid, long groupId)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the number of form definitions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching form definitions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching form definitions
	 */
	public java.util.List<FormDefinition> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns the form definitions before and after the current form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param formDefinitionId the primary key of the current form definition
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public FormDefinition[] findByUuid_C_PrevAndNext(
			long formDefinitionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Removes all the form definitions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching form definitions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the form definitions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching form definitions
	 */
	public java.util.List<FormDefinition> findByStatus(
		long groupId, int status);

	/**
	 * Returns a range of all the form definitions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByStatus(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the form definitions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the form definitions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByStatus_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the first form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByStatus_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns the last form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByStatus_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the last form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByStatus_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns the form definitions before and after the current form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param formDefinitionId the primary key of the current form definition
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public FormDefinition[] findByStatus_PrevAndNext(
			long formDefinitionId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Removes all the form definitions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByStatus(long groupId, int status);

	/**
	 * Returns the number of form definitions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching form definitions
	 */
	public int countByStatus(long groupId, int status);

	/**
	 * Returns all the form definitions where formName = &#63;.
	 *
	 * @param formName the form name
	 * @return the matching form definitions
	 */
	public java.util.List<FormDefinition> findByFormName(String formName);

	/**
	 * Returns a range of all the form definitions where formName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param formName the form name
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByFormName(
		String formName, int start, int end);

	/**
	 * Returns an ordered range of all the form definitions where formName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param formName the form name
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByFormName(
		String formName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the form definitions where formName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param formName the form name
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form definitions
	 */
	public java.util.List<FormDefinition> findByFormName(
		String formName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first form definition in the ordered set where formName = &#63;.
	 *
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByFormName_First(
			String formName,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the first form definition in the ordered set where formName = &#63;.
	 *
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByFormName_First(
		String formName,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns the last form definition in the ordered set where formName = &#63;.
	 *
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByFormName_Last(
			String formName,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the last form definition in the ordered set where formName = &#63;.
	 *
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByFormName_Last(
		String formName,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns the form definitions before and after the current form definition in the ordered set where formName = &#63;.
	 *
	 * @param formDefinitionId the primary key of the current form definition
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public FormDefinition[] findByFormName_PrevAndNext(
			long formDefinitionId, String formName,
			com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
				orderByComparator)
		throws NoSuchFormDefinitionException;

	/**
	 * Removes all the form definitions where formName = &#63; from the database.
	 *
	 * @param formName the form name
	 */
	public void removeByFormName(String formName);

	/**
	 * Returns the number of form definitions where formName = &#63;.
	 *
	 * @param formName the form name
	 * @return the number of matching form definitions
	 */
	public int countByFormName(String formName);

	/**
	 * Returns the form definition where formDefinitionId = &#63; and formVersion = &#63; or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @return the matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public FormDefinition findByFormDefinitionIdAndFormVersion(
			long formDefinitionId, String formVersion)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the form definition where formDefinitionId = &#63; and formVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByFormDefinitionIdAndFormVersion(
		long formDefinitionId, String formVersion);

	/**
	 * Returns the form definition where formDefinitionId = &#63; and formVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public FormDefinition fetchByFormDefinitionIdAndFormVersion(
		long formDefinitionId, String formVersion, boolean useFinderCache);

	/**
	 * Removes the form definition where formDefinitionId = &#63; and formVersion = &#63; from the database.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @return the form definition that was removed
	 */
	public FormDefinition removeByFormDefinitionIdAndFormVersion(
			long formDefinitionId, String formVersion)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the number of form definitions where formDefinitionId = &#63; and formVersion = &#63;.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @return the number of matching form definitions
	 */
	public int countByFormDefinitionIdAndFormVersion(
		long formDefinitionId, String formVersion);

	/**
	 * Caches the form definition in the entity cache if it is enabled.
	 *
	 * @param formDefinition the form definition
	 */
	public void cacheResult(FormDefinition formDefinition);

	/**
	 * Caches the form definitions in the entity cache if it is enabled.
	 *
	 * @param formDefinitions the form definitions
	 */
	public void cacheResult(java.util.List<FormDefinition> formDefinitions);

	/**
	 * Creates a new form definition with the primary key. Does not add the form definition to the database.
	 *
	 * @param formDefinitionId the primary key for the new form definition
	 * @return the new form definition
	 */
	public FormDefinition create(long formDefinitionId);

	/**
	 * Removes the form definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition that was removed
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public FormDefinition remove(long formDefinitionId)
		throws NoSuchFormDefinitionException;

	public FormDefinition updateImpl(FormDefinition formDefinition);

	/**
	 * Returns the form definition with the primary key or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public FormDefinition findByPrimaryKey(long formDefinitionId)
		throws NoSuchFormDefinitionException;

	/**
	 * Returns the form definition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition, or <code>null</code> if a form definition with the primary key could not be found
	 */
	public FormDefinition fetchByPrimaryKey(long formDefinitionId);

	/**
	 * Returns all the form definitions.
	 *
	 * @return the form definitions
	 */
	public java.util.List<FormDefinition> findAll();

	/**
	 * Returns a range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of form definitions
	 */
	public java.util.List<FormDefinition> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form definitions
	 */
	public java.util.List<FormDefinition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of form definitions
	 */
	public java.util.List<FormDefinition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormDefinition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the form definitions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of form definitions.
	 *
	 * @return the number of form definitions
	 */
	public int countAll();

}
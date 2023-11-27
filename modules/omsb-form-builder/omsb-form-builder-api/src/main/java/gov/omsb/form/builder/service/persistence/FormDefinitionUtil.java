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

import gov.omsb.form.builder.model.FormDefinition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the form definition service. This utility wraps <code>gov.omsb.form.builder.service.persistence.impl.FormDefinitionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinitionPersistence
 * @generated
 */
public class FormDefinitionUtil {

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
	public static void clearCache(FormDefinition formDefinition) {
		getPersistence().clearCache(formDefinition);
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
	public static Map<Serializable, FormDefinition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FormDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FormDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FormDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FormDefinition update(FormDefinition formDefinition) {
		return getPersistence().update(formDefinition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FormDefinition update(
		FormDefinition formDefinition, ServiceContext serviceContext) {

		return getPersistence().update(formDefinition, serviceContext);
	}

	/**
	 * Returns all the form definitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching form definitions
	 */
	public static List<FormDefinition> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<FormDefinition> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<FormDefinition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<FormDefinition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByUuid_First(
			String uuid, OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByUuid_First(
		String uuid, OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByUuid_Last(
			String uuid, OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByUuid_Last(
		String uuid, OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the form definitions before and after the current form definition in the ordered set where uuid = &#63;.
	 *
	 * @param formDefinitionId the primary key of the current form definition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public static FormDefinition[] findByUuid_PrevAndNext(
			long formDefinitionId, String uuid,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByUuid_PrevAndNext(
			formDefinitionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the form definitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of form definitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching form definitions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByUUID_G(String uuid, long groupId)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the form definition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form definition that was removed
	 */
	public static FormDefinition removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of form definitions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching form definitions
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching form definitions
	 */
	public static List<FormDefinition> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static FormDefinition[] findByUuid_C_PrevAndNext(
			long formDefinitionId, String uuid, long companyId,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			formDefinitionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the form definitions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching form definitions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the form definitions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching form definitions
	 */
	public static List<FormDefinition> findByStatus(long groupId, int status) {
		return getPersistence().findByStatus(groupId, status);
	}

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
	public static List<FormDefinition> findByStatus(
		long groupId, int status, int start, int end) {

		return getPersistence().findByStatus(groupId, status, start, end);
	}

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
	public static List<FormDefinition> findByStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().findByStatus(
			groupId, status, start, end, orderByComparator);
	}

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
	public static List<FormDefinition> findByStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByStatus_First(
			long groupId, int status,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByStatus_First(
		long groupId, int status,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().fetchByStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByStatus_Last(
			long groupId, int status,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last form definition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByStatus_Last(
		long groupId, int status,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().fetchByStatus_Last(
			groupId, status, orderByComparator);
	}

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
	public static FormDefinition[] findByStatus_PrevAndNext(
			long formDefinitionId, long groupId, int status,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByStatus_PrevAndNext(
			formDefinitionId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the form definitions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByStatus(long groupId, int status) {
		getPersistence().removeByStatus(groupId, status);
	}

	/**
	 * Returns the number of form definitions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching form definitions
	 */
	public static int countByStatus(long groupId, int status) {
		return getPersistence().countByStatus(groupId, status);
	}

	/**
	 * Returns all the form definitions where formName = &#63;.
	 *
	 * @param formName the form name
	 * @return the matching form definitions
	 */
	public static List<FormDefinition> findByFormName(String formName) {
		return getPersistence().findByFormName(formName);
	}

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
	public static List<FormDefinition> findByFormName(
		String formName, int start, int end) {

		return getPersistence().findByFormName(formName, start, end);
	}

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
	public static List<FormDefinition> findByFormName(
		String formName, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().findByFormName(
			formName, start, end, orderByComparator);
	}

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
	public static List<FormDefinition> findByFormName(
		String formName, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFormName(
			formName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first form definition in the ordered set where formName = &#63;.
	 *
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByFormName_First(
			String formName,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByFormName_First(
			formName, orderByComparator);
	}

	/**
	 * Returns the first form definition in the ordered set where formName = &#63;.
	 *
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByFormName_First(
		String formName, OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().fetchByFormName_First(
			formName, orderByComparator);
	}

	/**
	 * Returns the last form definition in the ordered set where formName = &#63;.
	 *
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByFormName_Last(
			String formName,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByFormName_Last(
			formName, orderByComparator);
	}

	/**
	 * Returns the last form definition in the ordered set where formName = &#63;.
	 *
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByFormName_Last(
		String formName, OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().fetchByFormName_Last(
			formName, orderByComparator);
	}

	/**
	 * Returns the form definitions before and after the current form definition in the ordered set where formName = &#63;.
	 *
	 * @param formDefinitionId the primary key of the current form definition
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public static FormDefinition[] findByFormName_PrevAndNext(
			long formDefinitionId, String formName,
			OrderByComparator<FormDefinition> orderByComparator)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByFormName_PrevAndNext(
			formDefinitionId, formName, orderByComparator);
	}

	/**
	 * Removes all the form definitions where formName = &#63; from the database.
	 *
	 * @param formName the form name
	 */
	public static void removeByFormName(String formName) {
		getPersistence().removeByFormName(formName);
	}

	/**
	 * Returns the number of form definitions where formName = &#63;.
	 *
	 * @param formName the form name
	 * @return the number of matching form definitions
	 */
	public static int countByFormName(String formName) {
		return getPersistence().countByFormName(formName);
	}

	/**
	 * Returns the form definition where formDefinitionId = &#63; and formVersion = &#63; or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @return the matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	public static FormDefinition findByFormDefinitionIdAndFormVersion(
			long formDefinitionId, String formVersion)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByFormDefinitionIdAndFormVersion(
			formDefinitionId, formVersion);
	}

	/**
	 * Returns the form definition where formDefinitionId = &#63; and formVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByFormDefinitionIdAndFormVersion(
		long formDefinitionId, String formVersion) {

		return getPersistence().fetchByFormDefinitionIdAndFormVersion(
			formDefinitionId, formVersion);
	}

	/**
	 * Returns the form definition where formDefinitionId = &#63; and formVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchByFormDefinitionIdAndFormVersion(
		long formDefinitionId, String formVersion, boolean useFinderCache) {

		return getPersistence().fetchByFormDefinitionIdAndFormVersion(
			formDefinitionId, formVersion, useFinderCache);
	}

	/**
	 * Removes the form definition where formDefinitionId = &#63; and formVersion = &#63; from the database.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @return the form definition that was removed
	 */
	public static FormDefinition removeByFormDefinitionIdAndFormVersion(
			long formDefinitionId, String formVersion)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().removeByFormDefinitionIdAndFormVersion(
			formDefinitionId, formVersion);
	}

	/**
	 * Returns the number of form definitions where formDefinitionId = &#63; and formVersion = &#63;.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param formVersion the form version
	 * @return the number of matching form definitions
	 */
	public static int countByFormDefinitionIdAndFormVersion(
		long formDefinitionId, String formVersion) {

		return getPersistence().countByFormDefinitionIdAndFormVersion(
			formDefinitionId, formVersion);
	}

	/**
	 * Caches the form definition in the entity cache if it is enabled.
	 *
	 * @param formDefinition the form definition
	 */
	public static void cacheResult(FormDefinition formDefinition) {
		getPersistence().cacheResult(formDefinition);
	}

	/**
	 * Caches the form definitions in the entity cache if it is enabled.
	 *
	 * @param formDefinitions the form definitions
	 */
	public static void cacheResult(List<FormDefinition> formDefinitions) {
		getPersistence().cacheResult(formDefinitions);
	}

	/**
	 * Creates a new form definition with the primary key. Does not add the form definition to the database.
	 *
	 * @param formDefinitionId the primary key for the new form definition
	 * @return the new form definition
	 */
	public static FormDefinition create(long formDefinitionId) {
		return getPersistence().create(formDefinitionId);
	}

	/**
	 * Removes the form definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition that was removed
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public static FormDefinition remove(long formDefinitionId)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().remove(formDefinitionId);
	}

	public static FormDefinition updateImpl(FormDefinition formDefinition) {
		return getPersistence().updateImpl(formDefinition);
	}

	/**
	 * Returns the form definition with the primary key or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	public static FormDefinition findByPrimaryKey(long formDefinitionId)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getPersistence().findByPrimaryKey(formDefinitionId);
	}

	/**
	 * Returns the form definition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition, or <code>null</code> if a form definition with the primary key could not be found
	 */
	public static FormDefinition fetchByPrimaryKey(long formDefinitionId) {
		return getPersistence().fetchByPrimaryKey(formDefinitionId);
	}

	/**
	 * Returns all the form definitions.
	 *
	 * @return the form definitions
	 */
	public static List<FormDefinition> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<FormDefinition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<FormDefinition> findAll(
		int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<FormDefinition> findAll(
		int start, int end, OrderByComparator<FormDefinition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the form definitions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of form definitions.
	 *
	 * @return the number of form definitions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FormDefinitionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FormDefinitionPersistence _persistence;

}
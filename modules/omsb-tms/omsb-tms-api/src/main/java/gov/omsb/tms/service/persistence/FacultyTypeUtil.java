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

import gov.omsb.tms.model.FacultyType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the faculty type service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.FacultyTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyTypePersistence
 * @generated
 */
public class FacultyTypeUtil {

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
	public static void clearCache(FacultyType facultyType) {
		getPersistence().clearCache(facultyType);
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
	public static Map<Serializable, FacultyType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FacultyType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FacultyType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FacultyType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FacultyType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FacultyType update(FacultyType facultyType) {
		return getPersistence().update(facultyType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FacultyType update(
		FacultyType facultyType, ServiceContext serviceContext) {

		return getPersistence().update(facultyType, serviceContext);
	}

	/**
	 * Returns the faculty type where code = &#63; or throws a <code>NoSuchFacultyTypeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching faculty type
	 * @throws NoSuchFacultyTypeException if a matching faculty type could not be found
	 */
	public static FacultyType findByCode(String code)
		throws gov.omsb.tms.exception.NoSuchFacultyTypeException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the faculty type where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching faculty type, or <code>null</code> if a matching faculty type could not be found
	 */
	public static FacultyType fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Returns the faculty type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty type, or <code>null</code> if a matching faculty type could not be found
	 */
	public static FacultyType fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Removes the faculty type where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the faculty type that was removed
	 */
	public static FacultyType removeByCode(String code)
		throws gov.omsb.tms.exception.NoSuchFacultyTypeException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of faculty types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching faculty types
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the faculty type in the entity cache if it is enabled.
	 *
	 * @param facultyType the faculty type
	 */
	public static void cacheResult(FacultyType facultyType) {
		getPersistence().cacheResult(facultyType);
	}

	/**
	 * Caches the faculty types in the entity cache if it is enabled.
	 *
	 * @param facultyTypes the faculty types
	 */
	public static void cacheResult(List<FacultyType> facultyTypes) {
		getPersistence().cacheResult(facultyTypes);
	}

	/**
	 * Creates a new faculty type with the primary key. Does not add the faculty type to the database.
	 *
	 * @param facultyTypeId the primary key for the new faculty type
	 * @return the new faculty type
	 */
	public static FacultyType create(long facultyTypeId) {
		return getPersistence().create(facultyTypeId);
	}

	/**
	 * Removes the faculty type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type that was removed
	 * @throws NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 */
	public static FacultyType remove(long facultyTypeId)
		throws gov.omsb.tms.exception.NoSuchFacultyTypeException {

		return getPersistence().remove(facultyTypeId);
	}

	public static FacultyType updateImpl(FacultyType facultyType) {
		return getPersistence().updateImpl(facultyType);
	}

	/**
	 * Returns the faculty type with the primary key or throws a <code>NoSuchFacultyTypeException</code> if it could not be found.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type
	 * @throws NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 */
	public static FacultyType findByPrimaryKey(long facultyTypeId)
		throws gov.omsb.tms.exception.NoSuchFacultyTypeException {

		return getPersistence().findByPrimaryKey(facultyTypeId);
	}

	/**
	 * Returns the faculty type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type, or <code>null</code> if a faculty type with the primary key could not be found
	 */
	public static FacultyType fetchByPrimaryKey(long facultyTypeId) {
		return getPersistence().fetchByPrimaryKey(facultyTypeId);
	}

	/**
	 * Returns all the faculty types.
	 *
	 * @return the faculty types
	 */
	public static List<FacultyType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @return the range of faculty types
	 */
	public static List<FacultyType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty types
	 */
	public static List<FacultyType> findAll(
		int start, int end, OrderByComparator<FacultyType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty types
	 */
	public static List<FacultyType> findAll(
		int start, int end, OrderByComparator<FacultyType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the faculty types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of faculty types.
	 *
	 * @return the number of faculty types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FacultyTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile FacultyTypePersistence _persistence;

}
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

import gov.omsb.tms.exception.NoSuchFacultyTypeException;
import gov.omsb.tms.model.FacultyType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faculty type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyTypeUtil
 * @generated
 */
@ProviderType
public interface FacultyTypePersistence extends BasePersistence<FacultyType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyTypeUtil} to access the faculty type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the faculty type where code = &#63; or throws a <code>NoSuchFacultyTypeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching faculty type
	 * @throws NoSuchFacultyTypeException if a matching faculty type could not be found
	 */
	public FacultyType findByCode(String code)
		throws NoSuchFacultyTypeException;

	/**
	 * Returns the faculty type where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching faculty type, or <code>null</code> if a matching faculty type could not be found
	 */
	public FacultyType fetchByCode(String code);

	/**
	 * Returns the faculty type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty type, or <code>null</code> if a matching faculty type could not be found
	 */
	public FacultyType fetchByCode(String code, boolean useFinderCache);

	/**
	 * Removes the faculty type where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the faculty type that was removed
	 */
	public FacultyType removeByCode(String code)
		throws NoSuchFacultyTypeException;

	/**
	 * Returns the number of faculty types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching faculty types
	 */
	public int countByCode(String code);

	/**
	 * Caches the faculty type in the entity cache if it is enabled.
	 *
	 * @param facultyType the faculty type
	 */
	public void cacheResult(FacultyType facultyType);

	/**
	 * Caches the faculty types in the entity cache if it is enabled.
	 *
	 * @param facultyTypes the faculty types
	 */
	public void cacheResult(java.util.List<FacultyType> facultyTypes);

	/**
	 * Creates a new faculty type with the primary key. Does not add the faculty type to the database.
	 *
	 * @param facultyTypeId the primary key for the new faculty type
	 * @return the new faculty type
	 */
	public FacultyType create(long facultyTypeId);

	/**
	 * Removes the faculty type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type that was removed
	 * @throws NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 */
	public FacultyType remove(long facultyTypeId)
		throws NoSuchFacultyTypeException;

	public FacultyType updateImpl(FacultyType facultyType);

	/**
	 * Returns the faculty type with the primary key or throws a <code>NoSuchFacultyTypeException</code> if it could not be found.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type
	 * @throws NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 */
	public FacultyType findByPrimaryKey(long facultyTypeId)
		throws NoSuchFacultyTypeException;

	/**
	 * Returns the faculty type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type, or <code>null</code> if a faculty type with the primary key could not be found
	 */
	public FacultyType fetchByPrimaryKey(long facultyTypeId);

	/**
	 * Returns all the faculty types.
	 *
	 * @return the faculty types
	 */
	public java.util.List<FacultyType> findAll();

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
	public java.util.List<FacultyType> findAll(int start, int end);

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
	public java.util.List<FacultyType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyType>
			orderByComparator);

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
	public java.util.List<FacultyType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faculty types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faculty types.
	 *
	 * @return the number of faculty types
	 */
	public int countAll();

}
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

import gov.omsb.tms.exception.NoSuchTraineeAdmissionDetailsRelException;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trainee admission details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeAdmissionDetailsRelUtil
 * @generated
 */
@ProviderType
public interface TraineeAdmissionDetailsRelPersistence
	extends BasePersistence<TraineeAdmissionDetailsRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraineeAdmissionDetailsRelUtil} to access the trainee admission details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainee admission details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByUuid(String uuid);

	/**
	 * Returns a range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public TraineeAdmissionDetailsRel[] findByUuid_PrevAndNext(
			long traineeAdmissionDetailsRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Removes all the trainee admission details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee admission details rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trainee admission details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee admission details rel that was removed
	 */
	public TraineeAdmissionDetailsRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee admission details rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public TraineeAdmissionDetailsRel[] findByUuid_C_PrevAndNext(
			long traineeAdmissionDetailsRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Removes all the trainee admission details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee admission details rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId);

	/**
	 * Returns a range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel findByProgramDurationId_First(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the first trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByProgramDurationId_First(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel findByProgramDurationId_Last(
			long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the last trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByProgramDurationId_Last(
		long programDurationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public TraineeAdmissionDetailsRel[] findByProgramDurationId_PrevAndNext(
			long traineeAdmissionDetailsRelId, long programDurationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Removes all the trainee admission details rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public void removeByProgramDurationId(long programDurationId);

	/**
	 * Returns the number of trainee admission details rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching trainee admission details rels
	 */
	public int countByProgramDurationId(long programDurationId);

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel findByTraineeId(long traineeId)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByTraineeId(long traineeId);

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByTraineeId(
		long traineeId, boolean useFinderCache);

	/**
	 * Removes the trainee admission details rel where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the trainee admission details rel that was removed
	 */
	public TraineeAdmissionDetailsRel removeByTraineeId(long traineeId)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the number of trainee admission details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee admission details rels
	 */
	public int countByTraineeId(long traineeId);

	/**
	 * Caches the trainee admission details rel in the entity cache if it is enabled.
	 *
	 * @param traineeAdmissionDetailsRel the trainee admission details rel
	 */
	public void cacheResult(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel);

	/**
	 * Caches the trainee admission details rels in the entity cache if it is enabled.
	 *
	 * @param traineeAdmissionDetailsRels the trainee admission details rels
	 */
	public void cacheResult(
		java.util.List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRels);

	/**
	 * Creates a new trainee admission details rel with the primary key. Does not add the trainee admission details rel to the database.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key for the new trainee admission details rel
	 * @return the new trainee admission details rel
	 */
	public TraineeAdmissionDetailsRel create(long traineeAdmissionDetailsRelId);

	/**
	 * Removes the trainee admission details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel that was removed
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public TraineeAdmissionDetailsRel remove(long traineeAdmissionDetailsRelId)
		throws NoSuchTraineeAdmissionDetailsRelException;

	public TraineeAdmissionDetailsRel updateImpl(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel);

	/**
	 * Returns the trainee admission details rel with the primary key or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public TraineeAdmissionDetailsRel findByPrimaryKey(
			long traineeAdmissionDetailsRelId)
		throws NoSuchTraineeAdmissionDetailsRelException;

	/**
	 * Returns the trainee admission details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel, or <code>null</code> if a trainee admission details rel with the primary key could not be found
	 */
	public TraineeAdmissionDetailsRel fetchByPrimaryKey(
		long traineeAdmissionDetailsRelId);

	/**
	 * Returns all the trainee admission details rels.
	 *
	 * @return the trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findAll();

	/**
	 * Returns a range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee admission details rels
	 */
	public java.util.List<TraineeAdmissionDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeAdmissionDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainee admission details rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainee admission details rels.
	 *
	 * @return the number of trainee admission details rels
	 */
	public int countAll();

}
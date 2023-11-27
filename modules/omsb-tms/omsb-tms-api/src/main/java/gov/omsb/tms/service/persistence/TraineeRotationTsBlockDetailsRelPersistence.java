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

import gov.omsb.tms.exception.NoSuchTraineeRotationTsBlockDetailsRelException;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trainee rotation ts block details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeRotationTsBlockDetailsRelUtil
 * @generated
 */
@ProviderType
public interface TraineeRotationTsBlockDetailsRelPersistence
	extends BasePersistence<TraineeRotationTsBlockDetailsRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraineeRotationTsBlockDetailsRelUtil} to access the trainee rotation ts block details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel[] findByUuid_PrevAndNext(
			long traineeRotationTsBlockDetailsRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Removes all the trainee rotation ts block details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee rotation ts block details rel that was removed
	 */
	public TraineeRotationTsBlockDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel[] findByUuid_C_PrevAndNext(
			long traineeRotationTsBlockDetailsRelId, String uuid,
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Removes all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId);

	/**
	 * Returns a range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelId_First(
				long blocksMetadataDetailsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelId_First(
			long blocksMetadataDetailsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelId_Last(
				long blocksMetadataDetailsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelId_Last(
			long blocksMetadataDetailsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel[]
			findByBlocksMetadataDetailsRelId_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId,
				long blocksMetadataDetailsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Removes all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 */
	public void removeByBlocksMetadataDetailsRelId(
		long blocksMetadataDetailsRelId);

	/**
	 * Returns the number of trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public int countByBlocksMetadataDetailsRelId(
		long blocksMetadataDetailsRelId);

	/**
	 * Returns all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId);

	/**
	 * Returns a range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByTraineeId_First(
			long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByTraineeId_First(
		long traineeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByTraineeId_Last(
			long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByTraineeId_Last(
		long traineeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel[] findByTraineeId_PrevAndNext(
			long traineeRotationTsBlockDetailsRelId, long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Removes all the trainee rotation ts block details rels where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	public void removeByTraineeId(long traineeId);

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public int countByTraineeId(long traineeId);

	/**
	 * Returns all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId);

	/**
	 * Returns a range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_First(
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_First(
			long progDurationRotationTsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_Last(
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_Last(
			long progDurationRotationTsRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel[]
			findByProgDurationRotationTsRelId_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId,
				long progDurationRotationTsRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Removes all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	public void removeByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId);

	/**
	 * Returns the number of trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public int countByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId);

	/**
	 * Returns all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @return the matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(long traineeId, String status);

	/**
	 * Returns a range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(
			long traineeId, String status, int start, int end);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(
			long traineeId, String status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(
			long traineeId, String status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByTraineeIdAndStatus_First(
			long traineeId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByTraineeIdAndStatus_First(
		long traineeId, String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByTraineeIdAndStatus_Last(
			long traineeId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByTraineeIdAndStatus_Last(
		long traineeId, String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel[]
			findByTraineeIdAndStatus_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId, long traineeId,
				String status,
				com.liferay.portal.kernel.util.OrderByComparator
					<TraineeRotationTsBlockDetailsRel> orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Removes all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 */
	public void removeByTraineeIdAndStatus(long traineeId, String status);

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public int countByTraineeIdAndStatus(long traineeId, String status);

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
			findByTraineeIdAndBlocksMetadataDetailsRelId(
				long traineeId, long blocksMetadataDetailsRelId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
		fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			long traineeId, long blocksMetadataDetailsRelId);

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public TraineeRotationTsBlockDetailsRel
		fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			long traineeId, long blocksMetadataDetailsRelId,
			boolean useFinderCache);

	/**
	 * Removes the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the trainee rotation ts block details rel that was removed
	 */
	public TraineeRotationTsBlockDetailsRel
			removeByTraineeIdAndBlocksMetadataDetailsRelId(
				long traineeId, long blocksMetadataDetailsRelId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63; and blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public int countByTraineeIdAndBlocksMetadataDetailsRelId(
		long traineeId, long blocksMetadataDetailsRelId);

	/**
	 * Caches the trainee rotation ts block details rel in the entity cache if it is enabled.
	 *
	 * @param traineeRotationTsBlockDetailsRel the trainee rotation ts block details rel
	 */
	public void cacheResult(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel);

	/**
	 * Caches the trainee rotation ts block details rels in the entity cache if it is enabled.
	 *
	 * @param traineeRotationTsBlockDetailsRels the trainee rotation ts block details rels
	 */
	public void cacheResult(
		java.util.List<TraineeRotationTsBlockDetailsRel>
			traineeRotationTsBlockDetailsRels);

	/**
	 * Creates a new trainee rotation ts block details rel with the primary key. Does not add the trainee rotation ts block details rel to the database.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key for the new trainee rotation ts block details rel
	 * @return the new trainee rotation ts block details rel
	 */
	public TraineeRotationTsBlockDetailsRel create(
		long traineeRotationTsBlockDetailsRelId);

	/**
	 * Removes the trainee rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel that was removed
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel remove(
			long traineeRotationTsBlockDetailsRelId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	public TraineeRotationTsBlockDetailsRel updateImpl(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel);

	/**
	 * Returns the trainee rotation ts block details rel with the primary key or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel findByPrimaryKey(
			long traineeRotationTsBlockDetailsRelId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException;

	/**
	 * Returns the trainee rotation ts block details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel, or <code>null</code> if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public TraineeRotationTsBlockDetailsRel fetchByPrimaryKey(
		long traineeRotationTsBlockDetailsRelId);

	/**
	 * Returns all the trainee rotation ts block details rels.
	 *
	 * @return the trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findAll();

	/**
	 * Returns a range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee rotation ts block details rels
	 */
	public java.util.List<TraineeRotationTsBlockDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainee rotation ts block details rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainee rotation ts block details rels.
	 *
	 * @return the number of trainee rotation ts block details rels
	 */
	public int countAll();

}
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

import gov.omsb.tms.exception.NoSuchTraineeLoggedProcedureDetailsException;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trainee logged procedure details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLoggedProcedureDetailsUtil
 * @generated
 */
@ProviderType
public interface TraineeLoggedProcedureDetailsPersistence
	extends BasePersistence<TraineeLoggedProcedureDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraineeLoggedProcedureDetailsUtil} to access the trainee logged procedure details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public TraineeLoggedProcedureDetails[] findByUuid_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Removes all the trainee logged procedure detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee logged procedure detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeLoggedProcedureDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trainee logged procedure details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee logged procedure details that was removed
	 */
	public TraineeLoggedProcedureDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public TraineeLoggedProcedureDetails[] findByUuid_C_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Removes all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId);

	/**
	 * Returns a range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByPatientId_First(
			String patientId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByPatientId_First(
		String patientId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByPatientId_Last(
			String patientId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByPatientId_Last(
		String patientId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public TraineeLoggedProcedureDetails[] findByPatientId_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String patientId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Removes all the trainee logged procedure detailses where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	public void removeByPatientId(String patientId);

	/**
	 * Returns the number of trainee logged procedure detailses where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public int countByPatientId(String patientId);

	/**
	 * Returns all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId);

	/**
	 * Returns a range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByPatientIdByLike_First(
			String patientId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByPatientIdByLike_First(
		String patientId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByPatientIdByLike_Last(
			String patientId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByPatientIdByLike_Last(
		String patientId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public TraineeLoggedProcedureDetails[] findByPatientIdByLike_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String patientId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Removes all the trainee logged procedure detailses where patientId LIKE &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	public void removeByPatientIdByLike(String patientId);

	/**
	 * Returns the number of trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public int countByPatientIdByLike(String patientId);

	/**
	 * Returns all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId);

	/**
	 * Returns a range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByTraineeId_First(
			long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the first trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByTraineeId_First(
		long traineeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the last trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails findByTraineeId_Last(
			long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the last trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByTraineeId_Last(
		long traineeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public TraineeLoggedProcedureDetails[] findByTraineeId_PrevAndNext(
			long traineeLoggedProcedureDetailsId, long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Removes all the trainee logged procedure detailses where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	public void removeByTraineeId(long traineeId);

	/**
	 * Returns the number of trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public int countByTraineeId(long traineeId);

	/**
	 * Caches the trainee logged procedure details in the entity cache if it is enabled.
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 */
	public void cacheResult(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails);

	/**
	 * Caches the trainee logged procedure detailses in the entity cache if it is enabled.
	 *
	 * @param traineeLoggedProcedureDetailses the trainee logged procedure detailses
	 */
	public void cacheResult(
		java.util.List<TraineeLoggedProcedureDetails>
			traineeLoggedProcedureDetailses);

	/**
	 * Creates a new trainee logged procedure details with the primary key. Does not add the trainee logged procedure details to the database.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key for the new trainee logged procedure details
	 * @return the new trainee logged procedure details
	 */
	public TraineeLoggedProcedureDetails create(
		long traineeLoggedProcedureDetailsId);

	/**
	 * Removes the trainee logged procedure details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details that was removed
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public TraineeLoggedProcedureDetails remove(
			long traineeLoggedProcedureDetailsId)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	public TraineeLoggedProcedureDetails updateImpl(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails);

	/**
	 * Returns the trainee logged procedure details with the primary key or throws a <code>NoSuchTraineeLoggedProcedureDetailsException</code> if it could not be found.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public TraineeLoggedProcedureDetails findByPrimaryKey(
			long traineeLoggedProcedureDetailsId)
		throws NoSuchTraineeLoggedProcedureDetailsException;

	/**
	 * Returns the trainee logged procedure details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details, or <code>null</code> if a trainee logged procedure details with the primary key could not be found
	 */
	public TraineeLoggedProcedureDetails fetchByPrimaryKey(
		long traineeLoggedProcedureDetailsId);

	/**
	 * Returns all the trainee logged procedure detailses.
	 *
	 * @return the trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findAll();

	/**
	 * Returns a range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee logged procedure detailses
	 */
	public java.util.List<TraineeLoggedProcedureDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainee logged procedure detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainee logged procedure detailses.
	 *
	 * @return the number of trainee logged procedure detailses
	 */
	public int countAll();

}
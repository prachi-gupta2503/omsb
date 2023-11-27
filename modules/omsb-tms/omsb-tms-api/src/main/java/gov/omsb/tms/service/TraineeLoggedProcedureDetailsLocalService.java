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

package gov.omsb.tms.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TraineeLoggedProcedureDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLoggedProcedureDetailsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TraineeLoggedProcedureDetailsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TraineeLoggedProcedureDetailsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the trainee logged procedure details local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TraineeLoggedProcedureDetailsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the trainee logged procedure details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLoggedProcedureDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 * @return the trainee logged procedure details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TraineeLoggedProcedureDetails addTraineeLoggedProcedureDetails(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new trainee logged procedure details with the primary key. Does not add the trainee logged procedure details to the database.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key for the new trainee logged procedure details
	 * @return the new trainee logged procedure details
	 */
	@Transactional(enabled = false)
	public TraineeLoggedProcedureDetails createTraineeLoggedProcedureDetails(
		long traineeLoggedProcedureDetailsId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the trainee logged procedure details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLoggedProcedureDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details that was removed
	 * @throws PortalException if a trainee logged procedure details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TraineeLoggedProcedureDetails deleteTraineeLoggedProcedureDetails(
			long traineeLoggedProcedureDetailsId)
		throws PortalException;

	/**
	 * Deletes the trainee logged procedure details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLoggedProcedureDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 * @return the trainee logged procedure details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TraineeLoggedProcedureDetails deleteTraineeLoggedProcedureDetails(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraineeLoggedProcedureDetails fetchTraineeLoggedProcedureDetails(
		long traineeLoggedProcedureDetailsId);

	/**
	 * Returns the trainee logged procedure details matching the UUID and group.
	 *
	 * @param uuid the trainee logged procedure details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraineeLoggedProcedureDetails
		fetchTraineeLoggedProcedureDetailsByUuidAndGroupId(
			String uuid, long groupId);

	public List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId);

	public List<TraineeLoggedProcedureDetails> findByTraineeId(long traineeId);

	public List<TraineeLoggedProcedureDetails>
		findTraineeLoggedProcedureDetailsByPatientId(String patientId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRotationIdByDatePerformed(
		String datePerformed, long traineeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraineeLoggedProcedureDetailsDTO getTraineeLoggedProcedureDetail(
		long supervisorId, long traineeLoggedProcedureDetailsId,
		String languageCode);

	/**
	 * Returns the trainee logged procedure details with the primary key.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details
	 * @throws PortalException if a trainee logged procedure details with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraineeLoggedProcedureDetails getTraineeLoggedProcedureDetails(
			long traineeLoggedProcedureDetailsId)
		throws PortalException;

	/**
	 * Returns the trainee logged procedure details matching the UUID and group.
	 *
	 * @param uuid the trainee logged procedure details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee logged procedure details
	 * @throws PortalException if a matching trainee logged procedure details could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraineeLoggedProcedureDetails
			getTraineeLoggedProcedureDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of trainee logged procedure detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraineeLoggedProcedureDetails>
		getTraineeLoggedProcedureDetailses(int start, int end);

	/**
	 * Returns all the trainee logged procedure detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee logged procedure detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee logged procedure detailses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraineeLoggedProcedureDetails>
		getTraineeLoggedProcedureDetailsesByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of trainee logged procedure detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee logged procedure detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee logged procedure detailses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraineeLoggedProcedureDetails>
		getTraineeLoggedProcedureDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator);

	/**
	 * Returns the number of trainee logged procedure detailses.
	 *
	 * @return the number of trainee logged procedure detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTraineeLoggedProcedureDetailsesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraineeLoggedProcedureDetailsDTO>
		getTraineeLoggedProcedureDetailsList(
			boolean isSuperVisor, boolean getByDedicatedProgram,
			long supervisorId, String programIds, String languageCode);

	/**
	 * Updates the trainee logged procedure details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLoggedProcedureDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 * @return the trainee logged procedure details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TraineeLoggedProcedureDetails updateTraineeLoggedProcedureDetails(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails);

}
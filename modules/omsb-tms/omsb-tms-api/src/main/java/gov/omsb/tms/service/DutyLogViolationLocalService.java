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

import gov.omsb.tms.custom.dto.DutyLogViolationDTO;
import gov.omsb.tms.model.DutyLogViolation;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DutyLogViolation. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DutyLogViolationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.DutyLogViolationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the duty log violation local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DutyLogViolationLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the duty log violation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogViolation the duty log violation
	 * @return the duty log violation that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DutyLogViolation addDutyLogViolation(
		DutyLogViolation dutyLogViolation);

	public DutyLogViolation addDutyLogViolation(
		long groupId, long companyId, long createdBy, long modifiedBy,
		long traineeId, long dutyLogId, long programMasterId,
		long residencyLevel, long rotationId, long trainingSiteId, long blockId,
		long blockWeekId, long programDutyRuleId);

	/**
	 * Creates a new duty log violation with the primary key. Does not add the duty log violation to the database.
	 *
	 * @param ViolationId the primary key for the new duty log violation
	 * @return the new duty log violation
	 */
	@Transactional(enabled = false)
	public DutyLogViolation createDutyLogViolation(long ViolationId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the duty log violation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogViolation the duty log violation
	 * @return the duty log violation that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DutyLogViolation deleteDutyLogViolation(
		DutyLogViolation dutyLogViolation);

	/**
	 * Deletes the duty log violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation that was removed
	 * @throws PortalException if a duty log violation with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DutyLogViolation deleteDutyLogViolation(long ViolationId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogViolationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogViolationModelImpl</code>.
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
	public DutyLogViolation fetchDutyLogViolation(long ViolationId);

	/**
	 * Returns the duty log violation matching the UUID and group.
	 *
	 * @param uuid the duty log violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLogViolation fetchDutyLogViolationByUuidAndGroupId(
		String uuid, long groupId);

	public DutyLogViolation findByDutyLogId(long dutyLogId);

	public DutyLogViolation findByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId);

	public DutyLogViolation findByTraineeId(long traineeId);

	public List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the duty log violation with the primary key.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation
	 * @throws PortalException if a duty log violation with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLogViolation getDutyLogViolation(long ViolationId)
		throws PortalException;

	/**
	 * Returns the duty log violation matching the UUID and group.
	 *
	 * @param uuid the duty log violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log violation
	 * @throws PortalException if a matching duty log violation could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLogViolation getDutyLogViolationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLogViolationDTO> getDutyLogViolationList(
		long programId, long traineeCohortId, long residencyLevelId,
		long traineeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLogViolationDTO> getDutyLogViolationListByUserId(
		long traineeId);

	/**
	 * Returns a range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of duty log violations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLogViolation> getDutyLogViolations(int start, int end);

	/**
	 * Returns all the duty log violations matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty log violations
	 * @param companyId the primary key of the company
	 * @return the matching duty log violations, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLogViolation> getDutyLogViolationsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of duty log violations matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty log violations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching duty log violations, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLogViolation> getDutyLogViolationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator);

	/**
	 * Returns the number of duty log violations.
	 *
	 * @return the number of duty log violations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDutyLogViolationsCount();

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

	/**
	 * Updates the duty log violation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogViolation the duty log violation
	 * @return the duty log violation that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DutyLogViolation updateDutyLogViolation(
		DutyLogViolation dutyLogViolation);

}
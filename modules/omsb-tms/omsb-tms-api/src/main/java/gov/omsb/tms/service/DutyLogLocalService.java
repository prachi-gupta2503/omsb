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

import gov.omsb.tms.custom.dto.DutyLogDTO;
import gov.omsb.tms.custom.dto.DutyLogHoursDTO;
import gov.omsb.tms.custom.dto.TraineeLevelListDTO;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.TraineeLevelMaster;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DutyLog. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DutyLogLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.DutyLogLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the duty log local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DutyLogLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the duty log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLog the duty log
	 * @return the duty log that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DutyLog addDutyLog(DutyLog dutyLog);

	public List<TraineeLevelListDTO> addToTraineeLevelListDTO(
		List<DutyLog> dutyLogs, String languageCode);

	/**
	 * Creates a new duty log with the primary key. Does not add the duty log to the database.
	 *
	 * @param dutyLogId the primary key for the new duty log
	 * @return the new duty log
	 */
	@Transactional(enabled = false)
	public DutyLog createDutyLog(long dutyLogId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the duty log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLog the duty log
	 * @return the duty log that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DutyLog deleteDutyLog(DutyLog dutyLog);

	/**
	 * Deletes the duty log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log that was removed
	 * @throws PortalException if a duty log with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DutyLog deleteDutyLog(long dutyLogId) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogModelImpl</code>.
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
	public DutyLog fetchDutyLog(long dutyLogId);

	/**
	 * Returns the duty log matching the UUID and group.
	 *
	 * @param uuid the duty log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLog fetchDutyLogByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLogDTO getAcgmeCallRule48Hour(
		long dutyTypeId, long traineeId, long blockId, long dutyLogId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLog> getByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLog> getByProgramDutyAssignmentId(
		long programDutyAssignmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraineeLevelListDTO> getByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programId, long cohortId, String languageCode);

	/**
	 * Returns the duty log with the primary key.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log
	 * @throws PortalException if a duty log with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLog getDutyLog(long dutyLogId) throws PortalException;

	/**
	 * Returns the duty log matching the UUID and group.
	 *
	 * @param uuid the duty log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log
	 * @throws PortalException if a matching duty log could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLog getDutyLogByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLogDTO getDutyLogDTO(long traineeId, String startDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLogHoursDTO> getDutyLogHours(
		long programId, long traineeCohortId, long residencyLevelId,
		long traineeId, String stratDate, String endDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLog> getDutyLogListByTraineeIdAndBlockId(
		long traineeId, long blocksMetadataDetailRelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLogDTO> getDutyLogs(
		Date startDate, Date endDate, long traineeId);

	/**
	 * Returns a range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of duty logs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLog> getDutyLogs(int start, int end);

	/**
	 * Returns all the duty logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty logs
	 * @param companyId the primary key of the company
	 * @return the matching duty logs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLog> getDutyLogsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of duty logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty logs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching duty logs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DutyLog> getDutyLogsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator);

	/**
	 * Returns the number of duty logs.
	 *
	 * @return the number of duty logs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDutyLogsCount();

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
	public DutyLog getPreviousDutyLog(long dutyLogId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DutyLog getPreviousDutyLog(
		long dutyLogId, long traineeId, long blockId, Date startDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isTraineeLevel(
		TraineeLevelMaster traineeLevelMaster,
		List<TraineeLevelListDTO> traineeLevelList);

	/**
	 * Updates the duty log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLog the duty log
	 * @return the duty log that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DutyLog updateDutyLog(DutyLog dutyLog);

}
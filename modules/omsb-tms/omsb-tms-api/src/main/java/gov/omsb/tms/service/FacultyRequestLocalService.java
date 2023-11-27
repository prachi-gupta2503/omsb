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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.custom.dto.FacultyRequestDTO;
import gov.omsb.tms.model.FacultyRequest;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for FacultyRequest. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FacultyRequestLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.FacultyRequestLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the faculty request local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FacultyRequestLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the faculty request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequest the faculty request
	 * @return the faculty request that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public FacultyRequest addFacultyRequest(FacultyRequest facultyRequest);

	public FacultyRequest addFacultyRequest(
			long groupId, long userId, long programId, long cvId)
		throws PortalException;

	/**
	 * Creates a new faculty request with the primary key. Does not add the faculty request to the database.
	 *
	 * @param facultyRequestId the primary key for the new faculty request
	 * @return the new faculty request
	 */
	@Transactional(enabled = false)
	public FacultyRequest createFacultyRequest(long facultyRequestId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the faculty request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequest the faculty request
	 * @return the faculty request that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public FacultyRequest deleteFacultyRequest(FacultyRequest facultyRequest);

	/**
	 * Deletes the faculty request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request that was removed
	 * @throws PortalException if a faculty request with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public FacultyRequest deleteFacultyRequest(long facultyRequestId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestModelImpl</code>.
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

	public FacultyRequest editFacultyRequest(
			long userId, long facultyRequestId, long potentialFacultyTypeId,
			long coveringLetterId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FacultyRequest fetchFacultyRequest(long facultyRequestId);

	/**
	 * Returns the faculty request matching the UUID and group.
	 *
	 * @param uuid the faculty request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FacultyRequest fetchFacultyRequestByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Returns the faculty request with the primary key.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request
	 * @throws PortalException if a faculty request with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FacultyRequest getFacultyRequest(long facultyRequestId)
		throws PortalException;

	/**
	 * Returns the faculty request matching the UUID and group.
	 *
	 * @param uuid the faculty request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request
	 * @throws PortalException if a matching faculty request could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FacultyRequest getFacultyRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FacultyRequestDTO> getFacultyRequestData(String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FacultyRequestDTO> getFacultyRequestDataBySearch(
		long programId, long facultyTypeId, long facultyRequestStatusId,
		String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FacultyRequest> getFacultyRequestList();

	/**
	 * Returns a range of all the faculty requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @return the range of faculty requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FacultyRequest> getFacultyRequests(int start, int end);

	/**
	 * Returns all the faculty requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty requests
	 * @param companyId the primary key of the company
	 * @return the matching faculty requests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FacultyRequest> getFacultyRequestsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of faculty requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty requests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FacultyRequest> getFacultyRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequest> orderByComparator);

	/**
	 * Returns the number of faculty requests.
	 *
	 * @return the number of faculty requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFacultyRequestsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FacultyRequestDTO> getMyFacultyRequests(
		long potentialFacultyId, String languageCode);

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
	public User getPotentialFacultyUser(long requestId);

	/**
	 * Updates the faculty request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequest the faculty request
	 * @return the faculty request that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public FacultyRequest updateFacultyRequest(FacultyRequest facultyRequest);

	public FacultyRequest updateLastestFacultyState(
		FacultyRequest facultyRequest, long lastestFacultyRequestStateId);

	public FacultyRequest updateRequest(FacultyRequest facultyRequest);

	public FacultyRequest updateStatus(
			long userId, long facultyRequestId, int status,
			ServiceContext serviceContext)
		throws PortalException;

}
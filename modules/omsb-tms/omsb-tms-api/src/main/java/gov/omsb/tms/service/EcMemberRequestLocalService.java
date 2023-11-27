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

import gov.omsb.tms.custom.dto.ECMembershipRequestListDTO;
import gov.omsb.tms.custom.dto.FacultySiteCompensationDTO;
import gov.omsb.tms.custom.dto.ResidentReportDTO;
import gov.omsb.tms.model.EcMemberRequest;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EcMemberRequest. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EcMemberRequestLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.EcMemberRequestLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the ec member request local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EcMemberRequestLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the ec member request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequest the ec member request
	 * @return the ec member request that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EcMemberRequest addEcMemberRequest(EcMemberRequest ecMemberRequest);

	/**
	 * Creates a new ec member request with the primary key. Does not add the ec member request to the database.
	 *
	 * @param ecMemberRequestId the primary key for the new ec member request
	 * @return the new ec member request
	 */
	@Transactional(enabled = false)
	public EcMemberRequest createEcMemberRequest(long ecMemberRequestId);

	public EcMemberRequest createNewRequest(
			EcMemberRequest ecMemberRequest, User user)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteAllRequests() throws PortalException;

	/**
	 * Deletes the ec member request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequest the ec member request
	 * @return the ec member request that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public EcMemberRequest deleteEcMemberRequest(
		EcMemberRequest ecMemberRequest);

	/**
	 * Deletes the ec member request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request that was removed
	 * @throws PortalException if a ec member request with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public EcMemberRequest deleteEcMemberRequest(long ecMemberRequestId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestModelImpl</code>.
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
	public EcMemberRequest fetchEcMemberRequest(long ecMemberRequestId);

	/**
	 * Returns the ec member request matching the UUID and group.
	 *
	 * @param uuid the ec member request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EcMemberRequest fetchEcMemberRequestByUuidAndGroupId(
		String uuid, long groupId);

	public EcMemberRequest findByPotentialEcMemberId(long potentialEcMemberId);

	public List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the ec member request with the primary key.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request
	 * @throws PortalException if a ec member request with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EcMemberRequest getEcMemberRequest(long ecMemberRequestId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EcMemberRequest getEcMemberRequestById(long ecMemberRequestId)
		throws PortalException;

	/**
	 * Returns the ec member request matching the UUID and group.
	 *
	 * @param uuid the ec member request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request
	 * @throws PortalException if a matching ec member request could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EcMemberRequest getEcMemberRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of ec member requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EcMemberRequest> getEcMemberRequests(int start, int end);

	/**
	 * Returns all the ec member requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member requests
	 * @param companyId the primary key of the company
	 * @return the matching ec member requests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EcMemberRequest> getEcMemberRequestsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of ec member requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ec member requests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EcMemberRequest> getEcMemberRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator);

	/**
	 * Returns the number of ec member requests.
	 *
	 * @return the number of ec member requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEcMemberRequestsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ECMembershipRequestListDTO> getECMembershipRequestData(
		long programId, long roleId, long statusId,
		long potentialEcMemberLrUserid, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FacultySiteCompensationDTO>
		getFacultySiteCompensationReportDetailsOfEcMember(
			String languageCode, long programId);

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
	public User getPotentialMemberUser(long requestId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResidentReportDTO> getResidentsInEachSitePerBlock(
		long programId, String annualYear, String languageCode);

	/**
	 * Updates the ec member request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequest the ec member request
	 * @return the ec member request that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EcMemberRequest updateEcMemberRequest(
		EcMemberRequest ecMemberRequest);

	public EcMemberRequest updateRequest(EcMemberRequest ecMemberRequest);

	public EcMemberRequest updateStatus(
			long userId, long ecMemberRequestId, int status,
			ServiceContext serviceContext)
		throws PortalException;

	public EcMemberRequest updateStatus(
			long userId, long roleId, long ecMemberRequestId, int status,
			String ecRequestStateCode, String comments,
			ServiceContext serviceContext)
		throws PortalException;

}
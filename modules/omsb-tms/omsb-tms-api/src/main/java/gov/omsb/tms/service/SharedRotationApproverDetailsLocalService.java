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

import gov.omsb.tms.model.SharedRotationApproverDetails;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SharedRotationApproverDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationApproverDetailsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SharedRotationApproverDetailsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.SharedRotationApproverDetailsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the shared rotation approver details local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SharedRotationApproverDetailsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the shared rotation approver details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationApproverDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 * @return the shared rotation approver details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SharedRotationApproverDetails addSharedRotationApproverDetails(
		SharedRotationApproverDetails sharedRotationApproverDetails);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new shared rotation approver details with the primary key. Does not add the shared rotation approver details to the database.
	 *
	 * @param sharedRotationApproverDetailsId the primary key for the new shared rotation approver details
	 * @return the new shared rotation approver details
	 */
	@Transactional(enabled = false)
	public SharedRotationApproverDetails createSharedRotationApproverDetails(
		long sharedRotationApproverDetailsId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the shared rotation approver details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationApproverDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details that was removed
	 * @throws PortalException if a shared rotation approver details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SharedRotationApproverDetails deleteSharedRotationApproverDetails(
			long sharedRotationApproverDetailsId)
		throws PortalException;

	/**
	 * Deletes the shared rotation approver details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationApproverDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 * @return the shared rotation approver details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SharedRotationApproverDetails deleteSharedRotationApproverDetails(
		SharedRotationApproverDetails sharedRotationApproverDetails);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationApproverDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationApproverDetailsModelImpl</code>.
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
	public SharedRotationApproverDetails fetchSharedRotationApproverDetails(
		long sharedRotationApproverDetailsId);

	/**
	 * Returns the shared rotation approver details matching the UUID and group.
	 *
	 * @param uuid the shared rotation approver details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SharedRotationApproverDetails
		fetchSharedRotationApproverDetailsByUuidAndGroupId(
			String uuid, long groupId);

	public SharedRotationApproverDetails findBySharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId);

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

	/**
	 * Returns the shared rotation approver details with the primary key.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details
	 * @throws PortalException if a shared rotation approver details with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SharedRotationApproverDetails getSharedRotationApproverDetails(
			long sharedRotationApproverDetailsId)
		throws PortalException;

	/**
	 * Returns the shared rotation approver details matching the UUID and group.
	 *
	 * @param uuid the shared rotation approver details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching shared rotation approver details
	 * @throws PortalException if a matching shared rotation approver details could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SharedRotationApproverDetails
			getSharedRotationApproverDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of shared rotation approver detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SharedRotationApproverDetails>
		getSharedRotationApproverDetailses(int start, int end);

	/**
	 * Returns all the shared rotation approver detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the shared rotation approver detailses
	 * @param companyId the primary key of the company
	 * @return the matching shared rotation approver detailses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SharedRotationApproverDetails>
		getSharedRotationApproverDetailsesByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of shared rotation approver detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the shared rotation approver detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching shared rotation approver detailses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SharedRotationApproverDetails>
		getSharedRotationApproverDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator);

	/**
	 * Returns the number of shared rotation approver detailses.
	 *
	 * @return the number of shared rotation approver detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSharedRotationApproverDetailsesCount();

	/**
	 * Updates the shared rotation approver details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationApproverDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 * @return the shared rotation approver details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SharedRotationApproverDetails updateSharedRotationApproverDetails(
		SharedRotationApproverDetails sharedRotationApproverDetails);

}
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

import gov.omsb.tms.model.ProgramWorkflowDetailsRel;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ProgramWorkflowDetailsRel. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramWorkflowDetailsRelLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ProgramWorkflowDetailsRelLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgramWorkflowDetailsRelLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the program workflow details rel local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ProgramWorkflowDetailsRelLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the program workflow details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ProgramWorkflowDetailsRel addProgramWorkflowDetailsRel(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new program workflow details rel with the primary key. Does not add the program workflow details rel to the database.
	 *
	 * @param programWorkflowDetailsRelId the primary key for the new program workflow details rel
	 * @return the new program workflow details rel
	 */
	@Transactional(enabled = false)
	public ProgramWorkflowDetailsRel createProgramWorkflowDetailsRel(
		long programWorkflowDetailsRelId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the program workflow details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel that was removed
	 * @throws PortalException if a program workflow details rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ProgramWorkflowDetailsRel deleteProgramWorkflowDetailsRel(
			long programWorkflowDetailsRelId)
		throws PortalException;

	/**
	 * Deletes the program workflow details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ProgramWorkflowDetailsRel deleteProgramWorkflowDetailsRel(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
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
	public ProgramWorkflowDetailsRel fetchProgramWorkflowDetailsRel(
		long programWorkflowDetailsRelId);

	/**
	 * Returns the program workflow details rel matching the UUID and group.
	 *
	 * @param uuid the program workflow details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgramWorkflowDetailsRel
		fetchProgramWorkflowDetailsRelByUuidAndGroupId(
			String uuid, long groupId);

	public ProgramWorkflowDetailsRel findByProgramId(long programId);

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
	 * Returns the program workflow details rel with the primary key.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel
	 * @throws PortalException if a program workflow details rel with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgramWorkflowDetailsRel getProgramWorkflowDetailsRel(
			long programWorkflowDetailsRelId)
		throws PortalException;

	/**
	 * Returns the program workflow details rel matching the UUID and group.
	 *
	 * @param uuid the program workflow details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program workflow details rel
	 * @throws PortalException if a matching program workflow details rel could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgramWorkflowDetailsRel
			getProgramWorkflowDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of program workflow details rels
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgramWorkflowDetailsRel> getProgramWorkflowDetailsRels(
		int start, int end);

	/**
	 * Returns all the program workflow details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program workflow details rels
	 * @param companyId the primary key of the company
	 * @return the matching program workflow details rels, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgramWorkflowDetailsRel>
		getProgramWorkflowDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of program workflow details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program workflow details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program workflow details rels, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgramWorkflowDetailsRel>
		getProgramWorkflowDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator);

	/**
	 * Returns the number of program workflow details rels.
	 *
	 * @return the number of program workflow details rels
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProgramWorkflowDetailsRelsCount();

	/**
	 * Updates the program workflow details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ProgramWorkflowDetailsRel updateProgramWorkflowDetailsRel(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel);

}
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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RotationObjectivesRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RotationObjectivesRelLocalService
 * @generated
 */
public class RotationObjectivesRelLocalServiceWrapper
	implements RotationObjectivesRelLocalService,
			   ServiceWrapper<RotationObjectivesRelLocalService> {

	public RotationObjectivesRelLocalServiceWrapper() {
		this(null);
	}

	public RotationObjectivesRelLocalServiceWrapper(
		RotationObjectivesRelLocalService rotationObjectivesRelLocalService) {

		_rotationObjectivesRelLocalService = rotationObjectivesRelLocalService;
	}

	/**
	 * Adds the rotation objectives rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationObjectivesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationObjectivesRel the rotation objectives rel
	 * @return the rotation objectives rel that was added
	 */
	@Override
	public gov.omsb.tms.model.RotationObjectivesRel addRotationObjectivesRel(
		gov.omsb.tms.model.RotationObjectivesRel rotationObjectivesRel) {

		return _rotationObjectivesRelLocalService.addRotationObjectivesRel(
			rotationObjectivesRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationObjectivesRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new rotation objectives rel with the primary key. Does not add the rotation objectives rel to the database.
	 *
	 * @param rotationObjectivesRelId the primary key for the new rotation objectives rel
	 * @return the new rotation objectives rel
	 */
	@Override
	public gov.omsb.tms.model.RotationObjectivesRel createRotationObjectivesRel(
		long rotationObjectivesRelId) {

		return _rotationObjectivesRelLocalService.createRotationObjectivesRel(
			rotationObjectivesRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationObjectivesRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rotation objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationObjectivesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel that was removed
	 * @throws PortalException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationObjectivesRel deleteRotationObjectivesRel(
			long rotationObjectivesRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationObjectivesRelLocalService.deleteRotationObjectivesRel(
			rotationObjectivesRelId);
	}

	/**
	 * Deletes the rotation objectives rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationObjectivesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationObjectivesRel the rotation objectives rel
	 * @return the rotation objectives rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.RotationObjectivesRel deleteRotationObjectivesRel(
		gov.omsb.tms.model.RotationObjectivesRel rotationObjectivesRel) {

		return _rotationObjectivesRelLocalService.deleteRotationObjectivesRel(
			rotationObjectivesRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rotationObjectivesRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rotationObjectivesRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rotationObjectivesRelLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _rotationObjectivesRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _rotationObjectivesRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _rotationObjectivesRelLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _rotationObjectivesRelLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _rotationObjectivesRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.RotationObjectivesRel fetchRotationObjectivesRel(
		long rotationObjectivesRelId) {

		return _rotationObjectivesRelLocalService.fetchRotationObjectivesRel(
			rotationObjectivesRelId);
	}

	/**
	 * Returns the rotation objectives rel matching the UUID and group.
	 *
	 * @param uuid the rotation objectives rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationObjectivesRel
		fetchRotationObjectivesRelByUuidAndGroupId(String uuid, long groupId) {

		return _rotationObjectivesRelLocalService.
			fetchRotationObjectivesRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rotationObjectivesRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _rotationObjectivesRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rotationObjectivesRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rotationObjectivesRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationObjectivesRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the rotation objectives rel with the primary key.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel
	 * @throws PortalException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationObjectivesRel getRotationObjectivesRel(
			long rotationObjectivesRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationObjectivesRelLocalService.getRotationObjectivesRel(
			rotationObjectivesRelId);
	}

	/**
	 * Returns the rotation objectives rel matching the UUID and group.
	 *
	 * @param uuid the rotation objectives rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation objectives rel
	 * @throws PortalException if a matching rotation objectives rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationObjectivesRel
			getRotationObjectivesRelByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationObjectivesRelLocalService.
			getRotationObjectivesRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of rotation objectives rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationObjectivesRel>
		getRotationObjectivesRels(int start, int end) {

		return _rotationObjectivesRelLocalService.getRotationObjectivesRels(
			start, end);
	}

	/**
	 * Returns all the rotation objectives rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation objectives rels
	 * @param companyId the primary key of the company
	 * @return the matching rotation objectives rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationObjectivesRel>
		getRotationObjectivesRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _rotationObjectivesRelLocalService.
			getRotationObjectivesRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of rotation objectives rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation objectives rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching rotation objectives rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationObjectivesRel>
		getRotationObjectivesRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.RotationObjectivesRel> orderByComparator) {

		return _rotationObjectivesRelLocalService.
			getRotationObjectivesRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rotation objectives rels.
	 *
	 * @return the number of rotation objectives rels
	 */
	@Override
	public int getRotationObjectivesRelsCount() {
		return _rotationObjectivesRelLocalService.
			getRotationObjectivesRelsCount();
	}

	/**
	 * Updates the rotation objectives rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationObjectivesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationObjectivesRel the rotation objectives rel
	 * @return the rotation objectives rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.RotationObjectivesRel updateRotationObjectivesRel(
		gov.omsb.tms.model.RotationObjectivesRel rotationObjectivesRel) {

		return _rotationObjectivesRelLocalService.updateRotationObjectivesRel(
			rotationObjectivesRel);
	}

	@Override
	public RotationObjectivesRelLocalService getWrappedService() {
		return _rotationObjectivesRelLocalService;
	}

	@Override
	public void setWrappedService(
		RotationObjectivesRelLocalService rotationObjectivesRelLocalService) {

		_rotationObjectivesRelLocalService = rotationObjectivesRelLocalService;
	}

	private RotationObjectivesRelLocalService
		_rotationObjectivesRelLocalService;

}
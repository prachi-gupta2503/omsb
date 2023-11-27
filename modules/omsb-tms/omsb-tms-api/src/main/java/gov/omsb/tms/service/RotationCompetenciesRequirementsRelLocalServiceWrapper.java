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
 * Provides a wrapper for {@link RotationCompetenciesRequirementsRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RotationCompetenciesRequirementsRelLocalService
 * @generated
 */
public class RotationCompetenciesRequirementsRelLocalServiceWrapper
	implements RotationCompetenciesRequirementsRelLocalService,
			   ServiceWrapper<RotationCompetenciesRequirementsRelLocalService> {

	public RotationCompetenciesRequirementsRelLocalServiceWrapper() {
		this(null);
	}

	public RotationCompetenciesRequirementsRelLocalServiceWrapper(
		RotationCompetenciesRequirementsRelLocalService
			rotationCompetenciesRequirementsRelLocalService) {

		_rotationCompetenciesRequirementsRelLocalService =
			rotationCompetenciesRequirementsRelLocalService;
	}

	/**
	 * Adds the rotation competencies requirements rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationCompetenciesRequirementsRel the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel that was added
	 */
	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
		addRotationCompetenciesRequirementsRel(
			gov.omsb.tms.model.RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel) {

		return _rotationCompetenciesRequirementsRelLocalService.
			addRotationCompetenciesRequirementsRel(
				rotationCompetenciesRequirementsRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationCompetenciesRequirementsRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new rotation competencies requirements rel with the primary key. Does not add the rotation competencies requirements rel to the database.
	 *
	 * @param rotationCompetenciesRelId the primary key for the new rotation competencies requirements rel
	 * @return the new rotation competencies requirements rel
	 */
	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
		createRotationCompetenciesRequirementsRel(
			long rotationCompetenciesRelId) {

		return _rotationCompetenciesRequirementsRelLocalService.
			createRotationCompetenciesRequirementsRel(
				rotationCompetenciesRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationCompetenciesRequirementsRelLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rotation competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel that was removed
	 * @throws PortalException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
			deleteRotationCompetenciesRequirementsRel(
				long rotationCompetenciesRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationCompetenciesRequirementsRelLocalService.
			deleteRotationCompetenciesRequirementsRel(
				rotationCompetenciesRelId);
	}

	/**
	 * Deletes the rotation competencies requirements rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationCompetenciesRequirementsRel the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
		deleteRotationCompetenciesRequirementsRel(
			gov.omsb.tms.model.RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel) {

		return _rotationCompetenciesRequirementsRelLocalService.
			deleteRotationCompetenciesRequirementsRel(
				rotationCompetenciesRequirementsRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rotationCompetenciesRequirementsRelLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rotationCompetenciesRequirementsRelLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rotationCompetenciesRequirementsRelLocalService.dynamicQuery();
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

		return _rotationCompetenciesRequirementsRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationCompetenciesRequirementsRelModelImpl</code>.
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

		return _rotationCompetenciesRequirementsRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationCompetenciesRequirementsRelModelImpl</code>.
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

		return _rotationCompetenciesRequirementsRelLocalService.dynamicQuery(
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

		return _rotationCompetenciesRequirementsRelLocalService.
			dynamicQueryCount(dynamicQuery);
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

		return _rotationCompetenciesRequirementsRelLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
		fetchRotationCompetenciesRequirementsRel(
			long rotationCompetenciesRelId) {

		return _rotationCompetenciesRequirementsRelLocalService.
			fetchRotationCompetenciesRequirementsRel(rotationCompetenciesRelId);
	}

	/**
	 * Returns the rotation competencies requirements rel matching the UUID and group.
	 *
	 * @param uuid the rotation competencies requirements rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
		fetchRotationCompetenciesRequirementsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _rotationCompetenciesRequirementsRelLocalService.
			fetchRotationCompetenciesRequirementsRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rotationCompetenciesRequirementsRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _rotationCompetenciesRequirementsRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rotationCompetenciesRequirementsRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rotationCompetenciesRequirementsRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationCompetenciesRequirementsRelLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rotation competencies requirements rel with the primary key.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel
	 * @throws PortalException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
			getRotationCompetenciesRequirementsRel(
				long rotationCompetenciesRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationCompetenciesRequirementsRelLocalService.
			getRotationCompetenciesRequirementsRel(rotationCompetenciesRelId);
	}

	/**
	 * Returns the rotation competencies requirements rel matching the UUID and group.
	 *
	 * @param uuid the rotation competencies requirements rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation competencies requirements rel
	 * @throws PortalException if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
			getRotationCompetenciesRequirementsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationCompetenciesRequirementsRelLocalService.
			getRotationCompetenciesRequirementsRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of rotation competencies requirements rels
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.RotationCompetenciesRequirementsRel>
			getRotationCompetenciesRequirementsRels(int start, int end) {

		return _rotationCompetenciesRequirementsRelLocalService.
			getRotationCompetenciesRequirementsRels(start, end);
	}

	/**
	 * Returns all the rotation competencies requirements rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation competencies requirements rels
	 * @param companyId the primary key of the company
	 * @return the matching rotation competencies requirements rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.RotationCompetenciesRequirementsRel>
			getRotationCompetenciesRequirementsRelsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _rotationCompetenciesRequirementsRelLocalService.
			getRotationCompetenciesRequirementsRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of rotation competencies requirements rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation competencies requirements rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching rotation competencies requirements rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.RotationCompetenciesRequirementsRel>
			getRotationCompetenciesRequirementsRelsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<gov.omsb.tms.model.RotationCompetenciesRequirementsRel>
						orderByComparator) {

		return _rotationCompetenciesRequirementsRelLocalService.
			getRotationCompetenciesRequirementsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rotation competencies requirements rels.
	 *
	 * @return the number of rotation competencies requirements rels
	 */
	@Override
	public int getRotationCompetenciesRequirementsRelsCount() {
		return _rotationCompetenciesRequirementsRelLocalService.
			getRotationCompetenciesRequirementsRelsCount();
	}

	/**
	 * Updates the rotation competencies requirements rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationCompetenciesRequirementsRel the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.RotationCompetenciesRequirementsRel
		updateRotationCompetenciesRequirementsRel(
			gov.omsb.tms.model.RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel) {

		return _rotationCompetenciesRequirementsRelLocalService.
			updateRotationCompetenciesRequirementsRel(
				rotationCompetenciesRequirementsRel);
	}

	@Override
	public RotationCompetenciesRequirementsRelLocalService getWrappedService() {
		return _rotationCompetenciesRequirementsRelLocalService;
	}

	@Override
	public void setWrappedService(
		RotationCompetenciesRequirementsRelLocalService
			rotationCompetenciesRequirementsRelLocalService) {

		_rotationCompetenciesRequirementsRelLocalService =
			rotationCompetenciesRequirementsRelLocalService;
	}

	private RotationCompetenciesRequirementsRelLocalService
		_rotationCompetenciesRequirementsRelLocalService;

}
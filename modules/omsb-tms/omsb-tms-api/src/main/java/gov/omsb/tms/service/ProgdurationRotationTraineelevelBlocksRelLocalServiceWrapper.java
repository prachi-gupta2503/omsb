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
 * Provides a wrapper for {@link ProgdurationRotationTraineelevelBlocksRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTraineelevelBlocksRelLocalService
 * @generated
 */
public class ProgdurationRotationTraineelevelBlocksRelLocalServiceWrapper
	implements ProgdurationRotationTraineelevelBlocksRelLocalService,
			   ServiceWrapper
				   <ProgdurationRotationTraineelevelBlocksRelLocalService> {

	public ProgdurationRotationTraineelevelBlocksRelLocalServiceWrapper() {
		this(null);
	}

	public ProgdurationRotationTraineelevelBlocksRelLocalServiceWrapper(
		ProgdurationRotationTraineelevelBlocksRelLocalService
			progdurationRotationTraineelevelBlocksRelLocalService) {

		_progdurationRotationTraineelevelBlocksRelLocalService =
			progdurationRotationTraineelevelBlocksRelLocalService;
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			addProgdurationRotationTraineelevelBlocksRel(
				java.util.List
					<gov.omsb.tms.model.
						ProgdurationTraineelevelBlocksLevelTypeRel>
							progdurationTraineelevelBlocksLevelTypeRels,
				long rotationId, long groupId, long createdBy) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			addProgdurationRotationTraineelevelBlocksRel(
				progdurationTraineelevelBlocksLevelTypeRels, rotationId,
				groupId, createdBy);
	}

	/**
	 * Adds the progduration rotation traineelevel blocks rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
		addProgdurationRotationTraineelevelBlocksRel(
			gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			addProgdurationRotationTraineelevelBlocksRel(
				progdurationRotationTraineelevelBlocksRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new progduration rotation traineelevel blocks rel with the primary key. Does not add the progduration rotation traineelevel blocks rel to the database.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key for the new progduration rotation traineelevel blocks rel
	 * @return the new progduration rotation traineelevel blocks rel
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
		createProgdurationRotationTraineelevelBlocksRel(
			long progdurationRotationTlBlocksRelId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			createProgdurationRotationTraineelevelBlocksRel(
				progdurationRotationTlBlocksRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the progduration rotation traineelevel blocks rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 * @throws PortalException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
			deleteProgdurationRotationTraineelevelBlocksRel(
				long progdurationRotationTlBlocksRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			deleteProgdurationRotationTraineelevelBlocksRel(
				progdurationRotationTlBlocksRelId);
	}

	/**
	 * Deletes the progduration rotation traineelevel blocks rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
		deleteProgdurationRotationTraineelevelBlocksRel(
			gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			deleteProgdurationRotationTraineelevelBlocksRel(
				progdurationRotationTraineelevelBlocksRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _progdurationRotationTraineelevelBlocksRelLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _progdurationRotationTraineelevelBlocksRelLocalService.
			dynamicQuery();
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

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
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

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
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

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			dynamicQuery(dynamicQuery, start, end, orderByComparator);
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

		return _progdurationRotationTraineelevelBlocksRelLocalService.
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

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
		fetchProgdurationRotationTraineelevelBlocksRel(
			long progdurationRotationTlBlocksRelId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			fetchProgdurationRotationTraineelevelBlocksRel(
				progdurationRotationTlBlocksRelId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation traineelevel blocks rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
		fetchProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			fetchProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			findByProgramDurationIdAndRotationId(
				long programDurationId, long rotationId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			findByProgramDurationIdAndRotationId(programDurationId, rotationId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			findByProgramDurationIdAndTraineeLevelId(
				long programDurationId, long traineeLevelId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			findByProgramDurationIdAndTraineeLevelId(
				programDurationId, traineeLevelId);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				traineeLevelId, programDurationId, rotationId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			findByTraineeLevelIdAndRotationType(
				long traineeLevelId, long rotationType) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			findByTraineeLevelIdAndRotationType(traineeLevelId, rotationType);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			findRotationByTraineeLevelId(long traineeLevelId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			findRotationByTraineeLevelId(traineeLevelId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			findTraineeLevelByDurationId(long durationId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			findTraineeLevelByDurationId(durationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ConfigureRotationDetailsDTO>
		getConfigureRotationDetails(String languageCode) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getConfigureRotationDetails(languageCode);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.custom.dto.ConfigureRotationEditDetailsDTO>
			getConfigureRotationDetailsByProgramAndDuration(
				long programId, long traineeLevelId, long programDurationId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getConfigureRotationDetailsByProgramAndDuration(
				programId, traineeLevelId, programDurationId);
	}

	@Override
	public gov.omsb.tms.custom.dto.ConfigureRotationBlockDetailsDTO
		getConfigureRotationDetailsByRotationAndDuration(
			long rotationId, String duration) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getConfigureRotationDetailsByRotationAndDuration(
				rotationId, duration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel
	 * @throws PortalException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
			getProgdurationRotationTraineelevelBlocksRel(
				long progdurationRotationTlBlocksRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getProgdurationRotationTraineelevelBlocksRel(
				progdurationRotationTlBlocksRelId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation traineelevel blocks rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation traineelevel blocks rel
	 * @throws PortalException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
			getProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of progduration rotation traineelevel blocks rels
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			getProgdurationRotationTraineelevelBlocksRels(int start, int end) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getProgdurationRotationTraineelevelBlocksRels(start, end);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation traineelevel blocks rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation traineelevel blocks rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of progduration rotation traineelevel blocks rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation traineelevel blocks rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration rotation traineelevel blocks rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel>
			getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<gov.omsb.tms.model.
						ProgdurationRotationTraineelevelBlocksRel>
							orderByComparator) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels.
	 *
	 * @return the number of progduration rotation traineelevel blocks rels
	 */
	@Override
	public int getProgdurationRotationTraineelevelBlocksRelsCount() {
		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getProgdurationRotationTraineelevelBlocksRelsCount();
	}

	@Override
	public java.util.List
		<gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO>
			getTraineeNoofBlocks(
				long programDurationId, long traineeLevelId,
				String languageCode) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			getTraineeNoofBlocks(
				programDurationId, traineeLevelId, languageCode);
	}

	/**
	 * Updates the progduration rotation traineelevel blocks rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
		updateProgdurationRotationTraineelevelBlocksRel(
			gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel) {

		return _progdurationRotationTraineelevelBlocksRelLocalService.
			updateProgdurationRotationTraineelevelBlocksRel(
				progdurationRotationTraineelevelBlocksRel);
	}

	@Override
	public ProgdurationRotationTraineelevelBlocksRelLocalService
		getWrappedService() {

		return _progdurationRotationTraineelevelBlocksRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgdurationRotationTraineelevelBlocksRelLocalService
			progdurationRotationTraineelevelBlocksRelLocalService) {

		_progdurationRotationTraineelevelBlocksRelLocalService =
			progdurationRotationTraineelevelBlocksRelLocalService;
	}

	private ProgdurationRotationTraineelevelBlocksRelLocalService
		_progdurationRotationTraineelevelBlocksRelLocalService;

}
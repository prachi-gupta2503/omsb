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
 * Provides a wrapper for {@link ProgdurationTraineelevelBlocksLevelTypeRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationTraineelevelBlocksLevelTypeRelLocalService
 * @generated
 */
public class ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceWrapper
	implements ProgdurationTraineelevelBlocksLevelTypeRelLocalService,
			   ServiceWrapper
				   <ProgdurationTraineelevelBlocksLevelTypeRelLocalService> {

	public ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceWrapper() {
		this(null);
	}

	public ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceWrapper(
		ProgdurationTraineelevelBlocksLevelTypeRelLocalService
			progdurationTraineelevelBlocksLevelTypeRelLocalService) {

		_progdurationTraineelevelBlocksLevelTypeRelLocalService =
			progdurationTraineelevelBlocksLevelTypeRelLocalService;
	}

	/**
	 * Adds the progduration traineelevel blocks level type rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRel the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
		addProgdurationTraineelevelBlocksLevelTypeRel(
			gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			addProgdurationTraineelevelBlocksLevelTypeRel(
				progdurationTraineelevelBlocksLevelTypeRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new progduration traineelevel blocks level type rel with the primary key. Does not add the progduration traineelevel blocks level type rel to the database.
	 *
	 * @param progdurationTlBlocksLtId the primary key for the new progduration traineelevel blocks level type rel
	 * @return the new progduration traineelevel blocks level type rel
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
		createProgdurationTraineelevelBlocksLevelTypeRel(
			long progdurationTlBlocksLtId) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			createProgdurationTraineelevelBlocksLevelTypeRel(
				progdurationTlBlocksLtId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the progduration traineelevel blocks level type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel that was removed
	 * @throws PortalException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
			deleteProgdurationTraineelevelBlocksLevelTypeRel(
				long progdurationTlBlocksLtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			deleteProgdurationTraineelevelBlocksLevelTypeRel(
				progdurationTlBlocksLtId);
	}

	/**
	 * Deletes the progduration traineelevel blocks level type rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRel the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
		deleteProgdurationTraineelevelBlocksLevelTypeRel(
			gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			deleteProgdurationTraineelevelBlocksLevelTypeRel(
				progdurationTraineelevelBlocksLevelTypeRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
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

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
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

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
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

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
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

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
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

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
		fetchProgdurationTraineelevelBlocksLevelTypeRel(
			long progdurationTlBlocksLtId) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			fetchProgdurationTraineelevelBlocksLevelTypeRel(
				progdurationTlBlocksLtId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel matching the UUID and group.
	 *
	 * @param uuid the progduration traineelevel blocks level type rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
		fetchProgdurationTraineelevelBlocksLevelTypeRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			fetchProgdurationTraineelevelBlocksLevelTypeRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel>
			findByProgramDurationId(long programDurationId) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			findByProgramDurationId(programDurationId);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
		findByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			findByProgramDurationIdAndTraineeLevelId(
				programDurationId, traineeLevelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel with the primary key.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel
	 * @throws PortalException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
			getProgdurationTraineelevelBlocksLevelTypeRel(
				long progdurationTlBlocksLtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getProgdurationTraineelevelBlocksLevelTypeRel(
				progdurationTlBlocksLtId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel matching the UUID and group.
	 *
	 * @param uuid the progduration traineelevel blocks level type rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration traineelevel blocks level type rel
	 * @throws PortalException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
			getProgdurationTraineelevelBlocksLevelTypeRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getProgdurationTraineelevelBlocksLevelTypeRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of progduration traineelevel blocks level type rels
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel>
			getProgdurationTraineelevelBlocksLevelTypeRels(int start, int end) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getProgdurationTraineelevelBlocksLevelTypeRels(start, end);
	}

	/**
	 * Returns all the progduration traineelevel blocks level type rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration traineelevel blocks level type rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration traineelevel blocks level type rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel>
			getProgdurationTraineelevelBlocksLevelTypeRelsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getProgdurationTraineelevelBlocksLevelTypeRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of progduration traineelevel blocks level type rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration traineelevel blocks level type rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration traineelevel blocks level type rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel>
			getProgdurationTraineelevelBlocksLevelTypeRelsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<gov.omsb.tms.model.
						ProgdurationTraineelevelBlocksLevelTypeRel>
							orderByComparator) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getProgdurationTraineelevelBlocksLevelTypeRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels.
	 *
	 * @return the number of progduration traineelevel blocks level type rels
	 */
	@Override
	public int getProgdurationTraineelevelBlocksLevelTypeRelsCount() {
		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getProgdurationTraineelevelBlocksLevelTypeRelsCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ProgramCohortDTO>
		getProgramCohorts(
			java.util.List<Long> programIds, java.util.List<String> yearRange,
			String languageCode) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getProgramCohorts(programIds, yearRange, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ProgramCohortDTO>
		getProgramCohortsRelationalDataByProgramDurationId(
			long programDurationId, String languageCode) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getProgramCohortsRelationalDataByProgramDurationId(
				programDurationId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLevelMaster>
		getTraineeLevelFromProgramDurationId(long programDurationId) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			getTraineeLevelFromProgramDurationId(programDurationId);
	}

	/**
	 * Updates the progduration traineelevel blocks level type rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRel the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
		updateProgdurationTraineelevelBlocksLevelTypeRel(
			gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel) {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService.
			updateProgdurationTraineelevelBlocksLevelTypeRel(
				progdurationTraineelevelBlocksLevelTypeRel);
	}

	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRelLocalService
		getWrappedService() {

		return _progdurationTraineelevelBlocksLevelTypeRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgdurationTraineelevelBlocksLevelTypeRelLocalService
			progdurationTraineelevelBlocksLevelTypeRelLocalService) {

		_progdurationTraineelevelBlocksLevelTypeRelLocalService =
			progdurationTraineelevelBlocksLevelTypeRelLocalService;
	}

	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService
		_progdurationTraineelevelBlocksLevelTypeRelLocalService;

}
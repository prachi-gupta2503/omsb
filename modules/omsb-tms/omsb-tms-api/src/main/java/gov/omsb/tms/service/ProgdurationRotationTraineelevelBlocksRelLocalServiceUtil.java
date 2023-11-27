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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgdurationRotationTraineelevelBlocksRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTraineelevelBlocksRelLocalService
 * @generated
 */
public class ProgdurationRotationTraineelevelBlocksRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		addProgdurationRotationTraineelevelBlocksRel(
			List<gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel>
				progdurationTraineelevelBlocksLevelTypeRels,
			long rotationId, long groupId, long createdBy) {

		return getService().addProgdurationRotationTraineelevelBlocksRel(
			progdurationTraineelevelBlocksLevelTypeRels, rotationId, groupId,
			createdBy);
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
	public static ProgdurationRotationTraineelevelBlocksRel
		addProgdurationRotationTraineelevelBlocksRel(
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel) {

		return getService().addProgdurationRotationTraineelevelBlocksRel(
			progdurationRotationTraineelevelBlocksRel);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new progduration rotation traineelevel blocks rel with the primary key. Does not add the progduration rotation traineelevel blocks rel to the database.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key for the new progduration rotation traineelevel blocks rel
	 * @return the new progduration rotation traineelevel blocks rel
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		createProgdurationRotationTraineelevelBlocksRel(
			long progdurationRotationTlBlocksRelId) {

		return getService().createProgdurationRotationTraineelevelBlocksRel(
			progdurationRotationTlBlocksRelId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static ProgdurationRotationTraineelevelBlocksRel
			deleteProgdurationRotationTraineelevelBlocksRel(
				long progdurationRotationTlBlocksRelId)
		throws PortalException {

		return getService().deleteProgdurationRotationTraineelevelBlocksRel(
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
	public static ProgdurationRotationTraineelevelBlocksRel
		deleteProgdurationRotationTraineelevelBlocksRel(
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel) {

		return getService().deleteProgdurationRotationTraineelevelBlocksRel(
			progdurationRotationTraineelevelBlocksRel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ProgdurationRotationTraineelevelBlocksRel
		fetchProgdurationRotationTraineelevelBlocksRel(
			long progdurationRotationTlBlocksRelId) {

		return getService().fetchProgdurationRotationTraineelevelBlocksRel(
			progdurationRotationTlBlocksRelId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation traineelevel blocks rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
				uuid, groupId);
	}

	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId) {

		return getService().findByProgramDurationIdAndRotationId(
			programDurationId, rotationId);
	}

	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId) {

		return getService().findByProgramDurationIdAndTraineeLevelId(
			programDurationId, traineeLevelId);
	}

	public static ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getService().
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				traineeLevelId, programDurationId, rotationId);
	}

	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType) {

		return getService().findByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType);
	}

	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findRotationByTraineeLevelId(long traineeLevelId) {

		return getService().findRotationByTraineeLevelId(traineeLevelId);
	}

	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findTraineeLevelByDurationId(long durationId) {

		return getService().findTraineeLevelByDurationId(durationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<gov.omsb.tms.custom.dto.ConfigureRotationDetailsDTO>
		getConfigureRotationDetails(String languageCode) {

		return getService().getConfigureRotationDetails(languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.ConfigureRotationEditDetailsDTO>
		getConfigureRotationDetailsByProgramAndDuration(
			long programId, long traineeLevelId, long programDurationId) {

		return getService().getConfigureRotationDetailsByProgramAndDuration(
			programId, traineeLevelId, programDurationId);
	}

	public static gov.omsb.tms.custom.dto.ConfigureRotationBlockDetailsDTO
		getConfigureRotationDetailsByRotationAndDuration(
			long rotationId, String duration) {

		return getService().getConfigureRotationDetailsByRotationAndDuration(
			rotationId, duration);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel
	 * @throws PortalException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			getProgdurationRotationTraineelevelBlocksRel(
				long progdurationRotationTlBlocksRelId)
		throws PortalException {

		return getService().getProgdurationRotationTraineelevelBlocksRel(
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
	public static ProgdurationRotationTraineelevelBlocksRel
			getProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().
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
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		getProgdurationRotationTraineelevelBlocksRels(int start, int end) {

		return getService().getProgdurationRotationTraineelevelBlocksRels(
			start, end);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation traineelevel blocks rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation traineelevel blocks rels, or an empty list if no matches were found
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
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
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getService().
			getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels.
	 *
	 * @return the number of progduration rotation traineelevel blocks rels
	 */
	public static int getProgdurationRotationTraineelevelBlocksRelsCount() {
		return getService().
			getProgdurationRotationTraineelevelBlocksRelsCount();
	}

	public static List<gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO>
		getTraineeNoofBlocks(
			long programDurationId, long traineeLevelId, String languageCode) {

		return getService().getTraineeNoofBlocks(
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
	public static ProgdurationRotationTraineelevelBlocksRel
		updateProgdurationRotationTraineelevelBlocksRel(
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel) {

		return getService().updateProgdurationRotationTraineelevelBlocksRel(
			progdurationRotationTraineelevelBlocksRel);
	}

	public static ProgdurationRotationTraineelevelBlocksRelLocalService
		getService() {

		return _service;
	}

	private static volatile
		ProgdurationRotationTraineelevelBlocksRelLocalService _service;

}
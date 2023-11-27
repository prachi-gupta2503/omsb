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
 * Provides a wrapper for {@link PatientTypeProgDurationRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeProgDurationRelLocalService
 * @generated
 */
public class PatientTypeProgDurationRelLocalServiceWrapper
	implements PatientTypeProgDurationRelLocalService,
			   ServiceWrapper<PatientTypeProgDurationRelLocalService> {

	public PatientTypeProgDurationRelLocalServiceWrapper() {
		this(null);
	}

	public PatientTypeProgDurationRelLocalServiceWrapper(
		PatientTypeProgDurationRelLocalService
			patientTypeProgDurationRelLocalService) {

		_patientTypeProgDurationRelLocalService =
			patientTypeProgDurationRelLocalService;
	}

	/**
	 * Adds the patient type prog duration rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientTypeProgDurationRel the patient type prog duration rel
	 * @return the patient type prog duration rel that was added
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
		addPatientTypeProgDurationRel(
			gov.omsb.tms.model.PatientTypeProgDurationRel
				patientTypeProgDurationRel) {

		return _patientTypeProgDurationRelLocalService.
			addPatientTypeProgDurationRel(patientTypeProgDurationRel);
	}

	/**
	 * Creates a new patient type prog duration rel with the primary key. Does not add the patient type prog duration rel to the database.
	 *
	 * @param PatientTypeProgDurationRelId the primary key for the new patient type prog duration rel
	 * @return the new patient type prog duration rel
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
		createPatientTypeProgDurationRel(long PatientTypeProgDurationRelId) {

		return _patientTypeProgDurationRelLocalService.
			createPatientTypeProgDurationRel(PatientTypeProgDurationRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeProgDurationRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the patient type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel that was removed
	 * @throws PortalException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
			deletePatientTypeProgDurationRel(long PatientTypeProgDurationRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeProgDurationRelLocalService.
			deletePatientTypeProgDurationRel(PatientTypeProgDurationRelId);
	}

	/**
	 * Deletes the patient type prog duration rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientTypeProgDurationRel the patient type prog duration rel
	 * @return the patient type prog duration rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
		deletePatientTypeProgDurationRel(
			gov.omsb.tms.model.PatientTypeProgDurationRel
				patientTypeProgDurationRel) {

		return _patientTypeProgDurationRelLocalService.
			deletePatientTypeProgDurationRel(patientTypeProgDurationRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeProgDurationRelLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _patientTypeProgDurationRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _patientTypeProgDurationRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _patientTypeProgDurationRelLocalService.dynamicQuery();
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

		return _patientTypeProgDurationRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.PatientTypeProgDurationRelModelImpl</code>.
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

		return _patientTypeProgDurationRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.PatientTypeProgDurationRelModelImpl</code>.
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

		return _patientTypeProgDurationRelLocalService.dynamicQuery(
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

		return _patientTypeProgDurationRelLocalService.dynamicQueryCount(
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

		return _patientTypeProgDurationRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
		fetchPatientTypeProgDurationRel(long PatientTypeProgDurationRelId) {

		return _patientTypeProgDurationRelLocalService.
			fetchPatientTypeProgDurationRel(PatientTypeProgDurationRelId);
	}

	/**
	 * Returns the patient type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the patient type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
		fetchPatientTypeProgDurationRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _patientTypeProgDurationRelLocalService.
			fetchPatientTypeProgDurationRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.PatientTypeProgDurationRel>
		findByProgramDurationId(long programDurationId) {

		return _patientTypeProgDurationRelLocalService.findByProgramDurationId(
			programDurationId);
	}

	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
		findByProgramDurationIdAndPatientTypeMasterId(
			long programDurationId, long patientTypeMasterId) {

		return _patientTypeProgDurationRelLocalService.
			findByProgramDurationIdAndPatientTypeMasterId(
				programDurationId, patientTypeMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _patientTypeProgDurationRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _patientTypeProgDurationRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _patientTypeProgDurationRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _patientTypeProgDurationRelLocalService.
			getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<Long, String> getOtherPatientTypesFromPatientMaster(
		long programDurationId, String type, String languageCode) {

		return _patientTypeProgDurationRelLocalService.
			getOtherPatientTypesFromPatientMaster(
				programDurationId, type, languageCode);
	}

	/**
	 * Returns the patient type prog duration rel with the primary key.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel
	 * @throws PortalException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
			getPatientTypeProgDurationRel(long PatientTypeProgDurationRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeProgDurationRelLocalService.
			getPatientTypeProgDurationRel(PatientTypeProgDurationRelId);
	}

	/**
	 * Returns the patient type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the patient type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient type prog duration rel
	 * @throws PortalException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
			getPatientTypeProgDurationRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeProgDurationRelLocalService.
			getPatientTypeProgDurationRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the patient type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of patient type prog duration rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.PatientTypeProgDurationRel>
		getPatientTypeProgDurationRels(int start, int end) {

		return _patientTypeProgDurationRelLocalService.
			getPatientTypeProgDurationRels(start, end);
	}

	/**
	 * Returns all the patient type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the patient type prog duration rels
	 * @param companyId the primary key of the company
	 * @return the matching patient type prog duration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.PatientTypeProgDurationRel>
		getPatientTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _patientTypeProgDurationRelLocalService.
			getPatientTypeProgDurationRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of patient type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the patient type prog duration rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching patient type prog duration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.PatientTypeProgDurationRel>
		getPatientTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.PatientTypeProgDurationRel>
					orderByComparator) {

		return _patientTypeProgDurationRelLocalService.
			getPatientTypeProgDurationRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of patient type prog duration rels.
	 *
	 * @return the number of patient type prog duration rels
	 */
	@Override
	public int getPatientTypeProgDurationRelsCount() {
		return _patientTypeProgDurationRelLocalService.
			getPatientTypeProgDurationRelsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeProgDurationRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the patient type prog duration rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientTypeProgDurationRel the patient type prog duration rel
	 * @return the patient type prog duration rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeProgDurationRel
		updatePatientTypeProgDurationRel(
			gov.omsb.tms.model.PatientTypeProgDurationRel
				patientTypeProgDurationRel) {

		return _patientTypeProgDurationRelLocalService.
			updatePatientTypeProgDurationRel(patientTypeProgDurationRel);
	}

	@Override
	public PatientTypeProgDurationRelLocalService getWrappedService() {
		return _patientTypeProgDurationRelLocalService;
	}

	@Override
	public void setWrappedService(
		PatientTypeProgDurationRelLocalService
			patientTypeProgDurationRelLocalService) {

		_patientTypeProgDurationRelLocalService =
			patientTypeProgDurationRelLocalService;
	}

	private PatientTypeProgDurationRelLocalService
		_patientTypeProgDurationRelLocalService;

}
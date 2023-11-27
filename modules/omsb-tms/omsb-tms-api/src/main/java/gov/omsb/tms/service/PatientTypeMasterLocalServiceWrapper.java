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
 * Provides a wrapper for {@link PatientTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeMasterLocalService
 * @generated
 */
public class PatientTypeMasterLocalServiceWrapper
	implements PatientTypeMasterLocalService,
			   ServiceWrapper<PatientTypeMasterLocalService> {

	public PatientTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public PatientTypeMasterLocalServiceWrapper(
		PatientTypeMasterLocalService patientTypeMasterLocalService) {

		_patientTypeMasterLocalService = patientTypeMasterLocalService;
	}

	/**
	 * Adds the patient type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientTypeMaster the patient type master
	 * @return the patient type master that was added
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeMaster addPatientTypeMaster(
		gov.omsb.tms.model.PatientTypeMaster patientTypeMaster) {

		return _patientTypeMasterLocalService.addPatientTypeMaster(
			patientTypeMaster);
	}

	@Override
	public gov.omsb.tms.model.PatientTypeMaster addUpdatePatientTypeMaster(
		gov.omsb.tms.model.PatientTypeMaster patientTypeMaster,
		java.util.List<String> patientTypeNames, boolean isCreate) {

		return _patientTypeMasterLocalService.addUpdatePatientTypeMaster(
			patientTypeMaster, patientTypeNames, isCreate);
	}

	/**
	 * Creates a new patient type master with the primary key. Does not add the patient type master to the database.
	 *
	 * @param patientTypeMasterId the primary key for the new patient type master
	 * @return the new patient type master
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeMaster createPatientTypeMaster(
		long patientTypeMasterId) {

		return _patientTypeMasterLocalService.createPatientTypeMaster(
			patientTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the patient type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master that was removed
	 * @throws PortalException if a patient type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeMaster deletePatientTypeMaster(
			long patientTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeMasterLocalService.deletePatientTypeMaster(
			patientTypeMasterId);
	}

	/**
	 * Deletes the patient type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientTypeMaster the patient type master
	 * @return the patient type master that was removed
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeMaster deletePatientTypeMaster(
		gov.omsb.tms.model.PatientTypeMaster patientTypeMaster) {

		return _patientTypeMasterLocalService.deletePatientTypeMaster(
			patientTypeMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _patientTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _patientTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _patientTypeMasterLocalService.dynamicQuery();
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

		return _patientTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.PatientTypeMasterModelImpl</code>.
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

		return _patientTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.PatientTypeMasterModelImpl</code>.
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

		return _patientTypeMasterLocalService.dynamicQuery(
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

		return _patientTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _patientTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.PatientTypeMaster fetchPatientTypeMaster(
		long patientTypeMasterId) {

		return _patientTypeMasterLocalService.fetchPatientTypeMaster(
			patientTypeMasterId);
	}

	/**
	 * Returns the patient type master matching the UUID and group.
	 *
	 * @param uuid the patient type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeMaster
		fetchPatientTypeMasterByUuidAndGroupId(String uuid, long groupId) {

		return _patientTypeMasterLocalService.
			fetchPatientTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.PatientTypeMaster>
		findByPatientTypeNameByLike(String patientTypeName) {

		return _patientTypeMasterLocalService.findByPatientTypeNameByLike(
			patientTypeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _patientTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _patientTypeMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _patientTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _patientTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the patient type master with the primary key.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master
	 * @throws PortalException if a patient type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeMaster getPatientTypeMaster(
			long patientTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeMasterLocalService.getPatientTypeMaster(
			patientTypeMasterId);
	}

	/**
	 * Returns the patient type master matching the UUID and group.
	 *
	 * @param uuid the patient type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient type master
	 * @throws PortalException if a matching patient type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeMaster
			getPatientTypeMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeMasterLocalService.
			getPatientTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the patient type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of patient type masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.PatientTypeMaster>
		getPatientTypeMasters(int start, int end) {

		return _patientTypeMasterLocalService.getPatientTypeMasters(start, end);
	}

	/**
	 * Returns all the patient type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the patient type masters
	 * @param companyId the primary key of the company
	 * @return the matching patient type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.PatientTypeMaster>
		getPatientTypeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _patientTypeMasterLocalService.
			getPatientTypeMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of patient type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the patient type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching patient type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.PatientTypeMaster>
		getPatientTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.PatientTypeMaster> orderByComparator) {

		return _patientTypeMasterLocalService.
			getPatientTypeMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of patient type masters.
	 *
	 * @return the number of patient type masters
	 */
	@Override
	public int getPatientTypeMastersCount() {
		return _patientTypeMasterLocalService.getPatientTypeMastersCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the patient type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientTypeMaster the patient type master
	 * @return the patient type master that was updated
	 */
	@Override
	public gov.omsb.tms.model.PatientTypeMaster updatePatientTypeMaster(
		gov.omsb.tms.model.PatientTypeMaster patientTypeMaster) {

		return _patientTypeMasterLocalService.updatePatientTypeMaster(
			patientTypeMaster);
	}

	@Override
	public boolean validatePatientTypeNames(
		java.util.List<String> patientTypeNames,
		gov.omsb.tms.model.PatientTypeMaster patientTypeMaster) {

		return _patientTypeMasterLocalService.validatePatientTypeNames(
			patientTypeNames, patientTypeMaster);
	}

	@Override
	public PatientTypeMasterLocalService getWrappedService() {
		return _patientTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		PatientTypeMasterLocalService patientTypeMasterLocalService) {

		_patientTypeMasterLocalService = patientTypeMasterLocalService;
	}

	private PatientTypeMasterLocalService _patientTypeMasterLocalService;

}
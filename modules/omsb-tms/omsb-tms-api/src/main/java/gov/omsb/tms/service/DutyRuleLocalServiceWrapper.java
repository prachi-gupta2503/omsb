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
 * Provides a wrapper for {@link DutyRuleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyRuleLocalService
 * @generated
 */
public class DutyRuleLocalServiceWrapper
	implements DutyRuleLocalService, ServiceWrapper<DutyRuleLocalService> {

	public DutyRuleLocalServiceWrapper() {
		this(null);
	}

	public DutyRuleLocalServiceWrapper(
		DutyRuleLocalService dutyRuleLocalService) {

		_dutyRuleLocalService = dutyRuleLocalService;
	}

	/**
	 * Adds the duty rule to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyRule the duty rule
	 * @return the duty rule that was added
	 */
	@Override
	public gov.omsb.tms.model.DutyRule addDutyRule(
		gov.omsb.tms.model.DutyRule dutyRule) {

		return _dutyRuleLocalService.addDutyRule(dutyRule);
	}

	/**
	 * Creates a new duty rule with the primary key. Does not add the duty rule to the database.
	 *
	 * @param dutyRuleId the primary key for the new duty rule
	 * @return the new duty rule
	 */
	@Override
	public gov.omsb.tms.model.DutyRule createDutyRule(long dutyRuleId) {
		return _dutyRuleLocalService.createDutyRule(dutyRuleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyRuleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the duty rule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyRule the duty rule
	 * @return the duty rule that was removed
	 */
	@Override
	public gov.omsb.tms.model.DutyRule deleteDutyRule(
		gov.omsb.tms.model.DutyRule dutyRule) {

		return _dutyRuleLocalService.deleteDutyRule(dutyRule);
	}

	/**
	 * Deletes the duty rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule that was removed
	 * @throws PortalException if a duty rule with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyRule deleteDutyRule(long dutyRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyRuleLocalService.deleteDutyRule(dutyRuleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyRuleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dutyRuleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dutyRuleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dutyRuleLocalService.dynamicQuery();
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

		return _dutyRuleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyRuleModelImpl</code>.
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

		return _dutyRuleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyRuleModelImpl</code>.
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

		return _dutyRuleLocalService.dynamicQuery(
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

		return _dutyRuleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dutyRuleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.DutyRule fetchDutyRule(long dutyRuleId) {
		return _dutyRuleLocalService.fetchDutyRule(dutyRuleId);
	}

	/**
	 * Returns the duty rule matching the UUID and group.
	 *
	 * @param uuid the duty rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyRule fetchDutyRuleByUuidAndGroupId(
		String uuid, long groupId) {

		return _dutyRuleLocalService.fetchDutyRuleByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dutyRuleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the duty rule with the primary key.
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule
	 * @throws PortalException if a duty rule with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyRule getDutyRule(long dutyRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyRuleLocalService.getDutyRule(dutyRuleId);
	}

	/**
	 * Returns the duty rule matching the UUID and group.
	 *
	 * @param uuid the duty rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty rule
	 * @throws PortalException if a matching duty rule could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyRule getDutyRuleByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyRuleLocalService.getDutyRuleByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @return the range of duty rules
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyRule> getDutyRules(
		int start, int end) {

		return _dutyRuleLocalService.getDutyRules(start, end);
	}

	/**
	 * Returns all the duty rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty rules
	 * @param companyId the primary key of the company
	 * @return the matching duty rules, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyRule>
		getDutyRulesByUuidAndCompanyId(String uuid, long companyId) {

		return _dutyRuleLocalService.getDutyRulesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of duty rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty rules
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching duty rules, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyRule>
		getDutyRulesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.DutyRule> orderByComparator) {

		return _dutyRuleLocalService.getDutyRulesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty rules.
	 *
	 * @return the number of duty rules
	 */
	@Override
	public int getDutyRulesCount() {
		return _dutyRuleLocalService.getDutyRulesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dutyRuleLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dutyRuleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyRuleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyRuleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the duty rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyRule the duty rule
	 * @return the duty rule that was updated
	 */
	@Override
	public gov.omsb.tms.model.DutyRule updateDutyRule(
		gov.omsb.tms.model.DutyRule dutyRule) {

		return _dutyRuleLocalService.updateDutyRule(dutyRule);
	}

	@Override
	public DutyRuleLocalService getWrappedService() {
		return _dutyRuleLocalService;
	}

	@Override
	public void setWrappedService(DutyRuleLocalService dutyRuleLocalService) {
		_dutyRuleLocalService = dutyRuleLocalService;
	}

	private DutyRuleLocalService _dutyRuleLocalService;

}
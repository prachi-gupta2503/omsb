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
 * Provides a wrapper for {@link LeaveAnnualRuleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualRuleLocalService
 * @generated
 */
public class LeaveAnnualRuleLocalServiceWrapper
	implements LeaveAnnualRuleLocalService,
			   ServiceWrapper<LeaveAnnualRuleLocalService> {

	public LeaveAnnualRuleLocalServiceWrapper() {
		this(null);
	}

	public LeaveAnnualRuleLocalServiceWrapper(
		LeaveAnnualRuleLocalService leaveAnnualRuleLocalService) {

		_leaveAnnualRuleLocalService = leaveAnnualRuleLocalService;
	}

	/**
	 * Adds the leave annual rule to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualRule the leave annual rule
	 * @return the leave annual rule that was added
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualRule addLeaveAnnualRule(
		gov.omsb.tms.model.LeaveAnnualRule leaveAnnualRule) {

		return _leaveAnnualRuleLocalService.addLeaveAnnualRule(leaveAnnualRule);
	}

	/**
	 * Creates a new leave annual rule with the primary key. Does not add the leave annual rule to the database.
	 *
	 * @param leaveAnnualRuleId the primary key for the new leave annual rule
	 * @return the new leave annual rule
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualRule createLeaveAnnualRule(
		long leaveAnnualRuleId) {

		return _leaveAnnualRuleLocalService.createLeaveAnnualRule(
			leaveAnnualRuleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualRuleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the leave annual rule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualRule the leave annual rule
	 * @return the leave annual rule that was removed
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualRule deleteLeaveAnnualRule(
		gov.omsb.tms.model.LeaveAnnualRule leaveAnnualRule) {

		return _leaveAnnualRuleLocalService.deleteLeaveAnnualRule(
			leaveAnnualRule);
	}

	/**
	 * Deletes the leave annual rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule that was removed
	 * @throws PortalException if a leave annual rule with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualRule deleteLeaveAnnualRule(
			long leaveAnnualRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualRuleLocalService.deleteLeaveAnnualRule(
			leaveAnnualRuleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualRuleLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveAnnualRuleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveAnnualRuleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveAnnualRuleLocalService.dynamicQuery();
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

		return _leaveAnnualRuleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualRuleModelImpl</code>.
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

		return _leaveAnnualRuleLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualRuleModelImpl</code>.
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

		return _leaveAnnualRuleLocalService.dynamicQuery(
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

		return _leaveAnnualRuleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveAnnualRuleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.LeaveAnnualRule fetchLeaveAnnualRule(
		long leaveAnnualRuleId) {

		return _leaveAnnualRuleLocalService.fetchLeaveAnnualRule(
			leaveAnnualRuleId);
	}

	/**
	 * Returns the leave annual rule matching the UUID and group.
	 *
	 * @param uuid the leave annual rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualRule
		fetchLeaveAnnualRuleByUuidAndGroupId(String uuid, long groupId) {

		return _leaveAnnualRuleLocalService.
			fetchLeaveAnnualRuleByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveAnnualRuleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveAnnualRuleLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveAnnualRuleLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave annual rule with the primary key.
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule
	 * @throws PortalException if a leave annual rule with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualRule getLeaveAnnualRule(
			long leaveAnnualRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualRuleLocalService.getLeaveAnnualRule(
			leaveAnnualRuleId);
	}

	/**
	 * Returns the leave annual rule matching the UUID and group.
	 *
	 * @param uuid the leave annual rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave annual rule
	 * @throws PortalException if a matching leave annual rule could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualRule
			getLeaveAnnualRuleByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualRuleLocalService.getLeaveAnnualRuleByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the leave annual rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @return the range of leave annual rules
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualRule>
		getLeaveAnnualRules(int start, int end) {

		return _leaveAnnualRuleLocalService.getLeaveAnnualRules(start, end);
	}

	/**
	 * Returns all the leave annual rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave annual rules
	 * @param companyId the primary key of the company
	 * @return the matching leave annual rules, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualRule>
		getLeaveAnnualRulesByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveAnnualRuleLocalService.
			getLeaveAnnualRulesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave annual rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave annual rules
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave annual rules, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualRule>
		getLeaveAnnualRulesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.LeaveAnnualRule> orderByComparator) {

		return _leaveAnnualRuleLocalService.
			getLeaveAnnualRulesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave annual rules.
	 *
	 * @return the number of leave annual rules
	 */
	@Override
	public int getLeaveAnnualRulesCount() {
		return _leaveAnnualRuleLocalService.getLeaveAnnualRulesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveAnnualRuleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualRuleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave annual rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualRule the leave annual rule
	 * @return the leave annual rule that was updated
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualRule updateLeaveAnnualRule(
		gov.omsb.tms.model.LeaveAnnualRule leaveAnnualRule) {

		return _leaveAnnualRuleLocalService.updateLeaveAnnualRule(
			leaveAnnualRule);
	}

	@Override
	public LeaveAnnualRuleLocalService getWrappedService() {
		return _leaveAnnualRuleLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveAnnualRuleLocalService leaveAnnualRuleLocalService) {

		_leaveAnnualRuleLocalService = leaveAnnualRuleLocalService;
	}

	private LeaveAnnualRuleLocalService _leaveAnnualRuleLocalService;

}
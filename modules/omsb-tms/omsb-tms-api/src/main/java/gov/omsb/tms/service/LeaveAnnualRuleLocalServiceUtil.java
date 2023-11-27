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

import gov.omsb.tms.model.LeaveAnnualRule;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveAnnualRule. This utility wraps
 * <code>gov.omsb.tms.service.impl.LeaveAnnualRuleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualRuleLocalService
 * @generated
 */
public class LeaveAnnualRuleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.LeaveAnnualRuleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LeaveAnnualRule addLeaveAnnualRule(
		LeaveAnnualRule leaveAnnualRule) {

		return getService().addLeaveAnnualRule(leaveAnnualRule);
	}

	/**
	 * Creates a new leave annual rule with the primary key. Does not add the leave annual rule to the database.
	 *
	 * @param leaveAnnualRuleId the primary key for the new leave annual rule
	 * @return the new leave annual rule
	 */
	public static LeaveAnnualRule createLeaveAnnualRule(
		long leaveAnnualRuleId) {

		return getService().createLeaveAnnualRule(leaveAnnualRuleId);
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
	 * Deletes the leave annual rule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualRule the leave annual rule
	 * @return the leave annual rule that was removed
	 */
	public static LeaveAnnualRule deleteLeaveAnnualRule(
		LeaveAnnualRule leaveAnnualRule) {

		return getService().deleteLeaveAnnualRule(leaveAnnualRule);
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
	public static LeaveAnnualRule deleteLeaveAnnualRule(long leaveAnnualRuleId)
		throws PortalException {

		return getService().deleteLeaveAnnualRule(leaveAnnualRuleId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualRuleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualRuleModelImpl</code>.
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

	public static LeaveAnnualRule fetchLeaveAnnualRule(long leaveAnnualRuleId) {
		return getService().fetchLeaveAnnualRule(leaveAnnualRuleId);
	}

	/**
	 * Returns the leave annual rule matching the UUID and group.
	 *
	 * @param uuid the leave annual rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	public static LeaveAnnualRule fetchLeaveAnnualRuleByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLeaveAnnualRuleByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the leave annual rule with the primary key.
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule
	 * @throws PortalException if a leave annual rule with the primary key could not be found
	 */
	public static LeaveAnnualRule getLeaveAnnualRule(long leaveAnnualRuleId)
		throws PortalException {

		return getService().getLeaveAnnualRule(leaveAnnualRuleId);
	}

	/**
	 * Returns the leave annual rule matching the UUID and group.
	 *
	 * @param uuid the leave annual rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave annual rule
	 * @throws PortalException if a matching leave annual rule could not be found
	 */
	public static LeaveAnnualRule getLeaveAnnualRuleByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveAnnualRuleByUuidAndGroupId(uuid, groupId);
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
	public static List<LeaveAnnualRule> getLeaveAnnualRules(
		int start, int end) {

		return getService().getLeaveAnnualRules(start, end);
	}

	/**
	 * Returns all the leave annual rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave annual rules
	 * @param companyId the primary key of the company
	 * @return the matching leave annual rules, or an empty list if no matches were found
	 */
	public static List<LeaveAnnualRule> getLeaveAnnualRulesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLeaveAnnualRulesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<LeaveAnnualRule> getLeaveAnnualRulesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveAnnualRule> orderByComparator) {

		return getService().getLeaveAnnualRulesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave annual rules.
	 *
	 * @return the number of leave annual rules
	 */
	public static int getLeaveAnnualRulesCount() {
		return getService().getLeaveAnnualRulesCount();
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
	 * Updates the leave annual rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualRule the leave annual rule
	 * @return the leave annual rule that was updated
	 */
	public static LeaveAnnualRule updateLeaveAnnualRule(
		LeaveAnnualRule leaveAnnualRule) {

		return getService().updateLeaveAnnualRule(leaveAnnualRule);
	}

	public static LeaveAnnualRuleLocalService getService() {
		return _service;
	}

	private static volatile LeaveAnnualRuleLocalService _service;

}
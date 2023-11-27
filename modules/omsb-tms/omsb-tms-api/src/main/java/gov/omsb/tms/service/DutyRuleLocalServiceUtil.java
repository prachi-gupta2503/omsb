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

import gov.omsb.tms.model.DutyRule;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DutyRule. This utility wraps
 * <code>gov.omsb.tms.service.impl.DutyRuleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DutyRuleLocalService
 * @generated
 */
public class DutyRuleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.DutyRuleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DutyRule addDutyRule(DutyRule dutyRule) {
		return getService().addDutyRule(dutyRule);
	}

	/**
	 * Creates a new duty rule with the primary key. Does not add the duty rule to the database.
	 *
	 * @param dutyRuleId the primary key for the new duty rule
	 * @return the new duty rule
	 */
	public static DutyRule createDutyRule(long dutyRuleId) {
		return getService().createDutyRule(dutyRuleId);
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
	 * Deletes the duty rule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyRule the duty rule
	 * @return the duty rule that was removed
	 */
	public static DutyRule deleteDutyRule(DutyRule dutyRule) {
		return getService().deleteDutyRule(dutyRule);
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
	public static DutyRule deleteDutyRule(long dutyRuleId)
		throws PortalException {

		return getService().deleteDutyRule(dutyRuleId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyRuleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyRuleModelImpl</code>.
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

	public static DutyRule fetchDutyRule(long dutyRuleId) {
		return getService().fetchDutyRule(dutyRuleId);
	}

	/**
	 * Returns the duty rule matching the UUID and group.
	 *
	 * @param uuid the duty rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public static DutyRule fetchDutyRuleByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDutyRuleByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the duty rule with the primary key.
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule
	 * @throws PortalException if a duty rule with the primary key could not be found
	 */
	public static DutyRule getDutyRule(long dutyRuleId) throws PortalException {
		return getService().getDutyRule(dutyRuleId);
	}

	/**
	 * Returns the duty rule matching the UUID and group.
	 *
	 * @param uuid the duty rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty rule
	 * @throws PortalException if a matching duty rule could not be found
	 */
	public static DutyRule getDutyRuleByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDutyRuleByUuidAndGroupId(uuid, groupId);
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
	public static List<DutyRule> getDutyRules(int start, int end) {
		return getService().getDutyRules(start, end);
	}

	/**
	 * Returns all the duty rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty rules
	 * @param companyId the primary key of the company
	 * @return the matching duty rules, or an empty list if no matches were found
	 */
	public static List<DutyRule> getDutyRulesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDutyRulesByUuidAndCompanyId(uuid, companyId);
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
	public static List<DutyRule> getDutyRulesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyRule> orderByComparator) {

		return getService().getDutyRulesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty rules.
	 *
	 * @return the number of duty rules
	 */
	public static int getDutyRulesCount() {
		return getService().getDutyRulesCount();
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
	 * Updates the duty rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyRule the duty rule
	 * @return the duty rule that was updated
	 */
	public static DutyRule updateDutyRule(DutyRule dutyRule) {
		return getService().updateDutyRule(dutyRule);
	}

	public static DutyRuleLocalService getService() {
		return _service;
	}

	private static volatile DutyRuleLocalService _service;

}
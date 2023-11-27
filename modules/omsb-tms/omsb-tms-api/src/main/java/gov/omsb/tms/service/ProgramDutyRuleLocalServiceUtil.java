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

import gov.omsb.tms.model.ProgramDutyRule;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgramDutyRule. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgramDutyRuleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyRuleLocalService
 * @generated
 */
public class ProgramDutyRuleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgramDutyRuleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the program duty rule to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDutyRule the program duty rule
	 * @return the program duty rule that was added
	 */
	public static ProgramDutyRule addProgramDutyRule(
		ProgramDutyRule programDutyRule) {

		return getService().addProgramDutyRule(programDutyRule);
	}

	public static ProgramDutyRule addProgramDutyRules(
		long programId, long cohortId, long[] dutyRulesId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addProgramDutyRules(
			programId, cohortId, dutyRulesId, serviceContext);
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
	 * Creates a new program duty rule with the primary key. Does not add the program duty rule to the database.
	 *
	 * @param programDutyRuleId the primary key for the new program duty rule
	 * @return the new program duty rule
	 */
	public static ProgramDutyRule createProgramDutyRule(
		long programDutyRuleId) {

		return getService().createProgramDutyRule(programDutyRuleId);
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
	 * Deletes the program duty rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule that was removed
	 * @throws PortalException if a program duty rule with the primary key could not be found
	 */
	public static ProgramDutyRule deleteProgramDutyRule(long programDutyRuleId)
		throws PortalException {

		return getService().deleteProgramDutyRule(programDutyRuleId);
	}

	/**
	 * Deletes the program duty rule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDutyRule the program duty rule
	 * @return the program duty rule that was removed
	 */
	public static ProgramDutyRule deleteProgramDutyRule(
		ProgramDutyRule programDutyRule) {

		return getService().deleteProgramDutyRule(programDutyRule);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDutyRuleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDutyRuleModelImpl</code>.
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

	public static ProgramDutyRule fetchProgramDutyRule(long programDutyRuleId) {
		return getService().fetchProgramDutyRule(programDutyRuleId);
	}

	/**
	 * Returns the program duty rule matching the UUID and group.
	 *
	 * @param uuid the program duty rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchProgramDutyRuleByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProgramDutyRuleByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<gov.omsb.tms.model.DutyRule>
		getDutyRulesListByProgramAndCohort(long programId, long cohortId) {

		return getService().getDutyRulesListByProgramAndCohort(
			programId, cohortId);
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
	 * Returns the program duty rule with the primary key.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule
	 * @throws PortalException if a program duty rule with the primary key could not be found
	 */
	public static ProgramDutyRule getProgramDutyRule(long programDutyRuleId)
		throws PortalException {

		return getService().getProgramDutyRule(programDutyRuleId);
	}

	/**
	 * Returns the program duty rule matching the UUID and group.
	 *
	 * @param uuid the program duty rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duty rule
	 * @throws PortalException if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule getProgramDutyRuleByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProgramDutyRuleByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the program duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of program duty rules
	 */
	public static List<ProgramDutyRule> getProgramDutyRules(
		int start, int end) {

		return getService().getProgramDutyRules(start, end);
	}

	/**
	 * Returns all the program duty rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duty rules
	 * @param companyId the primary key of the company
	 * @return the matching program duty rules, or an empty list if no matches were found
	 */
	public static List<ProgramDutyRule> getProgramDutyRulesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProgramDutyRulesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of program duty rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duty rules
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program duty rules, or an empty list if no matches were found
	 */
	public static List<ProgramDutyRule> getProgramDutyRulesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getService().getProgramDutyRulesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program duty rules.
	 *
	 * @return the number of program duty rules
	 */
	public static int getProgramDutyRulesCount() {
		return getService().getProgramDutyRulesCount();
	}

	/**
	 * Updates the program duty rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDutyRuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDutyRule the program duty rule
	 * @return the program duty rule that was updated
	 */
	public static ProgramDutyRule updateProgramDutyRule(
		ProgramDutyRule programDutyRule) {

		return getService().updateProgramDutyRule(programDutyRule);
	}

	public static ProgramDutyRuleLocalService getService() {
		return _service;
	}

	private static volatile ProgramDutyRuleLocalService _service;

}
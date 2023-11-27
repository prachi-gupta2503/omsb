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
 * Provides a wrapper for {@link ProgramDutyRuleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyRuleLocalService
 * @generated
 */
public class ProgramDutyRuleLocalServiceWrapper
	implements ProgramDutyRuleLocalService,
			   ServiceWrapper<ProgramDutyRuleLocalService> {

	public ProgramDutyRuleLocalServiceWrapper() {
		this(null);
	}

	public ProgramDutyRuleLocalServiceWrapper(
		ProgramDutyRuleLocalService programDutyRuleLocalService) {

		_programDutyRuleLocalService = programDutyRuleLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.ProgramDutyRule addProgramDutyRule(
		gov.omsb.tms.model.ProgramDutyRule programDutyRule) {

		return _programDutyRuleLocalService.addProgramDutyRule(programDutyRule);
	}

	@Override
	public gov.omsb.tms.model.ProgramDutyRule addProgramDutyRules(
		long programId, long cohortId, long[] dutyRulesId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _programDutyRuleLocalService.addProgramDutyRules(
			programId, cohortId, dutyRulesId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyRuleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new program duty rule with the primary key. Does not add the program duty rule to the database.
	 *
	 * @param programDutyRuleId the primary key for the new program duty rule
	 * @return the new program duty rule
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyRule createProgramDutyRule(
		long programDutyRuleId) {

		return _programDutyRuleLocalService.createProgramDutyRule(
			programDutyRuleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyRuleLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public gov.omsb.tms.model.ProgramDutyRule deleteProgramDutyRule(
			long programDutyRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyRuleLocalService.deleteProgramDutyRule(
			programDutyRuleId);
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
	@Override
	public gov.omsb.tms.model.ProgramDutyRule deleteProgramDutyRule(
		gov.omsb.tms.model.ProgramDutyRule programDutyRule) {

		return _programDutyRuleLocalService.deleteProgramDutyRule(
			programDutyRule);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _programDutyRuleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _programDutyRuleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _programDutyRuleLocalService.dynamicQuery();
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

		return _programDutyRuleLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _programDutyRuleLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _programDutyRuleLocalService.dynamicQuery(
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

		return _programDutyRuleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _programDutyRuleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgramDutyRule fetchProgramDutyRule(
		long programDutyRuleId) {

		return _programDutyRuleLocalService.fetchProgramDutyRule(
			programDutyRuleId);
	}

	/**
	 * Returns the program duty rule matching the UUID and group.
	 *
	 * @param uuid the program duty rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyRule
		fetchProgramDutyRuleByUuidAndGroupId(String uuid, long groupId) {

		return _programDutyRuleLocalService.
			fetchProgramDutyRuleByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _programDutyRuleLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<gov.omsb.tms.model.DutyRule>
		getDutyRulesListByProgramAndCohort(long programId, long cohortId) {

		return _programDutyRuleLocalService.getDutyRulesListByProgramAndCohort(
			programId, cohortId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _programDutyRuleLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _programDutyRuleLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programDutyRuleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyRuleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the program duty rule with the primary key.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule
	 * @throws PortalException if a program duty rule with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyRule getProgramDutyRule(
			long programDutyRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyRuleLocalService.getProgramDutyRule(
			programDutyRuleId);
	}

	/**
	 * Returns the program duty rule matching the UUID and group.
	 *
	 * @param uuid the program duty rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duty rule
	 * @throws PortalException if a matching program duty rule could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyRule
			getProgramDutyRuleByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyRuleLocalService.getProgramDutyRuleByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDutyRule>
		getProgramDutyRules(int start, int end) {

		return _programDutyRuleLocalService.getProgramDutyRules(start, end);
	}

	/**
	 * Returns all the program duty rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duty rules
	 * @param companyId the primary key of the company
	 * @return the matching program duty rules, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDutyRule>
		getProgramDutyRulesByUuidAndCompanyId(String uuid, long companyId) {

		return _programDutyRuleLocalService.
			getProgramDutyRulesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDutyRule>
		getProgramDutyRulesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgramDutyRule> orderByComparator) {

		return _programDutyRuleLocalService.
			getProgramDutyRulesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program duty rules.
	 *
	 * @return the number of program duty rules
	 */
	@Override
	public int getProgramDutyRulesCount() {
		return _programDutyRuleLocalService.getProgramDutyRulesCount();
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
	@Override
	public gov.omsb.tms.model.ProgramDutyRule updateProgramDutyRule(
		gov.omsb.tms.model.ProgramDutyRule programDutyRule) {

		return _programDutyRuleLocalService.updateProgramDutyRule(
			programDutyRule);
	}

	@Override
	public ProgramDutyRuleLocalService getWrappedService() {
		return _programDutyRuleLocalService;
	}

	@Override
	public void setWrappedService(
		ProgramDutyRuleLocalService programDutyRuleLocalService) {

		_programDutyRuleLocalService = programDutyRuleLocalService;
	}

	private ProgramDutyRuleLocalService _programDutyRuleLocalService;

}
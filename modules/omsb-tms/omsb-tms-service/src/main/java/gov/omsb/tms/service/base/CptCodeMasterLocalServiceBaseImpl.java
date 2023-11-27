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

package gov.omsb.tms.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import gov.omsb.tms.model.CptCodeMaster;
import gov.omsb.tms.service.CptCodeMasterLocalService;
import gov.omsb.tms.service.CptCodeMasterLocalServiceUtil;
import gov.omsb.tms.service.persistence.BankDetailsPersistence;
import gov.omsb.tms.service.persistence.BlockWeekMetadataDetailsRelPersistence;
import gov.omsb.tms.service.persistence.BlocksMetadataDetailsRelPersistence;
import gov.omsb.tms.service.persistence.CompetenciesMasterPersistence;
import gov.omsb.tms.service.persistence.CptCodeMasterPersistence;
import gov.omsb.tms.service.persistence.DutyAssignmentPersistence;
import gov.omsb.tms.service.persistence.DutyLogPersistence;
import gov.omsb.tms.service.persistence.DutyLogViolationPersistence;
import gov.omsb.tms.service.persistence.DutyRulePersistence;
import gov.omsb.tms.service.persistence.DutyTypesPersistence;
import gov.omsb.tms.service.persistence.EcMemberRequestPersistence;
import gov.omsb.tms.service.persistence.EcMemberRequestRotationsPersistence;
import gov.omsb.tms.service.persistence.EcMemberRequestStatePersistence;
import gov.omsb.tms.service.persistence.EcMemberRequestStatusPersistence;
import gov.omsb.tms.service.persistence.EligibilityDegreeMasterPersistence;
import gov.omsb.tms.service.persistence.FacultyBankDetailsPersistence;
import gov.omsb.tms.service.persistence.FacultyIncentivePersistence;
import gov.omsb.tms.service.persistence.FacultyRequestPersistence;
import gov.omsb.tms.service.persistence.FacultyRequestRotationsPersistence;
import gov.omsb.tms.service.persistence.FacultyRequestStatePersistence;
import gov.omsb.tms.service.persistence.FacultyRequestStatusPersistence;
import gov.omsb.tms.service.persistence.FacultyRotationTsBlockDetailsRelPersistence;
import gov.omsb.tms.service.persistence.FacultyTypePersistence;
import gov.omsb.tms.service.persistence.GenderMasterPersistence;
import gov.omsb.tms.service.persistence.LeaveAnnualMasterPersistence;
import gov.omsb.tms.service.persistence.LeaveAnnualMaxTraineePersistence;
import gov.omsb.tms.service.persistence.LeaveAnnualRulePersistence;
import gov.omsb.tms.service.persistence.LeaveMasterPersistence;
import gov.omsb.tms.service.persistence.LeaveProgramMasterPersistence;
import gov.omsb.tms.service.persistence.LeaveTraineeMasterPersistence;
import gov.omsb.tms.service.persistence.LeaveTypesPersistence;
import gov.omsb.tms.service.persistence.LevelTypeMasterPersistence;
import gov.omsb.tms.service.persistence.OmsbTmsFinderFinder;
import gov.omsb.tms.service.persistence.OmsbTmsFinderPersistence;
import gov.omsb.tms.service.persistence.ParticipationTypeMasterPersistence;
import gov.omsb.tms.service.persistence.PatientTypeMasterPersistence;
import gov.omsb.tms.service.persistence.PatientTypeProgDurationRelPersistence;
import gov.omsb.tms.service.persistence.ProcedureGroupMasterPersistence;
import gov.omsb.tms.service.persistence.ProcedureGroupProceduresCPTCodeRelPersistence;
import gov.omsb.tms.service.persistence.ProcedureMasterPersistence;
import gov.omsb.tms.service.persistence.ProcedurePgProgdurationRelPersistence;
import gov.omsb.tms.service.persistence.ProceduregroupProgdurationRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationCompetenciesRequirementsRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationObjectivesRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationRotationTlPgProcedurePtRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationRotationTraineelevelBlocksRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationRotationTrainingsitesRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationTraineelevelBlocksLevelTypeRelPersistence;
import gov.omsb.tms.service.persistence.ProgramDurationDetailsPersistence;
import gov.omsb.tms.service.persistence.ProgramDutyAssignmentPersistence;
import gov.omsb.tms.service.persistence.ProgramDutyRulePersistence;
import gov.omsb.tms.service.persistence.ProgramEligibilityDegreeRelPersistence;
import gov.omsb.tms.service.persistence.ProgramMasterPersistence;
import gov.omsb.tms.service.persistence.ProgramProgramTypeRelPersistence;
import gov.omsb.tms.service.persistence.ProgramTypeMasterPersistence;
import gov.omsb.tms.service.persistence.ProgramWorkflowDetailsRelPersistence;
import gov.omsb.tms.service.persistence.QararRequestPersistence;
import gov.omsb.tms.service.persistence.RoleTypeMasterPersistence;
import gov.omsb.tms.service.persistence.RoleTypeProgDurationRelPersistence;
import gov.omsb.tms.service.persistence.RotationCompetenciesRequirementsRelPersistence;
import gov.omsb.tms.service.persistence.RotationMasterPersistence;
import gov.omsb.tms.service.persistence.RotationObjectivesRelPersistence;
import gov.omsb.tms.service.persistence.RotationTypeMasterPersistence;
import gov.omsb.tms.service.persistence.SharedRotationApproverDetailsPersistence;
import gov.omsb.tms.service.persistence.SharedRotationRequestDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeAdmissionDetailsRelPersistence;
import gov.omsb.tms.service.persistence.TraineeCohortDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeElectiverotationPriorityDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeLevelMasterPersistence;
import gov.omsb.tms.service.persistence.TraineeLoggedProcedureDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeProgdurationTraineelevelDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeRotationTsBlockDetailsRelPersistence;
import gov.omsb.tms.service.persistence.TraineeSponsorDetailsPersistence;
import gov.omsb.tms.service.persistence.TrainingSitesMasterPersistence;
import gov.omsb.tms.service.persistence.ViolationUpdateStatusPersistence;
import gov.omsb.tms.service.persistence.VisitTypeMasterPersistence;
import gov.omsb.tms.service.persistence.VisitTypeProgDurationRelPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the cpt code master local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link gov.omsb.tms.service.impl.CptCodeMasterLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see gov.omsb.tms.service.impl.CptCodeMasterLocalServiceImpl
 * @generated
 */
public abstract class CptCodeMasterLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CptCodeMasterLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CptCodeMasterLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CptCodeMasterLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cpt code master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CptCodeMaster addCptCodeMaster(CptCodeMaster cptCodeMaster) {
		cptCodeMaster.setNew(true);

		return cptCodeMasterPersistence.update(cptCodeMaster);
	}

	/**
	 * Creates a new cpt code master with the primary key. Does not add the cpt code master to the database.
	 *
	 * @param cptCodeMasterId the primary key for the new cpt code master
	 * @return the new cpt code master
	 */
	@Override
	@Transactional(enabled = false)
	public CptCodeMaster createCptCodeMaster(long cptCodeMasterId) {
		return cptCodeMasterPersistence.create(cptCodeMasterId);
	}

	/**
	 * Deletes the cpt code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master that was removed
	 * @throws PortalException if a cpt code master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CptCodeMaster deleteCptCodeMaster(long cptCodeMasterId)
		throws PortalException {

		return cptCodeMasterPersistence.remove(cptCodeMasterId);
	}

	/**
	 * Deletes the cpt code master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CptCodeMaster deleteCptCodeMaster(CptCodeMaster cptCodeMaster) {
		return cptCodeMasterPersistence.remove(cptCodeMaster);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return cptCodeMasterPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CptCodeMaster.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return cptCodeMasterPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return cptCodeMasterPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return cptCodeMasterPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return cptCodeMasterPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return cptCodeMasterPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CptCodeMaster fetchCptCodeMaster(long cptCodeMasterId) {
		return cptCodeMasterPersistence.fetchByPrimaryKey(cptCodeMasterId);
	}

	/**
	 * Returns the cpt code master matching the UUID and group.
	 *
	 * @param uuid the cpt code master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchCptCodeMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return cptCodeMasterPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cpt code master with the primary key.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master
	 * @throws PortalException if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster getCptCodeMaster(long cptCodeMasterId)
		throws PortalException {

		return cptCodeMasterPersistence.findByPrimaryKey(cptCodeMasterId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(cptCodeMasterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CptCodeMaster.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("cptCodeMasterId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			cptCodeMasterLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CptCodeMaster.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"cptCodeMasterId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(cptCodeMasterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CptCodeMaster.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("cptCodeMasterId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CptCodeMaster>() {

				@Override
				public void performAction(CptCodeMaster cptCodeMaster)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, cptCodeMaster);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(CptCodeMaster.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return cptCodeMasterPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement CptCodeMasterLocalServiceImpl#deleteCptCodeMaster(CptCodeMaster) to avoid orphaned data");
		}

		return cptCodeMasterLocalService.deleteCptCodeMaster(
			(CptCodeMaster)persistedModel);
	}

	@Override
	public BasePersistence<CptCodeMaster> getBasePersistence() {
		return cptCodeMasterPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return cptCodeMasterPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the cpt code masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the cpt code masters
	 * @param companyId the primary key of the company
	 * @return the matching cpt code masters, or an empty list if no matches were found
	 */
	@Override
	public List<CptCodeMaster> getCptCodeMastersByUuidAndCompanyId(
		String uuid, long companyId) {

		return cptCodeMasterPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of cpt code masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the cpt code masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cpt code masters, or an empty list if no matches were found
	 */
	@Override
	public List<CptCodeMaster> getCptCodeMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return cptCodeMasterPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the cpt code master matching the UUID and group.
	 *
	 * @param uuid the cpt code master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cpt code master
	 * @throws PortalException if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster getCptCodeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return cptCodeMasterPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of cpt code masters
	 */
	@Override
	public List<CptCodeMaster> getCptCodeMasters(int start, int end) {
		return cptCodeMasterPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cpt code masters.
	 *
	 * @return the number of cpt code masters
	 */
	@Override
	public int getCptCodeMastersCount() {
		return cptCodeMasterPersistence.countAll();
	}

	/**
	 * Updates the cpt code master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CptCodeMaster updateCptCodeMaster(CptCodeMaster cptCodeMaster) {
		return cptCodeMasterPersistence.update(cptCodeMaster);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CptCodeMasterLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		cptCodeMasterLocalService = (CptCodeMasterLocalService)aopProxy;

		_setLocalServiceUtilService(cptCodeMasterLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CptCodeMasterLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CptCodeMaster.class;
	}

	protected String getModelClassName() {
		return CptCodeMaster.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = cptCodeMasterPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		CptCodeMasterLocalService cptCodeMasterLocalService) {

		try {
			Field field = CptCodeMasterLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, cptCodeMasterLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected BankDetailsPersistence bankDetailsPersistence;

	@Reference
	protected BlocksMetadataDetailsRelPersistence
		blocksMetadataDetailsRelPersistence;

	@Reference
	protected BlockWeekMetadataDetailsRelPersistence
		blockWeekMetadataDetailsRelPersistence;

	@Reference
	protected CompetenciesMasterPersistence competenciesMasterPersistence;

	protected CptCodeMasterLocalService cptCodeMasterLocalService;

	@Reference
	protected CptCodeMasterPersistence cptCodeMasterPersistence;

	@Reference
	protected DutyAssignmentPersistence dutyAssignmentPersistence;

	@Reference
	protected DutyLogPersistence dutyLogPersistence;

	@Reference
	protected DutyLogViolationPersistence dutyLogViolationPersistence;

	@Reference
	protected DutyRulePersistence dutyRulePersistence;

	@Reference
	protected DutyTypesPersistence dutyTypesPersistence;

	@Reference
	protected EcMemberRequestPersistence ecMemberRequestPersistence;

	@Reference
	protected EcMemberRequestRotationsPersistence
		ecMemberRequestRotationsPersistence;

	@Reference
	protected EcMemberRequestStatePersistence ecMemberRequestStatePersistence;

	@Reference
	protected EcMemberRequestStatusPersistence ecMemberRequestStatusPersistence;

	@Reference
	protected EligibilityDegreeMasterPersistence
		eligibilityDegreeMasterPersistence;

	@Reference
	protected FacultyBankDetailsPersistence facultyBankDetailsPersistence;

	@Reference
	protected FacultyIncentivePersistence facultyIncentivePersistence;

	@Reference
	protected FacultyRequestPersistence facultyRequestPersistence;

	@Reference
	protected FacultyRequestRotationsPersistence
		facultyRequestRotationsPersistence;

	@Reference
	protected FacultyRequestStatePersistence facultyRequestStatePersistence;

	@Reference
	protected FacultyRequestStatusPersistence facultyRequestStatusPersistence;

	@Reference
	protected FacultyRotationTsBlockDetailsRelPersistence
		facultyRotationTsBlockDetailsRelPersistence;

	@Reference
	protected FacultyTypePersistence facultyTypePersistence;

	@Reference
	protected GenderMasterPersistence genderMasterPersistence;

	@Reference
	protected LeaveAnnualMasterPersistence leaveAnnualMasterPersistence;

	@Reference
	protected LeaveAnnualMaxTraineePersistence leaveAnnualMaxTraineePersistence;

	@Reference
	protected LeaveAnnualRulePersistence leaveAnnualRulePersistence;

	@Reference
	protected LeaveMasterPersistence leaveMasterPersistence;

	@Reference
	protected LeaveProgramMasterPersistence leaveProgramMasterPersistence;

	@Reference
	protected LeaveTraineeMasterPersistence leaveTraineeMasterPersistence;

	@Reference
	protected LeaveTypesPersistence leaveTypesPersistence;

	@Reference
	protected LevelTypeMasterPersistence levelTypeMasterPersistence;

	@Reference
	protected OmsbTmsFinderPersistence omsbTmsFinderPersistence;

	@Reference
	protected OmsbTmsFinderFinder omsbTmsFinderFinder;

	@Reference
	protected ParticipationTypeMasterPersistence
		participationTypeMasterPersistence;

	@Reference
	protected PatientTypeMasterPersistence patientTypeMasterPersistence;

	@Reference
	protected PatientTypeProgDurationRelPersistence
		patientTypeProgDurationRelPersistence;

	@Reference
	protected ProcedureGroupMasterPersistence procedureGroupMasterPersistence;

	@Reference
	protected ProcedureGroupProceduresCPTCodeRelPersistence
		procedureGroupProceduresCPTCodeRelPersistence;

	@Reference
	protected ProceduregroupProgdurationRelPersistence
		proceduregroupProgdurationRelPersistence;

	@Reference
	protected ProcedureMasterPersistence procedureMasterPersistence;

	@Reference
	protected ProcedurePgProgdurationRelPersistence
		procedurePgProgdurationRelPersistence;

	@Reference
	protected ProgdurationCompetenciesRequirementsRelPersistence
		progdurationCompetenciesRequirementsRelPersistence;

	@Reference
	protected ProgdurationObjectivesRelPersistence
		progdurationObjectivesRelPersistence;

	@Reference
	protected ProgdurationRotationTlPgProcedurePtRelPersistence
		progdurationRotationTlPgProcedurePtRelPersistence;

	@Reference
	protected ProgdurationRotationTraineelevelBlocksRelPersistence
		progdurationRotationTraineelevelBlocksRelPersistence;

	@Reference
	protected ProgdurationRotationTrainingsitesRelPersistence
		progdurationRotationTrainingsitesRelPersistence;

	@Reference
	protected ProgdurationTraineelevelBlocksLevelTypeRelPersistence
		progdurationTraineelevelBlocksLevelTypeRelPersistence;

	@Reference
	protected ProgramDurationDetailsPersistence
		programDurationDetailsPersistence;

	@Reference
	protected ProgramDutyAssignmentPersistence programDutyAssignmentPersistence;

	@Reference
	protected ProgramDutyRulePersistence programDutyRulePersistence;

	@Reference
	protected ProgramEligibilityDegreeRelPersistence
		programEligibilityDegreeRelPersistence;

	@Reference
	protected ProgramMasterPersistence programMasterPersistence;

	@Reference
	protected ProgramProgramTypeRelPersistence programProgramTypeRelPersistence;

	@Reference
	protected ProgramTypeMasterPersistence programTypeMasterPersistence;

	@Reference
	protected ProgramWorkflowDetailsRelPersistence
		programWorkflowDetailsRelPersistence;

	@Reference
	protected QararRequestPersistence qararRequestPersistence;

	@Reference
	protected RoleTypeMasterPersistence roleTypeMasterPersistence;

	@Reference
	protected RoleTypeProgDurationRelPersistence
		roleTypeProgDurationRelPersistence;

	@Reference
	protected RotationCompetenciesRequirementsRelPersistence
		rotationCompetenciesRequirementsRelPersistence;

	@Reference
	protected RotationMasterPersistence rotationMasterPersistence;

	@Reference
	protected RotationObjectivesRelPersistence rotationObjectivesRelPersistence;

	@Reference
	protected RotationTypeMasterPersistence rotationTypeMasterPersistence;

	@Reference
	protected SharedRotationApproverDetailsPersistence
		sharedRotationApproverDetailsPersistence;

	@Reference
	protected SharedRotationRequestDetailsPersistence
		sharedRotationRequestDetailsPersistence;

	@Reference
	protected TraineeAdmissionDetailsRelPersistence
		traineeAdmissionDetailsRelPersistence;

	@Reference
	protected TraineeCohortDetailsPersistence traineeCohortDetailsPersistence;

	@Reference
	protected TraineeElectiverotationPriorityDetailsPersistence
		traineeElectiverotationPriorityDetailsPersistence;

	@Reference
	protected TraineeLevelMasterPersistence traineeLevelMasterPersistence;

	@Reference
	protected TraineeLoggedProcedureDetailsPersistence
		traineeLoggedProcedureDetailsPersistence;

	@Reference
	protected TraineeProgdurationTraineelevelDetailsPersistence
		traineeProgdurationTraineelevelDetailsPersistence;

	@Reference
	protected TraineeRotationTsBlockDetailsRelPersistence
		traineeRotationTsBlockDetailsRelPersistence;

	@Reference
	protected TraineeSponsorDetailsPersistence traineeSponsorDetailsPersistence;

	@Reference
	protected TrainingSitesMasterPersistence trainingSitesMasterPersistence;

	@Reference
	protected ViolationUpdateStatusPersistence violationUpdateStatusPersistence;

	@Reference
	protected VisitTypeMasterPersistence visitTypeMasterPersistence;

	@Reference
	protected VisitTypeProgDurationRelPersistence
		visitTypeProgDurationRelPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		CptCodeMasterLocalServiceBaseImpl.class);

}
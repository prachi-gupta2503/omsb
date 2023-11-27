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

import gov.omsb.tms.model.ProceduregroupProgdurationRel;
import gov.omsb.tms.service.ProceduregroupProgdurationRelLocalService;
import gov.omsb.tms.service.ProceduregroupProgdurationRelLocalServiceUtil;
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
 * Provides the base implementation for the proceduregroup progduration rel local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link gov.omsb.tms.service.impl.ProceduregroupProgdurationRelLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see gov.omsb.tms.service.impl.ProceduregroupProgdurationRelLocalServiceImpl
 * @generated
 */
public abstract class ProceduregroupProgdurationRelLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ProceduregroupProgdurationRelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProceduregroupProgdurationRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ProceduregroupProgdurationRelLocalServiceUtil</code>.
	 */

	/**
	 * Adds the proceduregroup progduration rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduregroupProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProceduregroupProgdurationRel addProceduregroupProgdurationRel(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		proceduregroupProgdurationRel.setNew(true);

		return proceduregroupProgdurationRelPersistence.update(
			proceduregroupProgdurationRel);
	}

	/**
	 * Creates a new proceduregroup progduration rel with the primary key. Does not add the proceduregroup progduration rel to the database.
	 *
	 * @param pgPdRelId the primary key for the new proceduregroup progduration rel
	 * @return the new proceduregroup progduration rel
	 */
	@Override
	@Transactional(enabled = false)
	public ProceduregroupProgdurationRel createProceduregroupProgdurationRel(
		long pgPdRelId) {

		return proceduregroupProgdurationRelPersistence.create(pgPdRelId);
	}

	/**
	 * Deletes the proceduregroup progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduregroupProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was removed
	 * @throws PortalException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProceduregroupProgdurationRel deleteProceduregroupProgdurationRel(
			long pgPdRelId)
		throws PortalException {

		return proceduregroupProgdurationRelPersistence.remove(pgPdRelId);
	}

	/**
	 * Deletes the proceduregroup progduration rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduregroupProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProceduregroupProgdurationRel deleteProceduregroupProgdurationRel(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		return proceduregroupProgdurationRelPersistence.remove(
			proceduregroupProgdurationRel);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return proceduregroupProgdurationRelPersistence.dslQuery(dslQuery);
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
			ProceduregroupProgdurationRel.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return proceduregroupProgdurationRelPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProceduregroupProgdurationRelModelImpl</code>.
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

		return proceduregroupProgdurationRelPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProceduregroupProgdurationRelModelImpl</code>.
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

		return proceduregroupProgdurationRelPersistence.findWithDynamicQuery(
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
		return proceduregroupProgdurationRelPersistence.countWithDynamicQuery(
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
		DynamicQuery dynamicQuery, Projection projection) {

		return proceduregroupProgdurationRelPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ProceduregroupProgdurationRel fetchProceduregroupProgdurationRel(
		long pgPdRelId) {

		return proceduregroupProgdurationRelPersistence.fetchByPrimaryKey(
			pgPdRelId);
	}

	/**
	 * Returns the proceduregroup progduration rel matching the UUID and group.
	 *
	 * @param uuid the proceduregroup progduration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel
		fetchProceduregroupProgdurationRelByUuidAndGroupId(
			String uuid, long groupId) {

		return proceduregroupProgdurationRelPersistence.fetchByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns the proceduregroup progduration rel with the primary key.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel
	 * @throws PortalException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel getProceduregroupProgdurationRel(
			long pgPdRelId)
		throws PortalException {

		return proceduregroupProgdurationRelPersistence.findByPrimaryKey(
			pgPdRelId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			proceduregroupProgdurationRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			ProceduregroupProgdurationRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("pgPdRelId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			proceduregroupProgdurationRelLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			ProceduregroupProgdurationRel.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("pgPdRelId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			proceduregroupProgdurationRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			ProceduregroupProgdurationRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("pgPdRelId");
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
			new ActionableDynamicQuery.PerformActionMethod
				<ProceduregroupProgdurationRel>() {

				@Override
				public void performAction(
						ProceduregroupProgdurationRel
							proceduregroupProgdurationRel)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, proceduregroupProgdurationRel);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					ProceduregroupProgdurationRel.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return proceduregroupProgdurationRelPersistence.create(
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
				"Implement ProceduregroupProgdurationRelLocalServiceImpl#deleteProceduregroupProgdurationRel(ProceduregroupProgdurationRel) to avoid orphaned data");
		}

		return proceduregroupProgdurationRelLocalService.
			deleteProceduregroupProgdurationRel(
				(ProceduregroupProgdurationRel)persistedModel);
	}

	@Override
	public BasePersistence<ProceduregroupProgdurationRel> getBasePersistence() {
		return proceduregroupProgdurationRelPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return proceduregroupProgdurationRelPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the proceduregroup progduration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the proceduregroup progduration rels
	 * @param companyId the primary key of the company
	 * @return the matching proceduregroup progduration rels, or an empty list if no matches were found
	 */
	@Override
	public List<ProceduregroupProgdurationRel>
		getProceduregroupProgdurationRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return proceduregroupProgdurationRelPersistence.findByUuid_C(
			uuid, companyId);
	}

	/**
	 * Returns a range of proceduregroup progduration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the proceduregroup progduration rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching proceduregroup progduration rels, or an empty list if no matches were found
	 */
	@Override
	public List<ProceduregroupProgdurationRel>
		getProceduregroupProgdurationRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProceduregroupProgdurationRel>
				orderByComparator) {

		return proceduregroupProgdurationRelPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the proceduregroup progduration rel matching the UUID and group.
	 *
	 * @param uuid the proceduregroup progduration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching proceduregroup progduration rel
	 * @throws PortalException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel
			getProceduregroupProgdurationRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return proceduregroupProgdurationRelPersistence.findByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel>
		getProceduregroupProgdurationRels(int start, int end) {

		return proceduregroupProgdurationRelPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of proceduregroup progduration rels.
	 *
	 * @return the number of proceduregroup progduration rels
	 */
	@Override
	public int getProceduregroupProgdurationRelsCount() {
		return proceduregroupProgdurationRelPersistence.countAll();
	}

	/**
	 * Updates the proceduregroup progduration rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduregroupProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProceduregroupProgdurationRel updateProceduregroupProgdurationRel(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		return proceduregroupProgdurationRelPersistence.update(
			proceduregroupProgdurationRel);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProceduregroupProgdurationRelLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		proceduregroupProgdurationRelLocalService =
			(ProceduregroupProgdurationRelLocalService)aopProxy;

		_setLocalServiceUtilService(proceduregroupProgdurationRelLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProceduregroupProgdurationRelLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ProceduregroupProgdurationRel.class;
	}

	protected String getModelClassName() {
		return ProceduregroupProgdurationRel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				proceduregroupProgdurationRelPersistence.getDataSource();

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
		ProceduregroupProgdurationRelLocalService
			proceduregroupProgdurationRelLocalService) {

		try {
			Field field =
				ProceduregroupProgdurationRelLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, proceduregroupProgdurationRelLocalService);
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

	protected ProceduregroupProgdurationRelLocalService
		proceduregroupProgdurationRelLocalService;

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
		ProceduregroupProgdurationRelLocalServiceBaseImpl.class);

}
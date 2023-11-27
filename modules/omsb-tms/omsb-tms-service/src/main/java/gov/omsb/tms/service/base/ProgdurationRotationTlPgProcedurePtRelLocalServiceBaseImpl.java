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

import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalServiceUtil;
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
 * Provides the base implementation for the progduration rotation tl pg procedure pt rel local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link gov.omsb.tms.service.impl.ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see gov.omsb.tms.service.impl.ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl
 * @generated
 */
public abstract class ProgdurationRotationTlPgProcedurePtRelLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ProgdurationRotationTlPgProcedurePtRelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProgdurationRotationTlPgProcedurePtRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ProgdurationRotationTlPgProcedurePtRelLocalServiceUtil</code>.
	 */

	/**
	 * Adds the progduration rotation tl pg procedure pt rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		addProgdurationRotationTlPgProcedurePtRel(
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		progdurationRotationTlPgProcedurePtRel.setNew(true);

		return progdurationRotationTlPgProcedurePtRelPersistence.update(
			progdurationRotationTlPgProcedurePtRel);
	}

	/**
	 * Creates a new progduration rotation tl pg procedure pt rel with the primary key. Does not add the progduration rotation tl pg procedure pt rel to the database.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key for the new progduration rotation tl pg procedure pt rel
	 * @return the new progduration rotation tl pg procedure pt rel
	 */
	@Override
	@Transactional(enabled = false)
	public ProgdurationRotationTlPgProcedurePtRel
		createProgdurationRotationTlPgProcedurePtRel(
			long progdurationRotationTlPgProcedurePtRelId) {

		return progdurationRotationTlPgProcedurePtRelPersistence.create(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Deletes the progduration rotation tl pg procedure pt rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 * @throws PortalException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
			deleteProgdurationRotationTlPgProcedurePtRel(
				long progdurationRotationTlPgProcedurePtRelId)
		throws PortalException {

		return progdurationRotationTlPgProcedurePtRelPersistence.remove(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Deletes the progduration rotation tl pg procedure pt rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		deleteProgdurationRotationTlPgProcedurePtRel(
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		return progdurationRotationTlPgProcedurePtRelPersistence.remove(
			progdurationRotationTlPgProcedurePtRel);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return progdurationRotationTlPgProcedurePtRelPersistence.dslQuery(
			dslQuery);
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
			ProgdurationRotationTlPgProcedurePtRel.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return progdurationRotationTlPgProcedurePtRelPersistence.
			findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
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

		return progdurationRotationTlPgProcedurePtRelPersistence.
			findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
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

		return progdurationRotationTlPgProcedurePtRelPersistence.
			findWithDynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return progdurationRotationTlPgProcedurePtRelPersistence.
			countWithDynamicQuery(dynamicQuery);
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

		return progdurationRotationTlPgProcedurePtRelPersistence.
			countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		fetchProgdurationRotationTlPgProcedurePtRel(
			long progdurationRotationTlPgProcedurePtRelId) {

		return progdurationRotationTlPgProcedurePtRelPersistence.
			fetchByPrimaryKey(progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation tl pg procedure pt rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		fetchProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
			String uuid, long groupId) {

		return progdurationRotationTlPgProcedurePtRelPersistence.fetchByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel
	 * @throws PortalException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
			getProgdurationRotationTlPgProcedurePtRel(
				long progdurationRotationTlPgProcedurePtRelId)
		throws PortalException {

		return progdurationRotationTlPgProcedurePtRelPersistence.
			findByPrimaryKey(progdurationRotationTlPgProcedurePtRelId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			progdurationRotationTlPgProcedurePtRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			ProgdurationRotationTlPgProcedurePtRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"progdurationRotationTlPgProcedurePtRelId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			progdurationRotationTlPgProcedurePtRelLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			ProgdurationRotationTlPgProcedurePtRel.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"progdurationRotationTlPgProcedurePtRelId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			progdurationRotationTlPgProcedurePtRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			ProgdurationRotationTlPgProcedurePtRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"progdurationRotationTlPgProcedurePtRelId");
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
				<ProgdurationRotationTlPgProcedurePtRel>() {

				@Override
				public void performAction(
						ProgdurationRotationTlPgProcedurePtRel
							progdurationRotationTlPgProcedurePtRel)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext,
						progdurationRotationTlPgProcedurePtRel);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					ProgdurationRotationTlPgProcedurePtRel.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return progdurationRotationTlPgProcedurePtRelPersistence.create(
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
				"Implement ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl#deleteProgdurationRotationTlPgProcedurePtRel(ProgdurationRotationTlPgProcedurePtRel) to avoid orphaned data");
		}

		return progdurationRotationTlPgProcedurePtRelLocalService.
			deleteProgdurationRotationTlPgProcedurePtRel(
				(ProgdurationRotationTlPgProcedurePtRel)persistedModel);
	}

	@Override
	public BasePersistence<ProgdurationRotationTlPgProcedurePtRel>
		getBasePersistence() {

		return progdurationRotationTlPgProcedurePtRelPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return progdurationRotationTlPgProcedurePtRelPersistence.
			findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation tl pg procedure pt rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation tl pg procedure pt rels, or an empty list if no matches were found
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel>
		getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return progdurationRotationTlPgProcedurePtRelPersistence.findByUuid_C(
			uuid, companyId);
	}

	/**
	 * Returns a range of progduration rotation tl pg procedure pt rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation tl pg procedure pt rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration rotation tl pg procedure pt rels, or an empty list if no matches were found
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel>
		getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return progdurationRotationTlPgProcedurePtRelPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation tl pg procedure pt rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws PortalException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
			getProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return progdurationRotationTlPgProcedurePtRelPersistence.findByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel>
		getProgdurationRotationTlPgProcedurePtRels(int start, int end) {

		return progdurationRotationTlPgProcedurePtRelPersistence.findAll(
			start, end);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels.
	 *
	 * @return the number of progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int getProgdurationRotationTlPgProcedurePtRelsCount() {
		return progdurationRotationTlPgProcedurePtRelPersistence.countAll();
	}

	/**
	 * Updates the progduration rotation tl pg procedure pt rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		updateProgdurationRotationTlPgProcedurePtRel(
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		return progdurationRotationTlPgProcedurePtRelPersistence.update(
			progdurationRotationTlPgProcedurePtRel);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProgdurationRotationTlPgProcedurePtRelLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		progdurationRotationTlPgProcedurePtRelLocalService =
			(ProgdurationRotationTlPgProcedurePtRelLocalService)aopProxy;

		_setLocalServiceUtilService(
			progdurationRotationTlPgProcedurePtRelLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProgdurationRotationTlPgProcedurePtRelLocalService.class.
			getName();
	}

	protected Class<?> getModelClass() {
		return ProgdurationRotationTlPgProcedurePtRel.class;
	}

	protected String getModelClassName() {
		return ProgdurationRotationTlPgProcedurePtRel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				progdurationRotationTlPgProcedurePtRelPersistence.
					getDataSource();

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
		ProgdurationRotationTlPgProcedurePtRelLocalService
			progdurationRotationTlPgProcedurePtRelLocalService) {

		try {
			Field field =
				ProgdurationRotationTlPgProcedurePtRelLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, progdurationRotationTlPgProcedurePtRelLocalService);
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

	protected ProgdurationRotationTlPgProcedurePtRelLocalService
		progdurationRotationTlPgProcedurePtRelLocalService;

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
		ProgdurationRotationTlPgProcedurePtRelLocalServiceBaseImpl.class);

}
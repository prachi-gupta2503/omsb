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
 * Provides a wrapper for {@link BankDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BankDetailsLocalService
 * @generated
 */
public class BankDetailsLocalServiceWrapper
	implements BankDetailsLocalService,
			   ServiceWrapper<BankDetailsLocalService> {

	public BankDetailsLocalServiceWrapper() {
		this(null);
	}

	public BankDetailsLocalServiceWrapper(
		BankDetailsLocalService bankDetailsLocalService) {

		_bankDetailsLocalService = bankDetailsLocalService;
	}

	/**
	 * Adds the bank details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankDetails the bank details
	 * @return the bank details that was added
	 */
	@Override
	public gov.omsb.tms.model.BankDetails addBankDetails(
		gov.omsb.tms.model.BankDetails bankDetails) {

		return _bankDetailsLocalService.addBankDetails(bankDetails);
	}

	@Override
	public gov.omsb.tms.model.BankDetails addBankDetails(
		String bankName, String bankBranch, String accountNumber,
		long ecMemberRequestId) {

		return _bankDetailsLocalService.addBankDetails(
			bankName, bankBranch, accountNumber, ecMemberRequestId);
	}

	/**
	 * Creates a new bank details with the primary key. Does not add the bank details to the database.
	 *
	 * @param bankDetailsId the primary key for the new bank details
	 * @return the new bank details
	 */
	@Override
	public gov.omsb.tms.model.BankDetails createBankDetails(
		long bankDetailsId) {

		return _bankDetailsLocalService.createBankDetails(bankDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the bank details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankDetails the bank details
	 * @return the bank details that was removed
	 */
	@Override
	public gov.omsb.tms.model.BankDetails deleteBankDetails(
		gov.omsb.tms.model.BankDetails bankDetails) {

		return _bankDetailsLocalService.deleteBankDetails(bankDetails);
	}

	/**
	 * Deletes the bank details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details that was removed
	 * @throws PortalException if a bank details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.BankDetails deleteBankDetails(long bankDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankDetailsLocalService.deleteBankDetails(bankDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bankDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bankDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bankDetailsLocalService.dynamicQuery();
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

		return _bankDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BankDetailsModelImpl</code>.
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

		return _bankDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BankDetailsModelImpl</code>.
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

		return _bankDetailsLocalService.dynamicQuery(
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

		return _bankDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bankDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.BankDetails editBankDetails(
		long bankDetailsId, String bankName, String bankBranch,
		String accountNumber, long ecMemberRequestId) {

		return _bankDetailsLocalService.editBankDetails(
			bankDetailsId, bankName, bankBranch, accountNumber,
			ecMemberRequestId);
	}

	@Override
	public gov.omsb.tms.model.BankDetails fetchBankDetails(long bankDetailsId) {
		return _bankDetailsLocalService.fetchBankDetails(bankDetailsId);
	}

	/**
	 * Returns the bank details matching the UUID and group.
	 *
	 * @param uuid the bank details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	@Override
	public gov.omsb.tms.model.BankDetails fetchBankDetailsByUuidAndGroupId(
		String uuid, long groupId) {

		return _bankDetailsLocalService.fetchBankDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.BankDetails findByEcMemberRequestId(
		long ecMemberRequestId) {

		return _bankDetailsLocalService.findByEcMemberRequestId(
			ecMemberRequestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bankDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bank details with the primary key.
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details
	 * @throws PortalException if a bank details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.BankDetails getBankDetails(long bankDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankDetailsLocalService.getBankDetails(bankDetailsId);
	}

	/**
	 * Returns the bank details matching the UUID and group.
	 *
	 * @param uuid the bank details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank details
	 * @throws PortalException if a matching bank details could not be found
	 */
	@Override
	public gov.omsb.tms.model.BankDetails getBankDetailsByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankDetailsLocalService.getBankDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @return the range of bank detailses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.BankDetails> getBankDetailses(
		int start, int end) {

		return _bankDetailsLocalService.getBankDetailses(start, end);
	}

	/**
	 * Returns all the bank detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the bank detailses
	 * @param companyId the primary key of the company
	 * @return the matching bank detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.BankDetails>
		getBankDetailsesByUuidAndCompanyId(String uuid, long companyId) {

		return _bankDetailsLocalService.getBankDetailsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of bank detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the bank detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of bank detailses
	 * @param end the upper bound of the range of bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching bank detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.BankDetails>
		getBankDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.BankDetails> orderByComparator) {

		return _bankDetailsLocalService.getBankDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of bank detailses.
	 *
	 * @return the number of bank detailses
	 */
	@Override
	public int getBankDetailsesCount() {
		return _bankDetailsLocalService.getBankDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _bankDetailsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bankDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bank details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankDetails the bank details
	 * @return the bank details that was updated
	 */
	@Override
	public gov.omsb.tms.model.BankDetails updateBankDetails(
		gov.omsb.tms.model.BankDetails bankDetails) {

		return _bankDetailsLocalService.updateBankDetails(bankDetails);
	}

	@Override
	public BankDetailsLocalService getWrappedService() {
		return _bankDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		BankDetailsLocalService bankDetailsLocalService) {

		_bankDetailsLocalService = bankDetailsLocalService;
	}

	private BankDetailsLocalService _bankDetailsLocalService;

}
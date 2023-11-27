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

import gov.omsb.tms.model.BankDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BankDetails. This utility wraps
 * <code>gov.omsb.tms.service.impl.BankDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BankDetailsLocalService
 * @generated
 */
public class BankDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.BankDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static BankDetails addBankDetails(BankDetails bankDetails) {
		return getService().addBankDetails(bankDetails);
	}

	public static BankDetails addBankDetails(
		String bankName, String bankBranch, String accountNumber,
		long ecMemberRequestId) {

		return getService().addBankDetails(
			bankName, bankBranch, accountNumber, ecMemberRequestId);
	}

	/**
	 * Creates a new bank details with the primary key. Does not add the bank details to the database.
	 *
	 * @param bankDetailsId the primary key for the new bank details
	 * @return the new bank details
	 */
	public static BankDetails createBankDetails(long bankDetailsId) {
		return getService().createBankDetails(bankDetailsId);
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
	 * Deletes the bank details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankDetails the bank details
	 * @return the bank details that was removed
	 */
	public static BankDetails deleteBankDetails(BankDetails bankDetails) {
		return getService().deleteBankDetails(bankDetails);
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
	public static BankDetails deleteBankDetails(long bankDetailsId)
		throws PortalException {

		return getService().deleteBankDetails(bankDetailsId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BankDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BankDetailsModelImpl</code>.
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

	public static BankDetails editBankDetails(
		long bankDetailsId, String bankName, String bankBranch,
		String accountNumber, long ecMemberRequestId) {

		return getService().editBankDetails(
			bankDetailsId, bankName, bankBranch, accountNumber,
			ecMemberRequestId);
	}

	public static BankDetails fetchBankDetails(long bankDetailsId) {
		return getService().fetchBankDetails(bankDetailsId);
	}

	/**
	 * Returns the bank details matching the UUID and group.
	 *
	 * @param uuid the bank details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank details, or <code>null</code> if a matching bank details could not be found
	 */
	public static BankDetails fetchBankDetailsByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBankDetailsByUuidAndGroupId(uuid, groupId);
	}

	public static BankDetails findByEcMemberRequestId(long ecMemberRequestId) {
		return getService().findByEcMemberRequestId(ecMemberRequestId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the bank details with the primary key.
	 *
	 * @param bankDetailsId the primary key of the bank details
	 * @return the bank details
	 * @throws PortalException if a bank details with the primary key could not be found
	 */
	public static BankDetails getBankDetails(long bankDetailsId)
		throws PortalException {

		return getService().getBankDetails(bankDetailsId);
	}

	/**
	 * Returns the bank details matching the UUID and group.
	 *
	 * @param uuid the bank details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank details
	 * @throws PortalException if a matching bank details could not be found
	 */
	public static BankDetails getBankDetailsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getBankDetailsByUuidAndGroupId(uuid, groupId);
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
	public static List<BankDetails> getBankDetailses(int start, int end) {
		return getService().getBankDetailses(start, end);
	}

	/**
	 * Returns all the bank detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the bank detailses
	 * @param companyId the primary key of the company
	 * @return the matching bank detailses, or an empty list if no matches were found
	 */
	public static List<BankDetails> getBankDetailsesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBankDetailsesByUuidAndCompanyId(uuid, companyId);
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
	public static List<BankDetails> getBankDetailsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BankDetails> orderByComparator) {

		return getService().getBankDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of bank detailses.
	 *
	 * @return the number of bank detailses
	 */
	public static int getBankDetailsesCount() {
		return getService().getBankDetailsesCount();
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
	 * Updates the bank details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankDetails the bank details
	 * @return the bank details that was updated
	 */
	public static BankDetails updateBankDetails(BankDetails bankDetails) {
		return getService().updateBankDetails(bankDetails);
	}

	public static BankDetailsLocalService getService() {
		return _service;
	}

	private static volatile BankDetailsLocalService _service;

}
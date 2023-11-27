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

package gov.omsb.email.template.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmailTemplateMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplateMasterLocalService
 * @generated
 */
public class EmailTemplateMasterLocalServiceWrapper
	implements EmailTemplateMasterLocalService,
			   ServiceWrapper<EmailTemplateMasterLocalService> {

	public EmailTemplateMasterLocalServiceWrapper() {
		this(null);
	}

	public EmailTemplateMasterLocalServiceWrapper(
		EmailTemplateMasterLocalService emailTemplateMasterLocalService) {

		_emailTemplateMasterLocalService = emailTemplateMasterLocalService;
	}

	/**
	 * Adds the email template master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailTemplateMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailTemplateMaster the email template master
	 * @return the email template master that was added
	 */
	@Override
	public gov.omsb.email.template.master.model.EmailTemplateMaster
		addEmailTemplateMaster(
			gov.omsb.email.template.master.model.EmailTemplateMaster
				emailTemplateMaster) {

		return _emailTemplateMasterLocalService.addEmailTemplateMaster(
			emailTemplateMaster);
	}

	/**
	 * Creates a new email template master with the primary key. Does not add the email template master to the database.
	 *
	 * @param templateId the primary key for the new email template master
	 * @return the new email template master
	 */
	@Override
	public gov.omsb.email.template.master.model.EmailTemplateMaster
		createEmailTemplateMaster(long templateId) {

		return _emailTemplateMasterLocalService.createEmailTemplateMaster(
			templateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the email template master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailTemplateMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailTemplateMaster the email template master
	 * @return the email template master that was removed
	 */
	@Override
	public gov.omsb.email.template.master.model.EmailTemplateMaster
		deleteEmailTemplateMaster(
			gov.omsb.email.template.master.model.EmailTemplateMaster
				emailTemplateMaster) {

		return _emailTemplateMasterLocalService.deleteEmailTemplateMaster(
			emailTemplateMaster);
	}

	/**
	 * Deletes the email template master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailTemplateMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master that was removed
	 * @throws PortalException if a email template master with the primary key could not be found
	 */
	@Override
	public gov.omsb.email.template.master.model.EmailTemplateMaster
			deleteEmailTemplateMaster(long templateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateMasterLocalService.deleteEmailTemplateMaster(
			templateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _emailTemplateMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _emailTemplateMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailTemplateMasterLocalService.dynamicQuery();
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

		return _emailTemplateMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.email.template.master.model.impl.EmailTemplateMasterModelImpl</code>.
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

		return _emailTemplateMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.email.template.master.model.impl.EmailTemplateMasterModelImpl</code>.
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

		return _emailTemplateMasterLocalService.dynamicQuery(
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

		return _emailTemplateMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _emailTemplateMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.email.template.master.model.EmailTemplateMaster
		fetchEmailTemplateMaster(long templateId) {

		return _emailTemplateMasterLocalService.fetchEmailTemplateMaster(
			templateId);
	}

	@Override
	public gov.omsb.email.template.master.model.EmailTemplateMaster
			findByTemplateName(String templateName)
		throws gov.omsb.email.template.master.exception.
			NoSuchEmailTemplateMasterException {

		return _emailTemplateMasterLocalService.findByTemplateName(
			templateName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _emailTemplateMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the email template master with the primary key.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master
	 * @throws PortalException if a email template master with the primary key could not be found
	 */
	@Override
	public gov.omsb.email.template.master.model.EmailTemplateMaster
			getEmailTemplateMaster(long templateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateMasterLocalService.getEmailTemplateMaster(
			templateId);
	}

	/**
	 * Returns a range of all the email template masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.email.template.master.model.impl.EmailTemplateMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email template masters
	 * @param end the upper bound of the range of email template masters (not inclusive)
	 * @return the range of email template masters
	 */
	@Override
	public java.util.List
		<gov.omsb.email.template.master.model.EmailTemplateMaster>
			getEmailTemplateMasters(int start, int end) {

		return _emailTemplateMasterLocalService.getEmailTemplateMasters(
			start, end);
	}

	/**
	 * Returns the number of email template masters.
	 *
	 * @return the number of email template masters
	 */
	@Override
	public int getEmailTemplateMastersCount() {
		return _emailTemplateMasterLocalService.getEmailTemplateMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _emailTemplateMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emailTemplateMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the email template master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailTemplateMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailTemplateMaster the email template master
	 * @return the email template master that was updated
	 */
	@Override
	public gov.omsb.email.template.master.model.EmailTemplateMaster
		updateEmailTemplateMaster(
			gov.omsb.email.template.master.model.EmailTemplateMaster
				emailTemplateMaster) {

		return _emailTemplateMasterLocalService.updateEmailTemplateMaster(
			emailTemplateMaster);
	}

	@Override
	public EmailTemplateMasterLocalService getWrappedService() {
		return _emailTemplateMasterLocalService;
	}

	@Override
	public void setWrappedService(
		EmailTemplateMasterLocalService emailTemplateMasterLocalService) {

		_emailTemplateMasterLocalService = emailTemplateMasterLocalService;
	}

	private EmailTemplateMasterLocalService _emailTemplateMasterLocalService;

}
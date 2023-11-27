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

package gov.omsb.email.template.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.email.template.master.model.EmailTemplateMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the email template master service. This utility wraps <code>gov.omsb.email.template.master.service.persistence.impl.EmailTemplateMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplateMasterPersistence
 * @generated
 */
public class EmailTemplateMasterUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmailTemplateMaster emailTemplateMaster) {
		getPersistence().clearCache(emailTemplateMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmailTemplateMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmailTemplateMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmailTemplateMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmailTemplateMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmailTemplateMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmailTemplateMaster update(
		EmailTemplateMaster emailTemplateMaster) {

		return getPersistence().update(emailTemplateMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmailTemplateMaster update(
		EmailTemplateMaster emailTemplateMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(emailTemplateMaster, serviceContext);
	}

	/**
	 * Returns the email template master where templateName = &#63; or throws a <code>NoSuchEmailTemplateMasterException</code> if it could not be found.
	 *
	 * @param templateName the template name
	 * @return the matching email template master
	 * @throws NoSuchEmailTemplateMasterException if a matching email template master could not be found
	 */
	public static EmailTemplateMaster findBytemplateName(String templateName)
		throws gov.omsb.email.template.master.exception.
			NoSuchEmailTemplateMasterException {

		return getPersistence().findBytemplateName(templateName);
	}

	/**
	 * Returns the email template master where templateName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateName the template name
	 * @return the matching email template master, or <code>null</code> if a matching email template master could not be found
	 */
	public static EmailTemplateMaster fetchBytemplateName(String templateName) {
		return getPersistence().fetchBytemplateName(templateName);
	}

	/**
	 * Returns the email template master where templateName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateName the template name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email template master, or <code>null</code> if a matching email template master could not be found
	 */
	public static EmailTemplateMaster fetchBytemplateName(
		String templateName, boolean useFinderCache) {

		return getPersistence().fetchBytemplateName(
			templateName, useFinderCache);
	}

	/**
	 * Removes the email template master where templateName = &#63; from the database.
	 *
	 * @param templateName the template name
	 * @return the email template master that was removed
	 */
	public static EmailTemplateMaster removeBytemplateName(String templateName)
		throws gov.omsb.email.template.master.exception.
			NoSuchEmailTemplateMasterException {

		return getPersistence().removeBytemplateName(templateName);
	}

	/**
	 * Returns the number of email template masters where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @return the number of matching email template masters
	 */
	public static int countBytemplateName(String templateName) {
		return getPersistence().countBytemplateName(templateName);
	}

	/**
	 * Caches the email template master in the entity cache if it is enabled.
	 *
	 * @param emailTemplateMaster the email template master
	 */
	public static void cacheResult(EmailTemplateMaster emailTemplateMaster) {
		getPersistence().cacheResult(emailTemplateMaster);
	}

	/**
	 * Caches the email template masters in the entity cache if it is enabled.
	 *
	 * @param emailTemplateMasters the email template masters
	 */
	public static void cacheResult(
		List<EmailTemplateMaster> emailTemplateMasters) {

		getPersistence().cacheResult(emailTemplateMasters);
	}

	/**
	 * Creates a new email template master with the primary key. Does not add the email template master to the database.
	 *
	 * @param templateId the primary key for the new email template master
	 * @return the new email template master
	 */
	public static EmailTemplateMaster create(long templateId) {
		return getPersistence().create(templateId);
	}

	/**
	 * Removes the email template master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master that was removed
	 * @throws NoSuchEmailTemplateMasterException if a email template master with the primary key could not be found
	 */
	public static EmailTemplateMaster remove(long templateId)
		throws gov.omsb.email.template.master.exception.
			NoSuchEmailTemplateMasterException {

		return getPersistence().remove(templateId);
	}

	public static EmailTemplateMaster updateImpl(
		EmailTemplateMaster emailTemplateMaster) {

		return getPersistence().updateImpl(emailTemplateMaster);
	}

	/**
	 * Returns the email template master with the primary key or throws a <code>NoSuchEmailTemplateMasterException</code> if it could not be found.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master
	 * @throws NoSuchEmailTemplateMasterException if a email template master with the primary key could not be found
	 */
	public static EmailTemplateMaster findByPrimaryKey(long templateId)
		throws gov.omsb.email.template.master.exception.
			NoSuchEmailTemplateMasterException {

		return getPersistence().findByPrimaryKey(templateId);
	}

	/**
	 * Returns the email template master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master, or <code>null</code> if a email template master with the primary key could not be found
	 */
	public static EmailTemplateMaster fetchByPrimaryKey(long templateId) {
		return getPersistence().fetchByPrimaryKey(templateId);
	}

	/**
	 * Returns all the email template masters.
	 *
	 * @return the email template masters
	 */
	public static List<EmailTemplateMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the email template masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailTemplateMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email template masters
	 * @param end the upper bound of the range of email template masters (not inclusive)
	 * @return the range of email template masters
	 */
	public static List<EmailTemplateMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the email template masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailTemplateMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email template masters
	 * @param end the upper bound of the range of email template masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of email template masters
	 */
	public static List<EmailTemplateMaster> findAll(
		int start, int end,
		OrderByComparator<EmailTemplateMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the email template masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailTemplateMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email template masters
	 * @param end the upper bound of the range of email template masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of email template masters
	 */
	public static List<EmailTemplateMaster> findAll(
		int start, int end,
		OrderByComparator<EmailTemplateMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the email template masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of email template masters.
	 *
	 * @return the number of email template masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmailTemplateMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EmailTemplateMasterPersistence _persistence;

}
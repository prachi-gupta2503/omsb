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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import gov.omsb.email.template.master.exception.NoSuchEmailTemplateMasterException;
import gov.omsb.email.template.master.model.EmailTemplateMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the email template master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplateMasterUtil
 * @generated
 */
@ProviderType
public interface EmailTemplateMasterPersistence
	extends BasePersistence<EmailTemplateMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailTemplateMasterUtil} to access the email template master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the email template master where templateName = &#63; or throws a <code>NoSuchEmailTemplateMasterException</code> if it could not be found.
	 *
	 * @param templateName the template name
	 * @return the matching email template master
	 * @throws NoSuchEmailTemplateMasterException if a matching email template master could not be found
	 */
	public EmailTemplateMaster findBytemplateName(String templateName)
		throws NoSuchEmailTemplateMasterException;

	/**
	 * Returns the email template master where templateName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateName the template name
	 * @return the matching email template master, or <code>null</code> if a matching email template master could not be found
	 */
	public EmailTemplateMaster fetchBytemplateName(String templateName);

	/**
	 * Returns the email template master where templateName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateName the template name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email template master, or <code>null</code> if a matching email template master could not be found
	 */
	public EmailTemplateMaster fetchBytemplateName(
		String templateName, boolean useFinderCache);

	/**
	 * Removes the email template master where templateName = &#63; from the database.
	 *
	 * @param templateName the template name
	 * @return the email template master that was removed
	 */
	public EmailTemplateMaster removeBytemplateName(String templateName)
		throws NoSuchEmailTemplateMasterException;

	/**
	 * Returns the number of email template masters where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @return the number of matching email template masters
	 */
	public int countBytemplateName(String templateName);

	/**
	 * Caches the email template master in the entity cache if it is enabled.
	 *
	 * @param emailTemplateMaster the email template master
	 */
	public void cacheResult(EmailTemplateMaster emailTemplateMaster);

	/**
	 * Caches the email template masters in the entity cache if it is enabled.
	 *
	 * @param emailTemplateMasters the email template masters
	 */
	public void cacheResult(
		java.util.List<EmailTemplateMaster> emailTemplateMasters);

	/**
	 * Creates a new email template master with the primary key. Does not add the email template master to the database.
	 *
	 * @param templateId the primary key for the new email template master
	 * @return the new email template master
	 */
	public EmailTemplateMaster create(long templateId);

	/**
	 * Removes the email template master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master that was removed
	 * @throws NoSuchEmailTemplateMasterException if a email template master with the primary key could not be found
	 */
	public EmailTemplateMaster remove(long templateId)
		throws NoSuchEmailTemplateMasterException;

	public EmailTemplateMaster updateImpl(
		EmailTemplateMaster emailTemplateMaster);

	/**
	 * Returns the email template master with the primary key or throws a <code>NoSuchEmailTemplateMasterException</code> if it could not be found.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master
	 * @throws NoSuchEmailTemplateMasterException if a email template master with the primary key could not be found
	 */
	public EmailTemplateMaster findByPrimaryKey(long templateId)
		throws NoSuchEmailTemplateMasterException;

	/**
	 * Returns the email template master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master, or <code>null</code> if a email template master with the primary key could not be found
	 */
	public EmailTemplateMaster fetchByPrimaryKey(long templateId);

	/**
	 * Returns all the email template masters.
	 *
	 * @return the email template masters
	 */
	public java.util.List<EmailTemplateMaster> findAll();

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
	public java.util.List<EmailTemplateMaster> findAll(int start, int end);

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
	public java.util.List<EmailTemplateMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailTemplateMaster>
			orderByComparator);

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
	public java.util.List<EmailTemplateMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailTemplateMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the email template masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of email template masters.
	 *
	 * @return the number of email template masters
	 */
	public int countAll();

}
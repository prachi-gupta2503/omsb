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

package gov.omsb.email.template.master.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import gov.omsb.email.template.master.exception.NoSuchEmailTemplateMasterException;
import gov.omsb.email.template.master.model.EmailTemplateMaster;
import gov.omsb.email.template.master.model.EmailTemplateMasterTable;
import gov.omsb.email.template.master.model.impl.EmailTemplateMasterImpl;
import gov.omsb.email.template.master.model.impl.EmailTemplateMasterModelImpl;
import gov.omsb.email.template.master.service.persistence.EmailTemplateMasterPersistence;
import gov.omsb.email.template.master.service.persistence.EmailTemplateMasterUtil;
import gov.omsb.email.template.master.service.persistence.impl.constants.omsb_masterPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the email template master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmailTemplateMasterPersistence.class)
public class EmailTemplateMasterPersistenceImpl
	extends BasePersistenceImpl<EmailTemplateMaster>
	implements EmailTemplateMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmailTemplateMasterUtil</code> to access the email template master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmailTemplateMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBytemplateName;
	private FinderPath _finderPathCountBytemplateName;

	/**
	 * Returns the email template master where templateName = &#63; or throws a <code>NoSuchEmailTemplateMasterException</code> if it could not be found.
	 *
	 * @param templateName the template name
	 * @return the matching email template master
	 * @throws NoSuchEmailTemplateMasterException if a matching email template master could not be found
	 */
	@Override
	public EmailTemplateMaster findBytemplateName(String templateName)
		throws NoSuchEmailTemplateMasterException {

		EmailTemplateMaster emailTemplateMaster = fetchBytemplateName(
			templateName);

		if (emailTemplateMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("templateName=");
			sb.append(templateName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmailTemplateMasterException(sb.toString());
		}

		return emailTemplateMaster;
	}

	/**
	 * Returns the email template master where templateName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateName the template name
	 * @return the matching email template master, or <code>null</code> if a matching email template master could not be found
	 */
	@Override
	public EmailTemplateMaster fetchBytemplateName(String templateName) {
		return fetchBytemplateName(templateName, true);
	}

	/**
	 * Returns the email template master where templateName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateName the template name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email template master, or <code>null</code> if a matching email template master could not be found
	 */
	@Override
	public EmailTemplateMaster fetchBytemplateName(
		String templateName, boolean useFinderCache) {

		templateName = Objects.toString(templateName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {templateName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBytemplateName, finderArgs, this);
		}

		if (result instanceof EmailTemplateMaster) {
			EmailTemplateMaster emailTemplateMaster =
				(EmailTemplateMaster)result;

			if (!Objects.equals(
					templateName, emailTemplateMaster.getTemplateName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMAILTEMPLATEMASTER_WHERE);

			boolean bindTemplateName = false;

			if (templateName.isEmpty()) {
				sb.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				sb.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTemplateName) {
					queryPos.add(templateName);
				}

				List<EmailTemplateMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBytemplateName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {templateName};
							}

							_log.warn(
								"EmailTemplateMasterPersistenceImpl.fetchBytemplateName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmailTemplateMaster emailTemplateMaster = list.get(0);

					result = emailTemplateMaster;

					cacheResult(emailTemplateMaster);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmailTemplateMaster)result;
		}
	}

	/**
	 * Removes the email template master where templateName = &#63; from the database.
	 *
	 * @param templateName the template name
	 * @return the email template master that was removed
	 */
	@Override
	public EmailTemplateMaster removeBytemplateName(String templateName)
		throws NoSuchEmailTemplateMasterException {

		EmailTemplateMaster emailTemplateMaster = findBytemplateName(
			templateName);

		return remove(emailTemplateMaster);
	}

	/**
	 * Returns the number of email template masters where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @return the number of matching email template masters
	 */
	@Override
	public int countBytemplateName(String templateName) {
		templateName = Objects.toString(templateName, "");

		FinderPath finderPath = _finderPathCountBytemplateName;

		Object[] finderArgs = new Object[] {templateName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMAILTEMPLATEMASTER_WHERE);

			boolean bindTemplateName = false;

			if (templateName.isEmpty()) {
				sb.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				sb.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTemplateName) {
					queryPos.add(templateName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2 =
		"emailTemplateMaster.templateName = ?";

	private static final String _FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3 =
		"(emailTemplateMaster.templateName IS NULL OR emailTemplateMaster.templateName = '')";

	public EmailTemplateMasterPersistenceImpl() {
		setModelClass(EmailTemplateMaster.class);

		setModelImplClass(EmailTemplateMasterImpl.class);
		setModelPKClass(long.class);

		setTable(EmailTemplateMasterTable.INSTANCE);
	}

	/**
	 * Caches the email template master in the entity cache if it is enabled.
	 *
	 * @param emailTemplateMaster the email template master
	 */
	@Override
	public void cacheResult(EmailTemplateMaster emailTemplateMaster) {
		entityCache.putResult(
			EmailTemplateMasterImpl.class, emailTemplateMaster.getPrimaryKey(),
			emailTemplateMaster);

		finderCache.putResult(
			_finderPathFetchBytemplateName,
			new Object[] {emailTemplateMaster.getTemplateName()},
			emailTemplateMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the email template masters in the entity cache if it is enabled.
	 *
	 * @param emailTemplateMasters the email template masters
	 */
	@Override
	public void cacheResult(List<EmailTemplateMaster> emailTemplateMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (emailTemplateMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmailTemplateMaster emailTemplateMaster : emailTemplateMasters) {
			if (entityCache.getResult(
					EmailTemplateMasterImpl.class,
					emailTemplateMaster.getPrimaryKey()) == null) {

				cacheResult(emailTemplateMaster);
			}
		}
	}

	/**
	 * Clears the cache for all email template masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmailTemplateMasterImpl.class);

		finderCache.clearCache(EmailTemplateMasterImpl.class);
	}

	/**
	 * Clears the cache for the email template master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmailTemplateMaster emailTemplateMaster) {
		entityCache.removeResult(
			EmailTemplateMasterImpl.class, emailTemplateMaster);
	}

	@Override
	public void clearCache(List<EmailTemplateMaster> emailTemplateMasters) {
		for (EmailTemplateMaster emailTemplateMaster : emailTemplateMasters) {
			entityCache.removeResult(
				EmailTemplateMasterImpl.class, emailTemplateMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmailTemplateMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmailTemplateMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmailTemplateMasterModelImpl emailTemplateMasterModelImpl) {

		Object[] args = new Object[] {
			emailTemplateMasterModelImpl.getTemplateName()
		};

		finderCache.putResult(
			_finderPathCountBytemplateName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBytemplateName, args, emailTemplateMasterModelImpl);
	}

	/**
	 * Creates a new email template master with the primary key. Does not add the email template master to the database.
	 *
	 * @param templateId the primary key for the new email template master
	 * @return the new email template master
	 */
	@Override
	public EmailTemplateMaster create(long templateId) {
		EmailTemplateMaster emailTemplateMaster = new EmailTemplateMasterImpl();

		emailTemplateMaster.setNew(true);
		emailTemplateMaster.setPrimaryKey(templateId);

		emailTemplateMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return emailTemplateMaster;
	}

	/**
	 * Removes the email template master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master that was removed
	 * @throws NoSuchEmailTemplateMasterException if a email template master with the primary key could not be found
	 */
	@Override
	public EmailTemplateMaster remove(long templateId)
		throws NoSuchEmailTemplateMasterException {

		return remove((Serializable)templateId);
	}

	/**
	 * Removes the email template master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email template master
	 * @return the email template master that was removed
	 * @throws NoSuchEmailTemplateMasterException if a email template master with the primary key could not be found
	 */
	@Override
	public EmailTemplateMaster remove(Serializable primaryKey)
		throws NoSuchEmailTemplateMasterException {

		Session session = null;

		try {
			session = openSession();

			EmailTemplateMaster emailTemplateMaster =
				(EmailTemplateMaster)session.get(
					EmailTemplateMasterImpl.class, primaryKey);

			if (emailTemplateMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailTemplateMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(emailTemplateMaster);
		}
		catch (NoSuchEmailTemplateMasterException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmailTemplateMaster removeImpl(
		EmailTemplateMaster emailTemplateMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emailTemplateMaster)) {
				emailTemplateMaster = (EmailTemplateMaster)session.get(
					EmailTemplateMasterImpl.class,
					emailTemplateMaster.getPrimaryKeyObj());
			}

			if (emailTemplateMaster != null) {
				session.delete(emailTemplateMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (emailTemplateMaster != null) {
			clearCache(emailTemplateMaster);
		}

		return emailTemplateMaster;
	}

	@Override
	public EmailTemplateMaster updateImpl(
		EmailTemplateMaster emailTemplateMaster) {

		boolean isNew = emailTemplateMaster.isNew();

		if (!(emailTemplateMaster instanceof EmailTemplateMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(emailTemplateMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					emailTemplateMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in emailTemplateMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmailTemplateMaster implementation " +
					emailTemplateMaster.getClass());
		}

		EmailTemplateMasterModelImpl emailTemplateMasterModelImpl =
			(EmailTemplateMasterModelImpl)emailTemplateMaster;

		if (!emailTemplateMasterModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				emailTemplateMaster.setModifiedDate(date);
			}
			else {
				emailTemplateMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(emailTemplateMaster);
			}
			else {
				emailTemplateMaster = (EmailTemplateMaster)session.merge(
					emailTemplateMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmailTemplateMasterImpl.class, emailTemplateMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(emailTemplateMasterModelImpl);

		if (isNew) {
			emailTemplateMaster.setNew(false);
		}

		emailTemplateMaster.resetOriginalValues();

		return emailTemplateMaster;
	}

	/**
	 * Returns the email template master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email template master
	 * @return the email template master
	 * @throws NoSuchEmailTemplateMasterException if a email template master with the primary key could not be found
	 */
	@Override
	public EmailTemplateMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailTemplateMasterException {

		EmailTemplateMaster emailTemplateMaster = fetchByPrimaryKey(primaryKey);

		if (emailTemplateMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailTemplateMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return emailTemplateMaster;
	}

	/**
	 * Returns the email template master with the primary key or throws a <code>NoSuchEmailTemplateMasterException</code> if it could not be found.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master
	 * @throws NoSuchEmailTemplateMasterException if a email template master with the primary key could not be found
	 */
	@Override
	public EmailTemplateMaster findByPrimaryKey(long templateId)
		throws NoSuchEmailTemplateMasterException {

		return findByPrimaryKey((Serializable)templateId);
	}

	/**
	 * Returns the email template master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateId the primary key of the email template master
	 * @return the email template master, or <code>null</code> if a email template master with the primary key could not be found
	 */
	@Override
	public EmailTemplateMaster fetchByPrimaryKey(long templateId) {
		return fetchByPrimaryKey((Serializable)templateId);
	}

	/**
	 * Returns all the email template masters.
	 *
	 * @return the email template masters
	 */
	@Override
	public List<EmailTemplateMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmailTemplateMaster> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<EmailTemplateMaster> findAll(
		int start, int end,
		OrderByComparator<EmailTemplateMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<EmailTemplateMaster> findAll(
		int start, int end,
		OrderByComparator<EmailTemplateMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<EmailTemplateMaster> list = null;

		if (useFinderCache) {
			list = (List<EmailTemplateMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMAILTEMPLATEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILTEMPLATEMASTER;

				sql = sql.concat(EmailTemplateMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmailTemplateMaster>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the email template masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmailTemplateMaster emailTemplateMaster : findAll()) {
			remove(emailTemplateMaster);
		}
	}

	/**
	 * Returns the number of email template masters.
	 *
	 * @return the number of email template masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_EMAILTEMPLATEMASTER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "templateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMAILTEMPLATEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmailTemplateMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email template master persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchBytemplateName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBytemplateName",
			new String[] {String.class.getName()},
			new String[] {"templateName"}, true);

		_finderPathCountBytemplateName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytemplateName",
			new String[] {String.class.getName()},
			new String[] {"templateName"}, false);

		_setEmailTemplateMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEmailTemplateMasterUtilPersistence(null);

		entityCache.removeCache(EmailTemplateMasterImpl.class.getName());
	}

	private void _setEmailTemplateMasterUtilPersistence(
		EmailTemplateMasterPersistence emailTemplateMasterPersistence) {

		try {
			Field field = EmailTemplateMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, emailTemplateMasterPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = omsb_masterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = omsb_masterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = omsb_masterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMAILTEMPLATEMASTER =
		"SELECT emailTemplateMaster FROM EmailTemplateMaster emailTemplateMaster";

	private static final String _SQL_SELECT_EMAILTEMPLATEMASTER_WHERE =
		"SELECT emailTemplateMaster FROM EmailTemplateMaster emailTemplateMaster WHERE ";

	private static final String _SQL_COUNT_EMAILTEMPLATEMASTER =
		"SELECT COUNT(emailTemplateMaster) FROM EmailTemplateMaster emailTemplateMaster";

	private static final String _SQL_COUNT_EMAILTEMPLATEMASTER_WHERE =
		"SELECT COUNT(emailTemplateMaster) FROM EmailTemplateMaster emailTemplateMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "emailTemplateMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmailTemplateMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmailTemplateMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmailTemplateMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}
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

package gov.omsb.tms.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import gov.omsb.tms.exception.NoSuchFacultyTypeException;
import gov.omsb.tms.model.FacultyType;
import gov.omsb.tms.model.FacultyTypeTable;
import gov.omsb.tms.model.impl.FacultyTypeImpl;
import gov.omsb.tms.model.impl.FacultyTypeModelImpl;
import gov.omsb.tms.service.persistence.FacultyTypePersistence;
import gov.omsb.tms.service.persistence.FacultyTypeUtil;
import gov.omsb.tms.service.persistence.impl.constants.OMSBTMSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the faculty type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacultyTypePersistence.class)
public class FacultyTypePersistenceImpl
	extends BasePersistenceImpl<FacultyType> implements FacultyTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacultyTypeUtil</code> to access the faculty type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacultyTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the faculty type where code = &#63; or throws a <code>NoSuchFacultyTypeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching faculty type
	 * @throws NoSuchFacultyTypeException if a matching faculty type could not be found
	 */
	@Override
	public FacultyType findByCode(String code)
		throws NoSuchFacultyTypeException {

		FacultyType facultyType = fetchByCode(code);

		if (facultyType == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFacultyTypeException(sb.toString());
		}

		return facultyType;
	}

	/**
	 * Returns the faculty type where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching faculty type, or <code>null</code> if a matching faculty type could not be found
	 */
	@Override
	public FacultyType fetchByCode(String code) {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the faculty type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty type, or <code>null</code> if a matching faculty type could not be found
	 */
	@Override
	public FacultyType fetchByCode(String code, boolean useFinderCache) {
		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCode, finderArgs, this);
		}

		if (result instanceof FacultyType) {
			FacultyType facultyType = (FacultyType)result;

			if (!Objects.equals(code, facultyType.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FACULTYTYPE_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(StringUtil.toLowerCase(code));
				}

				List<FacultyType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {code};
							}

							_log.warn(
								"FacultyTypePersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FacultyType facultyType = list.get(0);

					result = facultyType;

					cacheResult(facultyType);
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
			return (FacultyType)result;
		}
	}

	/**
	 * Removes the faculty type where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the faculty type that was removed
	 */
	@Override
	public FacultyType removeByCode(String code)
		throws NoSuchFacultyTypeException {

		FacultyType facultyType = findByCode(code);

		return remove(facultyType);
	}

	/**
	 * Returns the number of faculty types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching faculty types
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYTYPE_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(StringUtil.toLowerCase(code));
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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"lower(facultyType.code) = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(facultyType.code IS NULL OR facultyType.code = '')";

	public FacultyTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("facultyTypeId", "faculty_type_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("nameEn", "name_en");
		dbColumnNames.put("nameAr", "name_ar");

		setDBColumnNames(dbColumnNames);

		setModelClass(FacultyType.class);

		setModelImplClass(FacultyTypeImpl.class);
		setModelPKClass(long.class);

		setTable(FacultyTypeTable.INSTANCE);
	}

	/**
	 * Caches the faculty type in the entity cache if it is enabled.
	 *
	 * @param facultyType the faculty type
	 */
	@Override
	public void cacheResult(FacultyType facultyType) {
		entityCache.putResult(
			FacultyTypeImpl.class, facultyType.getPrimaryKey(), facultyType);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {facultyType.getCode()},
			facultyType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the faculty types in the entity cache if it is enabled.
	 *
	 * @param facultyTypes the faculty types
	 */
	@Override
	public void cacheResult(List<FacultyType> facultyTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (facultyTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FacultyType facultyType : facultyTypes) {
			if (entityCache.getResult(
					FacultyTypeImpl.class, facultyType.getPrimaryKey()) ==
						null) {

				cacheResult(facultyType);
			}
		}
	}

	/**
	 * Clears the cache for all faculty types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacultyTypeImpl.class);

		finderCache.clearCache(FacultyTypeImpl.class);
	}

	/**
	 * Clears the cache for the faculty type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacultyType facultyType) {
		entityCache.removeResult(FacultyTypeImpl.class, facultyType);
	}

	@Override
	public void clearCache(List<FacultyType> facultyTypes) {
		for (FacultyType facultyType : facultyTypes) {
			entityCache.removeResult(FacultyTypeImpl.class, facultyType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FacultyTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FacultyTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FacultyTypeModelImpl facultyTypeModelImpl) {

		Object[] args = new Object[] {facultyTypeModelImpl.getCode()};

		finderCache.putResult(_finderPathCountByCode, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCode, args, facultyTypeModelImpl);
	}

	/**
	 * Creates a new faculty type with the primary key. Does not add the faculty type to the database.
	 *
	 * @param facultyTypeId the primary key for the new faculty type
	 * @return the new faculty type
	 */
	@Override
	public FacultyType create(long facultyTypeId) {
		FacultyType facultyType = new FacultyTypeImpl();

		facultyType.setNew(true);
		facultyType.setPrimaryKey(facultyTypeId);

		facultyType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return facultyType;
	}

	/**
	 * Removes the faculty type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type that was removed
	 * @throws NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 */
	@Override
	public FacultyType remove(long facultyTypeId)
		throws NoSuchFacultyTypeException {

		return remove((Serializable)facultyTypeId);
	}

	/**
	 * Removes the faculty type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty type
	 * @return the faculty type that was removed
	 * @throws NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 */
	@Override
	public FacultyType remove(Serializable primaryKey)
		throws NoSuchFacultyTypeException {

		Session session = null;

		try {
			session = openSession();

			FacultyType facultyType = (FacultyType)session.get(
				FacultyTypeImpl.class, primaryKey);

			if (facultyType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facultyType);
		}
		catch (NoSuchFacultyTypeException noSuchEntityException) {
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
	protected FacultyType removeImpl(FacultyType facultyType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facultyType)) {
				facultyType = (FacultyType)session.get(
					FacultyTypeImpl.class, facultyType.getPrimaryKeyObj());
			}

			if (facultyType != null) {
				session.delete(facultyType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facultyType != null) {
			clearCache(facultyType);
		}

		return facultyType;
	}

	@Override
	public FacultyType updateImpl(FacultyType facultyType) {
		boolean isNew = facultyType.isNew();

		if (!(facultyType instanceof FacultyTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(facultyType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(facultyType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facultyType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FacultyType implementation " +
					facultyType.getClass());
		}

		FacultyTypeModelImpl facultyTypeModelImpl =
			(FacultyTypeModelImpl)facultyType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (facultyType.getCreateDate() == null)) {
			if (serviceContext == null) {
				facultyType.setCreateDate(date);
			}
			else {
				facultyType.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!facultyTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facultyType.setModifiedDate(date);
			}
			else {
				facultyType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(facultyType);
			}
			else {
				facultyType = (FacultyType)session.merge(facultyType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FacultyTypeImpl.class, facultyTypeModelImpl, false, true);

		cacheUniqueFindersCache(facultyTypeModelImpl);

		if (isNew) {
			facultyType.setNew(false);
		}

		facultyType.resetOriginalValues();

		return facultyType;
	}

	/**
	 * Returns the faculty type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty type
	 * @return the faculty type
	 * @throws NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 */
	@Override
	public FacultyType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacultyTypeException {

		FacultyType facultyType = fetchByPrimaryKey(primaryKey);

		if (facultyType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facultyType;
	}

	/**
	 * Returns the faculty type with the primary key or throws a <code>NoSuchFacultyTypeException</code> if it could not be found.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type
	 * @throws NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 */
	@Override
	public FacultyType findByPrimaryKey(long facultyTypeId)
		throws NoSuchFacultyTypeException {

		return findByPrimaryKey((Serializable)facultyTypeId);
	}

	/**
	 * Returns the faculty type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type, or <code>null</code> if a faculty type with the primary key could not be found
	 */
	@Override
	public FacultyType fetchByPrimaryKey(long facultyTypeId) {
		return fetchByPrimaryKey((Serializable)facultyTypeId);
	}

	/**
	 * Returns all the faculty types.
	 *
	 * @return the faculty types
	 */
	@Override
	public List<FacultyType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @return the range of faculty types
	 */
	@Override
	public List<FacultyType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty types
	 */
	@Override
	public List<FacultyType> findAll(
		int start, int end, OrderByComparator<FacultyType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty types
	 */
	@Override
	public List<FacultyType> findAll(
		int start, int end, OrderByComparator<FacultyType> orderByComparator,
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

		List<FacultyType> list = null;

		if (useFinderCache) {
			list = (List<FacultyType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FACULTYTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTYTYPE;

				sql = sql.concat(FacultyTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FacultyType>)QueryUtil.list(
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
	 * Removes all the faculty types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FacultyType facultyType : findAll()) {
			remove(facultyType);
		}
	}

	/**
	 * Returns the number of faculty types.
	 *
	 * @return the number of faculty types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FACULTYTYPE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "faculty_type_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACULTYTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacultyTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faculty type persistence.
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

		_finderPathFetchByCode = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()}, new String[] {"code"}, true);

		_finderPathCountByCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()}, new String[] {"code"},
			false);

		_setFacultyTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFacultyTypeUtilPersistence(null);

		entityCache.removeCache(FacultyTypeImpl.class.getName());
	}

	private void _setFacultyTypeUtilPersistence(
		FacultyTypePersistence facultyTypePersistence) {

		try {
			Field field = FacultyTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, facultyTypePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = OMSBTMSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = OMSBTMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OMSBTMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FACULTYTYPE =
		"SELECT facultyType FROM FacultyType facultyType";

	private static final String _SQL_SELECT_FACULTYTYPE_WHERE =
		"SELECT facultyType FROM FacultyType facultyType WHERE ";

	private static final String _SQL_COUNT_FACULTYTYPE =
		"SELECT COUNT(facultyType) FROM FacultyType facultyType";

	private static final String _SQL_COUNT_FACULTYTYPE_WHERE =
		"SELECT COUNT(facultyType) FROM FacultyType facultyType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "facultyType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FacultyType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FacultyType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FacultyTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"facultyTypeId", "groupId", "companyId", "createDate",
			"modifiedDate", "nameEn", "nameAr"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}
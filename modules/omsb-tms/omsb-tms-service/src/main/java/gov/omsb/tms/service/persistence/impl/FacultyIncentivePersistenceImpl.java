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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import gov.omsb.tms.exception.NoSuchFacultyIncentiveException;
import gov.omsb.tms.model.FacultyIncentive;
import gov.omsb.tms.model.FacultyIncentiveTable;
import gov.omsb.tms.model.impl.FacultyIncentiveImpl;
import gov.omsb.tms.model.impl.FacultyIncentiveModelImpl;
import gov.omsb.tms.service.persistence.FacultyIncentivePersistence;
import gov.omsb.tms.service.persistence.FacultyIncentiveUtil;
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
 * The persistence implementation for the faculty incentive service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacultyIncentivePersistence.class)
public class FacultyIncentivePersistenceImpl
	extends BasePersistenceImpl<FacultyIncentive>
	implements FacultyIncentivePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacultyIncentiveUtil</code> to access the faculty incentive persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacultyIncentiveImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the faculty incentives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty incentives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @return the range of matching faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty incentives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyIncentive> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty incentives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyIncentive> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<FacultyIncentive> list = null;

		if (useFinderCache) {
			list = (List<FacultyIncentive>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyIncentive facultyIncentive : list) {
					if (!uuid.equals(facultyIncentive.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FACULTYINCENTIVE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FacultyIncentiveModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<FacultyIncentive>)QueryUtil.list(
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
	 * Returns the first faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive findByUuid_First(
			String uuid, OrderByComparator<FacultyIncentive> orderByComparator)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = fetchByUuid_First(
			uuid, orderByComparator);

		if (facultyIncentive != null) {
			return facultyIncentive;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyIncentiveException(sb.toString());
	}

	/**
	 * Returns the first faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive fetchByUuid_First(
		String uuid, OrderByComparator<FacultyIncentive> orderByComparator) {

		List<FacultyIncentive> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive findByUuid_Last(
			String uuid, OrderByComparator<FacultyIncentive> orderByComparator)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = fetchByUuid_Last(
			uuid, orderByComparator);

		if (facultyIncentive != null) {
			return facultyIncentive;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyIncentiveException(sb.toString());
	}

	/**
	 * Returns the last faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive fetchByUuid_Last(
		String uuid, OrderByComparator<FacultyIncentive> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FacultyIncentive> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty incentives before and after the current faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param FacultyIncentiveId the primary key of the current faculty incentive
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	@Override
	public FacultyIncentive[] findByUuid_PrevAndNext(
			long FacultyIncentiveId, String uuid,
			OrderByComparator<FacultyIncentive> orderByComparator)
		throws NoSuchFacultyIncentiveException {

		uuid = Objects.toString(uuid, "");

		FacultyIncentive facultyIncentive = findByPrimaryKey(
			FacultyIncentiveId);

		Session session = null;

		try {
			session = openSession();

			FacultyIncentive[] array = new FacultyIncentiveImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, facultyIncentive, uuid, orderByComparator, true);

			array[1] = facultyIncentive;

			array[2] = getByUuid_PrevAndNext(
				session, facultyIncentive, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FacultyIncentive getByUuid_PrevAndNext(
		Session session, FacultyIncentive facultyIncentive, String uuid,
		OrderByComparator<FacultyIncentive> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FACULTYINCENTIVE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FacultyIncentiveModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						facultyIncentive)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyIncentive> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty incentives where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FacultyIncentive facultyIncentive :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(facultyIncentive);
		}
	}

	/**
	 * Returns the number of faculty incentives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty incentives
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYINCENTIVE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"facultyIncentive.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(facultyIncentive.uuid IS NULL OR facultyIncentive.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the faculty incentive where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyIncentiveException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = fetchByUUID_G(uuid, groupId);

		if (facultyIncentive == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFacultyIncentiveException(sb.toString());
		}

		return facultyIncentive;
	}

	/**
	 * Returns the faculty incentive where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the faculty incentive where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof FacultyIncentive) {
			FacultyIncentive facultyIncentive = (FacultyIncentive)result;

			if (!Objects.equals(uuid, facultyIncentive.getUuid()) ||
				(groupId != facultyIncentive.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FACULTYINCENTIVE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<FacultyIncentive> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FacultyIncentive facultyIncentive = list.get(0);

					result = facultyIncentive;

					cacheResult(facultyIncentive);
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
			return (FacultyIncentive)result;
		}
	}

	/**
	 * Removes the faculty incentive where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty incentive that was removed
	 */
	@Override
	public FacultyIncentive removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = findByUUID_G(uuid, groupId);

		return remove(facultyIncentive);
	}

	/**
	 * Returns the number of faculty incentives where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty incentives
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYINCENTIVE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"facultyIncentive.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(facultyIncentive.uuid IS NULL OR facultyIncentive.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"facultyIncentive.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @return the range of matching faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyIncentive> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyIncentive> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<FacultyIncentive> list = null;

		if (useFinderCache) {
			list = (List<FacultyIncentive>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyIncentive facultyIncentive : list) {
					if (!uuid.equals(facultyIncentive.getUuid()) ||
						(companyId != facultyIncentive.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FACULTYINCENTIVE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FacultyIncentiveModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<FacultyIncentive>)QueryUtil.list(
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
	 * Returns the first faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyIncentive> orderByComparator)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (facultyIncentive != null) {
			return facultyIncentive;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyIncentiveException(sb.toString());
	}

	/**
	 * Returns the first faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyIncentive> orderByComparator) {

		List<FacultyIncentive> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyIncentive> orderByComparator)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (facultyIncentive != null) {
			return facultyIncentive;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyIncentiveException(sb.toString());
	}

	/**
	 * Returns the last faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyIncentive> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FacultyIncentive> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty incentives before and after the current faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param FacultyIncentiveId the primary key of the current faculty incentive
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	@Override
	public FacultyIncentive[] findByUuid_C_PrevAndNext(
			long FacultyIncentiveId, String uuid, long companyId,
			OrderByComparator<FacultyIncentive> orderByComparator)
		throws NoSuchFacultyIncentiveException {

		uuid = Objects.toString(uuid, "");

		FacultyIncentive facultyIncentive = findByPrimaryKey(
			FacultyIncentiveId);

		Session session = null;

		try {
			session = openSession();

			FacultyIncentive[] array = new FacultyIncentiveImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, facultyIncentive, uuid, companyId, orderByComparator,
				true);

			array[1] = facultyIncentive;

			array[2] = getByUuid_C_PrevAndNext(
				session, facultyIncentive, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FacultyIncentive getByUuid_C_PrevAndNext(
		Session session, FacultyIncentive facultyIncentive, String uuid,
		long companyId, OrderByComparator<FacultyIncentive> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FACULTYINCENTIVE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FacultyIncentiveModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						facultyIncentive)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyIncentive> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty incentives where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FacultyIncentive facultyIncentive :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(facultyIncentive);
		}
	}

	/**
	 * Returns the number of faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty incentives
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYINCENTIVE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"facultyIncentive.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(facultyIncentive.uuid IS NULL OR facultyIncentive.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"facultyIncentive.companyId = ?";

	private FinderPath _finderPathFetchByRoleId;
	private FinderPath _finderPathCountByRoleId;

	/**
	 * Returns the faculty incentive where roleId = &#63; or throws a <code>NoSuchFacultyIncentiveException</code> if it could not be found.
	 *
	 * @param roleId the role ID
	 * @return the matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive findByRoleId(long roleId)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = fetchByRoleId(roleId);

		if (facultyIncentive == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("roleId=");
			sb.append(roleId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFacultyIncentiveException(sb.toString());
		}

		return facultyIncentive;
	}

	/**
	 * Returns the faculty incentive where roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleId the role ID
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive fetchByRoleId(long roleId) {
		return fetchByRoleId(roleId, true);
	}

	/**
	 * Returns the faculty incentive where roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public FacultyIncentive fetchByRoleId(long roleId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {roleId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRoleId, finderArgs, this);
		}

		if (result instanceof FacultyIncentive) {
			FacultyIncentive facultyIncentive = (FacultyIncentive)result;

			if (roleId != facultyIncentive.getRoleId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FACULTYINCENTIVE_WHERE);

			sb.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(roleId);

				List<FacultyIncentive> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRoleId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {roleId};
							}

							_log.warn(
								"FacultyIncentivePersistenceImpl.fetchByRoleId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FacultyIncentive facultyIncentive = list.get(0);

					result = facultyIncentive;

					cacheResult(facultyIncentive);
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
			return (FacultyIncentive)result;
		}
	}

	/**
	 * Removes the faculty incentive where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @return the faculty incentive that was removed
	 */
	@Override
	public FacultyIncentive removeByRoleId(long roleId)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = findByRoleId(roleId);

		return remove(facultyIncentive);
	}

	/**
	 * Returns the number of faculty incentives where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching faculty incentives
	 */
	@Override
	public int countByRoleId(long roleId) {
		FinderPath finderPath = _finderPathCountByRoleId;

		Object[] finderArgs = new Object[] {roleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYINCENTIVE_WHERE);

			sb.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(roleId);

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

	private static final String _FINDER_COLUMN_ROLEID_ROLEID_2 =
		"facultyIncentive.roleId = ?";

	public FacultyIncentivePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("FacultyIncentiveId", "faculty_incentive_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("roleId", "role_id");
		dbColumnNames.put("amountInOMR", "amount_in_omr");
		dbColumnNames.put("applicableForm", "applicable_form");

		setDBColumnNames(dbColumnNames);

		setModelClass(FacultyIncentive.class);

		setModelImplClass(FacultyIncentiveImpl.class);
		setModelPKClass(long.class);

		setTable(FacultyIncentiveTable.INSTANCE);
	}

	/**
	 * Caches the faculty incentive in the entity cache if it is enabled.
	 *
	 * @param facultyIncentive the faculty incentive
	 */
	@Override
	public void cacheResult(FacultyIncentive facultyIncentive) {
		entityCache.putResult(
			FacultyIncentiveImpl.class, facultyIncentive.getPrimaryKey(),
			facultyIncentive);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				facultyIncentive.getUuid(), facultyIncentive.getGroupId()
			},
			facultyIncentive);

		finderCache.putResult(
			_finderPathFetchByRoleId,
			new Object[] {facultyIncentive.getRoleId()}, facultyIncentive);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the faculty incentives in the entity cache if it is enabled.
	 *
	 * @param facultyIncentives the faculty incentives
	 */
	@Override
	public void cacheResult(List<FacultyIncentive> facultyIncentives) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (facultyIncentives.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FacultyIncentive facultyIncentive : facultyIncentives) {
			if (entityCache.getResult(
					FacultyIncentiveImpl.class,
					facultyIncentive.getPrimaryKey()) == null) {

				cacheResult(facultyIncentive);
			}
		}
	}

	/**
	 * Clears the cache for all faculty incentives.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacultyIncentiveImpl.class);

		finderCache.clearCache(FacultyIncentiveImpl.class);
	}

	/**
	 * Clears the cache for the faculty incentive.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacultyIncentive facultyIncentive) {
		entityCache.removeResult(FacultyIncentiveImpl.class, facultyIncentive);
	}

	@Override
	public void clearCache(List<FacultyIncentive> facultyIncentives) {
		for (FacultyIncentive facultyIncentive : facultyIncentives) {
			entityCache.removeResult(
				FacultyIncentiveImpl.class, facultyIncentive);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FacultyIncentiveImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FacultyIncentiveImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FacultyIncentiveModelImpl facultyIncentiveModelImpl) {

		Object[] args = new Object[] {
			facultyIncentiveModelImpl.getUuid(),
			facultyIncentiveModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, facultyIncentiveModelImpl);

		args = new Object[] {facultyIncentiveModelImpl.getRoleId()};

		finderCache.putResult(_finderPathCountByRoleId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByRoleId, args, facultyIncentiveModelImpl);
	}

	/**
	 * Creates a new faculty incentive with the primary key. Does not add the faculty incentive to the database.
	 *
	 * @param FacultyIncentiveId the primary key for the new faculty incentive
	 * @return the new faculty incentive
	 */
	@Override
	public FacultyIncentive create(long FacultyIncentiveId) {
		FacultyIncentive facultyIncentive = new FacultyIncentiveImpl();

		facultyIncentive.setNew(true);
		facultyIncentive.setPrimaryKey(FacultyIncentiveId);

		String uuid = _portalUUID.generate();

		facultyIncentive.setUuid(uuid);

		facultyIncentive.setCompanyId(CompanyThreadLocal.getCompanyId());

		return facultyIncentive;
	}

	/**
	 * Removes the faculty incentive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive that was removed
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	@Override
	public FacultyIncentive remove(long FacultyIncentiveId)
		throws NoSuchFacultyIncentiveException {

		return remove((Serializable)FacultyIncentiveId);
	}

	/**
	 * Removes the faculty incentive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty incentive
	 * @return the faculty incentive that was removed
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	@Override
	public FacultyIncentive remove(Serializable primaryKey)
		throws NoSuchFacultyIncentiveException {

		Session session = null;

		try {
			session = openSession();

			FacultyIncentive facultyIncentive = (FacultyIncentive)session.get(
				FacultyIncentiveImpl.class, primaryKey);

			if (facultyIncentive == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyIncentiveException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facultyIncentive);
		}
		catch (NoSuchFacultyIncentiveException noSuchEntityException) {
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
	protected FacultyIncentive removeImpl(FacultyIncentive facultyIncentive) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facultyIncentive)) {
				facultyIncentive = (FacultyIncentive)session.get(
					FacultyIncentiveImpl.class,
					facultyIncentive.getPrimaryKeyObj());
			}

			if (facultyIncentive != null) {
				session.delete(facultyIncentive);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facultyIncentive != null) {
			clearCache(facultyIncentive);
		}

		return facultyIncentive;
	}

	@Override
	public FacultyIncentive updateImpl(FacultyIncentive facultyIncentive) {
		boolean isNew = facultyIncentive.isNew();

		if (!(facultyIncentive instanceof FacultyIncentiveModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(facultyIncentive.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					facultyIncentive);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facultyIncentive proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FacultyIncentive implementation " +
					facultyIncentive.getClass());
		}

		FacultyIncentiveModelImpl facultyIncentiveModelImpl =
			(FacultyIncentiveModelImpl)facultyIncentive;

		if (Validator.isNull(facultyIncentive.getUuid())) {
			String uuid = _portalUUID.generate();

			facultyIncentive.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (facultyIncentive.getCreateDate() == null)) {
			if (serviceContext == null) {
				facultyIncentive.setCreateDate(date);
			}
			else {
				facultyIncentive.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!facultyIncentiveModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facultyIncentive.setModifiedDate(date);
			}
			else {
				facultyIncentive.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(facultyIncentive);
			}
			else {
				facultyIncentive = (FacultyIncentive)session.merge(
					facultyIncentive);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FacultyIncentiveImpl.class, facultyIncentiveModelImpl, false, true);

		cacheUniqueFindersCache(facultyIncentiveModelImpl);

		if (isNew) {
			facultyIncentive.setNew(false);
		}

		facultyIncentive.resetOriginalValues();

		return facultyIncentive;
	}

	/**
	 * Returns the faculty incentive with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty incentive
	 * @return the faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	@Override
	public FacultyIncentive findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacultyIncentiveException {

		FacultyIncentive facultyIncentive = fetchByPrimaryKey(primaryKey);

		if (facultyIncentive == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyIncentiveException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facultyIncentive;
	}

	/**
	 * Returns the faculty incentive with the primary key or throws a <code>NoSuchFacultyIncentiveException</code> if it could not be found.
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	@Override
	public FacultyIncentive findByPrimaryKey(long FacultyIncentiveId)
		throws NoSuchFacultyIncentiveException {

		return findByPrimaryKey((Serializable)FacultyIncentiveId);
	}

	/**
	 * Returns the faculty incentive with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive, or <code>null</code> if a faculty incentive with the primary key could not be found
	 */
	@Override
	public FacultyIncentive fetchByPrimaryKey(long FacultyIncentiveId) {
		return fetchByPrimaryKey((Serializable)FacultyIncentiveId);
	}

	/**
	 * Returns all the faculty incentives.
	 *
	 * @return the faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty incentives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @return the range of faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty incentives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findAll(
		int start, int end,
		OrderByComparator<FacultyIncentive> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty incentives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty incentives
	 */
	@Override
	public List<FacultyIncentive> findAll(
		int start, int end,
		OrderByComparator<FacultyIncentive> orderByComparator,
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

		List<FacultyIncentive> list = null;

		if (useFinderCache) {
			list = (List<FacultyIncentive>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FACULTYINCENTIVE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTYINCENTIVE;

				sql = sql.concat(FacultyIncentiveModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FacultyIncentive>)QueryUtil.list(
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
	 * Removes all the faculty incentives from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FacultyIncentive facultyIncentive : findAll()) {
			remove(facultyIncentive);
		}
	}

	/**
	 * Returns the number of faculty incentives.
	 *
	 * @return the number of faculty incentives
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FACULTYINCENTIVE);

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
		return "faculty_incentive_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACULTYINCENTIVE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacultyIncentiveModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faculty incentive persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "group_id"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "group_id"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "company_id"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "company_id"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "company_id"}, false);

		_finderPathFetchByRoleId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRoleId",
			new String[] {Long.class.getName()}, new String[] {"role_id"},
			true);

		_finderPathCountByRoleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleId",
			new String[] {Long.class.getName()}, new String[] {"role_id"},
			false);

		_setFacultyIncentiveUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFacultyIncentiveUtilPersistence(null);

		entityCache.removeCache(FacultyIncentiveImpl.class.getName());
	}

	private void _setFacultyIncentiveUtilPersistence(
		FacultyIncentivePersistence facultyIncentivePersistence) {

		try {
			Field field = FacultyIncentiveUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, facultyIncentivePersistence);
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

	private static final String _SQL_SELECT_FACULTYINCENTIVE =
		"SELECT facultyIncentive FROM FacultyIncentive facultyIncentive";

	private static final String _SQL_SELECT_FACULTYINCENTIVE_WHERE =
		"SELECT facultyIncentive FROM FacultyIncentive facultyIncentive WHERE ";

	private static final String _SQL_COUNT_FACULTYINCENTIVE =
		"SELECT COUNT(facultyIncentive) FROM FacultyIncentive facultyIncentive";

	private static final String _SQL_COUNT_FACULTYINCENTIVE_WHERE =
		"SELECT COUNT(facultyIncentive) FROM FacultyIncentive facultyIncentive WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "facultyIncentive.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FacultyIncentive exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FacultyIncentive exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FacultyIncentivePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "FacultyIncentiveId", "groupId", "companyId", "createDate",
			"modifiedDate", "roleId", "amountInOMR", "applicableForm"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchDutyLogException;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.DutyLogTable;
import gov.omsb.tms.model.impl.DutyLogImpl;
import gov.omsb.tms.model.impl.DutyLogModelImpl;
import gov.omsb.tms.service.persistence.DutyLogPersistence;
import gov.omsb.tms.service.persistence.DutyLogUtil;
import gov.omsb.tms.service.persistence.impl.constants.OMSBTMSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

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
 * The persistence implementation for the duty log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DutyLogPersistence.class)
public class DutyLogPersistenceImpl
	extends BasePersistenceImpl<DutyLog> implements DutyLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DutyLogUtil</code> to access the duty log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DutyLogImpl.class.getName();

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
	 * Returns all the duty logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty logs
	 */
	@Override
	public List<DutyLog> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

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

		List<DutyLog> list = null;

		if (useFinderCache) {
			list = (List<DutyLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLog dutyLog : list) {
					if (!uuid.equals(dutyLog.getUuid())) {
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

			sb.append(_SQL_SELECT_DUTYLOG_WHERE);

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
				sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
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

				list = (List<DutyLog>)QueryUtil.list(
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
	 * Returns the first duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByUuid_First(
			String uuid, OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByUuid_First(uuid, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByUuid_First(
		String uuid, OrderByComparator<DutyLog> orderByComparator) {

		List<DutyLog> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByUuid_Last(
			String uuid, OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByUuid_Last(uuid, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByUuid_Last(
		String uuid, OrderByComparator<DutyLog> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DutyLog> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where uuid = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog[] findByUuid_PrevAndNext(
			long dutyLogId, String uuid,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		uuid = Objects.toString(uuid, "");

		DutyLog dutyLog = findByPrimaryKey(dutyLogId);

		Session session = null;

		try {
			session = openSession();

			DutyLog[] array = new DutyLogImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dutyLog, uuid, orderByComparator, true);

			array[1] = dutyLog;

			array[2] = getByUuid_PrevAndNext(
				session, dutyLog, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyLog getByUuid_PrevAndNext(
		Session session, DutyLog dutyLog, String uuid,
		OrderByComparator<DutyLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUTYLOG_WHERE);

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
			sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(dutyLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DutyLog dutyLog :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dutyLog);
		}
	}

	/**
	 * Returns the number of duty logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty logs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYLOG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "dutyLog.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dutyLog.uuid IS NULL OR dutyLog.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByUUID_G(uuid, groupId);

		if (dutyLog == null) {
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

			throw new NoSuchDutyLogException(sb.toString());
		}

		return dutyLog;
	}

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByUUID_G(
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

		if (result instanceof DutyLog) {
			DutyLog dutyLog = (DutyLog)result;

			if (!Objects.equals(uuid, dutyLog.getUuid()) ||
				(groupId != dutyLog.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DUTYLOG_WHERE);

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

				List<DutyLog> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DutyLog dutyLog = list.get(0);

					result = dutyLog;

					cacheResult(dutyLog);
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
			return (DutyLog)result;
		}
	}

	/**
	 * Removes the duty log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty log that was removed
	 */
	@Override
	public DutyLog removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = findByUUID_G(uuid, groupId);

		return remove(dutyLog);
	}

	/**
	 * Returns the number of duty logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty logs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYLOG_WHERE);

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
		"dutyLog.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dutyLog.uuid IS NULL OR dutyLog.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dutyLog.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty logs
	 */
	@Override
	public List<DutyLog> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

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

		List<DutyLog> list = null;

		if (useFinderCache) {
			list = (List<DutyLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLog dutyLog : list) {
					if (!uuid.equals(dutyLog.getUuid()) ||
						(companyId != dutyLog.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DUTYLOG_WHERE);

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
				sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
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

				list = (List<DutyLog>)QueryUtil.list(
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
	 * Returns the first duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyLog> orderByComparator) {

		List<DutyLog> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyLog> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DutyLog> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog[] findByUuid_C_PrevAndNext(
			long dutyLogId, String uuid, long companyId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		uuid = Objects.toString(uuid, "");

		DutyLog dutyLog = findByPrimaryKey(dutyLogId);

		Session session = null;

		try {
			session = openSession();

			DutyLog[] array = new DutyLogImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dutyLog, uuid, companyId, orderByComparator, true);

			array[1] = dutyLog;

			array[2] = getByUuid_C_PrevAndNext(
				session, dutyLog, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyLog getByUuid_C_PrevAndNext(
		Session session, DutyLog dutyLog, String uuid, long companyId,
		OrderByComparator<DutyLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DUTYLOG_WHERE);

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
			sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(dutyLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DutyLog dutyLog :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dutyLog);
		}
	}

	/**
	 * Returns the number of duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty logs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYLOG_WHERE);

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
		"dutyLog.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dutyLog.uuid IS NULL OR dutyLog.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dutyLog.companyId = ?";

	private FinderPath _finderPathFetchByTraineeIdAndStartDate;
	private FinderPath _finderPathCountByTraineeIdAndStartDate;

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByTraineeIdAndStartDate(long traineeId, Date startDate)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByTraineeIdAndStartDate(traineeId, startDate);

		if (dutyLog == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeId=");
			sb.append(traineeId);

			sb.append(", startDate=");
			sb.append(startDate);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDutyLogException(sb.toString());
		}

		return dutyLog;
	}

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByTraineeIdAndStartDate(
		long traineeId, Date startDate) {

		return fetchByTraineeIdAndStartDate(traineeId, startDate, true);
	}

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByTraineeIdAndStartDate(
		long traineeId, Date startDate, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {traineeId, _getTime(startDate)};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTraineeIdAndStartDate, finderArgs, this);
		}

		if (result instanceof DutyLog) {
			DutyLog dutyLog = (DutyLog)result;

			if ((traineeId != dutyLog.getTraineeId()) ||
				!Objects.equals(startDate, dutyLog.getStartDate())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DUTYLOG_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_TRAINEEID_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_STARTDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				List<DutyLog> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTraineeIdAndStartDate, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									traineeId, _getTime(startDate)
								};
							}

							_log.warn(
								"DutyLogPersistenceImpl.fetchByTraineeIdAndStartDate(long, Date, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DutyLog dutyLog = list.get(0);

					result = dutyLog;

					cacheResult(dutyLog);
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
			return (DutyLog)result;
		}
	}

	/**
	 * Removes the duty log where traineeId = &#63; and startDate = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the duty log that was removed
	 */
	@Override
	public DutyLog removeByTraineeIdAndStartDate(long traineeId, Date startDate)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = findByTraineeIdAndStartDate(traineeId, startDate);

		return remove(dutyLog);
	}

	/**
	 * Returns the number of duty logs where traineeId = &#63; and startDate = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the number of matching duty logs
	 */
	@Override
	public int countByTraineeIdAndStartDate(long traineeId, Date startDate) {
		FinderPath finderPath = _finderPathCountByTraineeIdAndStartDate;

		Object[] finderArgs = new Object[] {traineeId, _getTime(startDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYLOG_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_TRAINEEID_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_STARTDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
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

	private static final String
		_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_TRAINEEID_2 =
			"dutyLog.traineeId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_STARTDATE_1 =
			"dutyLog.startDate IS NULL";

	private static final String
		_FINDER_COLUMN_TRAINEEIDANDSTARTDATE_STARTDATE_2 =
			"dutyLog.startDate = ?";

	private FinderPath
		_finderPathWithPaginationFindByTranieeIdAndBlocksMetadataDetailRelId;
	private FinderPath
		_finderPathWithoutPaginationFindByTranieeIdAndBlocksMetadataDetailRelId;
	private FinderPath _finderPathCountByTranieeIdAndBlocksMetadataDetailRelId;

	/**
	 * Returns all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching duty logs
	 */
	@Override
	public List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId) {

		return findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end) {

		return findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTranieeIdAndBlocksMetadataDetailRelId;
				finderArgs = new Object[] {
					traineeId, blocksMetadataDetailRelId
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTranieeIdAndBlocksMetadataDetailRelId;
			finderArgs = new Object[] {
				traineeId, blocksMetadataDetailRelId, start, end,
				orderByComparator
			};
		}

		List<DutyLog> list = null;

		if (useFinderCache) {
			list = (List<DutyLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLog dutyLog : list) {
					if ((traineeId != dutyLog.getTraineeId()) ||
						(blocksMetadataDetailRelId !=
							dutyLog.getBlocksMetadataDetailRelId())) {

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

			sb.append(_SQL_SELECT_DUTYLOG_WHERE);

			sb.append(
				_FINDER_COLUMN_TRANIEEIDANDBLOCKSMETADATADETAILRELID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRANIEEIDANDBLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(blocksMetadataDetailRelId);

				list = (List<DutyLog>)QueryUtil.list(
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
	 * Returns the first duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByTranieeIdAndBlocksMetadataDetailRelId_First(
			long traineeId, long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByTranieeIdAndBlocksMetadataDetailRelId_First(
			traineeId, blocksMetadataDetailRelId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByTranieeIdAndBlocksMetadataDetailRelId_First(
		long traineeId, long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator) {

		List<DutyLog> list = findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByTranieeIdAndBlocksMetadataDetailRelId_Last(
			long traineeId, long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByTranieeIdAndBlocksMetadataDetailRelId_Last(
			traineeId, blocksMetadataDetailRelId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByTranieeIdAndBlocksMetadataDetailRelId_Last(
		long traineeId, long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator) {

		int count = countByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId);

		if (count == 0) {
			return null;
		}

		List<DutyLog> list = findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog[] findByTranieeIdAndBlocksMetadataDetailRelId_PrevAndNext(
			long dutyLogId, long traineeId, long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = findByPrimaryKey(dutyLogId);

		Session session = null;

		try {
			session = openSession();

			DutyLog[] array = new DutyLogImpl[3];

			array[0] = getByTranieeIdAndBlocksMetadataDetailRelId_PrevAndNext(
				session, dutyLog, traineeId, blocksMetadataDetailRelId,
				orderByComparator, true);

			array[1] = dutyLog;

			array[2] = getByTranieeIdAndBlocksMetadataDetailRelId_PrevAndNext(
				session, dutyLog, traineeId, blocksMetadataDetailRelId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyLog getByTranieeIdAndBlocksMetadataDetailRelId_PrevAndNext(
		Session session, DutyLog dutyLog, long traineeId,
		long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DUTYLOG_WHERE);

		sb.append(
			_FINDER_COLUMN_TRANIEEIDANDBLOCKSMETADATADETAILRELID_TRAINEEID_2);

		sb.append(
			_FINDER_COLUMN_TRANIEEIDANDBLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

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
			sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeId);

		queryPos.add(blocksMetadataDetailRelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dutyLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	@Override
	public void removeByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId) {

		for (DutyLog dutyLog :
				findByTranieeIdAndBlocksMetadataDetailRelId(
					traineeId, blocksMetadataDetailRelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dutyLog);
		}
	}

	/**
	 * Returns the number of duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching duty logs
	 */
	@Override
	public int countByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId) {

		FinderPath finderPath =
			_finderPathCountByTranieeIdAndBlocksMetadataDetailRelId;

		Object[] finderArgs = new Object[] {
			traineeId, blocksMetadataDetailRelId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYLOG_WHERE);

			sb.append(
				_FINDER_COLUMN_TRANIEEIDANDBLOCKSMETADATADETAILRELID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRANIEEIDANDBLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(blocksMetadataDetailRelId);

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

	private static final String
		_FINDER_COLUMN_TRANIEEIDANDBLOCKSMETADATADETAILRELID_TRAINEEID_2 =
			"dutyLog.traineeId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRANIEEIDANDBLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2 =
			"dutyLog.blocksMetadataDetailRelId = ?";

	private FinderPath
		_finderPathWithPaginationFindByTranieeIdAndProgramDutyAssignmentId;
	private FinderPath
		_finderPathWithoutPaginationFindByTranieeIdAndProgramDutyAssignmentId;
	private FinderPath _finderPathCountByTranieeIdAndProgramDutyAssignmentId;

	/**
	 * Returns all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the matching duty logs
	 */
	@Override
	public List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId) {

		return findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end) {

		return findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTranieeIdAndProgramDutyAssignmentId;
				finderArgs = new Object[] {traineeId, programDutyAssignmentId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTranieeIdAndProgramDutyAssignmentId;
			finderArgs = new Object[] {
				traineeId, programDutyAssignmentId, start, end,
				orderByComparator
			};
		}

		List<DutyLog> list = null;

		if (useFinderCache) {
			list = (List<DutyLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLog dutyLog : list) {
					if ((traineeId != dutyLog.getTraineeId()) ||
						(programDutyAssignmentId !=
							dutyLog.getProgramDutyAssignmentId())) {

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

			sb.append(_SQL_SELECT_DUTYLOG_WHERE);

			sb.append(
				_FINDER_COLUMN_TRANIEEIDANDPROGRAMDUTYASSIGNMENTID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRANIEEIDANDPROGRAMDUTYASSIGNMENTID_PROGRAMDUTYASSIGNMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(programDutyAssignmentId);

				list = (List<DutyLog>)QueryUtil.list(
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
	 * Returns the first duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByTranieeIdAndProgramDutyAssignmentId_First(
			long traineeId, long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByTranieeIdAndProgramDutyAssignmentId_First(
			traineeId, programDutyAssignmentId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", programDutyAssignmentId=");
		sb.append(programDutyAssignmentId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByTranieeIdAndProgramDutyAssignmentId_First(
		long traineeId, long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator) {

		List<DutyLog> list = findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByTranieeIdAndProgramDutyAssignmentId_Last(
			long traineeId, long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByTranieeIdAndProgramDutyAssignmentId_Last(
			traineeId, programDutyAssignmentId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", programDutyAssignmentId=");
		sb.append(programDutyAssignmentId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByTranieeIdAndProgramDutyAssignmentId_Last(
		long traineeId, long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator) {

		int count = countByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId);

		if (count == 0) {
			return null;
		}

		List<DutyLog> list = findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog[] findByTranieeIdAndProgramDutyAssignmentId_PrevAndNext(
			long dutyLogId, long traineeId, long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = findByPrimaryKey(dutyLogId);

		Session session = null;

		try {
			session = openSession();

			DutyLog[] array = new DutyLogImpl[3];

			array[0] = getByTranieeIdAndProgramDutyAssignmentId_PrevAndNext(
				session, dutyLog, traineeId, programDutyAssignmentId,
				orderByComparator, true);

			array[1] = dutyLog;

			array[2] = getByTranieeIdAndProgramDutyAssignmentId_PrevAndNext(
				session, dutyLog, traineeId, programDutyAssignmentId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyLog getByTranieeIdAndProgramDutyAssignmentId_PrevAndNext(
		Session session, DutyLog dutyLog, long traineeId,
		long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DUTYLOG_WHERE);

		sb.append(
			_FINDER_COLUMN_TRANIEEIDANDPROGRAMDUTYASSIGNMENTID_TRAINEEID_2);

		sb.append(
			_FINDER_COLUMN_TRANIEEIDANDPROGRAMDUTYASSIGNMENTID_PROGRAMDUTYASSIGNMENTID_2);

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
			sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeId);

		queryPos.add(programDutyAssignmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dutyLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 */
	@Override
	public void removeByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId) {

		for (DutyLog dutyLog :
				findByTranieeIdAndProgramDutyAssignmentId(
					traineeId, programDutyAssignmentId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dutyLog);
		}
	}

	/**
	 * Returns the number of duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the number of matching duty logs
	 */
	@Override
	public int countByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId) {

		FinderPath finderPath =
			_finderPathCountByTranieeIdAndProgramDutyAssignmentId;

		Object[] finderArgs = new Object[] {traineeId, programDutyAssignmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYLOG_WHERE);

			sb.append(
				_FINDER_COLUMN_TRANIEEIDANDPROGRAMDUTYASSIGNMENTID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRANIEEIDANDPROGRAMDUTYASSIGNMENTID_PROGRAMDUTYASSIGNMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(programDutyAssignmentId);

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

	private static final String
		_FINDER_COLUMN_TRANIEEIDANDPROGRAMDUTYASSIGNMENTID_TRAINEEID_2 =
			"dutyLog.traineeId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRANIEEIDANDPROGRAMDUTYASSIGNMENTID_PROGRAMDUTYASSIGNMENTID_2 =
			"dutyLog.programDutyAssignmentId = ?";

	private FinderPath _finderPathWithPaginationFindByBlocksMetadataDetailRelId;
	private FinderPath
		_finderPathWithoutPaginationFindByBlocksMetadataDetailRelId;
	private FinderPath _finderPathCountByBlocksMetadataDetailRelId;

	/**
	 * Returns all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching duty logs
	 */
	@Override
	public List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end) {

		return findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBlocksMetadataDetailRelId;
				finderArgs = new Object[] {blocksMetadataDetailRelId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByBlocksMetadataDetailRelId;
			finderArgs = new Object[] {
				blocksMetadataDetailRelId, start, end, orderByComparator
			};
		}

		List<DutyLog> list = null;

		if (useFinderCache) {
			list = (List<DutyLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLog dutyLog : list) {
					if (blocksMetadataDetailRelId !=
							dutyLog.getBlocksMetadataDetailRelId()) {

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

			sb.append(_SQL_SELECT_DUTYLOG_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailRelId);

				list = (List<DutyLog>)QueryUtil.list(
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
	 * Returns the first duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByBlocksMetadataDetailRelId_First(
			long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByBlocksMetadataDetailRelId_First(
			blocksMetadataDetailRelId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the first duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByBlocksMetadataDetailRelId_First(
		long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator) {

		List<DutyLog> list = findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByBlocksMetadataDetailRelId_Last(
			long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByBlocksMetadataDetailRelId_Last(
			blocksMetadataDetailRelId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the last duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByBlocksMetadataDetailRelId_Last(
		long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator) {

		int count = countByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);

		if (count == 0) {
			return null;
		}

		List<DutyLog> list = findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog[] findByBlocksMetadataDetailRelId_PrevAndNext(
			long dutyLogId, long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = findByPrimaryKey(dutyLogId);

		Session session = null;

		try {
			session = openSession();

			DutyLog[] array = new DutyLogImpl[3];

			array[0] = getByBlocksMetadataDetailRelId_PrevAndNext(
				session, dutyLog, blocksMetadataDetailRelId, orderByComparator,
				true);

			array[1] = dutyLog;

			array[2] = getByBlocksMetadataDetailRelId_PrevAndNext(
				session, dutyLog, blocksMetadataDetailRelId, orderByComparator,
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

	protected DutyLog getByBlocksMetadataDetailRelId_PrevAndNext(
		Session session, DutyLog dutyLog, long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUTYLOG_WHERE);

		sb.append(
			_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

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
			sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(blocksMetadataDetailRelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dutyLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty logs where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	@Override
	public void removeByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		for (DutyLog dutyLog :
				findByBlocksMetadataDetailRelId(
					blocksMetadataDetailRelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dutyLog);
		}
	}

	/**
	 * Returns the number of duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching duty logs
	 */
	@Override
	public int countByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		FinderPath finderPath = _finderPathCountByBlocksMetadataDetailRelId;

		Object[] finderArgs = new Object[] {blocksMetadataDetailRelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYLOG_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailRelId);

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

	private static final String
		_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2 =
			"dutyLog.blocksMetadataDetailRelId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDutyAssignmentId;
	private FinderPath
		_finderPathWithoutPaginationFindByProgramDutyAssignmentId;
	private FinderPath _finderPathCountByProgramDutyAssignmentId;

	/**
	 * Returns all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the matching duty logs
	 */
	@Override
	public List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId) {

		return findByProgramDutyAssignmentId(
			programDutyAssignmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end) {

		return findByProgramDutyAssignmentId(
			programDutyAssignmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return findByProgramDutyAssignmentId(
			programDutyAssignmentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	@Override
	public List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgramDutyAssignmentId;
				finderArgs = new Object[] {programDutyAssignmentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProgramDutyAssignmentId;
			finderArgs = new Object[] {
				programDutyAssignmentId, start, end, orderByComparator
			};
		}

		List<DutyLog> list = null;

		if (useFinderCache) {
			list = (List<DutyLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLog dutyLog : list) {
					if (programDutyAssignmentId !=
							dutyLog.getProgramDutyAssignmentId()) {

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

			sb.append(_SQL_SELECT_DUTYLOG_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDUTYASSIGNMENTID_PROGRAMDUTYASSIGNMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDutyAssignmentId);

				list = (List<DutyLog>)QueryUtil.list(
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
	 * Returns the first duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByProgramDutyAssignmentId_First(
			long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByProgramDutyAssignmentId_First(
			programDutyAssignmentId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDutyAssignmentId=");
		sb.append(programDutyAssignmentId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the first duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByProgramDutyAssignmentId_First(
		long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator) {

		List<DutyLog> list = findByProgramDutyAssignmentId(
			programDutyAssignmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	@Override
	public DutyLog findByProgramDutyAssignmentId_Last(
			long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByProgramDutyAssignmentId_Last(
			programDutyAssignmentId, orderByComparator);

		if (dutyLog != null) {
			return dutyLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDutyAssignmentId=");
		sb.append(programDutyAssignmentId);

		sb.append("}");

		throw new NoSuchDutyLogException(sb.toString());
	}

	/**
	 * Returns the last duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public DutyLog fetchByProgramDutyAssignmentId_Last(
		long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator) {

		int count = countByProgramDutyAssignmentId(programDutyAssignmentId);

		if (count == 0) {
			return null;
		}

		List<DutyLog> list = findByProgramDutyAssignmentId(
			programDutyAssignmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog[] findByProgramDutyAssignmentId_PrevAndNext(
			long dutyLogId, long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = findByPrimaryKey(dutyLogId);

		Session session = null;

		try {
			session = openSession();

			DutyLog[] array = new DutyLogImpl[3];

			array[0] = getByProgramDutyAssignmentId_PrevAndNext(
				session, dutyLog, programDutyAssignmentId, orderByComparator,
				true);

			array[1] = dutyLog;

			array[2] = getByProgramDutyAssignmentId_PrevAndNext(
				session, dutyLog, programDutyAssignmentId, orderByComparator,
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

	protected DutyLog getByProgramDutyAssignmentId_PrevAndNext(
		Session session, DutyLog dutyLog, long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUTYLOG_WHERE);

		sb.append(
			_FINDER_COLUMN_PROGRAMDUTYASSIGNMENTID_PROGRAMDUTYASSIGNMENTID_2);

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
			sb.append(DutyLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programDutyAssignmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dutyLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty logs where programDutyAssignmentId = &#63; from the database.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 */
	@Override
	public void removeByProgramDutyAssignmentId(long programDutyAssignmentId) {
		for (DutyLog dutyLog :
				findByProgramDutyAssignmentId(
					programDutyAssignmentId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dutyLog);
		}
	}

	/**
	 * Returns the number of duty logs where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the number of matching duty logs
	 */
	@Override
	public int countByProgramDutyAssignmentId(long programDutyAssignmentId) {
		FinderPath finderPath = _finderPathCountByProgramDutyAssignmentId;

		Object[] finderArgs = new Object[] {programDutyAssignmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYLOG_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDUTYASSIGNMENTID_PROGRAMDUTYASSIGNMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDutyAssignmentId);

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

	private static final String
		_FINDER_COLUMN_PROGRAMDUTYASSIGNMENTID_PROGRAMDUTYASSIGNMENTID_2 =
			"dutyLog.programDutyAssignmentId = ?";

	public DutyLogPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("dutyLogId", "duty_log_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put(
			"programDutyAssignmentId", "program_duty_assignment_id");
		dbColumnNames.put(
			"blocksMetadataDetailRelId", "blocks_metadata_details_rel_id");
		dbColumnNames.put("residencyLevelId", "residency_level_id");
		dbColumnNames.put("multiDays", "multi_days");
		dbColumnNames.put("startDate", "start_date");
		dbColumnNames.put("endDate", "end_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(DutyLog.class);

		setModelImplClass(DutyLogImpl.class);
		setModelPKClass(long.class);

		setTable(DutyLogTable.INSTANCE);
	}

	/**
	 * Caches the duty log in the entity cache if it is enabled.
	 *
	 * @param dutyLog the duty log
	 */
	@Override
	public void cacheResult(DutyLog dutyLog) {
		entityCache.putResult(
			DutyLogImpl.class, dutyLog.getPrimaryKey(), dutyLog);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {dutyLog.getUuid(), dutyLog.getGroupId()}, dutyLog);

		finderCache.putResult(
			_finderPathFetchByTraineeIdAndStartDate,
			new Object[] {dutyLog.getTraineeId(), dutyLog.getStartDate()},
			dutyLog);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the duty logs in the entity cache if it is enabled.
	 *
	 * @param dutyLogs the duty logs
	 */
	@Override
	public void cacheResult(List<DutyLog> dutyLogs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dutyLogs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DutyLog dutyLog : dutyLogs) {
			if (entityCache.getResult(
					DutyLogImpl.class, dutyLog.getPrimaryKey()) == null) {

				cacheResult(dutyLog);
			}
		}
	}

	/**
	 * Clears the cache for all duty logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DutyLogImpl.class);

		finderCache.clearCache(DutyLogImpl.class);
	}

	/**
	 * Clears the cache for the duty log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DutyLog dutyLog) {
		entityCache.removeResult(DutyLogImpl.class, dutyLog);
	}

	@Override
	public void clearCache(List<DutyLog> dutyLogs) {
		for (DutyLog dutyLog : dutyLogs) {
			entityCache.removeResult(DutyLogImpl.class, dutyLog);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DutyLogImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DutyLogImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(DutyLogModelImpl dutyLogModelImpl) {
		Object[] args = new Object[] {
			dutyLogModelImpl.getUuid(), dutyLogModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, dutyLogModelImpl);

		args = new Object[] {
			dutyLogModelImpl.getTraineeId(),
			_getTime(dutyLogModelImpl.getStartDate())
		};

		finderCache.putResult(
			_finderPathCountByTraineeIdAndStartDate, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTraineeIdAndStartDate, args, dutyLogModelImpl);
	}

	/**
	 * Creates a new duty log with the primary key. Does not add the duty log to the database.
	 *
	 * @param dutyLogId the primary key for the new duty log
	 * @return the new duty log
	 */
	@Override
	public DutyLog create(long dutyLogId) {
		DutyLog dutyLog = new DutyLogImpl();

		dutyLog.setNew(true);
		dutyLog.setPrimaryKey(dutyLogId);

		String uuid = _portalUUID.generate();

		dutyLog.setUuid(uuid);

		dutyLog.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dutyLog;
	}

	/**
	 * Removes the duty log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log that was removed
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog remove(long dutyLogId) throws NoSuchDutyLogException {
		return remove((Serializable)dutyLogId);
	}

	/**
	 * Removes the duty log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the duty log
	 * @return the duty log that was removed
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog remove(Serializable primaryKey)
		throws NoSuchDutyLogException {

		Session session = null;

		try {
			session = openSession();

			DutyLog dutyLog = (DutyLog)session.get(
				DutyLogImpl.class, primaryKey);

			if (dutyLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDutyLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dutyLog);
		}
		catch (NoSuchDutyLogException noSuchEntityException) {
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
	protected DutyLog removeImpl(DutyLog dutyLog) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dutyLog)) {
				dutyLog = (DutyLog)session.get(
					DutyLogImpl.class, dutyLog.getPrimaryKeyObj());
			}

			if (dutyLog != null) {
				session.delete(dutyLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dutyLog != null) {
			clearCache(dutyLog);
		}

		return dutyLog;
	}

	@Override
	public DutyLog updateImpl(DutyLog dutyLog) {
		boolean isNew = dutyLog.isNew();

		if (!(dutyLog instanceof DutyLogModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dutyLog.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dutyLog);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dutyLog proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DutyLog implementation " +
					dutyLog.getClass());
		}

		DutyLogModelImpl dutyLogModelImpl = (DutyLogModelImpl)dutyLog;

		if (Validator.isNull(dutyLog.getUuid())) {
			String uuid = _portalUUID.generate();

			dutyLog.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dutyLog.getCreateDate() == null)) {
			if (serviceContext == null) {
				dutyLog.setCreateDate(date);
			}
			else {
				dutyLog.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!dutyLogModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dutyLog.setModifiedDate(date);
			}
			else {
				dutyLog.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dutyLog);
			}
			else {
				dutyLog = (DutyLog)session.merge(dutyLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DutyLogImpl.class, dutyLogModelImpl, false, true);

		cacheUniqueFindersCache(dutyLogModelImpl);

		if (isNew) {
			dutyLog.setNew(false);
		}

		dutyLog.resetOriginalValues();

		return dutyLog;
	}

	/**
	 * Returns the duty log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the duty log
	 * @return the duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDutyLogException {

		DutyLog dutyLog = fetchByPrimaryKey(primaryKey);

		if (dutyLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDutyLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dutyLog;
	}

	/**
	 * Returns the duty log with the primary key or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog findByPrimaryKey(long dutyLogId)
		throws NoSuchDutyLogException {

		return findByPrimaryKey((Serializable)dutyLogId);
	}

	/**
	 * Returns the duty log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log, or <code>null</code> if a duty log with the primary key could not be found
	 */
	@Override
	public DutyLog fetchByPrimaryKey(long dutyLogId) {
		return fetchByPrimaryKey((Serializable)dutyLogId);
	}

	/**
	 * Returns all the duty logs.
	 *
	 * @return the duty logs
	 */
	@Override
	public List<DutyLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of duty logs
	 */
	@Override
	public List<DutyLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty logs
	 */
	@Override
	public List<DutyLog> findAll(
		int start, int end, OrderByComparator<DutyLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty logs
	 */
	@Override
	public List<DutyLog> findAll(
		int start, int end, OrderByComparator<DutyLog> orderByComparator,
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

		List<DutyLog> list = null;

		if (useFinderCache) {
			list = (List<DutyLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DUTYLOG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DUTYLOG;

				sql = sql.concat(DutyLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DutyLog>)QueryUtil.list(
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
	 * Removes all the duty logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DutyLog dutyLog : findAll()) {
			remove(dutyLog);
		}
	}

	/**
	 * Returns the number of duty logs.
	 *
	 * @return the number of duty logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DUTYLOG);

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
		return "duty_log_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DUTYLOG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DutyLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the duty log persistence.
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

		_finderPathFetchByTraineeIdAndStartDate = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTraineeIdAndStartDate",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"trainee_id", "start_date"}, true);

		_finderPathCountByTraineeIdAndStartDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTraineeIdAndStartDate",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"trainee_id", "start_date"}, false);

		_finderPathWithPaginationFindByTranieeIdAndBlocksMetadataDetailRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTranieeIdAndBlocksMetadataDetailRelId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"trainee_id", "blocks_metadata_details_rel_id"},
				true);

		_finderPathWithoutPaginationFindByTranieeIdAndBlocksMetadataDetailRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTranieeIdAndBlocksMetadataDetailRelId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"trainee_id", "blocks_metadata_details_rel_id"},
				true);

		_finderPathCountByTranieeIdAndBlocksMetadataDetailRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByTranieeIdAndBlocksMetadataDetailRelId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"trainee_id", "blocks_metadata_details_rel_id"},
				false);

		_finderPathWithPaginationFindByTranieeIdAndProgramDutyAssignmentId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTranieeIdAndProgramDutyAssignmentId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"trainee_id", "program_duty_assignment_id"},
				true);

		_finderPathWithoutPaginationFindByTranieeIdAndProgramDutyAssignmentId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTranieeIdAndProgramDutyAssignmentId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"trainee_id", "program_duty_assignment_id"},
				true);

		_finderPathCountByTranieeIdAndProgramDutyAssignmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTranieeIdAndProgramDutyAssignmentId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"trainee_id", "program_duty_assignment_id"}, false);

		_finderPathWithPaginationFindByBlocksMetadataDetailRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByBlocksMetadataDetailRelId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"blocks_metadata_details_rel_id"}, true);

		_finderPathWithoutPaginationFindByBlocksMetadataDetailRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByBlocksMetadataDetailRelId",
				new String[] {Long.class.getName()},
				new String[] {"blocks_metadata_details_rel_id"}, true);

		_finderPathCountByBlocksMetadataDetailRelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBlocksMetadataDetailRelId",
			new String[] {Long.class.getName()},
			new String[] {"blocks_metadata_details_rel_id"}, false);

		_finderPathWithPaginationFindByProgramDutyAssignmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProgramDutyAssignmentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_duty_assignment_id"}, true);

		_finderPathWithoutPaginationFindByProgramDutyAssignmentId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProgramDutyAssignmentId",
				new String[] {Long.class.getName()},
				new String[] {"program_duty_assignment_id"}, true);

		_finderPathCountByProgramDutyAssignmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramDutyAssignmentId",
			new String[] {Long.class.getName()},
			new String[] {"program_duty_assignment_id"}, false);

		_setDutyLogUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDutyLogUtilPersistence(null);

		entityCache.removeCache(DutyLogImpl.class.getName());
	}

	private void _setDutyLogUtilPersistence(
		DutyLogPersistence dutyLogPersistence) {

		try {
			Field field = DutyLogUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, dutyLogPersistence);
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_DUTYLOG =
		"SELECT dutyLog FROM DutyLog dutyLog";

	private static final String _SQL_SELECT_DUTYLOG_WHERE =
		"SELECT dutyLog FROM DutyLog dutyLog WHERE ";

	private static final String _SQL_COUNT_DUTYLOG =
		"SELECT COUNT(dutyLog) FROM DutyLog dutyLog";

	private static final String _SQL_COUNT_DUTYLOG_WHERE =
		"SELECT COUNT(dutyLog) FROM DutyLog dutyLog WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dutyLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DutyLog exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DutyLog exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DutyLogPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "dutyLogId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "traineeId",
			"programDutyAssignmentId", "blocksMetadataDetailRelId",
			"residencyLevelId", "multiDays", "startDate", "endDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
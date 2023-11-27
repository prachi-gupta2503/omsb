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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import gov.omsb.tms.exception.NoSuchLeaveMasterException;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveMasterTable;
import gov.omsb.tms.model.impl.LeaveMasterImpl;
import gov.omsb.tms.model.impl.LeaveMasterModelImpl;
import gov.omsb.tms.service.persistence.LeaveMasterPersistence;
import gov.omsb.tms.service.persistence.LeaveMasterUtil;
import gov.omsb.tms.service.persistence.impl.constants.OMSBTMSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the leave master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveMasterPersistence.class)
public class LeaveMasterPersistenceImpl
	extends BasePersistenceImpl<LeaveMaster> implements LeaveMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveMasterUtil</code> to access the leave master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveMasterImpl.class.getName();

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
	 * Returns all the leave masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveMaster> orderByComparator,
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

		List<LeaveMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveMaster leaveMaster : list) {
					if (!uuid.equals(leaveMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVEMASTER_WHERE);

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
				sb.append(LeaveMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveMaster>)QueryUtil.list(
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
	 * Returns the first leave master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster findByUuid_First(
			String uuid, OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = fetchByUuid_First(uuid, orderByComparator);

		if (leaveMaster != null) {
			return leaveMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveMasterException(sb.toString());
	}

	/**
	 * Returns the first leave master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster fetchByUuid_First(
		String uuid, OrderByComparator<LeaveMaster> orderByComparator) {

		List<LeaveMaster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster findByUuid_Last(
			String uuid, OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = fetchByUuid_Last(uuid, orderByComparator);

		if (leaveMaster != null) {
			return leaveMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveMasterException(sb.toString());
	}

	/**
	 * Returns the last leave master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave masters before and after the current leave master in the ordered set where uuid = &#63;.
	 *
	 * @param leaveMasterId the primary key of the current leave master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	@Override
	public LeaveMaster[] findByUuid_PrevAndNext(
			long leaveMasterId, String uuid,
			OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		uuid = Objects.toString(uuid, "");

		LeaveMaster leaveMaster = findByPrimaryKey(leaveMasterId);

		Session session = null;

		try {
			session = openSession();

			LeaveMaster[] array = new LeaveMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveMaster, uuid, orderByComparator, true);

			array[1] = leaveMaster;

			array[2] = getByUuid_PrevAndNext(
				session, leaveMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveMaster getByUuid_PrevAndNext(
		Session session, LeaveMaster leaveMaster, String uuid,
		OrderByComparator<LeaveMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEMASTER_WHERE);

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
			sb.append(LeaveMasterModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(leaveMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveMaster leaveMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveMaster);
		}
	}

	/**
	 * Returns the number of leave masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEMASTER_WHERE);

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
		"leaveMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveMaster.uuid IS NULL OR leaveMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the leave master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = fetchByUUID_G(uuid, groupId);

		if (leaveMaster == null) {
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

			throw new NoSuchLeaveMasterException(sb.toString());
		}

		return leaveMaster;
	}

	/**
	 * Returns the leave master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster fetchByUUID_G(
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

		if (result instanceof LeaveMaster) {
			LeaveMaster leaveMaster = (LeaveMaster)result;

			if (!Objects.equals(uuid, leaveMaster.getUuid()) ||
				(groupId != leaveMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEMASTER_WHERE);

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

				List<LeaveMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveMaster leaveMaster = list.get(0);

					result = leaveMaster;

					cacheResult(leaveMaster);
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
			return (LeaveMaster)result;
		}
	}

	/**
	 * Removes the leave master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave master that was removed
	 */
	@Override
	public LeaveMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = findByUUID_G(uuid, groupId);

		return remove(leaveMaster);
	}

	/**
	 * Returns the number of leave masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEMASTER_WHERE);

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
		"leaveMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveMaster.uuid IS NULL OR leaveMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveMaster> orderByComparator,
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

		List<LeaveMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveMaster leaveMaster : list) {
					if (!uuid.equals(leaveMaster.getUuid()) ||
						(companyId != leaveMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVEMASTER_WHERE);

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
				sb.append(LeaveMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveMaster>)QueryUtil.list(
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
	 * Returns the first leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveMaster != null) {
			return leaveMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveMasterException(sb.toString());
	}

	/**
	 * Returns the first leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveMaster> orderByComparator) {

		List<LeaveMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveMaster != null) {
			return leaveMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveMasterException(sb.toString());
	}

	/**
	 * Returns the last leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave masters before and after the current leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveMasterId the primary key of the current leave master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	@Override
	public LeaveMaster[] findByUuid_C_PrevAndNext(
			long leaveMasterId, String uuid, long companyId,
			OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		uuid = Objects.toString(uuid, "");

		LeaveMaster leaveMaster = findByPrimaryKey(leaveMasterId);

		Session session = null;

		try {
			session = openSession();

			LeaveMaster[] array = new LeaveMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveMaster, uuid, companyId, orderByComparator, true);

			array[1] = leaveMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveMaster, uuid, companyId, orderByComparator,
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

	protected LeaveMaster getByUuid_C_PrevAndNext(
		Session session, LeaveMaster leaveMaster, String uuid, long companyId,
		OrderByComparator<LeaveMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LEAVEMASTER_WHERE);

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
			sb.append(LeaveMasterModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(leaveMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveMaster leaveMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveMaster);
		}
	}

	/**
	 * Returns the number of leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEMASTER_WHERE);

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
		"leaveMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveMaster.uuid IS NULL OR leaveMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTraineeId;
	private FinderPath _finderPathWithoutPaginationFindByTraineeId;
	private FinderPath _finderPathCountByTraineeId;

	/**
	 * Returns all the leave masters where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByTraineeId(long traineeId) {
		return findByTraineeId(
			traineeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave masters where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByTraineeId(
		long traineeId, int start, int end) {

		return findByTraineeId(traineeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave masters where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<LeaveMaster> orderByComparator) {

		return findByTraineeId(traineeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave masters where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave masters
	 */
	@Override
	public List<LeaveMaster> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<LeaveMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTraineeId;
				finderArgs = new Object[] {traineeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTraineeId;
			finderArgs = new Object[] {
				traineeId, start, end, orderByComparator
			};
		}

		List<LeaveMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveMaster leaveMaster : list) {
					if (traineeId != leaveMaster.getTraineeId()) {
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

			sb.append(_SQL_SELECT_LEAVEMASTER_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				list = (List<LeaveMaster>)QueryUtil.list(
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
	 * Returns the first leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster findByTraineeId_First(
			long traineeId, OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = fetchByTraineeId_First(
			traineeId, orderByComparator);

		if (leaveMaster != null) {
			return leaveMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append("}");

		throw new NoSuchLeaveMasterException(sb.toString());
	}

	/**
	 * Returns the first leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster fetchByTraineeId_First(
		long traineeId, OrderByComparator<LeaveMaster> orderByComparator) {

		List<LeaveMaster> list = findByTraineeId(
			traineeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster findByTraineeId_Last(
			long traineeId, OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = fetchByTraineeId_Last(
			traineeId, orderByComparator);

		if (leaveMaster != null) {
			return leaveMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append("}");

		throw new NoSuchLeaveMasterException(sb.toString());
	}

	/**
	 * Returns the last leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public LeaveMaster fetchByTraineeId_Last(
		long traineeId, OrderByComparator<LeaveMaster> orderByComparator) {

		int count = countByTraineeId(traineeId);

		if (count == 0) {
			return null;
		}

		List<LeaveMaster> list = findByTraineeId(
			traineeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave masters before and after the current leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param leaveMasterId the primary key of the current leave master
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	@Override
	public LeaveMaster[] findByTraineeId_PrevAndNext(
			long leaveMasterId, long traineeId,
			OrderByComparator<LeaveMaster> orderByComparator)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = findByPrimaryKey(leaveMasterId);

		Session session = null;

		try {
			session = openSession();

			LeaveMaster[] array = new LeaveMasterImpl[3];

			array[0] = getByTraineeId_PrevAndNext(
				session, leaveMaster, traineeId, orderByComparator, true);

			array[1] = leaveMaster;

			array[2] = getByTraineeId_PrevAndNext(
				session, leaveMaster, traineeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveMaster getByTraineeId_PrevAndNext(
		Session session, LeaveMaster leaveMaster, long traineeId,
		OrderByComparator<LeaveMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEMASTER_WHERE);

		sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

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
			sb.append(LeaveMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave masters where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	@Override
	public void removeByTraineeId(long traineeId) {
		for (LeaveMaster leaveMaster :
				findByTraineeId(
					traineeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveMaster);
		}
	}

	/**
	 * Returns the number of leave masters where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching leave masters
	 */
	@Override
	public int countByTraineeId(long traineeId) {
		FinderPath finderPath = _finderPathCountByTraineeId;

		Object[] finderArgs = new Object[] {traineeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEMASTER_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

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

	private static final String _FINDER_COLUMN_TRAINEEID_TRAINEEID_2 =
		"leaveMaster.traineeId = ?";

	public LeaveMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("leaveMasterId", "leave_master_id");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put("leaveTypeId", "leave_type_id");
		dbColumnNames.put("leaveTraineeId", "leave_trainee_id");
		dbColumnNames.put("blockName", "block_name");
		dbColumnNames.put("leaveFrom", "leave_from");
		dbColumnNames.put("leaveTo", "leave_to");
		dbColumnNames.put("noOfDays", "no_of_days");
		dbColumnNames.put("contactName", "contact_name");
		dbColumnNames.put("contactEmail", "contact_email");
		dbColumnNames.put("contactNo", "contact_no");
		dbColumnNames.put("reasonForLeave", "reason_for_leave");
		dbColumnNames.put("applicationDate", "application_date");
		dbColumnNames.put("returnFromLeave", "return_from_leave");
		dbColumnNames.put("reasonForDelay", "reason_for_delay");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveMaster.class);

		setModelImplClass(LeaveMasterImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveMasterTable.INSTANCE);
	}

	/**
	 * Caches the leave master in the entity cache if it is enabled.
	 *
	 * @param leaveMaster the leave master
	 */
	@Override
	public void cacheResult(LeaveMaster leaveMaster) {
		entityCache.putResult(
			LeaveMasterImpl.class, leaveMaster.getPrimaryKey(), leaveMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {leaveMaster.getUuid(), leaveMaster.getGroupId()},
			leaveMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave masters in the entity cache if it is enabled.
	 *
	 * @param leaveMasters the leave masters
	 */
	@Override
	public void cacheResult(List<LeaveMaster> leaveMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveMasters.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveMaster leaveMaster : leaveMasters) {
			if (entityCache.getResult(
					LeaveMasterImpl.class, leaveMaster.getPrimaryKey()) ==
						null) {

				cacheResult(leaveMaster);
			}
		}
	}

	/**
	 * Clears the cache for all leave masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveMasterImpl.class);

		finderCache.clearCache(LeaveMasterImpl.class);
	}

	/**
	 * Clears the cache for the leave master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveMaster leaveMaster) {
		entityCache.removeResult(LeaveMasterImpl.class, leaveMaster);
	}

	@Override
	public void clearCache(List<LeaveMaster> leaveMasters) {
		for (LeaveMaster leaveMaster : leaveMasters) {
			entityCache.removeResult(LeaveMasterImpl.class, leaveMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveMasterModelImpl leaveMasterModelImpl) {

		Object[] args = new Object[] {
			leaveMasterModelImpl.getUuid(), leaveMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveMasterModelImpl);
	}

	/**
	 * Creates a new leave master with the primary key. Does not add the leave master to the database.
	 *
	 * @param leaveMasterId the primary key for the new leave master
	 * @return the new leave master
	 */
	@Override
	public LeaveMaster create(long leaveMasterId) {
		LeaveMaster leaveMaster = new LeaveMasterImpl();

		leaveMaster.setNew(true);
		leaveMaster.setPrimaryKey(leaveMasterId);

		String uuid = _portalUUID.generate();

		leaveMaster.setUuid(uuid);

		leaveMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveMaster;
	}

	/**
	 * Removes the leave master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master that was removed
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	@Override
	public LeaveMaster remove(long leaveMasterId)
		throws NoSuchLeaveMasterException {

		return remove((Serializable)leaveMasterId);
	}

	/**
	 * Removes the leave master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave master
	 * @return the leave master that was removed
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	@Override
	public LeaveMaster remove(Serializable primaryKey)
		throws NoSuchLeaveMasterException {

		Session session = null;

		try {
			session = openSession();

			LeaveMaster leaveMaster = (LeaveMaster)session.get(
				LeaveMasterImpl.class, primaryKey);

			if (leaveMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveMaster);
		}
		catch (NoSuchLeaveMasterException noSuchEntityException) {
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
	protected LeaveMaster removeImpl(LeaveMaster leaveMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveMaster)) {
				leaveMaster = (LeaveMaster)session.get(
					LeaveMasterImpl.class, leaveMaster.getPrimaryKeyObj());
			}

			if (leaveMaster != null) {
				session.delete(leaveMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveMaster != null) {
			clearCache(leaveMaster);
		}

		return leaveMaster;
	}

	@Override
	public LeaveMaster updateImpl(LeaveMaster leaveMaster) {
		boolean isNew = leaveMaster.isNew();

		if (!(leaveMaster instanceof LeaveMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(leaveMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveMaster implementation " +
					leaveMaster.getClass());
		}

		LeaveMasterModelImpl leaveMasterModelImpl =
			(LeaveMasterModelImpl)leaveMaster;

		if (Validator.isNull(leaveMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			leaveMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveMaster.setCreateDate(date);
			}
			else {
				leaveMaster.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!leaveMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveMaster.setModifiedDate(date);
			}
			else {
				leaveMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveMaster);
			}
			else {
				leaveMaster = (LeaveMaster)session.merge(leaveMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveMasterImpl.class, leaveMasterModelImpl, false, true);

		cacheUniqueFindersCache(leaveMasterModelImpl);

		if (isNew) {
			leaveMaster.setNew(false);
		}

		leaveMaster.resetOriginalValues();

		return leaveMaster;
	}

	/**
	 * Returns the leave master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave master
	 * @return the leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	@Override
	public LeaveMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveMasterException {

		LeaveMaster leaveMaster = fetchByPrimaryKey(primaryKey);

		if (leaveMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveMaster;
	}

	/**
	 * Returns the leave master with the primary key or throws a <code>NoSuchLeaveMasterException</code> if it could not be found.
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	@Override
	public LeaveMaster findByPrimaryKey(long leaveMasterId)
		throws NoSuchLeaveMasterException {

		return findByPrimaryKey((Serializable)leaveMasterId);
	}

	/**
	 * Returns the leave master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master, or <code>null</code> if a leave master with the primary key could not be found
	 */
	@Override
	public LeaveMaster fetchByPrimaryKey(long leaveMasterId) {
		return fetchByPrimaryKey((Serializable)leaveMasterId);
	}

	/**
	 * Returns all the leave masters.
	 *
	 * @return the leave masters
	 */
	@Override
	public List<LeaveMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of leave masters
	 */
	@Override
	public List<LeaveMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave masters
	 */
	@Override
	public List<LeaveMaster> findAll(
		int start, int end, OrderByComparator<LeaveMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave masters
	 */
	@Override
	public List<LeaveMaster> findAll(
		int start, int end, OrderByComparator<LeaveMaster> orderByComparator,
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

		List<LeaveMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEMASTER;

				sql = sql.concat(LeaveMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveMaster>)QueryUtil.list(
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
	 * Removes all the leave masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveMaster leaveMaster : findAll()) {
			remove(leaveMaster);
		}
	}

	/**
	 * Returns the number of leave masters.
	 *
	 * @return the number of leave masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVEMASTER);

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
		return "leave_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave master persistence.
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

		_finderPathWithPaginationFindByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTraineeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"trainee_id"}, true);

		_finderPathWithoutPaginationFindByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			true);

		_finderPathCountByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			false);

		_setLeaveMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLeaveMasterUtilPersistence(null);

		entityCache.removeCache(LeaveMasterImpl.class.getName());
	}

	private void _setLeaveMasterUtilPersistence(
		LeaveMasterPersistence leaveMasterPersistence) {

		try {
			Field field = LeaveMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, leaveMasterPersistence);
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

	private static final String _SQL_SELECT_LEAVEMASTER =
		"SELECT leaveMaster FROM LeaveMaster leaveMaster";

	private static final String _SQL_SELECT_LEAVEMASTER_WHERE =
		"SELECT leaveMaster FROM LeaveMaster leaveMaster WHERE ";

	private static final String _SQL_COUNT_LEAVEMASTER =
		"SELECT COUNT(leaveMaster) FROM LeaveMaster leaveMaster";

	private static final String _SQL_COUNT_LEAVEMASTER_WHERE =
		"SELECT COUNT(leaveMaster) FROM LeaveMaster leaveMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "leaveMasterId", "traineeId", "leaveTypeId",
			"leaveTraineeId", "blockName", "leaveFrom", "leaveTo", "noOfDays",
			"contactName", "contactEmail", "contactNo", "reasonForLeave",
			"applicationDate", "returnFromLeave", "reasonForDelay", "programId",
			"groupId", "companyId", "createDate", "createdBy", "modifiedDate",
			"modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
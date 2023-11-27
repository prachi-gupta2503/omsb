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

import gov.omsb.tms.exception.NoSuchLeaveTraineeMasterException;
import gov.omsb.tms.model.LeaveTraineeMaster;
import gov.omsb.tms.model.LeaveTraineeMasterTable;
import gov.omsb.tms.model.impl.LeaveTraineeMasterImpl;
import gov.omsb.tms.model.impl.LeaveTraineeMasterModelImpl;
import gov.omsb.tms.service.persistence.LeaveTraineeMasterPersistence;
import gov.omsb.tms.service.persistence.LeaveTraineeMasterUtil;
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
 * The persistence implementation for the leave trainee master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveTraineeMasterPersistence.class)
public class LeaveTraineeMasterPersistenceImpl
	extends BasePersistenceImpl<LeaveTraineeMaster>
	implements LeaveTraineeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveTraineeMasterUtil</code> to access the leave trainee master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveTraineeMasterImpl.class.getName();

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
	 * Returns all the leave trainee masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave trainee masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @return the range of matching leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave trainee masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveTraineeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave trainee masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveTraineeMaster> orderByComparator,
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

		List<LeaveTraineeMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveTraineeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveTraineeMaster leaveTraineeMaster : list) {
					if (!uuid.equals(leaveTraineeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVETRAINEEMASTER_WHERE);

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
				sb.append(LeaveTraineeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveTraineeMaster>)QueryUtil.list(
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
	 * Returns the first leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster findByUuid_First(
			String uuid,
			OrderByComparator<LeaveTraineeMaster> orderByComparator)
		throws NoSuchLeaveTraineeMasterException {

		LeaveTraineeMaster leaveTraineeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (leaveTraineeMaster != null) {
			return leaveTraineeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveTraineeMasterException(sb.toString());
	}

	/**
	 * Returns the first leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster fetchByUuid_First(
		String uuid, OrderByComparator<LeaveTraineeMaster> orderByComparator) {

		List<LeaveTraineeMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveTraineeMaster> orderByComparator)
		throws NoSuchLeaveTraineeMasterException {

		LeaveTraineeMaster leaveTraineeMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (leaveTraineeMaster != null) {
			return leaveTraineeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveTraineeMasterException(sb.toString());
	}

	/**
	 * Returns the last leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveTraineeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveTraineeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave trainee masters before and after the current leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param leaveTraineeMasterId the primary key of the current leave trainee master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	@Override
	public LeaveTraineeMaster[] findByUuid_PrevAndNext(
			long leaveTraineeMasterId, String uuid,
			OrderByComparator<LeaveTraineeMaster> orderByComparator)
		throws NoSuchLeaveTraineeMasterException {

		uuid = Objects.toString(uuid, "");

		LeaveTraineeMaster leaveTraineeMaster = findByPrimaryKey(
			leaveTraineeMasterId);

		Session session = null;

		try {
			session = openSession();

			LeaveTraineeMaster[] array = new LeaveTraineeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveTraineeMaster, uuid, orderByComparator, true);

			array[1] = leaveTraineeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, leaveTraineeMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveTraineeMaster getByUuid_PrevAndNext(
		Session session, LeaveTraineeMaster leaveTraineeMaster, String uuid,
		OrderByComparator<LeaveTraineeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVETRAINEEMASTER_WHERE);

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
			sb.append(LeaveTraineeMasterModelImpl.ORDER_BY_JPQL);
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
						leaveTraineeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveTraineeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave trainee masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveTraineeMaster leaveTraineeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveTraineeMaster);
		}
	}

	/**
	 * Returns the number of leave trainee masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave trainee masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVETRAINEEMASTER_WHERE);

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
		"leaveTraineeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveTraineeMaster.uuid IS NULL OR leaveTraineeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the leave trainee master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveTraineeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTraineeMasterException {

		LeaveTraineeMaster leaveTraineeMaster = fetchByUUID_G(uuid, groupId);

		if (leaveTraineeMaster == null) {
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

			throw new NoSuchLeaveTraineeMasterException(sb.toString());
		}

		return leaveTraineeMaster;
	}

	/**
	 * Returns the leave trainee master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave trainee master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster fetchByUUID_G(
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

		if (result instanceof LeaveTraineeMaster) {
			LeaveTraineeMaster leaveTraineeMaster = (LeaveTraineeMaster)result;

			if (!Objects.equals(uuid, leaveTraineeMaster.getUuid()) ||
				(groupId != leaveTraineeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVETRAINEEMASTER_WHERE);

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

				List<LeaveTraineeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveTraineeMaster leaveTraineeMaster = list.get(0);

					result = leaveTraineeMaster;

					cacheResult(leaveTraineeMaster);
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
			return (LeaveTraineeMaster)result;
		}
	}

	/**
	 * Removes the leave trainee master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave trainee master that was removed
	 */
	@Override
	public LeaveTraineeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTraineeMasterException {

		LeaveTraineeMaster leaveTraineeMaster = findByUUID_G(uuid, groupId);

		return remove(leaveTraineeMaster);
	}

	/**
	 * Returns the number of leave trainee masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave trainee masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVETRAINEEMASTER_WHERE);

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
		"leaveTraineeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveTraineeMaster.uuid IS NULL OR leaveTraineeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveTraineeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @return the range of matching leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveTraineeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveTraineeMaster> orderByComparator,
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

		List<LeaveTraineeMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveTraineeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveTraineeMaster leaveTraineeMaster : list) {
					if (!uuid.equals(leaveTraineeMaster.getUuid()) ||
						(companyId != leaveTraineeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVETRAINEEMASTER_WHERE);

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
				sb.append(LeaveTraineeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveTraineeMaster>)QueryUtil.list(
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
	 * Returns the first leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveTraineeMaster> orderByComparator)
		throws NoSuchLeaveTraineeMasterException {

		LeaveTraineeMaster leaveTraineeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveTraineeMaster != null) {
			return leaveTraineeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveTraineeMasterException(sb.toString());
	}

	/**
	 * Returns the first leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveTraineeMaster> orderByComparator) {

		List<LeaveTraineeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveTraineeMaster> orderByComparator)
		throws NoSuchLeaveTraineeMasterException {

		LeaveTraineeMaster leaveTraineeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveTraineeMaster != null) {
			return leaveTraineeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveTraineeMasterException(sb.toString());
	}

	/**
	 * Returns the last leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	@Override
	public LeaveTraineeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveTraineeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveTraineeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave trainee masters before and after the current leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveTraineeMasterId the primary key of the current leave trainee master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	@Override
	public LeaveTraineeMaster[] findByUuid_C_PrevAndNext(
			long leaveTraineeMasterId, String uuid, long companyId,
			OrderByComparator<LeaveTraineeMaster> orderByComparator)
		throws NoSuchLeaveTraineeMasterException {

		uuid = Objects.toString(uuid, "");

		LeaveTraineeMaster leaveTraineeMaster = findByPrimaryKey(
			leaveTraineeMasterId);

		Session session = null;

		try {
			session = openSession();

			LeaveTraineeMaster[] array = new LeaveTraineeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveTraineeMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = leaveTraineeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveTraineeMaster, uuid, companyId, orderByComparator,
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

	protected LeaveTraineeMaster getByUuid_C_PrevAndNext(
		Session session, LeaveTraineeMaster leaveTraineeMaster, String uuid,
		long companyId, OrderByComparator<LeaveTraineeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVETRAINEEMASTER_WHERE);

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
			sb.append(LeaveTraineeMasterModelImpl.ORDER_BY_JPQL);
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
						leaveTraineeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveTraineeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave trainee masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveTraineeMaster leaveTraineeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveTraineeMaster);
		}
	}

	/**
	 * Returns the number of leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave trainee masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVETRAINEEMASTER_WHERE);

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
		"leaveTraineeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveTraineeMaster.uuid IS NULL OR leaveTraineeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveTraineeMaster.companyId = ?";

	public LeaveTraineeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("leaveTraineeMasterId", "leave_trainee_master_id");
		dbColumnNames.put("leaveProgramMasterId", "leave_program_master_id");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put("noOfLeaveTaken", "no_of_leave_taken");
		dbColumnNames.put("noOfLeaveRemaining", "no_of_leave_remaining");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveTraineeMaster.class);

		setModelImplClass(LeaveTraineeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveTraineeMasterTable.INSTANCE);
	}

	/**
	 * Caches the leave trainee master in the entity cache if it is enabled.
	 *
	 * @param leaveTraineeMaster the leave trainee master
	 */
	@Override
	public void cacheResult(LeaveTraineeMaster leaveTraineeMaster) {
		entityCache.putResult(
			LeaveTraineeMasterImpl.class, leaveTraineeMaster.getPrimaryKey(),
			leaveTraineeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				leaveTraineeMaster.getUuid(), leaveTraineeMaster.getGroupId()
			},
			leaveTraineeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave trainee masters in the entity cache if it is enabled.
	 *
	 * @param leaveTraineeMasters the leave trainee masters
	 */
	@Override
	public void cacheResult(List<LeaveTraineeMaster> leaveTraineeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveTraineeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveTraineeMaster leaveTraineeMaster : leaveTraineeMasters) {
			if (entityCache.getResult(
					LeaveTraineeMasterImpl.class,
					leaveTraineeMaster.getPrimaryKey()) == null) {

				cacheResult(leaveTraineeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all leave trainee masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveTraineeMasterImpl.class);

		finderCache.clearCache(LeaveTraineeMasterImpl.class);
	}

	/**
	 * Clears the cache for the leave trainee master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveTraineeMaster leaveTraineeMaster) {
		entityCache.removeResult(
			LeaveTraineeMasterImpl.class, leaveTraineeMaster);
	}

	@Override
	public void clearCache(List<LeaveTraineeMaster> leaveTraineeMasters) {
		for (LeaveTraineeMaster leaveTraineeMaster : leaveTraineeMasters) {
			entityCache.removeResult(
				LeaveTraineeMasterImpl.class, leaveTraineeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveTraineeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveTraineeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveTraineeMasterModelImpl leaveTraineeMasterModelImpl) {

		Object[] args = new Object[] {
			leaveTraineeMasterModelImpl.getUuid(),
			leaveTraineeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveTraineeMasterModelImpl);
	}

	/**
	 * Creates a new leave trainee master with the primary key. Does not add the leave trainee master to the database.
	 *
	 * @param leaveTraineeMasterId the primary key for the new leave trainee master
	 * @return the new leave trainee master
	 */
	@Override
	public LeaveTraineeMaster create(long leaveTraineeMasterId) {
		LeaveTraineeMaster leaveTraineeMaster = new LeaveTraineeMasterImpl();

		leaveTraineeMaster.setNew(true);
		leaveTraineeMaster.setPrimaryKey(leaveTraineeMasterId);

		String uuid = _portalUUID.generate();

		leaveTraineeMaster.setUuid(uuid);

		leaveTraineeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveTraineeMaster;
	}

	/**
	 * Removes the leave trainee master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master that was removed
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	@Override
	public LeaveTraineeMaster remove(long leaveTraineeMasterId)
		throws NoSuchLeaveTraineeMasterException {

		return remove((Serializable)leaveTraineeMasterId);
	}

	/**
	 * Removes the leave trainee master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave trainee master
	 * @return the leave trainee master that was removed
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	@Override
	public LeaveTraineeMaster remove(Serializable primaryKey)
		throws NoSuchLeaveTraineeMasterException {

		Session session = null;

		try {
			session = openSession();

			LeaveTraineeMaster leaveTraineeMaster =
				(LeaveTraineeMaster)session.get(
					LeaveTraineeMasterImpl.class, primaryKey);

			if (leaveTraineeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTraineeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveTraineeMaster);
		}
		catch (NoSuchLeaveTraineeMasterException noSuchEntityException) {
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
	protected LeaveTraineeMaster removeImpl(
		LeaveTraineeMaster leaveTraineeMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveTraineeMaster)) {
				leaveTraineeMaster = (LeaveTraineeMaster)session.get(
					LeaveTraineeMasterImpl.class,
					leaveTraineeMaster.getPrimaryKeyObj());
			}

			if (leaveTraineeMaster != null) {
				session.delete(leaveTraineeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveTraineeMaster != null) {
			clearCache(leaveTraineeMaster);
		}

		return leaveTraineeMaster;
	}

	@Override
	public LeaveTraineeMaster updateImpl(
		LeaveTraineeMaster leaveTraineeMaster) {

		boolean isNew = leaveTraineeMaster.isNew();

		if (!(leaveTraineeMaster instanceof LeaveTraineeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveTraineeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveTraineeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveTraineeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveTraineeMaster implementation " +
					leaveTraineeMaster.getClass());
		}

		LeaveTraineeMasterModelImpl leaveTraineeMasterModelImpl =
			(LeaveTraineeMasterModelImpl)leaveTraineeMaster;

		if (Validator.isNull(leaveTraineeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			leaveTraineeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveTraineeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveTraineeMaster.setCreateDate(date);
			}
			else {
				leaveTraineeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leaveTraineeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveTraineeMaster.setModifiedDate(date);
			}
			else {
				leaveTraineeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveTraineeMaster);
			}
			else {
				leaveTraineeMaster = (LeaveTraineeMaster)session.merge(
					leaveTraineeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveTraineeMasterImpl.class, leaveTraineeMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(leaveTraineeMasterModelImpl);

		if (isNew) {
			leaveTraineeMaster.setNew(false);
		}

		leaveTraineeMaster.resetOriginalValues();

		return leaveTraineeMaster;
	}

	/**
	 * Returns the leave trainee master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave trainee master
	 * @return the leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	@Override
	public LeaveTraineeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTraineeMasterException {

		LeaveTraineeMaster leaveTraineeMaster = fetchByPrimaryKey(primaryKey);

		if (leaveTraineeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTraineeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveTraineeMaster;
	}

	/**
	 * Returns the leave trainee master with the primary key or throws a <code>NoSuchLeaveTraineeMasterException</code> if it could not be found.
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	@Override
	public LeaveTraineeMaster findByPrimaryKey(long leaveTraineeMasterId)
		throws NoSuchLeaveTraineeMasterException {

		return findByPrimaryKey((Serializable)leaveTraineeMasterId);
	}

	/**
	 * Returns the leave trainee master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master, or <code>null</code> if a leave trainee master with the primary key could not be found
	 */
	@Override
	public LeaveTraineeMaster fetchByPrimaryKey(long leaveTraineeMasterId) {
		return fetchByPrimaryKey((Serializable)leaveTraineeMasterId);
	}

	/**
	 * Returns all the leave trainee masters.
	 *
	 * @return the leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave trainee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @return the range of leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave trainee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveTraineeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave trainee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave trainee masters
	 */
	@Override
	public List<LeaveTraineeMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveTraineeMaster> orderByComparator,
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

		List<LeaveTraineeMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveTraineeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVETRAINEEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVETRAINEEMASTER;

				sql = sql.concat(LeaveTraineeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveTraineeMaster>)QueryUtil.list(
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
	 * Removes all the leave trainee masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveTraineeMaster leaveTraineeMaster : findAll()) {
			remove(leaveTraineeMaster);
		}
	}

	/**
	 * Returns the number of leave trainee masters.
	 *
	 * @return the number of leave trainee masters
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
					_SQL_COUNT_LEAVETRAINEEMASTER);

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
		return "leave_trainee_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVETRAINEEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveTraineeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave trainee master persistence.
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

		_setLeaveTraineeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLeaveTraineeMasterUtilPersistence(null);

		entityCache.removeCache(LeaveTraineeMasterImpl.class.getName());
	}

	private void _setLeaveTraineeMasterUtilPersistence(
		LeaveTraineeMasterPersistence leaveTraineeMasterPersistence) {

		try {
			Field field = LeaveTraineeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, leaveTraineeMasterPersistence);
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

	private static final String _SQL_SELECT_LEAVETRAINEEMASTER =
		"SELECT leaveTraineeMaster FROM LeaveTraineeMaster leaveTraineeMaster";

	private static final String _SQL_SELECT_LEAVETRAINEEMASTER_WHERE =
		"SELECT leaveTraineeMaster FROM LeaveTraineeMaster leaveTraineeMaster WHERE ";

	private static final String _SQL_COUNT_LEAVETRAINEEMASTER =
		"SELECT COUNT(leaveTraineeMaster) FROM LeaveTraineeMaster leaveTraineeMaster";

	private static final String _SQL_COUNT_LEAVETRAINEEMASTER_WHERE =
		"SELECT COUNT(leaveTraineeMaster) FROM LeaveTraineeMaster leaveTraineeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveTraineeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveTraineeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveTraineeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveTraineeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "leaveTraineeMasterId", "leaveProgramMasterId", "traineeId",
			"noOfLeaveTaken", "noOfLeaveRemaining", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchLevelTypeMasterException;
import gov.omsb.tms.model.LevelTypeMaster;
import gov.omsb.tms.model.LevelTypeMasterTable;
import gov.omsb.tms.model.impl.LevelTypeMasterImpl;
import gov.omsb.tms.model.impl.LevelTypeMasterModelImpl;
import gov.omsb.tms.service.persistence.LevelTypeMasterPersistence;
import gov.omsb.tms.service.persistence.LevelTypeMasterUtil;
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
 * The persistence implementation for the level type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LevelTypeMasterPersistence.class)
public class LevelTypeMasterPersistenceImpl
	extends BasePersistenceImpl<LevelTypeMaster>
	implements LevelTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LevelTypeMasterUtil</code> to access the level type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LevelTypeMasterImpl.class.getName();

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
	 * Returns all the level type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the level type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the level type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the level type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator,
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

		List<LevelTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<LevelTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LevelTypeMaster levelTypeMaster : list) {
					if (!uuid.equals(levelTypeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_LEVELTYPEMASTER_WHERE);

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
				sb.append(LevelTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<LevelTypeMaster>)QueryUtil.list(
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
	 * Returns the first level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster findByUuid_First(
			String uuid, OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (levelTypeMaster != null) {
			return levelTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLevelTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<LevelTypeMaster> orderByComparator) {

		List<LevelTypeMaster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (levelTypeMaster != null) {
			return levelTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLevelTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<LevelTypeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LevelTypeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the level type masters before and after the current level type master in the ordered set where uuid = &#63;.
	 *
	 * @param LevelTypeMasterId the primary key of the current level type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	@Override
	public LevelTypeMaster[] findByUuid_PrevAndNext(
			long LevelTypeMasterId, String uuid,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		uuid = Objects.toString(uuid, "");

		LevelTypeMaster levelTypeMaster = findByPrimaryKey(LevelTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			LevelTypeMaster[] array = new LevelTypeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, levelTypeMaster, uuid, orderByComparator, true);

			array[1] = levelTypeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, levelTypeMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LevelTypeMaster getByUuid_PrevAndNext(
		Session session, LevelTypeMaster levelTypeMaster, String uuid,
		OrderByComparator<LevelTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_LEVELTYPEMASTER_WHERE);

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
			sb.append(LevelTypeMasterModelImpl.ORDER_BY_JPQL);
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
						levelTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LevelTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the level type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LevelTypeMaster levelTypeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(levelTypeMaster);
		}
	}

	/**
	 * Returns the number of level type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching level type masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEVELTYPEMASTER_WHERE);

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
		"levelTypeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(levelTypeMaster.uuid IS NULL OR levelTypeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLevelTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = fetchByUUID_G(uuid, groupId);

		if (levelTypeMaster == null) {
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

			throw new NoSuchLevelTypeMasterException(sb.toString());
		}

		return levelTypeMaster;
	}

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster fetchByUUID_G(
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

		if (result instanceof LevelTypeMaster) {
			LevelTypeMaster levelTypeMaster = (LevelTypeMaster)result;

			if (!Objects.equals(uuid, levelTypeMaster.getUuid()) ||
				(groupId != levelTypeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEVELTYPEMASTER_WHERE);

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

				List<LevelTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LevelTypeMaster levelTypeMaster = list.get(0);

					result = levelTypeMaster;

					cacheResult(levelTypeMaster);
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
			return (LevelTypeMaster)result;
		}
	}

	/**
	 * Removes the level type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the level type master that was removed
	 */
	@Override
	public LevelTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = findByUUID_G(uuid, groupId);

		return remove(levelTypeMaster);
	}

	/**
	 * Returns the number of level type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching level type masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEVELTYPEMASTER_WHERE);

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
		"levelTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(levelTypeMaster.uuid IS NULL OR levelTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"levelTypeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator,
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

		List<LevelTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<LevelTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LevelTypeMaster levelTypeMaster : list) {
					if (!uuid.equals(levelTypeMaster.getUuid()) ||
						(companyId != levelTypeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEVELTYPEMASTER_WHERE);

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
				sb.append(LevelTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<LevelTypeMaster>)QueryUtil.list(
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
	 * Returns the first level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (levelTypeMaster != null) {
			return levelTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLevelTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		List<LevelTypeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (levelTypeMaster != null) {
			return levelTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLevelTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LevelTypeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the level type masters before and after the current level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param LevelTypeMasterId the primary key of the current level type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	@Override
	public LevelTypeMaster[] findByUuid_C_PrevAndNext(
			long LevelTypeMasterId, String uuid, long companyId,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		uuid = Objects.toString(uuid, "");

		LevelTypeMaster levelTypeMaster = findByPrimaryKey(LevelTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			LevelTypeMaster[] array = new LevelTypeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, levelTypeMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = levelTypeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, levelTypeMaster, uuid, companyId, orderByComparator,
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

	protected LevelTypeMaster getByUuid_C_PrevAndNext(
		Session session, LevelTypeMaster levelTypeMaster, String uuid,
		long companyId, OrderByComparator<LevelTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_LEVELTYPEMASTER_WHERE);

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
			sb.append(LevelTypeMasterModelImpl.ORDER_BY_JPQL);
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
						levelTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LevelTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the level type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LevelTypeMaster levelTypeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(levelTypeMaster);
		}
	}

	/**
	 * Returns the number of level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching level type masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEVELTYPEMASTER_WHERE);

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
		"levelTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(levelTypeMaster.uuid IS NULL OR levelTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"levelTypeMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByLevelTypeNameByLike;
	private FinderPath _finderPathWithPaginationCountByLevelTypeNameByLike;

	/**
	 * Returns all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @return the matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName) {

		return findByLevelTypeNameByLike(
			levelTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param levelTypeName the level type name
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end) {

		return findByLevelTypeNameByLike(levelTypeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param levelTypeName the level type name
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return findByLevelTypeNameByLike(
			levelTypeName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param levelTypeName the level type name
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching level type masters
	 */
	@Override
	public List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator,
		boolean useFinderCache) {

		levelTypeName = Objects.toString(levelTypeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByLevelTypeNameByLike;
		finderArgs = new Object[] {
			levelTypeName, start, end, orderByComparator
		};

		List<LevelTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<LevelTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LevelTypeMaster levelTypeMaster : list) {
					if (!StringUtil.wildcardMatches(
							levelTypeMaster.getLevelTypeName(), levelTypeName,
							'_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_LEVELTYPEMASTER_WHERE);

			boolean bindLevelTypeName = false;

			if (levelTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEVELTYPENAMEBYLIKE_LEVELTYPENAME_3);
			}
			else {
				bindLevelTypeName = true;

				sb.append(_FINDER_COLUMN_LEVELTYPENAMEBYLIKE_LEVELTYPENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LevelTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLevelTypeName) {
					queryPos.add(StringUtil.toLowerCase(levelTypeName));
				}

				list = (List<LevelTypeMaster>)QueryUtil.list(
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
	 * Returns the first level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster findByLevelTypeNameByLike_First(
			String levelTypeName,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = fetchByLevelTypeNameByLike_First(
			levelTypeName, orderByComparator);

		if (levelTypeMaster != null) {
			return levelTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("levelTypeNameLIKE");
		sb.append(levelTypeName);

		sb.append("}");

		throw new NoSuchLevelTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster fetchByLevelTypeNameByLike_First(
		String levelTypeName,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		List<LevelTypeMaster> list = findByLevelTypeNameByLike(
			levelTypeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster findByLevelTypeNameByLike_Last(
			String levelTypeName,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = fetchByLevelTypeNameByLike_Last(
			levelTypeName, orderByComparator);

		if (levelTypeMaster != null) {
			return levelTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("levelTypeNameLIKE");
		sb.append(levelTypeName);

		sb.append("}");

		throw new NoSuchLevelTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public LevelTypeMaster fetchByLevelTypeNameByLike_Last(
		String levelTypeName,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		int count = countByLevelTypeNameByLike(levelTypeName);

		if (count == 0) {
			return null;
		}

		List<LevelTypeMaster> list = findByLevelTypeNameByLike(
			levelTypeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the level type masters before and after the current level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param LevelTypeMasterId the primary key of the current level type master
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	@Override
	public LevelTypeMaster[] findByLevelTypeNameByLike_PrevAndNext(
			long LevelTypeMasterId, String levelTypeName,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws NoSuchLevelTypeMasterException {

		levelTypeName = Objects.toString(levelTypeName, "");

		LevelTypeMaster levelTypeMaster = findByPrimaryKey(LevelTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			LevelTypeMaster[] array = new LevelTypeMasterImpl[3];

			array[0] = getByLevelTypeNameByLike_PrevAndNext(
				session, levelTypeMaster, levelTypeName, orderByComparator,
				true);

			array[1] = levelTypeMaster;

			array[2] = getByLevelTypeNameByLike_PrevAndNext(
				session, levelTypeMaster, levelTypeName, orderByComparator,
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

	protected LevelTypeMaster getByLevelTypeNameByLike_PrevAndNext(
		Session session, LevelTypeMaster levelTypeMaster, String levelTypeName,
		OrderByComparator<LevelTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_LEVELTYPEMASTER_WHERE);

		boolean bindLevelTypeName = false;

		if (levelTypeName.isEmpty()) {
			sb.append(_FINDER_COLUMN_LEVELTYPENAMEBYLIKE_LEVELTYPENAME_3);
		}
		else {
			bindLevelTypeName = true;

			sb.append(_FINDER_COLUMN_LEVELTYPENAMEBYLIKE_LEVELTYPENAME_2);
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
			sb.append(LevelTypeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLevelTypeName) {
			queryPos.add(StringUtil.toLowerCase(levelTypeName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						levelTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LevelTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the level type masters where levelTypeName LIKE &#63; from the database.
	 *
	 * @param levelTypeName the level type name
	 */
	@Override
	public void removeByLevelTypeNameByLike(String levelTypeName) {
		for (LevelTypeMaster levelTypeMaster :
				findByLevelTypeNameByLike(
					levelTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(levelTypeMaster);
		}
	}

	/**
	 * Returns the number of level type masters where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @return the number of matching level type masters
	 */
	@Override
	public int countByLevelTypeNameByLike(String levelTypeName) {
		levelTypeName = Objects.toString(levelTypeName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByLevelTypeNameByLike;

		Object[] finderArgs = new Object[] {levelTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEVELTYPEMASTER_WHERE);

			boolean bindLevelTypeName = false;

			if (levelTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEVELTYPENAMEBYLIKE_LEVELTYPENAME_3);
			}
			else {
				bindLevelTypeName = true;

				sb.append(_FINDER_COLUMN_LEVELTYPENAMEBYLIKE_LEVELTYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLevelTypeName) {
					queryPos.add(StringUtil.toLowerCase(levelTypeName));
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
		_FINDER_COLUMN_LEVELTYPENAMEBYLIKE_LEVELTYPENAME_2 =
			"lower(levelTypeMaster.levelTypeName) LIKE ?";

	private static final String
		_FINDER_COLUMN_LEVELTYPENAMEBYLIKE_LEVELTYPENAME_3 =
			"(levelTypeMaster.levelTypeName IS NULL OR levelTypeMaster.levelTypeName LIKE '')";

	public LevelTypeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("LevelTypeMasterId", "level_type_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("levelTypeName", "level_type_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(LevelTypeMaster.class);

		setModelImplClass(LevelTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(LevelTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the level type master in the entity cache if it is enabled.
	 *
	 * @param levelTypeMaster the level type master
	 */
	@Override
	public void cacheResult(LevelTypeMaster levelTypeMaster) {
		entityCache.putResult(
			LevelTypeMasterImpl.class, levelTypeMaster.getPrimaryKey(),
			levelTypeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				levelTypeMaster.getUuid(), levelTypeMaster.getGroupId()
			},
			levelTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the level type masters in the entity cache if it is enabled.
	 *
	 * @param levelTypeMasters the level type masters
	 */
	@Override
	public void cacheResult(List<LevelTypeMaster> levelTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (levelTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LevelTypeMaster levelTypeMaster : levelTypeMasters) {
			if (entityCache.getResult(
					LevelTypeMasterImpl.class,
					levelTypeMaster.getPrimaryKey()) == null) {

				cacheResult(levelTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all level type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LevelTypeMasterImpl.class);

		finderCache.clearCache(LevelTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the level type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LevelTypeMaster levelTypeMaster) {
		entityCache.removeResult(LevelTypeMasterImpl.class, levelTypeMaster);
	}

	@Override
	public void clearCache(List<LevelTypeMaster> levelTypeMasters) {
		for (LevelTypeMaster levelTypeMaster : levelTypeMasters) {
			entityCache.removeResult(
				LevelTypeMasterImpl.class, levelTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LevelTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LevelTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LevelTypeMasterModelImpl levelTypeMasterModelImpl) {

		Object[] args = new Object[] {
			levelTypeMasterModelImpl.getUuid(),
			levelTypeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, levelTypeMasterModelImpl);
	}

	/**
	 * Creates a new level type master with the primary key. Does not add the level type master to the database.
	 *
	 * @param LevelTypeMasterId the primary key for the new level type master
	 * @return the new level type master
	 */
	@Override
	public LevelTypeMaster create(long LevelTypeMasterId) {
		LevelTypeMaster levelTypeMaster = new LevelTypeMasterImpl();

		levelTypeMaster.setNew(true);
		levelTypeMaster.setPrimaryKey(LevelTypeMasterId);

		String uuid = _portalUUID.generate();

		levelTypeMaster.setUuid(uuid);

		levelTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return levelTypeMaster;
	}

	/**
	 * Removes the level type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master that was removed
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	@Override
	public LevelTypeMaster remove(long LevelTypeMasterId)
		throws NoSuchLevelTypeMasterException {

		return remove((Serializable)LevelTypeMasterId);
	}

	/**
	 * Removes the level type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the level type master
	 * @return the level type master that was removed
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	@Override
	public LevelTypeMaster remove(Serializable primaryKey)
		throws NoSuchLevelTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			LevelTypeMaster levelTypeMaster = (LevelTypeMaster)session.get(
				LevelTypeMasterImpl.class, primaryKey);

			if (levelTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLevelTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(levelTypeMaster);
		}
		catch (NoSuchLevelTypeMasterException noSuchEntityException) {
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
	protected LevelTypeMaster removeImpl(LevelTypeMaster levelTypeMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(levelTypeMaster)) {
				levelTypeMaster = (LevelTypeMaster)session.get(
					LevelTypeMasterImpl.class,
					levelTypeMaster.getPrimaryKeyObj());
			}

			if (levelTypeMaster != null) {
				session.delete(levelTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (levelTypeMaster != null) {
			clearCache(levelTypeMaster);
		}

		return levelTypeMaster;
	}

	@Override
	public LevelTypeMaster updateImpl(LevelTypeMaster levelTypeMaster) {
		boolean isNew = levelTypeMaster.isNew();

		if (!(levelTypeMaster instanceof LevelTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(levelTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					levelTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in levelTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LevelTypeMaster implementation " +
					levelTypeMaster.getClass());
		}

		LevelTypeMasterModelImpl levelTypeMasterModelImpl =
			(LevelTypeMasterModelImpl)levelTypeMaster;

		if (Validator.isNull(levelTypeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			levelTypeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (levelTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				levelTypeMaster.setCreateDate(date);
			}
			else {
				levelTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!levelTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				levelTypeMaster.setModifiedDate(date);
			}
			else {
				levelTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(levelTypeMaster);
			}
			else {
				levelTypeMaster = (LevelTypeMaster)session.merge(
					levelTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LevelTypeMasterImpl.class, levelTypeMasterModelImpl, false, true);

		cacheUniqueFindersCache(levelTypeMasterModelImpl);

		if (isNew) {
			levelTypeMaster.setNew(false);
		}

		levelTypeMaster.resetOriginalValues();

		return levelTypeMaster;
	}

	/**
	 * Returns the level type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the level type master
	 * @return the level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	@Override
	public LevelTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLevelTypeMasterException {

		LevelTypeMaster levelTypeMaster = fetchByPrimaryKey(primaryKey);

		if (levelTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLevelTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return levelTypeMaster;
	}

	/**
	 * Returns the level type master with the primary key or throws a <code>NoSuchLevelTypeMasterException</code> if it could not be found.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	@Override
	public LevelTypeMaster findByPrimaryKey(long LevelTypeMasterId)
		throws NoSuchLevelTypeMasterException {

		return findByPrimaryKey((Serializable)LevelTypeMasterId);
	}

	/**
	 * Returns the level type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master, or <code>null</code> if a level type master with the primary key could not be found
	 */
	@Override
	public LevelTypeMaster fetchByPrimaryKey(long LevelTypeMasterId) {
		return fetchByPrimaryKey((Serializable)LevelTypeMasterId);
	}

	/**
	 * Returns all the level type masters.
	 *
	 * @return the level type masters
	 */
	@Override
	public List<LevelTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the level type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of level type masters
	 */
	@Override
	public List<LevelTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the level type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of level type masters
	 */
	@Override
	public List<LevelTypeMaster> findAll(
		int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the level type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of level type masters
	 */
	@Override
	public List<LevelTypeMaster> findAll(
		int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator,
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

		List<LevelTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<LevelTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEVELTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEVELTYPEMASTER;

				sql = sql.concat(LevelTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LevelTypeMaster>)QueryUtil.list(
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
	 * Removes all the level type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LevelTypeMaster levelTypeMaster : findAll()) {
			remove(levelTypeMaster);
		}
	}

	/**
	 * Returns the number of level type masters.
	 *
	 * @return the number of level type masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEVELTYPEMASTER);

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
		return "level_type_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEVELTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LevelTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the level type master persistence.
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

		_finderPathWithPaginationFindByLevelTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevelTypeNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"level_type_name"}, true);

		_finderPathWithPaginationCountByLevelTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByLevelTypeNameByLike", new String[] {String.class.getName()},
			new String[] {"level_type_name"}, false);

		_setLevelTypeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLevelTypeMasterUtilPersistence(null);

		entityCache.removeCache(LevelTypeMasterImpl.class.getName());
	}

	private void _setLevelTypeMasterUtilPersistence(
		LevelTypeMasterPersistence levelTypeMasterPersistence) {

		try {
			Field field = LevelTypeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, levelTypeMasterPersistence);
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

	private static final String _SQL_SELECT_LEVELTYPEMASTER =
		"SELECT levelTypeMaster FROM LevelTypeMaster levelTypeMaster";

	private static final String _SQL_SELECT_LEVELTYPEMASTER_WHERE =
		"SELECT levelTypeMaster FROM LevelTypeMaster levelTypeMaster WHERE ";

	private static final String _SQL_COUNT_LEVELTYPEMASTER =
		"SELECT COUNT(levelTypeMaster) FROM LevelTypeMaster levelTypeMaster";

	private static final String _SQL_COUNT_LEVELTYPEMASTER_WHERE =
		"SELECT COUNT(levelTypeMaster) FROM LevelTypeMaster levelTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "levelTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LevelTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LevelTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LevelTypeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "LevelTypeMasterId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "levelTypeName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
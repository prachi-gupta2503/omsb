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

import gov.omsb.tms.exception.NoSuchCompetenciesMasterException;
import gov.omsb.tms.model.CompetenciesMaster;
import gov.omsb.tms.model.CompetenciesMasterTable;
import gov.omsb.tms.model.impl.CompetenciesMasterImpl;
import gov.omsb.tms.model.impl.CompetenciesMasterModelImpl;
import gov.omsb.tms.service.persistence.CompetenciesMasterPersistence;
import gov.omsb.tms.service.persistence.CompetenciesMasterUtil;
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
 * The persistence implementation for the competencies master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CompetenciesMasterPersistence.class)
public class CompetenciesMasterPersistenceImpl
	extends BasePersistenceImpl<CompetenciesMaster>
	implements CompetenciesMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CompetenciesMasterUtil</code> to access the competencies master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CompetenciesMasterImpl.class.getName();

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
	 * Returns all the competencies masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of matching competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator,
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

		List<CompetenciesMaster> list = null;

		if (useFinderCache) {
			list = (List<CompetenciesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CompetenciesMaster competenciesMaster : list) {
					if (!uuid.equals(competenciesMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_COMPETENCIESMASTER_WHERE);

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
				sb.append(CompetenciesMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<CompetenciesMaster>)QueryUtil.list(
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
	 * Returns the first competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster findByUuid_First(
			String uuid,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws NoSuchCompetenciesMasterException {

		CompetenciesMaster competenciesMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (competenciesMaster != null) {
			return competenciesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCompetenciesMasterException(sb.toString());
	}

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster fetchByUuid_First(
		String uuid, OrderByComparator<CompetenciesMaster> orderByComparator) {

		List<CompetenciesMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster findByUuid_Last(
			String uuid,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws NoSuchCompetenciesMasterException {

		CompetenciesMaster competenciesMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (competenciesMaster != null) {
			return competenciesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCompetenciesMasterException(sb.toString());
	}

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster fetchByUuid_Last(
		String uuid, OrderByComparator<CompetenciesMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CompetenciesMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the competencies masters before and after the current competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param competenciesMasterId the primary key of the current competencies master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	@Override
	public CompetenciesMaster[] findByUuid_PrevAndNext(
			long competenciesMasterId, String uuid,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws NoSuchCompetenciesMasterException {

		uuid = Objects.toString(uuid, "");

		CompetenciesMaster competenciesMaster = findByPrimaryKey(
			competenciesMasterId);

		Session session = null;

		try {
			session = openSession();

			CompetenciesMaster[] array = new CompetenciesMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, competenciesMaster, uuid, orderByComparator, true);

			array[1] = competenciesMaster;

			array[2] = getByUuid_PrevAndNext(
				session, competenciesMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CompetenciesMaster getByUuid_PrevAndNext(
		Session session, CompetenciesMaster competenciesMaster, String uuid,
		OrderByComparator<CompetenciesMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_COMPETENCIESMASTER_WHERE);

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
			sb.append(CompetenciesMasterModelImpl.ORDER_BY_JPQL);
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
						competenciesMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CompetenciesMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the competencies masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CompetenciesMaster competenciesMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(competenciesMaster);
		}
	}

	/**
	 * Returns the number of competencies masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching competencies masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMPETENCIESMASTER_WHERE);

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
		"competenciesMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(competenciesMaster.uuid IS NULL OR competenciesMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCompetenciesMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchCompetenciesMasterException {

		CompetenciesMaster competenciesMaster = fetchByUUID_G(uuid, groupId);

		if (competenciesMaster == null) {
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

			throw new NoSuchCompetenciesMasterException(sb.toString());
		}

		return competenciesMaster;
	}

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster fetchByUUID_G(
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

		if (result instanceof CompetenciesMaster) {
			CompetenciesMaster competenciesMaster = (CompetenciesMaster)result;

			if (!Objects.equals(uuid, competenciesMaster.getUuid()) ||
				(groupId != competenciesMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMPETENCIESMASTER_WHERE);

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

				List<CompetenciesMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CompetenciesMaster competenciesMaster = list.get(0);

					result = competenciesMaster;

					cacheResult(competenciesMaster);
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
			return (CompetenciesMaster)result;
		}
	}

	/**
	 * Removes the competencies master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the competencies master that was removed
	 */
	@Override
	public CompetenciesMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchCompetenciesMasterException {

		CompetenciesMaster competenciesMaster = findByUUID_G(uuid, groupId);

		return remove(competenciesMaster);
	}

	/**
	 * Returns the number of competencies masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching competencies masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMPETENCIESMASTER_WHERE);

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
		"competenciesMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(competenciesMaster.uuid IS NULL OR competenciesMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"competenciesMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of matching competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator,
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

		List<CompetenciesMaster> list = null;

		if (useFinderCache) {
			list = (List<CompetenciesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CompetenciesMaster competenciesMaster : list) {
					if (!uuid.equals(competenciesMaster.getUuid()) ||
						(companyId != competenciesMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_COMPETENCIESMASTER_WHERE);

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
				sb.append(CompetenciesMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<CompetenciesMaster>)QueryUtil.list(
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
	 * Returns the first competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws NoSuchCompetenciesMasterException {

		CompetenciesMaster competenciesMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (competenciesMaster != null) {
			return competenciesMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCompetenciesMasterException(sb.toString());
	}

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		List<CompetenciesMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws NoSuchCompetenciesMasterException {

		CompetenciesMaster competenciesMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (competenciesMaster != null) {
			return competenciesMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCompetenciesMasterException(sb.toString());
	}

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	@Override
	public CompetenciesMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CompetenciesMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the competencies masters before and after the current competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param competenciesMasterId the primary key of the current competencies master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	@Override
	public CompetenciesMaster[] findByUuid_C_PrevAndNext(
			long competenciesMasterId, String uuid, long companyId,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws NoSuchCompetenciesMasterException {

		uuid = Objects.toString(uuid, "");

		CompetenciesMaster competenciesMaster = findByPrimaryKey(
			competenciesMasterId);

		Session session = null;

		try {
			session = openSession();

			CompetenciesMaster[] array = new CompetenciesMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, competenciesMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = competenciesMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, competenciesMaster, uuid, companyId, orderByComparator,
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

	protected CompetenciesMaster getByUuid_C_PrevAndNext(
		Session session, CompetenciesMaster competenciesMaster, String uuid,
		long companyId, OrderByComparator<CompetenciesMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_COMPETENCIESMASTER_WHERE);

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
			sb.append(CompetenciesMasterModelImpl.ORDER_BY_JPQL);
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
						competenciesMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CompetenciesMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the competencies masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CompetenciesMaster competenciesMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(competenciesMaster);
		}
	}

	/**
	 * Returns the number of competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching competencies masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMPETENCIESMASTER_WHERE);

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
		"competenciesMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(competenciesMaster.uuid IS NULL OR competenciesMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"competenciesMaster.companyId = ?";

	public CompetenciesMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("competenciesMasterId", "competencies_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("competencyName", "competency_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(CompetenciesMaster.class);

		setModelImplClass(CompetenciesMasterImpl.class);
		setModelPKClass(long.class);

		setTable(CompetenciesMasterTable.INSTANCE);
	}

	/**
	 * Caches the competencies master in the entity cache if it is enabled.
	 *
	 * @param competenciesMaster the competencies master
	 */
	@Override
	public void cacheResult(CompetenciesMaster competenciesMaster) {
		entityCache.putResult(
			CompetenciesMasterImpl.class, competenciesMaster.getPrimaryKey(),
			competenciesMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				competenciesMaster.getUuid(), competenciesMaster.getGroupId()
			},
			competenciesMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the competencies masters in the entity cache if it is enabled.
	 *
	 * @param competenciesMasters the competencies masters
	 */
	@Override
	public void cacheResult(List<CompetenciesMaster> competenciesMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (competenciesMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CompetenciesMaster competenciesMaster : competenciesMasters) {
			if (entityCache.getResult(
					CompetenciesMasterImpl.class,
					competenciesMaster.getPrimaryKey()) == null) {

				cacheResult(competenciesMaster);
			}
		}
	}

	/**
	 * Clears the cache for all competencies masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CompetenciesMasterImpl.class);

		finderCache.clearCache(CompetenciesMasterImpl.class);
	}

	/**
	 * Clears the cache for the competencies master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompetenciesMaster competenciesMaster) {
		entityCache.removeResult(
			CompetenciesMasterImpl.class, competenciesMaster);
	}

	@Override
	public void clearCache(List<CompetenciesMaster> competenciesMasters) {
		for (CompetenciesMaster competenciesMaster : competenciesMasters) {
			entityCache.removeResult(
				CompetenciesMasterImpl.class, competenciesMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CompetenciesMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CompetenciesMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CompetenciesMasterModelImpl competenciesMasterModelImpl) {

		Object[] args = new Object[] {
			competenciesMasterModelImpl.getUuid(),
			competenciesMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, competenciesMasterModelImpl);
	}

	/**
	 * Creates a new competencies master with the primary key. Does not add the competencies master to the database.
	 *
	 * @param competenciesMasterId the primary key for the new competencies master
	 * @return the new competencies master
	 */
	@Override
	public CompetenciesMaster create(long competenciesMasterId) {
		CompetenciesMaster competenciesMaster = new CompetenciesMasterImpl();

		competenciesMaster.setNew(true);
		competenciesMaster.setPrimaryKey(competenciesMasterId);

		String uuid = _portalUUID.generate();

		competenciesMaster.setUuid(uuid);

		competenciesMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return competenciesMaster;
	}

	/**
	 * Removes the competencies master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master that was removed
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	@Override
	public CompetenciesMaster remove(long competenciesMasterId)
		throws NoSuchCompetenciesMasterException {

		return remove((Serializable)competenciesMasterId);
	}

	/**
	 * Removes the competencies master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the competencies master
	 * @return the competencies master that was removed
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	@Override
	public CompetenciesMaster remove(Serializable primaryKey)
		throws NoSuchCompetenciesMasterException {

		Session session = null;

		try {
			session = openSession();

			CompetenciesMaster competenciesMaster =
				(CompetenciesMaster)session.get(
					CompetenciesMasterImpl.class, primaryKey);

			if (competenciesMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompetenciesMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(competenciesMaster);
		}
		catch (NoSuchCompetenciesMasterException noSuchEntityException) {
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
	protected CompetenciesMaster removeImpl(
		CompetenciesMaster competenciesMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(competenciesMaster)) {
				competenciesMaster = (CompetenciesMaster)session.get(
					CompetenciesMasterImpl.class,
					competenciesMaster.getPrimaryKeyObj());
			}

			if (competenciesMaster != null) {
				session.delete(competenciesMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (competenciesMaster != null) {
			clearCache(competenciesMaster);
		}

		return competenciesMaster;
	}

	@Override
	public CompetenciesMaster updateImpl(
		CompetenciesMaster competenciesMaster) {

		boolean isNew = competenciesMaster.isNew();

		if (!(competenciesMaster instanceof CompetenciesMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(competenciesMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					competenciesMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in competenciesMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CompetenciesMaster implementation " +
					competenciesMaster.getClass());
		}

		CompetenciesMasterModelImpl competenciesMasterModelImpl =
			(CompetenciesMasterModelImpl)competenciesMaster;

		if (Validator.isNull(competenciesMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			competenciesMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (competenciesMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				competenciesMaster.setCreateDate(date);
			}
			else {
				competenciesMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!competenciesMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				competenciesMaster.setModifiedDate(date);
			}
			else {
				competenciesMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(competenciesMaster);
			}
			else {
				competenciesMaster = (CompetenciesMaster)session.merge(
					competenciesMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CompetenciesMasterImpl.class, competenciesMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(competenciesMasterModelImpl);

		if (isNew) {
			competenciesMaster.setNew(false);
		}

		competenciesMaster.resetOriginalValues();

		return competenciesMaster;
	}

	/**
	 * Returns the competencies master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the competencies master
	 * @return the competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	@Override
	public CompetenciesMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompetenciesMasterException {

		CompetenciesMaster competenciesMaster = fetchByPrimaryKey(primaryKey);

		if (competenciesMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompetenciesMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return competenciesMaster;
	}

	/**
	 * Returns the competencies master with the primary key or throws a <code>NoSuchCompetenciesMasterException</code> if it could not be found.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	@Override
	public CompetenciesMaster findByPrimaryKey(long competenciesMasterId)
		throws NoSuchCompetenciesMasterException {

		return findByPrimaryKey((Serializable)competenciesMasterId);
	}

	/**
	 * Returns the competencies master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master, or <code>null</code> if a competencies master with the primary key could not be found
	 */
	@Override
	public CompetenciesMaster fetchByPrimaryKey(long competenciesMasterId) {
		return fetchByPrimaryKey((Serializable)competenciesMasterId);
	}

	/**
	 * Returns all the competencies masters.
	 *
	 * @return the competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findAll(
		int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of competencies masters
	 */
	@Override
	public List<CompetenciesMaster> findAll(
		int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator,
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

		List<CompetenciesMaster> list = null;

		if (useFinderCache) {
			list = (List<CompetenciesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMPETENCIESMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMPETENCIESMASTER;

				sql = sql.concat(CompetenciesMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CompetenciesMaster>)QueryUtil.list(
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
	 * Removes all the competencies masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CompetenciesMaster competenciesMaster : findAll()) {
			remove(competenciesMaster);
		}
	}

	/**
	 * Returns the number of competencies masters.
	 *
	 * @return the number of competencies masters
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
					_SQL_COUNT_COMPETENCIESMASTER);

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
		return "competencies_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMPETENCIESMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CompetenciesMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the competencies master persistence.
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

		_setCompetenciesMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCompetenciesMasterUtilPersistence(null);

		entityCache.removeCache(CompetenciesMasterImpl.class.getName());
	}

	private void _setCompetenciesMasterUtilPersistence(
		CompetenciesMasterPersistence competenciesMasterPersistence) {

		try {
			Field field = CompetenciesMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, competenciesMasterPersistence);
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

	private static final String _SQL_SELECT_COMPETENCIESMASTER =
		"SELECT competenciesMaster FROM CompetenciesMaster competenciesMaster";

	private static final String _SQL_SELECT_COMPETENCIESMASTER_WHERE =
		"SELECT competenciesMaster FROM CompetenciesMaster competenciesMaster WHERE ";

	private static final String _SQL_COUNT_COMPETENCIESMASTER =
		"SELECT COUNT(competenciesMaster) FROM CompetenciesMaster competenciesMaster";

	private static final String _SQL_COUNT_COMPETENCIESMASTER_WHERE =
		"SELECT COUNT(competenciesMaster) FROM CompetenciesMaster competenciesMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "competenciesMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CompetenciesMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CompetenciesMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CompetenciesMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "competenciesMasterId", "groupId", "companyId",
			"createDate", "modifiedDate", "competencyName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
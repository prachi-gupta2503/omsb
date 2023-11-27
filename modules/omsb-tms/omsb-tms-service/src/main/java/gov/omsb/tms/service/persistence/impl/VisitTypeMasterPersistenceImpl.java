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

import gov.omsb.tms.exception.NoSuchVisitTypeMasterException;
import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.model.VisitTypeMasterTable;
import gov.omsb.tms.model.impl.VisitTypeMasterImpl;
import gov.omsb.tms.model.impl.VisitTypeMasterModelImpl;
import gov.omsb.tms.service.persistence.VisitTypeMasterPersistence;
import gov.omsb.tms.service.persistence.VisitTypeMasterUtil;
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
 * The persistence implementation for the visit type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VisitTypeMasterPersistence.class)
public class VisitTypeMasterPersistenceImpl
	extends BasePersistenceImpl<VisitTypeMaster>
	implements VisitTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VisitTypeMasterUtil</code> to access the visit type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VisitTypeMasterImpl.class.getName();

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
	 * Returns all the visit type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator,
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

		List<VisitTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<VisitTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VisitTypeMaster visitTypeMaster : list) {
					if (!uuid.equals(visitTypeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_VISITTYPEMASTER_WHERE);

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
				sb.append(VisitTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<VisitTypeMaster>)QueryUtil.list(
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
	 * Returns the first visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster findByUuid_First(
			String uuid, OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (visitTypeMaster != null) {
			return visitTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVisitTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<VisitTypeMaster> orderByComparator) {

		List<VisitTypeMaster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (visitTypeMaster != null) {
			return visitTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVisitTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<VisitTypeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<VisitTypeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	@Override
	public VisitTypeMaster[] findByUuid_PrevAndNext(
			long visitTypeMasterId, String uuid,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		uuid = Objects.toString(uuid, "");

		VisitTypeMaster visitTypeMaster = findByPrimaryKey(visitTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			VisitTypeMaster[] array = new VisitTypeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, visitTypeMaster, uuid, orderByComparator, true);

			array[1] = visitTypeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, visitTypeMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected VisitTypeMaster getByUuid_PrevAndNext(
		Session session, VisitTypeMaster visitTypeMaster, String uuid,
		OrderByComparator<VisitTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_VISITTYPEMASTER_WHERE);

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
			sb.append(VisitTypeMasterModelImpl.ORDER_BY_JPQL);
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
						visitTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VisitTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (VisitTypeMaster visitTypeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visitTypeMaster);
		}
	}

	/**
	 * Returns the number of visit type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching visit type masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISITTYPEMASTER_WHERE);

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
		"visitTypeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(visitTypeMaster.uuid IS NULL OR visitTypeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVisitTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = fetchByUUID_G(uuid, groupId);

		if (visitTypeMaster == null) {
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

			throw new NoSuchVisitTypeMasterException(sb.toString());
		}

		return visitTypeMaster;
	}

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster fetchByUUID_G(
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

		if (result instanceof VisitTypeMaster) {
			VisitTypeMaster visitTypeMaster = (VisitTypeMaster)result;

			if (!Objects.equals(uuid, visitTypeMaster.getUuid()) ||
				(groupId != visitTypeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VISITTYPEMASTER_WHERE);

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

				List<VisitTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					VisitTypeMaster visitTypeMaster = list.get(0);

					result = visitTypeMaster;

					cacheResult(visitTypeMaster);
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
			return (VisitTypeMaster)result;
		}
	}

	/**
	 * Removes the visit type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the visit type master that was removed
	 */
	@Override
	public VisitTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = findByUUID_G(uuid, groupId);

		return remove(visitTypeMaster);
	}

	/**
	 * Returns the number of visit type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching visit type masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISITTYPEMASTER_WHERE);

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
		"visitTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(visitTypeMaster.uuid IS NULL OR visitTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"visitTypeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator,
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

		List<VisitTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<VisitTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VisitTypeMaster visitTypeMaster : list) {
					if (!uuid.equals(visitTypeMaster.getUuid()) ||
						(companyId != visitTypeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_VISITTYPEMASTER_WHERE);

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
				sb.append(VisitTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<VisitTypeMaster>)QueryUtil.list(
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
	 * Returns the first visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (visitTypeMaster != null) {
			return visitTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVisitTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		List<VisitTypeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (visitTypeMaster != null) {
			return visitTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVisitTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<VisitTypeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	@Override
	public VisitTypeMaster[] findByUuid_C_PrevAndNext(
			long visitTypeMasterId, String uuid, long companyId,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		uuid = Objects.toString(uuid, "");

		VisitTypeMaster visitTypeMaster = findByPrimaryKey(visitTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			VisitTypeMaster[] array = new VisitTypeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, visitTypeMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = visitTypeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, visitTypeMaster, uuid, companyId, orderByComparator,
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

	protected VisitTypeMaster getByUuid_C_PrevAndNext(
		Session session, VisitTypeMaster visitTypeMaster, String uuid,
		long companyId, OrderByComparator<VisitTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_VISITTYPEMASTER_WHERE);

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
			sb.append(VisitTypeMasterModelImpl.ORDER_BY_JPQL);
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
						visitTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VisitTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (VisitTypeMaster visitTypeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(visitTypeMaster);
		}
	}

	/**
	 * Returns the number of visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching visit type masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISITTYPEMASTER_WHERE);

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
		"visitTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(visitTypeMaster.uuid IS NULL OR visitTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"visitTypeMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByVisitTypeNameByLike;
	private FinderPath _finderPathWithPaginationCountByVisitTypeNameByLike;

	/**
	 * Returns all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @return the matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName) {

		return findByVisitTypeNameByLike(
			visitTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end) {

		return findByVisitTypeNameByLike(visitTypeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return findByVisitTypeNameByLike(
			visitTypeName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator,
		boolean useFinderCache) {

		visitTypeName = Objects.toString(visitTypeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByVisitTypeNameByLike;
		finderArgs = new Object[] {
			visitTypeName, start, end, orderByComparator
		};

		List<VisitTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<VisitTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VisitTypeMaster visitTypeMaster : list) {
					if (!StringUtil.wildcardMatches(
							visitTypeMaster.getVisitTypeName(), visitTypeName,
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

			sb.append(_SQL_SELECT_VISITTYPEMASTER_WHERE);

			boolean bindVisitTypeName = false;

			if (visitTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_VISITTYPENAMEBYLIKE_VISITTYPENAME_3);
			}
			else {
				bindVisitTypeName = true;

				sb.append(_FINDER_COLUMN_VISITTYPENAMEBYLIKE_VISITTYPENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisitTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVisitTypeName) {
					queryPos.add(StringUtil.toLowerCase(visitTypeName));
				}

				list = (List<VisitTypeMaster>)QueryUtil.list(
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
	 * Returns the first visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster findByVisitTypeNameByLike_First(
			String visitTypeName,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = fetchByVisitTypeNameByLike_First(
			visitTypeName, orderByComparator);

		if (visitTypeMaster != null) {
			return visitTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visitTypeNameLIKE");
		sb.append(visitTypeName);

		sb.append("}");

		throw new NoSuchVisitTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster fetchByVisitTypeNameByLike_First(
		String visitTypeName,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		List<VisitTypeMaster> list = findByVisitTypeNameByLike(
			visitTypeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster findByVisitTypeNameByLike_Last(
			String visitTypeName,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = fetchByVisitTypeNameByLike_Last(
			visitTypeName, orderByComparator);

		if (visitTypeMaster != null) {
			return visitTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visitTypeNameLIKE");
		sb.append(visitTypeName);

		sb.append("}");

		throw new NoSuchVisitTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public VisitTypeMaster fetchByVisitTypeNameByLike_Last(
		String visitTypeName,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		int count = countByVisitTypeNameByLike(visitTypeName);

		if (count == 0) {
			return null;
		}

		List<VisitTypeMaster> list = findByVisitTypeNameByLike(
			visitTypeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	@Override
	public VisitTypeMaster[] findByVisitTypeNameByLike_PrevAndNext(
			long visitTypeMasterId, String visitTypeName,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws NoSuchVisitTypeMasterException {

		visitTypeName = Objects.toString(visitTypeName, "");

		VisitTypeMaster visitTypeMaster = findByPrimaryKey(visitTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			VisitTypeMaster[] array = new VisitTypeMasterImpl[3];

			array[0] = getByVisitTypeNameByLike_PrevAndNext(
				session, visitTypeMaster, visitTypeName, orderByComparator,
				true);

			array[1] = visitTypeMaster;

			array[2] = getByVisitTypeNameByLike_PrevAndNext(
				session, visitTypeMaster, visitTypeName, orderByComparator,
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

	protected VisitTypeMaster getByVisitTypeNameByLike_PrevAndNext(
		Session session, VisitTypeMaster visitTypeMaster, String visitTypeName,
		OrderByComparator<VisitTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_VISITTYPEMASTER_WHERE);

		boolean bindVisitTypeName = false;

		if (visitTypeName.isEmpty()) {
			sb.append(_FINDER_COLUMN_VISITTYPENAMEBYLIKE_VISITTYPENAME_3);
		}
		else {
			bindVisitTypeName = true;

			sb.append(_FINDER_COLUMN_VISITTYPENAMEBYLIKE_VISITTYPENAME_2);
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
			sb.append(VisitTypeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindVisitTypeName) {
			queryPos.add(StringUtil.toLowerCase(visitTypeName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						visitTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VisitTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit type masters where visitTypeName LIKE &#63; from the database.
	 *
	 * @param visitTypeName the visit type name
	 */
	@Override
	public void removeByVisitTypeNameByLike(String visitTypeName) {
		for (VisitTypeMaster visitTypeMaster :
				findByVisitTypeNameByLike(
					visitTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(visitTypeMaster);
		}
	}

	/**
	 * Returns the number of visit type masters where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @return the number of matching visit type masters
	 */
	@Override
	public int countByVisitTypeNameByLike(String visitTypeName) {
		visitTypeName = Objects.toString(visitTypeName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByVisitTypeNameByLike;

		Object[] finderArgs = new Object[] {visitTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISITTYPEMASTER_WHERE);

			boolean bindVisitTypeName = false;

			if (visitTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_VISITTYPENAMEBYLIKE_VISITTYPENAME_3);
			}
			else {
				bindVisitTypeName = true;

				sb.append(_FINDER_COLUMN_VISITTYPENAMEBYLIKE_VISITTYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVisitTypeName) {
					queryPos.add(StringUtil.toLowerCase(visitTypeName));
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
		_FINDER_COLUMN_VISITTYPENAMEBYLIKE_VISITTYPENAME_2 =
			"lower(visitTypeMaster.visitTypeName) LIKE ?";

	private static final String
		_FINDER_COLUMN_VISITTYPENAMEBYLIKE_VISITTYPENAME_3 =
			"(visitTypeMaster.visitTypeName IS NULL OR visitTypeMaster.visitTypeName LIKE '')";

	public VisitTypeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("visitTypeMasterId", "visit_type_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("visitTypeName", "visit_type_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(VisitTypeMaster.class);

		setModelImplClass(VisitTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(VisitTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the visit type master in the entity cache if it is enabled.
	 *
	 * @param visitTypeMaster the visit type master
	 */
	@Override
	public void cacheResult(VisitTypeMaster visitTypeMaster) {
		entityCache.putResult(
			VisitTypeMasterImpl.class, visitTypeMaster.getPrimaryKey(),
			visitTypeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				visitTypeMaster.getUuid(), visitTypeMaster.getGroupId()
			},
			visitTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the visit type masters in the entity cache if it is enabled.
	 *
	 * @param visitTypeMasters the visit type masters
	 */
	@Override
	public void cacheResult(List<VisitTypeMaster> visitTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (visitTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (VisitTypeMaster visitTypeMaster : visitTypeMasters) {
			if (entityCache.getResult(
					VisitTypeMasterImpl.class,
					visitTypeMaster.getPrimaryKey()) == null) {

				cacheResult(visitTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all visit type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VisitTypeMasterImpl.class);

		finderCache.clearCache(VisitTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the visit type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VisitTypeMaster visitTypeMaster) {
		entityCache.removeResult(VisitTypeMasterImpl.class, visitTypeMaster);
	}

	@Override
	public void clearCache(List<VisitTypeMaster> visitTypeMasters) {
		for (VisitTypeMaster visitTypeMaster : visitTypeMasters) {
			entityCache.removeResult(
				VisitTypeMasterImpl.class, visitTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VisitTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VisitTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		VisitTypeMasterModelImpl visitTypeMasterModelImpl) {

		Object[] args = new Object[] {
			visitTypeMasterModelImpl.getUuid(),
			visitTypeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, visitTypeMasterModelImpl);
	}

	/**
	 * Creates a new visit type master with the primary key. Does not add the visit type master to the database.
	 *
	 * @param visitTypeMasterId the primary key for the new visit type master
	 * @return the new visit type master
	 */
	@Override
	public VisitTypeMaster create(long visitTypeMasterId) {
		VisitTypeMaster visitTypeMaster = new VisitTypeMasterImpl();

		visitTypeMaster.setNew(true);
		visitTypeMaster.setPrimaryKey(visitTypeMasterId);

		String uuid = _portalUUID.generate();

		visitTypeMaster.setUuid(uuid);

		visitTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return visitTypeMaster;
	}

	/**
	 * Removes the visit type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master that was removed
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	@Override
	public VisitTypeMaster remove(long visitTypeMasterId)
		throws NoSuchVisitTypeMasterException {

		return remove((Serializable)visitTypeMasterId);
	}

	/**
	 * Removes the visit type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visit type master
	 * @return the visit type master that was removed
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	@Override
	public VisitTypeMaster remove(Serializable primaryKey)
		throws NoSuchVisitTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			VisitTypeMaster visitTypeMaster = (VisitTypeMaster)session.get(
				VisitTypeMasterImpl.class, primaryKey);

			if (visitTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisitTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(visitTypeMaster);
		}
		catch (NoSuchVisitTypeMasterException noSuchEntityException) {
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
	protected VisitTypeMaster removeImpl(VisitTypeMaster visitTypeMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(visitTypeMaster)) {
				visitTypeMaster = (VisitTypeMaster)session.get(
					VisitTypeMasterImpl.class,
					visitTypeMaster.getPrimaryKeyObj());
			}

			if (visitTypeMaster != null) {
				session.delete(visitTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (visitTypeMaster != null) {
			clearCache(visitTypeMaster);
		}

		return visitTypeMaster;
	}

	@Override
	public VisitTypeMaster updateImpl(VisitTypeMaster visitTypeMaster) {
		boolean isNew = visitTypeMaster.isNew();

		if (!(visitTypeMaster instanceof VisitTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(visitTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					visitTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in visitTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VisitTypeMaster implementation " +
					visitTypeMaster.getClass());
		}

		VisitTypeMasterModelImpl visitTypeMasterModelImpl =
			(VisitTypeMasterModelImpl)visitTypeMaster;

		if (Validator.isNull(visitTypeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			visitTypeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (visitTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				visitTypeMaster.setCreateDate(date);
			}
			else {
				visitTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!visitTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				visitTypeMaster.setModifiedDate(date);
			}
			else {
				visitTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(visitTypeMaster);
			}
			else {
				visitTypeMaster = (VisitTypeMaster)session.merge(
					visitTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VisitTypeMasterImpl.class, visitTypeMasterModelImpl, false, true);

		cacheUniqueFindersCache(visitTypeMasterModelImpl);

		if (isNew) {
			visitTypeMaster.setNew(false);
		}

		visitTypeMaster.resetOriginalValues();

		return visitTypeMaster;
	}

	/**
	 * Returns the visit type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit type master
	 * @return the visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	@Override
	public VisitTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVisitTypeMasterException {

		VisitTypeMaster visitTypeMaster = fetchByPrimaryKey(primaryKey);

		if (visitTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVisitTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return visitTypeMaster;
	}

	/**
	 * Returns the visit type master with the primary key or throws a <code>NoSuchVisitTypeMasterException</code> if it could not be found.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	@Override
	public VisitTypeMaster findByPrimaryKey(long visitTypeMasterId)
		throws NoSuchVisitTypeMasterException {

		return findByPrimaryKey((Serializable)visitTypeMasterId);
	}

	/**
	 * Returns the visit type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master, or <code>null</code> if a visit type master with the primary key could not be found
	 */
	@Override
	public VisitTypeMaster fetchByPrimaryKey(long visitTypeMasterId) {
		return fetchByPrimaryKey((Serializable)visitTypeMasterId);
	}

	/**
	 * Returns all the visit type masters.
	 *
	 * @return the visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findAll(
		int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visit type masters
	 */
	@Override
	public List<VisitTypeMaster> findAll(
		int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator,
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

		List<VisitTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<VisitTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VISITTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VISITTYPEMASTER;

				sql = sql.concat(VisitTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<VisitTypeMaster>)QueryUtil.list(
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
	 * Removes all the visit type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VisitTypeMaster visitTypeMaster : findAll()) {
			remove(visitTypeMaster);
		}
	}

	/**
	 * Returns the number of visit type masters.
	 *
	 * @return the number of visit type masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VISITTYPEMASTER);

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
		return "visit_type_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VISITTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VisitTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the visit type master persistence.
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

		_finderPathWithPaginationFindByVisitTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisitTypeNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"visit_type_name"}, true);

		_finderPathWithPaginationCountByVisitTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByVisitTypeNameByLike", new String[] {String.class.getName()},
			new String[] {"visit_type_name"}, false);

		_setVisitTypeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setVisitTypeMasterUtilPersistence(null);

		entityCache.removeCache(VisitTypeMasterImpl.class.getName());
	}

	private void _setVisitTypeMasterUtilPersistence(
		VisitTypeMasterPersistence visitTypeMasterPersistence) {

		try {
			Field field = VisitTypeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, visitTypeMasterPersistence);
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

	private static final String _SQL_SELECT_VISITTYPEMASTER =
		"SELECT visitTypeMaster FROM VisitTypeMaster visitTypeMaster";

	private static final String _SQL_SELECT_VISITTYPEMASTER_WHERE =
		"SELECT visitTypeMaster FROM VisitTypeMaster visitTypeMaster WHERE ";

	private static final String _SQL_COUNT_VISITTYPEMASTER =
		"SELECT COUNT(visitTypeMaster) FROM VisitTypeMaster visitTypeMaster";

	private static final String _SQL_COUNT_VISITTYPEMASTER_WHERE =
		"SELECT COUNT(visitTypeMaster) FROM VisitTypeMaster visitTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "visitTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VisitTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No VisitTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VisitTypeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "visitTypeMasterId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "visitTypeName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
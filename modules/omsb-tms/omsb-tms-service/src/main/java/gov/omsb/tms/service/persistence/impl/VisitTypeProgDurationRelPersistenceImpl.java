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

import gov.omsb.tms.exception.NoSuchVisitTypeProgDurationRelException;
import gov.omsb.tms.model.VisitTypeProgDurationRel;
import gov.omsb.tms.model.VisitTypeProgDurationRelTable;
import gov.omsb.tms.model.impl.VisitTypeProgDurationRelImpl;
import gov.omsb.tms.model.impl.VisitTypeProgDurationRelModelImpl;
import gov.omsb.tms.service.persistence.VisitTypeProgDurationRelPersistence;
import gov.omsb.tms.service.persistence.VisitTypeProgDurationRelUtil;
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
 * The persistence implementation for the visit type prog duration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VisitTypeProgDurationRelPersistence.class)
public class VisitTypeProgDurationRelPersistenceImpl
	extends BasePersistenceImpl<VisitTypeProgDurationRel>
	implements VisitTypeProgDurationRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VisitTypeProgDurationRelUtil</code> to access the visit type prog duration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VisitTypeProgDurationRelImpl.class.getName();

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
	 * Returns all the visit type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visit type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator,
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

		List<VisitTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<VisitTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VisitTypeProgDurationRel visitTypeProgDurationRel : list) {
					if (!uuid.equals(visitTypeProgDurationRel.getUuid())) {
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

			sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE);

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
				sb.append(VisitTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<VisitTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByUuid_First(
			String uuid,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel = fetchByUuid_First(
			uuid, orderByComparator);

		if (visitTypeProgDurationRel != null) {
			return visitTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVisitTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		List<VisitTypeProgDurationRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel = fetchByUuid_Last(
			uuid, orderByComparator);

		if (visitTypeProgDurationRel != null) {
			return visitTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVisitTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<VisitTypeProgDurationRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit type prog duration rels before and after the current visit type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the current visit type prog duration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public VisitTypeProgDurationRel[] findByUuid_PrevAndNext(
			long VisitTypeProgDurationRelId, String uuid,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		uuid = Objects.toString(uuid, "");

		VisitTypeProgDurationRel visitTypeProgDurationRel = findByPrimaryKey(
			VisitTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			VisitTypeProgDurationRel[] array =
				new VisitTypeProgDurationRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, visitTypeProgDurationRel, uuid, orderByComparator,
				true);

			array[1] = visitTypeProgDurationRel;

			array[2] = getByUuid_PrevAndNext(
				session, visitTypeProgDurationRel, uuid, orderByComparator,
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

	protected VisitTypeProgDurationRel getByUuid_PrevAndNext(
		Session session, VisitTypeProgDurationRel visitTypeProgDurationRel,
		String uuid,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE);

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
			sb.append(VisitTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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
						visitTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VisitTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit type prog duration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (VisitTypeProgDurationRel visitTypeProgDurationRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visitTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of visit type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching visit type prog duration rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISITTYPEPROGDURATIONREL_WHERE);

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
		"visitTypeProgDurationRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(visitTypeProgDurationRel.uuid IS NULL OR visitTypeProgDurationRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the visit type prog duration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVisitTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel = fetchByUUID_G(
			uuid, groupId);

		if (visitTypeProgDurationRel == null) {
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

			throw new NoSuchVisitTypeProgDurationRelException(sb.toString());
		}

		return visitTypeProgDurationRel;
	}

	/**
	 * Returns the visit type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the visit type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByUUID_G(
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

		if (result instanceof VisitTypeProgDurationRel) {
			VisitTypeProgDurationRel visitTypeProgDurationRel =
				(VisitTypeProgDurationRel)result;

			if (!Objects.equals(uuid, visitTypeProgDurationRel.getUuid()) ||
				(groupId != visitTypeProgDurationRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE);

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

				List<VisitTypeProgDurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					VisitTypeProgDurationRel visitTypeProgDurationRel =
						list.get(0);

					result = visitTypeProgDurationRel;

					cacheResult(visitTypeProgDurationRel);
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
			return (VisitTypeProgDurationRel)result;
		}
	}

	/**
	 * Removes the visit type prog duration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the visit type prog duration rel that was removed
	 */
	@Override
	public VisitTypeProgDurationRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel = findByUUID_G(
			uuid, groupId);

		return remove(visitTypeProgDurationRel);
	}

	/**
	 * Returns the number of visit type prog duration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching visit type prog duration rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISITTYPEPROGDURATIONREL_WHERE);

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
		"visitTypeProgDurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(visitTypeProgDurationRel.uuid IS NULL OR visitTypeProgDurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"visitTypeProgDurationRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator,
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

		List<VisitTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<VisitTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VisitTypeProgDurationRel visitTypeProgDurationRel : list) {
					if (!uuid.equals(visitTypeProgDurationRel.getUuid()) ||
						(companyId !=
							visitTypeProgDurationRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE);

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
				sb.append(VisitTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<VisitTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (visitTypeProgDurationRel != null) {
			return visitTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVisitTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		List<VisitTypeProgDurationRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (visitTypeProgDurationRel != null) {
			return visitTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVisitTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<VisitTypeProgDurationRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit type prog duration rels before and after the current visit type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the current visit type prog duration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public VisitTypeProgDurationRel[] findByUuid_C_PrevAndNext(
			long VisitTypeProgDurationRelId, String uuid, long companyId,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		uuid = Objects.toString(uuid, "");

		VisitTypeProgDurationRel visitTypeProgDurationRel = findByPrimaryKey(
			VisitTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			VisitTypeProgDurationRel[] array =
				new VisitTypeProgDurationRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, visitTypeProgDurationRel, uuid, companyId,
				orderByComparator, true);

			array[1] = visitTypeProgDurationRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, visitTypeProgDurationRel, uuid, companyId,
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

	protected VisitTypeProgDurationRel getByUuid_C_PrevAndNext(
		Session session, VisitTypeProgDurationRel visitTypeProgDurationRel,
		String uuid, long companyId,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE);

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
			sb.append(VisitTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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
						visitTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VisitTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit type prog duration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (VisitTypeProgDurationRel visitTypeProgDurationRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(visitTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of visit type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching visit type prog duration rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISITTYPEPROGDURATIONREL_WHERE);

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
		"visitTypeProgDurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(visitTypeProgDurationRel.uuid IS NULL OR visitTypeProgDurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"visitTypeProgDurationRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the visit type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visit type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgramDurationId;
				finderArgs = new Object[] {programDurationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProgramDurationId;
			finderArgs = new Object[] {
				programDurationId, start, end, orderByComparator
			};
		}

		List<VisitTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<VisitTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VisitTypeProgDurationRel visitTypeProgDurationRel : list) {
					if (programDurationId !=
							visitTypeProgDurationRel.getProgramDurationId()) {

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

			sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisitTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				list = (List<VisitTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel =
			fetchByProgramDurationId_First(
				programDurationId, orderByComparator);

		if (visitTypeProgDurationRel != null) {
			return visitTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchVisitTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		List<VisitTypeProgDurationRel> list = findByProgramDurationId(
			programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel =
			fetchByProgramDurationId_Last(programDurationId, orderByComparator);

		if (visitTypeProgDurationRel != null) {
			return visitTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchVisitTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<VisitTypeProgDurationRel> list = findByProgramDurationId(
			programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit type prog duration rels before and after the current visit type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the current visit type prog duration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public VisitTypeProgDurationRel[] findByProgramDurationId_PrevAndNext(
			long VisitTypeProgDurationRelId, long programDurationId,
			OrderByComparator<VisitTypeProgDurationRel> orderByComparator)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel = findByPrimaryKey(
			VisitTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			VisitTypeProgDurationRel[] array =
				new VisitTypeProgDurationRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, visitTypeProgDurationRel, programDurationId,
				orderByComparator, true);

			array[1] = visitTypeProgDurationRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, visitTypeProgDurationRel, programDurationId,
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

	protected VisitTypeProgDurationRel getByProgramDurationId_PrevAndNext(
		Session session, VisitTypeProgDurationRel visitTypeProgDurationRel,
		long programDurationId,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE);

		sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

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
			sb.append(VisitTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programDurationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						visitTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VisitTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visit type prog duration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (VisitTypeProgDurationRel visitTypeProgDurationRel :
				findByProgramDurationId(
					programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(visitTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of visit type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching visit type prog duration rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISITTYPEPROGDURATIONREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

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
		_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2 =
			"visitTypeProgDurationRel.programDurationId = ?";

	private FinderPath _finderPathFetchByProgramDurationIdAndVisitTypeMasterId;
	private FinderPath _finderPathCountByProgramDurationIdAndVisitTypeMasterId;

	/**
	 * Returns the visit type prog duration rel where programDurationId = &#63; and visitTypeMasterId = &#63; or throws a <code>NoSuchVisitTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @return the matching visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByProgramDurationIdAndVisitTypeMasterId(
			long programDurationId, long visitTypeMasterId)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel =
			fetchByProgramDurationIdAndVisitTypeMasterId(
				programDurationId, visitTypeMasterId);

		if (visitTypeProgDurationRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programDurationId=");
			sb.append(programDurationId);

			sb.append(", visitTypeMasterId=");
			sb.append(visitTypeMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchVisitTypeProgDurationRelException(sb.toString());
		}

		return visitTypeProgDurationRel;
	}

	/**
	 * Returns the visit type prog duration rel where programDurationId = &#63; and visitTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel
		fetchByProgramDurationIdAndVisitTypeMasterId(
			long programDurationId, long visitTypeMasterId) {

		return fetchByProgramDurationIdAndVisitTypeMasterId(
			programDurationId, visitTypeMasterId, true);
	}

	/**
	 * Returns the visit type prog duration rel where programDurationId = &#63; and visitTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public VisitTypeProgDurationRel
		fetchByProgramDurationIdAndVisitTypeMasterId(
			long programDurationId, long visitTypeMasterId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programDurationId, visitTypeMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramDurationIdAndVisitTypeMasterId,
				finderArgs, this);
		}

		if (result instanceof VisitTypeProgDurationRel) {
			VisitTypeProgDurationRel visitTypeProgDurationRel =
				(VisitTypeProgDurationRel)result;

			if ((programDurationId !=
					visitTypeProgDurationRel.getProgramDurationId()) ||
				(visitTypeMasterId !=
					visitTypeProgDurationRel.getVisitTypeMasterId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDVISITTYPEMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDVISITTYPEMASTERID_VISITTYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(visitTypeMasterId);

				List<VisitTypeProgDurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramDurationIdAndVisitTypeMasterId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programDurationId, visitTypeMasterId
								};
							}

							_log.warn(
								"VisitTypeProgDurationRelPersistenceImpl.fetchByProgramDurationIdAndVisitTypeMasterId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					VisitTypeProgDurationRel visitTypeProgDurationRel =
						list.get(0);

					result = visitTypeProgDurationRel;

					cacheResult(visitTypeProgDurationRel);
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
			return (VisitTypeProgDurationRel)result;
		}
	}

	/**
	 * Removes the visit type prog duration rel where programDurationId = &#63; and visitTypeMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @return the visit type prog duration rel that was removed
	 */
	@Override
	public VisitTypeProgDurationRel
			removeByProgramDurationIdAndVisitTypeMasterId(
				long programDurationId, long visitTypeMasterId)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel =
			findByProgramDurationIdAndVisitTypeMasterId(
				programDurationId, visitTypeMasterId);

		return remove(visitTypeProgDurationRel);
	}

	/**
	 * Returns the number of visit type prog duration rels where programDurationId = &#63; and visitTypeMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param visitTypeMasterId the visit type master ID
	 * @return the number of matching visit type prog duration rels
	 */
	@Override
	public int countByProgramDurationIdAndVisitTypeMasterId(
		long programDurationId, long visitTypeMasterId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndVisitTypeMasterId;

		Object[] finderArgs = new Object[] {
			programDurationId, visitTypeMasterId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISITTYPEPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDVISITTYPEMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDVISITTYPEMASTERID_VISITTYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(visitTypeMasterId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDVISITTYPEMASTERID_PROGRAMDURATIONID_2 =
			"visitTypeProgDurationRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDVISITTYPEMASTERID_VISITTYPEMASTERID_2 =
			"visitTypeProgDurationRel.visitTypeMasterId = ?";

	public VisitTypeProgDurationRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"VisitTypeProgDurationRelId", "visit_type_prog_duration_rel_id");
		dbColumnNames.put("visitTypeMasterId", "visit_type_master_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(VisitTypeProgDurationRel.class);

		setModelImplClass(VisitTypeProgDurationRelImpl.class);
		setModelPKClass(long.class);

		setTable(VisitTypeProgDurationRelTable.INSTANCE);
	}

	/**
	 * Caches the visit type prog duration rel in the entity cache if it is enabled.
	 *
	 * @param visitTypeProgDurationRel the visit type prog duration rel
	 */
	@Override
	public void cacheResult(VisitTypeProgDurationRel visitTypeProgDurationRel) {
		entityCache.putResult(
			VisitTypeProgDurationRelImpl.class,
			visitTypeProgDurationRel.getPrimaryKey(), visitTypeProgDurationRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				visitTypeProgDurationRel.getUuid(),
				visitTypeProgDurationRel.getGroupId()
			},
			visitTypeProgDurationRel);

		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndVisitTypeMasterId,
			new Object[] {
				visitTypeProgDurationRel.getProgramDurationId(),
				visitTypeProgDurationRel.getVisitTypeMasterId()
			},
			visitTypeProgDurationRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the visit type prog duration rels in the entity cache if it is enabled.
	 *
	 * @param visitTypeProgDurationRels the visit type prog duration rels
	 */
	@Override
	public void cacheResult(
		List<VisitTypeProgDurationRel> visitTypeProgDurationRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (visitTypeProgDurationRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (VisitTypeProgDurationRel visitTypeProgDurationRel :
				visitTypeProgDurationRels) {

			if (entityCache.getResult(
					VisitTypeProgDurationRelImpl.class,
					visitTypeProgDurationRel.getPrimaryKey()) == null) {

				cacheResult(visitTypeProgDurationRel);
			}
		}
	}

	/**
	 * Clears the cache for all visit type prog duration rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VisitTypeProgDurationRelImpl.class);

		finderCache.clearCache(VisitTypeProgDurationRelImpl.class);
	}

	/**
	 * Clears the cache for the visit type prog duration rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VisitTypeProgDurationRel visitTypeProgDurationRel) {
		entityCache.removeResult(
			VisitTypeProgDurationRelImpl.class, visitTypeProgDurationRel);
	}

	@Override
	public void clearCache(
		List<VisitTypeProgDurationRel> visitTypeProgDurationRels) {

		for (VisitTypeProgDurationRel visitTypeProgDurationRel :
				visitTypeProgDurationRels) {

			entityCache.removeResult(
				VisitTypeProgDurationRelImpl.class, visitTypeProgDurationRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VisitTypeProgDurationRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				VisitTypeProgDurationRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		VisitTypeProgDurationRelModelImpl visitTypeProgDurationRelModelImpl) {

		Object[] args = new Object[] {
			visitTypeProgDurationRelModelImpl.getUuid(),
			visitTypeProgDurationRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, visitTypeProgDurationRelModelImpl);

		args = new Object[] {
			visitTypeProgDurationRelModelImpl.getProgramDurationId(),
			visitTypeProgDurationRelModelImpl.getVisitTypeMasterId()
		};

		finderCache.putResult(
			_finderPathCountByProgramDurationIdAndVisitTypeMasterId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndVisitTypeMasterId, args,
			visitTypeProgDurationRelModelImpl);
	}

	/**
	 * Creates a new visit type prog duration rel with the primary key. Does not add the visit type prog duration rel to the database.
	 *
	 * @param VisitTypeProgDurationRelId the primary key for the new visit type prog duration rel
	 * @return the new visit type prog duration rel
	 */
	@Override
	public VisitTypeProgDurationRel create(long VisitTypeProgDurationRelId) {
		VisitTypeProgDurationRel visitTypeProgDurationRel =
			new VisitTypeProgDurationRelImpl();

		visitTypeProgDurationRel.setNew(true);
		visitTypeProgDurationRel.setPrimaryKey(VisitTypeProgDurationRelId);

		String uuid = _portalUUID.generate();

		visitTypeProgDurationRel.setUuid(uuid);

		visitTypeProgDurationRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return visitTypeProgDurationRel;
	}

	/**
	 * Removes the visit type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel that was removed
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public VisitTypeProgDurationRel remove(long VisitTypeProgDurationRelId)
		throws NoSuchVisitTypeProgDurationRelException {

		return remove((Serializable)VisitTypeProgDurationRelId);
	}

	/**
	 * Removes the visit type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel that was removed
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public VisitTypeProgDurationRel remove(Serializable primaryKey)
		throws NoSuchVisitTypeProgDurationRelException {

		Session session = null;

		try {
			session = openSession();

			VisitTypeProgDurationRel visitTypeProgDurationRel =
				(VisitTypeProgDurationRel)session.get(
					VisitTypeProgDurationRelImpl.class, primaryKey);

			if (visitTypeProgDurationRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisitTypeProgDurationRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(visitTypeProgDurationRel);
		}
		catch (NoSuchVisitTypeProgDurationRelException noSuchEntityException) {
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
	protected VisitTypeProgDurationRel removeImpl(
		VisitTypeProgDurationRel visitTypeProgDurationRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(visitTypeProgDurationRel)) {
				visitTypeProgDurationRel =
					(VisitTypeProgDurationRel)session.get(
						VisitTypeProgDurationRelImpl.class,
						visitTypeProgDurationRel.getPrimaryKeyObj());
			}

			if (visitTypeProgDurationRel != null) {
				session.delete(visitTypeProgDurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (visitTypeProgDurationRel != null) {
			clearCache(visitTypeProgDurationRel);
		}

		return visitTypeProgDurationRel;
	}

	@Override
	public VisitTypeProgDurationRel updateImpl(
		VisitTypeProgDurationRel visitTypeProgDurationRel) {

		boolean isNew = visitTypeProgDurationRel.isNew();

		if (!(visitTypeProgDurationRel instanceof
				VisitTypeProgDurationRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(visitTypeProgDurationRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					visitTypeProgDurationRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in visitTypeProgDurationRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VisitTypeProgDurationRel implementation " +
					visitTypeProgDurationRel.getClass());
		}

		VisitTypeProgDurationRelModelImpl visitTypeProgDurationRelModelImpl =
			(VisitTypeProgDurationRelModelImpl)visitTypeProgDurationRel;

		if (Validator.isNull(visitTypeProgDurationRel.getUuid())) {
			String uuid = _portalUUID.generate();

			visitTypeProgDurationRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (visitTypeProgDurationRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				visitTypeProgDurationRel.setCreateDate(date);
			}
			else {
				visitTypeProgDurationRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!visitTypeProgDurationRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				visitTypeProgDurationRel.setModifiedDate(date);
			}
			else {
				visitTypeProgDurationRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(visitTypeProgDurationRel);
			}
			else {
				visitTypeProgDurationRel =
					(VisitTypeProgDurationRel)session.merge(
						visitTypeProgDurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VisitTypeProgDurationRelImpl.class,
			visitTypeProgDurationRelModelImpl, false, true);

		cacheUniqueFindersCache(visitTypeProgDurationRelModelImpl);

		if (isNew) {
			visitTypeProgDurationRel.setNew(false);
		}

		visitTypeProgDurationRel.resetOriginalValues();

		return visitTypeProgDurationRel;
	}

	/**
	 * Returns the visit type prog duration rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVisitTypeProgDurationRelException {

		VisitTypeProgDurationRel visitTypeProgDurationRel = fetchByPrimaryKey(
			primaryKey);

		if (visitTypeProgDurationRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVisitTypeProgDurationRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return visitTypeProgDurationRel;
	}

	/**
	 * Returns the visit type prog duration rel with the primary key or throws a <code>NoSuchVisitTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel
	 * @throws NoSuchVisitTypeProgDurationRelException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public VisitTypeProgDurationRel findByPrimaryKey(
			long VisitTypeProgDurationRelId)
		throws NoSuchVisitTypeProgDurationRelException {

		return findByPrimaryKey((Serializable)VisitTypeProgDurationRelId);
	}

	/**
	 * Returns the visit type prog duration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel, or <code>null</code> if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public VisitTypeProgDurationRel fetchByPrimaryKey(
		long VisitTypeProgDurationRelId) {

		return fetchByPrimaryKey((Serializable)VisitTypeProgDurationRelId);
	}

	/**
	 * Returns all the visit type prog duration rels.
	 *
	 * @return the visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visit type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visit type prog duration rels
	 */
	@Override
	public List<VisitTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<VisitTypeProgDurationRel> orderByComparator,
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

		List<VisitTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<VisitTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VISITTYPEPROGDURATIONREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VISITTYPEPROGDURATIONREL;

				sql = sql.concat(
					VisitTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<VisitTypeProgDurationRel>)QueryUtil.list(
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
	 * Removes all the visit type prog duration rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VisitTypeProgDurationRel visitTypeProgDurationRel : findAll()) {
			remove(visitTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of visit type prog duration rels.
	 *
	 * @return the number of visit type prog duration rels
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
					_SQL_COUNT_VISITTYPEPROGDURATIONREL);

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
		return "visit_type_prog_duration_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VISITTYPEPROGDURATIONREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VisitTypeProgDurationRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the visit type prog duration rel persistence.
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

		_finderPathWithPaginationFindByProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProgramDurationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_duration_id"}, true);

		_finderPathWithoutPaginationFindByProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProgramDurationId", new String[] {Long.class.getName()},
			new String[] {"program_duration_id"}, true);

		_finderPathCountByProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramDurationId", new String[] {Long.class.getName()},
			new String[] {"program_duration_id"}, false);

		_finderPathFetchByProgramDurationIdAndVisitTypeMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgramDurationIdAndVisitTypeMasterId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"program_duration_id", "visit_type_master_id"},
				true);

		_finderPathCountByProgramDurationIdAndVisitTypeMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgramDurationIdAndVisitTypeMasterId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"program_duration_id", "visit_type_master_id"},
				false);

		_setVisitTypeProgDurationRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setVisitTypeProgDurationRelUtilPersistence(null);

		entityCache.removeCache(VisitTypeProgDurationRelImpl.class.getName());
	}

	private void _setVisitTypeProgDurationRelUtilPersistence(
		VisitTypeProgDurationRelPersistence
			visitTypeProgDurationRelPersistence) {

		try {
			Field field = VisitTypeProgDurationRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, visitTypeProgDurationRelPersistence);
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

	private static final String _SQL_SELECT_VISITTYPEPROGDURATIONREL =
		"SELECT visitTypeProgDurationRel FROM VisitTypeProgDurationRel visitTypeProgDurationRel";

	private static final String _SQL_SELECT_VISITTYPEPROGDURATIONREL_WHERE =
		"SELECT visitTypeProgDurationRel FROM VisitTypeProgDurationRel visitTypeProgDurationRel WHERE ";

	private static final String _SQL_COUNT_VISITTYPEPROGDURATIONREL =
		"SELECT COUNT(visitTypeProgDurationRel) FROM VisitTypeProgDurationRel visitTypeProgDurationRel";

	private static final String _SQL_COUNT_VISITTYPEPROGDURATIONREL_WHERE =
		"SELECT COUNT(visitTypeProgDurationRel) FROM VisitTypeProgDurationRel visitTypeProgDurationRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"visitTypeProgDurationRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VisitTypeProgDurationRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No VisitTypeProgDurationRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VisitTypeProgDurationRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "VisitTypeProgDurationRelId", "visitTypeMasterId",
			"programDurationId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
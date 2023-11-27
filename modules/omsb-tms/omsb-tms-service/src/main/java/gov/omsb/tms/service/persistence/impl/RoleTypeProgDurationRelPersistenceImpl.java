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

import gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException;
import gov.omsb.tms.model.RoleTypeProgDurationRel;
import gov.omsb.tms.model.RoleTypeProgDurationRelTable;
import gov.omsb.tms.model.impl.RoleTypeProgDurationRelImpl;
import gov.omsb.tms.model.impl.RoleTypeProgDurationRelModelImpl;
import gov.omsb.tms.service.persistence.RoleTypeProgDurationRelPersistence;
import gov.omsb.tms.service.persistence.RoleTypeProgDurationRelUtil;
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
 * The persistence implementation for the role type prog duration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RoleTypeProgDurationRelPersistence.class)
public class RoleTypeProgDurationRelPersistenceImpl
	extends BasePersistenceImpl<RoleTypeProgDurationRel>
	implements RoleTypeProgDurationRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RoleTypeProgDurationRelUtil</code> to access the role type prog duration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RoleTypeProgDurationRelImpl.class.getName();

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
	 * Returns all the role type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
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

		List<RoleTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<RoleTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RoleTypeProgDurationRel roleTypeProgDurationRel : list) {
					if (!uuid.equals(roleTypeProgDurationRel.getUuid())) {
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

			sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE);

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
				sb.append(RoleTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<RoleTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByUuid_First(
			String uuid,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel = fetchByUuid_First(
			uuid, orderByComparator);

		if (roleTypeProgDurationRel != null) {
			return roleTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRoleTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		List<RoleTypeProgDurationRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel = fetchByUuid_Last(
			uuid, orderByComparator);

		if (roleTypeProgDurationRel != null) {
			return roleTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRoleTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RoleTypeProgDurationRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public RoleTypeProgDurationRel[] findByUuid_PrevAndNext(
			long RoleTypeProgDurationRelId, String uuid,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		uuid = Objects.toString(uuid, "");

		RoleTypeProgDurationRel roleTypeProgDurationRel = findByPrimaryKey(
			RoleTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			RoleTypeProgDurationRel[] array =
				new RoleTypeProgDurationRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, roleTypeProgDurationRel, uuid, orderByComparator,
				true);

			array[1] = roleTypeProgDurationRel;

			array[2] = getByUuid_PrevAndNext(
				session, roleTypeProgDurationRel, uuid, orderByComparator,
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

	protected RoleTypeProgDurationRel getByUuid_PrevAndNext(
		Session session, RoleTypeProgDurationRel roleTypeProgDurationRel,
		String uuid,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE);

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
			sb.append(RoleTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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
						roleTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RoleTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role type prog duration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RoleTypeProgDurationRel roleTypeProgDurationRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(roleTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role type prog duration rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROLETYPEPROGDURATIONREL_WHERE);

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
		"roleTypeProgDurationRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(roleTypeProgDurationRel.uuid IS NULL OR roleTypeProgDurationRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel = fetchByUUID_G(
			uuid, groupId);

		if (roleTypeProgDurationRel == null) {
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

			throw new NoSuchRoleTypeProgDurationRelException(sb.toString());
		}

		return roleTypeProgDurationRel;
	}

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByUUID_G(
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

		if (result instanceof RoleTypeProgDurationRel) {
			RoleTypeProgDurationRel roleTypeProgDurationRel =
				(RoleTypeProgDurationRel)result;

			if (!Objects.equals(uuid, roleTypeProgDurationRel.getUuid()) ||
				(groupId != roleTypeProgDurationRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE);

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

				List<RoleTypeProgDurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					RoleTypeProgDurationRel roleTypeProgDurationRel = list.get(
						0);

					result = roleTypeProgDurationRel;

					cacheResult(roleTypeProgDurationRel);
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
			return (RoleTypeProgDurationRel)result;
		}
	}

	/**
	 * Removes the role type prog duration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role type prog duration rel that was removed
	 */
	@Override
	public RoleTypeProgDurationRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel = findByUUID_G(
			uuid, groupId);

		return remove(roleTypeProgDurationRel);
	}

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role type prog duration rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROLETYPEPROGDURATIONREL_WHERE);

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
		"roleTypeProgDurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(roleTypeProgDurationRel.uuid IS NULL OR roleTypeProgDurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"roleTypeProgDurationRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
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

		List<RoleTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<RoleTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RoleTypeProgDurationRel roleTypeProgDurationRel : list) {
					if (!uuid.equals(roleTypeProgDurationRel.getUuid()) ||
						(companyId != roleTypeProgDurationRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE);

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
				sb.append(RoleTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<RoleTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (roleTypeProgDurationRel != null) {
			return roleTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRoleTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		List<RoleTypeProgDurationRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (roleTypeProgDurationRel != null) {
			return roleTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRoleTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RoleTypeProgDurationRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public RoleTypeProgDurationRel[] findByUuid_C_PrevAndNext(
			long RoleTypeProgDurationRelId, String uuid, long companyId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		uuid = Objects.toString(uuid, "");

		RoleTypeProgDurationRel roleTypeProgDurationRel = findByPrimaryKey(
			RoleTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			RoleTypeProgDurationRel[] array =
				new RoleTypeProgDurationRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, roleTypeProgDurationRel, uuid, companyId,
				orderByComparator, true);

			array[1] = roleTypeProgDurationRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, roleTypeProgDurationRel, uuid, companyId,
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

	protected RoleTypeProgDurationRel getByUuid_C_PrevAndNext(
		Session session, RoleTypeProgDurationRel roleTypeProgDurationRel,
		String uuid, long companyId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE);

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
			sb.append(RoleTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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
						roleTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RoleTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role type prog duration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RoleTypeProgDurationRel roleTypeProgDurationRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(roleTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role type prog duration rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROLETYPEPROGDURATIONREL_WHERE);

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
		"roleTypeProgDurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(roleTypeProgDurationRel.uuid IS NULL OR roleTypeProgDurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"roleTypeProgDurationRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
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

		List<RoleTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<RoleTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RoleTypeProgDurationRel roleTypeProgDurationRel : list) {
					if (programDurationId !=
							roleTypeProgDurationRel.getProgramDurationId()) {

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

			sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoleTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				list = (List<RoleTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel =
			fetchByProgramDurationId_First(
				programDurationId, orderByComparator);

		if (roleTypeProgDurationRel != null) {
			return roleTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchRoleTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		List<RoleTypeProgDurationRel> list = findByProgramDurationId(
			programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel =
			fetchByProgramDurationId_Last(programDurationId, orderByComparator);

		if (roleTypeProgDurationRel != null) {
			return roleTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchRoleTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<RoleTypeProgDurationRel> list = findByProgramDurationId(
			programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public RoleTypeProgDurationRel[] findByProgramDurationId_PrevAndNext(
			long RoleTypeProgDurationRelId, long programDurationId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel = findByPrimaryKey(
			RoleTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			RoleTypeProgDurationRel[] array =
				new RoleTypeProgDurationRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, roleTypeProgDurationRel, programDurationId,
				orderByComparator, true);

			array[1] = roleTypeProgDurationRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, roleTypeProgDurationRel, programDurationId,
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

	protected RoleTypeProgDurationRel getByProgramDurationId_PrevAndNext(
		Session session, RoleTypeProgDurationRel roleTypeProgDurationRel,
		long programDurationId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE);

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
			sb.append(RoleTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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
						roleTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RoleTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role type prog duration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (RoleTypeProgDurationRel roleTypeProgDurationRel :
				findByProgramDurationId(
					programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(roleTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of role type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching role type prog duration rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROLETYPEPROGDURATIONREL_WHERE);

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
			"roleTypeProgDurationRel.programDurationId = ?";

	private FinderPath _finderPathFetchByProgramDurationIdAndRoleTypeMasterId;
	private FinderPath _finderPathCountByProgramDurationIdAndRoleTypeMasterId;

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByProgramDurationIdAndRoleTypeMasterId(
			long programDurationId, long roleTypeMasterId)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel =
			fetchByProgramDurationIdAndRoleTypeMasterId(
				programDurationId, roleTypeMasterId);

		if (roleTypeProgDurationRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programDurationId=");
			sb.append(programDurationId);

			sb.append(", roleTypeMasterId=");
			sb.append(roleTypeMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRoleTypeProgDurationRelException(sb.toString());
		}

		return roleTypeProgDurationRel;
	}

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByProgramDurationIdAndRoleTypeMasterId(
		long programDurationId, long roleTypeMasterId) {

		return fetchByProgramDurationIdAndRoleTypeMasterId(
			programDurationId, roleTypeMasterId, true);
	}

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByProgramDurationIdAndRoleTypeMasterId(
		long programDurationId, long roleTypeMasterId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programDurationId, roleTypeMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramDurationIdAndRoleTypeMasterId,
				finderArgs, this);
		}

		if (result instanceof RoleTypeProgDurationRel) {
			RoleTypeProgDurationRel roleTypeProgDurationRel =
				(RoleTypeProgDurationRel)result;

			if ((programDurationId !=
					roleTypeProgDurationRel.getProgramDurationId()) ||
				(roleTypeMasterId !=
					roleTypeProgDurationRel.getRoleTypeMasterId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDROLETYPEMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDROLETYPEMASTERID_ROLETYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(roleTypeMasterId);

				List<RoleTypeProgDurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramDurationIdAndRoleTypeMasterId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programDurationId, roleTypeMasterId
								};
							}

							_log.warn(
								"RoleTypeProgDurationRelPersistenceImpl.fetchByProgramDurationIdAndRoleTypeMasterId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RoleTypeProgDurationRel roleTypeProgDurationRel = list.get(
						0);

					result = roleTypeProgDurationRel;

					cacheResult(roleTypeProgDurationRel);
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
			return (RoleTypeProgDurationRel)result;
		}
	}

	/**
	 * Removes the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the role type prog duration rel that was removed
	 */
	@Override
	public RoleTypeProgDurationRel removeByProgramDurationIdAndRoleTypeMasterId(
			long programDurationId, long roleTypeMasterId)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel =
			findByProgramDurationIdAndRoleTypeMasterId(
				programDurationId, roleTypeMasterId);

		return remove(roleTypeProgDurationRel);
	}

	/**
	 * Returns the number of role type prog duration rels where programDurationId = &#63; and roleTypeMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the number of matching role type prog duration rels
	 */
	@Override
	public int countByProgramDurationIdAndRoleTypeMasterId(
		long programDurationId, long roleTypeMasterId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndRoleTypeMasterId;

		Object[] finderArgs = new Object[] {
			programDurationId, roleTypeMasterId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROLETYPEPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDROLETYPEMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDROLETYPEMASTERID_ROLETYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(roleTypeMasterId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDROLETYPEMASTERID_PROGRAMDURATIONID_2 =
			"roleTypeProgDurationRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDROLETYPEMASTERID_ROLETYPEMASTERID_2 =
			"roleTypeProgDurationRel.roleTypeMasterId = ?";

	public RoleTypeProgDurationRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"RoleTypeProgDurationRelId", "role_type_prog_duration_rel_id");
		dbColumnNames.put("roleTypeMasterId", "role_type_master_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(RoleTypeProgDurationRel.class);

		setModelImplClass(RoleTypeProgDurationRelImpl.class);
		setModelPKClass(long.class);

		setTable(RoleTypeProgDurationRelTable.INSTANCE);
	}

	/**
	 * Caches the role type prog duration rel in the entity cache if it is enabled.
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 */
	@Override
	public void cacheResult(RoleTypeProgDurationRel roleTypeProgDurationRel) {
		entityCache.putResult(
			RoleTypeProgDurationRelImpl.class,
			roleTypeProgDurationRel.getPrimaryKey(), roleTypeProgDurationRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				roleTypeProgDurationRel.getUuid(),
				roleTypeProgDurationRel.getGroupId()
			},
			roleTypeProgDurationRel);

		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndRoleTypeMasterId,
			new Object[] {
				roleTypeProgDurationRel.getProgramDurationId(),
				roleTypeProgDurationRel.getRoleTypeMasterId()
			},
			roleTypeProgDurationRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the role type prog duration rels in the entity cache if it is enabled.
	 *
	 * @param roleTypeProgDurationRels the role type prog duration rels
	 */
	@Override
	public void cacheResult(
		List<RoleTypeProgDurationRel> roleTypeProgDurationRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (roleTypeProgDurationRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RoleTypeProgDurationRel roleTypeProgDurationRel :
				roleTypeProgDurationRels) {

			if (entityCache.getResult(
					RoleTypeProgDurationRelImpl.class,
					roleTypeProgDurationRel.getPrimaryKey()) == null) {

				cacheResult(roleTypeProgDurationRel);
			}
		}
	}

	/**
	 * Clears the cache for all role type prog duration rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RoleTypeProgDurationRelImpl.class);

		finderCache.clearCache(RoleTypeProgDurationRelImpl.class);
	}

	/**
	 * Clears the cache for the role type prog duration rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RoleTypeProgDurationRel roleTypeProgDurationRel) {
		entityCache.removeResult(
			RoleTypeProgDurationRelImpl.class, roleTypeProgDurationRel);
	}

	@Override
	public void clearCache(
		List<RoleTypeProgDurationRel> roleTypeProgDurationRels) {

		for (RoleTypeProgDurationRel roleTypeProgDurationRel :
				roleTypeProgDurationRels) {

			entityCache.removeResult(
				RoleTypeProgDurationRelImpl.class, roleTypeProgDurationRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RoleTypeProgDurationRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				RoleTypeProgDurationRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RoleTypeProgDurationRelModelImpl roleTypeProgDurationRelModelImpl) {

		Object[] args = new Object[] {
			roleTypeProgDurationRelModelImpl.getUuid(),
			roleTypeProgDurationRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, roleTypeProgDurationRelModelImpl);

		args = new Object[] {
			roleTypeProgDurationRelModelImpl.getProgramDurationId(),
			roleTypeProgDurationRelModelImpl.getRoleTypeMasterId()
		};

		finderCache.putResult(
			_finderPathCountByProgramDurationIdAndRoleTypeMasterId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndRoleTypeMasterId, args,
			roleTypeProgDurationRelModelImpl);
	}

	/**
	 * Creates a new role type prog duration rel with the primary key. Does not add the role type prog duration rel to the database.
	 *
	 * @param RoleTypeProgDurationRelId the primary key for the new role type prog duration rel
	 * @return the new role type prog duration rel
	 */
	@Override
	public RoleTypeProgDurationRel create(long RoleTypeProgDurationRelId) {
		RoleTypeProgDurationRel roleTypeProgDurationRel =
			new RoleTypeProgDurationRelImpl();

		roleTypeProgDurationRel.setNew(true);
		roleTypeProgDurationRel.setPrimaryKey(RoleTypeProgDurationRelId);

		String uuid = _portalUUID.generate();

		roleTypeProgDurationRel.setUuid(uuid);

		roleTypeProgDurationRel.setCompanyId(CompanyThreadLocal.getCompanyId());

		return roleTypeProgDurationRel;
	}

	/**
	 * Removes the role type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel that was removed
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public RoleTypeProgDurationRel remove(long RoleTypeProgDurationRelId)
		throws NoSuchRoleTypeProgDurationRelException {

		return remove((Serializable)RoleTypeProgDurationRelId);
	}

	/**
	 * Removes the role type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the role type prog duration rel
	 * @return the role type prog duration rel that was removed
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public RoleTypeProgDurationRel remove(Serializable primaryKey)
		throws NoSuchRoleTypeProgDurationRelException {

		Session session = null;

		try {
			session = openSession();

			RoleTypeProgDurationRel roleTypeProgDurationRel =
				(RoleTypeProgDurationRel)session.get(
					RoleTypeProgDurationRelImpl.class, primaryKey);

			if (roleTypeProgDurationRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRoleTypeProgDurationRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(roleTypeProgDurationRel);
		}
		catch (NoSuchRoleTypeProgDurationRelException noSuchEntityException) {
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
	protected RoleTypeProgDurationRel removeImpl(
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(roleTypeProgDurationRel)) {
				roleTypeProgDurationRel = (RoleTypeProgDurationRel)session.get(
					RoleTypeProgDurationRelImpl.class,
					roleTypeProgDurationRel.getPrimaryKeyObj());
			}

			if (roleTypeProgDurationRel != null) {
				session.delete(roleTypeProgDurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (roleTypeProgDurationRel != null) {
			clearCache(roleTypeProgDurationRel);
		}

		return roleTypeProgDurationRel;
	}

	@Override
	public RoleTypeProgDurationRel updateImpl(
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		boolean isNew = roleTypeProgDurationRel.isNew();

		if (!(roleTypeProgDurationRel instanceof
				RoleTypeProgDurationRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(roleTypeProgDurationRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					roleTypeProgDurationRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in roleTypeProgDurationRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RoleTypeProgDurationRel implementation " +
					roleTypeProgDurationRel.getClass());
		}

		RoleTypeProgDurationRelModelImpl roleTypeProgDurationRelModelImpl =
			(RoleTypeProgDurationRelModelImpl)roleTypeProgDurationRel;

		if (Validator.isNull(roleTypeProgDurationRel.getUuid())) {
			String uuid = _portalUUID.generate();

			roleTypeProgDurationRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (roleTypeProgDurationRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				roleTypeProgDurationRel.setCreateDate(date);
			}
			else {
				roleTypeProgDurationRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!roleTypeProgDurationRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				roleTypeProgDurationRel.setModifiedDate(date);
			}
			else {
				roleTypeProgDurationRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(roleTypeProgDurationRel);
			}
			else {
				roleTypeProgDurationRel =
					(RoleTypeProgDurationRel)session.merge(
						roleTypeProgDurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RoleTypeProgDurationRelImpl.class, roleTypeProgDurationRelModelImpl,
			false, true);

		cacheUniqueFindersCache(roleTypeProgDurationRelModelImpl);

		if (isNew) {
			roleTypeProgDurationRel.setNew(false);
		}

		roleTypeProgDurationRel.resetOriginalValues();

		return roleTypeProgDurationRel;
	}

	/**
	 * Returns the role type prog duration rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the role type prog duration rel
	 * @return the role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRoleTypeProgDurationRelException {

		RoleTypeProgDurationRel roleTypeProgDurationRel = fetchByPrimaryKey(
			primaryKey);

		if (roleTypeProgDurationRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRoleTypeProgDurationRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return roleTypeProgDurationRel;
	}

	/**
	 * Returns the role type prog duration rel with the primary key or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public RoleTypeProgDurationRel findByPrimaryKey(
			long RoleTypeProgDurationRelId)
		throws NoSuchRoleTypeProgDurationRelException {

		return findByPrimaryKey((Serializable)RoleTypeProgDurationRelId);
	}

	/**
	 * Returns the role type prog duration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel, or <code>null</code> if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public RoleTypeProgDurationRel fetchByPrimaryKey(
		long RoleTypeProgDurationRelId) {

		return fetchByPrimaryKey((Serializable)RoleTypeProgDurationRelId);
	}

	/**
	 * Returns all the role type prog duration rels.
	 *
	 * @return the role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role type prog duration rels
	 */
	@Override
	public List<RoleTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
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

		List<RoleTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<RoleTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROLETYPEPROGDURATIONREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROLETYPEPROGDURATIONREL;

				sql = sql.concat(
					RoleTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RoleTypeProgDurationRel>)QueryUtil.list(
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
	 * Removes all the role type prog duration rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RoleTypeProgDurationRel roleTypeProgDurationRel : findAll()) {
			remove(roleTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of role type prog duration rels.
	 *
	 * @return the number of role type prog duration rels
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
					_SQL_COUNT_ROLETYPEPROGDURATIONREL);

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
		return "role_type_prog_duration_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROLETYPEPROGDURATIONREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RoleTypeProgDurationRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the role type prog duration rel persistence.
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

		_finderPathFetchByProgramDurationIdAndRoleTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY,
			"fetchByProgramDurationIdAndRoleTypeMasterId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_duration_id", "role_type_master_id"}, true);

		_finderPathCountByProgramDurationIdAndRoleTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramDurationIdAndRoleTypeMasterId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_duration_id", "role_type_master_id"}, false);

		_setRoleTypeProgDurationRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRoleTypeProgDurationRelUtilPersistence(null);

		entityCache.removeCache(RoleTypeProgDurationRelImpl.class.getName());
	}

	private void _setRoleTypeProgDurationRelUtilPersistence(
		RoleTypeProgDurationRelPersistence roleTypeProgDurationRelPersistence) {

		try {
			Field field = RoleTypeProgDurationRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, roleTypeProgDurationRelPersistence);
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

	private static final String _SQL_SELECT_ROLETYPEPROGDURATIONREL =
		"SELECT roleTypeProgDurationRel FROM RoleTypeProgDurationRel roleTypeProgDurationRel";

	private static final String _SQL_SELECT_ROLETYPEPROGDURATIONREL_WHERE =
		"SELECT roleTypeProgDurationRel FROM RoleTypeProgDurationRel roleTypeProgDurationRel WHERE ";

	private static final String _SQL_COUNT_ROLETYPEPROGDURATIONREL =
		"SELECT COUNT(roleTypeProgDurationRel) FROM RoleTypeProgDurationRel roleTypeProgDurationRel";

	private static final String _SQL_COUNT_ROLETYPEPROGDURATIONREL_WHERE =
		"SELECT COUNT(roleTypeProgDurationRel) FROM RoleTypeProgDurationRel roleTypeProgDurationRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"roleTypeProgDurationRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RoleTypeProgDurationRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RoleTypeProgDurationRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RoleTypeProgDurationRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "RoleTypeProgDurationRelId", "roleTypeMasterId",
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
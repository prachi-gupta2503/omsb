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

import gov.omsb.tms.exception.NoSuchProceduregroupProgdurationRelException;
import gov.omsb.tms.model.ProceduregroupProgdurationRel;
import gov.omsb.tms.model.ProceduregroupProgdurationRelTable;
import gov.omsb.tms.model.impl.ProceduregroupProgdurationRelImpl;
import gov.omsb.tms.model.impl.ProceduregroupProgdurationRelModelImpl;
import gov.omsb.tms.service.persistence.ProceduregroupProgdurationRelPersistence;
import gov.omsb.tms.service.persistence.ProceduregroupProgdurationRelUtil;
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
 * The persistence implementation for the proceduregroup progduration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProceduregroupProgdurationRelPersistence.class)
public class ProceduregroupProgdurationRelPersistenceImpl
	extends BasePersistenceImpl<ProceduregroupProgdurationRel>
	implements ProceduregroupProgdurationRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProceduregroupProgdurationRelUtil</code> to access the proceduregroup progduration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProceduregroupProgdurationRelImpl.class.getName();

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
	 * Returns all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
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

		List<ProceduregroupProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProceduregroupProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProceduregroupProgdurationRel
						proceduregroupProgdurationRel : list) {

					if (!uuid.equals(proceduregroupProgdurationRel.getUuid())) {
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

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
				sb.append(ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProceduregroupProgdurationRel>)QueryUtil.list(
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
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByUuid_First(
			String uuid,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (proceduregroupProgdurationRel != null) {
			return proceduregroupProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProceduregroupProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		List<ProceduregroupProgdurationRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (proceduregroupProgdurationRel != null) {
			return proceduregroupProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProceduregroupProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProceduregroupProgdurationRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel[] findByUuid_PrevAndNext(
			long pgPdRelId, String uuid,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		uuid = Objects.toString(uuid, "");

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			findByPrimaryKey(pgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProceduregroupProgdurationRel[] array =
				new ProceduregroupProgdurationRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, proceduregroupProgdurationRel, uuid, orderByComparator,
				true);

			array[1] = proceduregroupProgdurationRel;

			array[2] = getByUuid_PrevAndNext(
				session, proceduregroupProgdurationRel, uuid, orderByComparator,
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

	protected ProceduregroupProgdurationRel getByUuid_PrevAndNext(
		Session session,
		ProceduregroupProgdurationRel proceduregroupProgdurationRel,
		String uuid,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
			sb.append(ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
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
						proceduregroupProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProceduregroupProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduregroup progduration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProceduregroupProgdurationRel proceduregroupProgdurationRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(proceduregroupProgdurationRel);
		}
	}

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching proceduregroup progduration rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
		"proceduregroupProgdurationRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(proceduregroupProgdurationRel.uuid IS NULL OR proceduregroupProgdurationRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByUUID_G(uuid, groupId);

		if (proceduregroupProgdurationRel == null) {
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

			throw new NoSuchProceduregroupProgdurationRelException(
				sb.toString());
		}

		return proceduregroupProgdurationRel;
	}

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByUUID_G(
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

		if (result instanceof ProceduregroupProgdurationRel) {
			ProceduregroupProgdurationRel proceduregroupProgdurationRel =
				(ProceduregroupProgdurationRel)result;

			if (!Objects.equals(
					uuid, proceduregroupProgdurationRel.getUuid()) ||
				(groupId != proceduregroupProgdurationRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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

				List<ProceduregroupProgdurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProceduregroupProgdurationRel
						proceduregroupProgdurationRel = list.get(0);

					result = proceduregroupProgdurationRel;

					cacheResult(proceduregroupProgdurationRel);
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
			return (ProceduregroupProgdurationRel)result;
		}
	}

	/**
	 * Removes the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the proceduregroup progduration rel that was removed
	 */
	@Override
	public ProceduregroupProgdurationRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			findByUUID_G(uuid, groupId);

		return remove(proceduregroupProgdurationRel);
	}

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
		"proceduregroupProgdurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(proceduregroupProgdurationRel.uuid IS NULL OR proceduregroupProgdurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"proceduregroupProgdurationRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
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

		List<ProceduregroupProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProceduregroupProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProceduregroupProgdurationRel
						proceduregroupProgdurationRel : list) {

					if (!uuid.equals(proceduregroupProgdurationRel.getUuid()) ||
						(companyId !=
							proceduregroupProgdurationRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
				sb.append(ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProceduregroupProgdurationRel>)QueryUtil.list(
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
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (proceduregroupProgdurationRel != null) {
			return proceduregroupProgdurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProceduregroupProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		List<ProceduregroupProgdurationRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (proceduregroupProgdurationRel != null) {
			return proceduregroupProgdurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProceduregroupProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProceduregroupProgdurationRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel[] findByUuid_C_PrevAndNext(
			long pgPdRelId, String uuid, long companyId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		uuid = Objects.toString(uuid, "");

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			findByPrimaryKey(pgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProceduregroupProgdurationRel[] array =
				new ProceduregroupProgdurationRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, proceduregroupProgdurationRel, uuid, companyId,
				orderByComparator, true);

			array[1] = proceduregroupProgdurationRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, proceduregroupProgdurationRel, uuid, companyId,
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

	protected ProceduregroupProgdurationRel getByUuid_C_PrevAndNext(
		Session session,
		ProceduregroupProgdurationRel proceduregroupProgdurationRel,
		String uuid, long companyId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
			sb.append(ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
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
						proceduregroupProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProceduregroupProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProceduregroupProgdurationRel proceduregroupProgdurationRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(proceduregroupProgdurationRel);
		}
	}

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
		"proceduregroupProgdurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(proceduregroupProgdurationRel.uuid IS NULL OR proceduregroupProgdurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"proceduregroupProgdurationRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
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

		List<ProceduregroupProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProceduregroupProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProceduregroupProgdurationRel
						proceduregroupProgdurationRel : list) {

					if (programDurationId !=
							proceduregroupProgdurationRel.
								getProgramDurationId()) {

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

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				list = (List<ProceduregroupProgdurationRel>)QueryUtil.list(
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
	 * Returns the first proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByProgramDurationId_First(
				programDurationId, orderByComparator);

		if (proceduregroupProgdurationRel != null) {
			return proceduregroupProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProceduregroupProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		List<ProceduregroupProgdurationRel> list = findByProgramDurationId(
			programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByProgramDurationId_Last(programDurationId, orderByComparator);

		if (proceduregroupProgdurationRel != null) {
			return proceduregroupProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProceduregroupProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<ProceduregroupProgdurationRel> list = findByProgramDurationId(
			programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel[] findByProgramDurationId_PrevAndNext(
			long pgPdRelId, long programDurationId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			findByPrimaryKey(pgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProceduregroupProgdurationRel[] array =
				new ProceduregroupProgdurationRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, proceduregroupProgdurationRel, programDurationId,
				orderByComparator, true);

			array[1] = proceduregroupProgdurationRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, proceduregroupProgdurationRel, programDurationId,
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

	protected ProceduregroupProgdurationRel getByProgramDurationId_PrevAndNext(
		Session session,
		ProceduregroupProgdurationRel proceduregroupProgdurationRel,
		long programDurationId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
			sb.append(ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
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
						proceduregroupProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProceduregroupProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduregroup progduration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (ProceduregroupProgdurationRel proceduregroupProgdurationRel :
				findByProgramDurationId(
					programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(proceduregroupProgdurationRel);
		}
	}

	/**
	 * Returns the number of proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

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
			"proceduregroupProgdurationRel.programDurationId = ?";

	private FinderPath _finderPathWithPaginationFindByProcedureGroupMasterId;
	private FinderPath _finderPathWithoutPaginationFindByProcedureGroupMasterId;
	private FinderPath _finderPathCountByProcedureGroupMasterId;

	/**
	 * Returns all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProcedureGroupMasterId;
				finderArgs = new Object[] {procedureGroupMasterId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProcedureGroupMasterId;
			finderArgs = new Object[] {
				procedureGroupMasterId, start, end, orderByComparator
			};
		}

		List<ProceduregroupProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProceduregroupProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProceduregroupProgdurationRel
						proceduregroupProgdurationRel : list) {

					if (procedureGroupMasterId !=
							proceduregroupProgdurationRel.
								getProcedureGroupMasterId()) {

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

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureGroupMasterId);

				list = (List<ProceduregroupProgdurationRel>)QueryUtil.list(
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
	 * Returns the first proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByProcedureGroupMasterId_First(
				procedureGroupMasterId, orderByComparator);

		if (proceduregroupProgdurationRel != null) {
			return proceduregroupProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);

		sb.append("}");

		throw new NoSuchProceduregroupProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByProcedureGroupMasterId_First(
		long procedureGroupMasterId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		List<ProceduregroupProgdurationRel> list = findByProcedureGroupMasterId(
			procedureGroupMasterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByProcedureGroupMasterId_Last(
				procedureGroupMasterId, orderByComparator);

		if (proceduregroupProgdurationRel != null) {
			return proceduregroupProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);

		sb.append("}");

		throw new NoSuchProceduregroupProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByProcedureGroupMasterId_Last(
		long procedureGroupMasterId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		int count = countByProcedureGroupMasterId(procedureGroupMasterId);

		if (count == 0) {
			return null;
		}

		List<ProceduregroupProgdurationRel> list = findByProcedureGroupMasterId(
			procedureGroupMasterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel[]
			findByProcedureGroupMasterId_PrevAndNext(
				long pgPdRelId, long procedureGroupMasterId,
				OrderByComparator<ProceduregroupProgdurationRel>
					orderByComparator)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			findByPrimaryKey(pgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProceduregroupProgdurationRel[] array =
				new ProceduregroupProgdurationRelImpl[3];

			array[0] = getByProcedureGroupMasterId_PrevAndNext(
				session, proceduregroupProgdurationRel, procedureGroupMasterId,
				orderByComparator, true);

			array[1] = proceduregroupProgdurationRel;

			array[2] = getByProcedureGroupMasterId_PrevAndNext(
				session, proceduregroupProgdurationRel, procedureGroupMasterId,
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

	protected ProceduregroupProgdurationRel
		getByProcedureGroupMasterId_PrevAndNext(
			Session session,
			ProceduregroupProgdurationRel proceduregroupProgdurationRel,
			long procedureGroupMasterId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

		sb.append(
			_FINDER_COLUMN_PROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

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
			sb.append(ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(procedureGroupMasterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						proceduregroupProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProceduregroupProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduregroup progduration rels where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	@Override
	public void removeByProcedureGroupMasterId(long procedureGroupMasterId) {
		for (ProceduregroupProgdurationRel proceduregroupProgdurationRel :
				findByProcedureGroupMasterId(
					procedureGroupMasterId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(proceduregroupProgdurationRel);
		}
	}

	/**
	 * Returns the number of proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	@Override
	public int countByProcedureGroupMasterId(long procedureGroupMasterId) {
		FinderPath finderPath = _finderPathCountByProcedureGroupMasterId;

		Object[] finderArgs = new Object[] {procedureGroupMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureGroupMasterId);

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
		_FINDER_COLUMN_PROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2 =
			"proceduregroupProgdurationRel.procedureGroupMasterId = ?";

	private FinderPath
		_finderPathFetchByProgramDurationIdAndProcedureGroupMasterId;
	private FinderPath
		_finderPathCountByProgramDurationIdAndProcedureGroupMasterId;

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel
			findByProgramDurationIdAndProcedureGroupMasterId(
				long programDurationId, long procedureGroupMasterId)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByProgramDurationIdAndProcedureGroupMasterId(
				programDurationId, procedureGroupMasterId);

		if (proceduregroupProgdurationRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programDurationId=");
			sb.append(programDurationId);

			sb.append(", procedureGroupMasterId=");
			sb.append(procedureGroupMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProceduregroupProgdurationRelException(
				sb.toString());
		}

		return proceduregroupProgdurationRel;
	}

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterId(
			long programDurationId, long procedureGroupMasterId) {

		return fetchByProgramDurationIdAndProcedureGroupMasterId(
			programDurationId, procedureGroupMasterId, true);
	}

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterId(
			long programDurationId, long procedureGroupMasterId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				programDurationId, procedureGroupMasterId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramDurationIdAndProcedureGroupMasterId,
				finderArgs, this);
		}

		if (result instanceof ProceduregroupProgdurationRel) {
			ProceduregroupProgdurationRel proceduregroupProgdurationRel =
				(ProceduregroupProgdurationRel)result;

			if ((programDurationId !=
					proceduregroupProgdurationRel.getProgramDurationId()) ||
				(procedureGroupMasterId !=
					proceduregroupProgdurationRel.
						getProcedureGroupMasterId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(procedureGroupMasterId);

				List<ProceduregroupProgdurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramDurationIdAndProcedureGroupMasterId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programDurationId, procedureGroupMasterId
								};
							}

							_log.warn(
								"ProceduregroupProgdurationRelPersistenceImpl.fetchByProgramDurationIdAndProcedureGroupMasterId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProceduregroupProgdurationRel
						proceduregroupProgdurationRel = list.get(0);

					result = proceduregroupProgdurationRel;

					cacheResult(proceduregroupProgdurationRel);
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
			return (ProceduregroupProgdurationRel)result;
		}
	}

	/**
	 * Removes the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the proceduregroup progduration rel that was removed
	 */
	@Override
	public ProceduregroupProgdurationRel
			removeByProgramDurationIdAndProcedureGroupMasterId(
				long programDurationId, long procedureGroupMasterId)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			findByProgramDurationIdAndProcedureGroupMasterId(
				programDurationId, procedureGroupMasterId);

		return remove(proceduregroupProgdurationRel);
	}

	/**
	 * Returns the number of proceduregroup progduration rels where programDurationId = &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	@Override
	public int countByProgramDurationIdAndProcedureGroupMasterId(
		long programDurationId, long procedureGroupMasterId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndProcedureGroupMasterId;

		Object[] finderArgs = new Object[] {
			programDurationId, procedureGroupMasterId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(procedureGroupMasterId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERID_PROGRAMDURATIONID_2 =
			"proceduregroupProgdurationRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2 =
			"proceduregroupProgdurationRel.procedureGroupMasterId = ?";

	public ProceduregroupProgdurationRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("pgPdRelId", "pg_pd_rel_id");
		dbColumnNames.put(
			"procedureGroupMasterId", "procedure_group_master_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProceduregroupProgdurationRel.class);

		setModelImplClass(ProceduregroupProgdurationRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProceduregroupProgdurationRelTable.INSTANCE);
	}

	/**
	 * Caches the proceduregroup progduration rel in the entity cache if it is enabled.
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 */
	@Override
	public void cacheResult(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		entityCache.putResult(
			ProceduregroupProgdurationRelImpl.class,
			proceduregroupProgdurationRel.getPrimaryKey(),
			proceduregroupProgdurationRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				proceduregroupProgdurationRel.getUuid(),
				proceduregroupProgdurationRel.getGroupId()
			},
			proceduregroupProgdurationRel);

		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndProcedureGroupMasterId,
			new Object[] {
				proceduregroupProgdurationRel.getProgramDurationId(),
				proceduregroupProgdurationRel.getProcedureGroupMasterId()
			},
			proceduregroupProgdurationRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the proceduregroup progduration rels in the entity cache if it is enabled.
	 *
	 * @param proceduregroupProgdurationRels the proceduregroup progduration rels
	 */
	@Override
	public void cacheResult(
		List<ProceduregroupProgdurationRel> proceduregroupProgdurationRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (proceduregroupProgdurationRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProceduregroupProgdurationRel proceduregroupProgdurationRel :
				proceduregroupProgdurationRels) {

			if (entityCache.getResult(
					ProceduregroupProgdurationRelImpl.class,
					proceduregroupProgdurationRel.getPrimaryKey()) == null) {

				cacheResult(proceduregroupProgdurationRel);
			}
		}
	}

	/**
	 * Clears the cache for all proceduregroup progduration rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProceduregroupProgdurationRelImpl.class);

		finderCache.clearCache(ProceduregroupProgdurationRelImpl.class);
	}

	/**
	 * Clears the cache for the proceduregroup progduration rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		entityCache.removeResult(
			ProceduregroupProgdurationRelImpl.class,
			proceduregroupProgdurationRel);
	}

	@Override
	public void clearCache(
		List<ProceduregroupProgdurationRel> proceduregroupProgdurationRels) {

		for (ProceduregroupProgdurationRel proceduregroupProgdurationRel :
				proceduregroupProgdurationRels) {

			entityCache.removeResult(
				ProceduregroupProgdurationRelImpl.class,
				proceduregroupProgdurationRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProceduregroupProgdurationRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProceduregroupProgdurationRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProceduregroupProgdurationRelModelImpl
			proceduregroupProgdurationRelModelImpl) {

		Object[] args = new Object[] {
			proceduregroupProgdurationRelModelImpl.getUuid(),
			proceduregroupProgdurationRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			proceduregroupProgdurationRelModelImpl);

		args = new Object[] {
			proceduregroupProgdurationRelModelImpl.getProgramDurationId(),
			proceduregroupProgdurationRelModelImpl.getProcedureGroupMasterId()
		};

		finderCache.putResult(
			_finderPathCountByProgramDurationIdAndProcedureGroupMasterId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndProcedureGroupMasterId, args,
			proceduregroupProgdurationRelModelImpl);
	}

	/**
	 * Creates a new proceduregroup progduration rel with the primary key. Does not add the proceduregroup progduration rel to the database.
	 *
	 * @param pgPdRelId the primary key for the new proceduregroup progduration rel
	 * @return the new proceduregroup progduration rel
	 */
	@Override
	public ProceduregroupProgdurationRel create(long pgPdRelId) {
		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			new ProceduregroupProgdurationRelImpl();

		proceduregroupProgdurationRel.setNew(true);
		proceduregroupProgdurationRel.setPrimaryKey(pgPdRelId);

		String uuid = _portalUUID.generate();

		proceduregroupProgdurationRel.setUuid(uuid);

		proceduregroupProgdurationRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return proceduregroupProgdurationRel;
	}

	/**
	 * Removes the proceduregroup progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was removed
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel remove(long pgPdRelId)
		throws NoSuchProceduregroupProgdurationRelException {

		return remove((Serializable)pgPdRelId);
	}

	/**
	 * Removes the proceduregroup progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was removed
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel remove(Serializable primaryKey)
		throws NoSuchProceduregroupProgdurationRelException {

		Session session = null;

		try {
			session = openSession();

			ProceduregroupProgdurationRel proceduregroupProgdurationRel =
				(ProceduregroupProgdurationRel)session.get(
					ProceduregroupProgdurationRelImpl.class, primaryKey);

			if (proceduregroupProgdurationRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProceduregroupProgdurationRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(proceduregroupProgdurationRel);
		}
		catch (NoSuchProceduregroupProgdurationRelException
					noSuchEntityException) {

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
	protected ProceduregroupProgdurationRel removeImpl(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(proceduregroupProgdurationRel)) {
				proceduregroupProgdurationRel =
					(ProceduregroupProgdurationRel)session.get(
						ProceduregroupProgdurationRelImpl.class,
						proceduregroupProgdurationRel.getPrimaryKeyObj());
			}

			if (proceduregroupProgdurationRel != null) {
				session.delete(proceduregroupProgdurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (proceduregroupProgdurationRel != null) {
			clearCache(proceduregroupProgdurationRel);
		}

		return proceduregroupProgdurationRel;
	}

	@Override
	public ProceduregroupProgdurationRel updateImpl(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		boolean isNew = proceduregroupProgdurationRel.isNew();

		if (!(proceduregroupProgdurationRel instanceof
				ProceduregroupProgdurationRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					proceduregroupProgdurationRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					proceduregroupProgdurationRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in proceduregroupProgdurationRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProceduregroupProgdurationRel implementation " +
					proceduregroupProgdurationRel.getClass());
		}

		ProceduregroupProgdurationRelModelImpl
			proceduregroupProgdurationRelModelImpl =
				(ProceduregroupProgdurationRelModelImpl)
					proceduregroupProgdurationRel;

		if (Validator.isNull(proceduregroupProgdurationRel.getUuid())) {
			String uuid = _portalUUID.generate();

			proceduregroupProgdurationRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (proceduregroupProgdurationRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				proceduregroupProgdurationRel.setCreateDate(date);
			}
			else {
				proceduregroupProgdurationRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!proceduregroupProgdurationRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				proceduregroupProgdurationRel.setModifiedDate(date);
			}
			else {
				proceduregroupProgdurationRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(proceduregroupProgdurationRel);
			}
			else {
				proceduregroupProgdurationRel =
					(ProceduregroupProgdurationRel)session.merge(
						proceduregroupProgdurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProceduregroupProgdurationRelImpl.class,
			proceduregroupProgdurationRelModelImpl, false, true);

		cacheUniqueFindersCache(proceduregroupProgdurationRelModelImpl);

		if (isNew) {
			proceduregroupProgdurationRel.setNew(false);
		}

		proceduregroupProgdurationRel.resetOriginalValues();

		return proceduregroupProgdurationRel;
	}

	/**
	 * Returns the proceduregroup progduration rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchProceduregroupProgdurationRelException {

		ProceduregroupProgdurationRel proceduregroupProgdurationRel =
			fetchByPrimaryKey(primaryKey);

		if (proceduregroupProgdurationRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProceduregroupProgdurationRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return proceduregroupProgdurationRel;
	}

	/**
	 * Returns the proceduregroup progduration rel with the primary key or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel findByPrimaryKey(long pgPdRelId)
		throws NoSuchProceduregroupProgdurationRelException {

		return findByPrimaryKey((Serializable)pgPdRelId);
	}

	/**
	 * Returns the proceduregroup progduration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel, or <code>null</code> if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public ProceduregroupProgdurationRel fetchByPrimaryKey(long pgPdRelId) {
		return fetchByPrimaryKey((Serializable)pgPdRelId);
	}

	/**
	 * Returns all the proceduregroup progduration rels.
	 *
	 * @return the proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findAll(
		int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proceduregroup progduration rels
	 */
	@Override
	public List<ProceduregroupProgdurationRel> findAll(
		int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
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

		List<ProceduregroupProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProceduregroupProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL;

				sql = sql.concat(
					ProceduregroupProgdurationRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProceduregroupProgdurationRel>)QueryUtil.list(
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
	 * Removes all the proceduregroup progduration rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProceduregroupProgdurationRel proceduregroupProgdurationRel :
				findAll()) {

			remove(proceduregroupProgdurationRel);
		}
	}

	/**
	 * Returns the number of proceduregroup progduration rels.
	 *
	 * @return the number of proceduregroup progduration rels
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
					_SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL);

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
		return "pg_pd_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProceduregroupProgdurationRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the proceduregroup progduration rel persistence.
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

		_finderPathWithPaginationFindByProcedureGroupMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProcedureGroupMasterId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"procedure_group_master_id"}, true);

		_finderPathWithoutPaginationFindByProcedureGroupMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProcedureGroupMasterId",
				new String[] {Long.class.getName()},
				new String[] {"procedure_group_master_id"}, true);

		_finderPathCountByProcedureGroupMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcedureGroupMasterId",
			new String[] {Long.class.getName()},
			new String[] {"procedure_group_master_id"}, false);

		_finderPathFetchByProgramDurationIdAndProcedureGroupMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgramDurationIdAndProcedureGroupMasterId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {
					"program_duration_id", "procedure_group_master_id"
				},
				true);

		_finderPathCountByProgramDurationIdAndProcedureGroupMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgramDurationIdAndProcedureGroupMasterId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {
					"program_duration_id", "procedure_group_master_id"
				},
				false);

		_setProceduregroupProgdurationRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProceduregroupProgdurationRelUtilPersistence(null);

		entityCache.removeCache(
			ProceduregroupProgdurationRelImpl.class.getName());
	}

	private void _setProceduregroupProgdurationRelUtilPersistence(
		ProceduregroupProgdurationRelPersistence
			proceduregroupProgdurationRelPersistence) {

		try {
			Field field =
				ProceduregroupProgdurationRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, proceduregroupProgdurationRelPersistence);
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

	private static final String _SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL =
		"SELECT proceduregroupProgdurationRel FROM ProceduregroupProgdurationRel proceduregroupProgdurationRel";

	private static final String
		_SQL_SELECT_PROCEDUREGROUPPROGDURATIONREL_WHERE =
			"SELECT proceduregroupProgdurationRel FROM ProceduregroupProgdurationRel proceduregroupProgdurationRel WHERE ";

	private static final String _SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL =
		"SELECT COUNT(proceduregroupProgdurationRel) FROM ProceduregroupProgdurationRel proceduregroupProgdurationRel";

	private static final String _SQL_COUNT_PROCEDUREGROUPPROGDURATIONREL_WHERE =
		"SELECT COUNT(proceduregroupProgdurationRel) FROM ProceduregroupProgdurationRel proceduregroupProgdurationRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"proceduregroupProgdurationRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProceduregroupProgdurationRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProceduregroupProgdurationRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProceduregroupProgdurationRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "pgPdRelId", "procedureGroupMasterId", "programDurationId",
			"groupId", "companyId", "createDate", "modifiedDate", "createdBy",
			"modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
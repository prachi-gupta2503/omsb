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

import gov.omsb.tms.exception.NoSuchProcedurePgProgdurationRelException;
import gov.omsb.tms.model.ProcedurePgProgdurationRel;
import gov.omsb.tms.model.ProcedurePgProgdurationRelTable;
import gov.omsb.tms.model.impl.ProcedurePgProgdurationRelImpl;
import gov.omsb.tms.model.impl.ProcedurePgProgdurationRelModelImpl;
import gov.omsb.tms.service.persistence.ProcedurePgProgdurationRelPersistence;
import gov.omsb.tms.service.persistence.ProcedurePgProgdurationRelUtil;
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
 * The persistence implementation for the procedure pg progduration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProcedurePgProgdurationRelPersistence.class)
public class ProcedurePgProgdurationRelPersistenceImpl
	extends BasePersistenceImpl<ProcedurePgProgdurationRel>
	implements ProcedurePgProgdurationRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProcedurePgProgdurationRelUtil</code> to access the procedure pg progduration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProcedurePgProgdurationRelImpl.class.getName();

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
	 * Returns all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		List<ProcedurePgProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProcedurePgProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
						list) {

					if (!uuid.equals(procedurePgProgdurationRel.getUuid())) {
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

			sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
				sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProcedurePgProgdurationRel>)QueryUtil.list(
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
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByUuid_First(
			String uuid,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		List<ProcedurePgProgdurationRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProcedurePgProgdurationRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel[] findByUuid_PrevAndNext(
			long procedurePgPdRelId, String uuid,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		uuid = Objects.toString(uuid, "");

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			findByPrimaryKey(procedurePgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProcedurePgProgdurationRel[] array =
				new ProcedurePgProgdurationRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, procedurePgProgdurationRel, uuid, orderByComparator,
				true);

			array[1] = procedurePgProgdurationRel;

			array[2] = getByUuid_PrevAndNext(
				session, procedurePgProgdurationRel, uuid, orderByComparator,
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

	protected ProcedurePgProgdurationRel getByUuid_PrevAndNext(
		Session session, ProcedurePgProgdurationRel procedurePgProgdurationRel,
		String uuid,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
			sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
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
						procedurePgProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedurePgProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure pg progduration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(procedurePgProgdurationRel);
		}
	}

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure pg progduration rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
		"procedurePgProgdurationRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(procedurePgProgdurationRel.uuid IS NULL OR procedurePgProgdurationRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel = fetchByUUID_G(
			uuid, groupId);

		if (procedurePgProgdurationRel == null) {
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

			throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
		}

		return procedurePgProgdurationRel;
	}

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByUUID_G(
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

		if (result instanceof ProcedurePgProgdurationRel) {
			ProcedurePgProgdurationRel procedurePgProgdurationRel =
				(ProcedurePgProgdurationRel)result;

			if (!Objects.equals(uuid, procedurePgProgdurationRel.getUuid()) ||
				(groupId != procedurePgProgdurationRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

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

				List<ProcedurePgProgdurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProcedurePgProgdurationRel procedurePgProgdurationRel =
						list.get(0);

					result = procedurePgProgdurationRel;

					cacheResult(procedurePgProgdurationRel);
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
			return (ProcedurePgProgdurationRel)result;
		}
	}

	/**
	 * Removes the procedure pg progduration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure pg progduration rel that was removed
	 */
	@Override
	public ProcedurePgProgdurationRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel = findByUUID_G(
			uuid, groupId);

		return remove(procedurePgProgdurationRel);
	}

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure pg progduration rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
		"procedurePgProgdurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(procedurePgProgdurationRel.uuid IS NULL OR procedurePgProgdurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"procedurePgProgdurationRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		List<ProcedurePgProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProcedurePgProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
						list) {

					if (!uuid.equals(procedurePgProgdurationRel.getUuid()) ||
						(companyId !=
							procedurePgProgdurationRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
				sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProcedurePgProgdurationRel>)QueryUtil.list(
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
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		List<ProcedurePgProgdurationRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProcedurePgProgdurationRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel[] findByUuid_C_PrevAndNext(
			long procedurePgPdRelId, String uuid, long companyId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		uuid = Objects.toString(uuid, "");

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			findByPrimaryKey(procedurePgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProcedurePgProgdurationRel[] array =
				new ProcedurePgProgdurationRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, procedurePgProgdurationRel, uuid, companyId,
				orderByComparator, true);

			array[1] = procedurePgProgdurationRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, procedurePgProgdurationRel, uuid, companyId,
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

	protected ProcedurePgProgdurationRel getByUuid_C_PrevAndNext(
		Session session, ProcedurePgProgdurationRel procedurePgProgdurationRel,
		String uuid, long companyId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
			sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
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
						procedurePgProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedurePgProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure pg progduration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedurePgProgdurationRel);
		}
	}

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure pg progduration rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
		"procedurePgProgdurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(procedurePgProgdurationRel.uuid IS NULL OR procedurePgProgdurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"procedurePgProgdurationRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		List<ProcedurePgProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProcedurePgProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
						list) {

					if (programDurationId !=
							procedurePgProgdurationRel.getProgramDurationId()) {

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

			sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				list = (List<ProcedurePgProgdurationRel>)QueryUtil.list(
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
	 * Returns the first procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByProgramDurationId_First(
				programDurationId, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		List<ProcedurePgProgdurationRel> list = findByProgramDurationId(
			programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByProgramDurationId_Last(programDurationId, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<ProcedurePgProgdurationRel> list = findByProgramDurationId(
			programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel[] findByProgramDurationId_PrevAndNext(
			long procedurePgPdRelId, long programDurationId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			findByPrimaryKey(procedurePgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProcedurePgProgdurationRel[] array =
				new ProcedurePgProgdurationRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, procedurePgProgdurationRel, programDurationId,
				orderByComparator, true);

			array[1] = procedurePgProgdurationRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, procedurePgProgdurationRel, programDurationId,
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

	protected ProcedurePgProgdurationRel getByProgramDurationId_PrevAndNext(
		Session session, ProcedurePgProgdurationRel procedurePgProgdurationRel,
		long programDurationId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
			sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
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
						procedurePgProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedurePgProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure pg progduration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
				findByProgramDurationId(
					programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedurePgProgdurationRel);
		}
	}

	/**
	 * Returns the number of procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching procedure pg progduration rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
			"procedurePgProgdurationRel.programDurationId = ?";

	private FinderPath _finderPathWithPaginationFindByProcedureGroupMasterId;
	private FinderPath _finderPathWithoutPaginationFindByProcedureGroupMasterId;
	private FinderPath _finderPathCountByProcedureGroupMasterId;

	/**
	 * Returns all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		List<ProcedurePgProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProcedurePgProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
						list) {

					if (procedureGroupMasterId !=
							procedurePgProgdurationRel.
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

			sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureGroupMasterId);

				list = (List<ProcedurePgProgdurationRel>)QueryUtil.list(
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
	 * Returns the first procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByProcedureGroupMasterId_First(
				procedureGroupMasterId, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByProcedureGroupMasterId_First(
		long procedureGroupMasterId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		List<ProcedurePgProgdurationRel> list = findByProcedureGroupMasterId(
			procedureGroupMasterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByProcedureGroupMasterId_Last(
				procedureGroupMasterId, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByProcedureGroupMasterId_Last(
		long procedureGroupMasterId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		int count = countByProcedureGroupMasterId(procedureGroupMasterId);

		if (count == 0) {
			return null;
		}

		List<ProcedurePgProgdurationRel> list = findByProcedureGroupMasterId(
			procedureGroupMasterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel[]
			findByProcedureGroupMasterId_PrevAndNext(
				long procedurePgPdRelId, long procedureGroupMasterId,
				OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			findByPrimaryKey(procedurePgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProcedurePgProgdurationRel[] array =
				new ProcedurePgProgdurationRelImpl[3];

			array[0] = getByProcedureGroupMasterId_PrevAndNext(
				session, procedurePgProgdurationRel, procedureGroupMasterId,
				orderByComparator, true);

			array[1] = procedurePgProgdurationRel;

			array[2] = getByProcedureGroupMasterId_PrevAndNext(
				session, procedurePgProgdurationRel, procedureGroupMasterId,
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

	protected ProcedurePgProgdurationRel
		getByProcedureGroupMasterId_PrevAndNext(
			Session session,
			ProcedurePgProgdurationRel procedurePgProgdurationRel,
			long procedureGroupMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
			sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
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
						procedurePgProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedurePgProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure pg progduration rels where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	@Override
	public void removeByProcedureGroupMasterId(long procedureGroupMasterId) {
		for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
				findByProcedureGroupMasterId(
					procedureGroupMasterId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(procedurePgProgdurationRel);
		}
	}

	/**
	 * Returns the number of procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	@Override
	public int countByProcedureGroupMasterId(long procedureGroupMasterId) {
		FinderPath finderPath = _finderPathCountByProcedureGroupMasterId;

		Object[] finderArgs = new Object[] {procedureGroupMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREPGPROGDURATIONREL_WHERE);

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
			"procedurePgProgdurationRel.procedureGroupMasterId = ?";

	private FinderPath _finderPathWithPaginationFindByProcedureMasterId;
	private FinderPath _finderPathWithoutPaginationFindByProcedureMasterId;
	private FinderPath _finderPathCountByProcedureMasterId;

	/**
	 * Returns all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId) {

		return findByProcedureMasterId(
			procedureMasterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end) {

		return findByProcedureMasterId(procedureMasterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return findByProcedureMasterId(
			procedureMasterId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProcedureMasterId;
				finderArgs = new Object[] {procedureMasterId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProcedureMasterId;
			finderArgs = new Object[] {
				procedureMasterId, start, end, orderByComparator
			};
		}

		List<ProcedurePgProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProcedurePgProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
						list) {

					if (procedureMasterId !=
							procedurePgProgdurationRel.getProcedureMasterId()) {

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

			sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDUREMASTERID_PROCEDUREMASTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureMasterId);

				list = (List<ProcedurePgProgdurationRel>)QueryUtil.list(
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
	 * Returns the first procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByProcedureMasterId_First(
			long procedureMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByProcedureMasterId_First(
				procedureMasterId, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureMasterId=");
		sb.append(procedureMasterId);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByProcedureMasterId_First(
		long procedureMasterId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		List<ProcedurePgProgdurationRel> list = findByProcedureMasterId(
			procedureMasterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByProcedureMasterId_Last(
			long procedureMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByProcedureMasterId_Last(procedureMasterId, orderByComparator);

		if (procedurePgProgdurationRel != null) {
			return procedurePgProgdurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureMasterId=");
		sb.append(procedureMasterId);

		sb.append("}");

		throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByProcedureMasterId_Last(
		long procedureMasterId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		int count = countByProcedureMasterId(procedureMasterId);

		if (count == 0) {
			return null;
		}

		List<ProcedurePgProgdurationRel> list = findByProcedureMasterId(
			procedureMasterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel[] findByProcedureMasterId_PrevAndNext(
			long procedurePgPdRelId, long procedureMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			findByPrimaryKey(procedurePgPdRelId);

		Session session = null;

		try {
			session = openSession();

			ProcedurePgProgdurationRel[] array =
				new ProcedurePgProgdurationRelImpl[3];

			array[0] = getByProcedureMasterId_PrevAndNext(
				session, procedurePgProgdurationRel, procedureMasterId,
				orderByComparator, true);

			array[1] = procedurePgProgdurationRel;

			array[2] = getByProcedureMasterId_PrevAndNext(
				session, procedurePgProgdurationRel, procedureMasterId,
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

	protected ProcedurePgProgdurationRel getByProcedureMasterId_PrevAndNext(
		Session session, ProcedurePgProgdurationRel procedurePgProgdurationRel,
		long procedureMasterId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

		sb.append(_FINDER_COLUMN_PROCEDUREMASTERID_PROCEDUREMASTERID_2);

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
			sb.append(ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(procedureMasterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						procedurePgProgdurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedurePgProgdurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure pg progduration rels where procedureMasterId = &#63; from the database.
	 *
	 * @param procedureMasterId the procedure master ID
	 */
	@Override
	public void removeByProcedureMasterId(long procedureMasterId) {
		for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
				findByProcedureMasterId(
					procedureMasterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedurePgProgdurationRel);
		}
	}

	/**
	 * Returns the number of procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	@Override
	public int countByProcedureMasterId(long procedureMasterId) {
		FinderPath finderPath = _finderPathCountByProcedureMasterId;

		Object[] finderArgs = new Object[] {procedureMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREPGPROGDURATIONREL_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDUREMASTERID_PROCEDUREMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureMasterId);

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
		_FINDER_COLUMN_PROCEDUREMASTERID_PROCEDUREMASTERID_2 =
			"procedurePgProgdurationRel.procedureMasterId = ?";

	private FinderPath
		_finderPathFetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId;
	private FinderPath
		_finderPathCountByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId;

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel
			findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				long programDurationId, long procedureGroupMasterId,
				long procedureMasterId)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				programDurationId, procedureGroupMasterId, procedureMasterId);

		if (procedurePgProgdurationRel == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programDurationId=");
			sb.append(programDurationId);

			sb.append(", procedureGroupMasterId=");
			sb.append(procedureGroupMasterId);

			sb.append(", procedureMasterId=");
			sb.append(procedureMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProcedurePgProgdurationRelException(sb.toString());
		}

		return procedurePgProgdurationRel;
	}

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId) {

		return fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			programDurationId, procedureGroupMasterId, procedureMasterId, true);
	}

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				programDurationId, procedureGroupMasterId, procedureMasterId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId,
				finderArgs, this);
		}

		if (result instanceof ProcedurePgProgdurationRel) {
			ProcedurePgProgdurationRel procedurePgProgdurationRel =
				(ProcedurePgProgdurationRel)result;

			if ((programDurationId !=
					procedurePgProgdurationRel.getProgramDurationId()) ||
				(procedureGroupMasterId !=
					procedurePgProgdurationRel.getProcedureGroupMasterId()) ||
				(procedureMasterId !=
					procedurePgProgdurationRel.getProcedureMasterId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROCEDUREGROUPMASTERID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROCEDUREMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(procedureGroupMasterId);

				queryPos.add(procedureMasterId);

				List<ProcedurePgProgdurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programDurationId, procedureGroupMasterId,
									procedureMasterId
								};
							}

							_log.warn(
								"ProcedurePgProgdurationRelPersistenceImpl.fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProcedurePgProgdurationRel procedurePgProgdurationRel =
						list.get(0);

					result = procedurePgProgdurationRel;

					cacheResult(procedurePgProgdurationRel);
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
			return (ProcedurePgProgdurationRel)result;
		}
	}

	/**
	 * Removes the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the procedure pg progduration rel that was removed
	 */
	@Override
	public ProcedurePgProgdurationRel
			removeByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				long programDurationId, long procedureGroupMasterId,
				long procedureMasterId)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				programDurationId, procedureGroupMasterId, procedureMasterId);

		return remove(procedurePgProgdurationRel);
	}

	/**
	 * Returns the number of procedure pg progduration rels where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	@Override
	public int
		countByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId;

		Object[] finderArgs = new Object[] {
			programDurationId, procedureGroupMasterId, procedureMasterId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROCEDUREPGPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROCEDUREGROUPMASTERID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROCEDUREMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(procedureGroupMasterId);

				queryPos.add(procedureMasterId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROGRAMDURATIONID_2 =
			"procedurePgProgdurationRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROCEDUREGROUPMASTERID_2 =
			"procedurePgProgdurationRel.procedureGroupMasterId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPMASTERIDANDPROCEDUREMASTERID_PROCEDUREMASTERID_2 =
			"procedurePgProgdurationRel.procedureMasterId = ?";

	public ProcedurePgProgdurationRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("procedurePgPdRelId", "procedure_pg_pd_rel_id");
		dbColumnNames.put(
			"procedureGroupMasterId", "procedure_group_master_id");
		dbColumnNames.put("procedureMasterId", "procedure_master_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProcedurePgProgdurationRel.class);

		setModelImplClass(ProcedurePgProgdurationRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProcedurePgProgdurationRelTable.INSTANCE);
	}

	/**
	 * Caches the procedure pg progduration rel in the entity cache if it is enabled.
	 *
	 * @param procedurePgProgdurationRel the procedure pg progduration rel
	 */
	@Override
	public void cacheResult(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		entityCache.putResult(
			ProcedurePgProgdurationRelImpl.class,
			procedurePgProgdurationRel.getPrimaryKey(),
			procedurePgProgdurationRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				procedurePgProgdurationRel.getUuid(),
				procedurePgProgdurationRel.getGroupId()
			},
			procedurePgProgdurationRel);

		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId,
			new Object[] {
				procedurePgProgdurationRel.getProgramDurationId(),
				procedurePgProgdurationRel.getProcedureGroupMasterId(),
				procedurePgProgdurationRel.getProcedureMasterId()
			},
			procedurePgProgdurationRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the procedure pg progduration rels in the entity cache if it is enabled.
	 *
	 * @param procedurePgProgdurationRels the procedure pg progduration rels
	 */
	@Override
	public void cacheResult(
		List<ProcedurePgProgdurationRel> procedurePgProgdurationRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (procedurePgProgdurationRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
				procedurePgProgdurationRels) {

			if (entityCache.getResult(
					ProcedurePgProgdurationRelImpl.class,
					procedurePgProgdurationRel.getPrimaryKey()) == null) {

				cacheResult(procedurePgProgdurationRel);
			}
		}
	}

	/**
	 * Clears the cache for all procedure pg progduration rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProcedurePgProgdurationRelImpl.class);

		finderCache.clearCache(ProcedurePgProgdurationRelImpl.class);
	}

	/**
	 * Clears the cache for the procedure pg progduration rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		entityCache.removeResult(
			ProcedurePgProgdurationRelImpl.class, procedurePgProgdurationRel);
	}

	@Override
	public void clearCache(
		List<ProcedurePgProgdurationRel> procedurePgProgdurationRels) {

		for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
				procedurePgProgdurationRels) {

			entityCache.removeResult(
				ProcedurePgProgdurationRelImpl.class,
				procedurePgProgdurationRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProcedurePgProgdurationRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProcedurePgProgdurationRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProcedurePgProgdurationRelModelImpl
			procedurePgProgdurationRelModelImpl) {

		Object[] args = new Object[] {
			procedurePgProgdurationRelModelImpl.getUuid(),
			procedurePgProgdurationRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			procedurePgProgdurationRelModelImpl);

		args = new Object[] {
			procedurePgProgdurationRelModelImpl.getProgramDurationId(),
			procedurePgProgdurationRelModelImpl.getProcedureGroupMasterId(),
			procedurePgProgdurationRelModelImpl.getProcedureMasterId()
		};

		finderCache.putResult(
			_finderPathCountByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId,
			args, procedurePgProgdurationRelModelImpl);
	}

	/**
	 * Creates a new procedure pg progduration rel with the primary key. Does not add the procedure pg progduration rel to the database.
	 *
	 * @param procedurePgPdRelId the primary key for the new procedure pg progduration rel
	 * @return the new procedure pg progduration rel
	 */
	@Override
	public ProcedurePgProgdurationRel create(long procedurePgPdRelId) {
		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			new ProcedurePgProgdurationRelImpl();

		procedurePgProgdurationRel.setNew(true);
		procedurePgProgdurationRel.setPrimaryKey(procedurePgPdRelId);

		String uuid = _portalUUID.generate();

		procedurePgProgdurationRel.setUuid(uuid);

		procedurePgProgdurationRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return procedurePgProgdurationRel;
	}

	/**
	 * Removes the procedure pg progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel that was removed
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel remove(long procedurePgPdRelId)
		throws NoSuchProcedurePgProgdurationRelException {

		return remove((Serializable)procedurePgPdRelId);
	}

	/**
	 * Removes the procedure pg progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel that was removed
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel remove(Serializable primaryKey)
		throws NoSuchProcedurePgProgdurationRelException {

		Session session = null;

		try {
			session = openSession();

			ProcedurePgProgdurationRel procedurePgProgdurationRel =
				(ProcedurePgProgdurationRel)session.get(
					ProcedurePgProgdurationRelImpl.class, primaryKey);

			if (procedurePgProgdurationRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcedurePgProgdurationRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(procedurePgProgdurationRel);
		}
		catch (NoSuchProcedurePgProgdurationRelException
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
	protected ProcedurePgProgdurationRel removeImpl(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(procedurePgProgdurationRel)) {
				procedurePgProgdurationRel =
					(ProcedurePgProgdurationRel)session.get(
						ProcedurePgProgdurationRelImpl.class,
						procedurePgProgdurationRel.getPrimaryKeyObj());
			}

			if (procedurePgProgdurationRel != null) {
				session.delete(procedurePgProgdurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (procedurePgProgdurationRel != null) {
			clearCache(procedurePgProgdurationRel);
		}

		return procedurePgProgdurationRel;
	}

	@Override
	public ProcedurePgProgdurationRel updateImpl(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		boolean isNew = procedurePgProgdurationRel.isNew();

		if (!(procedurePgProgdurationRel instanceof
				ProcedurePgProgdurationRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(procedurePgProgdurationRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					procedurePgProgdurationRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in procedurePgProgdurationRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProcedurePgProgdurationRel implementation " +
					procedurePgProgdurationRel.getClass());
		}

		ProcedurePgProgdurationRelModelImpl
			procedurePgProgdurationRelModelImpl =
				(ProcedurePgProgdurationRelModelImpl)procedurePgProgdurationRel;

		if (Validator.isNull(procedurePgProgdurationRel.getUuid())) {
			String uuid = _portalUUID.generate();

			procedurePgProgdurationRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (procedurePgProgdurationRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				procedurePgProgdurationRel.setCreateDate(date);
			}
			else {
				procedurePgProgdurationRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!procedurePgProgdurationRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				procedurePgProgdurationRel.setModifiedDate(date);
			}
			else {
				procedurePgProgdurationRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(procedurePgProgdurationRel);
			}
			else {
				procedurePgProgdurationRel =
					(ProcedurePgProgdurationRel)session.merge(
						procedurePgProgdurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProcedurePgProgdurationRelImpl.class,
			procedurePgProgdurationRelModelImpl, false, true);

		cacheUniqueFindersCache(procedurePgProgdurationRelModelImpl);

		if (isNew) {
			procedurePgProgdurationRel.setNew(false);
		}

		procedurePgProgdurationRel.resetOriginalValues();

		return procedurePgProgdurationRel;
	}

	/**
	 * Returns the procedure pg progduration rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcedurePgProgdurationRelException {

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			fetchByPrimaryKey(primaryKey);

		if (procedurePgProgdurationRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcedurePgProgdurationRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return procedurePgProgdurationRel;
	}

	/**
	 * Returns the procedure pg progduration rel with the primary key or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel findByPrimaryKey(long procedurePgPdRelId)
		throws NoSuchProcedurePgProgdurationRelException {

		return findByPrimaryKey((Serializable)procedurePgPdRelId);
	}

	/**
	 * Returns the procedure pg progduration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel, or <code>null</code> if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public ProcedurePgProgdurationRel fetchByPrimaryKey(
		long procedurePgPdRelId) {

		return fetchByPrimaryKey((Serializable)procedurePgPdRelId);
	}

	/**
	 * Returns all the procedure pg progduration rels.
	 *
	 * @return the procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findAll(
		int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure pg progduration rels
	 */
	@Override
	public List<ProcedurePgProgdurationRel> findAll(
		int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
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

		List<ProcedurePgProgdurationRel> list = null;

		if (useFinderCache) {
			list = (List<ProcedurePgProgdurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCEDUREPGPROGDURATIONREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCEDUREPGPROGDURATIONREL;

				sql = sql.concat(
					ProcedurePgProgdurationRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProcedurePgProgdurationRel>)QueryUtil.list(
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
	 * Removes all the procedure pg progduration rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProcedurePgProgdurationRel procedurePgProgdurationRel :
				findAll()) {

			remove(procedurePgProgdurationRel);
		}
	}

	/**
	 * Returns the number of procedure pg progduration rels.
	 *
	 * @return the number of procedure pg progduration rels
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
					_SQL_COUNT_PROCEDUREPGPROGDURATIONREL);

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
		return "procedure_pg_pd_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCEDUREPGPROGDURATIONREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProcedurePgProgdurationRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the procedure pg progduration rel persistence.
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

		_finderPathWithPaginationFindByProcedureMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProcedureMasterId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"procedure_master_id"}, true);

		_finderPathWithoutPaginationFindByProcedureMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProcedureMasterId", new String[] {Long.class.getName()},
			new String[] {"procedure_master_id"}, true);

		_finderPathCountByProcedureMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcedureMasterId", new String[] {Long.class.getName()},
			new String[] {"procedure_master_id"}, false);

		_finderPathFetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"program_duration_id", "procedure_group_master_id",
					"procedure_master_id"
				},
				true);

		_finderPathCountByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"program_duration_id", "procedure_group_master_id",
					"procedure_master_id"
				},
				false);

		_setProcedurePgProgdurationRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProcedurePgProgdurationRelUtilPersistence(null);

		entityCache.removeCache(ProcedurePgProgdurationRelImpl.class.getName());
	}

	private void _setProcedurePgProgdurationRelUtilPersistence(
		ProcedurePgProgdurationRelPersistence
			procedurePgProgdurationRelPersistence) {

		try {
			Field field = ProcedurePgProgdurationRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, procedurePgProgdurationRelPersistence);
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

	private static final String _SQL_SELECT_PROCEDUREPGPROGDURATIONREL =
		"SELECT procedurePgProgdurationRel FROM ProcedurePgProgdurationRel procedurePgProgdurationRel";

	private static final String _SQL_SELECT_PROCEDUREPGPROGDURATIONREL_WHERE =
		"SELECT procedurePgProgdurationRel FROM ProcedurePgProgdurationRel procedurePgProgdurationRel WHERE ";

	private static final String _SQL_COUNT_PROCEDUREPGPROGDURATIONREL =
		"SELECT COUNT(procedurePgProgdurationRel) FROM ProcedurePgProgdurationRel procedurePgProgdurationRel";

	private static final String _SQL_COUNT_PROCEDUREPGPROGDURATIONREL_WHERE =
		"SELECT COUNT(procedurePgProgdurationRel) FROM ProcedurePgProgdurationRel procedurePgProgdurationRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"procedurePgProgdurationRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProcedurePgProgdurationRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProcedurePgProgdurationRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProcedurePgProgdurationRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "procedurePgPdRelId", "procedureGroupMasterId",
			"procedureMasterId", "programDurationId", "groupId", "companyId",
			"createDate", "modifiedDate", "createdBy", "modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
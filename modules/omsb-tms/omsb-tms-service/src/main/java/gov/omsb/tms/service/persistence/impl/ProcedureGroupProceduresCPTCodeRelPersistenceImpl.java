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

import gov.omsb.tms.exception.NoSuchProcedureGroupProceduresCPTCodeRelException;
import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel;
import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRelTable;
import gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelImpl;
import gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelModelImpl;
import gov.omsb.tms.service.persistence.ProcedureGroupProceduresCPTCodeRelPersistence;
import gov.omsb.tms.service.persistence.ProcedureGroupProceduresCPTCodeRelUtil;
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
 * The persistence implementation for the procedure group procedures cpt code rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProcedureGroupProceduresCPTCodeRelPersistence.class)
public class ProcedureGroupProceduresCPTCodeRelPersistenceImpl
	extends BasePersistenceImpl<ProcedureGroupProceduresCPTCodeRel>
	implements ProcedureGroupProceduresCPTCodeRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProcedureGroupProceduresCPTCodeRelUtil</code> to access the procedure group procedures cpt code rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProcedureGroupProceduresCPTCodeRelImpl.class.getName();

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
	 * Returns all the procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
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

		List<ProcedureGroupProceduresCPTCodeRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProcedureGroupProceduresCPTCodeRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureGroupProceduresCPTCodeRel
						procedureGroupProceduresCPTCodeRel : list) {

					if (!uuid.equals(
							procedureGroupProceduresCPTCodeRel.getUuid())) {

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

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

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
				sb.append(
					ProcedureGroupProceduresCPTCodeRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProcedureGroupProceduresCPTCodeRel>)QueryUtil.list(
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
	 * Returns the first procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByUuid_First(
			String uuid,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (procedureGroupProceduresCPTCodeRel != null) {
			return procedureGroupProceduresCPTCodeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
			sb.toString());
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		List<ProcedureGroupProceduresCPTCodeRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (procedureGroupProceduresCPTCodeRel != null) {
			return procedureGroupProceduresCPTCodeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
			sb.toString());
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProcedureGroupProceduresCPTCodeRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure group procedures cpt code rels before and after the current procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the current procedure group procedures cpt code rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel[] findByUuid_PrevAndNext(
			long pgProcedureCptCodeRelId, String uuid,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		uuid = Objects.toString(uuid, "");

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			findByPrimaryKey(pgProcedureCptCodeRelId);

		Session session = null;

		try {
			session = openSession();

			ProcedureGroupProceduresCPTCodeRel[] array =
				new ProcedureGroupProceduresCPTCodeRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, procedureGroupProceduresCPTCodeRel, uuid,
				orderByComparator, true);

			array[1] = procedureGroupProceduresCPTCodeRel;

			array[2] = getByUuid_PrevAndNext(
				session, procedureGroupProceduresCPTCodeRel, uuid,
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

	protected ProcedureGroupProceduresCPTCodeRel getByUuid_PrevAndNext(
		Session session,
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel,
		String uuid,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

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
			sb.append(
				ProcedureGroupProceduresCPTCodeRelModelImpl.ORDER_BY_JPQL);
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
						procedureGroupProceduresCPTCodeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureGroupProceduresCPTCodeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure group procedures cpt code rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(procedureGroupProceduresCPTCodeRel);
		}
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure group procedures cpt code rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

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
		"procedureGroupProceduresCPTCodeRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(procedureGroupProceduresCPTCodeRel.uuid IS NULL OR procedureGroupProceduresCPTCodeRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the procedure group procedures cpt code rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedureGroupProceduresCPTCodeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			fetchByUUID_G(uuid, groupId);

		if (procedureGroupProceduresCPTCodeRel == null) {
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

			throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
				sb.toString());
		}

		return procedureGroupProceduresCPTCodeRel;
	}

	/**
	 * Returns the procedure group procedures cpt code rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the procedure group procedures cpt code rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByUUID_G(
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

		if (result instanceof ProcedureGroupProceduresCPTCodeRel) {
			ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel =
					(ProcedureGroupProceduresCPTCodeRel)result;

			if (!Objects.equals(
					uuid, procedureGroupProceduresCPTCodeRel.getUuid()) ||
				(groupId != procedureGroupProceduresCPTCodeRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

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

				List<ProcedureGroupProceduresCPTCodeRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProcedureGroupProceduresCPTCodeRel
						procedureGroupProceduresCPTCodeRel = list.get(0);

					result = procedureGroupProceduresCPTCodeRel;

					cacheResult(procedureGroupProceduresCPTCodeRel);
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
			return (ProcedureGroupProceduresCPTCodeRel)result;
		}
	}

	/**
	 * Removes the procedure group procedures cpt code rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure group procedures cpt code rel that was removed
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			findByUUID_G(uuid, groupId);

		return remove(procedureGroupProceduresCPTCodeRel);
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure group procedures cpt code rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

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
		"procedureGroupProceduresCPTCodeRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(procedureGroupProceduresCPTCodeRel.uuid IS NULL OR procedureGroupProceduresCPTCodeRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"procedureGroupProceduresCPTCodeRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
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

		List<ProcedureGroupProceduresCPTCodeRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProcedureGroupProceduresCPTCodeRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureGroupProceduresCPTCodeRel
						procedureGroupProceduresCPTCodeRel : list) {

					if (!uuid.equals(
							procedureGroupProceduresCPTCodeRel.getUuid()) ||
						(companyId !=
							procedureGroupProceduresCPTCodeRel.
								getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

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
				sb.append(
					ProcedureGroupProceduresCPTCodeRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProcedureGroupProceduresCPTCodeRel>)QueryUtil.list(
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
	 * Returns the first procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (procedureGroupProceduresCPTCodeRel != null) {
			return procedureGroupProceduresCPTCodeRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
			sb.toString());
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		List<ProcedureGroupProceduresCPTCodeRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (procedureGroupProceduresCPTCodeRel != null) {
			return procedureGroupProceduresCPTCodeRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
			sb.toString());
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProcedureGroupProceduresCPTCodeRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure group procedures cpt code rels before and after the current procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the current procedure group procedures cpt code rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel[] findByUuid_C_PrevAndNext(
			long pgProcedureCptCodeRelId, String uuid, long companyId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		uuid = Objects.toString(uuid, "");

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			findByPrimaryKey(pgProcedureCptCodeRelId);

		Session session = null;

		try {
			session = openSession();

			ProcedureGroupProceduresCPTCodeRel[] array =
				new ProcedureGroupProceduresCPTCodeRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, procedureGroupProceduresCPTCodeRel, uuid, companyId,
				orderByComparator, true);

			array[1] = procedureGroupProceduresCPTCodeRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, procedureGroupProceduresCPTCodeRel, uuid, companyId,
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

	protected ProcedureGroupProceduresCPTCodeRel getByUuid_C_PrevAndNext(
		Session session,
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel,
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

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
			sb.append(
				ProcedureGroupProceduresCPTCodeRelModelImpl.ORDER_BY_JPQL);
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
						procedureGroupProceduresCPTCodeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureGroupProceduresCPTCodeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(procedureGroupProceduresCPTCodeRel);
		}
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure group procedures cpt code rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

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
		"procedureGroupProceduresCPTCodeRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(procedureGroupProceduresCPTCodeRel.uuid IS NULL OR procedureGroupProceduresCPTCodeRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"procedureGroupProceduresCPTCodeRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProcedureGroupId;
	private FinderPath _finderPathWithoutPaginationFindByProcedureGroupId;
	private FinderPath _finderPathCountByProcedureGroupId;

	/**
	 * Returns all the procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByProcedureGroupId(
		long procedureGroupId) {

		return findByProcedureGroupId(
			procedureGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByProcedureGroupId(
		long procedureGroupId, int start, int end) {

		return findByProcedureGroupId(procedureGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByProcedureGroupId(
		long procedureGroupId, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return findByProcedureGroupId(
			procedureGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findByProcedureGroupId(
		long procedureGroupId, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProcedureGroupId;
				finderArgs = new Object[] {procedureGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProcedureGroupId;
			finderArgs = new Object[] {
				procedureGroupId, start, end, orderByComparator
			};
		}

		List<ProcedureGroupProceduresCPTCodeRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProcedureGroupProceduresCPTCodeRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureGroupProceduresCPTCodeRel
						procedureGroupProceduresCPTCodeRel : list) {

					if (procedureGroupId !=
							procedureGroupProceduresCPTCodeRel.
								getProcedureGroupId()) {

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

			sb.append(_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDUREGROUPID_PROCEDUREGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProcedureGroupProceduresCPTCodeRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureGroupId);

				list = (List<ProcedureGroupProceduresCPTCodeRel>)QueryUtil.list(
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
	 * Returns the first procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByProcedureGroupId_First(
			long procedureGroupId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			fetchByProcedureGroupId_First(procedureGroupId, orderByComparator);

		if (procedureGroupProceduresCPTCodeRel != null) {
			return procedureGroupProceduresCPTCodeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupId=");
		sb.append(procedureGroupId);

		sb.append("}");

		throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
			sb.toString());
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByProcedureGroupId_First(
		long procedureGroupId,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		List<ProcedureGroupProceduresCPTCodeRel> list = findByProcedureGroupId(
			procedureGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByProcedureGroupId_Last(
			long procedureGroupId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			fetchByProcedureGroupId_Last(procedureGroupId, orderByComparator);

		if (procedureGroupProceduresCPTCodeRel != null) {
			return procedureGroupProceduresCPTCodeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupId=");
		sb.append(procedureGroupId);

		sb.append("}");

		throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
			sb.toString());
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByProcedureGroupId_Last(
		long procedureGroupId,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		int count = countByProcedureGroupId(procedureGroupId);

		if (count == 0) {
			return null;
		}

		List<ProcedureGroupProceduresCPTCodeRel> list = findByProcedureGroupId(
			procedureGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure group procedures cpt code rels before and after the current procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the current procedure group procedures cpt code rel
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel[]
			findByProcedureGroupId_PrevAndNext(
				long pgProcedureCptCodeRelId, long procedureGroupId,
				OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
					orderByComparator)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			findByPrimaryKey(pgProcedureCptCodeRelId);

		Session session = null;

		try {
			session = openSession();

			ProcedureGroupProceduresCPTCodeRel[] array =
				new ProcedureGroupProceduresCPTCodeRelImpl[3];

			array[0] = getByProcedureGroupId_PrevAndNext(
				session, procedureGroupProceduresCPTCodeRel, procedureGroupId,
				orderByComparator, true);

			array[1] = procedureGroupProceduresCPTCodeRel;

			array[2] = getByProcedureGroupId_PrevAndNext(
				session, procedureGroupProceduresCPTCodeRel, procedureGroupId,
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

	protected ProcedureGroupProceduresCPTCodeRel
		getByProcedureGroupId_PrevAndNext(
			Session session,
			ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel,
			long procedureGroupId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

		sb.append(_FINDER_COLUMN_PROCEDUREGROUPID_PROCEDUREGROUPID_2);

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
			sb.append(
				ProcedureGroupProceduresCPTCodeRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(procedureGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						procedureGroupProceduresCPTCodeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureGroupProceduresCPTCodeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure group procedures cpt code rels where procedureGroupId = &#63; from the database.
	 *
	 * @param procedureGroupId the procedure group ID
	 */
	@Override
	public void removeByProcedureGroupId(long procedureGroupId) {
		for (ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel :
					findByProcedureGroupId(
						procedureGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(procedureGroupProceduresCPTCodeRel);
		}
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the number of matching procedure group procedures cpt code rels
	 */
	@Override
	public int countByProcedureGroupId(long procedureGroupId) {
		FinderPath finderPath = _finderPathCountByProcedureGroupId;

		Object[] finderArgs = new Object[] {procedureGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDUREGROUPID_PROCEDUREGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureGroupId);

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
		_FINDER_COLUMN_PROCEDUREGROUPID_PROCEDUREGROUPID_2 =
			"procedureGroupProceduresCPTCodeRel.procedureGroupId = ?";

	public ProcedureGroupProceduresCPTCodeRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"pgProcedureCptCodeRelId", "pg_procedures_cpt_rel_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("procedureGroupId", "procedure_group_id");
		dbColumnNames.put("procedureId", "procedure_id");
		dbColumnNames.put("cptCodeId", "cpt_code_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProcedureGroupProceduresCPTCodeRel.class);

		setModelImplClass(ProcedureGroupProceduresCPTCodeRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProcedureGroupProceduresCPTCodeRelTable.INSTANCE);
	}

	/**
	 * Caches the procedure group procedures cpt code rel in the entity cache if it is enabled.
	 *
	 * @param procedureGroupProceduresCPTCodeRel the procedure group procedures cpt code rel
	 */
	@Override
	public void cacheResult(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		entityCache.putResult(
			ProcedureGroupProceduresCPTCodeRelImpl.class,
			procedureGroupProceduresCPTCodeRel.getPrimaryKey(),
			procedureGroupProceduresCPTCodeRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				procedureGroupProceduresCPTCodeRel.getUuid(),
				procedureGroupProceduresCPTCodeRel.getGroupId()
			},
			procedureGroupProceduresCPTCodeRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the procedure group procedures cpt code rels in the entity cache if it is enabled.
	 *
	 * @param procedureGroupProceduresCPTCodeRels the procedure group procedures cpt code rels
	 */
	@Override
	public void cacheResult(
		List<ProcedureGroupProceduresCPTCodeRel>
			procedureGroupProceduresCPTCodeRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (procedureGroupProceduresCPTCodeRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel :
					procedureGroupProceduresCPTCodeRels) {

			if (entityCache.getResult(
					ProcedureGroupProceduresCPTCodeRelImpl.class,
					procedureGroupProceduresCPTCodeRel.getPrimaryKey()) ==
						null) {

				cacheResult(procedureGroupProceduresCPTCodeRel);
			}
		}
	}

	/**
	 * Clears the cache for all procedure group procedures cpt code rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProcedureGroupProceduresCPTCodeRelImpl.class);

		finderCache.clearCache(ProcedureGroupProceduresCPTCodeRelImpl.class);
	}

	/**
	 * Clears the cache for the procedure group procedures cpt code rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		entityCache.removeResult(
			ProcedureGroupProceduresCPTCodeRelImpl.class,
			procedureGroupProceduresCPTCodeRel);
	}

	@Override
	public void clearCache(
		List<ProcedureGroupProceduresCPTCodeRel>
			procedureGroupProceduresCPTCodeRels) {

		for (ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel :
					procedureGroupProceduresCPTCodeRels) {

			entityCache.removeResult(
				ProcedureGroupProceduresCPTCodeRelImpl.class,
				procedureGroupProceduresCPTCodeRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProcedureGroupProceduresCPTCodeRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProcedureGroupProceduresCPTCodeRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProcedureGroupProceduresCPTCodeRelModelImpl
			procedureGroupProceduresCPTCodeRelModelImpl) {

		Object[] args = new Object[] {
			procedureGroupProceduresCPTCodeRelModelImpl.getUuid(),
			procedureGroupProceduresCPTCodeRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			procedureGroupProceduresCPTCodeRelModelImpl);
	}

	/**
	 * Creates a new procedure group procedures cpt code rel with the primary key. Does not add the procedure group procedures cpt code rel to the database.
	 *
	 * @param pgProcedureCptCodeRelId the primary key for the new procedure group procedures cpt code rel
	 * @return the new procedure group procedures cpt code rel
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel create(
		long pgProcedureCptCodeRelId) {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			new ProcedureGroupProceduresCPTCodeRelImpl();

		procedureGroupProceduresCPTCodeRel.setNew(true);
		procedureGroupProceduresCPTCodeRel.setPrimaryKey(
			pgProcedureCptCodeRelId);

		String uuid = _portalUUID.generate();

		procedureGroupProceduresCPTCodeRel.setUuid(uuid);

		procedureGroupProceduresCPTCodeRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return procedureGroupProceduresCPTCodeRel;
	}

	/**
	 * Removes the procedure group procedures cpt code rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was removed
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel remove(
			long pgProcedureCptCodeRelId)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		return remove((Serializable)pgProcedureCptCodeRelId);
	}

	/**
	 * Removes the procedure group procedures cpt code rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was removed
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel remove(Serializable primaryKey)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		Session session = null;

		try {
			session = openSession();

			ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel =
					(ProcedureGroupProceduresCPTCodeRel)session.get(
						ProcedureGroupProceduresCPTCodeRelImpl.class,
						primaryKey);

			if (procedureGroupProceduresCPTCodeRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(procedureGroupProceduresCPTCodeRel);
		}
		catch (NoSuchProcedureGroupProceduresCPTCodeRelException
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
	protected ProcedureGroupProceduresCPTCodeRel removeImpl(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(procedureGroupProceduresCPTCodeRel)) {
				procedureGroupProceduresCPTCodeRel =
					(ProcedureGroupProceduresCPTCodeRel)session.get(
						ProcedureGroupProceduresCPTCodeRelImpl.class,
						procedureGroupProceduresCPTCodeRel.getPrimaryKeyObj());
			}

			if (procedureGroupProceduresCPTCodeRel != null) {
				session.delete(procedureGroupProceduresCPTCodeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (procedureGroupProceduresCPTCodeRel != null) {
			clearCache(procedureGroupProceduresCPTCodeRel);
		}

		return procedureGroupProceduresCPTCodeRel;
	}

	@Override
	public ProcedureGroupProceduresCPTCodeRel updateImpl(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		boolean isNew = procedureGroupProceduresCPTCodeRel.isNew();

		if (!(procedureGroupProceduresCPTCodeRel instanceof
				ProcedureGroupProceduresCPTCodeRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					procedureGroupProceduresCPTCodeRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					procedureGroupProceduresCPTCodeRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in procedureGroupProceduresCPTCodeRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProcedureGroupProceduresCPTCodeRel implementation " +
					procedureGroupProceduresCPTCodeRel.getClass());
		}

		ProcedureGroupProceduresCPTCodeRelModelImpl
			procedureGroupProceduresCPTCodeRelModelImpl =
				(ProcedureGroupProceduresCPTCodeRelModelImpl)
					procedureGroupProceduresCPTCodeRel;

		if (Validator.isNull(procedureGroupProceduresCPTCodeRel.getUuid())) {
			String uuid = _portalUUID.generate();

			procedureGroupProceduresCPTCodeRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(procedureGroupProceduresCPTCodeRel.getCreateDate() == null)) {

			if (serviceContext == null) {
				procedureGroupProceduresCPTCodeRel.setCreateDate(date);
			}
			else {
				procedureGroupProceduresCPTCodeRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!procedureGroupProceduresCPTCodeRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				procedureGroupProceduresCPTCodeRel.setModifiedDate(date);
			}
			else {
				procedureGroupProceduresCPTCodeRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(procedureGroupProceduresCPTCodeRel);
			}
			else {
				procedureGroupProceduresCPTCodeRel =
					(ProcedureGroupProceduresCPTCodeRel)session.merge(
						procedureGroupProceduresCPTCodeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProcedureGroupProceduresCPTCodeRelImpl.class,
			procedureGroupProceduresCPTCodeRelModelImpl, false, true);

		cacheUniqueFindersCache(procedureGroupProceduresCPTCodeRelModelImpl);

		if (isNew) {
			procedureGroupProceduresCPTCodeRel.setNew(false);
		}

		procedureGroupProceduresCPTCodeRel.resetOriginalValues();

		return procedureGroupProceduresCPTCodeRel;
	}

	/**
	 * Returns the procedure group procedures cpt code rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			fetchByPrimaryKey(primaryKey);

		if (procedureGroupProceduresCPTCodeRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcedureGroupProceduresCPTCodeRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return procedureGroupProceduresCPTCodeRel;
	}

	/**
	 * Returns the procedure group procedures cpt code rel with the primary key or throws a <code>NoSuchProcedureGroupProceduresCPTCodeRelException</code> if it could not be found.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel findByPrimaryKey(
			long pgProcedureCptCodeRelId)
		throws NoSuchProcedureGroupProceduresCPTCodeRelException {

		return findByPrimaryKey((Serializable)pgProcedureCptCodeRelId);
	}

	/**
	 * Returns the procedure group procedures cpt code rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel, or <code>null</code> if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public ProcedureGroupProceduresCPTCodeRel fetchByPrimaryKey(
		long pgProcedureCptCodeRelId) {

		return fetchByPrimaryKey((Serializable)pgProcedureCptCodeRelId);
	}

	/**
	 * Returns all the procedure group procedures cpt code rels.
	 *
	 * @return the procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findAll(
		int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure group procedures cpt code rels
	 */
	@Override
	public List<ProcedureGroupProceduresCPTCodeRel> findAll(
		int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
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

		List<ProcedureGroupProceduresCPTCodeRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProcedureGroupProceduresCPTCodeRel>)finderCache.getResult(
					finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL;

				sql = sql.concat(
					ProcedureGroupProceduresCPTCodeRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProcedureGroupProceduresCPTCodeRel>)QueryUtil.list(
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
	 * Removes all the procedure group procedures cpt code rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel : findAll()) {

			remove(procedureGroupProceduresCPTCodeRel);
		}
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels.
	 *
	 * @return the number of procedure group procedures cpt code rels
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
					_SQL_COUNT_PROCEDUREGROUPPROCEDURESCPTCODEREL);

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
		return "pg_procedures_cpt_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProcedureGroupProceduresCPTCodeRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the procedure group procedures cpt code rel persistence.
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

		_finderPathWithPaginationFindByProcedureGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProcedureGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"procedure_group_id"}, true);

		_finderPathWithoutPaginationFindByProcedureGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProcedureGroupId",
			new String[] {Long.class.getName()},
			new String[] {"procedure_group_id"}, true);

		_finderPathCountByProcedureGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcedureGroupId", new String[] {Long.class.getName()},
			new String[] {"procedure_group_id"}, false);

		_setProcedureGroupProceduresCPTCodeRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProcedureGroupProceduresCPTCodeRelUtilPersistence(null);

		entityCache.removeCache(
			ProcedureGroupProceduresCPTCodeRelImpl.class.getName());
	}

	private void _setProcedureGroupProceduresCPTCodeRelUtilPersistence(
		ProcedureGroupProceduresCPTCodeRelPersistence
			procedureGroupProceduresCPTCodeRelPersistence) {

		try {
			Field field =
				ProcedureGroupProceduresCPTCodeRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, procedureGroupProceduresCPTCodeRelPersistence);
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

	private static final String _SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL =
		"SELECT procedureGroupProceduresCPTCodeRel FROM ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel";

	private static final String
		_SQL_SELECT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE =
			"SELECT procedureGroupProceduresCPTCodeRel FROM ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel WHERE ";

	private static final String _SQL_COUNT_PROCEDUREGROUPPROCEDURESCPTCODEREL =
		"SELECT COUNT(procedureGroupProceduresCPTCodeRel) FROM ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel";

	private static final String
		_SQL_COUNT_PROCEDUREGROUPPROCEDURESCPTCODEREL_WHERE =
			"SELECT COUNT(procedureGroupProceduresCPTCodeRel) FROM ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"procedureGroupProceduresCPTCodeRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProcedureGroupProceduresCPTCodeRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProcedureGroupProceduresCPTCodeRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProcedureGroupProceduresCPTCodeRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "pgProcedureCptCodeRelId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy",
			"procedureGroupId", "procedureId", "cptCodeId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
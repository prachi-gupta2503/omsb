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

import gov.omsb.tms.exception.NoSuchProcedureMasterException;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.ProcedureMasterTable;
import gov.omsb.tms.model.impl.ProcedureMasterImpl;
import gov.omsb.tms.model.impl.ProcedureMasterModelImpl;
import gov.omsb.tms.service.persistence.ProcedureMasterPersistence;
import gov.omsb.tms.service.persistence.ProcedureMasterUtil;
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
 * The persistence implementation for the procedure master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProcedureMasterPersistence.class)
public class ProcedureMasterPersistenceImpl
	extends BasePersistenceImpl<ProcedureMaster>
	implements ProcedureMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProcedureMasterUtil</code> to access the procedure master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProcedureMasterImpl.class.getName();

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
	 * Returns all the procedure masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
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

		List<ProcedureMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureMaster procedureMaster : list) {
					if (!uuid.equals(procedureMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

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
				sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProcedureMaster>)QueryUtil.list(
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
	 * Returns the first procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByUuid_First(
			String uuid, OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByUuid_First(
		String uuid, OrderByComparator<ProcedureMaster> orderByComparator) {

		List<ProcedureMaster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByUuid_Last(
			String uuid, OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByUuid_Last(
		String uuid, OrderByComparator<ProcedureMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProcedureMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster[] findByUuid_PrevAndNext(
			long procedureMasterId, String uuid,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		uuid = Objects.toString(uuid, "");

		ProcedureMaster procedureMaster = findByPrimaryKey(procedureMasterId);

		Session session = null;

		try {
			session = openSession();

			ProcedureMaster[] array = new ProcedureMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, procedureMaster, uuid, orderByComparator, true);

			array[1] = procedureMaster;

			array[2] = getByUuid_PrevAndNext(
				session, procedureMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProcedureMaster getByUuid_PrevAndNext(
		Session session, ProcedureMaster procedureMaster, String uuid,
		OrderByComparator<ProcedureMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

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
			sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
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
						procedureMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProcedureMaster procedureMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(procedureMaster);
		}
	}

	/**
	 * Returns the number of procedure masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREMASTER_WHERE);

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
		"procedureMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(procedureMaster.uuid IS NULL OR procedureMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedureMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByUUID_G(uuid, groupId);

		if (procedureMaster == null) {
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

			throw new NoSuchProcedureMasterException(sb.toString());
		}

		return procedureMaster;
	}

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByUUID_G(
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

		if (result instanceof ProcedureMaster) {
			ProcedureMaster procedureMaster = (ProcedureMaster)result;

			if (!Objects.equals(uuid, procedureMaster.getUuid()) ||
				(groupId != procedureMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

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

				List<ProcedureMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProcedureMaster procedureMaster = list.get(0);

					result = procedureMaster;

					cacheResult(procedureMaster);
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
			return (ProcedureMaster)result;
		}
	}

	/**
	 * Removes the procedure master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure master that was removed
	 */
	@Override
	public ProcedureMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = findByUUID_G(uuid, groupId);

		return remove(procedureMaster);
	}

	/**
	 * Returns the number of procedure masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREMASTER_WHERE);

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
		"procedureMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(procedureMaster.uuid IS NULL OR procedureMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"procedureMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
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

		List<ProcedureMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureMaster procedureMaster : list) {
					if (!uuid.equals(procedureMaster.getUuid()) ||
						(companyId != procedureMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

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
				sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProcedureMaster>)QueryUtil.list(
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
	 * Returns the first procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		List<ProcedureMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProcedureMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster[] findByUuid_C_PrevAndNext(
			long procedureMasterId, String uuid, long companyId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		uuid = Objects.toString(uuid, "");

		ProcedureMaster procedureMaster = findByPrimaryKey(procedureMasterId);

		Session session = null;

		try {
			session = openSession();

			ProcedureMaster[] array = new ProcedureMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, procedureMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = procedureMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, procedureMaster, uuid, companyId, orderByComparator,
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

	protected ProcedureMaster getByUuid_C_PrevAndNext(
		Session session, ProcedureMaster procedureMaster, String uuid,
		long companyId, OrderByComparator<ProcedureMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

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
			sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
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
						procedureMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProcedureMaster procedureMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedureMaster);
		}
	}

	/**
	 * Returns the number of procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREMASTER_WHERE);

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
		"procedureMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(procedureMaster.uuid IS NULL OR procedureMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"procedureMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProcedureNameByLike;
	private FinderPath _finderPathWithPaginationCountByProcedureNameByLike;

	/**
	 * Returns all the procedure masters where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @return the matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName) {

		return findByProcedureNameByLike(
			procedureName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end) {

		return findByProcedureNameByLike(procedureName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return findByProcedureNameByLike(
			procedureName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
		boolean useFinderCache) {

		procedureName = Objects.toString(procedureName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByProcedureNameByLike;
		finderArgs = new Object[] {
			procedureName, start, end, orderByComparator
		};

		List<ProcedureMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureMaster procedureMaster : list) {
					if (!StringUtil.wildcardMatches(
							procedureMaster.getProcedureName(), procedureName,
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

			sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

			boolean bindProcedureName = false;

			if (procedureName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROCEDURENAMEBYLIKE_PROCEDURENAME_3);
			}
			else {
				bindProcedureName = true;

				sb.append(_FINDER_COLUMN_PROCEDURENAMEBYLIKE_PROCEDURENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProcedureName) {
					queryPos.add(StringUtil.toLowerCase(procedureName));
				}

				list = (List<ProcedureMaster>)QueryUtil.list(
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
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByProcedureNameByLike_First(
			String procedureName,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByProcedureNameByLike_First(
			procedureName, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureNameLIKE");
		sb.append(procedureName);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByProcedureNameByLike_First(
		String procedureName,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		List<ProcedureMaster> list = findByProcedureNameByLike(
			procedureName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByProcedureNameByLike_Last(
			String procedureName,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByProcedureNameByLike_Last(
			procedureName, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureNameLIKE");
		sb.append(procedureName);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByProcedureNameByLike_Last(
		String procedureName,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		int count = countByProcedureNameByLike(procedureName);

		if (count == 0) {
			return null;
		}

		List<ProcedureMaster> list = findByProcedureNameByLike(
			procedureName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster[] findByProcedureNameByLike_PrevAndNext(
			long procedureMasterId, String procedureName,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		procedureName = Objects.toString(procedureName, "");

		ProcedureMaster procedureMaster = findByPrimaryKey(procedureMasterId);

		Session session = null;

		try {
			session = openSession();

			ProcedureMaster[] array = new ProcedureMasterImpl[3];

			array[0] = getByProcedureNameByLike_PrevAndNext(
				session, procedureMaster, procedureName, orderByComparator,
				true);

			array[1] = procedureMaster;

			array[2] = getByProcedureNameByLike_PrevAndNext(
				session, procedureMaster, procedureName, orderByComparator,
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

	protected ProcedureMaster getByProcedureNameByLike_PrevAndNext(
		Session session, ProcedureMaster procedureMaster, String procedureName,
		OrderByComparator<ProcedureMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

		boolean bindProcedureName = false;

		if (procedureName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PROCEDURENAMEBYLIKE_PROCEDURENAME_3);
		}
		else {
			bindProcedureName = true;

			sb.append(_FINDER_COLUMN_PROCEDURENAMEBYLIKE_PROCEDURENAME_2);
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
			sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindProcedureName) {
			queryPos.add(StringUtil.toLowerCase(procedureName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						procedureMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure masters where procedureName LIKE &#63; from the database.
	 *
	 * @param procedureName the procedure name
	 */
	@Override
	public void removeByProcedureNameByLike(String procedureName) {
		for (ProcedureMaster procedureMaster :
				findByProcedureNameByLike(
					procedureName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedureMaster);
		}
	}

	/**
	 * Returns the number of procedure masters where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @return the number of matching procedure masters
	 */
	@Override
	public int countByProcedureNameByLike(String procedureName) {
		procedureName = Objects.toString(procedureName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByProcedureNameByLike;

		Object[] finderArgs = new Object[] {procedureName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREMASTER_WHERE);

			boolean bindProcedureName = false;

			if (procedureName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROCEDURENAMEBYLIKE_PROCEDURENAME_3);
			}
			else {
				bindProcedureName = true;

				sb.append(_FINDER_COLUMN_PROCEDURENAMEBYLIKE_PROCEDURENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProcedureName) {
					queryPos.add(StringUtil.toLowerCase(procedureName));
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
		_FINDER_COLUMN_PROCEDURENAMEBYLIKE_PROCEDURENAME_2 =
			"lower(procedureMaster.procedureName) LIKE ?";

	private static final String
		_FINDER_COLUMN_PROCEDURENAMEBYLIKE_PROCEDURENAME_3 =
			"(procedureMaster.procedureName IS NULL OR procedureMaster.procedureName LIKE '')";

	private FinderPath
		_finderPathWithPaginationFindByProcedureNameByLikeAndProcedureGroupMasterId;
	private FinderPath
		_finderPathWithPaginationCountByProcedureNameByLikeAndProcedureGroupMasterId;

	/**
	 * Returns all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure masters
	 */
	@Override
	public List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId) {

		return findByProcedureNameByLikeAndProcedureGroupMasterId(
			procedureName, procedureGroupMasterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end) {

		return findByProcedureNameByLikeAndProcedureGroupMasterId(
			procedureName, procedureGroupMasterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end, OrderByComparator<ProcedureMaster> orderByComparator) {

		return findByProcedureNameByLikeAndProcedureGroupMasterId(
			procedureName, procedureGroupMasterId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end, OrderByComparator<ProcedureMaster> orderByComparator,
			boolean useFinderCache) {

		procedureName = Objects.toString(procedureName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath =
			_finderPathWithPaginationFindByProcedureNameByLikeAndProcedureGroupMasterId;
		finderArgs = new Object[] {
			procedureName, procedureGroupMasterId, start, end, orderByComparator
		};

		List<ProcedureMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureMaster procedureMaster : list) {
					if (!StringUtil.wildcardMatches(
							procedureMaster.getProcedureName(), procedureName,
							'_', '%', '\\', false) ||
						(procedureGroupMasterId !=
							procedureMaster.getProcedureGroupMasterId())) {

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

			sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

			boolean bindProcedureName = false;

			if (procedureName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDURENAME_3);
			}
			else {
				bindProcedureName = true;

				sb.append(
					_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDURENAME_2);
			}

			sb.append(
				_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProcedureName) {
					queryPos.add(StringUtil.toLowerCase(procedureName));
				}

				queryPos.add(procedureGroupMasterId);

				list = (List<ProcedureMaster>)QueryUtil.list(
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
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster
			findByProcedureNameByLikeAndProcedureGroupMasterId_First(
				String procedureName, long procedureGroupMasterId,
				OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster =
			fetchByProcedureNameByLikeAndProcedureGroupMasterId_First(
				procedureName, procedureGroupMasterId, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureNameLIKE");
		sb.append(procedureName);

		sb.append(", procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster
		fetchByProcedureNameByLikeAndProcedureGroupMasterId_First(
			String procedureName, long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator) {

		List<ProcedureMaster> list =
			findByProcedureNameByLikeAndProcedureGroupMasterId(
				procedureName, procedureGroupMasterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster
			findByProcedureNameByLikeAndProcedureGroupMasterId_Last(
				String procedureName, long procedureGroupMasterId,
				OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster =
			fetchByProcedureNameByLikeAndProcedureGroupMasterId_Last(
				procedureName, procedureGroupMasterId, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureNameLIKE");
		sb.append(procedureName);

		sb.append(", procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster
		fetchByProcedureNameByLikeAndProcedureGroupMasterId_Last(
			String procedureName, long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator) {

		int count = countByProcedureNameByLikeAndProcedureGroupMasterId(
			procedureName, procedureGroupMasterId);

		if (count == 0) {
			return null;
		}

		List<ProcedureMaster> list =
			findByProcedureNameByLikeAndProcedureGroupMasterId(
				procedureName, procedureGroupMasterId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster[]
			findByProcedureNameByLikeAndProcedureGroupMasterId_PrevAndNext(
				long procedureMasterId, String procedureName,
				long procedureGroupMasterId,
				OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		procedureName = Objects.toString(procedureName, "");

		ProcedureMaster procedureMaster = findByPrimaryKey(procedureMasterId);

		Session session = null;

		try {
			session = openSession();

			ProcedureMaster[] array = new ProcedureMasterImpl[3];

			array[0] =
				getByProcedureNameByLikeAndProcedureGroupMasterId_PrevAndNext(
					session, procedureMaster, procedureName,
					procedureGroupMasterId, orderByComparator, true);

			array[1] = procedureMaster;

			array[2] =
				getByProcedureNameByLikeAndProcedureGroupMasterId_PrevAndNext(
					session, procedureMaster, procedureName,
					procedureGroupMasterId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProcedureMaster
		getByProcedureNameByLikeAndProcedureGroupMasterId_PrevAndNext(
			Session session, ProcedureMaster procedureMaster,
			String procedureName, long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

		boolean bindProcedureName = false;

		if (procedureName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDURENAME_3);
		}
		else {
			bindProcedureName = true;

			sb.append(
				_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDURENAME_2);
		}

		sb.append(
			_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

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
			sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindProcedureName) {
			queryPos.add(StringUtil.toLowerCase(procedureName));
		}

		queryPos.add(procedureGroupMasterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						procedureMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	@Override
	public void removeByProcedureNameByLikeAndProcedureGroupMasterId(
		String procedureName, long procedureGroupMasterId) {

		for (ProcedureMaster procedureMaster :
				findByProcedureNameByLikeAndProcedureGroupMasterId(
					procedureName, procedureGroupMasterId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(procedureMaster);
		}
	}

	/**
	 * Returns the number of procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure masters
	 */
	@Override
	public int countByProcedureNameByLikeAndProcedureGroupMasterId(
		String procedureName, long procedureGroupMasterId) {

		procedureName = Objects.toString(procedureName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByProcedureNameByLikeAndProcedureGroupMasterId;

		Object[] finderArgs = new Object[] {
			procedureName, procedureGroupMasterId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREMASTER_WHERE);

			boolean bindProcedureName = false;

			if (procedureName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDURENAME_3);
			}
			else {
				bindProcedureName = true;

				sb.append(
					_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDURENAME_2);
			}

			sb.append(
				_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProcedureName) {
					queryPos.add(StringUtil.toLowerCase(procedureName));
				}

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
		_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDURENAME_2 =
			"lower(procedureMaster.procedureName) LIKE ? AND ";

	private static final String
		_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDURENAME_3 =
			"(procedureMaster.procedureName IS NULL OR procedureMaster.procedureName LIKE '') AND ";

	private static final String
		_FINDER_COLUMN_PROCEDURENAMEBYLIKEANDPROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2 =
			"procedureMaster.procedureGroupMasterId = ?";

	private FinderPath _finderPathWithPaginationFindByProcedureGroupMasterId;
	private FinderPath _finderPathWithoutPaginationFindByProcedureGroupMasterId;
	private FinderPath _finderPathCountByProcedureGroupMasterId;

	/**
	 * Returns all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	@Override
	public List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
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

		List<ProcedureMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureMaster procedureMaster : list) {
					if (procedureGroupMasterId !=
							procedureMaster.getProcedureGroupMasterId()) {

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

			sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

			sb.append(
				_FINDER_COLUMN_PROCEDUREGROUPMASTERID_PROCEDUREGROUPMASTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureGroupMasterId);

				list = (List<ProcedureMaster>)QueryUtil.list(
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
	 * Returns the first procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByProcedureGroupMasterId_First(
			procedureGroupMasterId, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByProcedureGroupMasterId_First(
		long procedureGroupMasterId,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		List<ProcedureMaster> list = findByProcedureGroupMasterId(
			procedureGroupMasterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster findByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByProcedureGroupMasterId_Last(
			procedureGroupMasterId, orderByComparator);

		if (procedureMaster != null) {
			return procedureMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);

		sb.append("}");

		throw new NoSuchProcedureMasterException(sb.toString());
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public ProcedureMaster fetchByProcedureGroupMasterId_Last(
		long procedureGroupMasterId,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		int count = countByProcedureGroupMasterId(procedureGroupMasterId);

		if (count == 0) {
			return null;
		}

		List<ProcedureMaster> list = findByProcedureGroupMasterId(
			procedureGroupMasterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster[] findByProcedureGroupMasterId_PrevAndNext(
			long procedureMasterId, long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = findByPrimaryKey(procedureMasterId);

		Session session = null;

		try {
			session = openSession();

			ProcedureMaster[] array = new ProcedureMasterImpl[3];

			array[0] = getByProcedureGroupMasterId_PrevAndNext(
				session, procedureMaster, procedureGroupMasterId,
				orderByComparator, true);

			array[1] = procedureMaster;

			array[2] = getByProcedureGroupMasterId_PrevAndNext(
				session, procedureMaster, procedureGroupMasterId,
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

	protected ProcedureMaster getByProcedureGroupMasterId_PrevAndNext(
		Session session, ProcedureMaster procedureMaster,
		long procedureGroupMasterId,
		OrderByComparator<ProcedureMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREMASTER_WHERE);

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
			sb.append(ProcedureMasterModelImpl.ORDER_BY_JPQL);
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
						procedureMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure masters where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	@Override
	public void removeByProcedureGroupMasterId(long procedureGroupMasterId) {
		for (ProcedureMaster procedureMaster :
				findByProcedureGroupMasterId(
					procedureGroupMasterId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(procedureMaster);
		}
	}

	/**
	 * Returns the number of procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure masters
	 */
	@Override
	public int countByProcedureGroupMasterId(long procedureGroupMasterId) {
		FinderPath finderPath = _finderPathCountByProcedureGroupMasterId;

		Object[] finderArgs = new Object[] {procedureGroupMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREMASTER_WHERE);

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
			"procedureMaster.procedureGroupMasterId = ?";

	public ProcedureMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("procedureMasterId", "procedure_master_id");
		dbColumnNames.put(
			"procedureGroupMasterId", "procedure_group_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("procedureName", "procedure_name");
		dbColumnNames.put("cptCode", "cpt_code");
		dbColumnNames.put("isMandatory", "is_mandatory");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProcedureMaster.class);

		setModelImplClass(ProcedureMasterImpl.class);
		setModelPKClass(long.class);

		setTable(ProcedureMasterTable.INSTANCE);
	}

	/**
	 * Caches the procedure master in the entity cache if it is enabled.
	 *
	 * @param procedureMaster the procedure master
	 */
	@Override
	public void cacheResult(ProcedureMaster procedureMaster) {
		entityCache.putResult(
			ProcedureMasterImpl.class, procedureMaster.getPrimaryKey(),
			procedureMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				procedureMaster.getUuid(), procedureMaster.getGroupId()
			},
			procedureMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the procedure masters in the entity cache if it is enabled.
	 *
	 * @param procedureMasters the procedure masters
	 */
	@Override
	public void cacheResult(List<ProcedureMaster> procedureMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (procedureMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProcedureMaster procedureMaster : procedureMasters) {
			if (entityCache.getResult(
					ProcedureMasterImpl.class,
					procedureMaster.getPrimaryKey()) == null) {

				cacheResult(procedureMaster);
			}
		}
	}

	/**
	 * Clears the cache for all procedure masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProcedureMasterImpl.class);

		finderCache.clearCache(ProcedureMasterImpl.class);
	}

	/**
	 * Clears the cache for the procedure master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProcedureMaster procedureMaster) {
		entityCache.removeResult(ProcedureMasterImpl.class, procedureMaster);
	}

	@Override
	public void clearCache(List<ProcedureMaster> procedureMasters) {
		for (ProcedureMaster procedureMaster : procedureMasters) {
			entityCache.removeResult(
				ProcedureMasterImpl.class, procedureMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProcedureMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProcedureMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProcedureMasterModelImpl procedureMasterModelImpl) {

		Object[] args = new Object[] {
			procedureMasterModelImpl.getUuid(),
			procedureMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, procedureMasterModelImpl);
	}

	/**
	 * Creates a new procedure master with the primary key. Does not add the procedure master to the database.
	 *
	 * @param procedureMasterId the primary key for the new procedure master
	 * @return the new procedure master
	 */
	@Override
	public ProcedureMaster create(long procedureMasterId) {
		ProcedureMaster procedureMaster = new ProcedureMasterImpl();

		procedureMaster.setNew(true);
		procedureMaster.setPrimaryKey(procedureMasterId);

		String uuid = _portalUUID.generate();

		procedureMaster.setUuid(uuid);

		procedureMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return procedureMaster;
	}

	/**
	 * Removes the procedure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master that was removed
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster remove(long procedureMasterId)
		throws NoSuchProcedureMasterException {

		return remove((Serializable)procedureMasterId);
	}

	/**
	 * Removes the procedure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the procedure master
	 * @return the procedure master that was removed
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster remove(Serializable primaryKey)
		throws NoSuchProcedureMasterException {

		Session session = null;

		try {
			session = openSession();

			ProcedureMaster procedureMaster = (ProcedureMaster)session.get(
				ProcedureMasterImpl.class, primaryKey);

			if (procedureMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcedureMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(procedureMaster);
		}
		catch (NoSuchProcedureMasterException noSuchEntityException) {
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
	protected ProcedureMaster removeImpl(ProcedureMaster procedureMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(procedureMaster)) {
				procedureMaster = (ProcedureMaster)session.get(
					ProcedureMasterImpl.class,
					procedureMaster.getPrimaryKeyObj());
			}

			if (procedureMaster != null) {
				session.delete(procedureMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (procedureMaster != null) {
			clearCache(procedureMaster);
		}

		return procedureMaster;
	}

	@Override
	public ProcedureMaster updateImpl(ProcedureMaster procedureMaster) {
		boolean isNew = procedureMaster.isNew();

		if (!(procedureMaster instanceof ProcedureMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(procedureMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					procedureMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in procedureMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProcedureMaster implementation " +
					procedureMaster.getClass());
		}

		ProcedureMasterModelImpl procedureMasterModelImpl =
			(ProcedureMasterModelImpl)procedureMaster;

		if (Validator.isNull(procedureMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			procedureMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (procedureMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				procedureMaster.setCreateDate(date);
			}
			else {
				procedureMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!procedureMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				procedureMaster.setModifiedDate(date);
			}
			else {
				procedureMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(procedureMaster);
			}
			else {
				procedureMaster = (ProcedureMaster)session.merge(
					procedureMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProcedureMasterImpl.class, procedureMasterModelImpl, false, true);

		cacheUniqueFindersCache(procedureMasterModelImpl);

		if (isNew) {
			procedureMaster.setNew(false);
		}

		procedureMaster.resetOriginalValues();

		return procedureMaster;
	}

	/**
	 * Returns the procedure master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the procedure master
	 * @return the procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcedureMasterException {

		ProcedureMaster procedureMaster = fetchByPrimaryKey(primaryKey);

		if (procedureMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcedureMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return procedureMaster;
	}

	/**
	 * Returns the procedure master with the primary key or throws a <code>NoSuchProcedureMasterException</code> if it could not be found.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster findByPrimaryKey(long procedureMasterId)
		throws NoSuchProcedureMasterException {

		return findByPrimaryKey((Serializable)procedureMasterId);
	}

	/**
	 * Returns the procedure master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master, or <code>null</code> if a procedure master with the primary key could not be found
	 */
	@Override
	public ProcedureMaster fetchByPrimaryKey(long procedureMasterId) {
		return fetchByPrimaryKey((Serializable)procedureMasterId);
	}

	/**
	 * Returns all the procedure masters.
	 *
	 * @return the procedure masters
	 */
	@Override
	public List<ProcedureMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of procedure masters
	 */
	@Override
	public List<ProcedureMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure masters
	 */
	@Override
	public List<ProcedureMaster> findAll(
		int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure masters
	 */
	@Override
	public List<ProcedureMaster> findAll(
		int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
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

		List<ProcedureMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCEDUREMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCEDUREMASTER;

				sql = sql.concat(ProcedureMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProcedureMaster>)QueryUtil.list(
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
	 * Removes all the procedure masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProcedureMaster procedureMaster : findAll()) {
			remove(procedureMaster);
		}
	}

	/**
	 * Returns the number of procedure masters.
	 *
	 * @return the number of procedure masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROCEDUREMASTER);

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
		return "procedure_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCEDUREMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProcedureMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the procedure master persistence.
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

		_finderPathWithPaginationFindByProcedureNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProcedureNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"procedure_name"}, true);

		_finderPathWithPaginationCountByProcedureNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByProcedureNameByLike", new String[] {String.class.getName()},
			new String[] {"procedure_name"}, false);

		_finderPathWithPaginationFindByProcedureNameByLikeAndProcedureGroupMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProcedureNameByLikeAndProcedureGroupMasterId",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"procedure_name", "procedure_group_master_id"},
				true);

		_finderPathWithPaginationCountByProcedureNameByLikeAndProcedureGroupMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByProcedureNameByLikeAndProcedureGroupMasterId",
				new String[] {String.class.getName(), Long.class.getName()},
				new String[] {"procedure_name", "procedure_group_master_id"},
				false);

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

		_setProcedureMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProcedureMasterUtilPersistence(null);

		entityCache.removeCache(ProcedureMasterImpl.class.getName());
	}

	private void _setProcedureMasterUtilPersistence(
		ProcedureMasterPersistence procedureMasterPersistence) {

		try {
			Field field = ProcedureMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, procedureMasterPersistence);
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

	private static final String _SQL_SELECT_PROCEDUREMASTER =
		"SELECT procedureMaster FROM ProcedureMaster procedureMaster";

	private static final String _SQL_SELECT_PROCEDUREMASTER_WHERE =
		"SELECT procedureMaster FROM ProcedureMaster procedureMaster WHERE ";

	private static final String _SQL_COUNT_PROCEDUREMASTER =
		"SELECT COUNT(procedureMaster) FROM ProcedureMaster procedureMaster";

	private static final String _SQL_COUNT_PROCEDUREMASTER_WHERE =
		"SELECT COUNT(procedureMaster) FROM ProcedureMaster procedureMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "procedureMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProcedureMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProcedureMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProcedureMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "procedureMasterId", "procedureGroupMasterId", "groupId",
			"companyId", "createDate", "modifiedDate", "createdBy",
			"modifiedBy", "procedureName", "cptCode", "isMandatory"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchProcedureGroupMasterException;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProcedureGroupMasterTable;
import gov.omsb.tms.model.impl.ProcedureGroupMasterImpl;
import gov.omsb.tms.model.impl.ProcedureGroupMasterModelImpl;
import gov.omsb.tms.service.persistence.ProcedureGroupMasterPersistence;
import gov.omsb.tms.service.persistence.ProcedureGroupMasterUtil;
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
 * The persistence implementation for the procedure group master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProcedureGroupMasterPersistence.class)
public class ProcedureGroupMasterPersistenceImpl
	extends BasePersistenceImpl<ProcedureGroupMaster>
	implements ProcedureGroupMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProcedureGroupMasterUtil</code> to access the procedure group master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProcedureGroupMasterImpl.class.getName();

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
	 * Returns all the procedure group masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
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

		List<ProcedureGroupMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureGroupMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureGroupMaster procedureGroupMaster : list) {
					if (!uuid.equals(procedureGroupMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_PROCEDUREGROUPMASTER_WHERE);

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
				sb.append(ProcedureGroupMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProcedureGroupMaster>)QueryUtil.list(
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
	 * Returns the first procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster findByUuid_First(
			String uuid,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (procedureGroupMaster != null) {
			return procedureGroupMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcedureGroupMasterException(sb.toString());
	}

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByUuid_First(
		String uuid,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		List<ProcedureGroupMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster findByUuid_Last(
			String uuid,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (procedureGroupMaster != null) {
			return procedureGroupMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcedureGroupMasterException(sb.toString());
	}

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProcedureGroupMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	@Override
	public ProcedureGroupMaster[] findByUuid_PrevAndNext(
			long procedureGroupMasterId, String uuid,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		uuid = Objects.toString(uuid, "");

		ProcedureGroupMaster procedureGroupMaster = findByPrimaryKey(
			procedureGroupMasterId);

		Session session = null;

		try {
			session = openSession();

			ProcedureGroupMaster[] array = new ProcedureGroupMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, procedureGroupMaster, uuid, orderByComparator, true);

			array[1] = procedureGroupMaster;

			array[2] = getByUuid_PrevAndNext(
				session, procedureGroupMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProcedureGroupMaster getByUuid_PrevAndNext(
		Session session, ProcedureGroupMaster procedureGroupMaster, String uuid,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPMASTER_WHERE);

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
			sb.append(ProcedureGroupMasterModelImpl.ORDER_BY_JPQL);
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
						procedureGroupMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureGroupMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure group masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProcedureGroupMaster procedureGroupMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(procedureGroupMaster);
		}
	}

	/**
	 * Returns the number of procedure group masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure group masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREGROUPMASTER_WHERE);

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
		"procedureGroupMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(procedureGroupMaster.uuid IS NULL OR procedureGroupMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedureGroupMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster = fetchByUUID_G(
			uuid, groupId);

		if (procedureGroupMaster == null) {
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

			throw new NoSuchProcedureGroupMasterException(sb.toString());
		}

		return procedureGroupMaster;
	}

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByUUID_G(
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

		if (result instanceof ProcedureGroupMaster) {
			ProcedureGroupMaster procedureGroupMaster =
				(ProcedureGroupMaster)result;

			if (!Objects.equals(uuid, procedureGroupMaster.getUuid()) ||
				(groupId != procedureGroupMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCEDUREGROUPMASTER_WHERE);

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

				List<ProcedureGroupMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProcedureGroupMaster procedureGroupMaster = list.get(0);

					result = procedureGroupMaster;

					cacheResult(procedureGroupMaster);
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
			return (ProcedureGroupMaster)result;
		}
	}

	/**
	 * Removes the procedure group master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure group master that was removed
	 */
	@Override
	public ProcedureGroupMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster = findByUUID_G(uuid, groupId);

		return remove(procedureGroupMaster);
	}

	/**
	 * Returns the number of procedure group masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure group masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREGROUPMASTER_WHERE);

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
		"procedureGroupMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(procedureGroupMaster.uuid IS NULL OR procedureGroupMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"procedureGroupMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
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

		List<ProcedureGroupMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureGroupMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureGroupMaster procedureGroupMaster : list) {
					if (!uuid.equals(procedureGroupMaster.getUuid()) ||
						(companyId != procedureGroupMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCEDUREGROUPMASTER_WHERE);

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
				sb.append(ProcedureGroupMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProcedureGroupMaster>)QueryUtil.list(
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
	 * Returns the first procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (procedureGroupMaster != null) {
			return procedureGroupMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcedureGroupMasterException(sb.toString());
	}

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		List<ProcedureGroupMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (procedureGroupMaster != null) {
			return procedureGroupMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcedureGroupMasterException(sb.toString());
	}

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProcedureGroupMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	@Override
	public ProcedureGroupMaster[] findByUuid_C_PrevAndNext(
			long procedureGroupMasterId, String uuid, long companyId,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		uuid = Objects.toString(uuid, "");

		ProcedureGroupMaster procedureGroupMaster = findByPrimaryKey(
			procedureGroupMasterId);

		Session session = null;

		try {
			session = openSession();

			ProcedureGroupMaster[] array = new ProcedureGroupMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, procedureGroupMaster, uuid, companyId,
				orderByComparator, true);

			array[1] = procedureGroupMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, procedureGroupMaster, uuid, companyId,
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

	protected ProcedureGroupMaster getByUuid_C_PrevAndNext(
		Session session, ProcedureGroupMaster procedureGroupMaster, String uuid,
		long companyId,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPMASTER_WHERE);

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
			sb.append(ProcedureGroupMasterModelImpl.ORDER_BY_JPQL);
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
						procedureGroupMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureGroupMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure group masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProcedureGroupMaster procedureGroupMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedureGroupMaster);
		}
	}

	/**
	 * Returns the number of procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure group masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDUREGROUPMASTER_WHERE);

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
		"procedureGroupMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(procedureGroupMaster.uuid IS NULL OR procedureGroupMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"procedureGroupMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByprocedureGroupNameByLike;
	private FinderPath _finderPathWithPaginationCountByprocedureGroupNameByLike;

	/**
	 * Returns all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @return the matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName) {

		return findByprocedureGroupNameByLike(
			procedureGroupName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end) {

		return findByprocedureGroupNameByLike(
			procedureGroupName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return findByprocedureGroupNameByLike(
			procedureGroupName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
		boolean useFinderCache) {

		procedureGroupName = Objects.toString(procedureGroupName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByprocedureGroupNameByLike;
		finderArgs = new Object[] {
			procedureGroupName, start, end, orderByComparator
		};

		List<ProcedureGroupMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureGroupMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProcedureGroupMaster procedureGroupMaster : list) {
					if (!StringUtil.wildcardMatches(
							procedureGroupMaster.getProcedureGroupName(),
							procedureGroupName, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_PROCEDUREGROUPMASTER_WHERE);

			boolean bindProcedureGroupName = false;

			if (procedureGroupName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROCEDUREGROUPNAMEBYLIKE_PROCEDUREGROUPNAME_3);
			}
			else {
				bindProcedureGroupName = true;

				sb.append(
					_FINDER_COLUMN_PROCEDUREGROUPNAMEBYLIKE_PROCEDUREGROUPNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcedureGroupMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProcedureGroupName) {
					queryPos.add(StringUtil.toLowerCase(procedureGroupName));
				}

				list = (List<ProcedureGroupMaster>)QueryUtil.list(
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
	 * Returns the first procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster findByprocedureGroupNameByLike_First(
			String procedureGroupName,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster =
			fetchByprocedureGroupNameByLike_First(
				procedureGroupName, orderByComparator);

		if (procedureGroupMaster != null) {
			return procedureGroupMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupNameLIKE");
		sb.append(procedureGroupName);

		sb.append("}");

		throw new NoSuchProcedureGroupMasterException(sb.toString());
	}

	/**
	 * Returns the first procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByprocedureGroupNameByLike_First(
		String procedureGroupName,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		List<ProcedureGroupMaster> list = findByprocedureGroupNameByLike(
			procedureGroupName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster findByprocedureGroupNameByLike_Last(
			String procedureGroupName,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster =
			fetchByprocedureGroupNameByLike_Last(
				procedureGroupName, orderByComparator);

		if (procedureGroupMaster != null) {
			return procedureGroupMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupNameLIKE");
		sb.append(procedureGroupName);

		sb.append("}");

		throw new NoSuchProcedureGroupMasterException(sb.toString());
	}

	/**
	 * Returns the last procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByprocedureGroupNameByLike_Last(
		String procedureGroupName,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		int count = countByprocedureGroupNameByLike(procedureGroupName);

		if (count == 0) {
			return null;
		}

		List<ProcedureGroupMaster> list = findByprocedureGroupNameByLike(
			procedureGroupName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	@Override
	public ProcedureGroupMaster[] findByprocedureGroupNameByLike_PrevAndNext(
			long procedureGroupMasterId, String procedureGroupName,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException {

		procedureGroupName = Objects.toString(procedureGroupName, "");

		ProcedureGroupMaster procedureGroupMaster = findByPrimaryKey(
			procedureGroupMasterId);

		Session session = null;

		try {
			session = openSession();

			ProcedureGroupMaster[] array = new ProcedureGroupMasterImpl[3];

			array[0] = getByprocedureGroupNameByLike_PrevAndNext(
				session, procedureGroupMaster, procedureGroupName,
				orderByComparator, true);

			array[1] = procedureGroupMaster;

			array[2] = getByprocedureGroupNameByLike_PrevAndNext(
				session, procedureGroupMaster, procedureGroupName,
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

	protected ProcedureGroupMaster getByprocedureGroupNameByLike_PrevAndNext(
		Session session, ProcedureGroupMaster procedureGroupMaster,
		String procedureGroupName,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDUREGROUPMASTER_WHERE);

		boolean bindProcedureGroupName = false;

		if (procedureGroupName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PROCEDUREGROUPNAMEBYLIKE_PROCEDUREGROUPNAME_3);
		}
		else {
			bindProcedureGroupName = true;

			sb.append(
				_FINDER_COLUMN_PROCEDUREGROUPNAMEBYLIKE_PROCEDUREGROUPNAME_2);
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
			sb.append(ProcedureGroupMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindProcedureGroupName) {
			queryPos.add(StringUtil.toLowerCase(procedureGroupName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						procedureGroupMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProcedureGroupMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedure group masters where procedureGroupName LIKE &#63; from the database.
	 *
	 * @param procedureGroupName the procedure group name
	 */
	@Override
	public void removeByprocedureGroupNameByLike(String procedureGroupName) {
		for (ProcedureGroupMaster procedureGroupMaster :
				findByprocedureGroupNameByLike(
					procedureGroupName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedureGroupMaster);
		}
	}

	/**
	 * Returns the number of procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @return the number of matching procedure group masters
	 */
	@Override
	public int countByprocedureGroupNameByLike(String procedureGroupName) {
		procedureGroupName = Objects.toString(procedureGroupName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByprocedureGroupNameByLike;

		Object[] finderArgs = new Object[] {procedureGroupName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDUREGROUPMASTER_WHERE);

			boolean bindProcedureGroupName = false;

			if (procedureGroupName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROCEDUREGROUPNAMEBYLIKE_PROCEDUREGROUPNAME_3);
			}
			else {
				bindProcedureGroupName = true;

				sb.append(
					_FINDER_COLUMN_PROCEDUREGROUPNAMEBYLIKE_PROCEDUREGROUPNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProcedureGroupName) {
					queryPos.add(StringUtil.toLowerCase(procedureGroupName));
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
		_FINDER_COLUMN_PROCEDUREGROUPNAMEBYLIKE_PROCEDUREGROUPNAME_2 =
			"lower(procedureGroupMaster.procedureGroupName) LIKE ?";

	private static final String
		_FINDER_COLUMN_PROCEDUREGROUPNAMEBYLIKE_PROCEDUREGROUPNAME_3 =
			"(procedureGroupMaster.procedureGroupName IS NULL OR procedureGroupMaster.procedureGroupName LIKE '')";

	public ProcedureGroupMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"procedureGroupMasterId", "procedure_group_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("procedureGroupName", "procedure_group_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProcedureGroupMaster.class);

		setModelImplClass(ProcedureGroupMasterImpl.class);
		setModelPKClass(long.class);

		setTable(ProcedureGroupMasterTable.INSTANCE);
	}

	/**
	 * Caches the procedure group master in the entity cache if it is enabled.
	 *
	 * @param procedureGroupMaster the procedure group master
	 */
	@Override
	public void cacheResult(ProcedureGroupMaster procedureGroupMaster) {
		entityCache.putResult(
			ProcedureGroupMasterImpl.class,
			procedureGroupMaster.getPrimaryKey(), procedureGroupMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				procedureGroupMaster.getUuid(),
				procedureGroupMaster.getGroupId()
			},
			procedureGroupMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the procedure group masters in the entity cache if it is enabled.
	 *
	 * @param procedureGroupMasters the procedure group masters
	 */
	@Override
	public void cacheResult(List<ProcedureGroupMaster> procedureGroupMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (procedureGroupMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProcedureGroupMaster procedureGroupMaster :
				procedureGroupMasters) {

			if (entityCache.getResult(
					ProcedureGroupMasterImpl.class,
					procedureGroupMaster.getPrimaryKey()) == null) {

				cacheResult(procedureGroupMaster);
			}
		}
	}

	/**
	 * Clears the cache for all procedure group masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProcedureGroupMasterImpl.class);

		finderCache.clearCache(ProcedureGroupMasterImpl.class);
	}

	/**
	 * Clears the cache for the procedure group master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProcedureGroupMaster procedureGroupMaster) {
		entityCache.removeResult(
			ProcedureGroupMasterImpl.class, procedureGroupMaster);
	}

	@Override
	public void clearCache(List<ProcedureGroupMaster> procedureGroupMasters) {
		for (ProcedureGroupMaster procedureGroupMaster :
				procedureGroupMasters) {

			entityCache.removeResult(
				ProcedureGroupMasterImpl.class, procedureGroupMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProcedureGroupMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProcedureGroupMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProcedureGroupMasterModelImpl procedureGroupMasterModelImpl) {

		Object[] args = new Object[] {
			procedureGroupMasterModelImpl.getUuid(),
			procedureGroupMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, procedureGroupMasterModelImpl);
	}

	/**
	 * Creates a new procedure group master with the primary key. Does not add the procedure group master to the database.
	 *
	 * @param procedureGroupMasterId the primary key for the new procedure group master
	 * @return the new procedure group master
	 */
	@Override
	public ProcedureGroupMaster create(long procedureGroupMasterId) {
		ProcedureGroupMaster procedureGroupMaster =
			new ProcedureGroupMasterImpl();

		procedureGroupMaster.setNew(true);
		procedureGroupMaster.setPrimaryKey(procedureGroupMasterId);

		String uuid = _portalUUID.generate();

		procedureGroupMaster.setUuid(uuid);

		procedureGroupMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return procedureGroupMaster;
	}

	/**
	 * Removes the procedure group master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master that was removed
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	@Override
	public ProcedureGroupMaster remove(long procedureGroupMasterId)
		throws NoSuchProcedureGroupMasterException {

		return remove((Serializable)procedureGroupMasterId);
	}

	/**
	 * Removes the procedure group master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the procedure group master
	 * @return the procedure group master that was removed
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	@Override
	public ProcedureGroupMaster remove(Serializable primaryKey)
		throws NoSuchProcedureGroupMasterException {

		Session session = null;

		try {
			session = openSession();

			ProcedureGroupMaster procedureGroupMaster =
				(ProcedureGroupMaster)session.get(
					ProcedureGroupMasterImpl.class, primaryKey);

			if (procedureGroupMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcedureGroupMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(procedureGroupMaster);
		}
		catch (NoSuchProcedureGroupMasterException noSuchEntityException) {
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
	protected ProcedureGroupMaster removeImpl(
		ProcedureGroupMaster procedureGroupMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(procedureGroupMaster)) {
				procedureGroupMaster = (ProcedureGroupMaster)session.get(
					ProcedureGroupMasterImpl.class,
					procedureGroupMaster.getPrimaryKeyObj());
			}

			if (procedureGroupMaster != null) {
				session.delete(procedureGroupMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (procedureGroupMaster != null) {
			clearCache(procedureGroupMaster);
		}

		return procedureGroupMaster;
	}

	@Override
	public ProcedureGroupMaster updateImpl(
		ProcedureGroupMaster procedureGroupMaster) {

		boolean isNew = procedureGroupMaster.isNew();

		if (!(procedureGroupMaster instanceof ProcedureGroupMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(procedureGroupMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					procedureGroupMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in procedureGroupMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProcedureGroupMaster implementation " +
					procedureGroupMaster.getClass());
		}

		ProcedureGroupMasterModelImpl procedureGroupMasterModelImpl =
			(ProcedureGroupMasterModelImpl)procedureGroupMaster;

		if (Validator.isNull(procedureGroupMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			procedureGroupMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (procedureGroupMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				procedureGroupMaster.setCreateDate(date);
			}
			else {
				procedureGroupMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!procedureGroupMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				procedureGroupMaster.setModifiedDate(date);
			}
			else {
				procedureGroupMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(procedureGroupMaster);
			}
			else {
				procedureGroupMaster = (ProcedureGroupMaster)session.merge(
					procedureGroupMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProcedureGroupMasterImpl.class, procedureGroupMasterModelImpl,
			false, true);

		cacheUniqueFindersCache(procedureGroupMasterModelImpl);

		if (isNew) {
			procedureGroupMaster.setNew(false);
		}

		procedureGroupMaster.resetOriginalValues();

		return procedureGroupMaster;
	}

	/**
	 * Returns the procedure group master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the procedure group master
	 * @return the procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	@Override
	public ProcedureGroupMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcedureGroupMasterException {

		ProcedureGroupMaster procedureGroupMaster = fetchByPrimaryKey(
			primaryKey);

		if (procedureGroupMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcedureGroupMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return procedureGroupMaster;
	}

	/**
	 * Returns the procedure group master with the primary key or throws a <code>NoSuchProcedureGroupMasterException</code> if it could not be found.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	@Override
	public ProcedureGroupMaster findByPrimaryKey(long procedureGroupMasterId)
		throws NoSuchProcedureGroupMasterException {

		return findByPrimaryKey((Serializable)procedureGroupMasterId);
	}

	/**
	 * Returns the procedure group master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master, or <code>null</code> if a procedure group master with the primary key could not be found
	 */
	@Override
	public ProcedureGroupMaster fetchByPrimaryKey(long procedureGroupMasterId) {
		return fetchByPrimaryKey((Serializable)procedureGroupMasterId);
	}

	/**
	 * Returns all the procedure group masters.
	 *
	 * @return the procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findAll(
		int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure group masters
	 */
	@Override
	public List<ProcedureGroupMaster> findAll(
		int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
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

		List<ProcedureGroupMaster> list = null;

		if (useFinderCache) {
			list = (List<ProcedureGroupMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCEDUREGROUPMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCEDUREGROUPMASTER;

				sql = sql.concat(ProcedureGroupMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProcedureGroupMaster>)QueryUtil.list(
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
	 * Removes all the procedure group masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProcedureGroupMaster procedureGroupMaster : findAll()) {
			remove(procedureGroupMaster);
		}
	}

	/**
	 * Returns the number of procedure group masters.
	 *
	 * @return the number of procedure group masters
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
					_SQL_COUNT_PROCEDUREGROUPMASTER);

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
		return "procedure_group_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCEDUREGROUPMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProcedureGroupMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the procedure group master persistence.
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

		_finderPathWithPaginationFindByprocedureGroupNameByLike =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByprocedureGroupNameByLike",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"procedure_group_name"}, true);

		_finderPathWithPaginationCountByprocedureGroupNameByLike =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByprocedureGroupNameByLike",
				new String[] {String.class.getName()},
				new String[] {"procedure_group_name"}, false);

		_setProcedureGroupMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProcedureGroupMasterUtilPersistence(null);

		entityCache.removeCache(ProcedureGroupMasterImpl.class.getName());
	}

	private void _setProcedureGroupMasterUtilPersistence(
		ProcedureGroupMasterPersistence procedureGroupMasterPersistence) {

		try {
			Field field = ProcedureGroupMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, procedureGroupMasterPersistence);
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

	private static final String _SQL_SELECT_PROCEDUREGROUPMASTER =
		"SELECT procedureGroupMaster FROM ProcedureGroupMaster procedureGroupMaster";

	private static final String _SQL_SELECT_PROCEDUREGROUPMASTER_WHERE =
		"SELECT procedureGroupMaster FROM ProcedureGroupMaster procedureGroupMaster WHERE ";

	private static final String _SQL_COUNT_PROCEDUREGROUPMASTER =
		"SELECT COUNT(procedureGroupMaster) FROM ProcedureGroupMaster procedureGroupMaster";

	private static final String _SQL_COUNT_PROCEDUREGROUPMASTER_WHERE =
		"SELECT COUNT(procedureGroupMaster) FROM ProcedureGroupMaster procedureGroupMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"procedureGroupMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProcedureGroupMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProcedureGroupMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProcedureGroupMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "procedureGroupMasterId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy",
			"procedureGroupName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchParticipationTypeMasterException;
import gov.omsb.tms.model.ParticipationTypeMaster;
import gov.omsb.tms.model.ParticipationTypeMasterTable;
import gov.omsb.tms.model.impl.ParticipationTypeMasterImpl;
import gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl;
import gov.omsb.tms.service.persistence.ParticipationTypeMasterPersistence;
import gov.omsb.tms.service.persistence.ParticipationTypeMasterUtil;
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
 * The persistence implementation for the participation type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ParticipationTypeMasterPersistence.class)
public class ParticipationTypeMasterPersistenceImpl
	extends BasePersistenceImpl<ParticipationTypeMaster>
	implements ParticipationTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ParticipationTypeMasterUtil</code> to access the participation type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ParticipationTypeMasterImpl.class.getName();

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
	 * Returns all the participation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the participation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
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

		List<ParticipationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ParticipationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ParticipationTypeMaster participationTypeMaster : list) {
					if (!uuid.equals(participationTypeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

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
				sb.append(ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ParticipationTypeMaster>)QueryUtil.list(
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
	 * Returns the first participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster findByUuid_First(
			String uuid,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (participationTypeMaster != null) {
			return participationTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchParticipationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByUuid_First(
		String uuid,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		List<ParticipationTypeMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster findByUuid_Last(
			String uuid,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (participationTypeMaster != null) {
			return participationTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchParticipationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByUuid_Last(
		String uuid,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ParticipationTypeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where uuid = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster[] findByUuid_PrevAndNext(
			long participationTypeMasterId, String uuid,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		uuid = Objects.toString(uuid, "");

		ParticipationTypeMaster participationTypeMaster = findByPrimaryKey(
			participationTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			ParticipationTypeMaster[] array =
				new ParticipationTypeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, participationTypeMaster, uuid, orderByComparator,
				true);

			array[1] = participationTypeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, participationTypeMaster, uuid, orderByComparator,
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

	protected ParticipationTypeMaster getByUuid_PrevAndNext(
		Session session, ParticipationTypeMaster participationTypeMaster,
		String uuid,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

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
			sb.append(ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
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
						participationTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ParticipationTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participation type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ParticipationTypeMaster participationTypeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(participationTypeMaster);
		}
	}

	/**
	 * Returns the number of participation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching participation type masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PARTICIPATIONTYPEMASTER_WHERE);

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
		"participationTypeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(participationTypeMaster.uuid IS NULL OR participationTypeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchParticipationTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster = fetchByUUID_G(
			uuid, groupId);

		if (participationTypeMaster == null) {
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

			throw new NoSuchParticipationTypeMasterException(sb.toString());
		}

		return participationTypeMaster;
	}

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the participation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByUUID_G(
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

		if (result instanceof ParticipationTypeMaster) {
			ParticipationTypeMaster participationTypeMaster =
				(ParticipationTypeMaster)result;

			if (!Objects.equals(uuid, participationTypeMaster.getUuid()) ||
				(groupId != participationTypeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

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

				List<ParticipationTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ParticipationTypeMaster participationTypeMaster = list.get(
						0);

					result = participationTypeMaster;

					cacheResult(participationTypeMaster);
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
			return (ParticipationTypeMaster)result;
		}
	}

	/**
	 * Removes the participation type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the participation type master that was removed
	 */
	@Override
	public ParticipationTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster = findByUUID_G(
			uuid, groupId);

		return remove(participationTypeMaster);
	}

	/**
	 * Returns the number of participation type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching participation type masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PARTICIPATIONTYPEMASTER_WHERE);

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
		"participationTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(participationTypeMaster.uuid IS NULL OR participationTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"participationTypeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
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

		List<ParticipationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ParticipationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ParticipationTypeMaster participationTypeMaster : list) {
					if (!uuid.equals(participationTypeMaster.getUuid()) ||
						(companyId != participationTypeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

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
				sb.append(ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ParticipationTypeMaster>)QueryUtil.list(
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
	 * Returns the first participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (participationTypeMaster != null) {
			return participationTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchParticipationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		List<ParticipationTypeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (participationTypeMaster != null) {
			return participationTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchParticipationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ParticipationTypeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster[] findByUuid_C_PrevAndNext(
			long participationTypeMasterId, String uuid, long companyId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		uuid = Objects.toString(uuid, "");

		ParticipationTypeMaster participationTypeMaster = findByPrimaryKey(
			participationTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			ParticipationTypeMaster[] array =
				new ParticipationTypeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, participationTypeMaster, uuid, companyId,
				orderByComparator, true);

			array[1] = participationTypeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, participationTypeMaster, uuid, companyId,
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

	protected ParticipationTypeMaster getByUuid_C_PrevAndNext(
		Session session, ParticipationTypeMaster participationTypeMaster,
		String uuid, long companyId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

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
			sb.append(ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
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
						participationTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ParticipationTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participation type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ParticipationTypeMaster participationTypeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(participationTypeMaster);
		}
	}

	/**
	 * Returns the number of participation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching participation type masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PARTICIPATIONTYPEMASTER_WHERE);

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
		"participationTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(participationTypeMaster.uuid IS NULL OR participationTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"participationTypeMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the participation type masters where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participation type masters where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participation type masters where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the participation type masters where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
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

		List<ParticipationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ParticipationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ParticipationTypeMaster participationTypeMaster : list) {
					if (programDurationId !=
							participationTypeMaster.getProgramDurationId()) {

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

			sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				list = (List<ParticipationTypeMaster>)QueryUtil.list(
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
	 * Returns the first participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster =
			fetchByProgramDurationId_First(
				programDurationId, orderByComparator);

		if (participationTypeMaster != null) {
			return participationTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchParticipationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		List<ParticipationTypeMaster> list = findByProgramDurationId(
			programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster =
			fetchByProgramDurationId_Last(programDurationId, orderByComparator);

		if (participationTypeMaster != null) {
			return participationTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchParticipationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<ParticipationTypeMaster> list = findByProgramDurationId(
			programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where programDurationId = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster[] findByProgramDurationId_PrevAndNext(
			long participationTypeMasterId, long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster = findByPrimaryKey(
			participationTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			ParticipationTypeMaster[] array =
				new ParticipationTypeMasterImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, participationTypeMaster, programDurationId,
				orderByComparator, true);

			array[1] = participationTypeMaster;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, participationTypeMaster, programDurationId,
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

	protected ParticipationTypeMaster getByProgramDurationId_PrevAndNext(
		Session session, ParticipationTypeMaster participationTypeMaster,
		long programDurationId,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

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
			sb.append(ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
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
						participationTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ParticipationTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participation type masters where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (ParticipationTypeMaster participationTypeMaster :
				findByProgramDurationId(
					programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(participationTypeMaster);
		}
	}

	/**
	 * Returns the number of participation type masters where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching participation type masters
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PARTICIPATIONTYPEMASTER_WHERE);

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
			"participationTypeMaster.programDurationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByParticipationTypeNameByLikeAndProgramDurationId;
	private FinderPath
		_finderPathWithPaginationCountByParticipationTypeNameByLikeAndProgramDurationId;

	/**
	 * Returns all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @return the matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId) {

		return findByParticipationTypeNameByLikeAndProgramDurationId(
			participationTypeName, programDurationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end) {

		return findByParticipationTypeNameByLikeAndProgramDurationId(
			participationTypeName, programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end,
			OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return findByParticipationTypeNameByLikeAndProgramDurationId(
			participationTypeName, programDurationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId, int start,
			int end,
			OrderByComparator<ParticipationTypeMaster> orderByComparator,
			boolean useFinderCache) {

		participationTypeName = Objects.toString(participationTypeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath =
			_finderPathWithPaginationFindByParticipationTypeNameByLikeAndProgramDurationId;
		finderArgs = new Object[] {
			participationTypeName, programDurationId, start, end,
			orderByComparator
		};

		List<ParticipationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ParticipationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ParticipationTypeMaster participationTypeMaster : list) {
					if (!StringUtil.wildcardMatches(
							participationTypeMaster.getParticipationTypeName(),
							participationTypeName, '_', '%', '\\', false) ||
						(programDurationId !=
							participationTypeMaster.getProgramDurationId())) {

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

			sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

			boolean bindParticipationTypeName = false;

			if (participationTypeName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PARTICIPATIONTYPENAME_3);
			}
			else {
				bindParticipationTypeName = true;

				sb.append(
					_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PARTICIPATIONTYPENAME_2);
			}

			sb.append(
				_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParticipationTypeName) {
					queryPos.add(StringUtil.toLowerCase(participationTypeName));
				}

				queryPos.add(programDurationId);

				list = (List<ParticipationTypeMaster>)QueryUtil.list(
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
	 * Returns the first participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster
			findByParticipationTypeNameByLikeAndProgramDurationId_First(
				String participationTypeName, long programDurationId,
				OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster =
			fetchByParticipationTypeNameByLikeAndProgramDurationId_First(
				participationTypeName, programDurationId, orderByComparator);

		if (participationTypeMaster != null) {
			return participationTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("participationTypeNameLIKE");
		sb.append(participationTypeName);

		sb.append(", programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchParticipationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster
		fetchByParticipationTypeNameByLikeAndProgramDurationId_First(
			String participationTypeName, long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		List<ParticipationTypeMaster> list =
			findByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master
	 * @throws NoSuchParticipationTypeMasterException if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster
			findByParticipationTypeNameByLikeAndProgramDurationId_Last(
				String participationTypeName, long programDurationId,
				OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster =
			fetchByParticipationTypeNameByLikeAndProgramDurationId_Last(
				participationTypeName, programDurationId, orderByComparator);

		if (participationTypeMaster != null) {
			return participationTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("participationTypeNameLIKE");
		sb.append(participationTypeName);

		sb.append(", programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchParticipationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public ParticipationTypeMaster
		fetchByParticipationTypeNameByLikeAndProgramDurationId_Last(
			String participationTypeName, long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		int count = countByParticipationTypeNameByLikeAndProgramDurationId(
			participationTypeName, programDurationId);

		if (count == 0) {
			return null;
		}

		List<ParticipationTypeMaster> list =
			findByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participation type masters before and after the current participation type master in the ordered set where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeMasterId the primary key of the current participation type master
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster[]
			findByParticipationTypeNameByLikeAndProgramDurationId_PrevAndNext(
				long participationTypeMasterId, String participationTypeName,
				long programDurationId,
				OrderByComparator<ParticipationTypeMaster> orderByComparator)
		throws NoSuchParticipationTypeMasterException {

		participationTypeName = Objects.toString(participationTypeName, "");

		ParticipationTypeMaster participationTypeMaster = findByPrimaryKey(
			participationTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			ParticipationTypeMaster[] array =
				new ParticipationTypeMasterImpl[3];

			array[0] =
				getByParticipationTypeNameByLikeAndProgramDurationId_PrevAndNext(
					session, participationTypeMaster, participationTypeName,
					programDurationId, orderByComparator, true);

			array[1] = participationTypeMaster;

			array[2] =
				getByParticipationTypeNameByLikeAndProgramDurationId_PrevAndNext(
					session, participationTypeMaster, participationTypeName,
					programDurationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ParticipationTypeMaster
		getByParticipationTypeNameByLikeAndProgramDurationId_PrevAndNext(
			Session session, ParticipationTypeMaster participationTypeMaster,
			String participationTypeName, long programDurationId,
			OrderByComparator<ParticipationTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE);

		boolean bindParticipationTypeName = false;

		if (participationTypeName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PARTICIPATIONTYPENAME_3);
		}
		else {
			bindParticipationTypeName = true;

			sb.append(
				_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PARTICIPATIONTYPENAME_2);
		}

		sb.append(
			_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PROGRAMDURATIONID_2);

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
			sb.append(ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindParticipationTypeName) {
			queryPos.add(StringUtil.toLowerCase(participationTypeName));
		}

		queryPos.add(programDurationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						participationTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ParticipationTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63; from the database.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByParticipationTypeNameByLikeAndProgramDurationId(
		String participationTypeName, long programDurationId) {

		for (ParticipationTypeMaster participationTypeMaster :
				findByParticipationTypeNameByLikeAndProgramDurationId(
					participationTypeName, programDurationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(participationTypeMaster);
		}
	}

	/**
	 * Returns the number of participation type masters where participationTypeName LIKE &#63; and programDurationId = &#63;.
	 *
	 * @param participationTypeName the participation type name
	 * @param programDurationId the program duration ID
	 * @return the number of matching participation type masters
	 */
	@Override
	public int countByParticipationTypeNameByLikeAndProgramDurationId(
		String participationTypeName, long programDurationId) {

		participationTypeName = Objects.toString(participationTypeName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByParticipationTypeNameByLikeAndProgramDurationId;

		Object[] finderArgs = new Object[] {
			participationTypeName, programDurationId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PARTICIPATIONTYPEMASTER_WHERE);

			boolean bindParticipationTypeName = false;

			if (participationTypeName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PARTICIPATIONTYPENAME_3);
			}
			else {
				bindParticipationTypeName = true;

				sb.append(
					_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PARTICIPATIONTYPENAME_2);
			}

			sb.append(
				_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParticipationTypeName) {
					queryPos.add(StringUtil.toLowerCase(participationTypeName));
				}

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
		_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PARTICIPATIONTYPENAME_2 =
			"lower(participationTypeMaster.participationTypeName) LIKE ? AND ";

	private static final String
		_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PARTICIPATIONTYPENAME_3 =
			"(participationTypeMaster.participationTypeName IS NULL OR participationTypeMaster.participationTypeName LIKE '') AND ";

	private static final String
		_FINDER_COLUMN_PARTICIPATIONTYPENAMEBYLIKEANDPROGRAMDURATIONID_PROGRAMDURATIONID_2 =
			"participationTypeMaster.programDurationId = ?";

	public ParticipationTypeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"participationTypeMasterId", "participation_type_master_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("participationTypeName", "participation_type_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(ParticipationTypeMaster.class);

		setModelImplClass(ParticipationTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(ParticipationTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the participation type master in the entity cache if it is enabled.
	 *
	 * @param participationTypeMaster the participation type master
	 */
	@Override
	public void cacheResult(ParticipationTypeMaster participationTypeMaster) {
		entityCache.putResult(
			ParticipationTypeMasterImpl.class,
			participationTypeMaster.getPrimaryKey(), participationTypeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				participationTypeMaster.getUuid(),
				participationTypeMaster.getGroupId()
			},
			participationTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the participation type masters in the entity cache if it is enabled.
	 *
	 * @param participationTypeMasters the participation type masters
	 */
	@Override
	public void cacheResult(
		List<ParticipationTypeMaster> participationTypeMasters) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (participationTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ParticipationTypeMaster participationTypeMaster :
				participationTypeMasters) {

			if (entityCache.getResult(
					ParticipationTypeMasterImpl.class,
					participationTypeMaster.getPrimaryKey()) == null) {

				cacheResult(participationTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all participation type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ParticipationTypeMasterImpl.class);

		finderCache.clearCache(ParticipationTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the participation type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ParticipationTypeMaster participationTypeMaster) {
		entityCache.removeResult(
			ParticipationTypeMasterImpl.class, participationTypeMaster);
	}

	@Override
	public void clearCache(
		List<ParticipationTypeMaster> participationTypeMasters) {

		for (ParticipationTypeMaster participationTypeMaster :
				participationTypeMasters) {

			entityCache.removeResult(
				ParticipationTypeMasterImpl.class, participationTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ParticipationTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ParticipationTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ParticipationTypeMasterModelImpl participationTypeMasterModelImpl) {

		Object[] args = new Object[] {
			participationTypeMasterModelImpl.getUuid(),
			participationTypeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, participationTypeMasterModelImpl);
	}

	/**
	 * Creates a new participation type master with the primary key. Does not add the participation type master to the database.
	 *
	 * @param participationTypeMasterId the primary key for the new participation type master
	 * @return the new participation type master
	 */
	@Override
	public ParticipationTypeMaster create(long participationTypeMasterId) {
		ParticipationTypeMaster participationTypeMaster =
			new ParticipationTypeMasterImpl();

		participationTypeMaster.setNew(true);
		participationTypeMaster.setPrimaryKey(participationTypeMasterId);

		String uuid = _portalUUID.generate();

		participationTypeMaster.setUuid(uuid);

		participationTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return participationTypeMaster;
	}

	/**
	 * Removes the participation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master that was removed
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster remove(long participationTypeMasterId)
		throws NoSuchParticipationTypeMasterException {

		return remove((Serializable)participationTypeMasterId);
	}

	/**
	 * Removes the participation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the participation type master
	 * @return the participation type master that was removed
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster remove(Serializable primaryKey)
		throws NoSuchParticipationTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			ParticipationTypeMaster participationTypeMaster =
				(ParticipationTypeMaster)session.get(
					ParticipationTypeMasterImpl.class, primaryKey);

			if (participationTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParticipationTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(participationTypeMaster);
		}
		catch (NoSuchParticipationTypeMasterException noSuchEntityException) {
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
	protected ParticipationTypeMaster removeImpl(
		ParticipationTypeMaster participationTypeMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(participationTypeMaster)) {
				participationTypeMaster = (ParticipationTypeMaster)session.get(
					ParticipationTypeMasterImpl.class,
					participationTypeMaster.getPrimaryKeyObj());
			}

			if (participationTypeMaster != null) {
				session.delete(participationTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (participationTypeMaster != null) {
			clearCache(participationTypeMaster);
		}

		return participationTypeMaster;
	}

	@Override
	public ParticipationTypeMaster updateImpl(
		ParticipationTypeMaster participationTypeMaster) {

		boolean isNew = participationTypeMaster.isNew();

		if (!(participationTypeMaster instanceof
				ParticipationTypeMasterModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(participationTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					participationTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in participationTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ParticipationTypeMaster implementation " +
					participationTypeMaster.getClass());
		}

		ParticipationTypeMasterModelImpl participationTypeMasterModelImpl =
			(ParticipationTypeMasterModelImpl)participationTypeMaster;

		if (Validator.isNull(participationTypeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			participationTypeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (participationTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				participationTypeMaster.setCreateDate(date);
			}
			else {
				participationTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!participationTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				participationTypeMaster.setModifiedDate(date);
			}
			else {
				participationTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(participationTypeMaster);
			}
			else {
				participationTypeMaster =
					(ParticipationTypeMaster)session.merge(
						participationTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ParticipationTypeMasterImpl.class, participationTypeMasterModelImpl,
			false, true);

		cacheUniqueFindersCache(participationTypeMasterModelImpl);

		if (isNew) {
			participationTypeMaster.setNew(false);
		}

		participationTypeMaster.resetOriginalValues();

		return participationTypeMaster;
	}

	/**
	 * Returns the participation type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the participation type master
	 * @return the participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParticipationTypeMasterException {

		ParticipationTypeMaster participationTypeMaster = fetchByPrimaryKey(
			primaryKey);

		if (participationTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParticipationTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return participationTypeMaster;
	}

	/**
	 * Returns the participation type master with the primary key or throws a <code>NoSuchParticipationTypeMasterException</code> if it could not be found.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master
	 * @throws NoSuchParticipationTypeMasterException if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster findByPrimaryKey(
			long participationTypeMasterId)
		throws NoSuchParticipationTypeMasterException {

		return findByPrimaryKey((Serializable)participationTypeMasterId);
	}

	/**
	 * Returns the participation type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master, or <code>null</code> if a participation type master with the primary key could not be found
	 */
	@Override
	public ParticipationTypeMaster fetchByPrimaryKey(
		long participationTypeMasterId) {

		return fetchByPrimaryKey((Serializable)participationTypeMasterId);
	}

	/**
	 * Returns all the participation type masters.
	 *
	 * @return the participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findAll(
		int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of participation type masters
	 */
	@Override
	public List<ParticipationTypeMaster> findAll(
		int start, int end,
		OrderByComparator<ParticipationTypeMaster> orderByComparator,
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

		List<ParticipationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ParticipationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PARTICIPATIONTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PARTICIPATIONTYPEMASTER;

				sql = sql.concat(
					ParticipationTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ParticipationTypeMaster>)QueryUtil.list(
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
	 * Removes all the participation type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ParticipationTypeMaster participationTypeMaster : findAll()) {
			remove(participationTypeMaster);
		}
	}

	/**
	 * Returns the number of participation type masters.
	 *
	 * @return the number of participation type masters
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
					_SQL_COUNT_PARTICIPATIONTYPEMASTER);

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
		return "participation_type_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PARTICIPATIONTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ParticipationTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the participation type master persistence.
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

		_finderPathWithPaginationFindByParticipationTypeNameByLikeAndProgramDurationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByParticipationTypeNameByLikeAndProgramDurationId",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"participation_type_name", "program_duration_id"},
				true);

		_finderPathWithPaginationCountByParticipationTypeNameByLikeAndProgramDurationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByParticipationTypeNameByLikeAndProgramDurationId",
				new String[] {String.class.getName(), Long.class.getName()},
				new String[] {"participation_type_name", "program_duration_id"},
				false);

		_setParticipationTypeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setParticipationTypeMasterUtilPersistence(null);

		entityCache.removeCache(ParticipationTypeMasterImpl.class.getName());
	}

	private void _setParticipationTypeMasterUtilPersistence(
		ParticipationTypeMasterPersistence participationTypeMasterPersistence) {

		try {
			Field field = ParticipationTypeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, participationTypeMasterPersistence);
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

	private static final String _SQL_SELECT_PARTICIPATIONTYPEMASTER =
		"SELECT participationTypeMaster FROM ParticipationTypeMaster participationTypeMaster";

	private static final String _SQL_SELECT_PARTICIPATIONTYPEMASTER_WHERE =
		"SELECT participationTypeMaster FROM ParticipationTypeMaster participationTypeMaster WHERE ";

	private static final String _SQL_COUNT_PARTICIPATIONTYPEMASTER =
		"SELECT COUNT(participationTypeMaster) FROM ParticipationTypeMaster participationTypeMaster";

	private static final String _SQL_COUNT_PARTICIPATIONTYPEMASTER_WHERE =
		"SELECT COUNT(participationTypeMaster) FROM ParticipationTypeMaster participationTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"participationTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ParticipationTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ParticipationTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ParticipationTypeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "participationTypeMasterId", "programDurationId", "groupId",
			"companyId", "createDate", "createdBy", "modifiedDate",
			"modifiedBy", "participationTypeName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchTraineeLevelMasterException;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.TraineeLevelMasterTable;
import gov.omsb.tms.model.impl.TraineeLevelMasterImpl;
import gov.omsb.tms.model.impl.TraineeLevelMasterModelImpl;
import gov.omsb.tms.service.persistence.TraineeLevelMasterPersistence;
import gov.omsb.tms.service.persistence.TraineeLevelMasterUtil;
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
 * The persistence implementation for the trainee level master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TraineeLevelMasterPersistence.class)
public class TraineeLevelMasterPersistenceImpl
	extends BasePersistenceImpl<TraineeLevelMaster>
	implements TraineeLevelMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TraineeLevelMasterUtil</code> to access the trainee level master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TraineeLevelMasterImpl.class.getName();

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
	 * Returns all the trainee level masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee level masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee level masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee level masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator,
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

		List<TraineeLevelMaster> list = null;

		if (useFinderCache) {
			list = (List<TraineeLevelMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeLevelMaster traineeLevelMaster : list) {
					if (!uuid.equals(traineeLevelMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_TRAINEELEVELMASTER_WHERE);

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
				sb.append(TraineeLevelMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeLevelMaster>)QueryUtil.list(
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
	 * Returns the first trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster findByUuid_First(
			String uuid,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (traineeLevelMaster != null) {
			return traineeLevelMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeLevelMasterException(sb.toString());
	}

	/**
	 * Returns the first trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster fetchByUuid_First(
		String uuid, OrderByComparator<TraineeLevelMaster> orderByComparator) {

		List<TraineeLevelMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (traineeLevelMaster != null) {
			return traineeLevelMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeLevelMasterException(sb.toString());
	}

	/**
	 * Returns the last trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster fetchByUuid_Last(
		String uuid, OrderByComparator<TraineeLevelMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraineeLevelMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee level masters before and after the current trainee level master in the ordered set where uuid = &#63;.
	 *
	 * @param traineeLevelMasterId the primary key of the current trainee level master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	@Override
	public TraineeLevelMaster[] findByUuid_PrevAndNext(
			long traineeLevelMasterId, String uuid,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		uuid = Objects.toString(uuid, "");

		TraineeLevelMaster traineeLevelMaster = findByPrimaryKey(
			traineeLevelMasterId);

		Session session = null;

		try {
			session = openSession();

			TraineeLevelMaster[] array = new TraineeLevelMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, traineeLevelMaster, uuid, orderByComparator, true);

			array[1] = traineeLevelMaster;

			array[2] = getByUuid_PrevAndNext(
				session, traineeLevelMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraineeLevelMaster getByUuid_PrevAndNext(
		Session session, TraineeLevelMaster traineeLevelMaster, String uuid,
		OrderByComparator<TraineeLevelMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEELEVELMASTER_WHERE);

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
			sb.append(TraineeLevelMasterModelImpl.ORDER_BY_JPQL);
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
						traineeLevelMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeLevelMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee level masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraineeLevelMaster traineeLevelMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeLevelMaster);
		}
	}

	/**
	 * Returns the number of trainee level masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee level masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEELEVELMASTER_WHERE);

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
		"traineeLevelMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(traineeLevelMaster.uuid IS NULL OR traineeLevelMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the trainee level master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeLevelMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster = fetchByUUID_G(uuid, groupId);

		if (traineeLevelMaster == null) {
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

			throw new NoSuchTraineeLevelMasterException(sb.toString());
		}

		return traineeLevelMaster;
	}

	/**
	 * Returns the trainee level master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trainee level master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster fetchByUUID_G(
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

		if (result instanceof TraineeLevelMaster) {
			TraineeLevelMaster traineeLevelMaster = (TraineeLevelMaster)result;

			if (!Objects.equals(uuid, traineeLevelMaster.getUuid()) ||
				(groupId != traineeLevelMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEELEVELMASTER_WHERE);

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

				List<TraineeLevelMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TraineeLevelMaster traineeLevelMaster = list.get(0);

					result = traineeLevelMaster;

					cacheResult(traineeLevelMaster);
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
			return (TraineeLevelMaster)result;
		}
	}

	/**
	 * Removes the trainee level master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee level master that was removed
	 */
	@Override
	public TraineeLevelMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster = findByUUID_G(uuid, groupId);

		return remove(traineeLevelMaster);
	}

	/**
	 * Returns the number of trainee level masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee level masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEELEVELMASTER_WHERE);

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
		"traineeLevelMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(traineeLevelMaster.uuid IS NULL OR traineeLevelMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"traineeLevelMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator,
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

		List<TraineeLevelMaster> list = null;

		if (useFinderCache) {
			list = (List<TraineeLevelMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeLevelMaster traineeLevelMaster : list) {
					if (!uuid.equals(traineeLevelMaster.getUuid()) ||
						(companyId != traineeLevelMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TRAINEELEVELMASTER_WHERE);

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
				sb.append(TraineeLevelMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeLevelMaster>)QueryUtil.list(
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
	 * Returns the first trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (traineeLevelMaster != null) {
			return traineeLevelMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeLevelMasterException(sb.toString());
	}

	/**
	 * Returns the first trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeLevelMaster> orderByComparator) {

		List<TraineeLevelMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (traineeLevelMaster != null) {
			return traineeLevelMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeLevelMasterException(sb.toString());
	}

	/**
	 * Returns the last trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeLevelMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraineeLevelMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee level masters before and after the current trainee level master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeLevelMasterId the primary key of the current trainee level master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	@Override
	public TraineeLevelMaster[] findByUuid_C_PrevAndNext(
			long traineeLevelMasterId, String uuid, long companyId,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		uuid = Objects.toString(uuid, "");

		TraineeLevelMaster traineeLevelMaster = findByPrimaryKey(
			traineeLevelMasterId);

		Session session = null;

		try {
			session = openSession();

			TraineeLevelMaster[] array = new TraineeLevelMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, traineeLevelMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = traineeLevelMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, traineeLevelMaster, uuid, companyId, orderByComparator,
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

	protected TraineeLevelMaster getByUuid_C_PrevAndNext(
		Session session, TraineeLevelMaster traineeLevelMaster, String uuid,
		long companyId, OrderByComparator<TraineeLevelMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEELEVELMASTER_WHERE);

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
			sb.append(TraineeLevelMasterModelImpl.ORDER_BY_JPQL);
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
						traineeLevelMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeLevelMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee level masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraineeLevelMaster traineeLevelMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeLevelMaster);
		}
	}

	/**
	 * Returns the number of trainee level masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee level masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEELEVELMASTER_WHERE);

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
		"traineeLevelMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(traineeLevelMaster.uuid IS NULL OR traineeLevelMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"traineeLevelMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBytraineeLevelNameByLike;
	private FinderPath _finderPathWithPaginationCountBytraineeLevelNameByLike;

	/**
	 * Returns all the trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @return the matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findBytraineeLevelNameByLike(
		String traineeLevelName) {

		return findBytraineeLevelNameByLike(
			traineeLevelName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelName the trainee level name
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findBytraineeLevelNameByLike(
		String traineeLevelName, int start, int end) {

		return findBytraineeLevelNameByLike(traineeLevelName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelName the trainee level name
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findBytraineeLevelNameByLike(
		String traineeLevelName, int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator) {

		return findBytraineeLevelNameByLike(
			traineeLevelName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelName the trainee level name
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findBytraineeLevelNameByLike(
		String traineeLevelName, int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator,
		boolean useFinderCache) {

		traineeLevelName = Objects.toString(traineeLevelName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBytraineeLevelNameByLike;
		finderArgs = new Object[] {
			traineeLevelName, start, end, orderByComparator
		};

		List<TraineeLevelMaster> list = null;

		if (useFinderCache) {
			list = (List<TraineeLevelMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeLevelMaster traineeLevelMaster : list) {
					if (!StringUtil.wildcardMatches(
							traineeLevelMaster.getTraineeLevelName(),
							traineeLevelName, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_TRAINEELEVELMASTER_WHERE);

			boolean bindTraineeLevelName = false;

			if (traineeLevelName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TRAINEELEVELNAMEBYLIKE_TRAINEELEVELNAME_3);
			}
			else {
				bindTraineeLevelName = true;

				sb.append(
					_FINDER_COLUMN_TRAINEELEVELNAMEBYLIKE_TRAINEELEVELNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TraineeLevelMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTraineeLevelName) {
					queryPos.add(StringUtil.toLowerCase(traineeLevelName));
				}

				list = (List<TraineeLevelMaster>)QueryUtil.list(
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
	 * Returns the first trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster findBytraineeLevelNameByLike_First(
			String traineeLevelName,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster =
			fetchBytraineeLevelNameByLike_First(
				traineeLevelName, orderByComparator);

		if (traineeLevelMaster != null) {
			return traineeLevelMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeLevelNameLIKE");
		sb.append(traineeLevelName);

		sb.append("}");

		throw new NoSuchTraineeLevelMasterException(sb.toString());
	}

	/**
	 * Returns the first trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster fetchBytraineeLevelNameByLike_First(
		String traineeLevelName,
		OrderByComparator<TraineeLevelMaster> orderByComparator) {

		List<TraineeLevelMaster> list = findBytraineeLevelNameByLike(
			traineeLevelName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster findBytraineeLevelNameByLike_Last(
			String traineeLevelName,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster =
			fetchBytraineeLevelNameByLike_Last(
				traineeLevelName, orderByComparator);

		if (traineeLevelMaster != null) {
			return traineeLevelMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeLevelNameLIKE");
		sb.append(traineeLevelName);

		sb.append("}");

		throw new NoSuchTraineeLevelMasterException(sb.toString());
	}

	/**
	 * Returns the last trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public TraineeLevelMaster fetchBytraineeLevelNameByLike_Last(
		String traineeLevelName,
		OrderByComparator<TraineeLevelMaster> orderByComparator) {

		int count = countBytraineeLevelNameByLike(traineeLevelName);

		if (count == 0) {
			return null;
		}

		List<TraineeLevelMaster> list = findBytraineeLevelNameByLike(
			traineeLevelName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee level masters before and after the current trainee level master in the ordered set where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelMasterId the primary key of the current trainee level master
	 * @param traineeLevelName the trainee level name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	@Override
	public TraineeLevelMaster[] findBytraineeLevelNameByLike_PrevAndNext(
			long traineeLevelMasterId, String traineeLevelName,
			OrderByComparator<TraineeLevelMaster> orderByComparator)
		throws NoSuchTraineeLevelMasterException {

		traineeLevelName = Objects.toString(traineeLevelName, "");

		TraineeLevelMaster traineeLevelMaster = findByPrimaryKey(
			traineeLevelMasterId);

		Session session = null;

		try {
			session = openSession();

			TraineeLevelMaster[] array = new TraineeLevelMasterImpl[3];

			array[0] = getBytraineeLevelNameByLike_PrevAndNext(
				session, traineeLevelMaster, traineeLevelName,
				orderByComparator, true);

			array[1] = traineeLevelMaster;

			array[2] = getBytraineeLevelNameByLike_PrevAndNext(
				session, traineeLevelMaster, traineeLevelName,
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

	protected TraineeLevelMaster getBytraineeLevelNameByLike_PrevAndNext(
		Session session, TraineeLevelMaster traineeLevelMaster,
		String traineeLevelName,
		OrderByComparator<TraineeLevelMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEELEVELMASTER_WHERE);

		boolean bindTraineeLevelName = false;

		if (traineeLevelName.isEmpty()) {
			sb.append(_FINDER_COLUMN_TRAINEELEVELNAMEBYLIKE_TRAINEELEVELNAME_3);
		}
		else {
			bindTraineeLevelName = true;

			sb.append(_FINDER_COLUMN_TRAINEELEVELNAMEBYLIKE_TRAINEELEVELNAME_2);
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
			sb.append(TraineeLevelMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTraineeLevelName) {
			queryPos.add(StringUtil.toLowerCase(traineeLevelName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeLevelMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeLevelMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee level masters where traineeLevelName LIKE &#63; from the database.
	 *
	 * @param traineeLevelName the trainee level name
	 */
	@Override
	public void removeBytraineeLevelNameByLike(String traineeLevelName) {
		for (TraineeLevelMaster traineeLevelMaster :
				findBytraineeLevelNameByLike(
					traineeLevelName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeLevelMaster);
		}
	}

	/**
	 * Returns the number of trainee level masters where traineeLevelName LIKE &#63;.
	 *
	 * @param traineeLevelName the trainee level name
	 * @return the number of matching trainee level masters
	 */
	@Override
	public int countBytraineeLevelNameByLike(String traineeLevelName) {
		traineeLevelName = Objects.toString(traineeLevelName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountBytraineeLevelNameByLike;

		Object[] finderArgs = new Object[] {traineeLevelName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEELEVELMASTER_WHERE);

			boolean bindTraineeLevelName = false;

			if (traineeLevelName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TRAINEELEVELNAMEBYLIKE_TRAINEELEVELNAME_3);
			}
			else {
				bindTraineeLevelName = true;

				sb.append(
					_FINDER_COLUMN_TRAINEELEVELNAMEBYLIKE_TRAINEELEVELNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTraineeLevelName) {
					queryPos.add(StringUtil.toLowerCase(traineeLevelName));
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
		_FINDER_COLUMN_TRAINEELEVELNAMEBYLIKE_TRAINEELEVELNAME_2 =
			"lower(traineeLevelMaster.traineeLevelName) LIKE ?";

	private static final String
		_FINDER_COLUMN_TRAINEELEVELNAMEBYLIKE_TRAINEELEVELNAME_3 =
			"(traineeLevelMaster.traineeLevelName IS NULL OR traineeLevelMaster.traineeLevelName LIKE '')";

	public TraineeLevelMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("traineeLevelMasterId", "trainee_level_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("traineeLevelName", "trainee_level_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(TraineeLevelMaster.class);

		setModelImplClass(TraineeLevelMasterImpl.class);
		setModelPKClass(long.class);

		setTable(TraineeLevelMasterTable.INSTANCE);
	}

	/**
	 * Caches the trainee level master in the entity cache if it is enabled.
	 *
	 * @param traineeLevelMaster the trainee level master
	 */
	@Override
	public void cacheResult(TraineeLevelMaster traineeLevelMaster) {
		entityCache.putResult(
			TraineeLevelMasterImpl.class, traineeLevelMaster.getPrimaryKey(),
			traineeLevelMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				traineeLevelMaster.getUuid(), traineeLevelMaster.getGroupId()
			},
			traineeLevelMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the trainee level masters in the entity cache if it is enabled.
	 *
	 * @param traineeLevelMasters the trainee level masters
	 */
	@Override
	public void cacheResult(List<TraineeLevelMaster> traineeLevelMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (traineeLevelMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TraineeLevelMaster traineeLevelMaster : traineeLevelMasters) {
			if (entityCache.getResult(
					TraineeLevelMasterImpl.class,
					traineeLevelMaster.getPrimaryKey()) == null) {

				cacheResult(traineeLevelMaster);
			}
		}
	}

	/**
	 * Clears the cache for all trainee level masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TraineeLevelMasterImpl.class);

		finderCache.clearCache(TraineeLevelMasterImpl.class);
	}

	/**
	 * Clears the cache for the trainee level master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TraineeLevelMaster traineeLevelMaster) {
		entityCache.removeResult(
			TraineeLevelMasterImpl.class, traineeLevelMaster);
	}

	@Override
	public void clearCache(List<TraineeLevelMaster> traineeLevelMasters) {
		for (TraineeLevelMaster traineeLevelMaster : traineeLevelMasters) {
			entityCache.removeResult(
				TraineeLevelMasterImpl.class, traineeLevelMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TraineeLevelMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TraineeLevelMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TraineeLevelMasterModelImpl traineeLevelMasterModelImpl) {

		Object[] args = new Object[] {
			traineeLevelMasterModelImpl.getUuid(),
			traineeLevelMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, traineeLevelMasterModelImpl);
	}

	/**
	 * Creates a new trainee level master with the primary key. Does not add the trainee level master to the database.
	 *
	 * @param traineeLevelMasterId the primary key for the new trainee level master
	 * @return the new trainee level master
	 */
	@Override
	public TraineeLevelMaster create(long traineeLevelMasterId) {
		TraineeLevelMaster traineeLevelMaster = new TraineeLevelMasterImpl();

		traineeLevelMaster.setNew(true);
		traineeLevelMaster.setPrimaryKey(traineeLevelMasterId);

		String uuid = _portalUUID.generate();

		traineeLevelMaster.setUuid(uuid);

		traineeLevelMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return traineeLevelMaster;
	}

	/**
	 * Removes the trainee level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master that was removed
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	@Override
	public TraineeLevelMaster remove(long traineeLevelMasterId)
		throws NoSuchTraineeLevelMasterException {

		return remove((Serializable)traineeLevelMasterId);
	}

	/**
	 * Removes the trainee level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainee level master
	 * @return the trainee level master that was removed
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	@Override
	public TraineeLevelMaster remove(Serializable primaryKey)
		throws NoSuchTraineeLevelMasterException {

		Session session = null;

		try {
			session = openSession();

			TraineeLevelMaster traineeLevelMaster =
				(TraineeLevelMaster)session.get(
					TraineeLevelMasterImpl.class, primaryKey);

			if (traineeLevelMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraineeLevelMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(traineeLevelMaster);
		}
		catch (NoSuchTraineeLevelMasterException noSuchEntityException) {
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
	protected TraineeLevelMaster removeImpl(
		TraineeLevelMaster traineeLevelMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traineeLevelMaster)) {
				traineeLevelMaster = (TraineeLevelMaster)session.get(
					TraineeLevelMasterImpl.class,
					traineeLevelMaster.getPrimaryKeyObj());
			}

			if (traineeLevelMaster != null) {
				session.delete(traineeLevelMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (traineeLevelMaster != null) {
			clearCache(traineeLevelMaster);
		}

		return traineeLevelMaster;
	}

	@Override
	public TraineeLevelMaster updateImpl(
		TraineeLevelMaster traineeLevelMaster) {

		boolean isNew = traineeLevelMaster.isNew();

		if (!(traineeLevelMaster instanceof TraineeLevelMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(traineeLevelMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					traineeLevelMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in traineeLevelMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TraineeLevelMaster implementation " +
					traineeLevelMaster.getClass());
		}

		TraineeLevelMasterModelImpl traineeLevelMasterModelImpl =
			(TraineeLevelMasterModelImpl)traineeLevelMaster;

		if (Validator.isNull(traineeLevelMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			traineeLevelMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (traineeLevelMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				traineeLevelMaster.setCreateDate(date);
			}
			else {
				traineeLevelMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!traineeLevelMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				traineeLevelMaster.setModifiedDate(date);
			}
			else {
				traineeLevelMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(traineeLevelMaster);
			}
			else {
				traineeLevelMaster = (TraineeLevelMaster)session.merge(
					traineeLevelMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TraineeLevelMasterImpl.class, traineeLevelMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(traineeLevelMasterModelImpl);

		if (isNew) {
			traineeLevelMaster.setNew(false);
		}

		traineeLevelMaster.resetOriginalValues();

		return traineeLevelMaster;
	}

	/**
	 * Returns the trainee level master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainee level master
	 * @return the trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	@Override
	public TraineeLevelMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTraineeLevelMasterException {

		TraineeLevelMaster traineeLevelMaster = fetchByPrimaryKey(primaryKey);

		if (traineeLevelMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraineeLevelMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return traineeLevelMaster;
	}

	/**
	 * Returns the trainee level master with the primary key or throws a <code>NoSuchTraineeLevelMasterException</code> if it could not be found.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master
	 * @throws NoSuchTraineeLevelMasterException if a trainee level master with the primary key could not be found
	 */
	@Override
	public TraineeLevelMaster findByPrimaryKey(long traineeLevelMasterId)
		throws NoSuchTraineeLevelMasterException {

		return findByPrimaryKey((Serializable)traineeLevelMasterId);
	}

	/**
	 * Returns the trainee level master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master, or <code>null</code> if a trainee level master with the primary key could not be found
	 */
	@Override
	public TraineeLevelMaster fetchByPrimaryKey(long traineeLevelMasterId) {
		return fetchByPrimaryKey((Serializable)traineeLevelMasterId);
	}

	/**
	 * Returns all the trainee level masters.
	 *
	 * @return the trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findAll(
		int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee level masters
	 */
	@Override
	public List<TraineeLevelMaster> findAll(
		int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator,
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

		List<TraineeLevelMaster> list = null;

		if (useFinderCache) {
			list = (List<TraineeLevelMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINEELEVELMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINEELEVELMASTER;

				sql = sql.concat(TraineeLevelMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TraineeLevelMaster>)QueryUtil.list(
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
	 * Removes all the trainee level masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraineeLevelMaster traineeLevelMaster : findAll()) {
			remove(traineeLevelMaster);
		}
	}

	/**
	 * Returns the number of trainee level masters.
	 *
	 * @return the number of trainee level masters
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
					_SQL_COUNT_TRAINEELEVELMASTER);

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
		return "trainee_level_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINEELEVELMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraineeLevelMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainee level master persistence.
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

		_finderPathWithPaginationFindBytraineeLevelNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBytraineeLevelNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"trainee_level_name"}, true);

		_finderPathWithPaginationCountBytraineeLevelNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBytraineeLevelNameByLike",
			new String[] {String.class.getName()},
			new String[] {"trainee_level_name"}, false);

		_setTraineeLevelMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTraineeLevelMasterUtilPersistence(null);

		entityCache.removeCache(TraineeLevelMasterImpl.class.getName());
	}

	private void _setTraineeLevelMasterUtilPersistence(
		TraineeLevelMasterPersistence traineeLevelMasterPersistence) {

		try {
			Field field = TraineeLevelMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, traineeLevelMasterPersistence);
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

	private static final String _SQL_SELECT_TRAINEELEVELMASTER =
		"SELECT traineeLevelMaster FROM TraineeLevelMaster traineeLevelMaster";

	private static final String _SQL_SELECT_TRAINEELEVELMASTER_WHERE =
		"SELECT traineeLevelMaster FROM TraineeLevelMaster traineeLevelMaster WHERE ";

	private static final String _SQL_COUNT_TRAINEELEVELMASTER =
		"SELECT COUNT(traineeLevelMaster) FROM TraineeLevelMaster traineeLevelMaster";

	private static final String _SQL_COUNT_TRAINEELEVELMASTER_WHERE =
		"SELECT COUNT(traineeLevelMaster) FROM TraineeLevelMaster traineeLevelMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "traineeLevelMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TraineeLevelMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TraineeLevelMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TraineeLevelMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "traineeLevelMasterId", "groupId", "companyId",
			"createDate", "modifiedDate", "createdBy", "modifiedBy",
			"traineeLevelName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchTrainingSitesMasterException;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.model.TrainingSitesMasterTable;
import gov.omsb.tms.model.impl.TrainingSitesMasterImpl;
import gov.omsb.tms.model.impl.TrainingSitesMasterModelImpl;
import gov.omsb.tms.service.persistence.TrainingSitesMasterPersistence;
import gov.omsb.tms.service.persistence.TrainingSitesMasterUtil;
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
 * The persistence implementation for the training sites master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TrainingSitesMasterPersistence.class)
public class TrainingSitesMasterPersistenceImpl
	extends BasePersistenceImpl<TrainingSitesMaster>
	implements TrainingSitesMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TrainingSitesMasterUtil</code> to access the training sites master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TrainingSitesMasterImpl.class.getName();

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
	 * Returns all the training sites masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
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

		List<TrainingSitesMaster> list = null;

		if (useFinderCache) {
			list = (List<TrainingSitesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrainingSitesMaster trainingSitesMaster : list) {
					if (!uuid.equals(trainingSitesMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

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
				sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<TrainingSitesMaster>)QueryUtil.list(
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
	 * Returns the first training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByUuid_First(
			String uuid,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByUuid_First(
		String uuid, OrderByComparator<TrainingSitesMaster> orderByComparator) {

		List<TrainingSitesMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByUuid_Last(
			String uuid,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByUuid_Last(
		String uuid, OrderByComparator<TrainingSitesMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TrainingSitesMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster[] findByUuid_PrevAndNext(
			long trainingSiteMasterId, String uuid,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		uuid = Objects.toString(uuid, "");

		TrainingSitesMaster trainingSitesMaster = findByPrimaryKey(
			trainingSiteMasterId);

		Session session = null;

		try {
			session = openSession();

			TrainingSitesMaster[] array = new TrainingSitesMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, trainingSitesMaster, uuid, orderByComparator, true);

			array[1] = trainingSitesMaster;

			array[2] = getByUuid_PrevAndNext(
				session, trainingSitesMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrainingSitesMaster getByUuid_PrevAndNext(
		Session session, TrainingSitesMaster trainingSitesMaster, String uuid,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

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
			sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
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
						trainingSitesMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TrainingSitesMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the training sites masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TrainingSitesMaster trainingSitesMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(trainingSitesMaster);
		}
	}

	/**
	 * Returns the number of training sites masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching training sites masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAININGSITESMASTER_WHERE);

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
		"trainingSitesMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(trainingSitesMaster.uuid IS NULL OR trainingSitesMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTrainingSitesMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster = fetchByUUID_G(uuid, groupId);

		if (trainingSitesMaster == null) {
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

			throw new NoSuchTrainingSitesMasterException(sb.toString());
		}

		return trainingSitesMaster;
	}

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByUUID_G(
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

		if (result instanceof TrainingSitesMaster) {
			TrainingSitesMaster trainingSitesMaster =
				(TrainingSitesMaster)result;

			if (!Objects.equals(uuid, trainingSitesMaster.getUuid()) ||
				(groupId != trainingSitesMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

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

				List<TrainingSitesMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TrainingSitesMaster trainingSitesMaster = list.get(0);

					result = trainingSitesMaster;

					cacheResult(trainingSitesMaster);
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
			return (TrainingSitesMaster)result;
		}
	}

	/**
	 * Removes the training sites master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the training sites master that was removed
	 */
	@Override
	public TrainingSitesMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster = findByUUID_G(uuid, groupId);

		return remove(trainingSitesMaster);
	}

	/**
	 * Returns the number of training sites masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching training sites masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAININGSITESMASTER_WHERE);

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
		"trainingSitesMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(trainingSitesMaster.uuid IS NULL OR trainingSitesMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"trainingSitesMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
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

		List<TrainingSitesMaster> list = null;

		if (useFinderCache) {
			list = (List<TrainingSitesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrainingSitesMaster trainingSitesMaster : list) {
					if (!uuid.equals(trainingSitesMaster.getUuid()) ||
						(companyId != trainingSitesMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

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
				sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<TrainingSitesMaster>)QueryUtil.list(
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
	 * Returns the first training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		List<TrainingSitesMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TrainingSitesMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster[] findByUuid_C_PrevAndNext(
			long trainingSiteMasterId, String uuid, long companyId,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		uuid = Objects.toString(uuid, "");

		TrainingSitesMaster trainingSitesMaster = findByPrimaryKey(
			trainingSiteMasterId);

		Session session = null;

		try {
			session = openSession();

			TrainingSitesMaster[] array = new TrainingSitesMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, trainingSitesMaster, uuid, companyId,
				orderByComparator, true);

			array[1] = trainingSitesMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, trainingSitesMaster, uuid, companyId,
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

	protected TrainingSitesMaster getByUuid_C_PrevAndNext(
		Session session, TrainingSitesMaster trainingSitesMaster, String uuid,
		long companyId,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

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
			sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
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
						trainingSitesMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TrainingSitesMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the training sites masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TrainingSitesMaster trainingSitesMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(trainingSitesMaster);
		}
	}

	/**
	 * Returns the number of training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching training sites masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAININGSITESMASTER_WHERE);

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
		"trainingSitesMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(trainingSitesMaster.uuid IS NULL OR trainingSitesMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"trainingSitesMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTrainingSiteStatus;
	private FinderPath _finderPathWithoutPaginationFindByTrainingSiteStatus;
	private FinderPath _finderPathCountByTrainingSiteStatus;

	/**
	 * Returns all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @return the matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus) {

		return findByTrainingSiteStatus(
			trainingSiteStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end) {

		return findByTrainingSiteStatus(trainingSiteStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return findByTrainingSiteStatus(
			trainingSiteStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTrainingSiteStatus;
				finderArgs = new Object[] {trainingSiteStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTrainingSiteStatus;
			finderArgs = new Object[] {
				trainingSiteStatus, start, end, orderByComparator
			};
		}

		List<TrainingSitesMaster> list = null;

		if (useFinderCache) {
			list = (List<TrainingSitesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrainingSitesMaster trainingSitesMaster : list) {
					if (!Objects.equals(
							trainingSiteStatus,
							trainingSitesMaster.getTrainingSiteStatus())) {

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

			sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

			sb.append(_FINDER_COLUMN_TRAININGSITESTATUS_TRAININGSITESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSiteStatus.booleanValue());

				list = (List<TrainingSitesMaster>)QueryUtil.list(
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
	 * Returns the first training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByTrainingSiteStatus_First(
			Boolean trainingSiteStatus,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster =
			fetchByTrainingSiteStatus_First(
				trainingSiteStatus, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trainingSiteStatus=");
		sb.append(trainingSiteStatus);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByTrainingSiteStatus_First(
		Boolean trainingSiteStatus,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		List<TrainingSitesMaster> list = findByTrainingSiteStatus(
			trainingSiteStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByTrainingSiteStatus_Last(
			Boolean trainingSiteStatus,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster =
			fetchByTrainingSiteStatus_Last(
				trainingSiteStatus, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trainingSiteStatus=");
		sb.append(trainingSiteStatus);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByTrainingSiteStatus_Last(
		Boolean trainingSiteStatus,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		int count = countByTrainingSiteStatus(trainingSiteStatus);

		if (count == 0) {
			return null;
		}

		List<TrainingSitesMaster> list = findByTrainingSiteStatus(
			trainingSiteStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster[] findByTrainingSiteStatus_PrevAndNext(
			long trainingSiteMasterId, Boolean trainingSiteStatus,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster = findByPrimaryKey(
			trainingSiteMasterId);

		Session session = null;

		try {
			session = openSession();

			TrainingSitesMaster[] array = new TrainingSitesMasterImpl[3];

			array[0] = getByTrainingSiteStatus_PrevAndNext(
				session, trainingSitesMaster, trainingSiteStatus,
				orderByComparator, true);

			array[1] = trainingSitesMaster;

			array[2] = getByTrainingSiteStatus_PrevAndNext(
				session, trainingSitesMaster, trainingSiteStatus,
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

	protected TrainingSitesMaster getByTrainingSiteStatus_PrevAndNext(
		Session session, TrainingSitesMaster trainingSitesMaster,
		Boolean trainingSiteStatus,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

		sb.append(_FINDER_COLUMN_TRAININGSITESTATUS_TRAININGSITESTATUS_2);

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
			sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(trainingSiteStatus.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						trainingSitesMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TrainingSitesMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the training sites masters where trainingSiteStatus = &#63; from the database.
	 *
	 * @param trainingSiteStatus the training site status
	 */
	@Override
	public void removeByTrainingSiteStatus(Boolean trainingSiteStatus) {
		for (TrainingSitesMaster trainingSitesMaster :
				findByTrainingSiteStatus(
					trainingSiteStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(trainingSitesMaster);
		}
	}

	/**
	 * Returns the number of training sites masters where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @return the number of matching training sites masters
	 */
	@Override
	public int countByTrainingSiteStatus(Boolean trainingSiteStatus) {
		FinderPath finderPath = _finderPathCountByTrainingSiteStatus;

		Object[] finderArgs = new Object[] {trainingSiteStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAININGSITESMASTER_WHERE);

			sb.append(_FINDER_COLUMN_TRAININGSITESTATUS_TRAININGSITESTATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSiteStatus.booleanValue());

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
		_FINDER_COLUMN_TRAININGSITESTATUS_TRAININGSITESTATUS_2 =
			"trainingSitesMaster.trainingSiteStatus = ?";

	private FinderPath _finderPathWithPaginationFindByTrainingSiteNameByLike;
	private FinderPath _finderPathWithPaginationCountByTrainingSiteNameByLike;

	/**
	 * Returns all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @return the matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName) {

		return findByTrainingSiteNameByLike(
			trainingSiteName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end) {

		return findByTrainingSiteNameByLike(trainingSiteName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return findByTrainingSiteNameByLike(
			trainingSiteName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		trainingSiteName = Objects.toString(trainingSiteName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByTrainingSiteNameByLike;
		finderArgs = new Object[] {
			trainingSiteName, start, end, orderByComparator
		};

		List<TrainingSitesMaster> list = null;

		if (useFinderCache) {
			list = (List<TrainingSitesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrainingSitesMaster trainingSitesMaster : list) {
					if (!StringUtil.wildcardMatches(
							trainingSitesMaster.getTrainingSiteName(),
							trainingSiteName, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

			boolean bindTrainingSiteName = false;

			if (trainingSiteName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TRAININGSITENAMEBYLIKE_TRAININGSITENAME_3);
			}
			else {
				bindTrainingSiteName = true;

				sb.append(
					_FINDER_COLUMN_TRAININGSITENAMEBYLIKE_TRAININGSITENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTrainingSiteName) {
					queryPos.add(StringUtil.toLowerCase(trainingSiteName));
				}

				list = (List<TrainingSitesMaster>)QueryUtil.list(
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
	 * Returns the first training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByTrainingSiteNameByLike_First(
			String trainingSiteName,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster =
			fetchByTrainingSiteNameByLike_First(
				trainingSiteName, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trainingSiteNameLIKE");
		sb.append(trainingSiteName);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByTrainingSiteNameByLike_First(
		String trainingSiteName,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		List<TrainingSitesMaster> list = findByTrainingSiteNameByLike(
			trainingSiteName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByTrainingSiteNameByLike_Last(
			String trainingSiteName,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster =
			fetchByTrainingSiteNameByLike_Last(
				trainingSiteName, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trainingSiteNameLIKE");
		sb.append(trainingSiteName);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByTrainingSiteNameByLike_Last(
		String trainingSiteName,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		int count = countByTrainingSiteNameByLike(trainingSiteName);

		if (count == 0) {
			return null;
		}

		List<TrainingSitesMaster> list = findByTrainingSiteNameByLike(
			trainingSiteName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster[] findByTrainingSiteNameByLike_PrevAndNext(
			long trainingSiteMasterId, String trainingSiteName,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		trainingSiteName = Objects.toString(trainingSiteName, "");

		TrainingSitesMaster trainingSitesMaster = findByPrimaryKey(
			trainingSiteMasterId);

		Session session = null;

		try {
			session = openSession();

			TrainingSitesMaster[] array = new TrainingSitesMasterImpl[3];

			array[0] = getByTrainingSiteNameByLike_PrevAndNext(
				session, trainingSitesMaster, trainingSiteName,
				orderByComparator, true);

			array[1] = trainingSitesMaster;

			array[2] = getByTrainingSiteNameByLike_PrevAndNext(
				session, trainingSitesMaster, trainingSiteName,
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

	protected TrainingSitesMaster getByTrainingSiteNameByLike_PrevAndNext(
		Session session, TrainingSitesMaster trainingSitesMaster,
		String trainingSiteName,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

		boolean bindTrainingSiteName = false;

		if (trainingSiteName.isEmpty()) {
			sb.append(_FINDER_COLUMN_TRAININGSITENAMEBYLIKE_TRAININGSITENAME_3);
		}
		else {
			bindTrainingSiteName = true;

			sb.append(_FINDER_COLUMN_TRAININGSITENAMEBYLIKE_TRAININGSITENAME_2);
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
			sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTrainingSiteName) {
			queryPos.add(StringUtil.toLowerCase(trainingSiteName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						trainingSitesMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TrainingSitesMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the training sites masters where trainingSiteName LIKE &#63; from the database.
	 *
	 * @param trainingSiteName the training site name
	 */
	@Override
	public void removeByTrainingSiteNameByLike(String trainingSiteName) {
		for (TrainingSitesMaster trainingSitesMaster :
				findByTrainingSiteNameByLike(
					trainingSiteName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(trainingSitesMaster);
		}
	}

	/**
	 * Returns the number of training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @return the number of matching training sites masters
	 */
	@Override
	public int countByTrainingSiteNameByLike(String trainingSiteName) {
		trainingSiteName = Objects.toString(trainingSiteName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByTrainingSiteNameByLike;

		Object[] finderArgs = new Object[] {trainingSiteName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAININGSITESMASTER_WHERE);

			boolean bindTrainingSiteName = false;

			if (trainingSiteName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TRAININGSITENAMEBYLIKE_TRAININGSITENAME_3);
			}
			else {
				bindTrainingSiteName = true;

				sb.append(
					_FINDER_COLUMN_TRAININGSITENAMEBYLIKE_TRAININGSITENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTrainingSiteName) {
					queryPos.add(StringUtil.toLowerCase(trainingSiteName));
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
		_FINDER_COLUMN_TRAININGSITENAMEBYLIKE_TRAININGSITENAME_2 =
			"lower(trainingSitesMaster.trainingSiteName) LIKE ?";

	private static final String
		_FINDER_COLUMN_TRAININGSITENAMEBYLIKE_TRAININGSITENAME_3 =
			"(trainingSitesMaster.trainingSiteName IS NULL OR trainingSitesMaster.trainingSiteName LIKE '')";

	private FinderPath _finderPathWithPaginationFindByTrainingSiteCodeByLike;
	private FinderPath _finderPathWithPaginationCountByTrainingSiteCodeByLike;

	/**
	 * Returns all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @return the matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode) {

		return findByTrainingSiteCodeByLike(
			trainingSiteCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end) {

		return findByTrainingSiteCodeByLike(trainingSiteCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return findByTrainingSiteCodeByLike(
			trainingSiteCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		trainingSiteCode = Objects.toString(trainingSiteCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByTrainingSiteCodeByLike;
		finderArgs = new Object[] {
			trainingSiteCode, start, end, orderByComparator
		};

		List<TrainingSitesMaster> list = null;

		if (useFinderCache) {
			list = (List<TrainingSitesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrainingSitesMaster trainingSitesMaster : list) {
					if (!StringUtil.wildcardMatches(
							trainingSitesMaster.getTrainingSiteCode(),
							trainingSiteCode, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

			boolean bindTrainingSiteCode = false;

			if (trainingSiteCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TRAININGSITECODEBYLIKE_TRAININGSITECODE_3);
			}
			else {
				bindTrainingSiteCode = true;

				sb.append(
					_FINDER_COLUMN_TRAININGSITECODEBYLIKE_TRAININGSITECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTrainingSiteCode) {
					queryPos.add(StringUtil.toLowerCase(trainingSiteCode));
				}

				list = (List<TrainingSitesMaster>)QueryUtil.list(
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
	 * Returns the first training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByTrainingSiteCodeByLike_First(
			String trainingSiteCode,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster =
			fetchByTrainingSiteCodeByLike_First(
				trainingSiteCode, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trainingSiteCodeLIKE");
		sb.append(trainingSiteCode);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByTrainingSiteCodeByLike_First(
		String trainingSiteCode,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		List<TrainingSitesMaster> list = findByTrainingSiteCodeByLike(
			trainingSiteCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster findByTrainingSiteCodeByLike_Last(
			String trainingSiteCode,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster =
			fetchByTrainingSiteCodeByLike_Last(
				trainingSiteCode, orderByComparator);

		if (trainingSitesMaster != null) {
			return trainingSitesMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trainingSiteCodeLIKE");
		sb.append(trainingSiteCode);

		sb.append("}");

		throw new NoSuchTrainingSitesMasterException(sb.toString());
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByTrainingSiteCodeByLike_Last(
		String trainingSiteCode,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		int count = countByTrainingSiteCodeByLike(trainingSiteCode);

		if (count == 0) {
			return null;
		}

		List<TrainingSitesMaster> list = findByTrainingSiteCodeByLike(
			trainingSiteCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster[] findByTrainingSiteCodeByLike_PrevAndNext(
			long trainingSiteMasterId, String trainingSiteCode,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws NoSuchTrainingSitesMasterException {

		trainingSiteCode = Objects.toString(trainingSiteCode, "");

		TrainingSitesMaster trainingSitesMaster = findByPrimaryKey(
			trainingSiteMasterId);

		Session session = null;

		try {
			session = openSession();

			TrainingSitesMaster[] array = new TrainingSitesMasterImpl[3];

			array[0] = getByTrainingSiteCodeByLike_PrevAndNext(
				session, trainingSitesMaster, trainingSiteCode,
				orderByComparator, true);

			array[1] = trainingSitesMaster;

			array[2] = getByTrainingSiteCodeByLike_PrevAndNext(
				session, trainingSitesMaster, trainingSiteCode,
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

	protected TrainingSitesMaster getByTrainingSiteCodeByLike_PrevAndNext(
		Session session, TrainingSitesMaster trainingSitesMaster,
		String trainingSiteCode,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAININGSITESMASTER_WHERE);

		boolean bindTrainingSiteCode = false;

		if (trainingSiteCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_TRAININGSITECODEBYLIKE_TRAININGSITECODE_3);
		}
		else {
			bindTrainingSiteCode = true;

			sb.append(_FINDER_COLUMN_TRAININGSITECODEBYLIKE_TRAININGSITECODE_2);
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
			sb.append(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTrainingSiteCode) {
			queryPos.add(StringUtil.toLowerCase(trainingSiteCode));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						trainingSitesMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TrainingSitesMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the training sites masters where trainingSiteCode LIKE &#63; from the database.
	 *
	 * @param trainingSiteCode the training site code
	 */
	@Override
	public void removeByTrainingSiteCodeByLike(String trainingSiteCode) {
		for (TrainingSitesMaster trainingSitesMaster :
				findByTrainingSiteCodeByLike(
					trainingSiteCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(trainingSitesMaster);
		}
	}

	/**
	 * Returns the number of training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @return the number of matching training sites masters
	 */
	@Override
	public int countByTrainingSiteCodeByLike(String trainingSiteCode) {
		trainingSiteCode = Objects.toString(trainingSiteCode, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByTrainingSiteCodeByLike;

		Object[] finderArgs = new Object[] {trainingSiteCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAININGSITESMASTER_WHERE);

			boolean bindTrainingSiteCode = false;

			if (trainingSiteCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TRAININGSITECODEBYLIKE_TRAININGSITECODE_3);
			}
			else {
				bindTrainingSiteCode = true;

				sb.append(
					_FINDER_COLUMN_TRAININGSITECODEBYLIKE_TRAININGSITECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTrainingSiteCode) {
					queryPos.add(StringUtil.toLowerCase(trainingSiteCode));
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
		_FINDER_COLUMN_TRAININGSITECODEBYLIKE_TRAININGSITECODE_2 =
			"lower(trainingSitesMaster.trainingSiteCode) LIKE ?";

	private static final String
		_FINDER_COLUMN_TRAININGSITECODEBYLIKE_TRAININGSITECODE_3 =
			"(trainingSitesMaster.trainingSiteCode IS NULL OR trainingSitesMaster.trainingSiteCode LIKE '')";

	public TrainingSitesMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("trainingSiteMasterId", "training_site_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("trainingSiteName", "training_site_name");
		dbColumnNames.put("trainingSiteCode", "training_site_code");
		dbColumnNames.put("trainingSiteStatus", "training_site_status");
		dbColumnNames.put("trainingSiteAddress", "training_site_address");
		dbColumnNames.put(
			"trainingSiteDescription", "training_site_description");

		setDBColumnNames(dbColumnNames);

		setModelClass(TrainingSitesMaster.class);

		setModelImplClass(TrainingSitesMasterImpl.class);
		setModelPKClass(long.class);

		setTable(TrainingSitesMasterTable.INSTANCE);
	}

	/**
	 * Caches the training sites master in the entity cache if it is enabled.
	 *
	 * @param trainingSitesMaster the training sites master
	 */
	@Override
	public void cacheResult(TrainingSitesMaster trainingSitesMaster) {
		entityCache.putResult(
			TrainingSitesMasterImpl.class, trainingSitesMaster.getPrimaryKey(),
			trainingSitesMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				trainingSitesMaster.getUuid(), trainingSitesMaster.getGroupId()
			},
			trainingSitesMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the training sites masters in the entity cache if it is enabled.
	 *
	 * @param trainingSitesMasters the training sites masters
	 */
	@Override
	public void cacheResult(List<TrainingSitesMaster> trainingSitesMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (trainingSitesMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TrainingSitesMaster trainingSitesMaster : trainingSitesMasters) {
			if (entityCache.getResult(
					TrainingSitesMasterImpl.class,
					trainingSitesMaster.getPrimaryKey()) == null) {

				cacheResult(trainingSitesMaster);
			}
		}
	}

	/**
	 * Clears the cache for all training sites masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TrainingSitesMasterImpl.class);

		finderCache.clearCache(TrainingSitesMasterImpl.class);
	}

	/**
	 * Clears the cache for the training sites master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrainingSitesMaster trainingSitesMaster) {
		entityCache.removeResult(
			TrainingSitesMasterImpl.class, trainingSitesMaster);
	}

	@Override
	public void clearCache(List<TrainingSitesMaster> trainingSitesMasters) {
		for (TrainingSitesMaster trainingSitesMaster : trainingSitesMasters) {
			entityCache.removeResult(
				TrainingSitesMasterImpl.class, trainingSitesMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TrainingSitesMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TrainingSitesMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TrainingSitesMasterModelImpl trainingSitesMasterModelImpl) {

		Object[] args = new Object[] {
			trainingSitesMasterModelImpl.getUuid(),
			trainingSitesMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, trainingSitesMasterModelImpl);
	}

	/**
	 * Creates a new training sites master with the primary key. Does not add the training sites master to the database.
	 *
	 * @param trainingSiteMasterId the primary key for the new training sites master
	 * @return the new training sites master
	 */
	@Override
	public TrainingSitesMaster create(long trainingSiteMasterId) {
		TrainingSitesMaster trainingSitesMaster = new TrainingSitesMasterImpl();

		trainingSitesMaster.setNew(true);
		trainingSitesMaster.setPrimaryKey(trainingSiteMasterId);

		String uuid = _portalUUID.generate();

		trainingSitesMaster.setUuid(uuid);

		trainingSitesMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return trainingSitesMaster;
	}

	/**
	 * Removes the training sites master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master that was removed
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster remove(long trainingSiteMasterId)
		throws NoSuchTrainingSitesMasterException {

		return remove((Serializable)trainingSiteMasterId);
	}

	/**
	 * Removes the training sites master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the training sites master
	 * @return the training sites master that was removed
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster remove(Serializable primaryKey)
		throws NoSuchTrainingSitesMasterException {

		Session session = null;

		try {
			session = openSession();

			TrainingSitesMaster trainingSitesMaster =
				(TrainingSitesMaster)session.get(
					TrainingSitesMasterImpl.class, primaryKey);

			if (trainingSitesMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrainingSitesMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(trainingSitesMaster);
		}
		catch (NoSuchTrainingSitesMasterException noSuchEntityException) {
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
	protected TrainingSitesMaster removeImpl(
		TrainingSitesMaster trainingSitesMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(trainingSitesMaster)) {
				trainingSitesMaster = (TrainingSitesMaster)session.get(
					TrainingSitesMasterImpl.class,
					trainingSitesMaster.getPrimaryKeyObj());
			}

			if (trainingSitesMaster != null) {
				session.delete(trainingSitesMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (trainingSitesMaster != null) {
			clearCache(trainingSitesMaster);
		}

		return trainingSitesMaster;
	}

	@Override
	public TrainingSitesMaster updateImpl(
		TrainingSitesMaster trainingSitesMaster) {

		boolean isNew = trainingSitesMaster.isNew();

		if (!(trainingSitesMaster instanceof TrainingSitesMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(trainingSitesMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					trainingSitesMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in trainingSitesMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TrainingSitesMaster implementation " +
					trainingSitesMaster.getClass());
		}

		TrainingSitesMasterModelImpl trainingSitesMasterModelImpl =
			(TrainingSitesMasterModelImpl)trainingSitesMaster;

		if (Validator.isNull(trainingSitesMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			trainingSitesMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (trainingSitesMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				trainingSitesMaster.setCreateDate(date);
			}
			else {
				trainingSitesMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!trainingSitesMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				trainingSitesMaster.setModifiedDate(date);
			}
			else {
				trainingSitesMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(trainingSitesMaster);
			}
			else {
				trainingSitesMaster = (TrainingSitesMaster)session.merge(
					trainingSitesMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TrainingSitesMasterImpl.class, trainingSitesMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(trainingSitesMasterModelImpl);

		if (isNew) {
			trainingSitesMaster.setNew(false);
		}

		trainingSitesMaster.resetOriginalValues();

		return trainingSitesMaster;
	}

	/**
	 * Returns the training sites master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the training sites master
	 * @return the training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrainingSitesMasterException {

		TrainingSitesMaster trainingSitesMaster = fetchByPrimaryKey(primaryKey);

		if (trainingSitesMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTrainingSitesMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return trainingSitesMaster;
	}

	/**
	 * Returns the training sites master with the primary key or throws a <code>NoSuchTrainingSitesMasterException</code> if it could not be found.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster findByPrimaryKey(long trainingSiteMasterId)
		throws NoSuchTrainingSitesMasterException {

		return findByPrimaryKey((Serializable)trainingSiteMasterId);
	}

	/**
	 * Returns the training sites master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master, or <code>null</code> if a training sites master with the primary key could not be found
	 */
	@Override
	public TrainingSitesMaster fetchByPrimaryKey(long trainingSiteMasterId) {
		return fetchByPrimaryKey((Serializable)trainingSiteMasterId);
	}

	/**
	 * Returns all the training sites masters.
	 *
	 * @return the training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findAll(
		int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of training sites masters
	 */
	@Override
	public List<TrainingSitesMaster> findAll(
		int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
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

		List<TrainingSitesMaster> list = null;

		if (useFinderCache) {
			list = (List<TrainingSitesMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAININGSITESMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAININGSITESMASTER;

				sql = sql.concat(TrainingSitesMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TrainingSitesMaster>)QueryUtil.list(
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
	 * Removes all the training sites masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TrainingSitesMaster trainingSitesMaster : findAll()) {
			remove(trainingSitesMaster);
		}
	}

	/**
	 * Returns the number of training sites masters.
	 *
	 * @return the number of training sites masters
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
					_SQL_COUNT_TRAININGSITESMASTER);

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
		return "training_site_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAININGSITESMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TrainingSitesMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the training sites master persistence.
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

		_finderPathWithPaginationFindByTrainingSiteStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrainingSiteStatus",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"training_site_status"}, true);

		_finderPathWithoutPaginationFindByTrainingSiteStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTrainingSiteStatus", new String[] {Boolean.class.getName()},
			new String[] {"training_site_status"}, true);

		_finderPathCountByTrainingSiteStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTrainingSiteStatus", new String[] {Boolean.class.getName()},
			new String[] {"training_site_status"}, false);

		_finderPathWithPaginationFindByTrainingSiteNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrainingSiteNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"training_site_name"}, true);

		_finderPathWithPaginationCountByTrainingSiteNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByTrainingSiteNameByLike",
			new String[] {String.class.getName()},
			new String[] {"training_site_name"}, false);

		_finderPathWithPaginationFindByTrainingSiteCodeByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrainingSiteCodeByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"training_site_code"}, true);

		_finderPathWithPaginationCountByTrainingSiteCodeByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByTrainingSiteCodeByLike",
			new String[] {String.class.getName()},
			new String[] {"training_site_code"}, false);

		_setTrainingSitesMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTrainingSitesMasterUtilPersistence(null);

		entityCache.removeCache(TrainingSitesMasterImpl.class.getName());
	}

	private void _setTrainingSitesMasterUtilPersistence(
		TrainingSitesMasterPersistence trainingSitesMasterPersistence) {

		try {
			Field field = TrainingSitesMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, trainingSitesMasterPersistence);
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

	private static final String _SQL_SELECT_TRAININGSITESMASTER =
		"SELECT trainingSitesMaster FROM TrainingSitesMaster trainingSitesMaster";

	private static final String _SQL_SELECT_TRAININGSITESMASTER_WHERE =
		"SELECT trainingSitesMaster FROM TrainingSitesMaster trainingSitesMaster WHERE ";

	private static final String _SQL_COUNT_TRAININGSITESMASTER =
		"SELECT COUNT(trainingSitesMaster) FROM TrainingSitesMaster trainingSitesMaster";

	private static final String _SQL_COUNT_TRAININGSITESMASTER_WHERE =
		"SELECT COUNT(trainingSitesMaster) FROM TrainingSitesMaster trainingSitesMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "trainingSitesMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TrainingSitesMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TrainingSitesMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TrainingSitesMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "trainingSiteMasterId", "groupId", "companyId",
			"createDate", "modifiedDate", "trainingSiteName",
			"trainingSiteCode", "trainingSiteStatus", "trainingSiteAddress",
			"trainingSiteDescription"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
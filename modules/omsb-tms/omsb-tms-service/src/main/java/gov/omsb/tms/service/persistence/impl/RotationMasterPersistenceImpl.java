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

import gov.omsb.tms.exception.NoSuchRotationMasterException;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationMasterTable;
import gov.omsb.tms.model.impl.RotationMasterImpl;
import gov.omsb.tms.model.impl.RotationMasterModelImpl;
import gov.omsb.tms.service.persistence.RotationMasterPersistence;
import gov.omsb.tms.service.persistence.RotationMasterUtil;
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
 * The persistence implementation for the rotation master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RotationMasterPersistence.class)
public class RotationMasterPersistenceImpl
	extends BasePersistenceImpl<RotationMaster>
	implements RotationMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RotationMasterUtil</code> to access the rotation master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RotationMasterImpl.class.getName();

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
	 * Returns all the rotation masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
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

		List<RotationMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationMaster rotationMaster : list) {
					if (!uuid.equals(rotationMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

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
				sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<RotationMaster>)QueryUtil.list(
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
	 * Returns the first rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByUuid_First(
			String uuid, OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByUuid_First(
		String uuid, OrderByComparator<RotationMaster> orderByComparator) {

		List<RotationMaster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByUuid_Last(
			String uuid, OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByUuid_Last(
		String uuid, OrderByComparator<RotationMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RotationMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster[] findByUuid_PrevAndNext(
			long rotationMasterId, String uuid,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		uuid = Objects.toString(uuid, "");

		RotationMaster rotationMaster = findByPrimaryKey(rotationMasterId);

		Session session = null;

		try {
			session = openSession();

			RotationMaster[] array = new RotationMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, rotationMaster, uuid, orderByComparator, true);

			array[1] = rotationMaster;

			array[2] = getByUuid_PrevAndNext(
				session, rotationMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RotationMaster getByUuid_PrevAndNext(
		Session session, RotationMaster rotationMaster, String uuid,
		OrderByComparator<RotationMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

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
			sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
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
						rotationMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RotationMaster rotationMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rotationMaster);
		}
	}

	/**
	 * Returns the number of rotation masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROTATIONMASTER_WHERE);

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
		"rotationMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(rotationMaster.uuid IS NULL OR rotationMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByUUID_G(uuid, groupId);

		if (rotationMaster == null) {
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

			throw new NoSuchRotationMasterException(sb.toString());
		}

		return rotationMaster;
	}

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByUUID_G(
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

		if (result instanceof RotationMaster) {
			RotationMaster rotationMaster = (RotationMaster)result;

			if (!Objects.equals(uuid, rotationMaster.getUuid()) ||
				(groupId != rotationMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

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

				List<RotationMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					RotationMaster rotationMaster = list.get(0);

					result = rotationMaster;

					cacheResult(rotationMaster);
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
			return (RotationMaster)result;
		}
	}

	/**
	 * Removes the rotation master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation master that was removed
	 */
	@Override
	public RotationMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = findByUUID_G(uuid, groupId);

		return remove(rotationMaster);
	}

	/**
	 * Returns the number of rotation masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONMASTER_WHERE);

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
		"rotationMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(rotationMaster.uuid IS NULL OR rotationMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"rotationMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
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

		List<RotationMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationMaster rotationMaster : list) {
					if (!uuid.equals(rotationMaster.getUuid()) ||
						(companyId != rotationMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

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
				sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<RotationMaster>)QueryUtil.list(
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
	 * Returns the first rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RotationMaster> orderByComparator) {

		List<RotationMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RotationMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RotationMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster[] findByUuid_C_PrevAndNext(
			long rotationMasterId, String uuid, long companyId,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		uuid = Objects.toString(uuid, "");

		RotationMaster rotationMaster = findByPrimaryKey(rotationMasterId);

		Session session = null;

		try {
			session = openSession();

			RotationMaster[] array = new RotationMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, rotationMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = rotationMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, rotationMaster, uuid, companyId, orderByComparator,
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

	protected RotationMaster getByUuid_C_PrevAndNext(
		Session session, RotationMaster rotationMaster, String uuid,
		long companyId, OrderByComparator<RotationMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

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
			sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
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
						rotationMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RotationMaster rotationMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rotationMaster);
		}
	}

	/**
	 * Returns the number of rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONMASTER_WHERE);

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
		"rotationMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(rotationMaster.uuid IS NULL OR rotationMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"rotationMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByRotationStatus;
	private FinderPath _finderPathWithoutPaginationFindByRotationStatus;
	private FinderPath _finderPathCountByRotationStatus;

	/**
	 * Returns all the rotation masters where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @return the matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationStatus(Boolean rotationStatus) {
		return findByRotationStatus(
			rotationStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end) {

		return findByRotationStatus(rotationStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return findByRotationStatus(
			rotationStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRotationStatus;
				finderArgs = new Object[] {rotationStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRotationStatus;
			finderArgs = new Object[] {
				rotationStatus, start, end, orderByComparator
			};
		}

		List<RotationMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationMaster rotationMaster : list) {
					if (!Objects.equals(
							rotationStatus,
							rotationMaster.getRotationStatus())) {

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

			sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

			sb.append(_FINDER_COLUMN_ROTATIONSTATUS_ROTATIONSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationStatus.booleanValue());

				list = (List<RotationMaster>)QueryUtil.list(
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
	 * Returns the first rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByRotationStatus_First(
			Boolean rotationStatus,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByRotationStatus_First(
			rotationStatus, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationStatus=");
		sb.append(rotationStatus);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByRotationStatus_First(
		Boolean rotationStatus,
		OrderByComparator<RotationMaster> orderByComparator) {

		List<RotationMaster> list = findByRotationStatus(
			rotationStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByRotationStatus_Last(
			Boolean rotationStatus,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByRotationStatus_Last(
			rotationStatus, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationStatus=");
		sb.append(rotationStatus);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByRotationStatus_Last(
		Boolean rotationStatus,
		OrderByComparator<RotationMaster> orderByComparator) {

		int count = countByRotationStatus(rotationStatus);

		if (count == 0) {
			return null;
		}

		List<RotationMaster> list = findByRotationStatus(
			rotationStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster[] findByRotationStatus_PrevAndNext(
			long rotationMasterId, Boolean rotationStatus,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = findByPrimaryKey(rotationMasterId);

		Session session = null;

		try {
			session = openSession();

			RotationMaster[] array = new RotationMasterImpl[3];

			array[0] = getByRotationStatus_PrevAndNext(
				session, rotationMaster, rotationStatus, orderByComparator,
				true);

			array[1] = rotationMaster;

			array[2] = getByRotationStatus_PrevAndNext(
				session, rotationMaster, rotationStatus, orderByComparator,
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

	protected RotationMaster getByRotationStatus_PrevAndNext(
		Session session, RotationMaster rotationMaster, Boolean rotationStatus,
		OrderByComparator<RotationMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

		sb.append(_FINDER_COLUMN_ROTATIONSTATUS_ROTATIONSTATUS_2);

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
			sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(rotationStatus.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rotationMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation masters where rotationStatus = &#63; from the database.
	 *
	 * @param rotationStatus the rotation status
	 */
	@Override
	public void removeByRotationStatus(Boolean rotationStatus) {
		for (RotationMaster rotationMaster :
				findByRotationStatus(
					rotationStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rotationMaster);
		}
	}

	/**
	 * Returns the number of rotation masters where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @return the number of matching rotation masters
	 */
	@Override
	public int countByRotationStatus(Boolean rotationStatus) {
		FinderPath finderPath = _finderPathCountByRotationStatus;

		Object[] finderArgs = new Object[] {rotationStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROTATIONMASTER_WHERE);

			sb.append(_FINDER_COLUMN_ROTATIONSTATUS_ROTATIONSTATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationStatus.booleanValue());

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

	private static final String _FINDER_COLUMN_ROTATIONSTATUS_ROTATIONSTATUS_2 =
		"rotationMaster.rotationStatus = ?";

	private FinderPath _finderPathWithPaginationFindByRotationNameByLike;
	private FinderPath _finderPathWithPaginationCountByRotationNameByLike;

	/**
	 * Returns all the rotation masters where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @return the matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationNameByLike(String rotationName) {
		return findByRotationNameByLike(
			rotationName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end) {

		return findByRotationNameByLike(rotationName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return findByRotationNameByLike(
			rotationName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		rotationName = Objects.toString(rotationName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRotationNameByLike;
		finderArgs = new Object[] {rotationName, start, end, orderByComparator};

		List<RotationMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationMaster rotationMaster : list) {
					if (!StringUtil.wildcardMatches(
							rotationMaster.getRotationName(), rotationName, '_',
							'%', '\\', false)) {

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

			sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

			boolean bindRotationName = false;

			if (rotationName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROTATIONNAMEBYLIKE_ROTATIONNAME_3);
			}
			else {
				bindRotationName = true;

				sb.append(_FINDER_COLUMN_ROTATIONNAMEBYLIKE_ROTATIONNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRotationName) {
					queryPos.add(StringUtil.toLowerCase(rotationName));
				}

				list = (List<RotationMaster>)QueryUtil.list(
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
	 * Returns the first rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByRotationNameByLike_First(
			String rotationName,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByRotationNameByLike_First(
			rotationName, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationNameLIKE");
		sb.append(rotationName);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByRotationNameByLike_First(
		String rotationName,
		OrderByComparator<RotationMaster> orderByComparator) {

		List<RotationMaster> list = findByRotationNameByLike(
			rotationName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByRotationNameByLike_Last(
			String rotationName,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByRotationNameByLike_Last(
			rotationName, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationNameLIKE");
		sb.append(rotationName);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByRotationNameByLike_Last(
		String rotationName,
		OrderByComparator<RotationMaster> orderByComparator) {

		int count = countByRotationNameByLike(rotationName);

		if (count == 0) {
			return null;
		}

		List<RotationMaster> list = findByRotationNameByLike(
			rotationName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster[] findByRotationNameByLike_PrevAndNext(
			long rotationMasterId, String rotationName,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		rotationName = Objects.toString(rotationName, "");

		RotationMaster rotationMaster = findByPrimaryKey(rotationMasterId);

		Session session = null;

		try {
			session = openSession();

			RotationMaster[] array = new RotationMasterImpl[3];

			array[0] = getByRotationNameByLike_PrevAndNext(
				session, rotationMaster, rotationName, orderByComparator, true);

			array[1] = rotationMaster;

			array[2] = getByRotationNameByLike_PrevAndNext(
				session, rotationMaster, rotationName, orderByComparator,
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

	protected RotationMaster getByRotationNameByLike_PrevAndNext(
		Session session, RotationMaster rotationMaster, String rotationName,
		OrderByComparator<RotationMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

		boolean bindRotationName = false;

		if (rotationName.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROTATIONNAMEBYLIKE_ROTATIONNAME_3);
		}
		else {
			bindRotationName = true;

			sb.append(_FINDER_COLUMN_ROTATIONNAMEBYLIKE_ROTATIONNAME_2);
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
			sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRotationName) {
			queryPos.add(StringUtil.toLowerCase(rotationName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rotationMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation masters where rotationName LIKE &#63; from the database.
	 *
	 * @param rotationName the rotation name
	 */
	@Override
	public void removeByRotationNameByLike(String rotationName) {
		for (RotationMaster rotationMaster :
				findByRotationNameByLike(
					rotationName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rotationMaster);
		}
	}

	/**
	 * Returns the number of rotation masters where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @return the number of matching rotation masters
	 */
	@Override
	public int countByRotationNameByLike(String rotationName) {
		rotationName = Objects.toString(rotationName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByRotationNameByLike;

		Object[] finderArgs = new Object[] {rotationName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROTATIONMASTER_WHERE);

			boolean bindRotationName = false;

			if (rotationName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROTATIONNAMEBYLIKE_ROTATIONNAME_3);
			}
			else {
				bindRotationName = true;

				sb.append(_FINDER_COLUMN_ROTATIONNAMEBYLIKE_ROTATIONNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRotationName) {
					queryPos.add(StringUtil.toLowerCase(rotationName));
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
		_FINDER_COLUMN_ROTATIONNAMEBYLIKE_ROTATIONNAME_2 =
			"lower(rotationMaster.rotationName) LIKE ?";

	private static final String
		_FINDER_COLUMN_ROTATIONNAMEBYLIKE_ROTATIONNAME_3 =
			"(rotationMaster.rotationName IS NULL OR rotationMaster.rotationName LIKE '')";

	private FinderPath _finderPathWithPaginationFindByRotationCodeByLike;
	private FinderPath _finderPathWithPaginationCountByRotationCodeByLike;

	/**
	 * Returns all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @return the matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationCodeByLike(String rotationCode) {
		return findByRotationCodeByLike(
			rotationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end) {

		return findByRotationCodeByLike(rotationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return findByRotationCodeByLike(
			rotationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	@Override
	public List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		rotationCode = Objects.toString(rotationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRotationCodeByLike;
		finderArgs = new Object[] {rotationCode, start, end, orderByComparator};

		List<RotationMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationMaster rotationMaster : list) {
					if (!StringUtil.wildcardMatches(
							rotationMaster.getRotationCode(), rotationCode, '_',
							'%', '\\', false)) {

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

			sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

			boolean bindRotationCode = false;

			if (rotationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROTATIONCODEBYLIKE_ROTATIONCODE_3);
			}
			else {
				bindRotationCode = true;

				sb.append(_FINDER_COLUMN_ROTATIONCODEBYLIKE_ROTATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRotationCode) {
					queryPos.add(StringUtil.toLowerCase(rotationCode));
				}

				list = (List<RotationMaster>)QueryUtil.list(
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
	 * Returns the first rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByRotationCodeByLike_First(
			String rotationCode,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByRotationCodeByLike_First(
			rotationCode, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationCodeLIKE");
		sb.append(rotationCode);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByRotationCodeByLike_First(
		String rotationCode,
		OrderByComparator<RotationMaster> orderByComparator) {

		List<RotationMaster> list = findByRotationCodeByLike(
			rotationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster findByRotationCodeByLike_Last(
			String rotationCode,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByRotationCodeByLike_Last(
			rotationCode, orderByComparator);

		if (rotationMaster != null) {
			return rotationMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationCodeLIKE");
		sb.append(rotationCode);

		sb.append("}");

		throw new NoSuchRotationMasterException(sb.toString());
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public RotationMaster fetchByRotationCodeByLike_Last(
		String rotationCode,
		OrderByComparator<RotationMaster> orderByComparator) {

		int count = countByRotationCodeByLike(rotationCode);

		if (count == 0) {
			return null;
		}

		List<RotationMaster> list = findByRotationCodeByLike(
			rotationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster[] findByRotationCodeByLike_PrevAndNext(
			long rotationMasterId, String rotationCode,
			OrderByComparator<RotationMaster> orderByComparator)
		throws NoSuchRotationMasterException {

		rotationCode = Objects.toString(rotationCode, "");

		RotationMaster rotationMaster = findByPrimaryKey(rotationMasterId);

		Session session = null;

		try {
			session = openSession();

			RotationMaster[] array = new RotationMasterImpl[3];

			array[0] = getByRotationCodeByLike_PrevAndNext(
				session, rotationMaster, rotationCode, orderByComparator, true);

			array[1] = rotationMaster;

			array[2] = getByRotationCodeByLike_PrevAndNext(
				session, rotationMaster, rotationCode, orderByComparator,
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

	protected RotationMaster getByRotationCodeByLike_PrevAndNext(
		Session session, RotationMaster rotationMaster, String rotationCode,
		OrderByComparator<RotationMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROTATIONMASTER_WHERE);

		boolean bindRotationCode = false;

		if (rotationCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROTATIONCODEBYLIKE_ROTATIONCODE_3);
		}
		else {
			bindRotationCode = true;

			sb.append(_FINDER_COLUMN_ROTATIONCODEBYLIKE_ROTATIONCODE_2);
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
			sb.append(RotationMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRotationCode) {
			queryPos.add(StringUtil.toLowerCase(rotationCode));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rotationMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation masters where rotationCode LIKE &#63; from the database.
	 *
	 * @param rotationCode the rotation code
	 */
	@Override
	public void removeByRotationCodeByLike(String rotationCode) {
		for (RotationMaster rotationMaster :
				findByRotationCodeByLike(
					rotationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rotationMaster);
		}
	}

	/**
	 * Returns the number of rotation masters where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @return the number of matching rotation masters
	 */
	@Override
	public int countByRotationCodeByLike(String rotationCode) {
		rotationCode = Objects.toString(rotationCode, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByRotationCodeByLike;

		Object[] finderArgs = new Object[] {rotationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROTATIONMASTER_WHERE);

			boolean bindRotationCode = false;

			if (rotationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROTATIONCODEBYLIKE_ROTATIONCODE_3);
			}
			else {
				bindRotationCode = true;

				sb.append(_FINDER_COLUMN_ROTATIONCODEBYLIKE_ROTATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRotationCode) {
					queryPos.add(StringUtil.toLowerCase(rotationCode));
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
		_FINDER_COLUMN_ROTATIONCODEBYLIKE_ROTATIONCODE_2 =
			"lower(rotationMaster.rotationCode) LIKE ?";

	private static final String
		_FINDER_COLUMN_ROTATIONCODEBYLIKE_ROTATIONCODE_3 =
			"(rotationMaster.rotationCode IS NULL OR rotationMaster.rotationCode LIKE '')";

	public RotationMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("rotationMasterId", "rotation_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("rotationCode", "rotation_code");
		dbColumnNames.put("rotationShortName", "rotation_short_name");
		dbColumnNames.put("rotationName", "rotation_name");
		dbColumnNames.put("rotationStatus", "rotation_status");
		dbColumnNames.put("rotationObjectives", "rotation_objecctives");

		setDBColumnNames(dbColumnNames);

		setModelClass(RotationMaster.class);

		setModelImplClass(RotationMasterImpl.class);
		setModelPKClass(long.class);

		setTable(RotationMasterTable.INSTANCE);
	}

	/**
	 * Caches the rotation master in the entity cache if it is enabled.
	 *
	 * @param rotationMaster the rotation master
	 */
	@Override
	public void cacheResult(RotationMaster rotationMaster) {
		entityCache.putResult(
			RotationMasterImpl.class, rotationMaster.getPrimaryKey(),
			rotationMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				rotationMaster.getUuid(), rotationMaster.getGroupId()
			},
			rotationMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rotation masters in the entity cache if it is enabled.
	 *
	 * @param rotationMasters the rotation masters
	 */
	@Override
	public void cacheResult(List<RotationMaster> rotationMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rotationMasters.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RotationMaster rotationMaster : rotationMasters) {
			if (entityCache.getResult(
					RotationMasterImpl.class, rotationMaster.getPrimaryKey()) ==
						null) {

				cacheResult(rotationMaster);
			}
		}
	}

	/**
	 * Clears the cache for all rotation masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RotationMasterImpl.class);

		finderCache.clearCache(RotationMasterImpl.class);
	}

	/**
	 * Clears the cache for the rotation master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RotationMaster rotationMaster) {
		entityCache.removeResult(RotationMasterImpl.class, rotationMaster);
	}

	@Override
	public void clearCache(List<RotationMaster> rotationMasters) {
		for (RotationMaster rotationMaster : rotationMasters) {
			entityCache.removeResult(RotationMasterImpl.class, rotationMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RotationMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RotationMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RotationMasterModelImpl rotationMasterModelImpl) {

		Object[] args = new Object[] {
			rotationMasterModelImpl.getUuid(),
			rotationMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, rotationMasterModelImpl);
	}

	/**
	 * Creates a new rotation master with the primary key. Does not add the rotation master to the database.
	 *
	 * @param rotationMasterId the primary key for the new rotation master
	 * @return the new rotation master
	 */
	@Override
	public RotationMaster create(long rotationMasterId) {
		RotationMaster rotationMaster = new RotationMasterImpl();

		rotationMaster.setNew(true);
		rotationMaster.setPrimaryKey(rotationMasterId);

		String uuid = _portalUUID.generate();

		rotationMaster.setUuid(uuid);

		rotationMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return rotationMaster;
	}

	/**
	 * Removes the rotation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master that was removed
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster remove(long rotationMasterId)
		throws NoSuchRotationMasterException {

		return remove((Serializable)rotationMasterId);
	}

	/**
	 * Removes the rotation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rotation master
	 * @return the rotation master that was removed
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster remove(Serializable primaryKey)
		throws NoSuchRotationMasterException {

		Session session = null;

		try {
			session = openSession();

			RotationMaster rotationMaster = (RotationMaster)session.get(
				RotationMasterImpl.class, primaryKey);

			if (rotationMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRotationMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rotationMaster);
		}
		catch (NoSuchRotationMasterException noSuchEntityException) {
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
	protected RotationMaster removeImpl(RotationMaster rotationMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rotationMaster)) {
				rotationMaster = (RotationMaster)session.get(
					RotationMasterImpl.class,
					rotationMaster.getPrimaryKeyObj());
			}

			if (rotationMaster != null) {
				session.delete(rotationMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rotationMaster != null) {
			clearCache(rotationMaster);
		}

		return rotationMaster;
	}

	@Override
	public RotationMaster updateImpl(RotationMaster rotationMaster) {
		boolean isNew = rotationMaster.isNew();

		if (!(rotationMaster instanceof RotationMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rotationMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rotationMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rotationMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RotationMaster implementation " +
					rotationMaster.getClass());
		}

		RotationMasterModelImpl rotationMasterModelImpl =
			(RotationMasterModelImpl)rotationMaster;

		if (Validator.isNull(rotationMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			rotationMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (rotationMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				rotationMaster.setCreateDate(date);
			}
			else {
				rotationMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!rotationMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				rotationMaster.setModifiedDate(date);
			}
			else {
				rotationMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rotationMaster);
			}
			else {
				rotationMaster = (RotationMaster)session.merge(rotationMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RotationMasterImpl.class, rotationMasterModelImpl, false, true);

		cacheUniqueFindersCache(rotationMasterModelImpl);

		if (isNew) {
			rotationMaster.setNew(false);
		}

		rotationMaster.resetOriginalValues();

		return rotationMaster;
	}

	/**
	 * Returns the rotation master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rotation master
	 * @return the rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRotationMasterException {

		RotationMaster rotationMaster = fetchByPrimaryKey(primaryKey);

		if (rotationMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRotationMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rotationMaster;
	}

	/**
	 * Returns the rotation master with the primary key or throws a <code>NoSuchRotationMasterException</code> if it could not be found.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster findByPrimaryKey(long rotationMasterId)
		throws NoSuchRotationMasterException {

		return findByPrimaryKey((Serializable)rotationMasterId);
	}

	/**
	 * Returns the rotation master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master, or <code>null</code> if a rotation master with the primary key could not be found
	 */
	@Override
	public RotationMaster fetchByPrimaryKey(long rotationMasterId) {
		return fetchByPrimaryKey((Serializable)rotationMasterId);
	}

	/**
	 * Returns all the rotation masters.
	 *
	 * @return the rotation masters
	 */
	@Override
	public List<RotationMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of rotation masters
	 */
	@Override
	public List<RotationMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation masters
	 */
	@Override
	public List<RotationMaster> findAll(
		int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation masters
	 */
	@Override
	public List<RotationMaster> findAll(
		int start, int end, OrderByComparator<RotationMaster> orderByComparator,
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

		List<RotationMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROTATIONMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROTATIONMASTER;

				sql = sql.concat(RotationMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RotationMaster>)QueryUtil.list(
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
	 * Removes all the rotation masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RotationMaster rotationMaster : findAll()) {
			remove(rotationMaster);
		}
	}

	/**
	 * Returns the number of rotation masters.
	 *
	 * @return the number of rotation masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ROTATIONMASTER);

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
		return "rotation_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROTATIONMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RotationMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rotation master persistence.
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

		_finderPathWithPaginationFindByRotationStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRotationStatus",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"rotation_status"}, true);

		_finderPathWithoutPaginationFindByRotationStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRotationStatus",
			new String[] {Boolean.class.getName()},
			new String[] {"rotation_status"}, true);

		_finderPathCountByRotationStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRotationStatus",
			new String[] {Boolean.class.getName()},
			new String[] {"rotation_status"}, false);

		_finderPathWithPaginationFindByRotationNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRotationNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"rotation_name"}, true);

		_finderPathWithPaginationCountByRotationNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRotationNameByLike",
			new String[] {String.class.getName()},
			new String[] {"rotation_name"}, false);

		_finderPathWithPaginationFindByRotationCodeByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRotationCodeByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"rotation_code"}, true);

		_finderPathWithPaginationCountByRotationCodeByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRotationCodeByLike",
			new String[] {String.class.getName()},
			new String[] {"rotation_code"}, false);

		_setRotationMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRotationMasterUtilPersistence(null);

		entityCache.removeCache(RotationMasterImpl.class.getName());
	}

	private void _setRotationMasterUtilPersistence(
		RotationMasterPersistence rotationMasterPersistence) {

		try {
			Field field = RotationMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, rotationMasterPersistence);
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

	private static final String _SQL_SELECT_ROTATIONMASTER =
		"SELECT rotationMaster FROM RotationMaster rotationMaster";

	private static final String _SQL_SELECT_ROTATIONMASTER_WHERE =
		"SELECT rotationMaster FROM RotationMaster rotationMaster WHERE ";

	private static final String _SQL_COUNT_ROTATIONMASTER =
		"SELECT COUNT(rotationMaster) FROM RotationMaster rotationMaster";

	private static final String _SQL_COUNT_ROTATIONMASTER_WHERE =
		"SELECT COUNT(rotationMaster) FROM RotationMaster rotationMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rotationMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RotationMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RotationMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RotationMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "rotationMasterId", "groupId", "companyId", "createDate",
			"modifiedDate", "rotationCode", "rotationShortName", "rotationName",
			"rotationStatus", "rotationObjectives"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchRotationTypeMasterException;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.model.RotationTypeMasterTable;
import gov.omsb.tms.model.impl.RotationTypeMasterImpl;
import gov.omsb.tms.model.impl.RotationTypeMasterModelImpl;
import gov.omsb.tms.service.persistence.RotationTypeMasterPersistence;
import gov.omsb.tms.service.persistence.RotationTypeMasterUtil;
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
 * The persistence implementation for the rotation type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RotationTypeMasterPersistence.class)
public class RotationTypeMasterPersistenceImpl
	extends BasePersistenceImpl<RotationTypeMaster>
	implements RotationTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RotationTypeMasterUtil</code> to access the rotation type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RotationTypeMasterImpl.class.getName();

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
	 * Returns all the rotation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator,
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

		List<RotationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationTypeMaster rotationTypeMaster : list) {
					if (!uuid.equals(rotationTypeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_ROTATIONTYPEMASTER_WHERE);

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
				sb.append(RotationTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<RotationTypeMaster>)QueryUtil.list(
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
	 * Returns the first rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster findByUuid_First(
			String uuid,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (rotationTypeMaster != null) {
			return rotationTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRotationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<RotationTypeMaster> orderByComparator) {

		List<RotationTypeMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster findByUuid_Last(
			String uuid,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (rotationTypeMaster != null) {
			return rotationTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRotationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<RotationTypeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RotationTypeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	@Override
	public RotationTypeMaster[] findByUuid_PrevAndNext(
			long rotationTypeMasterId, String uuid,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		uuid = Objects.toString(uuid, "");

		RotationTypeMaster rotationTypeMaster = findByPrimaryKey(
			rotationTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			RotationTypeMaster[] array = new RotationTypeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, rotationTypeMaster, uuid, orderByComparator, true);

			array[1] = rotationTypeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, rotationTypeMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RotationTypeMaster getByUuid_PrevAndNext(
		Session session, RotationTypeMaster rotationTypeMaster, String uuid,
		OrderByComparator<RotationTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_ROTATIONTYPEMASTER_WHERE);

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
			sb.append(RotationTypeMasterModelImpl.ORDER_BY_JPQL);
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
						rotationTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RotationTypeMaster rotationTypeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rotationTypeMaster);
		}
	}

	/**
	 * Returns the number of rotation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation type masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROTATIONTYPEMASTER_WHERE);

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
		"rotationTypeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(rotationTypeMaster.uuid IS NULL OR rotationTypeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster = fetchByUUID_G(uuid, groupId);

		if (rotationTypeMaster == null) {
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

			throw new NoSuchRotationTypeMasterException(sb.toString());
		}

		return rotationTypeMaster;
	}

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster fetchByUUID_G(
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

		if (result instanceof RotationTypeMaster) {
			RotationTypeMaster rotationTypeMaster = (RotationTypeMaster)result;

			if (!Objects.equals(uuid, rotationTypeMaster.getUuid()) ||
				(groupId != rotationTypeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROTATIONTYPEMASTER_WHERE);

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

				List<RotationTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					RotationTypeMaster rotationTypeMaster = list.get(0);

					result = rotationTypeMaster;

					cacheResult(rotationTypeMaster);
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
			return (RotationTypeMaster)result;
		}
	}

	/**
	 * Removes the rotation type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation type master that was removed
	 */
	@Override
	public RotationTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster = findByUUID_G(uuid, groupId);

		return remove(rotationTypeMaster);
	}

	/**
	 * Returns the number of rotation type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation type masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONTYPEMASTER_WHERE);

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
		"rotationTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(rotationTypeMaster.uuid IS NULL OR rotationTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"rotationTypeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator,
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

		List<RotationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationTypeMaster rotationTypeMaster : list) {
					if (!uuid.equals(rotationTypeMaster.getUuid()) ||
						(companyId != rotationTypeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ROTATIONTYPEMASTER_WHERE);

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
				sb.append(RotationTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<RotationTypeMaster>)QueryUtil.list(
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
	 * Returns the first rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (rotationTypeMaster != null) {
			return rotationTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRotationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		List<RotationTypeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (rotationTypeMaster != null) {
			return rotationTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRotationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RotationTypeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	@Override
	public RotationTypeMaster[] findByUuid_C_PrevAndNext(
			long rotationTypeMasterId, String uuid, long companyId,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		uuid = Objects.toString(uuid, "");

		RotationTypeMaster rotationTypeMaster = findByPrimaryKey(
			rotationTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			RotationTypeMaster[] array = new RotationTypeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, rotationTypeMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = rotationTypeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, rotationTypeMaster, uuid, companyId, orderByComparator,
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

	protected RotationTypeMaster getByUuid_C_PrevAndNext(
		Session session, RotationTypeMaster rotationTypeMaster, String uuid,
		long companyId, OrderByComparator<RotationTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_ROTATIONTYPEMASTER_WHERE);

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
			sb.append(RotationTypeMasterModelImpl.ORDER_BY_JPQL);
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
						rotationTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RotationTypeMaster rotationTypeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rotationTypeMaster);
		}
	}

	/**
	 * Returns the number of rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation type masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONTYPEMASTER_WHERE);

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
		"rotationTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(rotationTypeMaster.uuid IS NULL OR rotationTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"rotationTypeMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByRotationTypeNameByLike;
	private FinderPath _finderPathWithPaginationCountByRotationTypeNameByLike;

	/**
	 * Returns all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @return the matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName) {

		return findByRotationTypeNameByLike(
			rotationTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end) {

		return findByRotationTypeNameByLike(rotationTypeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return findByRotationTypeNameByLike(
			rotationTypeName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		rotationTypeName = Objects.toString(rotationTypeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRotationTypeNameByLike;
		finderArgs = new Object[] {
			rotationTypeName, start, end, orderByComparator
		};

		List<RotationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationTypeMaster rotationTypeMaster : list) {
					if (!StringUtil.wildcardMatches(
							rotationTypeMaster.getRotationTypeName(),
							rotationTypeName, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_ROTATIONTYPEMASTER_WHERE);

			boolean bindRotationTypeName = false;

			if (rotationTypeName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROTATIONTYPENAMEBYLIKE_ROTATIONTYPENAME_3);
			}
			else {
				bindRotationTypeName = true;

				sb.append(
					_FINDER_COLUMN_ROTATIONTYPENAMEBYLIKE_ROTATIONTYPENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RotationTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRotationTypeName) {
					queryPos.add(StringUtil.toLowerCase(rotationTypeName));
				}

				list = (List<RotationTypeMaster>)QueryUtil.list(
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
	 * Returns the first rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster findByRotationTypeNameByLike_First(
			String rotationTypeName,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster =
			fetchByRotationTypeNameByLike_First(
				rotationTypeName, orderByComparator);

		if (rotationTypeMaster != null) {
			return rotationTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationTypeNameLIKE");
		sb.append(rotationTypeName);

		sb.append("}");

		throw new NoSuchRotationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster fetchByRotationTypeNameByLike_First(
		String rotationTypeName,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		List<RotationTypeMaster> list = findByRotationTypeNameByLike(
			rotationTypeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster findByRotationTypeNameByLike_Last(
			String rotationTypeName,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster =
			fetchByRotationTypeNameByLike_Last(
				rotationTypeName, orderByComparator);

		if (rotationTypeMaster != null) {
			return rotationTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationTypeNameLIKE");
		sb.append(rotationTypeName);

		sb.append("}");

		throw new NoSuchRotationTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public RotationTypeMaster fetchByRotationTypeNameByLike_Last(
		String rotationTypeName,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		int count = countByRotationTypeNameByLike(rotationTypeName);

		if (count == 0) {
			return null;
		}

		List<RotationTypeMaster> list = findByRotationTypeNameByLike(
			rotationTypeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	@Override
	public RotationTypeMaster[] findByRotationTypeNameByLike_PrevAndNext(
			long rotationTypeMasterId, String rotationTypeName,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws NoSuchRotationTypeMasterException {

		rotationTypeName = Objects.toString(rotationTypeName, "");

		RotationTypeMaster rotationTypeMaster = findByPrimaryKey(
			rotationTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			RotationTypeMaster[] array = new RotationTypeMasterImpl[3];

			array[0] = getByRotationTypeNameByLike_PrevAndNext(
				session, rotationTypeMaster, rotationTypeName,
				orderByComparator, true);

			array[1] = rotationTypeMaster;

			array[2] = getByRotationTypeNameByLike_PrevAndNext(
				session, rotationTypeMaster, rotationTypeName,
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

	protected RotationTypeMaster getByRotationTypeNameByLike_PrevAndNext(
		Session session, RotationTypeMaster rotationTypeMaster,
		String rotationTypeName,
		OrderByComparator<RotationTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_ROTATIONTYPEMASTER_WHERE);

		boolean bindRotationTypeName = false;

		if (rotationTypeName.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROTATIONTYPENAMEBYLIKE_ROTATIONTYPENAME_3);
		}
		else {
			bindRotationTypeName = true;

			sb.append(_FINDER_COLUMN_ROTATIONTYPENAMEBYLIKE_ROTATIONTYPENAME_2);
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
			sb.append(RotationTypeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRotationTypeName) {
			queryPos.add(StringUtil.toLowerCase(rotationTypeName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rotationTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation type masters where rotationTypeName LIKE &#63; from the database.
	 *
	 * @param rotationTypeName the rotation type name
	 */
	@Override
	public void removeByRotationTypeNameByLike(String rotationTypeName) {
		for (RotationTypeMaster rotationTypeMaster :
				findByRotationTypeNameByLike(
					rotationTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rotationTypeMaster);
		}
	}

	/**
	 * Returns the number of rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @return the number of matching rotation type masters
	 */
	@Override
	public int countByRotationTypeNameByLike(String rotationTypeName) {
		rotationTypeName = Objects.toString(rotationTypeName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByRotationTypeNameByLike;

		Object[] finderArgs = new Object[] {rotationTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROTATIONTYPEMASTER_WHERE);

			boolean bindRotationTypeName = false;

			if (rotationTypeName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROTATIONTYPENAMEBYLIKE_ROTATIONTYPENAME_3);
			}
			else {
				bindRotationTypeName = true;

				sb.append(
					_FINDER_COLUMN_ROTATIONTYPENAMEBYLIKE_ROTATIONTYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRotationTypeName) {
					queryPos.add(StringUtil.toLowerCase(rotationTypeName));
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
		_FINDER_COLUMN_ROTATIONTYPENAMEBYLIKE_ROTATIONTYPENAME_2 =
			"lower(rotationTypeMaster.rotationTypeName) LIKE ?";

	private static final String
		_FINDER_COLUMN_ROTATIONTYPENAMEBYLIKE_ROTATIONTYPENAME_3 =
			"(rotationTypeMaster.rotationTypeName IS NULL OR rotationTypeMaster.rotationTypeName LIKE '')";

	public RotationTypeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("rotationTypeMasterId", "rotation_type_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("rotationTypeName", "rotation_type_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(RotationTypeMaster.class);

		setModelImplClass(RotationTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(RotationTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the rotation type master in the entity cache if it is enabled.
	 *
	 * @param rotationTypeMaster the rotation type master
	 */
	@Override
	public void cacheResult(RotationTypeMaster rotationTypeMaster) {
		entityCache.putResult(
			RotationTypeMasterImpl.class, rotationTypeMaster.getPrimaryKey(),
			rotationTypeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				rotationTypeMaster.getUuid(), rotationTypeMaster.getGroupId()
			},
			rotationTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rotation type masters in the entity cache if it is enabled.
	 *
	 * @param rotationTypeMasters the rotation type masters
	 */
	@Override
	public void cacheResult(List<RotationTypeMaster> rotationTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rotationTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RotationTypeMaster rotationTypeMaster : rotationTypeMasters) {
			if (entityCache.getResult(
					RotationTypeMasterImpl.class,
					rotationTypeMaster.getPrimaryKey()) == null) {

				cacheResult(rotationTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all rotation type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RotationTypeMasterImpl.class);

		finderCache.clearCache(RotationTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the rotation type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RotationTypeMaster rotationTypeMaster) {
		entityCache.removeResult(
			RotationTypeMasterImpl.class, rotationTypeMaster);
	}

	@Override
	public void clearCache(List<RotationTypeMaster> rotationTypeMasters) {
		for (RotationTypeMaster rotationTypeMaster : rotationTypeMasters) {
			entityCache.removeResult(
				RotationTypeMasterImpl.class, rotationTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RotationTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RotationTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RotationTypeMasterModelImpl rotationTypeMasterModelImpl) {

		Object[] args = new Object[] {
			rotationTypeMasterModelImpl.getUuid(),
			rotationTypeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, rotationTypeMasterModelImpl);
	}

	/**
	 * Creates a new rotation type master with the primary key. Does not add the rotation type master to the database.
	 *
	 * @param rotationTypeMasterId the primary key for the new rotation type master
	 * @return the new rotation type master
	 */
	@Override
	public RotationTypeMaster create(long rotationTypeMasterId) {
		RotationTypeMaster rotationTypeMaster = new RotationTypeMasterImpl();

		rotationTypeMaster.setNew(true);
		rotationTypeMaster.setPrimaryKey(rotationTypeMasterId);

		String uuid = _portalUUID.generate();

		rotationTypeMaster.setUuid(uuid);

		rotationTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return rotationTypeMaster;
	}

	/**
	 * Removes the rotation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master that was removed
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	@Override
	public RotationTypeMaster remove(long rotationTypeMasterId)
		throws NoSuchRotationTypeMasterException {

		return remove((Serializable)rotationTypeMasterId);
	}

	/**
	 * Removes the rotation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rotation type master
	 * @return the rotation type master that was removed
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	@Override
	public RotationTypeMaster remove(Serializable primaryKey)
		throws NoSuchRotationTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			RotationTypeMaster rotationTypeMaster =
				(RotationTypeMaster)session.get(
					RotationTypeMasterImpl.class, primaryKey);

			if (rotationTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRotationTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rotationTypeMaster);
		}
		catch (NoSuchRotationTypeMasterException noSuchEntityException) {
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
	protected RotationTypeMaster removeImpl(
		RotationTypeMaster rotationTypeMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rotationTypeMaster)) {
				rotationTypeMaster = (RotationTypeMaster)session.get(
					RotationTypeMasterImpl.class,
					rotationTypeMaster.getPrimaryKeyObj());
			}

			if (rotationTypeMaster != null) {
				session.delete(rotationTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rotationTypeMaster != null) {
			clearCache(rotationTypeMaster);
		}

		return rotationTypeMaster;
	}

	@Override
	public RotationTypeMaster updateImpl(
		RotationTypeMaster rotationTypeMaster) {

		boolean isNew = rotationTypeMaster.isNew();

		if (!(rotationTypeMaster instanceof RotationTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rotationTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rotationTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rotationTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RotationTypeMaster implementation " +
					rotationTypeMaster.getClass());
		}

		RotationTypeMasterModelImpl rotationTypeMasterModelImpl =
			(RotationTypeMasterModelImpl)rotationTypeMaster;

		if (Validator.isNull(rotationTypeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			rotationTypeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (rotationTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				rotationTypeMaster.setCreateDate(date);
			}
			else {
				rotationTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!rotationTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				rotationTypeMaster.setModifiedDate(date);
			}
			else {
				rotationTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rotationTypeMaster);
			}
			else {
				rotationTypeMaster = (RotationTypeMaster)session.merge(
					rotationTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RotationTypeMasterImpl.class, rotationTypeMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(rotationTypeMasterModelImpl);

		if (isNew) {
			rotationTypeMaster.setNew(false);
		}

		rotationTypeMaster.resetOriginalValues();

		return rotationTypeMaster;
	}

	/**
	 * Returns the rotation type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rotation type master
	 * @return the rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	@Override
	public RotationTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRotationTypeMasterException {

		RotationTypeMaster rotationTypeMaster = fetchByPrimaryKey(primaryKey);

		if (rotationTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRotationTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rotationTypeMaster;
	}

	/**
	 * Returns the rotation type master with the primary key or throws a <code>NoSuchRotationTypeMasterException</code> if it could not be found.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	@Override
	public RotationTypeMaster findByPrimaryKey(long rotationTypeMasterId)
		throws NoSuchRotationTypeMasterException {

		return findByPrimaryKey((Serializable)rotationTypeMasterId);
	}

	/**
	 * Returns the rotation type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master, or <code>null</code> if a rotation type master with the primary key could not be found
	 */
	@Override
	public RotationTypeMaster fetchByPrimaryKey(long rotationTypeMasterId) {
		return fetchByPrimaryKey((Serializable)rotationTypeMasterId);
	}

	/**
	 * Returns all the rotation type masters.
	 *
	 * @return the rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findAll(
		int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation type masters
	 */
	@Override
	public List<RotationTypeMaster> findAll(
		int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator,
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

		List<RotationTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<RotationTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROTATIONTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROTATIONTYPEMASTER;

				sql = sql.concat(RotationTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RotationTypeMaster>)QueryUtil.list(
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
	 * Removes all the rotation type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RotationTypeMaster rotationTypeMaster : findAll()) {
			remove(rotationTypeMaster);
		}
	}

	/**
	 * Returns the number of rotation type masters.
	 *
	 * @return the number of rotation type masters
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
					_SQL_COUNT_ROTATIONTYPEMASTER);

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
		return "rotation_type_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROTATIONTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RotationTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rotation type master persistence.
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

		_finderPathWithPaginationFindByRotationTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRotationTypeNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"rotation_type_name"}, true);

		_finderPathWithPaginationCountByRotationTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByRotationTypeNameByLike",
			new String[] {String.class.getName()},
			new String[] {"rotation_type_name"}, false);

		_setRotationTypeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRotationTypeMasterUtilPersistence(null);

		entityCache.removeCache(RotationTypeMasterImpl.class.getName());
	}

	private void _setRotationTypeMasterUtilPersistence(
		RotationTypeMasterPersistence rotationTypeMasterPersistence) {

		try {
			Field field = RotationTypeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, rotationTypeMasterPersistence);
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

	private static final String _SQL_SELECT_ROTATIONTYPEMASTER =
		"SELECT rotationTypeMaster FROM RotationTypeMaster rotationTypeMaster";

	private static final String _SQL_SELECT_ROTATIONTYPEMASTER_WHERE =
		"SELECT rotationTypeMaster FROM RotationTypeMaster rotationTypeMaster WHERE ";

	private static final String _SQL_COUNT_ROTATIONTYPEMASTER =
		"SELECT COUNT(rotationTypeMaster) FROM RotationTypeMaster rotationTypeMaster";

	private static final String _SQL_COUNT_ROTATIONTYPEMASTER_WHERE =
		"SELECT COUNT(rotationTypeMaster) FROM RotationTypeMaster rotationTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rotationTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RotationTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RotationTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RotationTypeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "rotationTypeMasterId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy",
			"rotationTypeName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
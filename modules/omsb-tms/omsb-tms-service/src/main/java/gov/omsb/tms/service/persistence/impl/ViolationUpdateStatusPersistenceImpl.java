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

import gov.omsb.tms.exception.NoSuchViolationUpdateStatusException;
import gov.omsb.tms.model.ViolationUpdateStatus;
import gov.omsb.tms.model.ViolationUpdateStatusTable;
import gov.omsb.tms.model.impl.ViolationUpdateStatusImpl;
import gov.omsb.tms.model.impl.ViolationUpdateStatusModelImpl;
import gov.omsb.tms.service.persistence.ViolationUpdateStatusPersistence;
import gov.omsb.tms.service.persistence.ViolationUpdateStatusUtil;
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
 * The persistence implementation for the violation update status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ViolationUpdateStatusPersistence.class)
public class ViolationUpdateStatusPersistenceImpl
	extends BasePersistenceImpl<ViolationUpdateStatus>
	implements ViolationUpdateStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ViolationUpdateStatusUtil</code> to access the violation update status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ViolationUpdateStatusImpl.class.getName();

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
	 * Returns all the violation update statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of matching violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator,
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

		List<ViolationUpdateStatus> list = null;

		if (useFinderCache) {
			list = (List<ViolationUpdateStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ViolationUpdateStatus violationUpdateStatus : list) {
					if (!uuid.equals(violationUpdateStatus.getUuid())) {
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

			sb.append(_SQL_SELECT_VIOLATIONUPDATESTATUS_WHERE);

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
				sb.append(ViolationUpdateStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<ViolationUpdateStatus>)QueryUtil.list(
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
	 * Returns the first violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus findByUuid_First(
			String uuid,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus = fetchByUuid_First(
			uuid, orderByComparator);

		if (violationUpdateStatus != null) {
			return violationUpdateStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchViolationUpdateStatusException(sb.toString());
	}

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByUuid_First(
		String uuid,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		List<ViolationUpdateStatus> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus findByUuid_Last(
			String uuid,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus = fetchByUuid_Last(
			uuid, orderByComparator);

		if (violationUpdateStatus != null) {
			return violationUpdateStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchViolationUpdateStatusException(sb.toString());
	}

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByUuid_Last(
		String uuid,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ViolationUpdateStatus> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the violation update statuses before and after the current violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param violationUpdateStatusId the primary key of the current violation update status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	@Override
	public ViolationUpdateStatus[] findByUuid_PrevAndNext(
			long violationUpdateStatusId, String uuid,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException {

		uuid = Objects.toString(uuid, "");

		ViolationUpdateStatus violationUpdateStatus = findByPrimaryKey(
			violationUpdateStatusId);

		Session session = null;

		try {
			session = openSession();

			ViolationUpdateStatus[] array = new ViolationUpdateStatusImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, violationUpdateStatus, uuid, orderByComparator, true);

			array[1] = violationUpdateStatus;

			array[2] = getByUuid_PrevAndNext(
				session, violationUpdateStatus, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ViolationUpdateStatus getByUuid_PrevAndNext(
		Session session, ViolationUpdateStatus violationUpdateStatus,
		String uuid, OrderByComparator<ViolationUpdateStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_VIOLATIONUPDATESTATUS_WHERE);

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
			sb.append(ViolationUpdateStatusModelImpl.ORDER_BY_JPQL);
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
						violationUpdateStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ViolationUpdateStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the violation update statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ViolationUpdateStatus violationUpdateStatus :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(violationUpdateStatus);
		}
	}

	/**
	 * Returns the number of violation update statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching violation update statuses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIOLATIONUPDATESTATUS_WHERE);

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
		"violationUpdateStatus.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(violationUpdateStatus.uuid IS NULL OR violationUpdateStatus.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus findByUUID_G(String uuid, long groupId)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus = fetchByUUID_G(
			uuid, groupId);

		if (violationUpdateStatus == null) {
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

			throw new NoSuchViolationUpdateStatusException(sb.toString());
		}

		return violationUpdateStatus;
	}

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByUUID_G(
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

		if (result instanceof ViolationUpdateStatus) {
			ViolationUpdateStatus violationUpdateStatus =
				(ViolationUpdateStatus)result;

			if (!Objects.equals(uuid, violationUpdateStatus.getUuid()) ||
				(groupId != violationUpdateStatus.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VIOLATIONUPDATESTATUS_WHERE);

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

				List<ViolationUpdateStatus> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ViolationUpdateStatus violationUpdateStatus = list.get(0);

					result = violationUpdateStatus;

					cacheResult(violationUpdateStatus);
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
			return (ViolationUpdateStatus)result;
		}
	}

	/**
	 * Removes the violation update status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the violation update status that was removed
	 */
	@Override
	public ViolationUpdateStatus removeByUUID_G(String uuid, long groupId)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus = findByUUID_G(
			uuid, groupId);

		return remove(violationUpdateStatus);
	}

	/**
	 * Returns the number of violation update statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching violation update statuses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VIOLATIONUPDATESTATUS_WHERE);

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
		"violationUpdateStatus.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(violationUpdateStatus.uuid IS NULL OR violationUpdateStatus.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"violationUpdateStatus.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of matching violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator,
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

		List<ViolationUpdateStatus> list = null;

		if (useFinderCache) {
			list = (List<ViolationUpdateStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ViolationUpdateStatus violationUpdateStatus : list) {
					if (!uuid.equals(violationUpdateStatus.getUuid()) ||
						(companyId != violationUpdateStatus.getCompanyId())) {

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

			sb.append(_SQL_SELECT_VIOLATIONUPDATESTATUS_WHERE);

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
				sb.append(ViolationUpdateStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<ViolationUpdateStatus>)QueryUtil.list(
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
	 * Returns the first violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (violationUpdateStatus != null) {
			return violationUpdateStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchViolationUpdateStatusException(sb.toString());
	}

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		List<ViolationUpdateStatus> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (violationUpdateStatus != null) {
			return violationUpdateStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchViolationUpdateStatusException(sb.toString());
	}

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ViolationUpdateStatus> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the violation update statuses before and after the current violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param violationUpdateStatusId the primary key of the current violation update status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	@Override
	public ViolationUpdateStatus[] findByUuid_C_PrevAndNext(
			long violationUpdateStatusId, String uuid, long companyId,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException {

		uuid = Objects.toString(uuid, "");

		ViolationUpdateStatus violationUpdateStatus = findByPrimaryKey(
			violationUpdateStatusId);

		Session session = null;

		try {
			session = openSession();

			ViolationUpdateStatus[] array = new ViolationUpdateStatusImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, violationUpdateStatus, uuid, companyId,
				orderByComparator, true);

			array[1] = violationUpdateStatus;

			array[2] = getByUuid_C_PrevAndNext(
				session, violationUpdateStatus, uuid, companyId,
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

	protected ViolationUpdateStatus getByUuid_C_PrevAndNext(
		Session session, ViolationUpdateStatus violationUpdateStatus,
		String uuid, long companyId,
		OrderByComparator<ViolationUpdateStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_VIOLATIONUPDATESTATUS_WHERE);

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
			sb.append(ViolationUpdateStatusModelImpl.ORDER_BY_JPQL);
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
						violationUpdateStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ViolationUpdateStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the violation update statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ViolationUpdateStatus violationUpdateStatus :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(violationUpdateStatus);
		}
	}

	/**
	 * Returns the number of violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching violation update statuses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VIOLATIONUPDATESTATUS_WHERE);

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
		"violationUpdateStatus.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(violationUpdateStatus.uuid IS NULL OR violationUpdateStatus.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"violationUpdateStatus.companyId = ?";

	private FinderPath _finderPathFetchByBlocksMetadataDetailRelId;
	private FinderPath _finderPathCountByBlocksMetadataDetailRelId;

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus =
			fetchByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);

		if (violationUpdateStatus == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("blocksMetadataDetailRelId=");
			sb.append(blocksMetadataDetailRelId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchViolationUpdateStatusException(sb.toString());
		}

		return violationUpdateStatus;
	}

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return fetchByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, true);
	}

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {blocksMetadataDetailRelId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByBlocksMetadataDetailRelId, finderArgs, this);
		}

		if (result instanceof ViolationUpdateStatus) {
			ViolationUpdateStatus violationUpdateStatus =
				(ViolationUpdateStatus)result;

			if (blocksMetadataDetailRelId !=
					violationUpdateStatus.getBlocksMetadataDetailRelId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_VIOLATIONUPDATESTATUS_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailRelId);

				List<ViolationUpdateStatus> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByBlocksMetadataDetailRelId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									blocksMetadataDetailRelId
								};
							}

							_log.warn(
								"ViolationUpdateStatusPersistenceImpl.fetchByBlocksMetadataDetailRelId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ViolationUpdateStatus violationUpdateStatus = list.get(0);

					result = violationUpdateStatus;

					cacheResult(violationUpdateStatus);
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
			return (ViolationUpdateStatus)result;
		}
	}

	/**
	 * Removes the violation update status where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the violation update status that was removed
	 */
	@Override
	public ViolationUpdateStatus removeByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus =
			findByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);

		return remove(violationUpdateStatus);
	}

	/**
	 * Returns the number of violation update statuses where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching violation update statuses
	 */
	@Override
	public int countByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		FinderPath finderPath = _finderPathCountByBlocksMetadataDetailRelId;

		Object[] finderArgs = new Object[] {blocksMetadataDetailRelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIOLATIONUPDATESTATUS_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailRelId);

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
		_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2 =
			"violationUpdateStatus.blocksMetadataDetailRelId = ?";

	public ViolationUpdateStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"violationUpdateStatusId", "violation_update_status_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createdDate", "created_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put(
			"blocksMetadataDetailRelId", "blocks_metadata_details_rel_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(ViolationUpdateStatus.class);

		setModelImplClass(ViolationUpdateStatusImpl.class);
		setModelPKClass(long.class);

		setTable(ViolationUpdateStatusTable.INSTANCE);
	}

	/**
	 * Caches the violation update status in the entity cache if it is enabled.
	 *
	 * @param violationUpdateStatus the violation update status
	 */
	@Override
	public void cacheResult(ViolationUpdateStatus violationUpdateStatus) {
		entityCache.putResult(
			ViolationUpdateStatusImpl.class,
			violationUpdateStatus.getPrimaryKey(), violationUpdateStatus);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				violationUpdateStatus.getUuid(),
				violationUpdateStatus.getGroupId()
			},
			violationUpdateStatus);

		finderCache.putResult(
			_finderPathFetchByBlocksMetadataDetailRelId,
			new Object[] {violationUpdateStatus.getBlocksMetadataDetailRelId()},
			violationUpdateStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the violation update statuses in the entity cache if it is enabled.
	 *
	 * @param violationUpdateStatuses the violation update statuses
	 */
	@Override
	public void cacheResult(
		List<ViolationUpdateStatus> violationUpdateStatuses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (violationUpdateStatuses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ViolationUpdateStatus violationUpdateStatus :
				violationUpdateStatuses) {

			if (entityCache.getResult(
					ViolationUpdateStatusImpl.class,
					violationUpdateStatus.getPrimaryKey()) == null) {

				cacheResult(violationUpdateStatus);
			}
		}
	}

	/**
	 * Clears the cache for all violation update statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ViolationUpdateStatusImpl.class);

		finderCache.clearCache(ViolationUpdateStatusImpl.class);
	}

	/**
	 * Clears the cache for the violation update status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ViolationUpdateStatus violationUpdateStatus) {
		entityCache.removeResult(
			ViolationUpdateStatusImpl.class, violationUpdateStatus);
	}

	@Override
	public void clearCache(
		List<ViolationUpdateStatus> violationUpdateStatuses) {

		for (ViolationUpdateStatus violationUpdateStatus :
				violationUpdateStatuses) {

			entityCache.removeResult(
				ViolationUpdateStatusImpl.class, violationUpdateStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ViolationUpdateStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ViolationUpdateStatusImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ViolationUpdateStatusModelImpl violationUpdateStatusModelImpl) {

		Object[] args = new Object[] {
			violationUpdateStatusModelImpl.getUuid(),
			violationUpdateStatusModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, violationUpdateStatusModelImpl);

		args = new Object[] {
			violationUpdateStatusModelImpl.getBlocksMetadataDetailRelId()
		};

		finderCache.putResult(
			_finderPathCountByBlocksMetadataDetailRelId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByBlocksMetadataDetailRelId, args,
			violationUpdateStatusModelImpl);
	}

	/**
	 * Creates a new violation update status with the primary key. Does not add the violation update status to the database.
	 *
	 * @param violationUpdateStatusId the primary key for the new violation update status
	 * @return the new violation update status
	 */
	@Override
	public ViolationUpdateStatus create(long violationUpdateStatusId) {
		ViolationUpdateStatus violationUpdateStatus =
			new ViolationUpdateStatusImpl();

		violationUpdateStatus.setNew(true);
		violationUpdateStatus.setPrimaryKey(violationUpdateStatusId);

		String uuid = _portalUUID.generate();

		violationUpdateStatus.setUuid(uuid);

		violationUpdateStatus.setCompanyId(CompanyThreadLocal.getCompanyId());

		return violationUpdateStatus;
	}

	/**
	 * Removes the violation update status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status that was removed
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	@Override
	public ViolationUpdateStatus remove(long violationUpdateStatusId)
		throws NoSuchViolationUpdateStatusException {

		return remove((Serializable)violationUpdateStatusId);
	}

	/**
	 * Removes the violation update status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the violation update status
	 * @return the violation update status that was removed
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	@Override
	public ViolationUpdateStatus remove(Serializable primaryKey)
		throws NoSuchViolationUpdateStatusException {

		Session session = null;

		try {
			session = openSession();

			ViolationUpdateStatus violationUpdateStatus =
				(ViolationUpdateStatus)session.get(
					ViolationUpdateStatusImpl.class, primaryKey);

			if (violationUpdateStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchViolationUpdateStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(violationUpdateStatus);
		}
		catch (NoSuchViolationUpdateStatusException noSuchEntityException) {
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
	protected ViolationUpdateStatus removeImpl(
		ViolationUpdateStatus violationUpdateStatus) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(violationUpdateStatus)) {
				violationUpdateStatus = (ViolationUpdateStatus)session.get(
					ViolationUpdateStatusImpl.class,
					violationUpdateStatus.getPrimaryKeyObj());
			}

			if (violationUpdateStatus != null) {
				session.delete(violationUpdateStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (violationUpdateStatus != null) {
			clearCache(violationUpdateStatus);
		}

		return violationUpdateStatus;
	}

	@Override
	public ViolationUpdateStatus updateImpl(
		ViolationUpdateStatus violationUpdateStatus) {

		boolean isNew = violationUpdateStatus.isNew();

		if (!(violationUpdateStatus instanceof
				ViolationUpdateStatusModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(violationUpdateStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					violationUpdateStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in violationUpdateStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ViolationUpdateStatus implementation " +
					violationUpdateStatus.getClass());
		}

		ViolationUpdateStatusModelImpl violationUpdateStatusModelImpl =
			(ViolationUpdateStatusModelImpl)violationUpdateStatus;

		if (Validator.isNull(violationUpdateStatus.getUuid())) {
			String uuid = _portalUUID.generate();

			violationUpdateStatus.setUuid(uuid);
		}

		if (!violationUpdateStatusModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				violationUpdateStatus.setModifiedDate(date);
			}
			else {
				violationUpdateStatus.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(violationUpdateStatus);
			}
			else {
				violationUpdateStatus = (ViolationUpdateStatus)session.merge(
					violationUpdateStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ViolationUpdateStatusImpl.class, violationUpdateStatusModelImpl,
			false, true);

		cacheUniqueFindersCache(violationUpdateStatusModelImpl);

		if (isNew) {
			violationUpdateStatus.setNew(false);
		}

		violationUpdateStatus.resetOriginalValues();

		return violationUpdateStatus;
	}

	/**
	 * Returns the violation update status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the violation update status
	 * @return the violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	@Override
	public ViolationUpdateStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchViolationUpdateStatusException {

		ViolationUpdateStatus violationUpdateStatus = fetchByPrimaryKey(
			primaryKey);

		if (violationUpdateStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchViolationUpdateStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return violationUpdateStatus;
	}

	/**
	 * Returns the violation update status with the primary key or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	@Override
	public ViolationUpdateStatus findByPrimaryKey(long violationUpdateStatusId)
		throws NoSuchViolationUpdateStatusException {

		return findByPrimaryKey((Serializable)violationUpdateStatusId);
	}

	/**
	 * Returns the violation update status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status, or <code>null</code> if a violation update status with the primary key could not be found
	 */
	@Override
	public ViolationUpdateStatus fetchByPrimaryKey(
		long violationUpdateStatusId) {

		return fetchByPrimaryKey((Serializable)violationUpdateStatusId);
	}

	/**
	 * Returns all the violation update statuses.
	 *
	 * @return the violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findAll(
		int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of violation update statuses
	 */
	@Override
	public List<ViolationUpdateStatus> findAll(
		int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator,
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

		List<ViolationUpdateStatus> list = null;

		if (useFinderCache) {
			list = (List<ViolationUpdateStatus>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VIOLATIONUPDATESTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VIOLATIONUPDATESTATUS;

				sql = sql.concat(ViolationUpdateStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ViolationUpdateStatus>)QueryUtil.list(
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
	 * Removes all the violation update statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ViolationUpdateStatus violationUpdateStatus : findAll()) {
			remove(violationUpdateStatus);
		}
	}

	/**
	 * Returns the number of violation update statuses.
	 *
	 * @return the number of violation update statuses
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
					_SQL_COUNT_VIOLATIONUPDATESTATUS);

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
		return "violation_update_status_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VIOLATIONUPDATESTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ViolationUpdateStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the violation update status persistence.
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

		_finderPathFetchByBlocksMetadataDetailRelId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByBlocksMetadataDetailRelId",
			new String[] {Long.class.getName()},
			new String[] {"blocks_metadata_details_rel_id"}, true);

		_finderPathCountByBlocksMetadataDetailRelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBlocksMetadataDetailRelId",
			new String[] {Long.class.getName()},
			new String[] {"blocks_metadata_details_rel_id"}, false);

		_setViolationUpdateStatusUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setViolationUpdateStatusUtilPersistence(null);

		entityCache.removeCache(ViolationUpdateStatusImpl.class.getName());
	}

	private void _setViolationUpdateStatusUtilPersistence(
		ViolationUpdateStatusPersistence violationUpdateStatusPersistence) {

		try {
			Field field = ViolationUpdateStatusUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, violationUpdateStatusPersistence);
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

	private static final String _SQL_SELECT_VIOLATIONUPDATESTATUS =
		"SELECT violationUpdateStatus FROM ViolationUpdateStatus violationUpdateStatus";

	private static final String _SQL_SELECT_VIOLATIONUPDATESTATUS_WHERE =
		"SELECT violationUpdateStatus FROM ViolationUpdateStatus violationUpdateStatus WHERE ";

	private static final String _SQL_COUNT_VIOLATIONUPDATESTATUS =
		"SELECT COUNT(violationUpdateStatus) FROM ViolationUpdateStatus violationUpdateStatus";

	private static final String _SQL_COUNT_VIOLATIONUPDATESTATUS_WHERE =
		"SELECT COUNT(violationUpdateStatus) FROM ViolationUpdateStatus violationUpdateStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"violationUpdateStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ViolationUpdateStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ViolationUpdateStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ViolationUpdateStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "violationUpdateStatusId", "groupId", "companyId",
			"createdDate", "createdBy", "modifiedDate", "modifiedBy",
			"blocksMetadataDetailRelId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
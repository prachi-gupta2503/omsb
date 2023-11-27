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

import gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException;
import gov.omsb.tms.model.EcMemberRequestStatus;
import gov.omsb.tms.model.EcMemberRequestStatusTable;
import gov.omsb.tms.model.impl.EcMemberRequestStatusImpl;
import gov.omsb.tms.model.impl.EcMemberRequestStatusModelImpl;
import gov.omsb.tms.service.persistence.EcMemberRequestStatusPersistence;
import gov.omsb.tms.service.persistence.EcMemberRequestStatusUtil;
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
 * The persistence implementation for the ec member request status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EcMemberRequestStatusPersistence.class)
public class EcMemberRequestStatusPersistenceImpl
	extends BasePersistenceImpl<EcMemberRequestStatus>
	implements EcMemberRequestStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EcMemberRequestStatusUtil</code> to access the ec member request status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EcMemberRequestStatusImpl.class.getName();

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
	 * Returns all the ec member request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
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

		List<EcMemberRequestStatus> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequestStatus ecMemberRequestStatus : list) {
					if (!uuid.equals(ecMemberRequestStatus.getUuid())) {
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

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE);

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
				sb.append(EcMemberRequestStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<EcMemberRequestStatus>)QueryUtil.list(
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
	 * Returns the first ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus findByUuid_First(
			String uuid,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByUuid_First(
			uuid, orderByComparator);

		if (ecMemberRequestStatus != null) {
			return ecMemberRequestStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEcMemberRequestStatusException(sb.toString());
	}

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByUuid_First(
		String uuid,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		List<EcMemberRequestStatus> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus findByUuid_Last(
			String uuid,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByUuid_Last(
			uuid, orderByComparator);

		if (ecMemberRequestStatus != null) {
			return ecMemberRequestStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEcMemberRequestStatusException(sb.toString());
	}

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByUuid_Last(
		String uuid,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequestStatus> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	@Override
	public EcMemberRequestStatus[] findByUuid_PrevAndNext(
			long ecMemberRequestStatusId, String uuid,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		uuid = Objects.toString(uuid, "");

		EcMemberRequestStatus ecMemberRequestStatus = findByPrimaryKey(
			ecMemberRequestStatusId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestStatus[] array = new EcMemberRequestStatusImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ecMemberRequestStatus, uuid, orderByComparator, true);

			array[1] = ecMemberRequestStatus;

			array[2] = getByUuid_PrevAndNext(
				session, ecMemberRequestStatus, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EcMemberRequestStatus getByUuid_PrevAndNext(
		Session session, EcMemberRequestStatus ecMemberRequestStatus,
		String uuid, OrderByComparator<EcMemberRequestStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE);

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
			sb.append(EcMemberRequestStatusModelImpl.ORDER_BY_JPQL);
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
						ecMemberRequestStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequestStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member request statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EcMemberRequestStatus ecMemberRequestStatus :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ecMemberRequestStatus);
		}
	}

	/**
	 * Returns the number of ec member request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member request statuses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATUS_WHERE);

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
		"ecMemberRequestStatus.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ecMemberRequestStatus.uuid IS NULL OR ecMemberRequestStatus.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus findByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByUUID_G(
			uuid, groupId);

		if (ecMemberRequestStatus == null) {
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

			throw new NoSuchEcMemberRequestStatusException(sb.toString());
		}

		return ecMemberRequestStatus;
	}

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByUUID_G(
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

		if (result instanceof EcMemberRequestStatus) {
			EcMemberRequestStatus ecMemberRequestStatus =
				(EcMemberRequestStatus)result;

			if (!Objects.equals(uuid, ecMemberRequestStatus.getUuid()) ||
				(groupId != ecMemberRequestStatus.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE);

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

				List<EcMemberRequestStatus> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EcMemberRequestStatus ecMemberRequestStatus = list.get(0);

					result = ecMemberRequestStatus;

					cacheResult(ecMemberRequestStatus);
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
			return (EcMemberRequestStatus)result;
		}
	}

	/**
	 * Removes the ec member request status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request status that was removed
	 */
	@Override
	public EcMemberRequestStatus removeByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = findByUUID_G(
			uuid, groupId);

		return remove(ecMemberRequestStatus);
	}

	/**
	 * Returns the number of ec member request statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member request statuses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATUS_WHERE);

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
		"ecMemberRequestStatus.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ecMemberRequestStatus.uuid IS NULL OR ecMemberRequestStatus.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ecMemberRequestStatus.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
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

		List<EcMemberRequestStatus> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequestStatus ecMemberRequestStatus : list) {
					if (!uuid.equals(ecMemberRequestStatus.getUuid()) ||
						(companyId != ecMemberRequestStatus.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE);

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
				sb.append(EcMemberRequestStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<EcMemberRequestStatus>)QueryUtil.list(
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
	 * Returns the first ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ecMemberRequestStatus != null) {
			return ecMemberRequestStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEcMemberRequestStatusException(sb.toString());
	}

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		List<EcMemberRequestStatus> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ecMemberRequestStatus != null) {
			return ecMemberRequestStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEcMemberRequestStatusException(sb.toString());
	}

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequestStatus> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	@Override
	public EcMemberRequestStatus[] findByUuid_C_PrevAndNext(
			long ecMemberRequestStatusId, String uuid, long companyId,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		uuid = Objects.toString(uuid, "");

		EcMemberRequestStatus ecMemberRequestStatus = findByPrimaryKey(
			ecMemberRequestStatusId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestStatus[] array = new EcMemberRequestStatusImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ecMemberRequestStatus, uuid, companyId,
				orderByComparator, true);

			array[1] = ecMemberRequestStatus;

			array[2] = getByUuid_C_PrevAndNext(
				session, ecMemberRequestStatus, uuid, companyId,
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

	protected EcMemberRequestStatus getByUuid_C_PrevAndNext(
		Session session, EcMemberRequestStatus ecMemberRequestStatus,
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE);

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
			sb.append(EcMemberRequestStatusModelImpl.ORDER_BY_JPQL);
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
						ecMemberRequestStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequestStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member request statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EcMemberRequestStatus ecMemberRequestStatus :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ecMemberRequestStatus);
		}
	}

	/**
	 * Returns the number of ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member request statuses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATUS_WHERE);

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
		"ecMemberRequestStatus.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ecMemberRequestStatus.uuid IS NULL OR ecMemberRequestStatus.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ecMemberRequestStatus.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCode;
	private FinderPath _finderPathWithPaginationCountByCode;

	/**
	 * Returns all the ec member request statuses where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByCode(String code) {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByCode(
		String code, int start, int end) {

		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByCode(
		String code, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return findByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findByCode(
		String code, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
		boolean useFinderCache) {

		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByCode;
		finderArgs = new Object[] {code, start, end, orderByComparator};

		List<EcMemberRequestStatus> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequestStatus ecMemberRequestStatus : list) {
					if (!StringUtil.wildcardMatches(
							ecMemberRequestStatus.getCode(), code, '_', '%',
							'\\', false)) {

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

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EcMemberRequestStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(StringUtil.toLowerCase(code));
				}

				list = (List<EcMemberRequestStatus>)QueryUtil.list(
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
	 * Returns the first ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus findByCode_First(
			String code,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByCode_First(
			code, orderByComparator);

		if (ecMemberRequestStatus != null) {
			return ecMemberRequestStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codeLIKE");
		sb.append(code);

		sb.append("}");

		throw new NoSuchEcMemberRequestStatusException(sb.toString());
	}

	/**
	 * Returns the first ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByCode_First(
		String code,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		List<EcMemberRequestStatus> list = findByCode(
			code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus findByCode_Last(
			String code,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByCode_Last(
			code, orderByComparator);

		if (ecMemberRequestStatus != null) {
			return ecMemberRequestStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codeLIKE");
		sb.append(code);

		sb.append("}");

		throw new NoSuchEcMemberRequestStatusException(sb.toString());
	}

	/**
	 * Returns the last ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByCode_Last(
		String code,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequestStatus> list = findByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	@Override
	public EcMemberRequestStatus[] findByCode_PrevAndNext(
			long ecMemberRequestStatusId, String code,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws NoSuchEcMemberRequestStatusException {

		code = Objects.toString(code, "");

		EcMemberRequestStatus ecMemberRequestStatus = findByPrimaryKey(
			ecMemberRequestStatusId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestStatus[] array = new EcMemberRequestStatusImpl[3];

			array[0] = getByCode_PrevAndNext(
				session, ecMemberRequestStatus, code, orderByComparator, true);

			array[1] = ecMemberRequestStatus;

			array[2] = getByCode_PrevAndNext(
				session, ecMemberRequestStatus, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EcMemberRequestStatus getByCode_PrevAndNext(
		Session session, EcMemberRequestStatus ecMemberRequestStatus,
		String code, OrderByComparator<EcMemberRequestStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODE_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_CODE_CODE_2);
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
			sb.append(EcMemberRequestStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCode) {
			queryPos.add(StringUtil.toLowerCase(code));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ecMemberRequestStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequestStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member request statuses where code LIKE &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeByCode(String code) {
		for (EcMemberRequestStatus ecMemberRequestStatus :
				findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ecMemberRequestStatus);
		}
	}

	/**
	 * Returns the number of ec member request statuses where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the number of matching ec member request statuses
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathWithPaginationCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATUS_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(StringUtil.toLowerCase(code));
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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"lower(ecMemberRequestStatus.code) LIKE ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(ecMemberRequestStatus.code IS NULL OR ecMemberRequestStatus.code LIKE '')";

	private FinderPath _finderPathFetchByNameEn;
	private FinderPath _finderPathCountByNameEn;

	/**
	 * Returns the ec member request status where nameEn = &#63; or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param nameEn the name en
	 * @return the matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus findByNameEn(String nameEn)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByNameEn(nameEn);

		if (ecMemberRequestStatus == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nameEn=");
			sb.append(nameEn);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEcMemberRequestStatusException(sb.toString());
		}

		return ecMemberRequestStatus;
	}

	/**
	 * Returns the ec member request status where nameEn = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nameEn the name en
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByNameEn(String nameEn) {
		return fetchByNameEn(nameEn, true);
	}

	/**
	 * Returns the ec member request status where nameEn = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nameEn the name en
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByNameEn(
		String nameEn, boolean useFinderCache) {

		nameEn = Objects.toString(nameEn, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nameEn};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByNameEn, finderArgs, this);
		}

		if (result instanceof EcMemberRequestStatus) {
			EcMemberRequestStatus ecMemberRequestStatus =
				(EcMemberRequestStatus)result;

			if (!Objects.equals(nameEn, ecMemberRequestStatus.getNameEn())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE);

			boolean bindNameEn = false;

			if (nameEn.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEEN_NAMEEN_3);
			}
			else {
				bindNameEn = true;

				sb.append(_FINDER_COLUMN_NAMEEN_NAMEEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNameEn) {
					queryPos.add(nameEn);
				}

				List<EcMemberRequestStatus> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByNameEn, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {nameEn};
							}

							_log.warn(
								"EcMemberRequestStatusPersistenceImpl.fetchByNameEn(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EcMemberRequestStatus ecMemberRequestStatus = list.get(0);

					result = ecMemberRequestStatus;

					cacheResult(ecMemberRequestStatus);
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
			return (EcMemberRequestStatus)result;
		}
	}

	/**
	 * Removes the ec member request status where nameEn = &#63; from the database.
	 *
	 * @param nameEn the name en
	 * @return the ec member request status that was removed
	 */
	@Override
	public EcMemberRequestStatus removeByNameEn(String nameEn)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = findByNameEn(nameEn);

		return remove(ecMemberRequestStatus);
	}

	/**
	 * Returns the number of ec member request statuses where nameEn = &#63;.
	 *
	 * @param nameEn the name en
	 * @return the number of matching ec member request statuses
	 */
	@Override
	public int countByNameEn(String nameEn) {
		nameEn = Objects.toString(nameEn, "");

		FinderPath finderPath = _finderPathCountByNameEn;

		Object[] finderArgs = new Object[] {nameEn};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATUS_WHERE);

			boolean bindNameEn = false;

			if (nameEn.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEEN_NAMEEN_3);
			}
			else {
				bindNameEn = true;

				sb.append(_FINDER_COLUMN_NAMEEN_NAMEEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNameEn) {
					queryPos.add(nameEn);
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

	private static final String _FINDER_COLUMN_NAMEEN_NAMEEN_2 =
		"ecMemberRequestStatus.nameEn = ?";

	private static final String _FINDER_COLUMN_NAMEEN_NAMEEN_3 =
		"(ecMemberRequestStatus.nameEn IS NULL OR ecMemberRequestStatus.nameEn = '')";

	public EcMemberRequestStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"ecMemberRequestStatusId", "ec_member_request_status_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("nameEn", "name_en");
		dbColumnNames.put("nameAr", "name_ar");

		setDBColumnNames(dbColumnNames);

		setModelClass(EcMemberRequestStatus.class);

		setModelImplClass(EcMemberRequestStatusImpl.class);
		setModelPKClass(long.class);

		setTable(EcMemberRequestStatusTable.INSTANCE);
	}

	/**
	 * Caches the ec member request status in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStatus the ec member request status
	 */
	@Override
	public void cacheResult(EcMemberRequestStatus ecMemberRequestStatus) {
		entityCache.putResult(
			EcMemberRequestStatusImpl.class,
			ecMemberRequestStatus.getPrimaryKey(), ecMemberRequestStatus);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				ecMemberRequestStatus.getUuid(),
				ecMemberRequestStatus.getGroupId()
			},
			ecMemberRequestStatus);

		finderCache.putResult(
			_finderPathFetchByNameEn,
			new Object[] {ecMemberRequestStatus.getNameEn()},
			ecMemberRequestStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ec member request statuses in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStatuses the ec member request statuses
	 */
	@Override
	public void cacheResult(
		List<EcMemberRequestStatus> ecMemberRequestStatuses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ecMemberRequestStatuses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EcMemberRequestStatus ecMemberRequestStatus :
				ecMemberRequestStatuses) {

			if (entityCache.getResult(
					EcMemberRequestStatusImpl.class,
					ecMemberRequestStatus.getPrimaryKey()) == null) {

				cacheResult(ecMemberRequestStatus);
			}
		}
	}

	/**
	 * Clears the cache for all ec member request statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EcMemberRequestStatusImpl.class);

		finderCache.clearCache(EcMemberRequestStatusImpl.class);
	}

	/**
	 * Clears the cache for the ec member request status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EcMemberRequestStatus ecMemberRequestStatus) {
		entityCache.removeResult(
			EcMemberRequestStatusImpl.class, ecMemberRequestStatus);
	}

	@Override
	public void clearCache(
		List<EcMemberRequestStatus> ecMemberRequestStatuses) {

		for (EcMemberRequestStatus ecMemberRequestStatus :
				ecMemberRequestStatuses) {

			entityCache.removeResult(
				EcMemberRequestStatusImpl.class, ecMemberRequestStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EcMemberRequestStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EcMemberRequestStatusImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EcMemberRequestStatusModelImpl ecMemberRequestStatusModelImpl) {

		Object[] args = new Object[] {
			ecMemberRequestStatusModelImpl.getUuid(),
			ecMemberRequestStatusModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ecMemberRequestStatusModelImpl);

		args = new Object[] {ecMemberRequestStatusModelImpl.getNameEn()};

		finderCache.putResult(_finderPathCountByNameEn, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByNameEn, args, ecMemberRequestStatusModelImpl);
	}

	/**
	 * Creates a new ec member request status with the primary key. Does not add the ec member request status to the database.
	 *
	 * @param ecMemberRequestStatusId the primary key for the new ec member request status
	 * @return the new ec member request status
	 */
	@Override
	public EcMemberRequestStatus create(long ecMemberRequestStatusId) {
		EcMemberRequestStatus ecMemberRequestStatus =
			new EcMemberRequestStatusImpl();

		ecMemberRequestStatus.setNew(true);
		ecMemberRequestStatus.setPrimaryKey(ecMemberRequestStatusId);

		String uuid = _portalUUID.generate();

		ecMemberRequestStatus.setUuid(uuid);

		ecMemberRequestStatus.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ecMemberRequestStatus;
	}

	/**
	 * Removes the ec member request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status that was removed
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	@Override
	public EcMemberRequestStatus remove(long ecMemberRequestStatusId)
		throws NoSuchEcMemberRequestStatusException {

		return remove((Serializable)ecMemberRequestStatusId);
	}

	/**
	 * Removes the ec member request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ec member request status
	 * @return the ec member request status that was removed
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	@Override
	public EcMemberRequestStatus remove(Serializable primaryKey)
		throws NoSuchEcMemberRequestStatusException {

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestStatus ecMemberRequestStatus =
				(EcMemberRequestStatus)session.get(
					EcMemberRequestStatusImpl.class, primaryKey);

			if (ecMemberRequestStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEcMemberRequestStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ecMemberRequestStatus);
		}
		catch (NoSuchEcMemberRequestStatusException noSuchEntityException) {
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
	protected EcMemberRequestStatus removeImpl(
		EcMemberRequestStatus ecMemberRequestStatus) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ecMemberRequestStatus)) {
				ecMemberRequestStatus = (EcMemberRequestStatus)session.get(
					EcMemberRequestStatusImpl.class,
					ecMemberRequestStatus.getPrimaryKeyObj());
			}

			if (ecMemberRequestStatus != null) {
				session.delete(ecMemberRequestStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ecMemberRequestStatus != null) {
			clearCache(ecMemberRequestStatus);
		}

		return ecMemberRequestStatus;
	}

	@Override
	public EcMemberRequestStatus updateImpl(
		EcMemberRequestStatus ecMemberRequestStatus) {

		boolean isNew = ecMemberRequestStatus.isNew();

		if (!(ecMemberRequestStatus instanceof
				EcMemberRequestStatusModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ecMemberRequestStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ecMemberRequestStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ecMemberRequestStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EcMemberRequestStatus implementation " +
					ecMemberRequestStatus.getClass());
		}

		EcMemberRequestStatusModelImpl ecMemberRequestStatusModelImpl =
			(EcMemberRequestStatusModelImpl)ecMemberRequestStatus;

		if (Validator.isNull(ecMemberRequestStatus.getUuid())) {
			String uuid = _portalUUID.generate();

			ecMemberRequestStatus.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ecMemberRequestStatus.getCreateDate() == null)) {
			if (serviceContext == null) {
				ecMemberRequestStatus.setCreateDate(date);
			}
			else {
				ecMemberRequestStatus.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!ecMemberRequestStatusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ecMemberRequestStatus.setModifiedDate(date);
			}
			else {
				ecMemberRequestStatus.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ecMemberRequestStatus);
			}
			else {
				ecMemberRequestStatus = (EcMemberRequestStatus)session.merge(
					ecMemberRequestStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EcMemberRequestStatusImpl.class, ecMemberRequestStatusModelImpl,
			false, true);

		cacheUniqueFindersCache(ecMemberRequestStatusModelImpl);

		if (isNew) {
			ecMemberRequestStatus.setNew(false);
		}

		ecMemberRequestStatus.resetOriginalValues();

		return ecMemberRequestStatus;
	}

	/**
	 * Returns the ec member request status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ec member request status
	 * @return the ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	@Override
	public EcMemberRequestStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEcMemberRequestStatusException {

		EcMemberRequestStatus ecMemberRequestStatus = fetchByPrimaryKey(
			primaryKey);

		if (ecMemberRequestStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEcMemberRequestStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ecMemberRequestStatus;
	}

	/**
	 * Returns the ec member request status with the primary key or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	@Override
	public EcMemberRequestStatus findByPrimaryKey(long ecMemberRequestStatusId)
		throws NoSuchEcMemberRequestStatusException {

		return findByPrimaryKey((Serializable)ecMemberRequestStatusId);
	}

	/**
	 * Returns the ec member request status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status, or <code>null</code> if a ec member request status with the primary key could not be found
	 */
	@Override
	public EcMemberRequestStatus fetchByPrimaryKey(
		long ecMemberRequestStatusId) {

		return fetchByPrimaryKey((Serializable)ecMemberRequestStatusId);
	}

	/**
	 * Returns all the ec member request statuses.
	 *
	 * @return the ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member request statuses
	 */
	@Override
	public List<EcMemberRequestStatus> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
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

		List<EcMemberRequestStatus> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestStatus>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ECMEMBERREQUESTSTATUS;

				sql = sql.concat(EcMemberRequestStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EcMemberRequestStatus>)QueryUtil.list(
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
	 * Removes all the ec member request statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EcMemberRequestStatus ecMemberRequestStatus : findAll()) {
			remove(ecMemberRequestStatus);
		}
	}

	/**
	 * Returns the number of ec member request statuses.
	 *
	 * @return the number of ec member request statuses
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
					_SQL_COUNT_ECMEMBERREQUESTSTATUS);

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
		return "ec_member_request_status_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ECMEMBERREQUESTSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EcMemberRequestStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ec member request status persistence.
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

		_finderPathWithPaginationFindByCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"code"}, true);

		_finderPathWithPaginationCountByCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCode",
			new String[] {String.class.getName()}, new String[] {"code"},
			false);

		_finderPathFetchByNameEn = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByNameEn",
			new String[] {String.class.getName()}, new String[] {"name_en"},
			true);

		_finderPathCountByNameEn = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameEn",
			new String[] {String.class.getName()}, new String[] {"name_en"},
			false);

		_setEcMemberRequestStatusUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEcMemberRequestStatusUtilPersistence(null);

		entityCache.removeCache(EcMemberRequestStatusImpl.class.getName());
	}

	private void _setEcMemberRequestStatusUtilPersistence(
		EcMemberRequestStatusPersistence ecMemberRequestStatusPersistence) {

		try {
			Field field = EcMemberRequestStatusUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, ecMemberRequestStatusPersistence);
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

	private static final String _SQL_SELECT_ECMEMBERREQUESTSTATUS =
		"SELECT ecMemberRequestStatus FROM EcMemberRequestStatus ecMemberRequestStatus";

	private static final String _SQL_SELECT_ECMEMBERREQUESTSTATUS_WHERE =
		"SELECT ecMemberRequestStatus FROM EcMemberRequestStatus ecMemberRequestStatus WHERE ";

	private static final String _SQL_COUNT_ECMEMBERREQUESTSTATUS =
		"SELECT COUNT(ecMemberRequestStatus) FROM EcMemberRequestStatus ecMemberRequestStatus";

	private static final String _SQL_COUNT_ECMEMBERREQUESTSTATUS_WHERE =
		"SELECT COUNT(ecMemberRequestStatus) FROM EcMemberRequestStatus ecMemberRequestStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"ecMemberRequestStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EcMemberRequestStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EcMemberRequestStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EcMemberRequestStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "ecMemberRequestStatusId", "groupId", "companyId",
			"createDate", "modifiedDate", "nameEn", "nameAr"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
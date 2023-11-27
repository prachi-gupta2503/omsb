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

import gov.omsb.tms.exception.NoSuchEcMemberRequestException;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.EcMemberRequestTable;
import gov.omsb.tms.model.impl.EcMemberRequestImpl;
import gov.omsb.tms.model.impl.EcMemberRequestModelImpl;
import gov.omsb.tms.service.persistence.EcMemberRequestPersistence;
import gov.omsb.tms.service.persistence.EcMemberRequestUtil;
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
 * The persistence implementation for the ec member request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EcMemberRequestPersistence.class)
public class EcMemberRequestPersistenceImpl
	extends BasePersistenceImpl<EcMemberRequest>
	implements EcMemberRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EcMemberRequestUtil</code> to access the ec member request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EcMemberRequestImpl.class.getName();

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
	 * Returns all the ec member requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator,
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

		List<EcMemberRequest> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequest ecMemberRequest : list) {
					if (!uuid.equals(ecMemberRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_ECMEMBERREQUEST_WHERE);

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
				sb.append(EcMemberRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EcMemberRequest>)QueryUtil.list(
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
	 * Returns the first ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest findByUuid_First(
			String uuid, OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (ecMemberRequest != null) {
			return ecMemberRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEcMemberRequestException(sb.toString());
	}

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByUuid_First(
		String uuid, OrderByComparator<EcMemberRequest> orderByComparator) {

		List<EcMemberRequest> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest findByUuid_Last(
			String uuid, OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (ecMemberRequest != null) {
			return ecMemberRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEcMemberRequestException(sb.toString());
	}

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByUuid_Last(
		String uuid, OrderByComparator<EcMemberRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	@Override
	public EcMemberRequest[] findByUuid_PrevAndNext(
			long ecMemberRequestId, String uuid,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		uuid = Objects.toString(uuid, "");

		EcMemberRequest ecMemberRequest = findByPrimaryKey(ecMemberRequestId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequest[] array = new EcMemberRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ecMemberRequest, uuid, orderByComparator, true);

			array[1] = ecMemberRequest;

			array[2] = getByUuid_PrevAndNext(
				session, ecMemberRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EcMemberRequest getByUuid_PrevAndNext(
		Session session, EcMemberRequest ecMemberRequest, String uuid,
		OrderByComparator<EcMemberRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUEST_WHERE);

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
			sb.append(EcMemberRequestModelImpl.ORDER_BY_JPQL);
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
						ecMemberRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EcMemberRequest ecMemberRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ecMemberRequest);
		}
	}

	/**
	 * Returns the number of ec member requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ECMEMBERREQUEST_WHERE);

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
		"ecMemberRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ecMemberRequest.uuid IS NULL OR ecMemberRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = fetchByUUID_G(uuid, groupId);

		if (ecMemberRequest == null) {
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

			throw new NoSuchEcMemberRequestException(sb.toString());
		}

		return ecMemberRequest;
	}

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByUUID_G(
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

		if (result instanceof EcMemberRequest) {
			EcMemberRequest ecMemberRequest = (EcMemberRequest)result;

			if (!Objects.equals(uuid, ecMemberRequest.getUuid()) ||
				(groupId != ecMemberRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ECMEMBERREQUEST_WHERE);

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

				List<EcMemberRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EcMemberRequest ecMemberRequest = list.get(0);

					result = ecMemberRequest;

					cacheResult(ecMemberRequest);
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
			return (EcMemberRequest)result;
		}
	}

	/**
	 * Removes the ec member request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request that was removed
	 */
	@Override
	public EcMemberRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = findByUUID_G(uuid, groupId);

		return remove(ecMemberRequest);
	}

	/**
	 * Returns the number of ec member requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ECMEMBERREQUEST_WHERE);

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
		"ecMemberRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ecMemberRequest.uuid IS NULL OR ecMemberRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ecMemberRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator,
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

		List<EcMemberRequest> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequest ecMemberRequest : list) {
					if (!uuid.equals(ecMemberRequest.getUuid()) ||
						(companyId != ecMemberRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ECMEMBERREQUEST_WHERE);

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
				sb.append(EcMemberRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EcMemberRequest>)QueryUtil.list(
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
	 * Returns the first ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ecMemberRequest != null) {
			return ecMemberRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEcMemberRequestException(sb.toString());
	}

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		List<EcMemberRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ecMemberRequest != null) {
			return ecMemberRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEcMemberRequestException(sb.toString());
	}

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	@Override
	public EcMemberRequest[] findByUuid_C_PrevAndNext(
			long ecMemberRequestId, String uuid, long companyId,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		uuid = Objects.toString(uuid, "");

		EcMemberRequest ecMemberRequest = findByPrimaryKey(ecMemberRequestId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequest[] array = new EcMemberRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ecMemberRequest, uuid, companyId, orderByComparator,
				true);

			array[1] = ecMemberRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, ecMemberRequest, uuid, companyId, orderByComparator,
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

	protected EcMemberRequest getByUuid_C_PrevAndNext(
		Session session, EcMemberRequest ecMemberRequest, String uuid,
		long companyId, OrderByComparator<EcMemberRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUEST_WHERE);

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
			sb.append(EcMemberRequestModelImpl.ORDER_BY_JPQL);
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
						ecMemberRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EcMemberRequest ecMemberRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ecMemberRequest);
		}
	}

	/**
	 * Returns the number of ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ECMEMBERREQUEST_WHERE);

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
		"ecMemberRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ecMemberRequest.uuid IS NULL OR ecMemberRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ecMemberRequest.companyId = ?";

	private FinderPath _finderPathFetchByPotentialEcMemberId;
	private FinderPath _finderPathCountByPotentialEcMemberId;

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest findByPotentialEcMemberId(long potentialEcMemberId)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = fetchByPotentialEcMemberId(
			potentialEcMemberId);

		if (ecMemberRequest == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("potentialEcMemberId=");
			sb.append(potentialEcMemberId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEcMemberRequestException(sb.toString());
		}

		return ecMemberRequest;
	}

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByPotentialEcMemberId(
		long potentialEcMemberId) {

		return fetchByPotentialEcMemberId(potentialEcMemberId, true);
	}

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByPotentialEcMemberId(
		long potentialEcMemberId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {potentialEcMemberId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPotentialEcMemberId, finderArgs, this);
		}

		if (result instanceof EcMemberRequest) {
			EcMemberRequest ecMemberRequest = (EcMemberRequest)result;

			if (potentialEcMemberId !=
					ecMemberRequest.getPotentialEcMemberId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ECMEMBERREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_POTENTIALECMEMBERID_POTENTIALECMEMBERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(potentialEcMemberId);

				List<EcMemberRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPotentialEcMemberId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {potentialEcMemberId};
							}

							_log.warn(
								"EcMemberRequestPersistenceImpl.fetchByPotentialEcMemberId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EcMemberRequest ecMemberRequest = list.get(0);

					result = ecMemberRequest;

					cacheResult(ecMemberRequest);
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
			return (EcMemberRequest)result;
		}
	}

	/**
	 * Removes the ec member request where potentialEcMemberId = &#63; from the database.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the ec member request that was removed
	 */
	@Override
	public EcMemberRequest removeByPotentialEcMemberId(long potentialEcMemberId)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = findByPotentialEcMemberId(
			potentialEcMemberId);

		return remove(ecMemberRequest);
	}

	/**
	 * Returns the number of ec member requests where potentialEcMemberId = &#63;.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the number of matching ec member requests
	 */
	@Override
	public int countByPotentialEcMemberId(long potentialEcMemberId) {
		FinderPath finderPath = _finderPathCountByPotentialEcMemberId;

		Object[] finderArgs = new Object[] {potentialEcMemberId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ECMEMBERREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_POTENTIALECMEMBERID_POTENTIALECMEMBERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(potentialEcMemberId);

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
		_FINDER_COLUMN_POTENTIALECMEMBERID_POTENTIALECMEMBERID_2 =
			"ecMemberRequest.potentialEcMemberId = ?";

	private FinderPath _finderPathWithPaginationFindByPotentialEcMemberLruserid;
	private FinderPath
		_finderPathWithoutPaginationFindByPotentialEcMemberLruserid;
	private FinderPath _finderPathCountByPotentialEcMemberLruserid;

	/**
	 * Returns all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @return the matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid) {

		return findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end) {

		return findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	@Override
	public List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPotentialEcMemberLruserid;
				finderArgs = new Object[] {potentialEcMemberLruserid};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByPotentialEcMemberLruserid;
			finderArgs = new Object[] {
				potentialEcMemberLruserid, start, end, orderByComparator
			};
		}

		List<EcMemberRequest> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequest ecMemberRequest : list) {
					if (potentialEcMemberLruserid !=
							ecMemberRequest.getPotentialEcMemberLruserid()) {

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

			sb.append(_SQL_SELECT_ECMEMBERREQUEST_WHERE);

			sb.append(
				_FINDER_COLUMN_POTENTIALECMEMBERLRUSERID_POTENTIALECMEMBERLRUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EcMemberRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(potentialEcMemberLruserid);

				list = (List<EcMemberRequest>)QueryUtil.list(
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
	 * Returns the first ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest findByPotentialEcMemberLruserid_First(
			long potentialEcMemberLruserid,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest =
			fetchByPotentialEcMemberLruserid_First(
				potentialEcMemberLruserid, orderByComparator);

		if (ecMemberRequest != null) {
			return ecMemberRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("potentialEcMemberLruserid=");
		sb.append(potentialEcMemberLruserid);

		sb.append("}");

		throw new NoSuchEcMemberRequestException(sb.toString());
	}

	/**
	 * Returns the first ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByPotentialEcMemberLruserid_First(
		long potentialEcMemberLruserid,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		List<EcMemberRequest> list = findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest findByPotentialEcMemberLruserid_Last(
			long potentialEcMemberLruserid,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = fetchByPotentialEcMemberLruserid_Last(
			potentialEcMemberLruserid, orderByComparator);

		if (ecMemberRequest != null) {
			return ecMemberRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("potentialEcMemberLruserid=");
		sb.append(potentialEcMemberLruserid);

		sb.append("}");

		throw new NoSuchEcMemberRequestException(sb.toString());
	}

	/**
	 * Returns the last ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public EcMemberRequest fetchByPotentialEcMemberLruserid_Last(
		long potentialEcMemberLruserid,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		int count = countByPotentialEcMemberLruserid(potentialEcMemberLruserid);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequest> list = findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	@Override
	public EcMemberRequest[] findByPotentialEcMemberLruserid_PrevAndNext(
			long ecMemberRequestId, long potentialEcMemberLruserid,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = findByPrimaryKey(ecMemberRequestId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequest[] array = new EcMemberRequestImpl[3];

			array[0] = getByPotentialEcMemberLruserid_PrevAndNext(
				session, ecMemberRequest, potentialEcMemberLruserid,
				orderByComparator, true);

			array[1] = ecMemberRequest;

			array[2] = getByPotentialEcMemberLruserid_PrevAndNext(
				session, ecMemberRequest, potentialEcMemberLruserid,
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

	protected EcMemberRequest getByPotentialEcMemberLruserid_PrevAndNext(
		Session session, EcMemberRequest ecMemberRequest,
		long potentialEcMemberLruserid,
		OrderByComparator<EcMemberRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUEST_WHERE);

		sb.append(
			_FINDER_COLUMN_POTENTIALECMEMBERLRUSERID_POTENTIALECMEMBERLRUSERID_2);

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
			sb.append(EcMemberRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(potentialEcMemberLruserid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ecMemberRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member requests where potentialEcMemberLruserid = &#63; from the database.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 */
	@Override
	public void removeByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid) {

		for (EcMemberRequest ecMemberRequest :
				findByPotentialEcMemberLruserid(
					potentialEcMemberLruserid, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(ecMemberRequest);
		}
	}

	/**
	 * Returns the number of ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @return the number of matching ec member requests
	 */
	@Override
	public int countByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid) {

		FinderPath finderPath = _finderPathCountByPotentialEcMemberLruserid;

		Object[] finderArgs = new Object[] {potentialEcMemberLruserid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ECMEMBERREQUEST_WHERE);

			sb.append(
				_FINDER_COLUMN_POTENTIALECMEMBERLRUSERID_POTENTIALECMEMBERLRUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(potentialEcMemberLruserid);

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
		_FINDER_COLUMN_POTENTIALECMEMBERLRUSERID_POTENTIALECMEMBERLRUSERID_2 =
			"ecMemberRequest.potentialEcMemberLruserid = ?";

	public EcMemberRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("ecMemberRequestId", "ec_member_request_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put("potentialEcMemberId", "potential_ec_member_id");
		dbColumnNames.put(
			"potentialEcMemberRoleId", "potential_ec_member_role_id");
		dbColumnNames.put(
			"latestEcMemberRequestStateId",
			"latest_ec_member_request_state_id");
		dbColumnNames.put("coveringLetterId", "covering_letter_id");
		dbColumnNames.put("cvId", "cv_id");
		dbColumnNames.put("noObjectionLetterId", "no_objection_letter_id");
		dbColumnNames.put("passportCopyId", "passport_copy_id");
		dbColumnNames.put("nationalIdCopyId", "national_id_copy_id");
		dbColumnNames.put("qararRequestId", "qarar_request_id");
		dbColumnNames.put("qararDocId", "qarar_doc_id");
		dbColumnNames.put(
			"potentialEcMemberLruserid", "potential_ec_member_lruserid");

		setDBColumnNames(dbColumnNames);

		setModelClass(EcMemberRequest.class);

		setModelImplClass(EcMemberRequestImpl.class);
		setModelPKClass(long.class);

		setTable(EcMemberRequestTable.INSTANCE);
	}

	/**
	 * Caches the ec member request in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequest the ec member request
	 */
	@Override
	public void cacheResult(EcMemberRequest ecMemberRequest) {
		entityCache.putResult(
			EcMemberRequestImpl.class, ecMemberRequest.getPrimaryKey(),
			ecMemberRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				ecMemberRequest.getUuid(), ecMemberRequest.getGroupId()
			},
			ecMemberRequest);

		finderCache.putResult(
			_finderPathFetchByPotentialEcMemberId,
			new Object[] {ecMemberRequest.getPotentialEcMemberId()},
			ecMemberRequest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ec member requests in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequests the ec member requests
	 */
	@Override
	public void cacheResult(List<EcMemberRequest> ecMemberRequests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ecMemberRequests.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EcMemberRequest ecMemberRequest : ecMemberRequests) {
			if (entityCache.getResult(
					EcMemberRequestImpl.class,
					ecMemberRequest.getPrimaryKey()) == null) {

				cacheResult(ecMemberRequest);
			}
		}
	}

	/**
	 * Clears the cache for all ec member requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EcMemberRequestImpl.class);

		finderCache.clearCache(EcMemberRequestImpl.class);
	}

	/**
	 * Clears the cache for the ec member request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EcMemberRequest ecMemberRequest) {
		entityCache.removeResult(EcMemberRequestImpl.class, ecMemberRequest);
	}

	@Override
	public void clearCache(List<EcMemberRequest> ecMemberRequests) {
		for (EcMemberRequest ecMemberRequest : ecMemberRequests) {
			entityCache.removeResult(
				EcMemberRequestImpl.class, ecMemberRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EcMemberRequestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EcMemberRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EcMemberRequestModelImpl ecMemberRequestModelImpl) {

		Object[] args = new Object[] {
			ecMemberRequestModelImpl.getUuid(),
			ecMemberRequestModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ecMemberRequestModelImpl);

		args = new Object[] {ecMemberRequestModelImpl.getPotentialEcMemberId()};

		finderCache.putResult(
			_finderPathCountByPotentialEcMemberId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByPotentialEcMemberId, args,
			ecMemberRequestModelImpl);
	}

	/**
	 * Creates a new ec member request with the primary key. Does not add the ec member request to the database.
	 *
	 * @param ecMemberRequestId the primary key for the new ec member request
	 * @return the new ec member request
	 */
	@Override
	public EcMemberRequest create(long ecMemberRequestId) {
		EcMemberRequest ecMemberRequest = new EcMemberRequestImpl();

		ecMemberRequest.setNew(true);
		ecMemberRequest.setPrimaryKey(ecMemberRequestId);

		String uuid = _portalUUID.generate();

		ecMemberRequest.setUuid(uuid);

		ecMemberRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ecMemberRequest;
	}

	/**
	 * Removes the ec member request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request that was removed
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	@Override
	public EcMemberRequest remove(long ecMemberRequestId)
		throws NoSuchEcMemberRequestException {

		return remove((Serializable)ecMemberRequestId);
	}

	/**
	 * Removes the ec member request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ec member request
	 * @return the ec member request that was removed
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	@Override
	public EcMemberRequest remove(Serializable primaryKey)
		throws NoSuchEcMemberRequestException {

		Session session = null;

		try {
			session = openSession();

			EcMemberRequest ecMemberRequest = (EcMemberRequest)session.get(
				EcMemberRequestImpl.class, primaryKey);

			if (ecMemberRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEcMemberRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ecMemberRequest);
		}
		catch (NoSuchEcMemberRequestException noSuchEntityException) {
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
	protected EcMemberRequest removeImpl(EcMemberRequest ecMemberRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ecMemberRequest)) {
				ecMemberRequest = (EcMemberRequest)session.get(
					EcMemberRequestImpl.class,
					ecMemberRequest.getPrimaryKeyObj());
			}

			if (ecMemberRequest != null) {
				session.delete(ecMemberRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ecMemberRequest != null) {
			clearCache(ecMemberRequest);
		}

		return ecMemberRequest;
	}

	@Override
	public EcMemberRequest updateImpl(EcMemberRequest ecMemberRequest) {
		boolean isNew = ecMemberRequest.isNew();

		if (!(ecMemberRequest instanceof EcMemberRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ecMemberRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ecMemberRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ecMemberRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EcMemberRequest implementation " +
					ecMemberRequest.getClass());
		}

		EcMemberRequestModelImpl ecMemberRequestModelImpl =
			(EcMemberRequestModelImpl)ecMemberRequest;

		if (Validator.isNull(ecMemberRequest.getUuid())) {
			String uuid = _portalUUID.generate();

			ecMemberRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ecMemberRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				ecMemberRequest.setCreateDate(date);
			}
			else {
				ecMemberRequest.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!ecMemberRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ecMemberRequest.setModifiedDate(date);
			}
			else {
				ecMemberRequest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ecMemberRequest);
			}
			else {
				ecMemberRequest = (EcMemberRequest)session.merge(
					ecMemberRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EcMemberRequestImpl.class, ecMemberRequestModelImpl, false, true);

		cacheUniqueFindersCache(ecMemberRequestModelImpl);

		if (isNew) {
			ecMemberRequest.setNew(false);
		}

		ecMemberRequest.resetOriginalValues();

		return ecMemberRequest;
	}

	/**
	 * Returns the ec member request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ec member request
	 * @return the ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	@Override
	public EcMemberRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEcMemberRequestException {

		EcMemberRequest ecMemberRequest = fetchByPrimaryKey(primaryKey);

		if (ecMemberRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEcMemberRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ecMemberRequest;
	}

	/**
	 * Returns the ec member request with the primary key or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	@Override
	public EcMemberRequest findByPrimaryKey(long ecMemberRequestId)
		throws NoSuchEcMemberRequestException {

		return findByPrimaryKey((Serializable)ecMemberRequestId);
	}

	/**
	 * Returns the ec member request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request, or <code>null</code> if a ec member request with the primary key could not be found
	 */
	@Override
	public EcMemberRequest fetchByPrimaryKey(long ecMemberRequestId) {
		return fetchByPrimaryKey((Serializable)ecMemberRequestId);
	}

	/**
	 * Returns all the ec member requests.
	 *
	 * @return the ec member requests
	 */
	@Override
	public List<EcMemberRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of ec member requests
	 */
	@Override
	public List<EcMemberRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member requests
	 */
	@Override
	public List<EcMemberRequest> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member requests
	 */
	@Override
	public List<EcMemberRequest> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator,
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

		List<EcMemberRequest> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ECMEMBERREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ECMEMBERREQUEST;

				sql = sql.concat(EcMemberRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EcMemberRequest>)QueryUtil.list(
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
	 * Removes all the ec member requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EcMemberRequest ecMemberRequest : findAll()) {
			remove(ecMemberRequest);
		}
	}

	/**
	 * Returns the number of ec member requests.
	 *
	 * @return the number of ec member requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ECMEMBERREQUEST);

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
		return "ec_member_request_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ECMEMBERREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EcMemberRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ec member request persistence.
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

		_finderPathFetchByPotentialEcMemberId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPotentialEcMemberId",
			new String[] {Long.class.getName()},
			new String[] {"potential_ec_member_id"}, true);

		_finderPathCountByPotentialEcMemberId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPotentialEcMemberId", new String[] {Long.class.getName()},
			new String[] {"potential_ec_member_id"}, false);

		_finderPathWithPaginationFindByPotentialEcMemberLruserid =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByPotentialEcMemberLruserid",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"potential_ec_member_lruserid"}, true);

		_finderPathWithoutPaginationFindByPotentialEcMemberLruserid =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByPotentialEcMemberLruserid",
				new String[] {Long.class.getName()},
				new String[] {"potential_ec_member_lruserid"}, true);

		_finderPathCountByPotentialEcMemberLruserid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPotentialEcMemberLruserid",
			new String[] {Long.class.getName()},
			new String[] {"potential_ec_member_lruserid"}, false);

		_setEcMemberRequestUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEcMemberRequestUtilPersistence(null);

		entityCache.removeCache(EcMemberRequestImpl.class.getName());
	}

	private void _setEcMemberRequestUtilPersistence(
		EcMemberRequestPersistence ecMemberRequestPersistence) {

		try {
			Field field = EcMemberRequestUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, ecMemberRequestPersistence);
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

	private static final String _SQL_SELECT_ECMEMBERREQUEST =
		"SELECT ecMemberRequest FROM EcMemberRequest ecMemberRequest";

	private static final String _SQL_SELECT_ECMEMBERREQUEST_WHERE =
		"SELECT ecMemberRequest FROM EcMemberRequest ecMemberRequest WHERE ";

	private static final String _SQL_COUNT_ECMEMBERREQUEST =
		"SELECT COUNT(ecMemberRequest) FROM EcMemberRequest ecMemberRequest";

	private static final String _SQL_COUNT_ECMEMBERREQUEST_WHERE =
		"SELECT COUNT(ecMemberRequest) FROM EcMemberRequest ecMemberRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ecMemberRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EcMemberRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EcMemberRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EcMemberRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "ecMemberRequestId", "groupId", "companyId", "createDate",
			"modifiedDate", "programId", "potentialEcMemberId",
			"potentialEcMemberRoleId", "latestEcMemberRequestStateId",
			"coveringLetterId", "cvId", "noObjectionLetterId", "passportCopyId",
			"nationalIdCopyId", "qararRequestId", "qararDocId",
			"potentialEcMemberLruserid"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
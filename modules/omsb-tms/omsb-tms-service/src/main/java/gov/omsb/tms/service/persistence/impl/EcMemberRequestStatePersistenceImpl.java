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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import gov.omsb.tms.exception.NoSuchEcMemberRequestStateException;
import gov.omsb.tms.model.EcMemberRequestState;
import gov.omsb.tms.model.EcMemberRequestStateTable;
import gov.omsb.tms.model.impl.EcMemberRequestStateImpl;
import gov.omsb.tms.model.impl.EcMemberRequestStateModelImpl;
import gov.omsb.tms.service.persistence.EcMemberRequestStatePersistence;
import gov.omsb.tms.service.persistence.EcMemberRequestStateUtil;
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
 * The persistence implementation for the ec member request state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EcMemberRequestStatePersistence.class)
public class EcMemberRequestStatePersistenceImpl
	extends BasePersistenceImpl<EcMemberRequestState>
	implements EcMemberRequestStatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EcMemberRequestStateUtil</code> to access the ec member request state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EcMemberRequestStateImpl.class.getName();

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
	 * Returns all the ec member request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
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

		List<EcMemberRequestState> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequestState ecMemberRequestState : list) {
					if (!uuid.equals(ecMemberRequestState.getUuid())) {
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

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

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
				sb.append(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
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

				list = (List<EcMemberRequestState>)QueryUtil.list(
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
	 * Returns the first ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByUuid_First(
			String uuid,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = fetchByUuid_First(
			uuid, orderByComparator);

		if (ecMemberRequestState != null) {
			return ecMemberRequestState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEcMemberRequestStateException(sb.toString());
	}

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByUuid_First(
		String uuid,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		List<EcMemberRequestState> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByUuid_Last(
			String uuid,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = fetchByUuid_Last(
			uuid, orderByComparator);

		if (ecMemberRequestState != null) {
			return ecMemberRequestState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEcMemberRequestStateException(sb.toString());
	}

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByUuid_Last(
		String uuid,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequestState> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState[] findByUuid_PrevAndNext(
			long ecMemberRequestStateId, String uuid,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		uuid = Objects.toString(uuid, "");

		EcMemberRequestState ecMemberRequestState = findByPrimaryKey(
			ecMemberRequestStateId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestState[] array = new EcMemberRequestStateImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ecMemberRequestState, uuid, orderByComparator, true);

			array[1] = ecMemberRequestState;

			array[2] = getByUuid_PrevAndNext(
				session, ecMemberRequestState, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EcMemberRequestState getByUuid_PrevAndNext(
		Session session, EcMemberRequestState ecMemberRequestState, String uuid,
		OrderByComparator<EcMemberRequestState> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

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
			sb.append(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
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
						ecMemberRequestState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequestState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member request states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EcMemberRequestState ecMemberRequestState :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ecMemberRequestState);
		}
	}

	/**
	 * Returns the number of ec member request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member request states
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATE_WHERE);

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
		"ecMemberRequestState.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ecMemberRequestState.uuid IS NULL OR ecMemberRequestState.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = fetchByUUID_G(
			uuid, groupId);

		if (ecMemberRequestState == null) {
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

			throw new NoSuchEcMemberRequestStateException(sb.toString());
		}

		return ecMemberRequestState;
	}

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByUUID_G(
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

		if (result instanceof EcMemberRequestState) {
			EcMemberRequestState ecMemberRequestState =
				(EcMemberRequestState)result;

			if (!Objects.equals(uuid, ecMemberRequestState.getUuid()) ||
				(groupId != ecMemberRequestState.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

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

				List<EcMemberRequestState> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EcMemberRequestState ecMemberRequestState = list.get(0);

					result = ecMemberRequestState;

					cacheResult(ecMemberRequestState);
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
			return (EcMemberRequestState)result;
		}
	}

	/**
	 * Removes the ec member request state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request state that was removed
	 */
	@Override
	public EcMemberRequestState removeByUUID_G(String uuid, long groupId)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = findByUUID_G(uuid, groupId);

		return remove(ecMemberRequestState);
	}

	/**
	 * Returns the number of ec member request states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member request states
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATE_WHERE);

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
		"ecMemberRequestState.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ecMemberRequestState.uuid IS NULL OR ecMemberRequestState.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ecMemberRequestState.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
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

		List<EcMemberRequestState> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequestState ecMemberRequestState : list) {
					if (!uuid.equals(ecMemberRequestState.getUuid()) ||
						(companyId != ecMemberRequestState.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

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
				sb.append(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
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

				list = (List<EcMemberRequestState>)QueryUtil.list(
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
	 * Returns the first ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ecMemberRequestState != null) {
			return ecMemberRequestState;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEcMemberRequestStateException(sb.toString());
	}

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		List<EcMemberRequestState> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ecMemberRequestState != null) {
			return ecMemberRequestState;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEcMemberRequestStateException(sb.toString());
	}

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequestState> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState[] findByUuid_C_PrevAndNext(
			long ecMemberRequestStateId, String uuid, long companyId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		uuid = Objects.toString(uuid, "");

		EcMemberRequestState ecMemberRequestState = findByPrimaryKey(
			ecMemberRequestStateId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestState[] array = new EcMemberRequestStateImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ecMemberRequestState, uuid, companyId,
				orderByComparator, true);

			array[1] = ecMemberRequestState;

			array[2] = getByUuid_C_PrevAndNext(
				session, ecMemberRequestState, uuid, companyId,
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

	protected EcMemberRequestState getByUuid_C_PrevAndNext(
		Session session, EcMemberRequestState ecMemberRequestState, String uuid,
		long companyId,
		OrderByComparator<EcMemberRequestState> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

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
			sb.append(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
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
						ecMemberRequestState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequestState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member request states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EcMemberRequestState ecMemberRequestState :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ecMemberRequestState);
		}
	}

	/**
	 * Returns the number of ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member request states
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATE_WHERE);

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
		"ecMemberRequestState.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ecMemberRequestState.uuid IS NULL OR ecMemberRequestState.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ecMemberRequestState.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByEcMemberRequestId;
	private FinderPath _finderPathWithoutPaginationFindByEcMemberRequestId;
	private FinderPath _finderPathCountByEcMemberRequestId;

	/**
	 * Returns all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId) {

		return findByEcMemberRequestId(
			ecMemberRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end) {

		return findByEcMemberRequestId(ecMemberRequestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return findByEcMemberRequestId(
			ecMemberRequestId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEcMemberRequestId;
				finderArgs = new Object[] {ecMemberRequestId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEcMemberRequestId;
			finderArgs = new Object[] {
				ecMemberRequestId, start, end, orderByComparator
			};
		}

		List<EcMemberRequestState> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequestState ecMemberRequestState : list) {
					if (ecMemberRequestId !=
							ecMemberRequestState.getEcMemberRequestId()) {

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

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

			sb.append(_FINDER_COLUMN_ECMEMBERREQUESTID_ECMEMBERREQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ecMemberRequestId);

				list = (List<EcMemberRequestState>)QueryUtil.list(
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
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByEcMemberRequestId_First(
			long ecMemberRequestId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState =
			fetchByEcMemberRequestId_First(
				ecMemberRequestId, orderByComparator);

		if (ecMemberRequestState != null) {
			return ecMemberRequestState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ecMemberRequestId=");
		sb.append(ecMemberRequestId);

		sb.append("}");

		throw new NoSuchEcMemberRequestStateException(sb.toString());
	}

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByEcMemberRequestId_First(
		long ecMemberRequestId,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		List<EcMemberRequestState> list = findByEcMemberRequestId(
			ecMemberRequestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByEcMemberRequestId_Last(
			long ecMemberRequestId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState =
			fetchByEcMemberRequestId_Last(ecMemberRequestId, orderByComparator);

		if (ecMemberRequestState != null) {
			return ecMemberRequestState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ecMemberRequestId=");
		sb.append(ecMemberRequestId);

		sb.append("}");

		throw new NoSuchEcMemberRequestStateException(sb.toString());
	}

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByEcMemberRequestId_Last(
		long ecMemberRequestId,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		int count = countByEcMemberRequestId(ecMemberRequestId);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequestState> list = findByEcMemberRequestId(
			ecMemberRequestId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState[] findByEcMemberRequestId_PrevAndNext(
			long ecMemberRequestStateId, long ecMemberRequestId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = findByPrimaryKey(
			ecMemberRequestStateId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestState[] array = new EcMemberRequestStateImpl[3];

			array[0] = getByEcMemberRequestId_PrevAndNext(
				session, ecMemberRequestState, ecMemberRequestId,
				orderByComparator, true);

			array[1] = ecMemberRequestState;

			array[2] = getByEcMemberRequestId_PrevAndNext(
				session, ecMemberRequestState, ecMemberRequestId,
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

	protected EcMemberRequestState getByEcMemberRequestId_PrevAndNext(
		Session session, EcMemberRequestState ecMemberRequestState,
		long ecMemberRequestId,
		OrderByComparator<EcMemberRequestState> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

		sb.append(_FINDER_COLUMN_ECMEMBERREQUESTID_ECMEMBERREQUESTID_2);

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
			sb.append(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(ecMemberRequestId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ecMemberRequestState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequestState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member request states where ecMemberRequestId = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 */
	@Override
	public void removeByEcMemberRequestId(long ecMemberRequestId) {
		for (EcMemberRequestState ecMemberRequestState :
				findByEcMemberRequestId(
					ecMemberRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ecMemberRequestState);
		}
	}

	/**
	 * Returns the number of ec member request states where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the number of matching ec member request states
	 */
	@Override
	public int countByEcMemberRequestId(long ecMemberRequestId) {
		FinderPath finderPath = _finderPathCountByEcMemberRequestId;

		Object[] finderArgs = new Object[] {ecMemberRequestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATE_WHERE);

			sb.append(_FINDER_COLUMN_ECMEMBERREQUESTID_ECMEMBERREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ecMemberRequestId);

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
		_FINDER_COLUMN_ECMEMBERREQUESTID_ECMEMBERREQUESTID_2 =
			"ecMemberRequestState.ecMemberRequestId = ?";

	private FinderPath _finderPathWithPaginationFindByVisibility;
	private FinderPath _finderPathWithoutPaginationFindByVisibility;
	private FinderPath _finderPathCountByVisibility;

	/**
	 * Returns all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @return the matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic) {

		return findByVisibility(
			ecMemberRequestId, isPublic, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end) {

		return findByVisibility(ecMemberRequestId, isPublic, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return findByVisibility(
			ecMemberRequestId, isPublic, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVisibility;
				finderArgs = new Object[] {ecMemberRequestId, isPublic};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVisibility;
			finderArgs = new Object[] {
				ecMemberRequestId, isPublic, start, end, orderByComparator
			};
		}

		List<EcMemberRequestState> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcMemberRequestState ecMemberRequestState : list) {
					if ((ecMemberRequestId !=
							ecMemberRequestState.getEcMemberRequestId()) ||
						(isPublic != ecMemberRequestState.isIsPublic())) {

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

			sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

			sb.append(_FINDER_COLUMN_VISIBILITY_ECMEMBERREQUESTID_2);

			sb.append(_FINDER_COLUMN_VISIBILITY_ISPUBLIC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ecMemberRequestId);

				queryPos.add(isPublic);

				list = (List<EcMemberRequestState>)QueryUtil.list(
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
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByVisibility_First(
			long ecMemberRequestId, boolean isPublic,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = fetchByVisibility_First(
			ecMemberRequestId, isPublic, orderByComparator);

		if (ecMemberRequestState != null) {
			return ecMemberRequestState;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ecMemberRequestId=");
		sb.append(ecMemberRequestId);

		sb.append(", isPublic=");
		sb.append(isPublic);

		sb.append("}");

		throw new NoSuchEcMemberRequestStateException(sb.toString());
	}

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByVisibility_First(
		long ecMemberRequestId, boolean isPublic,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		List<EcMemberRequestState> list = findByVisibility(
			ecMemberRequestId, isPublic, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState findByVisibility_Last(
			long ecMemberRequestId, boolean isPublic,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = fetchByVisibility_Last(
			ecMemberRequestId, isPublic, orderByComparator);

		if (ecMemberRequestState != null) {
			return ecMemberRequestState;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ecMemberRequestId=");
		sb.append(ecMemberRequestId);

		sb.append(", isPublic=");
		sb.append(isPublic);

		sb.append("}");

		throw new NoSuchEcMemberRequestStateException(sb.toString());
	}

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public EcMemberRequestState fetchByVisibility_Last(
		long ecMemberRequestId, boolean isPublic,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		int count = countByVisibility(ecMemberRequestId, isPublic);

		if (count == 0) {
			return null;
		}

		List<EcMemberRequestState> list = findByVisibility(
			ecMemberRequestId, isPublic, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState[] findByVisibility_PrevAndNext(
			long ecMemberRequestStateId, long ecMemberRequestId,
			boolean isPublic,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = findByPrimaryKey(
			ecMemberRequestStateId);

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestState[] array = new EcMemberRequestStateImpl[3];

			array[0] = getByVisibility_PrevAndNext(
				session, ecMemberRequestState, ecMemberRequestId, isPublic,
				orderByComparator, true);

			array[1] = ecMemberRequestState;

			array[2] = getByVisibility_PrevAndNext(
				session, ecMemberRequestState, ecMemberRequestId, isPublic,
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

	protected EcMemberRequestState getByVisibility_PrevAndNext(
		Session session, EcMemberRequestState ecMemberRequestState,
		long ecMemberRequestId, boolean isPublic,
		OrderByComparator<EcMemberRequestState> orderByComparator,
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

		sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE);

		sb.append(_FINDER_COLUMN_VISIBILITY_ECMEMBERREQUESTID_2);

		sb.append(_FINDER_COLUMN_VISIBILITY_ISPUBLIC_2);

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
			sb.append(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(ecMemberRequestId);

		queryPos.add(isPublic);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ecMemberRequestState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EcMemberRequestState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 */
	@Override
	public void removeByVisibility(long ecMemberRequestId, boolean isPublic) {
		for (EcMemberRequestState ecMemberRequestState :
				findByVisibility(
					ecMemberRequestId, isPublic, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(ecMemberRequestState);
		}
	}

	/**
	 * Returns the number of ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @return the number of matching ec member request states
	 */
	@Override
	public int countByVisibility(long ecMemberRequestId, boolean isPublic) {
		FinderPath finderPath = _finderPathCountByVisibility;

		Object[] finderArgs = new Object[] {ecMemberRequestId, isPublic};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ECMEMBERREQUESTSTATE_WHERE);

			sb.append(_FINDER_COLUMN_VISIBILITY_ECMEMBERREQUESTID_2);

			sb.append(_FINDER_COLUMN_VISIBILITY_ISPUBLIC_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ecMemberRequestId);

				queryPos.add(isPublic);

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

	private static final String _FINDER_COLUMN_VISIBILITY_ECMEMBERREQUESTID_2 =
		"ecMemberRequestState.ecMemberRequestId = ? AND ";

	private static final String _FINDER_COLUMN_VISIBILITY_ISPUBLIC_2 =
		"ecMemberRequestState.isPublic = ?";

	public EcMemberRequestStatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"ecMemberRequestStateId", "ec_member_request_state_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdByRoleId", "created_by_role_id");
		dbColumnNames.put("ecMemberRequestId", "ec_member_request_id");
		dbColumnNames.put(
			"ecMemberRequestStatusId", "ec_member_request_status_id");
		dbColumnNames.put("isPublic", "is_public");

		setDBColumnNames(dbColumnNames);

		setModelClass(EcMemberRequestState.class);

		setModelImplClass(EcMemberRequestStateImpl.class);
		setModelPKClass(long.class);

		setTable(EcMemberRequestStateTable.INSTANCE);
	}

	/**
	 * Caches the ec member request state in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestState the ec member request state
	 */
	@Override
	public void cacheResult(EcMemberRequestState ecMemberRequestState) {
		entityCache.putResult(
			EcMemberRequestStateImpl.class,
			ecMemberRequestState.getPrimaryKey(), ecMemberRequestState);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				ecMemberRequestState.getUuid(),
				ecMemberRequestState.getGroupId()
			},
			ecMemberRequestState);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ec member request states in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStates the ec member request states
	 */
	@Override
	public void cacheResult(List<EcMemberRequestState> ecMemberRequestStates) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ecMemberRequestStates.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EcMemberRequestState ecMemberRequestState :
				ecMemberRequestStates) {

			if (entityCache.getResult(
					EcMemberRequestStateImpl.class,
					ecMemberRequestState.getPrimaryKey()) == null) {

				cacheResult(ecMemberRequestState);
			}
		}
	}

	/**
	 * Clears the cache for all ec member request states.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EcMemberRequestStateImpl.class);

		finderCache.clearCache(EcMemberRequestStateImpl.class);
	}

	/**
	 * Clears the cache for the ec member request state.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EcMemberRequestState ecMemberRequestState) {
		entityCache.removeResult(
			EcMemberRequestStateImpl.class, ecMemberRequestState);
	}

	@Override
	public void clearCache(List<EcMemberRequestState> ecMemberRequestStates) {
		for (EcMemberRequestState ecMemberRequestState :
				ecMemberRequestStates) {

			entityCache.removeResult(
				EcMemberRequestStateImpl.class, ecMemberRequestState);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EcMemberRequestStateImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EcMemberRequestStateImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EcMemberRequestStateModelImpl ecMemberRequestStateModelImpl) {

		Object[] args = new Object[] {
			ecMemberRequestStateModelImpl.getUuid(),
			ecMemberRequestStateModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ecMemberRequestStateModelImpl);
	}

	/**
	 * Creates a new ec member request state with the primary key. Does not add the ec member request state to the database.
	 *
	 * @param ecMemberRequestStateId the primary key for the new ec member request state
	 * @return the new ec member request state
	 */
	@Override
	public EcMemberRequestState create(long ecMemberRequestStateId) {
		EcMemberRequestState ecMemberRequestState =
			new EcMemberRequestStateImpl();

		ecMemberRequestState.setNew(true);
		ecMemberRequestState.setPrimaryKey(ecMemberRequestStateId);

		String uuid = _portalUUID.generate();

		ecMemberRequestState.setUuid(uuid);

		ecMemberRequestState.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ecMemberRequestState;
	}

	/**
	 * Removes the ec member request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state that was removed
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState remove(long ecMemberRequestStateId)
		throws NoSuchEcMemberRequestStateException {

		return remove((Serializable)ecMemberRequestStateId);
	}

	/**
	 * Removes the ec member request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ec member request state
	 * @return the ec member request state that was removed
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState remove(Serializable primaryKey)
		throws NoSuchEcMemberRequestStateException {

		Session session = null;

		try {
			session = openSession();

			EcMemberRequestState ecMemberRequestState =
				(EcMemberRequestState)session.get(
					EcMemberRequestStateImpl.class, primaryKey);

			if (ecMemberRequestState == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEcMemberRequestStateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ecMemberRequestState);
		}
		catch (NoSuchEcMemberRequestStateException noSuchEntityException) {
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
	protected EcMemberRequestState removeImpl(
		EcMemberRequestState ecMemberRequestState) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ecMemberRequestState)) {
				ecMemberRequestState = (EcMemberRequestState)session.get(
					EcMemberRequestStateImpl.class,
					ecMemberRequestState.getPrimaryKeyObj());
			}

			if (ecMemberRequestState != null) {
				session.delete(ecMemberRequestState);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ecMemberRequestState != null) {
			clearCache(ecMemberRequestState);
		}

		return ecMemberRequestState;
	}

	@Override
	public EcMemberRequestState updateImpl(
		EcMemberRequestState ecMemberRequestState) {

		boolean isNew = ecMemberRequestState.isNew();

		if (!(ecMemberRequestState instanceof EcMemberRequestStateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ecMemberRequestState.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ecMemberRequestState);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ecMemberRequestState proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EcMemberRequestState implementation " +
					ecMemberRequestState.getClass());
		}

		EcMemberRequestStateModelImpl ecMemberRequestStateModelImpl =
			(EcMemberRequestStateModelImpl)ecMemberRequestState;

		if (Validator.isNull(ecMemberRequestState.getUuid())) {
			String uuid = _portalUUID.generate();

			ecMemberRequestState.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ecMemberRequestState.getCreateDate() == null)) {
			if (serviceContext == null) {
				ecMemberRequestState.setCreateDate(date);
			}
			else {
				ecMemberRequestState.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!ecMemberRequestStateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ecMemberRequestState.setModifiedDate(date);
			}
			else {
				ecMemberRequestState.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ecMemberRequestState);
			}
			else {
				ecMemberRequestState = (EcMemberRequestState)session.merge(
					ecMemberRequestState);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EcMemberRequestStateImpl.class, ecMemberRequestStateModelImpl,
			false, true);

		cacheUniqueFindersCache(ecMemberRequestStateModelImpl);

		if (isNew) {
			ecMemberRequestState.setNew(false);
		}

		ecMemberRequestState.resetOriginalValues();

		return ecMemberRequestState;
	}

	/**
	 * Returns the ec member request state with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ec member request state
	 * @return the ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEcMemberRequestStateException {

		EcMemberRequestState ecMemberRequestState = fetchByPrimaryKey(
			primaryKey);

		if (ecMemberRequestState == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEcMemberRequestStateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ecMemberRequestState;
	}

	/**
	 * Returns the ec member request state with the primary key or throws a <code>NoSuchEcMemberRequestStateException</code> if it could not be found.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState findByPrimaryKey(long ecMemberRequestStateId)
		throws NoSuchEcMemberRequestStateException {

		return findByPrimaryKey((Serializable)ecMemberRequestStateId);
	}

	/**
	 * Returns the ec member request state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state, or <code>null</code> if a ec member request state with the primary key could not be found
	 */
	@Override
	public EcMemberRequestState fetchByPrimaryKey(long ecMemberRequestStateId) {
		return fetchByPrimaryKey((Serializable)ecMemberRequestStateId);
	}

	/**
	 * Returns all the ec member request states.
	 *
	 * @return the ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member request states
	 */
	@Override
	public List<EcMemberRequestState> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
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

		List<EcMemberRequestState> list = null;

		if (useFinderCache) {
			list = (List<EcMemberRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ECMEMBERREQUESTSTATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ECMEMBERREQUESTSTATE;

				sql = sql.concat(EcMemberRequestStateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EcMemberRequestState>)QueryUtil.list(
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
	 * Removes all the ec member request states from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EcMemberRequestState ecMemberRequestState : findAll()) {
			remove(ecMemberRequestState);
		}
	}

	/**
	 * Returns the number of ec member request states.
	 *
	 * @return the number of ec member request states
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
					_SQL_COUNT_ECMEMBERREQUESTSTATE);

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
		return "ec_member_request_state_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ECMEMBERREQUESTSTATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EcMemberRequestStateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ec member request state persistence.
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

		_finderPathWithPaginationFindByEcMemberRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEcMemberRequestId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ec_member_request_id"}, true);

		_finderPathWithoutPaginationFindByEcMemberRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEcMemberRequestId", new String[] {Long.class.getName()},
			new String[] {"ec_member_request_id"}, true);

		_finderPathCountByEcMemberRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEcMemberRequestId", new String[] {Long.class.getName()},
			new String[] {"ec_member_request_id"}, false);

		_finderPathWithPaginationFindByVisibility = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisibility",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"ec_member_request_id", "is_public"}, true);

		_finderPathWithoutPaginationFindByVisibility = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisibility",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"ec_member_request_id", "is_public"}, true);

		_finderPathCountByVisibility = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVisibility",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"ec_member_request_id", "is_public"}, false);

		_setEcMemberRequestStateUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEcMemberRequestStateUtilPersistence(null);

		entityCache.removeCache(EcMemberRequestStateImpl.class.getName());
	}

	private void _setEcMemberRequestStateUtilPersistence(
		EcMemberRequestStatePersistence ecMemberRequestStatePersistence) {

		try {
			Field field = EcMemberRequestStateUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, ecMemberRequestStatePersistence);
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

	private static final String _SQL_SELECT_ECMEMBERREQUESTSTATE =
		"SELECT ecMemberRequestState FROM EcMemberRequestState ecMemberRequestState";

	private static final String _SQL_SELECT_ECMEMBERREQUESTSTATE_WHERE =
		"SELECT ecMemberRequestState FROM EcMemberRequestState ecMemberRequestState WHERE ";

	private static final String _SQL_COUNT_ECMEMBERREQUESTSTATE =
		"SELECT COUNT(ecMemberRequestState) FROM EcMemberRequestState ecMemberRequestState";

	private static final String _SQL_COUNT_ECMEMBERREQUESTSTATE_WHERE =
		"SELECT COUNT(ecMemberRequestState) FROM EcMemberRequestState ecMemberRequestState WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"ecMemberRequestState.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EcMemberRequestState exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EcMemberRequestState exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EcMemberRequestStatePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "ecMemberRequestStateId", "groupId", "createdBy",
			"companyId", "createDate", "modifiedDate", "createdByRoleId",
			"ecMemberRequestId", "ecMemberRequestStatusId", "isPublic"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
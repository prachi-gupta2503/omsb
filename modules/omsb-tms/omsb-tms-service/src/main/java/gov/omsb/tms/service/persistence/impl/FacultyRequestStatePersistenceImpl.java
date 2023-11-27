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

import gov.omsb.tms.exception.NoSuchFacultyRequestStateException;
import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.model.FacultyRequestStateTable;
import gov.omsb.tms.model.impl.FacultyRequestStateImpl;
import gov.omsb.tms.model.impl.FacultyRequestStateModelImpl;
import gov.omsb.tms.service.persistence.FacultyRequestStatePersistence;
import gov.omsb.tms.service.persistence.FacultyRequestStateUtil;
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
 * The persistence implementation for the faculty request state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacultyRequestStatePersistence.class)
public class FacultyRequestStatePersistenceImpl
	extends BasePersistenceImpl<FacultyRequestState>
	implements FacultyRequestStatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacultyRequestStateUtil</code> to access the faculty request state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacultyRequestStateImpl.class.getName();

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
	 * Returns all the faculty request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
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

		List<FacultyRequestState> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequestState facultyRequestState : list) {
					if (!uuid.equals(facultyRequestState.getUuid())) {
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

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

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
				sb.append(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRequestState>)QueryUtil.list(
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
	 * Returns the first faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByUuid_First(
			String uuid,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = fetchByUuid_First(
			uuid, orderByComparator);

		if (facultyRequestState != null) {
			return facultyRequestState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRequestStateException(sb.toString());
	}

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByUuid_First(
		String uuid, OrderByComparator<FacultyRequestState> orderByComparator) {

		List<FacultyRequestState> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = fetchByUuid_Last(
			uuid, orderByComparator);

		if (facultyRequestState != null) {
			return facultyRequestState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRequestStateException(sb.toString());
	}

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByUuid_Last(
		String uuid, OrderByComparator<FacultyRequestState> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FacultyRequestState> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState[] findByUuid_PrevAndNext(
			long facultyRequestStateId, String uuid,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		uuid = Objects.toString(uuid, "");

		FacultyRequestState facultyRequestState = findByPrimaryKey(
			facultyRequestStateId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequestState[] array = new FacultyRequestStateImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, facultyRequestState, uuid, orderByComparator, true);

			array[1] = facultyRequestState;

			array[2] = getByUuid_PrevAndNext(
				session, facultyRequestState, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FacultyRequestState getByUuid_PrevAndNext(
		Session session, FacultyRequestState facultyRequestState, String uuid,
		OrderByComparator<FacultyRequestState> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

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
			sb.append(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
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
						facultyRequestState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequestState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty request states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FacultyRequestState facultyRequestState :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(facultyRequestState);
		}
	}

	/**
	 * Returns the number of faculty request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request states
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATE_WHERE);

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
		"facultyRequestState.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(facultyRequestState.uuid IS NULL OR facultyRequestState.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = fetchByUUID_G(uuid, groupId);

		if (facultyRequestState == null) {
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

			throw new NoSuchFacultyRequestStateException(sb.toString());
		}

		return facultyRequestState;
	}

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByUUID_G(
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

		if (result instanceof FacultyRequestState) {
			FacultyRequestState facultyRequestState =
				(FacultyRequestState)result;

			if (!Objects.equals(uuid, facultyRequestState.getUuid()) ||
				(groupId != facultyRequestState.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

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

				List<FacultyRequestState> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FacultyRequestState facultyRequestState = list.get(0);

					result = facultyRequestState;

					cacheResult(facultyRequestState);
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
			return (FacultyRequestState)result;
		}
	}

	/**
	 * Removes the faculty request state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request state that was removed
	 */
	@Override
	public FacultyRequestState removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = findByUUID_G(uuid, groupId);

		return remove(facultyRequestState);
	}

	/**
	 * Returns the number of faculty request states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request states
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATE_WHERE);

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
		"facultyRequestState.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(facultyRequestState.uuid IS NULL OR facultyRequestState.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"facultyRequestState.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
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

		List<FacultyRequestState> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequestState facultyRequestState : list) {
					if (!uuid.equals(facultyRequestState.getUuid()) ||
						(companyId != facultyRequestState.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

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
				sb.append(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRequestState>)QueryUtil.list(
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
	 * Returns the first faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (facultyRequestState != null) {
			return facultyRequestState;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRequestStateException(sb.toString());
	}

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		List<FacultyRequestState> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (facultyRequestState != null) {
			return facultyRequestState;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRequestStateException(sb.toString());
	}

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FacultyRequestState> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState[] findByUuid_C_PrevAndNext(
			long facultyRequestStateId, String uuid, long companyId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		uuid = Objects.toString(uuid, "");

		FacultyRequestState facultyRequestState = findByPrimaryKey(
			facultyRequestStateId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequestState[] array = new FacultyRequestStateImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, facultyRequestState, uuid, companyId,
				orderByComparator, true);

			array[1] = facultyRequestState;

			array[2] = getByUuid_C_PrevAndNext(
				session, facultyRequestState, uuid, companyId,
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

	protected FacultyRequestState getByUuid_C_PrevAndNext(
		Session session, FacultyRequestState facultyRequestState, String uuid,
		long companyId,
		OrderByComparator<FacultyRequestState> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

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
			sb.append(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
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
						facultyRequestState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequestState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty request states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FacultyRequestState facultyRequestState :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(facultyRequestState);
		}
	}

	/**
	 * Returns the number of faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request states
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATE_WHERE);

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
		"facultyRequestState.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(facultyRequestState.uuid IS NULL OR facultyRequestState.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"facultyRequestState.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByfacultyRequestId;
	private FinderPath _finderPathWithoutPaginationFindByfacultyRequestId;
	private FinderPath _finderPathCountByfacultyRequestId;

	/**
	 * Returns all the faculty request states where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId) {

		return findByfacultyRequestId(
			facultyRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end) {

		return findByfacultyRequestId(facultyRequestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return findByfacultyRequestId(
			facultyRequestId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfacultyRequestId;
				finderArgs = new Object[] {facultyRequestId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfacultyRequestId;
			finderArgs = new Object[] {
				facultyRequestId, start, end, orderByComparator
			};
		}

		List<FacultyRequestState> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequestState facultyRequestState : list) {
					if (facultyRequestId !=
							facultyRequestState.getFacultyRequestId()) {

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

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

			sb.append(_FINDER_COLUMN_FACULTYREQUESTID_FACULTYREQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyRequestId);

				list = (List<FacultyRequestState>)QueryUtil.list(
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
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByfacultyRequestId_First(
			long facultyRequestId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = fetchByfacultyRequestId_First(
			facultyRequestId, orderByComparator);

		if (facultyRequestState != null) {
			return facultyRequestState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("facultyRequestId=");
		sb.append(facultyRequestId);

		sb.append("}");

		throw new NoSuchFacultyRequestStateException(sb.toString());
	}

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByfacultyRequestId_First(
		long facultyRequestId,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		List<FacultyRequestState> list = findByfacultyRequestId(
			facultyRequestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByfacultyRequestId_Last(
			long facultyRequestId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = fetchByfacultyRequestId_Last(
			facultyRequestId, orderByComparator);

		if (facultyRequestState != null) {
			return facultyRequestState;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("facultyRequestId=");
		sb.append(facultyRequestId);

		sb.append("}");

		throw new NoSuchFacultyRequestStateException(sb.toString());
	}

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByfacultyRequestId_Last(
		long facultyRequestId,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		int count = countByfacultyRequestId(facultyRequestId);

		if (count == 0) {
			return null;
		}

		List<FacultyRequestState> list = findByfacultyRequestId(
			facultyRequestId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState[] findByfacultyRequestId_PrevAndNext(
			long facultyRequestStateId, long facultyRequestId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = findByPrimaryKey(
			facultyRequestStateId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequestState[] array = new FacultyRequestStateImpl[3];

			array[0] = getByfacultyRequestId_PrevAndNext(
				session, facultyRequestState, facultyRequestId,
				orderByComparator, true);

			array[1] = facultyRequestState;

			array[2] = getByfacultyRequestId_PrevAndNext(
				session, facultyRequestState, facultyRequestId,
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

	protected FacultyRequestState getByfacultyRequestId_PrevAndNext(
		Session session, FacultyRequestState facultyRequestState,
		long facultyRequestId,
		OrderByComparator<FacultyRequestState> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

		sb.append(_FINDER_COLUMN_FACULTYREQUESTID_FACULTYREQUESTID_2);

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
			sb.append(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(facultyRequestId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						facultyRequestState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequestState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty request states where facultyRequestId = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 */
	@Override
	public void removeByfacultyRequestId(long facultyRequestId) {
		for (FacultyRequestState facultyRequestState :
				findByfacultyRequestId(
					facultyRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(facultyRequestState);
		}
	}

	/**
	 * Returns the number of faculty request states where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the number of matching faculty request states
	 */
	@Override
	public int countByfacultyRequestId(long facultyRequestId) {
		FinderPath finderPath = _finderPathCountByfacultyRequestId;

		Object[] finderArgs = new Object[] {facultyRequestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATE_WHERE);

			sb.append(_FINDER_COLUMN_FACULTYREQUESTID_FACULTYREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyRequestId);

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
		_FINDER_COLUMN_FACULTYREQUESTID_FACULTYREQUESTID_2 =
			"facultyRequestState.facultyRequestId = ?";

	private FinderPath
		_finderPathWithPaginationFindByfacultyRequestIdAndCreatedBy;
	private FinderPath
		_finderPathWithoutPaginationFindByfacultyRequestIdAndCreatedBy;
	private FinderPath _finderPathCountByfacultyRequestIdAndCreatedBy;

	/**
	 * Returns all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @return the matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy) {

		return findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy, int start, int end) {

		return findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	@Override
	public List<FacultyRequestState> findByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByfacultyRequestIdAndCreatedBy;
				finderArgs = new Object[] {facultyRequestId, createdBy};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByfacultyRequestIdAndCreatedBy;
			finderArgs = new Object[] {
				facultyRequestId, createdBy, start, end, orderByComparator
			};
		}

		List<FacultyRequestState> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequestState facultyRequestState : list) {
					if ((facultyRequestId !=
							facultyRequestState.getFacultyRequestId()) ||
						(createdBy != facultyRequestState.getCreatedBy())) {

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

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

			sb.append(
				_FINDER_COLUMN_FACULTYREQUESTIDANDCREATEDBY_FACULTYREQUESTID_2);

			sb.append(_FINDER_COLUMN_FACULTYREQUESTIDANDCREATEDBY_CREATEDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyRequestId);

				queryPos.add(createdBy);

				list = (List<FacultyRequestState>)QueryUtil.list(
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
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByfacultyRequestIdAndCreatedBy_First(
			long facultyRequestId, long createdBy,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState =
			fetchByfacultyRequestIdAndCreatedBy_First(
				facultyRequestId, createdBy, orderByComparator);

		if (facultyRequestState != null) {
			return facultyRequestState;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("facultyRequestId=");
		sb.append(facultyRequestId);

		sb.append(", createdBy=");
		sb.append(createdBy);

		sb.append("}");

		throw new NoSuchFacultyRequestStateException(sb.toString());
	}

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByfacultyRequestIdAndCreatedBy_First(
		long facultyRequestId, long createdBy,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		List<FacultyRequestState> list = findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState findByfacultyRequestIdAndCreatedBy_Last(
			long facultyRequestId, long createdBy,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState =
			fetchByfacultyRequestIdAndCreatedBy_Last(
				facultyRequestId, createdBy, orderByComparator);

		if (facultyRequestState != null) {
			return facultyRequestState;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("facultyRequestId=");
		sb.append(facultyRequestId);

		sb.append(", createdBy=");
		sb.append(createdBy);

		sb.append("}");

		throw new NoSuchFacultyRequestStateException(sb.toString());
	}

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public FacultyRequestState fetchByfacultyRequestIdAndCreatedBy_Last(
		long facultyRequestId, long createdBy,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		int count = countByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy);

		if (count == 0) {
			return null;
		}

		List<FacultyRequestState> list = findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState[] findByfacultyRequestIdAndCreatedBy_PrevAndNext(
			long facultyRequestStateId, long facultyRequestId, long createdBy,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = findByPrimaryKey(
			facultyRequestStateId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequestState[] array = new FacultyRequestStateImpl[3];

			array[0] = getByfacultyRequestIdAndCreatedBy_PrevAndNext(
				session, facultyRequestState, facultyRequestId, createdBy,
				orderByComparator, true);

			array[1] = facultyRequestState;

			array[2] = getByfacultyRequestIdAndCreatedBy_PrevAndNext(
				session, facultyRequestState, facultyRequestId, createdBy,
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

	protected FacultyRequestState getByfacultyRequestIdAndCreatedBy_PrevAndNext(
		Session session, FacultyRequestState facultyRequestState,
		long facultyRequestId, long createdBy,
		OrderByComparator<FacultyRequestState> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUESTSTATE_WHERE);

		sb.append(
			_FINDER_COLUMN_FACULTYREQUESTIDANDCREATEDBY_FACULTYREQUESTID_2);

		sb.append(_FINDER_COLUMN_FACULTYREQUESTIDANDCREATEDBY_CREATEDBY_2);

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
			sb.append(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(facultyRequestId);

		queryPos.add(createdBy);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						facultyRequestState)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequestState> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty request states where facultyRequestId = &#63; and createdBy = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 */
	@Override
	public void removeByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy) {

		for (FacultyRequestState facultyRequestState :
				findByfacultyRequestIdAndCreatedBy(
					facultyRequestId, createdBy, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(facultyRequestState);
		}
	}

	/**
	 * Returns the number of faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @return the number of matching faculty request states
	 */
	@Override
	public int countByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy) {

		FinderPath finderPath = _finderPathCountByfacultyRequestIdAndCreatedBy;

		Object[] finderArgs = new Object[] {facultyRequestId, createdBy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATE_WHERE);

			sb.append(
				_FINDER_COLUMN_FACULTYREQUESTIDANDCREATEDBY_FACULTYREQUESTID_2);

			sb.append(_FINDER_COLUMN_FACULTYREQUESTIDANDCREATEDBY_CREATEDBY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyRequestId);

				queryPos.add(createdBy);

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
		_FINDER_COLUMN_FACULTYREQUESTIDANDCREATEDBY_FACULTYREQUESTID_2 =
			"facultyRequestState.facultyRequestId = ? AND ";

	private static final String
		_FINDER_COLUMN_FACULTYREQUESTIDANDCREATEDBY_CREATEDBY_2 =
			"facultyRequestState.createdBy = ?";

	public FacultyRequestStatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("facultyRequestStateId", "faculty_request_state_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdByRoleId", "created_by_role_id");
		dbColumnNames.put("facultyRequestId", "faculty_request_id");
		dbColumnNames.put(
			"facultyRequestStatusId", "faculty_request_status_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(FacultyRequestState.class);

		setModelImplClass(FacultyRequestStateImpl.class);
		setModelPKClass(long.class);

		setTable(FacultyRequestStateTable.INSTANCE);
	}

	/**
	 * Caches the faculty request state in the entity cache if it is enabled.
	 *
	 * @param facultyRequestState the faculty request state
	 */
	@Override
	public void cacheResult(FacultyRequestState facultyRequestState) {
		entityCache.putResult(
			FacultyRequestStateImpl.class, facultyRequestState.getPrimaryKey(),
			facultyRequestState);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				facultyRequestState.getUuid(), facultyRequestState.getGroupId()
			},
			facultyRequestState);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the faculty request states in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStates the faculty request states
	 */
	@Override
	public void cacheResult(List<FacultyRequestState> facultyRequestStates) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (facultyRequestStates.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FacultyRequestState facultyRequestState : facultyRequestStates) {
			if (entityCache.getResult(
					FacultyRequestStateImpl.class,
					facultyRequestState.getPrimaryKey()) == null) {

				cacheResult(facultyRequestState);
			}
		}
	}

	/**
	 * Clears the cache for all faculty request states.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacultyRequestStateImpl.class);

		finderCache.clearCache(FacultyRequestStateImpl.class);
	}

	/**
	 * Clears the cache for the faculty request state.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacultyRequestState facultyRequestState) {
		entityCache.removeResult(
			FacultyRequestStateImpl.class, facultyRequestState);
	}

	@Override
	public void clearCache(List<FacultyRequestState> facultyRequestStates) {
		for (FacultyRequestState facultyRequestState : facultyRequestStates) {
			entityCache.removeResult(
				FacultyRequestStateImpl.class, facultyRequestState);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FacultyRequestStateImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FacultyRequestStateImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FacultyRequestStateModelImpl facultyRequestStateModelImpl) {

		Object[] args = new Object[] {
			facultyRequestStateModelImpl.getUuid(),
			facultyRequestStateModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, facultyRequestStateModelImpl);
	}

	/**
	 * Creates a new faculty request state with the primary key. Does not add the faculty request state to the database.
	 *
	 * @param facultyRequestStateId the primary key for the new faculty request state
	 * @return the new faculty request state
	 */
	@Override
	public FacultyRequestState create(long facultyRequestStateId) {
		FacultyRequestState facultyRequestState = new FacultyRequestStateImpl();

		facultyRequestState.setNew(true);
		facultyRequestState.setPrimaryKey(facultyRequestStateId);

		String uuid = _portalUUID.generate();

		facultyRequestState.setUuid(uuid);

		facultyRequestState.setCompanyId(CompanyThreadLocal.getCompanyId());

		return facultyRequestState;
	}

	/**
	 * Removes the faculty request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state that was removed
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState remove(long facultyRequestStateId)
		throws NoSuchFacultyRequestStateException {

		return remove((Serializable)facultyRequestStateId);
	}

	/**
	 * Removes the faculty request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty request state
	 * @return the faculty request state that was removed
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState remove(Serializable primaryKey)
		throws NoSuchFacultyRequestStateException {

		Session session = null;

		try {
			session = openSession();

			FacultyRequestState facultyRequestState =
				(FacultyRequestState)session.get(
					FacultyRequestStateImpl.class, primaryKey);

			if (facultyRequestState == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyRequestStateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facultyRequestState);
		}
		catch (NoSuchFacultyRequestStateException noSuchEntityException) {
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
	protected FacultyRequestState removeImpl(
		FacultyRequestState facultyRequestState) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facultyRequestState)) {
				facultyRequestState = (FacultyRequestState)session.get(
					FacultyRequestStateImpl.class,
					facultyRequestState.getPrimaryKeyObj());
			}

			if (facultyRequestState != null) {
				session.delete(facultyRequestState);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facultyRequestState != null) {
			clearCache(facultyRequestState);
		}

		return facultyRequestState;
	}

	@Override
	public FacultyRequestState updateImpl(
		FacultyRequestState facultyRequestState) {

		boolean isNew = facultyRequestState.isNew();

		if (!(facultyRequestState instanceof FacultyRequestStateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(facultyRequestState.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					facultyRequestState);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facultyRequestState proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FacultyRequestState implementation " +
					facultyRequestState.getClass());
		}

		FacultyRequestStateModelImpl facultyRequestStateModelImpl =
			(FacultyRequestStateModelImpl)facultyRequestState;

		if (Validator.isNull(facultyRequestState.getUuid())) {
			String uuid = _portalUUID.generate();

			facultyRequestState.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (facultyRequestState.getCreateDate() == null)) {
			if (serviceContext == null) {
				facultyRequestState.setCreateDate(date);
			}
			else {
				facultyRequestState.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!facultyRequestStateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facultyRequestState.setModifiedDate(date);
			}
			else {
				facultyRequestState.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(facultyRequestState);
			}
			else {
				facultyRequestState = (FacultyRequestState)session.merge(
					facultyRequestState);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FacultyRequestStateImpl.class, facultyRequestStateModelImpl, false,
			true);

		cacheUniqueFindersCache(facultyRequestStateModelImpl);

		if (isNew) {
			facultyRequestState.setNew(false);
		}

		facultyRequestState.resetOriginalValues();

		return facultyRequestState;
	}

	/**
	 * Returns the faculty request state with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty request state
	 * @return the faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacultyRequestStateException {

		FacultyRequestState facultyRequestState = fetchByPrimaryKey(primaryKey);

		if (facultyRequestState == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyRequestStateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facultyRequestState;
	}

	/**
	 * Returns the faculty request state with the primary key or throws a <code>NoSuchFacultyRequestStateException</code> if it could not be found.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState findByPrimaryKey(long facultyRequestStateId)
		throws NoSuchFacultyRequestStateException {

		return findByPrimaryKey((Serializable)facultyRequestStateId);
	}

	/**
	 * Returns the faculty request state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state, or <code>null</code> if a faculty request state with the primary key could not be found
	 */
	@Override
	public FacultyRequestState fetchByPrimaryKey(long facultyRequestStateId) {
		return fetchByPrimaryKey((Serializable)facultyRequestStateId);
	}

	/**
	 * Returns all the faculty request states.
	 *
	 * @return the faculty request states
	 */
	@Override
	public List<FacultyRequestState> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of faculty request states
	 */
	@Override
	public List<FacultyRequestState> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request states
	 */
	@Override
	public List<FacultyRequestState> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request states
	 */
	@Override
	public List<FacultyRequestState> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
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

		List<FacultyRequestState> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestState>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FACULTYREQUESTSTATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTYREQUESTSTATE;

				sql = sql.concat(FacultyRequestStateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FacultyRequestState>)QueryUtil.list(
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
	 * Removes all the faculty request states from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FacultyRequestState facultyRequestState : findAll()) {
			remove(facultyRequestState);
		}
	}

	/**
	 * Returns the number of faculty request states.
	 *
	 * @return the number of faculty request states
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
					_SQL_COUNT_FACULTYREQUESTSTATE);

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
		return "faculty_request_state_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACULTYREQUESTSTATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacultyRequestStateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faculty request state persistence.
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

		_finderPathWithPaginationFindByfacultyRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfacultyRequestId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"faculty_request_id"}, true);

		_finderPathWithoutPaginationFindByfacultyRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfacultyRequestId",
			new String[] {Long.class.getName()},
			new String[] {"faculty_request_id"}, true);

		_finderPathCountByfacultyRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfacultyRequestId", new String[] {Long.class.getName()},
			new String[] {"faculty_request_id"}, false);

		_finderPathWithPaginationFindByfacultyRequestIdAndCreatedBy =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByfacultyRequestIdAndCreatedBy",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"faculty_request_id", "created_by"}, true);

		_finderPathWithoutPaginationFindByfacultyRequestIdAndCreatedBy =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByfacultyRequestIdAndCreatedBy",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"faculty_request_id", "created_by"}, true);

		_finderPathCountByfacultyRequestIdAndCreatedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfacultyRequestIdAndCreatedBy",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"faculty_request_id", "created_by"}, false);

		_setFacultyRequestStateUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFacultyRequestStateUtilPersistence(null);

		entityCache.removeCache(FacultyRequestStateImpl.class.getName());
	}

	private void _setFacultyRequestStateUtilPersistence(
		FacultyRequestStatePersistence facultyRequestStatePersistence) {

		try {
			Field field = FacultyRequestStateUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, facultyRequestStatePersistence);
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

	private static final String _SQL_SELECT_FACULTYREQUESTSTATE =
		"SELECT facultyRequestState FROM FacultyRequestState facultyRequestState";

	private static final String _SQL_SELECT_FACULTYREQUESTSTATE_WHERE =
		"SELECT facultyRequestState FROM FacultyRequestState facultyRequestState WHERE ";

	private static final String _SQL_COUNT_FACULTYREQUESTSTATE =
		"SELECT COUNT(facultyRequestState) FROM FacultyRequestState facultyRequestState";

	private static final String _SQL_COUNT_FACULTYREQUESTSTATE_WHERE =
		"SELECT COUNT(facultyRequestState) FROM FacultyRequestState facultyRequestState WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "facultyRequestState.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FacultyRequestState exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FacultyRequestState exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FacultyRequestStatePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "facultyRequestStateId", "groupId", "companyId",
			"createdBy", "createDate", "modifiedDate", "createdByRoleId",
			"facultyRequestId", "facultyRequestStatusId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
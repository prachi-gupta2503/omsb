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

import gov.omsb.tms.exception.NoSuchFacultyRequestException;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.model.FacultyRequestTable;
import gov.omsb.tms.model.impl.FacultyRequestImpl;
import gov.omsb.tms.model.impl.FacultyRequestModelImpl;
import gov.omsb.tms.service.persistence.FacultyRequestPersistence;
import gov.omsb.tms.service.persistence.FacultyRequestUtil;
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
 * The persistence implementation for the faculty request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacultyRequestPersistence.class)
public class FacultyRequestPersistenceImpl
	extends BasePersistenceImpl<FacultyRequest>
	implements FacultyRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacultyRequestUtil</code> to access the faculty request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacultyRequestImpl.class.getName();

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
	 * Returns all the faculty requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty requests
	 */
	@Override
	public List<FacultyRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @return the range of matching faculty requests
	 */
	@Override
	public List<FacultyRequest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty requests
	 */
	@Override
	public List<FacultyRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty requests
	 */
	@Override
	public List<FacultyRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequest> orderByComparator,
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

		List<FacultyRequest> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequest facultyRequest : list) {
					if (!uuid.equals(facultyRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_FACULTYREQUEST_WHERE);

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
				sb.append(FacultyRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRequest>)QueryUtil.list(
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
	 * Returns the first faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest findByUuid_First(
			String uuid, OrderByComparator<FacultyRequest> orderByComparator)
		throws NoSuchFacultyRequestException {

		FacultyRequest facultyRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (facultyRequest != null) {
			return facultyRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRequestException(sb.toString());
	}

	/**
	 * Returns the first faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest fetchByUuid_First(
		String uuid, OrderByComparator<FacultyRequest> orderByComparator) {

		List<FacultyRequest> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest findByUuid_Last(
			String uuid, OrderByComparator<FacultyRequest> orderByComparator)
		throws NoSuchFacultyRequestException {

		FacultyRequest facultyRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (facultyRequest != null) {
			return facultyRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRequestException(sb.toString());
	}

	/**
	 * Returns the last faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest fetchByUuid_Last(
		String uuid, OrderByComparator<FacultyRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FacultyRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty requests before and after the current faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestId the primary key of the current faculty request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	@Override
	public FacultyRequest[] findByUuid_PrevAndNext(
			long facultyRequestId, String uuid,
			OrderByComparator<FacultyRequest> orderByComparator)
		throws NoSuchFacultyRequestException {

		uuid = Objects.toString(uuid, "");

		FacultyRequest facultyRequest = findByPrimaryKey(facultyRequestId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequest[] array = new FacultyRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, facultyRequest, uuid, orderByComparator, true);

			array[1] = facultyRequest;

			array[2] = getByUuid_PrevAndNext(
				session, facultyRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FacultyRequest getByUuid_PrevAndNext(
		Session session, FacultyRequest facultyRequest, String uuid,
		OrderByComparator<FacultyRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FACULTYREQUEST_WHERE);

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
			sb.append(FacultyRequestModelImpl.ORDER_BY_JPQL);
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
						facultyRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FacultyRequest facultyRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(facultyRequest);
		}
	}

	/**
	 * Returns the number of faculty requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYREQUEST_WHERE);

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
		"facultyRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(facultyRequest.uuid IS NULL OR facultyRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the faculty request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestException {

		FacultyRequest facultyRequest = fetchByUUID_G(uuid, groupId);

		if (facultyRequest == null) {
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

			throw new NoSuchFacultyRequestException(sb.toString());
		}

		return facultyRequest;
	}

	/**
	 * Returns the faculty request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the faculty request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest fetchByUUID_G(
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

		if (result instanceof FacultyRequest) {
			FacultyRequest facultyRequest = (FacultyRequest)result;

			if (!Objects.equals(uuid, facultyRequest.getUuid()) ||
				(groupId != facultyRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FACULTYREQUEST_WHERE);

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

				List<FacultyRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FacultyRequest facultyRequest = list.get(0);

					result = facultyRequest;

					cacheResult(facultyRequest);
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
			return (FacultyRequest)result;
		}
	}

	/**
	 * Removes the faculty request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request that was removed
	 */
	@Override
	public FacultyRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestException {

		FacultyRequest facultyRequest = findByUUID_G(uuid, groupId);

		return remove(facultyRequest);
	}

	/**
	 * Returns the number of faculty requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUEST_WHERE);

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
		"facultyRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(facultyRequest.uuid IS NULL OR facultyRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"facultyRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty requests
	 */
	@Override
	public List<FacultyRequest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @return the range of matching faculty requests
	 */
	@Override
	public List<FacultyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty requests
	 */
	@Override
	public List<FacultyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty requests
	 */
	@Override
	public List<FacultyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequest> orderByComparator,
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

		List<FacultyRequest> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequest facultyRequest : list) {
					if (!uuid.equals(facultyRequest.getUuid()) ||
						(companyId != facultyRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FACULTYREQUEST_WHERE);

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
				sb.append(FacultyRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRequest>)QueryUtil.list(
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
	 * Returns the first faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRequest> orderByComparator)
		throws NoSuchFacultyRequestException {

		FacultyRequest facultyRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (facultyRequest != null) {
			return facultyRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRequestException(sb.toString());
	}

	/**
	 * Returns the first faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRequest> orderByComparator) {

		List<FacultyRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRequest> orderByComparator)
		throws NoSuchFacultyRequestException {

		FacultyRequest facultyRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (facultyRequest != null) {
			return facultyRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRequestException(sb.toString());
	}

	/**
	 * Returns the last faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	@Override
	public FacultyRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FacultyRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty requests before and after the current faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestId the primary key of the current faculty request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	@Override
	public FacultyRequest[] findByUuid_C_PrevAndNext(
			long facultyRequestId, String uuid, long companyId,
			OrderByComparator<FacultyRequest> orderByComparator)
		throws NoSuchFacultyRequestException {

		uuid = Objects.toString(uuid, "");

		FacultyRequest facultyRequest = findByPrimaryKey(facultyRequestId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequest[] array = new FacultyRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, facultyRequest, uuid, companyId, orderByComparator,
				true);

			array[1] = facultyRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, facultyRequest, uuid, companyId, orderByComparator,
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

	protected FacultyRequest getByUuid_C_PrevAndNext(
		Session session, FacultyRequest facultyRequest, String uuid,
		long companyId, OrderByComparator<FacultyRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUEST_WHERE);

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
			sb.append(FacultyRequestModelImpl.ORDER_BY_JPQL);
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
						facultyRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FacultyRequest facultyRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(facultyRequest);
		}
	}

	/**
	 * Returns the number of faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUEST_WHERE);

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
		"facultyRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(facultyRequest.uuid IS NULL OR facultyRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"facultyRequest.companyId = ?";

	public FacultyRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("facultyRequestId", "faculty_request_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put("potentialFacultyId", "potential_faculty_id");
		dbColumnNames.put(
			"potentialFacultyTypeId", "potential_faculty_type_id");
		dbColumnNames.put(
			"lastestFacultyRequestStateId", "lastest_faculty_request_state_id");
		dbColumnNames.put("coveringLetterId", "covering_letter_id");
		dbColumnNames.put("cvId", "cv_id");
		dbColumnNames.put("passportCopyId", "passport_copy_id");
		dbColumnNames.put("notionalIdCopyId", "notional_id_copy_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(FacultyRequest.class);

		setModelImplClass(FacultyRequestImpl.class);
		setModelPKClass(long.class);

		setTable(FacultyRequestTable.INSTANCE);
	}

	/**
	 * Caches the faculty request in the entity cache if it is enabled.
	 *
	 * @param facultyRequest the faculty request
	 */
	@Override
	public void cacheResult(FacultyRequest facultyRequest) {
		entityCache.putResult(
			FacultyRequestImpl.class, facultyRequest.getPrimaryKey(),
			facultyRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				facultyRequest.getUuid(), facultyRequest.getGroupId()
			},
			facultyRequest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the faculty requests in the entity cache if it is enabled.
	 *
	 * @param facultyRequests the faculty requests
	 */
	@Override
	public void cacheResult(List<FacultyRequest> facultyRequests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (facultyRequests.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FacultyRequest facultyRequest : facultyRequests) {
			if (entityCache.getResult(
					FacultyRequestImpl.class, facultyRequest.getPrimaryKey()) ==
						null) {

				cacheResult(facultyRequest);
			}
		}
	}

	/**
	 * Clears the cache for all faculty requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacultyRequestImpl.class);

		finderCache.clearCache(FacultyRequestImpl.class);
	}

	/**
	 * Clears the cache for the faculty request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacultyRequest facultyRequest) {
		entityCache.removeResult(FacultyRequestImpl.class, facultyRequest);
	}

	@Override
	public void clearCache(List<FacultyRequest> facultyRequests) {
		for (FacultyRequest facultyRequest : facultyRequests) {
			entityCache.removeResult(FacultyRequestImpl.class, facultyRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FacultyRequestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FacultyRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FacultyRequestModelImpl facultyRequestModelImpl) {

		Object[] args = new Object[] {
			facultyRequestModelImpl.getUuid(),
			facultyRequestModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, facultyRequestModelImpl);
	}

	/**
	 * Creates a new faculty request with the primary key. Does not add the faculty request to the database.
	 *
	 * @param facultyRequestId the primary key for the new faculty request
	 * @return the new faculty request
	 */
	@Override
	public FacultyRequest create(long facultyRequestId) {
		FacultyRequest facultyRequest = new FacultyRequestImpl();

		facultyRequest.setNew(true);
		facultyRequest.setPrimaryKey(facultyRequestId);

		String uuid = _portalUUID.generate();

		facultyRequest.setUuid(uuid);

		facultyRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return facultyRequest;
	}

	/**
	 * Removes the faculty request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request that was removed
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	@Override
	public FacultyRequest remove(long facultyRequestId)
		throws NoSuchFacultyRequestException {

		return remove((Serializable)facultyRequestId);
	}

	/**
	 * Removes the faculty request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty request
	 * @return the faculty request that was removed
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	@Override
	public FacultyRequest remove(Serializable primaryKey)
		throws NoSuchFacultyRequestException {

		Session session = null;

		try {
			session = openSession();

			FacultyRequest facultyRequest = (FacultyRequest)session.get(
				FacultyRequestImpl.class, primaryKey);

			if (facultyRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facultyRequest);
		}
		catch (NoSuchFacultyRequestException noSuchEntityException) {
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
	protected FacultyRequest removeImpl(FacultyRequest facultyRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facultyRequest)) {
				facultyRequest = (FacultyRequest)session.get(
					FacultyRequestImpl.class,
					facultyRequest.getPrimaryKeyObj());
			}

			if (facultyRequest != null) {
				session.delete(facultyRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facultyRequest != null) {
			clearCache(facultyRequest);
		}

		return facultyRequest;
	}

	@Override
	public FacultyRequest updateImpl(FacultyRequest facultyRequest) {
		boolean isNew = facultyRequest.isNew();

		if (!(facultyRequest instanceof FacultyRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(facultyRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					facultyRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facultyRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FacultyRequest implementation " +
					facultyRequest.getClass());
		}

		FacultyRequestModelImpl facultyRequestModelImpl =
			(FacultyRequestModelImpl)facultyRequest;

		if (Validator.isNull(facultyRequest.getUuid())) {
			String uuid = _portalUUID.generate();

			facultyRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (facultyRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				facultyRequest.setCreateDate(date);
			}
			else {
				facultyRequest.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!facultyRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facultyRequest.setModifiedDate(date);
			}
			else {
				facultyRequest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(facultyRequest);
			}
			else {
				facultyRequest = (FacultyRequest)session.merge(facultyRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FacultyRequestImpl.class, facultyRequestModelImpl, false, true);

		cacheUniqueFindersCache(facultyRequestModelImpl);

		if (isNew) {
			facultyRequest.setNew(false);
		}

		facultyRequest.resetOriginalValues();

		return facultyRequest;
	}

	/**
	 * Returns the faculty request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty request
	 * @return the faculty request
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	@Override
	public FacultyRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacultyRequestException {

		FacultyRequest facultyRequest = fetchByPrimaryKey(primaryKey);

		if (facultyRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facultyRequest;
	}

	/**
	 * Returns the faculty request with the primary key or throws a <code>NoSuchFacultyRequestException</code> if it could not be found.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	@Override
	public FacultyRequest findByPrimaryKey(long facultyRequestId)
		throws NoSuchFacultyRequestException {

		return findByPrimaryKey((Serializable)facultyRequestId);
	}

	/**
	 * Returns the faculty request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request, or <code>null</code> if a faculty request with the primary key could not be found
	 */
	@Override
	public FacultyRequest fetchByPrimaryKey(long facultyRequestId) {
		return fetchByPrimaryKey((Serializable)facultyRequestId);
	}

	/**
	 * Returns all the faculty requests.
	 *
	 * @return the faculty requests
	 */
	@Override
	public List<FacultyRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @return the range of faculty requests
	 */
	@Override
	public List<FacultyRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty requests
	 */
	@Override
	public List<FacultyRequest> findAll(
		int start, int end,
		OrderByComparator<FacultyRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty requests
	 */
	@Override
	public List<FacultyRequest> findAll(
		int start, int end, OrderByComparator<FacultyRequest> orderByComparator,
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

		List<FacultyRequest> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FACULTYREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTYREQUEST;

				sql = sql.concat(FacultyRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FacultyRequest>)QueryUtil.list(
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
	 * Removes all the faculty requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FacultyRequest facultyRequest : findAll()) {
			remove(facultyRequest);
		}
	}

	/**
	 * Returns the number of faculty requests.
	 *
	 * @return the number of faculty requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FACULTYREQUEST);

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
		return "faculty_request_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACULTYREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacultyRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faculty request persistence.
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

		_setFacultyRequestUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFacultyRequestUtilPersistence(null);

		entityCache.removeCache(FacultyRequestImpl.class.getName());
	}

	private void _setFacultyRequestUtilPersistence(
		FacultyRequestPersistence facultyRequestPersistence) {

		try {
			Field field = FacultyRequestUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, facultyRequestPersistence);
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

	private static final String _SQL_SELECT_FACULTYREQUEST =
		"SELECT facultyRequest FROM FacultyRequest facultyRequest";

	private static final String _SQL_SELECT_FACULTYREQUEST_WHERE =
		"SELECT facultyRequest FROM FacultyRequest facultyRequest WHERE ";

	private static final String _SQL_COUNT_FACULTYREQUEST =
		"SELECT COUNT(facultyRequest) FROM FacultyRequest facultyRequest";

	private static final String _SQL_COUNT_FACULTYREQUEST_WHERE =
		"SELECT COUNT(facultyRequest) FROM FacultyRequest facultyRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "facultyRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FacultyRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FacultyRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FacultyRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "facultyRequestId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "programId",
			"potentialFacultyId", "potentialFacultyTypeId",
			"lastestFacultyRequestStateId", "coveringLetterId", "cvId",
			"passportCopyId", "notionalIdCopyId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchFacultyRequestStatusException;
import gov.omsb.tms.model.FacultyRequestStatus;
import gov.omsb.tms.model.FacultyRequestStatusTable;
import gov.omsb.tms.model.impl.FacultyRequestStatusImpl;
import gov.omsb.tms.model.impl.FacultyRequestStatusModelImpl;
import gov.omsb.tms.service.persistence.FacultyRequestStatusPersistence;
import gov.omsb.tms.service.persistence.FacultyRequestStatusUtil;
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
 * The persistence implementation for the faculty request status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacultyRequestStatusPersistence.class)
public class FacultyRequestStatusPersistenceImpl
	extends BasePersistenceImpl<FacultyRequestStatus>
	implements FacultyRequestStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacultyRequestStatusUtil</code> to access the faculty request status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacultyRequestStatusImpl.class.getName();

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
	 * Returns all the faculty request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of matching faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator,
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

		List<FacultyRequestStatus> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequestStatus facultyRequestStatus : list) {
					if (!uuid.equals(facultyRequestStatus.getUuid())) {
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

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATUS_WHERE);

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
				sb.append(FacultyRequestStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRequestStatus>)QueryUtil.list(
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
	 * Returns the first faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus findByUuid_First(
			String uuid,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = fetchByUuid_First(
			uuid, orderByComparator);

		if (facultyRequestStatus != null) {
			return facultyRequestStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRequestStatusException(sb.toString());
	}

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByUuid_First(
		String uuid,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		List<FacultyRequestStatus> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = fetchByUuid_Last(
			uuid, orderByComparator);

		if (facultyRequestStatus != null) {
			return facultyRequestStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRequestStatusException(sb.toString());
	}

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByUuid_Last(
		String uuid,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FacultyRequestStatus> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty request statuses before and after the current faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestStatusId the primary key of the current faculty request status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	@Override
	public FacultyRequestStatus[] findByUuid_PrevAndNext(
			long facultyRequestStatusId, String uuid,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException {

		uuid = Objects.toString(uuid, "");

		FacultyRequestStatus facultyRequestStatus = findByPrimaryKey(
			facultyRequestStatusId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequestStatus[] array = new FacultyRequestStatusImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, facultyRequestStatus, uuid, orderByComparator, true);

			array[1] = facultyRequestStatus;

			array[2] = getByUuid_PrevAndNext(
				session, facultyRequestStatus, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FacultyRequestStatus getByUuid_PrevAndNext(
		Session session, FacultyRequestStatus facultyRequestStatus, String uuid,
		OrderByComparator<FacultyRequestStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUESTSTATUS_WHERE);

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
			sb.append(FacultyRequestStatusModelImpl.ORDER_BY_JPQL);
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
						facultyRequestStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequestStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty request statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FacultyRequestStatus facultyRequestStatus :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(facultyRequestStatus);
		}
	}

	/**
	 * Returns the number of faculty request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request statuses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATUS_WHERE);

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
		"facultyRequestStatus.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(facultyRequestStatus.uuid IS NULL OR facultyRequestStatus.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = fetchByUUID_G(
			uuid, groupId);

		if (facultyRequestStatus == null) {
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

			throw new NoSuchFacultyRequestStatusException(sb.toString());
		}

		return facultyRequestStatus;
	}

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByUUID_G(
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

		if (result instanceof FacultyRequestStatus) {
			FacultyRequestStatus facultyRequestStatus =
				(FacultyRequestStatus)result;

			if (!Objects.equals(uuid, facultyRequestStatus.getUuid()) ||
				(groupId != facultyRequestStatus.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATUS_WHERE);

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

				List<FacultyRequestStatus> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FacultyRequestStatus facultyRequestStatus = list.get(0);

					result = facultyRequestStatus;

					cacheResult(facultyRequestStatus);
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
			return (FacultyRequestStatus)result;
		}
	}

	/**
	 * Removes the faculty request status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request status that was removed
	 */
	@Override
	public FacultyRequestStatus removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = findByUUID_G(uuid, groupId);

		return remove(facultyRequestStatus);
	}

	/**
	 * Returns the number of faculty request statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request statuses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATUS_WHERE);

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
		"facultyRequestStatus.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(facultyRequestStatus.uuid IS NULL OR facultyRequestStatus.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"facultyRequestStatus.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of matching faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator,
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

		List<FacultyRequestStatus> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequestStatus facultyRequestStatus : list) {
					if (!uuid.equals(facultyRequestStatus.getUuid()) ||
						(companyId != facultyRequestStatus.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATUS_WHERE);

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
				sb.append(FacultyRequestStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRequestStatus>)QueryUtil.list(
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
	 * Returns the first faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (facultyRequestStatus != null) {
			return facultyRequestStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRequestStatusException(sb.toString());
	}

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		List<FacultyRequestStatus> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (facultyRequestStatus != null) {
			return facultyRequestStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRequestStatusException(sb.toString());
	}

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FacultyRequestStatus> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty request statuses before and after the current faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestStatusId the primary key of the current faculty request status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	@Override
	public FacultyRequestStatus[] findByUuid_C_PrevAndNext(
			long facultyRequestStatusId, String uuid, long companyId,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException {

		uuid = Objects.toString(uuid, "");

		FacultyRequestStatus facultyRequestStatus = findByPrimaryKey(
			facultyRequestStatusId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequestStatus[] array = new FacultyRequestStatusImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, facultyRequestStatus, uuid, companyId,
				orderByComparator, true);

			array[1] = facultyRequestStatus;

			array[2] = getByUuid_C_PrevAndNext(
				session, facultyRequestStatus, uuid, companyId,
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

	protected FacultyRequestStatus getByUuid_C_PrevAndNext(
		Session session, FacultyRequestStatus facultyRequestStatus, String uuid,
		long companyId,
		OrderByComparator<FacultyRequestStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUESTSTATUS_WHERE);

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
			sb.append(FacultyRequestStatusModelImpl.ORDER_BY_JPQL);
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
						facultyRequestStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequestStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty request statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FacultyRequestStatus facultyRequestStatus :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(facultyRequestStatus);
		}
	}

	/**
	 * Returns the number of faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request statuses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATUS_WHERE);

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
		"facultyRequestStatus.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(facultyRequestStatus.uuid IS NULL OR facultyRequestStatus.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"facultyRequestStatus.companyId = ?";

	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the faculty request status where code = &#63; or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus findByCode(String code)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = fetchByCode(code);

		if (facultyRequestStatus == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFacultyRequestStatusException(sb.toString());
		}

		return facultyRequestStatus;
	}

	/**
	 * Returns the faculty request status where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByCode(String code) {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the faculty request status where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByCode(
		String code, boolean useFinderCache) {

		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCode, finderArgs, this);
		}

		if (result instanceof FacultyRequestStatus) {
			FacultyRequestStatus facultyRequestStatus =
				(FacultyRequestStatus)result;

			if (!Objects.equals(code, facultyRequestStatus.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FACULTYREQUESTSTATUS_WHERE);

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

				List<FacultyRequestStatus> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {code};
							}

							_log.warn(
								"FacultyRequestStatusPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FacultyRequestStatus facultyRequestStatus = list.get(0);

					result = facultyRequestStatus;

					cacheResult(facultyRequestStatus);
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
			return (FacultyRequestStatus)result;
		}
	}

	/**
	 * Removes the faculty request status where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the faculty request status that was removed
	 */
	@Override
	public FacultyRequestStatus removeByCode(String code)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = findByCode(code);

		return remove(facultyRequestStatus);
	}

	/**
	 * Returns the number of faculty request statuses where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching faculty request statuses
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYREQUESTSTATUS_WHERE);

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
		"lower(facultyRequestStatus.code) = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(facultyRequestStatus.code IS NULL OR facultyRequestStatus.code = '')";

	public FacultyRequestStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"facultyRequestStatusId", "faculty_request_status_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("nameEn", "name_en");
		dbColumnNames.put("nameAr", "name_ar");

		setDBColumnNames(dbColumnNames);

		setModelClass(FacultyRequestStatus.class);

		setModelImplClass(FacultyRequestStatusImpl.class);
		setModelPKClass(long.class);

		setTable(FacultyRequestStatusTable.INSTANCE);
	}

	/**
	 * Caches the faculty request status in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStatus the faculty request status
	 */
	@Override
	public void cacheResult(FacultyRequestStatus facultyRequestStatus) {
		entityCache.putResult(
			FacultyRequestStatusImpl.class,
			facultyRequestStatus.getPrimaryKey(), facultyRequestStatus);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				facultyRequestStatus.getUuid(),
				facultyRequestStatus.getGroupId()
			},
			facultyRequestStatus);

		finderCache.putResult(
			_finderPathFetchByCode,
			new Object[] {facultyRequestStatus.getCode()},
			facultyRequestStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the faculty request statuses in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStatuses the faculty request statuses
	 */
	@Override
	public void cacheResult(List<FacultyRequestStatus> facultyRequestStatuses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (facultyRequestStatuses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FacultyRequestStatus facultyRequestStatus :
				facultyRequestStatuses) {

			if (entityCache.getResult(
					FacultyRequestStatusImpl.class,
					facultyRequestStatus.getPrimaryKey()) == null) {

				cacheResult(facultyRequestStatus);
			}
		}
	}

	/**
	 * Clears the cache for all faculty request statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacultyRequestStatusImpl.class);

		finderCache.clearCache(FacultyRequestStatusImpl.class);
	}

	/**
	 * Clears the cache for the faculty request status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacultyRequestStatus facultyRequestStatus) {
		entityCache.removeResult(
			FacultyRequestStatusImpl.class, facultyRequestStatus);
	}

	@Override
	public void clearCache(List<FacultyRequestStatus> facultyRequestStatuses) {
		for (FacultyRequestStatus facultyRequestStatus :
				facultyRequestStatuses) {

			entityCache.removeResult(
				FacultyRequestStatusImpl.class, facultyRequestStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FacultyRequestStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				FacultyRequestStatusImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FacultyRequestStatusModelImpl facultyRequestStatusModelImpl) {

		Object[] args = new Object[] {
			facultyRequestStatusModelImpl.getUuid(),
			facultyRequestStatusModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, facultyRequestStatusModelImpl);

		args = new Object[] {facultyRequestStatusModelImpl.getCode()};

		finderCache.putResult(_finderPathCountByCode, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCode, args, facultyRequestStatusModelImpl);
	}

	/**
	 * Creates a new faculty request status with the primary key. Does not add the faculty request status to the database.
	 *
	 * @param facultyRequestStatusId the primary key for the new faculty request status
	 * @return the new faculty request status
	 */
	@Override
	public FacultyRequestStatus create(long facultyRequestStatusId) {
		FacultyRequestStatus facultyRequestStatus =
			new FacultyRequestStatusImpl();

		facultyRequestStatus.setNew(true);
		facultyRequestStatus.setPrimaryKey(facultyRequestStatusId);

		String uuid = _portalUUID.generate();

		facultyRequestStatus.setUuid(uuid);

		facultyRequestStatus.setCompanyId(CompanyThreadLocal.getCompanyId());

		return facultyRequestStatus;
	}

	/**
	 * Removes the faculty request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status that was removed
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	@Override
	public FacultyRequestStatus remove(long facultyRequestStatusId)
		throws NoSuchFacultyRequestStatusException {

		return remove((Serializable)facultyRequestStatusId);
	}

	/**
	 * Removes the faculty request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty request status
	 * @return the faculty request status that was removed
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	@Override
	public FacultyRequestStatus remove(Serializable primaryKey)
		throws NoSuchFacultyRequestStatusException {

		Session session = null;

		try {
			session = openSession();

			FacultyRequestStatus facultyRequestStatus =
				(FacultyRequestStatus)session.get(
					FacultyRequestStatusImpl.class, primaryKey);

			if (facultyRequestStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyRequestStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facultyRequestStatus);
		}
		catch (NoSuchFacultyRequestStatusException noSuchEntityException) {
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
	protected FacultyRequestStatus removeImpl(
		FacultyRequestStatus facultyRequestStatus) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facultyRequestStatus)) {
				facultyRequestStatus = (FacultyRequestStatus)session.get(
					FacultyRequestStatusImpl.class,
					facultyRequestStatus.getPrimaryKeyObj());
			}

			if (facultyRequestStatus != null) {
				session.delete(facultyRequestStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facultyRequestStatus != null) {
			clearCache(facultyRequestStatus);
		}

		return facultyRequestStatus;
	}

	@Override
	public FacultyRequestStatus updateImpl(
		FacultyRequestStatus facultyRequestStatus) {

		boolean isNew = facultyRequestStatus.isNew();

		if (!(facultyRequestStatus instanceof FacultyRequestStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(facultyRequestStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					facultyRequestStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facultyRequestStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FacultyRequestStatus implementation " +
					facultyRequestStatus.getClass());
		}

		FacultyRequestStatusModelImpl facultyRequestStatusModelImpl =
			(FacultyRequestStatusModelImpl)facultyRequestStatus;

		if (Validator.isNull(facultyRequestStatus.getUuid())) {
			String uuid = _portalUUID.generate();

			facultyRequestStatus.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (facultyRequestStatus.getCreateDate() == null)) {
			if (serviceContext == null) {
				facultyRequestStatus.setCreateDate(date);
			}
			else {
				facultyRequestStatus.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!facultyRequestStatusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facultyRequestStatus.setModifiedDate(date);
			}
			else {
				facultyRequestStatus.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(facultyRequestStatus);
			}
			else {
				facultyRequestStatus = (FacultyRequestStatus)session.merge(
					facultyRequestStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FacultyRequestStatusImpl.class, facultyRequestStatusModelImpl,
			false, true);

		cacheUniqueFindersCache(facultyRequestStatusModelImpl);

		if (isNew) {
			facultyRequestStatus.setNew(false);
		}

		facultyRequestStatus.resetOriginalValues();

		return facultyRequestStatus;
	}

	/**
	 * Returns the faculty request status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty request status
	 * @return the faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	@Override
	public FacultyRequestStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacultyRequestStatusException {

		FacultyRequestStatus facultyRequestStatus = fetchByPrimaryKey(
			primaryKey);

		if (facultyRequestStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyRequestStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facultyRequestStatus;
	}

	/**
	 * Returns the faculty request status with the primary key or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	@Override
	public FacultyRequestStatus findByPrimaryKey(long facultyRequestStatusId)
		throws NoSuchFacultyRequestStatusException {

		return findByPrimaryKey((Serializable)facultyRequestStatusId);
	}

	/**
	 * Returns the faculty request status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status, or <code>null</code> if a faculty request status with the primary key could not be found
	 */
	@Override
	public FacultyRequestStatus fetchByPrimaryKey(long facultyRequestStatusId) {
		return fetchByPrimaryKey((Serializable)facultyRequestStatusId);
	}

	/**
	 * Returns all the faculty request statuses.
	 *
	 * @return the faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request statuses
	 */
	@Override
	public List<FacultyRequestStatus> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator,
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

		List<FacultyRequestStatus> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestStatus>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FACULTYREQUESTSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTYREQUESTSTATUS;

				sql = sql.concat(FacultyRequestStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FacultyRequestStatus>)QueryUtil.list(
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
	 * Removes all the faculty request statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FacultyRequestStatus facultyRequestStatus : findAll()) {
			remove(facultyRequestStatus);
		}
	}

	/**
	 * Returns the number of faculty request statuses.
	 *
	 * @return the number of faculty request statuses
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
					_SQL_COUNT_FACULTYREQUESTSTATUS);

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
		return "faculty_request_status_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACULTYREQUESTSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacultyRequestStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faculty request status persistence.
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

		_finderPathFetchByCode = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()}, new String[] {"code"}, true);

		_finderPathCountByCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()}, new String[] {"code"},
			false);

		_setFacultyRequestStatusUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFacultyRequestStatusUtilPersistence(null);

		entityCache.removeCache(FacultyRequestStatusImpl.class.getName());
	}

	private void _setFacultyRequestStatusUtilPersistence(
		FacultyRequestStatusPersistence facultyRequestStatusPersistence) {

		try {
			Field field = FacultyRequestStatusUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, facultyRequestStatusPersistence);
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

	private static final String _SQL_SELECT_FACULTYREQUESTSTATUS =
		"SELECT facultyRequestStatus FROM FacultyRequestStatus facultyRequestStatus";

	private static final String _SQL_SELECT_FACULTYREQUESTSTATUS_WHERE =
		"SELECT facultyRequestStatus FROM FacultyRequestStatus facultyRequestStatus WHERE ";

	private static final String _SQL_COUNT_FACULTYREQUESTSTATUS =
		"SELECT COUNT(facultyRequestStatus) FROM FacultyRequestStatus facultyRequestStatus";

	private static final String _SQL_COUNT_FACULTYREQUESTSTATUS_WHERE =
		"SELECT COUNT(facultyRequestStatus) FROM FacultyRequestStatus facultyRequestStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"facultyRequestStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FacultyRequestStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FacultyRequestStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FacultyRequestStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "facultyRequestStatusId", "groupId", "companyId",
			"createDate", "modifiedDate", "nameEn", "nameAr"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
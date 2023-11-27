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

import gov.omsb.tms.exception.NoSuchDutyAssignmentException;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.model.DutyAssignmentTable;
import gov.omsb.tms.model.impl.DutyAssignmentImpl;
import gov.omsb.tms.model.impl.DutyAssignmentModelImpl;
import gov.omsb.tms.service.persistence.DutyAssignmentPersistence;
import gov.omsb.tms.service.persistence.DutyAssignmentUtil;
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
 * The persistence implementation for the duty assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DutyAssignmentPersistence.class)
public class DutyAssignmentPersistenceImpl
	extends BasePersistenceImpl<DutyAssignment>
	implements DutyAssignmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DutyAssignmentUtil</code> to access the duty assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DutyAssignmentImpl.class.getName();

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
	 * Returns all the duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
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

		List<DutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<DutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyAssignment dutyAssignment : list) {
					if (!uuid.equals(dutyAssignment.getUuid())) {
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

			sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

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
				sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
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

				list = (List<DutyAssignment>)QueryUtil.list(
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
	 * Returns the first duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByUuid_First(
			String uuid, OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByUuid_First(
			uuid, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByUuid_First(
		String uuid, OrderByComparator<DutyAssignment> orderByComparator) {

		List<DutyAssignment> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByUuid_Last(
			String uuid, OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByUuid_Last(
			uuid, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByUuid_Last(
		String uuid, OrderByComparator<DutyAssignment> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DutyAssignment> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment[] findByUuid_PrevAndNext(
			long dutyAssignmentId, String uuid,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		uuid = Objects.toString(uuid, "");

		DutyAssignment dutyAssignment = findByPrimaryKey(dutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			DutyAssignment[] array = new DutyAssignmentImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dutyAssignment, uuid, orderByComparator, true);

			array[1] = dutyAssignment;

			array[2] = getByUuid_PrevAndNext(
				session, dutyAssignment, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyAssignment getByUuid_PrevAndNext(
		Session session, DutyAssignment dutyAssignment, String uuid,
		OrderByComparator<DutyAssignment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

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
			sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
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
						dutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty assignments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DutyAssignment dutyAssignment :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dutyAssignment);
		}
	}

	/**
	 * Returns the number of duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty assignments
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYASSIGNMENT_WHERE);

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
		"dutyAssignment.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dutyAssignment.uuid IS NULL OR dutyAssignment.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyAssignmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByUUID_G(uuid, groupId);

		if (dutyAssignment == null) {
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

			throw new NoSuchDutyAssignmentException(sb.toString());
		}

		return dutyAssignment;
	}

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByUUID_G(
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

		if (result instanceof DutyAssignment) {
			DutyAssignment dutyAssignment = (DutyAssignment)result;

			if (!Objects.equals(uuid, dutyAssignment.getUuid()) ||
				(groupId != dutyAssignment.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

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

				List<DutyAssignment> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DutyAssignment dutyAssignment = list.get(0);

					result = dutyAssignment;

					cacheResult(dutyAssignment);
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
			return (DutyAssignment)result;
		}
	}

	/**
	 * Removes the duty assignment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty assignment that was removed
	 */
	@Override
	public DutyAssignment removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = findByUUID_G(uuid, groupId);

		return remove(dutyAssignment);
	}

	/**
	 * Returns the number of duty assignments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty assignments
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYASSIGNMENT_WHERE);

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
		"dutyAssignment.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dutyAssignment.uuid IS NULL OR dutyAssignment.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dutyAssignment.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
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

		List<DutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<DutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyAssignment dutyAssignment : list) {
					if (!uuid.equals(dutyAssignment.getUuid()) ||
						(companyId != dutyAssignment.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

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
				sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
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

				list = (List<DutyAssignment>)QueryUtil.list(
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
	 * Returns the first duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyAssignment> orderByComparator) {

		List<DutyAssignment> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyAssignment> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DutyAssignment> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment[] findByUuid_C_PrevAndNext(
			long dutyAssignmentId, String uuid, long companyId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		uuid = Objects.toString(uuid, "");

		DutyAssignment dutyAssignment = findByPrimaryKey(dutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			DutyAssignment[] array = new DutyAssignmentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dutyAssignment, uuid, companyId, orderByComparator,
				true);

			array[1] = dutyAssignment;

			array[2] = getByUuid_C_PrevAndNext(
				session, dutyAssignment, uuid, companyId, orderByComparator,
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

	protected DutyAssignment getByUuid_C_PrevAndNext(
		Session session, DutyAssignment dutyAssignment, String uuid,
		long companyId, OrderByComparator<DutyAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

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
			sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
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
						dutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty assignments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DutyAssignment dutyAssignment :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dutyAssignment);
		}
	}

	/**
	 * Returns the number of duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty assignments
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYASSIGNMENT_WHERE);

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
		"dutyAssignment.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dutyAssignment.uuid IS NULL OR dutyAssignment.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dutyAssignment.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDutyTypeId;
	private FinderPath _finderPathWithoutPaginationFindByDutyTypeId;
	private FinderPath _finderPathCountByDutyTypeId;

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @return the matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeId(long dutyTypeId) {
		return findByDutyTypeId(
			dutyTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end) {

		return findByDutyTypeId(dutyTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return findByDutyTypeId(
			dutyTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDutyTypeId;
				finderArgs = new Object[] {dutyTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDutyTypeId;
			finderArgs = new Object[] {
				dutyTypeId, start, end, orderByComparator
			};
		}

		List<DutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<DutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyAssignment dutyAssignment : list) {
					if (dutyTypeId != dutyAssignment.getDutyTypeId()) {
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

			sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_DUTYTYPEID_DUTYTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyTypeId);

				list = (List<DutyAssignment>)QueryUtil.list(
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
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByDutyTypeId_First(
			long dutyTypeId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByDutyTypeId_First(
			dutyTypeId, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyTypeId=");
		sb.append(dutyTypeId);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByDutyTypeId_First(
		long dutyTypeId, OrderByComparator<DutyAssignment> orderByComparator) {

		List<DutyAssignment> list = findByDutyTypeId(
			dutyTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByDutyTypeId_Last(
			long dutyTypeId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByDutyTypeId_Last(
			dutyTypeId, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyTypeId=");
		sb.append(dutyTypeId);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByDutyTypeId_Last(
		long dutyTypeId, OrderByComparator<DutyAssignment> orderByComparator) {

		int count = countByDutyTypeId(dutyTypeId);

		if (count == 0) {
			return null;
		}

		List<DutyAssignment> list = findByDutyTypeId(
			dutyTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment[] findByDutyTypeId_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = findByPrimaryKey(dutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			DutyAssignment[] array = new DutyAssignmentImpl[3];

			array[0] = getByDutyTypeId_PrevAndNext(
				session, dutyAssignment, dutyTypeId, orderByComparator, true);

			array[1] = dutyAssignment;

			array[2] = getByDutyTypeId_PrevAndNext(
				session, dutyAssignment, dutyTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyAssignment getByDutyTypeId_PrevAndNext(
		Session session, DutyAssignment dutyAssignment, long dutyTypeId,
		OrderByComparator<DutyAssignment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

		sb.append(_FINDER_COLUMN_DUTYTYPEID_DUTYTYPEID_2);

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
			sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dutyTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 */
	@Override
	public void removeByDutyTypeId(long dutyTypeId) {
		for (DutyAssignment dutyAssignment :
				findByDutyTypeId(
					dutyTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dutyAssignment);
		}
	}

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @return the number of matching duty assignments
	 */
	@Override
	public int countByDutyTypeId(long dutyTypeId) {
		FinderPath finderPath = _finderPathCountByDutyTypeId;

		Object[] finderArgs = new Object[] {dutyTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_DUTYTYPEID_DUTYTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyTypeId);

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

	private static final String _FINDER_COLUMN_DUTYTYPEID_DUTYTYPEID_2 =
		"dutyAssignment.dutyTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByDutyTypeIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByDutyTypeIdAndStatus;
	private FinderPath _finderPathCountByDutyTypeIdAndStatus;

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @return the matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status) {

		return findByDutyTypeIdAndStatus(
			dutyTypeId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end) {

		return findByDutyTypeIdAndStatus(dutyTypeId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return findByDutyTypeIdAndStatus(
			dutyTypeId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDutyTypeIdAndStatus;
				finderArgs = new Object[] {dutyTypeId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDutyTypeIdAndStatus;
			finderArgs = new Object[] {
				dutyTypeId, status, start, end, orderByComparator
			};
		}

		List<DutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<DutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyAssignment dutyAssignment : list) {
					if ((dutyTypeId != dutyAssignment.getDutyTypeId()) ||
						!status.equals(dutyAssignment.getStatus())) {

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

			sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_DUTYTYPEID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyTypeId);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<DutyAssignment>)QueryUtil.list(
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
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByDutyTypeIdAndStatus_First(
			long dutyTypeId, String status,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByDutyTypeIdAndStatus_First(
			dutyTypeId, status, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyTypeId=");
		sb.append(dutyTypeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByDutyTypeIdAndStatus_First(
		long dutyTypeId, String status,
		OrderByComparator<DutyAssignment> orderByComparator) {

		List<DutyAssignment> list = findByDutyTypeIdAndStatus(
			dutyTypeId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByDutyTypeIdAndStatus_Last(
			long dutyTypeId, String status,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByDutyTypeIdAndStatus_Last(
			dutyTypeId, status, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyTypeId=");
		sb.append(dutyTypeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByDutyTypeIdAndStatus_Last(
		long dutyTypeId, String status,
		OrderByComparator<DutyAssignment> orderByComparator) {

		int count = countByDutyTypeIdAndStatus(dutyTypeId, status);

		if (count == 0) {
			return null;
		}

		List<DutyAssignment> list = findByDutyTypeIdAndStatus(
			dutyTypeId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment[] findByDutyTypeIdAndStatus_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId, String status,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		status = Objects.toString(status, "");

		DutyAssignment dutyAssignment = findByPrimaryKey(dutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			DutyAssignment[] array = new DutyAssignmentImpl[3];

			array[0] = getByDutyTypeIdAndStatus_PrevAndNext(
				session, dutyAssignment, dutyTypeId, status, orderByComparator,
				true);

			array[1] = dutyAssignment;

			array[2] = getByDutyTypeIdAndStatus_PrevAndNext(
				session, dutyAssignment, dutyTypeId, status, orderByComparator,
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

	protected DutyAssignment getByDutyTypeIdAndStatus_PrevAndNext(
		Session session, DutyAssignment dutyAssignment, long dutyTypeId,
		String status, OrderByComparator<DutyAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

		sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_DUTYTYPEID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_STATUS_2);
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
			sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dutyTypeId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 */
	@Override
	public void removeByDutyTypeIdAndStatus(long dutyTypeId, String status) {
		for (DutyAssignment dutyAssignment :
				findByDutyTypeIdAndStatus(
					dutyTypeId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dutyAssignment);
		}
	}

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @return the number of matching duty assignments
	 */
	@Override
	public int countByDutyTypeIdAndStatus(long dutyTypeId, String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByDutyTypeIdAndStatus;

		Object[] finderArgs = new Object[] {dutyTypeId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_DUTYTYPEID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyTypeId);

				if (bindStatus) {
					queryPos.add(status);
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
		_FINDER_COLUMN_DUTYTYPEIDANDSTATUS_DUTYTYPEID_2 =
			"dutyAssignment.dutyTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DUTYTYPEIDANDSTATUS_STATUS_2 =
		"dutyAssignment.status = ?";

	private static final String _FINDER_COLUMN_DUTYTYPEIDANDSTATUS_STATUS_3 =
		"(dutyAssignment.status IS NULL OR dutyAssignment.status = '')";

	private FinderPath _finderPathWithPaginationFindByDutyTypeIdAndAssignment;
	private FinderPath
		_finderPathWithoutPaginationFindByDutyTypeIdAndAssignment;
	private FinderPath _finderPathCountByDutyTypeIdAndAssignment;

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @return the matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment) {

		return findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end) {

		return findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	@Override
	public List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		assignment = Objects.toString(assignment, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDutyTypeIdAndAssignment;
				finderArgs = new Object[] {dutyTypeId, assignment};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDutyTypeIdAndAssignment;
			finderArgs = new Object[] {
				dutyTypeId, assignment, start, end, orderByComparator
			};
		}

		List<DutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<DutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyAssignment dutyAssignment : list) {
					if ((dutyTypeId != dutyAssignment.getDutyTypeId()) ||
						!assignment.equals(dutyAssignment.getAssignment())) {

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

			sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_DUTYTYPEID_2);

			boolean bindAssignment = false;

			if (assignment.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_ASSIGNMENT_3);
			}
			else {
				bindAssignment = true;

				sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_ASSIGNMENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyTypeId);

				if (bindAssignment) {
					queryPos.add(assignment);
				}

				list = (List<DutyAssignment>)QueryUtil.list(
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
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByDutyTypeIdAndAssignment_First(
			long dutyTypeId, String assignment,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByDutyTypeIdAndAssignment_First(
			dutyTypeId, assignment, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyTypeId=");
		sb.append(dutyTypeId);

		sb.append(", assignment=");
		sb.append(assignment);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByDutyTypeIdAndAssignment_First(
		long dutyTypeId, String assignment,
		OrderByComparator<DutyAssignment> orderByComparator) {

		List<DutyAssignment> list = findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment findByDutyTypeIdAndAssignment_Last(
			long dutyTypeId, String assignment,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByDutyTypeIdAndAssignment_Last(
			dutyTypeId, assignment, orderByComparator);

		if (dutyAssignment != null) {
			return dutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyTypeId=");
		sb.append(dutyTypeId);

		sb.append(", assignment=");
		sb.append(assignment);

		sb.append("}");

		throw new NoSuchDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public DutyAssignment fetchByDutyTypeIdAndAssignment_Last(
		long dutyTypeId, String assignment,
		OrderByComparator<DutyAssignment> orderByComparator) {

		int count = countByDutyTypeIdAndAssignment(dutyTypeId, assignment);

		if (count == 0) {
			return null;
		}

		List<DutyAssignment> list = findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment[] findByDutyTypeIdAndAssignment_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId, String assignment,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws NoSuchDutyAssignmentException {

		assignment = Objects.toString(assignment, "");

		DutyAssignment dutyAssignment = findByPrimaryKey(dutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			DutyAssignment[] array = new DutyAssignmentImpl[3];

			array[0] = getByDutyTypeIdAndAssignment_PrevAndNext(
				session, dutyAssignment, dutyTypeId, assignment,
				orderByComparator, true);

			array[1] = dutyAssignment;

			array[2] = getByDutyTypeIdAndAssignment_PrevAndNext(
				session, dutyAssignment, dutyTypeId, assignment,
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

	protected DutyAssignment getByDutyTypeIdAndAssignment_PrevAndNext(
		Session session, DutyAssignment dutyAssignment, long dutyTypeId,
		String assignment, OrderByComparator<DutyAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_DUTYASSIGNMENT_WHERE);

		sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_DUTYTYPEID_2);

		boolean bindAssignment = false;

		if (assignment.isEmpty()) {
			sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_ASSIGNMENT_3);
		}
		else {
			bindAssignment = true;

			sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_ASSIGNMENT_2);
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
			sb.append(DutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dutyTypeId);

		if (bindAssignment) {
			queryPos.add(assignment);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; and assignment = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 */
	@Override
	public void removeByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment) {

		for (DutyAssignment dutyAssignment :
				findByDutyTypeIdAndAssignment(
					dutyTypeId, assignment, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dutyAssignment);
		}
	}

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @return the number of matching duty assignments
	 */
	@Override
	public int countByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment) {

		assignment = Objects.toString(assignment, "");

		FinderPath finderPath = _finderPathCountByDutyTypeIdAndAssignment;

		Object[] finderArgs = new Object[] {dutyTypeId, assignment};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_DUTYTYPEID_2);

			boolean bindAssignment = false;

			if (assignment.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_ASSIGNMENT_3);
			}
			else {
				bindAssignment = true;

				sb.append(_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_ASSIGNMENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyTypeId);

				if (bindAssignment) {
					queryPos.add(assignment);
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
		_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_DUTYTYPEID_2 =
			"dutyAssignment.dutyTypeId = ? AND ";

	private static final String
		_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_ASSIGNMENT_2 =
			"dutyAssignment.assignment = ?";

	private static final String
		_FINDER_COLUMN_DUTYTYPEIDANDASSIGNMENT_ASSIGNMENT_3 =
			"(dutyAssignment.assignment IS NULL OR dutyAssignment.assignment = '')";

	public DutyAssignmentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("dutyAssignmentId", "duty_assignment_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("dutyTypeId", "duty_type_id");
		dbColumnNames.put("colorCode", "color_code");

		setDBColumnNames(dbColumnNames);

		setModelClass(DutyAssignment.class);

		setModelImplClass(DutyAssignmentImpl.class);
		setModelPKClass(long.class);

		setTable(DutyAssignmentTable.INSTANCE);
	}

	/**
	 * Caches the duty assignment in the entity cache if it is enabled.
	 *
	 * @param dutyAssignment the duty assignment
	 */
	@Override
	public void cacheResult(DutyAssignment dutyAssignment) {
		entityCache.putResult(
			DutyAssignmentImpl.class, dutyAssignment.getPrimaryKey(),
			dutyAssignment);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dutyAssignment.getUuid(), dutyAssignment.getGroupId()
			},
			dutyAssignment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the duty assignments in the entity cache if it is enabled.
	 *
	 * @param dutyAssignments the duty assignments
	 */
	@Override
	public void cacheResult(List<DutyAssignment> dutyAssignments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dutyAssignments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DutyAssignment dutyAssignment : dutyAssignments) {
			if (entityCache.getResult(
					DutyAssignmentImpl.class, dutyAssignment.getPrimaryKey()) ==
						null) {

				cacheResult(dutyAssignment);
			}
		}
	}

	/**
	 * Clears the cache for all duty assignments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DutyAssignmentImpl.class);

		finderCache.clearCache(DutyAssignmentImpl.class);
	}

	/**
	 * Clears the cache for the duty assignment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DutyAssignment dutyAssignment) {
		entityCache.removeResult(DutyAssignmentImpl.class, dutyAssignment);
	}

	@Override
	public void clearCache(List<DutyAssignment> dutyAssignments) {
		for (DutyAssignment dutyAssignment : dutyAssignments) {
			entityCache.removeResult(DutyAssignmentImpl.class, dutyAssignment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DutyAssignmentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DutyAssignmentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DutyAssignmentModelImpl dutyAssignmentModelImpl) {

		Object[] args = new Object[] {
			dutyAssignmentModelImpl.getUuid(),
			dutyAssignmentModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dutyAssignmentModelImpl);
	}

	/**
	 * Creates a new duty assignment with the primary key. Does not add the duty assignment to the database.
	 *
	 * @param dutyAssignmentId the primary key for the new duty assignment
	 * @return the new duty assignment
	 */
	@Override
	public DutyAssignment create(long dutyAssignmentId) {
		DutyAssignment dutyAssignment = new DutyAssignmentImpl();

		dutyAssignment.setNew(true);
		dutyAssignment.setPrimaryKey(dutyAssignmentId);

		String uuid = _portalUUID.generate();

		dutyAssignment.setUuid(uuid);

		dutyAssignment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dutyAssignment;
	}

	/**
	 * Removes the duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment that was removed
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment remove(long dutyAssignmentId)
		throws NoSuchDutyAssignmentException {

		return remove((Serializable)dutyAssignmentId);
	}

	/**
	 * Removes the duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the duty assignment
	 * @return the duty assignment that was removed
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment remove(Serializable primaryKey)
		throws NoSuchDutyAssignmentException {

		Session session = null;

		try {
			session = openSession();

			DutyAssignment dutyAssignment = (DutyAssignment)session.get(
				DutyAssignmentImpl.class, primaryKey);

			if (dutyAssignment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDutyAssignmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dutyAssignment);
		}
		catch (NoSuchDutyAssignmentException noSuchEntityException) {
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
	protected DutyAssignment removeImpl(DutyAssignment dutyAssignment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dutyAssignment)) {
				dutyAssignment = (DutyAssignment)session.get(
					DutyAssignmentImpl.class,
					dutyAssignment.getPrimaryKeyObj());
			}

			if (dutyAssignment != null) {
				session.delete(dutyAssignment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dutyAssignment != null) {
			clearCache(dutyAssignment);
		}

		return dutyAssignment;
	}

	@Override
	public DutyAssignment updateImpl(DutyAssignment dutyAssignment) {
		boolean isNew = dutyAssignment.isNew();

		if (!(dutyAssignment instanceof DutyAssignmentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dutyAssignment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dutyAssignment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dutyAssignment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DutyAssignment implementation " +
					dutyAssignment.getClass());
		}

		DutyAssignmentModelImpl dutyAssignmentModelImpl =
			(DutyAssignmentModelImpl)dutyAssignment;

		if (Validator.isNull(dutyAssignment.getUuid())) {
			String uuid = _portalUUID.generate();

			dutyAssignment.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dutyAssignment.getCreateDate() == null)) {
			if (serviceContext == null) {
				dutyAssignment.setCreateDate(date);
			}
			else {
				dutyAssignment.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dutyAssignmentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dutyAssignment.setModifiedDate(date);
			}
			else {
				dutyAssignment.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dutyAssignment);
			}
			else {
				dutyAssignment = (DutyAssignment)session.merge(dutyAssignment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DutyAssignmentImpl.class, dutyAssignmentModelImpl, false, true);

		cacheUniqueFindersCache(dutyAssignmentModelImpl);

		if (isNew) {
			dutyAssignment.setNew(false);
		}

		dutyAssignment.resetOriginalValues();

		return dutyAssignment;
	}

	/**
	 * Returns the duty assignment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the duty assignment
	 * @return the duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDutyAssignmentException {

		DutyAssignment dutyAssignment = fetchByPrimaryKey(primaryKey);

		if (dutyAssignment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDutyAssignmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dutyAssignment;
	}

	/**
	 * Returns the duty assignment with the primary key or throws a <code>NoSuchDutyAssignmentException</code> if it could not be found.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment findByPrimaryKey(long dutyAssignmentId)
		throws NoSuchDutyAssignmentException {

		return findByPrimaryKey((Serializable)dutyAssignmentId);
	}

	/**
	 * Returns the duty assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment, or <code>null</code> if a duty assignment with the primary key could not be found
	 */
	@Override
	public DutyAssignment fetchByPrimaryKey(long dutyAssignmentId) {
		return fetchByPrimaryKey((Serializable)dutyAssignmentId);
	}

	/**
	 * Returns all the duty assignments.
	 *
	 * @return the duty assignments
	 */
	@Override
	public List<DutyAssignment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of duty assignments
	 */
	@Override
	public List<DutyAssignment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty assignments
	 */
	@Override
	public List<DutyAssignment> findAll(
		int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty assignments
	 */
	@Override
	public List<DutyAssignment> findAll(
		int start, int end, OrderByComparator<DutyAssignment> orderByComparator,
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

		List<DutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<DutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DUTYASSIGNMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DUTYASSIGNMENT;

				sql = sql.concat(DutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DutyAssignment>)QueryUtil.list(
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
	 * Removes all the duty assignments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DutyAssignment dutyAssignment : findAll()) {
			remove(dutyAssignment);
		}
	}

	/**
	 * Returns the number of duty assignments.
	 *
	 * @return the number of duty assignments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DUTYASSIGNMENT);

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
		return "duty_assignment_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DUTYASSIGNMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DutyAssignmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the duty assignment persistence.
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

		_finderPathWithPaginationFindByDutyTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDutyTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"duty_type_id"}, true);

		_finderPathWithoutPaginationFindByDutyTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDutyTypeId",
			new String[] {Long.class.getName()}, new String[] {"duty_type_id"},
			true);

		_finderPathCountByDutyTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDutyTypeId",
			new String[] {Long.class.getName()}, new String[] {"duty_type_id"},
			false);

		_finderPathWithPaginationFindByDutyTypeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDutyTypeIdAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"duty_type_id", "status"}, true);

		_finderPathWithoutPaginationFindByDutyTypeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDutyTypeIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"duty_type_id", "status"}, true);

		_finderPathCountByDutyTypeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDutyTypeIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"duty_type_id", "status"}, false);

		_finderPathWithPaginationFindByDutyTypeIdAndAssignment = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDutyTypeIdAndAssignment",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"duty_type_id", "assignment"}, true);

		_finderPathWithoutPaginationFindByDutyTypeIdAndAssignment =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDutyTypeIdAndAssignment",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"duty_type_id", "assignment"}, true);

		_finderPathCountByDutyTypeIdAndAssignment = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDutyTypeIdAndAssignment",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"duty_type_id", "assignment"}, false);

		_setDutyAssignmentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDutyAssignmentUtilPersistence(null);

		entityCache.removeCache(DutyAssignmentImpl.class.getName());
	}

	private void _setDutyAssignmentUtilPersistence(
		DutyAssignmentPersistence dutyAssignmentPersistence) {

		try {
			Field field = DutyAssignmentUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dutyAssignmentPersistence);
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

	private static final String _SQL_SELECT_DUTYASSIGNMENT =
		"SELECT dutyAssignment FROM DutyAssignment dutyAssignment";

	private static final String _SQL_SELECT_DUTYASSIGNMENT_WHERE =
		"SELECT dutyAssignment FROM DutyAssignment dutyAssignment WHERE ";

	private static final String _SQL_COUNT_DUTYASSIGNMENT =
		"SELECT COUNT(dutyAssignment) FROM DutyAssignment dutyAssignment";

	private static final String _SQL_COUNT_DUTYASSIGNMENT_WHERE =
		"SELECT COUNT(dutyAssignment) FROM DutyAssignment dutyAssignment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dutyAssignment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DutyAssignment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DutyAssignment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DutyAssignmentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "dutyAssignmentId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "dutyTypeId", "colorCode"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
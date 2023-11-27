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

import gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualMaxTraineeTable;
import gov.omsb.tms.model.impl.LeaveAnnualMaxTraineeImpl;
import gov.omsb.tms.model.impl.LeaveAnnualMaxTraineeModelImpl;
import gov.omsb.tms.service.persistence.LeaveAnnualMaxTraineePersistence;
import gov.omsb.tms.service.persistence.LeaveAnnualMaxTraineeUtil;
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
 * The persistence implementation for the leave annual max trainee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveAnnualMaxTraineePersistence.class)
public class LeaveAnnualMaxTraineePersistenceImpl
	extends BasePersistenceImpl<LeaveAnnualMaxTrainee>
	implements LeaveAnnualMaxTraineePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveAnnualMaxTraineeUtil</code> to access the leave annual max trainee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveAnnualMaxTraineeImpl.class.getName();

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
	 * Returns all the leave annual max trainees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of matching leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator,
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

		List<LeaveAnnualMaxTrainee> list = null;

		if (useFinderCache) {
			list = (List<LeaveAnnualMaxTrainee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee : list) {
					if (!uuid.equals(leaveAnnualMaxTrainee.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVEANNUALMAXTRAINEE_WHERE);

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
				sb.append(LeaveAnnualMaxTraineeModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveAnnualMaxTrainee>)QueryUtil.list(
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
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee findByUuid_First(
			String uuid,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = fetchByUuid_First(
			uuid, orderByComparator);

		if (leaveAnnualMaxTrainee != null) {
			return leaveAnnualMaxTrainee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveAnnualMaxTraineeException(sb.toString());
	}

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee fetchByUuid_First(
		String uuid,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		List<LeaveAnnualMaxTrainee> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = fetchByUuid_Last(
			uuid, orderByComparator);

		if (leaveAnnualMaxTrainee != null) {
			return leaveAnnualMaxTrainee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveAnnualMaxTraineeException(sb.toString());
	}

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee fetchByUuid_Last(
		String uuid,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveAnnualMaxTrainee> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave annual max trainees before and after the current leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the current leave annual max trainee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee[] findByUuid_PrevAndNext(
			long leaveAnnualMaxTraineeId, String uuid,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException {

		uuid = Objects.toString(uuid, "");

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = findByPrimaryKey(
			leaveAnnualMaxTraineeId);

		Session session = null;

		try {
			session = openSession();

			LeaveAnnualMaxTrainee[] array = new LeaveAnnualMaxTraineeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveAnnualMaxTrainee, uuid, orderByComparator, true);

			array[1] = leaveAnnualMaxTrainee;

			array[2] = getByUuid_PrevAndNext(
				session, leaveAnnualMaxTrainee, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveAnnualMaxTrainee getByUuid_PrevAndNext(
		Session session, LeaveAnnualMaxTrainee leaveAnnualMaxTrainee,
		String uuid, OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEANNUALMAXTRAINEE_WHERE);

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
			sb.append(LeaveAnnualMaxTraineeModelImpl.ORDER_BY_JPQL);
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
						leaveAnnualMaxTrainee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveAnnualMaxTrainee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave annual max trainees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveAnnualMaxTrainee);
		}
	}

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave annual max trainees
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEANNUALMAXTRAINEE_WHERE);

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
		"leaveAnnualMaxTrainee.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveAnnualMaxTrainee.uuid IS NULL OR leaveAnnualMaxTrainee.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveAnnualMaxTraineeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualMaxTraineeException {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = fetchByUUID_G(
			uuid, groupId);

		if (leaveAnnualMaxTrainee == null) {
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

			throw new NoSuchLeaveAnnualMaxTraineeException(sb.toString());
		}

		return leaveAnnualMaxTrainee;
	}

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee fetchByUUID_G(
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

		if (result instanceof LeaveAnnualMaxTrainee) {
			LeaveAnnualMaxTrainee leaveAnnualMaxTrainee =
				(LeaveAnnualMaxTrainee)result;

			if (!Objects.equals(uuid, leaveAnnualMaxTrainee.getUuid()) ||
				(groupId != leaveAnnualMaxTrainee.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEANNUALMAXTRAINEE_WHERE);

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

				List<LeaveAnnualMaxTrainee> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = list.get(0);

					result = leaveAnnualMaxTrainee;

					cacheResult(leaveAnnualMaxTrainee);
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
			return (LeaveAnnualMaxTrainee)result;
		}
	}

	/**
	 * Removes the leave annual max trainee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave annual max trainee that was removed
	 */
	@Override
	public LeaveAnnualMaxTrainee removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualMaxTraineeException {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = findByUUID_G(
			uuid, groupId);

		return remove(leaveAnnualMaxTrainee);
	}

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave annual max trainees
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEANNUALMAXTRAINEE_WHERE);

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
		"leaveAnnualMaxTrainee.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveAnnualMaxTrainee.uuid IS NULL OR leaveAnnualMaxTrainee.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveAnnualMaxTrainee.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of matching leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator,
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

		List<LeaveAnnualMaxTrainee> list = null;

		if (useFinderCache) {
			list = (List<LeaveAnnualMaxTrainee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee : list) {
					if (!uuid.equals(leaveAnnualMaxTrainee.getUuid()) ||
						(companyId != leaveAnnualMaxTrainee.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVEANNUALMAXTRAINEE_WHERE);

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
				sb.append(LeaveAnnualMaxTraineeModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveAnnualMaxTrainee>)QueryUtil.list(
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
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveAnnualMaxTrainee != null) {
			return leaveAnnualMaxTrainee;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveAnnualMaxTraineeException(sb.toString());
	}

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		List<LeaveAnnualMaxTrainee> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveAnnualMaxTrainee != null) {
			return leaveAnnualMaxTrainee;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveAnnualMaxTraineeException(sb.toString());
	}

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveAnnualMaxTrainee> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave annual max trainees before and after the current leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the current leave annual max trainee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee[] findByUuid_C_PrevAndNext(
			long leaveAnnualMaxTraineeId, String uuid, long companyId,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException {

		uuid = Objects.toString(uuid, "");

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = findByPrimaryKey(
			leaveAnnualMaxTraineeId);

		Session session = null;

		try {
			session = openSession();

			LeaveAnnualMaxTrainee[] array = new LeaveAnnualMaxTraineeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveAnnualMaxTrainee, uuid, companyId,
				orderByComparator, true);

			array[1] = leaveAnnualMaxTrainee;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveAnnualMaxTrainee, uuid, companyId,
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

	protected LeaveAnnualMaxTrainee getByUuid_C_PrevAndNext(
		Session session, LeaveAnnualMaxTrainee leaveAnnualMaxTrainee,
		String uuid, long companyId,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEANNUALMAXTRAINEE_WHERE);

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
			sb.append(LeaveAnnualMaxTraineeModelImpl.ORDER_BY_JPQL);
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
						leaveAnnualMaxTrainee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveAnnualMaxTrainee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave annual max trainees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveAnnualMaxTrainee);
		}
	}

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave annual max trainees
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEANNUALMAXTRAINEE_WHERE);

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
		"leaveAnnualMaxTrainee.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveAnnualMaxTrainee.uuid IS NULL OR leaveAnnualMaxTrainee.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveAnnualMaxTrainee.companyId = ?";

	public LeaveAnnualMaxTraineePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"leaveAnnualMaxTraineeId", "leave_annual_max_trainee_id");
		dbColumnNames.put("leaveAnnualRuleId", "leave_annual_rule_id");
		dbColumnNames.put("trainingLevel", "training_level");
		dbColumnNames.put("maxTraineeApplyLeave", "max_trainee_apply_leave");
		dbColumnNames.put("noOfTraineeTakenLeave", "no_of_trainee_taken_leave");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveAnnualMaxTrainee.class);

		setModelImplClass(LeaveAnnualMaxTraineeImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveAnnualMaxTraineeTable.INSTANCE);
	}

	/**
	 * Caches the leave annual max trainee in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualMaxTrainee the leave annual max trainee
	 */
	@Override
	public void cacheResult(LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {
		entityCache.putResult(
			LeaveAnnualMaxTraineeImpl.class,
			leaveAnnualMaxTrainee.getPrimaryKey(), leaveAnnualMaxTrainee);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				leaveAnnualMaxTrainee.getUuid(),
				leaveAnnualMaxTrainee.getGroupId()
			},
			leaveAnnualMaxTrainee);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave annual max trainees in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualMaxTrainees the leave annual max trainees
	 */
	@Override
	public void cacheResult(
		List<LeaveAnnualMaxTrainee> leaveAnnualMaxTrainees) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveAnnualMaxTrainees.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee :
				leaveAnnualMaxTrainees) {

			if (entityCache.getResult(
					LeaveAnnualMaxTraineeImpl.class,
					leaveAnnualMaxTrainee.getPrimaryKey()) == null) {

				cacheResult(leaveAnnualMaxTrainee);
			}
		}
	}

	/**
	 * Clears the cache for all leave annual max trainees.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveAnnualMaxTraineeImpl.class);

		finderCache.clearCache(LeaveAnnualMaxTraineeImpl.class);
	}

	/**
	 * Clears the cache for the leave annual max trainee.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {
		entityCache.removeResult(
			LeaveAnnualMaxTraineeImpl.class, leaveAnnualMaxTrainee);
	}

	@Override
	public void clearCache(List<LeaveAnnualMaxTrainee> leaveAnnualMaxTrainees) {
		for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee :
				leaveAnnualMaxTrainees) {

			entityCache.removeResult(
				LeaveAnnualMaxTraineeImpl.class, leaveAnnualMaxTrainee);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveAnnualMaxTraineeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				LeaveAnnualMaxTraineeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveAnnualMaxTraineeModelImpl leaveAnnualMaxTraineeModelImpl) {

		Object[] args = new Object[] {
			leaveAnnualMaxTraineeModelImpl.getUuid(),
			leaveAnnualMaxTraineeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveAnnualMaxTraineeModelImpl);
	}

	/**
	 * Creates a new leave annual max trainee with the primary key. Does not add the leave annual max trainee to the database.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key for the new leave annual max trainee
	 * @return the new leave annual max trainee
	 */
	@Override
	public LeaveAnnualMaxTrainee create(long leaveAnnualMaxTraineeId) {
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee =
			new LeaveAnnualMaxTraineeImpl();

		leaveAnnualMaxTrainee.setNew(true);
		leaveAnnualMaxTrainee.setPrimaryKey(leaveAnnualMaxTraineeId);

		String uuid = _portalUUID.generate();

		leaveAnnualMaxTrainee.setUuid(uuid);

		leaveAnnualMaxTrainee.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveAnnualMaxTrainee;
	}

	/**
	 * Removes the leave annual max trainee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee that was removed
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee remove(long leaveAnnualMaxTraineeId)
		throws NoSuchLeaveAnnualMaxTraineeException {

		return remove((Serializable)leaveAnnualMaxTraineeId);
	}

	/**
	 * Removes the leave annual max trainee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave annual max trainee
	 * @return the leave annual max trainee that was removed
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee remove(Serializable primaryKey)
		throws NoSuchLeaveAnnualMaxTraineeException {

		Session session = null;

		try {
			session = openSession();

			LeaveAnnualMaxTrainee leaveAnnualMaxTrainee =
				(LeaveAnnualMaxTrainee)session.get(
					LeaveAnnualMaxTraineeImpl.class, primaryKey);

			if (leaveAnnualMaxTrainee == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveAnnualMaxTraineeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveAnnualMaxTrainee);
		}
		catch (NoSuchLeaveAnnualMaxTraineeException noSuchEntityException) {
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
	protected LeaveAnnualMaxTrainee removeImpl(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveAnnualMaxTrainee)) {
				leaveAnnualMaxTrainee = (LeaveAnnualMaxTrainee)session.get(
					LeaveAnnualMaxTraineeImpl.class,
					leaveAnnualMaxTrainee.getPrimaryKeyObj());
			}

			if (leaveAnnualMaxTrainee != null) {
				session.delete(leaveAnnualMaxTrainee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveAnnualMaxTrainee != null) {
			clearCache(leaveAnnualMaxTrainee);
		}

		return leaveAnnualMaxTrainee;
	}

	@Override
	public LeaveAnnualMaxTrainee updateImpl(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		boolean isNew = leaveAnnualMaxTrainee.isNew();

		if (!(leaveAnnualMaxTrainee instanceof
				LeaveAnnualMaxTraineeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveAnnualMaxTrainee.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveAnnualMaxTrainee);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveAnnualMaxTrainee proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveAnnualMaxTrainee implementation " +
					leaveAnnualMaxTrainee.getClass());
		}

		LeaveAnnualMaxTraineeModelImpl leaveAnnualMaxTraineeModelImpl =
			(LeaveAnnualMaxTraineeModelImpl)leaveAnnualMaxTrainee;

		if (Validator.isNull(leaveAnnualMaxTrainee.getUuid())) {
			String uuid = _portalUUID.generate();

			leaveAnnualMaxTrainee.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveAnnualMaxTrainee.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveAnnualMaxTrainee.setCreateDate(date);
			}
			else {
				leaveAnnualMaxTrainee.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leaveAnnualMaxTraineeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveAnnualMaxTrainee.setModifiedDate(date);
			}
			else {
				leaveAnnualMaxTrainee.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveAnnualMaxTrainee);
			}
			else {
				leaveAnnualMaxTrainee = (LeaveAnnualMaxTrainee)session.merge(
					leaveAnnualMaxTrainee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveAnnualMaxTraineeImpl.class, leaveAnnualMaxTraineeModelImpl,
			false, true);

		cacheUniqueFindersCache(leaveAnnualMaxTraineeModelImpl);

		if (isNew) {
			leaveAnnualMaxTrainee.setNew(false);
		}

		leaveAnnualMaxTrainee.resetOriginalValues();

		return leaveAnnualMaxTrainee;
	}

	/**
	 * Returns the leave annual max trainee with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave annual max trainee
	 * @return the leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveAnnualMaxTraineeException {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = fetchByPrimaryKey(
			primaryKey);

		if (leaveAnnualMaxTrainee == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveAnnualMaxTraineeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveAnnualMaxTrainee;
	}

	/**
	 * Returns the leave annual max trainee with the primary key or throws a <code>NoSuchLeaveAnnualMaxTraineeException</code> if it could not be found.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee findByPrimaryKey(long leaveAnnualMaxTraineeId)
		throws NoSuchLeaveAnnualMaxTraineeException {

		return findByPrimaryKey((Serializable)leaveAnnualMaxTraineeId);
	}

	/**
	 * Returns the leave annual max trainee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee, or <code>null</code> if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public LeaveAnnualMaxTrainee fetchByPrimaryKey(
		long leaveAnnualMaxTraineeId) {

		return fetchByPrimaryKey((Serializable)leaveAnnualMaxTraineeId);
	}

	/**
	 * Returns all the leave annual max trainees.
	 *
	 * @return the leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findAll(
		int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave annual max trainees
	 */
	@Override
	public List<LeaveAnnualMaxTrainee> findAll(
		int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator,
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

		List<LeaveAnnualMaxTrainee> list = null;

		if (useFinderCache) {
			list = (List<LeaveAnnualMaxTrainee>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEANNUALMAXTRAINEE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEANNUALMAXTRAINEE;

				sql = sql.concat(LeaveAnnualMaxTraineeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveAnnualMaxTrainee>)QueryUtil.list(
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
	 * Removes all the leave annual max trainees from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee : findAll()) {
			remove(leaveAnnualMaxTrainee);
		}
	}

	/**
	 * Returns the number of leave annual max trainees.
	 *
	 * @return the number of leave annual max trainees
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
					_SQL_COUNT_LEAVEANNUALMAXTRAINEE);

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
		return "leave_annual_max_trainee_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEANNUALMAXTRAINEE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveAnnualMaxTraineeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave annual max trainee persistence.
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

		_setLeaveAnnualMaxTraineeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLeaveAnnualMaxTraineeUtilPersistence(null);

		entityCache.removeCache(LeaveAnnualMaxTraineeImpl.class.getName());
	}

	private void _setLeaveAnnualMaxTraineeUtilPersistence(
		LeaveAnnualMaxTraineePersistence leaveAnnualMaxTraineePersistence) {

		try {
			Field field = LeaveAnnualMaxTraineeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, leaveAnnualMaxTraineePersistence);
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

	private static final String _SQL_SELECT_LEAVEANNUALMAXTRAINEE =
		"SELECT leaveAnnualMaxTrainee FROM LeaveAnnualMaxTrainee leaveAnnualMaxTrainee";

	private static final String _SQL_SELECT_LEAVEANNUALMAXTRAINEE_WHERE =
		"SELECT leaveAnnualMaxTrainee FROM LeaveAnnualMaxTrainee leaveAnnualMaxTrainee WHERE ";

	private static final String _SQL_COUNT_LEAVEANNUALMAXTRAINEE =
		"SELECT COUNT(leaveAnnualMaxTrainee) FROM LeaveAnnualMaxTrainee leaveAnnualMaxTrainee";

	private static final String _SQL_COUNT_LEAVEANNUALMAXTRAINEE_WHERE =
		"SELECT COUNT(leaveAnnualMaxTrainee) FROM LeaveAnnualMaxTrainee leaveAnnualMaxTrainee WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"leaveAnnualMaxTrainee.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveAnnualMaxTrainee exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveAnnualMaxTrainee exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveAnnualMaxTraineePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "leaveAnnualMaxTraineeId", "leaveAnnualRuleId",
			"trainingLevel", "maxTraineeApplyLeave", "noOfTraineeTakenLeave",
			"groupId", "companyId", "createDate", "createdBy", "modifiedDate",
			"modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
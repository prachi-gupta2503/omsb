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

import gov.omsb.tms.exception.NoSuchLeaveAnnualRuleException;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveAnnualRuleTable;
import gov.omsb.tms.model.impl.LeaveAnnualRuleImpl;
import gov.omsb.tms.model.impl.LeaveAnnualRuleModelImpl;
import gov.omsb.tms.service.persistence.LeaveAnnualRulePersistence;
import gov.omsb.tms.service.persistence.LeaveAnnualRuleUtil;
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
 * The persistence implementation for the leave annual rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveAnnualRulePersistence.class)
public class LeaveAnnualRulePersistenceImpl
	extends BasePersistenceImpl<LeaveAnnualRule>
	implements LeaveAnnualRulePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveAnnualRuleUtil</code> to access the leave annual rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveAnnualRuleImpl.class.getName();

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
	 * Returns all the leave annual rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave annual rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @return the range of matching leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave annual rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveAnnualRule> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave annual rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveAnnualRule> orderByComparator,
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

		List<LeaveAnnualRule> list = null;

		if (useFinderCache) {
			list = (List<LeaveAnnualRule>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveAnnualRule leaveAnnualRule : list) {
					if (!uuid.equals(leaveAnnualRule.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVEANNUALRULE_WHERE);

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
				sb.append(LeaveAnnualRuleModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveAnnualRule>)QueryUtil.list(
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
	 * Returns the first leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule findByUuid_First(
			String uuid, OrderByComparator<LeaveAnnualRule> orderByComparator)
		throws NoSuchLeaveAnnualRuleException {

		LeaveAnnualRule leaveAnnualRule = fetchByUuid_First(
			uuid, orderByComparator);

		if (leaveAnnualRule != null) {
			return leaveAnnualRule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveAnnualRuleException(sb.toString());
	}

	/**
	 * Returns the first leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule fetchByUuid_First(
		String uuid, OrderByComparator<LeaveAnnualRule> orderByComparator) {

		List<LeaveAnnualRule> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule findByUuid_Last(
			String uuid, OrderByComparator<LeaveAnnualRule> orderByComparator)
		throws NoSuchLeaveAnnualRuleException {

		LeaveAnnualRule leaveAnnualRule = fetchByUuid_Last(
			uuid, orderByComparator);

		if (leaveAnnualRule != null) {
			return leaveAnnualRule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveAnnualRuleException(sb.toString());
	}

	/**
	 * Returns the last leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveAnnualRule> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveAnnualRule> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave annual rules before and after the current leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param leaveAnnualRuleId the primary key of the current leave annual rule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	@Override
	public LeaveAnnualRule[] findByUuid_PrevAndNext(
			long leaveAnnualRuleId, String uuid,
			OrderByComparator<LeaveAnnualRule> orderByComparator)
		throws NoSuchLeaveAnnualRuleException {

		uuid = Objects.toString(uuid, "");

		LeaveAnnualRule leaveAnnualRule = findByPrimaryKey(leaveAnnualRuleId);

		Session session = null;

		try {
			session = openSession();

			LeaveAnnualRule[] array = new LeaveAnnualRuleImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveAnnualRule, uuid, orderByComparator, true);

			array[1] = leaveAnnualRule;

			array[2] = getByUuid_PrevAndNext(
				session, leaveAnnualRule, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveAnnualRule getByUuid_PrevAndNext(
		Session session, LeaveAnnualRule leaveAnnualRule, String uuid,
		OrderByComparator<LeaveAnnualRule> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEANNUALRULE_WHERE);

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
			sb.append(LeaveAnnualRuleModelImpl.ORDER_BY_JPQL);
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
						leaveAnnualRule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveAnnualRule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave annual rules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveAnnualRule leaveAnnualRule :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveAnnualRule);
		}
	}

	/**
	 * Returns the number of leave annual rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave annual rules
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEANNUALRULE_WHERE);

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
		"leaveAnnualRule.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveAnnualRule.uuid IS NULL OR leaveAnnualRule.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the leave annual rule where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveAnnualRuleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualRuleException {

		LeaveAnnualRule leaveAnnualRule = fetchByUUID_G(uuid, groupId);

		if (leaveAnnualRule == null) {
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

			throw new NoSuchLeaveAnnualRuleException(sb.toString());
		}

		return leaveAnnualRule;
	}

	/**
	 * Returns the leave annual rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave annual rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule fetchByUUID_G(
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

		if (result instanceof LeaveAnnualRule) {
			LeaveAnnualRule leaveAnnualRule = (LeaveAnnualRule)result;

			if (!Objects.equals(uuid, leaveAnnualRule.getUuid()) ||
				(groupId != leaveAnnualRule.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEANNUALRULE_WHERE);

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

				List<LeaveAnnualRule> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveAnnualRule leaveAnnualRule = list.get(0);

					result = leaveAnnualRule;

					cacheResult(leaveAnnualRule);
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
			return (LeaveAnnualRule)result;
		}
	}

	/**
	 * Removes the leave annual rule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave annual rule that was removed
	 */
	@Override
	public LeaveAnnualRule removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualRuleException {

		LeaveAnnualRule leaveAnnualRule = findByUUID_G(uuid, groupId);

		return remove(leaveAnnualRule);
	}

	/**
	 * Returns the number of leave annual rules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave annual rules
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEANNUALRULE_WHERE);

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
		"leaveAnnualRule.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveAnnualRule.uuid IS NULL OR leaveAnnualRule.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveAnnualRule.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @return the range of matching leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveAnnualRule> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveAnnualRule> orderByComparator,
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

		List<LeaveAnnualRule> list = null;

		if (useFinderCache) {
			list = (List<LeaveAnnualRule>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveAnnualRule leaveAnnualRule : list) {
					if (!uuid.equals(leaveAnnualRule.getUuid()) ||
						(companyId != leaveAnnualRule.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVEANNUALRULE_WHERE);

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
				sb.append(LeaveAnnualRuleModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveAnnualRule>)QueryUtil.list(
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
	 * Returns the first leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveAnnualRule> orderByComparator)
		throws NoSuchLeaveAnnualRuleException {

		LeaveAnnualRule leaveAnnualRule = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveAnnualRule != null) {
			return leaveAnnualRule;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveAnnualRuleException(sb.toString());
	}

	/**
	 * Returns the first leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveAnnualRule> orderByComparator) {

		List<LeaveAnnualRule> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveAnnualRule> orderByComparator)
		throws NoSuchLeaveAnnualRuleException {

		LeaveAnnualRule leaveAnnualRule = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveAnnualRule != null) {
			return leaveAnnualRule;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveAnnualRuleException(sb.toString());
	}

	/**
	 * Returns the last leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	@Override
	public LeaveAnnualRule fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveAnnualRule> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveAnnualRule> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave annual rules before and after the current leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveAnnualRuleId the primary key of the current leave annual rule
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	@Override
	public LeaveAnnualRule[] findByUuid_C_PrevAndNext(
			long leaveAnnualRuleId, String uuid, long companyId,
			OrderByComparator<LeaveAnnualRule> orderByComparator)
		throws NoSuchLeaveAnnualRuleException {

		uuid = Objects.toString(uuid, "");

		LeaveAnnualRule leaveAnnualRule = findByPrimaryKey(leaveAnnualRuleId);

		Session session = null;

		try {
			session = openSession();

			LeaveAnnualRule[] array = new LeaveAnnualRuleImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveAnnualRule, uuid, companyId, orderByComparator,
				true);

			array[1] = leaveAnnualRule;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveAnnualRule, uuid, companyId, orderByComparator,
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

	protected LeaveAnnualRule getByUuid_C_PrevAndNext(
		Session session, LeaveAnnualRule leaveAnnualRule, String uuid,
		long companyId, OrderByComparator<LeaveAnnualRule> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEANNUALRULE_WHERE);

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
			sb.append(LeaveAnnualRuleModelImpl.ORDER_BY_JPQL);
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
						leaveAnnualRule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveAnnualRule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave annual rules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveAnnualRule leaveAnnualRule :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveAnnualRule);
		}
	}

	/**
	 * Returns the number of leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave annual rules
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEANNUALRULE_WHERE);

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
		"leaveAnnualRule.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveAnnualRule.uuid IS NULL OR leaveAnnualRule.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveAnnualRule.companyId = ?";

	public LeaveAnnualRulePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("leaveAnnualRuleId", "leave_annual_rule_id");
		dbColumnNames.put("programMasterId", "program_master_id");
		dbColumnNames.put("lastDateForSubmission", "last_date_for_submission");
		dbColumnNames.put(
			"annualLeaveAvailableAt", "annual_leave_available_at");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveAnnualRule.class);

		setModelImplClass(LeaveAnnualRuleImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveAnnualRuleTable.INSTANCE);
	}

	/**
	 * Caches the leave annual rule in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualRule the leave annual rule
	 */
	@Override
	public void cacheResult(LeaveAnnualRule leaveAnnualRule) {
		entityCache.putResult(
			LeaveAnnualRuleImpl.class, leaveAnnualRule.getPrimaryKey(),
			leaveAnnualRule);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				leaveAnnualRule.getUuid(), leaveAnnualRule.getGroupId()
			},
			leaveAnnualRule);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave annual rules in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualRules the leave annual rules
	 */
	@Override
	public void cacheResult(List<LeaveAnnualRule> leaveAnnualRules) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveAnnualRules.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveAnnualRule leaveAnnualRule : leaveAnnualRules) {
			if (entityCache.getResult(
					LeaveAnnualRuleImpl.class,
					leaveAnnualRule.getPrimaryKey()) == null) {

				cacheResult(leaveAnnualRule);
			}
		}
	}

	/**
	 * Clears the cache for all leave annual rules.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveAnnualRuleImpl.class);

		finderCache.clearCache(LeaveAnnualRuleImpl.class);
	}

	/**
	 * Clears the cache for the leave annual rule.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveAnnualRule leaveAnnualRule) {
		entityCache.removeResult(LeaveAnnualRuleImpl.class, leaveAnnualRule);
	}

	@Override
	public void clearCache(List<LeaveAnnualRule> leaveAnnualRules) {
		for (LeaveAnnualRule leaveAnnualRule : leaveAnnualRules) {
			entityCache.removeResult(
				LeaveAnnualRuleImpl.class, leaveAnnualRule);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveAnnualRuleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveAnnualRuleImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveAnnualRuleModelImpl leaveAnnualRuleModelImpl) {

		Object[] args = new Object[] {
			leaveAnnualRuleModelImpl.getUuid(),
			leaveAnnualRuleModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveAnnualRuleModelImpl);
	}

	/**
	 * Creates a new leave annual rule with the primary key. Does not add the leave annual rule to the database.
	 *
	 * @param leaveAnnualRuleId the primary key for the new leave annual rule
	 * @return the new leave annual rule
	 */
	@Override
	public LeaveAnnualRule create(long leaveAnnualRuleId) {
		LeaveAnnualRule leaveAnnualRule = new LeaveAnnualRuleImpl();

		leaveAnnualRule.setNew(true);
		leaveAnnualRule.setPrimaryKey(leaveAnnualRuleId);

		String uuid = _portalUUID.generate();

		leaveAnnualRule.setUuid(uuid);

		leaveAnnualRule.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveAnnualRule;
	}

	/**
	 * Removes the leave annual rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule that was removed
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	@Override
	public LeaveAnnualRule remove(long leaveAnnualRuleId)
		throws NoSuchLeaveAnnualRuleException {

		return remove((Serializable)leaveAnnualRuleId);
	}

	/**
	 * Removes the leave annual rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave annual rule
	 * @return the leave annual rule that was removed
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	@Override
	public LeaveAnnualRule remove(Serializable primaryKey)
		throws NoSuchLeaveAnnualRuleException {

		Session session = null;

		try {
			session = openSession();

			LeaveAnnualRule leaveAnnualRule = (LeaveAnnualRule)session.get(
				LeaveAnnualRuleImpl.class, primaryKey);

			if (leaveAnnualRule == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveAnnualRuleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveAnnualRule);
		}
		catch (NoSuchLeaveAnnualRuleException noSuchEntityException) {
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
	protected LeaveAnnualRule removeImpl(LeaveAnnualRule leaveAnnualRule) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveAnnualRule)) {
				leaveAnnualRule = (LeaveAnnualRule)session.get(
					LeaveAnnualRuleImpl.class,
					leaveAnnualRule.getPrimaryKeyObj());
			}

			if (leaveAnnualRule != null) {
				session.delete(leaveAnnualRule);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveAnnualRule != null) {
			clearCache(leaveAnnualRule);
		}

		return leaveAnnualRule;
	}

	@Override
	public LeaveAnnualRule updateImpl(LeaveAnnualRule leaveAnnualRule) {
		boolean isNew = leaveAnnualRule.isNew();

		if (!(leaveAnnualRule instanceof LeaveAnnualRuleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveAnnualRule.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveAnnualRule);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveAnnualRule proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveAnnualRule implementation " +
					leaveAnnualRule.getClass());
		}

		LeaveAnnualRuleModelImpl leaveAnnualRuleModelImpl =
			(LeaveAnnualRuleModelImpl)leaveAnnualRule;

		if (Validator.isNull(leaveAnnualRule.getUuid())) {
			String uuid = _portalUUID.generate();

			leaveAnnualRule.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveAnnualRule.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveAnnualRule.setCreateDate(date);
			}
			else {
				leaveAnnualRule.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leaveAnnualRuleModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveAnnualRule.setModifiedDate(date);
			}
			else {
				leaveAnnualRule.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveAnnualRule);
			}
			else {
				leaveAnnualRule = (LeaveAnnualRule)session.merge(
					leaveAnnualRule);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveAnnualRuleImpl.class, leaveAnnualRuleModelImpl, false, true);

		cacheUniqueFindersCache(leaveAnnualRuleModelImpl);

		if (isNew) {
			leaveAnnualRule.setNew(false);
		}

		leaveAnnualRule.resetOriginalValues();

		return leaveAnnualRule;
	}

	/**
	 * Returns the leave annual rule with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave annual rule
	 * @return the leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	@Override
	public LeaveAnnualRule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveAnnualRuleException {

		LeaveAnnualRule leaveAnnualRule = fetchByPrimaryKey(primaryKey);

		if (leaveAnnualRule == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveAnnualRuleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveAnnualRule;
	}

	/**
	 * Returns the leave annual rule with the primary key or throws a <code>NoSuchLeaveAnnualRuleException</code> if it could not be found.
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	@Override
	public LeaveAnnualRule findByPrimaryKey(long leaveAnnualRuleId)
		throws NoSuchLeaveAnnualRuleException {

		return findByPrimaryKey((Serializable)leaveAnnualRuleId);
	}

	/**
	 * Returns the leave annual rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule, or <code>null</code> if a leave annual rule with the primary key could not be found
	 */
	@Override
	public LeaveAnnualRule fetchByPrimaryKey(long leaveAnnualRuleId) {
		return fetchByPrimaryKey((Serializable)leaveAnnualRuleId);
	}

	/**
	 * Returns all the leave annual rules.
	 *
	 * @return the leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave annual rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @return the range of leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave annual rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findAll(
		int start, int end,
		OrderByComparator<LeaveAnnualRule> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave annual rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave annual rules
	 */
	@Override
	public List<LeaveAnnualRule> findAll(
		int start, int end,
		OrderByComparator<LeaveAnnualRule> orderByComparator,
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

		List<LeaveAnnualRule> list = null;

		if (useFinderCache) {
			list = (List<LeaveAnnualRule>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEANNUALRULE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEANNUALRULE;

				sql = sql.concat(LeaveAnnualRuleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveAnnualRule>)QueryUtil.list(
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
	 * Removes all the leave annual rules from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveAnnualRule leaveAnnualRule : findAll()) {
			remove(leaveAnnualRule);
		}
	}

	/**
	 * Returns the number of leave annual rules.
	 *
	 * @return the number of leave annual rules
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVEANNUALRULE);

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
		return "leave_annual_rule_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEANNUALRULE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveAnnualRuleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave annual rule persistence.
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

		_setLeaveAnnualRuleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLeaveAnnualRuleUtilPersistence(null);

		entityCache.removeCache(LeaveAnnualRuleImpl.class.getName());
	}

	private void _setLeaveAnnualRuleUtilPersistence(
		LeaveAnnualRulePersistence leaveAnnualRulePersistence) {

		try {
			Field field = LeaveAnnualRuleUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, leaveAnnualRulePersistence);
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

	private static final String _SQL_SELECT_LEAVEANNUALRULE =
		"SELECT leaveAnnualRule FROM LeaveAnnualRule leaveAnnualRule";

	private static final String _SQL_SELECT_LEAVEANNUALRULE_WHERE =
		"SELECT leaveAnnualRule FROM LeaveAnnualRule leaveAnnualRule WHERE ";

	private static final String _SQL_COUNT_LEAVEANNUALRULE =
		"SELECT COUNT(leaveAnnualRule) FROM LeaveAnnualRule leaveAnnualRule";

	private static final String _SQL_COUNT_LEAVEANNUALRULE_WHERE =
		"SELECT COUNT(leaveAnnualRule) FROM LeaveAnnualRule leaveAnnualRule WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveAnnualRule.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveAnnualRule exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveAnnualRule exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveAnnualRulePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "leaveAnnualRuleId", "programMasterId",
			"lastDateForSubmission", "annualLeaveAvailableAt", "groupId",
			"companyId", "createDate", "createdBy", "modifiedDate", "modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
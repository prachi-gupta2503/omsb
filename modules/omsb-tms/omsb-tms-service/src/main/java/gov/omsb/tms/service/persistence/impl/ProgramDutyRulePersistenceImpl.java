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

import gov.omsb.tms.exception.NoSuchProgramDutyRuleException;
import gov.omsb.tms.model.ProgramDutyRule;
import gov.omsb.tms.model.ProgramDutyRuleTable;
import gov.omsb.tms.model.impl.ProgramDutyRuleImpl;
import gov.omsb.tms.model.impl.ProgramDutyRuleModelImpl;
import gov.omsb.tms.service.persistence.ProgramDutyRulePersistence;
import gov.omsb.tms.service.persistence.ProgramDutyRuleUtil;
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
 * The persistence implementation for the program duty rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgramDutyRulePersistence.class)
public class ProgramDutyRulePersistenceImpl
	extends BasePersistenceImpl<ProgramDutyRule>
	implements ProgramDutyRulePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgramDutyRuleUtil</code> to access the program duty rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgramDutyRuleImpl.class.getName();

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
	 * Returns all the program duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator,
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

		List<ProgramDutyRule> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyRule>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyRule programDutyRule : list) {
					if (!uuid.equals(programDutyRule.getUuid())) {
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

			sb.append(_SQL_SELECT_PROGRAMDUTYRULE_WHERE);

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
				sb.append(ProgramDutyRuleModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramDutyRule>)QueryUtil.list(
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
	 * Returns the first program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule findByUuid_First(
			String uuid, OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = fetchByUuid_First(
			uuid, orderByComparator);

		if (programDutyRule != null) {
			return programDutyRule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramDutyRuleException(sb.toString());
	}

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule fetchByUuid_First(
		String uuid, OrderByComparator<ProgramDutyRule> orderByComparator) {

		List<ProgramDutyRule> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule findByUuid_Last(
			String uuid, OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = fetchByUuid_Last(
			uuid, orderByComparator);

		if (programDutyRule != null) {
			return programDutyRule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramDutyRuleException(sb.toString());
	}

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule fetchByUuid_Last(
		String uuid, OrderByComparator<ProgramDutyRule> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyRule> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty rules before and after the current program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param programDutyRuleId the primary key of the current program duty rule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	@Override
	public ProgramDutyRule[] findByUuid_PrevAndNext(
			long programDutyRuleId, String uuid,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		uuid = Objects.toString(uuid, "");

		ProgramDutyRule programDutyRule = findByPrimaryKey(programDutyRuleId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyRule[] array = new ProgramDutyRuleImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, programDutyRule, uuid, orderByComparator, true);

			array[1] = programDutyRule;

			array[2] = getByUuid_PrevAndNext(
				session, programDutyRule, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramDutyRule getByUuid_PrevAndNext(
		Session session, ProgramDutyRule programDutyRule, String uuid,
		OrderByComparator<ProgramDutyRule> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMDUTYRULE_WHERE);

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
			sb.append(ProgramDutyRuleModelImpl.ORDER_BY_JPQL);
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
						programDutyRule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyRule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty rules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgramDutyRule programDutyRule :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programDutyRule);
		}
	}

	/**
	 * Returns the number of program duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duty rules
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMDUTYRULE_WHERE);

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
		"programDutyRule.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(programDutyRule.uuid IS NULL OR programDutyRule.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDutyRuleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = fetchByUUID_G(uuid, groupId);

		if (programDutyRule == null) {
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

			throw new NoSuchProgramDutyRuleException(sb.toString());
		}

		return programDutyRule;
	}

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule fetchByUUID_G(
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

		if (result instanceof ProgramDutyRule) {
			ProgramDutyRule programDutyRule = (ProgramDutyRule)result;

			if (!Objects.equals(uuid, programDutyRule.getUuid()) ||
				(groupId != programDutyRule.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMDUTYRULE_WHERE);

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

				List<ProgramDutyRule> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgramDutyRule programDutyRule = list.get(0);

					result = programDutyRule;

					cacheResult(programDutyRule);
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
			return (ProgramDutyRule)result;
		}
	}

	/**
	 * Removes the program duty rule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duty rule that was removed
	 */
	@Override
	public ProgramDutyRule removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = findByUUID_G(uuid, groupId);

		return remove(programDutyRule);
	}

	/**
	 * Returns the number of program duty rules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duty rules
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDUTYRULE_WHERE);

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
		"programDutyRule.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(programDutyRule.uuid IS NULL OR programDutyRule.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"programDutyRule.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator,
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

		List<ProgramDutyRule> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyRule>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyRule programDutyRule : list) {
					if (!uuid.equals(programDutyRule.getUuid()) ||
						(companyId != programDutyRule.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGRAMDUTYRULE_WHERE);

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
				sb.append(ProgramDutyRuleModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramDutyRule>)QueryUtil.list(
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
	 * Returns the first program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (programDutyRule != null) {
			return programDutyRule;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramDutyRuleException(sb.toString());
	}

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		List<ProgramDutyRule> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (programDutyRule != null) {
			return programDutyRule;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramDutyRuleException(sb.toString());
	}

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyRule> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty rules before and after the current program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programDutyRuleId the primary key of the current program duty rule
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	@Override
	public ProgramDutyRule[] findByUuid_C_PrevAndNext(
			long programDutyRuleId, String uuid, long companyId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		uuid = Objects.toString(uuid, "");

		ProgramDutyRule programDutyRule = findByPrimaryKey(programDutyRuleId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyRule[] array = new ProgramDutyRuleImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, programDutyRule, uuid, companyId, orderByComparator,
				true);

			array[1] = programDutyRule;

			array[2] = getByUuid_C_PrevAndNext(
				session, programDutyRule, uuid, companyId, orderByComparator,
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

	protected ProgramDutyRule getByUuid_C_PrevAndNext(
		Session session, ProgramDutyRule programDutyRule, String uuid,
		long companyId, OrderByComparator<ProgramDutyRule> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMDUTYRULE_WHERE);

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
			sb.append(ProgramDutyRuleModelImpl.ORDER_BY_JPQL);
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
						programDutyRule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyRule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty rules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgramDutyRule programDutyRule :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programDutyRule);
		}
	}

	/**
	 * Returns the number of program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duty rules
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDUTYRULE_WHERE);

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
		"programDutyRule.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(programDutyRule.uuid IS NULL OR programDutyRule.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"programDutyRule.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramIdAndCohortId;
	private FinderPath _finderPathWithoutPaginationFindByProgramIdAndCohortId;
	private FinderPath _finderPathCountByProgramIdAndCohortId;

	/**
	 * Returns all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId) {

		return findByProgramIdAndCohortId(
			programId, cohortId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end) {

		return findByProgramIdAndCohortId(
			programId, cohortId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return findByProgramIdAndCohortId(
			programId, cohortId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgramIdAndCohortId;
				finderArgs = new Object[] {programId, cohortId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProgramIdAndCohortId;
			finderArgs = new Object[] {
				programId, cohortId, start, end, orderByComparator
			};
		}

		List<ProgramDutyRule> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyRule>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyRule programDutyRule : list) {
					if ((programId != programDutyRule.getProgramId()) ||
						(cohortId != programDutyRule.getCohortId())) {

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

			sb.append(_SQL_SELECT_PROGRAMDUTYRULE_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_PROGRAMID_2);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_COHORTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramDutyRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(cohortId);

				list = (List<ProgramDutyRule>)QueryUtil.list(
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
	 * Returns the first program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule findByProgramIdAndCohortId_First(
			long programId, long cohortId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = fetchByProgramIdAndCohortId_First(
			programId, cohortId, orderByComparator);

		if (programDutyRule != null) {
			return programDutyRule;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programId=");
		sb.append(programId);

		sb.append(", cohortId=");
		sb.append(cohortId);

		sb.append("}");

		throw new NoSuchProgramDutyRuleException(sb.toString());
	}

	/**
	 * Returns the first program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule fetchByProgramIdAndCohortId_First(
		long programId, long cohortId,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		List<ProgramDutyRule> list = findByProgramIdAndCohortId(
			programId, cohortId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule findByProgramIdAndCohortId_Last(
			long programId, long cohortId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = fetchByProgramIdAndCohortId_Last(
			programId, cohortId, orderByComparator);

		if (programDutyRule != null) {
			return programDutyRule;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programId=");
		sb.append(programId);

		sb.append(", cohortId=");
		sb.append(cohortId);

		sb.append("}");

		throw new NoSuchProgramDutyRuleException(sb.toString());
	}

	/**
	 * Returns the last program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	@Override
	public ProgramDutyRule fetchByProgramIdAndCohortId_Last(
		long programId, long cohortId,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		int count = countByProgramIdAndCohortId(programId, cohortId);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyRule> list = findByProgramIdAndCohortId(
			programId, cohortId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty rules before and after the current program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programDutyRuleId the primary key of the current program duty rule
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	@Override
	public ProgramDutyRule[] findByProgramIdAndCohortId_PrevAndNext(
			long programDutyRuleId, long programId, long cohortId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = findByPrimaryKey(programDutyRuleId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyRule[] array = new ProgramDutyRuleImpl[3];

			array[0] = getByProgramIdAndCohortId_PrevAndNext(
				session, programDutyRule, programId, cohortId,
				orderByComparator, true);

			array[1] = programDutyRule;

			array[2] = getByProgramIdAndCohortId_PrevAndNext(
				session, programDutyRule, programId, cohortId,
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

	protected ProgramDutyRule getByProgramIdAndCohortId_PrevAndNext(
		Session session, ProgramDutyRule programDutyRule, long programId,
		long cohortId, OrderByComparator<ProgramDutyRule> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMDUTYRULE_WHERE);

		sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_PROGRAMID_2);

		sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_COHORTID_2);

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
			sb.append(ProgramDutyRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programId);

		queryPos.add(cohortId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programDutyRule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyRule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty rules where programId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 */
	@Override
	public void removeByProgramIdAndCohortId(long programId, long cohortId) {
		for (ProgramDutyRule programDutyRule :
				findByProgramIdAndCohortId(
					programId, cohortId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programDutyRule);
		}
	}

	/**
	 * Returns the number of program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty rules
	 */
	@Override
	public int countByProgramIdAndCohortId(long programId, long cohortId) {
		FinderPath finderPath = _finderPathCountByProgramIdAndCohortId;

		Object[] finderArgs = new Object[] {programId, cohortId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDUTYRULE_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_PROGRAMID_2);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_COHORTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(cohortId);

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
		_FINDER_COLUMN_PROGRAMIDANDCOHORTID_PROGRAMID_2 =
			"programDutyRule.programId = ? AND ";

	private static final String _FINDER_COLUMN_PROGRAMIDANDCOHORTID_COHORTID_2 =
		"programDutyRule.cohortId = ?";

	public ProgramDutyRulePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("programDutyRuleId", "program_duty_rule_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put("dutyRuleId", "duty_rule_id");
		dbColumnNames.put("cohortId", "cohort_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgramDutyRule.class);

		setModelImplClass(ProgramDutyRuleImpl.class);
		setModelPKClass(long.class);

		setTable(ProgramDutyRuleTable.INSTANCE);
	}

	/**
	 * Caches the program duty rule in the entity cache if it is enabled.
	 *
	 * @param programDutyRule the program duty rule
	 */
	@Override
	public void cacheResult(ProgramDutyRule programDutyRule) {
		entityCache.putResult(
			ProgramDutyRuleImpl.class, programDutyRule.getPrimaryKey(),
			programDutyRule);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				programDutyRule.getUuid(), programDutyRule.getGroupId()
			},
			programDutyRule);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the program duty rules in the entity cache if it is enabled.
	 *
	 * @param programDutyRules the program duty rules
	 */
	@Override
	public void cacheResult(List<ProgramDutyRule> programDutyRules) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (programDutyRules.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgramDutyRule programDutyRule : programDutyRules) {
			if (entityCache.getResult(
					ProgramDutyRuleImpl.class,
					programDutyRule.getPrimaryKey()) == null) {

				cacheResult(programDutyRule);
			}
		}
	}

	/**
	 * Clears the cache for all program duty rules.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgramDutyRuleImpl.class);

		finderCache.clearCache(ProgramDutyRuleImpl.class);
	}

	/**
	 * Clears the cache for the program duty rule.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProgramDutyRule programDutyRule) {
		entityCache.removeResult(ProgramDutyRuleImpl.class, programDutyRule);
	}

	@Override
	public void clearCache(List<ProgramDutyRule> programDutyRules) {
		for (ProgramDutyRule programDutyRule : programDutyRules) {
			entityCache.removeResult(
				ProgramDutyRuleImpl.class, programDutyRule);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgramDutyRuleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProgramDutyRuleImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgramDutyRuleModelImpl programDutyRuleModelImpl) {

		Object[] args = new Object[] {
			programDutyRuleModelImpl.getUuid(),
			programDutyRuleModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, programDutyRuleModelImpl);
	}

	/**
	 * Creates a new program duty rule with the primary key. Does not add the program duty rule to the database.
	 *
	 * @param programDutyRuleId the primary key for the new program duty rule
	 * @return the new program duty rule
	 */
	@Override
	public ProgramDutyRule create(long programDutyRuleId) {
		ProgramDutyRule programDutyRule = new ProgramDutyRuleImpl();

		programDutyRule.setNew(true);
		programDutyRule.setPrimaryKey(programDutyRuleId);

		String uuid = _portalUUID.generate();

		programDutyRule.setUuid(uuid);

		programDutyRule.setCompanyId(CompanyThreadLocal.getCompanyId());

		return programDutyRule;
	}

	/**
	 * Removes the program duty rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule that was removed
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	@Override
	public ProgramDutyRule remove(long programDutyRuleId)
		throws NoSuchProgramDutyRuleException {

		return remove((Serializable)programDutyRuleId);
	}

	/**
	 * Removes the program duty rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the program duty rule
	 * @return the program duty rule that was removed
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	@Override
	public ProgramDutyRule remove(Serializable primaryKey)
		throws NoSuchProgramDutyRuleException {

		Session session = null;

		try {
			session = openSession();

			ProgramDutyRule programDutyRule = (ProgramDutyRule)session.get(
				ProgramDutyRuleImpl.class, primaryKey);

			if (programDutyRule == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgramDutyRuleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(programDutyRule);
		}
		catch (NoSuchProgramDutyRuleException noSuchEntityException) {
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
	protected ProgramDutyRule removeImpl(ProgramDutyRule programDutyRule) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(programDutyRule)) {
				programDutyRule = (ProgramDutyRule)session.get(
					ProgramDutyRuleImpl.class,
					programDutyRule.getPrimaryKeyObj());
			}

			if (programDutyRule != null) {
				session.delete(programDutyRule);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (programDutyRule != null) {
			clearCache(programDutyRule);
		}

		return programDutyRule;
	}

	@Override
	public ProgramDutyRule updateImpl(ProgramDutyRule programDutyRule) {
		boolean isNew = programDutyRule.isNew();

		if (!(programDutyRule instanceof ProgramDutyRuleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(programDutyRule.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					programDutyRule);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in programDutyRule proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgramDutyRule implementation " +
					programDutyRule.getClass());
		}

		ProgramDutyRuleModelImpl programDutyRuleModelImpl =
			(ProgramDutyRuleModelImpl)programDutyRule;

		if (Validator.isNull(programDutyRule.getUuid())) {
			String uuid = _portalUUID.generate();

			programDutyRule.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (programDutyRule.getCreateDate() == null)) {
			if (serviceContext == null) {
				programDutyRule.setCreateDate(date);
			}
			else {
				programDutyRule.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!programDutyRuleModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				programDutyRule.setModifiedDate(date);
			}
			else {
				programDutyRule.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(programDutyRule);
			}
			else {
				programDutyRule = (ProgramDutyRule)session.merge(
					programDutyRule);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgramDutyRuleImpl.class, programDutyRuleModelImpl, false, true);

		cacheUniqueFindersCache(programDutyRuleModelImpl);

		if (isNew) {
			programDutyRule.setNew(false);
		}

		programDutyRule.resetOriginalValues();

		return programDutyRule;
	}

	/**
	 * Returns the program duty rule with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the program duty rule
	 * @return the program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	@Override
	public ProgramDutyRule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgramDutyRuleException {

		ProgramDutyRule programDutyRule = fetchByPrimaryKey(primaryKey);

		if (programDutyRule == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgramDutyRuleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return programDutyRule;
	}

	/**
	 * Returns the program duty rule with the primary key or throws a <code>NoSuchProgramDutyRuleException</code> if it could not be found.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	@Override
	public ProgramDutyRule findByPrimaryKey(long programDutyRuleId)
		throws NoSuchProgramDutyRuleException {

		return findByPrimaryKey((Serializable)programDutyRuleId);
	}

	/**
	 * Returns the program duty rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule, or <code>null</code> if a program duty rule with the primary key could not be found
	 */
	@Override
	public ProgramDutyRule fetchByPrimaryKey(long programDutyRuleId) {
		return fetchByPrimaryKey((Serializable)programDutyRuleId);
	}

	/**
	 * Returns all the program duty rules.
	 *
	 * @return the program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findAll(
		int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program duty rules
	 */
	@Override
	public List<ProgramDutyRule> findAll(
		int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator,
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

		List<ProgramDutyRule> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyRule>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGRAMDUTYRULE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRAMDUTYRULE;

				sql = sql.concat(ProgramDutyRuleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgramDutyRule>)QueryUtil.list(
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
	 * Removes all the program duty rules from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgramDutyRule programDutyRule : findAll()) {
			remove(programDutyRule);
		}
	}

	/**
	 * Returns the number of program duty rules.
	 *
	 * @return the number of program duty rules
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROGRAMDUTYRULE);

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
		return "program_duty_rule_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGRAMDUTYRULE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgramDutyRuleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the program duty rule persistence.
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

		_finderPathWithPaginationFindByProgramIdAndCohortId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProgramIdAndCohortId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"program_id", "cohort_id"}, true);

		_finderPathWithoutPaginationFindByProgramIdAndCohortId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProgramIdAndCohortId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_id", "cohort_id"}, true);

		_finderPathCountByProgramIdAndCohortId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramIdAndCohortId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_id", "cohort_id"}, false);

		_setProgramDutyRuleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgramDutyRuleUtilPersistence(null);

		entityCache.removeCache(ProgramDutyRuleImpl.class.getName());
	}

	private void _setProgramDutyRuleUtilPersistence(
		ProgramDutyRulePersistence programDutyRulePersistence) {

		try {
			Field field = ProgramDutyRuleUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, programDutyRulePersistence);
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

	private static final String _SQL_SELECT_PROGRAMDUTYRULE =
		"SELECT programDutyRule FROM ProgramDutyRule programDutyRule";

	private static final String _SQL_SELECT_PROGRAMDUTYRULE_WHERE =
		"SELECT programDutyRule FROM ProgramDutyRule programDutyRule WHERE ";

	private static final String _SQL_COUNT_PROGRAMDUTYRULE =
		"SELECT COUNT(programDutyRule) FROM ProgramDutyRule programDutyRule";

	private static final String _SQL_COUNT_PROGRAMDUTYRULE_WHERE =
		"SELECT COUNT(programDutyRule) FROM ProgramDutyRule programDutyRule WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "programDutyRule.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgramDutyRule exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgramDutyRule exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgramDutyRulePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "programDutyRuleId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "programId",
			"dutyRuleId", "cohortId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchDutyLogViolationException;
import gov.omsb.tms.model.DutyLogViolation;
import gov.omsb.tms.model.DutyLogViolationTable;
import gov.omsb.tms.model.impl.DutyLogViolationImpl;
import gov.omsb.tms.model.impl.DutyLogViolationModelImpl;
import gov.omsb.tms.service.persistence.DutyLogViolationPersistence;
import gov.omsb.tms.service.persistence.DutyLogViolationUtil;
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
 * The persistence implementation for the duty log violation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DutyLogViolationPersistence.class)
public class DutyLogViolationPersistenceImpl
	extends BasePersistenceImpl<DutyLogViolation>
	implements DutyLogViolationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DutyLogViolationUtil</code> to access the duty log violation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DutyLogViolationImpl.class.getName();

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
	 * Returns all the duty log violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator,
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

		List<DutyLogViolation> list = null;

		if (useFinderCache) {
			list = (List<DutyLogViolation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLogViolation dutyLogViolation : list) {
					if (!uuid.equals(dutyLogViolation.getUuid())) {
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

			sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

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
				sb.append(DutyLogViolationModelImpl.ORDER_BY_JPQL);
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

				list = (List<DutyLogViolation>)QueryUtil.list(
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
	 * Returns the first duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByUuid_First(
			String uuid, OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByUuid_First(
			uuid, orderByComparator);

		if (dutyLogViolation != null) {
			return dutyLogViolation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDutyLogViolationException(sb.toString());
	}

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByUuid_First(
		String uuid, OrderByComparator<DutyLogViolation> orderByComparator) {

		List<DutyLogViolation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByUuid_Last(
			String uuid, OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByUuid_Last(
			uuid, orderByComparator);

		if (dutyLogViolation != null) {
			return dutyLogViolation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDutyLogViolationException(sb.toString());
	}

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByUuid_Last(
		String uuid, OrderByComparator<DutyLogViolation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DutyLogViolation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	@Override
	public DutyLogViolation[] findByUuid_PrevAndNext(
			long ViolationId, String uuid,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		uuid = Objects.toString(uuid, "");

		DutyLogViolation dutyLogViolation = findByPrimaryKey(ViolationId);

		Session session = null;

		try {
			session = openSession();

			DutyLogViolation[] array = new DutyLogViolationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dutyLogViolation, uuid, orderByComparator, true);

			array[1] = dutyLogViolation;

			array[2] = getByUuid_PrevAndNext(
				session, dutyLogViolation, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyLogViolation getByUuid_PrevAndNext(
		Session session, DutyLogViolation dutyLogViolation, String uuid,
		OrderByComparator<DutyLogViolation> orderByComparator,
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

		sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

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
			sb.append(DutyLogViolationModelImpl.ORDER_BY_JPQL);
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
						dutyLogViolation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLogViolation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty log violations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DutyLogViolation dutyLogViolation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dutyLogViolation);
		}
	}

	/**
	 * Returns the number of duty log violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty log violations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYLOGVIOLATION_WHERE);

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
		"dutyLogViolation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dutyLogViolation.uuid IS NULL OR dutyLogViolation.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByUUID_G(uuid, groupId);

		if (dutyLogViolation == null) {
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

			throw new NoSuchDutyLogViolationException(sb.toString());
		}

		return dutyLogViolation;
	}

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByUUID_G(
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

		if (result instanceof DutyLogViolation) {
			DutyLogViolation dutyLogViolation = (DutyLogViolation)result;

			if (!Objects.equals(uuid, dutyLogViolation.getUuid()) ||
				(groupId != dutyLogViolation.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

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

				List<DutyLogViolation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DutyLogViolation dutyLogViolation = list.get(0);

					result = dutyLogViolation;

					cacheResult(dutyLogViolation);
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
			return (DutyLogViolation)result;
		}
	}

	/**
	 * Removes the duty log violation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty log violation that was removed
	 */
	@Override
	public DutyLogViolation removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = findByUUID_G(uuid, groupId);

		return remove(dutyLogViolation);
	}

	/**
	 * Returns the number of duty log violations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty log violations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYLOGVIOLATION_WHERE);

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
		"dutyLogViolation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dutyLogViolation.uuid IS NULL OR dutyLogViolation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dutyLogViolation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator,
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

		List<DutyLogViolation> list = null;

		if (useFinderCache) {
			list = (List<DutyLogViolation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLogViolation dutyLogViolation : list) {
					if (!uuid.equals(dutyLogViolation.getUuid()) ||
						(companyId != dutyLogViolation.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

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
				sb.append(DutyLogViolationModelImpl.ORDER_BY_JPQL);
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

				list = (List<DutyLogViolation>)QueryUtil.list(
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
	 * Returns the first duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dutyLogViolation != null) {
			return dutyLogViolation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDutyLogViolationException(sb.toString());
	}

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		List<DutyLogViolation> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dutyLogViolation != null) {
			return dutyLogViolation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDutyLogViolationException(sb.toString());
	}

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DutyLogViolation> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	@Override
	public DutyLogViolation[] findByUuid_C_PrevAndNext(
			long ViolationId, String uuid, long companyId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		uuid = Objects.toString(uuid, "");

		DutyLogViolation dutyLogViolation = findByPrimaryKey(ViolationId);

		Session session = null;

		try {
			session = openSession();

			DutyLogViolation[] array = new DutyLogViolationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dutyLogViolation, uuid, companyId, orderByComparator,
				true);

			array[1] = dutyLogViolation;

			array[2] = getByUuid_C_PrevAndNext(
				session, dutyLogViolation, uuid, companyId, orderByComparator,
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

	protected DutyLogViolation getByUuid_C_PrevAndNext(
		Session session, DutyLogViolation dutyLogViolation, String uuid,
		long companyId, OrderByComparator<DutyLogViolation> orderByComparator,
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

		sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

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
			sb.append(DutyLogViolationModelImpl.ORDER_BY_JPQL);
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
						dutyLogViolation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLogViolation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty log violations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DutyLogViolation dutyLogViolation :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dutyLogViolation);
		}
	}

	/**
	 * Returns the number of duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty log violations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYLOGVIOLATION_WHERE);

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
		"dutyLogViolation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dutyLogViolation.uuid IS NULL OR dutyLogViolation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dutyLogViolation.companyId = ?";

	private FinderPath _finderPathFetchByTraineeId;
	private FinderPath _finderPathCountByTraineeId;

	/**
	 * Returns the duty log violation where traineeId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByTraineeId(long traineeId)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByTraineeId(traineeId);

		if (dutyLogViolation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeId=");
			sb.append(traineeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDutyLogViolationException(sb.toString());
		}

		return dutyLogViolation;
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByTraineeId(long traineeId) {
		return fetchByTraineeId(traineeId, true);
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByTraineeId(
		long traineeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {traineeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTraineeId, finderArgs, this);
		}

		if (result instanceof DutyLogViolation) {
			DutyLogViolation dutyLogViolation = (DutyLogViolation)result;

			if (traineeId != dutyLogViolation.getTraineeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				List<DutyLogViolation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTraineeId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {traineeId};
							}

							_log.warn(
								"DutyLogViolationPersistenceImpl.fetchByTraineeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DutyLogViolation dutyLogViolation = list.get(0);

					result = dutyLogViolation;

					cacheResult(dutyLogViolation);
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
			return (DutyLogViolation)result;
		}
	}

	/**
	 * Removes the duty log violation where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the duty log violation that was removed
	 */
	@Override
	public DutyLogViolation removeByTraineeId(long traineeId)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = findByTraineeId(traineeId);

		return remove(dutyLogViolation);
	}

	/**
	 * Returns the number of duty log violations where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching duty log violations
	 */
	@Override
	public int countByTraineeId(long traineeId) {
		FinderPath finderPath = _finderPathCountByTraineeId;

		Object[] finderArgs = new Object[] {traineeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYLOGVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

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

	private static final String _FINDER_COLUMN_TRAINEEID_TRAINEEID_2 =
		"dutyLogViolation.traineeId = ?";

	private FinderPath _finderPathWithPaginationFindByTraineeIdAndBlockId;
	private FinderPath _finderPathWithoutPaginationFindByTraineeIdAndBlockId;
	private FinderPath _finderPathCountByTraineeIdAndBlockId;

	/**
	 * Returns all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @return the matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId) {

		return findByTraineeIdAndBlockId(
			traineeId, blockId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end) {

		return findByTraineeIdAndBlockId(traineeId, blockId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return findByTraineeIdAndBlockId(
			traineeId, blockId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	@Override
	public List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTraineeIdAndBlockId;
				finderArgs = new Object[] {traineeId, blockId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTraineeIdAndBlockId;
			finderArgs = new Object[] {
				traineeId, blockId, start, end, orderByComparator
			};
		}

		List<DutyLogViolation> list = null;

		if (useFinderCache) {
			list = (List<DutyLogViolation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyLogViolation dutyLogViolation : list) {
					if ((traineeId != dutyLogViolation.getTraineeId()) ||
						(blockId != dutyLogViolation.getBlockId())) {

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

			sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDBLOCKID_TRAINEEID_2);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDBLOCKID_BLOCKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DutyLogViolationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(blockId);

				list = (List<DutyLogViolation>)QueryUtil.list(
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
	 * Returns the first duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByTraineeIdAndBlockId_First(
			long traineeId, long blockId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByTraineeIdAndBlockId_First(
			traineeId, blockId, orderByComparator);

		if (dutyLogViolation != null) {
			return dutyLogViolation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", blockId=");
		sb.append(blockId);

		sb.append("}");

		throw new NoSuchDutyLogViolationException(sb.toString());
	}

	/**
	 * Returns the first duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByTraineeIdAndBlockId_First(
		long traineeId, long blockId,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		List<DutyLogViolation> list = findByTraineeIdAndBlockId(
			traineeId, blockId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByTraineeIdAndBlockId_Last(
			long traineeId, long blockId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByTraineeIdAndBlockId_Last(
			traineeId, blockId, orderByComparator);

		if (dutyLogViolation != null) {
			return dutyLogViolation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", blockId=");
		sb.append(blockId);

		sb.append("}");

		throw new NoSuchDutyLogViolationException(sb.toString());
	}

	/**
	 * Returns the last duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByTraineeIdAndBlockId_Last(
		long traineeId, long blockId,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		int count = countByTraineeIdAndBlockId(traineeId, blockId);

		if (count == 0) {
			return null;
		}

		List<DutyLogViolation> list = findByTraineeIdAndBlockId(
			traineeId, blockId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	@Override
	public DutyLogViolation[] findByTraineeIdAndBlockId_PrevAndNext(
			long ViolationId, long traineeId, long blockId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = findByPrimaryKey(ViolationId);

		Session session = null;

		try {
			session = openSession();

			DutyLogViolation[] array = new DutyLogViolationImpl[3];

			array[0] = getByTraineeIdAndBlockId_PrevAndNext(
				session, dutyLogViolation, traineeId, blockId,
				orderByComparator, true);

			array[1] = dutyLogViolation;

			array[2] = getByTraineeIdAndBlockId_PrevAndNext(
				session, dutyLogViolation, traineeId, blockId,
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

	protected DutyLogViolation getByTraineeIdAndBlockId_PrevAndNext(
		Session session, DutyLogViolation dutyLogViolation, long traineeId,
		long blockId, OrderByComparator<DutyLogViolation> orderByComparator,
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

		sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

		sb.append(_FINDER_COLUMN_TRAINEEIDANDBLOCKID_TRAINEEID_2);

		sb.append(_FINDER_COLUMN_TRAINEEIDANDBLOCKID_BLOCKID_2);

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
			sb.append(DutyLogViolationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeId);

		queryPos.add(blockId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dutyLogViolation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyLogViolation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty log violations where traineeId = &#63; and blockId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 */
	@Override
	public void removeByTraineeIdAndBlockId(long traineeId, long blockId) {
		for (DutyLogViolation dutyLogViolation :
				findByTraineeIdAndBlockId(
					traineeId, blockId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dutyLogViolation);
		}
	}

	/**
	 * Returns the number of duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @return the number of matching duty log violations
	 */
	@Override
	public int countByTraineeIdAndBlockId(long traineeId, long blockId) {
		FinderPath finderPath = _finderPathCountByTraineeIdAndBlockId;

		Object[] finderArgs = new Object[] {traineeId, blockId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYLOGVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDBLOCKID_TRAINEEID_2);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDBLOCKID_BLOCKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(blockId);

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

	private static final String _FINDER_COLUMN_TRAINEEIDANDBLOCKID_TRAINEEID_2 =
		"dutyLogViolation.traineeId = ? AND ";

	private static final String _FINDER_COLUMN_TRAINEEIDANDBLOCKID_BLOCKID_2 =
		"dutyLogViolation.blockId = ?";

	private FinderPath _finderPathFetchByTraineeAndBlockAndProgramAndDutyLogId;
	private FinderPath _finderPathCountByTraineeAndBlockAndProgramAndDutyLogId;

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByTraineeAndBlockAndProgramAndDutyLogId(
			long traineeId, long blockId, long programMasterId, long dutyLogId)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation =
			fetchByTraineeAndBlockAndProgramAndDutyLogId(
				traineeId, blockId, programMasterId, dutyLogId);

		if (dutyLogViolation == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeId=");
			sb.append(traineeId);

			sb.append(", blockId=");
			sb.append(blockId);

			sb.append(", programMasterId=");
			sb.append(programMasterId);

			sb.append(", dutyLogId=");
			sb.append(dutyLogId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDutyLogViolationException(sb.toString());
		}

		return dutyLogViolation;
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId) {

		return fetchByTraineeAndBlockAndProgramAndDutyLogId(
			traineeId, blockId, programMasterId, dutyLogId, true);
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				traineeId, blockId, programMasterId, dutyLogId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTraineeAndBlockAndProgramAndDutyLogId,
				finderArgs, this);
		}

		if (result instanceof DutyLogViolation) {
			DutyLogViolation dutyLogViolation = (DutyLogViolation)result;

			if ((traineeId != dutyLogViolation.getTraineeId()) ||
				(blockId != dutyLogViolation.getBlockId()) ||
				(programMasterId != dutyLogViolation.getProgramMasterId()) ||
				(dutyLogId != dutyLogViolation.getDutyLogId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_BLOCKID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_PROGRAMMASTERID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_DUTYLOGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(blockId);

				queryPos.add(programMasterId);

				queryPos.add(dutyLogId);

				List<DutyLogViolation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTraineeAndBlockAndProgramAndDutyLogId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									traineeId, blockId, programMasterId,
									dutyLogId
								};
							}

							_log.warn(
								"DutyLogViolationPersistenceImpl.fetchByTraineeAndBlockAndProgramAndDutyLogId(long, long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DutyLogViolation dutyLogViolation = list.get(0);

					result = dutyLogViolation;

					cacheResult(dutyLogViolation);
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
			return (DutyLogViolation)result;
		}
	}

	/**
	 * Removes the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the duty log violation that was removed
	 */
	@Override
	public DutyLogViolation removeByTraineeAndBlockAndProgramAndDutyLogId(
			long traineeId, long blockId, long programMasterId, long dutyLogId)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation =
			findByTraineeAndBlockAndProgramAndDutyLogId(
				traineeId, blockId, programMasterId, dutyLogId);

		return remove(dutyLogViolation);
	}

	/**
	 * Returns the number of duty log violations where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the number of matching duty log violations
	 */
	@Override
	public int countByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId) {

		FinderPath finderPath =
			_finderPathCountByTraineeAndBlockAndProgramAndDutyLogId;

		Object[] finderArgs = new Object[] {
			traineeId, blockId, programMasterId, dutyLogId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DUTYLOGVIOLATION_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_BLOCKID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_PROGRAMMASTERID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_DUTYLOGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(blockId);

				queryPos.add(programMasterId);

				queryPos.add(dutyLogId);

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
		_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_TRAINEEID_2 =
			"dutyLogViolation.traineeId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_BLOCKID_2 =
			"dutyLogViolation.blockId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_PROGRAMMASTERID_2 =
			"dutyLogViolation.programMasterId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEANDBLOCKANDPROGRAMANDDUTYLOGID_DUTYLOGID_2 =
			"dutyLogViolation.dutyLogId = ?";

	private FinderPath _finderPathFetchByDutyLogId;
	private FinderPath _finderPathCountByDutyLogId;

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation findByDutyLogId(long dutyLogId)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByDutyLogId(dutyLogId);

		if (dutyLogViolation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dutyLogId=");
			sb.append(dutyLogId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDutyLogViolationException(sb.toString());
		}

		return dutyLogViolation;
	}

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByDutyLogId(long dutyLogId) {
		return fetchByDutyLogId(dutyLogId, true);
	}

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyLogId the duty log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public DutyLogViolation fetchByDutyLogId(
		long dutyLogId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dutyLogId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDutyLogId, finderArgs, this);
		}

		if (result instanceof DutyLogViolation) {
			DutyLogViolation dutyLogViolation = (DutyLogViolation)result;

			if (dutyLogId != dutyLogViolation.getDutyLogId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DUTYLOGVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_DUTYLOGID_DUTYLOGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyLogId);

				List<DutyLogViolation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDutyLogId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {dutyLogId};
							}

							_log.warn(
								"DutyLogViolationPersistenceImpl.fetchByDutyLogId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DutyLogViolation dutyLogViolation = list.get(0);

					result = dutyLogViolation;

					cacheResult(dutyLogViolation);
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
			return (DutyLogViolation)result;
		}
	}

	/**
	 * Removes the duty log violation where dutyLogId = &#63; from the database.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the duty log violation that was removed
	 */
	@Override
	public DutyLogViolation removeByDutyLogId(long dutyLogId)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = findByDutyLogId(dutyLogId);

		return remove(dutyLogViolation);
	}

	/**
	 * Returns the number of duty log violations where dutyLogId = &#63;.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the number of matching duty log violations
	 */
	@Override
	public int countByDutyLogId(long dutyLogId) {
		FinderPath finderPath = _finderPathCountByDutyLogId;

		Object[] finderArgs = new Object[] {dutyLogId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYLOGVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_DUTYLOGID_DUTYLOGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyLogId);

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

	private static final String _FINDER_COLUMN_DUTYLOGID_DUTYLOGID_2 =
		"dutyLogViolation.dutyLogId = ?";

	public DutyLogViolationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("ViolationId", "violation_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put("programMasterId", "program_master_id");
		dbColumnNames.put("residencyLevel", "residency_level");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("trainingSiteId", "training_site_id");
		dbColumnNames.put("blockId", "block_id");
		dbColumnNames.put("blockWeekId", "block_week_id");
		dbColumnNames.put("programDutyRuleId", "program_duty_rule_id");
		dbColumnNames.put("acgme80HoursRule", "acgme_80_hours_rule");
		dbColumnNames.put("acgmeCallRuleOption1", "acgme_call_rule_option1");
		dbColumnNames.put("acgmeCallRuleOption2", "acgme_call_rule_option2");
		dbColumnNames.put("acgmeShortBreakRule", "acgme_Short_Break_Rule");
		dbColumnNames.put("acgme24HoursRule", "acgme_24_hours_rule");
		dbColumnNames.put("acgmeDayOffRule", "acgme_day_off_rule");
		dbColumnNames.put("dutyLogId", "duty_log_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(DutyLogViolation.class);

		setModelImplClass(DutyLogViolationImpl.class);
		setModelPKClass(long.class);

		setTable(DutyLogViolationTable.INSTANCE);
	}

	/**
	 * Caches the duty log violation in the entity cache if it is enabled.
	 *
	 * @param dutyLogViolation the duty log violation
	 */
	@Override
	public void cacheResult(DutyLogViolation dutyLogViolation) {
		entityCache.putResult(
			DutyLogViolationImpl.class, dutyLogViolation.getPrimaryKey(),
			dutyLogViolation);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dutyLogViolation.getUuid(), dutyLogViolation.getGroupId()
			},
			dutyLogViolation);

		finderCache.putResult(
			_finderPathFetchByTraineeId,
			new Object[] {dutyLogViolation.getTraineeId()}, dutyLogViolation);

		finderCache.putResult(
			_finderPathFetchByTraineeAndBlockAndProgramAndDutyLogId,
			new Object[] {
				dutyLogViolation.getTraineeId(), dutyLogViolation.getBlockId(),
				dutyLogViolation.getProgramMasterId(),
				dutyLogViolation.getDutyLogId()
			},
			dutyLogViolation);

		finderCache.putResult(
			_finderPathFetchByDutyLogId,
			new Object[] {dutyLogViolation.getDutyLogId()}, dutyLogViolation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the duty log violations in the entity cache if it is enabled.
	 *
	 * @param dutyLogViolations the duty log violations
	 */
	@Override
	public void cacheResult(List<DutyLogViolation> dutyLogViolations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dutyLogViolations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DutyLogViolation dutyLogViolation : dutyLogViolations) {
			if (entityCache.getResult(
					DutyLogViolationImpl.class,
					dutyLogViolation.getPrimaryKey()) == null) {

				cacheResult(dutyLogViolation);
			}
		}
	}

	/**
	 * Clears the cache for all duty log violations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DutyLogViolationImpl.class);

		finderCache.clearCache(DutyLogViolationImpl.class);
	}

	/**
	 * Clears the cache for the duty log violation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DutyLogViolation dutyLogViolation) {
		entityCache.removeResult(DutyLogViolationImpl.class, dutyLogViolation);
	}

	@Override
	public void clearCache(List<DutyLogViolation> dutyLogViolations) {
		for (DutyLogViolation dutyLogViolation : dutyLogViolations) {
			entityCache.removeResult(
				DutyLogViolationImpl.class, dutyLogViolation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DutyLogViolationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DutyLogViolationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DutyLogViolationModelImpl dutyLogViolationModelImpl) {

		Object[] args = new Object[] {
			dutyLogViolationModelImpl.getUuid(),
			dutyLogViolationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dutyLogViolationModelImpl);

		args = new Object[] {dutyLogViolationModelImpl.getTraineeId()};

		finderCache.putResult(
			_finderPathCountByTraineeId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTraineeId, args, dutyLogViolationModelImpl);

		args = new Object[] {
			dutyLogViolationModelImpl.getTraineeId(),
			dutyLogViolationModelImpl.getBlockId(),
			dutyLogViolationModelImpl.getProgramMasterId(),
			dutyLogViolationModelImpl.getDutyLogId()
		};

		finderCache.putResult(
			_finderPathCountByTraineeAndBlockAndProgramAndDutyLogId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTraineeAndBlockAndProgramAndDutyLogId, args,
			dutyLogViolationModelImpl);

		args = new Object[] {dutyLogViolationModelImpl.getDutyLogId()};

		finderCache.putResult(
			_finderPathCountByDutyLogId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDutyLogId, args, dutyLogViolationModelImpl);
	}

	/**
	 * Creates a new duty log violation with the primary key. Does not add the duty log violation to the database.
	 *
	 * @param ViolationId the primary key for the new duty log violation
	 * @return the new duty log violation
	 */
	@Override
	public DutyLogViolation create(long ViolationId) {
		DutyLogViolation dutyLogViolation = new DutyLogViolationImpl();

		dutyLogViolation.setNew(true);
		dutyLogViolation.setPrimaryKey(ViolationId);

		String uuid = _portalUUID.generate();

		dutyLogViolation.setUuid(uuid);

		dutyLogViolation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dutyLogViolation;
	}

	/**
	 * Removes the duty log violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation that was removed
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	@Override
	public DutyLogViolation remove(long ViolationId)
		throws NoSuchDutyLogViolationException {

		return remove((Serializable)ViolationId);
	}

	/**
	 * Removes the duty log violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the duty log violation
	 * @return the duty log violation that was removed
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	@Override
	public DutyLogViolation remove(Serializable primaryKey)
		throws NoSuchDutyLogViolationException {

		Session session = null;

		try {
			session = openSession();

			DutyLogViolation dutyLogViolation = (DutyLogViolation)session.get(
				DutyLogViolationImpl.class, primaryKey);

			if (dutyLogViolation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDutyLogViolationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dutyLogViolation);
		}
		catch (NoSuchDutyLogViolationException noSuchEntityException) {
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
	protected DutyLogViolation removeImpl(DutyLogViolation dutyLogViolation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dutyLogViolation)) {
				dutyLogViolation = (DutyLogViolation)session.get(
					DutyLogViolationImpl.class,
					dutyLogViolation.getPrimaryKeyObj());
			}

			if (dutyLogViolation != null) {
				session.delete(dutyLogViolation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dutyLogViolation != null) {
			clearCache(dutyLogViolation);
		}

		return dutyLogViolation;
	}

	@Override
	public DutyLogViolation updateImpl(DutyLogViolation dutyLogViolation) {
		boolean isNew = dutyLogViolation.isNew();

		if (!(dutyLogViolation instanceof DutyLogViolationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dutyLogViolation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dutyLogViolation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dutyLogViolation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DutyLogViolation implementation " +
					dutyLogViolation.getClass());
		}

		DutyLogViolationModelImpl dutyLogViolationModelImpl =
			(DutyLogViolationModelImpl)dutyLogViolation;

		if (Validator.isNull(dutyLogViolation.getUuid())) {
			String uuid = _portalUUID.generate();

			dutyLogViolation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dutyLogViolation.getCreateDate() == null)) {
			if (serviceContext == null) {
				dutyLogViolation.setCreateDate(date);
			}
			else {
				dutyLogViolation.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dutyLogViolationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dutyLogViolation.setModifiedDate(date);
			}
			else {
				dutyLogViolation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dutyLogViolation);
			}
			else {
				dutyLogViolation = (DutyLogViolation)session.merge(
					dutyLogViolation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DutyLogViolationImpl.class, dutyLogViolationModelImpl, false, true);

		cacheUniqueFindersCache(dutyLogViolationModelImpl);

		if (isNew) {
			dutyLogViolation.setNew(false);
		}

		dutyLogViolation.resetOriginalValues();

		return dutyLogViolation;
	}

	/**
	 * Returns the duty log violation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the duty log violation
	 * @return the duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	@Override
	public DutyLogViolation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDutyLogViolationException {

		DutyLogViolation dutyLogViolation = fetchByPrimaryKey(primaryKey);

		if (dutyLogViolation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDutyLogViolationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dutyLogViolation;
	}

	/**
	 * Returns the duty log violation with the primary key or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	@Override
	public DutyLogViolation findByPrimaryKey(long ViolationId)
		throws NoSuchDutyLogViolationException {

		return findByPrimaryKey((Serializable)ViolationId);
	}

	/**
	 * Returns the duty log violation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation, or <code>null</code> if a duty log violation with the primary key could not be found
	 */
	@Override
	public DutyLogViolation fetchByPrimaryKey(long ViolationId) {
		return fetchByPrimaryKey((Serializable)ViolationId);
	}

	/**
	 * Returns all the duty log violations.
	 *
	 * @return the duty log violations
	 */
	@Override
	public List<DutyLogViolation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of duty log violations
	 */
	@Override
	public List<DutyLogViolation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty log violations
	 */
	@Override
	public List<DutyLogViolation> findAll(
		int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty log violations
	 */
	@Override
	public List<DutyLogViolation> findAll(
		int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator,
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

		List<DutyLogViolation> list = null;

		if (useFinderCache) {
			list = (List<DutyLogViolation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DUTYLOGVIOLATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DUTYLOGVIOLATION;

				sql = sql.concat(DutyLogViolationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DutyLogViolation>)QueryUtil.list(
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
	 * Removes all the duty log violations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DutyLogViolation dutyLogViolation : findAll()) {
			remove(dutyLogViolation);
		}
	}

	/**
	 * Returns the number of duty log violations.
	 *
	 * @return the number of duty log violations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DUTYLOGVIOLATION);

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
		return "violation_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DUTYLOGVIOLATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DutyLogViolationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the duty log violation persistence.
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

		_finderPathFetchByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			true);

		_finderPathCountByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			false);

		_finderPathWithPaginationFindByTraineeIdAndBlockId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTraineeIdAndBlockId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"trainee_id", "block_id"}, true);

		_finderPathWithoutPaginationFindByTraineeIdAndBlockId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTraineeIdAndBlockId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"trainee_id", "block_id"}, true);

		_finderPathCountByTraineeIdAndBlockId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTraineeIdAndBlockId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"trainee_id", "block_id"}, false);

		_finderPathFetchByTraineeAndBlockAndProgramAndDutyLogId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByTraineeAndBlockAndProgramAndDutyLogId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Long.class.getName()
				},
				new String[] {
					"trainee_id", "block_id", "program_master_id", "duty_log_id"
				},
				true);

		_finderPathCountByTraineeAndBlockAndProgramAndDutyLogId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByTraineeAndBlockAndProgramAndDutyLogId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Long.class.getName()
				},
				new String[] {
					"trainee_id", "block_id", "program_master_id", "duty_log_id"
				},
				false);

		_finderPathFetchByDutyLogId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDutyLogId",
			new String[] {Long.class.getName()}, new String[] {"duty_log_id"},
			true);

		_finderPathCountByDutyLogId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDutyLogId",
			new String[] {Long.class.getName()}, new String[] {"duty_log_id"},
			false);

		_setDutyLogViolationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDutyLogViolationUtilPersistence(null);

		entityCache.removeCache(DutyLogViolationImpl.class.getName());
	}

	private void _setDutyLogViolationUtilPersistence(
		DutyLogViolationPersistence dutyLogViolationPersistence) {

		try {
			Field field = DutyLogViolationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dutyLogViolationPersistence);
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

	private static final String _SQL_SELECT_DUTYLOGVIOLATION =
		"SELECT dutyLogViolation FROM DutyLogViolation dutyLogViolation";

	private static final String _SQL_SELECT_DUTYLOGVIOLATION_WHERE =
		"SELECT dutyLogViolation FROM DutyLogViolation dutyLogViolation WHERE ";

	private static final String _SQL_COUNT_DUTYLOGVIOLATION =
		"SELECT COUNT(dutyLogViolation) FROM DutyLogViolation dutyLogViolation";

	private static final String _SQL_COUNT_DUTYLOGVIOLATION_WHERE =
		"SELECT COUNT(dutyLogViolation) FROM DutyLogViolation dutyLogViolation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dutyLogViolation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DutyLogViolation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DutyLogViolation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DutyLogViolationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "ViolationId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "traineeId",
			"programMasterId", "residencyLevel", "rotationId", "trainingSiteId",
			"blockId", "blockWeekId", "programDutyRuleId", "acgme80HoursRule",
			"acgmeCallRuleOption1", "acgmeCallRuleOption2",
			"acgmeShortBreakRule", "acgme24HoursRule", "acgmeDayOffRule",
			"dutyLogId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
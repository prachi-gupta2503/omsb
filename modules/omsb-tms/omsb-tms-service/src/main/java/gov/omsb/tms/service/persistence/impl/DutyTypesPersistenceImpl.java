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

import gov.omsb.tms.exception.NoSuchDutyTypesException;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.DutyTypesTable;
import gov.omsb.tms.model.impl.DutyTypesImpl;
import gov.omsb.tms.model.impl.DutyTypesModelImpl;
import gov.omsb.tms.service.persistence.DutyTypesPersistence;
import gov.omsb.tms.service.persistence.DutyTypesUtil;
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
 * The persistence implementation for the duty types service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DutyTypesPersistence.class)
public class DutyTypesPersistenceImpl
	extends BasePersistenceImpl<DutyTypes> implements DutyTypesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DutyTypesUtil</code> to access the duty types persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DutyTypesImpl.class.getName();

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
	 * Returns all the duty typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty typeses
	 */
	@Override
	public List<DutyTypes> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of matching duty typeses
	 */
	@Override
	public List<DutyTypes> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty typeses
	 */
	@Override
	public List<DutyTypes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty typeses
	 */
	@Override
	public List<DutyTypes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator,
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

		List<DutyTypes> list = null;

		if (useFinderCache) {
			list = (List<DutyTypes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyTypes dutyTypes : list) {
					if (!uuid.equals(dutyTypes.getUuid())) {
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

			sb.append(_SQL_SELECT_DUTYTYPES_WHERE);

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
				sb.append(DutyTypesModelImpl.ORDER_BY_JPQL);
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

				list = (List<DutyTypes>)QueryUtil.list(
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
	 * Returns the first duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	@Override
	public DutyTypes findByUuid_First(
			String uuid, OrderByComparator<DutyTypes> orderByComparator)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = fetchByUuid_First(uuid, orderByComparator);

		if (dutyTypes != null) {
			return dutyTypes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDutyTypesException(sb.toString());
	}

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByUuid_First(
		String uuid, OrderByComparator<DutyTypes> orderByComparator) {

		List<DutyTypes> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	@Override
	public DutyTypes findByUuid_Last(
			String uuid, OrderByComparator<DutyTypes> orderByComparator)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = fetchByUuid_Last(uuid, orderByComparator);

		if (dutyTypes != null) {
			return dutyTypes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDutyTypesException(sb.toString());
	}

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByUuid_Last(
		String uuid, OrderByComparator<DutyTypes> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DutyTypes> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty typeses before and after the current duty types in the ordered set where uuid = &#63;.
	 *
	 * @param dutyTypeId the primary key of the current duty types
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	@Override
	public DutyTypes[] findByUuid_PrevAndNext(
			long dutyTypeId, String uuid,
			OrderByComparator<DutyTypes> orderByComparator)
		throws NoSuchDutyTypesException {

		uuid = Objects.toString(uuid, "");

		DutyTypes dutyTypes = findByPrimaryKey(dutyTypeId);

		Session session = null;

		try {
			session = openSession();

			DutyTypes[] array = new DutyTypesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dutyTypes, uuid, orderByComparator, true);

			array[1] = dutyTypes;

			array[2] = getByUuid_PrevAndNext(
				session, dutyTypes, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyTypes getByUuid_PrevAndNext(
		Session session, DutyTypes dutyTypes, String uuid,
		OrderByComparator<DutyTypes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DUTYTYPES_WHERE);

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
			sb.append(DutyTypesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(dutyTypes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyTypes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty typeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DutyTypes dutyTypes :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dutyTypes);
		}
	}

	/**
	 * Returns the number of duty typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty typeses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYTYPES_WHERE);

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
		"dutyTypes.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dutyTypes.uuid IS NULL OR dutyTypes.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	@Override
	public DutyTypes findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = fetchByUUID_G(uuid, groupId);

		if (dutyTypes == null) {
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

			throw new NoSuchDutyTypesException(sb.toString());
		}

		return dutyTypes;
	}

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByUUID_G(
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

		if (result instanceof DutyTypes) {
			DutyTypes dutyTypes = (DutyTypes)result;

			if (!Objects.equals(uuid, dutyTypes.getUuid()) ||
				(groupId != dutyTypes.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DUTYTYPES_WHERE);

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

				List<DutyTypes> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DutyTypes dutyTypes = list.get(0);

					result = dutyTypes;

					cacheResult(dutyTypes);
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
			return (DutyTypes)result;
		}
	}

	/**
	 * Removes the duty types where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty types that was removed
	 */
	@Override
	public DutyTypes removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = findByUUID_G(uuid, groupId);

		return remove(dutyTypes);
	}

	/**
	 * Returns the number of duty typeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty typeses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYTYPES_WHERE);

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
		"dutyTypes.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dutyTypes.uuid IS NULL OR dutyTypes.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dutyTypes.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty typeses
	 */
	@Override
	public List<DutyTypes> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of matching duty typeses
	 */
	@Override
	public List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty typeses
	 */
	@Override
	public List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty typeses
	 */
	@Override
	public List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator,
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

		List<DutyTypes> list = null;

		if (useFinderCache) {
			list = (List<DutyTypes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DutyTypes dutyTypes : list) {
					if (!uuid.equals(dutyTypes.getUuid()) ||
						(companyId != dutyTypes.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DUTYTYPES_WHERE);

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
				sb.append(DutyTypesModelImpl.ORDER_BY_JPQL);
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

				list = (List<DutyTypes>)QueryUtil.list(
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
	 * Returns the first duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	@Override
	public DutyTypes findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyTypes> orderByComparator)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dutyTypes != null) {
			return dutyTypes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDutyTypesException(sb.toString());
	}

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyTypes> orderByComparator) {

		List<DutyTypes> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	@Override
	public DutyTypes findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyTypes> orderByComparator)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dutyTypes != null) {
			return dutyTypes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDutyTypesException(sb.toString());
	}

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyTypes> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DutyTypes> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the duty typeses before and after the current duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyTypeId the primary key of the current duty types
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	@Override
	public DutyTypes[] findByUuid_C_PrevAndNext(
			long dutyTypeId, String uuid, long companyId,
			OrderByComparator<DutyTypes> orderByComparator)
		throws NoSuchDutyTypesException {

		uuid = Objects.toString(uuid, "");

		DutyTypes dutyTypes = findByPrimaryKey(dutyTypeId);

		Session session = null;

		try {
			session = openSession();

			DutyTypes[] array = new DutyTypesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dutyTypes, uuid, companyId, orderByComparator, true);

			array[1] = dutyTypes;

			array[2] = getByUuid_C_PrevAndNext(
				session, dutyTypes, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DutyTypes getByUuid_C_PrevAndNext(
		Session session, DutyTypes dutyTypes, String uuid, long companyId,
		OrderByComparator<DutyTypes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DUTYTYPES_WHERE);

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
			sb.append(DutyTypesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(dutyTypes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DutyTypes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the duty typeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DutyTypes dutyTypes :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dutyTypes);
		}
	}

	/**
	 * Returns the number of duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty typeses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYTYPES_WHERE);

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
		"dutyTypes.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dutyTypes.uuid IS NULL OR dutyTypes.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dutyTypes.companyId = ?";

	private FinderPath _finderPathFetchByDutyType;
	private FinderPath _finderPathCountByDutyType;

	/**
	 * Returns the duty types where dutyType = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyType the duty type
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	@Override
	public DutyTypes findByDutyType(String dutyType)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = fetchByDutyType(dutyType);

		if (dutyTypes == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dutyType=");
			sb.append(dutyType);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDutyTypesException(sb.toString());
		}

		return dutyTypes;
	}

	/**
	 * Returns the duty types where dutyType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyType the duty type
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByDutyType(String dutyType) {
		return fetchByDutyType(dutyType, true);
	}

	/**
	 * Returns the duty types where dutyType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByDutyType(String dutyType, boolean useFinderCache) {
		dutyType = Objects.toString(dutyType, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dutyType};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDutyType, finderArgs, this);
		}

		if (result instanceof DutyTypes) {
			DutyTypes dutyTypes = (DutyTypes)result;

			if (!Objects.equals(dutyType, dutyTypes.getDutyType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DUTYTYPES_WHERE);

			boolean bindDutyType = false;

			if (dutyType.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPE_DUTYTYPE_3);
			}
			else {
				bindDutyType = true;

				sb.append(_FINDER_COLUMN_DUTYTYPE_DUTYTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDutyType) {
					queryPos.add(dutyType);
				}

				List<DutyTypes> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDutyType, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {dutyType};
							}

							_log.warn(
								"DutyTypesPersistenceImpl.fetchByDutyType(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DutyTypes dutyTypes = list.get(0);

					result = dutyTypes;

					cacheResult(dutyTypes);
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
			return (DutyTypes)result;
		}
	}

	/**
	 * Removes the duty types where dutyType = &#63; from the database.
	 *
	 * @param dutyType the duty type
	 * @return the duty types that was removed
	 */
	@Override
	public DutyTypes removeByDutyType(String dutyType)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = findByDutyType(dutyType);

		return remove(dutyTypes);
	}

	/**
	 * Returns the number of duty typeses where dutyType = &#63;.
	 *
	 * @param dutyType the duty type
	 * @return the number of matching duty typeses
	 */
	@Override
	public int countByDutyType(String dutyType) {
		dutyType = Objects.toString(dutyType, "");

		FinderPath finderPath = _finderPathCountByDutyType;

		Object[] finderArgs = new Object[] {dutyType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DUTYTYPES_WHERE);

			boolean bindDutyType = false;

			if (dutyType.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPE_DUTYTYPE_3);
			}
			else {
				bindDutyType = true;

				sb.append(_FINDER_COLUMN_DUTYTYPE_DUTYTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDutyType) {
					queryPos.add(dutyType);
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

	private static final String _FINDER_COLUMN_DUTYTYPE_DUTYTYPE_2 =
		"dutyTypes.dutyType = ?";

	private static final String _FINDER_COLUMN_DUTYTYPE_DUTYTYPE_3 =
		"(dutyTypes.dutyType IS NULL OR dutyTypes.dutyType = '')";

	private FinderPath _finderPathFetchByDutyTypeAndStatus;
	private FinderPath _finderPathCountByDutyTypeAndStatus;

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	@Override
	public DutyTypes findByDutyTypeAndStatus(String dutyType, String status)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = fetchByDutyTypeAndStatus(dutyType, status);

		if (dutyTypes == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dutyType=");
			sb.append(dutyType);

			sb.append(", status=");
			sb.append(status);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDutyTypesException(sb.toString());
		}

		return dutyTypes;
	}

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByDutyTypeAndStatus(String dutyType, String status) {
		return fetchByDutyTypeAndStatus(dutyType, status, true);
	}

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public DutyTypes fetchByDutyTypeAndStatus(
		String dutyType, String status, boolean useFinderCache) {

		dutyType = Objects.toString(dutyType, "");
		status = Objects.toString(status, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dutyType, status};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDutyTypeAndStatus, finderArgs, this);
		}

		if (result instanceof DutyTypes) {
			DutyTypes dutyTypes = (DutyTypes)result;

			if (!Objects.equals(dutyType, dutyTypes.getDutyType()) ||
				!Objects.equals(status, dutyTypes.getStatus())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DUTYTYPES_WHERE);

			boolean bindDutyType = false;

			if (dutyType.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPEANDSTATUS_DUTYTYPE_3);
			}
			else {
				bindDutyType = true;

				sb.append(_FINDER_COLUMN_DUTYTYPEANDSTATUS_DUTYTYPE_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPEANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_DUTYTYPEANDSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDutyType) {
					queryPos.add(dutyType);
				}

				if (bindStatus) {
					queryPos.add(status);
				}

				List<DutyTypes> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDutyTypeAndStatus, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {dutyType, status};
							}

							_log.warn(
								"DutyTypesPersistenceImpl.fetchByDutyTypeAndStatus(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DutyTypes dutyTypes = list.get(0);

					result = dutyTypes;

					cacheResult(dutyTypes);
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
			return (DutyTypes)result;
		}
	}

	/**
	 * Removes the duty types where dutyType = &#63; and status = &#63; from the database.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the duty types that was removed
	 */
	@Override
	public DutyTypes removeByDutyTypeAndStatus(String dutyType, String status)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = findByDutyTypeAndStatus(dutyType, status);

		return remove(dutyTypes);
	}

	/**
	 * Returns the number of duty typeses where dutyType = &#63; and status = &#63;.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the number of matching duty typeses
	 */
	@Override
	public int countByDutyTypeAndStatus(String dutyType, String status) {
		dutyType = Objects.toString(dutyType, "");
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByDutyTypeAndStatus;

		Object[] finderArgs = new Object[] {dutyType, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DUTYTYPES_WHERE);

			boolean bindDutyType = false;

			if (dutyType.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPEANDSTATUS_DUTYTYPE_3);
			}
			else {
				bindDutyType = true;

				sb.append(_FINDER_COLUMN_DUTYTYPEANDSTATUS_DUTYTYPE_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYTYPEANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_DUTYTYPEANDSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDutyType) {
					queryPos.add(dutyType);
				}

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

	private static final String _FINDER_COLUMN_DUTYTYPEANDSTATUS_DUTYTYPE_2 =
		"dutyTypes.dutyType = ? AND ";

	private static final String _FINDER_COLUMN_DUTYTYPEANDSTATUS_DUTYTYPE_3 =
		"(dutyTypes.dutyType IS NULL OR dutyTypes.dutyType = '') AND ";

	private static final String _FINDER_COLUMN_DUTYTYPEANDSTATUS_STATUS_2 =
		"dutyTypes.status = ?";

	private static final String _FINDER_COLUMN_DUTYTYPEANDSTATUS_STATUS_3 =
		"(dutyTypes.status IS NULL OR dutyTypes.status = '')";

	public DutyTypesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("dutyTypeId", "duty_type_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("dutyType", "duty_type");

		setDBColumnNames(dbColumnNames);

		setModelClass(DutyTypes.class);

		setModelImplClass(DutyTypesImpl.class);
		setModelPKClass(long.class);

		setTable(DutyTypesTable.INSTANCE);
	}

	/**
	 * Caches the duty types in the entity cache if it is enabled.
	 *
	 * @param dutyTypes the duty types
	 */
	@Override
	public void cacheResult(DutyTypes dutyTypes) {
		entityCache.putResult(
			DutyTypesImpl.class, dutyTypes.getPrimaryKey(), dutyTypes);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {dutyTypes.getUuid(), dutyTypes.getGroupId()},
			dutyTypes);

		finderCache.putResult(
			_finderPathFetchByDutyType, new Object[] {dutyTypes.getDutyType()},
			dutyTypes);

		finderCache.putResult(
			_finderPathFetchByDutyTypeAndStatus,
			new Object[] {dutyTypes.getDutyType(), dutyTypes.getStatus()},
			dutyTypes);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the duty typeses in the entity cache if it is enabled.
	 *
	 * @param dutyTypeses the duty typeses
	 */
	@Override
	public void cacheResult(List<DutyTypes> dutyTypeses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dutyTypeses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DutyTypes dutyTypes : dutyTypeses) {
			if (entityCache.getResult(
					DutyTypesImpl.class, dutyTypes.getPrimaryKey()) == null) {

				cacheResult(dutyTypes);
			}
		}
	}

	/**
	 * Clears the cache for all duty typeses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DutyTypesImpl.class);

		finderCache.clearCache(DutyTypesImpl.class);
	}

	/**
	 * Clears the cache for the duty types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DutyTypes dutyTypes) {
		entityCache.removeResult(DutyTypesImpl.class, dutyTypes);
	}

	@Override
	public void clearCache(List<DutyTypes> dutyTypeses) {
		for (DutyTypes dutyTypes : dutyTypeses) {
			entityCache.removeResult(DutyTypesImpl.class, dutyTypes);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DutyTypesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DutyTypesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DutyTypesModelImpl dutyTypesModelImpl) {

		Object[] args = new Object[] {
			dutyTypesModelImpl.getUuid(), dutyTypesModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dutyTypesModelImpl);

		args = new Object[] {dutyTypesModelImpl.getDutyType()};

		finderCache.putResult(
			_finderPathCountByDutyType, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDutyType, args, dutyTypesModelImpl);

		args = new Object[] {
			dutyTypesModelImpl.getDutyType(), dutyTypesModelImpl.getStatus()
		};

		finderCache.putResult(
			_finderPathCountByDutyTypeAndStatus, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDutyTypeAndStatus, args, dutyTypesModelImpl);
	}

	/**
	 * Creates a new duty types with the primary key. Does not add the duty types to the database.
	 *
	 * @param dutyTypeId the primary key for the new duty types
	 * @return the new duty types
	 */
	@Override
	public DutyTypes create(long dutyTypeId) {
		DutyTypes dutyTypes = new DutyTypesImpl();

		dutyTypes.setNew(true);
		dutyTypes.setPrimaryKey(dutyTypeId);

		String uuid = _portalUUID.generate();

		dutyTypes.setUuid(uuid);

		dutyTypes.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dutyTypes;
	}

	/**
	 * Removes the duty types with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types that was removed
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	@Override
	public DutyTypes remove(long dutyTypeId) throws NoSuchDutyTypesException {
		return remove((Serializable)dutyTypeId);
	}

	/**
	 * Removes the duty types with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the duty types
	 * @return the duty types that was removed
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	@Override
	public DutyTypes remove(Serializable primaryKey)
		throws NoSuchDutyTypesException {

		Session session = null;

		try {
			session = openSession();

			DutyTypes dutyTypes = (DutyTypes)session.get(
				DutyTypesImpl.class, primaryKey);

			if (dutyTypes == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDutyTypesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dutyTypes);
		}
		catch (NoSuchDutyTypesException noSuchEntityException) {
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
	protected DutyTypes removeImpl(DutyTypes dutyTypes) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dutyTypes)) {
				dutyTypes = (DutyTypes)session.get(
					DutyTypesImpl.class, dutyTypes.getPrimaryKeyObj());
			}

			if (dutyTypes != null) {
				session.delete(dutyTypes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dutyTypes != null) {
			clearCache(dutyTypes);
		}

		return dutyTypes;
	}

	@Override
	public DutyTypes updateImpl(DutyTypes dutyTypes) {
		boolean isNew = dutyTypes.isNew();

		if (!(dutyTypes instanceof DutyTypesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dutyTypes.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dutyTypes);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dutyTypes proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DutyTypes implementation " +
					dutyTypes.getClass());
		}

		DutyTypesModelImpl dutyTypesModelImpl = (DutyTypesModelImpl)dutyTypes;

		if (Validator.isNull(dutyTypes.getUuid())) {
			String uuid = _portalUUID.generate();

			dutyTypes.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dutyTypes.getCreateDate() == null)) {
			if (serviceContext == null) {
				dutyTypes.setCreateDate(date);
			}
			else {
				dutyTypes.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!dutyTypesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dutyTypes.setModifiedDate(date);
			}
			else {
				dutyTypes.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dutyTypes);
			}
			else {
				dutyTypes = (DutyTypes)session.merge(dutyTypes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DutyTypesImpl.class, dutyTypesModelImpl, false, true);

		cacheUniqueFindersCache(dutyTypesModelImpl);

		if (isNew) {
			dutyTypes.setNew(false);
		}

		dutyTypes.resetOriginalValues();

		return dutyTypes;
	}

	/**
	 * Returns the duty types with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the duty types
	 * @return the duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	@Override
	public DutyTypes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDutyTypesException {

		DutyTypes dutyTypes = fetchByPrimaryKey(primaryKey);

		if (dutyTypes == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDutyTypesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dutyTypes;
	}

	/**
	 * Returns the duty types with the primary key or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	@Override
	public DutyTypes findByPrimaryKey(long dutyTypeId)
		throws NoSuchDutyTypesException {

		return findByPrimaryKey((Serializable)dutyTypeId);
	}

	/**
	 * Returns the duty types with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types, or <code>null</code> if a duty types with the primary key could not be found
	 */
	@Override
	public DutyTypes fetchByPrimaryKey(long dutyTypeId) {
		return fetchByPrimaryKey((Serializable)dutyTypeId);
	}

	/**
	 * Returns all the duty typeses.
	 *
	 * @return the duty typeses
	 */
	@Override
	public List<DutyTypes> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of duty typeses
	 */
	@Override
	public List<DutyTypes> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty typeses
	 */
	@Override
	public List<DutyTypes> findAll(
		int start, int end, OrderByComparator<DutyTypes> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty typeses
	 */
	@Override
	public List<DutyTypes> findAll(
		int start, int end, OrderByComparator<DutyTypes> orderByComparator,
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

		List<DutyTypes> list = null;

		if (useFinderCache) {
			list = (List<DutyTypes>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DUTYTYPES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DUTYTYPES;

				sql = sql.concat(DutyTypesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DutyTypes>)QueryUtil.list(
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
	 * Removes all the duty typeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DutyTypes dutyTypes : findAll()) {
			remove(dutyTypes);
		}
	}

	/**
	 * Returns the number of duty typeses.
	 *
	 * @return the number of duty typeses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DUTYTYPES);

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
		return "duty_type_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DUTYTYPES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DutyTypesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the duty types persistence.
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

		_finderPathFetchByDutyType = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDutyType",
			new String[] {String.class.getName()}, new String[] {"duty_type"},
			true);

		_finderPathCountByDutyType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDutyType",
			new String[] {String.class.getName()}, new String[] {"duty_type"},
			false);

		_finderPathFetchByDutyTypeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDutyTypeAndStatus",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"duty_type", "status"}, true);

		_finderPathCountByDutyTypeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDutyTypeAndStatus",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"duty_type", "status"}, false);

		_setDutyTypesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDutyTypesUtilPersistence(null);

		entityCache.removeCache(DutyTypesImpl.class.getName());
	}

	private void _setDutyTypesUtilPersistence(
		DutyTypesPersistence dutyTypesPersistence) {

		try {
			Field field = DutyTypesUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, dutyTypesPersistence);
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

	private static final String _SQL_SELECT_DUTYTYPES =
		"SELECT dutyTypes FROM DutyTypes dutyTypes";

	private static final String _SQL_SELECT_DUTYTYPES_WHERE =
		"SELECT dutyTypes FROM DutyTypes dutyTypes WHERE ";

	private static final String _SQL_COUNT_DUTYTYPES =
		"SELECT COUNT(dutyTypes) FROM DutyTypes dutyTypes";

	private static final String _SQL_COUNT_DUTYTYPES_WHERE =
		"SELECT COUNT(dutyTypes) FROM DutyTypes dutyTypes WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dutyTypes.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DutyTypes exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DutyTypes exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DutyTypesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "dutyTypeId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "dutyType"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
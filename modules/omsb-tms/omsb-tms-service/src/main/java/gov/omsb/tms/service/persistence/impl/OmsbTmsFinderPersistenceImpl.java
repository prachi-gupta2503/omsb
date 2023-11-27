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

import gov.omsb.tms.exception.NoSuchOmsbTmsFinderException;
import gov.omsb.tms.model.OmsbTmsFinder;
import gov.omsb.tms.model.OmsbTmsFinderTable;
import gov.omsb.tms.model.impl.OmsbTmsFinderImpl;
import gov.omsb.tms.model.impl.OmsbTmsFinderModelImpl;
import gov.omsb.tms.service.persistence.OmsbTmsFinderPersistence;
import gov.omsb.tms.service.persistence.OmsbTmsFinderUtil;
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
 * The persistence implementation for the omsb tms finder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OmsbTmsFinderPersistence.class)
public class OmsbTmsFinderPersistenceImpl
	extends BasePersistenceImpl<OmsbTmsFinder>
	implements OmsbTmsFinderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OmsbTmsFinderUtil</code> to access the omsb tms finder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OmsbTmsFinderImpl.class.getName();

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
	 * Returns all the omsb tms finders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the omsb tms finders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @return the range of matching omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator,
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

		List<OmsbTmsFinder> list = null;

		if (useFinderCache) {
			list = (List<OmsbTmsFinder>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OmsbTmsFinder omsbTmsFinder : list) {
					if (!uuid.equals(omsbTmsFinder.getUuid())) {
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

			sb.append(_SQL_SELECT_OMSBTMSFINDER_WHERE);

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
				sb.append(OmsbTmsFinderModelImpl.ORDER_BY_JPQL);
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

				list = (List<OmsbTmsFinder>)QueryUtil.list(
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
	 * Returns the first omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder findByUuid_First(
			String uuid, OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws NoSuchOmsbTmsFinderException {

		OmsbTmsFinder omsbTmsFinder = fetchByUuid_First(
			uuid, orderByComparator);

		if (omsbTmsFinder != null) {
			return omsbTmsFinder;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOmsbTmsFinderException(sb.toString());
	}

	/**
	 * Returns the first omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder fetchByUuid_First(
		String uuid, OrderByComparator<OmsbTmsFinder> orderByComparator) {

		List<OmsbTmsFinder> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder findByUuid_Last(
			String uuid, OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws NoSuchOmsbTmsFinderException {

		OmsbTmsFinder omsbTmsFinder = fetchByUuid_Last(uuid, orderByComparator);

		if (omsbTmsFinder != null) {
			return omsbTmsFinder;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOmsbTmsFinderException(sb.toString());
	}

	/**
	 * Returns the last omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder fetchByUuid_Last(
		String uuid, OrderByComparator<OmsbTmsFinder> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<OmsbTmsFinder> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the omsb tms finders before and after the current omsb tms finder in the ordered set where uuid = &#63;.
	 *
	 * @param omsbTmsFinderId the primary key of the current omsb tms finder
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public OmsbTmsFinder[] findByUuid_PrevAndNext(
			long omsbTmsFinderId, String uuid,
			OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws NoSuchOmsbTmsFinderException {

		uuid = Objects.toString(uuid, "");

		OmsbTmsFinder omsbTmsFinder = findByPrimaryKey(omsbTmsFinderId);

		Session session = null;

		try {
			session = openSession();

			OmsbTmsFinder[] array = new OmsbTmsFinderImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, omsbTmsFinder, uuid, orderByComparator, true);

			array[1] = omsbTmsFinder;

			array[2] = getByUuid_PrevAndNext(
				session, omsbTmsFinder, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OmsbTmsFinder getByUuid_PrevAndNext(
		Session session, OmsbTmsFinder omsbTmsFinder, String uuid,
		OrderByComparator<OmsbTmsFinder> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OMSBTMSFINDER_WHERE);

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
			sb.append(OmsbTmsFinderModelImpl.ORDER_BY_JPQL);
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
						omsbTmsFinder)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OmsbTmsFinder> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the omsb tms finders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (OmsbTmsFinder omsbTmsFinder :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(omsbTmsFinder);
		}
	}

	/**
	 * Returns the number of omsb tms finders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching omsb tms finders
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OMSBTMSFINDER_WHERE);

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
		"omsbTmsFinder.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(omsbTmsFinder.uuid IS NULL OR omsbTmsFinder.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the omsb tms finder where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchOmsbTmsFinderException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder findByUUID_G(String uuid, long groupId)
		throws NoSuchOmsbTmsFinderException {

		OmsbTmsFinder omsbTmsFinder = fetchByUUID_G(uuid, groupId);

		if (omsbTmsFinder == null) {
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

			throw new NoSuchOmsbTmsFinderException(sb.toString());
		}

		return omsbTmsFinder;
	}

	/**
	 * Returns the omsb tms finder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the omsb tms finder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder fetchByUUID_G(
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

		if (result instanceof OmsbTmsFinder) {
			OmsbTmsFinder omsbTmsFinder = (OmsbTmsFinder)result;

			if (!Objects.equals(uuid, omsbTmsFinder.getUuid()) ||
				(groupId != omsbTmsFinder.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_OMSBTMSFINDER_WHERE);

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

				List<OmsbTmsFinder> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					OmsbTmsFinder omsbTmsFinder = list.get(0);

					result = omsbTmsFinder;

					cacheResult(omsbTmsFinder);
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
			return (OmsbTmsFinder)result;
		}
	}

	/**
	 * Removes the omsb tms finder where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the omsb tms finder that was removed
	 */
	@Override
	public OmsbTmsFinder removeByUUID_G(String uuid, long groupId)
		throws NoSuchOmsbTmsFinderException {

		OmsbTmsFinder omsbTmsFinder = findByUUID_G(uuid, groupId);

		return remove(omsbTmsFinder);
	}

	/**
	 * Returns the number of omsb tms finders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching omsb tms finders
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_OMSBTMSFINDER_WHERE);

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
		"omsbTmsFinder.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(omsbTmsFinder.uuid IS NULL OR omsbTmsFinder.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"omsbTmsFinder.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @return the range of matching omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator,
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

		List<OmsbTmsFinder> list = null;

		if (useFinderCache) {
			list = (List<OmsbTmsFinder>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OmsbTmsFinder omsbTmsFinder : list) {
					if (!uuid.equals(omsbTmsFinder.getUuid()) ||
						(companyId != omsbTmsFinder.getCompanyId())) {

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

			sb.append(_SQL_SELECT_OMSBTMSFINDER_WHERE);

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
				sb.append(OmsbTmsFinderModelImpl.ORDER_BY_JPQL);
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

				list = (List<OmsbTmsFinder>)QueryUtil.list(
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
	 * Returns the first omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws NoSuchOmsbTmsFinderException {

		OmsbTmsFinder omsbTmsFinder = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (omsbTmsFinder != null) {
			return omsbTmsFinder;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchOmsbTmsFinderException(sb.toString());
	}

	/**
	 * Returns the first omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		List<OmsbTmsFinder> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws NoSuchOmsbTmsFinderException {

		OmsbTmsFinder omsbTmsFinder = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (omsbTmsFinder != null) {
			return omsbTmsFinder;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchOmsbTmsFinderException(sb.toString());
	}

	/**
	 * Returns the last omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	@Override
	public OmsbTmsFinder fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<OmsbTmsFinder> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the omsb tms finders before and after the current omsb tms finder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param omsbTmsFinderId the primary key of the current omsb tms finder
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public OmsbTmsFinder[] findByUuid_C_PrevAndNext(
			long omsbTmsFinderId, String uuid, long companyId,
			OrderByComparator<OmsbTmsFinder> orderByComparator)
		throws NoSuchOmsbTmsFinderException {

		uuid = Objects.toString(uuid, "");

		OmsbTmsFinder omsbTmsFinder = findByPrimaryKey(omsbTmsFinderId);

		Session session = null;

		try {
			session = openSession();

			OmsbTmsFinder[] array = new OmsbTmsFinderImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, omsbTmsFinder, uuid, companyId, orderByComparator,
				true);

			array[1] = omsbTmsFinder;

			array[2] = getByUuid_C_PrevAndNext(
				session, omsbTmsFinder, uuid, companyId, orderByComparator,
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

	protected OmsbTmsFinder getByUuid_C_PrevAndNext(
		Session session, OmsbTmsFinder omsbTmsFinder, String uuid,
		long companyId, OrderByComparator<OmsbTmsFinder> orderByComparator,
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

		sb.append(_SQL_SELECT_OMSBTMSFINDER_WHERE);

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
			sb.append(OmsbTmsFinderModelImpl.ORDER_BY_JPQL);
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
						omsbTmsFinder)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OmsbTmsFinder> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the omsb tms finders where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (OmsbTmsFinder omsbTmsFinder :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(omsbTmsFinder);
		}
	}

	/**
	 * Returns the number of omsb tms finders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching omsb tms finders
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_OMSBTMSFINDER_WHERE);

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
		"omsbTmsFinder.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(omsbTmsFinder.uuid IS NULL OR omsbTmsFinder.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"omsbTmsFinder.companyId = ?";

	public OmsbTmsFinderPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("omsbTmsFinderId", "omsb_tms_finder_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(OmsbTmsFinder.class);

		setModelImplClass(OmsbTmsFinderImpl.class);
		setModelPKClass(long.class);

		setTable(OmsbTmsFinderTable.INSTANCE);
	}

	/**
	 * Caches the omsb tms finder in the entity cache if it is enabled.
	 *
	 * @param omsbTmsFinder the omsb tms finder
	 */
	@Override
	public void cacheResult(OmsbTmsFinder omsbTmsFinder) {
		entityCache.putResult(
			OmsbTmsFinderImpl.class, omsbTmsFinder.getPrimaryKey(),
			omsbTmsFinder);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {omsbTmsFinder.getUuid(), omsbTmsFinder.getGroupId()},
			omsbTmsFinder);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the omsb tms finders in the entity cache if it is enabled.
	 *
	 * @param omsbTmsFinders the omsb tms finders
	 */
	@Override
	public void cacheResult(List<OmsbTmsFinder> omsbTmsFinders) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (omsbTmsFinders.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (OmsbTmsFinder omsbTmsFinder : omsbTmsFinders) {
			if (entityCache.getResult(
					OmsbTmsFinderImpl.class, omsbTmsFinder.getPrimaryKey()) ==
						null) {

				cacheResult(omsbTmsFinder);
			}
		}
	}

	/**
	 * Clears the cache for all omsb tms finders.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OmsbTmsFinderImpl.class);

		finderCache.clearCache(OmsbTmsFinderImpl.class);
	}

	/**
	 * Clears the cache for the omsb tms finder.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OmsbTmsFinder omsbTmsFinder) {
		entityCache.removeResult(OmsbTmsFinderImpl.class, omsbTmsFinder);
	}

	@Override
	public void clearCache(List<OmsbTmsFinder> omsbTmsFinders) {
		for (OmsbTmsFinder omsbTmsFinder : omsbTmsFinders) {
			entityCache.removeResult(OmsbTmsFinderImpl.class, omsbTmsFinder);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(OmsbTmsFinderImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OmsbTmsFinderImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		OmsbTmsFinderModelImpl omsbTmsFinderModelImpl) {

		Object[] args = new Object[] {
			omsbTmsFinderModelImpl.getUuid(),
			omsbTmsFinderModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, omsbTmsFinderModelImpl);
	}

	/**
	 * Creates a new omsb tms finder with the primary key. Does not add the omsb tms finder to the database.
	 *
	 * @param omsbTmsFinderId the primary key for the new omsb tms finder
	 * @return the new omsb tms finder
	 */
	@Override
	public OmsbTmsFinder create(long omsbTmsFinderId) {
		OmsbTmsFinder omsbTmsFinder = new OmsbTmsFinderImpl();

		omsbTmsFinder.setNew(true);
		omsbTmsFinder.setPrimaryKey(omsbTmsFinderId);

		String uuid = _portalUUID.generate();

		omsbTmsFinder.setUuid(uuid);

		omsbTmsFinder.setCompanyId(CompanyThreadLocal.getCompanyId());

		return omsbTmsFinder;
	}

	/**
	 * Removes the omsb tms finder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder that was removed
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public OmsbTmsFinder remove(long omsbTmsFinderId)
		throws NoSuchOmsbTmsFinderException {

		return remove((Serializable)omsbTmsFinderId);
	}

	/**
	 * Removes the omsb tms finder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the omsb tms finder
	 * @return the omsb tms finder that was removed
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public OmsbTmsFinder remove(Serializable primaryKey)
		throws NoSuchOmsbTmsFinderException {

		Session session = null;

		try {
			session = openSession();

			OmsbTmsFinder omsbTmsFinder = (OmsbTmsFinder)session.get(
				OmsbTmsFinderImpl.class, primaryKey);

			if (omsbTmsFinder == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOmsbTmsFinderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(omsbTmsFinder);
		}
		catch (NoSuchOmsbTmsFinderException noSuchEntityException) {
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
	protected OmsbTmsFinder removeImpl(OmsbTmsFinder omsbTmsFinder) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(omsbTmsFinder)) {
				omsbTmsFinder = (OmsbTmsFinder)session.get(
					OmsbTmsFinderImpl.class, omsbTmsFinder.getPrimaryKeyObj());
			}

			if (omsbTmsFinder != null) {
				session.delete(omsbTmsFinder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (omsbTmsFinder != null) {
			clearCache(omsbTmsFinder);
		}

		return omsbTmsFinder;
	}

	@Override
	public OmsbTmsFinder updateImpl(OmsbTmsFinder omsbTmsFinder) {
		boolean isNew = omsbTmsFinder.isNew();

		if (!(omsbTmsFinder instanceof OmsbTmsFinderModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(omsbTmsFinder.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					omsbTmsFinder);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in omsbTmsFinder proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OmsbTmsFinder implementation " +
					omsbTmsFinder.getClass());
		}

		OmsbTmsFinderModelImpl omsbTmsFinderModelImpl =
			(OmsbTmsFinderModelImpl)omsbTmsFinder;

		if (Validator.isNull(omsbTmsFinder.getUuid())) {
			String uuid = _portalUUID.generate();

			omsbTmsFinder.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (omsbTmsFinder.getCreateDate() == null)) {
			if (serviceContext == null) {
				omsbTmsFinder.setCreateDate(date);
			}
			else {
				omsbTmsFinder.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!omsbTmsFinderModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				omsbTmsFinder.setModifiedDate(date);
			}
			else {
				omsbTmsFinder.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(omsbTmsFinder);
			}
			else {
				omsbTmsFinder = (OmsbTmsFinder)session.merge(omsbTmsFinder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OmsbTmsFinderImpl.class, omsbTmsFinderModelImpl, false, true);

		cacheUniqueFindersCache(omsbTmsFinderModelImpl);

		if (isNew) {
			omsbTmsFinder.setNew(false);
		}

		omsbTmsFinder.resetOriginalValues();

		return omsbTmsFinder;
	}

	/**
	 * Returns the omsb tms finder with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the omsb tms finder
	 * @return the omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public OmsbTmsFinder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOmsbTmsFinderException {

		OmsbTmsFinder omsbTmsFinder = fetchByPrimaryKey(primaryKey);

		if (omsbTmsFinder == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOmsbTmsFinderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return omsbTmsFinder;
	}

	/**
	 * Returns the omsb tms finder with the primary key or throws a <code>NoSuchOmsbTmsFinderException</code> if it could not be found.
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder
	 * @throws NoSuchOmsbTmsFinderException if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public OmsbTmsFinder findByPrimaryKey(long omsbTmsFinderId)
		throws NoSuchOmsbTmsFinderException {

		return findByPrimaryKey((Serializable)omsbTmsFinderId);
	}

	/**
	 * Returns the omsb tms finder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder, or <code>null</code> if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public OmsbTmsFinder fetchByPrimaryKey(long omsbTmsFinderId) {
		return fetchByPrimaryKey((Serializable)omsbTmsFinderId);
	}

	/**
	 * Returns all the omsb tms finders.
	 *
	 * @return the omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the omsb tms finders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @return the range of omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findAll(
		int start, int end,
		OrderByComparator<OmsbTmsFinder> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the omsb tms finders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of omsb tms finders
	 */
	@Override
	public List<OmsbTmsFinder> findAll(
		int start, int end, OrderByComparator<OmsbTmsFinder> orderByComparator,
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

		List<OmsbTmsFinder> list = null;

		if (useFinderCache) {
			list = (List<OmsbTmsFinder>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OMSBTMSFINDER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OMSBTMSFINDER;

				sql = sql.concat(OmsbTmsFinderModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OmsbTmsFinder>)QueryUtil.list(
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
	 * Removes all the omsb tms finders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OmsbTmsFinder omsbTmsFinder : findAll()) {
			remove(omsbTmsFinder);
		}
	}

	/**
	 * Returns the number of omsb tms finders.
	 *
	 * @return the number of omsb tms finders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OMSBTMSFINDER);

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
		return "omsb_tms_finder_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OMSBTMSFINDER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OmsbTmsFinderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the omsb tms finder persistence.
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

		_setOmsbTmsFinderUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setOmsbTmsFinderUtilPersistence(null);

		entityCache.removeCache(OmsbTmsFinderImpl.class.getName());
	}

	private void _setOmsbTmsFinderUtilPersistence(
		OmsbTmsFinderPersistence omsbTmsFinderPersistence) {

		try {
			Field field = OmsbTmsFinderUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, omsbTmsFinderPersistence);
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

	private static final String _SQL_SELECT_OMSBTMSFINDER =
		"SELECT omsbTmsFinder FROM OmsbTmsFinder omsbTmsFinder";

	private static final String _SQL_SELECT_OMSBTMSFINDER_WHERE =
		"SELECT omsbTmsFinder FROM OmsbTmsFinder omsbTmsFinder WHERE ";

	private static final String _SQL_COUNT_OMSBTMSFINDER =
		"SELECT COUNT(omsbTmsFinder) FROM OmsbTmsFinder omsbTmsFinder";

	private static final String _SQL_COUNT_OMSBTMSFINDER_WHERE =
		"SELECT COUNT(omsbTmsFinder) FROM OmsbTmsFinder omsbTmsFinder WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "omsbTmsFinder.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OmsbTmsFinder exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OmsbTmsFinder exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OmsbTmsFinderPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "omsbTmsFinderId", "groupId", "companyId", "createDate",
			"modifiedDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
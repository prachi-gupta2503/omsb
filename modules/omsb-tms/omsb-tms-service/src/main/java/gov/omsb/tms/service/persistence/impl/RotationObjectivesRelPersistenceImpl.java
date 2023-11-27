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

import gov.omsb.tms.exception.NoSuchRotationObjectivesRelException;
import gov.omsb.tms.model.RotationObjectivesRel;
import gov.omsb.tms.model.RotationObjectivesRelTable;
import gov.omsb.tms.model.impl.RotationObjectivesRelImpl;
import gov.omsb.tms.model.impl.RotationObjectivesRelModelImpl;
import gov.omsb.tms.service.persistence.RotationObjectivesRelPersistence;
import gov.omsb.tms.service.persistence.RotationObjectivesRelUtil;
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
 * The persistence implementation for the rotation objectives rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RotationObjectivesRelPersistence.class)
public class RotationObjectivesRelPersistenceImpl
	extends BasePersistenceImpl<RotationObjectivesRel>
	implements RotationObjectivesRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RotationObjectivesRelUtil</code> to access the rotation objectives rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RotationObjectivesRelImpl.class.getName();

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
	 * Returns all the rotation objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator,
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

		List<RotationObjectivesRel> list = null;

		if (useFinderCache) {
			list = (List<RotationObjectivesRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationObjectivesRel rotationObjectivesRel : list) {
					if (!uuid.equals(rotationObjectivesRel.getUuid())) {
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

			sb.append(_SQL_SELECT_ROTATIONOBJECTIVESREL_WHERE);

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
				sb.append(RotationObjectivesRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<RotationObjectivesRel>)QueryUtil.list(
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
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel findByUuid_First(
			String uuid,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel = fetchByUuid_First(
			uuid, orderByComparator);

		if (rotationObjectivesRel != null) {
			return rotationObjectivesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRotationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByUuid_First(
		String uuid,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		List<RotationObjectivesRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel findByUuid_Last(
			String uuid,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel = fetchByUuid_Last(
			uuid, orderByComparator);

		if (rotationObjectivesRel != null) {
			return rotationObjectivesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRotationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RotationObjectivesRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public RotationObjectivesRel[] findByUuid_PrevAndNext(
			long rotationObjectivesRelId, String uuid,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		uuid = Objects.toString(uuid, "");

		RotationObjectivesRel rotationObjectivesRel = findByPrimaryKey(
			rotationObjectivesRelId);

		Session session = null;

		try {
			session = openSession();

			RotationObjectivesRel[] array = new RotationObjectivesRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, rotationObjectivesRel, uuid, orderByComparator, true);

			array[1] = rotationObjectivesRel;

			array[2] = getByUuid_PrevAndNext(
				session, rotationObjectivesRel, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RotationObjectivesRel getByUuid_PrevAndNext(
		Session session, RotationObjectivesRel rotationObjectivesRel,
		String uuid, OrderByComparator<RotationObjectivesRel> orderByComparator,
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

		sb.append(_SQL_SELECT_ROTATIONOBJECTIVESREL_WHERE);

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
			sb.append(RotationObjectivesRelModelImpl.ORDER_BY_JPQL);
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
						rotationObjectivesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationObjectivesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation objectives rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RotationObjectivesRel rotationObjectivesRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rotationObjectivesRel);
		}
	}

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation objectives rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROTATIONOBJECTIVESREL_WHERE);

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
		"rotationObjectivesRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(rotationObjectivesRel.uuid IS NULL OR rotationObjectivesRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationObjectivesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel findByUUID_G(String uuid, long groupId)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel = fetchByUUID_G(
			uuid, groupId);

		if (rotationObjectivesRel == null) {
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

			throw new NoSuchRotationObjectivesRelException(sb.toString());
		}

		return rotationObjectivesRel;
	}

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByUUID_G(
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

		if (result instanceof RotationObjectivesRel) {
			RotationObjectivesRel rotationObjectivesRel =
				(RotationObjectivesRel)result;

			if (!Objects.equals(uuid, rotationObjectivesRel.getUuid()) ||
				(groupId != rotationObjectivesRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROTATIONOBJECTIVESREL_WHERE);

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

				List<RotationObjectivesRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					RotationObjectivesRel rotationObjectivesRel = list.get(0);

					result = rotationObjectivesRel;

					cacheResult(rotationObjectivesRel);
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
			return (RotationObjectivesRel)result;
		}
	}

	/**
	 * Removes the rotation objectives rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation objectives rel that was removed
	 */
	@Override
	public RotationObjectivesRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel = findByUUID_G(
			uuid, groupId);

		return remove(rotationObjectivesRel);
	}

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation objectives rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONOBJECTIVESREL_WHERE);

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
		"rotationObjectivesRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(rotationObjectivesRel.uuid IS NULL OR rotationObjectivesRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"rotationObjectivesRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator,
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

		List<RotationObjectivesRel> list = null;

		if (useFinderCache) {
			list = (List<RotationObjectivesRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationObjectivesRel rotationObjectivesRel : list) {
					if (!uuid.equals(rotationObjectivesRel.getUuid()) ||
						(companyId != rotationObjectivesRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ROTATIONOBJECTIVESREL_WHERE);

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
				sb.append(RotationObjectivesRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<RotationObjectivesRel>)QueryUtil.list(
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
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (rotationObjectivesRel != null) {
			return rotationObjectivesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRotationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		List<RotationObjectivesRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (rotationObjectivesRel != null) {
			return rotationObjectivesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRotationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RotationObjectivesRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public RotationObjectivesRel[] findByUuid_C_PrevAndNext(
			long rotationObjectivesRelId, String uuid, long companyId,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		uuid = Objects.toString(uuid, "");

		RotationObjectivesRel rotationObjectivesRel = findByPrimaryKey(
			rotationObjectivesRelId);

		Session session = null;

		try {
			session = openSession();

			RotationObjectivesRel[] array = new RotationObjectivesRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, rotationObjectivesRel, uuid, companyId,
				orderByComparator, true);

			array[1] = rotationObjectivesRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, rotationObjectivesRel, uuid, companyId,
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

	protected RotationObjectivesRel getByUuid_C_PrevAndNext(
		Session session, RotationObjectivesRel rotationObjectivesRel,
		String uuid, long companyId,
		OrderByComparator<RotationObjectivesRel> orderByComparator,
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

		sb.append(_SQL_SELECT_ROTATIONOBJECTIVESREL_WHERE);

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
			sb.append(RotationObjectivesRelModelImpl.ORDER_BY_JPQL);
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
						rotationObjectivesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationObjectivesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation objectives rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RotationObjectivesRel rotationObjectivesRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rotationObjectivesRel);
		}
	}

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation objectives rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONOBJECTIVESREL_WHERE);

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
		"rotationObjectivesRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(rotationObjectivesRel.uuid IS NULL OR rotationObjectivesRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"rotationObjectivesRel.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByRotationIdAndProgramDurationId;
	private FinderPath
		_finderPathWithoutPaginationFindByRotationIdAndProgramDurationId;
	private FinderPath _finderPathCountByRotationIdAndProgramDurationId;

	/**
	 * Returns all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId) {

		return findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId, int start, int end) {

		return findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRotationIdAndProgramDurationId;
				finderArgs = new Object[] {rotationId, progDurationId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByRotationIdAndProgramDurationId;
			finderArgs = new Object[] {
				rotationId, progDurationId, start, end, orderByComparator
			};
		}

		List<RotationObjectivesRel> list = null;

		if (useFinderCache) {
			list = (List<RotationObjectivesRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationObjectivesRel rotationObjectivesRel : list) {
					if ((rotationId != rotationObjectivesRel.getRotationId()) ||
						(progDurationId !=
							rotationObjectivesRel.getProgDurationId())) {

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

			sb.append(_SQL_SELECT_ROTATIONOBJECTIVESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_PROGDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RotationObjectivesRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationId);

				queryPos.add(progDurationId);

				list = (List<RotationObjectivesRel>)QueryUtil.list(
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
	 * Returns the first rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel findByRotationIdAndProgramDurationId_First(
			long rotationId, long progDurationId,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel =
			fetchByRotationIdAndProgramDurationId_First(
				rotationId, progDurationId, orderByComparator);

		if (rotationObjectivesRel != null) {
			return rotationObjectivesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationId=");
		sb.append(rotationId);

		sb.append(", progDurationId=");
		sb.append(progDurationId);

		sb.append("}");

		throw new NoSuchRotationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByRotationIdAndProgramDurationId_First(
		long rotationId, long progDurationId,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		List<RotationObjectivesRel> list = findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel findByRotationIdAndProgramDurationId_Last(
			long rotationId, long progDurationId,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel =
			fetchByRotationIdAndProgramDurationId_Last(
				rotationId, progDurationId, orderByComparator);

		if (rotationObjectivesRel != null) {
			return rotationObjectivesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationId=");
		sb.append(rotationId);

		sb.append(", progDurationId=");
		sb.append(progDurationId);

		sb.append("}");

		throw new NoSuchRotationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByRotationIdAndProgramDurationId_Last(
		long rotationId, long progDurationId,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		int count = countByRotationIdAndProgramDurationId(
			rotationId, progDurationId);

		if (count == 0) {
			return null;
		}

		List<RotationObjectivesRel> list = findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public RotationObjectivesRel[]
			findByRotationIdAndProgramDurationId_PrevAndNext(
				long rotationObjectivesRelId, long rotationId,
				long progDurationId,
				OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel = findByPrimaryKey(
			rotationObjectivesRelId);

		Session session = null;

		try {
			session = openSession();

			RotationObjectivesRel[] array = new RotationObjectivesRelImpl[3];

			array[0] = getByRotationIdAndProgramDurationId_PrevAndNext(
				session, rotationObjectivesRel, rotationId, progDurationId,
				orderByComparator, true);

			array[1] = rotationObjectivesRel;

			array[2] = getByRotationIdAndProgramDurationId_PrevAndNext(
				session, rotationObjectivesRel, rotationId, progDurationId,
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

	protected RotationObjectivesRel
		getByRotationIdAndProgramDurationId_PrevAndNext(
			Session session, RotationObjectivesRel rotationObjectivesRel,
			long rotationId, long progDurationId,
			OrderByComparator<RotationObjectivesRel> orderByComparator,
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

		sb.append(_SQL_SELECT_ROTATIONOBJECTIVESREL_WHERE);

		sb.append(_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_ROTATIONID_2);

		sb.append(
			_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_PROGDURATIONID_2);

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
			sb.append(RotationObjectivesRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(rotationId);

		queryPos.add(progDurationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rotationObjectivesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationObjectivesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 */
	@Override
	public void removeByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId) {

		for (RotationObjectivesRel rotationObjectivesRel :
				findByRotationIdAndProgramDurationId(
					rotationId, progDurationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(rotationObjectivesRel);
		}
	}

	/**
	 * Returns the number of rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the number of matching rotation objectives rels
	 */
	@Override
	public int countByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId) {

		FinderPath finderPath =
			_finderPathCountByRotationIdAndProgramDurationId;

		Object[] finderArgs = new Object[] {rotationId, progDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONOBJECTIVESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_PROGDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationId);

				queryPos.add(progDurationId);

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
		_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_ROTATIONID_2 =
			"rotationObjectivesRel.rotationId = ? AND ";

	private static final String
		_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_PROGDURATIONID_2 =
			"rotationObjectivesRel.progDurationId = ?";

	public RotationObjectivesRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"rotationObjectivesRelId", "rotation_objectives_rel_id");
		dbColumnNames.put("progDurationId", "prog_duration_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(RotationObjectivesRel.class);

		setModelImplClass(RotationObjectivesRelImpl.class);
		setModelPKClass(long.class);

		setTable(RotationObjectivesRelTable.INSTANCE);
	}

	/**
	 * Caches the rotation objectives rel in the entity cache if it is enabled.
	 *
	 * @param rotationObjectivesRel the rotation objectives rel
	 */
	@Override
	public void cacheResult(RotationObjectivesRel rotationObjectivesRel) {
		entityCache.putResult(
			RotationObjectivesRelImpl.class,
			rotationObjectivesRel.getPrimaryKey(), rotationObjectivesRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				rotationObjectivesRel.getUuid(),
				rotationObjectivesRel.getGroupId()
			},
			rotationObjectivesRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rotation objectives rels in the entity cache if it is enabled.
	 *
	 * @param rotationObjectivesRels the rotation objectives rels
	 */
	@Override
	public void cacheResult(
		List<RotationObjectivesRel> rotationObjectivesRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rotationObjectivesRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RotationObjectivesRel rotationObjectivesRel :
				rotationObjectivesRels) {

			if (entityCache.getResult(
					RotationObjectivesRelImpl.class,
					rotationObjectivesRel.getPrimaryKey()) == null) {

				cacheResult(rotationObjectivesRel);
			}
		}
	}

	/**
	 * Clears the cache for all rotation objectives rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RotationObjectivesRelImpl.class);

		finderCache.clearCache(RotationObjectivesRelImpl.class);
	}

	/**
	 * Clears the cache for the rotation objectives rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RotationObjectivesRel rotationObjectivesRel) {
		entityCache.removeResult(
			RotationObjectivesRelImpl.class, rotationObjectivesRel);
	}

	@Override
	public void clearCache(List<RotationObjectivesRel> rotationObjectivesRels) {
		for (RotationObjectivesRel rotationObjectivesRel :
				rotationObjectivesRels) {

			entityCache.removeResult(
				RotationObjectivesRelImpl.class, rotationObjectivesRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RotationObjectivesRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				RotationObjectivesRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RotationObjectivesRelModelImpl rotationObjectivesRelModelImpl) {

		Object[] args = new Object[] {
			rotationObjectivesRelModelImpl.getUuid(),
			rotationObjectivesRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, rotationObjectivesRelModelImpl);
	}

	/**
	 * Creates a new rotation objectives rel with the primary key. Does not add the rotation objectives rel to the database.
	 *
	 * @param rotationObjectivesRelId the primary key for the new rotation objectives rel
	 * @return the new rotation objectives rel
	 */
	@Override
	public RotationObjectivesRel create(long rotationObjectivesRelId) {
		RotationObjectivesRel rotationObjectivesRel =
			new RotationObjectivesRelImpl();

		rotationObjectivesRel.setNew(true);
		rotationObjectivesRel.setPrimaryKey(rotationObjectivesRelId);

		String uuid = _portalUUID.generate();

		rotationObjectivesRel.setUuid(uuid);

		rotationObjectivesRel.setCompanyId(CompanyThreadLocal.getCompanyId());

		return rotationObjectivesRel;
	}

	/**
	 * Removes the rotation objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel that was removed
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public RotationObjectivesRel remove(long rotationObjectivesRelId)
		throws NoSuchRotationObjectivesRelException {

		return remove((Serializable)rotationObjectivesRelId);
	}

	/**
	 * Removes the rotation objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rotation objectives rel
	 * @return the rotation objectives rel that was removed
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public RotationObjectivesRel remove(Serializable primaryKey)
		throws NoSuchRotationObjectivesRelException {

		Session session = null;

		try {
			session = openSession();

			RotationObjectivesRel rotationObjectivesRel =
				(RotationObjectivesRel)session.get(
					RotationObjectivesRelImpl.class, primaryKey);

			if (rotationObjectivesRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRotationObjectivesRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rotationObjectivesRel);
		}
		catch (NoSuchRotationObjectivesRelException noSuchEntityException) {
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
	protected RotationObjectivesRel removeImpl(
		RotationObjectivesRel rotationObjectivesRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rotationObjectivesRel)) {
				rotationObjectivesRel = (RotationObjectivesRel)session.get(
					RotationObjectivesRelImpl.class,
					rotationObjectivesRel.getPrimaryKeyObj());
			}

			if (rotationObjectivesRel != null) {
				session.delete(rotationObjectivesRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rotationObjectivesRel != null) {
			clearCache(rotationObjectivesRel);
		}

		return rotationObjectivesRel;
	}

	@Override
	public RotationObjectivesRel updateImpl(
		RotationObjectivesRel rotationObjectivesRel) {

		boolean isNew = rotationObjectivesRel.isNew();

		if (!(rotationObjectivesRel instanceof
				RotationObjectivesRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rotationObjectivesRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rotationObjectivesRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rotationObjectivesRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RotationObjectivesRel implementation " +
					rotationObjectivesRel.getClass());
		}

		RotationObjectivesRelModelImpl rotationObjectivesRelModelImpl =
			(RotationObjectivesRelModelImpl)rotationObjectivesRel;

		if (Validator.isNull(rotationObjectivesRel.getUuid())) {
			String uuid = _portalUUID.generate();

			rotationObjectivesRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (rotationObjectivesRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				rotationObjectivesRel.setCreateDate(date);
			}
			else {
				rotationObjectivesRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!rotationObjectivesRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				rotationObjectivesRel.setModifiedDate(date);
			}
			else {
				rotationObjectivesRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rotationObjectivesRel);
			}
			else {
				rotationObjectivesRel = (RotationObjectivesRel)session.merge(
					rotationObjectivesRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RotationObjectivesRelImpl.class, rotationObjectivesRelModelImpl,
			false, true);

		cacheUniqueFindersCache(rotationObjectivesRelModelImpl);

		if (isNew) {
			rotationObjectivesRel.setNew(false);
		}

		rotationObjectivesRel.resetOriginalValues();

		return rotationObjectivesRel;
	}

	/**
	 * Returns the rotation objectives rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rotation objectives rel
	 * @return the rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public RotationObjectivesRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRotationObjectivesRelException {

		RotationObjectivesRel rotationObjectivesRel = fetchByPrimaryKey(
			primaryKey);

		if (rotationObjectivesRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRotationObjectivesRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rotationObjectivesRel;
	}

	/**
	 * Returns the rotation objectives rel with the primary key or throws a <code>NoSuchRotationObjectivesRelException</code> if it could not be found.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public RotationObjectivesRel findByPrimaryKey(long rotationObjectivesRelId)
		throws NoSuchRotationObjectivesRelException {

		return findByPrimaryKey((Serializable)rotationObjectivesRelId);
	}

	/**
	 * Returns the rotation objectives rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel, or <code>null</code> if a rotation objectives rel with the primary key could not be found
	 */
	@Override
	public RotationObjectivesRel fetchByPrimaryKey(
		long rotationObjectivesRelId) {

		return fetchByPrimaryKey((Serializable)rotationObjectivesRelId);
	}

	/**
	 * Returns all the rotation objectives rels.
	 *
	 * @return the rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findAll(
		int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation objectives rels
	 */
	@Override
	public List<RotationObjectivesRel> findAll(
		int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator,
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

		List<RotationObjectivesRel> list = null;

		if (useFinderCache) {
			list = (List<RotationObjectivesRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROTATIONOBJECTIVESREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROTATIONOBJECTIVESREL;

				sql = sql.concat(RotationObjectivesRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RotationObjectivesRel>)QueryUtil.list(
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
	 * Removes all the rotation objectives rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RotationObjectivesRel rotationObjectivesRel : findAll()) {
			remove(rotationObjectivesRel);
		}
	}

	/**
	 * Returns the number of rotation objectives rels.
	 *
	 * @return the number of rotation objectives rels
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
					_SQL_COUNT_ROTATIONOBJECTIVESREL);

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
		return "rotation_objectives_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROTATIONOBJECTIVESREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RotationObjectivesRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rotation objectives rel persistence.
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

		_finderPathWithPaginationFindByRotationIdAndProgramDurationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRotationIdAndProgramDurationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"rotation_id", "prog_duration_id"}, true);

		_finderPathWithoutPaginationFindByRotationIdAndProgramDurationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRotationIdAndProgramDurationId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"rotation_id", "prog_duration_id"}, true);

		_finderPathCountByRotationIdAndProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRotationIdAndProgramDurationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"rotation_id", "prog_duration_id"}, false);

		_setRotationObjectivesRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRotationObjectivesRelUtilPersistence(null);

		entityCache.removeCache(RotationObjectivesRelImpl.class.getName());
	}

	private void _setRotationObjectivesRelUtilPersistence(
		RotationObjectivesRelPersistence rotationObjectivesRelPersistence) {

		try {
			Field field = RotationObjectivesRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, rotationObjectivesRelPersistence);
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

	private static final String _SQL_SELECT_ROTATIONOBJECTIVESREL =
		"SELECT rotationObjectivesRel FROM RotationObjectivesRel rotationObjectivesRel";

	private static final String _SQL_SELECT_ROTATIONOBJECTIVESREL_WHERE =
		"SELECT rotationObjectivesRel FROM RotationObjectivesRel rotationObjectivesRel WHERE ";

	private static final String _SQL_COUNT_ROTATIONOBJECTIVESREL =
		"SELECT COUNT(rotationObjectivesRel) FROM RotationObjectivesRel rotationObjectivesRel";

	private static final String _SQL_COUNT_ROTATIONOBJECTIVESREL_WHERE =
		"SELECT COUNT(rotationObjectivesRel) FROM RotationObjectivesRel rotationObjectivesRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"rotationObjectivesRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RotationObjectivesRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RotationObjectivesRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RotationObjectivesRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "rotationObjectivesRelId", "progDurationId", "rotationId",
			"groupId", "companyId", "createDate", "modifiedDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
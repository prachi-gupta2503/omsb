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

import gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException;
import gov.omsb.tms.model.ProgdurationObjectivesRel;
import gov.omsb.tms.model.ProgdurationObjectivesRelTable;
import gov.omsb.tms.model.impl.ProgdurationObjectivesRelImpl;
import gov.omsb.tms.model.impl.ProgdurationObjectivesRelModelImpl;
import gov.omsb.tms.service.persistence.ProgdurationObjectivesRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationObjectivesRelUtil;
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
 * The persistence implementation for the progduration objectives rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgdurationObjectivesRelPersistence.class)
public class ProgdurationObjectivesRelPersistenceImpl
	extends BasePersistenceImpl<ProgdurationObjectivesRel>
	implements ProgdurationObjectivesRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgdurationObjectivesRelUtil</code> to access the progduration objectives rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgdurationObjectivesRelImpl.class.getName();

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
	 * Returns all the progduration objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of matching progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator,
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

		List<ProgdurationObjectivesRel> list = null;

		if (useFinderCache) {
			list = (List<ProgdurationObjectivesRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationObjectivesRel progdurationObjectivesRel :
						list) {

					if (!uuid.equals(progdurationObjectivesRel.getUuid())) {
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

			sb.append(_SQL_SELECT_PROGDURATIONOBJECTIVESREL_WHERE);

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
				sb.append(ProgdurationObjectivesRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgdurationObjectivesRel>)QueryUtil.list(
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
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException {

		ProgdurationObjectivesRel progdurationObjectivesRel = fetchByUuid_First(
			uuid, orderByComparator);

		if (progdurationObjectivesRel != null) {
			return progdurationObjectivesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		List<ProgdurationObjectivesRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException {

		ProgdurationObjectivesRel progdurationObjectivesRel = fetchByUuid_Last(
			uuid, orderByComparator);

		if (progdurationObjectivesRel != null) {
			return progdurationObjectivesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgdurationObjectivesRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration objectives rels before and after the current progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param PDObjectivesId the primary key of the current progduration objectives rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public ProgdurationObjectivesRel[] findByUuid_PrevAndNext(
			long PDObjectivesId, String uuid,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationObjectivesRel progdurationObjectivesRel = findByPrimaryKey(
			PDObjectivesId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationObjectivesRel[] array =
				new ProgdurationObjectivesRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, progdurationObjectivesRel, uuid, orderByComparator,
				true);

			array[1] = progdurationObjectivesRel;

			array[2] = getByUuid_PrevAndNext(
				session, progdurationObjectivesRel, uuid, orderByComparator,
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

	protected ProgdurationObjectivesRel getByUuid_PrevAndNext(
		Session session, ProgdurationObjectivesRel progdurationObjectivesRel,
		String uuid,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGDURATIONOBJECTIVESREL_WHERE);

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
			sb.append(ProgdurationObjectivesRelModelImpl.ORDER_BY_JPQL);
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
						progdurationObjectivesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationObjectivesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration objectives rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgdurationObjectivesRel progdurationObjectivesRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(progdurationObjectivesRel);
		}
	}

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration objectives rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONOBJECTIVESREL_WHERE);

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
		"progdurationObjectivesRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(progdurationObjectivesRel.uuid IS NULL OR progdurationObjectivesRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationObjectivesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProgdurationObjectivesRelException {

		ProgdurationObjectivesRel progdurationObjectivesRel = fetchByUUID_G(
			uuid, groupId);

		if (progdurationObjectivesRel == null) {
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

			throw new NoSuchProgdurationObjectivesRelException(sb.toString());
		}

		return progdurationObjectivesRel;
	}

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel fetchByUUID_G(
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

		if (result instanceof ProgdurationObjectivesRel) {
			ProgdurationObjectivesRel progdurationObjectivesRel =
				(ProgdurationObjectivesRel)result;

			if (!Objects.equals(uuid, progdurationObjectivesRel.getUuid()) ||
				(groupId != progdurationObjectivesRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGDURATIONOBJECTIVESREL_WHERE);

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

				List<ProgdurationObjectivesRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgdurationObjectivesRel progdurationObjectivesRel =
						list.get(0);

					result = progdurationObjectivesRel;

					cacheResult(progdurationObjectivesRel);
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
			return (ProgdurationObjectivesRel)result;
		}
	}

	/**
	 * Removes the progduration objectives rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration objectives rel that was removed
	 */
	@Override
	public ProgdurationObjectivesRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgdurationObjectivesRelException {

		ProgdurationObjectivesRel progdurationObjectivesRel = findByUUID_G(
			uuid, groupId);

		return remove(progdurationObjectivesRel);
	}

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration objectives rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONOBJECTIVESREL_WHERE);

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
		"progdurationObjectivesRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(progdurationObjectivesRel.uuid IS NULL OR progdurationObjectivesRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"progdurationObjectivesRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of matching progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator,
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

		List<ProgdurationObjectivesRel> list = null;

		if (useFinderCache) {
			list = (List<ProgdurationObjectivesRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationObjectivesRel progdurationObjectivesRel :
						list) {

					if (!uuid.equals(progdurationObjectivesRel.getUuid()) ||
						(companyId !=
							progdurationObjectivesRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGDURATIONOBJECTIVESREL_WHERE);

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
				sb.append(ProgdurationObjectivesRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgdurationObjectivesRel>)QueryUtil.list(
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
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException {

		ProgdurationObjectivesRel progdurationObjectivesRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (progdurationObjectivesRel != null) {
			return progdurationObjectivesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		List<ProgdurationObjectivesRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException {

		ProgdurationObjectivesRel progdurationObjectivesRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (progdurationObjectivesRel != null) {
			return progdurationObjectivesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationObjectivesRelException(sb.toString());
	}

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	@Override
	public ProgdurationObjectivesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationObjectivesRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration objectives rels before and after the current progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param PDObjectivesId the primary key of the current progduration objectives rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public ProgdurationObjectivesRel[] findByUuid_C_PrevAndNext(
			long PDObjectivesId, String uuid, long companyId,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws NoSuchProgdurationObjectivesRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationObjectivesRel progdurationObjectivesRel = findByPrimaryKey(
			PDObjectivesId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationObjectivesRel[] array =
				new ProgdurationObjectivesRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, progdurationObjectivesRel, uuid, companyId,
				orderByComparator, true);

			array[1] = progdurationObjectivesRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, progdurationObjectivesRel, uuid, companyId,
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

	protected ProgdurationObjectivesRel getByUuid_C_PrevAndNext(
		Session session, ProgdurationObjectivesRel progdurationObjectivesRel,
		String uuid, long companyId,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGDURATIONOBJECTIVESREL_WHERE);

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
			sb.append(ProgdurationObjectivesRelModelImpl.ORDER_BY_JPQL);
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
						progdurationObjectivesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationObjectivesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration objectives rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgdurationObjectivesRel progdurationObjectivesRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(progdurationObjectivesRel);
		}
	}

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration objectives rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONOBJECTIVESREL_WHERE);

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
		"progdurationObjectivesRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(progdurationObjectivesRel.uuid IS NULL OR progdurationObjectivesRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"progdurationObjectivesRel.companyId = ?";

	public ProgdurationObjectivesRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("PDObjectivesId", "pd_objectives_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("progDurationId", "prog_duration_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgdurationObjectivesRel.class);

		setModelImplClass(ProgdurationObjectivesRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProgdurationObjectivesRelTable.INSTANCE);
	}

	/**
	 * Caches the progduration objectives rel in the entity cache if it is enabled.
	 *
	 * @param progdurationObjectivesRel the progduration objectives rel
	 */
	@Override
	public void cacheResult(
		ProgdurationObjectivesRel progdurationObjectivesRel) {

		entityCache.putResult(
			ProgdurationObjectivesRelImpl.class,
			progdurationObjectivesRel.getPrimaryKey(),
			progdurationObjectivesRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				progdurationObjectivesRel.getUuid(),
				progdurationObjectivesRel.getGroupId()
			},
			progdurationObjectivesRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the progduration objectives rels in the entity cache if it is enabled.
	 *
	 * @param progdurationObjectivesRels the progduration objectives rels
	 */
	@Override
	public void cacheResult(
		List<ProgdurationObjectivesRel> progdurationObjectivesRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (progdurationObjectivesRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgdurationObjectivesRel progdurationObjectivesRel :
				progdurationObjectivesRels) {

			if (entityCache.getResult(
					ProgdurationObjectivesRelImpl.class,
					progdurationObjectivesRel.getPrimaryKey()) == null) {

				cacheResult(progdurationObjectivesRel);
			}
		}
	}

	/**
	 * Clears the cache for all progduration objectives rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgdurationObjectivesRelImpl.class);

		finderCache.clearCache(ProgdurationObjectivesRelImpl.class);
	}

	/**
	 * Clears the cache for the progduration objectives rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProgdurationObjectivesRel progdurationObjectivesRel) {

		entityCache.removeResult(
			ProgdurationObjectivesRelImpl.class, progdurationObjectivesRel);
	}

	@Override
	public void clearCache(
		List<ProgdurationObjectivesRel> progdurationObjectivesRels) {

		for (ProgdurationObjectivesRel progdurationObjectivesRel :
				progdurationObjectivesRels) {

			entityCache.removeResult(
				ProgdurationObjectivesRelImpl.class, progdurationObjectivesRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgdurationObjectivesRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgdurationObjectivesRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgdurationObjectivesRelModelImpl progdurationObjectivesRelModelImpl) {

		Object[] args = new Object[] {
			progdurationObjectivesRelModelImpl.getUuid(),
			progdurationObjectivesRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, progdurationObjectivesRelModelImpl);
	}

	/**
	 * Creates a new progduration objectives rel with the primary key. Does not add the progduration objectives rel to the database.
	 *
	 * @param PDObjectivesId the primary key for the new progduration objectives rel
	 * @return the new progduration objectives rel
	 */
	@Override
	public ProgdurationObjectivesRel create(long PDObjectivesId) {
		ProgdurationObjectivesRel progdurationObjectivesRel =
			new ProgdurationObjectivesRelImpl();

		progdurationObjectivesRel.setNew(true);
		progdurationObjectivesRel.setPrimaryKey(PDObjectivesId);

		String uuid = _portalUUID.generate();

		progdurationObjectivesRel.setUuid(uuid);

		progdurationObjectivesRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return progdurationObjectivesRel;
	}

	/**
	 * Removes the progduration objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel that was removed
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public ProgdurationObjectivesRel remove(long PDObjectivesId)
		throws NoSuchProgdurationObjectivesRelException {

		return remove((Serializable)PDObjectivesId);
	}

	/**
	 * Removes the progduration objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the progduration objectives rel
	 * @return the progduration objectives rel that was removed
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public ProgdurationObjectivesRel remove(Serializable primaryKey)
		throws NoSuchProgdurationObjectivesRelException {

		Session session = null;

		try {
			session = openSession();

			ProgdurationObjectivesRel progdurationObjectivesRel =
				(ProgdurationObjectivesRel)session.get(
					ProgdurationObjectivesRelImpl.class, primaryKey);

			if (progdurationObjectivesRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgdurationObjectivesRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(progdurationObjectivesRel);
		}
		catch (NoSuchProgdurationObjectivesRelException noSuchEntityException) {
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
	protected ProgdurationObjectivesRel removeImpl(
		ProgdurationObjectivesRel progdurationObjectivesRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(progdurationObjectivesRel)) {
				progdurationObjectivesRel =
					(ProgdurationObjectivesRel)session.get(
						ProgdurationObjectivesRelImpl.class,
						progdurationObjectivesRel.getPrimaryKeyObj());
			}

			if (progdurationObjectivesRel != null) {
				session.delete(progdurationObjectivesRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (progdurationObjectivesRel != null) {
			clearCache(progdurationObjectivesRel);
		}

		return progdurationObjectivesRel;
	}

	@Override
	public ProgdurationObjectivesRel updateImpl(
		ProgdurationObjectivesRel progdurationObjectivesRel) {

		boolean isNew = progdurationObjectivesRel.isNew();

		if (!(progdurationObjectivesRel instanceof
				ProgdurationObjectivesRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(progdurationObjectivesRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					progdurationObjectivesRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in progdurationObjectivesRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgdurationObjectivesRel implementation " +
					progdurationObjectivesRel.getClass());
		}

		ProgdurationObjectivesRelModelImpl progdurationObjectivesRelModelImpl =
			(ProgdurationObjectivesRelModelImpl)progdurationObjectivesRel;

		if (Validator.isNull(progdurationObjectivesRel.getUuid())) {
			String uuid = _portalUUID.generate();

			progdurationObjectivesRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (progdurationObjectivesRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				progdurationObjectivesRel.setCreateDate(date);
			}
			else {
				progdurationObjectivesRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!progdurationObjectivesRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				progdurationObjectivesRel.setModifiedDate(date);
			}
			else {
				progdurationObjectivesRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(progdurationObjectivesRel);
			}
			else {
				progdurationObjectivesRel =
					(ProgdurationObjectivesRel)session.merge(
						progdurationObjectivesRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgdurationObjectivesRelImpl.class,
			progdurationObjectivesRelModelImpl, false, true);

		cacheUniqueFindersCache(progdurationObjectivesRelModelImpl);

		if (isNew) {
			progdurationObjectivesRel.setNew(false);
		}

		progdurationObjectivesRel.resetOriginalValues();

		return progdurationObjectivesRel;
	}

	/**
	 * Returns the progduration objectives rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the progduration objectives rel
	 * @return the progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public ProgdurationObjectivesRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgdurationObjectivesRelException {

		ProgdurationObjectivesRel progdurationObjectivesRel = fetchByPrimaryKey(
			primaryKey);

		if (progdurationObjectivesRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgdurationObjectivesRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return progdurationObjectivesRel;
	}

	/**
	 * Returns the progduration objectives rel with the primary key or throws a <code>NoSuchProgdurationObjectivesRelException</code> if it could not be found.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public ProgdurationObjectivesRel findByPrimaryKey(long PDObjectivesId)
		throws NoSuchProgdurationObjectivesRelException {

		return findByPrimaryKey((Serializable)PDObjectivesId);
	}

	/**
	 * Returns the progduration objectives rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel, or <code>null</code> if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public ProgdurationObjectivesRel fetchByPrimaryKey(long PDObjectivesId) {
		return fetchByPrimaryKey((Serializable)PDObjectivesId);
	}

	/**
	 * Returns all the progduration objectives rels.
	 *
	 * @return the progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration objectives rels
	 */
	@Override
	public List<ProgdurationObjectivesRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator,
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

		List<ProgdurationObjectivesRel> list = null;

		if (useFinderCache) {
			list = (List<ProgdurationObjectivesRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGDURATIONOBJECTIVESREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGDURATIONOBJECTIVESREL;

				sql = sql.concat(
					ProgdurationObjectivesRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgdurationObjectivesRel>)QueryUtil.list(
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
	 * Removes all the progduration objectives rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgdurationObjectivesRel progdurationObjectivesRel : findAll()) {
			remove(progdurationObjectivesRel);
		}
	}

	/**
	 * Returns the number of progduration objectives rels.
	 *
	 * @return the number of progduration objectives rels
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
					_SQL_COUNT_PROGDURATIONOBJECTIVESREL);

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
		return "pd_objectives_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGDURATIONOBJECTIVESREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgdurationObjectivesRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the progduration objectives rel persistence.
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

		_setProgdurationObjectivesRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgdurationObjectivesRelUtilPersistence(null);

		entityCache.removeCache(ProgdurationObjectivesRelImpl.class.getName());
	}

	private void _setProgdurationObjectivesRelUtilPersistence(
		ProgdurationObjectivesRelPersistence
			progdurationObjectivesRelPersistence) {

		try {
			Field field = ProgdurationObjectivesRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, progdurationObjectivesRelPersistence);
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

	private static final String _SQL_SELECT_PROGDURATIONOBJECTIVESREL =
		"SELECT progdurationObjectivesRel FROM ProgdurationObjectivesRel progdurationObjectivesRel";

	private static final String _SQL_SELECT_PROGDURATIONOBJECTIVESREL_WHERE =
		"SELECT progdurationObjectivesRel FROM ProgdurationObjectivesRel progdurationObjectivesRel WHERE ";

	private static final String _SQL_COUNT_PROGDURATIONOBJECTIVESREL =
		"SELECT COUNT(progdurationObjectivesRel) FROM ProgdurationObjectivesRel progdurationObjectivesRel";

	private static final String _SQL_COUNT_PROGDURATIONOBJECTIVESREL_WHERE =
		"SELECT COUNT(progdurationObjectivesRel) FROM ProgdurationObjectivesRel progdurationObjectivesRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"progdurationObjectivesRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgdurationObjectivesRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgdurationObjectivesRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgdurationObjectivesRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "PDObjectivesId", "groupId", "companyId", "createDate",
			"modifiedDate", "progDurationId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchProgdurationRotationTrainingsitesRelException;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRelTable;
import gov.omsb.tms.model.impl.ProgdurationRotationTrainingsitesRelImpl;
import gov.omsb.tms.model.impl.ProgdurationRotationTrainingsitesRelModelImpl;
import gov.omsb.tms.service.persistence.ProgdurationRotationTrainingsitesRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationRotationTrainingsitesRelUtil;
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
 * The persistence implementation for the progduration rotation trainingsites rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgdurationRotationTrainingsitesRelPersistence.class)
public class ProgdurationRotationTrainingsitesRelPersistenceImpl
	extends BasePersistenceImpl<ProgdurationRotationTrainingsitesRel>
	implements ProgdurationRotationTrainingsitesRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgdurationRotationTrainingsitesRelUtil</code> to access the progduration rotation trainingsites rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgdurationRotationTrainingsitesRelImpl.class.getName();

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
	 * Returns all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
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

		List<ProgdurationRotationTrainingsitesRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTrainingsitesRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel : list) {

					if (!uuid.equals(
							progdurationRotationTrainingsitesRel.getUuid())) {

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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

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
				sb.append(
					ProgdurationRotationTrainingsitesRelModelImpl.
						ORDER_BY_JPQL);
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

				list =
					(List<ProgdurationRotationTrainingsitesRel>)QueryUtil.list(
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
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByUuid_First(
				uuid, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		List<ProgdurationRotationTrainingsitesRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByUuid_Last(
				uuid, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTrainingsitesRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel[] findByUuid_PrevAndNext(
			long progdurationRotationTsRelId, String uuid,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = findByPrimaryKey(
				progdurationRotationTsRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTrainingsitesRel[] array =
				new ProgdurationRotationTrainingsitesRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, uuid,
				orderByComparator, true);

			array[1] = progdurationRotationTrainingsitesRel;

			array[2] = getByUuid_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, uuid,
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

	protected ProgdurationRotationTrainingsitesRel getByUuid_PrevAndNext(
		Session session,
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel,
		String uuid,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

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
			sb.append(
				ProgdurationRotationTrainingsitesRelModelImpl.ORDER_BY_JPQL);
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
						progdurationRotationTrainingsitesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTrainingsitesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(progdurationRotationTrainingsitesRel);
		}
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

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
		"progdurationRotationTrainingsitesRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(progdurationRotationTrainingsitesRel.uuid IS NULL OR progdurationRotationTrainingsitesRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByUUID_G(uuid, groupId);

		if (progdurationRotationTrainingsitesRel == null) {
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

			throw new NoSuchProgdurationRotationTrainingsitesRelException(
				sb.toString());
		}

		return progdurationRotationTrainingsitesRel;
	}

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByUUID_G(
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

		if (result instanceof ProgdurationRotationTrainingsitesRel) {
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel =
					(ProgdurationRotationTrainingsitesRel)result;

			if (!Objects.equals(
					uuid, progdurationRotationTrainingsitesRel.getUuid()) ||
				(groupId !=
					progdurationRotationTrainingsitesRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

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

				List<ProgdurationRotationTrainingsitesRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel = list.get(0);

					result = progdurationRotationTrainingsitesRel;

					cacheResult(progdurationRotationTrainingsitesRel);
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
			return (ProgdurationRotationTrainingsitesRel)result;
		}
	}

	/**
	 * Removes the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = findByUUID_G(uuid, groupId);

		return remove(progdurationRotationTrainingsitesRel);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

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
		"progdurationRotationTrainingsitesRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(progdurationRotationTrainingsitesRel.uuid IS NULL OR progdurationRotationTrainingsitesRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"progdurationRotationTrainingsitesRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
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

		List<ProgdurationRotationTrainingsitesRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTrainingsitesRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel : list) {

					if (!uuid.equals(
							progdurationRotationTrainingsitesRel.getUuid()) ||
						(companyId !=
							progdurationRotationTrainingsitesRel.
								getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

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
				sb.append(
					ProgdurationRotationTrainingsitesRelModelImpl.
						ORDER_BY_JPQL);
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

				list =
					(List<ProgdurationRotationTrainingsitesRel>)QueryUtil.list(
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
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByUuid_C_First(
				uuid, companyId, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		List<ProgdurationRotationTrainingsitesRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByUuid_C_Last(
				uuid, companyId, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTrainingsitesRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel[] findByUuid_C_PrevAndNext(
			long progdurationRotationTsRelId, String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = findByPrimaryKey(
				progdurationRotationTsRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTrainingsitesRel[] array =
				new ProgdurationRotationTrainingsitesRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, uuid, companyId,
				orderByComparator, true);

			array[1] = progdurationRotationTrainingsitesRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, uuid, companyId,
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

	protected ProgdurationRotationTrainingsitesRel getByUuid_C_PrevAndNext(
		Session session,
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel,
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

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
			sb.append(
				ProgdurationRotationTrainingsitesRelModelImpl.ORDER_BY_JPQL);
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
						progdurationRotationTrainingsitesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTrainingsitesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTrainingsitesRel);
		}
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

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
		"progdurationRotationTrainingsitesRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(progdurationRotationTrainingsitesRel.uuid IS NULL OR progdurationRotationTrainingsitesRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"progdurationRotationTrainingsitesRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgramDurationId;
				finderArgs = new Object[] {programDurationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProgramDurationId;
			finderArgs = new Object[] {
				programDurationId, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTrainingsitesRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTrainingsitesRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel : list) {

					if (programDurationId !=
							progdurationRotationTrainingsitesRel.
								getProgramDurationId()) {

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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTrainingsitesRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				list =
					(List<ProgdurationRotationTrainingsitesRel>)QueryUtil.list(
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
	 * Returns the first progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				fetchByProgramDurationId_First(
					programDurationId, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		List<ProgdurationRotationTrainingsitesRel> list =
			findByProgramDurationId(programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				fetchByProgramDurationId_Last(
					programDurationId, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTrainingsitesRel> list =
			findByProgramDurationId(
				programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTsRelId, long programDurationId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = findByPrimaryKey(
				progdurationRotationTsRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTrainingsitesRel[] array =
				new ProgdurationRotationTrainingsitesRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, progdurationRotationTrainingsitesRel,
				programDurationId, orderByComparator, true);

			array[1] = progdurationRotationTrainingsitesRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, progdurationRotationTrainingsitesRel,
				programDurationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgdurationRotationTrainingsitesRel
		getByProgramDurationId_PrevAndNext(
			Session session,
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel,
			long programDurationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator,
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

		sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

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
			sb.append(
				ProgdurationRotationTrainingsitesRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programDurationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTrainingsitesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTrainingsitesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel :
					findByProgramDurationId(
						programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTrainingsitesRel);
		}
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

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
		_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2 =
			"progdurationRotationTrainingsitesRel.programDurationId = ?";

	private FinderPath _finderPathWithPaginationFindByRotationId;
	private FinderPath _finderPathWithoutPaginationFindByRotationId;
	private FinderPath _finderPathCountByRotationId;

	/**
	 * Returns all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId) {

		return findByRotationId(
			rotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId, int start, int end) {

		return findByRotationId(rotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return findByRotationId(
			rotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRotationId;
				finderArgs = new Object[] {rotationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRotationId;
			finderArgs = new Object[] {
				rotationId, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTrainingsitesRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTrainingsitesRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel : list) {

					if (rotationId !=
							progdurationRotationTrainingsitesRel.
								getRotationId()) {

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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(_FINDER_COLUMN_ROTATIONID_ROTATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTrainingsitesRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationId);

				list =
					(List<ProgdurationRotationTrainingsitesRel>)QueryUtil.list(
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
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByRotationId_First(
			long rotationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByRotationId_First(
				rotationId, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationId=");
		sb.append(rotationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByRotationId_First(
		long rotationId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		List<ProgdurationRotationTrainingsitesRel> list = findByRotationId(
			rotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByRotationId_Last(
			long rotationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByRotationId_Last(
				rotationId, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationId=");
		sb.append(rotationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByRotationId_Last(
		long rotationId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		int count = countByRotationId(rotationId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTrainingsitesRel> list = findByRotationId(
			rotationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel[] findByRotationId_PrevAndNext(
			long progdurationRotationTsRelId, long rotationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = findByPrimaryKey(
				progdurationRotationTsRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTrainingsitesRel[] array =
				new ProgdurationRotationTrainingsitesRelImpl[3];

			array[0] = getByRotationId_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, rotationId,
				orderByComparator, true);

			array[1] = progdurationRotationTrainingsitesRel;

			array[2] = getByRotationId_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, rotationId,
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

	protected ProgdurationRotationTrainingsitesRel getByRotationId_PrevAndNext(
		Session session,
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel,
		long rotationId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

		sb.append(_FINDER_COLUMN_ROTATIONID_ROTATIONID_2);

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
			sb.append(
				ProgdurationRotationTrainingsitesRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(rotationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTrainingsitesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTrainingsitesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where rotationId = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 */
	@Override
	public void removeByRotationId(long rotationId) {
		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel :
					findByRotationId(
						rotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTrainingsitesRel);
		}
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByRotationId(long rotationId) {
		FinderPath finderPath = _finderPathCountByRotationId;

		Object[] finderArgs = new Object[] {rotationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(_FINDER_COLUMN_ROTATIONID_ROTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationId);

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

	private static final String _FINDER_COLUMN_ROTATIONID_ROTATIONID_2 =
		"progdurationRotationTrainingsitesRel.rotationId = ?";

	private FinderPath _finderPathWithPaginationFindByTrainingSitesId;
	private FinderPath _finderPathWithoutPaginationFindByTrainingSitesId;
	private FinderPath _finderPathCountByTrainingSitesId;

	/**
	 * Returns all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByTrainingSitesId(
		long trainingSitesId) {

		return findByTrainingSitesId(
			trainingSitesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByTrainingSitesId(
		long trainingSitesId, int start, int end) {

		return findByTrainingSitesId(trainingSitesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByTrainingSitesId(
		long trainingSitesId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return findByTrainingSitesId(
			trainingSitesId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findByTrainingSitesId(
		long trainingSitesId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTrainingSitesId;
				finderArgs = new Object[] {trainingSitesId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTrainingSitesId;
			finderArgs = new Object[] {
				trainingSitesId, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTrainingsitesRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTrainingsitesRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel : list) {

					if (trainingSitesId !=
							progdurationRotationTrainingsitesRel.
								getTrainingSitesId()) {

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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(_FINDER_COLUMN_TRAININGSITESID_TRAININGSITESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTrainingsitesRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSitesId);

				list =
					(List<ProgdurationRotationTrainingsitesRel>)QueryUtil.list(
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
	 * Returns the first progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByTrainingSitesId_First(
			long trainingSitesId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByTrainingSitesId_First(
				trainingSitesId, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trainingSitesId=");
		sb.append(trainingSitesId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByTrainingSitesId_First(
		long trainingSitesId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		List<ProgdurationRotationTrainingsitesRel> list = findByTrainingSitesId(
			trainingSitesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByTrainingSitesId_Last(
			long trainingSitesId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByTrainingSitesId_Last(
				trainingSitesId, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trainingSitesId=");
		sb.append(trainingSitesId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByTrainingSitesId_Last(
		long trainingSitesId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		int count = countByTrainingSitesId(trainingSitesId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTrainingsitesRel> list = findByTrainingSitesId(
			trainingSitesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel[]
			findByTrainingSitesId_PrevAndNext(
				long progdurationRotationTsRelId, long trainingSitesId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = findByPrimaryKey(
				progdurationRotationTsRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTrainingsitesRel[] array =
				new ProgdurationRotationTrainingsitesRelImpl[3];

			array[0] = getByTrainingSitesId_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, trainingSitesId,
				orderByComparator, true);

			array[1] = progdurationRotationTrainingsitesRel;

			array[2] = getByTrainingSitesId_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, trainingSitesId,
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

	protected ProgdurationRotationTrainingsitesRel
		getByTrainingSitesId_PrevAndNext(
			Session session,
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel,
			long trainingSitesId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator,
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

		sb.append(_FINDER_COLUMN_TRAININGSITESID_TRAININGSITESID_2);

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
			sb.append(
				ProgdurationRotationTrainingsitesRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(trainingSitesId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTrainingsitesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTrainingsitesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where trainingSitesId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 */
	@Override
	public void removeByTrainingSitesId(long trainingSitesId) {
		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel :
					findByTrainingSitesId(
						trainingSitesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTrainingsitesRel);
		}
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByTrainingSitesId(long trainingSitesId) {
		FinderPath finderPath = _finderPathCountByTrainingSitesId;

		Object[] finderArgs = new Object[] {trainingSitesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(_FINDER_COLUMN_TRAININGSITESID_TRAININGSITESID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSitesId);

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
		_FINDER_COLUMN_TRAININGSITESID_TRAININGSITESID_2 =
			"progdurationRotationTrainingsitesRel.trainingSitesId = ?";

	private FinderPath _finderPathFetchByTrainingSiteAndRotationId;
	private FinderPath _finderPathCountByTrainingSiteAndRotationId;

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				fetchByTrainingSiteAndRotationId(trainingSitesId, rotationId);

		if (progdurationRotationTrainingsitesRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("trainingSitesId=");
			sb.append(trainingSitesId);

			sb.append(", rotationId=");
			sb.append(rotationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgdurationRotationTrainingsitesRelException(
				sb.toString());
		}

		return progdurationRotationTrainingsitesRel;
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId) {

		return fetchByTrainingSiteAndRotationId(
			trainingSitesId, rotationId, true);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {trainingSitesId, rotationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTrainingSiteAndRotationId, finderArgs, this);
		}

		if (result instanceof ProgdurationRotationTrainingsitesRel) {
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel =
					(ProgdurationRotationTrainingsitesRel)result;

			if ((trainingSitesId !=
					progdurationRotationTrainingsitesRel.
						getTrainingSitesId()) ||
				(rotationId !=
					progdurationRotationTrainingsitesRel.getRotationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAININGSITEANDROTATIONID_TRAININGSITESID_2);

			sb.append(_FINDER_COLUMN_TRAININGSITEANDROTATIONID_ROTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSitesId);

				queryPos.add(rotationId);

				List<ProgdurationRotationTrainingsitesRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTrainingSiteAndRotationId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									trainingSitesId, rotationId
								};
							}

							_log.warn(
								"ProgdurationRotationTrainingsitesRelPersistenceImpl.fetchByTrainingSiteAndRotationId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel = list.get(0);

					result = progdurationRotationTrainingsitesRel;

					cacheResult(progdurationRotationTrainingsitesRel);
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
			return (ProgdurationRotationTrainingsitesRel)result;
		}
	}

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			removeByTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				findByTrainingSiteAndRotationId(trainingSitesId, rotationId);

		return remove(progdurationRotationTrainingsitesRel);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and rotationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByTrainingSiteAndRotationId(
		long trainingSitesId, long rotationId) {

		FinderPath finderPath = _finderPathCountByTrainingSiteAndRotationId;

		Object[] finderArgs = new Object[] {trainingSitesId, rotationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAININGSITEANDROTATIONID_TRAININGSITESID_2);

			sb.append(_FINDER_COLUMN_TRAININGSITEANDROTATIONID_ROTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSitesId);

				queryPos.add(rotationId);

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
		_FINDER_COLUMN_TRAININGSITEANDROTATIONID_TRAININGSITESID_2 =
			"progdurationRotationTrainingsitesRel.trainingSitesId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAININGSITEANDROTATIONID_ROTATIONID_2 =
			"progdurationRotationTrainingsitesRel.rotationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByRotationIdAndIsSharedRotation;
	private FinderPath
		_finderPathWithoutPaginationFindByRotationIdAndIsSharedRotation;
	private FinderPath _finderPathCountByRotationIdAndIsSharedRotation;

	/**
	 * Returns all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @return the matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation) {

		return findByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end) {

		return findByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return findByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRotationIdAndIsSharedRotation;
				finderArgs = new Object[] {rotationId, isSharedRotation};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByRotationIdAndIsSharedRotation;
			finderArgs = new Object[] {
				rotationId, isSharedRotation, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTrainingsitesRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTrainingsitesRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel : list) {

					if ((rotationId !=
							progdurationRotationTrainingsitesRel.
								getRotationId()) ||
						(isSharedRotation !=
							progdurationRotationTrainingsitesRel.
								isIsSharedRotation())) {

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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDISSHAREDROTATION_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDISSHAREDROTATION_ISSHAREDROTATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTrainingsitesRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationId);

				queryPos.add(isSharedRotation);

				list =
					(List<ProgdurationRotationTrainingsitesRel>)QueryUtil.list(
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
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			findByRotationIdAndIsSharedRotation_First(
				long rotationId, boolean isSharedRotation,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				fetchByRotationIdAndIsSharedRotation_First(
					rotationId, isSharedRotation, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationId=");
		sb.append(rotationId);

		sb.append(", isSharedRotation=");
		sb.append(isSharedRotation);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByRotationIdAndIsSharedRotation_First(
			long rotationId, boolean isSharedRotation,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		List<ProgdurationRotationTrainingsitesRel> list =
			findByRotationIdAndIsSharedRotation(
				rotationId, isSharedRotation, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			findByRotationIdAndIsSharedRotation_Last(
				long rotationId, boolean isSharedRotation,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				fetchByRotationIdAndIsSharedRotation_Last(
					rotationId, isSharedRotation, orderByComparator);

		if (progdurationRotationTrainingsitesRel != null) {
			return progdurationRotationTrainingsitesRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationId=");
		sb.append(rotationId);

		sb.append(", isSharedRotation=");
		sb.append(isSharedRotation);

		sb.append("}");

		throw new NoSuchProgdurationRotationTrainingsitesRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByRotationIdAndIsSharedRotation_Last(
			long rotationId, boolean isSharedRotation,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		int count = countByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTrainingsitesRel> list =
			findByRotationIdAndIsSharedRotation(
				rotationId, isSharedRotation, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel[]
			findByRotationIdAndIsSharedRotation_PrevAndNext(
				long progdurationRotationTsRelId, long rotationId,
				boolean isSharedRotation,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = findByPrimaryKey(
				progdurationRotationTsRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTrainingsitesRel[] array =
				new ProgdurationRotationTrainingsitesRelImpl[3];

			array[0] = getByRotationIdAndIsSharedRotation_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, rotationId,
				isSharedRotation, orderByComparator, true);

			array[1] = progdurationRotationTrainingsitesRel;

			array[2] = getByRotationIdAndIsSharedRotation_PrevAndNext(
				session, progdurationRotationTrainingsitesRel, rotationId,
				isSharedRotation, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgdurationRotationTrainingsitesRel
		getByRotationIdAndIsSharedRotation_PrevAndNext(
			Session session,
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel,
			long rotationId, boolean isSharedRotation,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator,
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

		sb.append(_FINDER_COLUMN_ROTATIONIDANDISSHAREDROTATION_ROTATIONID_2);

		sb.append(
			_FINDER_COLUMN_ROTATIONIDANDISSHAREDROTATION_ISSHAREDROTATION_2);

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
			sb.append(
				ProgdurationRotationTrainingsitesRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(rotationId);

		queryPos.add(isSharedRotation);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTrainingsitesRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTrainingsitesRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 */
	@Override
	public void removeByRotationIdAndIsSharedRotation(
		long rotationId, boolean isSharedRotation) {

		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel :
					findByRotationIdAndIsSharedRotation(
						rotationId, isSharedRotation, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

			remove(progdurationRotationTrainingsitesRel);
		}
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByRotationIdAndIsSharedRotation(
		long rotationId, boolean isSharedRotation) {

		FinderPath finderPath = _finderPathCountByRotationIdAndIsSharedRotation;

		Object[] finderArgs = new Object[] {rotationId, isSharedRotation};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDISSHAREDROTATION_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDISSHAREDROTATION_ISSHAREDROTATION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationId);

				queryPos.add(isSharedRotation);

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
		_FINDER_COLUMN_ROTATIONIDANDISSHAREDROTATION_ROTATIONID_2 =
			"progdurationRotationTrainingsitesRel.rotationId = ? AND ";

	private static final String
		_FINDER_COLUMN_ROTATIONIDANDISSHAREDROTATION_ISSHAREDROTATION_2 =
			"progdurationRotationTrainingsitesRel.isSharedRotation = ?";

	private FinderPath _finderPathFetchByProgDurationTrainingSiteAndRotationId;
	private FinderPath _finderPathCountByProgDurationTrainingSiteAndRotationId;

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			findByProgDurationTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId, long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				fetchByProgDurationTrainingSiteAndRotationId(
					trainingSitesId, rotationId, programDurationId);

		if (progdurationRotationTrainingsitesRel == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("trainingSitesId=");
			sb.append(trainingSitesId);

			sb.append(", rotationId=");
			sb.append(rotationId);

			sb.append(", programDurationId=");
			sb.append(programDurationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgdurationRotationTrainingsitesRelException(
				sb.toString());
		}

		return progdurationRotationTrainingsitesRel;
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, long programDurationId) {

		return fetchByProgDurationTrainingSiteAndRotationId(
			trainingSitesId, rotationId, programDurationId, true);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, long programDurationId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				trainingSitesId, rotationId, programDurationId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgDurationTrainingSiteAndRotationId,
				finderArgs, this);
		}

		if (result instanceof ProgdurationRotationTrainingsitesRel) {
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel =
					(ProgdurationRotationTrainingsitesRel)result;

			if ((trainingSitesId !=
					progdurationRotationTrainingsitesRel.
						getTrainingSitesId()) ||
				(rotationId !=
					progdurationRotationTrainingsitesRel.getRotationId()) ||
				(programDurationId !=
					progdurationRotationTrainingsitesRel.
						getProgramDurationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_TRAININGSITESID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSitesId);

				queryPos.add(rotationId);

				queryPos.add(programDurationId);

				List<ProgdurationRotationTrainingsitesRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgDurationTrainingSiteAndRotationId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									trainingSitesId, rotationId,
									programDurationId
								};
							}

							_log.warn(
								"ProgdurationRotationTrainingsitesRelPersistenceImpl.fetchByProgDurationTrainingSiteAndRotationId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel = list.get(0);

					result = progdurationRotationTrainingsitesRel;

					cacheResult(progdurationRotationTrainingsitesRel);
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
			return (ProgdurationRotationTrainingsitesRel)result;
		}
	}

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			removeByProgDurationTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId, long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				findByProgDurationTrainingSiteAndRotationId(
					trainingSitesId, rotationId, programDurationId);

		return remove(progdurationRotationTrainingsitesRel);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByProgDurationTrainingSiteAndRotationId(
		long trainingSitesId, long rotationId, long programDurationId) {

		FinderPath finderPath =
			_finderPathCountByProgDurationTrainingSiteAndRotationId;

		Object[] finderArgs = new Object[] {
			trainingSitesId, rotationId, programDurationId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_TRAININGSITESID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSitesId);

				queryPos.add(rotationId);

				queryPos.add(programDurationId);

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
		_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_TRAININGSITESID_2 =
			"progdurationRotationTrainingsitesRel.trainingSitesId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_ROTATIONID_2 =
			"progdurationRotationTrainingsitesRel.rotationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGDURATIONTRAININGSITEANDROTATIONID_PROGRAMDURATIONID_2 =
			"progdurationRotationTrainingsitesRel.programDurationId = ?";

	private FinderPath _finderPathFetchByProgDurationAndTrainingSite;
	private FinderPath _finderPathCountByProgDurationAndTrainingSite;

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			findByProgDurationAndTrainingSite(
				long trainingSitesId, long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				fetchByProgDurationAndTrainingSite(
					trainingSitesId, programDurationId);

		if (progdurationRotationTrainingsitesRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("trainingSitesId=");
			sb.append(trainingSitesId);

			sb.append(", programDurationId=");
			sb.append(programDurationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgdurationRotationTrainingsitesRelException(
				sb.toString());
		}

		return progdurationRotationTrainingsitesRel;
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationAndTrainingSite(
			long trainingSitesId, long programDurationId) {

		return fetchByProgDurationAndTrainingSite(
			trainingSitesId, programDurationId, true);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationAndTrainingSite(
			long trainingSitesId, long programDurationId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {trainingSitesId, programDurationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgDurationAndTrainingSite, finderArgs,
				this);
		}

		if (result instanceof ProgdurationRotationTrainingsitesRel) {
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel =
					(ProgdurationRotationTrainingsitesRel)result;

			if ((trainingSitesId !=
					progdurationRotationTrainingsitesRel.
						getTrainingSitesId()) ||
				(programDurationId !=
					progdurationRotationTrainingsitesRel.
						getProgramDurationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONANDTRAININGSITE_TRAININGSITESID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONANDTRAININGSITE_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSitesId);

				queryPos.add(programDurationId);

				List<ProgdurationRotationTrainingsitesRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgDurationAndTrainingSite,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									trainingSitesId, programDurationId
								};
							}

							_log.warn(
								"ProgdurationRotationTrainingsitesRelPersistenceImpl.fetchByProgDurationAndTrainingSite(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel = list.get(0);

					result = progdurationRotationTrainingsitesRel;

					cacheResult(progdurationRotationTrainingsitesRel);
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
			return (ProgdurationRotationTrainingsitesRel)result;
		}
	}

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			removeByProgDurationAndTrainingSite(
				long trainingSitesId, long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				findByProgDurationAndTrainingSite(
					trainingSitesId, programDurationId);

		return remove(progdurationRotationTrainingsitesRel);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and programDurationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByProgDurationAndTrainingSite(
		long trainingSitesId, long programDurationId) {

		FinderPath finderPath = _finderPathCountByProgDurationAndTrainingSite;

		Object[] finderArgs = new Object[] {trainingSitesId, programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONANDTRAININGSITE_TRAININGSITESID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONANDTRAININGSITE_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(trainingSitesId);

				queryPos.add(programDurationId);

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
		_FINDER_COLUMN_PROGDURATIONANDTRAININGSITE_TRAININGSITESID_2 =
			"progdurationRotationTrainingsitesRel.trainingSitesId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGDURATIONANDTRAININGSITE_PROGRAMDURATIONID_2 =
			"progdurationRotationTrainingsitesRel.programDurationId = ?";

	private FinderPath
		_finderPathFetchByProgDurationRotationOwningProgramAndRotationId;
	private FinderPath
		_finderPathCountByProgDurationRotationOwningProgramAndRotationId;

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			findByProgDurationRotationOwningProgramAndRotationId(
				long rotationOwningProgramId, long rotationId,
				long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				fetchByProgDurationRotationOwningProgramAndRotationId(
					rotationOwningProgramId, rotationId, programDurationId);

		if (progdurationRotationTrainingsitesRel == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("rotationOwningProgramId=");
			sb.append(rotationOwningProgramId);

			sb.append(", rotationId=");
			sb.append(rotationId);

			sb.append(", programDurationId=");
			sb.append(programDurationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgdurationRotationTrainingsitesRelException(
				sb.toString());
		}

		return progdurationRotationTrainingsitesRel;
	}

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationRotationOwningProgramAndRotationId(
			long rotationOwningProgramId, long rotationId,
			long programDurationId) {

		return fetchByProgDurationRotationOwningProgramAndRotationId(
			rotationOwningProgramId, rotationId, programDurationId, true);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
		fetchByProgDurationRotationOwningProgramAndRotationId(
			long rotationOwningProgramId, long rotationId,
			long programDurationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				rotationOwningProgramId, rotationId, programDurationId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgDurationRotationOwningProgramAndRotationId,
				finderArgs, this);
		}

		if (result instanceof ProgdurationRotationTrainingsitesRel) {
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel =
					(ProgdurationRotationTrainingsitesRel)result;

			if ((rotationOwningProgramId !=
					progdurationRotationTrainingsitesRel.
						getRotationOwningProgramId()) ||
				(rotationId !=
					progdurationRotationTrainingsitesRel.getRotationId()) ||
				(programDurationId !=
					progdurationRotationTrainingsitesRel.
						getProgramDurationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_ROTATIONOWNINGPROGRAMID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationOwningProgramId);

				queryPos.add(rotationId);

				queryPos.add(programDurationId);

				List<ProgdurationRotationTrainingsitesRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgDurationRotationOwningProgramAndRotationId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									rotationOwningProgramId, rotationId,
									programDurationId
								};
							}

							_log.warn(
								"ProgdurationRotationTrainingsitesRelPersistenceImpl.fetchByProgDurationRotationOwningProgramAndRotationId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgdurationRotationTrainingsitesRel
						progdurationRotationTrainingsitesRel = list.get(0);

					result = progdurationRotationTrainingsitesRel;

					cacheResult(progdurationRotationTrainingsitesRel);
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
			return (ProgdurationRotationTrainingsitesRel)result;
		}
	}

	/**
	 * Removes the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel
			removeByProgDurationRotationOwningProgramAndRotationId(
				long rotationOwningProgramId, long rotationId,
				long programDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				findByProgDurationRotationOwningProgramAndRotationId(
					rotationOwningProgramId, rotationId, programDurationId);

		return remove(progdurationRotationTrainingsitesRel);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63;.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	@Override
	public int countByProgDurationRotationOwningProgramAndRotationId(
		long rotationOwningProgramId, long rotationId, long programDurationId) {

		FinderPath finderPath =
			_finderPathCountByProgDurationRotationOwningProgramAndRotationId;

		Object[] finderArgs = new Object[] {
			rotationOwningProgramId, rotationId, programDurationId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_ROTATIONOWNINGPROGRAMID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationOwningProgramId);

				queryPos.add(rotationId);

				queryPos.add(programDurationId);

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
		_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_ROTATIONOWNINGPROGRAMID_2 =
			"progdurationRotationTrainingsitesRel.rotationOwningProgramId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_ROTATIONID_2 =
			"progdurationRotationTrainingsitesRel.rotationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGDURATIONROTATIONOWNINGPROGRAMANDROTATIONID_PROGRAMDURATIONID_2 =
			"progdurationRotationTrainingsitesRel.programDurationId = ?";

	public ProgdurationRotationTrainingsitesRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"progdurationRotationTsRelId", "progduration_rotation_ts_rel_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("trainingSitesId", "training_sites_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("isSharedRotation", "is_shared_rotation");
		dbColumnNames.put(
			"rotationOwningProgramId", "rotation_owning_program_id");
		dbColumnNames.put("progCodeRsnSiteCode", "progcode_rsn_sitecode");
		dbColumnNames.put(
			"owningProgramDurationId", "owning_program_duration_id");
		dbColumnNames.put("noOfSlots", "no_of_slots");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgdurationRotationTrainingsitesRel.class);

		setModelImplClass(ProgdurationRotationTrainingsitesRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProgdurationRotationTrainingsitesRelTable.INSTANCE);
	}

	/**
	 * Caches the progduration rotation trainingsites rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTrainingsitesRel the progduration rotation trainingsites rel
	 */
	@Override
	public void cacheResult(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		entityCache.putResult(
			ProgdurationRotationTrainingsitesRelImpl.class,
			progdurationRotationTrainingsitesRel.getPrimaryKey(),
			progdurationRotationTrainingsitesRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				progdurationRotationTrainingsitesRel.getUuid(),
				progdurationRotationTrainingsitesRel.getGroupId()
			},
			progdurationRotationTrainingsitesRel);

		finderCache.putResult(
			_finderPathFetchByTrainingSiteAndRotationId,
			new Object[] {
				progdurationRotationTrainingsitesRel.getTrainingSitesId(),
				progdurationRotationTrainingsitesRel.getRotationId()
			},
			progdurationRotationTrainingsitesRel);

		finderCache.putResult(
			_finderPathFetchByProgDurationTrainingSiteAndRotationId,
			new Object[] {
				progdurationRotationTrainingsitesRel.getTrainingSitesId(),
				progdurationRotationTrainingsitesRel.getRotationId(),
				progdurationRotationTrainingsitesRel.getProgramDurationId()
			},
			progdurationRotationTrainingsitesRel);

		finderCache.putResult(
			_finderPathFetchByProgDurationAndTrainingSite,
			new Object[] {
				progdurationRotationTrainingsitesRel.getTrainingSitesId(),
				progdurationRotationTrainingsitesRel.getProgramDurationId()
			},
			progdurationRotationTrainingsitesRel);

		finderCache.putResult(
			_finderPathFetchByProgDurationRotationOwningProgramAndRotationId,
			new Object[] {
				progdurationRotationTrainingsitesRel.
					getRotationOwningProgramId(),
				progdurationRotationTrainingsitesRel.getRotationId(),
				progdurationRotationTrainingsitesRel.getProgramDurationId()
			},
			progdurationRotationTrainingsitesRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the progduration rotation trainingsites rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTrainingsitesRels the progduration rotation trainingsites rels
	 */
	@Override
	public void cacheResult(
		List<ProgdurationRotationTrainingsitesRel>
			progdurationRotationTrainingsitesRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (progdurationRotationTrainingsitesRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel :
					progdurationRotationTrainingsitesRels) {

			if (entityCache.getResult(
					ProgdurationRotationTrainingsitesRelImpl.class,
					progdurationRotationTrainingsitesRel.getPrimaryKey()) ==
						null) {

				cacheResult(progdurationRotationTrainingsitesRel);
			}
		}
	}

	/**
	 * Clears the cache for all progduration rotation trainingsites rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgdurationRotationTrainingsitesRelImpl.class);

		finderCache.clearCache(ProgdurationRotationTrainingsitesRelImpl.class);
	}

	/**
	 * Clears the cache for the progduration rotation trainingsites rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		entityCache.removeResult(
			ProgdurationRotationTrainingsitesRelImpl.class,
			progdurationRotationTrainingsitesRel);
	}

	@Override
	public void clearCache(
		List<ProgdurationRotationTrainingsitesRel>
			progdurationRotationTrainingsitesRels) {

		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel :
					progdurationRotationTrainingsitesRels) {

			entityCache.removeResult(
				ProgdurationRotationTrainingsitesRelImpl.class,
				progdurationRotationTrainingsitesRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgdurationRotationTrainingsitesRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgdurationRotationTrainingsitesRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgdurationRotationTrainingsitesRelModelImpl
			progdurationRotationTrainingsitesRelModelImpl) {

		Object[] args = new Object[] {
			progdurationRotationTrainingsitesRelModelImpl.getUuid(),
			progdurationRotationTrainingsitesRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			progdurationRotationTrainingsitesRelModelImpl);

		args = new Object[] {
			progdurationRotationTrainingsitesRelModelImpl.getTrainingSitesId(),
			progdurationRotationTrainingsitesRelModelImpl.getRotationId()
		};

		finderCache.putResult(
			_finderPathCountByTrainingSiteAndRotationId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTrainingSiteAndRotationId, args,
			progdurationRotationTrainingsitesRelModelImpl);

		args = new Object[] {
			progdurationRotationTrainingsitesRelModelImpl.getTrainingSitesId(),
			progdurationRotationTrainingsitesRelModelImpl.getRotationId(),
			progdurationRotationTrainingsitesRelModelImpl.getProgramDurationId()
		};

		finderCache.putResult(
			_finderPathCountByProgDurationTrainingSiteAndRotationId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgDurationTrainingSiteAndRotationId, args,
			progdurationRotationTrainingsitesRelModelImpl);

		args = new Object[] {
			progdurationRotationTrainingsitesRelModelImpl.getTrainingSitesId(),
			progdurationRotationTrainingsitesRelModelImpl.getProgramDurationId()
		};

		finderCache.putResult(
			_finderPathCountByProgDurationAndTrainingSite, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgDurationAndTrainingSite, args,
			progdurationRotationTrainingsitesRelModelImpl);

		args = new Object[] {
			progdurationRotationTrainingsitesRelModelImpl.
				getRotationOwningProgramId(),
			progdurationRotationTrainingsitesRelModelImpl.getRotationId(),
			progdurationRotationTrainingsitesRelModelImpl.getProgramDurationId()
		};

		finderCache.putResult(
			_finderPathCountByProgDurationRotationOwningProgramAndRotationId,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgDurationRotationOwningProgramAndRotationId,
			args, progdurationRotationTrainingsitesRelModelImpl);
	}

	/**
	 * Creates a new progduration rotation trainingsites rel with the primary key. Does not add the progduration rotation trainingsites rel to the database.
	 *
	 * @param progdurationRotationTsRelId the primary key for the new progduration rotation trainingsites rel
	 * @return the new progduration rotation trainingsites rel
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel create(
		long progdurationRotationTsRelId) {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				new ProgdurationRotationTrainingsitesRelImpl();

		progdurationRotationTrainingsitesRel.setNew(true);
		progdurationRotationTrainingsitesRel.setPrimaryKey(
			progdurationRotationTsRelId);

		String uuid = _portalUUID.generate();

		progdurationRotationTrainingsitesRel.setUuid(uuid);

		progdurationRotationTrainingsitesRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return progdurationRotationTrainingsitesRel;
	}

	/**
	 * Removes the progduration rotation trainingsites rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel that was removed
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel remove(
			long progdurationRotationTsRelId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		return remove((Serializable)progdurationRotationTsRelId);
	}

	/**
	 * Removes the progduration rotation trainingsites rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel that was removed
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel remove(Serializable primaryKey)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel =
					(ProgdurationRotationTrainingsitesRel)session.get(
						ProgdurationRotationTrainingsitesRelImpl.class,
						primaryKey);

			if (progdurationRotationTrainingsitesRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgdurationRotationTrainingsitesRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(progdurationRotationTrainingsitesRel);
		}
		catch (NoSuchProgdurationRotationTrainingsitesRelException
					noSuchEntityException) {

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
	protected ProgdurationRotationTrainingsitesRel removeImpl(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(progdurationRotationTrainingsitesRel)) {
				progdurationRotationTrainingsitesRel =
					(ProgdurationRotationTrainingsitesRel)session.get(
						ProgdurationRotationTrainingsitesRelImpl.class,
						progdurationRotationTrainingsitesRel.
							getPrimaryKeyObj());
			}

			if (progdurationRotationTrainingsitesRel != null) {
				session.delete(progdurationRotationTrainingsitesRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (progdurationRotationTrainingsitesRel != null) {
			clearCache(progdurationRotationTrainingsitesRel);
		}

		return progdurationRotationTrainingsitesRel;
	}

	@Override
	public ProgdurationRotationTrainingsitesRel updateImpl(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		boolean isNew = progdurationRotationTrainingsitesRel.isNew();

		if (!(progdurationRotationTrainingsitesRel instanceof
				ProgdurationRotationTrainingsitesRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					progdurationRotationTrainingsitesRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					progdurationRotationTrainingsitesRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in progdurationRotationTrainingsitesRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgdurationRotationTrainingsitesRel implementation " +
					progdurationRotationTrainingsitesRel.getClass());
		}

		ProgdurationRotationTrainingsitesRelModelImpl
			progdurationRotationTrainingsitesRelModelImpl =
				(ProgdurationRotationTrainingsitesRelModelImpl)
					progdurationRotationTrainingsitesRel;

		if (Validator.isNull(progdurationRotationTrainingsitesRel.getUuid())) {
			String uuid = _portalUUID.generate();

			progdurationRotationTrainingsitesRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(progdurationRotationTrainingsitesRel.getCreateDate() == null)) {

			if (serviceContext == null) {
				progdurationRotationTrainingsitesRel.setCreateDate(date);
			}
			else {
				progdurationRotationTrainingsitesRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!progdurationRotationTrainingsitesRelModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				progdurationRotationTrainingsitesRel.setModifiedDate(date);
			}
			else {
				progdurationRotationTrainingsitesRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(progdurationRotationTrainingsitesRel);
			}
			else {
				progdurationRotationTrainingsitesRel =
					(ProgdurationRotationTrainingsitesRel)session.merge(
						progdurationRotationTrainingsitesRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgdurationRotationTrainingsitesRelImpl.class,
			progdurationRotationTrainingsitesRelModelImpl, false, true);

		cacheUniqueFindersCache(progdurationRotationTrainingsitesRelModelImpl);

		if (isNew) {
			progdurationRotationTrainingsitesRel.setNew(false);
		}

		progdurationRotationTrainingsitesRel.resetOriginalValues();

		return progdurationRotationTrainingsitesRel;
	}

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel = fetchByPrimaryKey(
				primaryKey);

		if (progdurationRotationTrainingsitesRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgdurationRotationTrainingsitesRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return progdurationRotationTrainingsitesRel;
	}

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel findByPrimaryKey(
			long progdurationRotationTsRelId)
		throws NoSuchProgdurationRotationTrainingsitesRelException {

		return findByPrimaryKey((Serializable)progdurationRotationTsRelId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel, or <code>null</code> if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTrainingsitesRel fetchByPrimaryKey(
		long progdurationRotationTsRelId) {

		return fetchByPrimaryKey((Serializable)progdurationRotationTsRelId);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels.
	 *
	 * @return the progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation trainingsites rels
	 */
	@Override
	public List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
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

		List<ProgdurationRotationTrainingsitesRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTrainingsitesRel>)
					finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL;

				sql = sql.concat(
					ProgdurationRotationTrainingsitesRelModelImpl.
						ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<ProgdurationRotationTrainingsitesRel>)QueryUtil.list(
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
	 * Removes all the progduration rotation trainingsites rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel : findAll()) {

			remove(progdurationRotationTrainingsitesRel);
		}
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels.
	 *
	 * @return the number of progduration rotation trainingsites rels
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
					_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL);

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
		return "progduration_rotation_ts_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgdurationRotationTrainingsitesRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the progduration rotation trainingsites rel persistence.
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

		_finderPathWithPaginationFindByProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProgramDurationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_duration_id"}, true);

		_finderPathWithoutPaginationFindByProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProgramDurationId", new String[] {Long.class.getName()},
			new String[] {"program_duration_id"}, true);

		_finderPathCountByProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramDurationId", new String[] {Long.class.getName()},
			new String[] {"program_duration_id"}, false);

		_finderPathWithPaginationFindByRotationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRotationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"rotation_id"}, true);

		_finderPathWithoutPaginationFindByRotationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRotationId",
			new String[] {Long.class.getName()}, new String[] {"rotation_id"},
			true);

		_finderPathCountByRotationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRotationId",
			new String[] {Long.class.getName()}, new String[] {"rotation_id"},
			false);

		_finderPathWithPaginationFindByTrainingSitesId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrainingSitesId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"training_sites_id"}, true);

		_finderPathWithoutPaginationFindByTrainingSitesId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrainingSitesId",
			new String[] {Long.class.getName()},
			new String[] {"training_sites_id"}, true);

		_finderPathCountByTrainingSitesId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrainingSitesId",
			new String[] {Long.class.getName()},
			new String[] {"training_sites_id"}, false);

		_finderPathFetchByTrainingSiteAndRotationId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTrainingSiteAndRotationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"training_sites_id", "rotation_id"}, true);

		_finderPathCountByTrainingSiteAndRotationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTrainingSiteAndRotationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"training_sites_id", "rotation_id"}, false);

		_finderPathWithPaginationFindByRotationIdAndIsSharedRotation =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRotationIdAndIsSharedRotation",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"rotation_id", "is_shared_rotation"}, true);

		_finderPathWithoutPaginationFindByRotationIdAndIsSharedRotation =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRotationIdAndIsSharedRotation",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				new String[] {"rotation_id", "is_shared_rotation"}, true);

		_finderPathCountByRotationIdAndIsSharedRotation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRotationIdAndIsSharedRotation",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"rotation_id", "is_shared_rotation"}, false);

		_finderPathFetchByProgDurationTrainingSiteAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgDurationTrainingSiteAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"training_sites_id", "rotation_id", "program_duration_id"
				},
				true);

		_finderPathCountByProgDurationTrainingSiteAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgDurationTrainingSiteAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"training_sites_id", "rotation_id", "program_duration_id"
				},
				false);

		_finderPathFetchByProgDurationAndTrainingSite = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProgDurationAndTrainingSite",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"training_sites_id", "program_duration_id"}, true);

		_finderPathCountByProgDurationAndTrainingSite = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgDurationAndTrainingSite",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"training_sites_id", "program_duration_id"}, false);

		_finderPathFetchByProgDurationRotationOwningProgramAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgDurationRotationOwningProgramAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"rotation_owning_program_id", "rotation_id",
					"program_duration_id"
				},
				true);

		_finderPathCountByProgDurationRotationOwningProgramAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgDurationRotationOwningProgramAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"rotation_owning_program_id", "rotation_id",
					"program_duration_id"
				},
				false);

		_setProgdurationRotationTrainingsitesRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgdurationRotationTrainingsitesRelUtilPersistence(null);

		entityCache.removeCache(
			ProgdurationRotationTrainingsitesRelImpl.class.getName());
	}

	private void _setProgdurationRotationTrainingsitesRelUtilPersistence(
		ProgdurationRotationTrainingsitesRelPersistence
			progdurationRotationTrainingsitesRelPersistence) {

		try {
			Field field =
				ProgdurationRotationTrainingsitesRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, progdurationRotationTrainingsitesRelPersistence);
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

	private static final String
		_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL =
			"SELECT progdurationRotationTrainingsitesRel FROM ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel";

	private static final String
		_SQL_SELECT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE =
			"SELECT progdurationRotationTrainingsitesRel FROM ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel WHERE ";

	private static final String
		_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL =
			"SELECT COUNT(progdurationRotationTrainingsitesRel) FROM ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel";

	private static final String
		_SQL_COUNT_PROGDURATIONROTATIONTRAININGSITESREL_WHERE =
			"SELECT COUNT(progdurationRotationTrainingsitesRel) FROM ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"progdurationRotationTrainingsitesRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgdurationRotationTrainingsitesRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgdurationRotationTrainingsitesRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgdurationRotationTrainingsitesRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "progdurationRotationTsRelId", "programDurationId",
			"rotationId", "trainingSitesId", "groupId", "companyId",
			"createDate", "modifiedDate", "createdBy", "modifiedBy",
			"isSharedRotation", "rotationOwningProgramId",
			"progCodeRsnSiteCode", "owningProgramDurationId", "noOfSlots"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchProgdurationRotationTraineelevelBlocksRelException;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRelTable;
import gov.omsb.tms.model.impl.ProgdurationRotationTraineelevelBlocksRelImpl;
import gov.omsb.tms.model.impl.ProgdurationRotationTraineelevelBlocksRelModelImpl;
import gov.omsb.tms.service.persistence.ProgdurationRotationTraineelevelBlocksRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationRotationTraineelevelBlocksRelUtil;
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
 * The persistence implementation for the progduration rotation traineelevel blocks rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgdurationRotationTraineelevelBlocksRelPersistence.class)
public class ProgdurationRotationTraineelevelBlocksRelPersistenceImpl
	extends BasePersistenceImpl<ProgdurationRotationTraineelevelBlocksRel>
	implements ProgdurationRotationTraineelevelBlocksRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgdurationRotationTraineelevelBlocksRelUtil</code> to access the progduration rotation traineelevel blocks rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgdurationRotationTraineelevelBlocksRelImpl.class.getName();

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
	 * Returns all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid) {

		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		List<ProgdurationRotationTraineelevelBlocksRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTraineelevelBlocksRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel : list) {

					if (!uuid.equals(
							progdurationRotationTraineelevelBlocksRel.
								getUuid())) {

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

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
					ProgdurationRotationTraineelevelBlocksRelModelImpl.
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
					(List<ProgdurationRotationTraineelevelBlocksRel>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = fetchByUuid_First(
				uuid, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		List<ProgdurationRotationTraineelevelBlocksRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = fetchByUuid_Last(
				uuid, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel[] findByUuid_PrevAndNext(
			long progdurationRotationTlBlocksRelId, String uuid,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = findByPrimaryKey(
				progdurationRotationTlBlocksRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTraineelevelBlocksRel[] array =
				new ProgdurationRotationTraineelevelBlocksRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel, uuid,
				orderByComparator, true);

			array[1] = progdurationRotationTraineelevelBlocksRel;

			array[2] = getByUuid_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel, uuid,
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

	protected ProgdurationRotationTraineelevelBlocksRel getByUuid_PrevAndNext(
		Session session,
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel,
		String uuid,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
				ProgdurationRotationTraineelevelBlocksRelModelImpl.
					ORDER_BY_JPQL);
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
						progdurationRotationTraineelevelBlocksRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(progdurationRotationTraineelevelBlocksRel);
		}
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
		"progdurationRotationTraineelevelBlocksRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(progdurationRotationTraineelevelBlocksRel.uuid IS NULL OR progdurationRotationTraineelevelBlocksRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = fetchByUUID_G(
				uuid, groupId);

		if (progdurationRotationTraineelevelBlocksRel == null) {
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

			throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
				sb.toString());
		}

		return progdurationRotationTraineelevelBlocksRel;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel fetchByUUID_G(
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

		if (result instanceof ProgdurationRotationTraineelevelBlocksRel) {
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel =
					(ProgdurationRotationTraineelevelBlocksRel)result;

			if (!Objects.equals(
					uuid,
					progdurationRotationTraineelevelBlocksRel.getUuid()) ||
				(groupId !=
					progdurationRotationTraineelevelBlocksRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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

				List<ProgdurationRotationTraineelevelBlocksRel> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel = list.get(0);

					result = progdurationRotationTraineelevelBlocksRel;

					cacheResult(progdurationRotationTraineelevelBlocksRel);
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
			return (ProgdurationRotationTraineelevelBlocksRel)result;
		}
	}

	/**
	 * Removes the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = findByUUID_G(
				uuid, groupId);

		return remove(progdurationRotationTraineelevelBlocksRel);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
		"progdurationRotationTraineelevelBlocksRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(progdurationRotationTraineelevelBlocksRel.uuid IS NULL OR progdurationRotationTraineelevelBlocksRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"progdurationRotationTraineelevelBlocksRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		List<ProgdurationRotationTraineelevelBlocksRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTraineelevelBlocksRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel : list) {

					if (!uuid.equals(
							progdurationRotationTraineelevelBlocksRel.
								getUuid()) ||
						(companyId !=
							progdurationRotationTraineelevelBlocksRel.
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

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
					ProgdurationRotationTraineelevelBlocksRelModelImpl.
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
					(List<ProgdurationRotationTraineelevelBlocksRel>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = fetchByUuid_C_First(
				uuid, companyId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		List<ProgdurationRotationTraineelevelBlocksRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = fetchByUuid_C_Last(
				uuid, companyId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel[] findByUuid_C_PrevAndNext(
			long progdurationRotationTlBlocksRelId, String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = findByPrimaryKey(
				progdurationRotationTlBlocksRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTraineelevelBlocksRel[] array =
				new ProgdurationRotationTraineelevelBlocksRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel, uuid,
				companyId, orderByComparator, true);

			array[1] = progdurationRotationTraineelevelBlocksRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel, uuid,
				companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgdurationRotationTraineelevelBlocksRel getByUuid_C_PrevAndNext(
		Session session,
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel,
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
				ProgdurationRotationTraineelevelBlocksRelModelImpl.
					ORDER_BY_JPQL);
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
						progdurationRotationTraineelevelBlocksRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTraineelevelBlocksRel);
		}
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
		"progdurationRotationTraineelevelBlocksRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(progdurationRotationTraineelevelBlocksRel.uuid IS NULL OR progdurationRotationTraineelevelBlocksRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"progdurationRotationTraineelevelBlocksRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTraineeLevelId;
	private FinderPath _finderPathWithoutPaginationFindByTraineeLevelId;
	private FinderPath _finderPathCountByTraineeLevelId;

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByTraineeLevelId(
		long traineeLevelId) {

		return findByTraineeLevelId(
			traineeLevelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByTraineeLevelId(
		long traineeLevelId, int start, int end) {

		return findByTraineeLevelId(traineeLevelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByTraineeLevelId(
		long traineeLevelId, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return findByTraineeLevelId(
			traineeLevelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findByTraineeLevelId(
		long traineeLevelId, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTraineeLevelId;
				finderArgs = new Object[] {traineeLevelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTraineeLevelId;
			finderArgs = new Object[] {
				traineeLevelId, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTraineelevelBlocksRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel : list) {

					if (traineeLevelId !=
							progdurationRotationTraineelevelBlocksRel.
								getTraineeLevelId()) {

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

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEELEVELID_TRAINEELEVELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTraineelevelBlocksRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeLevelId);

				list =
					(List<ProgdurationRotationTraineelevelBlocksRel>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByTraineeLevelId_First(
			long traineeLevelId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByTraineeLevelId_First(traineeLevelId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeLevelId=");
		sb.append(traineeLevelId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelId_First(
			long traineeLevelId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByTraineeLevelId(traineeLevelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByTraineeLevelId_Last(
			long traineeLevelId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByTraineeLevelId_Last(traineeLevelId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeLevelId=");
		sb.append(traineeLevelId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel fetchByTraineeLevelId_Last(
		long traineeLevelId,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		int count = countByTraineeLevelId(traineeLevelId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByTraineeLevelId(
				traineeLevelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByTraineeLevelId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = findByPrimaryKey(
				progdurationRotationTlBlocksRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTraineelevelBlocksRel[] array =
				new ProgdurationRotationTraineelevelBlocksRelImpl[3];

			array[0] = getByTraineeLevelId_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				traineeLevelId, orderByComparator, true);

			array[1] = progdurationRotationTraineelevelBlocksRel;

			array[2] = getByTraineeLevelId_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				traineeLevelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgdurationRotationTraineelevelBlocksRel
		getByTraineeLevelId_PrevAndNext(
			Session session,
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel,
			long traineeLevelId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

		sb.append(_FINDER_COLUMN_TRAINEELEVELID_TRAINEELEVELID_2);

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
				ProgdurationRotationTraineelevelBlocksRelModelImpl.
					ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeLevelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTraineelevelBlocksRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 */
	@Override
	public void removeByTraineeLevelId(long traineeLevelId) {
		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					findByTraineeLevelId(
						traineeLevelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTraineelevelBlocksRel);
		}
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByTraineeLevelId(long traineeLevelId) {
		FinderPath finderPath = _finderPathCountByTraineeLevelId;

		Object[] finderArgs = new Object[] {traineeLevelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEELEVELID_TRAINEELEVELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeLevelId);

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

	private static final String _FINDER_COLUMN_TRAINEELEVELID_TRAINEELEVELID_2 =
		"progdurationRotationTraineelevelBlocksRel.traineeLevelId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		List<ProgdurationRotationTraineelevelBlocksRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTraineelevelBlocksRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel : list) {

					if (programDurationId !=
							progdurationRotationTraineelevelBlocksRel.
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

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTraineelevelBlocksRelModelImpl.
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
					(List<ProgdurationRotationTraineelevelBlocksRel>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationId_First(
				long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByProgramDurationId_First(
					programDurationId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByProgramDurationId(programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationId_Last(
				long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByProgramDurationId_Last(
					programDurationId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByProgramDurationId(
				programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = findByPrimaryKey(
				progdurationRotationTlBlocksRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTraineelevelBlocksRel[] array =
				new ProgdurationRotationTraineelevelBlocksRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				programDurationId, orderByComparator, true);

			array[1] = progdurationRotationTraineelevelBlocksRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
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

	protected ProgdurationRotationTraineelevelBlocksRel
		getByProgramDurationId_PrevAndNext(
			Session session,
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel,
			long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
				ProgdurationRotationTraineelevelBlocksRelModelImpl.
					ORDER_BY_JPQL);
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
						progdurationRotationTraineelevelBlocksRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					findByProgramDurationId(
						programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTraineelevelBlocksRel);
		}
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

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
			"progdurationRotationTraineelevelBlocksRel.programDurationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByProgramDurationIdAndTraineeLevelId;
	private FinderPath
		_finderPathWithoutPaginationFindByProgramDurationIdAndTraineeLevelId;
	private FinderPath _finderPathCountByProgramDurationIdAndTraineeLevelId;

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId) {

		return findByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end) {

		return findByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return findByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgramDurationIdAndTraineeLevelId;
				finderArgs = new Object[] {traineeLevelId, programDurationId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByProgramDurationIdAndTraineeLevelId;
			finderArgs = new Object[] {
				traineeLevelId, programDurationId, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTraineelevelBlocksRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel : list) {

					if ((traineeLevelId !=
							progdurationRotationTraineelevelBlocksRel.
								getTraineeLevelId()) ||
						(programDurationId !=
							progdurationRotationTraineelevelBlocksRel.
								getProgramDurationId())) {

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

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_TRAINEELEVELID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTraineelevelBlocksRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeLevelId);

				queryPos.add(programDurationId);

				list =
					(List<ProgdurationRotationTraineelevelBlocksRel>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelId_First(
				long traineeLevelId, long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByProgramDurationIdAndTraineeLevelId_First(
					traineeLevelId, programDurationId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeLevelId=");
		sb.append(traineeLevelId);

		sb.append(", programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelId_First(
			long traineeLevelId, long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByProgramDurationIdAndTraineeLevelId(
				traineeLevelId, programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelId_Last(
				long traineeLevelId, long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByProgramDurationIdAndTraineeLevelId_Last(
					traineeLevelId, programDurationId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeLevelId=");
		sb.append(traineeLevelId);

		sb.append(", programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelId_Last(
			long traineeLevelId, long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		int count = countByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByProgramDurationIdAndTraineeLevelId(
				traineeLevelId, programDurationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationIdAndTraineeLevelId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = findByPrimaryKey(
				progdurationRotationTlBlocksRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTraineelevelBlocksRel[] array =
				new ProgdurationRotationTraineelevelBlocksRelImpl[3];

			array[0] = getByProgramDurationIdAndTraineeLevelId_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				traineeLevelId, programDurationId, orderByComparator, true);

			array[1] = progdurationRotationTraineelevelBlocksRel;

			array[2] = getByProgramDurationIdAndTraineeLevelId_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				traineeLevelId, programDurationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgdurationRotationTraineelevelBlocksRel
		getByProgramDurationIdAndTraineeLevelId_PrevAndNext(
			Session session,
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel,
			long traineeLevelId, long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

		sb.append(
			_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_TRAINEELEVELID_2);

		sb.append(
			_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_PROGRAMDURATIONID_2);

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
				ProgdurationRotationTraineelevelBlocksRelModelImpl.
					ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeLevelId);

		queryPos.add(programDurationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTraineelevelBlocksRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationIdAndTraineeLevelId(
		long traineeLevelId, long programDurationId) {

		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					findByProgramDurationIdAndTraineeLevelId(
						traineeLevelId, programDurationId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

			remove(progdurationRotationTraineelevelBlocksRel);
		}
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByProgramDurationIdAndTraineeLevelId(
		long traineeLevelId, long programDurationId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndTraineeLevelId;

		Object[] finderArgs = new Object[] {traineeLevelId, programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_TRAINEELEVELID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeLevelId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_TRAINEELEVELID_2 =
			"progdurationRotationTraineelevelBlocksRel.traineeLevelId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_PROGRAMDURATIONID_2 =
			"progdurationRotationTraineelevelBlocksRel.programDurationId = ?";

	private FinderPath
		_finderPathFetchByProgramDurationIdAndTraineeLevelIdAndRotationId;
	private FinderPath
		_finderPathCountByProgramDurationIdAndTraineeLevelIdAndRotationId;

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
					traineeLevelId, programDurationId, rotationId);

		if (progdurationRotationTraineelevelBlocksRel == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeLevelId=");
			sb.append(traineeLevelId);

			sb.append(", programDurationId=");
			sb.append(programDurationId);

			sb.append(", rotationId=");
			sb.append(rotationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
				sb.toString());
		}

		return progdurationRotationTraineelevelBlocksRel;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
			long traineeLevelId, long programDurationId, long rotationId) {

		return fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
			traineeLevelId, programDurationId, rotationId, true);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
			long traineeLevelId, long programDurationId, long rotationId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				traineeLevelId, programDurationId, rotationId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramDurationIdAndTraineeLevelIdAndRotationId,
				finderArgs, this);
		}

		if (result instanceof ProgdurationRotationTraineelevelBlocksRel) {
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel =
					(ProgdurationRotationTraineelevelBlocksRel)result;

			if ((traineeLevelId !=
					progdurationRotationTraineelevelBlocksRel.
						getTraineeLevelId()) ||
				(programDurationId !=
					progdurationRotationTraineelevelBlocksRel.
						getProgramDurationId()) ||
				(rotationId !=
					progdurationRotationTraineelevelBlocksRel.
						getRotationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_TRAINEELEVELID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_ROTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeLevelId);

				queryPos.add(programDurationId);

				queryPos.add(rotationId);

				List<ProgdurationRotationTraineelevelBlocksRel> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramDurationIdAndTraineeLevelIdAndRotationId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									traineeLevelId, programDurationId,
									rotationId
								};
							}

							_log.warn(
								"ProgdurationRotationTraineelevelBlocksRelPersistenceImpl.fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel = list.get(0);

					result = progdurationRotationTraineelevelBlocksRel;

					cacheResult(progdurationRotationTraineelevelBlocksRel);
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
			return (ProgdurationRotationTraineelevelBlocksRel)result;
		}
	}

	/**
	 * Removes the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			removeByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				findByProgramDurationIdAndTraineeLevelIdAndRotationId(
					traineeLevelId, programDurationId, rotationId);

		return remove(progdurationRotationTraineelevelBlocksRel);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByProgramDurationIdAndTraineeLevelIdAndRotationId(
		long traineeLevelId, long programDurationId, long rotationId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndTraineeLevelIdAndRotationId;

		Object[] finderArgs = new Object[] {
			traineeLevelId, programDurationId, rotationId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_TRAINEELEVELID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_ROTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeLevelId);

				queryPos.add(programDurationId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_TRAINEELEVELID_2 =
			"progdurationRotationTraineelevelBlocksRel.traineeLevelId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_PROGRAMDURATIONID_2 =
			"progdurationRotationTraineelevelBlocksRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELIDANDROTATIONID_ROTATIONID_2 =
			"progdurationRotationTraineelevelBlocksRel.rotationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByProgramDurationIdAndRotationId;
	private FinderPath
		_finderPathWithoutPaginationFindByProgramDurationIdAndRotationId;
	private FinderPath _finderPathCountByProgramDurationIdAndRotationId;

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId) {

		return findByProgramDurationIdAndRotationId(
			programDurationId, rotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end) {

		return findByProgramDurationIdAndRotationId(
			programDurationId, rotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return findByProgramDurationIdAndRotationId(
			programDurationId, rotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgramDurationIdAndRotationId;
				finderArgs = new Object[] {programDurationId, rotationId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByProgramDurationIdAndRotationId;
			finderArgs = new Object[] {
				programDurationId, rotationId, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTraineelevelBlocksRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel : list) {

					if ((programDurationId !=
							progdurationRotationTraineelevelBlocksRel.
								getProgramDurationId()) ||
						(rotationId !=
							progdurationRotationTraineelevelBlocksRel.
								getRotationId())) {

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

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDROTATIONID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDROTATIONID_ROTATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTraineelevelBlocksRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(rotationId);

				list =
					(List<ProgdurationRotationTraineelevelBlocksRel>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndRotationId_First(
				long programDurationId, long rotationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByProgramDurationIdAndRotationId_First(
					programDurationId, rotationId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append(", rotationId=");
		sb.append(rotationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndRotationId_First(
			long programDurationId, long rotationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByProgramDurationIdAndRotationId(
				programDurationId, rotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndRotationId_Last(
				long programDurationId, long rotationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByProgramDurationIdAndRotationId_Last(
					programDurationId, rotationId, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append(", rotationId=");
		sb.append(rotationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndRotationId_Last(
			long programDurationId, long rotationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		int count = countByProgramDurationIdAndRotationId(
			programDurationId, rotationId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByProgramDurationIdAndRotationId(
				programDurationId, rotationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationIdAndRotationId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long programDurationId,
				long rotationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = findByPrimaryKey(
				progdurationRotationTlBlocksRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTraineelevelBlocksRel[] array =
				new ProgdurationRotationTraineelevelBlocksRelImpl[3];

			array[0] = getByProgramDurationIdAndRotationId_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				programDurationId, rotationId, orderByComparator, true);

			array[1] = progdurationRotationTraineelevelBlocksRel;

			array[2] = getByProgramDurationIdAndRotationId_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				programDurationId, rotationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgdurationRotationTraineelevelBlocksRel
		getByProgramDurationIdAndRotationId_PrevAndNext(
			Session session,
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel,
			long programDurationId, long rotationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

		sb.append(
			_FINDER_COLUMN_PROGRAMDURATIONIDANDROTATIONID_PROGRAMDURATIONID_2);

		sb.append(_FINDER_COLUMN_PROGRAMDURATIONIDANDROTATIONID_ROTATIONID_2);

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
				ProgdurationRotationTraineelevelBlocksRelModelImpl.
					ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programDurationId);

		queryPos.add(rotationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTraineelevelBlocksRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 */
	@Override
	public void removeByProgramDurationIdAndRotationId(
		long programDurationId, long rotationId) {

		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					findByProgramDurationIdAndRotationId(
						programDurationId, rotationId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

			remove(progdurationRotationTraineelevelBlocksRel);
		}
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByProgramDurationIdAndRotationId(
		long programDurationId, long rotationId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndRotationId;

		Object[] finderArgs = new Object[] {programDurationId, rotationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDROTATIONID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDROTATIONID_ROTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDROTATIONID_PROGRAMDURATIONID_2 =
			"progdurationRotationTraineelevelBlocksRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDROTATIONID_ROTATIONID_2 =
			"progdurationRotationTraineelevelBlocksRel.rotationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByTraineeLevelIdAndRotationType;
	private FinderPath
		_finderPathWithoutPaginationFindByTraineeLevelIdAndRotationType;
	private FinderPath _finderPathCountByTraineeLevelIdAndRotationType;

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType) {

		return findByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end) {

		return findByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return findByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTraineeLevelIdAndRotationType;
				finderArgs = new Object[] {traineeLevelId, rotationType};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTraineeLevelIdAndRotationType;
			finderArgs = new Object[] {
				traineeLevelId, rotationType, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTraineelevelBlocksRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTraineelevelBlocksRel
						progdurationRotationTraineelevelBlocksRel : list) {

					if ((traineeLevelId !=
							progdurationRotationTraineelevelBlocksRel.
								getTraineeLevelId()) ||
						(rotationType !=
							progdurationRotationTraineelevelBlocksRel.
								getRotationType())) {

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

			sb.append(
				_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEELEVELIDANDROTATIONTYPE_TRAINEELEVELID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEELEVELIDANDROTATIONTYPE_ROTATIONTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTraineelevelBlocksRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeLevelId);

				queryPos.add(rotationType);

				list =
					(List<ProgdurationRotationTraineelevelBlocksRel>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByTraineeLevelIdAndRotationType_First(
				long traineeLevelId, long rotationType,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByTraineeLevelIdAndRotationType_First(
					traineeLevelId, rotationType, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeLevelId=");
		sb.append(traineeLevelId);

		sb.append(", rotationType=");
		sb.append(rotationType);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelIdAndRotationType_First(
			long traineeLevelId, long rotationType,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByTraineeLevelIdAndRotationType(
				traineeLevelId, rotationType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
			findByTraineeLevelIdAndRotationType_Last(
				long traineeLevelId, long rotationType,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				fetchByTraineeLevelIdAndRotationType_Last(
					traineeLevelId, rotationType, orderByComparator);

		if (progdurationRotationTraineelevelBlocksRel != null) {
			return progdurationRotationTraineelevelBlocksRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeLevelId=");
		sb.append(traineeLevelId);

		sb.append(", rotationType=");
		sb.append(rotationType);

		sb.append("}");

		throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelIdAndRotationType_Last(
			long traineeLevelId, long rotationType,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		int count = countByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list =
			findByTraineeLevelIdAndRotationType(
				traineeLevelId, rotationType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel[]
			findByTraineeLevelIdAndRotationType_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				long rotationType,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = findByPrimaryKey(
				progdurationRotationTlBlocksRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTraineelevelBlocksRel[] array =
				new ProgdurationRotationTraineelevelBlocksRelImpl[3];

			array[0] = getByTraineeLevelIdAndRotationType_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				traineeLevelId, rotationType, orderByComparator, true);

			array[1] = progdurationRotationTraineelevelBlocksRel;

			array[2] = getByTraineeLevelIdAndRotationType_PrevAndNext(
				session, progdurationRotationTraineelevelBlocksRel,
				traineeLevelId, rotationType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgdurationRotationTraineelevelBlocksRel
		getByTraineeLevelIdAndRotationType_PrevAndNext(
			Session session,
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel,
			long traineeLevelId, long rotationType,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

		sb.append(
			_FINDER_COLUMN_TRAINEELEVELIDANDROTATIONTYPE_TRAINEELEVELID_2);

		sb.append(_FINDER_COLUMN_TRAINEELEVELIDANDROTATIONTYPE_ROTATIONTYPE_2);

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
				ProgdurationRotationTraineelevelBlocksRelModelImpl.
					ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeLevelId);

		queryPos.add(rotationType);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTraineelevelBlocksRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTraineelevelBlocksRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 */
	@Override
	public void removeByTraineeLevelIdAndRotationType(
		long traineeLevelId, long rotationType) {

		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					findByTraineeLevelIdAndRotationType(
						traineeLevelId, rotationType, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

			remove(progdurationRotationTraineelevelBlocksRel);
		}
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	@Override
	public int countByTraineeLevelIdAndRotationType(
		long traineeLevelId, long rotationType) {

		FinderPath finderPath = _finderPathCountByTraineeLevelIdAndRotationType;

		Object[] finderArgs = new Object[] {traineeLevelId, rotationType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(
				_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEELEVELIDANDROTATIONTYPE_TRAINEELEVELID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEELEVELIDANDROTATIONTYPE_ROTATIONTYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeLevelId);

				queryPos.add(rotationType);

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
		_FINDER_COLUMN_TRAINEELEVELIDANDROTATIONTYPE_TRAINEELEVELID_2 =
			"progdurationRotationTraineelevelBlocksRel.traineeLevelId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEELEVELIDANDROTATIONTYPE_ROTATIONTYPE_2 =
			"progdurationRotationTraineelevelBlocksRel.rotationType = ?";

	public ProgdurationRotationTraineelevelBlocksRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"progdurationRotationTlBlocksRelId",
			"progduration_rotation_tl_blocks_rel_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("rotationType", "rotation_type");
		dbColumnNames.put("traineeLevelId", "trainee_level_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("noOfBlocks", "no_of_blocks");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgdurationRotationTraineelevelBlocksRel.class);

		setModelImplClass(ProgdurationRotationTraineelevelBlocksRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProgdurationRotationTraineelevelBlocksRelTable.INSTANCE);
	}

	/**
	 * Caches the progduration rotation traineelevel blocks rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 */
	@Override
	public void cacheResult(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		entityCache.putResult(
			ProgdurationRotationTraineelevelBlocksRelImpl.class,
			progdurationRotationTraineelevelBlocksRel.getPrimaryKey(),
			progdurationRotationTraineelevelBlocksRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				progdurationRotationTraineelevelBlocksRel.getUuid(),
				progdurationRotationTraineelevelBlocksRel.getGroupId()
			},
			progdurationRotationTraineelevelBlocksRel);

		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndTraineeLevelIdAndRotationId,
			new Object[] {
				progdurationRotationTraineelevelBlocksRel.getTraineeLevelId(),
				progdurationRotationTraineelevelBlocksRel.
					getProgramDurationId(),
				progdurationRotationTraineelevelBlocksRel.getRotationId()
			},
			progdurationRotationTraineelevelBlocksRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the progduration rotation traineelevel blocks rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTraineelevelBlocksRels the progduration rotation traineelevel blocks rels
	 */
	@Override
	public void cacheResult(
		List<ProgdurationRotationTraineelevelBlocksRel>
			progdurationRotationTraineelevelBlocksRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (progdurationRotationTraineelevelBlocksRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					progdurationRotationTraineelevelBlocksRels) {

			if (entityCache.getResult(
					ProgdurationRotationTraineelevelBlocksRelImpl.class,
					progdurationRotationTraineelevelBlocksRel.
						getPrimaryKey()) == null) {

				cacheResult(progdurationRotationTraineelevelBlocksRel);
			}
		}
	}

	/**
	 * Clears the cache for all progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(
			ProgdurationRotationTraineelevelBlocksRelImpl.class);

		finderCache.clearCache(
			ProgdurationRotationTraineelevelBlocksRelImpl.class);
	}

	/**
	 * Clears the cache for the progduration rotation traineelevel blocks rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		entityCache.removeResult(
			ProgdurationRotationTraineelevelBlocksRelImpl.class,
			progdurationRotationTraineelevelBlocksRel);
	}

	@Override
	public void clearCache(
		List<ProgdurationRotationTraineelevelBlocksRel>
			progdurationRotationTraineelevelBlocksRels) {

		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel :
					progdurationRotationTraineelevelBlocksRels) {

			entityCache.removeResult(
				ProgdurationRotationTraineelevelBlocksRelImpl.class,
				progdurationRotationTraineelevelBlocksRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(
			ProgdurationRotationTraineelevelBlocksRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgdurationRotationTraineelevelBlocksRelImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgdurationRotationTraineelevelBlocksRelModelImpl
			progdurationRotationTraineelevelBlocksRelModelImpl) {

		Object[] args = new Object[] {
			progdurationRotationTraineelevelBlocksRelModelImpl.getUuid(),
			progdurationRotationTraineelevelBlocksRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			progdurationRotationTraineelevelBlocksRelModelImpl);

		args = new Object[] {
			progdurationRotationTraineelevelBlocksRelModelImpl.
				getTraineeLevelId(),
			progdurationRotationTraineelevelBlocksRelModelImpl.
				getProgramDurationId(),
			progdurationRotationTraineelevelBlocksRelModelImpl.getRotationId()
		};

		finderCache.putResult(
			_finderPathCountByProgramDurationIdAndTraineeLevelIdAndRotationId,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndTraineeLevelIdAndRotationId,
			args, progdurationRotationTraineelevelBlocksRelModelImpl);
	}

	/**
	 * Creates a new progduration rotation traineelevel blocks rel with the primary key. Does not add the progduration rotation traineelevel blocks rel to the database.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key for the new progduration rotation traineelevel blocks rel
	 * @return the new progduration rotation traineelevel blocks rel
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel create(
		long progdurationRotationTlBlocksRelId) {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel =
				new ProgdurationRotationTraineelevelBlocksRelImpl();

		progdurationRotationTraineelevelBlocksRel.setNew(true);
		progdurationRotationTraineelevelBlocksRel.setPrimaryKey(
			progdurationRotationTlBlocksRelId);

		String uuid = _portalUUID.generate();

		progdurationRotationTraineelevelBlocksRel.setUuid(uuid);

		progdurationRotationTraineelevelBlocksRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return progdurationRotationTraineelevelBlocksRel;
	}

	/**
	 * Removes the progduration rotation traineelevel blocks rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel remove(
			long progdurationRotationTlBlocksRelId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return remove((Serializable)progdurationRotationTlBlocksRelId);
	}

	/**
	 * Removes the progduration rotation traineelevel blocks rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel remove(
			Serializable primaryKey)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel =
					(ProgdurationRotationTraineelevelBlocksRel)session.get(
						ProgdurationRotationTraineelevelBlocksRelImpl.class,
						primaryKey);

			if (progdurationRotationTraineelevelBlocksRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(progdurationRotationTraineelevelBlocksRel);
		}
		catch (NoSuchProgdurationRotationTraineelevelBlocksRelException
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
	protected ProgdurationRotationTraineelevelBlocksRel removeImpl(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(progdurationRotationTraineelevelBlocksRel)) {
				progdurationRotationTraineelevelBlocksRel =
					(ProgdurationRotationTraineelevelBlocksRel)session.get(
						ProgdurationRotationTraineelevelBlocksRelImpl.class,
						progdurationRotationTraineelevelBlocksRel.
							getPrimaryKeyObj());
			}

			if (progdurationRotationTraineelevelBlocksRel != null) {
				session.delete(progdurationRotationTraineelevelBlocksRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (progdurationRotationTraineelevelBlocksRel != null) {
			clearCache(progdurationRotationTraineelevelBlocksRel);
		}

		return progdurationRotationTraineelevelBlocksRel;
	}

	@Override
	public ProgdurationRotationTraineelevelBlocksRel updateImpl(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		boolean isNew = progdurationRotationTraineelevelBlocksRel.isNew();

		if (!(progdurationRotationTraineelevelBlocksRel instanceof
				ProgdurationRotationTraineelevelBlocksRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					progdurationRotationTraineelevelBlocksRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					progdurationRotationTraineelevelBlocksRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in progdurationRotationTraineelevelBlocksRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgdurationRotationTraineelevelBlocksRel implementation " +
					progdurationRotationTraineelevelBlocksRel.getClass());
		}

		ProgdurationRotationTraineelevelBlocksRelModelImpl
			progdurationRotationTraineelevelBlocksRelModelImpl =
				(ProgdurationRotationTraineelevelBlocksRelModelImpl)
					progdurationRotationTraineelevelBlocksRel;

		if (Validator.isNull(
				progdurationRotationTraineelevelBlocksRel.getUuid())) {

			String uuid = _portalUUID.generate();

			progdurationRotationTraineelevelBlocksRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(progdurationRotationTraineelevelBlocksRel.getCreateDate() ==
				null)) {

			if (serviceContext == null) {
				progdurationRotationTraineelevelBlocksRel.setCreateDate(date);
			}
			else {
				progdurationRotationTraineelevelBlocksRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!progdurationRotationTraineelevelBlocksRelModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				progdurationRotationTraineelevelBlocksRel.setModifiedDate(date);
			}
			else {
				progdurationRotationTraineelevelBlocksRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(progdurationRotationTraineelevelBlocksRel);
			}
			else {
				progdurationRotationTraineelevelBlocksRel =
					(ProgdurationRotationTraineelevelBlocksRel)session.merge(
						progdurationRotationTraineelevelBlocksRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgdurationRotationTraineelevelBlocksRelImpl.class,
			progdurationRotationTraineelevelBlocksRelModelImpl, false, true);

		cacheUniqueFindersCache(
			progdurationRotationTraineelevelBlocksRelModelImpl);

		if (isNew) {
			progdurationRotationTraineelevelBlocksRel.setNew(false);
		}

		progdurationRotationTraineelevelBlocksRel.resetOriginalValues();

		return progdurationRotationTraineelevelBlocksRel;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel = fetchByPrimaryKey(
				primaryKey);

		if (progdurationRotationTraineelevelBlocksRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgdurationRotationTraineelevelBlocksRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return progdurationRotationTraineelevelBlocksRel;
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel findByPrimaryKey(
			long progdurationRotationTlBlocksRelId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return findByPrimaryKey(
			(Serializable)progdurationRotationTlBlocksRelId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel, or <code>null</code> if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTraineelevelBlocksRel fetchByPrimaryKey(
		long progdurationRotationTlBlocksRelId) {

		return fetchByPrimaryKey(
			(Serializable)progdurationRotationTlBlocksRelId);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels.
	 *
	 * @return the progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation traineelevel blocks rels
	 */
	@Override
	public List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
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

		List<ProgdurationRotationTraineelevelBlocksRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTraineelevelBlocksRel>)
					finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(
					_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL;

				sql = sql.concat(
					ProgdurationRotationTraineelevelBlocksRelModelImpl.
						ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<ProgdurationRotationTraineelevelBlocksRel>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Removes all the progduration rotation traineelevel blocks rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel : findAll()) {

			remove(progdurationRotationTraineelevelBlocksRel);
		}
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels.
	 *
	 * @return the number of progduration rotation traineelevel blocks rels
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
					_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL);

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
		return "progduration_rotation_tl_blocks_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgdurationRotationTraineelevelBlocksRelModelImpl.
			TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the progduration rotation traineelevel blocks rel persistence.
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

		_finderPathWithPaginationFindByTraineeLevelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTraineeLevelId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"trainee_level_id"}, true);

		_finderPathWithoutPaginationFindByTraineeLevelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTraineeLevelId",
			new String[] {Long.class.getName()},
			new String[] {"trainee_level_id"}, true);

		_finderPathCountByTraineeLevelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTraineeLevelId",
			new String[] {Long.class.getName()},
			new String[] {"trainee_level_id"}, false);

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

		_finderPathWithPaginationFindByProgramDurationIdAndTraineeLevelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProgramDurationIdAndTraineeLevelId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"trainee_level_id", "program_duration_id"}, true);

		_finderPathWithoutPaginationFindByProgramDurationIdAndTraineeLevelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProgramDurationIdAndTraineeLevelId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"trainee_level_id", "program_duration_id"}, true);

		_finderPathCountByProgramDurationIdAndTraineeLevelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramDurationIdAndTraineeLevelId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"trainee_level_id", "program_duration_id"}, false);

		_finderPathFetchByProgramDurationIdAndTraineeLevelIdAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgramDurationIdAndTraineeLevelIdAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"trainee_level_id", "program_duration_id", "rotation_id"
				},
				true);

		_finderPathCountByProgramDurationIdAndTraineeLevelIdAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgramDurationIdAndTraineeLevelIdAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"trainee_level_id", "program_duration_id", "rotation_id"
				},
				false);

		_finderPathWithPaginationFindByProgramDurationIdAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProgramDurationIdAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"program_duration_id", "rotation_id"}, true);

		_finderPathWithoutPaginationFindByProgramDurationIdAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProgramDurationIdAndRotationId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"program_duration_id", "rotation_id"}, true);

		_finderPathCountByProgramDurationIdAndRotationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramDurationIdAndRotationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_duration_id", "rotation_id"}, false);

		_finderPathWithPaginationFindByTraineeLevelIdAndRotationType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTraineeLevelIdAndRotationType",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"trainee_level_id", "rotation_type"}, true);

		_finderPathWithoutPaginationFindByTraineeLevelIdAndRotationType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTraineeLevelIdAndRotationType",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"trainee_level_id", "rotation_type"}, true);

		_finderPathCountByTraineeLevelIdAndRotationType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTraineeLevelIdAndRotationType",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"trainee_level_id", "rotation_type"}, false);

		_setProgdurationRotationTraineelevelBlocksRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgdurationRotationTraineelevelBlocksRelUtilPersistence(null);

		entityCache.removeCache(
			ProgdurationRotationTraineelevelBlocksRelImpl.class.getName());
	}

	private void _setProgdurationRotationTraineelevelBlocksRelUtilPersistence(
		ProgdurationRotationTraineelevelBlocksRelPersistence
			progdurationRotationTraineelevelBlocksRelPersistence) {

		try {
			Field field =
				ProgdurationRotationTraineelevelBlocksRelUtil.class.
					getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(
				null, progdurationRotationTraineelevelBlocksRelPersistence);
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
		_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL =
			"SELECT progdurationRotationTraineelevelBlocksRel FROM ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel";

	private static final String
		_SQL_SELECT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE =
			"SELECT progdurationRotationTraineelevelBlocksRel FROM ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel WHERE ";

	private static final String
		_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL =
			"SELECT COUNT(progdurationRotationTraineelevelBlocksRel) FROM ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel";

	private static final String
		_SQL_COUNT_PROGDURATIONROTATIONTRAINEELEVELBLOCKSREL_WHERE =
			"SELECT COUNT(progdurationRotationTraineelevelBlocksRel) FROM ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"progdurationRotationTraineelevelBlocksRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgdurationRotationTraineelevelBlocksRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgdurationRotationTraineelevelBlocksRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgdurationRotationTraineelevelBlocksRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "progdurationRotationTlBlocksRelId", "programDurationId",
			"rotationId", "rotationType", "traineeLevelId", "groupId",
			"companyId", "createDate", "modifiedDate", "createdBy",
			"modifiedBy", "noOfBlocks"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
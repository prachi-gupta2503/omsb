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

import gov.omsb.tms.exception.NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRelTable;
import gov.omsb.tms.model.impl.ProgdurationTraineelevelBlocksLevelTypeRelImpl;
import gov.omsb.tms.model.impl.ProgdurationTraineelevelBlocksLevelTypeRelModelImpl;
import gov.omsb.tms.service.persistence.ProgdurationTraineelevelBlocksLevelTypeRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationTraineelevelBlocksLevelTypeRelUtil;
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
 * The persistence implementation for the progduration traineelevel blocks level type rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = ProgdurationTraineelevelBlocksLevelTypeRelPersistence.class
)
public class ProgdurationTraineelevelBlocksLevelTypeRelPersistenceImpl
	extends BasePersistenceImpl<ProgdurationTraineelevelBlocksLevelTypeRel>
	implements ProgdurationTraineelevelBlocksLevelTypeRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgdurationTraineelevelBlocksLevelTypeRelUtil</code> to access the progduration traineelevel blocks level type rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgdurationTraineelevelBlocksLevelTypeRelImpl.class.getName();

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
	 * Returns all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid(
		String uuid) {

		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
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

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationTraineelevelBlocksLevelTypeRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationTraineelevelBlocksLevelTypeRel
						progdurationTraineelevelBlocksLevelTypeRel : list) {

					if (!uuid.equals(
							progdurationTraineelevelBlocksLevelTypeRel.
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
				_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
					ProgdurationTraineelevelBlocksLevelTypeRelModelImpl.
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
					(List<ProgdurationTraineelevelBlocksLevelTypeRel>)
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
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = fetchByUuid_First(
				uuid, orderByComparator);

		if (progdurationTraineelevelBlocksLevelTypeRel != null) {
			return progdurationTraineelevelBlocksLevelTypeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = fetchByUuid_Last(
				uuid, orderByComparator);

		if (progdurationTraineelevelBlocksLevelTypeRel != null) {
			return progdurationTraineelevelBlocksLevelTypeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel[] findByUuid_PrevAndNext(
			long progdurationTlBlocksLtId, String uuid,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = findByPrimaryKey(
				progdurationTlBlocksLtId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationTraineelevelBlocksLevelTypeRel[] array =
				new ProgdurationTraineelevelBlocksLevelTypeRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, progdurationTraineelevelBlocksLevelTypeRel, uuid,
				orderByComparator, true);

			array[1] = progdurationTraineelevelBlocksLevelTypeRel;

			array[2] = getByUuid_PrevAndNext(
				session, progdurationTraineelevelBlocksLevelTypeRel, uuid,
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

	protected ProgdurationTraineelevelBlocksLevelTypeRel getByUuid_PrevAndNext(
		Session session,
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel,
		String uuid,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
				ProgdurationTraineelevelBlocksLevelTypeRelModelImpl.
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
						progdurationTraineelevelBlocksLevelTypeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration traineelevel blocks level type rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(progdurationTraineelevelBlocksLevelTypeRel);
		}
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration traineelevel blocks level type rels
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
				_SQL_COUNT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
		"progdurationTraineelevelBlocksLevelTypeRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(progdurationTraineelevelBlocksLevelTypeRel.uuid IS NULL OR progdurationTraineelevelBlocksLevelTypeRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = fetchByUUID_G(
				uuid, groupId);

		if (progdurationTraineelevelBlocksLevelTypeRel == null) {
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

			throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
				sb.toString());
		}

		return progdurationTraineelevelBlocksLevelTypeRel;
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUUID_G(
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

		if (result instanceof ProgdurationTraineelevelBlocksLevelTypeRel) {
			ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel =
					(ProgdurationTraineelevelBlocksLevelTypeRel)result;

			if (!Objects.equals(
					uuid,
					progdurationTraineelevelBlocksLevelTypeRel.getUuid()) ||
				(groupId !=
					progdurationTraineelevelBlocksLevelTypeRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(
				_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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

				List<ProgdurationTraineelevelBlocksLevelTypeRel> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgdurationTraineelevelBlocksLevelTypeRel
						progdurationTraineelevelBlocksLevelTypeRel = list.get(
							0);

					result = progdurationTraineelevelBlocksLevelTypeRel;

					cacheResult(progdurationTraineelevelBlocksLevelTypeRel);
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
			return (ProgdurationTraineelevelBlocksLevelTypeRel)result;
		}
	}

	/**
	 * Removes the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration traineelevel blocks level type rel that was removed
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = findByUUID_G(
				uuid, groupId);

		return remove(progdurationTraineelevelBlocksLevelTypeRel);
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration traineelevel blocks level type rels
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
				_SQL_COUNT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
		"progdurationTraineelevelBlocksLevelTypeRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(progdurationTraineelevelBlocksLevelTypeRel.uuid IS NULL OR progdurationTraineelevelBlocksLevelTypeRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"progdurationTraineelevelBlocksLevelTypeRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
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

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationTraineelevelBlocksLevelTypeRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationTraineelevelBlocksLevelTypeRel
						progdurationTraineelevelBlocksLevelTypeRel : list) {

					if (!uuid.equals(
							progdurationTraineelevelBlocksLevelTypeRel.
								getUuid()) ||
						(companyId !=
							progdurationTraineelevelBlocksLevelTypeRel.
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
				_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
					ProgdurationTraineelevelBlocksLevelTypeRelModelImpl.
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
					(List<ProgdurationTraineelevelBlocksLevelTypeRel>)
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
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = fetchByUuid_C_First(
				uuid, companyId, orderByComparator);

		if (progdurationTraineelevelBlocksLevelTypeRel != null) {
			return progdurationTraineelevelBlocksLevelTypeRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = fetchByUuid_C_Last(
				uuid, companyId, orderByComparator);

		if (progdurationTraineelevelBlocksLevelTypeRel != null) {
			return progdurationTraineelevelBlocksLevelTypeRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel[]
			findByUuid_C_PrevAndNext(
				long progdurationTlBlocksLtId, String uuid, long companyId,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = findByPrimaryKey(
				progdurationTlBlocksLtId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationTraineelevelBlocksLevelTypeRel[] array =
				new ProgdurationTraineelevelBlocksLevelTypeRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, progdurationTraineelevelBlocksLevelTypeRel, uuid,
				companyId, orderByComparator, true);

			array[1] = progdurationTraineelevelBlocksLevelTypeRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, progdurationTraineelevelBlocksLevelTypeRel, uuid,
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

	protected ProgdurationTraineelevelBlocksLevelTypeRel
		getByUuid_C_PrevAndNext(
			Session session,
			ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel,
			String uuid, long companyId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
				ProgdurationTraineelevelBlocksLevelTypeRelModelImpl.
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
						progdurationTraineelevelBlocksLevelTypeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationTraineelevelBlocksLevelTypeRel);
		}
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration traineelevel blocks level type rels
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
				_SQL_COUNT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
		"progdurationTraineelevelBlocksLevelTypeRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(progdurationTraineelevelBlocksLevelTypeRel.uuid IS NULL OR progdurationTraineelevelBlocksLevelTypeRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"progdurationTraineelevelBlocksLevelTypeRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
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

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationTraineelevelBlocksLevelTypeRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationTraineelevelBlocksLevelTypeRel
						progdurationTraineelevelBlocksLevelTypeRel : list) {

					if (programDurationId !=
							progdurationTraineelevelBlocksLevelTypeRel.
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
				_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationTraineelevelBlocksLevelTypeRelModelImpl.
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
					(List<ProgdurationTraineelevelBlocksLevelTypeRel>)
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
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationId_First(
				long programDurationId,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel =
				fetchByProgramDurationId_First(
					programDurationId, orderByComparator);

		if (progdurationTraineelevelBlocksLevelTypeRel != null) {
			return progdurationTraineelevelBlocksLevelTypeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator) {

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list =
			findByProgramDurationId(programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationId_Last(
				long programDurationId,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel =
				fetchByProgramDurationId_Last(
					programDurationId, orderByComparator);

		if (progdurationTraineelevelBlocksLevelTypeRel != null) {
			return progdurationTraineelevelBlocksLevelTypeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list =
			findByProgramDurationId(
				programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationTlBlocksLtId, long programDurationId,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = findByPrimaryKey(
				progdurationTlBlocksLtId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationTraineelevelBlocksLevelTypeRel[] array =
				new ProgdurationTraineelevelBlocksLevelTypeRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, progdurationTraineelevelBlocksLevelTypeRel,
				programDurationId, orderByComparator, true);

			array[1] = progdurationTraineelevelBlocksLevelTypeRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, progdurationTraineelevelBlocksLevelTypeRel,
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

	protected ProgdurationTraineelevelBlocksLevelTypeRel
		getByProgramDurationId_PrevAndNext(
			Session session,
			ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel,
			long programDurationId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
				ProgdurationTraineelevelBlocksLevelTypeRelModelImpl.
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
						progdurationTraineelevelBlocksLevelTypeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration traineelevel blocks level type rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel :
					findByProgramDurationId(
						programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationTraineelevelBlocksLevelTypeRel);
		}
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(
				_SQL_COUNT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

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
			"progdurationTraineelevelBlocksLevelTypeRel.programDurationId = ?";

	private FinderPath _finderPathFetchByProgramDurationIdAndTraineeLevelId;
	private FinderPath _finderPathCountByProgramDurationIdAndTraineeLevelId;

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationIdAndTraineeLevelId(
				long programDurationId, long traineeLevelId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel =
				fetchByProgramDurationIdAndTraineeLevelId(
					programDurationId, traineeLevelId);

		if (progdurationTraineelevelBlocksLevelTypeRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programDurationId=");
			sb.append(programDurationId);

			sb.append(", traineeLevelId=");
			sb.append(traineeLevelId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
				sb.toString());
		}

		return progdurationTraineelevelBlocksLevelTypeRel;
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId) {

		return fetchByProgramDurationIdAndTraineeLevelId(
			programDurationId, traineeLevelId, true);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programDurationId, traineeLevelId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramDurationIdAndTraineeLevelId,
				finderArgs, this);
		}

		if (result instanceof ProgdurationTraineelevelBlocksLevelTypeRel) {
			ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel =
					(ProgdurationTraineelevelBlocksLevelTypeRel)result;

			if ((programDurationId !=
					progdurationTraineelevelBlocksLevelTypeRel.
						getProgramDurationId()) ||
				(traineeLevelId !=
					progdurationTraineelevelBlocksLevelTypeRel.
						getTraineeLevelId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(
				_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_TRAINEELEVELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(traineeLevelId);

				List<ProgdurationTraineelevelBlocksLevelTypeRel> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramDurationIdAndTraineeLevelId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programDurationId, traineeLevelId
								};
							}

							_log.warn(
								"ProgdurationTraineelevelBlocksLevelTypeRelPersistenceImpl.fetchByProgramDurationIdAndTraineeLevelId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgdurationTraineelevelBlocksLevelTypeRel
						progdurationTraineelevelBlocksLevelTypeRel = list.get(
							0);

					result = progdurationTraineelevelBlocksLevelTypeRel;

					cacheResult(progdurationTraineelevelBlocksLevelTypeRel);
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
			return (ProgdurationTraineelevelBlocksLevelTypeRel)result;
		}
	}

	/**
	 * Removes the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the progduration traineelevel blocks level type rel that was removed
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
			removeByProgramDurationIdAndTraineeLevelId(
				long programDurationId, long traineeLevelId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel =
				findByProgramDurationIdAndTraineeLevelId(
					programDurationId, traineeLevelId);

		return remove(progdurationTraineelevelBlocksLevelTypeRel);
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where programDurationId = &#63; and traineeLevelId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	@Override
	public int countByProgramDurationIdAndTraineeLevelId(
		long programDurationId, long traineeLevelId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndTraineeLevelId;

		Object[] finderArgs = new Object[] {programDurationId, traineeLevelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(
				_SQL_COUNT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_TRAINEELEVELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

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

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_PROGRAMDURATIONID_2 =
			"progdurationTraineelevelBlocksLevelTypeRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDTRAINEELEVELID_TRAINEELEVELID_2 =
			"progdurationTraineelevelBlocksLevelTypeRel.traineeLevelId = ?";

	public ProgdurationTraineelevelBlocksLevelTypeRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"progdurationTlBlocksLtId", "progduration_tl_blocks_lt_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("levelTypeId", "level_type_id");
		dbColumnNames.put("traineeLevelId", "trainee_level_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("noOfBlocks", "no_of_blocks");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgdurationTraineelevelBlocksLevelTypeRel.class);

		setModelImplClass(ProgdurationTraineelevelBlocksLevelTypeRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProgdurationTraineelevelBlocksLevelTypeRelTable.INSTANCE);
	}

	/**
	 * Caches the progduration traineelevel blocks level type rel in the entity cache if it is enabled.
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRel the progduration traineelevel blocks level type rel
	 */
	@Override
	public void cacheResult(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		entityCache.putResult(
			ProgdurationTraineelevelBlocksLevelTypeRelImpl.class,
			progdurationTraineelevelBlocksLevelTypeRel.getPrimaryKey(),
			progdurationTraineelevelBlocksLevelTypeRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				progdurationTraineelevelBlocksLevelTypeRel.getUuid(),
				progdurationTraineelevelBlocksLevelTypeRel.getGroupId()
			},
			progdurationTraineelevelBlocksLevelTypeRel);

		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndTraineeLevelId,
			new Object[] {
				progdurationTraineelevelBlocksLevelTypeRel.
					getProgramDurationId(),
				progdurationTraineelevelBlocksLevelTypeRel.getTraineeLevelId()
			},
			progdurationTraineelevelBlocksLevelTypeRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the progduration traineelevel blocks level type rels in the entity cache if it is enabled.
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRels the progduration traineelevel blocks level type rels
	 */
	@Override
	public void cacheResult(
		List<ProgdurationTraineelevelBlocksLevelTypeRel>
			progdurationTraineelevelBlocksLevelTypeRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (progdurationTraineelevelBlocksLevelTypeRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel :
					progdurationTraineelevelBlocksLevelTypeRels) {

			if (entityCache.getResult(
					ProgdurationTraineelevelBlocksLevelTypeRelImpl.class,
					progdurationTraineelevelBlocksLevelTypeRel.
						getPrimaryKey()) == null) {

				cacheResult(progdurationTraineelevelBlocksLevelTypeRel);
			}
		}
	}

	/**
	 * Clears the cache for all progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(
			ProgdurationTraineelevelBlocksLevelTypeRelImpl.class);

		finderCache.clearCache(
			ProgdurationTraineelevelBlocksLevelTypeRelImpl.class);
	}

	/**
	 * Clears the cache for the progduration traineelevel blocks level type rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		entityCache.removeResult(
			ProgdurationTraineelevelBlocksLevelTypeRelImpl.class,
			progdurationTraineelevelBlocksLevelTypeRel);
	}

	@Override
	public void clearCache(
		List<ProgdurationTraineelevelBlocksLevelTypeRel>
			progdurationTraineelevelBlocksLevelTypeRels) {

		for (ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel :
					progdurationTraineelevelBlocksLevelTypeRels) {

			entityCache.removeResult(
				ProgdurationTraineelevelBlocksLevelTypeRelImpl.class,
				progdurationTraineelevelBlocksLevelTypeRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(
			ProgdurationTraineelevelBlocksLevelTypeRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgdurationTraineelevelBlocksLevelTypeRelImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgdurationTraineelevelBlocksLevelTypeRelModelImpl
			progdurationTraineelevelBlocksLevelTypeRelModelImpl) {

		Object[] args = new Object[] {
			progdurationTraineelevelBlocksLevelTypeRelModelImpl.getUuid(),
			progdurationTraineelevelBlocksLevelTypeRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			progdurationTraineelevelBlocksLevelTypeRelModelImpl);

		args = new Object[] {
			progdurationTraineelevelBlocksLevelTypeRelModelImpl.
				getProgramDurationId(),
			progdurationTraineelevelBlocksLevelTypeRelModelImpl.
				getTraineeLevelId()
		};

		finderCache.putResult(
			_finderPathCountByProgramDurationIdAndTraineeLevelId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndTraineeLevelId, args,
			progdurationTraineelevelBlocksLevelTypeRelModelImpl);
	}

	/**
	 * Creates a new progduration traineelevel blocks level type rel with the primary key. Does not add the progduration traineelevel blocks level type rel to the database.
	 *
	 * @param progdurationTlBlocksLtId the primary key for the new progduration traineelevel blocks level type rel
	 * @return the new progduration traineelevel blocks level type rel
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel create(
		long progdurationTlBlocksLtId) {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel =
				new ProgdurationTraineelevelBlocksLevelTypeRelImpl();

		progdurationTraineelevelBlocksLevelTypeRel.setNew(true);
		progdurationTraineelevelBlocksLevelTypeRel.setPrimaryKey(
			progdurationTlBlocksLtId);

		String uuid = _portalUUID.generate();

		progdurationTraineelevelBlocksLevelTypeRel.setUuid(uuid);

		progdurationTraineelevelBlocksLevelTypeRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return progdurationTraineelevelBlocksLevelTypeRel;
	}

	/**
	 * Removes the progduration traineelevel blocks level type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel that was removed
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel remove(
			long progdurationTlBlocksLtId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return remove((Serializable)progdurationTlBlocksLtId);
	}

	/**
	 * Removes the progduration traineelevel blocks level type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel that was removed
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel remove(
			Serializable primaryKey)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		Session session = null;

		try {
			session = openSession();

			ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel =
					(ProgdurationTraineelevelBlocksLevelTypeRel)session.get(
						ProgdurationTraineelevelBlocksLevelTypeRelImpl.class,
						primaryKey);

			if (progdurationTraineelevelBlocksLevelTypeRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(progdurationTraineelevelBlocksLevelTypeRel);
		}
		catch (NoSuchProgdurationTraineelevelBlocksLevelTypeRelException
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
	protected ProgdurationTraineelevelBlocksLevelTypeRel removeImpl(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(progdurationTraineelevelBlocksLevelTypeRel)) {
				progdurationTraineelevelBlocksLevelTypeRel =
					(ProgdurationTraineelevelBlocksLevelTypeRel)session.get(
						ProgdurationTraineelevelBlocksLevelTypeRelImpl.class,
						progdurationTraineelevelBlocksLevelTypeRel.
							getPrimaryKeyObj());
			}

			if (progdurationTraineelevelBlocksLevelTypeRel != null) {
				session.delete(progdurationTraineelevelBlocksLevelTypeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (progdurationTraineelevelBlocksLevelTypeRel != null) {
			clearCache(progdurationTraineelevelBlocksLevelTypeRel);
		}

		return progdurationTraineelevelBlocksLevelTypeRel;
	}

	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel updateImpl(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		boolean isNew = progdurationTraineelevelBlocksLevelTypeRel.isNew();

		if (!(progdurationTraineelevelBlocksLevelTypeRel instanceof
				ProgdurationTraineelevelBlocksLevelTypeRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					progdurationTraineelevelBlocksLevelTypeRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					progdurationTraineelevelBlocksLevelTypeRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in progdurationTraineelevelBlocksLevelTypeRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgdurationTraineelevelBlocksLevelTypeRel implementation " +
					progdurationTraineelevelBlocksLevelTypeRel.getClass());
		}

		ProgdurationTraineelevelBlocksLevelTypeRelModelImpl
			progdurationTraineelevelBlocksLevelTypeRelModelImpl =
				(ProgdurationTraineelevelBlocksLevelTypeRelModelImpl)
					progdurationTraineelevelBlocksLevelTypeRel;

		if (Validator.isNull(
				progdurationTraineelevelBlocksLevelTypeRel.getUuid())) {

			String uuid = _portalUUID.generate();

			progdurationTraineelevelBlocksLevelTypeRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(progdurationTraineelevelBlocksLevelTypeRel.getCreateDate() ==
				null)) {

			if (serviceContext == null) {
				progdurationTraineelevelBlocksLevelTypeRel.setCreateDate(date);
			}
			else {
				progdurationTraineelevelBlocksLevelTypeRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!progdurationTraineelevelBlocksLevelTypeRelModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				progdurationTraineelevelBlocksLevelTypeRel.setModifiedDate(
					date);
			}
			else {
				progdurationTraineelevelBlocksLevelTypeRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(progdurationTraineelevelBlocksLevelTypeRel);
			}
			else {
				progdurationTraineelevelBlocksLevelTypeRel =
					(ProgdurationTraineelevelBlocksLevelTypeRel)session.merge(
						progdurationTraineelevelBlocksLevelTypeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgdurationTraineelevelBlocksLevelTypeRelImpl.class,
			progdurationTraineelevelBlocksLevelTypeRelModelImpl, false, true);

		cacheUniqueFindersCache(
			progdurationTraineelevelBlocksLevelTypeRelModelImpl);

		if (isNew) {
			progdurationTraineelevelBlocksLevelTypeRel.setNew(false);
		}

		progdurationTraineelevelBlocksLevelTypeRel.resetOriginalValues();

		return progdurationTraineelevelBlocksLevelTypeRel;
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel = fetchByPrimaryKey(
				primaryKey);

		if (progdurationTraineelevelBlocksLevelTypeRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgdurationTraineelevelBlocksLevelTypeRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return progdurationTraineelevelBlocksLevelTypeRel;
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel with the primary key or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel findByPrimaryKey(
			long progdurationTlBlocksLtId)
		throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return findByPrimaryKey((Serializable)progdurationTlBlocksLtId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel, or <code>null</code> if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel fetchByPrimaryKey(
		long progdurationTlBlocksLtId) {

		return fetchByPrimaryKey((Serializable)progdurationTlBlocksLtId);
	}

	/**
	 * Returns all the progduration traineelevel blocks level type rels.
	 *
	 * @return the progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration traineelevel blocks level type rels
	 */
	@Override
	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
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

		List<ProgdurationTraineelevelBlocksLevelTypeRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationTraineelevelBlocksLevelTypeRel>)
					finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(
					_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL;

				sql = sql.concat(
					ProgdurationTraineelevelBlocksLevelTypeRelModelImpl.
						ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<ProgdurationTraineelevelBlocksLevelTypeRel>)
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
	 * Removes all the progduration traineelevel blocks level type rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgdurationTraineelevelBlocksLevelTypeRel
				progdurationTraineelevelBlocksLevelTypeRel : findAll()) {

			remove(progdurationTraineelevelBlocksLevelTypeRel);
		}
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels.
	 *
	 * @return the number of progduration traineelevel blocks level type rels
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
					_SQL_COUNT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL);

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
		return "progduration_tl_blocks_lt_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgdurationTraineelevelBlocksLevelTypeRelModelImpl.
			TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the progduration traineelevel blocks level type rel persistence.
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

		_finderPathFetchByProgramDurationIdAndTraineeLevelId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY,
			"fetchByProgramDurationIdAndTraineeLevelId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_duration_id", "trainee_level_id"}, true);

		_finderPathCountByProgramDurationIdAndTraineeLevelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramDurationIdAndTraineeLevelId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_duration_id", "trainee_level_id"}, false);

		_setProgdurationTraineelevelBlocksLevelTypeRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgdurationTraineelevelBlocksLevelTypeRelUtilPersistence(null);

		entityCache.removeCache(
			ProgdurationTraineelevelBlocksLevelTypeRelImpl.class.getName());
	}

	private void _setProgdurationTraineelevelBlocksLevelTypeRelUtilPersistence(
		ProgdurationTraineelevelBlocksLevelTypeRelPersistence
			progdurationTraineelevelBlocksLevelTypeRelPersistence) {

		try {
			Field field =
				ProgdurationTraineelevelBlocksLevelTypeRelUtil.class.
					getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(
				null, progdurationTraineelevelBlocksLevelTypeRelPersistence);
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
		_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL =
			"SELECT progdurationTraineelevelBlocksLevelTypeRel FROM ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel";

	private static final String
		_SQL_SELECT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE =
			"SELECT progdurationTraineelevelBlocksLevelTypeRel FROM ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel WHERE ";

	private static final String
		_SQL_COUNT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL =
			"SELECT COUNT(progdurationTraineelevelBlocksLevelTypeRel) FROM ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel";

	private static final String
		_SQL_COUNT_PROGDURATIONTRAINEELEVELBLOCKSLEVELTYPEREL_WHERE =
			"SELECT COUNT(progdurationTraineelevelBlocksLevelTypeRel) FROM ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"progdurationTraineelevelBlocksLevelTypeRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgdurationTraineelevelBlocksLevelTypeRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgdurationTraineelevelBlocksLevelTypeRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgdurationTraineelevelBlocksLevelTypeRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "progdurationTlBlocksLtId", "programDurationId",
			"levelTypeId", "traineeLevelId", "groupId", "companyId",
			"createDate", "modifiedDate", "noOfBlocks"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
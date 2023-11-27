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

import gov.omsb.tms.exception.NoSuchProgdurationRotationTlPgProcedurePtRelException;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRelTable;
import gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelImpl;
import gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl;
import gov.omsb.tms.service.persistence.ProgdurationRotationTlPgProcedurePtRelPersistence;
import gov.omsb.tms.service.persistence.ProgdurationRotationTlPgProcedurePtRelUtil;
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
 * The persistence implementation for the progduration rotation tl pg procedure pt rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgdurationRotationTlPgProcedurePtRelPersistence.class)
public class ProgdurationRotationTlPgProcedurePtRelPersistenceImpl
	extends BasePersistenceImpl<ProgdurationRotationTlPgProcedurePtRel>
	implements ProgdurationRotationTlPgProcedurePtRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgdurationRotationTlPgProcedurePtRelUtil</code> to access the progduration rotation tl pg procedure pt rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgdurationRotationTlPgProcedurePtRelImpl.class.getName();

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
	 * Returns all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid) {

		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
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

		List<ProgdurationRotationTlPgProcedurePtRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTlPgProcedurePtRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTlPgProcedurePtRel
						progdurationRotationTlPgProcedurePtRel : list) {

					if (!uuid.equals(
							progdurationRotationTlPgProcedurePtRel.getUuid())) {

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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
					ProgdurationRotationTlPgProcedurePtRelModelImpl.
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
					(List<ProgdurationRotationTlPgProcedurePtRel>)
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
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = fetchByUuid_First(
				uuid, orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		List<ProgdurationRotationTlPgProcedurePtRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = fetchByUuid_Last(
				uuid, orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel[] findByUuid_PrevAndNext(
			long progdurationRotationTlPgProcedurePtRelId, String uuid,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = findByPrimaryKey(
				progdurationRotationTlPgProcedurePtRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTlPgProcedurePtRel[] array =
				new ProgdurationRotationTlPgProcedurePtRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, progdurationRotationTlPgProcedurePtRel, uuid,
				orderByComparator, true);

			array[1] = progdurationRotationTlPgProcedurePtRel;

			array[2] = getByUuid_PrevAndNext(
				session, progdurationRotationTlPgProcedurePtRel, uuid,
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

	protected ProgdurationRotationTlPgProcedurePtRel getByUuid_PrevAndNext(
		Session session,
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel,
		String uuid,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
				ProgdurationRotationTlPgProcedurePtRelModelImpl.ORDER_BY_JPQL);
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
						progdurationRotationTlPgProcedurePtRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(progdurationRotationTlPgProcedurePtRel);
		}
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
		"progdurationRotationTlPgProcedurePtRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(progdurationRotationTlPgProcedurePtRel.uuid IS NULL OR progdurationRotationTlPgProcedurePtRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = fetchByUUID_G(
				uuid, groupId);

		if (progdurationRotationTlPgProcedurePtRel == null) {
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

			throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
				sb.toString());
		}

		return progdurationRotationTlPgProcedurePtRel;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByUUID_G(
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

		if (result instanceof ProgdurationRotationTlPgProcedurePtRel) {
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel =
					(ProgdurationRotationTlPgProcedurePtRel)result;

			if (!Objects.equals(
					uuid, progdurationRotationTlPgProcedurePtRel.getUuid()) ||
				(groupId !=
					progdurationRotationTlPgProcedurePtRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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

				List<ProgdurationRotationTlPgProcedurePtRel> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgdurationRotationTlPgProcedurePtRel
						progdurationRotationTlPgProcedurePtRel = list.get(0);

					result = progdurationRotationTlPgProcedurePtRel;

					cacheResult(progdurationRotationTlPgProcedurePtRel);
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
			return (ProgdurationRotationTlPgProcedurePtRel)result;
		}
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = findByUUID_G(
				uuid, groupId);

		return remove(progdurationRotationTlPgProcedurePtRel);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
		"progdurationRotationTlPgProcedurePtRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(progdurationRotationTlPgProcedurePtRel.uuid IS NULL OR progdurationRotationTlPgProcedurePtRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"progdurationRotationTlPgProcedurePtRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
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

		List<ProgdurationRotationTlPgProcedurePtRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTlPgProcedurePtRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTlPgProcedurePtRel
						progdurationRotationTlPgProcedurePtRel : list) {

					if (!uuid.equals(
							progdurationRotationTlPgProcedurePtRel.getUuid()) ||
						(companyId !=
							progdurationRotationTlPgProcedurePtRel.
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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
					ProgdurationRotationTlPgProcedurePtRelModelImpl.
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
					(List<ProgdurationRotationTlPgProcedurePtRel>)
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
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = fetchByUuid_C_First(
				uuid, companyId, orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		List<ProgdurationRotationTlPgProcedurePtRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = fetchByUuid_C_Last(
				uuid, companyId, orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel[] findByUuid_C_PrevAndNext(
			long progdurationRotationTlPgProcedurePtRelId, String uuid,
			long companyId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		uuid = Objects.toString(uuid, "");

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = findByPrimaryKey(
				progdurationRotationTlPgProcedurePtRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTlPgProcedurePtRel[] array =
				new ProgdurationRotationTlPgProcedurePtRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, progdurationRotationTlPgProcedurePtRel, uuid,
				companyId, orderByComparator, true);

			array[1] = progdurationRotationTlPgProcedurePtRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, progdurationRotationTlPgProcedurePtRel, uuid,
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

	protected ProgdurationRotationTlPgProcedurePtRel getByUuid_C_PrevAndNext(
		Session session,
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel,
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
				ProgdurationRotationTlPgProcedurePtRelModelImpl.ORDER_BY_JPQL);
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
						progdurationRotationTlPgProcedurePtRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTlPgProcedurePtRel);
		}
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
		"progdurationRotationTlPgProcedurePtRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(progdurationRotationTlPgProcedurePtRel.uuid IS NULL OR progdurationRotationTlPgProcedurePtRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"progdurationRotationTlPgProcedurePtRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProcedureGroupId;
	private FinderPath _finderPathWithoutPaginationFindByProcedureGroupId;
	private FinderPath _finderPathCountByProcedureGroupId;

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProcedureGroupId(
		long procedureGroupId) {

		return findByProcedureGroupId(
			procedureGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProcedureGroupId(
		long procedureGroupId, int start, int end) {

		return findByProcedureGroupId(procedureGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProcedureGroupId(
		long procedureGroupId, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return findByProcedureGroupId(
			procedureGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProcedureGroupId(
		long procedureGroupId, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProcedureGroupId;
				finderArgs = new Object[] {procedureGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProcedureGroupId;
			finderArgs = new Object[] {
				procedureGroupId, start, end, orderByComparator
			};
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTlPgProcedurePtRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTlPgProcedurePtRel
						progdurationRotationTlPgProcedurePtRel : list) {

					if (procedureGroupId !=
							progdurationRotationTlPgProcedurePtRel.
								getProcedureGroupId()) {

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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDUREGROUPID_PROCEDUREGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTlPgProcedurePtRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureGroupId);

				list =
					(List<ProgdurationRotationTlPgProcedurePtRel>)
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
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByProcedureGroupId_First(
			long procedureGroupId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				fetchByProcedureGroupId_First(
					procedureGroupId, orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupId=");
		sb.append(procedureGroupId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByProcedureGroupId_First(
		long procedureGroupId,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		List<ProgdurationRotationTlPgProcedurePtRel> list =
			findByProcedureGroupId(procedureGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByProcedureGroupId_Last(
			long procedureGroupId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				fetchByProcedureGroupId_Last(
					procedureGroupId, orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("procedureGroupId=");
		sb.append(procedureGroupId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByProcedureGroupId_Last(
		long procedureGroupId,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		int count = countByProcedureGroupId(procedureGroupId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list =
			findByProcedureGroupId(
				procedureGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel[]
			findByProcedureGroupId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long procedureGroupId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = findByPrimaryKey(
				progdurationRotationTlPgProcedurePtRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTlPgProcedurePtRel[] array =
				new ProgdurationRotationTlPgProcedurePtRelImpl[3];

			array[0] = getByProcedureGroupId_PrevAndNext(
				session, progdurationRotationTlPgProcedurePtRel,
				procedureGroupId, orderByComparator, true);

			array[1] = progdurationRotationTlPgProcedurePtRel;

			array[2] = getByProcedureGroupId_PrevAndNext(
				session, progdurationRotationTlPgProcedurePtRel,
				procedureGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgdurationRotationTlPgProcedurePtRel
		getByProcedureGroupId_PrevAndNext(
			Session session,
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel,
			long procedureGroupId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

		sb.append(_FINDER_COLUMN_PROCEDUREGROUPID_PROCEDUREGROUPID_2);

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
				ProgdurationRotationTlPgProcedurePtRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(procedureGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTlPgProcedurePtRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63; from the database.
	 *
	 * @param procedureGroupId the procedure group ID
	 */
	@Override
	public void removeByProcedureGroupId(long procedureGroupId) {
		for (ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel :
					findByProcedureGroupId(
						procedureGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTlPgProcedurePtRel);
		}
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int countByProcedureGroupId(long procedureGroupId) {
		FinderPath finderPath = _finderPathCountByProcedureGroupId;

		Object[] finderArgs = new Object[] {procedureGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDUREGROUPID_PROCEDUREGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureGroupId);

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
		_FINDER_COLUMN_PROCEDUREGROUPID_PROCEDUREGROUPID_2 =
			"progdurationRotationTlPgProcedurePtRel.procedureGroupId = ?";

	private FinderPath _finderPathFetchByProcedureId;
	private FinderPath _finderPathCountByProcedureId;

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByProcedureId(
			long procedureId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = fetchByProcedureId(
				procedureId);

		if (progdurationRotationTlPgProcedurePtRel == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("procedureId=");
			sb.append(procedureId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
				sb.toString());
		}

		return progdurationRotationTlPgProcedurePtRel;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByProcedureId(
		long procedureId) {

		return fetchByProcedureId(procedureId, true);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param procedureId the procedure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByProcedureId(
		long procedureId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {procedureId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProcedureId, finderArgs, this);
		}

		if (result instanceof ProgdurationRotationTlPgProcedurePtRel) {
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel =
					(ProgdurationRotationTlPgProcedurePtRel)result;

			if (procedureId !=
					progdurationRotationTlPgProcedurePtRel.getProcedureId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDUREID_PROCEDUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureId);

				List<ProgdurationRotationTlPgProcedurePtRel> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProcedureId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {procedureId};
							}

							_log.warn(
								"ProgdurationRotationTlPgProcedurePtRelPersistenceImpl.fetchByProcedureId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgdurationRotationTlPgProcedurePtRel
						progdurationRotationTlPgProcedurePtRel = list.get(0);

					result = progdurationRotationTlPgProcedurePtRel;

					cacheResult(progdurationRotationTlPgProcedurePtRel);
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
			return (ProgdurationRotationTlPgProcedurePtRel)result;
		}
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where procedureId = &#63; from the database.
	 *
	 * @param procedureId the procedure ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel removeByProcedureId(
			long procedureId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = findByProcedureId(
				procedureId);

		return remove(progdurationRotationTlPgProcedurePtRel);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where procedureId = &#63;.
	 *
	 * @param procedureId the procedure ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int countByProcedureId(long procedureId) {
		FinderPath finderPath = _finderPathCountByProcedureId;

		Object[] finderArgs = new Object[] {procedureId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDUREID_PROCEDUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(procedureId);

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

	private static final String _FINDER_COLUMN_PROCEDUREID_PROCEDUREID_2 =
		"progdurationRotationTlPgProcedurePtRel.procedureId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
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

		List<ProgdurationRotationTlPgProcedurePtRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTlPgProcedurePtRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTlPgProcedurePtRel
						progdurationRotationTlPgProcedurePtRel : list) {

					if (programDurationId !=
							progdurationRotationTlPgProcedurePtRel.
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

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTlPgProcedurePtRelModelImpl.
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
					(List<ProgdurationRotationTlPgProcedurePtRel>)
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
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				fetchByProgramDurationId_First(
					programDurationId, orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		List<ProgdurationRotationTlPgProcedurePtRel> list =
			findByProgramDurationId(programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				fetchByProgramDurationId_Last(
					programDurationId, orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list =
			findByProgramDurationId(
				programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long programDurationId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = findByPrimaryKey(
				progdurationRotationTlPgProcedurePtRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTlPgProcedurePtRel[] array =
				new ProgdurationRotationTlPgProcedurePtRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, progdurationRotationTlPgProcedurePtRel,
				programDurationId, orderByComparator, true);

			array[1] = progdurationRotationTlPgProcedurePtRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, progdurationRotationTlPgProcedurePtRel,
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

	protected ProgdurationRotationTlPgProcedurePtRel
		getByProgramDurationId_PrevAndNext(
			Session session,
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel,
			long programDurationId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
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

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
				ProgdurationRotationTlPgProcedurePtRelModelImpl.ORDER_BY_JPQL);
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
						progdurationRotationTlPgProcedurePtRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel :
					findByProgramDurationId(
						programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(progdurationRotationTlPgProcedurePtRel);
		}
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

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
			"progdurationRotationTlPgProcedurePtRel.programDurationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByProgramDurationIdAndProcedureGroupIdAndProcedureId;
	private FinderPath
		_finderPathWithoutPaginationFindByProgramDurationIdAndProcedureGroupIdAndProcedureId;
	private FinderPath
		_finderPathCountByProgramDurationIdAndProcedureGroupIdAndProcedureId;

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId) {

		return findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			programDurationId, procedureGroupId, procedureId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end) {

		return findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			programDurationId, procedureGroupId, procedureId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			programDurationId, procedureGroupId, procedureId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgramDurationIdAndProcedureGroupIdAndProcedureId;
				finderArgs = new Object[] {
					programDurationId, procedureGroupId, procedureId
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByProgramDurationIdAndProcedureGroupIdAndProcedureId;
			finderArgs = new Object[] {
				programDurationId, procedureGroupId, procedureId, start, end,
				orderByComparator
			};
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTlPgProcedurePtRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgdurationRotationTlPgProcedurePtRel
						progdurationRotationTlPgProcedurePtRel : list) {

					if ((programDurationId !=
							progdurationRotationTlPgProcedurePtRel.
								getProgramDurationId()) ||
						(procedureGroupId !=
							progdurationRotationTlPgProcedurePtRel.
								getProcedureGroupId()) ||
						(procedureId !=
							progdurationRotationTlPgProcedurePtRel.
								getProcedureId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROCEDUREGROUPID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROCEDUREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					ProgdurationRotationTlPgProcedurePtRelModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(procedureGroupId);

				queryPos.add(procedureId);

				list =
					(List<ProgdurationRotationTlPgProcedurePtRel>)
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
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
				long programDurationId, long procedureGroupId, long procedureId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
					programDurationId, procedureGroupId, procedureId,
					orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append(", procedureGroupId=");
		sb.append(procedureGroupId);

		sb.append(", procedureId=");
		sb.append(procedureId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
			long programDurationId, long procedureGroupId, long procedureId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		List<ProgdurationRotationTlPgProcedurePtRel> list =
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
				long programDurationId, long procedureGroupId, long procedureId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
					programDurationId, procedureGroupId, procedureId,
					orderByComparator);

		if (progdurationRotationTlPgProcedurePtRel != null) {
			return progdurationRotationTlPgProcedurePtRel;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append(", procedureGroupId=");
		sb.append(procedureGroupId);

		sb.append(", procedureId=");
		sb.append(procedureId);

		sb.append("}");

		throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
			sb.toString());
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
			long programDurationId, long procedureGroupId, long procedureId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		int count = countByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			programDurationId, procedureGroupId, procedureId);

		if (count == 0) {
			return null;
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list =
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel[]
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long programDurationId, long procedureGroupId, long procedureId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = findByPrimaryKey(
				progdurationRotationTlPgProcedurePtRelId);

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTlPgProcedurePtRel[] array =
				new ProgdurationRotationTlPgProcedurePtRelImpl[3];

			array[0] =
				getByProgramDurationIdAndProcedureGroupIdAndProcedureId_PrevAndNext(
					session, progdurationRotationTlPgProcedurePtRel,
					programDurationId, procedureGroupId, procedureId,
					orderByComparator, true);

			array[1] = progdurationRotationTlPgProcedurePtRel;

			array[2] =
				getByProgramDurationIdAndProcedureGroupIdAndProcedureId_PrevAndNext(
					session, progdurationRotationTlPgProcedurePtRel,
					programDurationId, procedureGroupId, procedureId,
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

	protected ProgdurationRotationTlPgProcedurePtRel
		getByProgramDurationIdAndProcedureGroupIdAndProcedureId_PrevAndNext(
			Session session,
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel,
			long programDurationId, long procedureGroupId, long procedureId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

		sb.append(
			_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROGRAMDURATIONID_2);

		sb.append(
			_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROCEDUREGROUPID_2);

		sb.append(
			_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROCEDUREID_2);

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
				ProgdurationRotationTlPgProcedurePtRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programDurationId);

		queryPos.add(procedureGroupId);

		queryPos.add(procedureId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						progdurationRotationTlPgProcedurePtRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgdurationRotationTlPgProcedurePtRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 */
	@Override
	public void removeByProgramDurationIdAndProcedureGroupIdAndProcedureId(
		long programDurationId, long procedureGroupId, long procedureId) {

		for (ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel :
					findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
						programDurationId, procedureGroupId, procedureId,
						QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(progdurationRotationTlPgProcedurePtRel);
		}
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int countByProgramDurationIdAndProcedureGroupIdAndProcedureId(
		long programDurationId, long procedureGroupId, long procedureId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndProcedureGroupIdAndProcedureId;

		Object[] finderArgs = new Object[] {
			programDurationId, procedureGroupId, procedureId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROCEDUREGROUPID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROCEDUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(procedureGroupId);

				queryPos.add(procedureId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROGRAMDURATIONID_2 =
			"progdurationRotationTlPgProcedurePtRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROCEDUREGROUPID_2 =
			"progdurationRotationTlPgProcedurePtRel.procedureGroupId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREID_PROCEDUREID_2 =
			"progdurationRotationTlPgProcedurePtRel.procedureId = ?";

	private FinderPath
		_finderPathFetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId;
	private FinderPath
		_finderPathCountByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId;

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				long programDurationId, long procedureGroupId, long procedureId,
				long rotationId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
					programDurationId, procedureGroupId, procedureId,
					rotationId);

		if (progdurationRotationTlPgProcedurePtRel == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programDurationId=");
			sb.append(programDurationId);

			sb.append(", procedureGroupId=");
			sb.append(procedureGroupId);

			sb.append(", procedureId=");
			sb.append(procedureId);

			sb.append(", rotationId=");
			sb.append(rotationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
				sb.toString());
		}

		return progdurationRotationTlPgProcedurePtRel;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId) {

		return fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			programDurationId, procedureGroupId, procedureId, rotationId, true);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				programDurationId, procedureGroupId, procedureId, rotationId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId,
				finderArgs, this);
		}

		if (result instanceof ProgdurationRotationTlPgProcedurePtRel) {
			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel =
					(ProgdurationRotationTlPgProcedurePtRel)result;

			if ((programDurationId !=
					progdurationRotationTlPgProcedurePtRel.
						getProgramDurationId()) ||
				(procedureGroupId !=
					progdurationRotationTlPgProcedurePtRel.
						getProcedureGroupId()) ||
				(procedureId !=
					progdurationRotationTlPgProcedurePtRel.getProcedureId()) ||
				(rotationId !=
					progdurationRotationTlPgProcedurePtRel.getRotationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROCEDUREGROUPID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROCEDUREID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_ROTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(procedureGroupId);

				queryPos.add(procedureId);

				queryPos.add(rotationId);

				List<ProgdurationRotationTlPgProcedurePtRel> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programDurationId, procedureGroupId,
									procedureId, rotationId
								};
							}

							_log.warn(
								"ProgdurationRotationTlPgProcedurePtRelPersistenceImpl.fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(long, long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgdurationRotationTlPgProcedurePtRel
						progdurationRotationTlPgProcedurePtRel = list.get(0);

					result = progdurationRotationTlPgProcedurePtRel;

					cacheResult(progdurationRotationTlPgProcedurePtRel);
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
			return (ProgdurationRotationTlPgProcedurePtRel)result;
		}
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel
			removeByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				long programDurationId, long procedureGroupId, long procedureId,
				long rotationId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
					programDurationId, procedureGroupId, procedureId,
					rotationId);

		return remove(progdurationRotationTlPgProcedurePtRel);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int
		countByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId;

		Object[] finderArgs = new Object[] {
			programDurationId, procedureGroupId, procedureId, rotationId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROCEDUREGROUPID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROCEDUREID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_ROTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(procedureGroupId);

				queryPos.add(procedureId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROGRAMDURATIONID_2 =
			"progdurationRotationTlPgProcedurePtRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROCEDUREGROUPID_2 =
			"progdurationRotationTlPgProcedurePtRel.procedureGroupId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_PROCEDUREID_2 =
			"progdurationRotationTlPgProcedurePtRel.procedureId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPROCEDUREGROUPIDANDPROCEDUREIDANDROTATIONID_ROTATIONID_2 =
			"progdurationRotationTlPgProcedurePtRel.rotationId = ?";

	public ProgdurationRotationTlPgProcedurePtRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"progdurationRotationTlPgProcedurePtRelId",
			"progduration_rotation_tl_pg_procedure_pt_rel_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("traineeLevelId", "trainee_level_id");
		dbColumnNames.put("procedureGroupId", "procedure_group_id");
		dbColumnNames.put("procedureId", "procedure_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("minimumProcedures", "minimum_procedures");
		dbColumnNames.put(
			"traineelevelMinimumProcedures", "traineelevel_minimum_procedures");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgdurationRotationTlPgProcedurePtRel.class);

		setModelImplClass(ProgdurationRotationTlPgProcedurePtRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProgdurationRotationTlPgProcedurePtRelTable.INSTANCE);
	}

	/**
	 * Caches the progduration rotation tl pg procedure pt rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void cacheResult(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		entityCache.putResult(
			ProgdurationRotationTlPgProcedurePtRelImpl.class,
			progdurationRotationTlPgProcedurePtRel.getPrimaryKey(),
			progdurationRotationTlPgProcedurePtRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				progdurationRotationTlPgProcedurePtRel.getUuid(),
				progdurationRotationTlPgProcedurePtRel.getGroupId()
			},
			progdurationRotationTlPgProcedurePtRel);

		finderCache.putResult(
			_finderPathFetchByProcedureId,
			new Object[] {
				progdurationRotationTlPgProcedurePtRel.getProcedureId()
			},
			progdurationRotationTlPgProcedurePtRel);

		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId,
			new Object[] {
				progdurationRotationTlPgProcedurePtRel.getProgramDurationId(),
				progdurationRotationTlPgProcedurePtRel.getProcedureGroupId(),
				progdurationRotationTlPgProcedurePtRel.getProcedureId(),
				progdurationRotationTlPgProcedurePtRel.getRotationId()
			},
			progdurationRotationTlPgProcedurePtRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the progduration rotation tl pg procedure pt rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTlPgProcedurePtRels the progduration rotation tl pg procedure pt rels
	 */
	@Override
	public void cacheResult(
		List<ProgdurationRotationTlPgProcedurePtRel>
			progdurationRotationTlPgProcedurePtRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (progdurationRotationTlPgProcedurePtRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel :
					progdurationRotationTlPgProcedurePtRels) {

			if (entityCache.getResult(
					ProgdurationRotationTlPgProcedurePtRelImpl.class,
					progdurationRotationTlPgProcedurePtRel.getPrimaryKey()) ==
						null) {

				cacheResult(progdurationRotationTlPgProcedurePtRel);
			}
		}
	}

	/**
	 * Clears the cache for all progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(
			ProgdurationRotationTlPgProcedurePtRelImpl.class);

		finderCache.clearCache(
			ProgdurationRotationTlPgProcedurePtRelImpl.class);
	}

	/**
	 * Clears the cache for the progduration rotation tl pg procedure pt rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		entityCache.removeResult(
			ProgdurationRotationTlPgProcedurePtRelImpl.class,
			progdurationRotationTlPgProcedurePtRel);
	}

	@Override
	public void clearCache(
		List<ProgdurationRotationTlPgProcedurePtRel>
			progdurationRotationTlPgProcedurePtRels) {

		for (ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel :
					progdurationRotationTlPgProcedurePtRels) {

			entityCache.removeResult(
				ProgdurationRotationTlPgProcedurePtRelImpl.class,
				progdurationRotationTlPgProcedurePtRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(
			ProgdurationRotationTlPgProcedurePtRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgdurationRotationTlPgProcedurePtRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgdurationRotationTlPgProcedurePtRelModelImpl
			progdurationRotationTlPgProcedurePtRelModelImpl) {

		Object[] args = new Object[] {
			progdurationRotationTlPgProcedurePtRelModelImpl.getUuid(),
			progdurationRotationTlPgProcedurePtRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			progdurationRotationTlPgProcedurePtRelModelImpl);

		args = new Object[] {
			progdurationRotationTlPgProcedurePtRelModelImpl.getProcedureId()
		};

		finderCache.putResult(
			_finderPathCountByProcedureId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProcedureId, args,
			progdurationRotationTlPgProcedurePtRelModelImpl);

		args = new Object[] {
			progdurationRotationTlPgProcedurePtRelModelImpl.
				getProgramDurationId(),
			progdurationRotationTlPgProcedurePtRelModelImpl.
				getProcedureGroupId(),
			progdurationRotationTlPgProcedurePtRelModelImpl.getProcedureId(),
			progdurationRotationTlPgProcedurePtRelModelImpl.getRotationId()
		};

		finderCache.putResult(
			_finderPathCountByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId,
			args, progdurationRotationTlPgProcedurePtRelModelImpl);
	}

	/**
	 * Creates a new progduration rotation tl pg procedure pt rel with the primary key. Does not add the progduration rotation tl pg procedure pt rel to the database.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key for the new progduration rotation tl pg procedure pt rel
	 * @return the new progduration rotation tl pg procedure pt rel
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel create(
		long progdurationRotationTlPgProcedurePtRelId) {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel =
				new ProgdurationRotationTlPgProcedurePtRelImpl();

		progdurationRotationTlPgProcedurePtRel.setNew(true);
		progdurationRotationTlPgProcedurePtRel.setPrimaryKey(
			progdurationRotationTlPgProcedurePtRelId);

		String uuid = _portalUUID.generate();

		progdurationRotationTlPgProcedurePtRel.setUuid(uuid);

		progdurationRotationTlPgProcedurePtRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return progdurationRotationTlPgProcedurePtRel;
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel remove(
			long progdurationRotationTlPgProcedurePtRelId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return remove((Serializable)progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel remove(
			Serializable primaryKey)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		Session session = null;

		try {
			session = openSession();

			ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel =
					(ProgdurationRotationTlPgProcedurePtRel)session.get(
						ProgdurationRotationTlPgProcedurePtRelImpl.class,
						primaryKey);

			if (progdurationRotationTlPgProcedurePtRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(progdurationRotationTlPgProcedurePtRel);
		}
		catch (NoSuchProgdurationRotationTlPgProcedurePtRelException
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
	protected ProgdurationRotationTlPgProcedurePtRel removeImpl(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(progdurationRotationTlPgProcedurePtRel)) {
				progdurationRotationTlPgProcedurePtRel =
					(ProgdurationRotationTlPgProcedurePtRel)session.get(
						ProgdurationRotationTlPgProcedurePtRelImpl.class,
						progdurationRotationTlPgProcedurePtRel.
							getPrimaryKeyObj());
			}

			if (progdurationRotationTlPgProcedurePtRel != null) {
				session.delete(progdurationRotationTlPgProcedurePtRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (progdurationRotationTlPgProcedurePtRel != null) {
			clearCache(progdurationRotationTlPgProcedurePtRel);
		}

		return progdurationRotationTlPgProcedurePtRel;
	}

	@Override
	public ProgdurationRotationTlPgProcedurePtRel updateImpl(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		boolean isNew = progdurationRotationTlPgProcedurePtRel.isNew();

		if (!(progdurationRotationTlPgProcedurePtRel instanceof
				ProgdurationRotationTlPgProcedurePtRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					progdurationRotationTlPgProcedurePtRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					progdurationRotationTlPgProcedurePtRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in progdurationRotationTlPgProcedurePtRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgdurationRotationTlPgProcedurePtRel implementation " +
					progdurationRotationTlPgProcedurePtRel.getClass());
		}

		ProgdurationRotationTlPgProcedurePtRelModelImpl
			progdurationRotationTlPgProcedurePtRelModelImpl =
				(ProgdurationRotationTlPgProcedurePtRelModelImpl)
					progdurationRotationTlPgProcedurePtRel;

		if (Validator.isNull(
				progdurationRotationTlPgProcedurePtRel.getUuid())) {

			String uuid = _portalUUID.generate();

			progdurationRotationTlPgProcedurePtRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(progdurationRotationTlPgProcedurePtRel.getCreateDate() == null)) {

			if (serviceContext == null) {
				progdurationRotationTlPgProcedurePtRel.setCreateDate(date);
			}
			else {
				progdurationRotationTlPgProcedurePtRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!progdurationRotationTlPgProcedurePtRelModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				progdurationRotationTlPgProcedurePtRel.setModifiedDate(date);
			}
			else {
				progdurationRotationTlPgProcedurePtRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(progdurationRotationTlPgProcedurePtRel);
			}
			else {
				progdurationRotationTlPgProcedurePtRel =
					(ProgdurationRotationTlPgProcedurePtRel)session.merge(
						progdurationRotationTlPgProcedurePtRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgdurationRotationTlPgProcedurePtRelImpl.class,
			progdurationRotationTlPgProcedurePtRelModelImpl, false, true);

		cacheUniqueFindersCache(
			progdurationRotationTlPgProcedurePtRelModelImpl);

		if (isNew) {
			progdurationRotationTlPgProcedurePtRel.setNew(false);
		}

		progdurationRotationTlPgProcedurePtRel.resetOriginalValues();

		return progdurationRotationTlPgProcedurePtRel;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel = fetchByPrimaryKey(
				primaryKey);

		if (progdurationRotationTlPgProcedurePtRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgdurationRotationTlPgProcedurePtRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return progdurationRotationTlPgProcedurePtRel;
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel findByPrimaryKey(
			long progdurationRotationTlPgProcedurePtRelId)
		throws NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return findByPrimaryKey(
			(Serializable)progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel, or <code>null</code> if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public ProgdurationRotationTlPgProcedurePtRel fetchByPrimaryKey(
		long progdurationRotationTlPgProcedurePtRelId) {

		return fetchByPrimaryKey(
			(Serializable)progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels.
	 *
	 * @return the progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation tl pg procedure pt rels
	 */
	@Override
	public List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
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

		List<ProgdurationRotationTlPgProcedurePtRel> list = null;

		if (useFinderCache) {
			list =
				(List<ProgdurationRotationTlPgProcedurePtRel>)
					finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL;

				sql = sql.concat(
					ProgdurationRotationTlPgProcedurePtRelModelImpl.
						ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<ProgdurationRotationTlPgProcedurePtRel>)
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
	 * Removes all the progduration rotation tl pg procedure pt rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel : findAll()) {

			remove(progdurationRotationTlPgProcedurePtRel);
		}
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels.
	 *
	 * @return the number of progduration rotation tl pg procedure pt rels
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
					_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL);

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
		return "progduration_rotation_tl_pg_procedure_pt_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgdurationRotationTlPgProcedurePtRelModelImpl.
			TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the progduration rotation tl pg procedure pt rel persistence.
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

		_finderPathWithPaginationFindByProcedureGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProcedureGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"procedure_group_id"}, true);

		_finderPathWithoutPaginationFindByProcedureGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProcedureGroupId",
			new String[] {Long.class.getName()},
			new String[] {"procedure_group_id"}, true);

		_finderPathCountByProcedureGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcedureGroupId", new String[] {Long.class.getName()},
			new String[] {"procedure_group_id"}, false);

		_finderPathFetchByProcedureId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProcedureId",
			new String[] {Long.class.getName()}, new String[] {"procedure_id"},
			true);

		_finderPathCountByProcedureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProcedureId",
			new String[] {Long.class.getName()}, new String[] {"procedure_id"},
			false);

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

		_finderPathWithPaginationFindByProgramDurationIdAndProcedureGroupIdAndProcedureId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProgramDurationIdAndProcedureGroupIdAndProcedureId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {
					"program_duration_id", "procedure_group_id", "procedure_id"
				},
				true);

		_finderPathWithoutPaginationFindByProgramDurationIdAndProcedureGroupIdAndProcedureId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProgramDurationIdAndProcedureGroupIdAndProcedureId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"program_duration_id", "procedure_group_id", "procedure_id"
				},
				true);

		_finderPathCountByProgramDurationIdAndProcedureGroupIdAndProcedureId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgramDurationIdAndProcedureGroupIdAndProcedureId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"program_duration_id", "procedure_group_id", "procedure_id"
				},
				false);

		_finderPathFetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Long.class.getName()
				},
				new String[] {
					"program_duration_id", "procedure_group_id", "procedure_id",
					"rotation_id"
				},
				true);

		_finderPathCountByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Long.class.getName()
				},
				new String[] {
					"program_duration_id", "procedure_group_id", "procedure_id",
					"rotation_id"
				},
				false);

		_setProgdurationRotationTlPgProcedurePtRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgdurationRotationTlPgProcedurePtRelUtilPersistence(null);

		entityCache.removeCache(
			ProgdurationRotationTlPgProcedurePtRelImpl.class.getName());
	}

	private void _setProgdurationRotationTlPgProcedurePtRelUtilPersistence(
		ProgdurationRotationTlPgProcedurePtRelPersistence
			progdurationRotationTlPgProcedurePtRelPersistence) {

		try {
			Field field =
				ProgdurationRotationTlPgProcedurePtRelUtil.class.
					getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, progdurationRotationTlPgProcedurePtRelPersistence);
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
		_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL =
			"SELECT progdurationRotationTlPgProcedurePtRel FROM ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel";

	private static final String
		_SQL_SELECT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE =
			"SELECT progdurationRotationTlPgProcedurePtRel FROM ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel WHERE ";

	private static final String
		_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL =
			"SELECT COUNT(progdurationRotationTlPgProcedurePtRel) FROM ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel";

	private static final String
		_SQL_COUNT_PROGDURATIONROTATIONTLPGPROCEDUREPTREL_WHERE =
			"SELECT COUNT(progdurationRotationTlPgProcedurePtRel) FROM ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"progdurationRotationTlPgProcedurePtRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgdurationRotationTlPgProcedurePtRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgdurationRotationTlPgProcedurePtRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgdurationRotationTlPgProcedurePtRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "progdurationRotationTlPgProcedurePtRelId",
			"programDurationId", "rotationId", "traineeLevelId",
			"procedureGroupId", "procedureId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy",
			"minimumProcedures", "traineelevelMinimumProcedures"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
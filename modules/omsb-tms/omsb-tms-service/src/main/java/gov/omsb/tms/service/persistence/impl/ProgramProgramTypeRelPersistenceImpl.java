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

import gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException;
import gov.omsb.tms.model.ProgramProgramTypeRel;
import gov.omsb.tms.model.ProgramProgramTypeRelTable;
import gov.omsb.tms.model.impl.ProgramProgramTypeRelImpl;
import gov.omsb.tms.model.impl.ProgramProgramTypeRelModelImpl;
import gov.omsb.tms.service.persistence.ProgramProgramTypeRelPersistence;
import gov.omsb.tms.service.persistence.ProgramProgramTypeRelUtil;
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
 * The persistence implementation for the program program type rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgramProgramTypeRelPersistence.class)
public class ProgramProgramTypeRelPersistenceImpl
	extends BasePersistenceImpl<ProgramProgramTypeRel>
	implements ProgramProgramTypeRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgramProgramTypeRelUtil</code> to access the program program type rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgramProgramTypeRelImpl.class.getName();

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
	 * Returns all the program program type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program program type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program program type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program program type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
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

		List<ProgramProgramTypeRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramProgramTypeRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramProgramTypeRel programProgramTypeRel : list) {
					if (!uuid.equals(programProgramTypeRel.getUuid())) {
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

			sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

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
				sb.append(ProgramProgramTypeRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramProgramTypeRel>)QueryUtil.list(
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
	 * Returns the first program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByUuid_First(
			uuid, orderByComparator);

		if (programProgramTypeRel != null) {
			return programProgramTypeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramProgramTypeRelException(sb.toString());
	}

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		List<ProgramProgramTypeRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByUuid_Last(
			uuid, orderByComparator);

		if (programProgramTypeRel != null) {
			return programProgramTypeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramProgramTypeRelException(sb.toString());
	}

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgramProgramTypeRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program program type rels before and after the current program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param programPtId the primary key of the current program program type rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	@Override
	public ProgramProgramTypeRel[] findByUuid_PrevAndNext(
			long programPtId, String uuid,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		uuid = Objects.toString(uuid, "");

		ProgramProgramTypeRel programProgramTypeRel = findByPrimaryKey(
			programPtId);

		Session session = null;

		try {
			session = openSession();

			ProgramProgramTypeRel[] array = new ProgramProgramTypeRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, programProgramTypeRel, uuid, orderByComparator, true);

			array[1] = programProgramTypeRel;

			array[2] = getByUuid_PrevAndNext(
				session, programProgramTypeRel, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramProgramTypeRel getByUuid_PrevAndNext(
		Session session, ProgramProgramTypeRel programProgramTypeRel,
		String uuid, OrderByComparator<ProgramProgramTypeRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

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
			sb.append(ProgramProgramTypeRelModelImpl.ORDER_BY_JPQL);
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
						programProgramTypeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramProgramTypeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program program type rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgramProgramTypeRel programProgramTypeRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programProgramTypeRel);
		}
	}

	/**
	 * Returns the number of program program type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program program type rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMPROGRAMTYPEREL_WHERE);

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
		"programProgramTypeRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(programProgramTypeRel.uuid IS NULL OR programProgramTypeRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByUUID_G(
			uuid, groupId);

		if (programProgramTypeRel == null) {
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

			throw new NoSuchProgramProgramTypeRelException(sb.toString());
		}

		return programProgramTypeRel;
	}

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByUUID_G(
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

		if (result instanceof ProgramProgramTypeRel) {
			ProgramProgramTypeRel programProgramTypeRel =
				(ProgramProgramTypeRel)result;

			if (!Objects.equals(uuid, programProgramTypeRel.getUuid()) ||
				(groupId != programProgramTypeRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

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

				List<ProgramProgramTypeRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgramProgramTypeRel programProgramTypeRel = list.get(0);

					result = programProgramTypeRel;

					cacheResult(programProgramTypeRel);
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
			return (ProgramProgramTypeRel)result;
		}
	}

	/**
	 * Removes the program program type rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program program type rel that was removed
	 */
	@Override
	public ProgramProgramTypeRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = findByUUID_G(
			uuid, groupId);

		return remove(programProgramTypeRel);
	}

	/**
	 * Returns the number of program program type rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program program type rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMPROGRAMTYPEREL_WHERE);

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
		"programProgramTypeRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(programProgramTypeRel.uuid IS NULL OR programProgramTypeRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"programProgramTypeRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
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

		List<ProgramProgramTypeRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramProgramTypeRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramProgramTypeRel programProgramTypeRel : list) {
					if (!uuid.equals(programProgramTypeRel.getUuid()) ||
						(companyId != programProgramTypeRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

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
				sb.append(ProgramProgramTypeRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramProgramTypeRel>)QueryUtil.list(
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
	 * Returns the first program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (programProgramTypeRel != null) {
			return programProgramTypeRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramProgramTypeRelException(sb.toString());
	}

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		List<ProgramProgramTypeRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (programProgramTypeRel != null) {
			return programProgramTypeRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramProgramTypeRelException(sb.toString());
	}

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgramProgramTypeRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program program type rels before and after the current program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programPtId the primary key of the current program program type rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	@Override
	public ProgramProgramTypeRel[] findByUuid_C_PrevAndNext(
			long programPtId, String uuid, long companyId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		uuid = Objects.toString(uuid, "");

		ProgramProgramTypeRel programProgramTypeRel = findByPrimaryKey(
			programPtId);

		Session session = null;

		try {
			session = openSession();

			ProgramProgramTypeRel[] array = new ProgramProgramTypeRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, programProgramTypeRel, uuid, companyId,
				orderByComparator, true);

			array[1] = programProgramTypeRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, programProgramTypeRel, uuid, companyId,
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

	protected ProgramProgramTypeRel getByUuid_C_PrevAndNext(
		Session session, ProgramProgramTypeRel programProgramTypeRel,
		String uuid, long companyId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

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
			sb.append(ProgramProgramTypeRelModelImpl.ORDER_BY_JPQL);
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
						programProgramTypeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramProgramTypeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program program type rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgramProgramTypeRel programProgramTypeRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programProgramTypeRel);
		}
	}

	/**
	 * Returns the number of program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program program type rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMPROGRAMTYPEREL_WHERE);

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
		"programProgramTypeRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(programProgramTypeRel.uuid IS NULL OR programProgramTypeRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"programProgramTypeRel.companyId = ?";

	private FinderPath _finderPathFetchByProgramProgramType;
	private FinderPath _finderPathCountByProgramProgramType;

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByProgramProgramType(
			long programId, long programTypeId)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByProgramProgramType(
			programId, programTypeId);

		if (programProgramTypeRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programId=");
			sb.append(programId);

			sb.append(", programTypeId=");
			sb.append(programTypeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgramProgramTypeRelException(sb.toString());
		}

		return programProgramTypeRel;
	}

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByProgramProgramType(
		long programId, long programTypeId) {

		return fetchByProgramProgramType(programId, programTypeId, true);
	}

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByProgramProgramType(
		long programId, long programTypeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programId, programTypeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramProgramType, finderArgs, this);
		}

		if (result instanceof ProgramProgramTypeRel) {
			ProgramProgramTypeRel programProgramTypeRel =
				(ProgramProgramTypeRel)result;

			if ((programId != programProgramTypeRel.getProgramId()) ||
				(programTypeId != programProgramTypeRel.getProgramTypeId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMPROGRAMTYPE_PROGRAMID_2);

			sb.append(_FINDER_COLUMN_PROGRAMPROGRAMTYPE_PROGRAMTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(programTypeId);

				List<ProgramProgramTypeRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramProgramType, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programId, programTypeId
								};
							}

							_log.warn(
								"ProgramProgramTypeRelPersistenceImpl.fetchByProgramProgramType(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgramProgramTypeRel programProgramTypeRel = list.get(0);

					result = programProgramTypeRel;

					cacheResult(programProgramTypeRel);
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
			return (ProgramProgramTypeRel)result;
		}
	}

	/**
	 * Removes the program program type rel where programId = &#63; and programTypeId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the program program type rel that was removed
	 */
	@Override
	public ProgramProgramTypeRel removeByProgramProgramType(
			long programId, long programTypeId)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = findByProgramProgramType(
			programId, programTypeId);

		return remove(programProgramTypeRel);
	}

	/**
	 * Returns the number of program program type rels where programId = &#63; and programTypeId = &#63;.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the number of matching program program type rels
	 */
	@Override
	public int countByProgramProgramType(long programId, long programTypeId) {
		FinderPath finderPath = _finderPathCountByProgramProgramType;

		Object[] finderArgs = new Object[] {programId, programTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMPROGRAMTYPEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMPROGRAMTYPE_PROGRAMID_2);

			sb.append(_FINDER_COLUMN_PROGRAMPROGRAMTYPE_PROGRAMTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(programTypeId);

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

	private static final String _FINDER_COLUMN_PROGRAMPROGRAMTYPE_PROGRAMID_2 =
		"programProgramTypeRel.programId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMPROGRAMTYPE_PROGRAMTYPEID_2 =
			"programProgramTypeRel.programTypeId = ?";

	private FinderPath _finderPathFetchByProgramId;
	private FinderPath _finderPathCountByProgramId;

	/**
	 * Returns the program program type rel where programId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByProgramId(long programId)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByProgramId(
			programId);

		if (programProgramTypeRel == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programId=");
			sb.append(programId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgramProgramTypeRelException(sb.toString());
		}

		return programProgramTypeRel;
	}

	/**
	 * Returns the program program type rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByProgramId(long programId) {
		return fetchByProgramId(programId, true);
	}

	/**
	 * Returns the program program type rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByProgramId(
		long programId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramId, finderArgs, this);
		}

		if (result instanceof ProgramProgramTypeRel) {
			ProgramProgramTypeRel programProgramTypeRel =
				(ProgramProgramTypeRel)result;

			if (programId != programProgramTypeRel.getProgramId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMID_PROGRAMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				List<ProgramProgramTypeRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {programId};
							}

							_log.warn(
								"ProgramProgramTypeRelPersistenceImpl.fetchByProgramId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgramProgramTypeRel programProgramTypeRel = list.get(0);

					result = programProgramTypeRel;

					cacheResult(programProgramTypeRel);
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
			return (ProgramProgramTypeRel)result;
		}
	}

	/**
	 * Removes the program program type rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program program type rel that was removed
	 */
	@Override
	public ProgramProgramTypeRel removeByProgramId(long programId)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = findByProgramId(
			programId);

		return remove(programProgramTypeRel);
	}

	/**
	 * Returns the number of program program type rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program program type rels
	 */
	@Override
	public int countByProgramId(long programId) {
		FinderPath finderPath = _finderPathCountByProgramId;

		Object[] finderArgs = new Object[] {programId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMPROGRAMTYPEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMID_PROGRAMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

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

	private static final String _FINDER_COLUMN_PROGRAMID_PROGRAMID_2 =
		"programProgramTypeRel.programId = ?";

	private FinderPath _finderPathWithPaginationFindByprogramTypeId;
	private FinderPath _finderPathWithoutPaginationFindByprogramTypeId;
	private FinderPath _finderPathCountByprogramTypeId;

	/**
	 * Returns all the program program type rels where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByprogramTypeId(long programTypeId) {
		return findByprogramTypeId(
			programTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program program type rels where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end) {

		return findByprogramTypeId(programTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program program type rels where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return findByprogramTypeId(
			programTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program program type rels where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByprogramTypeId;
				finderArgs = new Object[] {programTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByprogramTypeId;
			finderArgs = new Object[] {
				programTypeId, start, end, orderByComparator
			};
		}

		List<ProgramProgramTypeRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramProgramTypeRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramProgramTypeRel programProgramTypeRel : list) {
					if (programTypeId !=
							programProgramTypeRel.getProgramTypeId()) {

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

			sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMTYPEID_PROGRAMTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramProgramTypeRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programTypeId);

				list = (List<ProgramProgramTypeRel>)QueryUtil.list(
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
	 * Returns the first program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByprogramTypeId_First(
			long programTypeId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel =
			fetchByprogramTypeId_First(programTypeId, orderByComparator);

		if (programProgramTypeRel != null) {
			return programProgramTypeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programTypeId=");
		sb.append(programTypeId);

		sb.append("}");

		throw new NoSuchProgramProgramTypeRelException(sb.toString());
	}

	/**
	 * Returns the first program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByprogramTypeId_First(
		long programTypeId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		List<ProgramProgramTypeRel> list = findByprogramTypeId(
			programTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByprogramTypeId_Last(
			long programTypeId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByprogramTypeId_Last(
			programTypeId, orderByComparator);

		if (programProgramTypeRel != null) {
			return programProgramTypeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programTypeId=");
		sb.append(programTypeId);

		sb.append("}");

		throw new NoSuchProgramProgramTypeRelException(sb.toString());
	}

	/**
	 * Returns the last program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByprogramTypeId_Last(
		long programTypeId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		int count = countByprogramTypeId(programTypeId);

		if (count == 0) {
			return null;
		}

		List<ProgramProgramTypeRel> list = findByprogramTypeId(
			programTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program program type rels before and after the current program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programPtId the primary key of the current program program type rel
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	@Override
	public ProgramProgramTypeRel[] findByprogramTypeId_PrevAndNext(
			long programPtId, long programTypeId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = findByPrimaryKey(
			programPtId);

		Session session = null;

		try {
			session = openSession();

			ProgramProgramTypeRel[] array = new ProgramProgramTypeRelImpl[3];

			array[0] = getByprogramTypeId_PrevAndNext(
				session, programProgramTypeRel, programTypeId,
				orderByComparator, true);

			array[1] = programProgramTypeRel;

			array[2] = getByprogramTypeId_PrevAndNext(
				session, programProgramTypeRel, programTypeId,
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

	protected ProgramProgramTypeRel getByprogramTypeId_PrevAndNext(
		Session session, ProgramProgramTypeRel programProgramTypeRel,
		long programTypeId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE);

		sb.append(_FINDER_COLUMN_PROGRAMTYPEID_PROGRAMTYPEID_2);

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
			sb.append(ProgramProgramTypeRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programProgramTypeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramProgramTypeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program program type rels where programTypeId = &#63; from the database.
	 *
	 * @param programTypeId the program type ID
	 */
	@Override
	public void removeByprogramTypeId(long programTypeId) {
		for (ProgramProgramTypeRel programProgramTypeRel :
				findByprogramTypeId(
					programTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programProgramTypeRel);
		}
	}

	/**
	 * Returns the number of program program type rels where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the number of matching program program type rels
	 */
	@Override
	public int countByprogramTypeId(long programTypeId) {
		FinderPath finderPath = _finderPathCountByprogramTypeId;

		Object[] finderArgs = new Object[] {programTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMPROGRAMTYPEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMTYPEID_PROGRAMTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programTypeId);

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

	private static final String _FINDER_COLUMN_PROGRAMTYPEID_PROGRAMTYPEID_2 =
		"programProgramTypeRel.programTypeId = ?";

	public ProgramProgramTypeRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("programPtId", "program_pt_id");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put("programTypeId", "program_type_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgramProgramTypeRel.class);

		setModelImplClass(ProgramProgramTypeRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProgramProgramTypeRelTable.INSTANCE);
	}

	/**
	 * Caches the program program type rel in the entity cache if it is enabled.
	 *
	 * @param programProgramTypeRel the program program type rel
	 */
	@Override
	public void cacheResult(ProgramProgramTypeRel programProgramTypeRel) {
		entityCache.putResult(
			ProgramProgramTypeRelImpl.class,
			programProgramTypeRel.getPrimaryKey(), programProgramTypeRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				programProgramTypeRel.getUuid(),
				programProgramTypeRel.getGroupId()
			},
			programProgramTypeRel);

		finderCache.putResult(
			_finderPathFetchByProgramProgramType,
			new Object[] {
				programProgramTypeRel.getProgramId(),
				programProgramTypeRel.getProgramTypeId()
			},
			programProgramTypeRel);

		finderCache.putResult(
			_finderPathFetchByProgramId,
			new Object[] {programProgramTypeRel.getProgramId()},
			programProgramTypeRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the program program type rels in the entity cache if it is enabled.
	 *
	 * @param programProgramTypeRels the program program type rels
	 */
	@Override
	public void cacheResult(
		List<ProgramProgramTypeRel> programProgramTypeRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (programProgramTypeRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgramProgramTypeRel programProgramTypeRel :
				programProgramTypeRels) {

			if (entityCache.getResult(
					ProgramProgramTypeRelImpl.class,
					programProgramTypeRel.getPrimaryKey()) == null) {

				cacheResult(programProgramTypeRel);
			}
		}
	}

	/**
	 * Clears the cache for all program program type rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgramProgramTypeRelImpl.class);

		finderCache.clearCache(ProgramProgramTypeRelImpl.class);
	}

	/**
	 * Clears the cache for the program program type rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProgramProgramTypeRel programProgramTypeRel) {
		entityCache.removeResult(
			ProgramProgramTypeRelImpl.class, programProgramTypeRel);
	}

	@Override
	public void clearCache(List<ProgramProgramTypeRel> programProgramTypeRels) {
		for (ProgramProgramTypeRel programProgramTypeRel :
				programProgramTypeRels) {

			entityCache.removeResult(
				ProgramProgramTypeRelImpl.class, programProgramTypeRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgramProgramTypeRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgramProgramTypeRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgramProgramTypeRelModelImpl programProgramTypeRelModelImpl) {

		Object[] args = new Object[] {
			programProgramTypeRelModelImpl.getUuid(),
			programProgramTypeRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, programProgramTypeRelModelImpl);

		args = new Object[] {
			programProgramTypeRelModelImpl.getProgramId(),
			programProgramTypeRelModelImpl.getProgramTypeId()
		};

		finderCache.putResult(
			_finderPathCountByProgramProgramType, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramProgramType, args,
			programProgramTypeRelModelImpl);

		args = new Object[] {programProgramTypeRelModelImpl.getProgramId()};

		finderCache.putResult(
			_finderPathCountByProgramId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramId, args, programProgramTypeRelModelImpl);
	}

	/**
	 * Creates a new program program type rel with the primary key. Does not add the program program type rel to the database.
	 *
	 * @param programPtId the primary key for the new program program type rel
	 * @return the new program program type rel
	 */
	@Override
	public ProgramProgramTypeRel create(long programPtId) {
		ProgramProgramTypeRel programProgramTypeRel =
			new ProgramProgramTypeRelImpl();

		programProgramTypeRel.setNew(true);
		programProgramTypeRel.setPrimaryKey(programPtId);

		String uuid = _portalUUID.generate();

		programProgramTypeRel.setUuid(uuid);

		programProgramTypeRel.setCompanyId(CompanyThreadLocal.getCompanyId());

		return programProgramTypeRel;
	}

	/**
	 * Removes the program program type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel that was removed
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	@Override
	public ProgramProgramTypeRel remove(long programPtId)
		throws NoSuchProgramProgramTypeRelException {

		return remove((Serializable)programPtId);
	}

	/**
	 * Removes the program program type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the program program type rel
	 * @return the program program type rel that was removed
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	@Override
	public ProgramProgramTypeRel remove(Serializable primaryKey)
		throws NoSuchProgramProgramTypeRelException {

		Session session = null;

		try {
			session = openSession();

			ProgramProgramTypeRel programProgramTypeRel =
				(ProgramProgramTypeRel)session.get(
					ProgramProgramTypeRelImpl.class, primaryKey);

			if (programProgramTypeRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgramProgramTypeRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(programProgramTypeRel);
		}
		catch (NoSuchProgramProgramTypeRelException noSuchEntityException) {
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
	protected ProgramProgramTypeRel removeImpl(
		ProgramProgramTypeRel programProgramTypeRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(programProgramTypeRel)) {
				programProgramTypeRel = (ProgramProgramTypeRel)session.get(
					ProgramProgramTypeRelImpl.class,
					programProgramTypeRel.getPrimaryKeyObj());
			}

			if (programProgramTypeRel != null) {
				session.delete(programProgramTypeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (programProgramTypeRel != null) {
			clearCache(programProgramTypeRel);
		}

		return programProgramTypeRel;
	}

	@Override
	public ProgramProgramTypeRel updateImpl(
		ProgramProgramTypeRel programProgramTypeRel) {

		boolean isNew = programProgramTypeRel.isNew();

		if (!(programProgramTypeRel instanceof
				ProgramProgramTypeRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(programProgramTypeRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					programProgramTypeRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in programProgramTypeRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgramProgramTypeRel implementation " +
					programProgramTypeRel.getClass());
		}

		ProgramProgramTypeRelModelImpl programProgramTypeRelModelImpl =
			(ProgramProgramTypeRelModelImpl)programProgramTypeRel;

		if (Validator.isNull(programProgramTypeRel.getUuid())) {
			String uuid = _portalUUID.generate();

			programProgramTypeRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (programProgramTypeRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				programProgramTypeRel.setCreateDate(date);
			}
			else {
				programProgramTypeRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!programProgramTypeRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				programProgramTypeRel.setModifiedDate(date);
			}
			else {
				programProgramTypeRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(programProgramTypeRel);
			}
			else {
				programProgramTypeRel = (ProgramProgramTypeRel)session.merge(
					programProgramTypeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgramProgramTypeRelImpl.class, programProgramTypeRelModelImpl,
			false, true);

		cacheUniqueFindersCache(programProgramTypeRelModelImpl);

		if (isNew) {
			programProgramTypeRel.setNew(false);
		}

		programProgramTypeRel.resetOriginalValues();

		return programProgramTypeRel;
	}

	/**
	 * Returns the program program type rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the program program type rel
	 * @return the program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgramProgramTypeRelException {

		ProgramProgramTypeRel programProgramTypeRel = fetchByPrimaryKey(
			primaryKey);

		if (programProgramTypeRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgramProgramTypeRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return programProgramTypeRel;
	}

	/**
	 * Returns the program program type rel with the primary key or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	@Override
	public ProgramProgramTypeRel findByPrimaryKey(long programPtId)
		throws NoSuchProgramProgramTypeRelException {

		return findByPrimaryKey((Serializable)programPtId);
	}

	/**
	 * Returns the program program type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel, or <code>null</code> if a program program type rel with the primary key could not be found
	 */
	@Override
	public ProgramProgramTypeRel fetchByPrimaryKey(long programPtId) {
		return fetchByPrimaryKey((Serializable)programPtId);
	}

	/**
	 * Returns all the program program type rels.
	 *
	 * @return the program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program program type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the program program type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findAll(
		int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program program type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program program type rels
	 */
	@Override
	public List<ProgramProgramTypeRel> findAll(
		int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
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

		List<ProgramProgramTypeRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramProgramTypeRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGRAMPROGRAMTYPEREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRAMPROGRAMTYPEREL;

				sql = sql.concat(ProgramProgramTypeRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgramProgramTypeRel>)QueryUtil.list(
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
	 * Removes all the program program type rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgramProgramTypeRel programProgramTypeRel : findAll()) {
			remove(programProgramTypeRel);
		}
	}

	/**
	 * Returns the number of program program type rels.
	 *
	 * @return the number of program program type rels
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
					_SQL_COUNT_PROGRAMPROGRAMTYPEREL);

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
		return "program_pt_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGRAMPROGRAMTYPEREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgramProgramTypeRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the program program type rel persistence.
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

		_finderPathFetchByProgramProgramType = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProgramProgramType",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_id", "program_type_id"}, true);

		_finderPathCountByProgramProgramType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramProgramType",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_id", "program_type_id"}, false);

		_finderPathFetchByProgramId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProgramId",
			new String[] {Long.class.getName()}, new String[] {"program_id"},
			true);

		_finderPathCountByProgramId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProgramId",
			new String[] {Long.class.getName()}, new String[] {"program_id"},
			false);

		_finderPathWithPaginationFindByprogramTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByprogramTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_type_id"}, true);

		_finderPathWithoutPaginationFindByprogramTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByprogramTypeId",
			new String[] {Long.class.getName()},
			new String[] {"program_type_id"}, true);

		_finderPathCountByprogramTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprogramTypeId",
			new String[] {Long.class.getName()},
			new String[] {"program_type_id"}, false);

		_setProgramProgramTypeRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgramProgramTypeRelUtilPersistence(null);

		entityCache.removeCache(ProgramProgramTypeRelImpl.class.getName());
	}

	private void _setProgramProgramTypeRelUtilPersistence(
		ProgramProgramTypeRelPersistence programProgramTypeRelPersistence) {

		try {
			Field field = ProgramProgramTypeRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, programProgramTypeRelPersistence);
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

	private static final String _SQL_SELECT_PROGRAMPROGRAMTYPEREL =
		"SELECT programProgramTypeRel FROM ProgramProgramTypeRel programProgramTypeRel";

	private static final String _SQL_SELECT_PROGRAMPROGRAMTYPEREL_WHERE =
		"SELECT programProgramTypeRel FROM ProgramProgramTypeRel programProgramTypeRel WHERE ";

	private static final String _SQL_COUNT_PROGRAMPROGRAMTYPEREL =
		"SELECT COUNT(programProgramTypeRel) FROM ProgramProgramTypeRel programProgramTypeRel";

	private static final String _SQL_COUNT_PROGRAMPROGRAMTYPEREL_WHERE =
		"SELECT COUNT(programProgramTypeRel) FROM ProgramProgramTypeRel programProgramTypeRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"programProgramTypeRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgramProgramTypeRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgramProgramTypeRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgramProgramTypeRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "programPtId", "programId", "programTypeId", "groupId",
			"companyId", "createDate", "modifiedDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
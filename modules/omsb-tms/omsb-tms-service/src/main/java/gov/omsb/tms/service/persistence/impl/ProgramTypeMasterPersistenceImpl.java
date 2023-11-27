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

import gov.omsb.tms.exception.NoSuchProgramTypeMasterException;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.model.ProgramTypeMasterTable;
import gov.omsb.tms.model.impl.ProgramTypeMasterImpl;
import gov.omsb.tms.model.impl.ProgramTypeMasterModelImpl;
import gov.omsb.tms.service.persistence.ProgramTypeMasterPersistence;
import gov.omsb.tms.service.persistence.ProgramTypeMasterUtil;
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
 * The persistence implementation for the program type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgramTypeMasterPersistence.class)
public class ProgramTypeMasterPersistenceImpl
	extends BasePersistenceImpl<ProgramTypeMaster>
	implements ProgramTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgramTypeMasterUtil</code> to access the program type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgramTypeMasterImpl.class.getName();

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
	 * Returns all the program type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
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

		List<ProgramTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramTypeMaster programTypeMaster : list) {
					if (!uuid.equals(programTypeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_PROGRAMTYPEMASTER_WHERE);

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
				sb.append(ProgramTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramTypeMaster>)QueryUtil.list(
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
	 * Returns the first program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster findByUuid_First(
			String uuid, OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (programTypeMaster != null) {
			return programTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<ProgramTypeMaster> orderByComparator) {

		List<ProgramTypeMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (programTypeMaster != null) {
			return programTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<ProgramTypeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgramTypeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where uuid = &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	@Override
	public ProgramTypeMaster[] findByUuid_PrevAndNext(
			long programTypeMasterId, String uuid,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		uuid = Objects.toString(uuid, "");

		ProgramTypeMaster programTypeMaster = findByPrimaryKey(
			programTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramTypeMaster[] array = new ProgramTypeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, programTypeMaster, uuid, orderByComparator, true);

			array[1] = programTypeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, programTypeMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramTypeMaster getByUuid_PrevAndNext(
		Session session, ProgramTypeMaster programTypeMaster, String uuid,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMTYPEMASTER_WHERE);

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
			sb.append(ProgramTypeMasterModelImpl.ORDER_BY_JPQL);
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
						programTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgramTypeMaster programTypeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programTypeMaster);
		}
	}

	/**
	 * Returns the number of program type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program type masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMTYPEMASTER_WHERE);

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
		"programTypeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(programTypeMaster.uuid IS NULL OR programTypeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster = fetchByUUID_G(uuid, groupId);

		if (programTypeMaster == null) {
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

			throw new NoSuchProgramTypeMasterException(sb.toString());
		}

		return programTypeMaster;
	}

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByUUID_G(
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

		if (result instanceof ProgramTypeMaster) {
			ProgramTypeMaster programTypeMaster = (ProgramTypeMaster)result;

			if (!Objects.equals(uuid, programTypeMaster.getUuid()) ||
				(groupId != programTypeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMTYPEMASTER_WHERE);

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

				List<ProgramTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgramTypeMaster programTypeMaster = list.get(0);

					result = programTypeMaster;

					cacheResult(programTypeMaster);
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
			return (ProgramTypeMaster)result;
		}
	}

	/**
	 * Removes the program type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program type master that was removed
	 */
	@Override
	public ProgramTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster = findByUUID_G(uuid, groupId);

		return remove(programTypeMaster);
	}

	/**
	 * Returns the number of program type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program type masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMTYPEMASTER_WHERE);

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
		"programTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(programTypeMaster.uuid IS NULL OR programTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"programTypeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
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

		List<ProgramTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramTypeMaster programTypeMaster : list) {
					if (!uuid.equals(programTypeMaster.getUuid()) ||
						(companyId != programTypeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGRAMTYPEMASTER_WHERE);

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
				sb.append(ProgramTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramTypeMaster>)QueryUtil.list(
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
	 * Returns the first program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (programTypeMaster != null) {
			return programTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		List<ProgramTypeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (programTypeMaster != null) {
			return programTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgramTypeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	@Override
	public ProgramTypeMaster[] findByUuid_C_PrevAndNext(
			long programTypeMasterId, String uuid, long companyId,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		uuid = Objects.toString(uuid, "");

		ProgramTypeMaster programTypeMaster = findByPrimaryKey(
			programTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramTypeMaster[] array = new ProgramTypeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, programTypeMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = programTypeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, programTypeMaster, uuid, companyId, orderByComparator,
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

	protected ProgramTypeMaster getByUuid_C_PrevAndNext(
		Session session, ProgramTypeMaster programTypeMaster, String uuid,
		long companyId, OrderByComparator<ProgramTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMTYPEMASTER_WHERE);

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
			sb.append(ProgramTypeMasterModelImpl.ORDER_BY_JPQL);
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
						programTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgramTypeMaster programTypeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programTypeMaster);
		}
	}

	/**
	 * Returns the number of program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program type masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMTYPEMASTER_WHERE);

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
		"programTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(programTypeMaster.uuid IS NULL OR programTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"programTypeMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramTypeNameByLike;
	private FinderPath _finderPathWithPaginationCountByProgramTypeNameByLike;

	/**
	 * Returns all the program type masters where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @return the matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName) {

		return findByProgramTypeNameByLike(
			programTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end) {

		return findByProgramTypeNameByLike(programTypeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return findByProgramTypeNameByLike(
			programTypeName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
		boolean useFinderCache) {

		programTypeName = Objects.toString(programTypeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByProgramTypeNameByLike;
		finderArgs = new Object[] {
			programTypeName, start, end, orderByComparator
		};

		List<ProgramTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramTypeMaster programTypeMaster : list) {
					if (!StringUtil.wildcardMatches(
							programTypeMaster.getProgramTypeName(),
							programTypeName, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_PROGRAMTYPEMASTER_WHERE);

			boolean bindProgramTypeName = false;

			if (programTypeName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROGRAMTYPENAMEBYLIKE_PROGRAMTYPENAME_3);
			}
			else {
				bindProgramTypeName = true;

				sb.append(
					_FINDER_COLUMN_PROGRAMTYPENAMEBYLIKE_PROGRAMTYPENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProgramTypeName) {
					queryPos.add(StringUtil.toLowerCase(programTypeName));
				}

				list = (List<ProgramTypeMaster>)QueryUtil.list(
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
	 * Returns the first program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster findByProgramTypeNameByLike_First(
			String programTypeName,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster =
			fetchByProgramTypeNameByLike_First(
				programTypeName, orderByComparator);

		if (programTypeMaster != null) {
			return programTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programTypeNameLIKE");
		sb.append(programTypeName);

		sb.append("}");

		throw new NoSuchProgramTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByProgramTypeNameByLike_First(
		String programTypeName,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		List<ProgramTypeMaster> list = findByProgramTypeNameByLike(
			programTypeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster findByProgramTypeNameByLike_Last(
			String programTypeName,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster = fetchByProgramTypeNameByLike_Last(
			programTypeName, orderByComparator);

		if (programTypeMaster != null) {
			return programTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programTypeNameLIKE");
		sb.append(programTypeName);

		sb.append("}");

		throw new NoSuchProgramTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByProgramTypeNameByLike_Last(
		String programTypeName,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		int count = countByProgramTypeNameByLike(programTypeName);

		if (count == 0) {
			return null;
		}

		List<ProgramTypeMaster> list = findByProgramTypeNameByLike(
			programTypeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	@Override
	public ProgramTypeMaster[] findByProgramTypeNameByLike_PrevAndNext(
			long programTypeMasterId, String programTypeName,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws NoSuchProgramTypeMasterException {

		programTypeName = Objects.toString(programTypeName, "");

		ProgramTypeMaster programTypeMaster = findByPrimaryKey(
			programTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramTypeMaster[] array = new ProgramTypeMasterImpl[3];

			array[0] = getByProgramTypeNameByLike_PrevAndNext(
				session, programTypeMaster, programTypeName, orderByComparator,
				true);

			array[1] = programTypeMaster;

			array[2] = getByProgramTypeNameByLike_PrevAndNext(
				session, programTypeMaster, programTypeName, orderByComparator,
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

	protected ProgramTypeMaster getByProgramTypeNameByLike_PrevAndNext(
		Session session, ProgramTypeMaster programTypeMaster,
		String programTypeName,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMTYPEMASTER_WHERE);

		boolean bindProgramTypeName = false;

		if (programTypeName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PROGRAMTYPENAMEBYLIKE_PROGRAMTYPENAME_3);
		}
		else {
			bindProgramTypeName = true;

			sb.append(_FINDER_COLUMN_PROGRAMTYPENAMEBYLIKE_PROGRAMTYPENAME_2);
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
			sb.append(ProgramTypeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindProgramTypeName) {
			queryPos.add(StringUtil.toLowerCase(programTypeName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program type masters where programTypeName LIKE &#63; from the database.
	 *
	 * @param programTypeName the program type name
	 */
	@Override
	public void removeByProgramTypeNameByLike(String programTypeName) {
		for (ProgramTypeMaster programTypeMaster :
				findByProgramTypeNameByLike(
					programTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programTypeMaster);
		}
	}

	/**
	 * Returns the number of program type masters where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @return the number of matching program type masters
	 */
	@Override
	public int countByProgramTypeNameByLike(String programTypeName) {
		programTypeName = Objects.toString(programTypeName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByProgramTypeNameByLike;

		Object[] finderArgs = new Object[] {programTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMTYPEMASTER_WHERE);

			boolean bindProgramTypeName = false;

			if (programTypeName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROGRAMTYPENAMEBYLIKE_PROGRAMTYPENAME_3);
			}
			else {
				bindProgramTypeName = true;

				sb.append(
					_FINDER_COLUMN_PROGRAMTYPENAMEBYLIKE_PROGRAMTYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProgramTypeName) {
					queryPos.add(StringUtil.toLowerCase(programTypeName));
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

	private static final String
		_FINDER_COLUMN_PROGRAMTYPENAMEBYLIKE_PROGRAMTYPENAME_2 =
			"lower(programTypeMaster.programTypeName) LIKE ?";

	private static final String
		_FINDER_COLUMN_PROGRAMTYPENAMEBYLIKE_PROGRAMTYPENAME_3 =
			"(programTypeMaster.programTypeName IS NULL OR programTypeMaster.programTypeName LIKE '')";

	public ProgramTypeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("programTypeMasterId", "program_type_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("programTypeName", "program_type_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgramTypeMaster.class);

		setModelImplClass(ProgramTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(ProgramTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the program type master in the entity cache if it is enabled.
	 *
	 * @param programTypeMaster the program type master
	 */
	@Override
	public void cacheResult(ProgramTypeMaster programTypeMaster) {
		entityCache.putResult(
			ProgramTypeMasterImpl.class, programTypeMaster.getPrimaryKey(),
			programTypeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				programTypeMaster.getUuid(), programTypeMaster.getGroupId()
			},
			programTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the program type masters in the entity cache if it is enabled.
	 *
	 * @param programTypeMasters the program type masters
	 */
	@Override
	public void cacheResult(List<ProgramTypeMaster> programTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (programTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgramTypeMaster programTypeMaster : programTypeMasters) {
			if (entityCache.getResult(
					ProgramTypeMasterImpl.class,
					programTypeMaster.getPrimaryKey()) == null) {

				cacheResult(programTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all program type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgramTypeMasterImpl.class);

		finderCache.clearCache(ProgramTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the program type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProgramTypeMaster programTypeMaster) {
		entityCache.removeResult(
			ProgramTypeMasterImpl.class, programTypeMaster);
	}

	@Override
	public void clearCache(List<ProgramTypeMaster> programTypeMasters) {
		for (ProgramTypeMaster programTypeMaster : programTypeMasters) {
			entityCache.removeResult(
				ProgramTypeMasterImpl.class, programTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgramTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProgramTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgramTypeMasterModelImpl programTypeMasterModelImpl) {

		Object[] args = new Object[] {
			programTypeMasterModelImpl.getUuid(),
			programTypeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, programTypeMasterModelImpl);
	}

	/**
	 * Creates a new program type master with the primary key. Does not add the program type master to the database.
	 *
	 * @param programTypeMasterId the primary key for the new program type master
	 * @return the new program type master
	 */
	@Override
	public ProgramTypeMaster create(long programTypeMasterId) {
		ProgramTypeMaster programTypeMaster = new ProgramTypeMasterImpl();

		programTypeMaster.setNew(true);
		programTypeMaster.setPrimaryKey(programTypeMasterId);

		String uuid = _portalUUID.generate();

		programTypeMaster.setUuid(uuid);

		programTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return programTypeMaster;
	}

	/**
	 * Removes the program type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master that was removed
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	@Override
	public ProgramTypeMaster remove(long programTypeMasterId)
		throws NoSuchProgramTypeMasterException {

		return remove((Serializable)programTypeMasterId);
	}

	/**
	 * Removes the program type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the program type master
	 * @return the program type master that was removed
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	@Override
	public ProgramTypeMaster remove(Serializable primaryKey)
		throws NoSuchProgramTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			ProgramTypeMaster programTypeMaster =
				(ProgramTypeMaster)session.get(
					ProgramTypeMasterImpl.class, primaryKey);

			if (programTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgramTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(programTypeMaster);
		}
		catch (NoSuchProgramTypeMasterException noSuchEntityException) {
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
	protected ProgramTypeMaster removeImpl(
		ProgramTypeMaster programTypeMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(programTypeMaster)) {
				programTypeMaster = (ProgramTypeMaster)session.get(
					ProgramTypeMasterImpl.class,
					programTypeMaster.getPrimaryKeyObj());
			}

			if (programTypeMaster != null) {
				session.delete(programTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (programTypeMaster != null) {
			clearCache(programTypeMaster);
		}

		return programTypeMaster;
	}

	@Override
	public ProgramTypeMaster updateImpl(ProgramTypeMaster programTypeMaster) {
		boolean isNew = programTypeMaster.isNew();

		if (!(programTypeMaster instanceof ProgramTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(programTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					programTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in programTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgramTypeMaster implementation " +
					programTypeMaster.getClass());
		}

		ProgramTypeMasterModelImpl programTypeMasterModelImpl =
			(ProgramTypeMasterModelImpl)programTypeMaster;

		if (Validator.isNull(programTypeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			programTypeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (programTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				programTypeMaster.setCreateDate(date);
			}
			else {
				programTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!programTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				programTypeMaster.setModifiedDate(date);
			}
			else {
				programTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(programTypeMaster);
			}
			else {
				programTypeMaster = (ProgramTypeMaster)session.merge(
					programTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgramTypeMasterImpl.class, programTypeMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(programTypeMasterModelImpl);

		if (isNew) {
			programTypeMaster.setNew(false);
		}

		programTypeMaster.resetOriginalValues();

		return programTypeMaster;
	}

	/**
	 * Returns the program type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the program type master
	 * @return the program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	@Override
	public ProgramTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgramTypeMasterException {

		ProgramTypeMaster programTypeMaster = fetchByPrimaryKey(primaryKey);

		if (programTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgramTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return programTypeMaster;
	}

	/**
	 * Returns the program type master with the primary key or throws a <code>NoSuchProgramTypeMasterException</code> if it could not be found.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	@Override
	public ProgramTypeMaster findByPrimaryKey(long programTypeMasterId)
		throws NoSuchProgramTypeMasterException {

		return findByPrimaryKey((Serializable)programTypeMasterId);
	}

	/**
	 * Returns the program type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master, or <code>null</code> if a program type master with the primary key could not be found
	 */
	@Override
	public ProgramTypeMaster fetchByPrimaryKey(long programTypeMasterId) {
		return fetchByPrimaryKey((Serializable)programTypeMasterId);
	}

	/**
	 * Returns all the program type masters.
	 *
	 * @return the program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findAll(
		int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program type masters
	 */
	@Override
	public List<ProgramTypeMaster> findAll(
		int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
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

		List<ProgramTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGRAMTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRAMTYPEMASTER;

				sql = sql.concat(ProgramTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgramTypeMaster>)QueryUtil.list(
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
	 * Removes all the program type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgramTypeMaster programTypeMaster : findAll()) {
			remove(programTypeMaster);
		}
	}

	/**
	 * Returns the number of program type masters.
	 *
	 * @return the number of program type masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROGRAMTYPEMASTER);

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
		return "program_type_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGRAMTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgramTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the program type master persistence.
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

		_finderPathWithPaginationFindByProgramTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProgramTypeNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_type_name"}, true);

		_finderPathWithPaginationCountByProgramTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByProgramTypeNameByLike",
			new String[] {String.class.getName()},
			new String[] {"program_type_name"}, false);

		_setProgramTypeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgramTypeMasterUtilPersistence(null);

		entityCache.removeCache(ProgramTypeMasterImpl.class.getName());
	}

	private void _setProgramTypeMasterUtilPersistence(
		ProgramTypeMasterPersistence programTypeMasterPersistence) {

		try {
			Field field = ProgramTypeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, programTypeMasterPersistence);
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

	private static final String _SQL_SELECT_PROGRAMTYPEMASTER =
		"SELECT programTypeMaster FROM ProgramTypeMaster programTypeMaster";

	private static final String _SQL_SELECT_PROGRAMTYPEMASTER_WHERE =
		"SELECT programTypeMaster FROM ProgramTypeMaster programTypeMaster WHERE ";

	private static final String _SQL_COUNT_PROGRAMTYPEMASTER =
		"SELECT COUNT(programTypeMaster) FROM ProgramTypeMaster programTypeMaster";

	private static final String _SQL_COUNT_PROGRAMTYPEMASTER_WHERE =
		"SELECT COUNT(programTypeMaster) FROM ProgramTypeMaster programTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "programTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgramTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgramTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgramTypeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "programTypeMasterId", "groupId", "companyId", "createDate",
			"modifiedDate", "programTypeName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
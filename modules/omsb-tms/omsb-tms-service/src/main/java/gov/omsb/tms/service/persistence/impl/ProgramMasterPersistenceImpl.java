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

import gov.omsb.tms.exception.NoSuchProgramMasterException;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramMasterTable;
import gov.omsb.tms.model.impl.ProgramMasterImpl;
import gov.omsb.tms.model.impl.ProgramMasterModelImpl;
import gov.omsb.tms.service.persistence.ProgramMasterPersistence;
import gov.omsb.tms.service.persistence.ProgramMasterUtil;
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
 * The persistence implementation for the program master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgramMasterPersistence.class)
public class ProgramMasterPersistenceImpl
	extends BasePersistenceImpl<ProgramMaster>
	implements ProgramMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgramMasterUtil</code> to access the program master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgramMasterImpl.class.getName();

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
	 * Returns all the program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program masters
	 */
	@Override
	public List<ProgramMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
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

		List<ProgramMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramMaster programMaster : list) {
					if (!uuid.equals(programMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

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
				sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramMaster>)QueryUtil.list(
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
	 * Returns the first program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByUuid_First(
			String uuid, OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the first program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByUuid_First(
		String uuid, OrderByComparator<ProgramMaster> orderByComparator) {

		List<ProgramMaster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByUuid_Last(
			String uuid, OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByUuid_Last(uuid, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the last program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByUuid_Last(
		String uuid, OrderByComparator<ProgramMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgramMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where uuid = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster[] findByUuid_PrevAndNext(
			long programMasterId, String uuid,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		uuid = Objects.toString(uuid, "");

		ProgramMaster programMaster = findByPrimaryKey(programMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramMaster[] array = new ProgramMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, programMaster, uuid, orderByComparator, true);

			array[1] = programMaster;

			array[2] = getByUuid_PrevAndNext(
				session, programMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramMaster getByUuid_PrevAndNext(
		Session session, ProgramMaster programMaster, String uuid,
		OrderByComparator<ProgramMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

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
			sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
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
						programMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgramMaster programMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programMaster);
		}
	}

	/**
	 * Returns the number of program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMMASTER_WHERE);

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
		"programMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(programMaster.uuid IS NULL OR programMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByUUID_G(uuid, groupId);

		if (programMaster == null) {
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

			throw new NoSuchProgramMasterException(sb.toString());
		}

		return programMaster;
	}

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByUUID_G(
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

		if (result instanceof ProgramMaster) {
			ProgramMaster programMaster = (ProgramMaster)result;

			if (!Objects.equals(uuid, programMaster.getUuid()) ||
				(groupId != programMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

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

				List<ProgramMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgramMaster programMaster = list.get(0);

					result = programMaster;

					cacheResult(programMaster);
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
			return (ProgramMaster)result;
		}
	}

	/**
	 * Removes the program master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program master that was removed
	 */
	@Override
	public ProgramMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = findByUUID_G(uuid, groupId);

		return remove(programMaster);
	}

	/**
	 * Returns the number of program masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMMASTER_WHERE);

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
		"programMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(programMaster.uuid IS NULL OR programMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"programMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program masters
	 */
	@Override
	public List<ProgramMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
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

		List<ProgramMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramMaster programMaster : list) {
					if (!uuid.equals(programMaster.getUuid()) ||
						(companyId != programMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

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
				sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramMaster>)QueryUtil.list(
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
	 * Returns the first program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the first program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramMaster> orderByComparator) {

		List<ProgramMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the last program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgramMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster[] findByUuid_C_PrevAndNext(
			long programMasterId, String uuid, long companyId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		uuid = Objects.toString(uuid, "");

		ProgramMaster programMaster = findByPrimaryKey(programMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramMaster[] array = new ProgramMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, programMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = programMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, programMaster, uuid, companyId, orderByComparator,
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

	protected ProgramMaster getByUuid_C_PrevAndNext(
		Session session, ProgramMaster programMaster, String uuid,
		long companyId, OrderByComparator<ProgramMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

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
			sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
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
						programMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgramMaster programMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programMaster);
		}
	}

	/**
	 * Returns the number of program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMMASTER_WHERE);

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
		"programMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(programMaster.uuid IS NULL OR programMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"programMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramStatus;
	private FinderPath _finderPathWithoutPaginationFindByProgramStatus;
	private FinderPath _finderPathCountByProgramStatus;

	/**
	 * Returns all the program masters where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @return the matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramStatus(Boolean programStatus) {
		return findByProgramStatus(
			programStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end) {

		return findByProgramStatus(programStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return findByProgramStatus(
			programStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProgramStatus;
				finderArgs = new Object[] {programStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProgramStatus;
			finderArgs = new Object[] {
				programStatus, start, end, orderByComparator
			};
		}

		List<ProgramMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramMaster programMaster : list) {
					if (!Objects.equals(
							programStatus, programMaster.getProgramStatus())) {

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

			sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMSTATUS_PROGRAMSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programStatus.booleanValue());

				list = (List<ProgramMaster>)QueryUtil.list(
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
	 * Returns the first program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByProgramStatus_First(
			Boolean programStatus,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByProgramStatus_First(
			programStatus, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programStatus=");
		sb.append(programStatus);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the first program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByProgramStatus_First(
		Boolean programStatus,
		OrderByComparator<ProgramMaster> orderByComparator) {

		List<ProgramMaster> list = findByProgramStatus(
			programStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByProgramStatus_Last(
			Boolean programStatus,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByProgramStatus_Last(
			programStatus, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programStatus=");
		sb.append(programStatus);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the last program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByProgramStatus_Last(
		Boolean programStatus,
		OrderByComparator<ProgramMaster> orderByComparator) {

		int count = countByProgramStatus(programStatus);

		if (count == 0) {
			return null;
		}

		List<ProgramMaster> list = findByProgramStatus(
			programStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster[] findByProgramStatus_PrevAndNext(
			long programMasterId, Boolean programStatus,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = findByPrimaryKey(programMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramMaster[] array = new ProgramMasterImpl[3];

			array[0] = getByProgramStatus_PrevAndNext(
				session, programMaster, programStatus, orderByComparator, true);

			array[1] = programMaster;

			array[2] = getByProgramStatus_PrevAndNext(
				session, programMaster, programStatus, orderByComparator,
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

	protected ProgramMaster getByProgramStatus_PrevAndNext(
		Session session, ProgramMaster programMaster, Boolean programStatus,
		OrderByComparator<ProgramMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

		sb.append(_FINDER_COLUMN_PROGRAMSTATUS_PROGRAMSTATUS_2);

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
			sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programStatus.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program masters where programStatus = &#63; from the database.
	 *
	 * @param programStatus the program status
	 */
	@Override
	public void removeByProgramStatus(Boolean programStatus) {
		for (ProgramMaster programMaster :
				findByProgramStatus(
					programStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programMaster);
		}
	}

	/**
	 * Returns the number of program masters where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @return the number of matching program masters
	 */
	@Override
	public int countByProgramStatus(Boolean programStatus) {
		FinderPath finderPath = _finderPathCountByProgramStatus;

		Object[] finderArgs = new Object[] {programStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMMASTER_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMSTATUS_PROGRAMSTATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programStatus.booleanValue());

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

	private static final String _FINDER_COLUMN_PROGRAMSTATUS_PROGRAMSTATUS_2 =
		"programMaster.programStatus = ?";

	private FinderPath _finderPathWithPaginationFindByProgramNameByLike;
	private FinderPath _finderPathWithPaginationCountByProgramNameByLike;

	/**
	 * Returns all the program masters where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @return the matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramNameByLike(String programName) {
		return findByProgramNameByLike(
			programName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end) {

		return findByProgramNameByLike(programName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return findByProgramNameByLike(
			programName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		programName = Objects.toString(programName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByProgramNameByLike;
		finderArgs = new Object[] {programName, start, end, orderByComparator};

		List<ProgramMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramMaster programMaster : list) {
					if (!StringUtil.wildcardMatches(
							programMaster.getProgramName(), programName, '_',
							'%', '\\', false)) {

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

			sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

			boolean bindProgramName = false;

			if (programName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROGRAMNAMEBYLIKE_PROGRAMNAME_3);
			}
			else {
				bindProgramName = true;

				sb.append(_FINDER_COLUMN_PROGRAMNAMEBYLIKE_PROGRAMNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProgramName) {
					queryPos.add(StringUtil.toLowerCase(programName));
				}

				list = (List<ProgramMaster>)QueryUtil.list(
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
	 * Returns the first program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByProgramNameByLike_First(
			String programName,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByProgramNameByLike_First(
			programName, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programNameLIKE");
		sb.append(programName);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the first program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByProgramNameByLike_First(
		String programName,
		OrderByComparator<ProgramMaster> orderByComparator) {

		List<ProgramMaster> list = findByProgramNameByLike(
			programName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByProgramNameByLike_Last(
			String programName,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByProgramNameByLike_Last(
			programName, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programNameLIKE");
		sb.append(programName);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the last program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByProgramNameByLike_Last(
		String programName,
		OrderByComparator<ProgramMaster> orderByComparator) {

		int count = countByProgramNameByLike(programName);

		if (count == 0) {
			return null;
		}

		List<ProgramMaster> list = findByProgramNameByLike(
			programName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster[] findByProgramNameByLike_PrevAndNext(
			long programMasterId, String programName,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		programName = Objects.toString(programName, "");

		ProgramMaster programMaster = findByPrimaryKey(programMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramMaster[] array = new ProgramMasterImpl[3];

			array[0] = getByProgramNameByLike_PrevAndNext(
				session, programMaster, programName, orderByComparator, true);

			array[1] = programMaster;

			array[2] = getByProgramNameByLike_PrevAndNext(
				session, programMaster, programName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramMaster getByProgramNameByLike_PrevAndNext(
		Session session, ProgramMaster programMaster, String programName,
		OrderByComparator<ProgramMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

		boolean bindProgramName = false;

		if (programName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PROGRAMNAMEBYLIKE_PROGRAMNAME_3);
		}
		else {
			bindProgramName = true;

			sb.append(_FINDER_COLUMN_PROGRAMNAMEBYLIKE_PROGRAMNAME_2);
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
			sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindProgramName) {
			queryPos.add(StringUtil.toLowerCase(programName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program masters where programName LIKE &#63; from the database.
	 *
	 * @param programName the program name
	 */
	@Override
	public void removeByProgramNameByLike(String programName) {
		for (ProgramMaster programMaster :
				findByProgramNameByLike(
					programName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programMaster);
		}
	}

	/**
	 * Returns the number of program masters where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @return the number of matching program masters
	 */
	@Override
	public int countByProgramNameByLike(String programName) {
		programName = Objects.toString(programName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByProgramNameByLike;

		Object[] finderArgs = new Object[] {programName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMMASTER_WHERE);

			boolean bindProgramName = false;

			if (programName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROGRAMNAMEBYLIKE_PROGRAMNAME_3);
			}
			else {
				bindProgramName = true;

				sb.append(_FINDER_COLUMN_PROGRAMNAMEBYLIKE_PROGRAMNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProgramName) {
					queryPos.add(StringUtil.toLowerCase(programName));
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

	private static final String _FINDER_COLUMN_PROGRAMNAMEBYLIKE_PROGRAMNAME_2 =
		"lower(programMaster.programName) LIKE ?";

	private static final String _FINDER_COLUMN_PROGRAMNAMEBYLIKE_PROGRAMNAME_3 =
		"(programMaster.programName IS NULL OR programMaster.programName LIKE '')";

	private FinderPath _finderPathWithPaginationFindByProgramCodeByLike;
	private FinderPath _finderPathWithPaginationCountByProgramCodeByLike;

	/**
	 * Returns all the program masters where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @return the matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramCodeByLike(String programCode) {
		return findByProgramCodeByLike(
			programCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end) {

		return findByProgramCodeByLike(programCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return findByProgramCodeByLike(
			programCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
		boolean useFinderCache) {

		programCode = Objects.toString(programCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByProgramCodeByLike;
		finderArgs = new Object[] {programCode, start, end, orderByComparator};

		List<ProgramMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramMaster programMaster : list) {
					if (!StringUtil.wildcardMatches(
							programMaster.getProgramCode(), programCode, '_',
							'%', '\\', false)) {

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

			sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

			boolean bindProgramCode = false;

			if (programCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROGRAMCODEBYLIKE_PROGRAMCODE_3);
			}
			else {
				bindProgramCode = true;

				sb.append(_FINDER_COLUMN_PROGRAMCODEBYLIKE_PROGRAMCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProgramCode) {
					queryPos.add(StringUtil.toLowerCase(programCode));
				}

				list = (List<ProgramMaster>)QueryUtil.list(
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
	 * Returns the first program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByProgramCodeByLike_First(
			String programCode,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByProgramCodeByLike_First(
			programCode, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programCodeLIKE");
		sb.append(programCode);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the first program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByProgramCodeByLike_First(
		String programCode,
		OrderByComparator<ProgramMaster> orderByComparator) {

		List<ProgramMaster> list = findByProgramCodeByLike(
			programCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByProgramCodeByLike_Last(
			String programCode,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByProgramCodeByLike_Last(
			programCode, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programCodeLIKE");
		sb.append(programCode);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the last program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByProgramCodeByLike_Last(
		String programCode,
		OrderByComparator<ProgramMaster> orderByComparator) {

		int count = countByProgramCodeByLike(programCode);

		if (count == 0) {
			return null;
		}

		List<ProgramMaster> list = findByProgramCodeByLike(
			programCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster[] findByProgramCodeByLike_PrevAndNext(
			long programMasterId, String programCode,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		programCode = Objects.toString(programCode, "");

		ProgramMaster programMaster = findByPrimaryKey(programMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramMaster[] array = new ProgramMasterImpl[3];

			array[0] = getByProgramCodeByLike_PrevAndNext(
				session, programMaster, programCode, orderByComparator, true);

			array[1] = programMaster;

			array[2] = getByProgramCodeByLike_PrevAndNext(
				session, programMaster, programCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramMaster getByProgramCodeByLike_PrevAndNext(
		Session session, ProgramMaster programMaster, String programCode,
		OrderByComparator<ProgramMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

		boolean bindProgramCode = false;

		if (programCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PROGRAMCODEBYLIKE_PROGRAMCODE_3);
		}
		else {
			bindProgramCode = true;

			sb.append(_FINDER_COLUMN_PROGRAMCODEBYLIKE_PROGRAMCODE_2);
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
			sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindProgramCode) {
			queryPos.add(StringUtil.toLowerCase(programCode));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program masters where programCode LIKE &#63; from the database.
	 *
	 * @param programCode the program code
	 */
	@Override
	public void removeByProgramCodeByLike(String programCode) {
		for (ProgramMaster programMaster :
				findByProgramCodeByLike(
					programCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programMaster);
		}
	}

	/**
	 * Returns the number of program masters where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @return the number of matching program masters
	 */
	@Override
	public int countByProgramCodeByLike(String programCode) {
		programCode = Objects.toString(programCode, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByProgramCodeByLike;

		Object[] finderArgs = new Object[] {programCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMMASTER_WHERE);

			boolean bindProgramCode = false;

			if (programCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROGRAMCODEBYLIKE_PROGRAMCODE_3);
			}
			else {
				bindProgramCode = true;

				sb.append(_FINDER_COLUMN_PROGRAMCODEBYLIKE_PROGRAMCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProgramCode) {
					queryPos.add(StringUtil.toLowerCase(programCode));
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

	private static final String _FINDER_COLUMN_PROGRAMCODEBYLIKE_PROGRAMCODE_2 =
		"lower(programMaster.programCode) LIKE ?";

	private static final String _FINDER_COLUMN_PROGRAMCODEBYLIKE_PROGRAMCODE_3 =
		"(programMaster.programCode IS NULL OR programMaster.programCode LIKE '')";

	private FinderPath _finderPathWithPaginationFindByprogramTypeId;
	private FinderPath _finderPathWithoutPaginationFindByprogramTypeId;
	private FinderPath _finderPathCountByprogramTypeId;

	/**
	 * Returns all the program masters where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the matching program masters
	 */
	@Override
	public List<ProgramMaster> findByprogramTypeId(long programTypeId) {
		return findByprogramTypeId(
			programTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end) {

		return findByprogramTypeId(programTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return findByprogramTypeId(
			programTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	@Override
	public List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator,
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

		List<ProgramMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramMaster programMaster : list) {
					if (programTypeId != programMaster.getProgramTypeId()) {
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

			sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMTYPEID_PROGRAMTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programTypeId);

				list = (List<ProgramMaster>)QueryUtil.list(
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
	 * Returns the first program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByprogramTypeId_First(
			long programTypeId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByprogramTypeId_First(
			programTypeId, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programTypeId=");
		sb.append(programTypeId);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the first program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByprogramTypeId_First(
		long programTypeId,
		OrderByComparator<ProgramMaster> orderByComparator) {

		List<ProgramMaster> list = findByprogramTypeId(
			programTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	@Override
	public ProgramMaster findByprogramTypeId_Last(
			long programTypeId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByprogramTypeId_Last(
			programTypeId, orderByComparator);

		if (programMaster != null) {
			return programMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programTypeId=");
		sb.append(programTypeId);

		sb.append("}");

		throw new NoSuchProgramMasterException(sb.toString());
	}

	/**
	 * Returns the last program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public ProgramMaster fetchByprogramTypeId_Last(
		long programTypeId,
		OrderByComparator<ProgramMaster> orderByComparator) {

		int count = countByprogramTypeId(programTypeId);

		if (count == 0) {
			return null;
		}

		List<ProgramMaster> list = findByprogramTypeId(
			programTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster[] findByprogramTypeId_PrevAndNext(
			long programMasterId, long programTypeId,
			OrderByComparator<ProgramMaster> orderByComparator)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = findByPrimaryKey(programMasterId);

		Session session = null;

		try {
			session = openSession();

			ProgramMaster[] array = new ProgramMasterImpl[3];

			array[0] = getByprogramTypeId_PrevAndNext(
				session, programMaster, programTypeId, orderByComparator, true);

			array[1] = programMaster;

			array[2] = getByprogramTypeId_PrevAndNext(
				session, programMaster, programTypeId, orderByComparator,
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

	protected ProgramMaster getByprogramTypeId_PrevAndNext(
		Session session, ProgramMaster programMaster, long programTypeId,
		OrderByComparator<ProgramMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROGRAMMASTER_WHERE);

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
			sb.append(ProgramMasterModelImpl.ORDER_BY_JPQL);
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
						programMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program masters where programTypeId = &#63; from the database.
	 *
	 * @param programTypeId the program type ID
	 */
	@Override
	public void removeByprogramTypeId(long programTypeId) {
		for (ProgramMaster programMaster :
				findByprogramTypeId(
					programTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programMaster);
		}
	}

	/**
	 * Returns the number of program masters where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the number of matching program masters
	 */
	@Override
	public int countByprogramTypeId(long programTypeId) {
		FinderPath finderPath = _finderPathCountByprogramTypeId;

		Object[] finderArgs = new Object[] {programTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMMASTER_WHERE);

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
		"programMaster.programTypeId = ?";

	public ProgramMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("programMasterId", "program_master_id");
		dbColumnNames.put("programTypeId", "program_type_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("programCode", "program_code");
		dbColumnNames.put("programName", "program_name");
		dbColumnNames.put("programDescription", "program_description");
		dbColumnNames.put("establishmentDate", "establishment_date");
		dbColumnNames.put("programVision", "program_vision");
		dbColumnNames.put("programMission", "program_mission");
		dbColumnNames.put("programStatus", "program_status");
		dbColumnNames.put("programObjectives", "program_objectives");
		dbColumnNames.put(
			"programAdmissionRequirements", "program_admission_requirements");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgramMaster.class);

		setModelImplClass(ProgramMasterImpl.class);
		setModelPKClass(long.class);

		setTable(ProgramMasterTable.INSTANCE);
	}

	/**
	 * Caches the program master in the entity cache if it is enabled.
	 *
	 * @param programMaster the program master
	 */
	@Override
	public void cacheResult(ProgramMaster programMaster) {
		entityCache.putResult(
			ProgramMasterImpl.class, programMaster.getPrimaryKey(),
			programMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {programMaster.getUuid(), programMaster.getGroupId()},
			programMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the program masters in the entity cache if it is enabled.
	 *
	 * @param programMasters the program masters
	 */
	@Override
	public void cacheResult(List<ProgramMaster> programMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (programMasters.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgramMaster programMaster : programMasters) {
			if (entityCache.getResult(
					ProgramMasterImpl.class, programMaster.getPrimaryKey()) ==
						null) {

				cacheResult(programMaster);
			}
		}
	}

	/**
	 * Clears the cache for all program masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgramMasterImpl.class);

		finderCache.clearCache(ProgramMasterImpl.class);
	}

	/**
	 * Clears the cache for the program master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProgramMaster programMaster) {
		entityCache.removeResult(ProgramMasterImpl.class, programMaster);
	}

	@Override
	public void clearCache(List<ProgramMaster> programMasters) {
		for (ProgramMaster programMaster : programMasters) {
			entityCache.removeResult(ProgramMasterImpl.class, programMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgramMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProgramMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgramMasterModelImpl programMasterModelImpl) {

		Object[] args = new Object[] {
			programMasterModelImpl.getUuid(),
			programMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, programMasterModelImpl);
	}

	/**
	 * Creates a new program master with the primary key. Does not add the program master to the database.
	 *
	 * @param programMasterId the primary key for the new program master
	 * @return the new program master
	 */
	@Override
	public ProgramMaster create(long programMasterId) {
		ProgramMaster programMaster = new ProgramMasterImpl();

		programMaster.setNew(true);
		programMaster.setPrimaryKey(programMasterId);

		String uuid = _portalUUID.generate();

		programMaster.setUuid(uuid);

		programMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return programMaster;
	}

	/**
	 * Removes the program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master that was removed
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster remove(long programMasterId)
		throws NoSuchProgramMasterException {

		return remove((Serializable)programMasterId);
	}

	/**
	 * Removes the program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the program master
	 * @return the program master that was removed
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster remove(Serializable primaryKey)
		throws NoSuchProgramMasterException {

		Session session = null;

		try {
			session = openSession();

			ProgramMaster programMaster = (ProgramMaster)session.get(
				ProgramMasterImpl.class, primaryKey);

			if (programMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgramMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(programMaster);
		}
		catch (NoSuchProgramMasterException noSuchEntityException) {
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
	protected ProgramMaster removeImpl(ProgramMaster programMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(programMaster)) {
				programMaster = (ProgramMaster)session.get(
					ProgramMasterImpl.class, programMaster.getPrimaryKeyObj());
			}

			if (programMaster != null) {
				session.delete(programMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (programMaster != null) {
			clearCache(programMaster);
		}

		return programMaster;
	}

	@Override
	public ProgramMaster updateImpl(ProgramMaster programMaster) {
		boolean isNew = programMaster.isNew();

		if (!(programMaster instanceof ProgramMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(programMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					programMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in programMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgramMaster implementation " +
					programMaster.getClass());
		}

		ProgramMasterModelImpl programMasterModelImpl =
			(ProgramMasterModelImpl)programMaster;

		if (Validator.isNull(programMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			programMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (programMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				programMaster.setCreateDate(date);
			}
			else {
				programMaster.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!programMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				programMaster.setModifiedDate(date);
			}
			else {
				programMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(programMaster);
			}
			else {
				programMaster = (ProgramMaster)session.merge(programMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgramMasterImpl.class, programMasterModelImpl, false, true);

		cacheUniqueFindersCache(programMasterModelImpl);

		if (isNew) {
			programMaster.setNew(false);
		}

		programMaster.resetOriginalValues();

		return programMaster;
	}

	/**
	 * Returns the program master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the program master
	 * @return the program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgramMasterException {

		ProgramMaster programMaster = fetchByPrimaryKey(primaryKey);

		if (programMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgramMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return programMaster;
	}

	/**
	 * Returns the program master with the primary key or throws a <code>NoSuchProgramMasterException</code> if it could not be found.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster findByPrimaryKey(long programMasterId)
		throws NoSuchProgramMasterException {

		return findByPrimaryKey((Serializable)programMasterId);
	}

	/**
	 * Returns the program master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master, or <code>null</code> if a program master with the primary key could not be found
	 */
	@Override
	public ProgramMaster fetchByPrimaryKey(long programMasterId) {
		return fetchByPrimaryKey((Serializable)programMasterId);
	}

	/**
	 * Returns all the program masters.
	 *
	 * @return the program masters
	 */
	@Override
	public List<ProgramMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of program masters
	 */
	@Override
	public List<ProgramMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program masters
	 */
	@Override
	public List<ProgramMaster> findAll(
		int start, int end,
		OrderByComparator<ProgramMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program masters
	 */
	@Override
	public List<ProgramMaster> findAll(
		int start, int end, OrderByComparator<ProgramMaster> orderByComparator,
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

		List<ProgramMaster> list = null;

		if (useFinderCache) {
			list = (List<ProgramMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGRAMMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRAMMASTER;

				sql = sql.concat(ProgramMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgramMaster>)QueryUtil.list(
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
	 * Removes all the program masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgramMaster programMaster : findAll()) {
			remove(programMaster);
		}
	}

	/**
	 * Returns the number of program masters.
	 *
	 * @return the number of program masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROGRAMMASTER);

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
		return "program_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGRAMMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgramMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the program master persistence.
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

		_finderPathWithPaginationFindByProgramStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProgramStatus",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_status"}, true);

		_finderPathWithoutPaginationFindByProgramStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProgramStatus",
			new String[] {Boolean.class.getName()},
			new String[] {"program_status"}, true);

		_finderPathCountByProgramStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProgramStatus",
			new String[] {Boolean.class.getName()},
			new String[] {"program_status"}, false);

		_finderPathWithPaginationFindByProgramNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProgramNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_name"}, true);

		_finderPathWithPaginationCountByProgramNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByProgramNameByLike",
			new String[] {String.class.getName()},
			new String[] {"program_name"}, false);

		_finderPathWithPaginationFindByProgramCodeByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProgramCodeByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_code"}, true);

		_finderPathWithPaginationCountByProgramCodeByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByProgramCodeByLike",
			new String[] {String.class.getName()},
			new String[] {"program_code"}, false);

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

		_setProgramMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgramMasterUtilPersistence(null);

		entityCache.removeCache(ProgramMasterImpl.class.getName());
	}

	private void _setProgramMasterUtilPersistence(
		ProgramMasterPersistence programMasterPersistence) {

		try {
			Field field = ProgramMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, programMasterPersistence);
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

	private static final String _SQL_SELECT_PROGRAMMASTER =
		"SELECT programMaster FROM ProgramMaster programMaster";

	private static final String _SQL_SELECT_PROGRAMMASTER_WHERE =
		"SELECT programMaster FROM ProgramMaster programMaster WHERE ";

	private static final String _SQL_COUNT_PROGRAMMASTER =
		"SELECT COUNT(programMaster) FROM ProgramMaster programMaster";

	private static final String _SQL_COUNT_PROGRAMMASTER_WHERE =
		"SELECT COUNT(programMaster) FROM ProgramMaster programMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "programMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgramMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgramMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgramMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "programMasterId", "programTypeId", "groupId", "companyId",
			"createDate", "modifiedDate", "programCode", "programName",
			"programDescription", "establishmentDate", "programVision",
			"programMission", "programStatus", "programObjectives",
			"programAdmissionRequirements"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchCptCodeMasterException;
import gov.omsb.tms.model.CptCodeMaster;
import gov.omsb.tms.model.CptCodeMasterTable;
import gov.omsb.tms.model.impl.CptCodeMasterImpl;
import gov.omsb.tms.model.impl.CptCodeMasterModelImpl;
import gov.omsb.tms.service.persistence.CptCodeMasterPersistence;
import gov.omsb.tms.service.persistence.CptCodeMasterUtil;
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
 * The persistence implementation for the cpt code master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CptCodeMasterPersistence.class)
public class CptCodeMasterPersistenceImpl
	extends BasePersistenceImpl<CptCodeMaster>
	implements CptCodeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CptCodeMasterUtil</code> to access the cpt code master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CptCodeMasterImpl.class.getName();

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
	 * Returns all the cpt code masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator,
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

		List<CptCodeMaster> list = null;

		if (useFinderCache) {
			list = (List<CptCodeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CptCodeMaster cptCodeMaster : list) {
					if (!uuid.equals(cptCodeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_CPTCODEMASTER_WHERE);

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
				sb.append(CptCodeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<CptCodeMaster>)QueryUtil.list(
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
	 * Returns the first cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster findByUuid_First(
			String uuid, OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (cptCodeMaster != null) {
			return cptCodeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCptCodeMasterException(sb.toString());
	}

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchByUuid_First(
		String uuid, OrderByComparator<CptCodeMaster> orderByComparator) {

		List<CptCodeMaster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster findByUuid_Last(
			String uuid, OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = fetchByUuid_Last(uuid, orderByComparator);

		if (cptCodeMaster != null) {
			return cptCodeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCptCodeMasterException(sb.toString());
	}

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<CptCodeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CptCodeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster[] findByUuid_PrevAndNext(
			long cptCodeMasterId, String uuid,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		uuid = Objects.toString(uuid, "");

		CptCodeMaster cptCodeMaster = findByPrimaryKey(cptCodeMasterId);

		Session session = null;

		try {
			session = openSession();

			CptCodeMaster[] array = new CptCodeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, cptCodeMaster, uuid, orderByComparator, true);

			array[1] = cptCodeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, cptCodeMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CptCodeMaster getByUuid_PrevAndNext(
		Session session, CptCodeMaster cptCodeMaster, String uuid,
		OrderByComparator<CptCodeMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CPTCODEMASTER_WHERE);

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
			sb.append(CptCodeMasterModelImpl.ORDER_BY_JPQL);
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
						cptCodeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CptCodeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cpt code masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CptCodeMaster cptCodeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cptCodeMaster);
		}
	}

	/**
	 * Returns the number of cpt code masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cpt code masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CPTCODEMASTER_WHERE);

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
		"cptCodeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(cptCodeMaster.uuid IS NULL OR cptCodeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCptCodeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = fetchByUUID_G(uuid, groupId);

		if (cptCodeMaster == null) {
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

			throw new NoSuchCptCodeMasterException(sb.toString());
		}

		return cptCodeMaster;
	}

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchByUUID_G(
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

		if (result instanceof CptCodeMaster) {
			CptCodeMaster cptCodeMaster = (CptCodeMaster)result;

			if (!Objects.equals(uuid, cptCodeMaster.getUuid()) ||
				(groupId != cptCodeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CPTCODEMASTER_WHERE);

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

				List<CptCodeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CptCodeMaster cptCodeMaster = list.get(0);

					result = cptCodeMaster;

					cacheResult(cptCodeMaster);
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
			return (CptCodeMaster)result;
		}
	}

	/**
	 * Removes the cpt code master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cpt code master that was removed
	 */
	@Override
	public CptCodeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = findByUUID_G(uuid, groupId);

		return remove(cptCodeMaster);
	}

	/**
	 * Returns the number of cpt code masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cpt code masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CPTCODEMASTER_WHERE);

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
		"cptCodeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(cptCodeMaster.uuid IS NULL OR cptCodeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"cptCodeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator,
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

		List<CptCodeMaster> list = null;

		if (useFinderCache) {
			list = (List<CptCodeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CptCodeMaster cptCodeMaster : list) {
					if (!uuid.equals(cptCodeMaster.getUuid()) ||
						(companyId != cptCodeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CPTCODEMASTER_WHERE);

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
				sb.append(CptCodeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<CptCodeMaster>)QueryUtil.list(
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
	 * Returns the first cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (cptCodeMaster != null) {
			return cptCodeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCptCodeMasterException(sb.toString());
	}

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		List<CptCodeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (cptCodeMaster != null) {
			return cptCodeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCptCodeMasterException(sb.toString());
	}

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CptCodeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster[] findByUuid_C_PrevAndNext(
			long cptCodeMasterId, String uuid, long companyId,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		uuid = Objects.toString(uuid, "");

		CptCodeMaster cptCodeMaster = findByPrimaryKey(cptCodeMasterId);

		Session session = null;

		try {
			session = openSession();

			CptCodeMaster[] array = new CptCodeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, cptCodeMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = cptCodeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, cptCodeMaster, uuid, companyId, orderByComparator,
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

	protected CptCodeMaster getByUuid_C_PrevAndNext(
		Session session, CptCodeMaster cptCodeMaster, String uuid,
		long companyId, OrderByComparator<CptCodeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_CPTCODEMASTER_WHERE);

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
			sb.append(CptCodeMasterModelImpl.ORDER_BY_JPQL);
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
						cptCodeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CptCodeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cpt code masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CptCodeMaster cptCodeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cptCodeMaster);
		}
	}

	/**
	 * Returns the number of cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cpt code masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CPTCODEMASTER_WHERE);

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
		"cptCodeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(cptCodeMaster.uuid IS NULL OR cptCodeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"cptCodeMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCptCodeNameByLike;
	private FinderPath _finderPathWithPaginationCountByCptCodeNameByLike;

	/**
	 * Returns all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @return the matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByCptCodeNameByLike(String cptCodeName) {
		return findByCptCodeNameByLike(
			cptCodeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end) {

		return findByCptCodeNameByLike(cptCodeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return findByCptCodeNameByLike(
			cptCodeName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator,
		boolean useFinderCache) {

		cptCodeName = Objects.toString(cptCodeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByCptCodeNameByLike;
		finderArgs = new Object[] {cptCodeName, start, end, orderByComparator};

		List<CptCodeMaster> list = null;

		if (useFinderCache) {
			list = (List<CptCodeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CptCodeMaster cptCodeMaster : list) {
					if (!StringUtil.wildcardMatches(
							cptCodeMaster.getCptCodeName(), cptCodeName, '_',
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

			sb.append(_SQL_SELECT_CPTCODEMASTER_WHERE);

			boolean bindCptCodeName = false;

			if (cptCodeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPTCODENAMEBYLIKE_CPTCODENAME_3);
			}
			else {
				bindCptCodeName = true;

				sb.append(_FINDER_COLUMN_CPTCODENAMEBYLIKE_CPTCODENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CptCodeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCptCodeName) {
					queryPos.add(StringUtil.toLowerCase(cptCodeName));
				}

				list = (List<CptCodeMaster>)QueryUtil.list(
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
	 * Returns the first cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster findByCptCodeNameByLike_First(
			String cptCodeName,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = fetchByCptCodeNameByLike_First(
			cptCodeName, orderByComparator);

		if (cptCodeMaster != null) {
			return cptCodeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cptCodeNameLIKE");
		sb.append(cptCodeName);

		sb.append("}");

		throw new NoSuchCptCodeMasterException(sb.toString());
	}

	/**
	 * Returns the first cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchByCptCodeNameByLike_First(
		String cptCodeName,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		List<CptCodeMaster> list = findByCptCodeNameByLike(
			cptCodeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster findByCptCodeNameByLike_Last(
			String cptCodeName,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = fetchByCptCodeNameByLike_Last(
			cptCodeName, orderByComparator);

		if (cptCodeMaster != null) {
			return cptCodeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cptCodeNameLIKE");
		sb.append(cptCodeName);

		sb.append("}");

		throw new NoSuchCptCodeMasterException(sb.toString());
	}

	/**
	 * Returns the last cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public CptCodeMaster fetchByCptCodeNameByLike_Last(
		String cptCodeName,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		int count = countByCptCodeNameByLike(cptCodeName);

		if (count == 0) {
			return null;
		}

		List<CptCodeMaster> list = findByCptCodeNameByLike(
			cptCodeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster[] findByCptCodeNameByLike_PrevAndNext(
			long cptCodeMasterId, String cptCodeName,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws NoSuchCptCodeMasterException {

		cptCodeName = Objects.toString(cptCodeName, "");

		CptCodeMaster cptCodeMaster = findByPrimaryKey(cptCodeMasterId);

		Session session = null;

		try {
			session = openSession();

			CptCodeMaster[] array = new CptCodeMasterImpl[3];

			array[0] = getByCptCodeNameByLike_PrevAndNext(
				session, cptCodeMaster, cptCodeName, orderByComparator, true);

			array[1] = cptCodeMaster;

			array[2] = getByCptCodeNameByLike_PrevAndNext(
				session, cptCodeMaster, cptCodeName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CptCodeMaster getByCptCodeNameByLike_PrevAndNext(
		Session session, CptCodeMaster cptCodeMaster, String cptCodeName,
		OrderByComparator<CptCodeMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CPTCODEMASTER_WHERE);

		boolean bindCptCodeName = false;

		if (cptCodeName.isEmpty()) {
			sb.append(_FINDER_COLUMN_CPTCODENAMEBYLIKE_CPTCODENAME_3);
		}
		else {
			bindCptCodeName = true;

			sb.append(_FINDER_COLUMN_CPTCODENAMEBYLIKE_CPTCODENAME_2);
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
			sb.append(CptCodeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCptCodeName) {
			queryPos.add(StringUtil.toLowerCase(cptCodeName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cptCodeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CptCodeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cpt code masters where cptCodeName LIKE &#63; from the database.
	 *
	 * @param cptCodeName the cpt code name
	 */
	@Override
	public void removeByCptCodeNameByLike(String cptCodeName) {
		for (CptCodeMaster cptCodeMaster :
				findByCptCodeNameByLike(
					cptCodeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cptCodeMaster);
		}
	}

	/**
	 * Returns the number of cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @return the number of matching cpt code masters
	 */
	@Override
	public int countByCptCodeNameByLike(String cptCodeName) {
		cptCodeName = Objects.toString(cptCodeName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByCptCodeNameByLike;

		Object[] finderArgs = new Object[] {cptCodeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CPTCODEMASTER_WHERE);

			boolean bindCptCodeName = false;

			if (cptCodeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPTCODENAMEBYLIKE_CPTCODENAME_3);
			}
			else {
				bindCptCodeName = true;

				sb.append(_FINDER_COLUMN_CPTCODENAMEBYLIKE_CPTCODENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCptCodeName) {
					queryPos.add(StringUtil.toLowerCase(cptCodeName));
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

	private static final String _FINDER_COLUMN_CPTCODENAMEBYLIKE_CPTCODENAME_2 =
		"lower(cptCodeMaster.cptCodeName) LIKE ?";

	private static final String _FINDER_COLUMN_CPTCODENAMEBYLIKE_CPTCODENAME_3 =
		"(cptCodeMaster.cptCodeName IS NULL OR cptCodeMaster.cptCodeName LIKE '')";

	public CptCodeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("cptCodeMasterId", "cpt_code_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("cptCodeName", "cpt_code_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(CptCodeMaster.class);

		setModelImplClass(CptCodeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(CptCodeMasterTable.INSTANCE);
	}

	/**
	 * Caches the cpt code master in the entity cache if it is enabled.
	 *
	 * @param cptCodeMaster the cpt code master
	 */
	@Override
	public void cacheResult(CptCodeMaster cptCodeMaster) {
		entityCache.putResult(
			CptCodeMasterImpl.class, cptCodeMaster.getPrimaryKey(),
			cptCodeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {cptCodeMaster.getUuid(), cptCodeMaster.getGroupId()},
			cptCodeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cpt code masters in the entity cache if it is enabled.
	 *
	 * @param cptCodeMasters the cpt code masters
	 */
	@Override
	public void cacheResult(List<CptCodeMaster> cptCodeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cptCodeMasters.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CptCodeMaster cptCodeMaster : cptCodeMasters) {
			if (entityCache.getResult(
					CptCodeMasterImpl.class, cptCodeMaster.getPrimaryKey()) ==
						null) {

				cacheResult(cptCodeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all cpt code masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CptCodeMasterImpl.class);

		finderCache.clearCache(CptCodeMasterImpl.class);
	}

	/**
	 * Clears the cache for the cpt code master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CptCodeMaster cptCodeMaster) {
		entityCache.removeResult(CptCodeMasterImpl.class, cptCodeMaster);
	}

	@Override
	public void clearCache(List<CptCodeMaster> cptCodeMasters) {
		for (CptCodeMaster cptCodeMaster : cptCodeMasters) {
			entityCache.removeResult(CptCodeMasterImpl.class, cptCodeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CptCodeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CptCodeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CptCodeMasterModelImpl cptCodeMasterModelImpl) {

		Object[] args = new Object[] {
			cptCodeMasterModelImpl.getUuid(),
			cptCodeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, cptCodeMasterModelImpl);
	}

	/**
	 * Creates a new cpt code master with the primary key. Does not add the cpt code master to the database.
	 *
	 * @param cptCodeMasterId the primary key for the new cpt code master
	 * @return the new cpt code master
	 */
	@Override
	public CptCodeMaster create(long cptCodeMasterId) {
		CptCodeMaster cptCodeMaster = new CptCodeMasterImpl();

		cptCodeMaster.setNew(true);
		cptCodeMaster.setPrimaryKey(cptCodeMasterId);

		String uuid = _portalUUID.generate();

		cptCodeMaster.setUuid(uuid);

		cptCodeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return cptCodeMaster;
	}

	/**
	 * Removes the cpt code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master that was removed
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster remove(long cptCodeMasterId)
		throws NoSuchCptCodeMasterException {

		return remove((Serializable)cptCodeMasterId);
	}

	/**
	 * Removes the cpt code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cpt code master
	 * @return the cpt code master that was removed
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster remove(Serializable primaryKey)
		throws NoSuchCptCodeMasterException {

		Session session = null;

		try {
			session = openSession();

			CptCodeMaster cptCodeMaster = (CptCodeMaster)session.get(
				CptCodeMasterImpl.class, primaryKey);

			if (cptCodeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCptCodeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cptCodeMaster);
		}
		catch (NoSuchCptCodeMasterException noSuchEntityException) {
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
	protected CptCodeMaster removeImpl(CptCodeMaster cptCodeMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cptCodeMaster)) {
				cptCodeMaster = (CptCodeMaster)session.get(
					CptCodeMasterImpl.class, cptCodeMaster.getPrimaryKeyObj());
			}

			if (cptCodeMaster != null) {
				session.delete(cptCodeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cptCodeMaster != null) {
			clearCache(cptCodeMaster);
		}

		return cptCodeMaster;
	}

	@Override
	public CptCodeMaster updateImpl(CptCodeMaster cptCodeMaster) {
		boolean isNew = cptCodeMaster.isNew();

		if (!(cptCodeMaster instanceof CptCodeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cptCodeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					cptCodeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cptCodeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CptCodeMaster implementation " +
					cptCodeMaster.getClass());
		}

		CptCodeMasterModelImpl cptCodeMasterModelImpl =
			(CptCodeMasterModelImpl)cptCodeMaster;

		if (Validator.isNull(cptCodeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			cptCodeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (cptCodeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				cptCodeMaster.setCreateDate(date);
			}
			else {
				cptCodeMaster.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!cptCodeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cptCodeMaster.setModifiedDate(date);
			}
			else {
				cptCodeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cptCodeMaster);
			}
			else {
				cptCodeMaster = (CptCodeMaster)session.merge(cptCodeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CptCodeMasterImpl.class, cptCodeMasterModelImpl, false, true);

		cacheUniqueFindersCache(cptCodeMasterModelImpl);

		if (isNew) {
			cptCodeMaster.setNew(false);
		}

		cptCodeMaster.resetOriginalValues();

		return cptCodeMaster;
	}

	/**
	 * Returns the cpt code master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cpt code master
	 * @return the cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCptCodeMasterException {

		CptCodeMaster cptCodeMaster = fetchByPrimaryKey(primaryKey);

		if (cptCodeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCptCodeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cptCodeMaster;
	}

	/**
	 * Returns the cpt code master with the primary key or throws a <code>NoSuchCptCodeMasterException</code> if it could not be found.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster findByPrimaryKey(long cptCodeMasterId)
		throws NoSuchCptCodeMasterException {

		return findByPrimaryKey((Serializable)cptCodeMasterId);
	}

	/**
	 * Returns the cpt code master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master, or <code>null</code> if a cpt code master with the primary key could not be found
	 */
	@Override
	public CptCodeMaster fetchByPrimaryKey(long cptCodeMasterId) {
		return fetchByPrimaryKey((Serializable)cptCodeMasterId);
	}

	/**
	 * Returns all the cpt code masters.
	 *
	 * @return the cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findAll(
		int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cpt code masters
	 */
	@Override
	public List<CptCodeMaster> findAll(
		int start, int end, OrderByComparator<CptCodeMaster> orderByComparator,
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

		List<CptCodeMaster> list = null;

		if (useFinderCache) {
			list = (List<CptCodeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CPTCODEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CPTCODEMASTER;

				sql = sql.concat(CptCodeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CptCodeMaster>)QueryUtil.list(
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
	 * Removes all the cpt code masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CptCodeMaster cptCodeMaster : findAll()) {
			remove(cptCodeMaster);
		}
	}

	/**
	 * Returns the number of cpt code masters.
	 *
	 * @return the number of cpt code masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CPTCODEMASTER);

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
		return "cpt_code_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CPTCODEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CptCodeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cpt code master persistence.
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

		_finderPathWithPaginationFindByCptCodeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCptCodeNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cpt_code_name"}, true);

		_finderPathWithPaginationCountByCptCodeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCptCodeNameByLike",
			new String[] {String.class.getName()},
			new String[] {"cpt_code_name"}, false);

		_setCptCodeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCptCodeMasterUtilPersistence(null);

		entityCache.removeCache(CptCodeMasterImpl.class.getName());
	}

	private void _setCptCodeMasterUtilPersistence(
		CptCodeMasterPersistence cptCodeMasterPersistence) {

		try {
			Field field = CptCodeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, cptCodeMasterPersistence);
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

	private static final String _SQL_SELECT_CPTCODEMASTER =
		"SELECT cptCodeMaster FROM CptCodeMaster cptCodeMaster";

	private static final String _SQL_SELECT_CPTCODEMASTER_WHERE =
		"SELECT cptCodeMaster FROM CptCodeMaster cptCodeMaster WHERE ";

	private static final String _SQL_COUNT_CPTCODEMASTER =
		"SELECT COUNT(cptCodeMaster) FROM CptCodeMaster cptCodeMaster";

	private static final String _SQL_COUNT_CPTCODEMASTER_WHERE =
		"SELECT COUNT(cptCodeMaster) FROM CptCodeMaster cptCodeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cptCodeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CptCodeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CptCodeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CptCodeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "cptCodeMasterId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "cptCodeName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
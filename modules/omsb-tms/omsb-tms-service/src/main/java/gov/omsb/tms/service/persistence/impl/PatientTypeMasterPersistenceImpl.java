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

import gov.omsb.tms.exception.NoSuchPatientTypeMasterException;
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.model.PatientTypeMasterTable;
import gov.omsb.tms.model.impl.PatientTypeMasterImpl;
import gov.omsb.tms.model.impl.PatientTypeMasterModelImpl;
import gov.omsb.tms.service.persistence.PatientTypeMasterPersistence;
import gov.omsb.tms.service.persistence.PatientTypeMasterUtil;
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
 * The persistence implementation for the patient type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PatientTypeMasterPersistence.class)
public class PatientTypeMasterPersistenceImpl
	extends BasePersistenceImpl<PatientTypeMaster>
	implements PatientTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PatientTypeMasterUtil</code> to access the patient type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PatientTypeMasterImpl.class.getName();

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
	 * Returns all the patient type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator,
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

		List<PatientTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<PatientTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PatientTypeMaster patientTypeMaster : list) {
					if (!uuid.equals(patientTypeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_PATIENTTYPEMASTER_WHERE);

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
				sb.append(PatientTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<PatientTypeMaster>)QueryUtil.list(
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
	 * Returns the first patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster findByUuid_First(
			String uuid, OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (patientTypeMaster != null) {
			return patientTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPatientTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<PatientTypeMaster> orderByComparator) {

		List<PatientTypeMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (patientTypeMaster != null) {
			return patientTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPatientTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<PatientTypeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PatientTypeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient type masters before and after the current patient type master in the ordered set where uuid = &#63;.
	 *
	 * @param patientTypeMasterId the primary key of the current patient type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	@Override
	public PatientTypeMaster[] findByUuid_PrevAndNext(
			long patientTypeMasterId, String uuid,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		uuid = Objects.toString(uuid, "");

		PatientTypeMaster patientTypeMaster = findByPrimaryKey(
			patientTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			PatientTypeMaster[] array = new PatientTypeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, patientTypeMaster, uuid, orderByComparator, true);

			array[1] = patientTypeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, patientTypeMaster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientTypeMaster getByUuid_PrevAndNext(
		Session session, PatientTypeMaster patientTypeMaster, String uuid,
		OrderByComparator<PatientTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PATIENTTYPEMASTER_WHERE);

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
			sb.append(PatientTypeMasterModelImpl.ORDER_BY_JPQL);
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
						patientTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PatientTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PatientTypeMaster patientTypeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(patientTypeMaster);
		}
	}

	/**
	 * Returns the number of patient type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient type masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENTTYPEMASTER_WHERE);

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
		"patientTypeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(patientTypeMaster.uuid IS NULL OR patientTypeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPatientTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster = fetchByUUID_G(uuid, groupId);

		if (patientTypeMaster == null) {
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

			throw new NoSuchPatientTypeMasterException(sb.toString());
		}

		return patientTypeMaster;
	}

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the patient type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster fetchByUUID_G(
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

		if (result instanceof PatientTypeMaster) {
			PatientTypeMaster patientTypeMaster = (PatientTypeMaster)result;

			if (!Objects.equals(uuid, patientTypeMaster.getUuid()) ||
				(groupId != patientTypeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PATIENTTYPEMASTER_WHERE);

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

				List<PatientTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PatientTypeMaster patientTypeMaster = list.get(0);

					result = patientTypeMaster;

					cacheResult(patientTypeMaster);
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
			return (PatientTypeMaster)result;
		}
	}

	/**
	 * Removes the patient type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient type master that was removed
	 */
	@Override
	public PatientTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster = findByUUID_G(uuid, groupId);

		return remove(patientTypeMaster);
	}

	/**
	 * Returns the number of patient type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient type masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PATIENTTYPEMASTER_WHERE);

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
		"patientTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(patientTypeMaster.uuid IS NULL OR patientTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"patientTypeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator,
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

		List<PatientTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<PatientTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PatientTypeMaster patientTypeMaster : list) {
					if (!uuid.equals(patientTypeMaster.getUuid()) ||
						(companyId != patientTypeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PATIENTTYPEMASTER_WHERE);

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
				sb.append(PatientTypeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<PatientTypeMaster>)QueryUtil.list(
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
	 * Returns the first patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (patientTypeMaster != null) {
			return patientTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPatientTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		List<PatientTypeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (patientTypeMaster != null) {
			return patientTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPatientTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PatientTypeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient type masters before and after the current patient type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param patientTypeMasterId the primary key of the current patient type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	@Override
	public PatientTypeMaster[] findByUuid_C_PrevAndNext(
			long patientTypeMasterId, String uuid, long companyId,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		uuid = Objects.toString(uuid, "");

		PatientTypeMaster patientTypeMaster = findByPrimaryKey(
			patientTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			PatientTypeMaster[] array = new PatientTypeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, patientTypeMaster, uuid, companyId, orderByComparator,
				true);

			array[1] = patientTypeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, patientTypeMaster, uuid, companyId, orderByComparator,
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

	protected PatientTypeMaster getByUuid_C_PrevAndNext(
		Session session, PatientTypeMaster patientTypeMaster, String uuid,
		long companyId, OrderByComparator<PatientTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PATIENTTYPEMASTER_WHERE);

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
			sb.append(PatientTypeMasterModelImpl.ORDER_BY_JPQL);
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
						patientTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PatientTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PatientTypeMaster patientTypeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(patientTypeMaster);
		}
	}

	/**
	 * Returns the number of patient type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient type masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PATIENTTYPEMASTER_WHERE);

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
		"patientTypeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(patientTypeMaster.uuid IS NULL OR patientTypeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"patientTypeMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPatientTypeNameByLike;
	private FinderPath _finderPathWithPaginationCountByPatientTypeNameByLike;

	/**
	 * Returns all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @return the matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName) {

		return findByPatientTypeNameByLike(
			patientTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param patientTypeName the patient type name
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end) {

		return findByPatientTypeNameByLike(patientTypeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param patientTypeName the patient type name
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return findByPatientTypeNameByLike(
			patientTypeName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient type masters where patientTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param patientTypeName the patient type name
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findByPatientTypeNameByLike(
		String patientTypeName, int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator,
		boolean useFinderCache) {

		patientTypeName = Objects.toString(patientTypeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByPatientTypeNameByLike;
		finderArgs = new Object[] {
			patientTypeName, start, end, orderByComparator
		};

		List<PatientTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<PatientTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PatientTypeMaster patientTypeMaster : list) {
					if (!StringUtil.wildcardMatches(
							patientTypeMaster.getPatientTypeName(),
							patientTypeName, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_PATIENTTYPEMASTER_WHERE);

			boolean bindPatientTypeName = false;

			if (patientTypeName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PATIENTTYPENAMEBYLIKE_PATIENTTYPENAME_3);
			}
			else {
				bindPatientTypeName = true;

				sb.append(
					_FINDER_COLUMN_PATIENTTYPENAMEBYLIKE_PATIENTTYPENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PatientTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPatientTypeName) {
					queryPos.add(StringUtil.toLowerCase(patientTypeName));
				}

				list = (List<PatientTypeMaster>)QueryUtil.list(
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
	 * Returns the first patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster findByPatientTypeNameByLike_First(
			String patientTypeName,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster =
			fetchByPatientTypeNameByLike_First(
				patientTypeName, orderByComparator);

		if (patientTypeMaster != null) {
			return patientTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientTypeNameLIKE");
		sb.append(patientTypeName);

		sb.append("}");

		throw new NoSuchPatientTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster fetchByPatientTypeNameByLike_First(
		String patientTypeName,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		List<PatientTypeMaster> list = findByPatientTypeNameByLike(
			patientTypeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master
	 * @throws NoSuchPatientTypeMasterException if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster findByPatientTypeNameByLike_Last(
			String patientTypeName,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster = fetchByPatientTypeNameByLike_Last(
			patientTypeName, orderByComparator);

		if (patientTypeMaster != null) {
			return patientTypeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientTypeNameLIKE");
		sb.append(patientTypeName);

		sb.append("}");

		throw new NoSuchPatientTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type master, or <code>null</code> if a matching patient type master could not be found
	 */
	@Override
	public PatientTypeMaster fetchByPatientTypeNameByLike_Last(
		String patientTypeName,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		int count = countByPatientTypeNameByLike(patientTypeName);

		if (count == 0) {
			return null;
		}

		List<PatientTypeMaster> list = findByPatientTypeNameByLike(
			patientTypeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient type masters before and after the current patient type master in the ordered set where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeMasterId the primary key of the current patient type master
	 * @param patientTypeName the patient type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	@Override
	public PatientTypeMaster[] findByPatientTypeNameByLike_PrevAndNext(
			long patientTypeMasterId, String patientTypeName,
			OrderByComparator<PatientTypeMaster> orderByComparator)
		throws NoSuchPatientTypeMasterException {

		patientTypeName = Objects.toString(patientTypeName, "");

		PatientTypeMaster patientTypeMaster = findByPrimaryKey(
			patientTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			PatientTypeMaster[] array = new PatientTypeMasterImpl[3];

			array[0] = getByPatientTypeNameByLike_PrevAndNext(
				session, patientTypeMaster, patientTypeName, orderByComparator,
				true);

			array[1] = patientTypeMaster;

			array[2] = getByPatientTypeNameByLike_PrevAndNext(
				session, patientTypeMaster, patientTypeName, orderByComparator,
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

	protected PatientTypeMaster getByPatientTypeNameByLike_PrevAndNext(
		Session session, PatientTypeMaster patientTypeMaster,
		String patientTypeName,
		OrderByComparator<PatientTypeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_PATIENTTYPEMASTER_WHERE);

		boolean bindPatientTypeName = false;

		if (patientTypeName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PATIENTTYPENAMEBYLIKE_PATIENTTYPENAME_3);
		}
		else {
			bindPatientTypeName = true;

			sb.append(_FINDER_COLUMN_PATIENTTYPENAMEBYLIKE_PATIENTTYPENAME_2);
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
			sb.append(PatientTypeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPatientTypeName) {
			queryPos.add(StringUtil.toLowerCase(patientTypeName));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						patientTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PatientTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient type masters where patientTypeName LIKE &#63; from the database.
	 *
	 * @param patientTypeName the patient type name
	 */
	@Override
	public void removeByPatientTypeNameByLike(String patientTypeName) {
		for (PatientTypeMaster patientTypeMaster :
				findByPatientTypeNameByLike(
					patientTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(patientTypeMaster);
		}
	}

	/**
	 * Returns the number of patient type masters where patientTypeName LIKE &#63;.
	 *
	 * @param patientTypeName the patient type name
	 * @return the number of matching patient type masters
	 */
	@Override
	public int countByPatientTypeNameByLike(String patientTypeName) {
		patientTypeName = Objects.toString(patientTypeName, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByPatientTypeNameByLike;

		Object[] finderArgs = new Object[] {patientTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENTTYPEMASTER_WHERE);

			boolean bindPatientTypeName = false;

			if (patientTypeName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PATIENTTYPENAMEBYLIKE_PATIENTTYPENAME_3);
			}
			else {
				bindPatientTypeName = true;

				sb.append(
					_FINDER_COLUMN_PATIENTTYPENAMEBYLIKE_PATIENTTYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPatientTypeName) {
					queryPos.add(StringUtil.toLowerCase(patientTypeName));
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
		_FINDER_COLUMN_PATIENTTYPENAMEBYLIKE_PATIENTTYPENAME_2 =
			"lower(patientTypeMaster.patientTypeName) LIKE ?";

	private static final String
		_FINDER_COLUMN_PATIENTTYPENAMEBYLIKE_PATIENTTYPENAME_3 =
			"(patientTypeMaster.patientTypeName IS NULL OR patientTypeMaster.patientTypeName LIKE '')";

	public PatientTypeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("patientTypeMasterId", "patient_type_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("patientTypeName", "patient_type_name");

		setDBColumnNames(dbColumnNames);

		setModelClass(PatientTypeMaster.class);

		setModelImplClass(PatientTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(PatientTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the patient type master in the entity cache if it is enabled.
	 *
	 * @param patientTypeMaster the patient type master
	 */
	@Override
	public void cacheResult(PatientTypeMaster patientTypeMaster) {
		entityCache.putResult(
			PatientTypeMasterImpl.class, patientTypeMaster.getPrimaryKey(),
			patientTypeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				patientTypeMaster.getUuid(), patientTypeMaster.getGroupId()
			},
			patientTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the patient type masters in the entity cache if it is enabled.
	 *
	 * @param patientTypeMasters the patient type masters
	 */
	@Override
	public void cacheResult(List<PatientTypeMaster> patientTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (patientTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PatientTypeMaster patientTypeMaster : patientTypeMasters) {
			if (entityCache.getResult(
					PatientTypeMasterImpl.class,
					patientTypeMaster.getPrimaryKey()) == null) {

				cacheResult(patientTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all patient type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PatientTypeMasterImpl.class);

		finderCache.clearCache(PatientTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the patient type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PatientTypeMaster patientTypeMaster) {
		entityCache.removeResult(
			PatientTypeMasterImpl.class, patientTypeMaster);
	}

	@Override
	public void clearCache(List<PatientTypeMaster> patientTypeMasters) {
		for (PatientTypeMaster patientTypeMaster : patientTypeMasters) {
			entityCache.removeResult(
				PatientTypeMasterImpl.class, patientTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PatientTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PatientTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PatientTypeMasterModelImpl patientTypeMasterModelImpl) {

		Object[] args = new Object[] {
			patientTypeMasterModelImpl.getUuid(),
			patientTypeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, patientTypeMasterModelImpl);
	}

	/**
	 * Creates a new patient type master with the primary key. Does not add the patient type master to the database.
	 *
	 * @param patientTypeMasterId the primary key for the new patient type master
	 * @return the new patient type master
	 */
	@Override
	public PatientTypeMaster create(long patientTypeMasterId) {
		PatientTypeMaster patientTypeMaster = new PatientTypeMasterImpl();

		patientTypeMaster.setNew(true);
		patientTypeMaster.setPrimaryKey(patientTypeMasterId);

		String uuid = _portalUUID.generate();

		patientTypeMaster.setUuid(uuid);

		patientTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return patientTypeMaster;
	}

	/**
	 * Removes the patient type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master that was removed
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	@Override
	public PatientTypeMaster remove(long patientTypeMasterId)
		throws NoSuchPatientTypeMasterException {

		return remove((Serializable)patientTypeMasterId);
	}

	/**
	 * Removes the patient type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patient type master
	 * @return the patient type master that was removed
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	@Override
	public PatientTypeMaster remove(Serializable primaryKey)
		throws NoSuchPatientTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			PatientTypeMaster patientTypeMaster =
				(PatientTypeMaster)session.get(
					PatientTypeMasterImpl.class, primaryKey);

			if (patientTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPatientTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(patientTypeMaster);
		}
		catch (NoSuchPatientTypeMasterException noSuchEntityException) {
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
	protected PatientTypeMaster removeImpl(
		PatientTypeMaster patientTypeMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patientTypeMaster)) {
				patientTypeMaster = (PatientTypeMaster)session.get(
					PatientTypeMasterImpl.class,
					patientTypeMaster.getPrimaryKeyObj());
			}

			if (patientTypeMaster != null) {
				session.delete(patientTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (patientTypeMaster != null) {
			clearCache(patientTypeMaster);
		}

		return patientTypeMaster;
	}

	@Override
	public PatientTypeMaster updateImpl(PatientTypeMaster patientTypeMaster) {
		boolean isNew = patientTypeMaster.isNew();

		if (!(patientTypeMaster instanceof PatientTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(patientTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					patientTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in patientTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PatientTypeMaster implementation " +
					patientTypeMaster.getClass());
		}

		PatientTypeMasterModelImpl patientTypeMasterModelImpl =
			(PatientTypeMasterModelImpl)patientTypeMaster;

		if (Validator.isNull(patientTypeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			patientTypeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (patientTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				patientTypeMaster.setCreateDate(date);
			}
			else {
				patientTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!patientTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				patientTypeMaster.setModifiedDate(date);
			}
			else {
				patientTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(patientTypeMaster);
			}
			else {
				patientTypeMaster = (PatientTypeMaster)session.merge(
					patientTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PatientTypeMasterImpl.class, patientTypeMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(patientTypeMasterModelImpl);

		if (isNew) {
			patientTypeMaster.setNew(false);
		}

		patientTypeMaster.resetOriginalValues();

		return patientTypeMaster;
	}

	/**
	 * Returns the patient type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient type master
	 * @return the patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	@Override
	public PatientTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPatientTypeMasterException {

		PatientTypeMaster patientTypeMaster = fetchByPrimaryKey(primaryKey);

		if (patientTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPatientTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return patientTypeMaster;
	}

	/**
	 * Returns the patient type master with the primary key or throws a <code>NoSuchPatientTypeMasterException</code> if it could not be found.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master
	 * @throws NoSuchPatientTypeMasterException if a patient type master with the primary key could not be found
	 */
	@Override
	public PatientTypeMaster findByPrimaryKey(long patientTypeMasterId)
		throws NoSuchPatientTypeMasterException {

		return findByPrimaryKey((Serializable)patientTypeMasterId);
	}

	/**
	 * Returns the patient type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientTypeMasterId the primary key of the patient type master
	 * @return the patient type master, or <code>null</code> if a patient type master with the primary key could not be found
	 */
	@Override
	public PatientTypeMaster fetchByPrimaryKey(long patientTypeMasterId) {
		return fetchByPrimaryKey((Serializable)patientTypeMasterId);
	}

	/**
	 * Returns all the patient type masters.
	 *
	 * @return the patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @return the range of patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findAll(
		int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type masters
	 * @param end the upper bound of the range of patient type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of patient type masters
	 */
	@Override
	public List<PatientTypeMaster> findAll(
		int start, int end,
		OrderByComparator<PatientTypeMaster> orderByComparator,
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

		List<PatientTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<PatientTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PATIENTTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PATIENTTYPEMASTER;

				sql = sql.concat(PatientTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PatientTypeMaster>)QueryUtil.list(
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
	 * Removes all the patient type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PatientTypeMaster patientTypeMaster : findAll()) {
			remove(patientTypeMaster);
		}
	}

	/**
	 * Returns the number of patient type masters.
	 *
	 * @return the number of patient type masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PATIENTTYPEMASTER);

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
		return "patient_type_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PATIENTTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PatientTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the patient type master persistence.
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

		_finderPathWithPaginationFindByPatientTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPatientTypeNameByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"patient_type_name"}, true);

		_finderPathWithPaginationCountByPatientTypeNameByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByPatientTypeNameByLike",
			new String[] {String.class.getName()},
			new String[] {"patient_type_name"}, false);

		_setPatientTypeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPatientTypeMasterUtilPersistence(null);

		entityCache.removeCache(PatientTypeMasterImpl.class.getName());
	}

	private void _setPatientTypeMasterUtilPersistence(
		PatientTypeMasterPersistence patientTypeMasterPersistence) {

		try {
			Field field = PatientTypeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, patientTypeMasterPersistence);
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

	private static final String _SQL_SELECT_PATIENTTYPEMASTER =
		"SELECT patientTypeMaster FROM PatientTypeMaster patientTypeMaster";

	private static final String _SQL_SELECT_PATIENTTYPEMASTER_WHERE =
		"SELECT patientTypeMaster FROM PatientTypeMaster patientTypeMaster WHERE ";

	private static final String _SQL_COUNT_PATIENTTYPEMASTER =
		"SELECT COUNT(patientTypeMaster) FROM PatientTypeMaster patientTypeMaster";

	private static final String _SQL_COUNT_PATIENTTYPEMASTER_WHERE =
		"SELECT COUNT(patientTypeMaster) FROM PatientTypeMaster patientTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "patientTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PatientTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PatientTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PatientTypeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "patientTypeMasterId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy", "patientTypeName"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
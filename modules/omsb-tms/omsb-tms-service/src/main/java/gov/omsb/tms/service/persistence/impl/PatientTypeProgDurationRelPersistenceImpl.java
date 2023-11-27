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

import gov.omsb.tms.exception.NoSuchPatientTypeProgDurationRelException;
import gov.omsb.tms.model.PatientTypeProgDurationRel;
import gov.omsb.tms.model.PatientTypeProgDurationRelTable;
import gov.omsb.tms.model.impl.PatientTypeProgDurationRelImpl;
import gov.omsb.tms.model.impl.PatientTypeProgDurationRelModelImpl;
import gov.omsb.tms.service.persistence.PatientTypeProgDurationRelPersistence;
import gov.omsb.tms.service.persistence.PatientTypeProgDurationRelUtil;
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
 * The persistence implementation for the patient type prog duration rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PatientTypeProgDurationRelPersistence.class)
public class PatientTypeProgDurationRelPersistenceImpl
	extends BasePersistenceImpl<PatientTypeProgDurationRel>
	implements PatientTypeProgDurationRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PatientTypeProgDurationRelUtil</code> to access the patient type prog duration rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PatientTypeProgDurationRelImpl.class.getName();

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
	 * Returns all the patient type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
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

		List<PatientTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<PatientTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PatientTypeProgDurationRel patientTypeProgDurationRel :
						list) {

					if (!uuid.equals(patientTypeProgDurationRel.getUuid())) {
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

			sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
				sb.append(PatientTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<PatientTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByUuid_First(
			String uuid,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (patientTypeProgDurationRel != null) {
			return patientTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPatientTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		List<PatientTypeProgDurationRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (patientTypeProgDurationRel != null) {
			return patientTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPatientTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PatientTypeProgDurationRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient type prog duration rels before and after the current patient type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the current patient type prog duration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public PatientTypeProgDurationRel[] findByUuid_PrevAndNext(
			long PatientTypeProgDurationRelId, String uuid,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		uuid = Objects.toString(uuid, "");

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			findByPrimaryKey(PatientTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			PatientTypeProgDurationRel[] array =
				new PatientTypeProgDurationRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, patientTypeProgDurationRel, uuid, orderByComparator,
				true);

			array[1] = patientTypeProgDurationRel;

			array[2] = getByUuid_PrevAndNext(
				session, patientTypeProgDurationRel, uuid, orderByComparator,
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

	protected PatientTypeProgDurationRel getByUuid_PrevAndNext(
		Session session, PatientTypeProgDurationRel patientTypeProgDurationRel,
		String uuid,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
			sb.append(PatientTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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
						patientTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PatientTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient type prog duration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PatientTypeProgDurationRel patientTypeProgDurationRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(patientTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of patient type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient type prog duration rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
		"patientTypeProgDurationRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(patientTypeProgDurationRel.uuid IS NULL OR patientTypeProgDurationRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the patient type prog duration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPatientTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByUUID_G(String uuid, long groupId)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel = fetchByUUID_G(
			uuid, groupId);

		if (patientTypeProgDurationRel == null) {
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

			throw new NoSuchPatientTypeProgDurationRelException(sb.toString());
		}

		return patientTypeProgDurationRel;
	}

	/**
	 * Returns the patient type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the patient type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByUUID_G(
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

		if (result instanceof PatientTypeProgDurationRel) {
			PatientTypeProgDurationRel patientTypeProgDurationRel =
				(PatientTypeProgDurationRel)result;

			if (!Objects.equals(uuid, patientTypeProgDurationRel.getUuid()) ||
				(groupId != patientTypeProgDurationRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE);

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

				List<PatientTypeProgDurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PatientTypeProgDurationRel patientTypeProgDurationRel =
						list.get(0);

					result = patientTypeProgDurationRel;

					cacheResult(patientTypeProgDurationRel);
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
			return (PatientTypeProgDurationRel)result;
		}
	}

	/**
	 * Removes the patient type prog duration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient type prog duration rel that was removed
	 */
	@Override
	public PatientTypeProgDurationRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel = findByUUID_G(
			uuid, groupId);

		return remove(patientTypeProgDurationRel);
	}

	/**
	 * Returns the number of patient type prog duration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient type prog duration rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
		"patientTypeProgDurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(patientTypeProgDurationRel.uuid IS NULL OR patientTypeProgDurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"patientTypeProgDurationRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
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

		List<PatientTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<PatientTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PatientTypeProgDurationRel patientTypeProgDurationRel :
						list) {

					if (!uuid.equals(patientTypeProgDurationRel.getUuid()) ||
						(companyId !=
							patientTypeProgDurationRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
				sb.append(PatientTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<PatientTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (patientTypeProgDurationRel != null) {
			return patientTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPatientTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		List<PatientTypeProgDurationRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (patientTypeProgDurationRel != null) {
			return patientTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPatientTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PatientTypeProgDurationRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient type prog duration rels before and after the current patient type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the current patient type prog duration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public PatientTypeProgDurationRel[] findByUuid_C_PrevAndNext(
			long PatientTypeProgDurationRelId, String uuid, long companyId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		uuid = Objects.toString(uuid, "");

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			findByPrimaryKey(PatientTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			PatientTypeProgDurationRel[] array =
				new PatientTypeProgDurationRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, patientTypeProgDurationRel, uuid, companyId,
				orderByComparator, true);

			array[1] = patientTypeProgDurationRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, patientTypeProgDurationRel, uuid, companyId,
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

	protected PatientTypeProgDurationRel getByUuid_C_PrevAndNext(
		Session session, PatientTypeProgDurationRel patientTypeProgDurationRel,
		String uuid, long companyId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
			sb.append(PatientTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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
						patientTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PatientTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient type prog duration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PatientTypeProgDurationRel patientTypeProgDurationRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(patientTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of patient type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient type prog duration rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
		"patientTypeProgDurationRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(patientTypeProgDurationRel.uuid IS NULL OR patientTypeProgDurationRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"patientTypeProgDurationRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the patient type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
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

		List<PatientTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<PatientTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PatientTypeProgDurationRel patientTypeProgDurationRel :
						list) {

					if (programDurationId !=
							patientTypeProgDurationRel.getProgramDurationId()) {

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

			sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PatientTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				list = (List<PatientTypeProgDurationRel>)QueryUtil.list(
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
	 * Returns the first patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			fetchByProgramDurationId_First(
				programDurationId, orderByComparator);

		if (patientTypeProgDurationRel != null) {
			return patientTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchPatientTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the first patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		List<PatientTypeProgDurationRel> list = findByProgramDurationId(
			programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			fetchByProgramDurationId_Last(programDurationId, orderByComparator);

		if (patientTypeProgDurationRel != null) {
			return patientTypeProgDurationRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchPatientTypeProgDurationRelException(sb.toString());
	}

	/**
	 * Returns the last patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<PatientTypeProgDurationRel> list = findByProgramDurationId(
			programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient type prog duration rels before and after the current patient type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the current patient type prog duration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public PatientTypeProgDurationRel[] findByProgramDurationId_PrevAndNext(
			long PatientTypeProgDurationRelId, long programDurationId,
			OrderByComparator<PatientTypeProgDurationRel> orderByComparator)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			findByPrimaryKey(PatientTypeProgDurationRelId);

		Session session = null;

		try {
			session = openSession();

			PatientTypeProgDurationRel[] array =
				new PatientTypeProgDurationRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, patientTypeProgDurationRel, programDurationId,
				orderByComparator, true);

			array[1] = patientTypeProgDurationRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, patientTypeProgDurationRel, programDurationId,
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

	protected PatientTypeProgDurationRel getByProgramDurationId_PrevAndNext(
		Session session, PatientTypeProgDurationRel patientTypeProgDurationRel,
		long programDurationId,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
			sb.append(PatientTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
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
						patientTypeProgDurationRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PatientTypeProgDurationRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient type prog duration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (PatientTypeProgDurationRel patientTypeProgDurationRel :
				findByProgramDurationId(
					programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(patientTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of patient type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching patient type prog duration rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENTTYPEPROGDURATIONREL_WHERE);

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
			"patientTypeProgDurationRel.programDurationId = ?";

	private FinderPath
		_finderPathFetchByProgramDurationIdAndPatientTypeMasterId;
	private FinderPath
		_finderPathCountByProgramDurationIdAndPatientTypeMasterId;

	/**
	 * Returns the patient type prog duration rel where programDurationId = &#63; and patientTypeMasterId = &#63; or throws a <code>NoSuchPatientTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @return the matching patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel
			findByProgramDurationIdAndPatientTypeMasterId(
				long programDurationId, long patientTypeMasterId)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			fetchByProgramDurationIdAndPatientTypeMasterId(
				programDurationId, patientTypeMasterId);

		if (patientTypeProgDurationRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programDurationId=");
			sb.append(programDurationId);

			sb.append(", patientTypeMasterId=");
			sb.append(patientTypeMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPatientTypeProgDurationRelException(sb.toString());
		}

		return patientTypeProgDurationRel;
	}

	/**
	 * Returns the patient type prog duration rel where programDurationId = &#63; and patientTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel
		fetchByProgramDurationIdAndPatientTypeMasterId(
			long programDurationId, long patientTypeMasterId) {

		return fetchByProgramDurationIdAndPatientTypeMasterId(
			programDurationId, patientTypeMasterId, true);
	}

	/**
	 * Returns the patient type prog duration rel where programDurationId = &#63; and patientTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient type prog duration rel, or <code>null</code> if a matching patient type prog duration rel could not be found
	 */
	@Override
	public PatientTypeProgDurationRel
		fetchByProgramDurationIdAndPatientTypeMasterId(
			long programDurationId, long patientTypeMasterId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programDurationId, patientTypeMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramDurationIdAndPatientTypeMasterId,
				finderArgs, this);
		}

		if (result instanceof PatientTypeProgDurationRel) {
			PatientTypeProgDurationRel patientTypeProgDurationRel =
				(PatientTypeProgDurationRel)result;

			if ((programDurationId !=
					patientTypeProgDurationRel.getProgramDurationId()) ||
				(patientTypeMasterId !=
					patientTypeProgDurationRel.getPatientTypeMasterId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPATIENTTYPEMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPATIENTTYPEMASTERID_PATIENTTYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(patientTypeMasterId);

				List<PatientTypeProgDurationRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramDurationIdAndPatientTypeMasterId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programDurationId, patientTypeMasterId
								};
							}

							_log.warn(
								"PatientTypeProgDurationRelPersistenceImpl.fetchByProgramDurationIdAndPatientTypeMasterId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PatientTypeProgDurationRel patientTypeProgDurationRel =
						list.get(0);

					result = patientTypeProgDurationRel;

					cacheResult(patientTypeProgDurationRel);
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
			return (PatientTypeProgDurationRel)result;
		}
	}

	/**
	 * Removes the patient type prog duration rel where programDurationId = &#63; and patientTypeMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @return the patient type prog duration rel that was removed
	 */
	@Override
	public PatientTypeProgDurationRel
			removeByProgramDurationIdAndPatientTypeMasterId(
				long programDurationId, long patientTypeMasterId)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			findByProgramDurationIdAndPatientTypeMasterId(
				programDurationId, patientTypeMasterId);

		return remove(patientTypeProgDurationRel);
	}

	/**
	 * Returns the number of patient type prog duration rels where programDurationId = &#63; and patientTypeMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param patientTypeMasterId the patient type master ID
	 * @return the number of matching patient type prog duration rels
	 */
	@Override
	public int countByProgramDurationIdAndPatientTypeMasterId(
		long programDurationId, long patientTypeMasterId) {

		FinderPath finderPath =
			_finderPathCountByProgramDurationIdAndPatientTypeMasterId;

		Object[] finderArgs = new Object[] {
			programDurationId, patientTypeMasterId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PATIENTTYPEPROGDURATIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPATIENTTYPEMASTERID_PROGRAMDURATIONID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMDURATIONIDANDPATIENTTYPEMASTERID_PATIENTTYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				queryPos.add(patientTypeMasterId);

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
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPATIENTTYPEMASTERID_PROGRAMDURATIONID_2 =
			"patientTypeProgDurationRel.programDurationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMDURATIONIDANDPATIENTTYPEMASTERID_PATIENTTYPEMASTERID_2 =
			"patientTypeProgDurationRel.patientTypeMasterId = ?";

	public PatientTypeProgDurationRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"PatientTypeProgDurationRelId",
			"patient_type_prog_duration_rel_id");
		dbColumnNames.put("patientTypeMasterId", "patient_type_master_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(PatientTypeProgDurationRel.class);

		setModelImplClass(PatientTypeProgDurationRelImpl.class);
		setModelPKClass(long.class);

		setTable(PatientTypeProgDurationRelTable.INSTANCE);
	}

	/**
	 * Caches the patient type prog duration rel in the entity cache if it is enabled.
	 *
	 * @param patientTypeProgDurationRel the patient type prog duration rel
	 */
	@Override
	public void cacheResult(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		entityCache.putResult(
			PatientTypeProgDurationRelImpl.class,
			patientTypeProgDurationRel.getPrimaryKey(),
			patientTypeProgDurationRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				patientTypeProgDurationRel.getUuid(),
				patientTypeProgDurationRel.getGroupId()
			},
			patientTypeProgDurationRel);

		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndPatientTypeMasterId,
			new Object[] {
				patientTypeProgDurationRel.getProgramDurationId(),
				patientTypeProgDurationRel.getPatientTypeMasterId()
			},
			patientTypeProgDurationRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the patient type prog duration rels in the entity cache if it is enabled.
	 *
	 * @param patientTypeProgDurationRels the patient type prog duration rels
	 */
	@Override
	public void cacheResult(
		List<PatientTypeProgDurationRel> patientTypeProgDurationRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (patientTypeProgDurationRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PatientTypeProgDurationRel patientTypeProgDurationRel :
				patientTypeProgDurationRels) {

			if (entityCache.getResult(
					PatientTypeProgDurationRelImpl.class,
					patientTypeProgDurationRel.getPrimaryKey()) == null) {

				cacheResult(patientTypeProgDurationRel);
			}
		}
	}

	/**
	 * Clears the cache for all patient type prog duration rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PatientTypeProgDurationRelImpl.class);

		finderCache.clearCache(PatientTypeProgDurationRelImpl.class);
	}

	/**
	 * Clears the cache for the patient type prog duration rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		entityCache.removeResult(
			PatientTypeProgDurationRelImpl.class, patientTypeProgDurationRel);
	}

	@Override
	public void clearCache(
		List<PatientTypeProgDurationRel> patientTypeProgDurationRels) {

		for (PatientTypeProgDurationRel patientTypeProgDurationRel :
				patientTypeProgDurationRels) {

			entityCache.removeResult(
				PatientTypeProgDurationRelImpl.class,
				patientTypeProgDurationRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PatientTypeProgDurationRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				PatientTypeProgDurationRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PatientTypeProgDurationRelModelImpl
			patientTypeProgDurationRelModelImpl) {

		Object[] args = new Object[] {
			patientTypeProgDurationRelModelImpl.getUuid(),
			patientTypeProgDurationRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			patientTypeProgDurationRelModelImpl);

		args = new Object[] {
			patientTypeProgDurationRelModelImpl.getProgramDurationId(),
			patientTypeProgDurationRelModelImpl.getPatientTypeMasterId()
		};

		finderCache.putResult(
			_finderPathCountByProgramDurationIdAndPatientTypeMasterId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramDurationIdAndPatientTypeMasterId, args,
			patientTypeProgDurationRelModelImpl);
	}

	/**
	 * Creates a new patient type prog duration rel with the primary key. Does not add the patient type prog duration rel to the database.
	 *
	 * @param PatientTypeProgDurationRelId the primary key for the new patient type prog duration rel
	 * @return the new patient type prog duration rel
	 */
	@Override
	public PatientTypeProgDurationRel create(
		long PatientTypeProgDurationRelId) {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			new PatientTypeProgDurationRelImpl();

		patientTypeProgDurationRel.setNew(true);
		patientTypeProgDurationRel.setPrimaryKey(PatientTypeProgDurationRelId);

		String uuid = _portalUUID.generate();

		patientTypeProgDurationRel.setUuid(uuid);

		patientTypeProgDurationRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return patientTypeProgDurationRel;
	}

	/**
	 * Removes the patient type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel that was removed
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public PatientTypeProgDurationRel remove(long PatientTypeProgDurationRelId)
		throws NoSuchPatientTypeProgDurationRelException {

		return remove((Serializable)PatientTypeProgDurationRelId);
	}

	/**
	 * Removes the patient type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel that was removed
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public PatientTypeProgDurationRel remove(Serializable primaryKey)
		throws NoSuchPatientTypeProgDurationRelException {

		Session session = null;

		try {
			session = openSession();

			PatientTypeProgDurationRel patientTypeProgDurationRel =
				(PatientTypeProgDurationRel)session.get(
					PatientTypeProgDurationRelImpl.class, primaryKey);

			if (patientTypeProgDurationRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPatientTypeProgDurationRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(patientTypeProgDurationRel);
		}
		catch (NoSuchPatientTypeProgDurationRelException
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
	protected PatientTypeProgDurationRel removeImpl(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patientTypeProgDurationRel)) {
				patientTypeProgDurationRel =
					(PatientTypeProgDurationRel)session.get(
						PatientTypeProgDurationRelImpl.class,
						patientTypeProgDurationRel.getPrimaryKeyObj());
			}

			if (patientTypeProgDurationRel != null) {
				session.delete(patientTypeProgDurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (patientTypeProgDurationRel != null) {
			clearCache(patientTypeProgDurationRel);
		}

		return patientTypeProgDurationRel;
	}

	@Override
	public PatientTypeProgDurationRel updateImpl(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		boolean isNew = patientTypeProgDurationRel.isNew();

		if (!(patientTypeProgDurationRel instanceof
				PatientTypeProgDurationRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(patientTypeProgDurationRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					patientTypeProgDurationRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in patientTypeProgDurationRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PatientTypeProgDurationRel implementation " +
					patientTypeProgDurationRel.getClass());
		}

		PatientTypeProgDurationRelModelImpl
			patientTypeProgDurationRelModelImpl =
				(PatientTypeProgDurationRelModelImpl)patientTypeProgDurationRel;

		if (Validator.isNull(patientTypeProgDurationRel.getUuid())) {
			String uuid = _portalUUID.generate();

			patientTypeProgDurationRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (patientTypeProgDurationRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				patientTypeProgDurationRel.setCreateDate(date);
			}
			else {
				patientTypeProgDurationRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!patientTypeProgDurationRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				patientTypeProgDurationRel.setModifiedDate(date);
			}
			else {
				patientTypeProgDurationRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(patientTypeProgDurationRel);
			}
			else {
				patientTypeProgDurationRel =
					(PatientTypeProgDurationRel)session.merge(
						patientTypeProgDurationRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PatientTypeProgDurationRelImpl.class,
			patientTypeProgDurationRelModelImpl, false, true);

		cacheUniqueFindersCache(patientTypeProgDurationRelModelImpl);

		if (isNew) {
			patientTypeProgDurationRel.setNew(false);
		}

		patientTypeProgDurationRel.resetOriginalValues();

		return patientTypeProgDurationRel;
	}

	/**
	 * Returns the patient type prog duration rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPatientTypeProgDurationRelException {

		PatientTypeProgDurationRel patientTypeProgDurationRel =
			fetchByPrimaryKey(primaryKey);

		if (patientTypeProgDurationRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPatientTypeProgDurationRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return patientTypeProgDurationRel;
	}

	/**
	 * Returns the patient type prog duration rel with the primary key or throws a <code>NoSuchPatientTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel
	 * @throws NoSuchPatientTypeProgDurationRelException if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public PatientTypeProgDurationRel findByPrimaryKey(
			long PatientTypeProgDurationRelId)
		throws NoSuchPatientTypeProgDurationRelException {

		return findByPrimaryKey((Serializable)PatientTypeProgDurationRelId);
	}

	/**
	 * Returns the patient type prog duration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PatientTypeProgDurationRelId the primary key of the patient type prog duration rel
	 * @return the patient type prog duration rel, or <code>null</code> if a patient type prog duration rel with the primary key could not be found
	 */
	@Override
	public PatientTypeProgDurationRel fetchByPrimaryKey(
		long PatientTypeProgDurationRelId) {

		return fetchByPrimaryKey((Serializable)PatientTypeProgDurationRelId);
	}

	/**
	 * Returns all the patient type prog duration rels.
	 *
	 * @return the patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @return the range of patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient type prog duration rels
	 * @param end the upper bound of the range of patient type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of patient type prog duration rels
	 */
	@Override
	public List<PatientTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<PatientTypeProgDurationRel> orderByComparator,
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

		List<PatientTypeProgDurationRel> list = null;

		if (useFinderCache) {
			list = (List<PatientTypeProgDurationRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PATIENTTYPEPROGDURATIONREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PATIENTTYPEPROGDURATIONREL;

				sql = sql.concat(
					PatientTypeProgDurationRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PatientTypeProgDurationRel>)QueryUtil.list(
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
	 * Removes all the patient type prog duration rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PatientTypeProgDurationRel patientTypeProgDurationRel :
				findAll()) {

			remove(patientTypeProgDurationRel);
		}
	}

	/**
	 * Returns the number of patient type prog duration rels.
	 *
	 * @return the number of patient type prog duration rels
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
					_SQL_COUNT_PATIENTTYPEPROGDURATIONREL);

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
		return "patient_type_prog_duration_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PATIENTTYPEPROGDURATIONREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PatientTypeProgDurationRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the patient type prog duration rel persistence.
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

		_finderPathFetchByProgramDurationIdAndPatientTypeMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgramDurationIdAndPatientTypeMasterId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"program_duration_id", "patient_type_master_id"},
				true);

		_finderPathCountByProgramDurationIdAndPatientTypeMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgramDurationIdAndPatientTypeMasterId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"program_duration_id", "patient_type_master_id"},
				false);

		_setPatientTypeProgDurationRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPatientTypeProgDurationRelUtilPersistence(null);

		entityCache.removeCache(PatientTypeProgDurationRelImpl.class.getName());
	}

	private void _setPatientTypeProgDurationRelUtilPersistence(
		PatientTypeProgDurationRelPersistence
			patientTypeProgDurationRelPersistence) {

		try {
			Field field = PatientTypeProgDurationRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, patientTypeProgDurationRelPersistence);
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

	private static final String _SQL_SELECT_PATIENTTYPEPROGDURATIONREL =
		"SELECT patientTypeProgDurationRel FROM PatientTypeProgDurationRel patientTypeProgDurationRel";

	private static final String _SQL_SELECT_PATIENTTYPEPROGDURATIONREL_WHERE =
		"SELECT patientTypeProgDurationRel FROM PatientTypeProgDurationRel patientTypeProgDurationRel WHERE ";

	private static final String _SQL_COUNT_PATIENTTYPEPROGDURATIONREL =
		"SELECT COUNT(patientTypeProgDurationRel) FROM PatientTypeProgDurationRel patientTypeProgDurationRel";

	private static final String _SQL_COUNT_PATIENTTYPEPROGDURATIONREL_WHERE =
		"SELECT COUNT(patientTypeProgDurationRel) FROM PatientTypeProgDurationRel patientTypeProgDurationRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"patientTypeProgDurationRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PatientTypeProgDurationRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PatientTypeProgDurationRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PatientTypeProgDurationRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "PatientTypeProgDurationRelId", "patientTypeMasterId",
			"programDurationId", "groupId", "companyId", "createDate",
			"createdBy", "modifiedDate", "modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
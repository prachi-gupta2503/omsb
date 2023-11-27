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

import gov.omsb.tms.exception.NoSuchEligibilityDegreeMasterException;
import gov.omsb.tms.model.EligibilityDegreeMaster;
import gov.omsb.tms.model.EligibilityDegreeMasterTable;
import gov.omsb.tms.model.impl.EligibilityDegreeMasterImpl;
import gov.omsb.tms.model.impl.EligibilityDegreeMasterModelImpl;
import gov.omsb.tms.service.persistence.EligibilityDegreeMasterPersistence;
import gov.omsb.tms.service.persistence.EligibilityDegreeMasterUtil;
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
 * The persistence implementation for the eligibility degree master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EligibilityDegreeMasterPersistence.class)
public class EligibilityDegreeMasterPersistenceImpl
	extends BasePersistenceImpl<EligibilityDegreeMaster>
	implements EligibilityDegreeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EligibilityDegreeMasterUtil</code> to access the eligibility degree master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EligibilityDegreeMasterImpl.class.getName();

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
	 * Returns all the eligibility degree masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
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

		List<EligibilityDegreeMaster> list = null;

		if (useFinderCache) {
			list = (List<EligibilityDegreeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EligibilityDegreeMaster eligibilityDegreeMaster : list) {
					if (!uuid.equals(eligibilityDegreeMaster.getUuid())) {
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

			sb.append(_SQL_SELECT_ELIGIBILITYDEGREEMASTER_WHERE);

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
				sb.append(EligibilityDegreeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<EligibilityDegreeMaster>)QueryUtil.list(
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
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByUuid_First(
			String uuid,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster = fetchByUuid_First(
			uuid, orderByComparator);

		if (eligibilityDegreeMaster != null) {
			return eligibilityDegreeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEligibilityDegreeMasterException(sb.toString());
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByUuid_First(
		String uuid,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		List<EligibilityDegreeMaster> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByUuid_Last(
			String uuid,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster = fetchByUuid_Last(
			uuid, orderByComparator);

		if (eligibilityDegreeMaster != null) {
			return eligibilityDegreeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEligibilityDegreeMasterException(sb.toString());
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByUuid_Last(
		String uuid,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EligibilityDegreeMaster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where uuid = &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public EligibilityDegreeMaster[] findByUuid_PrevAndNext(
			long eligibilityDegreeMasterId, String uuid,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		uuid = Objects.toString(uuid, "");

		EligibilityDegreeMaster eligibilityDegreeMaster = findByPrimaryKey(
			eligibilityDegreeMasterId);

		Session session = null;

		try {
			session = openSession();

			EligibilityDegreeMaster[] array =
				new EligibilityDegreeMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, eligibilityDegreeMaster, uuid, orderByComparator,
				true);

			array[1] = eligibilityDegreeMaster;

			array[2] = getByUuid_PrevAndNext(
				session, eligibilityDegreeMaster, uuid, orderByComparator,
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

	protected EligibilityDegreeMaster getByUuid_PrevAndNext(
		Session session, EligibilityDegreeMaster eligibilityDegreeMaster,
		String uuid,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_ELIGIBILITYDEGREEMASTER_WHERE);

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
			sb.append(EligibilityDegreeMasterModelImpl.ORDER_BY_JPQL);
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
						eligibilityDegreeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EligibilityDegreeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eligibility degree masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EligibilityDegreeMaster eligibilityDegreeMaster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(eligibilityDegreeMaster);
		}
	}

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching eligibility degree masters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELIGIBILITYDEGREEMASTER_WHERE);

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
		"eligibilityDegreeMaster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(eligibilityDegreeMaster.uuid IS NULL OR eligibilityDegreeMaster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEligibilityDegreeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster = fetchByUUID_G(
			uuid, groupId);

		if (eligibilityDegreeMaster == null) {
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

			throw new NoSuchEligibilityDegreeMasterException(sb.toString());
		}

		return eligibilityDegreeMaster;
	}

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the eligibility degree master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByUUID_G(
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

		if (result instanceof EligibilityDegreeMaster) {
			EligibilityDegreeMaster eligibilityDegreeMaster =
				(EligibilityDegreeMaster)result;

			if (!Objects.equals(uuid, eligibilityDegreeMaster.getUuid()) ||
				(groupId != eligibilityDegreeMaster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ELIGIBILITYDEGREEMASTER_WHERE);

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

				List<EligibilityDegreeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EligibilityDegreeMaster eligibilityDegreeMaster = list.get(
						0);

					result = eligibilityDegreeMaster;

					cacheResult(eligibilityDegreeMaster);
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
			return (EligibilityDegreeMaster)result;
		}
	}

	/**
	 * Removes the eligibility degree master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the eligibility degree master that was removed
	 */
	@Override
	public EligibilityDegreeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster = findByUUID_G(
			uuid, groupId);

		return remove(eligibilityDegreeMaster);
	}

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching eligibility degree masters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELIGIBILITYDEGREEMASTER_WHERE);

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
		"eligibilityDegreeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(eligibilityDegreeMaster.uuid IS NULL OR eligibilityDegreeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"eligibilityDegreeMaster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
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

		List<EligibilityDegreeMaster> list = null;

		if (useFinderCache) {
			list = (List<EligibilityDegreeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EligibilityDegreeMaster eligibilityDegreeMaster : list) {
					if (!uuid.equals(eligibilityDegreeMaster.getUuid()) ||
						(companyId != eligibilityDegreeMaster.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ELIGIBILITYDEGREEMASTER_WHERE);

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
				sb.append(EligibilityDegreeMasterModelImpl.ORDER_BY_JPQL);
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

				list = (List<EligibilityDegreeMaster>)QueryUtil.list(
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
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (eligibilityDegreeMaster != null) {
			return eligibilityDegreeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEligibilityDegreeMasterException(sb.toString());
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		List<EligibilityDegreeMaster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (eligibilityDegreeMaster != null) {
			return eligibilityDegreeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEligibilityDegreeMasterException(sb.toString());
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EligibilityDegreeMaster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public EligibilityDegreeMaster[] findByUuid_C_PrevAndNext(
			long eligibilityDegreeMasterId, String uuid, long companyId,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		uuid = Objects.toString(uuid, "");

		EligibilityDegreeMaster eligibilityDegreeMaster = findByPrimaryKey(
			eligibilityDegreeMasterId);

		Session session = null;

		try {
			session = openSession();

			EligibilityDegreeMaster[] array =
				new EligibilityDegreeMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, eligibilityDegreeMaster, uuid, companyId,
				orderByComparator, true);

			array[1] = eligibilityDegreeMaster;

			array[2] = getByUuid_C_PrevAndNext(
				session, eligibilityDegreeMaster, uuid, companyId,
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

	protected EligibilityDegreeMaster getByUuid_C_PrevAndNext(
		Session session, EligibilityDegreeMaster eligibilityDegreeMaster,
		String uuid, long companyId,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_ELIGIBILITYDEGREEMASTER_WHERE);

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
			sb.append(EligibilityDegreeMasterModelImpl.ORDER_BY_JPQL);
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
						eligibilityDegreeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EligibilityDegreeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eligibility degree masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EligibilityDegreeMaster eligibilityDegreeMaster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(eligibilityDegreeMaster);
		}
	}

	/**
	 * Returns the number of eligibility degree masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching eligibility degree masters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELIGIBILITYDEGREEMASTER_WHERE);

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
		"eligibilityDegreeMaster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(eligibilityDegreeMaster.uuid IS NULL OR eligibilityDegreeMaster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"eligibilityDegreeMaster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByeligibilityDegreeByLike;
	private FinderPath _finderPathWithPaginationCountByeligibilityDegreeByLike;

	/**
	 * Returns all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @return the matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String eligibilityDegree) {

		return findByeligibilityDegreeByLike(
			eligibilityDegree, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String eligibilityDegree, int start, int end) {

		return findByeligibilityDegreeByLike(
			eligibilityDegree, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String eligibilityDegree, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return findByeligibilityDegreeByLike(
			eligibilityDegree, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String eligibilityDegree, int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
		boolean useFinderCache) {

		eligibilityDegree = Objects.toString(eligibilityDegree, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByeligibilityDegreeByLike;
		finderArgs = new Object[] {
			eligibilityDegree, start, end, orderByComparator
		};

		List<EligibilityDegreeMaster> list = null;

		if (useFinderCache) {
			list = (List<EligibilityDegreeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EligibilityDegreeMaster eligibilityDegreeMaster : list) {
					if (!StringUtil.wildcardMatches(
							eligibilityDegreeMaster.getEligibilityDegree(),
							eligibilityDegree, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_ELIGIBILITYDEGREEMASTER_WHERE);

			boolean bindEligibilityDegree = false;

			if (eligibilityDegree.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ELIGIBILITYDEGREEBYLIKE_ELIGIBILITYDEGREE_3);
			}
			else {
				bindEligibilityDegree = true;

				sb.append(
					_FINDER_COLUMN_ELIGIBILITYDEGREEBYLIKE_ELIGIBILITYDEGREE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EligibilityDegreeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEligibilityDegree) {
					queryPos.add(StringUtil.toLowerCase(eligibilityDegree));
				}

				list = (List<EligibilityDegreeMaster>)QueryUtil.list(
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
	 * Returns the first eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByeligibilityDegreeByLike_First(
			String eligibilityDegree,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster =
			fetchByeligibilityDegreeByLike_First(
				eligibilityDegree, orderByComparator);

		if (eligibilityDegreeMaster != null) {
			return eligibilityDegreeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eligibilityDegreeLIKE");
		sb.append(eligibilityDegree);

		sb.append("}");

		throw new NoSuchEligibilityDegreeMasterException(sb.toString());
	}

	/**
	 * Returns the first eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByeligibilityDegreeByLike_First(
		String eligibilityDegree,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		List<EligibilityDegreeMaster> list = findByeligibilityDegreeByLike(
			eligibilityDegree, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByeligibilityDegreeByLike_Last(
			String eligibilityDegree,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster =
			fetchByeligibilityDegreeByLike_Last(
				eligibilityDegree, orderByComparator);

		if (eligibilityDegreeMaster != null) {
			return eligibilityDegreeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eligibilityDegreeLIKE");
		sb.append(eligibilityDegree);

		sb.append("}");

		throw new NoSuchEligibilityDegreeMasterException(sb.toString());
	}

	/**
	 * Returns the last eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByeligibilityDegreeByLike_Last(
		String eligibilityDegree,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		int count = countByeligibilityDegreeByLike(eligibilityDegree);

		if (count == 0) {
			return null;
		}

		List<EligibilityDegreeMaster> list = findByeligibilityDegreeByLike(
			eligibilityDegree, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eligibility degree masters before and after the current eligibility degree master in the ordered set where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the current eligibility degree master
	 * @param eligibilityDegree the eligibility degree
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public EligibilityDegreeMaster[] findByeligibilityDegreeByLike_PrevAndNext(
			long eligibilityDegreeMasterId, String eligibilityDegree,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator)
		throws NoSuchEligibilityDegreeMasterException {

		eligibilityDegree = Objects.toString(eligibilityDegree, "");

		EligibilityDegreeMaster eligibilityDegreeMaster = findByPrimaryKey(
			eligibilityDegreeMasterId);

		Session session = null;

		try {
			session = openSession();

			EligibilityDegreeMaster[] array =
				new EligibilityDegreeMasterImpl[3];

			array[0] = getByeligibilityDegreeByLike_PrevAndNext(
				session, eligibilityDegreeMaster, eligibilityDegree,
				orderByComparator, true);

			array[1] = eligibilityDegreeMaster;

			array[2] = getByeligibilityDegreeByLike_PrevAndNext(
				session, eligibilityDegreeMaster, eligibilityDegree,
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

	protected EligibilityDegreeMaster getByeligibilityDegreeByLike_PrevAndNext(
		Session session, EligibilityDegreeMaster eligibilityDegreeMaster,
		String eligibilityDegree,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_ELIGIBILITYDEGREEMASTER_WHERE);

		boolean bindEligibilityDegree = false;

		if (eligibilityDegree.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_ELIGIBILITYDEGREEBYLIKE_ELIGIBILITYDEGREE_3);
		}
		else {
			bindEligibilityDegree = true;

			sb.append(
				_FINDER_COLUMN_ELIGIBILITYDEGREEBYLIKE_ELIGIBILITYDEGREE_2);
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
			sb.append(EligibilityDegreeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEligibilityDegree) {
			queryPos.add(StringUtil.toLowerCase(eligibilityDegree));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						eligibilityDegreeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EligibilityDegreeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eligibility degree masters where eligibilityDegree LIKE &#63; from the database.
	 *
	 * @param eligibilityDegree the eligibility degree
	 */
	@Override
	public void removeByeligibilityDegreeByLike(String eligibilityDegree) {
		for (EligibilityDegreeMaster eligibilityDegreeMaster :
				findByeligibilityDegreeByLike(
					eligibilityDegree, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(eligibilityDegreeMaster);
		}
	}

	/**
	 * Returns the number of eligibility degree masters where eligibilityDegree LIKE &#63;.
	 *
	 * @param eligibilityDegree the eligibility degree
	 * @return the number of matching eligibility degree masters
	 */
	@Override
	public int countByeligibilityDegreeByLike(String eligibilityDegree) {
		eligibilityDegree = Objects.toString(eligibilityDegree, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByeligibilityDegreeByLike;

		Object[] finderArgs = new Object[] {eligibilityDegree};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELIGIBILITYDEGREEMASTER_WHERE);

			boolean bindEligibilityDegree = false;

			if (eligibilityDegree.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ELIGIBILITYDEGREEBYLIKE_ELIGIBILITYDEGREE_3);
			}
			else {
				bindEligibilityDegree = true;

				sb.append(
					_FINDER_COLUMN_ELIGIBILITYDEGREEBYLIKE_ELIGIBILITYDEGREE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEligibilityDegree) {
					queryPos.add(StringUtil.toLowerCase(eligibilityDegree));
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
		_FINDER_COLUMN_ELIGIBILITYDEGREEBYLIKE_ELIGIBILITYDEGREE_2 =
			"lower(eligibilityDegreeMaster.eligibilityDegree) LIKE ?";

	private static final String
		_FINDER_COLUMN_ELIGIBILITYDEGREEBYLIKE_ELIGIBILITYDEGREE_3 =
			"(eligibilityDegreeMaster.eligibilityDegree IS NULL OR eligibilityDegreeMaster.eligibilityDegree LIKE '')";

	public EligibilityDegreeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"eligibilityDegreeMasterId", "eligibility_degree_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("eligibilityDegree", "eligibility_degree");

		setDBColumnNames(dbColumnNames);

		setModelClass(EligibilityDegreeMaster.class);

		setModelImplClass(EligibilityDegreeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(EligibilityDegreeMasterTable.INSTANCE);
	}

	/**
	 * Caches the eligibility degree master in the entity cache if it is enabled.
	 *
	 * @param eligibilityDegreeMaster the eligibility degree master
	 */
	@Override
	public void cacheResult(EligibilityDegreeMaster eligibilityDegreeMaster) {
		entityCache.putResult(
			EligibilityDegreeMasterImpl.class,
			eligibilityDegreeMaster.getPrimaryKey(), eligibilityDegreeMaster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				eligibilityDegreeMaster.getUuid(),
				eligibilityDegreeMaster.getGroupId()
			},
			eligibilityDegreeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the eligibility degree masters in the entity cache if it is enabled.
	 *
	 * @param eligibilityDegreeMasters the eligibility degree masters
	 */
	@Override
	public void cacheResult(
		List<EligibilityDegreeMaster> eligibilityDegreeMasters) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (eligibilityDegreeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EligibilityDegreeMaster eligibilityDegreeMaster :
				eligibilityDegreeMasters) {

			if (entityCache.getResult(
					EligibilityDegreeMasterImpl.class,
					eligibilityDegreeMaster.getPrimaryKey()) == null) {

				cacheResult(eligibilityDegreeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all eligibility degree masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EligibilityDegreeMasterImpl.class);

		finderCache.clearCache(EligibilityDegreeMasterImpl.class);
	}

	/**
	 * Clears the cache for the eligibility degree master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EligibilityDegreeMaster eligibilityDegreeMaster) {
		entityCache.removeResult(
			EligibilityDegreeMasterImpl.class, eligibilityDegreeMaster);
	}

	@Override
	public void clearCache(
		List<EligibilityDegreeMaster> eligibilityDegreeMasters) {

		for (EligibilityDegreeMaster eligibilityDegreeMaster :
				eligibilityDegreeMasters) {

			entityCache.removeResult(
				EligibilityDegreeMasterImpl.class, eligibilityDegreeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EligibilityDegreeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EligibilityDegreeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EligibilityDegreeMasterModelImpl eligibilityDegreeMasterModelImpl) {

		Object[] args = new Object[] {
			eligibilityDegreeMasterModelImpl.getUuid(),
			eligibilityDegreeMasterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, eligibilityDegreeMasterModelImpl);
	}

	/**
	 * Creates a new eligibility degree master with the primary key. Does not add the eligibility degree master to the database.
	 *
	 * @param eligibilityDegreeMasterId the primary key for the new eligibility degree master
	 * @return the new eligibility degree master
	 */
	@Override
	public EligibilityDegreeMaster create(long eligibilityDegreeMasterId) {
		EligibilityDegreeMaster eligibilityDegreeMaster =
			new EligibilityDegreeMasterImpl();

		eligibilityDegreeMaster.setNew(true);
		eligibilityDegreeMaster.setPrimaryKey(eligibilityDegreeMasterId);

		String uuid = _portalUUID.generate();

		eligibilityDegreeMaster.setUuid(uuid);

		eligibilityDegreeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return eligibilityDegreeMaster;
	}

	/**
	 * Removes the eligibility degree master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master that was removed
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public EligibilityDegreeMaster remove(long eligibilityDegreeMasterId)
		throws NoSuchEligibilityDegreeMasterException {

		return remove((Serializable)eligibilityDegreeMasterId);
	}

	/**
	 * Removes the eligibility degree master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the eligibility degree master
	 * @return the eligibility degree master that was removed
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public EligibilityDegreeMaster remove(Serializable primaryKey)
		throws NoSuchEligibilityDegreeMasterException {

		Session session = null;

		try {
			session = openSession();

			EligibilityDegreeMaster eligibilityDegreeMaster =
				(EligibilityDegreeMaster)session.get(
					EligibilityDegreeMasterImpl.class, primaryKey);

			if (eligibilityDegreeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEligibilityDegreeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(eligibilityDegreeMaster);
		}
		catch (NoSuchEligibilityDegreeMasterException noSuchEntityException) {
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
	protected EligibilityDegreeMaster removeImpl(
		EligibilityDegreeMaster eligibilityDegreeMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eligibilityDegreeMaster)) {
				eligibilityDegreeMaster = (EligibilityDegreeMaster)session.get(
					EligibilityDegreeMasterImpl.class,
					eligibilityDegreeMaster.getPrimaryKeyObj());
			}

			if (eligibilityDegreeMaster != null) {
				session.delete(eligibilityDegreeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (eligibilityDegreeMaster != null) {
			clearCache(eligibilityDegreeMaster);
		}

		return eligibilityDegreeMaster;
	}

	@Override
	public EligibilityDegreeMaster updateImpl(
		EligibilityDegreeMaster eligibilityDegreeMaster) {

		boolean isNew = eligibilityDegreeMaster.isNew();

		if (!(eligibilityDegreeMaster instanceof
				EligibilityDegreeMasterModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(eligibilityDegreeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					eligibilityDegreeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in eligibilityDegreeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EligibilityDegreeMaster implementation " +
					eligibilityDegreeMaster.getClass());
		}

		EligibilityDegreeMasterModelImpl eligibilityDegreeMasterModelImpl =
			(EligibilityDegreeMasterModelImpl)eligibilityDegreeMaster;

		if (Validator.isNull(eligibilityDegreeMaster.getUuid())) {
			String uuid = _portalUUID.generate();

			eligibilityDegreeMaster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (eligibilityDegreeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				eligibilityDegreeMaster.setCreateDate(date);
			}
			else {
				eligibilityDegreeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!eligibilityDegreeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				eligibilityDegreeMaster.setModifiedDate(date);
			}
			else {
				eligibilityDegreeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(eligibilityDegreeMaster);
			}
			else {
				eligibilityDegreeMaster =
					(EligibilityDegreeMaster)session.merge(
						eligibilityDegreeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EligibilityDegreeMasterImpl.class, eligibilityDegreeMasterModelImpl,
			false, true);

		cacheUniqueFindersCache(eligibilityDegreeMasterModelImpl);

		if (isNew) {
			eligibilityDegreeMaster.setNew(false);
		}

		eligibilityDegreeMaster.resetOriginalValues();

		return eligibilityDegreeMaster;
	}

	/**
	 * Returns the eligibility degree master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the eligibility degree master
	 * @return the eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEligibilityDegreeMasterException {

		EligibilityDegreeMaster eligibilityDegreeMaster = fetchByPrimaryKey(
			primaryKey);

		if (eligibilityDegreeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEligibilityDegreeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return eligibilityDegreeMaster;
	}

	/**
	 * Returns the eligibility degree master with the primary key or throws a <code>NoSuchEligibilityDegreeMasterException</code> if it could not be found.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master
	 * @throws NoSuchEligibilityDegreeMasterException if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public EligibilityDegreeMaster findByPrimaryKey(
			long eligibilityDegreeMasterId)
		throws NoSuchEligibilityDegreeMasterException {

		return findByPrimaryKey((Serializable)eligibilityDegreeMasterId);
	}

	/**
	 * Returns the eligibility degree master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master, or <code>null</code> if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public EligibilityDegreeMaster fetchByPrimaryKey(
		long eligibilityDegreeMasterId) {

		return fetchByPrimaryKey((Serializable)eligibilityDegreeMasterId);
	}

	/**
	 * Returns all the eligibility degree masters.
	 *
	 * @return the eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findAll(
		int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of eligibility degree masters
	 */
	@Override
	public List<EligibilityDegreeMaster> findAll(
		int start, int end,
		OrderByComparator<EligibilityDegreeMaster> orderByComparator,
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

		List<EligibilityDegreeMaster> list = null;

		if (useFinderCache) {
			list = (List<EligibilityDegreeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELIGIBILITYDEGREEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELIGIBILITYDEGREEMASTER;

				sql = sql.concat(
					EligibilityDegreeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EligibilityDegreeMaster>)QueryUtil.list(
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
	 * Removes all the eligibility degree masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EligibilityDegreeMaster eligibilityDegreeMaster : findAll()) {
			remove(eligibilityDegreeMaster);
		}
	}

	/**
	 * Returns the number of eligibility degree masters.
	 *
	 * @return the number of eligibility degree masters
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
					_SQL_COUNT_ELIGIBILITYDEGREEMASTER);

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
		return "eligibility_degree_master_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELIGIBILITYDEGREEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EligibilityDegreeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the eligibility degree master persistence.
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

		_finderPathWithPaginationFindByeligibilityDegreeByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByeligibilityDegreeByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"eligibility_degree"}, true);

		_finderPathWithPaginationCountByeligibilityDegreeByLike =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByeligibilityDegreeByLike",
				new String[] {String.class.getName()},
				new String[] {"eligibility_degree"}, false);

		_setEligibilityDegreeMasterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEligibilityDegreeMasterUtilPersistence(null);

		entityCache.removeCache(EligibilityDegreeMasterImpl.class.getName());
	}

	private void _setEligibilityDegreeMasterUtilPersistence(
		EligibilityDegreeMasterPersistence eligibilityDegreeMasterPersistence) {

		try {
			Field field = EligibilityDegreeMasterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, eligibilityDegreeMasterPersistence);
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

	private static final String _SQL_SELECT_ELIGIBILITYDEGREEMASTER =
		"SELECT eligibilityDegreeMaster FROM EligibilityDegreeMaster eligibilityDegreeMaster";

	private static final String _SQL_SELECT_ELIGIBILITYDEGREEMASTER_WHERE =
		"SELECT eligibilityDegreeMaster FROM EligibilityDegreeMaster eligibilityDegreeMaster WHERE ";

	private static final String _SQL_COUNT_ELIGIBILITYDEGREEMASTER =
		"SELECT COUNT(eligibilityDegreeMaster) FROM EligibilityDegreeMaster eligibilityDegreeMaster";

	private static final String _SQL_COUNT_ELIGIBILITYDEGREEMASTER_WHERE =
		"SELECT COUNT(eligibilityDegreeMaster) FROM EligibilityDegreeMaster eligibilityDegreeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"eligibilityDegreeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EligibilityDegreeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EligibilityDegreeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EligibilityDegreeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "eligibilityDegreeMasterId", "groupId", "companyId",
			"createDate", "modifiedDate", "createdBy", "modifiedBy",
			"eligibilityDegree"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}